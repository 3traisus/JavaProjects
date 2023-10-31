package Tema_3;

import lib20.Datos;
import lib20.Menu;

public class ProductoOp
{
    private Datos obd = new Datos();
    private Producto obp;

    public ProductoOp(int clave)
    {
        obp = new Producto();
        obp.setClave(clave);
        System.out.println("Escribe los datos del producto;");
        System.out.println("Clave " + clave);
        do
            obp.setNombre(obd.Cadena("Nombre").toUpperCase());
        while (obp.getNombre().isBlank());
        do
            obp.setPrecio(obd.Doble("Precio"));
        while (obp.getPrecio() < 1);

    }

    public void Mostrar()
    {
        System.out.println(obp.getClave() + "\t" + obp.getNombre() + "\t" + obp.getPrecio());
    }

    public void Modificar()
    {
        int op;
        Menu obm = new Menu("Modificar", new String[] { "nombre", "precio" });
        do
            switch (op = obm.Opcion())
            {
            case 1:
                do
                    obp.setNombre(obm.obd.Cadena("Nuevo nombre").toUpperCase());
                while (obp.getNombre().isBlank());
                break;
            case 2:
                obp.setPrecio(obm.obd.Doble("Nueva preci"));
                while (obp.getPrecio() < 1)
                    ;
            }
        while (op != obm.Salir());
    }

    public int Clave()
    {
        return obp.getClave();
    }

}
