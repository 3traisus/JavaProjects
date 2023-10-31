package Tema_4;

import java.util.LinkedList;

import lib20.Datos;

public class ArboldeCuentas
{
	private NodoArbolCt raiz, nvo, act, may, ant;
	private Datos obd = new Datos();
	private LinkedList<NodoArbolCt> lista = new LinkedList<NodoArbolCt>();
	
	public ArboldeCuentas()
	{
		raiz = null;
	}
	
	private boolean Vacio()
	{
		return raiz==null;
	}
	
	private void Existe()
	{
		for(ant=raiz,act = raiz; act!=null && act.getCue().Numero()!=nvo.getCue().Numero(); 
				ant=act, act= nvo.getCue().Numero()>act.getCue().Numero()? act.getDer(): act.getIzq());                    
		
	}
	
	private int Num()
	{
		if(!this.Vacio())
		{
			for(may = raiz; may.getDer()!=null;may=may.getDer());
			return may.getCue().Numero()+1;
		}
		else
			return 1;	
	}
	
	public void Insertar()
	{
		nvo = new NodoArbolCt(new Cuenta(this.Num()));
		if(!this.Vacio())
		{
			this.Existe();
			ant.setDer(nvo);
			nvo.setPad(ant);
		}
		else
			raiz=nvo;
		obd.Println("Cuenta almacenada con exito");
	
	}
	
	public void Eliminar()
	{
		if(!this.Vacio())
		{
			nvo = new NodoArbolCt(new Cuenta("Numero de Cuenta a eliminar"));
			this.Existe();
			if(act!=null)
			{
				obd.Println("Datos de la cuenta eliminada");
				if(act.getIzq()==null)
					nvo = act.getDer();
				else
					if(act.getDer()==null)
						nvo = act.getIzq();
					else
					{
						nvo = may = act.getIzq();
						while(may.getDer()!=null)
							may = may.getDer();
						may.setDer(act.getDer());
						act.getDer().setPad(may);
					}
				if(act!=raiz)
				{
					if(ant.getDer()==act)
						ant.setDer(nvo);
					else
						ant.setIzq(nvo);
					nvo.setPad(ant);
				}
				else
				{
					raiz=nvo;
					raiz.setPad(null);
				}
			}
			else
				obd.Println("No existe el numero a elimninar");
		}
		else
			obd.Println("Arbol binario de cuentas vacio");	
		
	}
	
	public void Recorrido()
	{
		if(!this.Vacio())
		{
			obd.Println("Lista de cuentas de arbol");
			lista.clear();
			lista.addFirst(raiz);
			while(!lista.isEmpty())
			{
				may =lista.removeFirst();
				may.getCue().Mostrar();
				if(may.getIzq()!=null)
					lista.addLast(may.getIzq());
				else
					if(may.getDer()!=null)
						lista.addLast(may.getDer());
			}
		}
		else
			obd.Println("Arbol Vacio");
	}
	
	public void Buscar()
	{
		if(!this.Vacio())
		{
			nvo = new NodoArbolCt(new Cuenta("Numero de Cuenta a Buscar"));
			this.Existe();
			if(act!=null)
			{
				obd.Println("Datos de la cuenta");
				act.getCue().Mostrar();
			}
			else
				obd.Println("");
		}
		else
			obd.Println("Arbol binario de cuentas vacio");
		obd.Println("");
	}
	
	public void Deposito()
	{
		if (!this.Vacio())
		{
			nvo = new NodoArbolCt(new Cuenta("Número de la cuenta para hacer el deposito"));
			this.Existe();
			if (act != null)
			{
				System.out.println("Datos de la cuenta:");
				act.getCue().Mostrar();
				act.getCue().Deposito();
			}
			else
				System.out.println("La cuenta no existe.");
		}
		else
			System.out.println("Árbol binario de cuentas vació");
		System.out.println();
	}
	
	public void Retiro()
	{
		if (!this.Vacio())
		{
			nvo = new NodoArbolCt(new Cuenta("Número de la cuenta para hacer el retiro"));
			this.Existe();
			if (act != null)
			{
				System.out.println("Datos de la cuenta:");
				act.getCue().Mostrar();
				act.getCue().Retiro();
			}
			else
				System.out.println("La cuenta no existe.");
		}
		else
			System.out.println("Árbol binario de cuentas vació");
		System.out.println();
	}
	
	public void Balanceo()
	{
		if (!this.Vacio())
		{
			lista.clear();
			this.Lista(raiz);
			raiz = null;
			this.Balanceo(0, lista.size() - 1);
			System.out.println("Árbol binario de cuentas balanceado");
		}
		else
			System.out.println("Árbol binario de cuentas vació");
		System.out.println();
	}
	
	private void Lista(NodoArbolCt tmp)
	{
		if (tmp != null)
		{
			this.Lista(tmp.getIzq());
			lista.add(tmp);
			this.Lista(tmp.getDer());
		}
	}
	
	private void Balanceo(int ini, int fin)
	{
		int cen = (ini + fin) / 2;
		if (ini <= fin)
		{
			this.Insertar(lista.get(cen).getCue());
			this.Balanceo(ini, cen - 1);
			this.Balanceo(cen + 1, fin);
		}
	}
	
	public void Insertar(Cuenta cue)
	{
		nvo = new NodoArbolCt(cue);
		if (!this.Vacio())
		{
			this.Existe();
			if (nvo.getCue().Numero() > ant.getCue().Numero())
				ant.setDer(nvo);
			else
				ant.setIzq(nvo);
			nvo.setPad(ant);
		}
		else
			raiz = nvo;
	}
	
	public void Borrar()
	{
		if(!this.Vacio())
		{
			raiz= null;
		}
		else
			obd.Println("Arbol binario de cuentas vacio");
		obd.Println("");
	}
}





























