package Tema_3.Repaso;

public class ListaDobleLiga
{
	private TDA2 ref;
	private ListaDobleLiga ant,sig;
	
	public ListaDobleLiga (TDA2 ref)
	{
		this.ref = ref;
		ant=sig=null;
	}
	
	public TDA2 getRef()
	{
		return ref;
	}
	public void setRef(TDA2 ref)
	{
		this.ref = ref;
	}
	public ListaDobleLiga getAnt()
	{
		return ant;
	}
	public void setAnt(ListaDobleLiga ant)
	{
		this.ant = ant;
	}
	public ListaDobleLiga getSig()
	{
		return sig;
	}
	public void setSig(ListaDobleLiga sig)
	{
		this.sig = sig;
	}
	
	
}
