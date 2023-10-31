package Odyseo;

import java.util.LinkedList;

import lib20.Datos;

public class ContadorListas
{
	private LinkedList<Integer> lista = new LinkedList<Integer>();
	private Datos obd = new Datos();
	
	
	public LinkedList<String> preparar(String text)
	{
		LinkedList<String> LisTemp = new LinkedList<String>();
		String cad = text+"\n";
		obd.Println(cad);
		int temp=-1;
		for(int x=0;x<cad.length();x++)
		{
			temp = cad.indexOf("\n",x);
			//obd.Println(temp+"");
			if(temp!=-1)
				if(!cad.substring(x,temp).isBlank())
					 LisTemp.add(cad.substring(x,x=temp));
		}
		return LisTemp;
	}
	
	public void Contar(LinkedList<String> list)
	{
		int temp=-1;
		int cont=1;
		for(int x=0;x<list.size();x++)
		{
			list.set(x,list.get(x)+" ");
		}
		
		for(String ele: list)
		{
			for(int x=0;x<ele.length();x++)
			{
				temp = ele.indexOf(" ",x);
				//obd.Println(temp+"");
				if(temp!=-1)
					if(!ele.substring(x,temp).isBlank())
						 lista.add(cont);
			}
			cont++;
		}

		for(int ele: lista)
		{
			obd.Println(ele+"");
		}
	}
	
	public static void main (String []args)
	{
		ContadorListas cont = new ContadorListas();
		cont.Contar(cont.preparar("a b \n c"));
		
	}
}
