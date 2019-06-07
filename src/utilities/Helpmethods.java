package utilities;

import models.GasStation;
import models.Purchase;
import models.Sale;

/**
 * @author Linus Brugger Die Klasse Helpmethod wird benoetigt, wenn die es eine
 *         Lieferung eine Nummer zugewiesen werden muss bzw. wenn der Beleg
 *         seine Nummer erhalten soll.
 */
public class Helpmethods {

	public static int newdeliveriesnumber() {
		// Number des letzten Einkauf auslesen
		int number;
		int size;
		Purchase purchase;
		size = GasStation.getPurchases().size() - 1; // Die Zahl wo man das Letze findet
		if (size == -1) { // Wenn es noch keine Lieferung gibt
			return 1;
		} else { // Sonst die letzte Lieferung + 1
			purchase = GasStation.getPurchases().get(size);
			number = purchase.getPurchaseNumber() + 1;
			return number;
		}

	}

	public static int newsalesnumber() {
		// Number des letzten Einkauf auslesen
		int number;
		int size;
		Sale sales;
		size = GasStation.getSales().size() - 1; // Die Zahl wo man das Letze findet
		if (size == -1) { // Wenn es noch keinen Beleg gibt
			return 1;
		} else { // Sonst der letzte Beleg + 1
			sales = GasStation.getSales().get(size);
			number = sales.getSaleNumber() + 1;
			return number;
		}
	}
}
