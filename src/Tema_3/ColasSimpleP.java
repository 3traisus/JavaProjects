package Tema_3;

import lib20.Menu;

public class ColasSimpleP
{

	public static void main(String[] args)
	{
		int op;
		Menu obm = new Menu("Pila Dinamica",new String[] 
				{"Insertar","Extraer","Recorrido","Buscar","Modificar","Borrar"});
		ColasSimple obc = new ColasSimple();
		do
		{
			switch(op=obm.Opcion())
			{
				case 1:
					obc.Insertar();
					break;
				case 2:
					obc.Extraer();
					break;
				case 3:
					obc.Recorrido();
					break;
				case 4:
					obc.Buscar();
					break;
				case 5:
					obc.Modificar();
					break;
				case 6:
					obc.Borrar();
			}
		}while(op!=obm.Salir());
			
	}

}
