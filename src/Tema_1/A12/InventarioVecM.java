package Tema_1.A12;

import lib20.Datos;

public class InventarioVecM
{
	private String clv, nom;
	private int ex, por;
	private double comp, vent;
	private Datos obd = new Datos();
	
	public InventarioVecM()
	{
		clv = obd.Cadena("Clave =");
		nom = obd.Cadena("Nombre =");
		ex  = obd.Entero("Existencia =");
		do
			comp = obd.Doble("Compra =");
		while(comp<1);
		do
			por = obd.Entero("Porcentaje =");
		while(por < 20 || por >50);
		vent = comp * por /100 + comp;
		
	}
	
	public void Mostrar()
	{
		System.out.println("Clave:" + clv + "\t Nombre:" + nom + "\t Existencia:" + ex + "\t Compra:" + comp
				+ "\t Porcentaje:" + por + "\t Venta:" + vent);
	}
	
	public String CLV()
	{
		return clv;
	}
	
	public double Inversion()
	{
		double inv = comp * ex;
		return inv;
	}
}
