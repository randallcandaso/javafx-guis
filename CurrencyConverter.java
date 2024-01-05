package model;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/*

* This is minimal GUI with no events.

*

* @author Rick Mercer

*/

public class CurrencyConverter extends Application {

 

  public static void main(String[] args) {

    launch(args);

  }

	private Label usd = new Label("US Dollars");

	private Label eur = new Label("European Euros");
	
	private Label mxn = new Label("Mexican Pesos");
	
	private Label jpy = new Label("Japense Yen");
	
	private Label gbp = new Label("British Pound");

	private TextField textField1 = new TextField("Enter USD");

	private TextField textField2 = new TextField("Enter EUR");
	
	private TextField textField3 = new TextField("Enter MXN");
	
	private TextField textField4 = new TextField("Enter JPY");
	
	private TextField textField5 = new TextField("Enter GBP");

	@Override

	public void start(Stage stage) {

		// The main entry point into this program:

		stage.setTitle("Currency Converter");

		GridPane window = new GridPane();

		window.add(usd, 1, 1);

		window.add(textField1, 2, 1);

		window.add(eur, 1, 2);

		window.add(textField2, 2, 2);
		
		window.add(mxn, 1, 3);
		
		window.add(textField3, 2, 3);

		window.add(jpy, 1, 4);
		
		window.add(textField4, 2, 4);

		window.add(gbp, 1, 5);
		
		window.add(textField5, 2, 5);

		textField1.setOnAction(new usdHandler());
		textField2.setOnAction(new eurHandler());
		textField3.setOnAction(new mxnHandler());
		textField4.setOnAction(new jpyHandler());
		textField5.setOnAction(new gbpHandler());

		window.setHgap(20);
		window.setVgap(20);

		Scene scene = new Scene(window, 300, 200);

		stage.setScene(scene);

		stage.show();

	}

	private class usdHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent ae) {
			String input = textField1.getText();
			double number = Double.parseDouble(input);
			double eur = number * 0.92;
			textField2.setText(String.valueOf(eur));
			double mxn = number * 17.02;
			textField3.setText(String.valueOf(mxn));
			double jpy = number * 143.69;
			textField4.setText(String.valueOf(jpy));
			double gbp = number * 0.79;
			textField5.setText(String.valueOf(gbp));
		}
	}

	private class eurHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent ae) {
			String input = textField2.getText();
			double number = Double.parseDouble(input);
			double usd = number * 1.09;
			textField1.setText(String.valueOf(usd));
			double mxn = number * 18.59;
			textField3.setText(String.valueOf(mxn));
			double jpy = number * 156.68;
			textField4.setText(String.valueOf(jpy));
			double gbp = number * 0.86;
			textField5.setText(String.valueOf(gbp));
		}
	}
	
	private class mxnHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent ae) {
			String input = textField3.getText();
			double number = Double.parseDouble(input);
			double eur = number * 0.054;
			textField2.setText(String.valueOf(eur));
			double usd = number * 0.059;
			textField1.setText(String.valueOf(usd));
			double jpy = number * 8.43;
			textField4.setText(String.valueOf(jpy));
			double gbp = number * 0.046;
			textField5.setText(String.valueOf(gbp));
		}
	}
	
	private class jpyHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent ae) {
			String input = textField4.getText();
			double number = Double.parseDouble(input);
			double eur = number * 0.0064;
			textField2.setText(String.valueOf(eur));
			double mxn = number * 0.12;
			textField3.setText(String.valueOf(mxn));
			double usd = number * 0.0070;
			textField1.setText(String.valueOf(usd));
			double gbp = number * 0.0055;
			textField5.setText(String.valueOf(gbp));
		}	
	}
	
	private class gbpHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent ae) {
			String input = textField5.getText();
			double number = Double.parseDouble(input);
			double eur = number * 1.16;
			textField2.setText(String.valueOf(eur));
			double mxn = number * 21.55;
			textField3.setText(String.valueOf(mxn));
			double jpy = number * 181.63;
			textField4.setText(String.valueOf(jpy));
			double usd = number * 1.26;
			textField1.setText(String.valueOf(usd));
		}
	}



}

 