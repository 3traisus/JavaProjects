package Tema_4.A41;

import java.util.LinkedList;
import lib20.Datos;

public class ArbolArticulo
{
	private NodoArticulo raiz,nvo,ant,act,may;
	private Datos obd = new Datos();
	private LinkedList<NodoArticulo> lista = new LinkedList<NodoArticulo>();
	
	public ArbolArticulo()
	{
		raiz=null;
	}
	
	private boolean Vacio()
	{
		return raiz==null;
	}
	
	private int Num()
	{
		if(!this.Vacio())
		{
			for(may = raiz; may.getDer()!=null;may=may.getDer());
			return may.getArt().Clv()+1;
		}
		else
			return 1;	
	}
	
	private void Existe()
	{
		for(ant=raiz,act = raiz; act!=null && act.getArt().Clv()!=nvo.getArt().Clv(); 
				ant=act, act= act.getDer());                    
		
	}
	
	public void Insertar()
	{
		nvo = new NodoArticulo(new Articulo(this.Num()));
		if(!this.Vacio())
		{
			this.Existe();
			ant.setDer(nvo);
		}
		else
			raiz=nvo;
		obd.Println("Cuenta almacenada con exito");
	}
	
	public void Recorrer()
	{
		if(!this.Vacio())
		{
			obd.Println("Lista de Articulos de arbol");
			lista.clear();
			lista.addFirst(raiz);
			while(!lista.isEmpty())
			{
				may =lista.removeFirst();
				may.getArt().Mostrar();
				/*if(may.getIzq()!=null)
					lista.addLast(may.getIzq());
				else*/
					if(may.getDer()!=null)
						lista.addLast(may.getDer());
			}
		}
		else
			obd.Println("Arbol Vacio");
	}
	
	public void Buscar(int op)
	{
		if(!this.Vacio())
		{
			nvo = new NodoArticulo(new Articulo("Clave de Cuenta a "+(op==3?"Buscar":"Modificar")));
			this.Existe();
			if(act!=null)
			{
				obd.Println("Datos del Articulo");
				act.getArt().Mostrar();
				if(op==4)
					act.getArt().Modificar();
			}
			else
				obd.Println("Clave inexistente");
		}
		else
			obd.Println("Arbol binario de Articulos vacio");
		obd.Println("");
	}
	
	public void Borrar()
	{
		if(!this.Vacio())
		{
			nvo = new NodoArticulo(new Articulo("Clave de articulo a Eliminar"));
			this.Existe();
			if(act!=null)
			{
				obd.Println("Numero Eliminado");
				if(act!=raiz)
					if(act.getDer()==null)
						ant.setDer(null);
					else 
						ant.setDer(act.getDer());
				else
					raiz = act.getDer();
			}
			else
				obd.Println("La clave no se encuentra en el arbol");
		}
		else
			obd.Println("Arbol vacio");
	}
}



/*public void Fusion()
{
	if(!this.Vacio())
	{
		nvo = new NodoArticulo(new Articulo("Clave de articulo a Eliminar"));
		this.Existe();
		if(act!=null)
		{
			//
			obd.Println("Numero Eliminado");
			if(act.getDer()==null)
				nvo= act.getIzq();
			else 
				if(act.getIzq()==null)
					nvo = act.getDer();
				else
				{
					may = act.getIzq();
					while(may.getDer()!=null)
					{
						may = may.getDer();
					}
					may.setDer(act.getDer());
				}
			if(act!=raiz)
				if(ant.getDer()==act)//Aqui otorgamos la ruta nueva para poder eliminar 
					ant.setDer(nvo);
				else
					ant.setIzq(nvo);
			else raiz =nvo;
		}
		else
			obd.Println("La clave no se encuentra en el arbol");
	}
	else
		obd.Println("Arbol vacio");
}
}*/
























