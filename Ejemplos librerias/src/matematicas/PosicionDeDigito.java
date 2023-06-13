package matematicas;

public class PosicionDeDigito extends digitos {
	
	public static int posicionDeDigito(int numero1, int numero2) 
	 {
		 int resultado = 0;
		 for (int i = 0; (i < digitos(numero1)) && (digitoN(numero1, i) != numero2); i++)
		 {
			 if (i == digitos(numero1)) 
			 {
				 resultado = -1;
			 } 
			 else 
			 {
				 resultado = i;
			 }
		 }
		 return resultado;
	 }
	 
	 public static int posicionDeDigito(long numero1, int numero2)
	 {
		 int resultado;
		 resultado = posicionDeDigito((int)numero1, numero2);
		 
		 return resultado;
	 }
}
