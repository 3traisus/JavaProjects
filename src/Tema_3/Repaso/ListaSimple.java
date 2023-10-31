package Tema_3.Repaso;

import lib20.Datos;


public class ListaSimple
{
	private int ind=0,con;
	private ListaSimpleLiga ini,fin,pos,temp,ant;
	private Datos obd = new Datos();
	
	private boolean Vacio()
	{
		return ini==null;
	}
	
	private int Clave()
	{
		return ++ind;
	}
	
	private void Camino(int op) //recorrido pos=null;
	{
		for(pos=ini,con=0;pos!=null && con!=(op-1);ant=pos,pos=pos.getSig(),con++);//repasa esto en listaSimple ocupa llevar ant para identificar al padre cuando sea doble no se va a ocupar
	}
	
	private void Camino()
	{
		for(pos=ini;pos!=fin;ant=pos,pos=pos.getSig());
	}
	
	public void Insertar(int op)// recorrido pos = fin;
	{
		if(!this.Vacio())
		{
			switch(op)
			{
				case 1:
					temp = ini;
					ini = new ListaSimpleLiga(new TDA2(this.Clave()));
					ini.setSig(temp);
					break;
				case 2:
					temp = new ListaSimpleLiga(new TDA2(this.Clave()));
					fin.setSig(temp);
					fin=temp;
					break;
				case 3:
					do
						op = obd.Entero("Posicion en la cual insertar");
					while (op<1);
					this.Camino(op);
					if(pos!=null)
					{
						if(pos==ini)
						{
							temp = ini;
							ini = new ListaSimpleLiga(new TDA2(this.Clave()));
							ini.setSig(temp);
						}
						else
							if(pos==fin)
							{
								temp = new ListaSimpleLiga(new TDA2(this.Clave()));
								fin.setSig(temp);
								fin=temp;
							}
							else
							{
								temp = new ListaSimpleLiga(new TDA2(this.Clave()));
								ant.setSig(temp);
								temp.setSig(pos);
							}
					}
					else
						obd.Println("La posicion no existe");
					
			}
		}
		else
		{
			ini = new ListaSimpleLiga(new TDA2(this.Clave()));
			fin = ini;
			obd.Println("hola");
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
					ini = ini.getSig();
					break;
				case 2:
					obd.Println("Elemento extraido");
					fin.getRef().Mostrar();
					this.Camino();
					ant.setSig(null);
					fin = ant;
					break;
				case 3:
					do
						op = obd.Entero("Posicion en la cual insertar");
					while (op<1);
					this.Camino(op);
					if(pos!=null)
					{
						if(pos==ini)
						{
							obd.Println("Elemento extraido");
							ini.getRef().Mostrar();
							ini = ini.getSig();
						}
						else
							if(pos==fin)
							{
								obd.Println("Elemento extraido");
								fin.getRef().Mostrar();
								this.Camino();
								ant.setSig(null);
								fin = ant;
							}
							else
							{
								obd.Println("Elemento extraido");
								pos.getRef().Mostrar();
								ant.setSig(pos.getSig());
							}
					}
					else
						obd.Println("La posicion no existe");
			}
		}
	}
	
	public void Recorrido()
	{
		if(!this.Vacio())
			for(pos=ini;pos!=null;pos=pos.getSig())
				pos.getRef().Mostrar();
		else
			obd.Println("Lista simple Vacia");
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
				obd.Println("Elemento no encontrado");
		}		
		else
			obd.Println("Lista simple Vacia");
	}
	
	public void Modificar()
	{
		if(!this.Vacio())
		{
			do
				con = obd.Entero("Dame la clave a Modificar");
			while(con<1);
			for(pos=ini;pos!=null && pos.getRef().Clave()!=con;pos=pos.getSig());
			if(pos!=null)
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
