package Tema_3;

import lib20.Menu;

public class PilaDin�micaP
{
    public static void main(String[] args)
    {
        int op;
        Menu obm=new Menu("Pila Din�mica Vector",new String[] {"Insertar","Extraer","Recorrido","Buscar","Modificar","Borrar"});
        PilaDin�mica obp=new PilaDin�mica();
        do
            switch(op=obm.Opcion())
            {
            case 1:
                obp.Insertar();
                break;
            case 2:
                obp.Extraer();
                break;
            case 3:
                obp.Recorrido();
                break;
            case 4:
                obp.Buscar();
                break;
            case 5:
                obp.Modificar();
                break;
            case 6:
                obp.Borra();
            }
        while (op != obm.Salir());
    }
}
