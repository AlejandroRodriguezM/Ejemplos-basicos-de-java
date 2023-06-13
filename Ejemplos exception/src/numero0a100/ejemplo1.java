package numero0a100;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ejemplo1 {
	
	public static void main(String[] args) 
	{
		
		int numero = -1;int contador = 0;
		
		do
		{
			try
			{
				Scanner ent = new Scanner(System.in);
				System.out.println("Introduce un numero: ");
				numero = ent.nextInt();
				
				if (numero < 0 || numero > 100)
				{
					System.err.println("El numero "+numero+"\nDebe de estar comprendido entre 0 y 100");
				}
			}
			catch(ArithmeticException ex)
			{
				System.err.println("ERROR. Numero incorrecto");
			}
			catch(InputMismatchException ex)
			{
				System.err.println("ERROR. LEctura de datos");
			}
			finally
			{
				contador++;
			}
		}
		while(numero < 0 || numero > 100);
		
		System.out.println("Numero: " + numero + "\nNumero de intentos: " + contador);
//		ent.close();

		
	}

}
