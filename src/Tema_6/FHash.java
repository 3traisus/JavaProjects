package Tema_6;

public class FHash
{
	public int Modulo(int num, int can)
	{
		return num%can;
		
	}
	
	public int Cuadratica(int num, int can)
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
	
	public int Plegamiento(int num, int tam)
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
	
	public int Trucamiento(int num, int tam)
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
