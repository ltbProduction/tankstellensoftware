package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    
    public void initialize(URL location, ResourceBundle resources) {
    	cb_fueltype.getItems().removeAll(cb_fueltype.getItems());
    	cb_fueltype.getItems().addAll("Super", "Diesel");
    	cb_fueltype.getSelectionModel().select("Super");
    }
    
    @FXML
    void addFuelToShoppingCart(ActionEvent event) {

    }

    @FXML
    void chooseFuelType(ActionEvent event) {

    }

    @FXML
    void setAmountOfFuel(ActionEvent event) {

    }
    

}
