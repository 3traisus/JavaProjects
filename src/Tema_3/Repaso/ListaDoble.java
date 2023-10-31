package Tema_3.Repaso;

import lib20.Datos;

public class ListaDoble
{
	private int ind=0,con;
	private ListaDobleLiga ini,fin,nvo,pos,ant;
	private Datos obd = new Datos();
	
	private int Clave()
	{
		return ++ind;
	}
	
	private boolean Vacio()
	{
		return ini==null;
	}
	
	private void Camino(int op)
	{
		for(con=0,pos=ini;pos!=null && con!=(op-1);ant = pos,pos = pos.getSig(), con++);
	}
	
	
	
	public void Insertar(int op)
	{
		if(!this.Vacio())
		{
			switch(op)
			{
				case 1:
					nvo =  new ListaDobleLiga(new TDA2(this.Clave()));
					ini.setAnt(nvo);
					nvo.setSig(ini);
					ini=nvo;
					break;
				case 2:
					nvo =  new ListaDobleLiga(new TDA2(this.Clave()));
					nvo.setAnt(fin);
					fin.setSig(nvo);
					fin=nvo;
					break;
				case 3:
					do
						op = obd.Entero("Dame la posicion a insertar");
					while(op<1 || op>ind);
					this.Camino(op);
					if(pos==ini)
					{
						nvo =  new ListaDobleLiga(new TDA2(this.Clave()));
						ini.setAnt(nvo);
						nvo.setSig(ini);
						ini=nvo;
					}
					else
						if(pos==fin)
						{
							nvo =  new ListaDobleLiga(new TDA2(this.Clave()));
							nvo.setAnt(fin);
							fin.setSig(nvo);
							fin=nvo;
						}
						else
						{
							nvo =  new ListaDobleLiga(new TDA2(this.Clave()));
							pos.setAnt(nvo);
							nvo.setSig(pos);
							ant.setSig(nvo);
							nvo.setAnt(ant);
						}
					
			}
		}
		else
		{
			ini = new ListaDobleLiga(new TDA2(this.Clave()));
			fin = ini;
		}
	}
	
	public void Extraer(int op)
	{
		if(!this.Vacio())
		{
			switch(op)
			{
				case 1:
					obd.Println("Elemento extraido");
					ini.getRef().Mostrar();
					ini=ini.getSig();
					break;
				case 2:
					obd.Println("Elemento extraido");
					fin.getRef().Mostrar();
					fin = fin.getAnt();
					fin.setSig(null);
					break;
				case 3:
					do
						op = obd.Entero("Dame la posicion a insertar");
					while(op<1 || op>ind);
					this.Camino(op);
					if(pos==ini)
					{
						obd.Println("Elemento extraido");
						ini.getRef().Mostrar();
						ini=ini.getSig();
					}
					else
						if(pos==fin)
						{
							obd.Println("Elemento extraido");
							fin.getRef().Mostrar();
							fin = fin.getAnt();
							fin.setSig(null);
						}
						else
						{
							obd.Println("Elemento extraido");
							pos.getRef().Mostrar();
							ant.setSig(pos.getSig());
							pos.getSig().setAnt(ant);
						}
					
			}
		}
		else
		{
			ini = new ListaDobleLiga(new TDA2(this.Clave()));
			ini= fin;
		}
	}
	
	public void Recorrer()
	{
		if(!this.Vacio())
			for(pos=ini;pos!=null;pos=pos.getSig())
				pos.getRef().Mostrar();
		else
			obd.Println("ListaDoble Vacia");
		
	}
	
	public void Busqueda()
	{
		if(!this.Vacio())
		{
			do
				con = obd.Entero("Dame la clave a buscar");
			while(con<1);
			for(pos=ini;pos!=null && pos.getRef().Clave()!=con;pos=pos.getSig());
			if(pos!=null)
				obd.Println("Elemento encontrado");
			else
				obd.Println("Clave no existente");
		}
		else
			obd.Println("ListaDoble Vacia");

	}
	
	public void Modificar()
	{

		if(!this.Vacio())
		{
			do
				con = obd.Entero("Dame la clave a Modifcar");
			while(con<1);
			for(pos=ini;pos!=null && pos.getRef().Clave()!=con;pos=pos.getSig());
			if(pos!=null)
				pos.getRef().Modificar();
			else
				obd.Println("Clave no existente");
		}
		else
			obd.Println("ListaDoble Vacia");

	}
	
	public void Borrar()
	{
		obd.Println("ListaDoble Borrada");
		ini=fin=null;
	}
}
