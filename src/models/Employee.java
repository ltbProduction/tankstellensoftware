package models;

import sun.util.calendar.LocalGregorianCalendar.Date;

public class Employee {

	private boolean isActive;
	private String employeeName;
	private int employeeNumber;
	private Date dateOfEmployment;
	
	public Employee(boolean isActive, String employeeName, int employeeNumber, Date dateOfEmployment) {
		this.isActive = isActive;
		this.employeeName = employeeName;
		this.employeeNumber = employeeNumber;
		this.dateOfEmployment = dateOfEmployment;
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
