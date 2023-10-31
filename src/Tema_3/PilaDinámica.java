package Tema_3;

import java.util.Vector;

import lib20.Datos;


public class PilaDinámica
{
    private String nombre;
    private int pos;
    private Datos obd = new Datos();
    private Vector<String> pila = new Vector<String>(5, 3);

    public void Insertar()
    {
        do
            pila.add(obd.Cadena("Nombre").toUpperCase());
        while (pila.get(pila.size() - 1).isBlank());
        System.out.println("Nombre insertado con éxito.\n");

    }

    public void Extraer()
    {
        if (!pila.isEmpty())
            System.out.println("Nombre extraido:\n" + pila.remove(pila.size() - 1));
        else
            System.out.println("Pila vacía");
        System.out.println();
    }

    public void Recorrido()
    {
        if (!pila.isEmpty())
        {
            System.out.println("Nombre de la pila:");
            for (pos = pila.size() - 1; pos >= 0; pos--)
                System.out.println((pos + 1) + ".-" + pila.get(pos));
        } else
            System.out.println("Pila vacía.");
        System.out.println();
    }

    public void Buscar()
    {
        boolean ban = true;
        if (!pila.isEmpty())
        {
            do
                nombre = obd.Cadena("Nombre o apellido a buscar").toUpperCase();
            while (nombre.isBlank());
            for (pos = pila.size() - 1; pos >= 0; pos--)
                if (pila.get(pos).indexOf(nombre) != -1)
                {
                    if (ban)
                        System.out.println("Nombre encontrados:");
                    System.out.println(pila.get(pos));
                    ban = false;
                }
            if (ban)
                System.out.println("El nombre o apellido no exixste en la pila");
        } else
            System.out.println("Pila vacía");
        System.out.println();
    }

    public void Modificar()
    {
        if (!pila.isEmpty())
        {
            do
                pos = obd.Entero("Cual es la pisición del nombre a modificar");
            while (pos < 1 || pos > pila.size());
            pos--;
            System.out.println("Nombre:" + pila.get(pos));
            do
                pila.set(pos, obd.Cadena("Nuevo nombre").toUpperCase());
            while (pila.get(pos).isBlank());
            System.out.println("Modidicación realizada.");
        } else
            System.out.println("Pila vacía");
        System.out.println();
    }

    public void Borra()
    {
        pila = new Vector<String>(5, 3);
        System.out.println("Pila borrarda. \n");
    }
    
    public void prueba()
    {
    	pila.contains(getClass().)
    }
}
