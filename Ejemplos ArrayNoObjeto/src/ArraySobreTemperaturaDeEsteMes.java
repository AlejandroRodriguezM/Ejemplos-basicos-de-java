/* Marian Gallarado Casaus
   21/10/2021
   vamos a crear un programa para guardar la temperatura de cada dia del mes de octubre
   y calcular la media*/
public class ArraySobreTemperaturaDeEsteMes 
{
	public static void main (String args[])
	{
		double temperatura[]= new double[31];
		double media, suma=0;
		int tamanyo=temperatura.length;
		for (int i = 0; i <tamanyo; i++)
		{
			temperatura[i]=Math.random()*25;
			suma=suma+temperatura[1];
		}
		media= suma / temperatura.length;
		System.out.println("La temperatura media de Ocutubre fue: "+media);
	}
}