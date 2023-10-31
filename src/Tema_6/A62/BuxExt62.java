package Tema_6.A62;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

import lib20.Datos;
import lib20.Menu;

public class BuxExt62
{
	private String na="A62Practica.ahg";
	private RandomAccessFile oa;
	private Random obr = new Random();
	private int con,can,pos,op=0;
	String temp;
	private Datos obd = new Datos();
	private FuncionesHash obf = new FuncionesHash();
	
	public BuxExt62()
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
			if(!oa.readUTF().isBlank())
				if(oa.readUTF().equals(temp))
					break;
		if(con<pos)
			return false;
		else
			return true;
	}
	
	private boolean Espacio() throws IOException
	{
		int dir=0;
		boolean ban = false;
		switch(op)
		{
			case 1:
				dir = obf.Modulo(Integer.parseInt(temp),can);
				break;
			case 2:
				dir = obf.Cuadratica(Integer.parseInt(temp),can);
				break;
			case 3:
				dir = obf.Plegamiento(Integer.parseInt(temp),can);
				break;
			case 4:
				dir = obf.Trucamiento(Integer.parseInt(temp),can);
		
		}
		for(oa.seek(dir*(10)),con=dir;con<can;con++)
			if(oa.readUTF().isBlank())
				break;
		if(con==can)
			for(oa.seek(0),con=0;con<dir;con++)
				if(oa.readUTF().isBlank())
					break;
				else
					if(con<dir)
						ban = true;
					else
						ban = false;
		else
			ban = true;
		return ban;
	}
	
	public void Generar()
	{
		try
		{
			oa = new RandomAccessFile(na, "rw");
			oa.setLength(0);
			for(pos=0;pos<can;pos++)
			{
				do
				{
					temp = this.Generate();
				}while(!this.Comprobar() && pos!=0);
				if(this.Espacio())
					oa.writeUTF(temp);
			}
			oa.close();	
		}catch(IOException e)
		{
			obd.Println("Me cago en todo generar");
		}
	}
	
	public void FuncionesHash()
	{
		Menu obm = new Menu("Funciones Hash",new String[] {"Modulo","Cuadratica","Plegamiento","Truncamiento"});
		op = obm.Opcion();
		obd.Println("Seleccion con exito");
		
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















