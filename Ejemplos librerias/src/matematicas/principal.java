package matematicas;
import java.util.*;
import matematicas.digitoN;


public class principal {
	
	public static void main(String[] args) 
	{
		Scanner ent = new Scanner(System.in);
		int numero1;
		
		System.out.println("Dime un numero para dar la vuelta: ");
		numero1 = ent.nextInt();
		
		System.out.println(matematicas.voltea.voltea(numero1));
		
	}

}
