package Tema_1;

public class Trabajador
{
	private String nom, puesto;
	private int tarjeta;
	private double sueld;

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getPuesto()
	{
		return puesto;
	}

	public void setPuesto(String puesto)
	{
		this.puesto = puesto;
	}

	public int getTarjeta()
	{
		return tarjeta;
	}

	public void setTarjeta(int tarjeta)
	{
		this.tarjeta = tarjeta;
	}

	public double getSueld()
	{
		return sueld;
	}

	public void setSueld(double sueld)
	{
		this.sueld = sueld;
	}

	public void Mostrar()
	{
		System.out.println(nom + "-" + puesto + "-" + tarjeta + "-" + sueld);
	}

}
