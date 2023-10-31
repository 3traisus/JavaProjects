package Tema_4;

import lib20.Datos;

public class Cuenta
{
	private int num;
	private String nom;
	private double sal,mon;
	private Datos obd = new Datos();
	
	public Cuenta(String msj)
	{
		do
			num=obd.Entero(msj);
		while(num<1);
	}
	public Cuenta(int num)
	{
		this.num = num;
		obd.Println("Escribe los datos de la cuenta");
		obd.Println("Numero"+ num);
		do
			nom= obd.Cadena("Nombre:").toUpperCase();
		while(nom.isBlank());
		do
			sal = obd.Doble("Saldo:");
		while(sal<1);
	}
	
	public void Mostrar()
	{
		obd.Println(num+"\t"+nom+"\t"+sal);
	}
	
	public void Deposito()
	{
		do
			mon = obd.Doble("Cual es el monto del deposito");
		while(mon<1);
		sal+=mon;
	}
	
	public void Retiro()
	{
		do
		{
			mon = obd.Doble("Cual es el monto del deposito");
			if(mon>sal)
				obd.Println("Saldo insuficiente");
		}
			
		while(mon<0 || mon>sal);
		sal-=mon; 
	}
	
	public int Numero()
	{
		return this.num;
	}
}
