package Fernando;

import java.util.LinkedList;

import lib20.Datos;

public class CopiladorLR
{

	private Datos obd  = new Datos();
	
	private String[] 
		terminales = new String[] {"num","id","int","float","char",",",";","+","-","*","/","(",")","="},
		noterminales = new String[] {"P","Tipo","V","A","E","T","F"},
		Tipos = new String[] {"int","float","char"},
		
		columnas = new String[] {"num","id","int","float","char",",",";","+","-","*","/","(",")","=","$","P","Tipo","V","A","E","T","F"},
		estados = new String[] {"I00","I01","I02","I03","I04","I05","I06","I07","I08","I09","I10","I11","I12","I13","I14","I15","I16",
									"I17","I18","I19","I20","I21","I22","I23","I24","I25","I26","I27","I28","I29","I30","I31","I32"},
		producciones = new String[] {"Q","P","P","V","V","A","E","E","E","T","T","T","F","F","F","Tipo","Tipo","Tipo"};
	private int[] 
		prodTam = new int [] {1,3,1,3,2,4,3,3,1,3,3,1,3,1,1,1,1,1};
	
		
		
	
	private String[][]
		tablaSint =  new String[][] 
		{//		num		id		int		float		char		,		;		+		-		*		/		(		)		=		$		P		Tipo		V		A		E		T		F
		/*I00*/	{"",	"I07",	"I04",	"I05",		"I06",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"I01",	"I02",		"",		"I03",	"",		"",		""},
		/*I01*/	{"",	"",		"",		"",			"",			"",		"",		"",		"",		"",		"",		"",		"",		"",		"P0",	"",		"",			"",		"",		"",		"",		""},
		/*I02*/	{"",	"I08",	"",		"",			"",			"",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"",			"",		"",		"",		"",		""},
		/*I03*/	{"",	"",		"",		"", 		"",			"",		"",		"",		"",		"",		"",		"",		"",		"",		"P2",	"",		"",			"",		"",		"",		"",		""},
		/*I04*/	{"",	"P15",	"",		"",			"",			"",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"",			"",		"",		"",		"",		""},
		/*I05*/	{"",	"P16",	"",		"",			"",			"",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"",			"",		"",		"",		"",		""},
		/*I06*/	{"",	"P17",	"",		"",			"",			"",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"",			"",		"",		"",		"",		""},
		/*I07*/	{"",	"",		"",		"",			"",			"",		"",		"",		"",		"",		"",		"",		"",		"I09",	"",		"",		"",			"",		"",		"",		"",		""},
		/*I08*/	{"",	"",		"",		"",			"",			"I11",	"I12",	"",		"",		"",		"",		"",		"",		"",		"",		"",		"",			"I10",	"",		"",		"",		""},
		/*I09*/	{"I18",	"I17",	"",		"",			"",			"",		"",		"",		"",		"",		"",		"I16",	"",		"",		"",		"",		"",			"",		"",		"I13",	"I14",	"I15"},
		/*I10*/	{"",	"",		"",		"",			"",			"",		"",		"",		"",		"",		"",		"",		"",		"",		"P1",	"",		"",			"",		"",		"",		"",		""},
		/*I11*/	{"",	"I19",	"",		"",			"",			"",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"",			"",		"",		"",		"",		""},
		/*I12*/	{"",	"I07",	"I04",	"I05",		"I06",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"",		"I20",	"I02",		"",		"I03",	"",		"",		""},
		/*I13*/	{"",	"",		"",		"",			"",			"",		"I21",	"I22",	"I23",	"",		"",		"",		"",		"",		"",		"",		"",			"",		"",		"",		"",		""},
		/*I14*/	{"",	"",		"",		"",			"",			"",		"P8",	"P8",	"P8",	"I24",	"I25",	"",		"P8",	"",		"",		"",		"",			"",		"",		"",		"",		""},
		/*I15*/	{"",	"",		"",		"",			"",			"",		"P11",	"P11",	"P11",	"P11",	"P11",	"",		"P11",	"",		"",		"",		"",			"",		"",		"",		"",		""},
		/*I16*/	{"I18",	"I17",	"",		"",		 	"",			"",		"",		"",		"",		"",		"",		"I16",	"",		"",		"",		"",		"",			"",		"",		"I26",	"I14",	"I15"},
		/*I17*/	{"",	"",		"",		"",			"",			"",		"P13",	"P13",	"P13",	"P13",	"P13",	"",		"P13",	"",		"",		"",		"",			"",		"",		"",		"",		""},
		/*I18*/	{"",	"",		"",		"",			"",			"",		"P14",	"P14",	"P14",	"P14",	"P14",	"",		"P14",	"",		"",		"",		"",			"",		"",		"",		"",		""},
		/*I19*/	{"",	"",		"",		"",			"",			"I11",	"I12",	"",		"",		"",		"",		"",		"",		"",		"",		"",		"",			"I27",	"",		"",		"",		""},
		/*I20*/	{"",	"",		"",		"",			"",			"",		"",		"",		"",		"",		"",		"",		"",		"",		"P4",	"",		"",			"",		"",		"",		"",		""},
		/*I21*/	{"",	"",		"",		"",			"",			"",		"",		"",		"",		"",		"",		"",		"",		"",		"P5",	"",		"",			"",		"",		"",		"",		""},
		/*I22*/	{"I18",	"I17",	"",		"",			"",			"",		"",		"",		"",		"",		"",		"I16",	"",		"",		"",		"",		"",			"",		"",		"",		"I28",	"I15"},
		/*I23*/	{"I18",	"I17",	"",		"",			"",			"",		"",		"",		"",		"",		"",		"I16",	"",		"",		"",		"",		"",			"",		"",		"",		"I29",	"I15"},
		/*I24*/	{"I18",	"I17",	"",		"",			"",			"",		"",		"",		"",		"",		"",		"I16",	"",		"",		"",		"",		"",			"",		"",		"",		"",		"I30"},
		/*I25*/	{"I18",	"I17",	"",		"",			"",			"",		"",		"",		"",		"",		"",		"I16",	"",		"",		"",		"",		"",			"",		"",		"",		"",		"I31"},
		/*I26*/	{"",	"",		"",		"",			"",			"",		"",		"I22",	"I23",	"",		"",		"",		"I32",	"",		"",		"",		"",			"",		"",		"",		"",		""},
		/*I27*/	{"",	"",		"",		"",			"",			"",		"",		"",		"",		"",		"",		"",		"",		"",		"P3",	"",		"",			"",		"",		"",		"",		""},
		/*I28*/	{"",	"",		"",		"",			"",			"",		"P6",	"P6",	"P6",	"I24",	"I25",	"",		"P6",	"",		"",		"",		"",			"",		"",		"",		"",		""},
		/*I29*/	{"",	"",		"",		"",			"",			"",		"P7",	"P7",	"P7",	"I24",	"I25",	"",		"P7",	"",		"",		"",		"",			"",		"",		"",		"",		""},
		/*I30*/	{"",	"",		"",		"",			"",			"",		"P9",	"P9",	"P9",	"P9",	"P9",	"",		"P9",	"",		"",		"",		"",			"",		"",		"",		"",		""},
		/*I31*/	{"",	"",		"",		"",			"",			"",		"P10",	"P10",	"P10",	"P10",	"P10",	"",		"P10",	"",		"",		"",		"",			"",		"",		"",		"",		""},
		/*I32*/	{"",	"",		"",		"",			"",			"",		"P12",	"P12",	"P12",	"P12",	"P12",	"",		"P12",	"",		"",		"",		"",			"",		"",		"",		"",		""},
		
		}; 
		
	
	private String 
		expId=("[a-z]([a-z]|[A-Z])*[0-9]*"),
		expNum=("-?[1-9][0-9]*(.[0-9]*[1-9])?");
	
	private LinkedList<String> entrada = new LinkedList<String>();
	private LinkedList<String> pilaT = new LinkedList<String>();
	private LinkedList<String> IDS = new LinkedList<String>();
	private LinkedList<String> TiposIDS = new LinkedList<String>();
	
	private void Error(int pos)
	{	
		obd.Println(pos+"");
		for(int x=0;x<entrada.size()-1;x++)
		{
			if(x==pos)
				obd.Print("??"+entrada.get(x)+"?? ");
			else
				obd.Print(entrada.get(x)+" ");
		}
		if(entrada.get(pos)=="null0")
		{
			obd.Println("La variable no ha sido declarada");
		}
		else
		{
			obd.Println(entrada.get(pos)=="$"?"Se debe continuar la expresion":"Error en el elemento \t ??"+entrada.get(pos)+"??");
			obd.Print("Valores posibles aceptados: \t");
			int rango = Integer.parseInt(pilaT.getLast().substring(1)),y;
			for(int x=0;x<tablaSint[rango].length;x++)
			{
				if(!tablaSint[rango][x].isBlank())
				{
					for(y=0;y<noterminales.length && !noterminales[y].equals(columnas[x]) ;y++);
					if(y<noterminales.length)
					{
						obd.Print("Siguientes "+columnas[x]);
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
		int ejex,ejey,x,y,z,rango,pos=0;
		while(!pila.getFirst().equals("Q"))
		{
			for(x=0;x<estados.length && !pilaT.getLast().equals(estados[x]) ;x++);
			for(y=0;y<columnas.length && !pila.getFirst().equals(columnas[y]) ;y++);
			//obd.Println(x+"//"+y);
			
			if(x<estados.length && y<columnas.length)
			{
				obd.Println("///////////////////////////////////");
				this.mostrarPilas(pilaT);
					if(!tablaSint[x][y].isBlank())
					{
						if(tablaSint[x][y].charAt(0)=='I')
						{
							pilaT.add(tablaSint[x][y]);
							pos++;
							pila.removeFirst(); 
						}
						else
							if(tablaSint[x][y].charAt(0)=='P')
							{
								pos--;
								rango = Integer.parseInt(tablaSint[x][y].substring(1));
								for(z=0;z<prodTam[rango];z++)
									pilaT.removeLast();
								if(tablaSint[x][y].equals("P0"))
								{
									obd.Println("CADENA ACEPTADA");
									//this.mostrarPilas(entrada);
									break;
								}
								pila.addFirst(producciones[rango]);
							}
					}
					else
					{
						obd.Println("Tronar");//futuramente guardar la posicion
						this.Error(pos);
						break;
					}
				
			}
			else
			{
				obd.Println("Error en los rangos");
				this.Error(pos);
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
						IDS.add(pila.get(y));
						TiposIDS.add(temp);
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
		//this.mostrarPilas(pilatrans);
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
		//this.mostrarPilas(LisTemp);
		return LisTemp;
			
	}
	
	public void mostrarPilas(LinkedList<String> pila)
	{
		obd.Println("Mostrar");
		for(int x = 0; x<pila.size();x++)
			obd.Println(pila.get(x));
	}
	
	
	
	public static void main(String[] args)
	{
		CopiladorLR obc = new CopiladorLR();
		obc.Accion(obc.Entrada(obc.Separar("int id0 , id1 ; float id2 ; char id3 , id4 ; id4 = 12 ;")));
	}
}
