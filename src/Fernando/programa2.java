package Fernando;

import java.util.Stack;

import lib20.Datos;
import lib20.Menu;

public class programa2 {
	private Datos obd = new Datos(); 
	private int x,con,est,transicion[][];
	private String cad,universe="",exp2,finales;
	private Stack<String> pila = new Stack<String>();
	
	
	private boolean Rep()
	{
		for(x=0;x<cad.length();x++)
			if(cad.substring(x+1).contains(cad.charAt(x)+"") || cad.contains(" "))
				break;
		return x<cad.length();
	}
	
	private boolean Permite(String exp,String cad)
	{
		return cad.matches(exp);
	}
	
	public void Universo()
	{
		do
			cad = obd.Cadena("Dame las letras del universo").trim();
		while(this.Rep() || cad.isEmpty());
		universe=cad;
	}
	
	public void Estados()
	{
		do
			est = obd.Entero("Dame la cantidad de estados");
		while(est<1 || est>9);
		exp2=("[0-"+(est-1)+"]*");
		transicion = new int[est][universe.length()];
	}
	
	public void Finales()
	{
		do
			cad = obd.Cadena("Dame los estados finales");
		while(!this.Permite(exp2,cad) || this.Rep());
		finales = cad;
	}
	
	public void Trans()
	{
		int y,res;
		for(x=0;x<transicion.length;x++)
		{
			for(y=0;y<transicion[x].length;y++)
			{
				do
					res = obd.Entero("Dame la transicion ["+x+"]["+y+"]");
				while(res<-1 || res>9 || !this.Permite(exp2,res+""));
				transicion[x][y]=res;
			}
		}		
	}
	
	public void Generar()
	{
		cad = obd.Cadena("Dame la cadena");
		int car=0;
		for(x=0;x<cad.length();x++) 
		{
			car=universe.indexOf(cad.charAt(x));
			if(car!=-1)
			{
				con=transicion[con][car];	
		
			  if(con==-1)
			  {
				  obd.Println("No aceptada");
				  return;
			  }
			}
			else
			{
				obd.Println("No aceptada");
				  return;
			}
			
		}
		if(finales.contains(con+""))
			obd.Println("Cadena acepta");
		else
			obd.Println("No aceptada");
	}
	
	/*public void Pila()
	{ 
		con = 0;
		int con2=0;
		String temp="";
		
		while(temp!="m")
		{
			do
			{
				temp = pila.push(obd.Cadena("Caracter"+con2)).trim();
			}while(temp.length()!=1 || this.validar(temp));
			if(temp.charAt(0)=='m')
			{
				pila.pop();
				break;	
			}
			con2++;
		}
		if(finales.contains(con+""))
		{
			while(!pila.isEmpty())
			{
				temp=pila.pop();
				obd.Println(temp);
				if(temp.charAt(0)!=obd.Caracter("Cadena inversa"+con2--))
				{
					pila.push(temp);
					break;
				}
					
			}
		}
		if(pila.isEmpty())
			obd.Println("Es aceptada");
		else
			obd.Println("No aceptada");
	}*/
	
	private boolean validar(String temp)
	{
		boolean ban=false;
		if(temp.charAt(0)!='m')
		{
			x=universe.indexOf(temp.charAt(0));
			if(x!=-1)
			{
				con=transicion[con][x];	
			}
			else
			{
				pila.pop();
				ban=true;
			}
				
		}
		obd.Println(ban+"");
		return ban;
	}
	
	public static void main (String[]args)
	{
		int op;
		Menu obm;
		obm = new Menu("Actividad 2", new String[] {"Tabla de Transiciones","Validar Cadena"});
		
		programa2 oba = new programa2();
		oba.Universo();
		oba.Estados();
		oba.Finales();
		do
			
			switch(op=obm.Opcion())
			{
				case 1:
					oba.Trans();
					break;
				case 2:
					oba.Generar();
					break;
				/*case 2:
					oba.Pila();*/
			}
		while(op!=obm.Salir());
		
	}
}