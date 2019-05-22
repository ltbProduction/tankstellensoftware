package models;

public class Good extends Product {

	
	//Konstruktor
	public Good(int number, String name, String unit, double amount, double purchasePrice, double salePrice) {
		super(number, name, unit, amount, purchasePrice, salePrice);

	
	}

	
	
	
	//Zum testen ob die Objekte erzeugt wurden
	public void displayproduct() {
		System.out.println("Good: " + number + ", " + name + ", " + unit  + ", " + amount  + ", " + purchasePrice  + ", " + salePrice);
	}
	
	
	@Override
	public void createorder(int amount) {
		
		
	}



	@Override
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



	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	//Die korrekte Ausgabe für die Textdatei wird erzeugt
	public String displaytextfile() {
		String text = String.valueOf(number)+";"+name+";" +unit+";"+String.valueOf(amount)+";"+String.valueOf(purchasePrice)+";"+String.valueOf(salePrice);
		return text;
	}

	
	
	
}
