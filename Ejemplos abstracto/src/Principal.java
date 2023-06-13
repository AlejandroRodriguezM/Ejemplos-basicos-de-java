
public class Principal {
	
	public static void main(String[] args) 
	{
//		Vehiculo vehiculo = new Vehiculo(); //No se puede instanciar porque las clases abstractas añaden el nivel de seguridad.
//		vehiculo.funciona(); //Nunca funcionara porque los metodos de clases abstractas no puede ser instanciadas.
//		coche.prueba(); //Las clases abstractas pueden tener metodos no abstractos, pero solamente se pueden instanciar desde una subclase
		
		Coche coche = new Coche();
		
		coche.funciona();
		
		coche.prueba();
		Vehiculo.prueba();
	
	
	
	
	
	
	
	
	
	
	
	
	}
	


}
