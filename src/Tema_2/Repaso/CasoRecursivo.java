package Tema_2.Repaso;

import lib20.Datos;

public class CasoRecursivo
{
	private Datos obd = new Datos();
	private double ini,gan=1.3,tot;
	int meses;
	
	public CasoRecursivo()
	{
		do
			ini= obd.Doble("Dame el monto inicial");
		while(ini<1);
		do
			meses = obd.Entero("Dame a cuantos meses");
		while(meses<1);
	}
	
	public void Llama()
	{
		tot=this.Proc(ini,meses);
	}
	
	private double Proc(double act,int meses)
	{
		if(meses>0)
		{
			act *= gan;
			return this.Proc(act,--meses);
		}
		else
			return act;
	}	
	
	public void Mostrar()
	{
		obd.Println("Usted empezo:"+ini+"\n con un ingreso:"+gan+"\n a"+meses+"meses"+
				"\n le genero una ganancia:"+(tot-ini)+"\n su total en la cuenta es:"+tot);
	}
}
