package controller;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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
    void addNewEmployee(ActionEvent event) {

    	
    	
    }

}
