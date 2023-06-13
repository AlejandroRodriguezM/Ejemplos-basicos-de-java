package calculadora;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * Por Alejandro Rodriguez Mena
 * 
 * Ejercicio 31 - Clase Principal
 * 
 * Crear una calculadora simple usando javaFX y Scenebuilder, los botones al pulsarlos deben de cambiar de color y al limpiar deben de volver a su color original.
 * Crear 2 botones, uno para guardar el dato en pantalla y otro para mostrarlo.
 */

public class Principal extends Application{

	//Metodo que permite la ejecutcion de la aplicacion.
	public void start(Stage primaryStage) throws IOException 
	{
		Parent root = FXMLLoader.load(getClass().getResource("calculadoraV2.fxml")); //Obtenemos el diseño en la ruta y fichero ya creado.
		primaryStage.setScene(new Scene(root)); //Creamos una escena para poder usar la aplicacion.
		primaryStage.setTitle("Calculadora simple opcional"); //Titulo de la aplicacion.
		primaryStage.show(); //Mostramos la aplicacion-

	}
	public static void main(String[] args) 
	{
		launch(args);
	}
}
