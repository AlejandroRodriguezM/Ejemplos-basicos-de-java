package persona;
import java.util.ArrayList;

public class Principal {
	
	public static void main(String[] args) 
	{
		
		Alumno a = new Alumno("Alejandro","1234567S","C/Java 2","657435788","123456789","1","DAW","7,5");
	
		Profesor profesor1 = new Profesor("Juan","1234567S","C/Java 3","123456789","8","Informatica","Tarde");
		
		System.out.println(a.saludar());
		
		System.out.println(profesor1.saludar());
		
	}

}
