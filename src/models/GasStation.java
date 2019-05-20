package models;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sun.util.calendar.LocalGregorianCalendar.Date;
import utilities.FileSetter;
import utilities.Hilfmethoden;

public class GasStation {


	private static String gasStationName; //Name der Tankstelle
	private static ObservableList<Employee> employees = FXCollections.observableArrayList(); //Liste mit allen Mitarbeitern
	private static ArrayList<Product> storage = new ArrayList<>(); //Liste mit allen Produkte
	private static ArrayList<Product> shoppingCart = new ArrayList<>(); //Liste mit Produkten im Warenkorb
	private static ObservableList<FuelTank> fuelTanks = FXCollections.observableArrayList(); //Liste mit allen Kraftstofftanks
	private static ArrayList<Good> goods = new ArrayList<>(); // Liste mit allen Waren
	private static ArrayList<Sale> sales = new ArrayList<>(); //Liste mit allen Verk�ufen
	private static ArrayList<Purchase> purchases = new ArrayList<>(); //Liste mit allen Eink�ufen
	private static Date startBalanceDate; //Startdatum
	private static Date endBalanceDate; //Enddatum

	
	
	public GasStation(String gasStationName) {
		this.gasStationName = gasStationName;
	}
	

	public static void addEmployee(String employeeName, LocalDate dateOfEmployment) {
		int indexlastmember = (getEmployees().size())-1;
		int employeeNumber = employees.get(indexlastmember).getEmployeeNumber() +1;
		Employee employee = new Employee(employeeNumber, employeeName, dateOfEmployment);
		employees.add(employee);
	}
	
	public static void addFuelTank(FuelTank fuelTank) {
		fuelTanks.add(fuelTank);
	}
	

	
	
	public static void startGasStation() {
		
	}
	
	public static void scanDeliveries() {
		
	}
	
	public static void createSaleReceipt() {
		
	}
	
	//writeCurrentData speichert die �nderbaren Daten
	public static void writeCurrentData() {
		
	}
	
	public static void createHistory() {
		
	}
	
	public static void calculateBalance(Date startBalanceDate, Date endBalaceDate) {
		
	}
	//Test f�r Linus
	public static void display() {
		for (Purchase g: purchases){
			g.display();
		}
	
	}
	
	public static void finishedreceipt() { //Zum abschlie�en einer Reception
		double sum;
		sum = 0;
		for (Product p : GasStation.getShoppingCart()) {
		sum += p.amount*p.price;
		}
		//Methode welche den Beleg ausdruckt
		FileSetter.createreceipt(sum);
		shoppingCart.clear();
		sales.add(new Sale(Hilfmethoden.newsalesnumber(), LocalDate.now(), sum));
	}

	public static String getGasStationName() {
		return gasStationName;
	}

	public static void setGasStationName(String gasStationName) {
		GasStation.gasStationName = gasStationName;
	}

	//Methode die ObservableList von Mitarbeitern zur�ckgibt
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

	public static ObservableList<FuelTank> getFuelTanks() {
		return fuelTanks;
	}

	public static void setFuelTanks(ObservableList<FuelTank> fuelTanks) {
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
	
	public static Employee activeEmployee() {
		Employee activeemployee;
		activeemployee = null;
		
		for(Employee e : employees){
			if(e.isActive()) {
				activeemployee = e;
			}
			else {
				continue;
			}
		}
		return activeemployee;
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
