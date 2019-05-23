package models;

import java.text.DecimalFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Purchase {

	private int purchaseNumber;
	private LocalDate purchaseDate;
	private double purchasePrice;
	
	public Purchase (int purchaseNumber, LocalDate date, double purchasePrice) {
		this.purchaseNumber = purchaseNumber;
		this.purchaseDate = date;
		this.purchasePrice = purchasePrice;
	}

	public int getPurchaseNumber() {
		return purchaseNumber;
	}

	public void setPurchaseNumber(int purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	//Test Linus 
	public void display(){
		System.out.println(purchaseNumber);
		System.out.println(purchaseDate);
		System.out.println(purchasePrice);
		System.out.println();
	}
	
	//Die korrekte Ausgabe für die Textdatei wird erzeugt
		public String displaytextfile() {
		//Das passende Format für die Ausgabe
		DecimalFormat df = new DecimalFormat("#,00");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
		String text = String.valueOf(purchaseNumber)+";"+purchaseDate.format(formatter)+";"+df.format(purchasePrice);
		return text;
		}
	
}
