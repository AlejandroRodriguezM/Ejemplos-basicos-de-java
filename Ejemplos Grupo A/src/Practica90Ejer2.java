/*
 * Por grupo b
 * Muestra los números múltiplos de 5 de 0 a 100 utilizando un bucle while.
 * V1.0
 * 28/10/2021
 */
public class Practica90Ejer2 {
	public static void main (String [] args)
	{
		int numero_multiplo=0;
		//Mientras el numero multiplo sea menor o igual a 100 seguira
		while (numero_multiplo<=100)
		{
			//Si el resto da 0, permitira seguir
			if ((numero_multiplo%5)==0) 
			{
		System.out.println ("Los multiplos de 5 son: "+numero_multiplo);
		}
			numero_multiplo++;
	}
	}
}
