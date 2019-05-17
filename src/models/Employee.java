package models;

import java.time.LocalDate;

 

public class Employee {


	private String employeeName;
	private int employeeNumber = 0;
	private LocalDate dateOfEmployment;
	
	
	
	public Employee(String employeeName, LocalDate dateOfEmployment) {
		this.employeeName = employeeName;
		this.employeeNumber +=1;
		this.dateOfEmployment = dateOfEmployment;
	}
	
	

	public void displayEmployees() {
		
	
		
		//System.out.println("Mitarbeiternummer: " + employeeNumber + ", Mitarbeitername: " + employeeName + ", Einstellungsdatum: " + dateOfEmployment);
	}
	
	
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public LocalDate getDateOfEmployment() {
		return dateOfEmployment;
	}

	public void setDateOfEmployment(LocalDate dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
	}
	
	
	
}
