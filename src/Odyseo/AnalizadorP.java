package Odyseo;

import java.util.LinkedList;

import lib20.Datos;

public class AnalizadorP
{
	private Datos obd = new Datos();
	private LinkedList<String> lista = new LinkedList<String>();
	private LinkedList<String> listCad = new LinkedList<String>();
	private String cad,cad2,lenguaje[]= {"Programa","Imprime","Int","Float","String","Internal","External","Metodo"};
	
	private String expId=("[a-z]([a-z]|[A-Z])*[0-9]*"),
			expNum=("[1-9][0-9]*(.[0-9]*[1-9])?"),
			expChar=("[/*+()-{};,=]"),
			expOpeRel=(">=|<=|==|!=|>|<"),
			expLog=("¿|&&|\\|\\|"),
			expLITCAD=("[~]([a-z]|[A-Z])([a-z]|[A-Z])*[~]"),
			expLITCHAR=("[']([A-Z]|[a-z])[']"),
			expBolean1="FALSE",expBolean2="TRUE";

	private String valoresCol2[] = {"Programa", "ID", "NUM", "{","}","Imprime","Internal","External","Metodo","Int","Float","String","LITCAD","LITCHAR",",","=",";","(",")","$"},
			valoresReb2[] = {"PROG","BODY","SENT",/*"IMPVAL",*/"DEC",/*"OTRODEC","ASIG","ASIGVAL","ASIGFIN","PARAMETROS","OTROPAR"*/};
	
	private String matriz2[][] = {
			/*{"Programa ID { BODY }","ID","#","{","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},//prog
			
			{"#","SENT BODY","#","#","","SENT BODY","SENT BODY","SENT BODY","SENT BODY","#","#","#","#","#","#","#","#","#","#","#"},//body
			
			{"#","ID = L ;","#","#","#","Imprime ( L ) ;","Internal DEC ID","Extenal DEC ID;","Metodo","#","#","#","#","#","#","=",";","#","#","#"},//SENT
				{"#","SENT","#","#","#","#","#","#","#","Int","Float","String","#","#","#","#","#","#","#","#"},//DEG*/

			{"Programa ID { BODY }","","#","","","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},//prog
			
			{"#","SENT BODY","#","#","","SENT BODY","SENT BODY","SENT BODY","SENT BODY","#","#","#","#","#","#","#","#","#","#","#"},//body
			
			{"#","ID = L ;","#","#","#","Imprime ( L ) ;","Internal DEC ID","Extenal DEC ID","Metodo","#","#","#","#","#","#","","","","","#"},//SENT
				{"#","SENT","#","#","#","#","#","#","#","Int","Float","String","#","#","#","#","#","#","#","#"},//DEG
			
			
			//{"#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},//prog
		};
	
	/*private String matriz2[][] = {
			{"Programa ID { BODY }","ID","#","{","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},//prog
			{"#","SENT BODY","SENT BODY","#","","SENT BODY","SENT BODY","SENT BODY","#","#","#","#","SENT BODY","SENT BODY","#","#",";","#",")",""},//body
			
			{"#","L ;","L ;","#","#","Imprime ( IMPVAL )","Internal DEC","External DEC","#","#","#","#","L ;","L ;","#","#","#","(","#","#"},//sentencia
			{"#","ID","NUM","#","#","#","#","#","#","#","#","#","LITCAD","LITCHAR","#","#","#",")",""},//impval
			{"#","ID","#","#","#","#","#","#","Metodo ID ( PARAMETROS ) ;","Int ID ASIG","Float ID ASIG","String ID ASIG","#","#","#","#","#","(","#","#"},//DEC
			{"#","#","#","#","#","#","#","#","#","ID ASIG","ID ASIG","ID ASIG","#","#","#","#","#","#","#","#"},//OTRODEC
			{"#","#","#","#","#","#","#","#","#","#","#","#","#","#",", OTRODEC","= ASIGVAL",";","#","#","#"},//ASIG
			{"#","ID ASIGFIN","NUM ASIGFIN","#","#","#","#","#","#","#","#","#","LITCAD ASIGFIN","LITCHAR ASIGFIN","#","#","#","#","#","#"},//ASIGVAL//CHANGED L
			{"#","#","#","#","#","#","#","#","#","#","#","#","#","#",", OTRODEC","#",";","#","#","#"},//ASIGFIN
			
			{"#","ID","#","#","#","#","#","#","#","Int ID OTROPAR","Float ID OTROPAR","String ID OTROPAR","#","#","#","#","#","#",")","#"},//PARAMETROS
			{"#","#","#","#","#","#","#","#","#","#","#","#","#","#",", PARAMETROS","#","#","#","","#"}//otropar
			
		};*/
	
	private String valoresCol[] = { "-", "+", "*", "/","ID","NUM","$","(",")","TRUE","FALSE",">","<",">=","<=","==","!=","¿","&&","||","LITCAD","LITCHAR",";"},
			valoresReb[] = {"L","L1","R","R1","EXP","T","EXP1","F","T1"};
	private String matriz[][] = {
			{"#","#","#","#","R L1","R L1 ","#","R L1","#EP","R L1 ","R L1 ","#","#","#","#","#","#","R L1","R L1","R L1","R L1","R L1","#"},//lOGICOS
			{"#","#","#","#"," "," "," "," ","#"," "," ","#","#","#","#","#","#"," ","&& R L1","|| R L1","","",""},//lOGICOS1
			
			{"#","#","#","#","EXP R1","EXP R1","#","EXP R1","#EV","EXP R1","EXP R1","#","#","#","#","#","#","EXP R1","#","#","EXP R1","EXP R1","#"},//OPERADORES RELACIONALES
			{"#","#","#","#"," "," "," "," "," "," "," ","> EXP R1","< EXP R1",">= EXP R1","<= EXP R1","== EXP R1","!= EXP R1","#"," "," ","EXP R1","EXP R1",""},//OPERADORES RELACIONALES 1
	 
			{"#","#","#","#","T EXP1","T EXP1","#","T EXP1","!","T EXP1","T EXP1","#","#","#","#","#","#","T EXP1","#","#","T EXP1","T EXP1","#"},//EXP
			{"#","#","#","#","F T1","F T1","#","F T1","#","F T1","F T1","#","#","#","#","#","#","F T1","#","#","F T1","F T1","#"},//T
			{"- T EXP1","+ T EXP1"," "," ","#","#"," ","#"," "," "," "," "," "," "," "," "," ","#"," "," ","#","#",""},//EXP1
			{"#","#","#","#","ID","NUM"," ","( L )"," ","TRUE","FALSE","#","#EF","#","#","#","#","¿","#","#","LITCAD","LITCHAR",";"},//F
			{" "," ","* F T1","/ F T1","F T1","","","F T1"," ","F T1"," "," "," "," "," "," "," ","F T1"," "," ","#","#",""}//T1
			
		};

	
	public boolean  Validad2()
	{
		cad2="";
		int x=0,y=0,reten=0;
		String temp2,res="";
		lista.clear();
		lista.add("$");
		lista.addLast("PROG");
		
		while(!lista.isEmpty() || listCad.isEmpty())
		{
			if(lista.getLast().equals("L"))
				this.Validad();
			
			obd.Print(temp2=listCad.getFirst()); 
			//obd.Print(temp=lista.getLast());
			obd.Print("))->");
			
			//obd.Println(lista.getLast());		
			for(x=0;x<valoresReb2.length && !valoresReb2[x].equals(lista.getLast());x++);
			if(x<valoresReb2.length)
				reten = x;
			for(y=0;y<valoresCol2.length && !valoresCol2[y].equals(temp2);y++);
			
			//obd.Print(reten+"/"+y);
			res = matriz2[reten][y];
			
			for(int z=0;z<lista.size();z++)
				obd.Print(lista.get(z)+"-");
			obd.Println("((("+res+")))");
			
			if(res!="#")
			{
				obd.Println(temp2+"/"+lista.getLast());
				if(temp2.equals(lista.getLast()))
				{
					obd.Println("Eliminado 1");
					lista.removeLast();
					cad2 += listCad.removeFirst();
				}else
				{
					lista.removeLast();
					lista.addAll(this.Invertir(this.Separar(res)));	
				}
				
			}else break;
			obd.Println("////////////////////////////////////");
			
		}

		if(lista.getLast()=="$" && listCad.getLast()=="$")
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
			
			//obd.Println("Elementos finales/"+lista.getLast());
			for(z=0;z<valoresReb2.length && !valoresReb2[z].equals(lista.getLast());z++);
			if(z<valoresReb2.length)
			{
				obd.Println("Hasta luego loco");
				return;
			}
				
			//obd.Println("Elementos finales/"+lista.getLast()+"/"+listCad.getFirst());
			for(x=0;x<valoresReb.length && !valoresReb[x].contains(lista.getLast()!="$"?lista.getLast():"EXP1");x++);
			for(y=0;y<valoresCol.length && !valoresCol[y].contains(temp2);y++);
			if(!(x<valoresReb.length) || !(y<valoresCol.length))
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
				if(temp!="EF")
				{
					if(temp!="EP")
					{
						if(temp!="EV")
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
						{
							obd.Println("Se esperaba un valor logico");
							lista.removeLast();
							cad2 +=listCad.removeFirst();
						}
					}else 
					{
						obd.Println("Se esperaba un valor dentro del parentesis");
						lista.removeLast();
						lista.removeLast();
						cad2 +=listCad.removeFirst();
						
					}
					
				}
				else
				{
					obd.Println("Esperaba un valor numerico");
					lista.removeLast();
					cad2 +=listCad.removeFirst();
				}
			}
			else
			{
				lista.removeLast();
				return;
			}
				
		}
	}
	
	public void Lectura(String cad)
	{
		this.cad=cad;
		listCad = this.Transformar(this.Separar(this.cad));
		listCad.add("$");
	}
	
	private LinkedList<String> Transformar(LinkedList<String> trans)
	{
		int x;
		for(String T:trans)
			obd.Println(T);
		LinkedList<String> lisTrans = new LinkedList<String>();
		for(String T:trans)
		{
			for(x=0;x<lenguaje.length && !lenguaje[x].equals(T);x++);
			if(!(x<lenguaje.length))
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
	
	public static void main(String[] args)
	{
		AnalizadorP oba = new AnalizadorP();
		oba.Lectura("Programa x { Int x = 12 ; }");
		if(oba.Validad2())
			System.out.print("Aceptado");
		else
			System.out.print("No Aceptado"+oba.cad2);
	}

}
