package models;

import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import sun.util.calendar.LocalGregorianCalendar.Date;

public class GasStation {


	private String gasStationName; //Name der Tankstelle

	private static ArrayList<Employee> employees = new ArrayList<>(); //Liste mit allen Mitarbeitern
	private static ArrayList<Product> storage = new ArrayList<>(); //Liste mit allen Produkte
	private static ArrayList<Product> shoppingCart = new ArrayList<>(); //Liste mit Produkten im Warenkorb
	private static ArrayList<Fuel> fuels = new ArrayList<>(); //Liste mit den Tanks
	private static ArrayList<Good> goods = new ArrayList<>(); // Liste mit allen Waren
	private static ArrayList<Sale> sales = new ArrayList<>(); //Liste mit allen Verk�ufen
	private static ArrayList<Purchase> purchases = new ArrayList<>(); //Liste mit allen Eink�ufen
	private static Date startBalanceDate; //Startdatum 
	private static Date endBalanceDate; //Enddatrum

	
	
	public GasStation(String gasStationName) {
		this.gasStationName = gasStationName;
	}
	

	
	//Methode welche alle ArrayLists auf null setzt
	
	public static void clearArrayList() {
		goods.clear();
		fuels.clear();
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

	public String getGasStationName() {
		return gasStationName;
	}

	public void setGasStationName(String gasStationName) {
		this.gasStationName = gasStationName;
	}

	public static ArrayList<Employee> getEmployees() {
		return employees;
	}

	public static void setEmployees(ArrayList<Employee> employees) {
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

	public static ArrayList<Fuel> getFuels() {
		return fuels;
	}

	public static void setFuels(ArrayList<Fuel> fuels) {
		GasStation.fuels = fuels;
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
