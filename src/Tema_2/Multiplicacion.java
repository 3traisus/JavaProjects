package Tema_2;

import lib20.Datos;

public class Multiplicacion
{
private Datos obd = new Datos();
	
	public int Numero()
	{	
		int num;
		do
			num = new Datos().Entero("Numero");
		while(num<0);
		return num;
	}
	
	public int Producto (int pro, int num)
	{
		if(pro == 0)
			return 0;
		else 
		{
			return num + this.Producto(pro -1, num);
		}
	}
	
	public void Mostrar(int num)
	{
		obd.Println(""+num);
	}
}
