package Classes;

public enum Fueltanks {

DIESEL("Diesel", 5000), SUPER("Benzin", 5000);

//Atributte
private String name;
private int maxcap;

Fueltanks(String name, int maxcap){
	this.name= name;
	this.maxcap = maxcap;
}

public String getName() {
	return name;
}

public int getMaxcap() {
	return maxcap;
}


}
