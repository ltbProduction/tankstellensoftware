package controller;

import java.io.IOException;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import models.GasStation;

/**
 * @author Lukas Blunck
 *
 */

public class ControllerNewEmployeeDialog {

    @FXML
    private Button btnAddEmployee;

    @FXML
    private TextField tfNameOfNewEmployee;

    @FXML
    private DatePicker dpDateOfEmployment;
    
    String nameOfEmployee;
    LocalDate dateOfEmployment;
    

    // Neuen Mitarbeiter hinzufuegen
    @FXML
    void addNewEmployee(ActionEvent event) throws IOException {
    	
    	LocalDate date = dpDateOfEmployment.getValue();  		
    	
    	if (dpDateOfEmployment.getValue() == null) {
    		date = LocalDate.now();
    	}
    	
    	if (tfNameOfNewEmployee.getText().equals("")) {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fehler");
			alert.setHeaderText("Bitte geben Sie einem Namen ein.");
			alert.setContentText(null);
			alert.showAndWait();
		
    	} else {
    		
    		GasStation.addEmployee(tfNameOfNewEmployee.getText(), date);
        	
        	//schlieﬂt das Fenster
        	Stage stage = (Stage)
        	    	btnAddEmployee.getScene().getWindow();
        	    	stage.close();   
    		
    	}
    	
    	 	    	 	   	
    	    	
    }

}

