package Tema_5;

import lib20.Menu;

public class OInternoMateriasP
{

	public static void main(String[] args)
	{
		int op;
		Menu obm=new Menu("Control de materias", new String[] {"Nueva", "Lista", "Modificar", "Ordenar" });
		OInternoMaterias obo=new OInternoMaterias();
		
		do
			switch(op=obm.Opcion())
			{
				case 1:
					obo.Nueva();
					break;
				case 2:
					obo.Lista();
					break;
				case 3:
					obo.Modificar();
					break;
				case 4:
					obo.Ordenar();
			}
		while(op!=obm.Salir());
	}

}
