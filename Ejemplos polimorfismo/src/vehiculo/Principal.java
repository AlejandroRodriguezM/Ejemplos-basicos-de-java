package vehiculo;

public class Principal {
	
	public static void main(String[] args) 
	{
		//Polimorfismo significa muchos objetos. Da la habilidad de identificar un objeto como mas de 1 tipo. Ejm: Coche es un objeto vehiculo y un objeto coche
		Bicicleta bicicleta = new Bicicleta();
		Coche coche = new Coche();
		Barco barco = new Barco();
		
		Vehiculo carrera[] = {bicicleta,coche,barco};
		
		for(Vehiculo x : carrera)
		{
			x.arranca();
			
		}
		
	}

}
