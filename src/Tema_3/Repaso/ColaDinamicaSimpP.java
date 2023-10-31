package Tema_3.Repaso;

import lib20.Datos;
import lib20.Menu;

public class ColaDinamicaSimpP
{
	public static void main(String []args)
	{
		Datos obd = new Datos();
		Menu obm = new Menu("Repaso ColaDinamicaSimple-TDA",
				new String[] {"Insertar", "Recorrido","Extraer", "Buscar", "Modificar", "Borrar" });
		int op;
		ColaDinamicaSimp inv = new ColaDinamicaSimp();
		do
		{
			switch (op = obm.Opcion())
			{
				case 1:
						obd.Println("Agregar");
						inv.Insertar();
					break;
				case 2:
						obd.Println("Recorrido");
						inv.Recorrido();
					break;
				case 3:
						inv.Extraer();
					break;
				case 4:
						inv.Busqueda();
					break;
				case 5:
						inv.Modificar();
					break;
				case 6:
						inv.Borrar();	
			}
		}
		while (op != obm.Salir());
	}
}
