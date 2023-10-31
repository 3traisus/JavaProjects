package Tema_5.A51;

import java.util.Calendar;
import java.util.Random;

import lib20.Datos;

public class Metodos 
{
	private String vec[];
	private int pos,can,ind,aux;
	private Datos obd = new Datos();
	private Random obr = new Random();
	
	public Metodos()
	{
		do
			pos = obd.Entero("¿Cual es el tamaño del arreglo?");
		while (pos < 1);
		vec = new String[pos];
	}


	public void Control()
	{
		obd.Println("Pansa llena corazon contento igual que el vector");
		for (pos = 0; pos < vec.length; pos++)
			do
			{
				vec[pos]="";
				for(ind=0;ind<2;ind++)
					vec[pos]+=obr.nextInt(3);

				vec[pos]+="42";
				for(ind=4;ind<8;ind++)
					vec[pos]+=obr.nextInt(10);
				for (can = 0; can < pos; can++)
					if (vec[can] == vec[pos])
					{
						System.out.println(pos + "-" + vec[pos]);
						break;
					}
			}
			while (can < pos);	
	}
	
	public boolean Acceso()
	{
		return vec[0]!=null;
	}
	
	public void Tiempo()
	{
		Calendar fe = Calendar.getInstance();
		int min, seg, mil;
		min = fe.get(Calendar.MINUTE);
		seg = fe.get(Calendar.SECOND);
		mil = fe.get(Calendar.MILLISECOND);
		System.out.println(min + ":" + seg + ":" + mil);
	}
	
	public void Mostrar()
	{
		obd.Println("Contenido del arreglo:");
		for (pos = 0; pos < vec.length; pos++)
		{
			obd.Print(vec[pos] + "\t");
			if ((pos + 1) % 5 == 0)
				obd.Println("");
		}
		obd.Println("");
	}
	
	public void BurbujaM()
	{
		obd.Println("Burbuja Mejorado");
		for (pos = 0; pos < vec.length - 1; pos++)
			for (can = pos + 1; can < vec.length; can++)
			{
				if (Integer.parseInt(vec[pos]) < Integer.parseInt(vec[can]))
				{
					aux = Integer.parseInt(vec[pos]) ;
					vec[pos] = vec[can];
					if(aux<3000000 && aux>1000000)
						vec[can] = "0"+aux;
					else
						if(aux<430000)
							vec[can] = "00"+aux;
						else
							vec[can] = aux+"";
				}
			}
	}

	public void QuickSort()
	{
		obd.Println("QuickSort");
		this.QuickSort(0, vec.length - 1);
	}

	private void QuickSort(int ini, int fin)
	{
		int pivote = Integer.parseInt(vec[(ini + fin) / 2]);
		int izq = ini, der = fin;
		while (izq <= der)
		{
			while (Integer.parseInt(vec[izq]) > pivote) 
				izq++;
			while (Integer.parseInt(vec[der]) < pivote)
				der--;
			if (izq <= der)
			{
				aux =  Integer.parseInt(vec[izq]);
				vec[izq] = vec[der];
				if(aux<3000000 && aux>1000000)
					vec[der] = "0"+aux;
				else
					if(aux<430000)
						vec[der]=aux+"00";
					else
						vec[der]=aux+"";
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
		obd.Println("ShellSort");
		int inc;
		for (inc = vec.length / 2; inc > 0; inc /= 2)
			for (can = inc; can < vec.length; can++)
				for (pos = can; pos >= inc && Integer.parseInt(vec[pos - inc]) < Integer.parseInt(vec[pos]) ; pos -= inc)
				{
					aux = Integer.parseInt(vec[pos - inc]);
					vec[pos - inc] = vec[pos];
					if(aux<3000000 && aux>1000000)
						vec[pos] = "0"+aux;
					else
						if(aux<430000)
							vec[pos] = "00"+aux;
						else
							vec[pos] = aux+"";
				}
	}

	public void Radix()
	{
		obd.Println("Radix");
		int may = Integer.parseInt(vec[0]) , nd, dig, fac;
		@SuppressWarnings("unchecked")
		java.util.LinkedList<String> cola[] = new java.util.LinkedList[10];
		for (pos = 0; pos < vec.length; pos++)
			if (Integer.parseInt(vec[pos]) > may)
				may = Integer.parseInt(vec[pos]);
		nd = (may + "").length();
		for (pos = 0; pos < cola.length; pos++)
			cola[pos] = new java.util.LinkedList<String>();
		for (dig = 1, fac = 1; dig <= nd; dig++, fac *= 10)
		{
			for (pos = 0; pos < vec.length; pos++)
				cola[ Integer.parseInt(vec[pos]) / fac % 10].addFirst(vec[pos]);
			for (can = cola.length-1, pos = 0; can >= 0; can--)
				while (!cola[can].isEmpty())
					vec[pos++] = cola[can].removeLast();
		}
	}
	
	
}
