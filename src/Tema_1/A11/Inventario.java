package Tema_1.A11;

import Tema_1.Trabajador;
import lib20.Datos;

public class Inventario
{
	Datos obd = new Datos();
	private int ind;
	private InventarioM list[];

	public Inventario()
	{
		do
			ind = obd.Entero("Cantidad de productos");
		while (ind < 0);
		list = new InventarioM[ind];
		ind = -1;
	}

	public void Agregar()
	{
		try
		{
			if ((ind + 1) < list.length)
			{
				list[++ind] = new InventarioM();
				list[ind].setClv(obd.Cadena("Clave Producto"));
				list[ind].setNom(obd.Cadena("Nombre Producto"));
				list[ind].setEx(obd.Entero("Existencia"));
				list[ind].setComp(obd.Doble("Precio de Compra"));
				list[ind].setPor(obd.Entero("Porcentaje de ganancia"));
				list[ind].Calc();
			}
			else
			{
				InventarioM temp[];
				temp = list;
				list = new InventarioM[(ind + 2)];
				for (int x = 0; x < temp.length; x++)
					list[x] = temp[x];
				list[++ind] = new InventarioM();
				list[ind].setClv(obd.Cadena("Clave Producto"));
				list[ind].setNom(obd.Cadena("Nombre Producto"));
				list[ind].setEx(obd.Entero("Existencia"));
				list[ind].setComp(obd.Doble("Precio de Compra"));
				list[ind].setPor(obd.Entero("Porcentaje de ganancia"));
				list[ind].Calc();
			}
		}
		catch (NumberFormatException e)
		{
			obd.Println("Error de formato");
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
			String ele = obd.Cadena("Clave a Buscar");
			for (; x < list.length; x++)
				if (list[x].getClv().contains(ele))
				{
					obd.Println("Se encontro");
					list[x].Mostrar();
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
			String ele = obd.Cadena("Clave a Modificar");
			for (; x < list.length; x++)
				if (list[x].getClv().contains(ele))
				{
					list[x].setClv(obd.Cadena("Clave Producto"));
					list[x].setNom(obd.Cadena("Nombre Producto"));
					list[x].setEx(obd.Entero("Existencia"));
					list[x].setComp(obd.Doble("Precio de Compra"));
					list[x].setPor(obd.Entero("Porcentaje de ganancia"));
					list[x].Calc();
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
			String ele = obd.Cadena("Clave a Eliminar");
			for (; x < list.length; x++)
				if (list[x].getNom().contains(ele))
					break;
			InventarioM temp[];
			temp = list;
			list = new InventarioM[(ind--)];
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

	public double Inversion()
	{
		double inv = 0;
		for (int x = 0; x < list.length; x++)
			inv += list[x].getComp() * list[x].getEx();
		return inv;
	}

}
