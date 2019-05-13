package models;

import sun.util.calendar.LocalGregorianCalendar.Date;

public class Purchase {

	private int purchaseNumber;
	private Date purchaseDate;
	private double purchasePrice;
	
	public Purchase (int purchaseNumber, Date purchaseDate, double purchasePrice) {
		this.purchaseNumber = purchaseNumber;
		this.purchaseDate = purchaseDate;
		this.purchasePrice = purchasePrice;
	}

	public int getPurchaseNumber() {
		return purchaseNumber;
	}

	public void setPurchaseNumber(int purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	
}
