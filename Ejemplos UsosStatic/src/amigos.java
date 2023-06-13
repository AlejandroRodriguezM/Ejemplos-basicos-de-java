
public class amigos {
	
	String nombre;
	static int NumeroAmigos;
	
	amigos(String nombre)
	{
		this.nombre = nombre;
		NumeroAmigos++;
	}
	
	public static void MuestraAmigos()
	{
		System.out.println("Tienes un total de "+NumeroAmigos+" amigos");
	}

}
