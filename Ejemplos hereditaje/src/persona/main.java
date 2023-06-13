package persona;
import java.util.ArrayList;

public class main {
	
	public static void main(String[] args) 
	{
		
		Persona p = new Persona("Pepe","25606812S","C/Java","657435722");
		
		p.mostrarPersona();
		
		System.out.println("**********************************************************************");
		
		Alumno a = new Alumno("Alejandro","1234567S","C/Java 2","657435788","123456789","1","DAW","7,5");
		
		a.mostrarPersona();
		
		System.out.println("**********************************************************************");
		
		ArrayList modulos = new ArrayList();
		
		modulos.add("Programacion");
		modulos.add("Base de datos");
		modulos.add("Sistemas informaticos");
		
		Profesor profesor1 = new Profesor("Juan","1234567S","C/Java 3","123456789","8","Informatica",modulos,"Tarde");
		
		profesor1.mostrarPersona();
		
		System.out.println("**********************************************************************");
		
	}

}
