package Tema_3;

import Tema_2.A21.BicolaEstaticaNombre;
import lib20.Menu;

public class ListaSimpleNombreP
{

	public static void main(String[] args)
	{
		  int op;
	        Menu obm=new Menu("Lista Simple Ligas",new String[] {"InsertarI","InsertarF","InsertarP","ExtraerI","ExtraerF","ExtraerP","Recorrido","Buscar","Modificar","Borrar"});
	        ListaSimpleNombres obp= new ListaSimpleNombres();
	        do
	            switch(op=obm.Opcion())
	            {
	            case 1:
	                obp.InsertarIni();
	                break;
	            case 2:
	                obp.InsertarFinal();;
	                break;
	            case 3:
	            	obp.InsertarIni();
	            	break;
	            case 4:
	                obp.ExtraerIni();
	                break;
	            case 5:
	                obp.ExtraerFinal();
	                break;
	            case 6:
	            	obp.ExtraerPos();
	            	break;
	            case 7:
	                obp.Recorrido();
	                break;
	            case 8:
	                obp.Buscar();
	                break;
	            case 9:
	            	obp.Modificar();
	            	break;
	            case 10:
	            	obp.Borrar();
	            }
	        while (op != obm.Salir());
	}

}
