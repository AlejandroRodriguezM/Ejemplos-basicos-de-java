package matematicas;
import java.util.*;


public class siguientePrimo extends esPrimo {
	
	static int siguientePrimo(int numero) 
	{
		while (!esPrimo(++numero)) {};
		return numero;
	}
	
	
}
