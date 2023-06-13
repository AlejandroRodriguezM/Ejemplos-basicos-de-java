import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/*
 * Por Alejandro Rodriguez Mena
 *
 * Ejercicio 31 - Clase Principal
 *
 * Crear una calculadora simple usando javaFX y Scenebuilder, los botones al pulsarlos deben de cambiar de color y al limpiar deben de volver a su color original.
 * Crear 2 botones, uno para guardar el dato en pantalla y otro para mostrarlo.
 */

public class CalcController {

	private boolean digito = false;
	private boolean punto = false;
	private int numOperandos = 0;
	private double operando1,operando2,operando3;
	private char operador = ' ';

	//Diferentes variables de SceneBuilder

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button bot_cero;

	@FXML
	private Button bot_uno;
	
	@FXML
	private Button bot_dos;
	
	@FXML
	private Button bot_tres;
	
	@FXML
	private Button bot_cuatro;
	
	@FXML
	private Button bot_cinco;

	@FXML
	private Button bot_seis;

	@FXML
	private Button bot_siete;
	
	@FXML
	private Button bot_ocho;
	
	@FXML
	private Button bot_nueve;

	@FXML
	private Button bot_grabar;

	@FXML
	private Button bot_igual;

	@FXML
	private Button bot_mostrar;

	@FXML
	private Button bot_multiplicar;

	@FXML
	private Button bot_dividir;

	@FXML
	private Button bot_punto;

	@FXML
	private Button bot_restar;

	@FXML
	private Button bot_sumar;

	@FXML
	private Label labPantalla;

	/////////////////////////////
	//Metodos de la calculadora//
	/////////////////////////////

	//Cada click representa un boton en la calculadora

	@FXML
	private void click_cero(ActionEvent event) {
		bot_cero.setStyle("-fx-background-color: #A0F52D"); //Al pulsarlo, se cambiara de color.
		digitoPantalla("0");
	}

	@FXML
	private void click_uno(ActionEvent event) {
		bot_uno.setStyle("-fx-background-color: #A0F52D"); //Al pulsarlo, se cambiara de color.
		digitoPantalla("1");
	}

	@FXML
	private void click_dos(ActionEvent event) {
		bot_dos.setStyle("-fx-background-color: #A0F52D"); //Al pulsarlo, se cambiara de color.
		digitoPantalla("2");
	}

	@FXML
	private void click_tres(ActionEvent event) {
		bot_tres.setStyle("-fx-background-color: #A0F52D"); //Al pulsarlo, se cambiara de color.
		digitoPantalla("3");
	}

	@FXML
	private void click_cuatro(ActionEvent event) {
		bot_cuatro.setStyle("-fx-background-color: #A0F52D"); //Al pulsarlo, se cambiara de color.
		digitoPantalla("4");
	}

	@FXML
	private void click_cinco(ActionEvent event) {
		bot_cinco.setStyle("-fx-background-color: #A0F52D"); //Al pulsarlo, se cambiara de color.
		digitoPantalla("5");
	}

	@FXML
	private void click_seis(ActionEvent event) {
		bot_seis.setStyle("-fx-background-color: #A0F52D"); //Al pulsarlo, se cambiara de color.
		digitoPantalla("6");
	}

	@FXML
	private void click_siete(ActionEvent event) {
		bot_siete.setStyle("-fx-background-color: #A0F52D"); //Al pulsarlo, se cambiara de color.
		digitoPantalla("7");
	}

	@FXML
	private void click_ocho(ActionEvent event) {
		bot_ocho.setStyle("-fx-background-color: #A0F52D"); //Al pulsarlo, se cambiara de color.
		digitoPantalla("8");
	}

	@FXML
	private void click_nueve(ActionEvent event) {
		bot_nueve.setStyle("-fx-background-color: #A0F52D"); //Al pulsarlo, se cambiara de color.
		digitoPantalla("9");
	}

	@FXML
	private void click_punto(ActionEvent event)
	{
		bot_punto.setStyle("-fx-background-color: #A0F52D"); //Al pulsarlo, se cambiara de color.
		if(!punto && !digito)
		{
			labPantalla.setText("0.");
			digito = true;
		}
		else if(!punto)
		{
			String valorActual = labPantalla.getText();
			labPantalla.setText(valorActual + ".");
		}

		punto = true;
	}

	@FXML
	private void click_restar(ActionEvent event) {
		bot_restar.setStyle("-fx-background-color: #A0F52D"); //Al pulsarlo, se cambiara de color.
		evaluarOperador("-");
	}

	@FXML
	private void click_sumar(ActionEvent event) {
		bot_sumar.setStyle("-fx-background-color: #A0F52D"); //Al pulsarlo, se cambiara de color.
		evaluarOperador("+");
	}

	@FXML
	private void click_multiplicar(ActionEvent event) {
		bot_multiplicar.setStyle("-fx-background-color: #A0F52D"); //Al pulsarlo, se cambiara de color.
		evaluarOperador("*");
	}

	@FXML
	private void click_dividir(ActionEvent event) {
		bot_dividir.setStyle("-fx-background-color: #A0F52D"); //Al pulsarlo, se cambiara de color.
		evaluarOperador("/");
	}

	@FXML
	private void click_igual(ActionEvent event) {
		bot_igual.setStyle("-fx-background-color: #A0F52D"); //Al pulsarlo, se cambiara de color.
		evaluarOperador("=");
		botonesDefault();
	}

	@FXML
	private void click_guardar(ActionEvent event) //Se guardara en una variable el valor que se encuentre en pantalla y borrara la pantalla.
	{
		bot_grabar.setStyle("-fx-background-color: #A0F52D");

		if(!digito) //En caso haber realizado una operacion, se guardara el valor de esta.
		{
			if(this.numOperandos == 1)
			{
				this.operando3 = Double.parseDouble(labPantalla.getText());
				this.operando2 = 0;
				this.numOperandos = 0;
			}
			labPantalla.setText("");
			return;
		}
		else
		{
			if(this.numOperandos == 0) //Si es el primer digito que metemos, se guardara en la variable "operando1"
			{
				this.operando3 = Double.parseDouble(labPantalla.getText());
			}
			else if(this.numOperandos == 1) //Si es el segundo digito que metemos, se guardara en la variable "operando2"
			{
				this.operando3 = Double.parseDouble(labPantalla.getText());
			}
		}
		labPantalla.setText("");
		this.digito = false;
	}

	@FXML
	void click_mostrar(ActionEvent event)
	{
		bot_mostrar.setStyle("-fx-background-color: #A0F52D");
		labPantalla.setText(String.valueOf(this.operando3));

		if(this.numOperandos == 0) //Si es el primer digito que metemos, se guardara
		{
			this.operando1 = operando3;
			System.out.println("Digito1: "+operando3);
		}
		else if(this.numOperandos >= 1)
		{
			this.operando2 = operando3;
			System.out.println("Digito2: "+operando3);
			this.numOperandos++;
		}
	}

	@FXML
	void click_wipeOut(ActionEvent event) //Funcion que nos servira para resetear toda la calculadora.
	{
		this.digito = false;
		this.punto = false;
		this.numOperandos = 0;
		this.operando1 = 0;
		this.operando2 = 0;
		this.operando3 = 0;
		this.operador = ' ';
		this.labPantalla.setText("0");
		botonesDefault();
	}

	@FXML
	void click_delete(ActionEvent event) //Funcion que nos servira para borrar solamente el contenido del operando, no resetear
	{
		if(this.numOperandos == 0)
		{
			this.operando1 = 0;
			labPantalla.setText("0");
		}
		if(this.numOperandos == 1)
		{
			this.operando2 = 0;
			labPantalla.setText("0");
		}
	}

	//Funcion para devolver los botones de la calculadora a default
	private void botonesDefault()
	{
		this.bot_cero.setStyle(null); //Devuelve al boton su color original.
		this.bot_uno.setStyle(null); //Devuelve al boton su color original.
		this.bot_dos.setStyle(null); //Devuelve al boton su color original.
		this.bot_tres.setStyle(null); //Devuelve al boton su color original.
		this.bot_tres.setStyle(null); //Devuelve al boton su color original.
		this.bot_cuatro.setStyle(null); //Devuelve al boton su color original.
		this.bot_cinco.setStyle(null); //Devuelve al boton su color original.
		this.bot_seis.setStyle(null); //Devuelve al boton su color original.
		this.bot_siete.setStyle(null); //Devuelve al boton su color original.
		this.bot_ocho.setStyle(null); //Devuelve al boton su color original.
		this.bot_nueve.setStyle(null); //Devuelve al boton su color original.
		this.bot_sumar.setStyle(null); //Devuelve al boton su color original.
		this.bot_restar.setStyle(null); //Devuelve al boton su color original.
		this.bot_multiplicar.setStyle(null); //Devuelve al boton su color original.
		this.bot_dividir.setStyle(null); //Devuelve al boton su color original.
		this.bot_punto.setStyle(null); //Devuelve al boton su color original.
		this.bot_igual.setStyle(null); //Devuelve al boton su color original.
		this.bot_grabar.setStyle(null); //Devuelve al boton su color original.
		this.bot_mostrar.setStyle(null); //Devuelve al boton su color original.
	}

	//Funcion que permite mostrar datos en la pantalla de la calculadora
	private void digitoPantalla(String numero)
	{
		if(!digito && numero.equals("0")) //No permitira escribir un 0 siempre y cuando no haya mas numeros en pantalla
		{
			if(this.numOperandos == 1)
			{
				this.operando2 = 0;
				this.numOperandos++;
			}
			labPantalla.setText("0");
			return;
		}
		if(!digito) //Si no hay digito en pantalla, no se mostrara ningun digito
		{
			labPantalla.setText("");
			punto = false;
		}

		String valActual = labPantalla.getText();
		labPantalla.setText(valActual+ numero); //Se mostrara el valor del numero en pantalla
		digito = true;
	}

	//Funcion que permitira hacer calculos de la calculadora
	private void evaluarOperador(String operador)
	{
		if(digito) //Si hay un digito en pantalla, se sumara +1 al contador
		{
			this.numOperandos++;
		}
		if(digito && numOperandos == 1) //Si el numero de operandos son 1, se guardara el valor de "operando1"
		{
			System.out.println("digito1");
			operando1 = Double.parseDouble(labPantalla.getText());
		}
		if(digito && numOperandos >= 2) //Si el numero de operandos son 2, se guardara el valor de "operando2" y se realizara la operacion pertinente.
		{
			System.out.println("digito2");

			operando2 = Double.parseDouble(labPantalla.getText());
			switch(this.operador)
			{
			case '+':
			{
				this.operando1 += operando2;
				labPantalla.setText(String.valueOf(operando1));
				break;
			}
			case '-':
			{
				this.operando1 -= operando2;
				labPantalla.setText(String.valueOf(operando1));
				break;
			}
			case '*':
			{
				this.operando1 *=operando2;
				labPantalla.setText(String.valueOf(operando1));
				break;
			}
			case '/':
			{
				if(this.operando1 == 0 || this.operando2 == 0) //Para evitar fallos, si uno de los operandos a divir es 0, automaticamente el resultado en pantalla es 0.
				{
					this.labPantalla.setText("N/A");
					this.operando1 = 0;
				}
				else
				{
					this.operando1 /=operando2;
					labPantalla.setText(String.valueOf(operando1));
				}
				break;
			}
			case '=':
			{
				this.operando1 = operando2;
				labPantalla.setText(String.valueOf(operando1));
				break;
			}
			}
		}
		this.numOperandos = 1;
		punto = false;
		digito = false;
		this.operador = operador.charAt(0);
	}
}