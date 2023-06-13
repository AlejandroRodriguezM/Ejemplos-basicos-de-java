/*
 * Por grupo b
 * Muestra la tabla de multiplicar de un número introducido por teclado.
 * V1.0
 * 28/10/2021
 */
import java.util.*;
public class Practica90Ejer8 {
	public static void main(String[] args)
	{
		Scanner ent=new Scanner (System.in);
		int num_multiplicar;
		int tabla_multiplar;
		int resultado;
		{
			System.out.println ("introduce un numero que quieras ver su tabla: ");
			num_multiplicar=ent.nextInt();
			//Se realizara la tabla de multiplicar del 1 al 10
			for (tabla_multiplar=1; tabla_multiplar<=10; tabla_multiplar++)
			{
				resultado=num_multiplicar*tabla_multiplar;
				System.out.println (resultado);
			}	
		}
	}
}
