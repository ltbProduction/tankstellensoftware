package models;

/**
 * @author Lukas Blunck, Robin Birkhofer, Linus Brugger
 *
 */

public class Good extends Product {

	// Konstruktor
	public Good(int number, String name, String unit, double amount, double purchasePrice, double salePrice) {
		super(number, name, unit, amount, purchasePrice, salePrice);
	}

	
	public static int getIndex(int numberOfGood) {

		// Methode, die den Listen-Index einer Ware mit angegebener
		// Warennummer zurückgibt.
		int i = 0;

		for (Good g : GasStation.getGoods()) {
			if (g.getNumber() == numberOfGood) {
				i = GasStation.getGoods().indexOf(g);
			} else
				continue;
		}

		return i;

	}

	// Die korrekte Ausgabe für die Textdatei wird erzeugt
	public String displaytextfile() {
		String text = String.valueOf(number) + ";" + name + ";" + unit + ";" + String.valueOf(amount) + ";"
				+ String.valueOf(purchasePrice) + ";" + String.valueOf(salePrice);
		return text;
	}

}
