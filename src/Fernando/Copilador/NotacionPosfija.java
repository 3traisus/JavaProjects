package Fernando.Copilador;

import java.util.LinkedList;

import lib20.Datos;

public class NotacionPosfija
{
	private Datos obd = new Datos();
	private LinkedList<String> entrada = new LinkedList<String>();
	private LinkedList<String> orden = new LinkedList<String>();
	private LinkedList<String> ordenEst = new LinkedList<String>();
	private String 
		expNum=("-?[0-9][0-9]*(.[0-9]*[1-9])?"),
		operadores[] = new String[] {"+","-","*","/"},
		prioridad[] = new String[] {"+-","*/","()"};
	
	public void Nuevo(String ele)
	{
		entrada.add(ele);
	}
	
	public void Orden()
	{
		LinkedList<String> tempSimb = new LinkedList<String>();
		entrada.add("$");
		ordenEst.add(entrada.removeFirst());
		ordenEst.add(entrada.removeFirst());
		
		//this.mostrarPilas(entrada);
		int p1,p2;
		
		while(!entrada.getFirst().equals("$"))
		{
			if(entrada.getFirst().matches(expNum))
			{
				orden.add(entrada.getFirst());
			}
			else
			{
				if(tempSimb.isEmpty())
					tempSimb.add(entrada.getFirst());
				else
				{
					p1 = this.Prioridad(entrada.getFirst());
					p2 = this.Prioridad(tempSimb.getFirst());
					//obd.Println("<"+p1+"/"+entrada.getFirst()+">"+"<"+p2+"/"+tempSimb.getFirst()+">");
					if(p1!=2 && p2!=2)
					{
						if(p2>=p1)
						{
							orden.add(tempSimb.removeFirst());
							tempSimb.addFirst(entrada.getFirst());
						}
						else
						{
							tempSimb.addFirst(entrada.getFirst());
						}
					}
					else
						if(entrada.getFirst().equals(")"))
						{
							//this.mostrarPilas(tempSimb);
							while(!tempSimb.getFirst().equals("("))
							{
								orden.add(tempSimb.removeFirst());
							}
							tempSimb.removeFirst();
							//orden.addAll(tempSimb);
						}
						else
							tempSimb.addFirst(entrada.getFirst());			
				}
			}
			entrada.removeFirst();
		}
		orden.addAll(tempSimb);
		ordenEst.addAll(orden);
		//obd.Println("////////////");
		//this.mostrarPilas(orden);
		//obd.Println(this.Resolver());
		
	}
	
	public String Resolver()
	{
		int x,y;
		String res="",ope;
		double der,izq;
		orden.add("$");
		
		for(x=0;x<orden.size();x++)
		{
			for(y=0;y<operadores.length && !operadores[y].equals(orden.get(x));y++);
			if(y<operadores.length)
			{
				if(!orden.get(x).equals("$"))
				{
					ope=orden.get(x);
					izq= Double.parseDouble(orden.get(x-1));
					der= Double.parseDouble(orden.get(x-2));
					//obd.Println(ope+"/"+izq+"/"+der+"/");
					orden.add(x, this.SeleccionarR(ope, izq, der)+"");
					//obd.Println(orden.get(x));
					orden.remove(x+1);
					orden.remove(x-1);
					orden.remove(x-2);
					x=0;
					//this.mostrarPilas(orden);
				}
			}
		}
		res=orden.getFirst();
		return res;
	}
	
	private double SeleccionarR(String op,double izq,double der)
	{
		double res=-2;
		switch(op)
		{
			case "+" :
				res = der + izq ;
				break;
				
			case "-" :
				res = der - izq ;
				break;
				
			case "*":
				res = der * izq ;
				break;
			
			case "/":
				res = der / izq ;
				break;
		}
		return res;
	}
	
	private int Prioridad(String cad)
	{
		int x;
		for(x=0;x<prioridad.length && !prioridad[x].contains(cad);x++);
			if(x<prioridad.length)
			{
				return x;
			}
			else
				return -1;
	}
	
	public LinkedList<String> OrdenAsig()
	{
		obd.Print("Notacion Posfija");
		this.mostrarPilas(ordenEst);
		return ordenEst;
	}
	
	public void mostrarPilas(LinkedList<String> pila)
	{
		System.out.println("Mostrar");
		for(int x = 0; x<pila.size();x++)
			System.out.println(pila.get(x));
	}
}
