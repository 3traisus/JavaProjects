package Tema_3;

import lib20.Datos;
import lib20.Menu;

public class Trabajador
{
	private int tarjeta;
	private String nom;
	private double sueld;
	private Datos obd = new Datos();
	
	public Trabajador(int tarjeta)
	{
		obd.Println("Datos Trabajador");
		this.tarjeta = tarjeta;
		obd.Println("Numero de tarjeta"+ tarjeta);
		do
			nom =obd.Cadena("Nombre").toUpperCase();
		while(nom.isBlank());
		do
			sueld = obd.Doble("Sueldo");
		while(nom.isBlank());
		
	}
	
	public void Mostrar()
	{
		obd.Println("Tarjeta:"+tarjeta+"Nombre:"+nom+"Sueldo"+sueld);
	}
	
	public int TarClv()
	{
		return tarjeta;
	}
	
	public void Modificar()
	{
		int op;
		Menu obm = new Menu("Modificar", new String[] {"Nombre","Sueldo"});
		do
			switch(op=obm.Opcion())
			{
				case 1:
					do
						nom = obd.Cadena("Nuevo Nombre").toUpperCase();
					while(nom.isBlank());
					obd.Println("");
					break;
				case 2:
					do
						sueld = obd.Doble("Nuevo Sueldo");
					while(sueld<1);
					obd.Println("");
			}while(op!=obm.Salir());
	}
}
