package Tema_2.A21;

import lib20.Menu;

public class BicolaDinamicaCiu2P
{

	public static void main(String[] args)
	{
		int op;
		Menu obm = new Menu("Bicola Dinamica Ciudades",new String[]{"InsertarI","InsertarF","ExtraerI","ExtraerF","Recorrido","Buscar","Modificar","Borrar"});
		BicolaDinamicaCiu obp = new BicolaDinamicaCiu();
		do
            switch(op=obm.Opcion())
            {
            case 1:
            case 2:
                obp.Insertar(op);;
                break;
            case 3:
            case 4:
                obp.Extraer(op);
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
