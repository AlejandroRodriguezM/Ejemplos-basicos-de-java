package matematicas;
public class voltea {
	
	public static int voltea(int numero) 
	{
		int resultado = 0;
	    if (numero < 0) 
	    {
	      resultado = -voltea(-numero);
	    } 
	    do
	    {
	    	resultado = (resultado * 10) + (numero % 10);
	   	    numero = numero / 10;
	    }
	    while(numero > 0);
	  
	    return resultado;
	}
	
	public static long voltea(long numero)
	{
		long resultado;
		resultado = (int)voltea((int)numero);
		return resultado;
	}
	
	
}
