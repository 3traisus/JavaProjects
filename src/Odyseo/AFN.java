package Odyseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lib20.Datos;

public class AFN	
{
	private BufferedReader obb=new BufferedReader(new InputStreamReader(System.in));
	private String alfabeto,cadena;
	Datos obd =new Datos();
	private int AFD[][],est,fin,ini=0,col,actual,pos,vec[];
	private boolean Pertenece,Aceptacion;
	boolean ban;
	
	private boolean permite()
	{
		int x;
		for(x=0;x<alfabeto.length();x++)
			if(alfabeto.substring(x+1).contains(alfabeto.charAt(x)+""))
				break;
		return x<alfabeto.length();
	}
	public void Alfabeto()
	{  
		do
			alfabeto=obd.Cadena("Alfabeto");//Insertar el alfabeto	
		while(alfabeto.isEmpty()||this.permite());
	    Pattern patron = Pattern.compile("[A-Z]*|[a-z]*");
	    Matcher regular = patron.matcher(alfabeto);
	    if (regular.matches())
	    {//Controla el numero de estados
	    	try
			{ 			
				do
				{
					System.out.println("Num Estados");//Dame el numero de estados
					est=Integer.parseInt(obb.readLine());
				}
				while(est<=0 || est>10);
			}
			catch (IOException e)
			{
				System.out.println("error en el dispositivo");
			}
			catch (NumberFormatException e)
			{
				System.out.println("Solo datos numericos");
			}
	    	
	    	//controla el estado final o de aceptacion
	    	try
			{ 			
				do
				{
					System.out.println("Estados Finales Hay");// Cuantos Estados finales hay
					fin=Integer.parseInt(obb.readLine());
				}
				while(fin>=est+1 || fin<=0);
			}
			catch (IOException e)
			{
				System.out.println("error en el dispositivo");
			}
			catch (NumberFormatException e)
			{
				System.out.println("Solo datos numericos");
			}
	    	vec=new int[fin];
	    	System.out.println("Dame los " + vec.length + " estados finales");
			for (int ind = 0; ind < vec.length; ind++)
				vec[ind] = obd.Entero((ind + 1) + ".-");
			for (int ind = 0; ind < vec.length; ind++)
			{
				if(vec[ind]==0)
					ban=true;
			}
	    	System.out.println();
	    	System.out.println("Alfabeto= "+alfabeto);
	    	System.out.println("Q= "+est);
    		System.out.println("q0= "+ini);
    		System.out.print("F= ");
    		for (int ind = 0; ind < vec.length; ind++)
    			System.out.print("[ " + vec[ind] + " ]");
    		System.out.println();
	    }
	    else
	    {
	    	System.out.println("alfabeto NO VALIDO... tiene que ser en el rango [a-z] [A-Z]");
	    }
	}
	public void Tabla()
	{
		//Comenzar a construir la matriz
		System.out.println("Llena la tabla de transiciones");
		col=alfabeto.length();
		AFD=new int[est][col];
		for(est=0;est<AFD.length;est++)
			  for(col=0;col<AFD[est].length;col++)
				  AFD[est][col]=obd.Entero("[ "+est+" ][ "+col+" ].-");
		
		System.out.println("Contenido de la tabla de transiciones...");
		  for(est=0;est<AFD.length;est++)
		  {
			  for(col=0;col<AFD[est].length;col++)
				  System.out.print(AFD[est][col]+"\t");
		          System.out.println();
		  }
	}
	public String Cadena(String cad)
	{
		actual=0;
		pos=0;
		cadena=cad;
		if(cadena.equalsIgnoreCase(""))
		{
			actual=vec[0];
			if(actual==0){  //Cadena Vacia Valida
		}
		if(cadena.compareToIgnoreCase("")==0 && ban)
		{ //Cadena Vacia Invalida
			System.out.println("La cadena "+cadena+" fue ACEPTADA por el automata");
			}
		}
		else 
		{ //2Do Paso Cadena No Vacia
			//actual=ini;
			for (int i = 0; i < cadena.length(); i++) 
			{
				Pertenece=false;
				Aceptacion=false;
				for (int j = 0; j < alfabeto.length(); j++)
				{
					if(alfabeto.charAt(j)==cadena.charAt(i)) //Verificar si existe en cabecera
					{
						Pertenece=true;
						pos=j;
					}
				}
				if(Pertenece) 
				{ //validar si Pertenece el caracter al alfabeto
					//Tomar Valor de el estado y verificar estado de error
					actual=AFD[actual][pos];
					if(actual==-1)
					{
						return("La cadena tiene se fue a estado de error en la posicion "+(i+1));
					}
				}
				if(!Pertenece) //No pertenece el caracter al alfabeto 
				{
					return("El Caracter \""+cadena.charAt(i)+"\" no pertenece al alfabeto. ");
				}
			}			
			for (int i = 0; i < vec.length; i++) 
			{
				if(actual==vec[i])
					Aceptacion=true;
				}
			if(Aceptacion)
				return("La cadena "+cadena+" fue ACEPTADA por el automata");
			else
				return("La cadena "+cadena + " fue RECHAZADA por que no termina en el estado final");
			
			}
		return cad;
	}
	
	public static void main(String args[])
	{ 
		AFN oba=new AFN();
	    oba.Alfabeto();
	    oba.Tabla();
	   // Interfa obd=new Interfa();
	    //obd.setVisible(true);
	}
}