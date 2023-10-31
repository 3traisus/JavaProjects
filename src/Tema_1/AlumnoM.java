package Tema_1;

import lib20.Datos;

public class AlumnoM 
{
	private Alumno[] al;
	private int ind;
	private Datos obd = new Datos();
	
	public AlumnoM()
	{
		do
			ind = obd.Entero("Cantidad de Alumnos");
		while(ind<1);
		al = new Alumno[ind];
		ind = -1;
	}
	
	public void Nuevo()
	{
		if((ind+1)<al.length)
		{
			al[++ind]= new Alumno();
		}else
		{
			obd.Println("No hay sistema");
		}
	}
	
	public void Lista()
	{
		if(ind!=-1)
			for(int x=0;x<=ind;x++)
			{
				al[x].Mostrar();
			}
		else
			obd.Println("Debes registrar al menos un alumno");
	}
	
	public void Buscar()
	{
		if(ind!=-1)
		{
			String bus=obd.Cadena("NC a buscar");
			int x=-1;
			try
			{
				for(;x<=ind;)
				{
					if(al[++x].Control().equalsIgnoreCase(bus))
					{
						al[x].Mostrar();
						break;
					}		
				}
				/*if(x>ind) ////// no entra aqui 
					obd.Println("No hay nadie en el sistema llamado asi");*/
			}catch(ArrayIndexOutOfBoundsException e)
			{
				obd.Println("java es asombroso");
			}
		}
		else
			obd.Println("Debes registrar al menos un alumno");
	}
}
