package matematicas;

import matematicas.voltea;

public class digitoN extends voltea{
	public static int digitoN(int numero1, int numero2) {
		
		int resultado;
	    numero1 = voltea(numero1);
	    do
	    {
	    	numero1 = numero1 / 10;
	    }
	    while (numero2-- > 0);
	    
	    resultado = (int)numero1 % 10;
	    return resultado;
	  }
	
	public static int digitoN(long numero1, int numero2) 
	{
		int resultado;
		resultado = digitoN((int)numero1,numero2);
		return resultado;
	}
}
