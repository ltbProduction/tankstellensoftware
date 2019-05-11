package models;

public abstract class Product {

	protected int number;
	protected String name;
//	private Producttyp producttyp;
	protected String unit;
	protected double price;
//	protected int amount; Das geht nicht weil bei Fuel sind es double werte
	
	
	// Methoden
	
	public Product(int number, String name, String unit, double price) {
		this.number = number;
		this.name = name;
		this.unit = unit;
		this.price = price;
		
	}
	public abstract void createorder(int amount);
	public abstract void displayorder();
	public abstract void createdelivery(int amount);
	
	



}
