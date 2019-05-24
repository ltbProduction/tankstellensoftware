package models;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import sun.util.calendar.LocalGregorianCalendar.Date;
import utilities.FileSetter;
import utilities.helpmethod;

public class GasStation {

	private static String gasStationName = "Tankstelle Kl�sterle"; // Name der Tankstelle
	private static ObservableList<Employee> employees = FXCollections.observableArrayList(); // Liste mit allen
																								// Mitarbeitern
	private static ObservableList<Product> storage = FXCollections.observableArrayList(); // Liste mit allen Produkte
	private static ObservableList<Good> shoppingCartGoods = FXCollections.observableArrayList(); // Liste mit Waren im
																									// Warenkorb
	private static ObservableList<Product> shoppingCart = FXCollections.observableArrayList(); // Liste mit Produkten
																								// (Waren + Kraftstoff)
																								// im Warenkorb
	private static ObservableList<Fuel> fuels = FXCollections.observableArrayList(); // Liste mit allen
																								// Kraftstofftanks
	private static ObservableList<Good> goods = FXCollections.observableArrayList(); // Liste mit allen Waren
	private static ObservableList<Sale> sales = FXCollections.observableArrayList(); // Liste mit allen Verkï¿½ufen
	private static ObservableList<Purchase> purchases = FXCollections.observableArrayList(); // Liste mit allen
																								// Einkï¿½ufen
	private static Date startBalanceDate; // Startdatum
	private static Date endBalanceDate; // Enddatum

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

	public static void addFuelToShoppingCart(String name, double amount) {
		int i = 0;
		for (Fuel f : fuels) {
			if (f.getName().equals(name)) {
				i = fuels.indexOf(f);
			}
		}

		
		
		// Neues Tank-Produkt erstellen
		Fuel f = new Fuel(fuels.get(i).getNumber(), name, amount, fuels.get(i).getPurchasePrice(), fuels.get(i).getSalePrice());

		// Dem Warenkorb hinzufügen
		shoppingCart.add(f);
		
		

	}
	
	public static void finishPurchaseProcess() {
		
		
		
		for (Product p : shoppingCart) {							// Prüfe für jedes Produkt in shoppingCart
			if (p instanceof Fuel) {								// ob das Produkt ein Kraftstoffprodukt ist
				for (Fuel f : fuels) {								// Wenn ja, überprüfe für jeden Kraftstofftank
					if (f.getName().equals(p.getName())) {			// ob dessen Name gleich dem Name des Produkts ist (z.B. Diesel = Diesel)
						f.setAmount(f.getAmount()-p.getAmount());	// Wenn ja, setze den Füllstand auf die Differenz aus altem Füllstand und gekaufter Menge
					}
				}
			}
		}
		
		for (Product p : shoppingCart) {								// Prüfe für jedes Produkt im Warenkorb
			if (p instanceof Good) {									// ob das Produkt eine Ware ist
				for (Good g : goods) {									// Wenn ja, überprüfe für jede Ware im Warenlager
					if (g.getName().equals(p.getName())) {				// ob dessen Name gleich dem Name des Produkts ist (z.B. Wodka = Wodka)
						g.setAmount(g.getAmount()-p.getAmount());		// Wenn ja, setze die Menge auf die Differenz aus alter Menge und gekaufter Menge
					}
				}
			}
		}
		
		
		
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

	// writeCurrentData speichert die ï¿½nderbaren Daten
	public static void writeCurrentData() {

	}

	public static void createHistory() {

	}

	public static void calculateBalance(Date startBalanceDate, Date endBalaceDate) {

	}



	public static void finishedreceipt() { // Zum abschlieï¿½en einer Reception
		double sum;
		sum = 0;
		for (Product p : GasStation.getShoppingCart()) {
			sum += p.amount * p.salePrice;
		}
		// Methode welche den Beleg ausdruckt
		sum = Math.round(100.0*sum)/100.0;
		FileSetter.createreceipt(sum);
		shoppingCart.clear();
		sales.add(new Sale(helpmethod.newsalesnumber(), LocalDate.now(), sum));
	}

	public static String getGasStationName() {
		return gasStationName;
	}

	public static void setGasStationName(String gasStationName) {
		GasStation.gasStationName = gasStationName;
	}

	// Methode die ObservableList von Mitarbeitern zurï¿½ckgibt
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

	public static Date getStartBalanceDate() {
		return startBalanceDate;
	}

	public static void setStartBalanceDate(Date startBalanceDate) {
		GasStation.startBalanceDate = startBalanceDate;
	}

	public static Date getEndBalanceDate() {
		return endBalanceDate;
	}

	public static void setEndBalanceDate(Date endBalanceDate) {
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
			}else continue;
			
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
	  double value = GasStation.getFuels().get(fueltype).getAmount()/GasStation.getFuels().get(fueltype).getCapacity();
	System.out.println(value);	
	if(value > 0.5) {
		image = new Image("/resource/traffic light/traffic_light_green.PNG");		
	} else if(value > 0.25) {
		image = new Image("/resource/traffic light/traffic_light_yellow.PNG");		
	} else if(value >= 0.0) {
		image = new Image("/resource/traffic light/traffic_light_red.PNG");		
	}
	return image;
}


//Gibt die aktuelle Ampeldarstellung in Abhängigkeit des Füllstands von Super an
//public static Image getSuperTrafficLight() {
//	
//	Image image = null;
//	  double value = GasStation.getFuelTanks().get(1).getFuelLevel()/GasStation.getFuelTanks().get(1).getCapacity();
//		
//	if(value > 0.5) {
//		image = new Image("/resource/traffic light/traffic_light_green.PNG");		
//	} else if(value > 0.25) {
//		image = new Image("/resource/traffic light/traffic_light_yellow.PNG");		
//	} else if(value >= 0.0) {
//		image = new Image("/resource/traffic light/traffic_light_red.PNG");		
//	}
//	return image;
//}
}