package Tema_5;

import java.util.Random;

import lib20.Datos;

public class Businterna
{
	private int arr[],pos,num,can;
	private Datos obd = new Datos();
	
	public Businterna()
	{
		do
			can=obd.Entero("");
		while(can<1);
		arr = new int[can];
	}
	
	public void Aleatorio()
	{
		Random obr = new Random();
		for(pos=0;pos<arr.length;pos++)
		{
			do
			{
				num=obr.nextInt(arr.length*10);
				for(can=0;can<pos && arr[pos]!=num;can++);
			}while(can<pos);
			arr[pos]=num;
		}
	}
	
	public void Aleatorio(int op)
	{
		Random obr = new Random();
		FuncionesHashAHG obh = new FuncionesHashAHG();
		int dir;
		for(pos=0;pos<arr.length;pos++)
		{
			do
			{
				num=obr.nextInt(arr.length*10);
				switch(op)
				{
					case 1:
						dir = obh.Modulo(num, arr.length);
						break;
					case 2:
						dir = obh.Modulo(num, arr.length);
						break;
					case 3:
						dir = obh.Modulo(num, arr.length);
						break;
					case 4:
						dir = obh.Modulo(num, arr.length);
						break;
				}
				for(can=0;can<pos && arr[pos]!=num;can++);
			}while(can<pos);
			arr[pos]=num;
		}
	}
	
	public void Mostrar()
	{
		obd.Println("Contenido del arreglo:");
		for (pos = 0; pos < arr.length; pos++)
		{
			obd.Print(arr[pos] + "\t");
			if ((pos + 1) % 5 == 0)
				obd.Println("");
		}
		obd.Println("");
	}
	
	public void BusSecuencial()
	{
		do
			num= obd.Entero("Numero a buscar");
		while(num<1);
		for (pos = 0; pos < arr.length && arr[pos]!=num; pos++);
		if(pos<arr.length)
			obd.Println("Posicion real es"+pos+1);
		else
			obd.Println("No existe");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
