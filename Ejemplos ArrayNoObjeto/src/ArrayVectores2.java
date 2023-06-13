
public class ArrayVectores2 {
	public static void main(String [] args)
	{
		int dia_mas_calor;
		double temp_alta;
		double suma_temp=0;
		double temp_media;
		double temperatura[]=new double[31];
		int longitud=temperatura.length;

		for (int i=0;i<longitud;i++) 
		{
			
		   temperatura[i]=Math.random()*30;
		   suma_temp=suma_temp+temperatura[i];
		   System.out.println(i);
		}
		temp_alta=temperatura[0];
		dia_mas_calor=1;
		for (int j=1;j<longitud;j++)
		{
			if (temperatura[j]<temp_alta)
			{
				temp_alta=temperatura[j];
				dia_mas_calor=j+1;
			}
		}
		temp_media=(suma_temp/longitud);
		System.out.println("La temperatura media de octubre es: "+temp_media);
		System.out.println("La temperatura maxima es: "+temp_alta+" del dia "+dia_mas_calor);
	 }
}