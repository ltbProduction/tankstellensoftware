package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import models.Employee;
import models.Fuel;
import models.GasStation;
import models.Good;
import models.Product;
import models.Purchase;
import models.Sale;

/**
 * @author Linus Brugger
 *
 */
public class FileSetter {
     private static String pathdata = "src/resource/Data/";
     private static String firstlinegoods = "Nummer;Name;Lagereinheit;Menge;Einkaufspreis;Verkaufspreis";
     private static String firstlinehistory = "Nummer;Datum;Preis";
     private static String firstlineemployee = "Nummer;Name;Datum";
     private static String firstlinefuels = "Nummer;Kraftstoffart;Fuellstand;Kapazitaet;Einkaufspreis;Verkaufspreis";
   
     
     //Die Text datei der Mitarbeiter wird geschrieben
     public static void writeemployee() {
    	 File file = new File(pathdata+ "Employee.txt"); //Die neue File wird erzeugt

  		try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) { 
  			bw.write(firstlineemployee); //Die erste Zeile wird geschrieben
  			bw.newLine(); 
  			for (Employee e : GasStation.getEmployees()) {							//fuer jeden Mitarbeiter von Employyes
				bw.write(e.displaytextfile()); 								//Schreiben des Mitarbeiters			
				if (GasStation.getEmployees().indexOf(e) < GasStation.getEmployees().size()-1) {	// Wenn es nicht das letzte Element der Liste ist
					bw.newLine();									// Springe in die naechste Zeile
				} else continue;									// Sonst fahre fort
				
				
			}
			GasStation.getEmployees().clear(); //ArrayList loeschen damit Objekte beim erneuten einlesen nicht doppelt vorkommen

  		} catch (IOException e) {
  			e.printStackTrace();
     }
     }
     
     
     //Die Text Datei der Kraftstoffe wird geschrieben
     public static void writefuels() {
    	 File file = new File(pathdata+ "FuelTanks.txt"); //Die neue File wird erzeugt

  		try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) { 
  			bw.write(firstlinefuels); //Die erste Zeile wird geschrieben
  			bw.newLine(); 
  			//Muss noch geaendert werden

  			for (Fuel f : GasStation.getFuels()) {							//fuer jeden Kraftstofftank von Kraftstofftanks
				bw.write(f.displaytextfile()); 								//Schreiben des Tanks
				if (GasStation.getFuels().indexOf(f) < GasStation.getFuels().size()-1) {	// Wenn es nicht das letzte Element der Liste ist
					bw.newLine();									// Springe in die naechste Zeile
				} else continue;									// Sonst fahre fort

			}
			GasStation.getFuels().clear(); //ArrayList loeschen damit objekte beim erneuten Einlesen nicht doppelt vorkommen

  		} catch (IOException e) {
  			e.printStackTrace();
     }
  		
     }
     
     //Die Text Datei der Waren wird geschrieben
     public static void writeGoods() {
    	 File file = new File(pathdata+ "Goods.txt"); //Die neue File wird erzeugt

  		try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) { 
  			bw.write(firstlinegoods); //Die erste Zeile wird geschrieben
  			bw.newLine(); 
  			for (Good g : GasStation.getGoods()) {							//fuer jede Ware von Waren
				bw.write(g.displaytextfile()); 							//Schreibe die Waren
				if (GasStation.getGoods().indexOf(g) < GasStation.getGoods().size()-1) {	// Wenn es nicht das letzte Element der Liste ist
					bw.newLine();								// Springe in die naechste Zeile
				} else continue;								// Sonst fuehre fort
				
			}
			GasStation.getGoods().clear(); //ArrayList loeschen damit Objekte beim erneuten Einlesen nicht doppelt vorkommen
	
  		} catch (IOException e) {
  			e.printStackTrace();
     }
     }
     
     //Die Text datei der Waren wird geschrieben
     public static void writeHistorypurchases() {
    	 File file = new File(pathdata+ "Historypurchases.txt"); //Die neue File wird erzeugt

  		try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) { 
  			bw.write(firstlinehistory); //Die erste Zeile wird geschrieben
  			bw.newLine(); 
  			for (Purchase p : GasStation.getPurchases()) {							//fuer jeden Einkauf von Einkaeufe
				bw.write(p.displaytextfile()); 								//Schreibe den Einkauf
				if (GasStation.getPurchases().indexOf(p) < GasStation.getPurchases().size()-1) {	// Wenn es nicht das letzte Element der Liste ist
					bw.newLine();									// Springe in die naechste Zeile
				} else continue;									
			}
			GasStation.getPurchases().clear(); //ArrayList loeschen damit objekte beim erneuten einlesen nicht doppelt vorkommen

  		} catch (IOException e) {
  			e.printStackTrace();
     }
     }
     
     
     //Die Text Datei der Waren wird geschrieben
     public static void writeHistorysales() {
    	 File file = new File(pathdata+ "Historysales.txt"); //Die neue File wird erzeugt

  		try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) { 
  			bw.write(firstlinehistory); //Die erste Zeile wird geschrieben
  			bw.newLine(); 
  			for (Sale s : GasStation.getSales()) {								//fuer jeden Verkauf von Verkäufe
				bw.write(s.displaytextfile()); 								//Schreibe den Verkauf
				if (GasStation.getSales().indexOf(s) < GasStation.getSales().size()-1) {		//Wenn es nicht das letzte Element der Liste ist
					bw.newLine();									// Springe in die naechste Zeile
				} else continue;									
			}
			GasStation.getSales().clear(); //ArrayList loeschen damit Objekte beim erneuten einlesen nicht doppelt vorkommen

  		} catch (IOException e) {
  			e.printStackTrace();
     }
     }	
    //Einen Beleg ausrucken
  	public static void createreceipt(double completesum, File file) {
  	int numberofreceipt = Helpmethods.newsalesnumber(); //Neue Sales Methode wird geholt
  	LocalDate today = LocalDate.now(); //heutige Datum
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu"); //richtige Format vom Datum
	

  	
  	try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) { 
			bw.write(GasStation.getGasStationName()); //Die erste Zeile wird geschrieben
			bw.newLine(); 
			bw.newLine();
			bw.write("Belegnummer: "+String.valueOf(numberofreceipt));
			bw.newLine();
			bw.write("Datum: " + today.format(formatter));
			bw.newLine();
			bw.write("Mitarbeiter: "+GasStation.activeEmployee().getEmployeeName());
			bw.newLine();
			bw.newLine();
				
			
			for (Product p : GasStation.getShoppingCart()) {
			bw.write(p.displayreceipt()); //Ausgabe der Produkte
			bw.newLine();
		}
			bw.newLine();
			bw.write("Gesamtbetrag: "+completesum +" EUR");
		} catch (IOException e) {
			e.printStackTrace();
 }
  	
  	
    }
  	//Waren bestellen schreiben
  	public static void writeGoodsOrder(File file) {
  	  	LocalDate today = LocalDate.now();
  		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
  		
  		
  		
  		try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) { 
			bw.write("Bestelldatum = "+ today.format(formatter)); //Die erste Zeile wird geschrieben
			bw.newLine(); 
			bw.write("Warennummer;Bestellmenge");
			bw.newLine();
		
			for (Good g : GasStation.getOrderGood()) {
			bw.write(String.valueOf(g.getNumber())+";"+String.valueOf(g.getAmount())); //Ausgabe der Produkte
			bw.newLine();
		}

		} catch (IOException e) {
			e.printStackTrace();
    }
  		GasStation.getOrderGood().clear();
  		
  	}

  	//Kraftstoffbestellung erzeugen
  	public static void writeFuelOrder(File file) {
  	  	LocalDate today = LocalDate.now();
  		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
  		double amountdiesel = 0;
  		double amountsuper = 0;
  		
		for (Fuel f : GasStation.getOrderFuel()) {
			if (f.getName().equals("Diesel")) {
				amountdiesel += f.getAmount();
			} else if (f.getName().equals("Super")) {
				amountsuper += f.getAmount();
			} else continue;
		}

  		try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) { 
			bw.write("BESTELLDATUM = "+ today.format(formatter)); //Die erste Zeile wird geschrieben
			bw.newLine(); 
			bw.write("DIESEL = "+String.valueOf(amountdiesel) );
			bw.newLine();
			bw.write("SUPER = " + String.valueOf(amountsuper));
			GasStation.getOrderFuel().clear();	
		

		} catch (IOException e) {
			e.printStackTrace();
    }
  	}
     
  	
}
     
     
     

     


