package Tema_3;

import lib20.Datos;

public class ColasSimple
{
	private int ind,pos;
	private String cola[],nom;
	private Datos obd  = new Datos();
	private boolean ban=true;
	
	public ColasSimple()
	{
		do
			ind=obd.Entero("Capacidad de la cola");
		while(ind<1);
		cola= new String[ind];
		ind=-1;
		obd.Println("");
	}
	
	private boolean Vacia()
	{
		return ind==-1;
	}
	private boolean Llena()
	{
		return ind==cola.length-1;
	}
	
	public void Insertar()
	{
		if(!this.Llena())
		{
			do
				nom = obd.Cadena("Nombre a insertar").toUpperCase();
			while(nom.isBlank());
			cola[++ind]=nom;
			obd.Println("Alumno insertado con exito");
		}
		else
			obd.Println("Cola Llena");
		obd.Println("");
	}
	
	public void Extraer()
	{
		if(!this.Vacia())
		{
			obd.Println("Alumno que salido del salon" + cola[0]);
			for(pos=0; pos<ind; pos++)
				cola[pos]=cola[pos+1];
			ind--;
		}
		else
			obd.Println("Cola Vacia");
		obd.Println("");
	}
	
	public void Recorrido()
	{
		if(!this.Vacia())
		{
			obd.Println("Alumnos que estan en la clase(Cola)");
			for(pos=0;pos<=ind;pos++)
				obd.Println(""+cola[pos]);
		}
		else
			obd.Println("Cola Vacia");
		obd.Println("");
			
	}
	
	public void Buscar()
	{
		if(!this.Vacia())
		{
			do
				nom = obd.Cadena("Nombre o Apellido a buscar").toUpperCase();
			while(nom.isBlank());
			for(pos=0;pos<=ind;pos++)
				if(cola[pos].indexOf(nom)!=-1)
				{
					obd.Println("Alumno Encontrado \t"+ cola[pos]);
					ban =  false;
				}
		if(ban)
			obd.Println("El nombre o apellido no se encuentra");
		}
		else
			obd.Println("Cola Vacia");
		obd.Println("");
			
	}
	
	public void Modificar()
	{
		if(!this.Vacia())
		{
			do
				nom = obd.Cadena("Nombre Completo a Modificar").toUpperCase();
			while(nom.isBlank());
			for(pos=0;pos<=ind;pos++)
				if(cola[pos].equals(nom))
				{
					do
						cola[pos] = obd.Cadena("Nuevo Nombre").toUpperCase();
					while(cola[pos].isBlank());
					break;
				}
		if(pos>ind)
			obd.Println("El nombre no se encontro");
		}
		else
			obd.Println("Cola Vacia");
		obd.Println("");
			
	}
	
	public void Borrar()
	{
		if(!this.Vacia())
		{
			//cola = new String[cola.length]; borra la memoria
			ind=-1;//no borra la memoria sola la remplaza
			obd.Println("Cola Vacia");
		}
		else
			obd.Println("Cola Vacia");
		obd.Println("");
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}