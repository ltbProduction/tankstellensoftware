package models;

import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import sun.util.calendar.LocalGregorianCalendar.Date;

public class GasStation {

	private String gasStationName;
	private ArrayList<Employee> employees = new ArrayList<>();
	private ArrayList<Product> storage = new ArrayList<>();
	private ArrayList<Product> shoppingCart = new ArrayList<>();
	private ArrayList<Fuel> fuels = new ArrayList<>();
	private ArrayList<Good> goods = new ArrayList<>();
	private ArrayList<Sales> sales = new ArrayList<>();
	private ArrayList<Purchases> purchases = new ArrayList<>();
	private Date startBalanceDate;
	private Date endBalanceDate;
	
	
	public GasStation(String gasStationName) {
		this.gasStationName = gasStationName;
	}
	
	//Auslesen der Daten, Products anlegen, Employees auslesen, FileTransfer anlegen/starten
	public void addGood(Good good) {
		goods.add(good);
	}
	
	public void addFuel(Fuel fuel) {
		fuels.add(fuel);
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
	public void displayproducts() {
		for (Good g: goods){
			g.displayproduct();
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
