package Tema_3.A32;

import lib20.Datos;
import lib20.Fecha;
import lib20.Menu;

public class Materias
{
	private int clv,ht,hp;
	private String nom,creditos,plan;
	private Datos obd = new Datos();
	private Fecha obf = new Fecha();
	
	public Materias(int clv)
	{
		this.clv = clv;
		do
			nom = obd.Cadena("Nombre de la materia").toUpperCase();
		while(nom.isBlank());
		do
			ht = obd.Entero("Numero de horas Teoricas 1-5");
		while(ht<1 || ht>5);
		do
			hp = obd.Entero("Numero de horas Practicas 1-5");
		while(hp<1 || hp>5);
		creditos = ht+"-"+hp+"-"+(ht+hp);
		plan = obf.Real(obd.Entero("Dame el Dia(1-31)"), obd.Entero("Dame el mes (1-12)"), obd.Entero("Dame el año (>0)"));
	}
	
	public int getClave()
	{
		return clv;
	}

	public void Mostrar()
	{
		obd.Println(clv+","+nom+","+ht+","+hp+","+creditos+","+plan);
	}
	
	public void Modificar()
	{
		int op;
        Menu obm=new Menu("Modificar",new String[] {"Nombre","Hora-Teoricas","Horas-Practicas"});
        do
            switch(op=obm.Opcion())
            {
            case 1:
                do
                    nom=obd.Cadena("Nuevo nombre de materia").toUpperCase();
                while(nom.isBlank());
                break;
            case 2:
                do
                    ht= obd.Entero("modifica horas teoricas");
                while(ht<1 || ht>5);
                break;
            case 3:
                do
                    hp= obd.Entero("modifica horas practicas");
                while(hp<1 || hp>5);
            }
        while(op !=obm.Salir());
        creditos = ht+"-"+hp+"-"+(ht+hp);
	}
}


