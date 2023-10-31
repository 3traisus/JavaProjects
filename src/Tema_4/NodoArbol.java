package Tema_4;

public class NodoArbol
{
	private int num;
	private NodoArbol izq, der;
	
	public NodoArbol(int num)
	{
		this.num=num;
		der=izq=null;
	}

	public int getNum()
	{
		return num;
	}

	public void setNum(int num)
	{
		this.num = num;
	}

	public NodoArbol getIzq()
	{
		return izq;
	}

	public void setIzq(NodoArbol izq)
	{
		this.izq = izq;
	}

	public NodoArbol getDer()
	{
		return der;
	}

	public void setDer(NodoArbol der)
	{
		this.der = der;
	}
	
	
}
