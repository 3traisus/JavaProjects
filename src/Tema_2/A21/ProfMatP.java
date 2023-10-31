package Tema_2.A21;

import lib20.Datos;
import lib20.Menu;

public class ProfMatP
{
	public static void main(String[] args)
	{
		int op;
	    Menu obm=new Menu("Conversor",new String[] 
	    		{"Decimal a Binario","Decimal a Octal","Decimal a Hexadecimal"});
		ProfMAt obp = new ProfMAt();
		do
		{
			switch(op=obm.Opcion())
			{
				case 1:
					System.out.println(obp.Bin(obp.Num(new Datos().Entero("Numero Decimal a Convetir a Binario"))));
					break;
				case 2:
					System.out.println(obp.Octal(obp.Num (new Datos().Entero("Numero Decimal a Convetir a Octal"))));
					break;
				case 3:
				System.out.println(obp.Hexa(obp.Num (new Datos().Entero("Numero Decimal a Convetir a Hexa"))));
			}
		}while(op!=obm.Salir());
	}

}
