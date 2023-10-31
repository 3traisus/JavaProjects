package Tema_1;

import lib20.Datos;

public class Yudi
{
	Datos obd = new Datos();
	private int tam, pos, div, suma;

	private int []vec,ind;

	public void Tamaño()
	{
		do
			tam = obd.Entero("Cuál es la cantidad de números?");
		while (tam < 1);
		vec = new int[tam];

	}

	public void Leer()
	{

		System.out.println("Escribe los  número ");
		for (pos = 0; pos < vec.length; pos++)
			vec[pos] = obd.Entero("[" + (pos + 1) + "]");

	}

	public void Validar()
	{
		for (pos = 0; pos < vec.length; pos++)
		{
			suma=0;
			for (div=1; div <vec[pos]; div++)
				if (vec[pos] % div == 0)
					suma += div;
			if (suma == vec[pos])
			{
				System.out.println("El numero " + vec[pos] + " es perfecto");
			}
			else
				System.out.println("El numero " + vec[pos] + " no es perfecto");
		}

	}
	
	public void Mostrar()
	{
		for (pos = 0; pos < vec.length; pos++)
			System.out.println((vec));
	}
	
	public static void main(String[]args)
	{
		Yudi oby = new Yudi();
		oby.Tamaño();
		oby.Leer();
		oby.Validar();
	}
}