package Tema_5.A51;


import lib20.Menu;

public class Principal
{

	public static void main(String[] args)
	{

		int op,op2;
		Menu obm = new Menu("Métodos de ordenamiento interno",
				new String[] { "Tamaño del arreglo", "Numeros de control", "Ordenamiento",});
		Menu obm2 = new Menu("Ordenamiento",
				new String[] {"Burbuja Mejorado", "QuickSort", "ShellSort", "Radix"});
		Metodos ob =null;

		do
			switch (op = obm.Opcion())
			{
				case 1:
					ob = new Metodos();
					break;
				case 2:
					if(ob!=null)
						ob.Control();
						ob.Mostrar();
					break;
				case 3:
					if(ob!=null && ob.Acceso())
						do
						{
							switch(op2 = obm2.Opcion())
							{
								case 1:
									ob.Tiempo();
									ob.BurbujaM();
									ob.Tiempo();
									ob.Mostrar();
									break;
								case 2:
									ob.Tiempo();
									ob.QuickSort();
									ob.Tiempo();
									ob.Mostrar();
									break;
								case 3:
									ob.Tiempo();
									ob.ShellSort();
									ob.Tiempo();
									ob.Mostrar();
									break;
								case 4:
									ob.Tiempo();
									ob.Radix();
									ob.Tiempo();
									ob.Mostrar();
							}
							
						}while(op2 !=obm2.Salir());
			}
		while (op != obm.Salir());
	}

}
