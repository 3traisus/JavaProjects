package Tema_3;

public class NodoDobleA
{
	private Alumno alu;
	private NodoDobleA ant,sig;
	
	public NodoDobleA(Alumno alu)
	{
		ant = null;
		this.alu = alu;
		sig = null;
	}

	public Alumno getAlu()
	{
		return alu;
	}

	public void setAlu(Alumno alu)
	{
		this.alu = alu;
	}

	public NodoDobleA getAnt()
	{
		return ant;
	}

	public void setAnt(NodoDobleA ant)
	{
		this.ant = ant;
	}

	public NodoDobleA getSig()
	{
		return sig;
	}

	public void setSig(NodoDobleA sig)
	{
		this.sig = sig;
	}
	
	
}
