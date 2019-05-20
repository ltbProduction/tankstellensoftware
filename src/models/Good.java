package models;

public class Good extends Product {

	//Atribute
	

	//Konstruktor
	public Good(int number, String name, String unit, double amount, double price) {
		super(number, name, unit, price, amount);
	
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
	
//	
//	@Override
//	public void createorder(int amount) {
//		
//		
//	}
//
//
//
//	@Override
//	public void createdelivery(int amount) {
//		
//	}
//
//
//
//
//
//	@Override
//	public void displayorder() {
//		// TODO Auto-generated method stub
//		
//	}




	@Override
	public int getNumber() {
		return number;
		
	}



	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	//Die korrekte Ausgabe für die Textdatei wird erzeugt
	public String displaytextfile() {
		String text = String.valueOf(number)+";"+name+";" +unit+";"+String.valueOf(amount)+";"+String.valueOf(price);
		return text;
	}

	
	
	
}
