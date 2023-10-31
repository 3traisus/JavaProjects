package Tema_3.Repaso;

import lib20.Datos;

public class ColaEstaticaCircular
{
	private boolean ban=false;
	private int ini,fin,ind,bus;
	private TDA2 cola[];
	private Datos obd = new Datos();
	
	private int Clave()
	{
		if(!this.Vacio())
			return cola[fin].Clave()+1;
		else
			return 1;
	}
	
	private boolean Vacio()
	{
		return ini==-1;
	}
	
	private boolean Lleno()
	{
		if(ini==0 && fin==cola.length-1)
			return true;
		else
			if(fin+1==ini)
				return true;
			else
				return false;
	}
	
	public ColaEstaticaCircular()
	{
		do
			ind= obd.Entero("Tamallo de la cola circular");
		while(ind<1);
		cola = new TDA2[ind];
		ini=fin=-1;
	}
	
	public void Insertar()
	{
		if(!this.Lleno())
		{
			bus = this.Clave();
			if(this.Vacio())
				fin=ini=0;
			else
				if(fin==cola.length-1)
					fin=0;
				else
					fin++;
			cola[fin]= new TDA2(bus);
		}
		else
			obd.Println("Cola circular Llena");
	}
	
	public void Extraer()
	{
		if(!this.Vacio())
		{
			obd.Println("Elemento extraido");
			cola[ini].Mostrar();
			if(ini==fin)
				ini=fin=-1;
			else
				if(ini==cola.length-1)
					ini=0;
				else
					ini++;
		}
		else
			obd.Println("Cola circular Vacia");
	}
	
	public void Recorrido()
	{
		if(!this.Vacio())
		{
			if(fin<ini)
			{
				for(ind=ini;ind<cola.length;ind++)
					cola[ind].Mostrar();
				for(ind=0;ind<=fin;ind++)
					cola[ind].Mostrar();
			}
			else
				for(ind=ini;ind<=fin;ind++)
					cola[ind].Mostrar();
		}
		else
			obd.Println("Cola circular Vacia");
	}
	
	public void Buscar()
	{
		if(!this.Vacio())
		{
			do
				bus = obd.Entero("Clave a bucar");
			while(bus<1);
			if(fin<ini)
			{
				for(ind=ini;ind<cola.length;ind++)
					if(cola[ind].Clave()==bus)
					{
						ban=true;
						break;
					}
				if(!ban)
					for(ind=0;ind<=fin;ind++)
						if(cola[ind].Clave()==bus)
						{
							ban=true;
							break;
						}
			}
			else
			{
				for(ind=ini;ind<=fin;ind++)
					if(cola[ind].Clave()==bus)
					{
						ban=true;
						break;
					}
						
			}
			if(ban)
				cola[ind].Mostrar();
			else
				obd.Println("Elemento no existe");

		}
		else
			obd.Println("Cola circular Vacia");
	}
	
	public void Modificar()
	{
		if(!this.Vacio())
		{
			do
				bus = obd.Entero("Clave a bucar");
			while(bus<1);
			if(fin<ini)
			{
				for(ind=ini;ind<cola.length;ind++)
					if(cola[ind].Clave()==bus)
					{
						ban=true;
						break;
					}
				if(!ban)
					for(ind=0;ind<=fin;ind++)
						if(cola[ind].Clave()==bus)
						{
							ban=true;
							break;
						}
			}
			else
			{
				for(ind=ini;ind<=fin;ind++)
					if(cola[ind].Clave()==bus)
					{
						ban=true;
						break;
					}
						
			}
			if(ban)
				cola[ind].Modificar();
			else
				obd.Println("Elemento no existe");

		}
		else
			obd.Println("Cola circular Vacia");
	}
	
	public void Borrar()
	{
		cola = new TDA2[cola.length];
		ini=fin=-1;
		obd.Println("Cola Circular Borrada");
	}
	
	
	
	
	
	
	
	
	
	
	
}
