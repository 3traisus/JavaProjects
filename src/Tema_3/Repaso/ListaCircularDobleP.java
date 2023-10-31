package Tema_3.Repaso;

import lib20.Menu;

public class ListaCircularDobleP
{

	public static void main(String[] args)
	{
		Menu obm = new Menu("Repaso ListaCircularDoble-TDA",
				new String[] { "Insertar", "Recorrido","Extraer", "Buscar", "Modificar", "Borrar" });
		Menu obm2;
		int op,op2;
		ListaCircularDoble inv = new ListaCircularDoble();
		do
		{
			switch (op = obm.Opcion())
			{
				case 1:
					obm2 = new Menu("Insertar",new String [] {"Inicio","Final","Posicion"});
					do
						switch(op2= obm2.Opcion())
						{
							case 1:
							case 2:
							case 3:
								inv.Insertar(op2);		
						}
					while(op2 != obm2.Salir());
					break;
				case 2:
					inv.Recorrido();
					break;
				case 3:
					obm2 = new Menu("Extraer",new String [] {"Inicio","Final","Posicion"});
					do
						switch(op2= obm2.Opcion())
						{
							case 1:
							case 2:
							case 3:
								inv.Extraer(op2);		
						}
					while(op2 != obm2.Salir());
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
