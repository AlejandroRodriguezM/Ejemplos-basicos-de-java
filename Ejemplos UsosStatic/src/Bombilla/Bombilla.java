package Bombilla;

public class Bombilla {
	
    //Atributos de clase
    private static int bombillasCreadas;
    private static int bombillasEncendidas;
    private static int bombillasApagadas;
    
    //Atributos de objeto
    private boolean estado;
    private int vecesEncendida;
    
    //Atributos de clase constantes
    public static final boolean Estado_Inicial_Predeterminado = false;
    
    //Constructor Bombilla con parametro
    public Bombilla(boolean estado) 
    {
    	//Inicializamos el estado    
    	this.setEstado(estado);

    	//Si el primer estado es encendida, ya ha sido encendida una vez
//    	this.vecesEncendida = estado ? 1 : 0;
    	if(estado)
    	{
    		this.vecesEncendida = 1;
    	}
    	else
    	{
    		this.vecesEncendida = 0;
    	}

    	//Actualizamos atributos de clase        
    	Bombilla.bombillasCreadas++;
//    	Bombilla.bombillasEncendidas += this.estado ? 1 : 0;
    	
    	//Es lo mismo que Bombilla.bombillasEncendidas += this.estado ? 1 : 0;
    	if(estado)
    	{
    	Bombilla.bombillasEncendidas = 1 + Bombilla.bombillasEncendidas;
    	}
    	else
    	{
    		Bombilla.bombillasEncendidas = Bombilla.bombillasEncendidas + 0;
    	}
    }
    
   //Constructor Bombilla sin parametros. Nos servira para hacer que la bombilla creada se encuentre apagada.
    public Bombilla() 
    {
    	this(Bombilla.Estado_Inicial_Predeterminado);
    }

    //getEstado, para consultar el estado actual de la bombilla (apagada/false o encendida/true);
    public boolean getEstado() 
    {
    	return this.estado;
    }
    //isEncendida, que devuelva true si la bombilla está encendida (estado encendido/true);
    public boolean isEncendida() 
    {
    	return this.estado;
    }
    //isApagada, que devuelva true si la bomilla está apagada (estado apagada/false);
    public boolean isApagada() 
    {
    	return this.estado = false;
    }
    
    //getVecesEncendida, para obtener el número de veces que ha sido encendida.
    public int getVecesEncendida() 
    {
    	return this.vecesEncendida;
    }
    
    //Set de estado.
    public void setEstado(boolean estado)
    {
    	this.estado = estado;
    }
    
    //getBombillasCreadas, para obtener la cantidad de bombillas creadas hasta el momento;
    public static int getBombillasCreadas() 
    {
    	return Bombilla.bombillasCreadas;
    }
    
    //getBombillasEncendidas, para obtener la cantidad de bombillas encendidas en el momento actual.
    public static int getBombillasEncendidas() 
    {
    	return Bombilla.bombillasEncendidas;
    }
    
    //getBombillasEncendidas, para obtener la cantidad de bombillas apagadas en el momento actual.
    public static int getBombillasApagadas() 
    {
    	return Bombilla.bombillasApagadas;
    }
    
    @Override
    public String toString() 
    {
    	String resultado = "";
    	if (estado)
    	{

    		if(vecesEncendida == 1)
    		{
    			resultado = "Bombilla encendida. Se ha encendido " + this.vecesEncendida + " vez.";
    		}
    		else
    		{
    			if(vecesEncendida > 1)
    			{
    				resultado = "Bombilla encendida. " + "Se han encendido " + this.vecesEncendida + " numero de veces.";
    			}
    		}
    	}
    	else
    	{
    		if(vecesEncendida == 1)
    		{
    			resultado = "Bombilla apagada. Se ha encendido " + this.vecesEncendida + " vez.";
    		}
    		else
    		{
    			if(vecesEncendida > 1)
    			{
    				resultado = "Bombilla apagada. Se han encendido " + this.vecesEncendida + " veces.";
    			}
    		}
    	}
    	return resultado;
    }
    
    public void encender() 
    {        
    	if (this.estado == false) // Comprobamos que la bombilla no esté aún encendida
    	{ 
    		this.estado = true;              // Pasamos el estado a encendida
    		this.vecesEncendida++;           // Incrementamos el número de veces que la bombilla ha sido encendida
    		Bombilla.bombillasEncendidas++;  // Incrementamos la cantidad de bombillas encendidas en este momento
    		System.out.println("Has encendido la bombilla");
    	}
    	else //Si la bombilla ya está encendida se lanza este mensaje
    	{  
    		System.out.println("Error: intentando encender bombilla ya encendida.");            
    	}
    }
    
    public void apagar ()
    {
    	if (this.estado == false) 
    	{  // Si la bombilla ya está apagada se lanza una excepción
    		System.out.println("Error: intentando encender bombilla ya encendida.");
    	}
    	else //Sólo si la bombilla está encendida se llevan a cabo las acciones
    	{  
    		this.estado = false;              // Pasamos el estado a apagada
    		Bombilla.bombillasEncendidas--;
    		Bombilla.bombillasApagadas++;  // Incrementamos la cantidad de bombillas encendidas en este momento// Decrementamos en uno el número de bombillas encendidas en este momento
    		System.out.println("Has apagado la bombilla");
    	}
    }
    
    public void conmutar()  
    {
    	if (this.estado)
    	{
    		apagar();    // Si la bombilla está encendida, la apagamos         
    	}

    	else 
    	{
    		encender();  // Si la bombilla está apagada, la encendemos 
    	}
    }
}
