package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import models.Employee;
import models.Fuel;
import models.GasStation;
import models.Good;
import models.Purchase;
import models.Sale;

/**
 * @author Linus Brugger
 *
 */
public class FileScanner {

	
	
	private static String datafile = "src/resource/Data/"; //Ort wo die Dateien gespeichert werden
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu"); //Format wie die Daten in den .txt gespeichert sind
	private static String fileNameEmployee = datafile + "Employee.txt"; //Name der Txt Datei wo die Mitarbeitern gespeichert werden
	private static String fileNamePurchasesHistory = datafile + "Historypurchases.txt"; //Name der Txt Datei wo die Eink�ufe gespeichert werden
	private static String fileNameSalesHistory = datafile + "Historysales.txt"; //Name der Txt Datei wo die Verk�ufe gespeichert werden
	private static String fileNameGoods = datafile + "Goods.txt"; ////Name der Txt Datei wo die aktuellen Warenbest�nde gespeichert werden
	private static String fileNameFuelTanks = datafile + "FuelTanks.txt"; //Name der Txt Datei wo die akteullen Tanks gespeichert werden

    
	//Mitarbeiter auslesen
 		public static void readEmployee() {
			
			File file = new File(fileNameEmployee);

		     //Arraylist leeren
		     
			try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
				String line;
				br.readLine();
		
				while ((line = br.readLine()) != null) {
			
				String[] output = line.split(";");
				GasStation.getEmployees().add(new Employee(Integer.parseInt(output[0]),output[1], LocalDate.parse(output[2], formatter)));
							
		}
			} catch (IOException | NumberFormatException e) {
				e.printStackTrace();
			}
		}
	//Eink�ufe auslesen
		public static void readPurchasesHistory() {
		
		
	 
		     File file = new File(fileNamePurchasesHistory);
		    
		     
			
			

			try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
				String line;
				br.readLine();
		
				while ((line = br.readLine()) != null) {
			
				String[] output = line.split(";");
				GasStation.getPurchases().add(new Purchase(Integer.parseInt(output[0]), LocalDate.parse(output[1], formatter), Double.parseDouble(output[2])));
					
					
		}
			} catch (IOException | NumberFormatException  e) {
				e.printStackTrace();
			}
			
		}


		//Die Verk�ufe werden ausgelesen
	public static void readSalesHistory() {
		
			 

	     File file = new File(fileNameSalesHistory);

	    
	     
		
		

		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
			String line;
			br.readLine();
	
			while ((line = br.readLine()) != null) {
		
			String[] output = line.split(";");
			GasStation.getSales().add(new Sale(Integer.parseInt(output[0]),  LocalDate.parse(output[1], formatter), Double.parseDouble(output[2])));
				
				
	}
		} catch (IOException | NumberFormatException  e) {
			e.printStackTrace();
		}
		
	}


	//Waren werden ausgelesen und Objekte Goods erzeugt
	public static void readGoods() {
	 
	     File file = new File(fileNameGoods);
	     //Arraylist leeren

	     try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
			String line;
			br.readLine();
	
			while ((line = br.readLine()) != null) {
		
			String[] output = line.split(";");
			GasStation.getGoods().add(new Good(Integer.parseInt(output[0]), output[1], output[2], Double.parseDouble(output[3]), Double.parseDouble(output[4]), Double.parseDouble(output[5])));
				
				
	}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
		
	//Tanks werden ausgelesen und Objekte erzeugt.
	public static void readFuelTanks() {

		     File file = new File(fileNameFuelTanks);


		     
			try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
				String line;
				br.readLine();
		
				while ((line = br.readLine()) != null) {
			
				String[] output = line.split(";");
				Fuel f = new Fuel(Integer.parseInt(output[0]), output[1], Double.parseDouble(output[2]), Double.parseDouble(output[4]), Double.parseDouble(output[5]));
				f.setCapacity(Double.parseDouble(output[3]));
				GasStation.getFuels().add(f);
								
		}
			} catch (IOException | NumberFormatException  e) {
				e.printStackTrace();
			}
		}
		
		
	//Das auslesen der neuen Lieferungen
		
		public static int readDeliveryGoods(File file) throws ParseException, IOException   {
		     
				//1 hei�t erfolgreich
				//2 hei�t kapazit�tsgrenze �bertroffen
				//3 hei�t Fehler in der Datei
		 
	    	 int success;
	    	 //Datei auslesen
	    	 LocalDate dateofdelivery;// Das Lieferdatum
	    	 double sum = 0;//Die Endsumme
	    	 int newnumber = Helpmethods.newdeliveriesnumber();
	 
	   
	    	 
	    	 try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
				String line;
				line = br.readLine(); //Die Zeile mit dem Lieferdatum
				String[] output = line.split("=");
				dateofdelivery = LocalDate.parse(output[1], formatter);//Lieferdatum wurde festgelegt
				
				br.readLine(); //Das auslesen der unwichtigen Zeile
				int numberofgood; //Die Nummer der Waren
				double newamount; //Die neue Menge
				int amount; //Die Menge der Lieferung
				double price;
					while ((line = br.readLine()) != null) {	//Schleife startet			
						output = line.split(";");
						numberofgood = Integer.parseInt(output[0]);
					
						// Alle Waren nach dem passenden Gut kontrollieren
						for (Good g : GasStation.getGoods()) {
							if (g.getNumber()==numberofgood) {//ist es die gleiche Warennummer
								amount = Integer.parseInt(output[3]); //Die Menge wird gelsen
								price = Double.parseDouble(output[4]); //Der Einkaufspreis wird gelesen
								newamount = g.getAmount() + amount; //Die neue Menge f�r die Objekte
								g.setAmount(newamount);
								g.setPurchasePrice(price);
								sum += amount*price;
							}
							else {
								continue;
							}
						}
						
					}
				
				GasStation.getPurchases().add(new Purchase(newnumber, dateofdelivery, sum));
				success = 1;
	    	 } catch (IOException  e) {
					e.printStackTrace();
					success = 3;
				
				}
	     return success;
	 
	}   
		
		public static int readDeliveryFuels(File file) throws IOException {
		
	 
			//1 hei�t erfolgreich
			//2 hei�t kapazit�tsgrenze �bertroffen
			//3 hei�t Fehler in der Datei

			int success = 0;
			
	    	 LocalDate dateofdelivery;// Das Lieferdatum
	    	 double sum = 0;//Die Endsumme
	    	 int newnumber = Helpmethods.newdeliveriesnumber(); //Die Lieferungsnummer
	    	 
	   
	    	 
	    	 try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
				//Variable zum auslesen
	    		 double oldamountdiesel = GasStation.getFuels().get(0).getAmount();
	    		 double oldamountsuper = GasStation.getFuels().get(1).getAmount();
	    		 double addamountdiesel; //Die hinzugef�gte Menge an Diesel
		    	 double pricediesel; // 
		    	 double addamountsuper; //Die hinzugef�gte Menge an Super
		    	 double pricesuper;
	    		 
	    		 
	    		String line;
				line = br.readLine(); //Die Zeile mit dem Lieferdatum
				String[] output = line.split("=");
				dateofdelivery = LocalDate.parse(output[1], formatter);//Lieferdatum wurde festgelegt
				
				line = br.readLine(); //Die Diesel Zeile
				output = line.split("=");
				addamountdiesel = Double.parseDouble(output[1]);//Diesel Menge intialisiert
				
				line = br.readLine(); //Die Dieselpreis Zeile
				output = line.split("=");
				pricediesel = Double.parseDouble(output[1]);//Diesel Preis intialisiert
				
				line = br.readLine(); //Die super Zeile
				output = line.split("=");
				addamountsuper = Double.parseDouble(output[1]);//super Menge intialisiert
				
				line = br.readLine(); //Die superpreis Zeile
				output = line.split("=");
				pricesuper = Double.parseDouble(output[1]);//super Preis intialisiert
				
				//Menge f�r die Objekte anpassen
				if(oldamountdiesel+addamountdiesel<=GasStation.getFuels().get(0).getCapacity()) {
				GasStation.getFuels().get(0).setAmount((addamountdiesel+oldamountdiesel)); //Die Menge des Dieseltanks auff�llen
				}else {
					//Die Kapazit�tsgrenze wurde �berschritten
					GasStation.getFuels().get(0).setAmount(GasStation.getFuels().get(0).getCapacity());
					success = 2;
				}
				
				if(oldamountsuper+addamountsuper<=GasStation.getFuels().get(1).getCapacity()) {
					GasStation.getFuels().get(1).setAmount((addamountsuper+oldamountsuper)); //Die Menge des Dieseltanks auff�llen
					}else {
						//Die Kapazit�tsgrenze wurde �berschritten
						GasStation.getFuels().get(1).setAmount(GasStation.getFuels().get(1).getCapacity());
						success = 2;
				}				
				GasStation.getFuels().get(0).setPurchasePrice(pricediesel);
				GasStation.getFuels().get(1).setPurchasePrice(pricesuper);

				
				sum = pricesuper*addamountsuper+pricediesel*addamountdiesel; //Summe errechnen
				sum = Math.round(100.0*sum)/100.0;
				GasStation.getPurchases().add(new Purchase(newnumber, dateofdelivery, sum)); //Neuer Einkauf anlegen
				if (success == 0) {
				success = 1;}
				} catch (IOException  e) {
					e.printStackTrace();
					success= 3;
				
				}
	    	 return success;
			}	 
	
	
	

}