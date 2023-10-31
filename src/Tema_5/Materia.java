package Tema_5;

import lib20.Datos;
import lib20.Menu;

public class Materia
{
	private int clave, creditos, plan;
	private String nombre;
	private Datos obd = new Datos();

	public Materia(int clave)
	{
		System.out.println("Escribe los datos de la materia:");
		this.clave = clave;
		System.out.println("Clave: " + clave);
		do
			nombre = obd.Cadena("Nombre: ").toUpperCase();
		while (nombre.isBlank());
		do
			creditos = obd.Entero("Créditos: ");
		while (creditos < 2 || creditos > 8);
		do
			plan = obd.Entero("Plan: ");
		while (plan < 2000);
	}

	public void Mostrar()
	{
		System.out.println(clave + "\t" + nombre + "\t" + creditos + "\t" + plan);
	}

	public void Modificar()
	{
		int op;
		Menu obm = new Menu("Modificaciones", new String[] { "Nombre", "Créditos", "Plan" });
		do

			switch (op = obm.Opcion())
			{
				case 1:
					do
						nombre = obd.Cadena("Nuevo nombre: ").toUpperCase();
					while (nombre.isBlank());
					break;
				case 2:
					do
						creditos = obd.Entero("Nuevos créditos: ");
					while (creditos < 2 || creditos > 8);
					break;
				case 3:
					do
						plan = obd.Entero("Nuevo plan: ");
					while (plan < 2000);
			}
		while (op != obm.Salir());
	}

	public int Clave()
	{
		return clave;
	}

	public String Nombre()
	{
		return nombre;
	}
}