package Tema_1.Repaso;

import lib20.Datos;

public class MT2
{
	private Datos obd = new Datos();
	private TDA2 list[];
	private int ind;
	
	public MT2()
	{
		do
			ind=obd.Entero("Tamaño del Arreglo");
		while(ind<1);
		list= new TDA2[ind];
		ind=-1;
	}
	
	public void Nuevo()
	{
		if((ind+1)<list.length)
			list[++ind]= new TDA2();
		else
		{
			TDA2 temp[];
			temp = list;
			list = new TDA2[(ind + 2)];
			for (int x = 0; x < temp.length; x++)
				list[x] = temp[x];
			list[++ind]= new TDA2();
		}
	}
	
	public void Consulta()
	{
		if(ind!=-1)
			for(int x=0;x<=ind;x++)
				list[x].Mostrar();
		else
			obd.Println("Lista Vacia");
	}
	
	public void Buscar()
	{
		int x,bus;
		if(ind!=-1)
		{
			do
				bus = obd.Entero("Numero de Tarjeta a buscar");
			while(bus<0);
			for(x=0;x<=ind;x++)
				if(list[x].Clave()==bus)
					break;
			if(x<=ind)
				obd.Println("Elemento encontrado en la posicion \t"+(x+1));
			else
				obd.Print("Elemento no existe");
		}
		else
			obd.Println("Lista Vacia");
	}
	
	public void Modificar()
	{
		int x,bus;
		if(ind!=-1)
		{
			do
				bus = obd.Entero("Numero de Tarjeta a Modifcar");
			while(bus<0);
			for(x=0;x<=ind;x++)
				if(list[x].Clave()==bus)
					break;
			if(x<=ind)
				list[x].Modificar();	
			else
				obd.Print("Elemento no existe");
		}
		else
			obd.Println("Lista Vacia");
	}
	
	public void Eliminar()
	{
		int bus,x;
		if(ind!=-1)
		{
			do
				bus = obd.Entero("Numero de tarjeta a Eliminar");
			while(bus<0);
			for(x=0;x<=ind;x++)
				if(list[x].Clave()==bus)
					break;
			if(x<=ind)
			{
				TDA2 temp[];
				temp = list;
				list = new TDA2[(ind--)];
				for(int y=0;y<temp.length;y++)
				{
					if (y < x)
						list[y] = temp[y];
					else if (y > x)
						list[y - 1] = temp[y];
					else
						obd.Println("Eliminado");
				}
			}
			else
				obd.Println("El elemento no existe");
				
		}
		else
			obd.Println("Lista Vacia");
	}
}
