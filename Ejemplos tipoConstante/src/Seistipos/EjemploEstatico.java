package Seistipos;

public class EjemploEstatico {

	public static void main(String[] args) 
	{
		SeisEjemplos variable = new SeisEjemplos();
		SeisEjemplos variableEstatica1 = new SeisEjemplos();
		SeisEjemplos variableEstatica2 = new SeisEjemplos();
		
		variableEstatica1.ConstanteEstatico = "Cambio 1"; //Objeto creado
		
		variableEstatica2.ConstanteEstatico = "Cambio 2"; //Objeto creado
		
		SeisEjemplos.ConstanteEstatico = "Cambio 1"; //Objeto creado. Igual que la variableEstatica1, solo que creada de la forma adecuada
		
		SeisEjemplos.ConstanteEstatico = "Cambio 2"; //Objeto creado. Igual que la variableEstatica2, solo que creada de la forma adecuada
		
		System.out.println(variableEstatica1.ConstanteEstatico); //Llama la VariableEstatica1, de forma in-adecuada
		
		System.out.println(variableEstatica2.ConstanteEstatico); //Llama la VariableEstatica2, de forma in-adecuada
		
		System.out.println(variable.ConstanteEstatico); //Llama la Variable, de forma in-adecuada
		
		System.out.println(SeisEjemplos.ConstanteEstatico); //Llama la Variable, de forma adecuada
		
		System.out.println(SeisEjemplos.ConstanteEstatico); //Llama la VariableEstatica1, de forma adecuada
		
		System.out.println(SeisEjemplos.ConstanteEstatico); //Llama la VariableEstatica2, de forma adecuada
		
		System.out.println(SeisEjemplos.ConstanteEstatico); //Llama la Variable, de forma adecuada
		
		
		
		//Al modificar el atributo estatico, este siempre sera el ultimo valor de la variable. 
		//ConstanteEstatico tiene 3 valores:
		//"Constante estatico"
		//"Cambio 1"
		//"Cambio 2"
		//Pero al ser el ultimo cambio "Cambio 2", el valor sera ese, da igual el numero de objetos que creemos.
		
		
	}
}
