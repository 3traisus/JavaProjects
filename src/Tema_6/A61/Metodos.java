package Tema_6.A61;

import java.util.Random;

import lib20.Datos;

public class Metodos
{
	private int tam,pos,can,ini,fin;
	private String num[],cad;
	private Datos obd = new Datos();
	private Random obr = new Random();
	
	public Metodos()
	{
		do
			tam = obd.Entero("Dame el tamaño del Vector");
		while(tam<1);
		num = new String[tam];
	}
	
	private void Otorgar()
	{
		switch(obr.nextInt(5))
		{
			case 0:
				num[pos]+="A";
				break;
			case 1:
				num[pos]+="E";
				break;
			case 2:
				num[pos]+="I";
				break;
			case 3:
				num[pos]+="O";
				break;
			case 4:
				num[pos]+="U";
		}
		for(int con=0,n;con<6;con++)
			switch(n=obr.nextInt(15))
			{
				case 10:
					num[pos]+="a";
					break;
				case 11:
					num[pos]+="e";
					break;
				case 12:
					num[pos]+="i";
					break;
				case 13:
					num[pos]+="o";
					break;
				case 14:
					num[pos]+="u";
					break;
				default:
					num[pos]+=n;	
			}
		switch(obr.nextInt(5))
		{
			case 0:
				num[pos]+="A";
				break;
			case 1:
				num[pos]+="E";
				break;
			case 2:
				num[pos]+="I";
				break;
			case 3:
				num[pos]+="O";
				break;
			case 4:
				num[pos]+="U";
		}
	}
	
	public void Aleatorio()
	{
		if(num!=null)
		{
			for(pos=0;pos<num.length;pos++)
			{
				num[pos]="";
				do
				{
					this.Otorgar();
					for(can=0;can<pos && num[can]!=num[pos];can++);
					if(can<pos)
						obd.Println("rep"+num[pos]);
				}while(can<pos);
			}
			java.util.Arrays.sort(num);
		}
	}
	
	public void Mostrar()
	{
		obd.Println("Contenido del arreglo:");
		for (pos = 0; pos < num.length; pos++)
		{
			obd.Print(num[pos] + "\t");
			if ((pos + 1) % 10 == 0)
				obd.Println("");
		}
		obd.Println("");
	}
	
	private boolean Compare()
	{
		int ban=0;
		if(cad.length()==num[0].length())
		{
			can=0;
			do
				switch(cad.charAt(can))
				{
					case 'A':
					case 'E':
					case 'I':
					case 'O':
					case 'U':
						can+=7;
						break;
					default:
						can+=7;
						ban++;	
				}
			while(can<=7);
							
		for(can=1;can<7;can++)
		{
			switch(cad.charAt(can))
			{
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
				case '0':
					break;
				default:
				ban++;
			}
		}
	}
	else			
		ban++;
		
		
		return ban!=0;
	}
	
	public void Busqueda()
	{
		ini=0; fin=num.length-1;
		do
			cad = obd.Cadena("Dame la clave a buscar");
		while(this.Compare());	
		while(ini<=fin)
		{
			pos=(ini+fin)/2;
			if(num[pos].equals(cad))
				break;
			if(this.bus2())
				break;
		}
		if(num[pos].equals(cad))
			System.out.println("Numero encontrado en la posicion "+(pos+1));
		else
			System.out.println("El numero no esta en el arreglo.");
	}
	
	private boolean bus()
	{
		can=0;
		do
		{
			obd.Println(((int)cad.charAt(can))+"/"+((int)num[pos].charAt(can))+"/"+can);
			if(((int)cad.charAt(can))!=((int)num[pos].charAt(can)))
				if(((int)cad.charAt(can))>((int)num[pos].charAt(can)))
					ini=pos++;
				else
					fin=pos--;
			else
				can++;
		}while(((int)cad.charAt(can))==((int)num[pos].charAt(can)) && can<cad.length()-1);
		return can==cad.length();
	}
	
	private boolean bus2()
	{
		for(can=0;can<cad.length() && ((int)cad.charAt(can))==((int)num[pos].charAt(can));can++);
		if(can==cad.length())
		{
			return true;
		}
		else
		{
			if(((int)cad.charAt(can))>((int)num[pos].charAt(can)))
				ini=pos++;
			else
				fin=pos--;
			obd.Println(ini+"/"+fin);
			return false;
		}
	}
	
	/*public void Busqueda()
	{
		int ini=0, fin=num.length-1;
		do
			cad = obd.Cadena("Dame la clave a buscar");
		while(this.Compare());	
		while(ini<=fin)
		{
			pos=(ini+fin)/2;
			if(num[pos]==cad)
				break;
			if(cad>num[pos])
				ini=pos+1;
			else
				fin=pos-1;
		}
		if(arr[pos]==num)
			System.out.println("Numero encontrado en la posicion "+(pos+1));
		else
			System.out.println("El numero no esta en el arreglo.");
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
