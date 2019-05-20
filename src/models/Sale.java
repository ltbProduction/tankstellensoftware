package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Sale {
	
	private int saleNumber;
	private LocalDate saleDate;
	private double salePrice;
	
	public Sale (int saleNumber, LocalDate saleDate, double salePrice) {
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

	public LocalDate getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	
	public String displaytextfile() {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
	String text = String.valueOf(saleNumber)+";"+saleDate.format(formatter)+";"+String.valueOf(salePrice);
	return text;
	}
	

}
