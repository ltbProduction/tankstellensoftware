package models;

import java.util.Date;
  

public class Employee {

	private boolean isActive;
	private String employeeName;
	private int employeeNumber;
	private Date dateOfEmployment;
	
	
	//Ich habe den boolean entfernt. Weil es nicht dahin gehört
	public Employee(String employeeName, int employeeNumber, Date dateOfEmployment) {
		this.employeeName = employeeName;
		this.employeeNumber = employeeNumber;
		this.dateOfEmployment = dateOfEmployment;
	}
	
	

	public void displayEmployee() {
		System.out.println(dateOfEmployment);
	}
	
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
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

	public Date getDateOfEmployment() {
		return dateOfEmployment;
	}

	public void setDateOfEmployment(Date dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
	}
	
	
	
}
