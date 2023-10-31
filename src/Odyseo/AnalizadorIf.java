package Odyseo;

import java.util.LinkedList;

import lib20.Datos;

public class AnalizadorIf
{

	private Datos obd = new Datos();
	private String cad;
	
	private LinkedList<String> lista = new LinkedList<String>();
	private LinkedList<String> listCad = new LinkedList<String>();
	private String valIfRen[]= {"E","E1","T","T1","F"},
			lenguaje[]= {"var"},
			valIfCol[]= { "-", "+", "*", "/","ID","NUM","$","(",")","TRUE","FALSE",">","<",">=","<=","==","!=","!","&&","||",";"};
	private String matIf[][] = {
			/*{},
			{},
			
			{},
			{},*/
			
			{"T E1","T E1","T E1","T E1","T E1","T E1","","T E1","T E1","T E1","#","#","#","#","#","#","#","#","#","#","#"},//E
			{"- T E1","+ T E1","","","#","#"," ","#","","#","#","#","#","#","#","#","#","#","#","#"," "},//E1

			{"#","#","F T1","F T1","F T1","F T1","","F T1","F T1","F T1","#","#","#","#","#","#","#","#","#","#","#"},//T
			{"","","* F T1","/ F T1","#","#"," ","#","","#","#","#","#","#","#","#","#","#","#","#",""},//T1
			
			{"#","#","#","#","ID","NUM","","( T )","","TRUE","FALSE","#","#","#","#","#","#","#","#","#",""}//F
	};
	
	private String expId=("[a-z]([a-z]|[A-Z])*[0-9]*"),
			expNum=("[1-9][0-9]*(.[0-9]*[1-9])?"),
			expChar=("[/*+()-]"),
			expOpeRel=(">=|<=|==|!=|>|<"),
			expLog=("!|&&|\\|\\|"),
			expBolean1="FALSE",expBolean2="TRUE";
	
	public void  Validad()
	{
		int x=0,y=0;
		String temp,temp2;
		lista.clear();
		lista.add("$");
		lista.addLast("E");
		
		while(!lista.isEmpty())
		{
			if(!listCad.isEmpty())
				temp2=listCad.getFirst();
			else
				temp2="$";
			
			//obd.Println("Elementos finales/"+lista.getLast()+"/"+listCad.getFirst());
			for(x=0;x<valIfRen.length && !valIfRen[x].contains(lista.getLast()!="$"?lista.getLast():"T1");x++);
			for(y=0;y<valIfCol.length && !valIfCol[y].contains(temp2);y++);
			if(x>=valIfRen.length || y>=valIfCol.length)
			{
				obd.Println("Trono");
				break;
			}
				
			
			temp=matIf[x][y];
			for(int z=0;z<lista.size();z++)
				obd.Print(lista.get(z)+"-");
			obd.Println("");
			
			if(temp!="#")
			{
				lista.removeLast();
				lista.addAll(this.Invertir(this.Separar(temp)));
				if(temp2!="$")
					if(lista.getLast().equals(temp2))
					{
						obd.Println("ELIMINADO");
						listCad.removeFirst();
						lista.removeLast();
					}
			}
			else
				break;
		}
		if(lista.isEmpty())
			obd.Println("Cadena aceptada");
		else
			obd.Println("Cadena no aceptada");
	}
	
	public void Lectura()
	{
		do 
			cad = obd.Cadena("Dame la cadena a validar");
		while(cad.isBlank());
		listCad = this.Transformar(this.Separar(cad));
	}
	
	private LinkedList<String> Transformar(LinkedList<String> trans)
	{
		int x;
		boolean ban=true;
		for(String T:trans)
			obd.Println(T);
		LinkedList<String> lisTrans = new LinkedList<String>();
		for(String T:trans)
		{
			for(x=0;x<lenguaje.length && !lenguaje[x].contains(T);x++);
			if(x>=lenguaje.length)
			{
				if(ban)
				{
					if(T!="=")
					{
						if(T.equals(expBolean1) || T.equals(expBolean2))
						{
							lisTrans.add(T);
							obd.Println("Aceptado como boolean");
						}
						else
							if(T.matches(expLog))
							{
								lisTrans.add(T);
								obd.Println("Aceptado como Logico");
							}
							else
								if(T.matches(expOpeRel))
								{
									lisTrans.add(T);
									obd.Println("Aceptado como operador logico");
								}else
									if(T.matches(expId))
									{
										lisTrans.add("ID");
										obd.Println("Aceptado como id");
									}
									else
										if(T.matches(expNum))
										{
											lisTrans.add("NUM");
											obd.Println("Aceptado como num");
										}
										else
											if(T.matches(expChar))
											{
												lisTrans.add(T);
												obd.Println("Aceptado como char");
											}
					}
				}else
				{
					ban=true;
				}
			}
			else
				ban=false;
		}
		for(String T:lisTrans)
			obd.Println(T);
		return lisTrans;
	}
	
	private void Funciones()
	{
		
	}

	private LinkedList<String> Separar(String cad)//SEPARAR POR ESPACIOS
	{
		cad+=" ";
		LinkedList<String> LisTemp = new LinkedList<String>();
		int temp;
		for(int x=0;x<cad.length();x++)
		{
			temp = cad.indexOf(" ",x);
			//obd.Println(temp+"");
			if(temp!=-1)
				if(!cad.substring(x,temp).isBlank())
					 LisTemp.add(cad.substring(x,x=temp));
		}
		return LisTemp;
	}
	private LinkedList<String>  Invertir(LinkedList<String> inv)//INVERTIR LISTA
	{

		LinkedList<String> temp = new LinkedList<String>();
		for(int x=inv.size()-1;x>=0;x--)
			temp.add(inv.get(x));
		return temp;
	}
	
	public static void main(String[] args)
	{
		AnalizadorIf ob = new AnalizadorIf();
		ob.Lectura();
		ob.Validad();
		
	}

}
