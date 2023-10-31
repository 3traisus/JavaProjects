package Tema_5;

import java.util.Random;

import lib20.Datos;


public class OInterno
{
	private int arr[];
	private int pos, can, aux;
	private Datos obd = new Datos();
	private Random obr = new Random();

	public OInterno()
	{
		do
			pos = obd.Entero("¿Cual es el tamaño del arreglo?");
		while (pos < 1);
		arr = new int[pos];
		this.Aleatorios();
	}

	private void Aleatorios()
	{
		for (pos = 0; pos < arr.length; pos++)
			do
			{
				arr[pos] = obr.nextInt(arr.length * 10);// Crece el rango y evita que haya muchas repeticiones de num.
				for (can = 0; can < pos; can++)
					if (arr[can] == arr[pos])
					{
						System.out.println(pos + "-" + arr[pos]);// Muestra la posicion y numero que se repitio
						break;
					}
			}
			while (can < pos);
	}

	public void Mostrar()
	{
		System.out.println("Contenido del arreglo: ");
		for (pos = 0; pos < arr.length; pos++)
		{
			System.out.print(arr[pos] + "\t");
			if ((pos + 1) % 5 == 0)
				System.out.println();
		}
		System.out.println();
	}

	public void Burbuja()
	{
		for (can = 1; can <= arr.length; can++)
			for (pos = 0; pos < arr.length - 1; pos++)
				if (arr[pos] > arr[pos + 1]) // cambia el signo a < para hacerlo decendente o > para hacerlo acendentro
				{
					aux = arr[pos];
					arr[pos] = arr[pos + 1];
					arr[pos + 1] = aux;
				}
	}

	public void BurbujaM()
	{
		// int x = 0;
		for (pos = 0; pos < arr.length - 1; pos++)
			for (can = pos + 1; can < arr.length; can++)
				// {
				// x++;
				if (arr[pos] < arr[can])
				{
					aux = arr[pos];
					arr[pos] = arr[can];
					arr[can] = aux;
				}
		// }
		// System.out.println(x); //Lo que esta como comentario reduce el tiempo
	}

	public void QuickSort()
	{
		this.QuickSort(0, arr.length - 1);
	}

	private void QuickSort(int ini, int fin)
	{
		int pivote = arr[(ini + fin) / 2];
		int izq = ini, der = fin;
		while (izq <= der)
		{
			while (arr[izq] < pivote) // se cambia el signo para que se modifique el orden
				izq++;
			while (arr[der] > pivote)// igual que el comentario de arriba
				der--;
			if (izq <= der)
			{
				aux = arr[izq];
				arr[izq] = arr[der];
				arr[der] = aux;
				izq++;
				der--;
			}
		}
		if (ini < der)
			this.QuickSort(ini, der);
		if (izq < fin)
			this.QuickSort(izq, fin);
	}

	public void ShellSort()
	{
		int inc;
		for (inc = arr.length / 2; inc > 0; inc /= 2)
			for (can = inc; can < arr.length; can++)
				for (pos = can; pos >= inc && arr[pos - inc] > arr[pos]; pos -= inc)// cambiar a < para que vaya de manera decendente
				{
					aux = arr[pos - inc];
					arr[pos - inc] = arr[pos];
					arr[pos] = aux;
				}
	}

	public void Radix()
	{
		int may = arr[0], nd, dig, fac;
		@SuppressWarnings("unchecked")
		java.util.LinkedList<Integer> cola[] = new java.util.LinkedList[10];
		for (pos = 0; pos < arr.length; pos++)
			if (arr[pos] > may)
				may = arr[pos];
		nd = (may + "").length();
		for (pos = 0; pos < cola.length; pos++)
			cola[pos] = new java.util.LinkedList<Integer>();
		for (dig = 1, fac = 1; dig <= nd; dig++, fac *= 10)
		{
			for (pos = 0; pos < arr.length; pos++)
				cola[arr[pos] / fac % 10].add(arr[pos]);
			for (can = 0, pos = 0; can < cola.length; can++)
				while (!cola[can].isEmpty())
					arr[pos++] = cola[can].removeFirst();
		}
	}

	public void Java()
	{
		java.util.Arrays.sort(arr);
	}
}
