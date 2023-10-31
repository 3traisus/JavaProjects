package Tema_3;

import lib20.Datos;

public class ListaSimpleCM
{
	private NodoSimpleCM ini, fin,nvo, act;
	private int clv;
	private Datos obd = new Datos();
	
	public ListaSimpleCM()
	{
		ini=fin=null;
	}
	
	private boolean Vacia()
	{
		return ini==null;
	}
	
	private int Tamaño()
	{
		return 0;
	}
	
	public int Clave()
	{
		return clv+1;
	}
	
	public void Insertar(int op)
	{
		
	}
	
	public void Extraer(int op)
	{
		
	}
	
	public void Recorrido()
	{
		if(!this.Vacia())
		{
			obd.Println("Lista de elementos");
			act=ini;
		}
		else
			obd.Println("Lista Circular Vacia");
		obd.Println("");
	}
	
	public void BuscarMod(int op)
	{
		if(!this.Vacia())
		{
			do
				clv=obd.Entero("Clave de la materia a"+(op==4? "Buscar":"Modificar"));
			while(clv<1);
			act=ini;
			do
			{
				if(act.getMat().Clave()==clv)
				{
					obd.Println("Datos de la materia");
					act.getMat().Mostrar();
					if(op==5)
						act.getMat().Modificar();
					break;
				}
				act=act.getSig();
			}
			while(act!=ini);
			if(act==ini)
				obd.Println("La clave no esta en la lista Circular");
		}
		else
			obd.Println("Lista Circular Vacia");
		obd.Println("");
	}
	
	public void Borrar()
	{
		if(!this.Vacia())
		{
			ini=fin=null;
			obd.Println("Lista Circular de MAterias Borrada");
		}
		else
			obd.Println("Lista de materias Vacias");
		obd.Println("");
	}
}
