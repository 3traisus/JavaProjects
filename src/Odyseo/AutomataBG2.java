package Odyseo;

import lib20.Datos;
import lib20.Menu;

public class AutomataBG2
{
	private Datos obd = new Datos(); 
	private String
		expUni=("[a-z]*"),
		expFin,
		expTot,
		expEst,
		universe="";
	private int transiccion[][];
	
	private boolean Rep(String cad)
	{
		int x;
		for(x=0;x<cad.length();x++)
			if(cad.substring(x+1).contains(cad.charAt(x)+"") || cad.contains(" "))
				break;
		return x<cad.length();
	}
	
	public void Universo()
	{
		String universo;
		do
			universo = obd.Cadena("Dame los datos");
		while(!universo.matches(expUni) | this.Rep(universo));		
		universe = universo;
	}
	
	public void Estados()
	{
		int x;
		do
			x = obd.Entero("Dame la cantidad de estados");
		while(x<1 | x>9);		
		expEst = ("[0-"+(x-1)+"]*");
		expTot=("\\-[1]|[0-"+(x-1)+"]");
		transiccion = new int[x][universe.length()];
		//expEst = ("\\-[1-2]");
	}
	
	public void Finales()
	{
		String universo;
		do
			universo = obd.Cadena("Dame los Estados Finales");
		while(!universo.matches(expEst) | this.Rep(universo));
		expFin = universo;
	}

	public void Trans()
	{
		int y,res,x;
		for(x=0;x<transiccion.length;x++)
		{
			for(y=0;y<transiccion[x].length;y++)
			{
				do
					res = obd.Entero("Dame la transiccion ["+x+"]["+y+"]");
				while(!(res+"").matches(expTot));
				transiccion[x][y]=res;
			}
		}		
	}
	
	
	public void Generar()
	{
		String cad;
		int x,con=0;
		
		
		cad = obd.Cadena("Dame la cadena");
		int car=0;
		for(x=0;x<cad.length();x++) 
		{
			car=universe.indexOf(cad.charAt(x));
			if(car!=-1)
			{
				con=transiccion[con][car];	
		
			  if(con==-1)
			  {
				  obd.Println("No aceptada por estado de rechazo");
				  return;
			  }
			  if(con==-2)
			  {
				  obd.Println("No aceptada por inexistencia");
				  return;
			  }
			}
			else
			{
				obd.Println("No aceptada");
				  return;
			}
			
		}
		if(expFin.contains(con+""))
		{
			obd.Println("Cadena acepta");
		}
		else
			obd.Println("No aceptada por no finalizar en estado final");
	}

	public static void main (String[]args)
	{
		int op;
		Menu obm;
		obm = new Menu("Actividad2", new String[] {"Tabla Transicciones","Validar Cadena"});
		
		AutomataBG2 oba = new AutomataBG2();
		oba.Universo();
		oba.Estados();
		oba.Finales();
		do
			
			switch(op=obm.Opcion())
			{
				case 1:
					oba.Trans();
					break;
				case 2:
					oba.Generar();
					break;
				/*case 2:
					oba.Pila();*/
		}
		while(op!=obm.Salir());
		
	}
}
