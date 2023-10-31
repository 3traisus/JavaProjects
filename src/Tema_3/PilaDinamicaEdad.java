package Tema_3;

import java.util.Stack;

import lib20.Datos;

public class PilaDinamicaEdad
{
	private int edad,edadb;
	private Datos obd = new Datos();
	private Stack<Integer> pil = new Stack<Integer>();
	private Stack<Integer> aux = new Stack<Integer>();
	private boolean ban;
	
	public void Insertar()
	{
		do
			edad = obd.Entero("Edad");
		while(edad<1 || edad>100);
		pil.push(edad);
		System.out.println("Edad Almacenada en la pila");
	}
	
	public void Extraer()
	{
		if(!pil.empty())
			obd.Println("Edad Eliminada de la pila" + pil.pop());
		else
			obd.Println("Pila Vacia");
		obd.Println("");
	}
	
	public void Recorrido()
	{
		if(!pil.empty())
		{
			obd.Println("Edades de la pila");
			do
			{
				edad = pil.pop();
				obd.Println(""+edad);
				aux.push(edad);
			}
			while(!pil.empty());
			while(!aux.empty())
				pil.push(aux.pop());
		}else
			obd.Println("Pila vacia");
		obd.Println("");
	}
	
	public void Buscar()
	{
		ban = true;
		int con=0;
		if(!pil.empty())
		{
			do
				edadb=obd.Entero("Edad a buscar");
			while(edad<1 || edad>100);
			do
			{
				edad = pil.pop();
				if(edad==edadb)
				{
					con++;
					ban=false;
				}
				aux.push(edad);
			}
			while(!pil.empty());
			while(!aux.empty())
				pil.push(aux.pop());
			if(ban)
				obd.Println("La edad no estan en la pila.");
			else
				obd.Println("La edad la encontramos "+ con + "Veces");
		}
		else
			obd.Println("Pila Vacia");
		obd.Println("");;
		
	}
	
	public void Modificar()
	{
		ban = true;
		if(!pil.empty())
		{
			do
				edadb=obd.Entero("Edad a Modificar");
			while(edad<1 || edad>100);
			do
			{
				edad = pil.pop();
				if(edad==edadb)
				{
					do
						edad=obd.Entero("Nueva Edad");
					while(edad<1 || edad>100);
					ban=false;
				}
				aux.push(edad);
			}
			while(!pil.empty() && ban);
			while(!aux.empty())
				pil.push(aux.pop());
			if(ban)
				obd.Println("La edad no esta en la pila");
			else
				obd.Println("La edad fue modificada");
				
		}
		else
			obd.Println("Pila Vacia");
		obd.Println("");;
		
	}
	
	public void Borrar()
	{
		if(!pil.empty())
		{
			while(!pil.empty())
				pil.pop();
			obd.Print("Pila Borrada");
		}
		else
			obd.Println("Pila Vacia");
		obd.Println("");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
