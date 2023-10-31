package Tema_6;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

import Tema_5.OExterno;
import lib20.Datos;

public class BExterna
{
	private int can, pos, num, con;
	private String noa="busqueda.ahg";
	private RandomAccessFile oba;
	private Datos obd= new Datos();
	
	
	public BExterna()
	{
		do
			can=obd.Entero("Cuál es la cantidad de datos del archivo?");
		while(can<1);
	}
	
	
	public void Aleatorio()
	{
		Random obr=new Random();
		try
		{
			oba=new RandomAccessFile(noa, "rw");
			oba.setLength(0);
			for(pos=0; pos<can; pos++)
			{
				do
				{
					num=obr.nextInt(can*10)+1;
					for(con=0, oba.seek(0); con<pos && oba.readInt()!=num; con++);
				}
				while(con<pos);
				oba.seek(pos*4);
				oba.writeInt(num);
			}
			oba.close();
		}
		catch(IOException e)
		{
			System.out.println("Error de escritura");
		}
		new OExterno(noa);
	}
	
	public void Mostrar()
	{
		try
		{
			oba=new RandomAccessFile(noa,"r");
		
			System.out.println("\t contenido del archivo");
			for(pos=0; pos<can; pos++)
			{
				System.out.println(oba.readInt()+"\t");
				if((pos+1)%10==0)
					System.out.println();
			}
			oba.close();
		}
		catch(IOException e)
		{
			System.out.println("Error de lectura");
		}
	}
	
	public void BSecuencial()
	{
		
		try
		{
			oba=new RandomAccessFile(noa, "r");
			
				do
					num=obd.Entero("Cual es el numero a buscar");
				while(num<1);
				for(pos=0; pos<can && oba.readInt()!=num; pos++);
				if(pos<can)
					System.out.println("Numero encontrado en la posicion: "+(pos+1));
				else
					System.out.println("El numero no esta en el archivo");
				oba.close();
					
		}
		catch(IOException e)
		{
			System.out.println("Error de lectura");
		}
	}
	
	public void BBinaria()
	{
		int ini=0, fin;
		try
		{
			oba=new RandomAccessFile(noa,"r");
			fin=(int)oba.length()/4-1;
					do
						num=obd.Entero("Cual es el numero a buscar");
					while(num<1);
					while(ini<=fin)
					{
						pos=(ini+fin)/2;
						oba.seek(pos*4);
						if(oba.readInt()==num)
							break;
						oba.seek(pos*4);
					if(num>oba.readInt())
						ini=pos+1;
					else
						fin=pos-1;
					}
					oba.seek(pos*4);
					if(oba.readInt()==num)
						System.out.println("Numero encontrado en la posicion: "+(pos+1));
					else
						System.out.println("El numero no esta en el archivo");
					oba.close();

						
		}
		catch(IOException e)
		{
			System.out.println("Error de lectura");
		}
	}
}
		//bit          byte
// int    32             4
// double  64            8
// String   2032         254


