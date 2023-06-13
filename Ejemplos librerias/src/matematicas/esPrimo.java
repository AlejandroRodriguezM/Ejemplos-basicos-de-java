package matematicas;
import java.util.*;
public class esPrimo {
	
	public static Scanner ent = new Scanner(System.in);
	
	public static  boolean esPrimo(int numero)
	{
		boolean resultado = false;
		
		if (numero < 2)
		{
			resultado = false;
		}
		else
		{
			for (int i = 2 ; i < numero; i++)
			{
				if (numero%i == 0)
				{
					resultado = true;
				}
			}
		}
		return resultado;
	}
	
	public boolean esPrimo(long numero)
	{
		boolean resultado;
		resultado = esPrimo((int)numero);
		
		return resultado;
	}
}
