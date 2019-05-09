package models;

import java.util.ArrayList;

public class GasStation {

private String name;
private int numberofcustomers;
private ArrayList<Goods> goods = new ArrayList<>();
private ArrayList<Fuel> fuel = new ArrayList<>();



//Methoden 
public GasStation(String name) {
	this.name = name;
}

public void start() {
	//Die Daten sollen ausgelesen werden.
		// Die Bestandsdaten sollen ausgelegt werden
		// Die Kaufbelege sollen ausgelegt werden
		

	
	
	
}

public void readData() {
	
}



public void creategood(int price, int inventory, ClassofGoods cod) {
	//Die Objekte sollen angelegt werden
	//goods.add(new Goods(price, duration, cog))
}

public void createfuel() {
	//Die Objekte sollen angelegt werden
	//fuel.add(new Fuel(price, duration, fuel));
}


public void checkdeliveries() {
	
}


public void writeData() {
	
}
}
