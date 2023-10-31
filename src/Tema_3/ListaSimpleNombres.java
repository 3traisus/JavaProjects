package Tema_3;

import lib20.Datos;

public class ListaSimpleNombres
{
	private NodoSimple ini,fin,nvo,ant;
	private Datos obd = new Datos();
	private String nom;
	private int pos,con;
	
	public ListaSimpleNombres()
	{
		ini=fin=null;
	}
	
	private boolean Vacia()
	{
		return ini==null;
	}
	
	public void InsertarIni()
	{
		do
			nvo= new NodoSimple(obd.Cadena("Nombre insertar inicio"));
		while(nvo.getNombre().isBlank());
		if(!this.Vacia())
		{
			nvo.setSiguiente(ini);
			ini=nvo;
		}
		else
			ini=fin=nvo;	
	}
	
	public void InsertarFinal()
	{
		do
			nvo= new NodoSimple(obd.Cadena("Nombre insertar inicio"));
		while(nvo.getNombre().isBlank());
		if(!this.Vacia())
		{
			fin.setSiguiente(nvo);
			fin=nvo;
		}
		else
			ini=fin=nvo;	
	}
	
	public void InsertarPos()
	{
		if(!this.Vacia())
		{
			do
				pos=obd.Entero("Cual es la posicion donde desea insertar");
			while(pos<1 && pos>this.Tamaño());
			if(pos==1)
				this.InsertarIni();
			else
				if(pos>this.Tamaño())
					this.InsertarFinal();
				else
				{
					do
						nvo = new NodoSimple(obd.Cadena("Nombre a insertar en la posicion")+pos);
					while(nvo.getNombre().isBlank());
					for(ant = ini, con=1;con<pos-1;ant=ant.getSiguiente(),con++);
					nvo.setSiguiente(ant.getSiguiente());
					ant.setSiguiente(nvo);
				}
		}
		else
		{
			do
				nvo= new NodoSimple(obd.Cadena("Nombre a insertar en la lista vacia"));
			while(nvo.getNombre().isBlank());
			ini=fin=nvo;
		}	
	}
	
	private int Tamaño()
	{
		int can;
		for(nvo=ini,can=1; nvo.getSiguiente()!=null;nvo=nvo.getSiguiente(),can++);
		return can;
	}
	
	
	public void ExtraerIni()
	{
		if(!this.Vacia())
		{
			obd.Println("Nombre extraido del inicio de la lista"+ini.getNombre());
			ini=ini.getSiguiente();
		}
		else
			obd.Println("Lista de nombres Vacia");
		obd.Println("");
	}
	
	public void ExtraerFinal()
	{
		if(!this.Vacia())
		{
			obd.Println("Nombre extraido del inicio de la lista"+fin.getNombre());
			for(nvo=ini; nvo.getSiguiente()!=fin;nvo=nvo.getSiguiente());
			fin=nvo;
			fin.setSiguiente(null);
		}
		else
			obd.Println("Lista de nombres Vacia");
		obd.Println("");
	}
	
	public void ExtraerPos()
	{
		if(!this.Vacia())
		{
			do
				pos=obd.Entero("Cual es la posicion del nombre a extraer (1-"+this.Tamaño()+")");
			while(pos<1 && pos>this.Tamaño());
			if(pos==1)
				this.ExtraerIni();
			else
				if(pos==this.Tamaño())
					this.ExtraerFinal();
				else 
				{
					for(ant = ini, con=1;con<pos-1;ant=ant.getSiguiente(),con++);
					/*nvo=ant.getSiguiente();
					ant.setSiguiente(nvo.getSiguiente());*/
					ant.setSiguiente(ant.getSiguiente().getSiguiente());
				}
			nvo = new NodoSimple(obd.Cadena("Nombre a extraer de la posicion"+pos));
			
		}
	}
	
	public void Recorrido()
	{
		if(!this.Vacia())
		{
			for(nvo=ini; nvo!=null;nvo=nvo.getSiguiente())
				obd.Println(nvo.getNombre());
		}
		else
			obd.Println("Lista de nombres Vacia");
		obd.Println("");
	}
	
	public void Buscar()
	{
		if(!this.Vacia())
		{
			do
				nom = obd.Cadena("Nombre a buscar").toUpperCase();
			while(nom.isBlank());
			for(nvo=ini, pos=1; nvo!=null && !nvo.getNombre().equals(nom);nvo=nvo.getSiguiente(),pos++);
				if(nvo!=null)
					obd.Println("Nombre encontrado en la posicion"+pos);
				else 
					obd.Println("El nombre que busca no existe");
		}
		else
			obd.Println("Lista de nombres Vacia");
		obd.Println("");
	}
	
	public void Modificar()
	{
		if(!this.Vacia())
		{
			do
				nom = obd.Cadena("Nombre a Modificar").toUpperCase();
			while(nom.isBlank());
			for(nvo=ini; nvo!=null && !nvo.getNombre().equals(nom);nvo=nvo.getSiguiente())
				if(nvo!=null)
				{
					do
						nvo.setNombre(obd.Cadena("Escribe el nuevo nombre").toUpperCase(null));
					while(nvo.getNombre().isBlank());
					obd.Println("Nombre modificado");
				}
				else 
					obd.Println("El nombre que busca no existe");
		}
		else
			obd.Println("Lista de nombres Vacia");
		obd.Println("");
	}
	
	public void Borrar()
	{
		if(!this.Vacia())
		{
			ini=fin=null;
			obd.Println("Lista borrada");
		}
		else
			obd.Println("Lista de nombres Vacia");
		obd.Println("");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
