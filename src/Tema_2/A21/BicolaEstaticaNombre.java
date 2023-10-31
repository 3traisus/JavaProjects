package Tema_2.A21;

import lib20.Datos;

public class BicolaEstaticaNombre
{
	private int ind, pos;
	private String bicola[],nom;
	private Datos obd = new Datos();
	
	public BicolaEstaticaNombre()
	{
		do
			ind=obd.Entero("Tamallo de la bicola");
		while(ind<1);
		bicola = new String[ind];
		ind=-1;
	}
	
	private boolean Vacia()
	{
		return ind==-1;
	}
	
	private boolean Llena()
	{
		return ind==bicola.length-1;
	}
	
	public void Insertar()
	{
		if(!this.Llena())
		{
			for(pos=ind;pos>=0;pos--)
				bicola[pos+1]=bicola[pos];
			ind++;
			do
				bicola[0]= obd.Cadena("Nombre insertar inicio").toUpperCase();
			while(bicola[0].isBlank());
		}else
			obd.Println("Bicola llena");
		obd.Println("");
	}
	
	public void InsertarF()
	{
		if(!this.Llena())
		{
			ind++;
			do
				bicola[ind]= obd.Cadena("Nombre insertar inicio").toUpperCase();
			while(bicola[ind].isBlank());
		}else
			obd.Println("Bicola llena");
		obd.Println("");
	}
	
	public void Extraer()
	{
		if(!this.Vacia())
		{
			obd.Println("Nombre Extraido del inicio " + bicola[0]);
			for(pos=0;pos<ind;pos++)
			{	
				bicola[pos]=bicola[pos+1];
			}
			ind--;
		}else
			obd.Println("Bicola Vacia");
		obd.Println("");
	}
	
	public void ExtraerF()
	{
		if(!this.Vacia())
		{
			obd.Println("Nombre extraido del final"+ bicola[ind]);
			ind--;
		}
	}
	
	public void Recorrido()
	{
		if(!this.Vacia())
		{
			obd.Println("Nombres de la bicola");
			for(pos=0;pos<=ind;pos++)
				obd.Println(bicola[pos]);
		}else
			obd.Println("Bicola Vacia");
		obd.Println("");
		
	}
	
	public void Buscar()
	{
		if(!this.Vacia())
		{
			do
				nom=obd.Cadena("Nombre a buscar en bicola").toUpperCase();
			while(nom.isBlank());
			for(pos=0;pos<=ind;pos++)
				if(bicola[pos].equals(nom))
				{
					obd.Println("Nombre encontrado en la posicion"+(pos+1));
					break;
				}
			if(pos>ind)
				obd.Print("Nombre no encontrado");
		}
		else
			obd.Println("Bicola vacia");
		obd.Println("");
	}
	
	public void Modificar()
	{
		if(!this.Vacia())
		{
			do
				nom=obd.Cadena("Nombre a Modificar en bicola").toUpperCase();
			while(nom.isBlank());
			for(pos=0;pos<=ind;pos++)
				if(bicola[pos].equals(nom))
				{
					do
						bicola[pos]=obd.Cadena("Nombre nuevo").toUpperCase();
					while(bicola[pos].isBlank());
					break;
				}
			if(pos>ind)
				obd.Print("Nombre no encontrado");
		}
		else
			obd.Println("Bicola vacia");
		obd.Println("");
	}
	
	public void Borrar()
	{
		if(!this.Vacia())
		{
			bicola= new String[bicola.length];
			ind=-1;
			obd.Println("Bicola borrada");
		}
		else
			obd.Println("Bicola Vacia..");
		obd.Println("");
	}
}























