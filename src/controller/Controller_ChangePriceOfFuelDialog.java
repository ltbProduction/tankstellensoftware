package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.GasStation;
import utilities.FileTransfer;

public class Controller_ChangePriceOfFuelDialog implements Initializable {
	

	//ObservableList<String> fueltype = FXCollections.observableArrayList("Super", "Diesel");

	    @FXML
	    private Button b_confirmprice;

	    @FXML
	    private ComboBox<String> cb_nameoffueltype;

	    @FXML
	    private TextField tf_newprice;

	    @FXML
	    void confirmPrice(ActionEvent event) {
	    	
	    	double newPrice = 0;
	    	try{newPrice = Double.valueOf(tf_newprice.getText());
    	}catch(NumberFormatException e) {
	        	System.out.println("Das ist keine gültige Zahl");
	    	}
	    	
	    	GasStation.changePriceOfFuel(cb_nameoffueltype.getValue(), newPrice);
	    	
	    	
	    	//schließt das Fenster
	    	Stage stage = (Stage)
	    	    	b_confirmprice.getScene().getWindow();
	    	    	stage.close();

	    }

	    @FXML
	    void nameOfProduct(ActionEvent event) {

	    }

	    @FXML
	    void newPrice(ActionEvent event) {

	    }
	    
	    @Override
		public void initialize(URL location, ResourceBundle resources) {
	    	cb_nameoffueltype.getItems().removeAll(cb_nameoffueltype.getItems());
	    	cb_nameoffueltype.getItems().addAll("Super", "Diesel");
	    	cb_nameoffueltype.getSelectionModel().select("Super");
	    }

	}

