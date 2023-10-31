package Tema_3;

import java.util.LinkedList;

import lib20.Datos;

public class ListaLinkedListP
{
	private int pos, clv;
	private ProductoOp pro;
	private Datos obd = new Datos();
	private LinkedList <ProductoOp> lista = new LinkedList<ProductoOp>();
	
	
	public int Clave()
	{
		int clv=0;
		if(!lista.isEmpty())
			for(ProductoOp por: lista)
				if(pro.Clave()>clv)
					clv=pro.Clave();
		return clv+1;
	}
	
	public void Insertar(int op)
	{
		pro = new ProductoOp(this.clv);
		if(!lista.isEmpty())
		{
			switch(op)
			{
				case 1:
					lista.addFirst(pro);
					break;
				case 2:
					do
						pos=obd.Entero("Cual es la posicion?");
					while(pos<1);
					if(pos<=lista.size())
						lista.add(pos-1,pro);
					else
						lista.addLast(pro);	
					break;
				case 3:
					lista.addLast(pro);
			}
		}
		else
			lista.add(pro);
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
						pos=obd.Entero("Cual es la posicion");
					while(pos<1);
					if(pos<=lista.size())
					{
						obd.Println("Producto Eliminado");
						lista.remove(pos-1).Mostrar();
					}
					else
						obd.Println("La posicion esta fuera del tamaño de la lista");
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
			for(ProductoOp pro: lista)
				if(pro.Clave()==clv)
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



























