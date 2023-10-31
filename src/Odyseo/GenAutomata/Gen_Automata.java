package Odyseo.GenAutomata;

import java.util.LinkedList;
import lib20.Datos;//llama a la libreria

public class Gen_Automata
{
	private Datos obd = new Datos();//libreria 
	private LinkedList<TDA_GAuto> Datos = new LinkedList<TDA_GAuto>();//Generado
	private LinkedList<String> listaSintactica = new LinkedList<String>();//Generado
	private LinkedList<String> pilaSintactica = new LinkedList<String>();//Generado
	private LinkedList<String> eleSintacticos = new LinkedList<String>();//Generado
	private TDA_GAuto tda;//Tipo Dato Abstracto
	
	private String[] palabrasReservadas;//lo ocupa poner el usuario
	private String[] columnasTabla;//lo ocupa poner el usuario
	private String[] renglonesTabla;//lo ocupa poner el usuario
	private String[][] TablaLogica;//lo ocupa poner el usuario
	
	
	public void setPalabraReservadas(String[] lista) //USO OBLIGATORIO
	{
		palabrasReservadas = lista;
	}

	public void setColumnas(String[] lista)
	{
		columnasTabla = lista;
	}
	
	public void setRenglones(String[] lista)
	{
		renglonesTabla = lista;
	}
	
	public void setTablaLogica(String[][] lista)
	{
		TablaLogica = lista;
	}
	
	/*public void Separar(String txt,String[] palabrasReservadas)//Separa los elementos 
	{
		eleSintacticos.clear();
		this.setPalabraReservadas(palabrasReservadas);
		String[] entraEnter;//se genera
		int numele=-1;
		String [] temp;
		entraEnter=txt.split("\n");
		for(int x=0;x<entraEnter.length;x++)
		{	
			temp = entraEnter[x].split(" ");
			for(int ind=0;ind<temp.length;ind++)
			{
				if(!temp[ind].isBlank())
				{
					tda = new TDA_GAuto();
					tda.setNum_Fila(x);
					tda.setNum_Elemento(ind);//tda.setNum_Elemento(++numele);
					tda.setFrm_Entrada(temp[ind]);
					tda.setFrm_Lexica(this.FormaLexica(temp[ind],palabrasReservadas));
					Datos.add(tda);
				}
			}
		}	
		for(TDA_GAuto ele: Datos)
		{
			obd.Println(ele.getNum_Elemento()+"/"+ele.getFrm_Entrada()+"/"+ele.getFrm_Lexica()+"/"+ele.getNum_Fila());
			eleSintacticos.addFirst(ele.getFrm_Lexica());
		}
	}*/
	
	public void Separar(String txt)//Separa los elementos 
	{
		this.setPalabraReservadas(palabrasReservadas);
		String[] entraEnter;//se genera
		//int numele=-1;
		String [] temp;
		entraEnter=txt.split("\n");
		for(int x=0;x<entraEnter.length;x++)
		{	
			temp = entraEnter[x].split(" ");
			for(int ind=0;ind<temp.length;ind++)
			{
				if(!temp[ind].isBlank())
				{
					tda = new TDA_GAuto();
					tda.setNum_Fila(x);
					tda.setNum_Elemento(ind);//tda.setNum_Elemento(++numele);
					tda.setFrm_Entrada(temp[ind]);
					tda.setFrm_Lexica(this.FormaLexica(temp[ind],palabrasReservadas));
					Datos.add(tda);
				}
			}
		}	
		for(TDA_GAuto ele: Datos)
		{
			obd.Println(ele.getNum_Fila()+"/"+ele.getFrm_Entrada()+"/"+ele.getFrm_Lexica()+"/"+ele.getNum_Elemento());
			eleSintacticos.addFirst(ele.getFrm_Lexica());
		}
		/*for(String ele:eleSintacticos)
		{
			obd.Println(ele);
		}*/
	}
	
	private String FormaLexica(String cad,String[] palabrasReservadas)
	{
		int x;
		//obd.Println("Checa Esto:"+palabrasReservadas);
		for(x=0;x<palabrasReservadas.length && !palabrasReservadas[x].equals(cad);x++);
		if(x<palabrasReservadas.length)
			return cad;
		else
		{
			if(cad.matches("[a-z]([a-z]|[A-Z]|[0-9])*"))
			{
				return "id";
			}
			else if(cad.matches("-?([1-9][0-9]*|0)(.[0-9]*)?(e[+|-][1-9][0-9]*)?"))
			{
				return "num";
			}
		}
		return "ErrorLexico";
	}
	
	private String ElementosHabiles()
	{
		int x=0;
		for(x=0;x<columnasTabla.length && !columnasTabla[x].equals(eleSintacticos.getLast());x++);
		if(x<columnasTabla.length)
		{
			
		}

		return "";
	}
	
	public void Evaluar()
	{
		pilaSintactica.add("$");
		pilaSintactica.add("prog");
		int col=-1,ren=-1,x=-1,pos=0;
		boolean ban=false;
		String actual="Inicio";
		
		while(!pilaSintactica.getLast().equals("$"))
		{
			obd.Println(pilaSintactica.getLast()+"/"+eleSintacticos.getLast());
			for(x=0;x<renglonesTabla.length && !renglonesTabla[x].equals(pilaSintactica.getLast());x++);
			if(x<renglonesTabla.length)
			{
				ren = x;
				ban=true;
			}
			else
			{
				ban = false;
			}
			for(x=0;x<columnasTabla.length && !columnasTabla[x].equals(eleSintacticos.getLast());x++);
			if(x<columnasTabla.length)
			{
				col = x;
			}
			
			actual = TablaLogica[ren][col];
			//obd.Println(ren+"/"+col+":"+actual);
			if(pilaSintactica.getLast().equals(eleSintacticos.getLast()))
			{
				listaSintactica.add(this.Cadenizador(pilaSintactica)+":"+eleSintacticos.getLast()+":"+"Concuerda");
				pilaSintactica.removeLast();
				eleSintacticos.removeLast();
				pos++;
			}
			else
			{
				if(!actual.isBlank())
				{
					if(actual.contains("#"))//PalabraReservada -> terminador: No regresa ; Avance negativo
					{
						listaSintactica.add(this.Cadenizador(pilaSintactica)+":"+eleSintacticos.getLast()+":"+"Error/"+eleSintacticos.getLast()+"->"+pilaSintactica.getLast()+"/Fila:"+Datos.get(pos).getNum_Fila()+"/Elemento:"+Datos.get(pos).getNum_Elemento());
						pilaSintactica.removeLast();
						eleSintacticos.removeLast();
						pos++;
					}
					else//Palabra Reservada -> terminador : Regresa Elementos ; Avance positivo
					{
						listaSintactica.add(this.Cadenizador(pilaSintactica)+":"+eleSintacticos.getLast()+":"+this.Cadenizador(Listaneitor(actual)));
						pilaSintactica.removeLast();
						pilaSintactica.addAll(Listaneitor(actual));
					}
				}
				else
				{
					if(ban)//Si encuentra Cambio de renglon
					{
						//Palabra Reservada -> terminador: No regresa ; Avance positivo
						listaSintactica.add(this.Cadenizador(pilaSintactica)+":"+eleSintacticos.getLast()+":"+"Saltar");
						pilaSintactica.removeLast();
					}
					else
					{
						//No es Palabra Reservada -> terminador: No regresa ; Avance positivo
						listaSintactica.add(this.Cadenizador(pilaSintactica)+":"+eleSintacticos.getLast()+":"+"Error/Falta Elemento->"+pilaSintactica.getLast()+"/Fila:"+Datos.get(pos).getNum_Fila()+"/Elemento:"+Datos.get(pos).getNum_Elemento());
						pilaSintactica.removeLast();
					}
					
				}
			}
			
		}
	}
	
	private String Cadenizador(LinkedList<String> lista)
	{
		String cad="";
		for(String ele:lista)
		{
			cad=cad+ele+" ";
		}
		return cad;
	}
	
	private LinkedList<String> Listaneitor(String cad)
	{
		String[] ele;
		LinkedList<String> lista = new LinkedList<String>();
		ele =cad.split(" ");
		for(String T: ele)
			lista.addFirst(T);
		/*for(String T: lista)
			obd.Println(T);*/
		return lista;
	}
	
	public void Mostrar()
	{
		for(String ele:listaSintactica)
		{
			obd.Println(ele);
		}
	}
	
	public String PilaMovimientos()
	{
		String cad="";
		for(String ele:listaSintactica)
		{
			cad=cad+ele+"\n";
		}
		return cad;
	}//
	
	public static void main (String[]args)
	{
		 String matriz2[][] = {
			//id										num										(									)									litcad									litchar									+										-										*								/										<										>										<=										>=								!=										==										!										&										|								true									false									If										While									Repeat										Else									then									do										endif									endwhile								Programa																Int										Float									Char									String									Bool							,										Proc									Func									endp									endf							endfin									idp										idf										Retorna											$								++										--										;										:										=								until			ErrorLexico										
/*prog*/			{"#",										"#",									"#",								"#",								"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",										"#",									"#",									"#",									"#",									"#",									"Programa id ; dec modulos sentencias endfin",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#"				,"#"},
/*dec*/				{"",										"#",									"#",								"#",								"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"",										"",										"",											"#",									"#",									"#",									"#",									"#",									"#2",																	"Int id sigid ; dec",					"Float id sigid ; dec",					"Char id sigid ; dec",					"String id sigid ; dec",				"Bool id sigid ; dec",			"#",									"",										"",										"#",									"#",							"",										"#",									"#",									"#",									"#",							"#",									"#",									"",										"#",									"#",							"#"				,"#"},
/*modulos*/			{"",										"#",									"#",								"#",								"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"",										"",										"",											"#",									"#",									"#",									"#",									"#",									"#2",																	"#",									"#",									"#",									"#",									"#",							"#",									"proc modulos",							"fun modulos",							"#",									"#",							"",										"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#"				,"#"},
/*sentencias*/		{"sentencia sentencias",					"#",									"#",								"#1",								"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"sentencia sentencias",					"sentencia sentencias",					"sentencia sentencias",						"",										"#",									"#",									"",										"",										"#2",																	"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"",										"",								"",										"#",									"#",									"",										"#",							"#",									"#",									"#",									"#",									"#",							""				,"#"},
/*sigid*/			{"",										"#",									"#",								"#",								"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",										"#",									"#",									"#",									"#",									"#",									"#2",																	"#",									"#",									"#",									"#",									"#",							", id sigid",							"#",									"#",									"#",									"#",							"",										"#",									"#",									"#",									"#",							"#",									"#",									"",										"#",									"#",							"#"				,"#"},
/*sentencia*/		{"id = L ;",								"#",									"#",								"#",								"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"If L then sentencias sigif endif",		"While L do sentencias endwhile",		"Repeat sentencias until L ;",				"#",									"#",									"#",									"#",									"#",									"#2",																	"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"",										"#",									"",				 				"#"				,"#"},
/*sigif*/			{"#",										"#",									"#",								"#",								"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",										"Else sentencias",						"#",									"#",									"",										"#",									"#2",																	"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#"				,"#"},
/*proc*/			{"",										"#",									"",									"#",								"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",										"#",									"#",									"#",									"#",									"#",									"#2",																	"#",									"#",									"#",									"#",									"#",							"#",									"Proc id ( list-arg ) sentencias endp","#",									    "#",									"#",							"#",									"",										"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#"				,"#"},
/*fun*/				{"",										"#",									"",									"#",								"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",										"#",									"#",									"#",									"#",									"#",									"#2",																	"#",									"#",									"#",									"#",									"#",							"#",									"#",				 "Funcion id ( list-arg ) : tr sentencias return endf",     "#",									"#",							"#",									"#",									"",										"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#"				,"#"},
/*list-arg*/		{"",										"#",									"#",								"",									"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",										"#",									"#",									"#",									"#",									"#",									"#2",																	"Int id siglis",						"Float id siglis",						"Char id siglis",						"String id siglis",						"Bool id siglis",				"#",									"#", 									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#"				,"#"},
/*siglis*/			{"#",										"#",									"#",								"",									"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",										"#",									"#",									"#",									"#",									"#",									"#2",																	"#",									"#",									"#",									"#",									"#",							", list-arg",							"#", 									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"",										"#",							"#"				,"#"},
/*tr*/				{"#",										"#",									"#",								"#",								"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",										"#",									"#",									"#",									"#",									"#",									"#2",																	"Int",									"Float",								"Char",									"String",								"Bool",							"#",									"#", 									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#"				,"#"},
/*return*/			{"#00",										"#0",									"#0",								"#0",								"#0",									"#0",									"#0",									"#0",									"#0",							"#0",									"#0",									"#0",									"#0",									"#0",							"#0",									"#0",									"#0",									"#0",									"#0",							"#0",									"#0",									"#0",									"#0",									"#0",										"#0",									"#0",									"#0",									"#0",									"#0",									"#2",																	"#0",									"#0",									"#0",									"#0",									"#0",							"#0",									"#0", 									"#0",									"#0",									"#0",							"#0",									"#0",									"#0",									"Retorna L ;",							"#0",							"#0",									"#0",									"#0",									"#0",									"#0",							"#0"			,"#"},


/*L*/				{"R L1",                                    "R L1",		                           "R L1",				                "#",								"R L1",									"R L1",								    "#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"R L1",									"#",									"#",							"R L1",									"R L1",									"#",									"#",									"#",										"#",									"#",									"#",									"#",									"#",									"#2",																	"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"",										"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#"				,"#"},
/*L1*/				{"#",                                       "#",                                   "#",                                 " ",                                "#",		                            "#",                                    "#",                                    "#",									"#",						    "#"		      						   ,"#",									"#",									"#",									"#",						    "#",		         				    "#",									"! L",									"& R L1",								"| R L1",						"#",		   							"#",									"#",									"#",									"#",									    "#",		               	            " ",									" ",									"#",									" ",									"#2",		          												    "#",									"#",									"#",									"#",									"#",							"",									    "#",									"#",									"#",									"",								"",				 						"#",									"#",									"#",									" ",							"#",									"#",									" ",									"#",									"#"								," "			,"#"},
/*R*/				{"E R1",                                    "E R1",                                "E R1",                              "#",                                "E R1",		                            "E R1",                                 "#",									"#",									"#",						    "#"		                               ,"#",									"#",									"#",									"#",							"#",		          				    "#",									"#",									"#",									"#",							"E R1",		          					"E R1",									"#",									"#",									"#",									    "#",			                        "#",									"#",									"#",									"#",									"#2",		           		          							        "#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#"								,"#"			,"#"},
/*R1*/				{"#",                                       "#",                                   "#",                                 " ",                                "#",		                            "#",                                    "#",									"#",									"#",						    "#"		                               ,"< E",									"> E",									"<= E",									">= E",							"!= E",									"== E",									"",									    " ",									" ",							"#",		           	                "#",									"#",									"#",									"#",									    "#",		               	            " ",									" ",									"#",									" ",									"#2",		        	          								        "#",									"#",									"#",									"#",									"#",							"",									    "#",									"#",									"#",									"",								"",										"#",									"#",									"#",									" ",							"#",									"#",									" ",									"#",									"#"								," "			,"#"},
/*E*/				{"T E1",                                    "T E1",                                "T E1",                              "#",                                "T E1",		                            "T E1",                                 "#",									"#",									"#",						    "#"		                               ,"#",									"#",									"#",									"#",							"#",		           					"#",									"#",									"#",									"#",							"T E1",		           	                "T E1",									"#",									"#",									"#",									    "#",		        	                "#",									"#",									"#",									"#",									"#2",		           	          								        "#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#"								,"#"			,"#"},
/*E1*/				{"#",                                       "#",                                   "#",                                 " ",                                "#",		                            "#",                                    "+ T E1",							    "- T E1",								"#",						    "#"		                               ,"",									    "",									    "",									    "",							    "",		              				    "",									    "",									    " ",									" ",							"#",		              	            "#",				 					"#",									"#",									"#",									    "#",		        	                " ",									" ",									"#",									" ",									"#2",		           	          								        "#",									"#",									"#",									"#",									"#",							"",									    "#",									"#",									"#",									"",								"",										"#",									"#",									"#",									" ",							"#",									"#",									" ",									"#",									"#"								," "			,"#"},
/*T*/				{"F T1",                                    "F T1",                                "F T1",                              "#",                                "F T1",		                            "F T1",                                 "#",									"#",									"#",						    "#"		                               ,"#",									"#",									"#",									"#",							"#",		          			        "#",									"#",									"#",									"#",							"F T1",		          	                "F T1",									"#",									"#",									"#",									    "#",		          	                "#",									"#",									"#",									"#",									"#2",			          								                "#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#"								,"#"			,"#"},
/*T1*/				{"#",                                      	"#",                                  	"#",                                 " ",                                "#",		                            "#",                                   "",									    "",									    "* F T1",						"/ F T1"		                       ,"",									    "",									    "",									    "",							    "",		              			        " ",									" ",									" ",									" ",							"#",		          	           	    "#",									"#",									"#",									"#",									    "#",		        	                " ",									" ",									"#",									" ",									"#2",			          								                "#",									"#",									"#",									"#",									"#",							"",									    "#",									"#",									"#",									"",								"",										"#",									"#",									"#",									" ",							"#",									"#",									" ",									"#",									"#"								," "			,"#"},
/*F*/				{"id",                                      "num",                                 "( L )",                             "#",                                "litcad",		                        "litchar",                              "#",									"#",									"#",						    "#"		                               ,"#",									"#",									"#",									"#",							"#",		         					"#",									"#",									"#",									"#",							"true",		           	                "false",								"#",									"#",									"#",									    "#",		                            "#",									"#",									"#",									"#",									"#2",			          								                "#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#",							"#",									"#",									"#",									"#",									"#"								,"#"			,"#"},

};
		
		 String valoresCol[] = {"id","num","(",")","litcad","litcar","+","-","*","/","<",">","<=",">=","!=","==","!","&","|","true","false",
					"If","While","Repeat","Else","then","do","endif","endwhile","Programa","Int","Float","Char","String","Bool",",","Proc","Funcion","endp","endf","endfin","idp","idf","Retorna","$","++","--",";",":","=","until","ErrorLexico"},//VALORES DE BUSQUEDA COLUMNAS
					//valoresReb[] = {"prog","dec","sigid","modulos","proc","fun","tiporetorno","list-arg","siglist","list-param","sig-param","sentencias","sentencia","sigif","asigna","L","L1","R","R1","E","E1","T","T1","F"};//VALORES DE BUSQUEDA RENGLONES
					valoresReb[] = {"prog","dec","modulos","sentencias","sigid","sentencia","sigif","proc","fun","list-arg","siglis","tr","return","L","L1","R","R1","E","E1","T","T1","F"},//VALORES DE BUSQUEDA RENGLONES
					lenguaje[]= {"Programa","endfin","Int","Float","Char","String","Bool","Proc","endp","Funcion","endf","If","endif","While","endwhile","Repeat","until","Else","Retorna",",",";",":","=","++","--","then","do","(",")","==","+","-","*","/"};//PALABRAS RESERVADAS
					//valoresRebExc[] = {"modulos"};
		 
		Gen_Automata oba = new Gen_Automata();
		oba.setPalabraReservadas(lenguaje);
		oba.setTablaLogica(matriz2);
		oba.setColumnas(valoresCol);
		oba.setRenglones(valoresReb);
		/*oba.Separar("Programa id ;\n Float f , f1 ; Int i ; i = i + 5 ; \n Proc idproc ( Int var , Bool ban ) endp\n Funcion idfun ( Int var ) : Int Retorna 5 ; endf"
				+ "\n f = 3.14 ; If 5 == 5 then If 5 == 5 then endif endif While 5 == 5 do If 5 == 5 then endif endwhile Repeat If 5 == 5 then endif until 20 ; \nendfin");
		*/
		oba.Separar("i Programa id ; endfin");
		oba.Evaluar();
		oba.Mostrar();
	}
}
