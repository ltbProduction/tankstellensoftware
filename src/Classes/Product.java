package Classes;

public abstract class Product {

	protected String name;
	protected int price;
	protected int duration;
//	protected int amount;
	
	
	// Methoden
	
	public Product(int price, int duration) {
		this.price = price;
		this.duration = duration;
	}
	public abstract void createorder(int amount);
	public abstract void displayorder();
	public abstract void createdelivery(int amount);



}
