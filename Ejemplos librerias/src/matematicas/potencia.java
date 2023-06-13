package matematicas;
public class potencia {
	
	public static int potencia(int base,int potencia)
	{
		int resultado;
		
		resultado = base * potencia;
		
		return resultado;
	}
	
	public static int potencia(long base,long potencia)
	{
		int resultado;
		resultado = potencia((int)base,(int)potencia);
		return resultado;
	}
	
	public static double potencia(double base,double potencia)
	{
		double resultado;
		
		resultado = base * potencia;
		
		return resultado;
	}
	
	public static double potencia(float base,float potencia)
	{
		double resultado;
		resultado = potencia((double)base,(double)potencia);
		return resultado;
	}
	
	
}
