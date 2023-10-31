package Tema_3.Repaso;

import lib20.Datos;

public class PilaEstatica
{
	private int ind,clv,pos=-1;
	private TDA2 pila[];
	private Datos obd = new Datos();
	
	public PilaEstatica()
	{
		do
			pos = obd.Entero("Tamallo de la pila");
		while(pos<1);
		pila = new TDA2[pos];
		pos=-1;
	}
	
	private boolean Vacia()
	{
		return pos==-1;
	}
	
	private boolean Llena()
	{
		return pos==pila.length-1;
	}
	
	private int Clave()
	{
		if(this.Vacia())
			return 1;
		else
			return pila[pos].Clave()+1;
	}
	
	public void Insertar()
	{
		if(!this.Llena())
		{
			clv = this.Clave();
			pila[++pos] = new TDA2(clv);
		}
		else
			obd.Println("Pila llena");
	}
	
	public void Extraer()
	{
		if(!this.Vacia())
			pos--;
		else
			obd.Println("Pila Vacia");
	}
	
	public void Recorrido()
	{
		if(!this.Vacia())
		{
			obd.Println("Pila de Trabajadores");
			for(ind=0;ind<=pos;ind++)
				pila[ind].Mostrar();
		}
		else
			obd.Println("Pila Vacia");
	}
	
	public void Busqueda()
	{
		if(!this.Vacia())
		{
			do
				clv = obd.Entero("Dame la clave a buscar");
			while(clv<1);
			obd.Println("Pila de Trabajadores");
			for(ind=0;ind<=pos;ind++)
				if(pila[ind].Clave()==clv)
					break;
			if(ind<=pos)
				obd.Println("Elemento encontrado en la pos"+(ind+1));
			else
				obd.Println("Elemento no encontrado");
		}
		else
			obd.Println("Pila Vacia");
	}
	
	public void Modificar()
	{
		if(!this.Vacia())
		{
			do
				clv = obd.Entero("Dame la clave a Modificar");
			while(clv<1);
			obd.Println("Pila de Trabajadores");
			for(ind=0;ind<=pos;ind++)
				if(pila[ind].Clave()==clv)
					break;
			if(ind<=pos)
				pila[ind].Modificar();
			else
				obd.Println("Elemento no encontrado");
		}
		else
			obd.Println("Pila Vacia");
	}
	
	public void Borrar()
	{
		pila = new TDA2[pila.length];
		pos=-1;
		obd.Println("Todos los elementos fueron eleminados");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
