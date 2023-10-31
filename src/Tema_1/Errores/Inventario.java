package Tema_1.A12;

public class Inventario
{
	private String clv, nom;
	private int ex, por;
	private double comp, vent;
	
	public String getClv()
	{
		return clv;
	}

	public void setClv(String clv)
	{
		this.clv = clv;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public int getEx()
	{
		return ex;
	}

	public void setEx(int ex)
	{
		this.ex = (ex <= 0) ? 0 : ex;
	}

	public int getPor()
	{
		return por;
	}

	public void setPor(int por)
	{
		this.por = (por<20)? 20 : por;
	}

	public double getComp()
	{
		return comp;
	}

	public void setComp(double comp)
	{
		this.comp = (comp <= 0) ? 1 : comp;
	}

	public void Calc()
	{
		this.vent = comp + comp * por / 100;
	}

	public double getVent()
	{
		return vent;
	}

	public void Mostrar()
	{
		System.out.println("Clave:" + clv + "\t Nombre:" + nom + "\t Existencia:" + ex + "\t Compra:-" + comp
				+ "\t Porcentaje:" + por + "\t Venta:" + vent);
	}
	
}
