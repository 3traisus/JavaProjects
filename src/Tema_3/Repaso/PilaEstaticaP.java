package Tema_3.Repaso;

import lib20.Datos;
import lib20.Menu;

public class PilaEstaticaP
{

	public static void main(String[] args)
	{
		Datos obd = new Datos();
		Menu obm = new Menu("Repaso PilaEstatica-TDA",
				new String[] { "Tamallo", "Insertar", "Recorrido","Extraer", "Buscar", "Modificar", "Borrar" });
		int op;
		PilaEstatica inv = null;
		do
		{
			switch (op = obm.Opcion())
			{
				case 1:
					inv = new PilaEstatica();
					break;
				case 2:
					if (inv != null)
					{
						obd.Println("Agregar");
						inv.Insertar();
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
						inv.Extraer();
					else
						obd.Println("Ingresa en la opcion 1");
					break;
				case 5:
					if (inv != null)
						inv.Busqueda();
					else
						obd.Println("Ingresa en la opcion 1");
					break;
				case 6:
					if (inv != null)
						inv.Modificar();
					else
						obd.Println("Ingresa en la opcion 1");
					break;
				case 7:
					if (inv != null)
						inv.Borrar();	
					else
						obd.Println("Ingresa en la opcion 1");
			}
		}
		while (op != obm.Salir());
	}

}
