public class mayorarray2 {
	
	public static int esmayor(int vector[])
	{
		int i,valor1,maximo;
		
		maximo=vector[0];
		for (i=0;i<10;i++)
		{
			valor1=vector[i];
			
			if (maximo<valor1)
			{
				maximo=valor1;
			}
		}
		return maximo;
	}
	
	public static int posicion(int vector[])
	{
		int i,valor1,maximo,posicion=0;
		
		maximo=vector[0];
		for (i=0;i<10;i++)
		{
			valor1=vector[i];
			if (maximo<valor1)
			{
				maximo=valor1;
			}
			
			if (valor1==maximo)
			{
				posicion=i;
			}
		}
		return posicion;
	}
	
	public static void main(String [] args)
	{
		int numero[]=new int[10];
		int posicion;
		
		System.out.print("Posicion ");
		for (int i=0;i<10;i++)
		{
			System.out.printf("|%4d",i);
		}
		System.out.print("|");
		System.out.println();
		System.out.println("         |+++++++++++++++++++++++++++++++++++++++++++++++++|");
		System.out.print("Numeros  ");
		for (int i=0;i<10;i++)
		{
			numero[i]=(int)(Math.random()*10+1);
			System.out.printf("|%4d",numero[i]);
		}
		System.out.print("|");
		System.out.println();
		System.out.println();
		System.out.print("El numero mayor es: "+esmayor(numero)+"\nY se encuentra en la posicion: "+posicion(numero));
	}
}
