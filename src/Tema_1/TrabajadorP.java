package Tema_1;

import lib20.Datos;
import lib20.Menu;

public class TrabajadorP
{

	public static void main(String[] args)
	{
		int op = -1;
		String[] o = { "Cantidad", "Nuevo", "Consulta", "Buscar", "Modificar", "Eliminar" };
		Menu m = new Menu("Menu Alumno", o);
		TrabajadorEsta tbd = null;
		Datos obd = new Datos();
		do
		{
			switch (op = m.Opcion())
			{
			case 1:
				tbd = new TrabajadorEsta();
				break;
			case 2:
				if (tbd != null)
				{
					obd.Println("Ingresa los Datos del alumno");
					tbd.Agregar();
				}
				else
					obd.Println("Ingresa en la opcion 1");
				break;
			case 3:
				if (tbd != null)
				{
					obd.Println("Lista de Alumnos");
					tbd.Consulta();
				}
				else
					obd.Println("Ingresa en la opcion 1");
				break;
			case 4:
				if (tbd != null)
					tbd.Buscar();
				else
					obd.Println("Ingresa en la opcion 1");
				break;
			case 5:
				if (tbd != null)
					tbd.Modificar();
				else
					obd.Println("Ingresa en la opcion 1");
				break;
			case 6:
				if (tbd != null)
					tbd.Eliminar();
				else
					obd.Println("Ingresa en la opcion 1");
			}
		}
		while (op != m.Salir());

	}

}
