/*
 * Por grupo b
 * Escribe un programa que muestre los n primeros términos de la serie de Fibonacci. El primer
   término de la serie de Fibonacci es 0, el segundo es 1 y el resto se calcula sumando los dos
   anteriores, por lo que tendríamos que los términos son 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144… El
   número n se debe introducir por teclado.
 * V1.0
 * 28/10/2021
 */
import java.util.*;
public class Practica91Ejer12 {
    public static void main(String[] args) {
    	Scanner ent=new Scanner (System.in);
        int numero_largo;
        int num1=0;
        int num2=1;
        int suma=1;
        System.out.println ("Introduce cuanta serie de numeros quieres ver del numero Fibonacci");
        numero_largo=ent.nextInt();
        for (int i=1;i<numero_largo;i++) {
            // muestro la suma
            System.out.print(num1+","+suma);
            //primero sumamos
            suma=num1+num2;
            //Despues, cambiamos la segunda variable por la primera
            num1=num2;
            //Por ultimo, cambiamos la suma por la segunda variable
            num2=suma;
             
             
        }
    }
 
}
