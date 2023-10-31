package Odyseo;
import java.util.ArrayDeque;
import lib20.Datos;

public class Abelardo
{
Datos obd = new Datos();
private ArrayDeque<Character> pila = new ArrayDeque<Character>();



private String cad, ent, valores[] = { "1z", "2z", "3z", "12", "13", "21", "23", "31", "32", "?1", "?2", "?3", "$1","$2", "$3", "$z", "11", "22", "33" }; // TODAS LAS POSIBLES COMBINACIONES
private byte i, pos = 0, est, hacer, matriz_transacicion[][][] = {
{ { 0, 1 }, { 0,1 }, { 0, 1 }, { 0, 1 }, { 0, 1 }, { 0, 1 }, { 0, 1 }, { 0, 1 }, { 0, 1 },
{ 1, 3 },{ 1, 3 }, { 1, 3 }, { -1, 3 }, { -1, 3 }, { -1, 3 }, { -1, 3 }, { 0, 1 }, { 0, 1 }, { 0, 1 } }, // RENGLON 0 (ESTADO)

{ { -1, 3 }, { -1, 3 }, { -1, 3 }, {-1, 3 }, { -1, 3 }, {-1, 3 }, { -1, 3 }, { -1, 3 }, { -1, 3 },
{ -1, 3 },{ -1, 3 }, { -1, 3 }, { -1, 3 }, { -1, 3 }, { -1, 3 }, { 3, 3 }, { 2, 3 }, { 2, 3 }, { 2, 3 } }, // RENGLON 1 (ESTADO)

{ { -1, 3 }, { -1, 3 }, { -1, 3 }, { -1, 3 }, { -1, 3 }, { -1, 3 }, { -1, 3 }, { -1, 3 }, { -1, 3 }, // RENGLON 2 (ESTADO)
{ -1, 3 }, { -1, 3 }, { -1, 3 }, { -1, 3 }, { -1, 3 }, { -1, 3 }, { -1, 3 }, { 1, 2 }, { 1, 2 },
{ 1, 2 } } }; // matriz de transacicion


private void lectura() {
byte estados[][] = { { 0, 0, 0, 1 }, { 1, 1, 1, -1 } };
String carcteres_lenguaje = "123?"; // caracteres que acepta mi lenguaje
do {
est = 0;
cad = obd.Cadena("Ingresa la cadena a validar");
for (i = 0; i < cad.length(); i++) {

pos = (byte) carcteres_lenguaje.indexOf(cad.charAt(i)); // revisa que el caracter exista en los validos
// para el lenguaje
if (est != -1 && pos != -1) // verifica que sea un estado valido
est = estados[est][pos];
else {
est = -1;
break;
}
}
if (est != 1)
System.out.println("La cadena contiene caracteres no validos...");
} while (est != 1);
cad += "$";
pila.clear();
pila.push('z');
System.out.println();
System.out.println("La cadena procesada es : " + cad);
}



private void validar() {
ent = "";
est = 0;
for (i = 0; i < cad.length(); i++) {
ent = cad.charAt(i) + "" + pila.getFirst();
for (pos = 0; pos < valores.length; pos++)
if (valores[pos].equals(ent))
break;
if (est != -1 && pos < valores.length) {
hacer = matriz_transacicion[est][pos][1];
est = matriz_transacicion[est][pos][0];
if (hacer == 1) // mete a la pila el elemento
pila.push(cad.charAt(i));
else if (hacer == 2)// saca de la cola el elemento
pila.pop();
} else
break;
}
if (est == 3)
{
System.out.println();
System.out.println("ESTA CADENA SE ACEPTA");
}
else
{
System.out.println();
System.out.println("ESTA CADENA NO SE ACEPTA");
}

}



public static void main(String[] args) {
Abelardo obi = new Abelardo();
System.out.println();
System.err.println("LENGUAJE DOBLE INVERSA !!");
System.out.println();
while (true) {
obi.lectura();
obi.validar();
System.out.println();



}
}
}