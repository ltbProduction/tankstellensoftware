package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import models.GasStation;

/**
 * @author Robin Birkhofer
 *
 */

public class ControllerChangePriceOfGoodsDialog implements Initializable {

	@FXML
	private Button btnConfirmPrice;

	@FXML
	private ComboBox<String> cbNameOfProduct;

	@FXML
	private TextField tfNewPrice;

    //Wird ausgeloest wenn man im PopUp "Warenpreis aendern" auf "Bestaetigen" klickt
    //Aktualisiert den neuen Preis in der Tabelle 
    //Bei falschen Eingaben erscheint ein PopUp
	@FXML
	void confirmPrice(ActionEvent event) {

		double newPrice = 0;
		try {
			newPrice = Double.valueOf(tfNewPrice.getText());
		} catch (NumberFormatException e) {

		}

		if(newPrice<=0) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Fehler");
    		alert.setHeaderText("Bitte gültigen Wert angeben");
    		alert.setContentText(null);
    		alert.showAndWait();
    	} else {
		GasStation.changePriceOfGood(cbNameOfProduct.getValue(), newPrice);
		// schließt das Fenster
		Stage stage = (Stage) btnConfirmPrice.getScene().getWindow();
		stage.close();
    	}

	}


    //Initialisierung der ComboBox
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cbNameOfProduct.getItems().removeAll(cbNameOfProduct.getItems());
		cbNameOfProduct.getItems().addAll("Wodka Jelzin", "Filip Maurice", "Jupiter Schokoriegel", "Sitting Bull",
				"TK-Pizza Deluxe");
		cbNameOfProduct.getSelectionModel().select("Wodka Jelzin");
	}

}
