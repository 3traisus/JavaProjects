package Fernando;

import java.util.LinkedList;

import lib20.Datos;

public class ValidacionAsigna
{
	private Datos obd = new Datos();
	private LinkedList<String> entrada = new LinkedList<String>();
	private LinkedList<String> convertidos = new LinkedList<String>();
	private LinkedList<String> orden = new LinkedList<String>();
	private LinkedList<String> ordenFinal = new LinkedList<String>();

	private int digd,digi;
	private String op="",
			Tipos[] = new String[] {"int","float","char"},
			prioridad[] = new String[] {"+-","*/","()"},
			operadores[] = new String[] {"+","-","*","/"},
			expNum=("-?[0-9][0-9]*(.[0-9]*[1-9])?"),
			numEnt=("-?[0-9][0-9]*"),
			numFloat=("-?[0-9][0-9]*(.[0-9]*[1-9])");
	
	private int[][]////////////////////////////se uso para el analisis de asignacion
		asig =  new int[][] 
		{
			{1,1,1},
			{1,1,1},
			{1,0,1},
		},
		suma =  new int[][] 
		{
			{0,1,0},
			{1,1,1},
			{0,1,0},
		},
		resta =  new int[][] 
		{
			{0,1,0},
			{1,1,1},
			{0,1,0},
		},
		multi =  new int[][] 
		{
			{0,1,0},
			{1,1,1},
			{0,1,0},
		},
		div =  new int[][] 
		{
			{1,1,1},
			{1,1,1},
			{1,1,1},
		};

	public void Nuevo(String ele)////////////////////////////se uso para el analisis de asignacion
	{
		entrada.add(ele);
	}
	
	public void Orden()
	{
		LinkedList<String> tempSimb = new LinkedList<String>();
		entrada.add("$");
		ordenFinal.add( entrada.removeFirst());
		ordenFinal.add(entrada.removeFirst());
		
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
		ordenFinal.addAll(orden);
		//obd.Println("////////////");
		//this.mostrarPilas(orden);
		obd.Println(this.Resolver());
		
		
	}
	
	private String Resolver()
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
	
	private void Convertir() ////////////////////////////se uso para el analisis de asignacion
	{
		int x;
		for(String T:entrada)
		{
			if(!T.equals("(") && !T.equals(")"))
			{
				for(x=0;x<Tipos.length && !Tipos[x].equals(T);x++);
				if(x<Tipos.length)
					convertidos.add(x+"");
				else
					if(T.matches(numEnt))//mandar su tipo de dato
						convertidos.add("0");
					else
						if(T.matches(numFloat))
							convertidos.add("1");
						else
							convertidos.add(T);	
			}
		}
			
	}
	
	public boolean Analizar()////////////////////////////se uso para el analisis de asignacion
	{
		this.Convertir();
		convertidos.addFirst("$");
		obd.Println("Convertidos----------------------------------------------------");
		this.mostrarPilas(convertidos);
		while(!convertidos.getLast().equals("$"))
		{
			digd = Integer.parseInt(convertidos.removeLast());
			op = convertidos.removeLast();
			if(op=="$")
				break;
			digi = Integer.parseInt(convertidos.removeLast());
			convertidos.addLast(this.Seleccionar()+"");
		}
		convertidos.clear();
		if(digd==1)
			return false;
		else
			return true;

	}
	
	
	private int Seleccionar()////////////////////////////se uso para el analisis de asignacion
	{
		int res=-2;
		switch(op)
		{
			case "+" :
				res = suma[digi][digd];
				break;
				
			case "-" :
				res = resta[digi][digd];
				break;
				
			case "*":
				res = multi[digi][digd];
				break;
			
			case "/":
				res = div[digi][digd];
				break;
				
			case "=":
				res = asig[digi][digd];
		}
		return res;
	}
	
	public LinkedList<String> OrdenAsig()
	{
		this.mostrarPilas(ordenFinal);
		return ordenFinal;
	}
	
	
	public void mostrarPilas(LinkedList<String> pila)////////////////////////////se uso para el analisis de asignacion
	{
		System.out.println("Mostrar");
		for(int x = 0; x<pila.size();x++)
			System.out.println(pila.get(x));
	}


}
