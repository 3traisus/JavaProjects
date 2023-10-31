package Odyseo;

import lib20.Datos;
import lib20.Menu;

public class Comaflotantes
{
	private Datos obd = new Datos();
	int ped;
	float pfd;
	String ent="",fra="",IEEE754="";
	
	
	public void Transformar(String cad)
	{
		int temp = cad.indexOf('.'),ini=0;
		boolean ban=false;
		
		if(cad.charAt(0)=='-')
		{
			ini++;
			IEEE754+="1";
		}
		else
			IEEE754+="0";
			
		
		if(temp!=-1)
		{
			ped= Integer.parseInt(cad.substring(ini, temp));
			pfd= Float.parseFloat(cad.substring(temp));
			ban = true;
		}		
		else
			ped = Integer.parseInt(cad);	
		
		if(ban)
		{
			while(ped>1)
			{
				ent=ped%2+ent;
				ped/=2;
			}
			ent=ped+ent;
			
			while(pfd<1)
			{
				fra+="0";
				pfd*=2;
			}
			fra+="1";
		}
		else
		{
			while(ped/2>1)
			{
				ent=ped%2+ent;
				ped/=2;
			}
			ent=ped+ent;
		}
		this.bits8();
		this.Bits23();
		obd.Println("Cadena transformada");

	}
	
	private void bits8()
	{
		int temp=127+ent.length()-1;
		String sos = "";
		
		while(temp>1)
		{
			sos=temp%2+sos;
			temp/=2;
		}
		sos=temp+sos;
		IEEE754+=sos;
	}
	
	private void Bits23()
	{
		String temp=fra;
		for(int x=temp.length();x<23;x++,temp+="0");
		IEEE754+=temp;
	}
	
	public void Cientifica()
	{
		obd.Println(ent.charAt(0)+"."+ent.substring(1)+fra+" X 2^"+(ent.length()-1));		
	}
	
	public void Mostrar()
	{
		obd.Println(IEEE754);
	}

	/*private Pattern pat=Pattern.compile("[^01]");
	private int x;
	private String cad,res;
	private Datos obd = new Datos();
	private FloarCad obf = new FloarCad();
	
	public void Lectura()
	{
		do
			cad=obd.Cadena("Dame una cadena en coma flotantes");
		while(!this.Validar());
		obd.Println("hola");
	}
	
	/*private boolean Validar() // revisa q no contega elementos del patner
	{
		if(!pat.matcher(cad).find())
			return true;
		else
			return false;
	}*/
	
	/*private boolean Validar() //revisa q contenga las caracterisiticas del parametro rango/lenght 
	{
		if(cad.matches("[01]{32}"))
			return true;
		else
			return false;
	}*/	
	
	public static void main(String[] args)
	{	
		int op;
		String val="";
		Menu obm;
		obm = new Menu("Cadenas Flotantes 2", new String[] {"Validar Cadena","Transformar","Mostrar Decimal","Mostrar Notacion cientifica","Mostrar IEEE754",});
		
		Comaflotantes ob = new Comaflotantes();
		FloarCad obf = new FloarCad();
		
		do
			switch(op=obm.Opcion())
			{
				case 1:
					obf.Lectura();
					val="";
					break;
				case 2:
					val=obf.ValorFloat();
					ob.Transformar(val);
					break;
				case 3:
					if(!val.isBlank())
						obf.Mostrar();
					break;
				case 4:
					if(!val.isBlank())
						ob.Cientifica();
					break;
				case 5:
					if(!val.isBlank())
						ob.Mostrar();
			}
		while(op!=obm.Salir());
		
	}
}
