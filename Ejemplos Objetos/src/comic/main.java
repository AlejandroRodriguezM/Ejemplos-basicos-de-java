package comic;

public class main {
	
	//Ejercicio1

	public static void main(String[] args) 
	{
		comic MiComic = new comic();
		
		System.out.println(MiComic.precio);
		
		System.out.println(MiComic.tipoDuro);
		
		System.out.println(MiComic.tipoBlando);
		
		System.out.println(MiComic.idioma);
		
		comic.lectura();
		
		comic.guardar();

	}

}
