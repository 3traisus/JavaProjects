package Tema_3;

import lib20.Datos;

public class ColaSimpleAlumno
{
	private int ind, pos;
	private Alumno cola[];
	private Datos obd = new Datos();
	private String con;
	private boolean ban=true;
	
	public ColaSimpleAlumno()
	{
		do
			ind= obd.Entero("Tamaño de la cola");
		while(ind<1);
		cola = new Alumno[ind];
		ind=-1;
	}
	
	private boolean vacia()
	{
		return ind==-1;
	}
	
	private boolean llena()
	{
		return ind==cola.length;
	}
	
	public void Insertar()
	{
		if(!this.llena())
		{
			cola[++ind]= new Alumno();
			obd.Println("Alumno asignado con exito");
		}
		else
			obd.Println("Cola llena");
	}
	
	public void Extraer()
	{
		if(this.vacia())
		{
			obd.Println("Alumno Extraido");
			cola[0].Mostrar();
			for(pos=0;pos<ind;pos++)
				cola[pos]=cola[pos+1];
			ind--;
		}
		else
			obd.Println("Cola Vacia");
		obd.Println("");
	}
	
	public void Recorrido()
	{
		if(!this.vacia())
		{
			obd.Println("Alumnos de la cola");
			for(pos=0;pos<=ind;pos++)
				cola[pos].Mostrar();
		}
		else
			obd.Println("Cola vacia");
		obd.Println("");
	}
	
	public void Buscar()
	{
		if(!this.vacia())
		{
			do
				con = obd.Cadena("No. de control a buscar").toUpperCase();
			while(con.isBlank());
			for(pos=0;pos<=ind;pos++)
				if(cola[pos].Control().equals(con))
				{
					obd.Println("Alumno encontrado");
					cola[pos].Mostrar();
					break;
				}
			if(pos>ind)
				obd.Println("Alumno no encontrado");
		}
		else
			obd.Println("Cola Vacia");
		obd.Println("");
	}
	
	public void Modificar()
	{
		if(!this.vacia())
		{
			do
				con = obd.Cadena("No. de control a modificar").toUpperCase();
			while(con.isBlank());
			for(Alumno oba:cola)
				if(oba!=null && oba.Control().equals(con))
				{
					obd.Println("Datos del alumno");
					oba.Mostrar();
					oba.Modificar();
					obd.Println("Alumno Modificado");
					oba.Mostrar();
					ban=false;
					break;
				}
			if(ban)
				obd.Println("Alumno no encontrado");
		}
		else
			obd.Println("Cola Vacia");
		obd.Println("");
	}
	
	public void Borrar()
	{
		if(!this.vacia())
		{
			cola = new Alumno[cola.length];
			ind=-1;
			obd.Println("Cola borrada");
		}
		else
			obd.Println("Cola Vacia");
		obd.Println("");
	}
	
}























