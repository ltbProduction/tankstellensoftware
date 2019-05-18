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

public class Controller_ChangePriceOfGoodsDialog implements Initializable{

    @FXML
    private Button b_confirmprice;

    @FXML
    private ComboBox<String> cb_nameofproduct;

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
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	cb_nameofproduct.getItems().removeAll(cb_nameofproduct.getItems());
    	cb_nameofproduct.getItems().addAll("Wodka Jelzin", "Filip Maurice", "Jupiter Schokoriegel", "Sitting Bull", "TK-Pizza Deluxe");
    	cb_nameofproduct.getSelectionModel().select("Wodka Jelzin");
    }

}

