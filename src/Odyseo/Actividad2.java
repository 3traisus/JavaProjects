package Odyseo;

import lib20.Datos;
import lib20.Menu;

public class Actividad2
{
	private String cad;
	private String expresion=("[a-z]*"), exp2,expf;
	
	private String universe="";
	private int est=0,finales[];
	private String transiccion[];
	
	
	private Datos obd = new Datos(); 
	private int x=0,y=0,con;
	
	public Actividad2()
	{
		this.Universo();
		this.Estados();
		this.Finales();
		transiccion = new String[est*est];
		obd.Println(universe);
		this.Trans();
	}
	
	private boolean Permite(String exp)
	{
		return cad.matches(exp);
	}
	
	private boolean Rep()
	{
		for(x=0;x<cad.length();x++)
			if(cad.substring(x+1).contains(cad.charAt(x)+""))
				break;
		return x<cad.length();
	}
	private void Universo()
	{
		do
			cad = obd.Cadena("Dame las letras del universo");
		while(!this.Permite(expresion) || this.Rep() || cad.isEmpty());
		for(x=0;x<cad.length();x++)
		{
			if(x==0)
			{
				universe+="(";
			}
			universe+="["+cad.charAt(x)+"]?";
			if(x==cad.length()-1)
				universe+=")";	
		}
		//universe= "(["+cad.charAt(0)+"]?["+cad.charAt(1)+"]?["+cad.charAt(2)+"]?)"; //modificar para que jale con cualquier universo
	}
	
	private void Finales()
	{
		do
			cad = obd.Cadena("Dame los estados finales");
		while(!this.Permite(exp2));
		finales = new int [cad.length()];
		for(x=0;x<finales.length;x++)
			finales[x]= Integer.parseInt(cad.charAt(x)+"");
	}
	
	private void Trans()
	{
		con=0;
		for(x=0;x<est;x++)
		{
			for(y=0;y<est;y++)
			{
				do
					cad = obd.Cadena("Dame las letras de la transiccion ["+x+"]["+y+"]");
				while(!this.Permite(universe)||cad.isEmpty());
				transiccion[con++]=cad;
			}
		}		
	}
	
	private void Construir()
	{
		
	}
	
	private void Estados()
	{
		do
			est = obd.Entero("Dame la cantidad de estados");
		while(est<1);
		exp2=("[0-"+(est-1)+"]*");
	}
 
	public void Mostrar()
	{
		con=0;
		obd.Println(universe);
		for(x=0;x<finales.length;x++)
			obd.Println(finales[x]+"");
		for(x=0;x<est;x++)
		{
			for(y=0;y<est;y++)
			{
				obd.Println("["+x+"]["+y+"]:"+transiccion[con++]);
			}	
		}
	}
	
	public static void main(String[] args)
	{	
		int op;
		Menu obm;
		obm = new Menu("Actividad2", new String[] {"Validar Cadena"});
		
		Actividad2 ob;
		
		do
			switch(op=obm.Opcion())
			{
				case 1:
					ob = new Actividad2();
					ob.Mostrar();
			}
		while(op!=obm.Salir());
		
	}
}
