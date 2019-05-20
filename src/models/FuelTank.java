package models;

public class FuelTank {

	
//Attribute
	
	private int tankNumber;
	private FuelType fuelType;
	private double fuelLevel;
	private double capacity;
	private double purchasePrice;
	private double salePrice;
	
//Konstruktor
	public FuelTank(int tankNumber, FuelType fuelType, double fuelLevel, double capacity, double purchasePrice, double salePrice) {
		this.tankNumber = tankNumber;
		this.fuelType = fuelType;
		this.fuelLevel = fuelLevel;
		this.capacity = capacity;
		this.purchasePrice = purchasePrice;
		this.salePrice = salePrice;
	}

	

	public int getTankNumber() {
		return tankNumber;
	}

	public void setTankNumber(int tankNumber) {
		this.tankNumber = tankNumber;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public double getFuelLevel() {
		return fuelLevel;
	}

	public void setFuelLevel(double fuelLevel) {
		this.fuelLevel = fuelLevel;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	
	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	
	public String displaytextfile() {
		String text = String.valueOf(tankNumber)+";"+ getFuelType() +";"+String.valueOf(fuelLevel)+";"+ String.valueOf(capacity) + ";" + String.valueOf(purchasePrice)+ ";"+String.valueOf(salePrice);
	return text;
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


