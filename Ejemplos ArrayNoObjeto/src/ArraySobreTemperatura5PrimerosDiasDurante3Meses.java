/* Marian Gallarado Casaus
   26/10/2021
   vamos a crear un programa que guarde la temperatura de los 5 primeros dias del mes de durante 3 meses
   y muestre la media de cada mes*/
public class ArraySobreTemperatura5PrimerosDiasDurante3Meses 
{
	public static void main (String args[])
	{
		double temperatura[][]= new double[3][5];
		double media, suma;
		for (int mes = 0; mes <=2; mes++)
		{
			for (int dia=0; dia<=4; dia++)
			{
				temperatura[mes][dia]=Math.random()*25;
				System.out.print(temperatura[mes][dia]+" ");
			}
			System.out.println(" ");
		}
		for (int mes = 0; mes <=2; mes++)
		{
			suma=0;
			for (int dia=0; dia<=4; dia++)
			{
				suma=suma+temperatura[mes][dia];
			}
			media= suma / 5;
			System.out.println("La temperatura media de este mes fue: "+media);
		}
	}
}