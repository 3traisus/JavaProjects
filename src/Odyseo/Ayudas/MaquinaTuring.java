package Odyseo.Ayudas;
import java.util.LinkedList;

import lib20.Datos;
public class MaquinaTuring
{
	private Datos obd = new Datos();
	private String datos,estFin="",cadVal;
	private int estados;
	private TDA_MT[][] tabla;
	private TDA_MT tda;
	private LinkedList<Character> pila = new LinkedList<Character>();
	
	public void CadenaVal()//Metodo cadena de entrada donde se le agregan los blancos inciales y finales 
	{
		do
			cadVal = obd.Cadena("Dame la cadena a validad");
		while(cadVal.isBlank() || this.Val());
		cadVal = "B"+cadVal+"B";
	}
	
	private boolean Val()//Valida que la cadena contenga los letras del universo 
	{
		int x=1;
		if(cadVal.length()>1)
			for(;x<cadVal.length() && datos.contains(cadVal.charAt(x)+"");x++);
		else
			if(!datos.contains(cadVal))
				return true;
		return x<cadVal.length();
	}
	
	public void Datos()//Pide las letras del universo y las guarda en una cadena
	{
		do
		{
			datos=obd.Cadena("Dame el Universo").trim();
			datos = this.EliminarEspacios();
		}	
		while(datos.isBlank()|this.Rep(datos,null));
		datos ="B"+datos;
		obd.Println(datos);
	}

	private String EliminarEspacios()//Elimina espacios de una cadena 
	{
		String update="";
		for(int x=0;x<datos.length();x++)
		{
			if(datos.charAt(x)!=' ')
				update = update + datos.charAt(x);
		}
		return update;	
	}

	private boolean Rep(String cad,String exc)//Revisa que no tenga elementos repetidos en una cadena y con las posibles excepciones 
	{
		int x;
		if(exc==null)//Sin excepciones 
		{
			for(x=0;x<cad.length();x++)
				if(cad.substring(x+1).contains(cad.charAt(x)+"") || cad.contains(" "))
					break;
		}
		else//con excepciones 
		{
			for(x=0;x<cad.length();x++)
				if(!exc.contains(cad.charAt(x)+""))
					if(cad.substring(x+1).contains(cad.charAt(x)+"") || cad.contains(" "))
						break;
		}
		return x<cad.length();
	}
	
	public void Estados()//Numero de estados existentes 
	{
		do
			estados = obd.Entero("Dame la cantidad de estados");
		while(estados<1);
		obd.Println(estFin);
			
	}
	
	public void Trans()// termina de declarar la reglas de la MT y asigna sus valores 
	{
		obd.Println(estados+"/"+datos.length());
		tabla = new TDA_MT[estados][datos.length()];
		
		byte mov;
		char ins;
		int est,x,y;
		for(x=0;x<tabla.length;x++)
		{
			for(y=0;y<tabla[x].length;y++)
			{
				tda = new TDA_MT();
				do
					est = obd.Entero("["+x+"]["+y+"]"+"Dame a Cual Estado se dirige");
				while(est<-1 || est>estados);
				if(est!=-1)
				{
					do
						ins = obd.Caracter("["+x+"]["+y+"]"+"Valor a insertar");
					while(!datos.contains(ins+""));
					do
						mov = obd.Byte("["+x+"]["+y+"]"+"L=1,R=2,Nada=0");
					while(mov<0|mov>2);
					tda.setInsert(ins);
					tda.setMov(mov);
				}
				tda.setEstado(est);
				tabla[x][y]=tda;
			}
		}		
		for(x=0;x<tabla.length;x++)
		{
			for(y=0;y<tabla[x].length;y++)
			{
				obd.Print(tabla[x][y].getEstado()+"/"+tabla[x][y].getInsert()+"/"+tabla[x][y].getMov()+"\t");
			}
			obd.Println("");
		}
		
	}
	
	public void GeneraValidacion()//Este genera el funcionamiento de una MT
	{
		obd.Println("LLegamos"+cadVal);
		pila.clear();
		int fila=0,col=0,ind=0,x=0;
		while(fila!=-1 && fila!=estados)
		{
			if(x<cadVal.length())//adquiere el valor de la columna apartir de la posicion de la cad o la pila
				col = datos.indexOf(cadVal.charAt(x++));
			else
				if(ind<pila.size())
					col = datos.indexOf(pila.get(ind));
				else
					col = datos.indexOf('B');
			
			obd.Println(tabla[fila][col].getInsert()+"["+fila+","+col+"]"+ind+"/"+pila.size());//imprime para comprobar 
			
			
			if(ind<pila.size())//si ind es mayor a pila.size significa q se ocupa agregar una posicion nueva de lo contrario modifica una posicion indica con ind
				pila.set(ind, tabla[fila][col].getInsert());
			else
				pila.add(tabla[fila][col].getInsert());
			
			if(tabla[fila][col].getMov()!=0)//si es igual a cero es igual a no se mueve 
				if(tabla[fila][col].getMov()==2)//si es igual a R=2 se mueve a la derecha 
					ind++;
				else//de lo contrario se mueve la izq, todo esto recorriendo la posicion del ind 
					ind--;
			fila = tabla[fila][col].getEstado();
		
		}
		for(char ele: pila)//Recorre la pila de elementos y lo muestra para ver el resultado 
		{
			obd.Print(ele+" ");
		}
		if(fila==-1)
			obd.Println("Cadena no aceptada");
		else
			if(fila==estados)
				obd.Println("Cadena aceptada");
	}
	
	public static void main(String[]args)
	{
		MaquinaTuring maq = new MaquinaTuring();
		maq.Datos();
		maq.Estados();
		maq.Trans();
		while(true)
		{
			maq.CadenaVal();
			maq.GeneraValidacion();
		}
	}
}
