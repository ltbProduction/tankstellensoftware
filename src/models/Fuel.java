package models;

public class Fuel extends Product{

	
//Attribute
	private double amount;
	
//Konstruktor
	public Fuel(int number, String name, String unit, double amount, double price) {
		super(number, name, unit, price);
		this.amount = amount;
	}
	
	
	
	
	
	
	public void createorder(int amount) {
	
		
	}

	
	public void displayorder() {
		
		
	}

	
	public void createdelivery(int amount) {
	
		
	}




	

	public double getAmount() {
		return amount;
	}






	public void setAmount(double amount) {
		this.amount = amount;
	}






	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	}


