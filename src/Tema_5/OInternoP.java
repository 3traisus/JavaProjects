package Tema_5;

import lib20.Menu;

public class OInternoP
{

	public static void main(String[] args)
	{
		int op;
		Menu obm = new Menu("Ordenamiento Interno",
				new String[] { "Burbuja", "Burbuja Mejorado", "QuickSort", "ShellSort", "Radix", "Java" });
		OInterno obo =null;

		do
			switch (op = obm.Opcion())
			{
				case 1:
					obo = new OInterno();
					obo.Burbuja();
					obo.Mostrar();
					break;
				case 2:
					obo = new OInterno();
					obo.BurbujaM();
					obo.Mostrar();
					break;
				case 3:
					obo = new OInterno();
					obo.QuickSort();
					obo.Mostrar();
					break;
				case 4:
					obo = new OInterno();
					obo.ShellSort();
					obo.Mostrar();
					break;
				case 5:
					obo = new OInterno();
					obo.Radix();
					obo.Mostrar();
					break;
				case 6:
					obo = new OInterno();
					obo.Java();
					obo.Mostrar();
			}
		while (op != obm.Salir());
	}
}
