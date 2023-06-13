package prueba;
//import matematicas.voltea;
import java.util.*;
public class prueba_voltea {
	
	public static void main(String[] args) 
	{
		Scanner ent = new Scanner(System.in);
		int numero1;
		
		System.out.println("Dime un numero al que darle la vuelta: ");
		numero1 = ent.nextInt();
		
		System.out.println(matematicas.voltea.voltea(numero1));
		ent.close();
		
	}

}
