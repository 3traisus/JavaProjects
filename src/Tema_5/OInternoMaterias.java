package Tema_5;

import java.util.LinkedList;

import lib20.Datos;


public class OInternoMaterias
{
	private int pos, con, clv;
	private Materia lista[];
	private Datos obd = new Datos();

	public OInternoMaterias()
	{
		do
			pos = obd.Entero("Cantidad de materias de la lista?");
		while (pos < 1);
		lista = new Materia[pos];
		pos = -1;
	}

	private int Clave()
	{
		int clv = 1;
		if (pos != -1)
			for (con = 0; con < pos; con++)
				if (lista[con].Clave() >= clv)
					clv = lista[con].Clave() + 1;
		return clv;
	}

	public void Nueva()
	{
		if (pos + 1 < lista.length)
		{
			clv = this.Clave();
			lista[++pos] = new Materia(this.Clave());
		}
		else
			System.out.println("No hay espacio para otra materia.");
		System.out.println();
	}

	public void Lista()
	{
		if (pos != -1)
		{
			System.out.println("Lista de materias:");
			for (con = 0; con <= pos; con++)
				lista[con].Mostrar();
		}
		else
			System.out.println("No hay materias registradas");
		System.out.println();
	}

	public void Modificar()
	{
		if (pos != -1)
		{
			do
				clv = obd.Entero("Clave de la materia a modificar?");
			while (clv < 1);
			for (con = 0; con <= pos; con++)
				if (lista[con].Clave() == clv)
				{
					lista[con].Modificar();
					break;
				}
			if (con > pos)
				System.out.println("La materia no esta registrada.");
		}
		else
			System.out.println("No hay materias registradas");
		System.out.println();
	}

	public void Ordenar()
	{
		int may = lista[0].Nombre().length(), x;
		String letras = " ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		@SuppressWarnings("unchecked")
		LinkedList<Materia> cola[] = new LinkedList[letras.length()];
		for (con = 1; con <= pos; con++)
			if (lista[con].Nombre().length() > may)
				may = lista[con].Nombre().length();
		may--;
		for (con = 0; con < cola.length; con++)
			cola[con] = new LinkedList<Materia>();
		for (; may >= 0; may--)
		{
			for (con = 0; con <= pos; con++)
			{
				x = lista[con].Nombre().length() - 1 < may ? 0 : letras.indexOf(lista[con].Nombre().charAt(may));
				cola[x].addLast(lista[con]);
			}
			for (con = 0, pos = -1; con < cola.length; con++)
				while (!cola[con].isEmpty())
					lista[++pos] = cola[con].removeFirst();
		}
	}
}
