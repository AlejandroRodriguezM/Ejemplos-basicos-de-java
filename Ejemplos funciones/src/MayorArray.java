public class MayorArray {
	
	public static int mayor(int vector[])
	{
		int num1,num2,mayor;
		mayor=vector[0];
		for (int i=0;i<10;i++)
		{
			num1=vector[i];
			num2=mayor;
			if (num1>num2)
			{
				mayor=num1;
			}
		}
		return mayor;
	}
	
	public static void main(String [] args) 
	{
		
		int numero[]=new int[10];
		
		for (int i=0;i<10;i++)
		{
			numero[i]=(int)(Math.random()*9);
		}
		
		for (int i=0;i<10;i++)
		{
			System.out.print(numero[i]+" ");		
		}
		
		System.out.println();		
		System.out.println("El numero mayor es: "+mayor(numero));		
	}
}