package humano;

public class main {
	
	//Ejercicio2
	
	public static void main(String [] args)
	{
		persona denice = new persona("Denice",40,1.75);
		
		persona alejandro = new persona("Alejandro",29,1.78);
		
		System.out.println(denice.nombre);
		
		System.out.println(denice.edad);
		
		System.out.println(denice.altura);
		
		System.out.println();
		
		System.out.println(alejandro.nombre);
		
		System.out.println(alejandro.edad);
		
		System.out.println(alejandro.altura);
	}

}
