package models;

import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import sun.util.calendar.LocalGregorianCalendar.Date;

public class GasStation {

	private String gasStationName;
	private ArrayList<Employee> employees = new ArrayList<>();
	private ArrayList<Product> storage = new ArrayList<>(); //Was hei�t das?
	private ArrayList<Product> shoppingCart = new ArrayList<>(); 
	private ArrayList<Fuel> fuels = new ArrayList<>(); 
	private ArrayList<Good> goods = new ArrayList<>();
	private ArrayList<Sale> sales = new ArrayList<>();
	private ArrayList<Purchase> purchases = new ArrayList<>();
	private Date startBalanceDate;
	private Date endBalanceDate;
	
	
	public GasStation(String gasStationName) {
		this.gasStationName = gasStationName;
	}
	
	//Das hinzuf�gen der Daten
	public void addGood(Good good) {
		goods.add(good);
	}
	
	public void addFuel(Fuel fuel) {
		fuels.add(fuel);
	}
	public void addstorage(Product product) {
		storage.add(product);
		
	}
	
	public void addemployee(Employee employee) {
		employees.add(employee);
		
	}
	public void addshoppingcart(Product product) {
		shoppingCart.add(product);
		
	}
	public void addsale(Sale sale) {
		sales.add(sale);
		
	}	
	public void addpurchases(Purchase purchase) {
		purchases.add(purchase);
		
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
	
	//writeCurrentData speichert die �nderbaren Daten
	public void writeCurrentData() {
		
	}
	
	public void createHistory() {
		
	}
	
	public void calculateBalance(Date startBalanceDate, Date endBalaceDate) {
		
	}
	//Test f�r Linus
	public void display() {
		for (Employee e: employees){
			e.displayEmployee();
		}
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
