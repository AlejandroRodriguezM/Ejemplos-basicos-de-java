package animal;

import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) 
	{
		int opcion;
		Animal animal;
		
		Scanner ent = new Scanner(System.in);
		
		System.out.println("Que opcion escoges: \n1) Perro. \n2) Gato. ");
		opcion = ent.nextInt();
		
		if (opcion == 1)
		{
			animal = new Perro();
			animal.ruido();
		}
		else if(opcion == 2)
		{
			animal = new Gato();
			animal.ruido();
		}
		else
		{
			animal = new Animal();
			System.out.println("Opcion incorrecta.");
			animal.ruido();
		}
		
	}

}
