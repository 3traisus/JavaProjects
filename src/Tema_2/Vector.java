package Tema_2;

import java.util.Random;

import lib2020.Datos;

public class Vector
{	
	private int vec[];
	private Random obr = new Random();
	
	public Vector()
	{
		int tam;
		do
			tam = new lib20.Datos().Entero("Tamallo del vector");
		while(tam<1);
		vec = new int[tam];
	}
	
	public int tam()
	{
		return vec.length-1;
	}
	
	public void Aleatorio(int pos)
	{
		if(pos>0)
			this.Aleatorio(pos-1);
		vec[pos]=obr.nextInt(100);
	}
	
	public void Mostrar(int pos)
	{
		if(pos>0)
			this.Mostrar(pos-1);
		System.out.println(vec[pos]);
	}
}
