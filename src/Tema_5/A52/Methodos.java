package Tema_5.A52;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

import Tema_5.OExterno;
import lib20.Datos;

public class Methodos
{
	StringBuffer sb;
	private String na="Claves.ahg",aux1="Aux1.ahg",aux2="Aux2.ahg",cad,temp;
	private RandomAccessFile oa,ao1,ao2;
	private int pos,can,con,con2=5,ind,num;
	private Datos obd = new Datos();
	
	public Methodos()
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
					cad="";
					for(ind=0;ind<5;ind++)
					{
						num = obr.nextInt(15);
						if(num<10)
							cad+=num;
						else
							switch(num)
							{
								case 10:
									cad+="A";
									break;
								case 11:
									cad+="E";
									break;
								case 12:
									cad+="I";
									break;
								case 13:
									cad+="O";
									break;
								case 14: 
									cad+="U";		
							}
					}
						sb = new StringBuffer(cad);
						sb.setLength(5);
					for(con=0, oa.seek(0); con<pos ;con++)
					{
						temp="";
						for(ind=0;ind<5;ind++)
							temp+=oa.readChar();
						if(temp==cad)
							break;
					}			
				}while(con<pos);
				oa.writeChars(sb.toString());
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
			for(con=0, oa.seek(0); con<can ;con++)
			{
				temp="";
				for(ind=0;ind<5;ind++)
					temp+=oa.readChar();
				obd.Println(temp + "\t");
			}	
			oa.close();
		}
		catch (IOException e)
		{
			System.out.println("Error de lectura.");
		}
		obd.Println("");
	}
	
	
	
	public void MezclaNatural()
	{
		int ta2;
		/*do
		{*/
			ta2 = this.Particion();
			/*if (ta2 != 0)
				this.Fusion();*/
		/*}
		while (ta2 != 0);*/
	}
	
	private int Particion()
	{
		int ta2 = 0, num = 0, ant=0,a1=0,a2=0;
		boolean ban=true;
		try
		{
			oa = new RandomAccessFile(na, "r");
			can = (int) oa.length() / 10;
			ao1 = new RandomAccessFile(aux1, "rw");
			ao1.setLength(0);
			ao2 = new RandomAccessFile(aux2, "rw");
			ao2.setLength(0);
			
			for(con=0, oa.seek(0); con<can ;con++)
			{
				temp="";
				for(ind=0;ind<5;ind++)
					temp+=oa.readChar();
				
				sb = new StringBuffer(temp);
				sb.setLength(5);
				
				for(ind=0;ind<5;ind++)
					num=oa.readChar();
				
				if(num>ant)
				{
					if(ban)
					{
						ao1.writeChars(sb.toString());
						ant=num;
						ban=true;
					}
					else
					{
						ao2.writeChars(sb.toString());
						ant=num;
						ban=false;
					}	
				}
				else
					if(!ban)
					{
						ao1.writeChars(sb.toString());
						ant=num;
						ban=true;
					}
					else
					{
						ao2.writeChars(sb.toString());
						ant=num;
						ban=false;
					}
			}	
			oa.close();
			ao1.close();
			ta2 = (int) ao2.length() / 10;
			ao2.close();
		}
		catch (IOException e)
		{
			System.out.println("Error de lectura.");
		}
		return ta2;
	}
	/*
	 * 			can =(int) ao1.length() /10;
			for(con=0, oa.seek(0); con<can ;con++)
			{				
				temp="";
				for(ind=0;ind<5;ind++)
				{
					temp+=ao1.readChar();	
				}
				obd.Println("1."+temp+"\t");
			}
			
			can =(int) ao2.length() /10;
			for(con=0, oa.seek(0); con<can ;con++)
			{				
				temp="";
				for(ind=0;ind<5;ind++)
				{
					temp+=ao2.readChar();	
				}
				obd.Println("2."+temp+"\t");
			}
	 * */
}
