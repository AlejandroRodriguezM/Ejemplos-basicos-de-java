
public class Esmayor {
	public static int Esmayor (int vector[])
	{
		int mayor,n1;
		mayor=vector[0];
		for (int i=0;i<10;i++)
		{
			if (vector[i]>mayor)
			{
				mayor=vector[i];
			}
		}
		return mayor;
	}
	
	public static int posicion (int vector[])
	{
		int mayor,n1,posicion=0;
		mayor=vector[0];
		for (int i=0;i<10;i++)
		{
			if (vector[i]>mayor)
			{
				mayor=vector[i];
			}
			
			if (mayor==vector[i])
			{
				posicion=i;
			}
		}
		return posicion;
	}
	
	public static void main(String [] args)
	{
		int numero[]=new int[10];
		
		for (int i=0;i<10;i++)
		{
			numero[i]=(int)(Math.random()*10+1);
			System.out.print(numero[i]+" ");
		}
		System.out.println();
		System.out.print("El numero mayor es: "+Esmayor(numero)+"\nY su posicion es: "+posicion(numero));
		
	}
}
