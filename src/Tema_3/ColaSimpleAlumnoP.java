package Tema_3;

import Tema_2.A21.ProfMAt;
import lib20.Menu;

public class ColaSimpleAlumnoP
{

	public static void main(String[] args)
	{
		int op;
	    Menu obm=new Menu("Conversor",new String[] 
	    		{"Insertar","Extraer","Recorrido","Buscar","Modificar","Borrar"});
		ColaSimpleAlumno obc = new ColaSimpleAlumno();
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
