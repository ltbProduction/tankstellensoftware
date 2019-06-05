package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Lukas Blunck, Robin Birkhofer, Linus Brugger
 *
 */

public class Employee {

	// Name des Mitarbeiters
	private String employeeName;
	// Mitarbeiternummer
	private int employeeNumber;
	// Einstellungsdatum
	private LocalDate dateOfEmployment;
	// Zustand (eingeloggt?)
	private boolean isActive=false;
	
	// Konstruktor
	public Employee(int employeeNumber, String employeeName, LocalDate dateOfEmployment) {
		
		this.employeeName = employeeName;
		this.employeeNumber = employeeNumber;
		this.dateOfEmployment = dateOfEmployment;
		
	}
	
	// Rueckgabe des Namen
	public String getEmployeeName() {
		return employeeName;
	}

	// Rueckgabe der Mitarbeiternummer
	public int getEmployeeNumber() {
		return employeeNumber;
	}

	// Rueckgabe des Einstellungsdatums
	public LocalDate getDateOfEmployment() {
		return dateOfEmployment;
	}

	// Rueckgabe, ob Mitarbeiter aktiv ist
	public boolean isActive() {
		return isActive;
	}

	// Einstellen, dass Mitarbeiter aktiv ist
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	// Ausgabe fuer Textdatei
	public String displaytextfile() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
		String text = String.valueOf(employeeNumber)+";"+employeeName +";" + dateOfEmployment.format(formatter);
		return text;
	}
	
	
	
}
