package controller;

import java.io.IOException;
import java.time.LocalDate;
import controller.Controller_Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import models.Employee;
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

    	nameOfEmployee = tf_nameofnewemployee.getText();
    	dateOfEmployment = dp_dateofemployment.getValue();
    	
    	Employee employee = new Employee(nameOfEmployee, dateOfEmployment);
    	GasStation.addEmployee(employee);
    	
    	
        
    	
    	   	
    	    	
    }

}
