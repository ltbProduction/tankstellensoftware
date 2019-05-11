package models;

import sun.util.calendar.LocalGregorianCalendar.Date;

public class Sales {
	
	private int saleNumber;
	private Date saleDate;
	private double salePrice;
	
	public Sales (int saleNumber, Date saleDate, double salePrice) {
		this.saleNumber = saleNumber;
		this.saleDate = saleDate;
		this.salePrice = salePrice;
	}

	public int getSaleNumber() {
		return saleNumber;
	}

	public void setSaleNumber(int saleNumber) {
		this.saleNumber = saleNumber;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	
	

}
