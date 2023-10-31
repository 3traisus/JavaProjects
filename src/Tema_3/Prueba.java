package Tema_3;

public class Prueba
{
	public static void main(String[] args)
	{
		NodoSimple maria,jose, daniel, lorena,inicio;
		maria = new NodoSimple("Maria");
		jose = new NodoSimple("Jose");
		daniel = new NodoSimple("Daniel");
		lorena = new NodoSimple("Lorena");
		
		lorena.setSiguiente(jose);
		jose.setSiguiente(maria);
		maria.setSiguiente(daniel);
		
		for(inicio=lorena; inicio!=null;inicio=inicio.getSiguiente())
			System.out.println(inicio.getNombre());
		
		
	}

}
