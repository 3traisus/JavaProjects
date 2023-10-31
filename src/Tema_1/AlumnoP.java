package Tema_1;

import lib20.*;

public class AlumnoP
{
	public static void main(String[] args)
	{
		/*
		 * Alumno A = new Alumno(); Alumno B = new Alumno(); A.Mostrar(); B.Mostrar();
		 */
		int op = -1;
		String[] o = { "Cantidad", "Nuevo", "Lista", "Buscar" };
		Menu m = new Menu("Menu Alumno", o);
		AlumnoM alm = null;
		Datos obd = new Datos();
		do
		{
			switch (op = m.Opcion())
			{
			case 1:
				alm = new AlumnoM();
				break;
			case 2:
				if (alm != null)
				{
					obd.Println("Ingresa los Datos del alumno");
					alm.Nuevo();
				}
				else
					obd.Println("Ingresa en la opcion 1");
				break;
			case 3:
				if (alm != null)
				{
					obd.Println("Lista de Alumnos");
					alm.Lista();
				}
				else
					obd.Println("Ingresa en la opcion 1");
				break;
			case 4:
				if (alm != null)
					alm.Buscar();
				else
					obd.Println("Ingresa en la opcion 1");
			}
		}
		while (op != m.Salir());

	}

}
