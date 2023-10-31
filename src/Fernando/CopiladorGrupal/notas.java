package Fernando.CopiladorGrupal;

public class notas
{
	
	/*if(x>=2)
	{
		obd.Println("aaa");
		pila.add("float "+"V"+pos+";");
		pila.add("V"+(pos++)+"= "+ entrada.get(x-2)+";");//0
		pila.add("float "+"V"+pos+";");
		pila.add("V"+(pos--)+"= "+ entrada.get(x-1)+";");//1
		pila.add("V"+(pos) +"= V"+(pos)+" "+entrada.get(x) +" V"+(++pos)+";");//0-0-1
		entrada.remove(x);
		entrada.remove(x-1);
		entrada.remove(x-2);
		pos++;
		if(!tempSwWh.isEmpty())
		{	
			if(tempSwWh.getLast().equals("sw"))
			pos-=2;
		}
	}
	else
		if(x==1)
		{
			obd.Println("bbb");
			pos=pos-2;
			pila.add("V"+(pos) +"= V"+(pos)+""+entrada.remove(x) +""+entrada.remove(x-1)+";");
			pos=pos+2;
			if(!tempSwWh.isEmpty())
			{
				if(tempSwWh.getLast().equals("sw"))
				pos-=2;
			}
		}
		else
			if(x==0)
			{
				if(pos<=3)
				{
					obd.Println("ccc");
					pos=pos-3;
					pila.add("V"+(pos) +"= V"+(pos)+""+entrada.removeFirst()+"V"+(pos+2)+";");
					pos=pos+3;
				}
				else
				{
					obd.Println("ddd");
					pos=pos-4;
					pila.add("V"+(pos) +"= V"+(pos)+""+entrada.removeFirst()+"V"+(pos+2)+";");
					pos=pos+4;
				}
				if(!tempSwWh.isEmpty())
				{
					if(tempSwWh.getLast().equals("sw"))
					pos-=4;
				}
			}
			/*else
			{
				obd.Println("eee");
				pila.add("V"+(pos++)+"="+entrada.removeFirst()+";");
				if(!tempSwWh.isEmpty())
				{
					if(tempSwWh.getLast().equals("sw"))
					pos-=1;
				}
			}*/
}
