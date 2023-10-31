package Tema_4;

import java.util.LinkedList;

import lib20.Datos;

public class ArbolBinario
{
	private int nivel;
	private NodoArbol raiz,nvo,act,ant,may,antsuce,suce;
	private Datos obd = new Datos();
	private LinkedList<NodoArbol> lista = new LinkedList<NodoArbol>();
	
	public ArbolBinario()
	{
		raiz = null;
	}
	
	private boolean Vacia()
	{
		return raiz==null;
	}
	
	private void Camino()
	{
		act = raiz;
		nivel =1;
		while(act!=null && act.getNum() !=nvo.getNum())
		{
			ant = act;
			act = nvo.getNum()>act.getNum()?act.getDer():act.getIzq();
			nivel++;
		}
	}
	
	public void Insertar()
	{
		nvo = new NodoArbol(obd.Entero("Escribe el numero del nodo"));
		if(!this.Vacia())
		{
			this.Camino();
			if(act==null) 
			{
				if(nvo.getNum()>ant.getNum())
					ant.setDer(nvo);
				else
					ant.setIzq(nvo);
			}
			else
				obd.Println("Nodo Repetido");
		}
		else
		{
			raiz=nvo;
			obd.Println("Nodo Insertado con exito");
		}
		obd.Println("");
			
	}
	
	public void Fusion()
	{
		if(!this.Vacia())
		{
			nvo = new NodoArbol(obd.Entero("Escribe el numero el cual desea eliminar"));
			this.Camino();
			if(act!=null)
			{
				obd.Println("Numero Eliminado");
				if(act.getDer()==null)
					nvo= act.getIzq();
				else 
					if(act.getIzq()==null)
						nvo = act.getDer();
					else
					{
						may = act.getIzq();
						while(may.getDer()!=null)
						{
							may = may.getDer();
						}
						may.setDer(act.getDer());
					}
				if(act!=raiz)
					if(ant.getDer()==act)//Aqui otorgamos la ruta nueva para poder eliminar 
						ant.setDer(nvo);
					else
						ant.setIzq(nvo);
				else raiz =nvo;
			}
			else
				obd.Println("El numero no se encuentra en el arbol");
		}
		else
			obd.Println("Arbol vacio");
	}
	
	public void Copeado()
	{
		if(this.Vacia())
		{
			nvo = new NodoArbol(obd.Entero("Escribe la cadena a eliminar"));
			this.Camino();
			if(act != null)
			{
				obd.Println("Nodo Eliminado");
				if(act.getIzq()!=null && act.getDer()!=null)
				{
					antsuce = act;
					suce = act.getIzq();
					while(suce.getDer()!=null)
					{
						antsuce = suce;
						suce = suce.getDer();
					}
					act.setNum(suce.getNum());
					antsuce.setDer(suce.getIzq());
				}
				else
					if(act.getIzq()!=null)
					{
						antsuce = act;
						suce = act.getIzq();
						while(suce.getDer()!=null)
						{
							antsuce = suce;
							suce = suce.getDer();
						}
						act.setNum(suce.getNum());
						antsuce.setDer(suce.getIzq());
					}
					else
						if(act.getDer()!=null)
						{
							antsuce = act;
							suce = act.getDer();
							while(suce.getIzq()!=null)
							{
								antsuce = suce;
								suce = suce.getDer();
							}
							act.setNum(suce.getNum());
							antsuce.setIzq(suce.getDer());
						}
						else
						{
							if(act!=raiz)
								if(ant.getIzq()==act)
									ant.setIzq(null);
								else
									act.setDer(null);
							else
								raiz = null;
						}
			}
			else
				obd.Println("El Numero no existe en el arbol");
		}
		else
			obd.Println("El arbol esta vacio");
		obd.Println("");
			
	}
	
	public void Amplitud()
	{
		if(!this.Vacia())
		{
			obd.Println("Contenido del arbol");
			lista.clear();
			lista.addLast(raiz);
			while(!lista.isEmpty())
			{
				act = lista.removeFirst();
				obd.Println(""+act.getNum());
				if(act.getIzq()!=null)
					lista.addLast(act.getIzq());
				if(act.getDer()!=null)
					lista.addLast(act.getDer());
			}
		}
		else
			obd.Println("El arbol esta vacio");
		obd.Println("");
	}
	
	public void Profundidad()
	{
		if(!this.Vacia())
		{
			obd.Println("Contenido del arbol");
			lista.clear();
			lista.addLast(raiz);
			while(!lista.isEmpty())
			{
				act = lista.removeLast();
				obd.Println(""+act.getNum());
				if(act.getIzq()!=null)
					lista.addLast(act.getDer());
				if(act.getDer()!=null)
					lista.addLast(act.getIzq());
			}
		}
		else
			obd.Println("El arbol esta vacio");
		obd.Println("");
	}
	
	public void Buscar()
	{
		if(this.Vacia())
		{
			nvo = new NodoArbol(obd.Entero("Escribe la cadena a eliminar"));
			this.Camino();
			if(act != null)
				obd.Print("Si existe en arbol y esta en el nivel" + nivel);
			else
				obd.Print("No existe en arbol y esta en el nivel" + nivel);
		}
		else
			obd.Println("El arbol esta vacio");
		obd.Println("");
	}
	
	public void Balanceo()
	{
		if(this.Vacia())
		{
			lista.clear();
			this.Lista(raiz);
			raiz = null;
			this.Balanceo(0,lista.size());
			obd.Println("Arbol balanceado");
		}
		else
			obd.Println("Arbol binario vacio");
		obd.Println("");

	}
	
	private void Lista(NodoArbol tmp )
	{
		if(tmp!=null)
		{
			this.Lista(tmp.getIzq());
			lista.add(tmp);
			this.Lista(tmp.getDer());
		}
	}
	
	private void Balanceo(int ini, int fin)
	{
		int cen= (ini + fin)/2;
		if(ini<=fin)
		{
			this.Insertar(lista.get(cen).getNum());
			this.Balanceo(ini,cen-1);
			this.Balanceo(cen+1,fin);
		}
	}
	
	public void Insertar(int num)
	{
		nvo = new NodoArbol(num);
		if(!this.Vacia())
		{
			this.Camino();
			if(act==null) 
			{
				if(nvo.getNum()>ant.getNum())
					ant.setDer(nvo);
				else
					ant.setIzq(nvo);
			}
		}
		else
			raiz=nvo;
		obd.Println("");
			
	}
	
	public void Borrar()
	{
		if(this.Vacia())
		{
			raiz = null;
			obd.Println("Arbol Binario borrado");
		}
		else
			obd.Println("Arbol binario vacio");
		obd.Println("");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
