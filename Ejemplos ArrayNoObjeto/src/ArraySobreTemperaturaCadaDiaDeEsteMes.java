/* Marian Gallarado Casaus
   21/10/2021
   vamos a crear un programa para mostar la temperatura de cada dia del mes de octubre
   y mostrar el dia con la temperatura mas alta*/
public class ArraySobreTemperaturaCadaDiaDeEsteMes 
{
	public static void main (String args[])
	{
		double temperatura[]= new double[31];
		double suma=0, tempMax=0;
		int diaMax=0,tamanyo=temperatura.length;
		for (int i = 0; i <tamanyo; i++)
		{
			temperatura[i]=Math.random()*25;
			suma=suma+temperatura[1];
			if (temperatura[i]> tempMax)
			{
				tempMax=temperatura[i];
				diaMax=i+1;
			}
		}
		System.out.println("La temperatura más alta de Ocutubre fue: "+tempMax+" fue el día: "+diaMax);
	}
}