package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Controller_GasPumpDialog implements Initializable {
	
	//ObservableList<String> fueltype = FXCollections.observableArrayList("Super", "Diesel");

    @FXML
    private ComboBox<String> cb_fueltype;

    @FXML
    private TextField tf_amountoffuel;

    @FXML
    private Button b_addfuel;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	cb_fueltype.getItems().removeAll(cb_fueltype.getItems());
    	cb_fueltype.getItems().addAll("Super", "Diesel");
    	cb_fueltype.getSelectionModel().select("Super");
    }
    
// @FXML
//    void addFuelToShoppingCart(ActionEvent event) {
//    	
//    	int productNumber;
//    	
//    	for (FuelTank t : GasStation.getFuelTanks()) {
//    		
//    		
//    		
//    		
//    		if (cb_fueltype.getValue().equals(t.getFuelType())) {
//    			productNumber = t.getTankNumber();
//    		} else continue;
//    		
//    	}
//    	
//    	GasStation.addFuelToShoppingCart(productNumber, Double.parseDouble(tf_amountoffuel.getText()));
//    	
//    	
//    	
//    	//schlieﬂt das Fenster
//    	Stage stage = (Stage)
//    	    	b_addfuel.getScene().getWindow();
//    	    	stage.close();
//
//    }

    @FXML
    void chooseFuelType(ActionEvent event) {

    }

    @FXML
    void setAmountOfFuel(ActionEvent event) {

    }
    

}
