package Tema_4.A41;

import lib20.Menu;

public class ArbolArticuloP
{

	public static void main(String[] args)
	{
		int op1;
		Menu obm1;
		obm1 = new Menu("Arbol de Articulos", new String[] {"Nuevo","Lista","Buscar","Modificar","Eliminar"});
		ArbolArticulo obl = new ArbolArticulo();
		do
			switch(op1=obm1.Opcion())
			{
				case 1:
					obl.Insertar();
					break;
				case 2:
					obl.Recorrer();
					break;
				case 3:
				case 4:
					obl.Buscar(op1);
					break;
				case 5:
					obl.Borrar();
					
			}
		while(op1!=obm1.Salir());
	}

}
