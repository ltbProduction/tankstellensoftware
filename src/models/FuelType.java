package models;

public enum FuelType {

	DIESEL("Diesel", 0.00), SUPER("Super", 0.00);
	
	private String fuelType;
	private double purchasePrice;
	
	FuelType(String fuelType, double purchasePrice) {
		this.fuelType = fuelType;
		this.purchasePrice = purchasePrice;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	
	
	
	
	
	

}
