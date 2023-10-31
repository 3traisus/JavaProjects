
package Tema_2.A21;

import lib20.Datos;

public class ProfMAt
{
	
	public int Num(int num)
	{
		while(num<1)
			num = new Datos().Entero("Numero a convertir");
		return num;
	}
	
	public String Bin(int num)
	{
		if(num>1)
			return this.Bin(num/2)+""+num%2;
		return ""+num;
	}
	
	public String Octal(int num)
	{
		if(num>7)
			return this.Octal(num/8)+""+num%8;
		else
			return ""+num;
	}
	
	public String Hexa(int num)
	{
		char op[] = new char [] {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		if(num>15)
			return  this.Hexa(num/16) + op[num%16];
		else
			return ""+op[num];
	}

}
