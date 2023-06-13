/*
 * Por grupo b
 * Muestra los números del 320 al 160, contando de 20 en 20 hacia atrás utilizando un bucle while
 * V1.0
 * 28/10/2021
 */
public class practica90ejer5 {
	public static void main(String[] args)
	{
	int numero=340;
	//Mientras el numero sea menor o igual a 340 y mayor o igual a 180, se realizara el bucle
	while (numero<=340 && numero>=180)
	{
		numero=numero-20;
		System.out.println ("Los numeros entre 320 y 160 son: "+numero);
	}
	
	}

}
