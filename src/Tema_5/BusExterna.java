package Tema_5;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.RandomAccess;

import lib20.Datos;

public class BusExterna
{
	private int pos,can,num,con;
	private String na="Numeros.ahg";
	private RandomAccessFile oa;
	private Datos obd = new Datos();
	
	public BusExterna()
	{
		do
			can=obd.Entero("Cual es la cantidad de datos");
		while(can<1);
		
	}
	
	public void Aleatorio()
	{
		Random obr = new Random();
		try
		{
			oa = new RandomAccessFile(na,"rw");
			oa.setLength(0);
			for(pos=0;pos<can;pos++)
			{
				do
				{
					num=obr.nextInt()+1;	
					for(con=0, oa.seek(0);con<pos && oa.readInt()!=num;con++);
				}while(con<pos);
				oa.seek(pos*4);
				oa.write(num);
			}
			oa.close();
		}catch(IOException e)
		{
			
		}
	}
	
	
	public void Mostrar()
	{
		obd.Println("Contenido del archivo");
		try
		{
			oa = new RandomAccessFile(na, "r");
			for(pos=0;pos<can;pos++)
			{
				obd.Println(""+oa.readInt()+"\t");
				if((pos+1)%10==0)
					obd.Println("");
			}
			oa.close();
		}catch(IOException e) 
		{
			
		}
	}
	
	public void BusquedaExterna()
	{
		obd.Println("Contenido del archivo");
		try
		{
			do
				num = obd.Entero("Numero a buscar");
			while(num<1);
			oa = new RandomAccessFile(na, "r");
			for(pos=0;pos<can && oa.readInt()!=num;pos++);
				if(pos<can)
					obd.Println("Numero encontrado en "+ pos);
				else 
					obd.Println("El numero no existe");
			oa.close();
		}catch(IOException e) 
		{
			
		}
	}
	
	
	
}



























