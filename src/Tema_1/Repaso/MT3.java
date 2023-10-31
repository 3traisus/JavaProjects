package Tema_1.Repaso;

import java.util.Vector;

import lib20.Datos;

public class MT3
{
	private Datos obd = new Datos();
	private Vector<TDA2> vector = null;
	private int ind;
	
	public MT3()
	{
		do
			ind = obd.Entero("Dame el tamaño del vector");
		while(ind<1);
		vector = new Vector<TDA2>(ind,1);
	}
	
	public void Nuevo()
	{
		if(vector!=null)
		{
			vector.add(new TDA2());
		}
		else
			obd.Println("Vector es Null");
	}
	
	public void Consulta()
	{
		if(!vector.isEmpty())
		{
			for(int x=0;x<vector.size();x++)
				vector.elementAt(x).Mostrar();

		}
		else
			obd.Println("Vector Vacio");
	}
	
	public void Buscar()
	{
		int bus,x;
		if(!vector.isEmpty())
		{
			do
				bus= obd.Entero("Tarjeta a Buscar");
			while(bus<0);
			for(x=0;x<vector.size();x++)
				if(vector.elementAt(x).Clave()==bus)
					break;
			if(x<vector.size())
				obd.Println("Elemento encontrado en la posicion"+(x+1));
			else
				obd.Println("Elemento no existe");
		}
		else
			obd.Println("Vector Vacio");
	}
	
	public void Modificar()
	{
		int bus,x;
		if(!vector.isEmpty())
		{
			do
				bus= obd.Entero("Tarjeta a Buscar");
			while(bus<0);
			for(x=0;x<vector.size();x++)
				if(vector.elementAt(x).Clave()==bus)
					break;
			if(x<vector.size())
			{
				vector.elementAt(x).Modificar();
				obd.Println("Elemento Modificado");
			}
			else
				obd.Println("Elemento no existe");
		}
		else
			obd.Println("Vector Vacio");
	}
	
	public void Eliminar()
	{
		int bus,x;
		if(!vector.isEmpty())
		{
			do
				bus= obd.Entero("Tarjeta a Buscar");
			while(bus<0);
			for(x=0;x<vector.size();x++)
				if(vector.elementAt(x).Clave()==bus)
					break;
			if(x<vector.size())
			{
				vector.remove(x);
			}
			else
				obd.Println("Elemento no existe");
		}
		else
			obd.Println("Vector Vacio");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
