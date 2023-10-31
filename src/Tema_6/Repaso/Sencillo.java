package Tema_6.Repaso;

import java.io.IOException;
import java.io.RandomAccessFile;

import lib20.Datos;

public class Sencillo
{
	private String na="Sencillo.ahg";
	private RandomAccessFile oa;
	private int ind=0,con,can;
	private Datos obd = new Datos();
	
	public Sencillo()
	{
		do
			can = obd.Entero("Cantidad");
		while(can<1);
		try
		{
			oa = new RandomAccessFile(na, "rw");
			oa.setLength(0);
		}
		catch (IOException e)
		{
			
		}
	}
	
	public void Insertar(String cad)
	{
		try
		{
			oa = new RandomAccessFile(na, "rw");
			oa.seek(12*(ind++));
			oa.writeUTF(cad);
		}catch(IOException e)
		{
			
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
					obd.Println("");
				else
					obd.Print(oa.readUTF()+"\t");
			oa.close();
		}catch(IOException e)
		{
			obd.Println("Me cago en todo");
		}
	}
}
