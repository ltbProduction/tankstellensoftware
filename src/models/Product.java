package models;

public class Product {

	protected int number;
	protected String name;
//	private Producttyp producttyp;
	protected String unit;
	protected double price;
	private double sum;
	protected double amount; 
	
	
	// Methoden
	
	public Product(int number, String name, String unit, double price, double amount) {
		this.number = number;
		this.name = name;
		this.unit = unit;
		this.price = price;
		this.amount = amount;
		this.sum = amount*price;
	}
	
	
	
	public double getSum() {
		return sum;
	}



	public void setSum(double sum) {
		this.sum = sum;
	}



	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String displayreceipt() {
		String text;
		text = name + " - " + String.valueOf(amount) + " "+ unit + " - "+ String.valueOf(price) + " EUR/"+unit+" - "+ String.valueOf(amount*price) +" EUR"; 
		return text;
	}
	
	
	
	



}
