package models;

import java.time.LocalDate;
import java.util.ArrayList;
import models.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sun.util.calendar.LocalGregorianCalendar.Date;

public class GasStation {


	private String gasStationName; //Name der Tankstelle
	private static ObservableList<Employee> employees = FXCollections.observableArrayList(); //Liste mit allen Mitarbeitern
	private static ArrayList<Product> storage = new ArrayList<>(); //Liste mit allen Produkte
	private static ArrayList<Product> shoppingCart = new ArrayList<>(); //Liste mit Produkten im Warenkorb
	private static ArrayList<FuelTank> fuelTanks = new ArrayList<>(); //Liste mit allen Kraftstofftanks
	private static ArrayList<Good> goods = new ArrayList<>(); // Liste mit allen Waren
	private static ArrayList<Sale> sales = new ArrayList<>(); //Liste mit allen Verkäufen
	private static ArrayList<Purchase> purchases = new ArrayList<>(); //Liste mit allen Einkäufen
	private static Date startBalanceDate; //Startdatum 
	private static Date endBalanceDate; //Enddatrum

	
	
	public GasStation(String gasStationName) {
		this.gasStationName = gasStationName;
	}
	

	public static void addEmployee(String employeeName, LocalDate dateOfEmployment) {
		int employeeNumber = (getEmployees().size())+1;
		Employee employee = new Employee(employeeNumber, employeeName, dateOfEmployment);
		employees.add(employee);
	}
	
	public static void addFuelTank(FuelTank fuelTank) {
		fuelTanks.add(fuelTank);
	}
	
	
	//Methode welche alle ArrayLists auf null setzt
	
	public static void clearArrayList() {
		goods.clear();
		fuelTanks.clear();
		storage.clear();
		employees.clear();
		shoppingCart.clear();
		sales.clear();
		purchases.clear();
				
	}
	
	
	
	public static void startGasStation() {
		
	}
	
	public static void scanDeliveries() {
		
	}
	
	public static void createSaleReceipt() {
		
	}
	
	//writeCurrentData speichert die änderbaren Daten
	public static void writeCurrentData() {
		
	}
	
	public static void createHistory() {
		
	}
	
	public static void calculateBalance(Date startBalanceDate, Date endBalaceDate) {
		
	}
	//Test für Linus
	public static void display() {
		for (Purchase g: purchases){
			g.display();
		}
	}

	public String getGasStationName() {
		return gasStationName;
	}

	public void setGasStationName(String gasStationName) {
		this.gasStationName = gasStationName;
	}

	//Methode die ObservableList von Mitarbeitern zurückgibt
	public static ObservableList<Employee> getEmployees() {
			
			return employees;
					  
	}
	
	public static void setEmployees(ObservableList<Employee> employees) {
		GasStation.employees = employees;
	}

	public static ArrayList<Product> getStorage() {
		return storage;
	}

	public static void setStorage(ArrayList<Product> storage) {
		GasStation.storage = storage;
	}

	public static ArrayList<Product> getShoppingCart() {
		return shoppingCart;
	}

	public static void setShoppingCart(ArrayList<Product> shoppingCart) {
		GasStation.shoppingCart = shoppingCart;
	}

	public static ArrayList<FuelTank> getFuelTanks() {
		return fuelTanks;
	}

	public static void setFuels(ArrayList<FuelTank> fuelTanks) {
		GasStation.fuelTanks = fuelTanks;
	}

	public static ArrayList<Good> getGoods() {
		return goods;
	}

	public static void setGoods(ArrayList<Good> goods) {
	   GasStation.goods = goods;
	}

	public static ArrayList<Sale> getSales() {
		return sales;
	}

	public static void setSales(ArrayList<Sale> sales) {
		GasStation.sales = sales;
	}

	public static ArrayList<Purchase> getPurchases() {
		return purchases;
	}

	public static void setPurchases(ArrayList<Purchase> purchases) {
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
	

	
	
	
}
	
	
	
	
	//alt:
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
