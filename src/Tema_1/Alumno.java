package Tema_1;

import lib20.*;

public class Alumno
{
	private String nc, nom;
	private int edad;
	private char sex;
	private Datos obd = new Datos();

	public Alumno()
	{
		nc = obd.Cadena("NC");
		nom = obd.Cadena("Nombre");
		edad = obd.Entero("Promedio");
		sex = obd.Caracter("Sexo (F/M)");
	}

	public void Mostrar()
	{
		obd.Println(nc + "\t" + nom + "\t" + edad + "\t" + sex + "\t");
	}

	public String Control()
	{
		return nc;
	}
}
