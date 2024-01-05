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

public class BmiCalculator extends Application {

	public static void main(String[] args) {

		launch(args);

	}

	private Label weight = new Label("Weight (in total pounds)");

	private Label height = new Label("Height (in total inches)");

	private TextField textField1 = new TextField("");

	private TextField textField2 = new TextField("");

	private Label total = new Label("BMI: ");

	private Label actual = new Label("0.00");

	@Override

	public void start(Stage stage) {

		// The main entry point into this program:

		stage.setTitle("BMI Calculator");

		GridPane window = new GridPane();

		window.add(weight, 1, 1);

		window.add(textField2, 3, 1);

		window.add(height, 1, 2);

		window.add(textField1, 3, 2);

		window.add(total, 1, 3);
		window.add(actual, 2, 3);

		textField1.setOnAction(new conversionHandler());
		textField2.setOnAction(new conversionHandler());

		window.setHgap(20);
		window.setVgap(20);

		Scene scene = new Scene(window, 400, 150);

		stage.setScene(scene);

		stage.show();
	}

	public static double conversion(double weight, double height) {
		double kilos = weight / 2.20462;
		double meters = height *  0.0254;
		double bmi = kilos / meters;
		return bmi;
	}
	
	private class conversionHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent ae) {
			String input1 = textField1.getText();
			String input2 = textField2.getText();
			double weight = Double.parseDouble(input1);
			double height = Double.parseDouble(input2);
			double conversion = conversion(weight, height);
			actual.setText(String.valueOf(conversion));
		}
	}

}
