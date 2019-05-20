package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import models.Employee;
import models.FuelTank;
import models.FuelType;
import models.GasStation;
import models.Good;
import models.Purchase;
import models.Sale;

public class FileScanner {

	
	private static String datafile = "src/resource/textfiles/Data/";
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
	private static String fileNameEmployee = datafile + "Employee.txt";
	private static String fileNamePurchasesHistory = datafile + "Historypurchases.txt";
	private static String fileNameSalesHistory = datafile + "Historysales.txt";
	private static String fileNameGoods = datafile + "Goods.txt";
	private static String fileNameFuelTanks = datafile + "FuelTanks.txt";
    private static String fileNameDeliveryGoods = "src/resource/textfiles/deliveries/WarenLieferung.txt";
    private static String fileNameDeliveryFuels = "src/resource/textfiles/deliveries/KraftstoffLieferung.txt";
    private static String filenamedeliverhistory = "src/resource/textfiles/historydeliveries/Einkaufsbeleg";

    
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


		//Alle Kassenzettel werden ausgelesen und als Objekte erzeugt
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
				GasStation.getGoods().add(new Good(Integer.parseInt(output[0]), output[1], output[2], Double.parseDouble(output[3]), Double.parseDouble(output[4])));
					
					
		}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//Waren wurden ausgelesen und Objekt erzeugt 
		
		//Tanks werden ausgelesen und Objekte erzeugt.
		public static void readFuelTanks() {

		     File file = new File(fileNameFuelTanks);


		     
			try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
				String line;
				br.readLine();
		
				while ((line = br.readLine()) != null) {
			
				String[] output = line.split(";");
				GasStation.getFuelTanks().add(new FuelTank(Integer.parseInt(output[0]), FuelType.valueOf(output[1]), Double.parseDouble(output[2]), Double.parseDouble(output[3]), Double.parseDouble(output[4]), Double.parseDouble(output[5])));
									
		}
			} catch (IOException | NumberFormatException  e) {
				e.printStackTrace();
			}
		}
		
		
//Das auslesen der neuen Lieferungen
		
		public static void readDeliveryGoods() throws ParseException, IOException   {
	     

	     File file = new File(fileNameDeliveryGoods);

	
	     //Schauen ob die File existiert
	     if (file.exists()) {
	    	 
	    	 
	    	 
	    	 //Datei auslesen
	    	 LocalDate dateofdelivery;// Das Lieferdatum
	    	 double sum = 0;//Die Endsumme
	    	 int newnumber = Hilfmethoden.newdeliveriesnumber();
	    	 
	   
	    	 
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
								newamount = g.getAmount() + amount; //Die neue Menge für die Objekte
								g.setAmount(newamount);
								sum += amount*price;
							}
							else {
								continue;
							}
						}
						
					}
				
				GasStation.getPurchases().add(new Purchase(newnumber, dateofdelivery, sum));
				} catch (IOException  e) {
					e.printStackTrace();
					
				
				}
	    	 //Methode welche die Textdatei dann verschiebt in den deliveries history ordner
	    	
	          
	         // renaming the file and moving it to a new location 
	         if(file.renameTo 
	            (new File(filenamedeliverhistory + String.valueOf(newnumber)+".txt" ))) 
	         { 
	             // if file copied successfully then delete the original file 
	             file.delete(); 
	             System.out.println("File moved successfully"); 
	         } 
	         else
	         { 
	             System.out.println("Failed to move the file"); 
	         } 
	    	 
			}	 
	     //Es exitiert nicht dann lassen wir es halt
	    	
	     } // Methode beendet
	   
		
		public static void readDeliveryFuelTanks() throws IOException {
		
	 

	     File file = new File(fileNameDeliveryFuels);

	     //Schauen ob die File existiert
	     if (file.exists()) {
	    
	    	 LocalDate dateofdelivery;// Das Lieferdatum
	    	 double sum = 0;//Die Endsumme
	    	 int newnumber = Hilfmethoden.newdeliveriesnumber(); //Die Lieferungsnummer
	    	 
	   
	    	 
	    	 try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
				//Variable zum auslesen
	    		 
	    		 double  amountdiesel;
		    	 double pricediesel;
		    	 double amountsuper;
		    	 double pricesuper;
	    		 
	    		 
	    		String line;
				line = br.readLine(); //Die Zeile mit dem Lieferdatum
				String[] output = line.split("=");
				dateofdelivery = LocalDate.parse(output[1], formatter);//Lieferdatum wurde festgelegt
				
				line = br.readLine(); //Die Diesel Zeile
				output = line.split("=");
				amountdiesel = Double.parseDouble(output[1]);//Diesel Menge intialisiert
				
				line = br.readLine(); //Die Dieselpreis Zeile
				output = line.split("=");
				pricediesel = Double.parseDouble(output[1]);//Diesel Preis intialisiert
				
				line = br.readLine(); //Die super Zeile
				output = line.split("=");
				amountsuper = Double.parseDouble(output[1]);//super Menge intialisiert
				
				line = br.readLine(); //Die superpreis Zeile
				output = line.split("=");
				pricesuper = Double.parseDouble(output[1]);//super Preis intialisiert
				
				//Menge für die Objekte anpassen
				GasStation.getFuelTanks().get(0).setFuelLevel((amountdiesel+GasStation.getFuelTanks().get(0).getFuelLevel())); //Die Menge des Dieseltanks auffüllen
				GasStation.getFuelTanks().get(1).setFuelLevel((amountsuper+GasStation.getFuelTanks().get(1).getFuelLevel())); //Die Menge des Supertanks auffüllen
				
				GasStation.getFuelTanks().get(0).setPurchasePrice(pricediesel);
				GasStation.getFuelTanks().get(1).setPurchasePrice(pricesuper);

				
				sum = pricesuper*amountsuper+pricediesel*amountdiesel; //Summe errechnen
				
				GasStation.getPurchases().add(new Purchase(newnumber, dateofdelivery, sum)); //Neuer Einkauf anlegen

				
				} catch (IOException  e) {
					e.printStackTrace();
					
				
				}
	         if(file.renameTo 
	 	            (new File(filenamedeliverhistory + String.valueOf(newnumber)+".txt" ))) 
	 	         { 
	 	             // if file copied successfully then delete the original file 
	 	             file.delete(); 
	 	             System.out.println("File moved successfully"); 
	 	         } 
	 	         else
	 	         { 
	 	             System.out.println("Failed to move the file"); 
	 	         } 
	    	 
			}	 
	     //Es exitiert nicht dann lassen wir es halt
	    	
	     } // Methode beendet
	
	
		//Die Methode welche den letzten Einkauf angibt

	
		
		
//		
//		//Methoden welche die Datei in den anderen Ordner verschiebt
//		
//		private static void safefilesinhistory(String oldfile, int number) throws IOException {
//		
//		String staticfile = "resource/textfiles/historydeliveries/lastdeliver.txt";
//		String newfile = "resource/textfiles/historydeliveries/Lieferung" + String.valueOf(number) + ".txt";
//		System.out.println(newfile);	 
//		File file1 = new File(classLoader.getResource(oldfile).getFile()); //Die alte Datei in dem delivr Ordner
//		File file2 = new File(classLoader.getResource(staticfile).getFile()); //Die neue Datei
//		String path = file2.getAbsolutePath()+String.valueOf(number);
//		File file3 = new File(path);
//		
//		
//		file3.createNewFile(); //Neue Datei erzeugen
//		
//		copyFile(file1, file2);
//		
//		
//		
//			
//		}
//		
//		
//		//Die Methode welche schlussendlich die Datei kopiert.
//		public static void copyFile(File in, File out) throws IOException {
//	        FileChannel inChannel = null;
//	        FileChannel outChannel = null;
//	        try {
//	            inChannel = new FileInputStream(in).getChannel();
//	            outChannel = new FileOutputStream(out).getChannel();
//	            inChannel.transferTo(0, inChannel.size(), outChannel);
//	        } catch (IOException e) {
//	            throw e;
//	        } finally {
//	            try {
//	                if (inChannel != null)
//	                    inChannel.close();
//	                if (outChannel != null)
//	                    outChannel.close();
//	            } catch (IOException e) {}
//	        }
//	    }
//	 
//		
}


