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

public class ControllerChangePriceOfFuelDialog implements Initializable {

	    @FXML
	    private Button btnConfirmPrice;

	    @FXML
	    private ComboBox<String> cbNameOfFuelType;

	    @FXML
	    private TextField tfNewPrice;

	    //Wird ausgeloest wenn man im PopUp "Treibstoffpreis aendern" auf "Bestaetigen" klickt
	    //Aktualisiert den neuen Preis in der Tabelle 
	    //Bei falschen Eingaben erscheint ein PopUp
	    @FXML
	    void confirmPrice(ActionEvent event) {
	    	
	    	double newPrice = 0;
	    	try{newPrice = Double.valueOf(tfNewPrice.getText());
    	}catch(NumberFormatException e) {

	    	}
	    	
	    	if(newPrice<=0) {
	    		Alert alert = new Alert(AlertType.ERROR);
	    		alert.setTitle("Fehler");
	    		alert.setHeaderText("Bitte gültigen Wert angeben");
	    		alert.setContentText(null);
	    		alert.showAndWait();
	    	} else {
	    	GasStation.changePriceOfFuel(cbNameOfFuelType.getValue(), newPrice);
	    	//schließt das Fenster
	    	Stage stage = (Stage)
	    	    	btnConfirmPrice.getScene().getWindow();
	    	    	stage.close();
	    	}
	    	
	    	

	    }

	    @FXML
	    void nameOfProduct(ActionEvent event) {

	    }

	    @FXML
	    void newPrice(ActionEvent event) {

	    }
	    
	    //Initialisierung der ComboBox
	    @Override
		public void initialize(URL location, ResourceBundle resources) {
	    	cbNameOfFuelType.getItems().removeAll(cbNameOfFuelType.getItems());
	    	cbNameOfFuelType.getItems().addAll("Super", "Diesel");
	    	cbNameOfFuelType.getSelectionModel().select("Super");
	    }

	}

