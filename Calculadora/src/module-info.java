module Calculadora {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens calculadora to javafx.graphics, javafx.fxml;
}
