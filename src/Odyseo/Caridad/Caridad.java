package Odyseo.Caridad;

import java.util.ArrayDeque;
import java.util.Scanner;

import lib20.Datos;

public class Caridad
{
	Scanner obd = new Scanner(System.in);
	private Datos ob = new Datos();
    private ArrayDeque<Character> pila = new ArrayDeque<Character>();
    private String cad="";
    private String[] valores =    {"b$","c$", "bb", "cb", "cc", "ac", "aa", "da", "dd", "$d"};
    // b^n c^m a^m d^m+n donde n y m > 0
    private String[][] matriz = { {"10","20","!2", "!2", "!2", "!2", "!2", "!2", "!2", "!2"}, // b$ -- estado 0
                                  {"!2","!2", "10", "20", "!2", "!2", "!2", "!2", "!2", "!2"}, // bb viene c
                                  {"!2","!2", "!2", "!2", "20", "30", "!2", "!2", "!2", "!2"}, // cc viene a
                                  {"!2","!2", "!2", "!2", "!2", "!2", "30", "40", "!2", "!2"}, // aa viene d
                                  {"!2","!2", "!2", "!2", "!2", "!2", "!2", "!2", "40", "52"} }; // dd viene $
    private int x, n, k, k2, m, d;

    public void Lectura() {
        cad = ob.Cadena("Dame cadena");
        cad += "$";
    }

    public void Tabla() {
    	ob.Println(cad);
        if(cad.equals("$")){
            System.out.println("Cadena aceptada");
            return;
        }
        
        pila.clear();
        pila.push('$');
        n = 0; // b
        k = 0; // c
        k2 = 0; // a
        d = 0; // d
        int y, ind = 0; // se ocupa dejar del tipo entero para controlar la posicion de la matriz
        char accion = ' ';
        String form;
        
        for (x = 0; x < cad.length(); x++)
        {
            form = cad.charAt(x) + "" + pila.getFirst();
            for (y = 0; y < valores.length && !valores[y].contains(form); y++); // este ciclo termina cuando encuentra una similitud con las combinaciones o sea mayor valores.length
            if (y < valores.length) { // es para que no se salga del rango para evitar el try and catch
                accion = matriz[ind][y].charAt(1);
                if (matriz[ind][y].charAt(0) != '!')
                    ind = Integer.parseInt(matriz[ind][y].charAt(0) + "");
                else
                    break;
            }
            ob.Println(accion+"//////"+form+"//////"+ind);
            if (accion == '0')
            {
                pila.push(cad.charAt(x));
                if(cad.charAt(x) == 'b')
                    n++;
                else
                    if(cad.charAt(x) != 'b' && cad.charAt(x) != '$')
                    {
                        if(cad.charAt(x) == 'c')
                            k++;
                        if(cad.charAt(x) == 'a')
                            k2++;
                        if(cad.charAt(x) == 'd')
                            d++;
                    }
            }
            else
                if(accion == '1')
                    pila.pop();
        }
        if(k==k2)
        	m = (k + k2) / 2; // que m tenga el valor deseado de c y a
        else
        {
        	 System.out.println("No aceptada");
        	 return;
        }
        if(ind == 5 && d == (n + m))
            System.out.println("Cadena aceptada");
        else
            System.out.println("No aceptada");
    }
    
    public String Cadena(String msj) {
        String cad = "";
        System.out.println(msj + " ");
        if (obd.hasNextLine()) {
            cad = obd.nextLine().trim();
        } else {
            System.out.println("Error en el dispositivo de entrada");
        }
        return cad;
    }
	public static void main(String[] args)
	{
		Caridad obd = new Caridad();
		obd.Lectura();
		obd.Tabla();
	}

}
