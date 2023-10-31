package Tema_6.A62;

import lib20.Menu;

public class BusExt62P
{

	public static void main(String[] args)
	{
		BuxExt62 ob = null;
		int op;
		Menu obm = new Menu("Métodos de ordenamiento interno",
				new String[] { "Cantidad", "Funciones Hash", "Generar Aleatorios","Mostrar los numeros","Buscar Tarjeta"});

		do
			switch (op = obm.Opcion())
			{
				case 1:
					ob = new BuxExt62();
					break;
				case 2:
					ob.FuncionesHash();
					break;
				case 3:
					if(ob!=null)
						ob.Generar();
					break;
				case 4:
					if(ob!=null)
						ob.Mostrar();
				case 5:
					
			}
		while (op != obm.Salir());
	}

}
