package Odyseo;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import lib20.Datos;

public class CpiladorVacacional
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
			//valoresReb[] = {"prog","dec","sigid","modulos","proc","fun","tiporetorno","list-arg","siglist","list-param","sig-param","sentencias","sentencia","sigif","asigna","L","L1","R","R1","E","E1","T","T1","F"};//VALORES DE BUSQUEDA RENGLONES
			valoresReb[] = {"prog","dec","modulos","sentencias","sigid","sentencia","sigif","proc","fun","list-arg","siglis","tr","return","L","L1","R","R1","E","E1","T","T1","F"};//VALORES DE BUSQUEDA RENGLONES
			//valoresRebExc[] = {"modulos"};
			
	private String matriz2[][] = {
						//id										num										(									)									litcad									litchar									+										-										*								/										<										>										<=										>=								!=										==										!										&										|								true									false									If										While									Repeat										Else									then									do										endif									endwhile								Programa																Int										Float									Char									String									Bool							,										Proc									Func									endp									endf							endfin									idp										idf										Retorna									$								++										--										;										:										=								until
	/*prog*/			{"",										"#",									"#",								"#",								"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",										"#",									"#",									"#",									"#",									"#",									"Programa id ; dec modulos sentencias endfin",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"",										"#",									"#",							"#"},
	/*dec*/				{"",										"#",									"#",								"#",								"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"",										"",										"",											"#",									"#",									"#",									"#",									"#",									"#2",																	"Int id sigid ; dec",					"Float id sigid ; dec",					"Char id sigid ; dec",					"String id sigid ; dec",				"Bool id sigid ; dec",			"#",									"",										"",										"#",									"#",							"",										"#",									"#",									"#",									"#",							"#",									"#",									"",										"#",									"#",							"#"},
	/*modulos*/			{"",										"#",									"#",								"#",								"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"",										"",										"",											"#",									"#",									"#",									"#",									"#",									"#2",																	"#",									"#",									"#",									"#",									"#",							"#",									"proc modulos",							"fun modulos",							"#",									"#",							"",										"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#"},
	/*sentencias*/		{"sentencia sentencias",					"#",									"#",								"#1",								"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"sentencia sentencias",					"sentencia sentencias",					"sentencia sentencias",						"",										"#",									"#",									"",										"",										"#2",																	"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"",										"",								"",										"#",									"#",									"",										"#",							"#",									"#",									"#",									"#",									"#",							""},
	/*sigid*/			{"",										"#",									"#",								"#",								"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",										"#",									"#",									"#",									"#",									"#",									"#2",																	"#",									"#",									"#",									"#",									"#",							", id sigid",							"#",									"#",									"#",									"#",							"",										"#",									"#",									"#",									"#",							"#",									"#",									"",										"#",									"#",							"#"},
	/*sentencia*/		{"id = L ;",								"#",									"#",								"#",								"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"If L then sentencias sigif endif",		"While L do sentencias endwhile",		"Repeat sentencias until L ;",				"#",									"#",									"#",									"#",									"#",									"#2",																	"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"",										"#",									"",				 				"#"},
	/*sigif*/			{"#",										"#",									"#",								"#",								"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",										"Else sentencias",						"#",									"#",									"",										"#",									"#2",																	"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#"},
	/*proc*/			{"#",										"#",									"",									"#",								"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",										"#",									"#",									"#",									"#",									"#",									"#2",																	"#",									"#",									"#",									"#",									"#",							"#",									"Proc idp ( list-arg ) sentencias endp","#",									"#",									"#",							"#",									"",										"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#"},
	/*fun*/				{"#",										"#",									"",									"#",								"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",										"#",									"#",									"#",									"#",									"#",									"#2",																	"#",									"#",									"#",									"#",									"#",							"#",									"#",									"Funcion idf ( list-arg ) : tr sentencias return endf","#",						"#",							"#",									"#",									"",										"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#"},
	/*list-arg*/		{"",										"#",									"#",								"",									"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",										"#",									"#",									"#",									"#",									"#",									"#2",																	"Int id siglis",						"Float id siglis",						"Char id siglis",						"String id siglis",						"Bool id siglis",				"#",									"#", 									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#"},
	/*siglis*/			{"#",										"#",									"#",								"",									"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",										"#",									"#",									"#",									"#",									"#",									"#2",																	"#",									"#",									"#",									"#",									"#",							", list-arg",							"#", 									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"",										"#",							"#"},
	/*tr*/				{"#",										"#",									"#",								"#",								"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",										"#",									"#",									"#",									"#",									"#",									"#2",																	"Int",									"Float",								"Char",									"String",								"Bool",							"#",									"#", 									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#"},
	/*return*/			{"#00",										"#0",									"#0",								"#0",								"#0",									"#0",									"#0",									"#0",									"#0",							"#0",									"#0",									"#0",									"#0",									"#0",							"#0",									"#0",									"#0",									"#0",									"#0",							"#0",									"#0",									"#0",									"#0",									"#0",										"#0",									"#0",									"#0",									"#0",									"#0",									"#2",																	"#0",									"#0",									"#0",									"#0",									"#0",							"#0",									"#0", 									"#0",									"#0",									"#0",							"#0",									"#0",									"#0",									"Retorna L ;",							"#0",							"#0",									"#0",									"#0",									"#0",									"#0",							"#0"},

	
	/*L*/				{"R L1",                                    "R L1",		                           "R L1",				                "#",								"R L1",									"R L1",								    "#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"R L1",									"#",									"#",							"R L1",									"R L1",									"#",									"#",									"#",										"#",									"#",									"#",									"#",									"#",									"#2",																	"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#"},
	/*L1*/				{"#",                                       "#",                                   "#",                                 " ",                                "#",		                            "#",                                    "#",                                    "#",									"#",						    "#"		      						   ,"#",									"#",									"#",									"#",						    "#",		         				    "#",									"! L",									"& R L1",								"| R L1",						"#",		   							"#",									"#",									"#",									"#",									    "#",		               	            " ",									" ",									"#",									" ",									"#2",		          												    "#",									"#",									"#",									"#",									"#",							"",									    "#",									"#",									"#",									"",								"#",									"#",									"#",									"#",									" ",							"#",									"#",									" ",									"#",									"#"								," "},
	/*R*/				{"E R1",                                    "E R1",                                "E R1",                              "#",                                "E R1",		                            "E R1",                                 "#",									"#",									"#",						    "#"		                               ,"#",									"#",									"#",									"#",							"#",		          				    "#",									"#",									"#",									"#",							"E R1",		          					"E R1",									"#",									"#",									"#",									    "#",			                        "#",									"#",									"#",									"#",									"#2",		           		          							        "#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#"								,"#"},
	/*R1*/				{"#",                                       "#",                                   "#",                                 " ",                                "#",		                            "#",                                    "#",									"#",									"#",						    "#"		                               ,"< E",									"> E",									"<= E",									">= E",							"!= E",									"== E",									"",									    " ",									" ",							"#",		           	                "#",									"#",									"#",									"#",									    "#",		               	            " ",									" ",									"#",									" ",									"#2",		        	          								        "#",									"#",									"#",									"#",									"#",							"",									    "#",									"#",									"#",									"",								"#",									"#",									"#",									"#",									" ",							"#",									"#",									" ",									"#",									"#"								," "},
	/*E*/				{"T E1",                                    "T E1",                                "T E1",                              "#",                                "T E1",		                            "T E1",                                 "#",									"#",									"#",						    "#"		                               ,"#",									"#",									"#",									"#",							"#",		           					"#",									"#",									"#",									"#",							"T E1",		           	                "T E1",									"#",									"#",									"#",									    "#",		        	                "#",									"#",									"#",									"#",									"#2",		           	          								        "#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#"								,"#"},
	/*E1*/				{"#",                                       "#",                                   "#",                                 " ",                                "#",		                            "#",                                    "+ T E1",							    "- T E1",								"#",						    "#"		                               ,"",									    "",									    "",									    "",							    "",		              				    "",									    "",									    " ",									" ",							"#",		              	            "#",				 					"#",									"#",									"#",									    "#",		        	                " ",									" ",									"#",									" ",									"#2",		           	          								        "#",									"#",									"#",									"#",									"#",							"",									    "#",									"#",									"#",									"",								"#",									"#",									"#",									"#",									" ",							"#",									"#",									" ",									"#",									"#"								," "},
	/*T*/				{"F T1",                                    "F T1",                                "F T1",                              "#",                                "F T1",		                            "F T1",                                 "#",									"#",									"#",						    "#"		                               ,"#",									"#",									"#",									"#",							"#",		          			        "#",									"#",									"#",									"#",							"F T1",		          	                "F T1",									"#",									"#",									"#",									    "#",		          	                "#",									"#",									"#",									"#",									"#2",			          								                "#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#"								,"#"},
	/*T1*/				{"#",                                      	"#",                                  	"#",                                 " ",                                "#",		                            "#",                                   "",									    "",									    "* F T1",						"/ F T1"		                       ,"",									    "",									    "",									    "",							    "",		              			        " ",									" ",									" ",									" ",							"#",		          	           	    "#",									"#",									"#",									"#",									    "#",		        	                " ",									" ",									"#",									" ",									"#2",			          								                "#",									"#",									"#",									"#",									"#",							"",									    "#",									"#",									"#",									"",								"#",									"#",									"#",									"#",									" ",							"#",									"#",									" ",									"#",									"#"								," "},
	/*F*/				{"id",                                      "num",                                 "( L )",                             "#",                                "litcad",		                        "litchar",                              "#",									"#",									"#",						    "#"		                               ,"#",									"#",									"#",									"#",							"#",		         					"#",									"#",									"#",									"#",							"true",		           	                "false",								"#",									"#",									"#",									    "#",		                            "#",									"#",									"#",									"#",									"#2",			          								                "#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#"								,"#"},
		
	};
	
	public String Ultipila()
	{
		int x;
		
		/*for(x=0;x<lenguaje.length && !lenguaje[x].equals(lista.getLast());x++);
			if(x<lenguaje.length)
				return lista.getLast();
			else
				return lista.getLast();*/
		for(x=0;x<valoresReb.length && !valoresReb[x].equals(lista.getLast());x++);
			if(x<valoresReb.length) {
				lista.removeLast();
				return ""+this.Ultipila();
			}
			else
				if(!lista.getLast().equals("endfin"))
					return lista.getLast();
				else
					return "";
	}
	
	private String errores[] = 
		{
			"El metodo de 'Funcion' necesita contener un Retorna antes de ",
			"Se detecto un ')' el cual nunca fue abierto antes de ",
			"No puede haber mas de un identificador 'Programa' por clase",
			"El paranteisis de cerrado nunca se encontro"
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
		con=0;//SE LIMPIAN Y REINICIAN VARIABLES 
		listLexico.clear();
		int x=0,y=0,reten=0;
		String temp2,res="";
		lista.clear();
		lista.add("$");
		lista.addLast("prog");
		
		while(!lista.isEmpty() || listCad.isEmpty()) // CICLO Q TERMINA HASTA LLEGAR A VACIO O BREAK O RETURN
		{	
			if(lista.getLast()=="$")
				break;
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
					int n;
					/*for(n=0; n<valoresReb.length && !valoresReb[n].equals(listCad.getFirst());n++);
						if(n>=valoresReb.length && listCad.getFirst()!=lista.getLast())
						{
							res="#3";
							break;
						}
						else
						{
							lista.removeLast();
							lista.addAll(this.Invertir(this.Separar(res)));	
						}*/
					for(n=0;n<valoresReb.length && !valoresReb[n].equals(lista.getLast());n++);
						if(n>=valoresReb.length)
						{
						
							obd.Println("//1"+n);
							break;
						}
						else
						{
							lista.removeLast();
							lista.addAll(this.Invertir(this.Separar(res)));	
						}
					
				}
			}else
			{
				obd.Println(res+"/"+con);
				if(lista.getLast().equals("L"))
				{
					return "Valor Esperado un Terminador";
				}else
					if(lista.getLast().equals("T1"))
					{
						return "Valor Esperado un Logico/Relaciona/";
					}
					else
						if(lista.getLast().equals("sentencias"))
						{
							return "Valor Esperado ID/EstructuraControl/";
						}
						else
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
			return "Valor esperado ";
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
		listCad.clear();
		listCad.addAll(lista);
		listCad.add("$");
		for(String T:listCad)
		{
			obd.Println(T+"L");
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
		ban = false;
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
															obd.Println("Bandera");
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
