package models;

import java.io.File;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import utilities.FileSetter;

/**
 * @author Lukas Blunck, Robin Birkhofer, Linus Brugger
 *
 */
public class GasStation {

	private static String gasStationName = "Tankstelle Kloesterle"; // Name der Tankstelle
	// Liste mit allen Mitarbeitern
	private static ObservableList<Employee> employees = FXCollections.observableArrayList();
	// Liste mit allen Produkten
	private static ObservableList<Product> storage = FXCollections.observableArrayList();
	// Liste mit Waren im Warenkorb fuer "Waren hinzufuegen"-Fenster
	private static ObservableList<Good> shoppingCartGoods = FXCollections.observableArrayList();
	// Liste mit Produkten (Waren + Kraftstoff) im Warenkorb
	private static ObservableList<Product> shoppingCart = FXCollections.observableArrayList();
	// Liste mit allen Kraftstofftanks
	private static ObservableList<Fuel> fuels = FXCollections.observableArrayList();
	// Liste mit allen Waren
	private static ObservableList<Good> goods = FXCollections.observableArrayList();
	//Liste mit allen Verkaeufen für die Bilanz
	private static ObservableList<Sale> balanceSales = FXCollections.observableArrayList();	
	// Liste mit allen Verkaeufen	
	private static ObservableList<Sale> sales = FXCollections.observableArrayList();
	//Liste mit allen Einkaeufen für die Bilanz
	private static ObservableList<Purchase> balancePurchases = FXCollections.observableArrayList();	
	// Liste mit allen Einkaeufen
	private static ObservableList<Purchase> purchases = FXCollections.observableArrayList();

	//Liste mit allen Bestellten Waren
	private static ObservableList<Good> orderGood = FXCollections.observableArrayList();
	//Liste mit allen Bestellten Kraftstofftanks
	private static ObservableList<Fuel> orderFuel = FXCollections.observableArrayList();
//	private static LocalDate startBalanceDate; // Startdatum Bilanz
//	private static Date endBalanceDate; // Enddatum Bilanz

	public GasStation() {

	}

	public static void addEmployee(String employeeName, LocalDate dateOfEmployment) {
		int indexlastmember = (getEmployees().size()) - 1;
		int employeeNumber = employees.get(indexlastmember).getEmployeeNumber() + 1;
		Employee employee = new Employee(employeeNumber, employeeName, dateOfEmployment);
		employees.add(employee);
	}

	public static void addFuelTank(Fuel fuelTank) {
		fuels.add(fuelTank);
	}

	public static boolean addFuelToShoppingCart(String name, double amount) {

		boolean value = false;

		// Ueberpruefe, ob es einen Kraftstofftank der angegebenen Kraftstoffart gibt,
		// der genuegend Kraftstoff beinhaltet. Es wird ein Puffer von 100 Litern
		// eingebaut. Sobald ein Tank mit genuegend Kraftstoff gefunden wird, wird die
		// Rueckgabe-Variable auf true gesetzt.
		// Ausserdem wird der Index des gefundenen Kraftstofftanks gespeichert.
		int i = 0;
		for (Fuel f : fuels) {
			if (f.getName().equals(name)) {
				i = fuels.indexOf(f);
				if (amount < (f.getAmount() - 100)) {
					value = true;
				}
			}
		}

		// Wenn kein Tank mit ausreichendem Fuellstand gefunden wurde, wird die Methode
		// abgebrochen und eine Fehlermeldung zurueckgegeben.
		if (value == false) {
			return value;

			// Ansonsten wird die Methode weitergefuehrt
		} else {

			// Die gewuenschte Menge wird vom Kraftstofftank abgezogen.
			// Es wird ein neues Kraftstoff-Produkt mit den Werten des Kraftstofftanks und
			// der gewuenschten Menge instanziiert. Anschliessend wird es dem Warenkorb
			// hinzugefuegt. Da die Klasse Fuel von Product erbt, kann das neue Produkt in
			// die shoppingCart-Liste der Klasse Product hinzugefuegt werden.
			fuels.get(i).setAmount(fuels.get(i).getAmount() - amount);
			fuels.get(i).displayFuel();

			Fuel f = new Fuel(fuels.get(i).getNumber(), name, amount, fuels.get(i).getPurchasePrice(),
					fuels.get(i).getSalePrice());

			shoppingCart.add(f);

			// Aktualisieren der Liste Fuels (Workaround, da Tabellenspalten sich nicht
			// autom. aktualisieren)
			FXCollections.copy(fuels, fuels);

			// Es wird zurueckgegeben, dass der Kraftstoff erfolgreich dem Warenkorb
			// hinzugefuegt wurde.
			return value;

		}

	}

	public static boolean addGoodToShoppingCart(int goodnumber, double amount) {

		// Attribute initialisieren
		boolean value = true;
		boolean numberCheck = false;
		int i = 0;
		
		// Ueberpruefe fuer jede Ware, ob Sie der eingegebenen Nummer entspricht
		// Wenn ja, setze i gleich dem Index der Ware
		for (Good g : GasStation.getGoods()) {
			if (g.getNumber() == goodnumber) {
				i = goods.indexOf(g);
				numberCheck = true;
			}

		}

		// Wenn die eingegebene Nummer nicht gefunden werden konnte, gebe eine
		// Fehlermeldung aus. 
		if (numberCheck == false) {

			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warennumer falsch");
			alert.setHeaderText("Die eingegebene Warennummer ist falsch.");
			alert.setContentText("Bitte vergleichen Sie die eingegebene Warennummer mit dem Bestand.");
			alert.showAndWait();

		// Wenn die gewuenschte Menge groesser ist als die Gesamtmenge der Ware 
		// oder kleiner/gleich Null ist, gebe den Rueckgabewert false zurueck
		} else if (amount > (goods.get(i)).getAmount() || amount<=0) {
			
			return value = false;
		
			// Ansonsten wird die Methode weitergefuehrt
			} else {

				// Die gewuenschte Menge wird vom Warenbestand abgezogen.
				// Es wird ein neues Waren-Produkt mit den Werten der Ware und
				// der gewuenschten Menge instanziiert. Anschliessend wird es dem Warenkorb
				// hinzugefuegt.
				goods.get(i).setAmount(goods.get(i).getAmount() - amount);

				Good g = new Good(goodnumber, goods.get(i).getName(), goods.get(i).getUnit(), amount,
						goods.get(i).getPurchasePrice(), goods.get(i).getSalePrice());

				shoppingCartGoods.add(g); // Hinzufuegen zur Liste zur Anzeige der gewaehlten Waren im "Waren
											// hinzufuegen"-Fenster
				shoppingCart.add(g); // Hinzufuegen zur Liste des gesamten Warenkorbs

				// Aktualisieren der Liste Goods (Workaround, da Tabellenspalten sich nicht
				// autom. aktualisieren)
				FXCollections.copy(goods, goods);

			}
			
		return value;

		}
		
		

		

	

	public static double getTotalPrice() {
		double totalPrice = 0;
		for (Product p : shoppingCart) {
			totalPrice += p.getTotalSalePrice();
		}

		totalPrice = Math.round(100.0 * totalPrice) / 100.0;
		return totalPrice;
	}

	public static ObservableList<Good> getShoppingCartGoods() {
		return shoppingCartGoods;
	}

	public static void setShoppingCartGoods(ObservableList<Good> shoppingCartGoods) {
		GasStation.shoppingCartGoods = shoppingCartGoods;
	}

	public static void startGasStation() {

	}

	public static void scanDeliveries() {

	}

	public static void createSaleReceipt() {

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

	public static String getGasStationName() {
		return gasStationName;
	}

	public static void setGasStationName(String gasStationName) {
		GasStation.gasStationName = gasStationName;
	}

	// Methode die ObservableList von Mitarbeitern zuruckgibt
	public static ObservableList<Employee> getEmployees() {

		return employees;

	}

	public static void setEmployees(ObservableList<Employee> employees) {
		GasStation.employees = employees;
	}

	public static ObservableList<Product> getStorage() {
		return storage;
	}

	public static void setStorage(ObservableList<Product> storage) {
		GasStation.storage = storage;
	}

	public static ObservableList<Product> getShoppingCart() {
		return shoppingCart;
	}

	public static void setShoppingCart(ObservableList<Product> shoppingCart) {
		GasStation.shoppingCart = shoppingCart;
	}

	public static ObservableList<Fuel> getFuels() {
		return fuels;
	}

	public static void setFuels(ObservableList<Fuel> fuels) {
		GasStation.fuels = fuels;
	}

	public static ObservableList<Good> getGoods() {
		return goods;
	}

	public static void setGoods(ObservableList<Good> goods) {
		GasStation.goods = goods;
	}

	public static ObservableList<Sale> getSales() {
		return sales;
	}

	public static void setSales(ObservableList<Sale> sales) {
		GasStation.sales = sales;
	}

	public static ObservableList<Purchase> getPurchases() {
		return purchases;
	}

	public static void setPurchases(ObservableList<Purchase> purchases) {
		GasStation.purchases = purchases;
	}

//	public static LocalDate getStartBalanceDate() {
//		return startBalanceDate;
//	}
//
//	public static void setStartBalanceDate(LocalDate startBalanceDate) {
//		GasStation.startBalanceDate = startBalanceDate;
//	}
//
//	public static LocalDate getEndBalanceDate() {
//		return endBalanceDate;
//	}
//
//	public static void setEndBalanceDate(LocalDate endBalanceDate) {
//		GasStation.endBalanceDate = endBalanceDate;
//	}

	
	public static ObservableList<Good> getOrderGood() {
		return orderGood;
	}

	public static void setOrderGood(ObservableList<Good> orderGood) {
		GasStation.orderGood = orderGood;
	}

	public static ObservableList<Fuel> getOrderFuel() {
		return orderFuel;
	}

	public static void setOrderFuel(ObservableList<Fuel> orderFuel) {
		GasStation.orderFuel = orderFuel;
	}
	
	public static ObservableList<Sale> getBalanceSales() {
		return balanceSales;
	}

	public static void setBalanceSales(ObservableList<Sale> balanceSales) {
		GasStation.balanceSales = balanceSales;
	}

	public static ObservableList<Purchase> getBalancePurchases() {
		return balancePurchases;
	}

	public static void setBalancePurchases(ObservableList<Purchase> balancePurchases) {
		GasStation.balancePurchases = balancePurchases;
	}





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

//Methode Ueberprueft ob eine vorhandene Mitarbeiternummer eingegeben wird beim Login
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

public static void addFuelOrder(String fueltype, double amount) {
	for (Fuel f : fuels) {
	 if(f.getName().equals(fueltype)) {
		 Fuel o = new Fuel(f.getNumber(), f.getName(), amount, 0, 0);
		 orderFuel.add(o);
	
	 }
	 // aktualisiert die Liste
	 FXCollections.copy(orderFuel, orderFuel);
	}
	
}




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

	public static void createHistory() {
		
		
		//Verkaeufe
		balanceSales.clear();
		for (Sale s : sales) {
			balanceSales.add(s);
			}
		
		balancePurchases.clear();
		for (Purchase p : purchases) {
		balancePurchases.add(p);
		}
	}
	
	public static void changeBalanceTable (LocalDate startDate, LocalDate endDate) {
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
		//Die Einkaeufe
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
		sum = Math.round(sum*100.0)/100.0;
		return sum;
	}

	public static double createFullPurchases() {
		double sum = 0;
		for (Purchase p : balancePurchases) {
			sum += p.getPurchasePrice();
		}
		sum = Math.round(sum*100.0)/100.0;

		return sum;
	}

}
	

