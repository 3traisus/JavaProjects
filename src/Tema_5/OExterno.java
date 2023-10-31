package Tema_5;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

import lib20.Datos;

public class OExterno
{
	private String aro = "original.ahg", au1 = "auxiliar1.ahg", au2 = "auxiliar2.ahg";
	private RandomAccessFile oaro, oau1, oau2;
	private int can, con, num, x;
	private Datos obd = new Datos();
	private Random obr = new Random();

	public OExterno()
	{
		do
			can = obd.Entero("Cuál es la cantidad de datos del archivo?");
		while (can < 1);
		try
		{
			oaro = new RandomAccessFile(aro, "rw"); // rw lectura y escritura
			oaro.setLength(0);
			for (con = 1; con <= can; con++)
			{
				do
				{
					num = obr.nextInt(can * 20);
					if (con != 0)
					{
						for (x = 0; x < con; x++)
							if (oaro.readInt() == num)
								break;
					}
				}
				while (x < con);
				oaro.seek(con * 4); //es para que brinque el byte y guarde lo que hay cada 4 posiciones
				oaro.writeInt(num);
			}
			oaro.close();
		}
		catch (IOException e)
		{
			System.out.println("Error de escritura.");
		}
	}

	public void Mostrar()
	{
		obd.Println("Contenido del archivo");
		try
		{
			System.out.println("\nContenido del archivo...");
			oaro = new RandomAccessFile(aro, "r"); // r solo lectura
			can = (int) oaro.length() / 4;
			for (con = 1; con < can; con++)
			{
				System.out.print(oaro.readInt() + "\t");
				if ((con + 1) % 10 == 0)
					System.out.println();
			}
			oaro.close();
		}
		catch (IOException e)
		{
			System.out.println("Error de lectura.");
		}
		obd.Println("");
	}

	public void MezclaDirecta()
	{
		int par;
		try
		{
			oaro = new RandomAccessFile(aro, "r");
			can = (int) oaro.length() / 4;
			oaro.close();
		}
		catch (IOException e)
		{
			System.out.println("Error de lectura.");
		}
		for (par = 1; par < can; par *= 2)
		{
			this.Particion(par);
			this.Fusion(par);
		}
	}

	private void Particion(int par)
	{
		try
		{
			oaro = new RandomAccessFile(aro, "r");
			oau1 = new RandomAccessFile(au1, "rw");
			oau1.setLength(0);
			oau2 = new RandomAccessFile(au1, "rw");
			oau2.setLength(0);
			try
			{
				while (true)
				{
					for (con = 1; con <= par; con++)
						oau1.writeInt(oaro.readInt());
					for (con = 1; con <= par; con++)
						oau2.writeInt(oaro.readInt());
				}
			}
			catch (EOFException e)
			{
				oaro.close();
				oau1.close();
				oau2.close();
			}
		}
		catch (IOException e)
		{
			System.out.println("Error de lectura.");
		}
	}

	private void Fusion(int par)
	{
		
	}
	
	public OExterno(String na)
	{
		this.MezclaNatural(na);
	}
	
	public void MezclaNatural(String na)
	{
		int ta2;
		do
		{
			ta2 = this.Particion();
			if (ta2 != 0)
				this.Fusion();
		}
		while (ta2 != 0);
	}

	private int Particion(String na)
	{
		int ta2 = 0, num, ant, con, aux = 1;
		try
		{
			oaro = new RandomAccessFile(na, "r");
			can = (int) oaro.length() / 10;
			oau1 = new RandomAccessFile(au1, "rw");
			oau1.setLength(0);
			oau2 = new RandomAccessFile(au2, "rw");
			oau2.setLength(0);
			String temp="";
			for(int ind=0;ind<5;ind++)
				temp+=oaro.readChar();
			num = oaro.readInt();
			oau1.writeInt(num);
			ant = num;
			for (con = 2; con <= can; con++)
			{
				num = oaro.readInt();
				if (aux == 1)
					if (num > aux)
					{
						oau1.writeInt(num);
						aux = 1;
					}
					else
					{
						oau2.writeInt(num);
						aux = 2;
					}
				else
					if (num > ant)
					{
						oau2.write(num);
						aux = 2;
					}
					else
					{
						oau1.writeInt(num);
						aux = 1;
					}
				ant = num;
			}
			oaro.close();
			oau1.close();
			/*ta2 = (int) oau2.length() / 4;*/
			oau2.close();
		}
		catch (IOException e)
		{
			System.out.println("Error de lectura.");
		}
		return ta2;
	}

	private void Fusion(String na)
	{
		int num1, num2, con = 0;
		try
		{
			oaro = new RandomAccessFile(na, "rw");
			oaro.setLength(0);
			oau1 = new RandomAccessFile(au1, "r");
			oau2 = new RandomAccessFile(au2, "r");
			num1 = oau1.readInt();
			num2 = oau2.readInt();
			try
			{
				while (true)
				{
					if (num1 < num2)
					{
						oaro.writeInt(num1);
						con++;
						num1 = oau1.readInt();
					}
					else
					{
						oaro.writeInt(num2);
						num2 = oau2.readInt();
					}
				}
			}
			catch (EOFException e)
			{
				if (con != oau1.length() / 4)
					try
					{
						while (true)
						{
							oaro.writeInt(num1);
							num1 = oau1.readInt();
						}
					}
					catch (EOFException e1)
					{
						oau1.close();
						oau2.close();
					}
				else
					try
					{
						while (true)
						{
							oaro.writeInt(num2);
							num2 = oau2.readInt();
						}
					}
					catch (EOFException e1)
					{
						oau1.close();
						oau2.close();
					}
			}
		}
		catch (IOException e)
		{
			System.out.println("Error de lectura.");
		}
	}
	
	private int Particion()
	{
		int ta2 = 0, num, ant, con, aux = 1;
		try
		{
			oaro = new RandomAccessFile(aro, "r");
			can = (int) oaro.length() / 4;
			oau1 = new RandomAccessFile(au1, "rw");
			oau1.setLength(0);
			oau2 = new RandomAccessFile(au2, "rw");
			oau2.setLength(0);
			num = oaro.readInt();
			oau1.writeInt(num);
			ant = num;
			for (con = 2; con <= can; con++)
			{
				num = oaro.readInt();
				if (aux == 1)
					if (num > aux)
					{
						oau1.writeInt(num);
						aux = 1;
					}
					else
					{
						oau2.writeInt(num);
						aux = 2;
					}
				else
					if (num > ant)
					{
						oau2.write(num);
						aux = 2;
					}
					else
					{
						oau1.writeInt(num);
						aux = 1;
					}
				ant = num;
			}
			oaro.close();
			oau1.close();
			ta2 = (int) oau2.length() / 4;
			oau2.close();
		}
		catch (IOException e)
		{
			System.out.println("Error de lectura.");
		}
		return ta2;
	}

	private void Fusion()
	{
		int num1, num2, con = 0;
		try
		{
			oaro = new RandomAccessFile(aro, "rw");
			oaro.setLength(0);
			oau1 = new RandomAccessFile(au1, "r");
			oau2 = new RandomAccessFile(au2, "r");
			num1 = oau1.readInt();
			num2 = oau2.readInt();
			try
			{
				while (true)
				{
					if (num1 < num2)
					{
						oaro.writeInt(num1);
						con++;
						num1 = oau1.readInt();
					}
					else
					{
						oaro.writeInt(num2);
						num2 = oau2.readInt();
					}
				}
			}
			catch (EOFException e)
			{
				if (con != oau1.length() / 4)
					try
					{
						while (true)
						{
							oaro.writeInt(num1);
							num1 = oau1.readInt();
						}
					}
					catch (EOFException e1)
					{
						oau1.close();
						oau2.close();
					}
				else
					try
					{
						while (true)
						{
							oaro.writeInt(num2);
							num2 = oau2.readInt();
						}
					}
					catch (EOFException e1)
					{
						oau1.close();
						oau2.close();
					}
			}
		}
		catch (IOException e)
		{
			System.out.println("Error de lectura.");
		}
	}
}
