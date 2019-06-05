package models;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @author Linus Brugger
 *
 */

public class Purchase {

	// Nummer des Einkaufs
	private int purchaseNumber;
	// Datum
	private LocalDate purchaseDate;
	// Betrag
	private double purchasePrice;

	// Konstruktor
	public Purchase(int purchaseNumber, LocalDate date, double purchasePrice) {
		this.purchaseNumber = purchaseNumber;
		this.purchaseDate = date;
		this.purchasePrice = purchasePrice;
	}

	public int getPurchaseNumber() {
		return purchaseNumber;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	// Die korrekte Ausgabe für die Textdatei wird erzeugt
	public String displaytextfile() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
		String text = String.valueOf(purchaseNumber) + ";" + purchaseDate.format(formatter) + ";"
				+ String.valueOf(purchasePrice);
		return text;
	}

}