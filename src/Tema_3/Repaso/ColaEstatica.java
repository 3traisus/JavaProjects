package Tema_3.Repaso;

import lib20.Datos;

public class ColaEstatica
{
	private int ind,clv,pos;
	private TDA2 cola[];
	private Datos obd = new Datos();
	int bus;
	
	public ColaEstatica()
	{
		do
			ind= obd.Entero("Dame el tamallo de la cola");
		while(ind<1);
		cola = new TDA2[ind];
		pos=-1;
	}
	
	private boolean Vacio()
	{
		return pos==-1;
	}
	
	private boolean Lleno()
	{
		return pos==cola.length-1;
	}
	
	private int Clave()
	{
		if(!this.Vacio())
			return cola[pos].Clave()+1;
		else
			return 1;
	}
	
	public void Insertar()
	{
		int clv;
		if(!this.Lleno())
		{
			clv= this.Clave();
			cola[++pos] = new TDA2(clv);
		}
		else
			obd.Println("La cola esta llena");
	}
	
	public void Extraer()
	{
		if(!this.Vacio())
		{
			obd.Println("Alumno Extraido");
			cola[0].Mostrar();
			for(ind=0;ind<pos;ind++)
				cola[ind]=cola[ind+1];
			pos--;
		}
		else
			obd.Println("La cola esta Vacia");
	}
	
	public void Recorrido() 
	{
		if(!this.Vacio())
		{
			for(ind=0;ind<=pos;ind++)
				cola[ind].Mostrar();
		}
		else
			obd.Println("La cola esta Vacia");
	}
	
	public void Busqueda()
	{
		if(!this.Vacio())
		{
			do
				bus = obd.Entero("Dame la clave a buscar");
			while(bus<1);
			for(ind=0;ind<=pos;ind++)
				if(cola[ind].Clave()==bus)
					break;
			if(ind<=pos)
				obd.Println("La clave fue encontrada en la poscion"+(ind+1));
			else
				obd.Println("La clave no se encuentra");
		}
		else
			obd.Println("La cola esta Vacia");
	}
	
	public void Modificar()
	{
		if(!this.Vacio())
		{
			do
				bus = obd.Entero("Dame la clave a Modificar");
			while(bus<1);
			for(ind=0;ind<=pos;ind++)
				if(cola[ind].Clave()==bus)
					break;
			if(ind<=pos)
				cola[ind].Modificar();
			else
				obd.Println("La clave no se encuentra");
		}
		else
			obd.Println("La cola esta Vacia");
	}
	
	public void Borrar()
	{
		cola = new TDA2[cola.length];
		pos=-1;
		obd.Println("Cola Borrada");
	}
}
