package Tema_6;
import java.util.Random;

import lib20.Datos;

public class BInterna
{
	private int arr[], pos, can, num,con;
	private Datos obd=new Datos();
	Random obr =new Random();
	private FHash obh=new FHash();
	
	public BInterna()
	{
		do
			can=obd.Entero("Cual es la cantidad de datos del arreglo?");
		while(can<1);
			arr=new int[can];
	}
	public BInterna(int op)
	{
		this();
		this.Aleatorios(op);
	}
	public void Aleatorios(int op)
	{
		int dir=0;
		for(pos=0; pos<arr.length; pos++)
		{
			do
			{
				
			
			num=obr.nextInt(can*10)+1;
			
			for(con=0; con<arr.length && arr[con]!=num; con++);
		}
			while(con<arr.length);
			switch(op)
			{
			case 1:
				dir= obh.Modulo(num,arr.length);
			break;
			case 2: 
				dir=obh.Cuadratica(num,arr.length);
			break;
			case 3: 
				dir =obh.Plegamiento(num,arr.length);
			break;
			case 4: 
				dir =obh.Trucamiento(num, arr.length);
			}
			if(arr[dir]!=0)
			do
			{
				dir++;
				if(dir==arr.length)
					dir=0;
			}
			while(arr[dir]!=0);
			arr[dir]=num;
		}
	
	}
	
	public void BHash(int op)
	{
		int dir = 0,x;
		do
			num=obd.Entero("Cual es el numero a buscar?");
		while(num<1);
		switch(op)
		{
		case 1:
			dir= obh.Modulo(num,arr.length);
		break;
		case 2: 
			dir=obh.Cuadratica(num,arr.length);
		break;
		case 3: 
			dir =obh.Plegamiento(num,arr.length);
		break;
		case 4: 
			dir =obh.Trucamiento(num, arr.length);
		}
		x=dir;
		if(arr[dir]!=num)
			do
			{
				dir++;
				if(dir==arr.length)
					dir=0;
				if(arr[dir]==num)
					break;
			}
		while(dir!=x);
		if(arr[dir]==num)
			System.out.println("Numero encontrado en la posicion: "+(dir+1));
		else
			System.out.println("Numero no esta en el arreglo.");
	}
	
	public void Aleatorios()
	{
		
		for(pos=0; pos<arr.length; pos++)
		{
			do
			{
				
			
			num=obr.nextInt(can*10)+1;
			for(con=0; con<pos && arr[con]!=num; con++);
		}
			while(con<pos);
			arr[pos]=num;
		}
		java.util.Arrays.sort(arr);
	}
	
	public void Mostrar()
	{
		System.out.println("\nDatos del arreglo.");
		for(pos=0; pos<arr.length; pos++)
		{
			System.out.println(arr[pos]+"\t");
			if((pos+1)/10==0)
				System.out.println();
		}
	}
	
	public void BSecuencia()
	{
		do
			num=obd.Entero("Cual es el numero a buscar?");
		while(num<1);
		for(pos=0; pos<arr.length && arr[pos]!=num; pos++);
		if(pos<arr.length)
			System.out.println("Numero encontrado en la posicion: "+(pos+1));
		else
			System.out.println("Numero no esta en el arreglo.");
	}
	
	public void BBinaria()
	{
		int ini=0, fin=arr.length-1;
		do
			num=obd.Entero("Cual es el numero a buscar?");
		while(num<1);
		while(ini<=fin)
		{
			pos=(ini+fin)/2;
			if(arr[pos]==num)
				break;
			if(num>arr[pos])
				ini=pos+1;
			else
				fin=pos-1;
		}
		if(arr[pos]==num)
			System.out.println("Número encontrado en la posición "+(pos+1));
		else
			System.out.println("El número no esta en el arreglo.");
		
	}
}
