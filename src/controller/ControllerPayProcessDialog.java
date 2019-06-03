package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.Window;
import models.GasStation;
import utilities.Helpmethods;

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
		//Die neue Verkaufsnummer
		int salenumber = Helpmethods.newsalesnumber();
		//Was soll beim schließen passieren
		Stage stage = (Stage) btnContinue.getScene().getWindow();

		//Das DiagonalFeld welches den Speicherort nachfrägt
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Speicherort");
        alert.setHeaderText("Wo möchten Sie den Beleg Speichern?");
 
        ButtonType saveReceiptAs = new ButtonType("Speicherort auswählen");
        ButtonType saveReceiptDesktop = new ButtonType("Desktop");
         alert.getButtonTypes().clear();
 
        alert.getButtonTypes().addAll(saveReceiptAs, saveReceiptDesktop);
 
        
        Optional<ButtonType> option = alert.showAndWait();
      
        if (option.get() == saveReceiptAs) {
    		// Den Filechooser auslösen
    		Window window = btnContinue.getScene().getWindow();
    		file = fileChooser.showSaveDialog(window);
    		if(file!=null) {
    		GasStation.finishedreceipt(file, salenumber);
    		// schließt das Fenster
    		stage.close();
    		}
        } else if (option.get() == saveReceiptDesktop) {
            String home = System.getProperty("user.home");    	   
//        	//Auf dem Desktop speichern
        	String filename = home + "/Desktop/Beleg" + String.valueOf(salenumber) + ".txt"; 
            File file = new File(filename);
            GasStation.finishedreceipt(file, salenumber);
        	// schließt das Fenster
    		stage.close();
            }
     




	}

}
