package models;

public class Fuel extends Product{

//Attribute
	Fueltanks fuel;

	
//Konstruktor
	public Fuel( int price, int duration, Fueltanks fuel) {
		super(price, duration);
		this.fuel = fuel;
	}
	
	
	
	
	
	
	public void createorder(int amount) {
	
		
	}

	
	public void displayorder() {
		
		
	}

	
	public void createdelivery(int amount) {
	
		
	}
	
	
	public String getname() {
		return fuel.getName();
	}

}
