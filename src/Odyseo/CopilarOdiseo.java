package Odyseo;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import lib20.Datos;

public class CopilarOdiseo
{

	private Datos obd = new Datos();
	private LinkedList<String> lista = new LinkedList<String>();//PILA PARA GUARDAR VALORES RESULTANTES
	private LinkedList<String> listCad = new LinkedList<String>();//PILA DE ENTRADA, LOS VALORES SON LOS Q ESCIRBA EL USUARIO
	private LinkedList<String> listLexico = new LinkedList<String>();//PILA DE ALMACEN DE CADENAS SINTACTICAS EL NOMBRE ESTA MAL
	private String cad,cadLex="",lenguaje[]= {"Programa","endfin","Int","Float","Char","String","Bool","Proc",
			"endp","Funcion","endf","If","endif","While","endwhile","Repeat","until","Else","Retorna",",",";",":","=","++","--","then","do"};//PALABRAS RESERVADAS
	private int con=0;
	private boolean ban=false;
	
	private String expId=("[a-z]([a-z]|[A-Z])*[0-9]*"),
			expNum=("[1-9][0-9]*(.[0-9]*[1-9])?"),
			expChar=("[()]"),
			expAsig=("="),
			expOpeBas=("[+-[*]/]"),
			expOpeRel=(">=|<=|==|!=|>|<"),
			expLog=("[!|&|\\|]"),
			expLITCAD=("[~]([a-z]|[A-Z])([a-z]|[A-Z])*[~]"),
			expLITCHAR=("[']([A-Z]|[a-z])[']"),
			expBoleanf="false",expBoleant="true";
	
	private String valoresCol[] = {"id","num","(",")","litcad","litcar","+","-","*","/","<",">","<=",">=","!=","==","!","&","|","true","false",
			"If","While","Repeat","Else","then","do","endif","endwhile","Programa","Int","Float","Char","String","Bool",",","Proc","Funcion","endp","endf","endfin","idp","idf","Retorna","$","++","--",";",":","=","until"},//VALORES DE BUSQUEDA COLUMNAS
			valoresReb[] = {"prog","dec","sigid","modulos","proc","fun","tiporetorno","list-arg","siglist","list-param","sig-param","sentencias","sentencia","sigif","asigna","L","L1","R","R1","E","E1","T","T1","F"};//VALORES DE BUSQUEDA RENGLONES
	//Retorna sentencias
	private String matriz2[][] = {
			/*prog*/{"","#3","#3","#3","#3",			"#3","#3","#3","#3","#3"		,"#3","#3","#3","#3","#3",		"#3","#3","#3","#3","#3",		"#3","#3","#3","#3","#3",		"#3","#3","#3","#3","Programa id ; modulos dec sentencias endfin",		"#3","#3","#3","#3","#3",		"#3","#3","#3","#3","#3",		"#3","#3","#3","#3","#3",		"#3","#3","","#3","#3" 	,"#3"},
			/*dec*/{"","#","#","#","#",		"#","#","#","#","#"		,"#","#","#","#","#",		"#","#","#","#","#",		"#"," "," "," ","#",		"#","#","#","#","#2",		"Int id sigid ; dec","Float id sigid ; dec","Char id sigid ; dec","String id sigid ; dec","Bool id sigid ; dec",		"#","#","#"," ","#",		" ","#","#","#","#",		"#","#",";","#","= L sigid ;"		,"#"},
			/*sigid*/{"","#8","#","#","#",		"#","#","#","#","#"		,"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#2",		"#","#","#","#","#",		", id sigid","#","#","#","#",		"#6","#","#","#","#",		"#","#"," ","#",""		,"#"},
			/*modulos*/{"","#","#","#","#",		"#","#","#","#","#"		,"#","#","#","#","#",		"#","#","#","#","#",		"#","","","","#",		"#","#","#","#","#2",		"","","","","",		"#","proc modulos","fun modulos","#","#",		" ","#","#","#","#4",		"#","#","#","#","#"		,"#"},
		/*proc*/{"#","#"," ","#","#",		"#","#","#","#","#"		,"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#2",		"#","#","#","#","#",		"#","Proc idp ( list-arg ) sentencias endp","#","#","#",		"#","","#","#","#",		"#","#","#","#","#"		,"#"},
		/*fun*/{"#","#"," ","#","#",		"#","#","#","#","#"		,"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#2",		"#","#","#","#","#",		"#","#","Funcion idf ( list-arg ) : tiporetorno sentencias endf","#","#",		"#","#","idf","#","#",		"#","#","#","#","#"		,"#"},
		/*tiporetorno*/{"#","#","#","#","#",		"#","#","#","#","#"		,"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#2",		"Int","Float","Char","String","Bool",		"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#"		,"#"},
		/*list-arg*/{"","#","#","#","#",		"#","#","#","#","#"		,"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#2",		"Int id siglist","Float id siglist","Char id siglist","String id siglist","Bool id siglist",		"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#"		,"#"},
		/*siglist*/{"#","#8","#"," ","#",		"#","#","#","#","#"		,"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#2",		"#","#","#","#","#",		", list-arg","#","#","#","#",		"#","#","#","#","#",		"#","#","#"," ","#"		,"#"},
		/*list-param*/{"L sig-param","L sig-param","L sig-param","#","L sig-param",		"L sig-param","#","#","#","#"		,"#","#","#","#","#",		"#","#","#","#","L sig-param",		"L sig-param","#","#","#","#",		"#","#","#","#","#2",		"#","#","#","#","#",		"#","#","#","#","#",		"#","L sig-param","L sig-param","#","#",		"#","#","#","#","#"		,"#"},
		/*sig-param*/{"#","#","#","#","#",		"#","#","#","#","#"		,"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#2",		"#","#","#","#","#",		", L sig-param","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#"		,"#"},
			/*sentencias*/{"sentencia sentencias","#","#","#0","#",		"#","#","#","#","#"		,"#","#","#","#","#",		"#","#","#","#","#",		"#","sentencia sentencias","sentencia sentencias","sentencia sentencias","",		"#","#","","","#2",		"dec","dec","dec","dec","dec",		"#","#"," "," "," ",		" ","#","#","sentencia sentencias","#",		"sentencia sentencias","sentencia sentencias","#","#","#"		," "},
		/*sentencia*/{"asigna ;","#"," ","#","#",		"#","#","#","#","#"		,"#","#","#","#","#",		"#","#","#","#","#",		"#","If L then sentencias sigif endif","While L do sentencias sigif endwhile","Repeat sentencias until L ;","",		"#","#","#","#","#2",		"#","#","#","#","#",		"#","#","#","#","#",		"#","idp ( list-param ) ;","#","Retorna L ;","#",		"asigna ;","asigna ;","#","#","#"		,"#"},
		/*sigif*/{"#","#","#","#","#",		"#","#","#","#","#"		,"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","Else sentencias",		"#","#","","","#2",		"#","#","#","#","#",		"#","#","","#","#",		"#","#","#","#","#",		"#","#","#","#","#" 	,"#"},
		/*asigna*/{"id = L","#","#","#","#",		"#","#","#","#","#"		,"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#2",		"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#",		"++ L","-- L","#","#"," "		,"#"},

		
		/*L*/{"R L1","R L1","R L1","#","R L1",		"R L1","#","#","#","#"		,"#","#","#","#","#",		"#","R L1","#","#","R L1",		"R L1","#","#","#","#",		"#","#","#","#","#2",		"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#"		,"#"},
		/*L1*/{"#","#","#"," ","#",		"#","#","#","#","#"		,"#","#","#","#","#",		"#","! L","& R L1","| R L1","#",		"#","#","#","#","#",		" "," ","#"," ","#2",		"#","#","#","#","#",		"","#","#","#","",		"#","#","#","#"," ",		"#","#"," ","#","#"		," "},
		/*R*/{"E R1","E R1","E R1","#","E R1",		"E R1","#","#","#","#"		,"#","#","#","#","#",		"#","#","#","#","E R1",		"E R1","#","#","#","#",		"#","#","#","#","#2",		"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#"		,"#"},
		/*R1*/{"#","#","#"," ","#",		"#","#","#","#","#"		,"< E","> E","<= E",">= E","!= E",		"== E",""," "," ","#",		"#","#","#","#","#",		" "," ","#"," ","#2",		"#","#","#","#","#",		"","#","#","#","",		"#","#","#","#"," ",		"#","#"," ","#","#"		," "},
		/*E*/{"T E1","T E1","T E1","#","T E1",		"T E1","#","#","#","#"		,"#","#","#","#","#",		"#","#","#","#","T E1",		"T E1","#","#","#","#",		"#","#","#","#","#2",		"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#"		,"#"},
		/*E1*/{"#","#","#"," ","#",		"#","+ T E1","- T E1","#","#"		,"","","","","",		"",""," "," ","#",		"#","#","#","#","#",		" "," ","#"," ","#2",		"#","#","#","#","#",		"","#","#","#","",		"#","#","#","#"," ",		"#","#"," ","#","#"		," "},
		/*T*/{"F T1","F T1","F T1","#","F T1",		"F T1","#","#","#","#"		,"#","#","#","#","#",		"#","#","#","#","F T1",		"F T1","#","#","#","#",		"#","#","#","#","#2",		"#","#","#","#","#",		"#7","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#"		,"#"},
		/*T1*/{"#1","#1","#"," ","#1",		"#1","","","* F T1","/ F T1"		,"","","","","",		" "," "," "," ","#1",		"#1","#1","#1","#1","#1",		" "," ","#1"," ","#2",		"#9","#1","#1","#1","#1",		"","#1","#1","#1","",		"#5","#1","#1","#1"," ",		"#1","#1"," ","#1","#1"		," "},
		/*F*/{"id","num","( L )","#","litcad",		"litchar","#","#","#","#"		,"#","#","#","#","#",		"#","#","#","#","true",		"false","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#",		"#","#","#","#","#"		,"#"},
		
	};
	
	public String Ultipila()
	{
		int x;
		for(x=0;x<lenguaje.length && !lenguaje[x].equals(lista.getLast());x++);
			if(x<lenguaje.length)
				return lista.getLast();
			else
				return listCad.getFirst();
	}
	
	private String errores[] = 
		{
				"->No hay llave de apertura del Parentesis ",//0
				"->Se esperaba un Operador de cualquier tipo O agrupacion ",//1
				"->Solo puede haber un Programa ",//2
				"->Despues de programa solo puede haber una ^id ;^ ",//3
				"->Se esperaba el endfin ",//4
				"->Se esperaba un valor de cierre del Proceso o Funcion ",//5
				"-> Se esperaba un ",//6
				"-> Se esperaba un valor terminador ",//7
				"->Se esperaba valor diferente a ",//8
				"-> Se esperaba un cierre en "//9
		};
	
	public boolean  ErrorLexico()
	{
		return ban;
	}
	
	public LinkedList<String> Sinta()
	{
		return listLexico;
	}
	
	public int Contador()
	{
		return con;
	}
	
	public String  Validad2()
	{
		con=-1;//SE LIMPIAN Y REINICIAN VARIABLES 
		listLexico.clear();
		int x=0,y=0,reten=0;
		String temp2,res="";
		lista.clear();
		lista.add("$");
		lista.addLast("prog");
		
		while(!lista.isEmpty() || listCad.isEmpty()) // CICLO Q TERMINA HASTA LLEGAR A VACIO O BREAK O RETURN
		{	
			cadLex ="";// SE REINICIA LA VARIABLE QUE CONTRUYE LA CADENA SINTACTICA
			try {
				cadLex += temp2=listCad.getFirst(); 
			}catch(NoSuchElementException e)
			{
				break;
			}
			//obd.Print(temp=lista.getLast());
			cadLex += "))->";
			
			//obd.Println(lista.getLast());		
			for(x=0;x<valoresReb.length && !valoresReb[x].equals(lista.getLast());x++);//RECORRE HASTA ENCONTRAR SIMILITUDES
			if(x<valoresReb.length)//SI NO HAY SIMILTUD CONTINUA CON ANTERIOR VALOR GUARDADO
				reten = x;
			for(y=0;y<valoresCol.length && !valoresCol[y].equals(temp2);y++);//RECORRE HASTA ENCONTRAR SIMILITUDES
			
			//obd.Print(reten+"/"+y);
			res = matriz2[reten][y];//OBITENE EL VALOR DE LA MATRIZ 
			
			for(int z=0;z<lista.size();z++)//AGREGA VALORES SINTACTICA EL NOMBRE ESTA MAL
				cadLex += lista.get(z)+"-";
			cadLex +="((("+res+")))";
			
			listLexico.add(cadLex); //LO AGREGA POR PARTES PARA DARLE PRESENTACION
			cadLex ="";
			
			if(!res.contains("#"))//CUALQUIER ERROR CONTENDRA UN # DE PRIMER ELEMENTO
			{
				cadLex += temp2+"/"+lista.getLast(); 
				if(temp2.equals(lista.getLast()))//COMPARA SI LOS VALORES SON SEMEJANTES
				{
					cadLex += "((Eliminado))";
					con++;		// CUENTA PARA SABER QUE PASO DE ELEMENTO PARA LUEGO RECONCER DONDE ES EL ERROR
					lista.removeLast();
					listCad.removeFirst();
					
				}else
				{
					lista.removeLast();
					lista.addAll(this.Invertir(this.Separar(res)));	
				}
			}else
			{
				obd.Println(res+"/"+con);
				if(res.length()>1)//SI EL ERROR TIENE ALGUN VALOR APARTE DE # ES UN ERROR YA ESPECIFICADO 
					return errores[ Integer.parseInt(res.substring(1)) ];
				else
					break;
			}
			listLexico.add(cadLex);
			listLexico.add("////////////////////////////////////");
		}

		if((lista.getLast()=="$" && listCad.getFirst()=="$"))
		{
			return "";
		}
		else
		{
			return "Error no definido";
		}
	}
	
	public void Lectura(String cad) // LECUTURA APARTIR DE CADENA--ABSOLETO--
	{
		this.cad=cad;
		listCad = this.Transformar(this.Separar(this.cad));
		listCad.add("$");
	}
	
	public void LecturaList(LinkedList<String> lista)
	{
		ban = false;
		listCad.clear();
		listCad.addAll(lista);
		listCad.add("$");
		for(String T:listCad)
		{
			obd.Println(T);
		}
	}
	
	public LinkedList<String> Separar(String cad)//SEPARAR POR ESPACIOS
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
	
	public LinkedList<String> SepararN(String text)//SEPARAR POR \n
	{
		LinkedList<String> LisTemp = new LinkedList<String>();
		String cad = text;
		int temp=-1;
		for(int x=0;x<cad.length();x++)
		{
			temp = cad.indexOf("\n",x);
			//obd.Println(temp+"");
			if(temp!=-1)
				if(!cad.substring(x,temp).isBlank())
					 LisTemp.add(cad.substring(x,x=temp));
		}
		/*for(int x=0;x<cad.length();)
		{
			temp = cad.indexOf("\n",x);
			if(temp!=-1)
			{
				if(!cad.substring(x,temp).isBlank())
				{
					 LisTemp.add(cad.substring(x,x=temp+1).trim());
				}
			}else
			{
				LisTemp.add(cad.substring(x,x=cad.length()).trim());
			}
				
		}*/
		return LisTemp;
	}
	
	public LinkedList<String> Transformar(LinkedList<String> trans)//ANALIZADOR LEXICO 
	{
		int x,ind;
		/*for(String T:trans)
			obd.Println(T);*/
		LinkedList<String> lisTrans = new LinkedList<String>();
		for(ind=0;ind<trans.size();ind++)
		{
			for(x=0;x<lenguaje.length && !lenguaje[x].equals(trans.get(ind));x++);
			{
			if(!(x<lenguaje.length))
			{
				if(trans.get(ind).equals(expBoleanf))
				{
					lisTrans.add(expBoleanf);
					obd.Println("Aceptado como BooleanoF");
				}
				else
					if(trans.get(ind).equals(expBoleant))
					{
						lisTrans.add(expBoleant);
						obd.Println("Aceptado como BooleanoT");
					}else
						if(trans.get(ind).matches(expId))
						{
							if(ind>0)
							{
								if(trans.get(ind-1).equals("Funcion")) {
									lisTrans.add("idf");
									obd.Println("Aceptado como Id Funcion");
								}
								else
									if(trans.get(ind-1).equals("Proc")) {
										lisTrans.add("idp");
										obd.Println("Aceptado como Id Proc");
									}else {
										lisTrans.add("id");
										obd.Println("Aceptado como Id");
									}
							}
							else {
								lisTrans.add("id");
								obd.Println("Aceptado como Id");
							}
		
						}else
							if(trans.get(ind).matches(expNum))
							{
								lisTrans.add("num");
								obd.Println("Aceptado como Num");
							}else
								if(trans.get(ind).matches(expChar))
								{
									lisTrans.add(trans.get(ind));
									obd.Println("Aceptado como Char");
								}
								else
									if(trans.get(ind).matches(expLITCAD))
									{
										lisTrans.add("litcad");
										obd.Println("Aceptado como Cadena");
									}
									else
										if(trans.get(ind).matches(expLITCHAR))
										{
											lisTrans.add("licar");
											obd.Println("Aceptado como Caracter");
										}
										else
											if(trans.get(ind).matches(expAsig))
											{
												lisTrans.add(trans.get(ind));
												obd.Println("Aceptado como Asignador");
											}
											else
												if(trans.get(ind).matches(expOpeBas))
												{
													lisTrans.add(trans.get(ind));
													obd.Println("Aceptado como Operador Basico");
												}
												else
													if(trans.get(ind).matches(expOpeRel))
													{
														lisTrans.add(trans.get(ind));
														obd.Println("Aceptado como Operador Relacional");
													}
													else
														if(trans.get(ind).matches(expLog))
														{
															lisTrans.add(trans.get(ind));
															obd.Println("Aceptado como Logico");
														}
														else
														{
															ban = true;
														}
													
									
			}
			else
				{
					lisTrans.add(trans.get(ind));
					obd.Println("Aceptado como PalabraReservada");
				};
		}
		}
		for(String T:lisTrans)
			obd.Println(T);
		return lisTrans;
	}
	
	private LinkedList<String>  Invertir(LinkedList<String> inv)//INVERTIR LISTA
	{
		LinkedList<String> temp = new LinkedList<String>();
		for(int x=inv.size()-1;x>=0;x--)
			temp.add(inv.get(x));
		return temp;
	}
}
