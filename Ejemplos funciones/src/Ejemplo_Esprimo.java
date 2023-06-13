import java.util.Scanner;

public class Ejemplo_Esprimo {
	public static boolean esprimo(int valor)
	{
		boolean esprimo=false;
		
		//Si el valor es true, cambia el valor del booleano
		for (int i=2;i<valor;i++)
		{
			if (valor%i==0)
			{
				esprimo=true;
			}
		}
		return esprimo;
	}
	
	public static void main(String [] args)
	{
		Scanner ent=new Scanner(System.in);
		int i,contador_primo=0,contador_noprimo=0;
		int numero[]=new int[10];
		int primo[]=new int[10];
		int noprimo[]=new int[10];
		
		//Se introducen los numeros aleatorios
		for (i=0;i<numero.length;i++)
		{
			System.out.print("Dime un numero. Numero "+(i+1)+" de 10: ");
			numero[i]=ent.nextInt();
		}
		
		for (i=0;i<10;i++)
		{
			if (numero[i]%2==0 ||numero[i]==0)
			{
				System.out.printf("%4d|",numero[i]);
			}
			else
			{
				System.out.printf("%4d|",numero[i]);
			}
			
		}
		System.out.println();
		
		//Se calculan las posiciones dentro del array de los numeros primos y no primos
		for (i=0;i<numero.length;i++)
		{
			if (esprimo(numero[i])==true||numero[i]==0)
			{
				primo[contador_primo++]=numero[i];
			}
			else
			{
				noprimo[contador_noprimo++]=numero[i];
				
			}
		}
		
		//Se hace una copia del array
		for (i=0;i<contador_primo;i++)
		{
			numero[i]=primo[i];
		}
		contador_noprimo=0;
		
		//Se calcula la posicion de los numeros no primos
		for (i=contador_primo;i<10;i++)
		{
			numero[i]=noprimo[contador_noprimo];
			contador_noprimo++;
		}
		
		System.out.println();
		
		//Se separan los numeros primos y no primos.
		for (i=0;i<10;i++)
		{
			if (esprimo(numero[i])==true ||numero[i]==0)
			{
				System.out.printf("%4d|",numero[i]);
			}
			else
			{
				System.out.printf("%4d|",numero[i]);
			}
		}
	}
}
