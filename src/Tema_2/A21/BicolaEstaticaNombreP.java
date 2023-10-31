package Tema_2.A21;

import Tema_3.PilaDinámica;
import lib20.Menu;

public class BicolaEstaticaNombreP
{

	public static void main(String[] args)
	{
        int op;
        Menu obm=new Menu("BicolaEstatica",new String[] {"InsertarI","InsertarF","ExtraerI","ExtraerF","Recorrido","Buscar","Modificar","Borrar"});
        BicolaEstaticaNombre obp= new BicolaEstaticaNombre();
        do
            switch(op=obm.Opcion())
            {
            case 1:
                obp.Insertar();
                break;
            case 2:
                obp.InsertarF();;
                break;
            case 3:
                obp.Extraer();
                break;
            case 4:
                obp.ExtraerF();
                break;
            case 5:
                obp.Recorrido();
                break;
            case 6:
                obp.Buscar();
                break;
            case 7:
            	obp.Modificar();
            	break;
            case 8:
            	obp.Borrar();
            }
        while (op != obm.Salir());
    }

}
