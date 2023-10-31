package Tema_3;

import lib20.Menu;

public class PilaDinamicaEdadP
{

	public static void main(String[] args)
	{
		int op;
		Menu obm = new Menu("Pila Dinamica",new String[] 
				{"Insertar","Extraer","Recorrido","Buscar","Modificar","Borrar"});
		PilaDinamicaEdad pila = new PilaDinamicaEdad();
		do
		{
			switch(op=obm.Opcion())
			{
				case 1:
					pila.Insertar();
					break;
				case 2:
					pila.Extraer();
					break;
				case 3:
					pila.Recorrido();
					break;
				case 4:
					pila.Buscar();
					break;
				case 5:
					pila.Modificar();
					break;
				case 6:
					pila.Borrar();
					
			}
		}while(op!=obm.Salir());
		
	}

}
