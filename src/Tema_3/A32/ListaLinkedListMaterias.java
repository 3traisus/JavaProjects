package Tema_3.A32;

import java.util.LinkedList;

import lib20.Datos;

public class ListaLinkedListMaterias
{
	private int pos, clv;
	private Materias mat;
	private Datos obd = new Datos();
	private LinkedList <Materias> lista = new LinkedList<Materias>();
	
	public int Clave()
	{
		int clv=0;
		if(!lista.isEmpty())
			for(Materias por: lista)
				if(por.getClave()>clv)
					clv=por.getClave();
		return clv+1;
	}
	
	public void Insertar(int op)
	{
		mat = new Materias(this.Clave());
		if(!lista.isEmpty())
		{
			switch(op)
			{
				case 1:
					lista.addFirst(mat);
					break;
				case 2:
					do
						pos=obd.Entero("Cual es la posicion?");
					while(pos<1);
					if(pos<=lista.size())
						lista.add(pos-1,mat);
					else
						lista.addLast(mat);	
					break;
				case 3:
					lista.addLast(mat);
			}
		}
		else
			lista.add(mat);
		obd.Println("Se agrego con exito");
	}
	
	public void Extraer(int op)
	{
		if(!lista.isEmpty())
			switch(op)
			{
				case 1:
					obd.Println("Producto Eliminado");
					lista.removeFirst().Mostrar();
					break;
				case 2:
					do
						clv=obd.Entero("Cual es la clave a Eliminar");
					while(clv<1);
					if(clv<=lista.size())
					{
						obd.Println("Producto Eliminado");
						pos=0;
						for(Materias pro: lista)
						{
							if(pro.getClave()==clv)
							{
								lista.remove(pos).Mostrar();
								break;
							}
								
							pos++;
						}
					}
					else
						obd.Println("La posicion esta fuera del tamaño de la lista");
					break;
				case 3:
					obd.Println("Producto Eliminado");
					lista.removeLast().Mostrar();
			}
		else 
			obd.Println("Lista de productos vacia");
		obd.Println("");
	}
	
	public void Recorrido()
	{
		if(!lista.isEmpty())
		{
			obd.Println("Elementos de la lista");
			for(Materias pro: lista)
			{
				pro.Mostrar();
			}
		}
		else
			obd.Println("Lista de productos vacia");
		obd.Println("");
	}
	
	public void BuscarMod(int op)
	{
		boolean ban=true;
		if(!lista.isEmpty())
		{
			do
				clv=obd.Entero("Cual es la clave del producto"+ (op==4? "Buscar": "Modificar"));
			while(clv<1);
			for(Materias pro: lista)
				if(pro.getClave()==clv)
				{
					obd.Println("Datos del producto");
					pro.Mostrar();
					if(op==5)
						pro.Modificar();
					ban=false;
					break;
				}
			if(ban)
				obd.Println("La clave del producto no existe");
		}
		else
			obd.Println("Lista de productos vacia");
		obd.Println("");
	}
	
	public void Borrar()
	{
		if(!lista.isEmpty())
		{
			lista.clear();
			obd.Println("Lista de productos Borrada");
		}
		else
			obd.Println("Lista de productos vacia");
		obd.Println("");
	}
}
