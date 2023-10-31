package Tema_1.Repaso;

import lib20.Datos;

public class MT1
{
	private Datos obd = new Datos();
	private TDA1 list[];
	private int ind;
	
	public MT1()
	{
		do
			ind = obd.Entero("Tamallo del arreglo");
		while(ind<1);
		list = new TDA1[ind];
		ind=-1;
	}
	
	public void Nuevo()
	{
		if((ind+1)<list.length)
			try
			{
				list[++ind]= new TDA1();
				do
					list[ind].setTar(obd.Entero("Dame el numero de la tarjeta"));
				while(list[ind].getTar()<1);
				list[ind].setNom(obd.Cadena("Dame el Nombre"));
				list[ind].setPuesto(obd.Cadena("Dame el Puesto"));
				do
				list[ind].setSueld(obd.Entero("Dame el Sueldo"));
				while(list[ind].getSueld()<1);
			}catch(NumberFormatException e)
			{
				obd.Println("Algun dato Resulto ser erroneo");
			}
		else
		{
			TDA1 temp[];
			temp = list;
			list = new TDA1[(ind + 2)];
			for (int x = 0; x < temp.length; x++)
				list[x] = temp[x];
			list[++ind]= new TDA1();
			do
				list[ind].setTar(obd.Entero("Dame el numero de la tarjeta"));
			while(list[ind].getTar()<1);
			list[ind].setNom(obd.Cadena("Dame el Nombre"));
			list[ind].setPuesto(obd.Cadena("Dame el Puesto"));
			do
			list[ind].setSueld(obd.Entero("Dame el Sueldo"));
			while(list[ind].getSueld()<1);
		}
	}
	
	
	public void Consulta()
	{
		if(ind!=-1)
		{
			for(int x=0;x<=ind;x++)
				list[x].Mostrar();
		}
		else
			obd.Println("Lista Vacia");
	}
	
	public void Buscar()
	{
		String bus;
		int x;
		if(ind!=-1)
		{
			do
				bus = obd.Cadena("Nombre o Apellido a Buscar");
			while(bus.isBlank());
			for(x=0;x<=ind;x++)
				if(list[x].getNom().contains(bus))
					break;
			if(x<=ind)
				obd.Println("El elemento existe en la posicion \t"+(x+1));
			else
				obd.Println("El elemento no existe");
		}
		else
			obd.Println("Lista Vacia");
	}
	
	public void Modificar()
	{
		int bus,x;
		if(ind!=-1)
		{
			do
				bus = obd.Entero("Nombre de tarjeta a Modificar");
			while(bus<0);
			for(x=0;x<=ind;x++)
				if(list[x].getTar()==bus)
					break;
			if(x<=ind)
			{
				list[ind].setNom(obd.Cadena("Dame el Nombre"));
				list[ind].setPuesto(obd.Cadena("Dame el Puesto"));
				do
					list[ind].setSueld(obd.Entero("Dame el Sueldo"));
				while(list[ind].getSueld()<1);
			}
			else
				obd.Println("El elemento no existe");
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
				bus = obd.Entero("Nombre de tarjeta a Eliminar");
			while(bus<0);
			for(x=0;x<=ind;x++)
				if(list[x].getTar()==bus)
					break;
			if(x<=ind)
			{
				TDA1 temp[];
				temp = list;
				list = new TDA1[(ind--)];
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
