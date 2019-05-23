package models;

public class Fuel extends Product{

	
//Attribute
	
	private double capacity;
	
//Konstruktor
	public Fuel(int number, String name, double amount, double purchasePrice, double salePrice) {
		
		super(number, name, "Liter", amount, purchasePrice, salePrice);
		
		
		
	}

	public static boolean enoughFuelCheck(String chosenFuelName, double amountOfFuel) {
		
		boolean value = false;
		
		for (Fuel f : GasStation.getFuels()) {
			if (f.getName().equals(chosenFuelName)) {
				if (amountOfFuel < (f.getAmount()-100)) {
					value = true;
					break;
				} else continue;
			}
		}
		
		return value;
		
	}
	
	public void displayFuel() {
		System.out.println("Fuel: " + getNumber() + ", " + name + ", " + amount + ", " + capacity + ", " + purchasePrice + ", " + salePrice);
	}
	
	public double getCapacity() {
		return capacity;
	}




	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}




	public String displaytextfile() {
		String text = String.valueOf(number)+";"+ getName() +";"+String.valueOf(amount)+";"+ String.valueOf(capacity) + ";" + String.valueOf(purchasePrice)+ ";"+String.valueOf(salePrice);
	return text;
	}



	@Override
	public void createorder(int amount) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void displayorder() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void createdelivery(int amount) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		return number;
	}
	
	
	
	
//	public void createorder(int amount) {
//	
//		
//	}
//
//	
//	public void displayorder() {
//		
//		
//	}
//
//	
//	public void createdelivery(int amount) {
//	
//		
//	}
//
//
//
//
//	
//
//	public double getAmount() {
//		return amount;
//	}
//
//
//
//
//
//
//	public void setAmount(double amount) {
//		this.amount = amount;
//	}





	
	

	}


