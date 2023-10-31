package Tema_3;

public class NodoSimpleTra
{
	private Trabajador tra;
	private NodoSimpleTra sig;
	
	public NodoSimpleTra(Trabajador tra)
	{
		this.tra=tra;
		sig =null;
	}
	
	public Trabajador getTrabajador()
	{
		return tra;
	}
	
	public void setTrabajador(Trabajador tra)
	{
		this.tra=tra;
	}
	
	public NodoSimpleTra getSiguiente()
	{
		return sig;
	}
	
	public void setSiguiente (NodoSimpleTra siguiente)
	{
		this.sig = siguiente;
	}
	
}
