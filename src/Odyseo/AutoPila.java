package Odyseo;

import java.util.ArrayDeque;
import java.util.Scanner;
//import java.util.LinkedList;

import lib20.Datos;
import lib20.Menu;

public class AutoPila
{
	private Datos obd = new Datos(); 
	private String cad,exp=("[abc]*m[abc]*"),valores[] = { "a$", "b$", "c$", "ab", "ac", "ba", "bc", "ca", "cb","m$", "ma", "mb", "mc", "am","bm", "cm", "aa", "bb", "cc", "$a","$b","$c","$$" };//wmw-1
	private int x;
	private ArrayDeque<Character> pila = new ArrayDeque<Character>();
	
	private byte  matriz_transacicion[][][] = {
				{{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{1,2},{1,2},{1,2},{1,2},{-1,2},{-1,2},{-1,2},{0,0},{0,0},{0,0},{-1,2},{-1,2},{-1,2},{-1,2}},
				{{-1,2},{-1,2},{-1,2},{-1,2},{-1,2},{-1,2},{-1,2},{-1,2},{-1,2},{-1,2},{1,2},{1,2},{1,2},{1,1},{1,1},{1,1},{1,1},{1,1},{1,1},{1,1},{1,1},{1,1},{2,2}}
				};
	
	public void Lectura()
	{
		boolean ban=false;;
		do
		{ 
			if(ban)
				obd.Println("debe cumplir con la siguiente expresion [abc]*m[abc]* "); 
			cad = obd.Cadena("Dame la cadena a validar");
		}
		while(ban = !cad.matches(exp));
		cad+="$";
	}
	
	public void Tabla()
	{
		pila.clear();
		pila.push('$');
		x=0;
		int y,accion = -2,ind=0;
		String form;

		for(x=0;x<cad.length();x++)
		{
			form = cad.charAt(x)+""+pila.getFirst();
			for(y=0;y<valores.length && !valores[y].contains(form);y++);
	
			accion = matriz_transacicion[ind][y][1];
			ind = matriz_transacicion[ind][y][0];
			if(ind==-1)
				break;
			if(accion==0)
				pila.push(cad.charAt(x));
			else
				if(accion==1 && ind==1)
					obd.Println(pila.pop()+"/");
		}
		if(ind==2 && accion==2)
			obd.Println("Cadena aceptada");
		else
			obd.Println("No aceptada");
	}
	
	public static void main(String[]args)
	{
		int op;
		Menu obm;
		obm = new Menu("Actividad automatapila", new String[] {"Validar Cadena"});
		
		AutoPila oba = new AutoPila();
		do
			switch(op=obm.Opcion())
			{
				case 1:
					oba.Lectura();
					oba.Tabla();
			}
		while(op!=obm.Salir());
	}
}
