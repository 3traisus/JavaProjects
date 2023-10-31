package Tema_3;

public class NoDoble
{
	private String producto;
	private NoDoble ant, sig;
	
	public NoDoble(String producto)
	{
		ant = null;
		this.producto = producto.toUpperCase();
		sig = null;
	}

	public String getProducto()
	{
		return producto;
	}

	public void setProducto(String producto)
	{
		this.producto = producto;
	}

	public NoDoble getAnt()
	{
		return ant;
	}

	public void setAnt(NoDoble ant)
	{
		this.ant = ant;
	}

	public NoDoble getSig()
	{
		return sig;
	}

	public void setSig(NoDoble sig)
	{
		this.sig = sig;
	}
	
	
	
	
	
}
