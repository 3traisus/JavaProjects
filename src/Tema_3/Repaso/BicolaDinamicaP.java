package Tema_3.Repaso;

import lib20.Datos;
import lib20.Menu;

public class BicolaDinamicaP
{

	public static void main(String[] args)
	{
		Datos obd = new Datos();
		Menu obm = new Menu("Repaso BicolaDinamica-TDA",
				new String[] {"InsertarIni","InsertarFin", "Recorrido","ExtraerIni","ExtraerFin", "Buscar", "Modificar", "Borrar" });
		int op;
		BicolaDinamica inv = new BicolaDinamica();
		do
		{
			switch (op = obm.Opcion())
			{
				case 1:
					if (inv != null)
					{
						obd.Println("Agregar");
						inv.InsertarIni();
					}
					else
						obd.Println("Ingresa en la opcion 1");
					break;
				case 2:
					if (inv != null)
					{
						obd.Println("Agregar");
						inv.InsertarFin();
					}
					else
						obd.Println("Ingresa en la opcion 1");
					break;
				case 3:
					if (inv != null)
					{
						obd.Println("Recorrido");
						inv.Recorrido();
					}
					else
						obd.Println("Ingresa en la opcion 1");
					break;
				case 4:
					if (inv != null)
					{
						obd.Println("Extraer");
						inv.ExtraerIni();
					}
					else
						obd.Println("Ingresa en la opcion 1");
					break;
				case 5:
					if (inv != null)
					{
						obd.Println("Extraer");
						inv.ExtraerFin();
					}
					else
						obd.Println("Ingresa en la opcion 1");
					break;
				case 6:
					if (inv != null)
						inv.Busqueda();
					else
						obd.Println("Ingresa en la opcion 1");
					break;
				case 7:
					if (inv != null)
						inv.Modificar();
					else
						obd.Println("Ingresa en la opcion 1");
					break;
				case 8:
					if (inv != null)
						inv.Borrar();
					else
						obd.Println("Ingresa en la opcion 1");
			}
		}
		while (op != obm.Salir());
	}

}
