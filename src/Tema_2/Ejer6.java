package Tema_2;

import lib20.Datos;

public class Ejer6
{
	private double ini;
	private Datos obd = new Datos();
	
	public Ejer6()
	{
		do
			ini= obd.Entero("Monto inicial");
		while(ini<1);
	}
	
	
}
