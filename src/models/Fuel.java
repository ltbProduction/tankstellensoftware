package models;

/**
 * @author Lukas Blunck, Robin Birkhofer, Linus Brugger
 *
 */

public class Fuel extends Product {

	// Kapazitaet des Kraftstofftanks
	private double capacity;

	//Konstruktor
	public Fuel(int number, String name, double amount, double purchasePrice, double salePrice) {

		super(number, name, "Liter", amount, purchasePrice, salePrice);

	}

	// Rueckgabe der Kapazitaet
	public double getCapacity() {
		return capacity;
	}

	// Einstellen der Kapazitaet
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	// Ausgabe fuer Textdate
	public String displaytextfile() {
		String text = String.valueOf(number) + ";" + getName() + ";" + String.valueOf(amount) + ";"
				+ String.valueOf(capacity) + ";" + String.valueOf(purchasePrice) + ";" + String.valueOf(salePrice);
		return text;
	}

	// Methode, die den Listen-Index eines Kraftstofftanks mit angegebener
	// Kraftstoffart zurückgibt.
	public static int getIndex(String fueltype) {

		int i = 0;

		for (Fuel f : GasStation.getFuels()) {
			if (f.getName().equals(fueltype)) {
				i = GasStation.getFuels().indexOf(f);
			} else
				continue;
		}

		return i;

	}


}