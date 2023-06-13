package vehiculo;

public class main {
	
	public static void main(String[] args) 
	{
		coche coche1 = new coche();
		bicicleta bici1 = new bicicleta();
		
		coche.funciona();
		coche.parada();
		
		System.out.println();
		
		vehiculo.funciona();
		bicicleta.parada();
		
		System.out.println();
		
		System.out.println(coche1.puertas);
		System.out.println(coche1.ruedas);
		
		System.out.println();
		
		System.out.println(bici1.pedales);
		System.out.println(bici1.ruedas);
		
	}

}
