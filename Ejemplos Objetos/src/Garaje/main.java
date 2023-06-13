package Garaje;

public class main {
	
	//Ejercicio4
	
	public static void main(String[] args) 
	{
		garaje garaje = new garaje ();
		
		Coche coche1 = new Coche("BMW");
		Coche coche2 = new Coche("Ford");
		
		Bicicleta bici1 = new Bicicleta("Montaña");
		Bicicleta bici2 = new Bicicleta("Carretera");
		
		
		garaje.aparcamiento_coche(coche1);
		garaje.aparcamiento_coche(coche2);
		
		garaje.conducir_coche(coche1);
		garaje.conducir_coche(coche2);
		
		garaje.tunear_coche(coche1);
		garaje.tunear_coche(coche2);
		
		System.out.println();
		
		garaje.aparcamiento_bicicleta(bici1);
		garaje.aparcamiento_bicicleta(bici2);
		
		garaje.conducir_bicicleta(bici1);
		garaje.conducir_bicicleta(bici2);
		
		garaje.tunear_bicicleta(bici1);
		garaje.tunear_bicicleta(bici2);
	}
}
