package Tema_6.Repaso;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

import lib20.Datos;

public class A62
{
	private String na="A62Practica.ahg";
	private RandomAccessFile oa;
	private Random obr = new Random();
	private int con,can,pos;
	String temp;
	private Datos obd = new Datos();
	
	public A62()
	{
		do
			can = obd.Entero("Dame la cantidad de claves");
		while(can<1);
	}
	
	private String Generate()
	{
		String cad="";
		for(int x=0;x<8;x++)
			cad+= obr.nextInt(10);
		return cad;
	}
	
	private boolean Comprobar() throws IOException
	{
		for(oa.seek(0),con=0;con<pos;con++)
			if(oa.readUTF().equals(temp))
				break;
		if(con<pos)
			return false;
		else
			return true;
	}
	
	public void Generar()
	{
		try
		{
			obd.Println("Generar");
			oa = new RandomAccessFile(na, "rw");
			oa.setLength(0);
			for(pos=0;pos<can;pos++)
			{
				do
				{
					temp = this.Generate();
				}while(!this.Comprobar() && pos!=0);
				oa.writeUTF(temp);
			}
			oa.close();	
		}catch(IOException e)
		{
			obd.Println("Me cago en todo generar");
		}
	}
	
	public void Mostrar() 
	{
		obd.Println("Contendido del archivo");
		try
		{
			oa = new RandomAccessFile(na, "r");
			for(oa.seek(0),con=0;con<can;con++)
				if((con+1)%5==0)
					obd.Println(oa.readUTF());
				else
					obd.Print(oa.readUTF()+"\t");
			oa.close();
		}catch(IOException e)
		{
			obd.Println("Me cago en todo");
		}
	}
}















