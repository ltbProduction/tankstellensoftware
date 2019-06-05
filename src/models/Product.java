package models;

/**
 * @author Lukas Blunck, Robin Birkhofer, Linus Brugger
 *
 */

public abstract class Product {

	// Nummer
	protected int number;
	// Name/Bezeichnung
	protected String name;
	// Menge
	protected double amount;
	// Lagereinheit (Bei Kraftstoff: Liter)
	protected String unit;
	// Einkaufspreis
	protected double purchasePrice;
	// Verkaufspreis pro Einheit
	protected double salePrice;
	// Gesamtpreis im Verkauf
	protected double totalSalePrice;

	// Konstruktor
	public Product(int number, String name, String unit, double amount, double purchasePrice, double salePrice) {
		
		this.number = number;
		this.name = name;
		this.amount = amount;
		this.unit = unit;
		this.purchasePrice = purchasePrice;
		this.salePrice = salePrice;
		// Runden des Gesamtpreises
		totalSalePrice = Math.round(100.0 * (amount * salePrice)) / 100.0;

	}



	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double price) {
		this.salePrice = price;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public double getTotalSalePrice() {
		return totalSalePrice;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	// Zur Ausgabe fuer Beleg
	public String displayreceipt() {
		String text;
		text = name + " - " + String.valueOf(amount) + " " + unit + " - " + String.valueOf(salePrice) + " EUR/" + unit
				+ " - " + String.valueOf(amount * salePrice) + " EUR";
		return text;
	}

}
