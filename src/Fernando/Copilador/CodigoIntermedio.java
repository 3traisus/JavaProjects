package Fernando.Copilador;

import java.util.LinkedList;

import lib20.Datos;

public class CodigoIntermedio
{

	private LinkedList<String> entrada = new LinkedList<String>();
	private Datos obd = new Datos();
	
	private String 
	//expDec=("(int|float|char)([a-z]([a-z]|[A-Z])*[0-9]*)(;)"),
	expTip=("(int|float|char|,)"),
	expNum=("-?[0-9][0-9]*(.[0-9]*[1-9])?"),
	expId=("[a-z]([a-z]|[A-Z])*[0-9]*"),
	expOp="*/+-";
	
	private String[] operadores = new String[] {"+","-","*","/"};
	
	public void Nuevo(String ele)
	{
		entrada.add(ele);
	}
	
	public void Nuevos(LinkedList<String> nuevos)
	{
		entrada.addAll(nuevos);
	}
	
	public LinkedList<String> Elementos()
	{
		return entrada;
	}
	
	public LinkedList<String> Traducir()
	{
		int x,pos=0,y;
		String cad="";
		entrada.add("$");
		LinkedList<String> pila = new LinkedList<String>();
		while(!entrada.getFirst().equals("$"))
		{
			if(entrada.getFirst().matches(expTip))
			{
				entrada.removeFirst();
				if(entrada.getFirst().matches(expId))
					pila.add(entrada.removeFirst()+" DB");
				else
					obd.Println("Algo esta muy mal");
			}
			else
				if(entrada.getFirst().matches(expId))
				{
					cad=entrada.removeFirst();
					if(entrada.getFirst().equals("="))
					{
						cad=cad+entrada.removeFirst()+"V0";
					}
				}else
					if(entrada.getFirst().matches(expNum))
					{
						for(x=0;x<entrada.size() && !expOp.contains(entrada.get(x));x++);
						if(x==2)
						{
							pila.add("float V"+pos+";");
							pila.add("V"+(pos++)+"= "+ entrada.get(x-2));//0
							pila.add("float V"+pos+";");
							pila.add("V"+(pos--)+"= "+ entrada.get(x-1));//1
							pila.add("V"+(pos) +"= V"+(pos)+""+entrada.get(x) +" V"+(++pos));//0-0-1
							entrada.remove(x);
							entrada.remove(x-1);
							entrada.remove(x-2);
							pos++;
						}
						else
							if(x==1)
							{
								pos=pos-2;
								pila.add("V"+(pos) +"= V"+(pos)+""+entrada.remove(x) +""+entrada.remove(x-1));
								pos=pos+2;
							}
							else
								if(x==0)
								{
									pos=pos-4;
									pila.add("V"+(pos) +"= V"+(pos)+""+entrada.removeFirst()+"V"+(pos+2));
									pos=pos+4;
								}
					}
					else
						entrada.removeFirst();
		}
		pila.add(cad);
		return pila;
	}
	
}
