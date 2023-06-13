
public class main {
	
	public static void main(String[] args) 
	{
		comic Comic1 = new comic("Iron man",2021,"Marvel"); //Creamos el objeto "Comic1" con 3 valores.
		
		Comic1.SetYear(2023); //Cambiamos el valor de "year" usando un "set" El cambio solamente afecta al objeto "Comic1" y no otros que podamos crear
		
		System.out.println(Comic1.getYear());
		System.out.println(Comic1.getNombre());
		System.out.println(Comic1.getEditorial());
		
		
		
	}

}
