package Model;

public class Goods extends Product {
	//Atribute
	private ClassofGoods cog;

	//Konstruktor
	public Goods(int price, int duration, ClassofGoods cog) {
		super(price, duration);
		this.cog = cog;
	}

	
	
	
	
	
	
	
	public void createorder(int amount) {
		
		
	}

	public void displayorder() {
		
	}

	public void createdelivery(int amount) {
		
	}

	
	public String getName() {
		return cog.getName();
		
	}
	
	public String getType() {
		return cog.getType();
	}
	
	public int getNumber() {
		return cog.getNumber();
	}
	
}
