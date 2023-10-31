package Tema_6.A61;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

import lib20.Datos;

public class BusExtMet
{
	StringBuffer sb;
	private int can, pos, x,num,ind=0;
	private String noa="ExternalBus.ahg",cad="";
	private RandomAccessFile oba;
	private Datos obd= new Datos();
	
	
	public BusExtMet()
	{
		do
			can=obd.Entero("Cual es la cantidad de datos del archivo?");
		while(can<1);
	}
	
	
	public void Aleatorio(int op)
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
					for(x=0;x<8;x++)
						cad+=obr.nextInt(10);
					obd.Println(cad);
					if(op==1) 
						num = this.Modulo(Integer.parseInt(cad), can);
					if(op==2)
						num = this.Cuadratica(Integer.parseInt(cad), can);
					if(op==3)
						num = this.Plegamiento(Integer.parseInt(cad), can);
					if(op==4)
						num = this.Trucamiento(Integer.parseInt(cad), can);
					
					sb = new StringBuffer(cad);
					sb.setLength(8);
					
					oba.seek(num * cad.length()*2);
					ind = num;
					/*for(con=0, oa.seek(0); con<pos ;con++)
					{
						temp="";
						for(ind=0;ind<5;ind++)
							temp+=oa.readChar();
						if(temp==cad)
							break;
					}*/	
					if(pos!=0)
					{
						obd.Println(ind+"");
						do
						{
							if(ind==can)
								ind=-1;
							ind++;
							oba.seek(ind*cad.length()*2);
						}while(oba.readUTF()!=null &&  ind==num);
							
					}else
						oba.writeUTF(cad);
					
					if(ind!=num)
						oba.writeUTF(cad);
				}
				while(ind!=num);
				oba.writeChars(sb.toString());
				obd.Println(oba.readUTF()+"hola");
			}
			oba.close();
		}
		catch(IOException e)
		{
			System.out.println("Error de escritura");
		}
	}
	
	public void Mostrar()
	{
		try
		{
			oba=new RandomAccessFile(noa,"r");
		
			System.out.println("\t contenido del archivo");
			for(pos=0; pos<can; pos++)
			{
				System.out.println(oba.readUTF()+"\t");
				if((pos+1)%5==0)
					System.out.println();
			}
			oba.close();
		}
		catch(IOException e)
		{
			System.out.println("Error de lectura");
		}
	}
	
	private int Modulo(int num, int can)
	{
		return num%can;
		
	}
	
	private int Cuadratica(int num, int can)
	{
		int nd=(can-1+"").length(), dir=0,ini;
		String cua= num*num+"";
		if(cua.length()>=nd)
			do
			{
				ini=cua.length()/2-nd/2;
				dir=Integer.parseInt(cua.substring(ini,ini+nd));
				if(dir>can-1)
					nd--;
			}
			while(dir>can-1);
			else
				dir= Integer.parseInt(cua);
		return dir;
				
		
	}
	
	private int Plegamiento(int num, int tam)
	{
		int nd=(tam-1+"").length(),dir=0, suma,ini;
		String cad=num+"";
		if(cad.length()>=nd)
			do
		{
			suma=0;
			for(ini=0; ini<cad.length()-nd; ini+=nd)
				suma+=Integer.parseInt(cad.substring(ini,ini+nd));
			if(ini<cad.length())
				suma+=Integer.parseInt(cad.substring(ini));
			if(suma>=tam)
				dir= Integer.parseInt((suma+"").substring((suma+"").length()-nd));
			else
				dir=suma;
			if(dir>=tam)
				nd--;
		}
			while(dir>=tam);
		else
			dir=num;
			
		return dir;
	}
	
	private int Trucamiento(int num, int tam)
	{
		int nd=(tam-1+"").length(), dir=0,ini;
		String cad =num+"", sub="";
		if(cad.length()>=nd)
			do
			{
				for(ini=0; ini<cad.length(); ini+=2)
					sub+=cad.charAt(ini);
				if(sub.length()>=nd)
					dir=Integer.parseInt(sub.substring(0,nd));
				else
					dir=Integer.parseInt(sub);
				if(dir>=tam)
					nd--;
			}
			while(dir>=tam);
			else
				dir=num;
				
		return dir;
	}
}
