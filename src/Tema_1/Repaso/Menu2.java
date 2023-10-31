package Tema_1.Repaso;

import lib20.Datos;
import lib20.Menu;

public class Menu2
{

	public static void main(String[] args)
	{
		Datos obd = new Datos();
		Menu obm = new Menu("Repaso TDA-Normal",
				new String[] { "Cantidad", "Nuevo", "Consulta", "Buscar", "Modificar", "Eliminar" });
		int op;
		MT2 inv = null;
		do
		{
			switch (op = obm.Opcion())
			{
				case 1:
					inv = new MT2();
					break;
				case 2:
					if (inv != null)
					{
						obd.Println("Agregar");
						inv.Nuevo();
					}
					else
						obd.Println("Ingresa en la opcion 1");
					break;
				case 3:
					if (inv != null)
					{
						obd.Println("Consulta");
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
			}
		}
		while (op != obm.Salir());

	}
}
