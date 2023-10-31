package Tema_3;

import lib20.Menu;

public class ListaDoubleProP
{

	public static void main(String[] args)
	{
		int op1,op2;
		Menu obm1, obm2;
		obm1 = new Menu("Lista Dobles", new String[] {"Insertar","Extraer","Recorrido","Buscar","Modificar","Borrar"});
		ListaDoublePro obl = new ListaDoublePro();
		
		do
			switch(op1=obm1.Opcion())
			{
				case 1:
					obm2 = new Menu("Insertar Producto", new String[] {"Inicio","Posicion","Final"});
					do
						switch(op2=obm2.Opcion())
						{
							case 1:
							case 2:
							case 3:
								obl.Insertar(op2);
						}
					while(op2!=obm2.Salir());
					break;
				case 2:
					obm2 = new Menu("Extraer Producto", new String[] {"Inicio","Posicion","Final"});
					do
					{
						op2 = obm2.Opcion();
						if(op2==1 || op2==2|| op2==3)
							obl.Extraer();
					}
					while(op2!=obm2.Salir());
					break;
				case 3:
					obl.Recorrido();
					break;
				case 4:
				case 5:
					obl.BuscarMod(op1);
					break;
				case 6:
					obl.Borrar();
					
			}
		while(op1!=obm1.Salir());
	
	}
}
