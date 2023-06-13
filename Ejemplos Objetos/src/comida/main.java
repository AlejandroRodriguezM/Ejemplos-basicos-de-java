package comida;

public class main {
	
	//Ejercicio3
	
	public static void main(String [] args)
	{
		//comida nevera[] = new comida[3];
		
		comida comida1 = new comida("pizza");
		comida comida2 = new comida("hamburguesa");
		comida comida3 = new comida("patatas");
		
		comida nevera[] = {comida1,comida2,comida3};
		
//		nevera[0] = comida1;
//		nevera[1] = comida2;
//		nevera[2] = comida3;
		
		System.out.println(nevera[0].nombre);
		System.out.println(nevera[1].nombre);
		System.out.println(nevera[2].nombre);
	}

}
