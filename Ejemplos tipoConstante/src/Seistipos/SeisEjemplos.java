package Seistipos;

public class SeisEjemplos {
	
	public String TipoPublico = "Tipo publica";
	
	protected String TipoProtegido = "Tipo Protegida";
	
	private String TipoPrivado = "Tipo privada";
	
	static String ConstanteEstatico = "Constante estatico"; //Se le puede añadir los diferentes tipos mencionados arriba y afectaran a la variable, como se ha demostrado en los ejemplos.
	
	final String ConstanteFinal = "Constante final"; //Se le puede añadir los diferentes tipos mencionados arriba y afectaran a la variable, como se ha demostrado en los ejemplos. Al ser "final", sus valores permaneceran fijos
	
	static final String ConstanteEstaticoFinal = "Constante estatico y final";
	
	public static void main(String[] args) 
	{
		SeisEjemplos variable = new SeisEjemplos();
		
		System.out.println(variable.TipoPrivado);  //Se ve, ya que el tipo private se puede ver solamente dentro de su clase
		
		System.out.println(variable.ConstanteEstatico);   //Se ve, ya que el atributo static se puede ver solamente dentro de su clase o paquete. Esta es una forma correcta de llamarla, pero no es la adecuada
		
		System.out.println(SeisEjemplos.ConstanteEstatico);   //Se ve, ya que el atributo static se puede ver solamente dentro de su clase o paquete. Esta es la forma correcta de llamar a la constante. Es estatico, por lo cual no cambia aunque redifinamos el contenido de la variable
	
		//ConstanteFinal="ERROR"; //No se puede modificar el atributo, ya que es de tipo "final" por lo cual no se puede cambiar y su valor es fijo
		
		System.out.println(variable.ConstanteFinal);  //Se ve, ya que el atributo static se puede ver solamente dentro de su clase o paquete. No se puede modificar el valor de la variable.
		
		//ConstanteEstaticoFinal="ERROR"; //No se puede modificar el atributo, ya que es de tipo "final" por lo cual no se puede cambiar y su valor es fijo
		
		System.out.println(SeisEjemplos.ConstanteEstaticoFinal); //Se ve, ya que el atributo static se puede ver solamente dentro de su clase o paquete. No se puede modificar el valor de la variable. Combina ambas contanstes, osea, no se puede modificar y la forma correcto de llamarla se hace de esta forma
	
	//https://www.youtube.com/watch?v=64JUq_-zkBU video explicacion
	}
}
