package Tema_4.A41;

import lib20.Datos;
import lib20.Menu;

public class Articulo
{
	private int clv,exis;
	private String nom;
	private double pre;
	private Datos obd = new Datos();
	
	public Articulo(String msj)
	{
		do
			clv = obd.Entero(msj);
		while(clv<1);		
	}
	
	public Articulo(int clv)
	{
		this.clv = clv;
		do
			nom = obd.Cadena("Nombre del Articulo");
		while(nom.isBlank());
		do
			exis = obd.Entero("Existencias del producto");
		while(exis<1);
		do
			pre = obd.Doble("Precio del Articulo");
		while(pre<1);
	}
	
	public void Mostrar()
	{
		obd.Println(clv+"\t"+nom+"\t"+exis+"\t"+pre);
	}
	
	public void Modificar()
	{
		int op;
		Menu obm = new Menu("Modificar", new String[] {"Nombre","Existencia","Precio"});
		do
			switch(op=obm.Opcion())
			{
				case 1:
					do
						nom = obd.Cadena("Nombre Nuevo");
					while(nom.isBlank());
					break;
				case 2:
					do
						exis = obd.Entero("Existencias Nueva");
					while(exis<1);
					break;
				case 3:
					do
						pre = obd.Doble("Precio Nuevo");
					while(pre<1);
			}
		while(op!=obm.Salir());
		
	}
	
	public int Clv()
	{
		return clv;
	}
}





























