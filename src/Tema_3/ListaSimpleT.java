package Tema_3;

import lib20.Datos;

public class ListaSimpleT
{
	private NodoSimpleTra ini,fin,nvo,ant,tmp;
	private int pos,con, tarjeta;
	private Datos obd = new Datos();
	
	public ListaSimpleT()
	{
		ini=fin=null;
	}
	
	private boolean Vacia()
	{
		return ini==null;
	}
	
	public void Insertar( )
	{
		
	}
	
	public void Extraer( )
	{
		
	}
	
	public void Recorrido()
	{
		if(!this.Vacia())
		{
			obd.Println("Trabajadores de la lista");
			for(tmp=ini;tmp!=null;tmp=tmp.getSiguiente())
				tmp.getTrabajador();
		}
		else
			obd.Println("Lista Vacia");
		obd.Println("");
	}
	
	public void BuscarMod(int op)
	{
		if(!this.Vacia())
		{
			do
				tarjeta = obd.Entero("Cual es el numero de tarjeta a"+(op==4?"Buscar":"Modificar")+"?");
			while(tarjeta<1);
			for(tmp=ini;tmp!=null && tmp.getTrabajador().TarClv()!=tarjeta;tmp=tmp.getSiguiente());
			if(tmp!=null)
			{
				obd.Println("Trabajador encontrado:");
				tmp.getTrabajador().Mostrar();
				if(op==5)
				{
					tmp.getTrabajador().Modificar();
					obd.Println("Datos del Trabajador Modificado");
					tmp.getTrabajador().Mostrar();
				}
			}
			else
				obd.Println("El numoer de Tarjeta no existe en la lista");
			
		}
		else
			obd.Println("Lista de Trabajadores Vacia");
		obd.Println("");
	}
	
	public void Borrar()
	{
		if(!this.Vacia())
		{
			ini=fin=null;
			obd.Println("Lista de Trabajadores");
		}
		else
			obd.Println("Lista de Trabajadores Vacia");
		obd.Println("");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
