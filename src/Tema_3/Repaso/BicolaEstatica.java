package Tema_3.Repaso;

import lib20.Datos;

public class BicolaEstatica
{
	private Datos obd = new Datos();
	private TDA2 cola[];
	private int ind,pos,bus;
	
	private boolean Vacio()
	{
		return ind==-1;
	}
	
	private boolean Lleno()
	{
		return ind==cola.length-1;
	}
	
	public BicolaEstatica()
	{
		do
			ind = obd.Entero("Dame el tamallo de la bicola");
		while(ind<1);
		cola = new TDA2[ind];
		ind=-1;
	}
	
	private int Clave()
	{
		if(!this.Vacio())
			return cola[ind].Clave()+1;
		else
			return 1;
	}
	
	public void InsertarFin()
	{
		if(!this.Lleno())
		{
			bus = this.Clave();
			cola[++ind] = new TDA2(bus);
		}
		else
			obd.Println("Bicola Llena");
	}
	
	public void InsertarIni()
	{
		if(!this.Lleno())
		{
			bus = this.Clave();
			for(pos=0;pos<=ind;pos++)
				cola[pos+1]=cola[pos];
			cola[0]= new TDA2(bus);
			ind++;
		}
		else
			obd.Println("Bicola Llena");
	}
	
	public void ExtraerFin()
	{
		if(!this.Vacio())
		{
			obd.Println("Elemento extraido al Final");
			cola[ind--].Mostrar();
		}
		else
			obd.Println("Bicola Vacia");
	}
	
	public void ExtraerIni()
	{
		if(!this.Vacio())
		{
			obd.Println("Elemento extraido al Inicio");
			cola[0].Mostrar();
			for(pos=0;pos<=ind;pos++)
				cola[pos]=cola[pos+1];
			ind--;
		}
		else
			obd.Println("Bicola Vacia");
	}
	
	public void Recorrido()
	{
		if(!this.Vacio())
		{
			for(pos=0;pos<=ind;pos++)
				cola[pos].Mostrar();
		}
		else
			obd.Println("Bicola Vacia");
	}
	
	public void Busqueda()
	{
		if(!this.Vacio())
		{
			do
				bus= obd.Entero("Clave a buscar");
			while(bus<1);
			for(pos=0;pos<=ind;pos++)
				if(cola[pos].Clave()==bus)
					break;
			if(pos<=ind)
				obd.Println("Clave encontrada en la posicion"+(pos+1));
			else
				obd.Println("Clave no existe");
		}
		else
			obd.Println("Bicola Vacia");
	}
	
	public void Modificar()
	{
		if(!this.Vacio())
		{
			do
				bus= obd.Entero("Clave a buscar");
			while(bus<1);
			for(pos=0;pos<=ind;pos++)
				if(cola[pos].Clave()==bus)
					break;
			if(pos<=ind)
				cola[pos].Modificar();
			else
				obd.Println("Clave no existe");
		}
		else
			obd.Println("Bicola Vacia");
	}
	
	public void Borrar()
	{
		obd.Println("Bicola Borrada");
		cola = new TDA2[cola.length];
		ind=-1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
