package Tema_1.A12;

import java.util.Vector;

import lib20.Datos;
import lib20.Menu;

public class InventarioVec
{
	public static void main(String[] args)
	{
		Datos obd = new Datos();
		String[] tit = { "Cantidad", "Nuevo", "Consultar", "Buscar", "Modificar","Eliminar","Inversion" };
		Menu obm = new Menu("Vector Usos A12", tit);
		Vector<InventarioVecM> vec =  new Vector<InventarioVecM>(10,3);;
		int op;
		String ele;

		do
			switch (op = obm.Opcion())
			{
				case 1:
					vec = new Vector<InventarioVecM>(obd.Entero("Tamaño del vector"),3);
					
					break;
				case 2:
					if(vec.add(new InventarioVecM()))
						obd.Println("Elemento Agregado con exito");
					else
						obd.Println("Elemento No Agregado con exito");
					
					break;
				case 3:
					if (!vec.isEmpty())// Empety vector esta vacio
						for (int pos = 0; pos < vec.size(); pos++)// size obtiene el tamaño actual del vector
							vec.get(pos).Mostrar();
					else
						obd.Println("Elemento vacio");
					break;
				case 4:
					if (!vec.isEmpty())
					{
						int pos=0;
						ele = obd.Cadena("Clave a Buscar");
						for (; pos < vec.size(); pos++)
							if (vec.get(pos).CLV().contains(ele))
							{
								obd.Println("Elemento encontrado");
								vec.get(pos).Mostrar();
								break;
							}
						if(pos== vec.size())
							obd.Println("Elemento no existente");
					}
					else
						obd.Println("Elemento vacio");
					break;
				case 5:
					if (!vec.isEmpty())
					{
						int pos=0;
						ele = obd.Cadena("Clave a Modificar");
						for (; pos < vec.size(); pos++)
							if (vec.get(pos).CLV().contains(ele))
							{
								vec.set(pos, new InventarioVecM());
								break;
							}
						if(pos== vec.size())
							obd.Println("Elemento no existente");
					}
					else
						obd.Println("Elemento vacio");
					break;
				case 6:
					if (!vec.isEmpty())
					{
						int pos=0;
						ele = obd.Cadena("Clave a Eliminar");
						for (; pos < vec.size(); pos++)
							if (vec.get(pos).CLV().contains(ele))
							{
								obd.Println("Elemento Eliminado");
								vec.remove(pos);
								break;
							}
						if(pos== vec.size())
							obd.Println("Elemento no existente");
					}
					else
						obd.Println("Elemento vacio");
					break;
				case 7:
					if (!vec.isEmpty())
					{
						double tot = 0;
						for (int pos =0; pos < vec.size(); pos++)
							tot+=vec.get(pos).Inversion();
						obd.Println("El total de la inversion es" + tot);
					}
					else
						obd.Println("Elemento vacio");	
			}
		while (op != obm.Salir());
}
}
