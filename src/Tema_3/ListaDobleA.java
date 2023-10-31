package Tema_3;

import lib20.Datos;

public class ListaDobleA
{
	private int pos,con;
	private String nc;
	private NodoDobleA ini,fin,nvo,tmp;
	private Datos obd = new Datos();
	
	public ListaDobleA()
	{
		ini=fin=null;
	}
	
	private boolean Vacia()
	{
		return ini==null;
	}
	
	public void Insertar(int op)
	{
		nvo = new NodoDobleA(new Alumno());
		if(!this.Vacia())
		{
			switch(op)
			{
				case 1:
					nvo.setSig(ini);
					ini.setAnt(nvo);
					ini = nvo;
					break;
				case 2:
					do
						pos= obd.Entero("Dime la posicion a insertar");
					while(pos<1);
					for(tmp=ini, con=1;tmp!=null && con<pos;tmp=tmp.getSig(), con++)
					if(pos==1)
					{
						nvo.setSig(ini);
						ini.setAnt(nvo);
						ini = nvo;
					}
					else
						if(tmp!=null)
						{
							tmp.getAnt().setSig(nvo);
							nvo.setAnt(tmp.getAnt());
							nvo.setSig(tmp);
							tmp.setAnt(nvo);
						}
				case 3:
					nvo.setAnt(fin);
					fin.setSig(nvo);
					fin=nvo;
			}
		}
		else
			ini = fin =nvo;
		obd.Println("Alumno almacenado con exito. \n");
	}
	
	public void Extraer (int op)
	{
		if(!this.Vacia())
		{
			obd.Println("Datos del alumno extraido");
			switch(op)
			{
				case 1:
					ini.getAlu().Mostrar();
					if(ini!=fin)
					{
						ini = ini.getSig();
						ini.setAnt(null);
					}
					else
						ini=fin=null;
					break;
				case 2:
					do
						pos= obd.Entero("Dime la posicion a insetar");
					while(pos<1);
					for(tmp=ini, con=1;tmp!=null && con<pos;tmp=tmp.getSig(), con++)
					if(pos==1)
					{
						ini.getAlu().Mostrar();
						if(ini!=fin)
						{
							ini= ini.getSig();
							ini.setAnt(null);
						}
						else
							ini=fin=null;
					}
					else
						if(tmp!=null)
						{
							tmp.getAlu().Mostrar();
							if(tmp!=fin)
							{
								tmp.getAnt().setSig(tmp.getSig());
								tmp.getSig().setAnt(tmp.getAnt());
							}
							else
							{
								fin = fin.getAnt();
								fin.setSig(null);
							}
						}
						else
							obd.Println("la posicion es mayor del tamaño de la lista");
				case 3:
					fin.getAlu().Mostrar();
					if(ini!=fin)
					{
						fin = fin.getAnt();
						fin.setSig(null);
					}
					else
						ini=fin=null;
					
			}
		}
		else
			obd.Println("Lista de alumnos Vacia");
		obd.Println("");
	}
	
	public void Recorrido()
	{
		if(!this.Vacia())
		{
			obd.Println("Lista de Alumnos");
			for(tmp=ini,con=1;tmp!=null; tmp = tmp.getSig(), con++)
			{
				obd.Println(con+"\t");
				tmp.getAlu().Mostrar();
			}
		}
		else
			obd.Println("Lista de alumnos Vacia");
		obd.Println("");
	}
	
	public void BuscarMod(int op)
	{
		if(!this.Vacia())
		{
			do
				nc = obd.Cadena("Numero de contral del alumno"+(op==4?"Buscar":"Modificar")).toUpperCase();
			while(nc.isBlank());
			for(tmp=ini;tmp!=null && !tmp.getAlu().Control().equals(nc); tmp = tmp.getSig());
			if(tmp!=null)
			{
				obd.Println("Datos del alumno");
				tmp.getAlu().Mostrar();
				if(op==5)
					tmp.getAlu().Modificar();
					
			}
			else
				obd.Println("Numero de control no existe en la lista");
			
		}
		else
			obd.Println("Lista de alumnos Vacia");
		obd.Println("");
	}
	
	public void Borrar()
	{
		if(!this.Vacia())
		{
			ini=fin=null;
			obd.Println("Lista de alumnos Borrada.");
		}
		else
			obd.Println("Lista de alumnos Vacia");
		obd.Println("");
	}
	
}
