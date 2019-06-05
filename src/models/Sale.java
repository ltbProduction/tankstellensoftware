package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Linus Brugger
 *
 */

public class Sale {

	// Nummer des Verkaufs
	private int saleNumber;
	// Datum
	private LocalDate saleDate;
	// Betrag
	private double salePrice;

	public Sale(int saleNumber, LocalDate saleDate, double salePrice) {
		this.saleNumber = saleNumber;
		this.saleDate = saleDate;
		this.salePrice = salePrice;
	}

	public int getSaleNumber() {
		return saleNumber;
	}

	public LocalDate getSaleDate() {
		return saleDate;
	}

	public double getSalePrice() {
		return salePrice;
	}

	// Ausgabe fuer Textdatei
	public String displaytextfile() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
		String text = String.valueOf(saleNumber) + ";" + saleDate.format(formatter) + ";" + String.valueOf(salePrice);
		return text;
	}

}