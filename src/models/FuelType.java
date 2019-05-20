package models;

public enum FuelType {

	DIESEL("Diesel"), SUPER("Super");
	
	private String fuelType;
	
	
	FuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	
	
}
