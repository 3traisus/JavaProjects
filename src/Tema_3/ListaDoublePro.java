package Tema_3;

public class ListaDoublePro
{
	private ProductoOp nvo,tmp,ant;
	private String pro;
	private void Insetar(int op)
	{
		
		switch(op)
		{
			case 1:
				nvo.setSiguiente(ini);
				ini.setAnterior();
				ini=nvo;
				break;
			case 2:
				do
					pos=obd.Entero("Dame pos");
				while(pos<1);
				for(con=1,tmp=ini;tmp!=null && con<pos;tmp=tmp.getSiguiente(),con++);
				if(pos==1)
				{
					
				}else 
					if(tmp==null)
					{
						nvo.setAnterior(fin);
						fin.setSiguiente(nvo);
						fin=nvo;
					}
					else
					{
						
					}
				break;
			case 3:
		}
	}
	
	public void Extraer(op)
	{
		if(!this.Vacia)
		{
			switch()
			{
			case 1:
				obd.Println("producto");
				if(ini!=fin)
				{
					ini= ini.getSiguiente()
					ini.setAnterior(null);
				}else
					ini=fin=null;
				
				break;
			case 2:
				do
					pos=obd.Entero();
				while(pos<1);
				for(tmp=ini, con=1;tmp!=null && con<pos;tmp.getSiguiente, con++)
				{
					if(pos==1)
					{
						obd.Println()
						
					}
					else
						if(tmp!=null)
						{
							
						}
						else
							
					// tmp.getAnterior().setSiguiente(tmp.getSiguiente());
					//tmp.getSiguiente().setAnterior(tmp.getAnterior());
				}
			case 3:
				obd.Println("producto");
				if(ini!=fin)
				{
					fin = fin.getAnterior();
					fin.setSiguiente(null);
					ini.setAnterior(null);
				}else
			}
			
		}
		
		public void Recorrido()
		{
			
		}
		
		public void BuscarModificar(int op)
		{
			if(!this.Vacia)
			{
				do 
					pro = obd.Cadena(""+(op==4?"buscar":"Modificar"));
				while(pro.isBlank());
				for(tmp =ini, pos=1; tmp!=null && tmp.getProducto().equals(pro); tmp.tmp.getSiguiente(), pos++;)
					if(tmp!=null)
						if(op==4)
							obd.printl("Producto encontrado en la posicion "+ pos);
						else
							do
								tmp.setProducto(obd.Cadena("Nuevo nombre ").toLowerCase());
							while(tmp.getProducto().isBlank());
					else
						obd.PRintl("Producto no esta en la lista");
				
			}
			else
				obd.Printl("Lista Vacia");
			obd.Println("");
		}
		
		public void Borrar()
		{
			if(!this.Vacia)
			{
				ini=fin=null;
				obd.println("Lista de productos borrada");
			}
			else
				obd.println("Lista Vacia");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
