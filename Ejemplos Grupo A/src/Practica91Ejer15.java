/*
 * Por grupo b
 * Escribe un programa que dados dos números, uno real (base) y un entero positivo (exponente),
   saque por pantalla todas las potencias con base el numero dado y exponentes entre uno y el
   exponente introducido. No se deben utilizar funciones de exponenciación. Por ejemplo, si
   introducimos el 2 y el 5, se deberán mostrar 21, 22, 23, 24 y 25.
 * V1.0
 * 28/10/2021
 */
import java.util.*;
public class Practica91Ejer15 {
	public static void main (String [] args)
	{
		Scanner ent=new Scanner (System.in);
		int numero_base;
		int num_exponente;
		int num_contados;
		int contador;
		System.out.println ("Dime un numero, que sera la base: ");
		numero_base=ent.nextInt();
		System.out.println ("Dime un numero, que sera el exponente: ");
		num_exponente=ent.nextInt();
		//mientras el contador sea igual a 1 y menor o igual al numero del expontente introducido permitira continuar
		for (contador=1;contador<=num_exponente;contador++)
		{
			
			System.out.print(numero_base+"^"+contador+ ", ");
			
		}
		
	}

}
