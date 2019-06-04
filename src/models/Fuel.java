package models;

public class Fuel extends Product{

	
//Attribute
	
	private double capacity;
	
//Konstruktor
	public Fuel(int number, String name, double amount, double purchasePrice, double salePrice) {
		
		super(number, name, "Liter", amount, purchasePrice, salePrice);
		
		
		
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


	// Methode, die den Listen-Index eines Kraftstofftanks mit angegebener Kraftstoffart zurückgibt.
	public static int getIndex(String fueltype) {

		int i = 0;

		for (Fuel f : GasStation.getFuels()) {
			if (f.getName().equals(fueltype)) {
				i = GasStation.getFuels().indexOf(f);
			} else
				continue;
		}

		return i;

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


