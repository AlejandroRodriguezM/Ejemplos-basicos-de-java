package Seistipos;

public class DiferentesTipos {
	
	public static void main(String[] args) 
	{
		SeisEjemplos variable = new SeisEjemplos();
		
		System.out.println(variable.TipoProtegido); //Se puede ver ya que el tipo protected se puede ver solamente dentro de su paquete
		
		System.out.println(variable.TipoPublico);  //Se ve, ya que el tipo public se puede ver en cualquier parte del proyecto
		
		//System.out.println(variable.VariablePrivada);  //No se ve, ya el tipo privado solamente se ve dentro de su clase
		
		System.out.println(variable.ConstanteEstatico);  //Se ve, ya que el atributo static se puede ver solamente dentro de su clase o paquete. Esta es una forma correcta de llamarla, pero no es la adecuada
		
		System.out.println(SeisEjemplos.ConstanteEstatico);  //Se ve, ya que el atributo static se puede ver solamente dentro de su clase o paquete. Esta es la forma correcta de llamar a la constante. Es estatico, por lo cual no cambia aunque redifinamos el contenido de la variable
		
	}
}
