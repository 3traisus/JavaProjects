package Tema_3;

import lib20.Menu;

public class PilaPromedioP
{
    public static void main(String[] args)
    {

        int op;
        Menu obm = new Menu("Pila de calificaciones",
                new String[] { "Insertar", "Extraer", "Recorrido", "Busqueda", "Borrrar" });
        PilaPromedio obp = new PilaPromedio();

        do
            switch (op = obm.Opcion())
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
                obp.Borrar();

            }
        while (op != obm.Salir());
    }

}
