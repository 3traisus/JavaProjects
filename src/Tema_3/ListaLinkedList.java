package Tema_3;

import java.util.LinkedList;

import lib20.Datos;

public class ListaLinkedList
{
	int pos;
	private String nom;
	private Datos obd = new Datos();
	private LinkedList<String> lista = new LinkedList<String>();
	
	
	public void BuscarModificar(int op)
	{
		if(!lista.isEmpty())
		{
			do
				nom=obd.Cadena("Nombre de la persona a "+(op==4? "Buscar": "Modificar" )).toUpperCase();
			while(nom.isBlank());
			for(pos=0; pos<lista.size(); pos++)
				if(lista.get(pos).equals(nom))
				{
					obd.Println("persona encontrada "+(pos+1)+
							"/"+ lista.get(pos));
					if(op==5)
					{
						do
							nom = obd.Cadena("Escribe el nuevo nombre").toUpperCase();
						while(nom.isBlank());
						lista.set(pos,nom);
					}
					break;
				}
			if(pos==lista.size())
			{
				obd.Println("La persona no esta en la lista");
			}
		}
		else 
			obd.Println("Lista Vacia");
		obd.Println("");
	}
	
	public void Borrar()
	{
		if(!lista.isEmpty())
		{
			lista.clear();
			obd.Println("ListaBorrada");
		}
		else
			obd.Println("Lista vacia");
		obd.Println("");
	}
}
