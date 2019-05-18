package controller;

import java.io.IOException;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.GasStation;

public class Controller_NewEmployeeDialog {

    @FXML
    private Button b_addemployee;

    @FXML
    private TextField tf_nameofnewemployee;

    @FXML
    private DatePicker dp_dateofemployment;
    
    String nameOfEmployee;
    LocalDate dateOfEmployment;
    

    @FXML
    void addNewEmployee(ActionEvent event) throws IOException {
    	
    	GasStation.addEmployee(tf_nameofnewemployee.getText(), dp_dateofemployment.getValue());
    	
    	//schlieﬂt das Fenster
    	Stage stage = (Stage)
    	    	b_addemployee.getScene().getWindow();
    	    	stage.close();    	    	 	   	
    	    	
    }

}

