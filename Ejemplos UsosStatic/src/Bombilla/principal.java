package Bombilla;

public class principal {
	
	public static void main(String[] args) 
	{
		//Mostramos las bombillas cre
	    System.out.println ("N�mero de bombillas creadas hasta el momento: " + Bombilla.getBombillasCreadas() + "\nN�mero de bombillas encendidas en este momento: " + Bombilla.getBombillasEncendidas() +  "\n");

	    //Creaci�n y asignaci�n del primer objeto
	    System.out.println ("Creamos una bombilla llamada b1.\n");
	    Bombilla b1= new Bombilla();
	    System.out.println ("Estado de b1: " +  b1);
	    
//	    //Creaci�n y asignaci�n del primer objeto
//	    System.out.println ("Creamos una bombilla llamada b1.\n");
//	    Bombilla b1= new Bombilla();
//	    System.out.println ("Estado de b1: " +  b1.getEstado());

	    //Creaci�n y asignaci�n del segundo objeto
	    System.out.println ("Creamos una bombilla llamada b2.\n");
	    Bombilla b2= new Bombilla(true);
	    System.out.println ("Estado de b2: " + b2 + "\n");

	    //Conmutar b2 cuatro veces
	    for (int i=0; i < 4; i++) 
	    {
	    	System.out.println ("Conmutando estado de b2.\n");
	    	b2.conmutar();
	    	System.out.println ("Estado de b2: " + b2 + "\n");
	    }

	    //Encender b2
	    System.out.println ("Encendiendo b2.\n");
	    b2.encender();

	    //Apagar b2
	    System.out.println ("Apagando b2.\n");
	    b2.apagar();

	    //Encender b2
	    System.out.println ("Encendiendo b2.\n");
	    b2.encender();

	    //Creaci�n y asignaci�n del tercer objeto
	    System.out.println ("Creamos una bombilla llamada b3.\n");
	    Bombilla b3= new Bombilla(true); //Creamos objeto con parametro
	    System.out.println ("Estado de b3: " +  b3 + "\n");

	    //Valores de clase finales
	    System.out.println ("N�mero de bombillas creadas hasta el momento: " + Bombilla.getBombillasCreadas());
	    System.out.println ("N�mero de bombillas encendidas en este momento: " + Bombilla.getBombillasEncendidas());
	    System.out.println ("N�mero de bombillas apagadas en este momento: " + Bombilla.getBombillasApagadas());
	}
}
