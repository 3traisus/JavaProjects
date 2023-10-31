package Tema_1.A11;

import lib20.*;

public class InvertarioP
{

	public static void main(String[] args)
	{
		Datos obd = new Datos();
		Menu obm = new Menu("Inventario",
				new String[] { "Cantidad", "Nuevo", "Consulta", "Buscar", "Modificar", "Eliminar", "Inversion" });
		int op;
		Inventario inv = null;
		do
		{
			switch (op = obm.Opcion())
			{
			case 1:
				inv = new Inventario();
				break;
			case 2:
				if (inv != null)
				{
					obd.Println("Agregar Producto");
					inv.Agregar();
				}
				else
					obd.Println("Ingresa en la opcion 1");
				break;
			case 3:
				if (inv != null)
				{
					obd.Println("Lista Productos");
					inv.Consulta();
				}
				else
					obd.Println("Ingresa en la opcion 1");
				break;
			case 4:
				if (inv != null)
					inv.Buscar();
				else
					obd.Println("Ingresa en la opcion 1");
				break;
			case 5:
				if (inv != null)
					inv.Modificar();
				else
					obd.Println("Ingresa en la opcion 1");
				break;
			case 6:
				if (inv != null)
					inv.Eliminar();
				else
					obd.Println("Ingresa en la opcion 1");
				break;
			case 7:
				if (inv != null)
				{
					obd.Println("Inversion Total..." + inv.Inversion());
				}
			}
		}
		while (op != obm.Salir());
	}

}
