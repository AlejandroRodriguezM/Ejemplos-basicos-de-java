package matematicas;

public class digitos extends digitoN {
	
	public static int digitos(int numero)
	{
		int resultado = 0;
		
		if (numero < 10 && numero > -10)
		{
			resultado = 1;
		}
		else
		{
			do
			{
				numero = numero/10;
				resultado++;
			}
			while (numero > 0 || numero < 0);
		}
		return resultado;
	}
	
	public static int digitos(long numero)
	{
		int resultado;
		resultado = digitos((int)numero);
		return resultado;
	}
	
	 
}


