public class ArraysVectores3 {
	public static void main (String [] args)
	{
		int media=0;
		int suma=0;
		int mes=0;
		int dia=0;
		double temperatura[][]=new double[3][5];
		for (mes=0;mes<temperatura.length;mes++)
		{
		    for (dia=0;dia<temperatura[mes].length;dia++)
		    {
				temperatura[mes][dia]=Math.round(Math.random()*30);
			    System.out.print ((int)temperatura[mes][dia]+"         ");
		}
		    System.out.println (" ");
	}
		for (mes=0;mes<=2;mes++)
		{
			for (dia=0;dia<=4;dia++)
			{
				suma=suma+(int)temperatura[mes][dia];
			}
			media=suma/5;	
			System.out.println (media +" para el mes"+ mes);
		}
}
}