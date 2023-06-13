package animales;

public class principal {
	
	public static void main(String[] args) 
	{
		//Las interfaces sirven para decirle a la clase lo que va a hacer, se diferencia de la herencia porque permite aplicar mas de 1 interfaz(super)
		
		Conejo conejo = new Conejo();
		Buho buho = new Buho();
		Pez pez = new Pez();
		
		conejo.huye();
		buho.caza();
		pez.caza();
		pez.huye();
		

	}

}
