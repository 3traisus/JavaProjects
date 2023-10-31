package Tema_1.A12;

import lib20.Datos;

public class InventarioM
{
	private int ind;
	private Inventario list[];
	private Datos obd = new Datos();
	
	public InventarioM()
	{
		do
			ind = obd.Entero("Cantidad de productos");
		while (ind < 0);
		list = new Inventario[ind];
		ind = -1;
	}

	public void Agregar()
	{
		int por;
		try
		{
			if ((ind + 1) < list.length)
			{
				list[++ind] = new Inventario();
				list[ind].setClv(obd.Cadena("Clave Producto"));
				list[ind].setNom(obd.Cadena("Nombre Producto"));
				list[ind].setEx(obd.Entero("Existencia"));
				list[ind].setComp(obd.Doble("Precio de Compra"));
				por = obd.Entero("Porcentaje de ganancia %20-%50");
				list[ind].setPor((por>50)? 50:por);
				list[ind].Calc();
			}
			else
			{
				Inventario temp[];
				temp = list;
				list = new Inventario[(ind + 4)];
				for (int x = 0; x < temp.length; x++)
					list[x] = temp[x];
				obd.Println("Vector lleno... Se han agregado posiciones extra");
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
			for (int x = 0; x < ind+1; x++)
				list[x].Mostrar();
	}

	public void Buscar()
	{
		if (ind > -1)
		{
			int x = 0;
			String ele = obd.Cadena("Clave a Buscar");
			for (; x < ind+1; x++)
				if (list[x].getClv().contains(ele))
				{
					obd.Println("Se encontro");
					list[x].Mostrar();
					break;
				}
			if (x == ind+1)
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
			for (; x < ind+1; x++)
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
			if (x == ind+1)
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
			for (; x < ind+1; x++)
				if (list[x].getNom().contains(ele))
					break;
			Inventario temp[]= new Inventario[ind+1];
			temp = list;
			list = new Inventario[(list.length-1)];
			for (int y = 0; y < temp.length; y++)
			{
				if (y < x)
					list[y] = temp[y];
				else if (y > x)
					list[y - 1] = temp[y];
				else
				{
					obd.Println("Eliminado");
					ind--;
				}
					

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
