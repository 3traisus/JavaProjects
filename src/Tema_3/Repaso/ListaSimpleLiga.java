package Tema_3.Repaso;

public class ListaSimpleLiga
{
	private TDA2 ref;
	private ListaSimpleLiga sig;
	
	public ListaSimpleLiga (TDA2 ref)
	{
		this.ref = ref;
		sig = null;
	}
	
	public TDA2 getRef()
	{
		return ref;
	}
	public void setRef(TDA2 ref)
	{
		this.ref = ref;
	}
	public ListaSimpleLiga getSig()
	{
		return sig;
	}
	public void setSig(ListaSimpleLiga sig)
	{
		this.sig = sig;
	}
	
	
}
