package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.FileChooser.ExtensionFilter;
import models.GasStation;

public class ControllerPayProcessDialog implements Initializable {

	// Test Linus
	private File file;
	private FileChooser fileChooser;

	@FXML
	private Pane pane;

	@FXML
	private Label lblPrice;

	@FXML
	private TextField tfMoneyReceived;

	@FXML
	private Button btnConfirmMoneyReceived;

	@FXML
	private Label lblMoneyReturn;

	@FXML
	private Button btnContinue;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// File-Chooser initialisieren
		fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Textdateien", "*.txt"));

		// Label auf Gesamtbetrag des Warenkorbs setzen
		lblPrice.setText(String.valueOf(GasStation.getTotalPrice()));

	}

	@FXML
	void onConfirmMoneyReceived(ActionEvent event) {

		double moneyReceived = Double.parseDouble(tfMoneyReceived.getText());

		// Setze Label auf die Differenz von Gegebenem Geld - Gesamtbetrag (gerundet)
		lblMoneyReturn
				.setText(String.valueOf(Math.round(100.0 * (moneyReceived - GasStation.getTotalPrice())) / 100.0));

	}

	@FXML
	void onContinue(ActionEvent event) {
		// Den Filechooser auslösen
		Window window = btnContinue.getScene().getWindow();
		file = fileChooser.showSaveDialog(window);
		GasStation.finishedreceipt(file);

		// schließt das Fenster
		Stage stage = (Stage) btnContinue.getScene().getWindow();
		stage.close();

	}

}
