package Tema_3;

import lib20.Datos;

public class ListaDoble
{
	private int pos;
	private NoDoble ini,fin,nvo,ant,tmp;
	private Datos obd = new Datos();
	
	public ListaDoble()
	{
		ini = fin = null;
	}
	
	private boolean Vacia()
	{
		return ini==null;
	}
	
	public void Insertar(int op)
	{
		do
			nvo = new NoDoble(obd.Cadena("Escribe el nombre del producto"));
		while(nvo.getProducto().isBlank());
		if(!this.Vacia())
		{
			switch(op)
			{
				case 1:
					nvo.setSig(ini);
					ini.setAnt(nvo);
					ini=nvo;
					break;
				case 2:
					nvo.setSig(fin);
					fin.setAnt(nvo);
					fin=nvo;
					break;
				case 3:
			}
		}
		else
			ini=fin=nvo;
		obd.Println("Producto insertado con exito");
	}
}
