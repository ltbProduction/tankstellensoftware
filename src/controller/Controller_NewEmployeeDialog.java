package controller;

import java.io.IOException;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
    int employeeNumber = 0;

    @FXML
    void addNewEmployee(ActionEvent event) throws IOException {

    	nameOfEmployee = tf_nameofnewemployee.getText();
    	dateOfEmployment = dp_dateofemployment.getValue();
    	employeeNumber += 1;
    	
//    	DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d.MM.uuuu");
//    	String dateOfEmployment = dp_dateofemployment.getValue().format(formatters);
    	
    	Employee employee = new Employee(employeeNumber, nameOfEmployee, dateOfEmployment);
    	GasStation.addEmployee(employee);
    	
    	
    	//schlieﬂt das Fenster
    	Stage stage = (Stage)
    	b_addemployee.getScene().getWindow();
    	stage.close();
    			
    	
    	
        
    	
    	   	
    	    	
    }

}
