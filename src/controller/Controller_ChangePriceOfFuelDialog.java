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
import javafx.stage.Stage;

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
	    	
	    	
	    	//schlieﬂt das Fenster
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
	    
	    public void initialize(URL location, ResourceBundle resources) {
	    	cb_nameoffueltype.getItems().removeAll(cb_nameoffueltype.getItems());
	    	cb_nameoffueltype.getItems().addAll("Super", "Diesel");
	    	cb_nameoffueltype.getSelectionModel().select("Super");
	    }

	}

