package Odyseo;


import java.util.Scanner;
import java.util.Stack;


public class AutomataBG3
{
	Scanner obd = new Scanner(System.in);
	private String expUni=("[a-z]*"),
		expFin,
		expTot,
		expEst,
		universe="";
	private int transiccion[][];
	
            public int Entero(String msj) {
        int num = 0;
        System.out.print(msj + " ");
        String input = obd.nextLine().trim();
        if (input.matches("\\-?[0-9]")) {
            num = Integer.parseInt(input);
        } else {
            num = this.Entero(msj);
        }
        return num;
    }
    
        public String Cadena(String msj) {
        String cad = "";
        System.out.print(msj + " ");
        if (obd.hasNextLine()) {
            cad = obd.nextLine().trim();
        } else {
            System.out.println("Error en el dispositivo de entrada");
        }
        return cad;
    }
    
        public char Caracter(String msj) {
        char car = ' ';
        System.out.print(msj + " ");
        String input = obd.nextLine().trim();
        if (input.isEmpty()) {
            car = this.Caracter(msj);
        } else {
            car = input.charAt(0);
        }
        return car;
    }
        
	private boolean Rep(String cad)
	{
		int x;
		for(x=0;x<cad.length();x++)
			if(cad.substring(x+1).contains(cad.charAt(x)+"") || cad.contains(" "))
				break;
		return x<cad.length();
	}
	
	public void Universo()
	{
		String universo;
		do
			universo = Cadena("Dame los datos");
		while(!universo.matches(expUni) | this.Rep(universo));		
		universe = universo;
	}
	
	public void Estados()
	{
		int x;
		do
			x = Entero("Dame la cantidad de estados");
		while(x<1 | x>9);		
		expEst = ("[0-"+(x-1)+"]*");
		expTot=("\\-[1]|[0-"+(x-1)+"]");
		transiccion = new int[x][universe.length()];
		//expEst = ("\\-[1-2]");
	}
	
	public void Finales()
	{
		String universo;
		do
			universo = Cadena("Dame los Estados Finales");
		while(!universo.matches(expEst) | this.Rep(universo));
		expFin = universo;
	}

	public void Trans()
	{
		int y,res,x;
		for(x=0;x<transiccion.length;x++)
		{
			for(y=0;y<transiccion[x].length;y++)
			{
				do
					res = Entero("Dame la transiccion ["+x+"]["+y+"]");
				while(!(res+"").matches(expTot));
				transiccion[x][y]=res;
			}
		}		
	}
	
	
	public void Generar()
	{
		String cad;
		int x,con=0;
		
		
		cad = Cadena("Dame la cadena");
		int car=0;
		for(x=0;x<cad.length();x++) 
		{
			car=universe.indexOf(cad.charAt(x));
			if(car!=-1)
			{
				con=transiccion[con][car];	
		
			  if(con==-1)
			  {
				  System.out.println("No aceptada por estado de rechazo");
				  return;
			  }
			  if(con==-2)
			  {
				  System.out.println("No aceptada por inexistencia");
				  return;
			  }
			}
			else
			{
				System.out.println("No aceptada");
				  return;
			}
			
		}
		if(expFin.contains(con+""))
		{
			System.out.println("Cadena acepta");
		}
		else
			System.out.println("No aceptada por no finalizar en estado final");
	}

	public static void main (String[]args)
	{

		
		AutomataBG3 oba = new AutomataBG3();
		oba.Universo();
		oba.Estados();
		oba.Finales();
	
		oba.Trans();
	
		oba.Generar();
	}
}
