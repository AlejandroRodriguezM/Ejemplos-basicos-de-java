
public class main {
	
	public static void main(String[] args) 
	{
		articulo MisArticulos[] = new articulo[10];
		int contador;
		
		
		for (contador = 0; contador < MisArticulos.length; contador++) 
		{
			MisArticulos[contador] = new articulo("00"+contador,"Articulo "+contador,"DVD",(float)Math.random()*10);
		}
		
		for (contador = 0; contador < MisArticulos.length; contador++) 
		{
			System.out.println("Codigo articulo. "+MisArticulos[contador].getCodigo());
			System.out.println("Alquiler 1 dia: "+MisArticulos[contador].precio1());
			System.out.println("Alquiler 2 dias: "+MisArticulos[contador].precio2());
			System.out.println("Alquiler 1 semana: "+MisArticulos[contador].precio_semana());
		}
	}
}
