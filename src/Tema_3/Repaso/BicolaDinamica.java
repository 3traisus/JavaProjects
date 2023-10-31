package Tema_3.Repaso;

import java.util.Vector;

import lib20.Datos;

public class BicolaDinamica
{
	private Datos obd = new Datos();
	private int ind,bus;
	private Vector<TDA2> cola = new Vector<TDA2>();
	
	private int Clave()
	{
		if(!cola.isEmpty())
			return cola.get(cola.size()-1).Clave()+1;
		else
			return 1;
	}
	
	public void InsertarFin()
	{
		cola.add(new TDA2(this.Clave()));
	}
	
	public void InsertarIni()
	{
		cola.add(0, new TDA2(this.Clave()));
	}
	
	public void ExtraerIni()
	{
		if(!cola.isEmpty())
		{
			cola.remove(0).Mostrar();
		}
		else
			obd.Println("biCola Vacia");
	}
	
	public void ExtraerFin()
	{
		if(!cola.isEmpty())
		{
			cola.remove(cola.size()-1).Mostrar();
		}
		else
			obd.Println("biCola Vacia");
	}
	
	public void Recorrido()
	{
		if(!cola.isEmpty())
		{
			for(TDA2 T: cola)
			{
				T.Mostrar();
			}
		}
		else
			obd.Println("biCola Vacia");
	}
	
	public void Busqueda()
	{
		if(!cola.isEmpty())
		{
			do
				bus = obd.Entero("Dame la clave a buscar");
			while(bus<1);
			for(ind=0;ind<cola.size();ind++)
				if(cola.get(ind).Clave()==bus)
					break;
			if(ind<cola.size())
				obd.Println("Clave encontrada en la posicion"+(ind+1));
			else
				obd.Println("Clave no existe");
		}
		else
			obd.Println("biCola Vacia");
	}
	
	public void Modificar()
	{
		if(!cola.isEmpty())
		{
			do
				bus = obd.Entero("Dame la clave a buscar");
			while(bus<1);
			for(ind=0;ind<cola.size();ind++)
				if(cola.get(ind).Clave()==bus)
					break;
			if(ind<cola.size())
				cola.get(ind).Modificar();
			else
				obd.Println("Clave no existe");
		}
		else
			obd.Println("biCola Vacia");
	}
	
	public void Borrar()
	{
		obd.Println("Bicola Dinamica Borrada");
		cola.clear();
	}
}
