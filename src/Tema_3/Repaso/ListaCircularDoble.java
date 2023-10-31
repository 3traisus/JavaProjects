package Tema_3.Repaso;

import lib20.Datos;

public class ListaCircularDoble
{
	private int ind=0,con,x,bus;
	private ListaDobleLiga ini,fin,nvo,pos,ant;
	private Datos obd = new Datos();
	
	private boolean Vacio()
	{
		return ini==null;
	}
	
	private int Tama�o()
	{
		int x=-1;
		for(pos=ini,x=0;pos!=fin;pos=pos.getSig(),x++);
		return x;
	}
	
	private void Camino(int op)
	{
		for(con=0,pos=ini;pos!=fin && con!=(op-1);ant = pos,pos = pos.getSig(), con++);
	}
	
	private void Camino()
	{
		for(pos=ini;pos!=fin;ant=pos,pos=pos.getSig());
	}
	
	private int Clave()
	{
		return ++ind;
	}
	
	public void Insertar(int op)
	{
		nvo = new ListaDobleLiga(new TDA2(this.Clave()));
		if(!this.Vacio())
		{
			switch(op)
			{
				case 1:
						nvo.setSig(ini);
						ini.setAnt(nvo);
						ini = nvo;
					break;
				case 2:
						fin.setSig(nvo);
						nvo.setAnt(fin);
						fin = nvo;
					break;
				case 3:
					do
						op=obd.Entero("Dame la posicion a insertar");
					while(op<1);
					this.Camino(op);
					if(pos==ini)
					{
						nvo.setSig(ini);
						ini.setAnt(nvo);
						ini = nvo;
					}
					else
						if(pos==fin)
						{
							fin.setSig(nvo);
							nvo.setAnt(fin);
							fin = nvo;
						}
						else
						{
							ant.setSig(nvo);
							nvo.setAnt(ant);
							nvo.setSig(pos);
							pos.setAnt(nvo);
						}				
			}
		}
		else
		{
			ini = fin = nvo;
			ini.setSig(fin);
		}
		fin.setSig(ini);
		ini.setAnt(fin);
	}
	
	public void Extraer(int op)
	{
		if(!this.Vacio())
		{
			if(ini!=fin)
			{
				switch(op)
				{
					case 1:
						ini = ini.getSig();
						break;
					case 2:
						fin = fin.getAnt();
						break;
					case 3:
						do
							op=obd.Entero("Dame la posicion a insertar");
						while(op<1);
						this.Camino(op);
						if(pos==ini)
						{
							ini = ini.getSig();
						}
						else
							if(pos==fin)
							{
								fin = fin.getAnt();
							}
							else
							{
								ant.setSig(pos.getSig());
								pos.getSig().setAnt(ant);
							}				
				}
			}
			else
				ini = fin = null;

		}
		else
			obd.Println("ListaCircularDoble vacia");
		
		fin.setSig(ini);
		ini.setAnt(fin);
	}
	
	public void Recorrido()
	{
		con = this.Tama�o();
		if(!this.Vacio())
			for(pos=ini,x=0;x<=con;pos=pos.getSig(),x++)
				pos.getRef().Mostrar();
		else
			obd.Println("Lista simple Vacia");
	}
	
	public void Busqueda()
	{
		con = this.Tama�o();
		if(!this.Vacio())
		{
			do
				bus = obd.Entero("Dame la clave a buscar");
			while(bus<1);
			for(pos=ini,x=0;x<=con && pos.getRef().Clave()!=bus;pos=pos.getSig(),x++);
			if(x<=con)
				obd.Println("Elemento encontrado"+(x+1));
			else
				obd.Println("Elemento no encontrado");
		}		
		else
			obd.Println("Lista simple Vacia");
	}
	
	public void Modificar()
	{
		con = this.Tama�o();
		if(!this.Vacio())
		{
			do
				bus = obd.Entero("Dame la clave a Modificar");
			while(bus<1);
			for(pos=ini,x=0;x<=con;pos=pos.getSig(),x++)
				if(pos.getRef().Clave()==bus)
					pos.getRef().Modificar();
			else
				obd.Println("Elemento no encontrado");
		}		
		else
			obd.Println("Lista simple Vacia");
	}
	
	public void Borrar() 
	{
		obd.Println("Lista simple borrada");
		ini=fin=null;
	}
}
