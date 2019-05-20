package utilities;

import models.GasStation;
import models.Purchase;
import models.Sale;

public class HelpMethods {

	public static int newdeliveriesnumber() {
		//Number des letzten einkauf auslesen
		int number;
		int size;
		Purchase purchase;
		size = GasStation.getPurchases().size()-1; //Die Zahl wo man das letze findet
		if (size == -1) { //Wenn es noch keinen Beleg gibt
			return 1;
		} else { //Sonst der letzte Beleg + 1
			purchase = GasStation.getPurchases().get(size);
			number = purchase.getPurchaseNumber() +1;
			return number;
		 }
		
	
		}
		public static int newsalesnumber() {
			//Number des letzten einkauf auslesen
			int number;
			int size;
			Sale sales;
			size = GasStation.getSales().size()-1; //Die Zahl wo man das letze findet
			if (size == -1) { //Wenn es noch keinen Beleg gibt
				return 1;
			} else { //Sonst der letzte Beleg + 1
				sales = GasStation.getSales().get(size);
				number = sales.getSaleNumber() +1;
				return number;
			 }
		}
	}

