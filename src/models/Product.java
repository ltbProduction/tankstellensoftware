package models;

public abstract class Product {

	protected String number;
	protected String name;
	protected String type;
	protected int price;
	protected int amount;
	
	
	// Methoden
	
	public Product(int price, int amount) {
		this.price = price;
		this.amount = amount;
	}
	public abstract void createorder(int amount);
	public abstract void displayorder();
	public abstract void createdelivery(int amount);
	
	



}
