package Tema_3;

public class NodoSimple
{
	private String nombre;
	private NodoSimple sig;
	
	public NodoSimple(String nombre)
	{
		this.nombre = nombre.toUpperCase();
		sig = null;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public NodoSimple getSiguiente()
	{
		return sig;
	}
	
	public void setSiguiente (NodoSimple siguiente)
	{
		this.sig = siguiente;
	}
	
}
