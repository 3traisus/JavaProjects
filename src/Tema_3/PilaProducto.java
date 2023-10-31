package Tema_3;

import lib20.Datos;

public class PilaProducto
{
    private int ind, clve, pos;
    private ProductoOp pila[];
    private Datos obd = new Datos();

    public PilaProducto()
    {
        do
            ind = obd.Entero("Tamaño de la pila de producto");
        while (ind < 1);
        pila = new ProductoOp[ind];
        ind = -1;
        System.out.println();
    }

    private boolean Vaciar()
    {
        return ind == -1;
    }

    private boolean Llenar()
    {
        return ind == pila.length - 1;
    }

    public void Insertar()
    {
        if (!this.Llenar())
        {
            clve = (this.Vaciar()) ? 1 : pila[ind].Clave() + 1;
            pila[++ind] = new ProductoOp(clve);

        } else
            System.out.println("Pila llena.\n");
        System.out.println();
    }

    public void Extrar()
    {
        if (!this.Vaciar())
        {
            System.out.println("Producto extraido :");
            pila[ind--].Mostrar();

        } else
            System.out.println("Pila vacía");
        System.out.println();
    }

    public void Recorrido()
    {
        if (!this.Vaciar())
        {
            System.out.println("Producto de la pila");
            for (pos = ind; pos >= 0; pos--)
                pila[pos].Mostrar();

        } else
            System.out.println("Pila vacía");
        System.out.println();
    }

    public void Buscar()
    {
        if (!this.Vaciar())
        {
            do
                clve = obd.Entero("Clave del producto que Modificar?");
            while (clve < 1);
            for (pos = ind; pos >= 0; pos--)
                if (pila[pos].Clave() == clve)
                {
                    System.out.println("Producto escontrado");
                    pila[pos].Mostrar();
                    pila[pos].Modificar();
                    ;
                    break;
                }
            if (pos == -1)
                System.out.println("La clave no esta registrada.");

        } else
            System.out.println("Pila vacía");
        System.out.println();
    }

    public void Modificar()
    {
        if (!this.Vaciar())
        {
            do
                clve = obd.Entero("Clave del producto que buscar?");
            while (clve < 1);
            for (pos = ind; pos >= 0; pos--)
                if (pila[pos].Clave() == clve)
                {
                    System.out.println("Producto escontrado");
                    pila[pos].Mostrar();
                    break;
                }
            if (pos == -1)
                System.out.println("La clave no esta registrada.");

        } else
            System.out.println("Pila vacía");
        System.out.println();

    }

    public void Borra()
    {
        pila = new ProductoOp[pila.length];
        ind = -1;
        System.out.println("Pila borrada.\n");

    }
}
