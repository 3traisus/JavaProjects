package Tema_1;

import java.util.Vector;

import lib20.*;

public class VectorUse
{
	public static void main(String[] args)
	{
		Datos obd = new Datos();
		String[] tit = { "Insertar", "Consultar", "Modificar", "Eliminar", "Buscar" };
		Menu obm = new Menu("Vector Usos", tit);
		Vector<Integer> vec = new Vector<Integer>();
		int op, ele;

		do
			switch (op = obm.Opcion())
			{
			case 1:
				if (vec.add(obd.Entero("Dato a Agregar")))// agraga elementos al vector
					obd.Println("Elemento Agregado con exito");
				else
					obd.Println("Elemento No Agregado con exito");
				break;
			case 2:
				if (!vec.isEmpty())// Empety vector esta vacio
					for (int pos = 0; pos < vec.size(); pos++)// size obtiene el tamaño actual del vector
						obd.Println("" + vec.get(pos));// get obtiene el contenido del vector
				else
					obd.Println("Elemento vacio");
				break;
			case 3:
				if (!vec.isEmpty())
					if (vec.contains(ele = obd.Entero("Dato a Modificar")))// contains compara el contenido del vector
																			// con una tipo de dato
						vec.set(vec.indexOf(ele), obd.Entero("Escribe el Dato Modificado"));// index of obtiene el
																							// indice del tipo de dato
																							// encontrado en el vector
					// set modifica los datos del vector apartir de una posicion y una cadena
					else
						obd.Println("Elemento no encontrado");
				else
					obd.Println("Elemento vacio");
				break;
			case 4:
				if (!vec.isEmpty())
					if (vec.contains(ele = obd.Entero("Dato a Eliminar")))
						vec.remove(vec.indexOf(ele));// elimina el dato en un indice determinado
					else
						obd.Println("Elemento no encontrado");
				else
					obd.Println("Elemento vacio");
				break;
			case 5:
				if (!vec.isEmpty())
					if (vec.contains(obd.Entero("Dato a buscar")))

						obd.Println("Elemento encontrado");
					else
						obd.Println("Elemento no encontrado");
				else
					obd.Println("Elemento vacio");
			}
		while (op != obm.Salir());
	}

}
