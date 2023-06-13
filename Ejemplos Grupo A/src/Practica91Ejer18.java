/*
 * Por grupo b
 * Escribe un programa que obtenga los números enteros comprendidos entre dos números
   introducidos por teclado y validados como distintos, el programa debe empezar por el menor de los
   enteros introducidos e ir incrementando de 7 en 7.
 * V1.0
 * 28/10/2021
 */
import java.util.*;
public class Practica91Ejer18 {
	public static void main(String[] args)
	{
		Scanner ent=new Scanner(System.in);
	    int numero_menor;
	    int numero_mayor;
	    int suma_siete=7;
	    System.out.println("Introduce el numero menor: ");
	    numero_menor=ent.nextInt();	
	    System.out.println("Introduce el numero mayor: ");
	    numero_mayor=ent.nextInt();
	    //Comprende el rango entre el numero menor y el numero mayor
	    for(int i=numero_menor;i<=numero_mayor;i++)
	    {	
		   numero_menor=numero_menor+suma_siete;
		   //Suma al numero menor "+7" hasta que sea menor o igual al numero mayor
		   if (numero_menor<=numero_mayor)
		       {
			     System.out.println(numero_menor);
		       }
	    }
	 }
}
