import java.util.*;
public class varias_operaciones {
	
	public static double operacion(double valor1,double valor2,char operador)
	{
		double resultado=0;
		
		if (operador=='+')
		{
			resultado=valor1+valor2;
		}
		else
		{
			if (operador=='-')
			{
				resultado=valor1-valor2;
			}
			else 
			{
				if (operador=='*')
				{
					resultado=valor1*valor2;
				}
				else 
				{
					if (operador=='/' && valor1!=0 &&valor2!=0)
					{
						resultado=valor1/valor2;
					}
					else 
					{
						if (operador=='%' && valor1!=0 &&valor2!=0)
						{
							resultado=valor1%valor2;
						}
						else
						{
							resultado=0;
						}
					}
				}
			}
		}
		
		return resultado;
	}
	
	public static void main(String [] args)
	{
		Scanner ent=new Scanner(System.in);
		double numero1,numero2;
		char operador;
		
		System.out.print("Escribe un numero: ");
		numero1=ent.nextDouble();
		
		System.out.print("Escribe otro numero: ");
		numero2=ent.nextDouble();
		System.out.println();
		
		//numero1=Math.random()*50+1;
		//numero2=Math.random()*50+1;
		
		System.out.print("Escribe que operador quieres: ");
		operador=ent.next().charAt(0);
		System.out.println();
		
		System.out.print("El resultado es: "+operacion(numero1,numero2,operador));
		
		ent.close();
	}
}