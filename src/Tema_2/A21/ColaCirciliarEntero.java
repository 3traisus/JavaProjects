package Tema_2.A21;

import lib20.Datos;

public class ColaCirciliarEntero
{
	private int ini,fin,pos,num;
	private int cola[];
	private Datos obd = new Datos();
	
	public ColaCirciliarEntero()
	{
		do
			ini=obd.Entero("Tamaño de la cola circular");
		while(ini<1);
		cola = new int[ini];
		ini=-1;
	}
	
	private boolean Vacia()
	{
		return ini==-1;
	}
	
	private boolean Llena()
	{
		return ini==0 && fin==cola.length-1 || ini-1==fin;
	}
	
	public void Insertar()
	{
		if(!this.Llena())
		{
			if(this.Vacia())
				ini=fin=0;
			else
				fin=(fin+1==cola.length)?0:fin+1;
			cola[fin] = obd.Entero("Escribe ek numero entera en la cola circular");
		}else
			obd.Println("Cola Circular llena");
		obd.Println("");
	}
	
	public void Extraer ()
	{
		if(!this.Vacia())
		{
			obd.Println("Numero extraido de la cola circular"+cola[ini]);
			if(ini==fin)
				ini=fin=-1;
			else
				ini=(ini+1==cola.length)?0:ini+1;
			
		}else 
			obd.Println("Cola circular vacia");
		obd.Println("");
	}
	
	public void Recorrido()
	{
		if(!this.Vacia())
		{
			for(pos=ini;pos!=fin;pos=(pos+1==cola.length)?0:pos+1)
				obd.Println(""+cola[pos]);
			obd.Println(""+cola[pos]);
				
		}else
			obd.Println("Cola Vacia");
		obd.Println("");
	}
	
	public void Buscar()
	{
		if(!this.Vacia())
		{
			num=obd.Entero("Numero a buscar");
			for(pos=ini;pos!=fin;pos=(pos+1==cola.length)?0:pos+1)
				if(cola[pos]==num)
					break;
			if(cola[pos]==num)
				obd.Println("Numero encontrado en cola circular");
			else
				obd.Println("Numero no encontrado");
		}else
			obd.Println("Cola circular vacia");
		obd.Println("");
	}
	
	public void Modificar()
	{
		if(!this.Vacia())
		{
			num=obd.Entero("Numero a buscar");
			for(pos=ini;pos!=fin;pos=(pos+1==cola.length)?0:pos+1)
				if(cola[pos]==num)
					break;
			if(cola[pos]==num)
				cola[pos]=obd.Entero("Escribe numero modificado");
			else
				obd.Println("Numero no encontrado");
		}else
			obd.Println("Cola circular vacia");
		obd.Println("");
	}
		
	public void Borrar()
	{
		if(!this.Vacia())
		{
			cola=new int[cola.length];
			ini=fin=-1;
			obd.Println("Cola circular borrada");
		}else
			obd.Println("Cola vacia");
		obd.Println("");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}





























