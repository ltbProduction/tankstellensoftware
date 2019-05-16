package models;

public class Good extends Product {
	int amount;
	//Atribute
	

	//Konstruktor
	public Good(int number, String name, String unit, int amount, double price) {
		super(number, name, unit, price);
		this.amount = amount;
	}

	
	
	
	//Zum testen ob die Objekte erzeugt wurden
	public void displayproduct() {
		System.out.println(number);
		System.out.println(name);
		System.out.println(unit);
		System.out.println(amount);
		System.out.println(price);
		System.out.println();
	}
	
	
	public void createorder(int amount) {
		
		
	}



	public void createdelivery(int amount) {
		
	}





	@Override
	public void displayorder() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public int getNumber() {
		return number;
		
	}




	public int getAmount() {
		return amount;
	}




	public void setAmount(int amount) {
		this.amount = amount;
	}

	
	
	
}
