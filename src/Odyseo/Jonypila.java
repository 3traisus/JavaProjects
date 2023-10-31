package Odyseo;

import java.util.ArrayDeque;

import lib20.Datos;

public class Jonypila
{

	
	/*private String cad,valores[] = { "a$", "b$", "c$", "ab", "ac", "ba", "bc", "ca", "cb","m$", "ma", "mb", "mc", "am","bm", "cm", "aa", "bb", "cc", "$a","$b","$c","$$" };;//wmw-1
	private String matriz[][] = {
			{"00","00","00","00","00","00","00","00","00","12","12","12","12","!2","!2","!2","00","00","00","!2","!2","!2","!2"},//linea o estado 0
			{"!2","!2","!2","!2","!2","!2","!2","!2","!2","!2","12","12","12","11","11","11","11","11","11","11","11","11","22"}//linea o estado 1
			};*/
	private Datos obd = new Datos(); 
	private String cad,valores[] = { "b$","cb","bc","ab","ba","$a","bb"};;//   $bcb
	private String matriz[][] = {
			{"10","!2","10","!2","!2","!2","!2"},//linea o estado 0
			{"!2","00","!2","20","!2","!2","!2"},//linea o estado 1
			{"!2","!2","!2","!2","30","42","!2"},//linea o estado 2
			{"!2","!2","!2","20","!2","!2","!2"},//linea o estado 3
			};
	
	private int x;
	private ArrayDeque<Character> pila = new ArrayDeque<Character>();
	

	public void Lectura()
	{
		boolean ban=false;;
		do 
		{
			if(ban)
				obd.Println("No debe estar vacia"); 
			cad = obd.Cadena("Dame la cadena a validar");
		}while(ban = cad.isBlank());
		cad+="$";
	}
	
	private void Tabla()
	{
		pila.clear();
		pila.push('$');
		x=0;
		int y,ind=0,c=0,a=-1;//se ocupa dejar del tipo entero para controlar la posicion de la matriz
		char accion=' ';
		String form;

		for(x=0;x<cad.length();x++)
		{
			form = cad.charAt(x)+""+pila.getFirst();
			for(y=0;y<valores.length && !valores[y].contains(form);y++);//este ciclo termina cuando encuentra una similitud con las combinaciones o sea mayoe valores.lenght 
			if(y<valores.length)//es para q no se salga del rango para evitar el try and catch
			{
				accion = matriz[ind][y].charAt(1);
				if(matriz[ind][y].charAt(0)!='!')
					ind = Integer.parseInt(matriz[ind][y].charAt(0)+"");
				else
					break;
			}
			if(accion=='0')
			{
				pila.push(cad.charAt(x));
				if(cad.charAt(x)!='b'&& cad.charAt(x)!='$')
				{
					if(cad.charAt(x)=='c')
						c++;
					else
						if(cad.charAt(x)=='a')
							a++;
						
				}
			}
			else
				if(accion=='1' && ind==1)
					pila.pop();
		}
		/*for(char T: pila)
		{
			obd.Print(T+"");
		}
		obd.Println("----"+ind+"/"+accion+"/"+c+"/"+a);*/
		if(ind==4 && accion=='2' && c==a)
			obd.Println("Cadena aceptada");
		else
			obd.Println("No aceptada");
	}
	
	public static void main(String[]args)
	{
		Jonypila oba = new Jonypila();
		while(true) {
					oba.Lectura();
					oba.Tabla();}		
	}
}
