// Randall Candaso

package model;

import javafx.application.Application; 
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

import javafx.scene.control.Label;

import javafx.scene.control.Button;

import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

import javafx.scene.layout.GridPane;

import javafx.scene.control.TextField;

/*

* This is minimal GUI with no events.

*

* @author Rick Mercer

*/

public class TemperatureConverter extends Application {

	public static void main(String[] args) {

		launch(args);

	}

	private Label celcius = new Label("Celcius");

	private Label fahrenheit = new Label("Fahrenheit");

	private TextField textField1 = new TextField("Enter F°");

	private TextField textField2 = new TextField("Enter C°");

	@Override

	public void start(Stage stage) {

		// The main entry point into this program:

		stage.setTitle("CtoF FtoC");

		GridPane window = new GridPane();

		window.add(celcius, 1, 1);

		window.add(textField2, 2, 1);

		window.add(fahrenheit, 1, 2);

		window.add(textField1, 2, 2);

		textField1.setOnAction(new celciusHandler());
		textField2.setOnAction(new fahrenheitHandler());

		window.setHgap(20);
		window.setVgap(20);

		Scene scene = new Scene(window, 280, 110);

		stage.setScene(scene);

		stage.show();

	}

	public static double FtoC(double c) {
		return Math.round(((c - 32) * 5 / 9) * 10.0) / 10.0;
	}

	public static double CtoF(double f) {
		return Math.round((((f * 9 / 5)) + 32) * 10.0) / 10.0;
	}

	private class celciusHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent ae) {
			String input = textField1.getText();
			double number = Double.parseDouble(input);
			double conversion = FtoC(number);
			textField2.setText(String.valueOf(conversion));
		}
	}

	private class fahrenheitHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent ae) {
			String input = textField2.getText();
			double number = Double.parseDouble(input);
			double conversion = CtoF(number);
			textField1.setText(String.valueOf(conversion));
		}
	}

}
