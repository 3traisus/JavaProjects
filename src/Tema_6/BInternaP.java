package Tema_6;

import lib20.Menu;

public class BInternaP
{
	public static void main(String[] args) 
	{
		int op, op1;
		Menu obm=new Menu("Busqueda Interna",new String[] {"Secuencial","Binaria","Hash"});
		BInterna obb;
		do
			switch(op=obm.Opcion())
			{
			case 1:
				obb= new BInterna();
				obb.Aleatorios();
				obb.Mostrar();
				obb.BSecuencia();
				break;
			case 2:
				obb= new BInterna();
				obb.Aleatorios();
				obb.Mostrar();
				obb.BBinaria();
				break;
			case 3:
				Menu obm1=new Menu("Funciones Hash", 
						new String[] {"Modulo","Cuadratica","Plegamiento","Trucamiento"});
				do
				{
					switch(op1=obm1.Opcion())
					{
					case 1:
					case 2:
					case 3:
					case 4:
						obb=new BInterna(op1);
						obb.Mostrar();
						obb.BHash(op1);
					}
					
				}
				while(op1!=obm1.Salir());
				
			}
		while (op != obm.Salir());
		
	}
}
