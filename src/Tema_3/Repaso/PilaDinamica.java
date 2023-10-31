package Tema_3.Repaso;

import java.util.Vector;

import lib20.Datos;

public class PilaDinamica
{
	private int ind;
	private int bus;
	private Vector <TDA2> pila = new Vector<TDA2>(5,2);
	private Datos obd = new Datos();
	
	private int Clave()
	{
		if(!pila.isEmpty())
			return (pila.get(pila.size()-1).Clave()+1);
		else
			return 1;
	}
	
	public void Insertar()
	{
		pila.add(new TDA2(this.Clave()));
	}
	
	public void Extraer()
	{
		if(!pila.isEmpty())
		{
			obd.Println("Elemento extraido");
			pila.remove(pila.size()-1).Mostrar();
		}
		else
			obd.Println("Pila Vacia");
			
	}
	
	public void Recorrido()
	{
		if(!pila.isEmpty())
		{
			for(TDA2 T:pila)
			{
				T.Mostrar();
			}
		}
		else
			obd.Println("Pila Vacia");
	}
	
	public void Busqueda()
	{
		if(!pila.isEmpty())
		{
			do
				bus= obd.Entero("Clave a buscar");
			while(bus<1);
			for(ind=0;ind<pila.size();ind++)
				if(pila.get(ind).Clave()==bus)
					break;
			if(ind<pila.size())
				obd.Println("Elemento encontrado en la posicion"+(ind+1));
			else
				obd.Println("Elemento no encontrado");
		}
		else
			obd.Println("Pila Vacia");
	}
	
	public void Modificar()
	{
		if(!pila.isEmpty())
		{
			do
				bus= obd.Entero("Clave a Modificar");
			while(bus<1);
			for(ind=0;ind<pila.size();ind++)
				if(pila.get(ind).Clave()==bus)
					break;
			if(ind<pila.size())
				pila.get(ind).Modificar();
			else
				obd.Println("Elemento no encontrado");
		}
		else
			obd.Println("Pila Vacia");
	}
	
	public void Borrar()
	{
		pila.clear();
		obd.Println("Todos los elementos fueron eleminados");
	}
}
