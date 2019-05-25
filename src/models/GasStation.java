package models;

import java.io.File;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import sun.util.calendar.LocalGregorianCalendar.Date;
import utilities.FileSetter;
import utilities.FileTransfer;
import utilities.helpmethod;

public class GasStation {

	private static String gasStationName = "Tankstelle Klösterle"; // Name der Tankstelle
	// Liste mit allen Mitarbeitern
	private static ObservableList<Employee> employees = FXCollections.observableArrayList();
	// Liste mit allen Produkten
	private static ObservableList<Product> storage = FXCollections.observableArrayList();
	// Liste mit Waren im Warenkorb für "Waren hinzufügen"-Fenster
	private static ObservableList<Good> shoppingCartGoods = FXCollections.observableArrayList();
	// Liste mit Produkten (Waren + Kraftstoff) im Warenkorb
	private static ObservableList<Product> shoppingCart = FXCollections.observableArrayList();
	// Liste mit allen Kraftstofftanks
	private static ObservableList<Fuel> fuels = FXCollections.observableArrayList();
	// Liste mit allen Waren
	private static ObservableList<Good> goods = FXCollections.observableArrayList();
	// Liste mit allen Verkäufen
	private static ObservableList<Sale> sales = FXCollections.observableArrayList();
	// Liste mit allen Einkäufen
	private static ObservableList<Purchase> purchases = FXCollections.observableArrayList();
	private static LocalDate startBalanceDate; // Startdatum Bilanz
	private static LocalDate endBalanceDate; // Enddatum Bilanz

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

		// Überprüfe, ob es einen Kraftstofftank der angegebenen Kraftstoffart gibt,
		// der genügend Kraftstoff beinhaltet. Es wird ein Puffer von 100 Litern
		// eingebaut. Sobald ein Tank mit genügend Kraftstoff gefunden wird, wird die
		// Rückgabe-Variable auf true gesetzt.
		// Außerdem wird der Index des gefundenen Kraftstofftanks gespeichert.
		int i = 0;
		for (Fuel f : fuels) {
			if (f.getName().equals(name)) {
				i = fuels.indexOf(f);
				if (amount < (f.getAmount() - 100)) {
					value = true;
				}
			}
		}

		// Wenn kein Tank mit ausreichendem Füllstand gefunden wurde, wird die Methode
		// abgebrochen und eine Fehlermeldung zurückgegeben.
		if (value == false) {
			return value;

			// Ansonsten wird die Methode weitergeführt
		} else {

			// Die gewünschte Menge wird vom Kraftstofftank abgezogen.
			// Es wird ein neues Kraftstoff-Produkt mit den Werten des Kraftstofftanks und
			// der gewünschten Menge instanziiert. Anschließend wird es dem Warenkorb
			// hinzugefügt. Da die Klasse Fuel von Product erbt, kann das neue Produkt in
			// die shoppingCart-Liste der Klasse Product hinzugefügt werden.
			fuels.get(i).setAmount(fuels.get(i).getAmount()-amount);
			fuels.get(i).displayFuel();
			
			
			Fuel f = new Fuel(fuels.get(i).getNumber(), name, amount, fuels.get(i).getPurchasePrice(),
					fuels.get(i).getSalePrice());

			shoppingCart.add(f);
			
			// Aktualisieren der Liste Fuels (Workaround, da Tabellenspalten sich nicht autom. aktualisieren)
			FXCollections.copy(fuels, fuels);

						

			// Es wird zurückgegeben, dass der Kraftstoff erfolgreich dem Warenkorb
			// hinzugefügt wurde.
			return value;

		}

	}

	public static boolean addGoodToShoppingCart(int goodnumber, double amount) {

		boolean value = false;

		// Überprüfe, ob es eine Ware mit der angegebenen Warennummer gibt, die in
		// ausreichender Menge vorhanden ist. Sobald eine Ware gefunden wird, wird die
		// Rückgabe-Variable auf true gesetzt. Außerdem wird der Index der gefundenen
		// Ware gespeichert.
		int i = 0;
		for (Good g : goods) {
			if (g.getNumber() == goodnumber) {
				i = goods.indexOf(g);
				if (amount < (g.getAmount())) {
					value = true;
				}
			}

		}

		// Wenn keine Ware mit ausreichendem Bestand gefunden wurde, wird die Methode
		// abgebrochen und eine Fehlermeldung zurückgegeben.
		if (value == false) {
			return value;

			// Ansonsten wird die Methode weitergeführt
		} else {

			// Die gewünschte Menge wird vom Warenbestand abgezogen.
			// Es wird ein neues Waren-Produkt mit den Werten der Ware und
			// der gewünschten Menge instanziiert. Anschließend wird es dem Warenkorb
			// hinzugefügt. Da die Klasse Good von Product erbt, kann das neue Produkt in
			// die shoppingCart-Liste der Klasse Product hinzugefügt werden.
			goods.get(i).setAmount(goods.get(i).getAmount()-amount);
			
			Good g = new Good(goodnumber, goods.get(i).getName(), goods.get(i).getUnit(), amount,
					goods.get(i).getPurchasePrice(), goods.get(i).getSalePrice());

			shoppingCartGoods.add(g); // Liste zur Anzeige der gewählten Waren im "Waren hinzufügen"-Fenster
			shoppingCart.add(g);
			
			// Aktualisieren der Liste Fuels (Workaround, da Tabellenspalten sich nicht autom. aktualisieren)
			FXCollections.copy(fuels, fuels);

		}

		// Es wird zurückgegeben, dass der Kraftstoff erfolgreich dem Warenkorb
		// hinzugefügt wurde.
		return value;

	}
	
	public static double getTotalPrice() {
		double totalPrice = 0;
		for (Product p : shoppingCart) {
			totalPrice += p.getTotalSalePrice();
		}
		
		totalPrice = Math.round(100.0*totalPrice)/100.0;
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

	// writeCurrentData speichert die Ã¯Â¿Â½nderbaren Daten
	public static void writeCurrentData() {

	}

	public static void createHistory() {

	}

	public static void calculateBalance(Date startBalanceDate, Date endBalaceDate) {

	}



	public static void finishedreceipt(File file) { // Zum abschlieÃ¯Â¿Â½en einer Reception
		double sum;
		sum = 0;
		for (Product p : GasStation.getShoppingCart()) {
			sum += p.amount * p.salePrice;
		}
		// Methode welche den Beleg ausdruckt
		sum = Math.round(100.0*sum)/100.0;
		FileSetter.createreceipt(sum, file);
		shoppingCart.clear();
		sales.add(new Sale(helpmethod.newsalesnumber(), LocalDate.now(), sum));
	}

	public static String getGasStationName() {
		return gasStationName;
	}

	public static void setGasStationName(String gasStationName) {
		GasStation.gasStationName = gasStationName;
	}

	// Methode die ObservableList von Mitarbeitern zurÃ¯Â¿Â½ckgibt
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

	public static LocalDate getStartBalanceDate() {
		return startBalanceDate;
	}

	public static void setStartBalanceDate(LocalDate startBalanceDate) {
		GasStation.startBalanceDate = startBalanceDate;
	}

	public static LocalDate getEndBalanceDate() {
		return endBalanceDate;
	}

	public static void setEndBalanceDate(LocalDate endBalanceDate) {
		GasStation.endBalanceDate = endBalanceDate;
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

//Methode überprüft ob eine vorhandene Mitarbeiternummer eingegeben wird beim Login
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

//Gibt die aktuelle Ampeldarstellung in Abhängigkeit des Füllstands an
public static Image getTrafficLight(int fueltype) {
	
	
	Image image = null;
	  double value = fuels.get(fueltype).getAmount()/GasStation.getFuels().get(fueltype).getCapacity();	
	if(value > 0.5) {
		image = new Image("/resource/traffic light/traffic_light_green.PNG");		
	} else if(value > 0.25) {
		image = new Image("/resource/traffic light/traffic_light_yellow.PNG");		
	} else if(value >= 0.0) {
		image = new Image("/resource/traffic light/traffic_light_red.PNG");		
	}
	return image;
}

	


//Methode Ã¼berprÃ¼ft ob eine vorhandene Mitarbeiternummer eingegeben wird beim Login
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

//Gibt die aktuelle Ampeldarstellung in AbhÃ¤ngigkeit des FÃ¼llstands an
	public static Image getTrafficLight(int fueltype) {

		Image image = null;
		double value = GasStation.getFuels().get(fueltype).getAmount()
				/ GasStation.getFuels().get(fueltype).getCapacity();
		System.out.println(value);
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
		if(fueltype.equals(f.getName())) {
			f.setSalePrice(newPrice);
		}continue;
	}
	FileTransfer.refresh();
}

public static void changePriceOfGood(String product, double newPrice) {

	for (Good g : GasStation.getGoods()) {
		if(product.equals(g.getName())) {
			g.setSalePrice(newPrice);
		}continue;
	}
	FileTransfer.refresh();
}
	
}




