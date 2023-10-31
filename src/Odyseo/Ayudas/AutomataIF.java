package Odyseo.Ayudas;

import java.util.LinkedList;

import lib20.Datos;

public class AutomataIF
{
	private Datos obd = new Datos();
	private LinkedList<String> entrada = new LinkedList<String>();
	private String [] 
			inciales = new String[] {"Si","tip_dato"},reservadas= new String[] {"SENTENCIAS","COND","VALOR"},
			SI = new String[] {"Si","(","COND",")","{","SENTENCIAS","}"},SIerror = new String[] {"","P:Abierto_error/","","P:Cerrado_error/","L:Abierto_error/","","L:Cerrado_error/"},
			DEC = new String[] {"tip_dato","id",";"},
				COND = new String[] {"VALOR", "op_log", "VALOR"},CondError = new String[] {"","Op:logico",""},
					VALOR = new String[] {"id","num"};
			/*Asigna = new String[] {""},
			Para = new String[] {""},
			Imprime = new String[] {""},*/
	private String Error="";
	private int indice =0;
	
	public void Separar(String txt)
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
		entrada.addAll(LisTemp);//Entrada user es la pila como la entro el usuario		
	}
	
	public void mostrarPilas()
	{
		System.out.println("Mostrar");
		for(int x = 0; x<entrada.size();x++)
			System.out.println(entrada.get(x));
	}
	
	public void Final()
	{
		obd.Println(indice+"/"+entrada.size());
		if(indice<entrada.size())
		{
			Error = Error + "Llave de Cerrado Sobrante \n";
			obd.Println(Error);
		}
		else
		{
			if(Error.isEmpty())
			{
				obd.Println("Congratulation");
			}
			else
			{
				obd.Println(Error);
			}
		}
	}
	
	public void SENTENCIAS()
	{
		int x;
		while(indice<entrada.size())
		{
			for(x=0;x<inciales.length && !inciales[x].equals(entrada.get(indice));x++);
			if(x<inciales.length)
			{
				if(entrada.get(indice).equals("Si"))
				{
					//indice += this.AutoIF();
					this.AutoIF();	
					continue;
				}
				else
				if(entrada.get(indice).equals("tip_dato"))
				{
					
				}
				
			}
			else
				if(entrada.get(indice).equals("}"))
				{
					//obd.Println("Inicio:"+indice+"/"+entrada.get(indice));
					break;
				}
				else
				{
					//obd.Println("Einicio:"+indice+"/"+entrada.get(indice));
					Error = Error + "No se encontro ningun bloque valido:"+indice+"\n";
				}
			indice++;//estamos checando los indices ojo;
		}
	}
		
	private void AutoIF() 
	{
		int ind=0,x;
		while(ind<SI.length)
		{
			if(indice<entrada.size())
			{
				for(x=0;x<reservadas.length && !reservadas[x].equals(SI[ind]);x++);
				if(x<reservadas.length)
				{
					if(reservadas[x].equals("COND"))
					{
						//indice += this.Cond();
						this.Cond();
						ind++;
						continue;
					}
					else
					if(reservadas[x].equals("SENTENCIAS"))
					{
						this.SENTENCIAS();
						ind++;
						continue;
					}
				}
				else
				{
					if(indice<entrada.size())
					{
						if(!SI[ind].equals(entrada.get(indice)))//indice+ind
						{
							//obd.Println("E:if"+indice+"/"+entrada.get(indice));
							Error = Error + SIerror[ind] +indice+"\n";
							ind++;
							continue;
						}
						/*else
							obd.Println("If"+indice+"/"+entrada.get(indice));*/
					}
					else
					{
						Error = Error +"Llave de cierre final faltante:"+indice+"\n";
					}
						
				}
					
				indice++;
				ind++;
			}
			else
			{
				//if(Error.isBlank())
				{
					Error = Error +"Elementos faltantes \n";
					for(;ind<SI.length;ind++)
					{
						if(SI[ind].equals("COND"))
						{
							for (int y=0;y<COND.length;y++)
							{
								if(COND[y].equals("VALOR"))
								{
									Error = Error +"num|id ->";
								}
								else
								{
									Error = Error +COND[y]+"->";
								}
							}
						}
						else
						{
							Error = Error +SI[ind]+"->";
						}
					}
					Error = Error +"\n";
				}	
				return;
			}
		}
		//return ind;
	}
	
	private void Cond()
	{
		int ind=0,x;
		while(ind<COND.length)
		{
			if(indice<entrada.size())
			{
				for(x=0;x<reservadas.length && !reservadas[x].equals(COND[ind]);x++);
				if(x<reservadas.length)
				{
					//indice +=this.Valor();
					this.Valor();
					ind++;
					continue;
				}
				else
				{
					if(!COND[ind].equals(entrada.get(indice)))//indice+ind
					{
						//obd.Println("E:Cond"+indice+"/"+entrada.get(indice));
						Error = Error + CondError[ind] +indice+"\n";
						//Error = Error + "Se esperaba un operador Logico:"+indice+"\n";
						ind++;
						continue;
					}
					//else
						//obd.Println("Cond"+indice+"/"+entrada.get(indice));
					
				}
				indice++;
				ind++;
			}
			else
			{
				if(Error.isBlank())
				{
					Error = Error +"Elementos faltantes \n";
					for(;ind<COND.length;ind++)
					{
						if(COND[ind].equals("VALOR"))
						{
							Error = Error +"num|id ->";
						}
						else
						{
							Error = Error +COND[ind]+"->";
						}
						
					}
					Error = Error +"\n";
					
				}	
				return;
			}
			
		}
		//return ind;
	}
	
	private void Valor()
	{
		int x;
		if(indice<entrada.size())
		{
			for(x=0;x<VALOR.length && !VALOR[x].equals(entrada.get(indice));x++);
			if(x>=VALOR.length)
			{
				//obd.Println("E:Val"+indice+"/"+entrada.get(indice));
				Error = Error + "Se esperaba Un numero o una id:"+indice+"\n";
			}
			//else
				//obd.Println("val"+indice+"/"+entrada.get(indice));
		}else
		{
			Error = Error +"Elementos faltantes \n";
			Error=Error +"id|num";
			Error = Error +"\n";
		}
		
		indice++;
		//return 1;
	}
	
	public static void main (String[]args)
	{
		AutomataIF oba = new AutomataIF();
		//oba.Separar("Si ( id op_log num ) { Si ( id op_log num ) {   } }");
		oba.Separar("Si Si");
		oba.mostrarPilas();
		oba.SENTENCIAS();
		oba.Final();

	}
}