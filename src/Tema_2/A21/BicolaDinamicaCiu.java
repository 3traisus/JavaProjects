package Tema_2.A21;

import java.util.Vector;

import lib20.Datos;

public class BicolaDinamicaCiu
{
	private String ciudad;
	private Vector<String> bicola = new Vector<String>(5,2);
	private Datos obd = new Datos();
	
	public void Insertar(int op)
	{
		do
			ciudad=obd.Cadena("Nombre de la ciudad"+(op==1?"Inicio":"Final")).toUpperCase();
		while(ciudad.isBlank());
		bicola.add(op==1 ? 0:bicola.size(),ciudad);
		obd.Println("ciudad almacenada con exito");
	}
	
	public void Extraer(int op)
	{
		if(!bicola.isEmpty())
		{
			obd.Println("Nombre de la ciudad eliminada de "+(op==3 ?"inicio":"final"));
			obd.Println(bicola.remove(op == 3 ? 0 : bicola.size()-1));
			
		}
		else
			obd.Println("bicola de ciudad vacia");
		obd.Println("");
	}
	
	public void Recorrido()
	{
		if(!bicola.isEmpty())
		{
			obd.Println("Nombres de las ciudades");
			for(String ciudad: bicola)
				obd.Println(ciudad);
		}
		else
			obd.Println("Bicola de ciudades vacia");
		obd.Println("");
	}
	
	public void Buscar()
	{
		int pos=1;
		if(!bicola.isEmpty())
		{
			do
				ciudad=obd.Cadena("Nombre de la ciudad a buscar").toUpperCase();
			while(ciudad.isBlank());
			for(String ciudad: bicola)
			{
				if(ciudad.equals(ciudad))
				{
					obd.Println("Ciudad encontrada en la posicion"+pos);
					break;
				}
				pos++;
			}
			if(pos>bicola.size())
				obd.Println("La ciudad no esta en la bicola");
				
		}
		else
			obd.Println("bicola vacia");
		obd.Println("");
	}
	
	public void Modificar()
	{
		if(!bicola.isEmpty())
		{
			int pos;
			do
				ciudad=obd.Cadena("Nombre de la ciudad a modificar").toUpperCase();
			while(ciudad.isBlank());
			for(pos=0;pos<bicola.size();pos++)
				if(bicola.get(pos).equals(ciudad))
				{
					do
						bicola.set(pos, obd.Cadena("Nuevo nombre de la ciudad")).toUpperCase();
					while(bicola.get(pos).isBlank());
					break;
				}
			if(pos==bicola.size())
				obd.Println("ciudad no se encuentra en la bicola");
		}
		else
			obd.Println("Bicola vacia");
		obd.Println("");
	}
	
	public void Borrar()
	{
		if(!bicola.isEmpty())
		{
			bicola.clear();
			obd.Println("Bicola de ciudades borrada");
		}
		else
			obd.Println("Bicola vacia");
		obd.Println("");
	}
}






















































