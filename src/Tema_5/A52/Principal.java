package Tema_5.A52;

import lib20.Menu;

public class Principal
{

	public static void main(String[] args)
	{
		Methodos ob;
		int op;
		Menu obm = new Menu("Métodos de ordenamiento interno",
				new String[] { "Tamaño", "Mezcla Directa", "Mezcla Natural",});

		do
			switch (op = obm.Opcion())
			{
				case 1:
					ob = new Methodos();
					ob.Aleatorio();
					ob.Mostrar();
					break;
				case 2:
					break;
				case 3:
			}
		while (op != obm.Salir());
	}

}
