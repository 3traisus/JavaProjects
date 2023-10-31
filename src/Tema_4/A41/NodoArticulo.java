package Tema_4.A41;

public class NodoArticulo
{
	private Articulo art;
	private NodoArticulo der, izq;
	
	public NodoArticulo(Articulo art)
	{
		this.art = art;
		der = izq = null;
	}

	public Articulo getArt()
	{
		return art;
	}

	public void setArt(Articulo art)
	{
		this.art = art;
	}

	public NodoArticulo getDer()
	{
		return der;
	}

	public void setDer(NodoArticulo der)
	{
		this.der = der;
	}

	public NodoArticulo getIzq()
	{
		return izq;
	}

	public void setIzq(NodoArticulo izq)
	{
		this.izq = izq;
	}
	
	
}
