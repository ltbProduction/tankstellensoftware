package models;

public enum ClassofGoods {

VODKA("Wodka Jelzin", 421, "Flasche"), FILIPMAURICE("Filip Maurice", 871, "Packung"),
JUPITER_CHOCO("Jupiter Schokoriegel", 871, "Packung"), BULL("Sitting Bull",992,"Dose"), 
PIZZA("TK-Pizza", 101, "Stück");

	//Attribute 

	private String name;
	private int number;
	private String type;
	
	
	//Methode
	
	ClassofGoods(String name, int number, String type) {
		this.name= name;
		this.number = number;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}


	public int getNumber() {
		return number;
	}


	public String getType() {
		return type;
	}



		
	
}
