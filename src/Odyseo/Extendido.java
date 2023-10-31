package Odyseo;

import lib20.Menu;

public class Extendido
{
	
	
	public static void main(String[] args)
	{
		float val;
		int op;
		Menu obm;
		obm = new Menu("Cadenas Flotantes", new String[] {"Valor Decimal","Transformar a binario","Transformar IEEE754"});
		
		FloarCad obf = new FloarCad();
		
		do
			switch(op=obm.Opcion())
			{
				case 1:
					obf.Lectura();
					val = obf.ValorFloat();
					
			}
		while(op!=obm.Salir());
	}
}
