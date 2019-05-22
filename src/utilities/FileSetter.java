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

public class FileSetter {
     private static String pathdata = "src/resource/textfiles/Data/";
     private static String receiptsdata = "src/resource/textfiles/receipt/";
     private static String firstlinegoods = "Nummer;Name;Lagereinheit;Menge;Einkaufspreis;Verkaufspreis";
     private static String firstlinehistory = "Nummer;Datum;Preis";
     private static String firstlineemployee = "Nummer;Name;Datum";
     private static String firstlinefuels = "Nummer;Kraftstoffart;Füllstand;Kapazität;Einkaufspreis;Verkaufspreis";
   
     
     //Die Text datei der Mitarbeiter wird geschrieben
     public static void writeemployee() {
    	 File file = new File(pathdata+ "Employee.txt"); //Die neue File wird erzeugt

  		try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) { 
  			bw.write(firstlineemployee); //Die erste Zeile wird geschrieben
  			bw.newLine(); 
  			for (Employee e : GasStation.getEmployees()) {
				bw.write(e.displaytextfile()); //Ausgabe der Produkte
				if (GasStation.getEmployees().indexOf(e) < GasStation.getEmployees().size()-1) {
					bw.newLine();
				} else continue;
				
				
			}
  		} catch (IOException e) {
  			e.printStackTrace();
     }
     }
     
     
     //Die Text datei der Kraftstoffe wird geschrieben
     public static void writefuels() {
    	 File file = new File(pathdata+ "FuelTanks.txt"); //Die neue File wird erzeugt

  		try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) { 
  			bw.write(firstlinefuels); //Die erste Zeile wird geschrieben
  			bw.newLine(); 
  			//Muss noch ge#ndert werden
  			for (Fuel f : GasStation.getFuels()) {
				bw.write(f.displaytextfile()); //Ausgabe der Produkte
				if (GasStation.getFuels().indexOf(f) < GasStation.getFuels().size()-1) {
					bw.newLine();
				} else continue;
				
			}
  		} catch (IOException e) {
  			e.printStackTrace();
     }
     }
     
     //Die Text datei der Waren wird geschrieben
     public static void writeGoods() {
    	 File file = new File(pathdata+ "Goods.txt"); //Die neue File wird erzeugt

  		try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) { 
  			bw.write(firstlinegoods); //Die erste Zeile wird geschrieben
  			bw.newLine(); 
  			for (Good g : GasStation.getGoods()) {
				bw.write(g.displaytextfile()); //Ausgabe der Produkte
				if (GasStation.getGoods().indexOf(g) < GasStation.getGoods().size()-1) {
					bw.newLine();
				} else continue;
				
			}
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
  			for (Purchase p : GasStation.getPurchases()) {
				bw.write(p.displaytextfile()); //Ausgabe der Produkte
				if (GasStation.getPurchases().indexOf(p) < GasStation.getPurchases().size()-1) {
					bw.newLine();
				} else continue;
			}
  		} catch (IOException e) {
  			e.printStackTrace();
     }
     }
     
     
     //Die Text datei der Waren wird geschrieben
     public static void writeHistorysales() {
    	 File file = new File(pathdata+ "Historysales.txt"); //Die neue File wird erzeugt

  		try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) { 
  			bw.write(firstlinehistory); //Die erste Zeile wird geschrieben
  			bw.newLine(); 
  			for (Sale s : GasStation.getSales()) {
				bw.write(s.displaytextfile()); //Ausgabe der Produkte
				if (GasStation.getSales().indexOf(s) < GasStation.getSales().size()-1) {
					bw.newLine();
				} else continue;
			}
  		} catch (IOException e) {
  			e.printStackTrace();
     }
     }	
  	public static void createreceipt(double completesum) {
  	int numberofreceipt = GasStation.getSales().get(GasStation.getSales().size()-1).getSaleNumber() +1;
  	File file = new File(receiptsdata + "Einkaufsbeleg" + String.valueOf(numberofreceipt) + ".txt");
  	LocalDate today = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
	

  	
  	try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) { 
			bw.write(GasStation.getGasStationName()); //Die erste Zeile wird geschrieben
			bw.newLine(); 
			bw.newLine();
			bw.write("Belegnummer: "+String.valueOf(numberofreceipt));
			bw.newLine();
			bw.write("Datum:" + today.format(formatter));
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
     
     
     
     
     
}
     


