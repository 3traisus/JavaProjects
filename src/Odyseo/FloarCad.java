package Odyseo;


import lib20.Datos;
import lib20.Menu;

public class FloarCad 
{
	private String expresion=("-?([1-9][0-9]*|0)\\.(([0-9]*[1-9])|0)([Ee][+-][1-9][0-9]*)?");
	private String cad;
	private Datos obd = new Datos(); 
	
	public void Lectura()
	{
		do
			cad = obd.Cadena("Dame un numero flotante");
		while(!this.Permite());
		obd.Println("Cadena aceptada");
	}
	
	private boolean Permite()
	{
		return cad.matches(expresion) && (!cad.equals("-0.0"));
	}
	/*public String ValorFloat()
	{
		return cad;
	}*/ 
	public void Mostrar()
	{
		obd.Print(cad);
	}
	
	public static void main(String[] args)
	{	
		int op;
		Menu obm;
		obm = new Menu("Cadenas Flotantes", new String[] {"Validar Cadena"});
		
		FloarCad ob = new FloarCad();
		
		do
			switch(op=obm.Opcion())
			{
				case 1:
					ob.Lectura();
			}
		while(op!=obm.Salir());
		
	}
	
}
