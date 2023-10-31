package Tema_4;

public class NodoArbolCt
{
	private Cuenta cue;
	private NodoArbolCt izq, der ,pad;
	
	public NodoArbolCt(Cuenta cue)
	{
		this.cue = cue;
		pad = izq = der = null;
	}

	public Cuenta getCue()
	{
		return cue;
	}

	public void setCue(Cuenta cue)
	{
		this.cue = cue;
	}

	public NodoArbolCt getIzq()
	{
		return izq;
	}

	public void setIzq(NodoArbolCt izq)
	{
		this.izq = izq;
	}

	public NodoArbolCt getDer()
	{
		return der;
	}

	public void setDer(NodoArbolCt der)
	{
		this.der = der;
	}

	public NodoArbolCt getPad()
	{
		return pad;
	}

	public void setPad(NodoArbolCt pad)
	{
		this.pad = pad;
	}
	
}
