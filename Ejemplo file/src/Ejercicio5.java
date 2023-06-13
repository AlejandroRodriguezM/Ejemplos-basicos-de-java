

import java.io.File;

public class Ejercicio5 {
	
	public static void main(String[] args) 
	{
		File rutaDoc = new File("./Documentos/frases.txt");
		
		
		if(rutaDoc.exists())
		{
			System.out.println("si");
		}
		else
		{
			System.out.println("no");
		}
	}

}
