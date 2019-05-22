package models;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sun.util.calendar.LocalGregorianCalendar.Date;
import utilities.FileSetter;
import utilities.helpmethod;

public class GasStation {

	private static String gasStationName; // Name der Tankstelle
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
		Fuel f = new Fuel(fuels.get(i).getNumber(), name, amount, amount, fuels.get(i).getPurchasePrice(), fuels.get(i).getSalePrice());

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

	// Test fï¿½r Linus
	public static void display() {
		for (Purchase g : purchases) {
			g.display();
		}

	}

	public static void finishedreceipt() { // Zum abschlieï¿½en einer Reception
		double sum;
		sum = 0;
		for (Product p : GasStation.getShoppingCart()) {
			sum += p.amount * p.salePrice;
		}
		// Methode welche den Beleg ausdruckt
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

}

// alt:
//private String name;
//private int numberofcustomers;
//private ArrayList<Goods> goods = new ArrayList<>();
//private ArrayList<Fuel> fuel = new ArrayList<>();
//
//
//
////Methoden 
//public GasStation(String name) {
//	this.name = name;
//}
//
//public void start() {
//	//Die Daten sollen ausgelesen werden.
//		// Die Bestandsdaten sollen ausgelegt werden
//		// Die Kaufbelege sollen ausgelegt werden
//		
//
//	
//	
//	
//}
//
//public void readData() {
//	
//}
//
//
//
//public void creategood(int price, int inventory, ClassofGoods cod) {
//	//Die Objekte sollen angelegt werden
//	//goods.add(new Goods(price, duration, cog))
//}
//
//public void createfuel() {
//	//Die Objekte sollen angelegt werden
//	//fuel.add(new Fuel(price, duration, fuel));
//}
//
//
//public void checkdeliveries() {
//	
//}
//
//
//public void writeData() {
//	
//}
//}
