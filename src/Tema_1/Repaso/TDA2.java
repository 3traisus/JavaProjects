package Tema_1.Repaso;

import lib20.Datos;
import lib20.Menu;

public class TDA2
{
	private Datos obd = new Datos();
	private int tar,sueld;
	private String nom,puesto;
	
	public TDA2()
	{
		do
			tar = obd.Entero("Numero de tarjeta =");
		while(tar<0);
		nom = obd.Cadena("Nombre =");
		puesto = obd.Cadena("Puesto =");
		do
			sueld = obd.Entero("Sueldo =");
		while(sueld<0);
	}
	
	public void Mostrar()
	{
		System.out.println(tar+"\t"+nom+"\t"+puesto+"\t"+sueld);
	}
	
	public void Modificar()
	{
		int op;
		Menu obm = new Menu("Dato a Modificar", new String[] {"Nombre","Puesto","Sueldo"});
		do
		{
			switch(op=obm.Opcion())
			{
				case 1:
					nom = obd.Cadena("Nombre =");
					break;
				case 2:
					puesto = obd.Cadena("Puesto =");
					break;
				case 3:
					do
						sueld = obd.Entero("Sueldo =");
					while(sueld<0);
			}
			if(op!=obm.Salir())
				obd.Println("Dato Modificado");
		}
		while(op!=obm.Salir());
	}
	
	public int Clave()
	{
		return tar;
	}
}
