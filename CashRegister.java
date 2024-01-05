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

public class CashRegister extends Application {

	public static void main(String[] args) {

		launch(args);

	}

	private Label quantity = new Label("Quantity");

	private Label price = new Label("Price");

	private TextField textField1 = new TextField("");

	private TextField textField2 = new TextField("");

	private Label total = new Label("Total: ");

	private Label actual = new Label("0.00");

	@Override

	public void start(Stage stage) {

		// The main entry point into this program:

		stage.setTitle("Cash Register");

		GridPane window = new GridPane();

		window.add(quantity, 1, 1);

		window.add(textField2, 2, 1);

		window.add(price, 1, 2);

		window.add(textField1, 2, 2);

		window.add(total, 1, 3);
		window.add(actual, 2, 3);

		textField1.setOnAction(new conversionHandler());
		textField2.setOnAction(new conversionHandler());

		window.setHgap(20);
		window.setVgap(20);

		Scene scene = new Scene(window, 300, 150);

		stage.setScene(scene);

		stage.show();
	}

	public static double conversion(double num, double price, double total) {
		double current = num * price;
		return current + total;
	}

	private class conversionHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent ae) {
			String input1 = textField1.getText();
			String input2 = textField2.getText();
			String input3 = actual.getText();
			double number = Double.parseDouble(input1);
			double price = Double.parseDouble(input2);
			double total = Double.parseDouble(input3);
			double conversion = conversion(number, price, total);
			actual.setText(String.valueOf(conversion));
		}
	}

}
