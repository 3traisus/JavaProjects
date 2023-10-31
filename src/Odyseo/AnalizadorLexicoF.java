package Odyseo;

import java.util.LinkedList;
import lib20.Datos;

public class AnalizadorLexicoF
{
	private Datos obd = new Datos();
	public String cad,cad2;
	
	private LinkedList<String> lista = new LinkedList<String>();
	private LinkedList<String> listCad = new LinkedList<String>();
	private String valoresCol[] = { "-", "+", "*", "/","ID","NUM","$","(",")","TRUE","FALSE",">","<",">=","<=","==","!=","¿","&&","||","LITCAD","LITCHAR"},
			valoresReb[] = {"L","L1","R","R1","EXP","T","EXP1","F","T1"},lenguaje[]= {"IF(","ELSE","INT","FLOAT"};
	private String matriz[][] = {
			{"#","#","#","#","R L1","R L1 ","#","R L1","#","R L1 ","R L1 ","#","#","#","#","#","#","R L1","R L1","R L1","R L1","R L1"},//lOGICOS
			{"#","#","#","#"," "," "," "," "," "," "," ","#","#","#","#","#","#"," ","&& R L1","|| R L1","",""},//lOGICOS
			
			{"#","#","#","#","EXP R1","EXP R1","#","EXP R1","#","EXP R1","EXP R1","#","#","#","#","#","#","EXP R1","#","#","EXP R1","EXP R1"},//OPERADORES RELACIONALES
			{"#","#","#","#"," "," "," "," "," "," "," ","> EXP R1","< EXP R1",">= EXP R1","<= EXP R1","== EXP R1","!= EXP R1","#"," "," ","EXP R1","EXP R1"},//OPERADORES RELACIONALES 1
	 
			{"#","#","#","#","T EXP1","T EXP1","#","T EXP1","!","T EXP1","T EXP1","#","#","#","#","#","#","T EXP1","#","#","T EXP1","T EXP1"},//EXP
			{"#","#","#","#","F T1","F T1","#","F T1","#","F T1","F T1","#","#","#","#","#","#","F T1","#","#","F T1","F T1"},//T
			{"- T EXP1","+ T EXP1"," "," ","#","#"," ","#"," "," "," "," "," "," "," "," "," ","#"," "," ","#","#"},//EXP1
			{"#","#","#","#","ID","NUM"," ","( L )"," ","TRUE","FALSE","#","#","#","#","#","#","¿","#","#","LITCAD","LITCHAR"},//F
			{" "," ","* F T1","/ F T1","F T1","","","F T1"," ","F T1"," "," "," "," "," "," "," ","F T1"," "," ","#","#"}//T1
		};
	//"/","","","",""
	
	private String valoresCol2[] = { "ID", "{", "}", "INT","FLOAT","IF(","ELSE","$",",","=","LITCAD","LITCHAR"},
			valoresReb2[] = {"SENT}","SENT1","DEC","ASIG","OTRO","BLOQ","RESTIF"};
	private String matriz2[][] = {
			{"SENT1 SENT}","#","","SENT1 SENT}","#","SENT1 SENT}","#","","#","#","LITCAD","LITCHAR"},//SENTENCIA
			{"ASIG","#","","DEC","DEC","IF( L ) BLOQ RESTIF","#","","#","#","",""},//SENTENCIAS
			
			{"#","#","#","INT ID OTRO ; DEC","FLOAT ID OTRO ; DEC","#","#","","#","#","",""},//DEC
			{"ID = L","#","#","#","#","#","#","","#","","#","#","",""},//ASIG
			
			{"#","#","","#","#","#","#","",", ID OTRO","= L OTRO","",""},//OTRO
			{"#","{ SENT}"," ","#","#","{ SENT}","#","","#","#","",""},//BLOQUE
			
			{"#","#","}","#","#","#","ELSE BLOQ","#","#","#","",""}//RESTIF
		};
	
	
	private String expId=("[a-z]([a-z]|[A-Z])*[0-9]*"),
			expNum=("[1-9][0-9]*(.[0-9]*[1-9])?"),
			expChar=("[/*+()-{}]"),
			expOpeRel=(">=|<=|==|!=|>|<"),
			expLog=("¿|&&|\\|\\|"),
			expLITCAD=("[~]([a-z]|[A-Z])([a-z]|[A-Z])*[~]"),
			expLITCHAR=("[']([A-Z]|[a-z])[']"),
			expBolean1="FALSE",expBolean2="TRUE";
	
	public boolean  Validad2()
	{
		cad2="";
		int x=0,y=0;
		String temp,temp2;
		lista.clear();
		lista.add("$");
		lista.addLast("SENT}");
		
		while(!lista.isEmpty())
		{
			if(lista.getLast().equals("L"))
				this.Validad();
			if(!listCad.isEmpty())
			{
				obd.Print(temp2=listCad.getFirst()); 
				obd.Print("))->");	
			}
			else
				temp2="$";
			
	
			for(x=0;x<valoresReb2.length && !valoresReb2[x].contains(lista.getLast()!="$"?lista.getLast():"SENT1");x++);
			for(y=0;y<valoresCol2.length && !valoresCol2[y].contains(temp2);y++);
			if(x>=valoresReb2.length || y>=valoresCol2.length)
			{
				obd.Println("Trono2");
				break;
			}
				
			
			temp=matriz2[x][y];
			for(int z=0;z<lista.size();z++)
				obd.Print(lista.get(z)+"-");
			//obd.Println("");
			obd.Println("("+temp+")");
			
			if(temp!="#")
			{
				lista.removeLast();
				lista.addAll(this.Invertir(this.Separar(temp)));
				if(temp2!="$")
					if(lista.getLast().equals(temp2))
					{
						obd.Println("ELIMINADO");
						cad2 +=listCad.removeFirst();
						lista.removeLast();
					}
			}
			else
				break;
		}
		if(lista.isEmpty())
		{
			obd.Println("Cadena aceptada");	
			return true;
		}
		else
		{
			obd.Println("Cadena no aceptada");
			return false;
		}
	}
	
	private void  Validad()
	{
		obd.Println("Hola perro");
		int x=0,y=0,z=0;
		String temp,temp2;
		
		while(!lista.isEmpty())
		{
			if(!listCad.isEmpty())
			{
				obd.Print(temp2=listCad.getFirst()); 
				obd.Print("))->");
			}
			else
				temp2="$";
			obd.Println("Elementos finales/"+lista.getLast());
			for(z=0;z<valoresReb2.length && !valoresReb2[z].contains(temp2);z++);
			if(z<valoresReb2.length)
				break;
			//obd.Println("Elementos finales/"+lista.getLast()+"/"+listCad.getFirst());
			for(x=0;x<valoresReb.length && !valoresReb[x].contains(lista.getLast()!="$"?lista.getLast():"EXP1");x++);
			for(y=0;y<valoresCol.length && !valoresCol[y].contains(temp2);y++);
			if(x>=valoresReb.length || y>=valoresCol.length)
			{
				obd.Println("Trono1");
				break;
			}
			temp=matriz[x][y];
			for(z=0;z<lista.size();z++)
				obd.Print(lista.get(z)+"-");
			//obd.Println("");
			obd.Println("("+temp+")");
			
			if(temp!="#")
			{
				lista.removeLast();
				lista.addAll(this.Invertir(this.Separar(temp)));
				if(temp2!="$")
					if(lista.getLast().equals(temp2))
					{
						obd.Println("ELIMINADO");
						cad2 +=listCad.removeFirst();
						lista.removeLast();
					}
			}
			else
				break;
		}
	}

	
	public void Lectura(String cad)
	{
		this.cad=cad;
		listCad = this.Transformar(this.Separar(this.cad));
	}
	
	private LinkedList<String> Transformar(LinkedList<String> trans)
	{
		int x,l;
		boolean ban=true;
		for(String T:trans)
			obd.Println(T);
		LinkedList<String> lisTrans = new LinkedList<String>();
		for(String T:trans)
		{
			for(x=0;x<lenguaje.length && !lenguaje[x].contains(T);x++);
			if(x>=lenguaje.length)
			{
				if(T!="=")
				{
					if(T.equals(expBolean1) || T.equals(expBolean2))
					{
						lisTrans.add(T);
						obd.Println("Aceptado como boolean");
					}
					else
						if(T.matches(expLog))
						{
							lisTrans.add(T);
							obd.Println("Aceptado como Logico");
						}
						else
							if(T.matches(expOpeRel))
							{
								lisTrans.add(T);
								obd.Println("Aceptado como operador logico");
							}else
								if(T.matches(expId))
								{
									lisTrans.add("ID");
									obd.Println("Aceptado como id");
								}
								else
									if(T.matches(expNum))
									{
										lisTrans.add("NUM");
										obd.Println("Aceptado como num");
									}
									else
										if(T.matches(expChar))
										{
											lisTrans.add(T);
											obd.Println("Aceptado como char");
										}else
											if(T.matches(expLITCHAR))
											{
												lisTrans.add("LITCHAR");
												obd.Println("Aceptado como LITCHAR");
											}
											else
												if(T.matches(expLITCAD))
												{
													lisTrans.add("LITCAD");
													obd.Println("Aceptado como LITCAD");
												}

					}
			}
			else
				{
					lisTrans.add(T);
					obd.Println("Aceptado como PalabraReservada");
				};
		}
		for(String T:lisTrans)
			obd.Println(T);
		return lisTrans;
	}

	private LinkedList<String> Separar(String cad)//SEPARAR POR ESPACIOS
	{
		cad+=" ";
		LinkedList<String> LisTemp = new LinkedList<String>();
		int temp;
		for(int x=0;x<cad.length();x++)
		{
			temp = cad.indexOf(" ",x);
			//obd.Println(temp+"");
			if(temp!=-1)
				if(!cad.substring(x,temp).isBlank())
					 LisTemp.add(cad.substring(x,x=temp));
		}
		return LisTemp;
	}
	private LinkedList<String>  Invertir(LinkedList<String> inv)//INVERTIR LISTA
	{

		LinkedList<String> temp = new LinkedList<String>();
		for(int x=inv.size()-1;x>=0;x--)
			temp.add(inv.get(x));
		return temp;
	}
	
	public static void main (String[]args)
	{
		AnalizadorLexicoF oba = new AnalizadorLexicoF();
		oba.Lectura("IF( ( x != y ) || z == 12 ) { 'C' }");
		if(oba.Validad2())
			System.out.print("Aceptado");
		else
			System.out.print("No Aceptado"+oba.cad2);
	}
}