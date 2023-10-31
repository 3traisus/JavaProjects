package Tema_2;

import lib20.Datos;

public class Elevacion
{
	private Datos obd = new Datos();
	
	public int Numero()
	{
		return obd.Entero("Numero a Elevar");
	}
	
	public int Potencia()
	{
		int pot;
		do
			pot = obd.Entero("Potencia deseada");
		while(pot<0);
		return pot;
	}
	
	public int Elevar (int pot, int num)
	{
		if(pot == 0)
			return 1;
		else 
		{
			return num * this.Elevar(pot -1, num);
		}
	}
	
	public void Mostrar(int num)
	{
		obd.Println(""+num);
	}
}
