package animales;

public class Pez implements Presa,Depredador{

	@Override
	public void caza() 
	{
		System.out.println("Este pez esta cazando pequeños peces");

		
	}

	@Override
	public void huye() 
	{
		System.out.println("Este pez esta huyendo de un pez mas grande");
		
	}
	

}
