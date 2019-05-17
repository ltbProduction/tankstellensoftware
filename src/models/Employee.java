package models;

import java.util.Date;
  

public class Employee {


	private String employeeName;
	private int employeeNumber = 000;
	private Date dateOfEmployment;
	
	
	//Ich habe den boolean entfernt. Weil es nicht dahin gehört
	public Employee(String employeeName, Date dateOfEmployment) {
		this.employeeName = employeeName;
		this.employeeNumber +=1;
		this.dateOfEmployment = dateOfEmployment;
	}
	
	

	public void displayEmployee() {
		System.out.println(dateOfEmployment);
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
