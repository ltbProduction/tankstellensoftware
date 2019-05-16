package models;

import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import sun.util.calendar.LocalGregorianCalendar.Date;

public class GasStation {


	private String gasStationName; //Name der Tankstelle
	private ArrayList<Employee> employees = new ArrayList<>(); //Liste mit allen Mitarbeitern
	private ArrayList<Product> storage = new ArrayList<>(); //Liste mit allen Produkte
	private ArrayList<Product> shoppingCart = new ArrayList<>(); //Liste mit Produkten im Warenkorb
	private ArrayList<Fuel> fuels = new ArrayList<>(); //Liste 
	private ArrayList<Good> goods = new ArrayList<>();
	private ArrayList<Sale> sales = new ArrayList<>();
	private ArrayList<Purchase> purchases = new ArrayList<>();
	private Date startBalanceDate;
	private Date endBalanceDate;
	
	
	public GasStation(String gasStationName) {
		this.gasStationName = gasStationName;
	}
	

	
	//Methode welche alle ArrayLists auf null setzt
	
	public void clearArrayList() {
		goods.clear();
		fuels.clear();
		storage.clear();
		employees.clear();
		shoppingCart.clear();
		sales.clear();
		purchases.clear();
				
	}
	
	
	
	public void startGasStation() {
		
	}
	
	public void scanDeliveries() {
		
	}
	
	public void createSaleReceipt() {
		
	}
	
	//writeCurrentData speichert die änderbaren Daten
	public void writeCurrentData() {
		
	}
	
	public void createHistory() {
		
	}
	
	public void calculateBalance(Date startBalanceDate, Date endBalaceDate) {
		
	}
	//Test für Linus
	public void display() {
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

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	public ArrayList<Product> getStorage() {
		return storage;
	}

	public void setStorage(ArrayList<Product> storage) {
		this.storage = storage;
	}

	public ArrayList<Product> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ArrayList<Product> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public ArrayList<Fuel> getFuels() {
		return fuels;
	}

	public void setFuels(ArrayList<Fuel> fuels) {
		this.fuels = fuels;
	}

	public ArrayList<Good> getGoods() {
		return goods;
	}

	public void setGoods(ArrayList<Good> goods) {
		this.goods = goods;
	}

	public ArrayList<Sale> getSales() {
		return sales;
	}

	public void setSales(ArrayList<Sale> sales) {
		this.sales = sales;
	}

	public ArrayList<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(ArrayList<Purchase> purchases) {
		this.purchases = purchases;
	}

	public Date getStartBalanceDate() {
		return startBalanceDate;
	}

	public void setStartBalanceDate(Date startBalanceDate) {
		this.startBalanceDate = startBalanceDate;
	}

	public Date getEndBalanceDate() {
		return endBalanceDate;
	}

	public void setEndBalanceDate(Date endBalanceDate) {
		this.endBalanceDate = endBalanceDate;
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
