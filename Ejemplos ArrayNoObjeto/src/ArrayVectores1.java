public class ArrayVectores1 {
	public static void main(String [] args)
	{
		double temperatura[] = new double[31];
		double suma = 0;
		double media;

		for (int i=0;i<temperatura.length;i++) 
		{
		   temperatura[i]=Math.random()*31+1;
		   suma+=temperatura[i];
		   System.out.println (temperatura[i]);
		}
		
		media=suma/temperatura.length;
		System.out.println("La nota media es: " + media);
	 }
}