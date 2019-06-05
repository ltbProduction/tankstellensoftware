package models;

import java.io.File;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import utilities.FileSetter;

/**
 * @author Lukas Blunck, Robin Birkhofer, Linus Brugger
 *
 */
public class GasStation {

	// Name der Tankstelle
	private static String gasStationName = "Tankstelle Kloesterle"; // Name der Tankstelle
	// Liste mit allen Mitarbeitern
	private static ObservableList<Employee> employees = FXCollections.observableArrayList();
	// Liste mit Waren im Warenkorb fuer "Waren hinzufuegen"-Fenster
	private static ObservableList<Good> shoppingCartGoods = FXCollections.observableArrayList();
	// Liste mit Produkten (Waren + Kraftstoff) im Warenkorb
	private static ObservableList<Product> shoppingCart = FXCollections.observableArrayList();
	// Liste mit allen Kraftstofftanks
	private static ObservableList<Fuel> fuels = FXCollections.observableArrayList();
	// Liste mit allen Waren
	private static ObservableList<Good> goods = FXCollections.observableArrayList();
	// Liste mit allen Verkaeufen im Zeitraum der Bilanz (alle Verkaeufe wenn kein Zeitraum angegeben)
	private static ObservableList<Sale> balanceSales = FXCollections.observableArrayList();
	// Liste mit allen Verkaeufen
	private static ObservableList<Sale> sales = FXCollections.observableArrayList();
	// Liste mit allen Einkaeufen im Zeitraum der Bilanz (alle Einkaeufe wenn kein Zeitraum angegeben)
	private static ObservableList<Purchase> balancePurchases = FXCollections.observableArrayList();
	// Liste mit allen Einkaeufen
	private static ObservableList<Purchase> purchases = FXCollections.observableArrayList();
	// Liste mit allen Bestellten Waren
	private static ObservableList<Good> orderGood = FXCollections.observableArrayList();
	// Liste mit allen Bestellten Kraftstofftanks
	private static ObservableList<Fuel> orderFuel = FXCollections.observableArrayList();

	// Hinzufuegen von neuen Mitarbeitern.
	public static void addEmployee(String employeeName, LocalDate dateOfEmployment) {

		int indexlastmember = (getEmployees().size()) - 1;
		int employeeNumber = employees.get(indexlastmember).getEmployeeNumber() + 1;
		Employee employee = new Employee(employeeNumber, employeeName, dateOfEmployment);
		employees.add(employee);

	}

	// Hinzufuegen von Kraftstoff zum Warenkorb
	public static boolean addFuelToShoppingCart(String name, double amount) {

		boolean value = false;

		// Ueberpruefe, ob es einen Kraftstofftank der angegebenen Kraftstoffart gibt,
		// der genuegend Kraftstoff beinhaltet. Sobald ein Tank mit genuegend Kraftstoff
		// gefunden wird, wird die Rueckgabe-Variable auf true gesetzt.
		// Ausserdem wird der Index des gefundenen Kraftstofftanks gespeichert.
		int i = 0;
		for (Fuel f : fuels) {
			if (f.getName().equals(name)) {
				i = fuels.indexOf(f);
				if (amount < (f.getAmount())) {
					value = true;
				}
			}
		}

		// Wenn kein Tank mit ausreichendem Fuellstand gefunden wurde wird false
		// zurueckgegeben.
		if (value == false) {
			return value;

			// Ansonsten wird die Methode weitergefuehrt
		} else {

			// Die gewuenschte Menge wird vom Kraftstofftank abgezogen.
			fuels.get(i).setAmount(fuels.get(i).getAmount() - amount);

			// Es wird ein neues Kraftstoff-Produkt mit den Werten des Kraftstofftanks und
			// der gewuenschten Menge instanziiert.
			Fuel f = new Fuel(fuels.get(i).getNumber(), name, amount, fuels.get(i).getPurchasePrice(),
					fuels.get(i).getSalePrice());

			// Anschliessend wird es dem Warenkorb hinzugefuegt.
			shoppingCart.add(f);

			// Aktualisieren der Liste Fuels (Workaround, da Tabellenspalten sich nicht
			// autom. aktualisieren)
			FXCollections.copy(fuels, fuels);

			// Es wird true zurueckgegeben, da der Kraftstoff erfolgreich dem Warenkorb
			// hinzugefuegt wurde.
			return value;

		}

	}

	// Hinzufuegen von Waren zum Warenkorb
	public static boolean addGoodToShoppingCart(int goodnumber, double amount) {

		// Attribute initialisieren
		boolean value = true;
		int i = 0;

		// Ueberpruefe fuer jede Ware, ob Sie der eingegebenen Nummer entspricht
		// Wenn ja, setze i gleich dem Index der Ware
		for (Good g : GasStation.getGoods()) {
			if (g.getNumber() == goodnumber) {
				i = goods.indexOf(g);
				break;
			}

		}

		// Wenn die gewuenschte Menge groesser ist als die Gesamtmenge der Ware
		// gebe den Rueckgabewert false zurueck
		if (amount > (goods.get(i)).getAmount()) {

			return value = false;

			// Ansonsten wird die Methode weitergefuehrt
		} else {

			// Die gewuenschte Menge wird vom Warenbestand abgezogen.
			goods.get(i).setAmount(goods.get(i).getAmount() - amount);
			// Es wird ein neues Waren-Produkt mit den Werten der Ware und
			// der gewuenschten Menge instanziiert.
			Good g = new Good(goodnumber, goods.get(i).getName(), goods.get(i).getUnit(), amount,
					goods.get(i).getPurchasePrice(), goods.get(i).getSalePrice());

			// Hinzufuegen zur Liste der gewaehlten Waren
			shoppingCartGoods.add(g);
			// Hinzufuegen zur Liste des gesamten Warenkorbs
			shoppingCart.add(g);

			// Aktualisieren der Liste Goods (Workaround, da Tabellenspalten sich nicht
			// autom. aktualisieren)
			FXCollections.copy(goods, goods);
			
			// Es wird true zurueckgegeben, da die Ware erfolgreich dem Warenkorb
			// hinzugefuegt wurde.
			return value;

		}

		 
	

	}

	// Rueckgabe des Gesamtbetrags des Warenkorbs, fuer Labels
	public static double getTotalPrice() {
		double totalPrice = 0;
		// fuer jedes Produkt im Warenkorb
		for (Product p : shoppingCart) {
			// Gesamtbetrag um Preis des Produkt erhoehen
			totalPrice += p.getTotalSalePrice();
		}

		// Runden auf zwei Nachkommastellen
		totalPrice = Math.round(100.0 * totalPrice) / 100.0;
		return totalPrice;
	}

	// Rueckgabe aller Waren im Warenkorb (Anzeige im Waren hinzufuegen Fenster)
	public static ObservableList<Good> getShoppingCartGoods() {
		return shoppingCartGoods;
	}

	public static void finishedreceipt(File file, int salenumber) { // Zum abschliessen einer Reception
		
		double sum;
		sum = 0;
		for (Product p : GasStation.getShoppingCart()) {
			sum += p.amount * p.salePrice;
		}
		// Methode welche den Beleg ausdruckt
		sum = Math.round(100.0 * sum) / 100.0;
		FileSetter.createreceipt(sum, file);
		shoppingCart.clear();
		sales.add(new Sale(salenumber, LocalDate.now(), sum));

	}
	
	// Rueckgabe des Namens der Tankstelle
	public static String getGasStationName() {
		return gasStationName;
	}
	
	// Rueckgabe aller Mitarbeiter
	public static ObservableList<Employee> getEmployees() {
		return employees;
	}

	// Rueckgabe des Warenkorbs
	public static ObservableList<Product> getShoppingCart() {
		return shoppingCart;
	}

	// Rueckgabe der Kraftstofftanks
	public static ObservableList<Fuel> getFuels() {
		return fuels;
	}

	// Rueckgabe der Waren im Bestand 
	public static ObservableList<Good> getGoods() {
		return goods;
	}

	// Rueckgabe aller Verkaeufe
	public static ObservableList<Sale> getSales() {
		return sales;
	}

	// Rueckgabe aller Einkaeufe
	public static ObservableList<Purchase> getPurchases() {
		return purchases;
	}

	// Rueckgabe der bestellten Waren
	public static ObservableList<Good> getOrderGood() {
		return orderGood;
	}

	// Rueckgabe der bestellten Kraftstoffe
	public static ObservableList<Fuel> getOrderFuel() {
		return orderFuel;
	}

	// Rueckgabe der Verkaeufe fuer Bilanz 
	public static ObservableList<Sale> getBalanceSales() {
		return balanceSales;
	}

	// Einstellen der Verkaeufe fuer Bilanz
	public static void setBalanceSales(ObservableList<Sale> balanceSales) {
		GasStation.balanceSales = balanceSales;
	}

	// Rueckgabe der Einkaeufe fuer Bilanz 
	public static ObservableList<Purchase> getBalancePurchases() {
		return balancePurchases;
	}

	// Pruefen, welcher Mitarbeiter aktiv ist
	public static Employee activeEmployee() {
		
		Employee activeemployee;
		activeemployee = null;

		for (Employee e : employees) {
			if (e.isActive()) {
				activeemployee = e;
			} else {
				continue;
			}
		}
		return activeemployee;
	}

	// Einstellen des aktiven Mitarbeiters
	public static boolean setCurrentEmployee(int number) {
		for (Employee e : employees) {
			if (e.getEmployeeNumber() == number) {
				e.setActive(true);
				return true;
			} else
				continue;

		}
		return false;
	}

	// Methode ueberprueft ob eine vorhandene Mitarbeiternummer eingegeben wird beim Login
	public static boolean existingEmployee(int number) {
		boolean value = false;
		for (Employee e : employees) {
			if (e.getEmployeeNumber() == number) {
				value = true;
				break;
			} else {
				value = false;
			}
		}
		return value;
	}

	// Ueberpruefen, ob angegebene Warennummer existiert
	public static boolean existingGood(int number) {
		boolean value = false;
		for (Good g : goods) {
			if (g.getNumber() == number) {
				value = true;
				break;
			} else {
				value = false;

			}
		}
		return value;
	}

	//Gibt die aktuelle Ampeldarstellung in Abhaengigkeit des Fuellstands an
	public static Image getTrafficLight(int fueltype) {

		Image image = null;
		double value = GasStation.getFuels().get(fueltype).getAmount()
				/ GasStation.getFuels().get(fueltype).getCapacity();

		if (value > 0.5) {
			image = new Image("/resource/traffic light/traffic_light_green.PNG");
		} else if (value > 0.25) {
			image = new Image("/resource/traffic light/traffic_light_yellow.PNG");
		} else if (value >= 0.0) {
			image = new Image("/resource/traffic light/traffic_light_red.PNG");
		}
		return image;
	}

	// aendert Preis des Kraftstoffs
	public static void changePriceOfFuel(String fueltype, double newPrice) {

		for (Fuel f : GasStation.getFuels()) {
			if (fueltype.equals(f.getName())) {
				f.setSalePrice(newPrice);
			}
			continue;
		}
		// Aktualisieren der Liste Fuels (Workaround, da Tabellenspalten sich nicht
		// autom. aktualisieren)
		FXCollections.copy(fuels, fuels);
	}

	// Fuegt Waren-Bestellung hinzu
	public static void addGoodOrder(int number, double amount) {
		for (Good g : goods) {
			if (g.getNumber() == number) {
				Good o = new Good(number, g.getName(), g.getUnit(), amount, 0, 0);
				o.setAmount(amount);
				orderGood.add(o);
			}
			// aktualisiert die Liste
			FXCollections.copy(orderGood, orderGood);

		}

	}

	// Fuegt Kraftstoff-Bestellung hinzu
	public static void addFuelOrder(String fueltype, double amount) {
		for (Fuel f : fuels) {
			if (f.getName().equals(fueltype)) {
				Fuel o = new Fuel(f.getNumber(), f.getName(), amount, 0, 0);
				orderFuel.add(o);

			}
			// aktualisiert die Liste
			FXCollections.copy(orderFuel, orderFuel);
		}

	}

	// aendert Warenpreis
	public static void changePriceOfGood(String product, double newPrice) {

		for (Good g : GasStation.getGoods()) {
			if (product.equals(g.getName())) {
				g.setSalePrice(newPrice);
			}
			continue;
		}
		// Aktualisieren der Liste Fuels (Workaround, da Tabellenspalten sich nicht
		// autom. aktualisieren)
		FXCollections.copy(goods, goods);

	}

	// erstellt Bilanz initial
	public static void createHistory() {

		// Verkaeufe
		balanceSales.clear();
		for (Sale s : sales) {
			balanceSales.add(s);
		}

		balancePurchases.clear();
		for (Purchase p : purchases) {
			balancePurchases.add(p);
		}
	}
	
	// aendert Bilanz-Tabelle
	public static void changeBalanceTable(LocalDate startDate, LocalDate endDate) {
		LocalDate ds = startDate.minusDays(1);
		LocalDate df = endDate.plusDays(1);

		balanceSales.clear();
		for (Sale s : sales) {
			LocalDate sd = s.getSaleDate();
			if (sd.isAfter(ds) && sd.isBefore(df)) {
				balanceSales.add(s);
			} else {
				continue;
			}
		}
		FXCollections.copy(balanceSales, balanceSales);
		// Die Einkaeufe
		balancePurchases.clear();
		for (Purchase p : purchases) {
			LocalDate pd = p.getPurchaseDate();
			if (pd.isAfter(ds) && pd.isBefore(df)) {
				balancePurchases.add(p);
			} else {
				continue;
			}

		}
		FXCollections.copy(balancePurchases, balancePurchases);

	}
	
	public static double createFullSales() {
		double sum = 0;
		for (Sale s : balanceSales) {
			sum += s.getSalePrice();
		}
		sum = Math.round(sum * 100.0) / 100.0;
		return sum;
	}

	public static double createFullPurchases() {
		double sum = 0;
		for (Purchase p : balancePurchases) {
			sum += p.getPurchasePrice();
		}
		sum = Math.round(sum * 100.0) / 100.0;

		return sum;
	}

}
