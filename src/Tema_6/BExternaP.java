package Tema_6;

import lib20.Menu;

public class BExternaP 
{
	public static void main(String[] args) 
	{
		int op;
		Menu obm=new Menu("Busqueda Interna",new String[] {"Secuencial","Binaria"});
		BExterna obb;
		do
			switch(op=obm.Opcion())
			{
			case 1:
				obb= new BExterna();
				obb.Aleatorio();
				obb.Mostrar();
				obb.BSecuencial();
				break;
			case 2:
				obb= new BExterna();
				obb.Aleatorio();
				obb.Mostrar();
				obb.BBinaria();
			}
		while (op != obm.Salir());
	
	}
}
	

