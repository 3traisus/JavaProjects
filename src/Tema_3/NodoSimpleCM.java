package Tema_3;

public class NodoSimpleCM
{
	private Materias mat;
	private NodoSimpleCM sig;
	
	public NodoSimpleCM(Materias mat)
	{
		this.mat = mat;
		sig=null;
	}

	public Materias getMat()
	{
		return mat;
	}

	public void setMat(Materias mat)
	{
		this.mat = mat;
	}

	public NodoSimpleCM getSig()
	{
		return sig;
	}

	public void setSig(NodoSimpleCM sig)
	{
		this.sig = sig;
	}
	
	
	
}
