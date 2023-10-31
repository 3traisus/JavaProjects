package Tema_3.Repaso;

import lib20.Datos;
import java.util.*;

public class ColaDinamicaSimp
{
	private Vector<TDA2> cola = new Vector<TDA2>(5,2);
	private Datos obd = new Datos();
	int bus,ind;
	
	private int Clave()
	{
		if(cola.isEmpty())
			return 1;
		else
			return (cola.get(cola.size()-1).Clave()+1);
	}
	
	public void Insertar()
	{
		cola.add(new TDA2(this.Clave()));
	}
	
	public void Extraer()
	{
		if(!cola.isEmpty())
		{
			obd.Println("Elemento Extraido");
			cola.remove(0);
		}		
		else
			obd.Println("Cola esta vacia");
	}
	
	public void Recorrido()
	{
		if(!cola.isEmpty())
			for(TDA2 T : cola)
				T.Mostrar();
		else
			obd.Println("Cola esta vacia");
	}
	
	public void Busqueda()
	{
		if(!cola.isEmpty())
		{
			do
				bus = obd.Entero("Dame la clave a buscar");
			while(bus<1);
			if(!cola.isEmpty())
				for(ind=0;ind<cola.size();ind++)
					if(cola.get(ind).Clave()==bus)
						break;
			if(ind<cola.size())
				obd.Println("Clave encontrada");
			else
				obd.Println("La clave no existe");
		}	
		else
			obd.Println("Cola esta vacia");
}
	
	public void Modificar()
	{
		if(!cola.isEmpty())
		{
			do
				bus = obd.Entero("Dame la clave a buscar");
			while(bus<1);
			if(!cola.isEmpty())
				for(ind=0;ind<cola.size();ind++)
					if(cola.get(ind).Clave()==bus)
						break;
			if(ind<cola.size())
				cola.get(ind).Modificar();
			else
				obd.Println("La clave no existe");
		}	
		else
			obd.Println("Cola esta vacia");
	}
	
	public void Borrar()
	{
		cola.clear();
		obd.Println("Todos los elementos fueron eleminados");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
