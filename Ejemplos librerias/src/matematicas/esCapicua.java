package matematicas;
public class esCapicua {

	public static boolean numeroCapicua(int numero) 
	{	
		int numero_original = numero;
		int numeroInvertido = 0;
		int resto = 0;
		boolean resultado = false;
		
		while(numero_original!=0)
		{
			resto = numero_original%10;
			numeroInvertido=numeroInvertido*10+resto;
            numero_original = numero_original/10;
            }

		if(numeroInvertido == numero)
	    {
	    	resultado = true;
		}
	    return resultado;
	}
	
	public static boolean numeroCapicua(long numero) 
	{	
		boolean resultado;
		resultado = numeroCapicua((int)numero);
		
	    return resultado;
	}
}

