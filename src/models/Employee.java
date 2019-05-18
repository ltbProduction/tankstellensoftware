package models;

import java.time.LocalDate;

 

public class Employee {


	private String employeeName;
	int employeeNumber;
	private LocalDate dateOfEmployment;
	
	
	
	public Employee(int employeeNumber, String employeeName, LocalDate dateOfEmployment) {
		this.employeeName = employeeName;
		this.employeeNumber = employeeNumber;
		this.dateOfEmployment = dateOfEmployment;
	}
	
	

	public void displayEmployees() {
		
		//System.out.println("Mitarbeiternummer: " + employeeNumber + ", Mitarbeitername: " + employeeName + ", Einstellungsdatum: " + dateOfEmployment);
	}
	
	
	public String getEmployeeName() {
		return employeeName;
	}

	public final void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public final void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public LocalDate getDateOfEmployment() {
		return dateOfEmployment;
	}

	public final void setDateOfEmployment(LocalDate dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
	}
	
	
	
}
