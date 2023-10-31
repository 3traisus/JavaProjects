package Tema_3;

import java.util.Vector;

import lib20.Datos;


public class PilaDinámicaAlumno
{
    private Vector<Alumno> pila = new Vector<Alumno>(5, 2);
    private Vector<Alumno> aux = null;
    private Datos obd = new Datos();
    private Alumno oba = null;
    private String control;
    private boolean ban;

    public void Insertar()
    {
        pila.add(new Alumno());
        System.out.println("Alumno insertado en la pila. \n");
    }

    public void Extraer()
    {
        if (!pila.isEmpty())
        {
            System.out.println("Alumno extraido:");
            pila.remove(pila.size() - 1).Mostrar();
        } else
            System.out.println("Pila vacía");
        System.out.println();

    }

    public void Recorrido()
    {
        if (!pila.isEmpty())
        {
            aux = new Vector<Alumno>(pila.size());
            System.out.println("Lista de alumnos:");
            while (!pila.isEmpty())
            {
                oba = pila.remove(pila.size()-1);
                oba.Mostrar();
                aux.add(oba);
            }
            while (!aux.isEmpty())
                pila.add(aux.remove(aux.size() - 1));
        } else
            System.out.println("Pila vacía");
        System.out.println();

    }

    public void Buscar()
    {
        ban = true;
        if (!pila.isEmpty())
        {
            do
                control = obd.Cadena("No. de control del alumno que buscar?").toUpperCase();
            while (control.isBlank());
            aux = new Vector<Alumno>(pila.size());
            do
            {
                oba = pila.remove(pila.size() - 1);
                if (oba.Control().equals(control))
                {
                    System.out.println("Alumno encontrar:");
                    oba.Mostrar();
                    ban = false;
                }
                aux.add(oba);
            }

            while (pila.isEmpty() && !oba.Control().equals(control));
            while (!aux.isEmpty())
                pila.add(aux.remove(aux.size() - 1));
            if (ban)
                System.out.println("El alumno no existe en la pila");
        } else
            System.out.println("Pila vacía");
        System.out.println();
    }

    public void Modificar()
    {
        ban = true;
        if (!pila.isEmpty())
        {
            do
                control = obd.Cadena("No. de control del alumno que buscar?").toUpperCase();
            while (control.isBlank());
            aux = new Vector<Alumno>(pila.size());
            do
            {
                oba = pila.remove(pila.size() - 1);
                if (oba.Control().equals(control))
                {
                    System.out.println("Alumno encontrar:");
                    oba.Mostrar();
                    oba.Modificar();
                    System.out.println("Alumno modificar");
                    oba.Modificar();
                }
                aux.add(oba);
            }

            while (pila.isEmpty() && !oba.Control().equals(control));
            while (!aux.isEmpty())
                pila.add(aux.remove(aux.size() - 1));
            if (ban)
                System.out.println("El alumno no existe en la pila.");
        } else
            System.out.println("Pila vacía");
        System.out.println();

    }

    public void Borra()
    {
        if (!pila.isEmpty())
        {
            while (!pila.isEmpty())
                pila.remove(pila.size() - 1);
            System.out.println("Pila borrada. \n");
        } else
            System.out.println("Pila vacía");
        System.out.println();

    }
}
