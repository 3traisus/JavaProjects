package Tema_1;

import lib20.*;

public class TrabajadorDina
{
	Datos obd = new Datos();
	private int ind;
	private Trabajador list[];

	public TrabajadorDina()
	{
		do
			ind = obd.Entero("Numero de trabajadores");
		while (ind < 0);
		list = new Trabajador[ind];
		ind = -1;
	}

	public void Agregar()
	{
		if ((ind + 1) < list.length)
		{
			list[++ind] = new Trabajador();
			list[ind].setNom(obd.Cadena("Dame tu nombre"));
			list[ind].setPuesto(obd.Cadena("En q puesto Trabajas"));
			list[ind].setTarjeta(obd.Entero("Numero Tarjeta"));
			list[ind].setSueld(obd.Doble("Sueldo"));
		}
		else
		{
			Trabajador temp[];
			temp = list;
			list = new Trabajador[(ind + 2)];
			for (int x = 0; x < temp.length; x++)
				list[x] = temp[x];
			list[++ind] = new Trabajador();
			list[ind].setNom(obd.Cadena("Dame tu nombre"));
			list[ind].setPuesto(obd.Cadena("En q puesto Trabajas"));
			list[ind].setTarjeta(obd.Entero("Numero Tarjeta"));
			list[ind].setSueld(obd.Doble("Sueldo"));

		}
	}

	public void Consulta()
	{
		if (ind > -1)
			for (int x = 0; x < list.length; x++)
				list[x].Mostrar();
	}

	public void Buscar()
	{
		if (ind > -1)
		{
			int x = 0;
			String ele = obd.Cadena("Nombre a Buscar");
			for (; x < list.length; x++)
				if (list[x].getNom().contains(ele))
				{
					obd.Println("Se encontro");
					break;
				}
			if (x == list.length)
			{
				obd.Println("No se encontro");
			}
		}
		else
			obd.Println("Agrega Elementos a la lista");
	}

	public void Modificar()
	{
		if (ind > -1)
		{
			int x = 0;
			String ele = obd.Cadena("Nombre a Modificar");
			for (; x < list.length; x++)
				if (list[x].getNom().contains(ele))
				{
					list[x].setNom(obd.Cadena("Nombre Modificado"));
					list[x].setPuesto(obd.Cadena("Puesto Modificado"));
					list[x].setTarjeta(obd.Entero("Tarjeta Modificada"));
					list[x].setSueld(obd.Doble("Sueldo Modificado"));
					break;
				}
			if (x == list.length)
			{
				obd.Println("No se encontro");
			}
		}
		else
			obd.Println("Agrega Elementos a la lista");
	}

	public void Eliminar()
	{
		if (ind > -1)
		{
			int x = 0;
			String ele = obd.Cadena("Nombre a Eliminar");
			for (; x < list.length; x++)
				if (list[x].getNom().contains(ele))
					break;
			Trabajador temp[];
			temp = list;
			list = new Trabajador[(ind--)];
			for (int y = 0; y < temp.length; y++)
			{
				if (y < x)
					list[y] = temp[y];
				else if (y > x)
					list[y - 1] = temp[y];
				else
					obd.Println("Eliminado");

			}
		}
		else
			obd.Println("Agrega Elementos a la lista");
	}

}
