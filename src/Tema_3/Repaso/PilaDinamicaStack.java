package Tema_3.Repaso;

import java.util.Stack;

import lib20.Datos;

public class PilaDinamicaStack
{
	private int bus;
	private Stack <TDA2> pila = new Stack<TDA2>();
	private Stack <TDA2> aux = new Stack<TDA2>();
	private TDA2 obt;
	private Datos obd = new Datos();
	
	private int Clave()
	{
		if(!pila.isEmpty())
			return (pila.get(pila.size()-1).Clave()+1);
		else
			return 1;
	}
	
	private void Cambio()
	{
		while(!aux.empty())
			pila.push(aux.pop());
	}
	
	public void Insertar()
	{
		pila.push(new TDA2(this.Clave()));
	}
	
	public void Extraer()
	{
		if(!pila.isEmpty())
		{
			obd.Println("Elemento extraido");
			pila.pop().Mostrar();
		}
		else
			obd.Println("Pila Vacia");
			
	}
	
	public void Recorrido()
	{
		if(!pila.isEmpty())
		{
			while(!pila.isEmpty())
			{
				obt = pila.pop();
				obt.Mostrar();
				aux.push(obt);
			}
			this.Cambio();
		}
		else
			obd.Println("Pila Vacia");
	}
	
	public void Busqueda()
	{
		boolean ban=true;
		if(!pila.isEmpty())
		{
			do
				bus = obd.Entero("Clave a buscar");
			while(bus<1);
			while(!pila.isEmpty())
			{
				obt = pila.pop();
				if(obt.Clave()==bus && ban)
				{
					obd.Println("Elemento encontrado");
					obt.Mostrar();
					ban=false;
				}
				aux.push(obt);
			}
			if(ban)
				obd.Println("El trabajador no existe");
			this.Cambio();
		}
		else
			obd.Println("Pila Vacia");
	}
	
	public void Modificar()
	{
		boolean ban=true;
		if(!pila.isEmpty())
		{
			do
				bus = obd.Entero("Clave a buscar");
			while(bus<1);
			while(!pila.isEmpty())
			{
				obt = pila.pop();
				if(obt.Clave()==bus && ban)
				{
					obt.Modificar();
					ban=false;
				}
				aux.push(obt);
			}
			if(ban)
				obd.Println("El trabajador no existe");
			this.Cambio();
		}
		else
			obd.Println("Pila Vacia");
	}
	
	public void Borrar()
	{
		pila = new Stack<TDA2>();
		obd.Println("Todos los elementos fueron eleminados");
	}
}
