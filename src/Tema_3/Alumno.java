 package Tema_3;

import lib20.Datos;
import lib20.Menu;

public class Alumno
{
    private String control,nombre;
    private int promedio;
    private Datos obd=new Datos();
    public Alumno()
    {
        System.out.println("Escribe los datos del alumno:");
        do
            control=obd.Cadena("No.de control").toUpperCase();
        while(control.isBlank());
        do
            nombre=obd.Cadena("Nombre").toUpperCase();
        while(nombre.isEmpty());
        do
            promedio=obd.Entero("Promedio");
        while(promedio<0 || promedio>100);      
    }
    public void Mostrar()
    {
        System.out.println(control +"\t"+nombre +"\t"+promedio);      
    }
    public String Control()
    {
        return control;
    }
    public void Modificar()
    {
        int op;
        Menu obm=new Menu("Modificar",new String[] {"Nombre","Promedio"});
        do
            switch(op=obm.Opcion())
            {
            case 1:
                do
                    nombre=obd.Cadena("Nuevo nombre".toUpperCase());
                while(nombre.isBlank());
                break;
            case 2:
                do
                    promedio= obd.Entero("Nuevo promedio");
                while(promedio<0|| promedio>100);
            }
        while(op !=obm.Salir());
    }
    
}
