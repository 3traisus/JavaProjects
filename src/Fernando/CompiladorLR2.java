package Fernando;

import java.util.LinkedList;

import Fernando.Copilador.CodigoIntermedio;
import lib20.Datos;

public class CompiladorLR2
{

	private Datos obd  = new Datos();
	private ValidacionAsigna val = new ValidacionAsigna();
	private CodigoIntermedio inter = new CodigoIntermedio();
	
	private String[] 
		operadores = new String[] {"+","-","*","/","=","(",")"},
		terminales = new String[] {"id","int","float","char",",",";","+","-","*","/","(",")","=","num"},
		noterminales = new String[] {"P","Tipo","V","A","EXP","E","TERM","T","F"},
		Tipos = new String[] {"int","float","char"},
		
		columnas = new String[] {"id","int","float","char",",",";","+","-","*","/","(",")","num","=","$","P","Tipo","V","A","EXP","E","TERM","T","F"},
		estados = new String[] {"I00","I01","I02","I03","I04","I05","I06","I07","I08","I09","I10","I11","I12","I13","I14","I15","I16","I17","I18","I19"	
												,"I20","I21","I22","I23","I24","I25","I26","I27","I28","I29","I30","I31","I32","I33","I34","I35","I36","I37","I38"},
		producciones = new String[] {"Q","P","P","Tipo","Tipo","Tipo","V","V","A","EXP","E","E","E","TERM","T","T","T","F","F","F"};
	private int[] 
		prodTam = new int [] {1,3,1,1,1,1,3,2,4,2,3,3,0,2,3,3,0,1,3,1};
	
		
		
	
	private String[][]
		tablaSint =  new String[][] 
		{//		id	    int		 float	char	 	,			 ;		+		-		*		 /		(	     )		num	  	=   	$		P		Tipo		V		   A	EXP   	E		TERM  	T		F
		/*I00*/	{"I07",	"I04",	"I05",	"I06",		"",			"",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"I01",	"I02",		"",		"I03",	"",		 "",	 "",    "",    "" },
		/*I01*/	{"",	"",		"",		"",			"",			"",		"",		"",		"",		"",		"",		"",		"",		"",		"P0",	"",		"",			"",		"",		"",		"",		"",		"",		""},
		/*I02*/	{"I08",	"", 	"",		"",			"",			"",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"",			"",		"",		"",		"",		"",		"",		""},
		/*I03*/	{"",	"",		"",		"",			"",			"",		"",		"",		"",		"",		"",		"",		"",		"",		"P2",	"",		"",			"",		"",		"",		"",		"",		"",		""},
		/*I04*/	{"P3",	"", 	"",		"",			"",			"",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"",			"",		"",		"",		"",		"",		"",		""},
		/*I05*/	{"P4",	"",	 	"",		"",			"",			"",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"",			"",		"",		"",		"",		"",		"",		""},
		/*I06*/	{"P5",	"",	  	"",		"",			"",			"",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"",			"",		"",		"",		"",		"",		"",		""},
		/*I07*/	{"",	"",		"",		"",			"",			"",		"",		"",		"",		"",		"",		"",		"",		"I09",	"",		"",		"",			"",		"",		"",		"",		"",		"",		""},
		/*I08*/	{"",	"",		"",		"",			"I11",	 "I12",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"",			"I10",	"",		"",		"",		"",		"",		""},
		/*I09*/	{"I16",	 "",	"",		"",			"",			"",		"",		"",		"",		"",		"I17",	"",	  "I18",	"",		"",		"",		"",			"",		"",		"I13",	"",  "I14", 	"", "I15"},
		/*I10*/	{"",	"",		"",		"",			"",			"",		"",		"",		"",		"",		"",		"",		"",		"",		"P1",	"",		"",			"",		"",		"",		"",		"",		"",		""},
		/*I11*/	{"I19",	"",		"",		"",			"",			"",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"",			"",		"",		"",		"",		"",		"",		""},
		/*I12*/	{"I07",	"I04",	"I05",	"I06",		"",			"",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"I20",	"I02",		"",		"I03",	"",		"",		"",		"",		""},
		/*I13*/	{"",	"",		"",		"",			"",			"I21",	"",	   	"",	  	"",  	 "",	"",		"",		"",		"",		"",		"",		"",			"",		"",		"",		"",		"",		"",		""},
		/*I14*/	{"",	"",		"",		"",			"",			"P12",	"I23",	"I24",	"", 	"",	 	"",		"P12",	"",		"",		"",		"",		"",			"",		"",		"",		"I22",	"",		"",		""},
		/*I15*/	{"",	"",		"",		"",			"",			"P16",	"P16",	"P16",	"I26",	"I27",	"",		"P16",	"",		"",		"",		"",		"",			"",		"",		"",		"",		"",		"I25",	""},
		/*I16*/	{"",	"",		"",		"",			"",			"P17",	"P17",	"P17",	"P17",	"P17",	"",		"P17",	"",		"",		"",		"",		"",			"",		"",		"I26",	"I14",	"I15",	"",		""},
		/*I17*/	{"I16",	"",		"",		"",			"",			"",		"",		"",		"",		"",		"I17",	"",		"I18",	"",		"",		"",		"",			"",		"",		"I28",	"",		"I14",	"",		"I15"},
		/*I18*/	{"",	"",		"",		"",			"",			"P19",	"P19",	"P19",	"P19",	"P19",	"",		"P19",	"",		"",		"",		"",		"",			"",		"",		"",		"",		"",		"",		""},
		/*I19*/	{"",	"",		"",		"",			"I11",		"I12",	"",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"",			"I29",	"",		"",		"",		"",		"",		""},
		/*I20*/	{"",	"",		"",		"",			"",			"",		"",		"",		"",		"",		"",		"",		"",		"",		"P7",	"",		"",			"",		"",		"",		"",		"",		"",		""},
		/*I21*/	{"",	"",		"",		"",			"",			"",		"",		"",		"",		"",		"",		"",		"",		"",		"P8",	"",		"",			"",		"",		"",		"",		"",		"",		""},
		/*I22*/	{"",	"",		"",		"",			"",			"P9",	"",		"",		"",		"",		"",		"P9",	"",		"",		"",		"",		"",			"",		"",		"",		"",		"",		"",		""},
		/*I23*/	{"I16",	"",		"",		"",			"",			"",		"",		"",		"",		"",		"I17",	"",		"I18",	"",		"",		"",		"",			"",		"",		"",		"",		"I30",	"",		"I15"},
		/*I24*/	{"I16",	"",		"",		"",			"",			"",		"",		"",		"",		"",		"I17",	"",		"I18",	"",		"",		"",		"",			"",		"",		"",		"",		"I31",	"",		"I15"},
		/*I25*/	{"",	"",		"",		"",			"",			"P13",	"P13",	"P13",	"",		"",		"",		"P13",	"",		"",		"",		"",		"",			"",		"",		"",		"",		"",		"",		""},
		/*I26*/	{"I16",	"",		"",		"",			"",			"",		"",		"",		"",		"",		"I17",	"",		"I18", 	"",		"",		"",		"",			"",		"",		"",		"",		"",		"",		"I32"},
		/*I27*/	{"I16",	"",		"",		"",			"",			"",		"",		"",		"",		"",		"I17",	"",		"I18",	"",		"",		"",		"",			"",		"",		"",		"",		"",		"",		"I33"},
		/*I28*/	{"",	"",		"",		"",			"",			"",		"",		"",		"",		"",		"",		"I34",	"",		"",		"",		"",		"",			"",		"",		"",		"",		"",		"",		""},
		/*I29*/	{"",	"",		"",		"",			"",			"",		"",		"",		"",		"",		"",		"",		"",		"",		"P6",	"",		"",			"",		"",		"",		"",		"",		"",		""},
		/*I30*/	{"",	"",		"",		"",			"",			"P12",	"I23",	"I24",	"",		"",		"",		"P12",	"",		"",		"",		"",		"",			"",		"",		"",		"I35",	"",		"",		""},
		/*I31*/	{"",	"",		"",		"",			"",			"P12",	"I23",	"I24",	"",		"",		"",		"P12",	"",		"",		"",		"",		"",			"",		"",		"",		"I36",	"",		"",		""},
		/*I32*/	{"",	"",		"",		"",			"",			"P16",	"P16",	"P16",	"I26",	"I27",	"",		"P16",	"",		"",		"",		"",		"",			"",		"",		"",		"",		"",		"I37",	""},
		/*I33*/	{"",	"",		"",		"",			"",			"P16",	"P16",	"P16",	"I26",	"I27",	"",		"P16",	"",		"",		"",		"",		"",			"",		"",		"",		"",		"",		"I38",	""},
		/*I34*/	{"",	"",		"",		"",			"",			"P18",	"P18",	"P18",	"P18",	"P18",	"",		"P18",	"",		"",		"",		"",		"",			"",		"",		"",		"",		"",		"",		""},
		/*I35*/	{"",	"",		"",		"",			"",			"P10",	"",		"",		"",		"",		"",		"P10",	"",		"",		"",		"",		"",			"",		"",		"",		"",		"",		"",		""},
		/*I36*/	{"",	"",		"",		"",			"",			"P11",	"",		"",		"",		"",		"",		"P11",	"",		"",		"",		"",		"",			"",		"",		"",		"",		"",		"",		""},
		/*I37*/	{"",	"",		"",		"",			"",			"P14",	"P14",	"P14",	"",		"",		"",		"P14",	"",		"",		"",		"",		"",			"",		"",		"",		"",		"",		"",		""},
		/*I38*/	{"",	"",		"",		"",			"",			"P15",	"P15",	"P15",	"",		"",		"",		"P15",	"",		"",		"",		"",		"",			"",		"",		"",		"",		"",		"",		""},
		
		}; 
		
	
	private String 
		expId=("[a-z]([a-z]|[A-Z])*[0-9]*"),
		expNum=("-?[0-9][0-9]*(.[0-9]*[1-9])?"),
				numEnt=("-?[0-9][0-9]*"),
				numFloat=("-?[0-9][0-9]*(.[0-9]*[1-9])");
	
	private LinkedList<String> entraUser = new LinkedList<String>();
	private LinkedList<String> entrada = new LinkedList<String>();
	private LinkedList<String> pilaT = new LinkedList<String>();
	private LinkedList<String> IDS = new LinkedList<String>();
	private LinkedList<String> TiposIDS = new LinkedList<String>();
	
	private void Error(int pos,String cad)
	{	
		//obd.Println(pos+"posError");
		for(int x=0;x<entrada.size()-1;x++)
		{
			if(x==pos)
				obd.Print("??"+entraUser.get(x)+"??");
			else
				obd.Print(entraUser.get(x)+" ");
		}
		if(entrada.get(pos)=="null0")
		{
			obd.Println("La variable no ha sido declarada");
			
		}else
			if(entrada.get(pos)=="null1")
			{
				obd.Println("La variable se repite");
				
			}
			else
				if(!cad.isBlank())
				{
					obd.Println("La asignacion fue Erronea");
				}
				else
				{
					obd.Println(entrada.get(pos)=="$"?"Se debe continuar la expresion":"Error en el elemento \t ??"+entraUser.get(pos)+"??");
					obd.Print("Valores posibles aceptados: \t");
					int rango = Integer.parseInt(pilaT.getLast().substring(1)),y;
					for(int x=0;x<tablaSint[rango].length;x++)
					{
						if(!tablaSint[rango][x].isBlank())
						{
							for(y=0;y<noterminales.length && !noterminales[y].equals(columnas[x]) ;y++);
							if(y<noterminales.length)
							{
								//obd.Print("Siguientes "+columnas[x]);
							}
							else
								obd.Print(columnas[x]);
							obd.Print("\\");
						}
					}
				}
		
	}
	
	public void Accion (LinkedList<String> pila)
	{
		pilaT.add("$");
		pilaT.add("I00");
		int x,y,z,rango,pos=0,ind,contador=0;
		String temp="";
		boolean ban=false;
		//////////////////////////////////////////////////////////////////////////
		while(!pila.getFirst().equals("Q"))
		{
			for(x=0;x<estados.length && !pilaT.getLast().equals(estados[x]) ;x++);
			for(y=0;y<columnas.length && !pila.getFirst().equals(columnas[y]) ;y++);
			//obd.Println(x+"//"+y);
			
			if(x<estados.length && y<columnas.length)
			{
				obd.Println(pilaT.getLast()+"/"+pila.getFirst());
				
				if((pilaT.getLast().equals("I18") && pila.getFirst().equals(";"))
						|| (pilaT.getLast().equals("I34") && pila.getFirst().equals(";")))
				{
					ban=val.Analizar();
					if(ban)
					{
						this.Error(pos,"Error en la asignacion");
						break;
					}else
					{
						obd.Println("la asignacion fue exitosa");
						val.Orden();
						inter.Nuevos(val.OrdenAsig());
						
						
					}
				}
				
				if((pilaT.getLast()=="I12" && pila.getFirst().equals("id") || ban))
				{
					ban=true;
					obd.Println("Asignando");
					for(ind=0;ind<operadores.length && !operadores[ind].equals(pila.getFirst());ind++);
					if(ind<operadores.length)
					{
						if(!temp.equals(pila.getFirst()))
						{
							val.Nuevo(pila.getFirst());//mandarlo igual 
							temp = pila.getFirst();
						}
						
					}
					else	
					{
						if(pila.getFirst().equals("id"))
						{
							for(ind=0;ind<IDS.size() && !IDS.get(ind).equals(entraUser.get(pos));ind++);
							if(ind<IDS.size())
							{
								val.Nuevo(Tipos[Integer.parseInt(TiposIDS.get(ind))]);//mandar su tipo de dato
								//val.Nuevo(entraUser.get(pos));
								//futuramente imprimir su valor 
								temp = "";
							}
						}
						else
							if(pila.getFirst().equals("num"))
							{
								/*if(entraUser.get(pos).matches(numEnt))//mandar su tipo de dato
								{
									val.Nuevo("0");
								}
								else
									val.Nuevo("1");*/
								val.Nuevo(entraUser.get(pos));
								temp = "";
							}
					}
						
					//obd.Println(entraUser.get(pos)+"----->");
				}
					
				System.out.print("///////////////////////////////////");
				this.mostrarPilas(pilaT);
				if(!tablaSint[x][y].isBlank())
				{
					if(tablaSint[x][y].charAt(0)=='I')
					{
						pilaT.add(tablaSint[x][y]);
						pos++;
						if(pila.getFirst().equals(entrada.get(contador)))//empezamos aqui 
						{
							if(!ban)
							{
								inter.Nuevo(entraUser.get(contador));
							}
							contador++;
						}
						pila.removeFirst();
						
					}
					else
						if(tablaSint[x][y].charAt(0)=='P')
						{
							pos--;
							rango = Integer.parseInt(tablaSint[x][y].substring(1));
							//obd.Println(rango+"");
							for(z=0;z<prodTam[rango];z++)
								pilaT.removeLast();
							if(tablaSint[x][y].equals("P0"))
							{
								System.out.println("CADENA ACEPTADA");
								this.mostrarPilas(inter.Elementos());
								//val.mostrarPilas();
								//this.mostrarPilas(entrada);
								break;
							}
							pila.addFirst(producciones[rango]);
						}
				}
				else
				{
					//System.out.println("Tronar");//futuramente guardar la posicion
					//obd.Println(pilaT.getLast()+"/"+pila.getFirst());
					this.Error(pos,"");
					break;
				}
				
			}
			else
			{
				this.Error(pos,"");
				break;
			}	
			//pilaT.add(tablaSint[1][0]);
		}
	}
	
	
	public LinkedList<String> Entrada(LinkedList<String> pila)
	{
		String temp="";
		int x;
		LinkedList<String> pilatrans = new LinkedList<String>();
		/////////////////////////////////////////////////////////////////////	
		for(int y=0; y<pila.size(); y++)
		{
			//obd.Println(pila.get(y));
			for(x=0;x<terminales.length && !terminales[x].equals(pila.get(y)) ;x++);
			if(x<terminales.length)
			{
				if(pila.get(y).equals(";"))
					temp = "";
				for(x=0;x<Tipos.length && !Tipos[x].equals(pila.get(y)) ;x++);
					if(x<Tipos.length)
						temp = pila.get(y);
				pilatrans.add(pila.get(y));
			}
			else
				if(pila.get(y).matches(expId))
				{
					pilatrans.add("id");
					if(temp!="")
					{						
						if(IDS.contains(pila.get(y)))
						{
							pilatrans.removeLast();
							pilatrans.add("null1");
						}else
						{
							IDS.add(pila.get(y));
							for(x=0;x<Tipos.length && !Tipos[x].equals(temp);x++);
							if(x<Tipos.length)
								TiposIDS.add(x+"");
						}
					}
					else
					{
						if(!IDS.contains(pila.get(y)))
						{
							pilatrans.removeLast();
							pilatrans.add("null0");
						}
					}
				}
				else
					if(pila.get(y).matches(expNum))
						pilatrans.add("num");
					else
						pilatrans.add("null");
		}
		pilatrans.add("$");
		this.mostrarPilas(pilatrans);
		//this.mostrarPilas(IDS);
		//this.mostrarPilas(TiposIDS);
		entrada.addAll(pilatrans);
		return pilatrans;
	}
	
	public LinkedList<String> Separar(String txt)
	{
		txt+=" ";
		LinkedList<String> LisTemp = new LinkedList<String>();
		int temp;
		for(int x=0;x<txt.length();x++)
		{
			temp = txt.indexOf(" ",x);
			//obd.Println(temp+"");
			if(temp!=-1)
				if(!txt.substring(x,temp).isBlank())
					 LisTemp.add(txt.substring(x,x=temp));
		}
		entraUser.addAll(LisTemp);
		return LisTemp;
			
	}
	
	public void mostrarPilas(LinkedList<String> pila)
	{
		System.out.println("Mostrar");
		for(int x = 0; x<pila.size();x++)
			System.out.println(pila.get(x));
	}
	
	
	
	public static void main(String[] args)
	{
		CompiladorLR2 obc = new CompiladorLR2();
		obc.Accion(obc.Entrada(obc.Separar("char b ; float c ;  c = ( 3 + 5 ) / 2 ;")));

	}

}
