package Tema_3;

import lib20.Datos;

public class PilaPromedio
{
    private int ind,pos;
    private String pila[],cal;
    private Datos obd=new Datos();
    
    public PilaPromedio()
    {
        do
            ind=obd.Entero("Tamaño de la pila");
        while(ind<1);
        pila=new String[ind];
        ind=-1;
    }
    private boolean Vacio()
    {
        return ind==-1;
    }
    private boolean Llena()
    {
        return ind==pila.length-1;
    }
    public void Insertar()
    {
        String cad1="7891N",cad2="0123456789A";
        if(! this.Llena())
        {
            do
            {
                cal=obd.Cadena("Escribe la calificacion").toUpperCase() ;
                if(cal.length()==3 && cal.equals("100"))
                    cal+="0";                    
            }
            while(cal.length()<2 || cal.length()>3 || cad1.indexOf(cal.charAt(0))==-1 || cad2.indexOf(cal.charAt(1))==-1);
            pila[++ind]=obd.Cadena("Escribe la calificacion");
        }
        else
            System.out.println("Pila llena...");
    }
     public void Extraer()
     {
         if(!this.Vacio())
             System.out.println("Calificacion extraida"+pila[ind--]+"");
         else
            System.out.println("Pila vacia.....\n");
         
     }
     public void Recorrido()
     {
         if(!this.Vacio())
         {
             System.out.println("Calificacion de la pila:");
             for(pos=ind;pos>=0;pos--)
                 System.out.println(pila[pos]);
         }
         else
             System.out.println("Pila vacia...\n");
     }
     public void Buscar()
     {
         if(!this.Vacio())
         {
             cal=obd.Cadena("Calificacion a buscar?");
             for(pos=ind;pos>=0;pos--)
                 if(pila[pos].equals(cal))
                 {
                     System.out.println("Calificacion encontrada en la posicion"+(pos+1)+"\n");
                     break;
                 }
             if(pos==-1)
                 System.out.println("La calificacion no existe en la pila .\n");
         }
         else
             System.out.println("Pila vacia...\n");
     }
   /*  public void Modificar()
     {
         String cad1="7891N",cad2="0123456789A";
         if(!this.Vacio())
         {
             cal=obd.Cadena("Calificacion a Modificar ?");
             for(pos=ind;pos>=0;pos--)
                 if(pila[pos].equals(cal))
                 {
                     do
                     {
                         cal=obd.Cadena("Escribe la nueva  calificacion").toUpperCase() ;
                         if(cal.length()==3 && cal.equals("100"))
                             cal+="0";                    
                     }
                     while(cal.length()<2 || cal.length()>3 || cad1.indexOf(cal.charAt(0))==-1 || cad2.indexOf(cal.charAt(1))==-1);
                     pila[++ind]=obd.Cadena("Escribe la calificacion");
                 }
             if(pos==-1)
                 System.out.println("La calificacion no existe en la pila .\n");
         }
         else
             System.out.println("Pila vacia...\n");
     }*/
     
     public void Borrar()
     {
         String aux[]=new String[pila.length];
         int con=0;
         if(!this.Vacio())
         {
             cal=obd.Cadena("Calificacion a buscar para eliminar?");
             for(pos=ind; pos>=0;pos--)
                 if(pila[pos].equals(cal))
                 {
                     System.out.println("Calificacion borrrada" + pila[pos]);
                     
                     break;
                 }
                 else
                 {
                     aux[++con]=pila[pos];
                 }
             if(pos==-1)
                 System.out.println("La calificaion no existe en la pila.\n");
             else
             {
                 for(;con>=0;con--,pos++)
                     pila[pos]=aux[con];
                 ind--;
             }
                     
         }
         else
             System.out.println("Pila vacia...\n");
     }
     
     public void Borarr1()
     {
         pila=new String[pila.length];
         ind=-1;
     }
     
}
