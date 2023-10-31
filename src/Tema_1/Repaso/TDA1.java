package Tema_1.Repaso;

public class TDA1
{
	private int tar,sueld;
	private String nom,puesto;
	
	public int getTar()
	{
		return tar;
	}
	public void setTar(int tar)
	{
		this.tar = tar;
	}
	public int getSueld()
	{
		return sueld;
	}
	public void setSueld(int sueld)
	{
		this.sueld = sueld;
	}
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
	
	public void Mostrar()
	{
		System.out.println(tar+"\t"+nom+"\t"+puesto+"\t"+sueld);
	}
	
}
