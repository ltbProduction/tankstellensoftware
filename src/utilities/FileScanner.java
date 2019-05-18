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

public class FileScanner {
//Der Classloader
	private static ClassLoader classLoader = new FileTransfer().getClass().getClassLoader();
	private static String datafile = "resource/textfiles/Data/";
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
	private static String fileNameEmployee = datafile + "Employee.txt";
	private static String fileNamePurchasesHistory = datafile + "Historypurchases.txt";
	private static String fileNameSalesHistory = datafile + "Historysales.txt";
	private static String fileNameGoods = datafile + "Goods.txt";
	private static String fileNameFuels = datafile+ "Fuels.txt";
    private static String fileNameDeliverGoods = "resource/textfiles/deliver/WarenLieferung.txt";
    private static String fileNameDeliverFuels = "resource/textfiles/deliver/KraftstoffLieferung.txt";

    
	//Mitarbeiter auslesen
		public static void readEmployee() {
			
			
		 
		     File file = new File(classLoader.getResource(fileNameEmployee).getFile());
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
		
		
	 
		     File file = new File(classLoader.getResource(fileNamePurchasesHistory).getFile());
		    
		     
			
			

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
			
				 
		     File file = new File(classLoader.getResource(fileNameSalesHistory).getFile());
		    
		     
			
			

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
		 
		     File file = new File(classLoader.getResource(fileNameGoods).getFile());
		     //Arraylist leeren
		     
			
			

			try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
				String line;
				br.readLine();
		
				while ((line = br.readLine()) != null) {
			
				String[] output = line.split(";");
				GasStation.getGoods().add(new Good(Integer.parseInt(output[0]), output[1], output[2], Integer.parseInt(output[3]), Double.parseDouble(output[4])));
					
					
		}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//Waren wurden ausgelesen und Objekt erzeugt 
		
		//Tanks werden ausgelesen und Objekte erzeugt.
		public static void readFuels() {
		 
		     File file = new File(classLoader.getResource(fileNameFuels).getFile());
		     
			
			

			try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
				String line;
				br.readLine();
		
				while ((line = br.readLine()) != null) {
			
				String[] output = line.split(";");
				GasStation.getFuels().add(new Fuel(Integer.parseInt(output[0]), output[1], output[2], Double.parseDouble(output[3]), Double.parseDouble(output[4])));
					
					
		}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
//Das auslesen der neuen Lieferungen
		
		public static void readDeliversGoods() throws ParseException, IOException   {
	     
	     File file = new File(classLoader.getResource(fileNameDeliverGoods).getFile());
	
	     //Schauen ob die File existiert
	     if (file.exists()) {
	    	 
	    	 
	    	 
	    	 //Datei auslesen
	    	 LocalDate dateofdelivery;// Das Lieferdatum
	    	 double sum = 0;//Die Endsumme
	    	 int newnumber = newdeliveriesnumber();
	    	 
	   
	    	 
	    	 try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
				String line;
				line = br.readLine(); //Die Zeile mit dem Lieferdatum
				String[] output = line.split("=");
				dateofdelivery = LocalDate.parse(output[1], formatter);//Lieferdatum wurde festgelegt
				
				br.readLine(); //Das auslesen der unwichtigen Zeile
				int numberofgood; //Die Nummer der Waren
				int newamount; //Die neue Menge
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
	    	 
	    	 
			}	 
	     //Es exitiert nicht dann lassen wir es halt
	    	
	     } // Methode beendet
	   
		
		public static void readDeliversFuels() throws IOException {
		
	     ClassLoader classLoader = new FileTransfer().getClass().getClassLoader();
	 
	     File file = new File(classLoader.getResource(fileNameDeliverFuels).getFile());
	     //Schauen ob die File existiert
	     if (file.exists()) {
	    
	    	 LocalDate dateofdelivery;// Das Lieferdatum
	    	 double sum = 0;//Die Endsumme
	    	 int newnumber = newdeliveriesnumber(); //Die Lieferungsnummer
	    	 
	   
	    	 
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
				
				//Preise für die Objekte anpassen
				GasStation.getFuels().get(0).setAmount((amountdiesel+GasStation.getFuels().get(0).getAmount())); //Die Menge des Dieseltanks auffüllen
				GasStation.getFuels().get(1).setAmount((amountsuper+GasStation.getFuels().get(1).getAmount())); //Die Menge des Supertanks auffüllen

				
				
				sum = pricesuper*amountsuper+pricediesel*amountdiesel; //Summe errechnen
				
				GasStation.getPurchases().add(new Purchase(newnumber, dateofdelivery, sum)); //Neuer Einkauf anlegen

				
				} catch (IOException  e) {
					e.printStackTrace();
					
				
				}
	    	 System.out.println("Test");
//	    	 safefilesinhistory(fileName, newnumber);
	    	 
			}	 
	     //Es exitiert nicht dann lassen wir es halt
	    	
	     } // Methode beendet
	
	
		//Die Methode welche den letzten Einkauf angibt
		private static int newdeliveriesnumber() {
			//Number des letzten einkauf auslesen
			int number;
			int size;
			Purchase purchase;
			size = GasStation.getPurchases().size()-1; //Die Zahl wo man das letze findet
			if (size == -1) { //Wenn es noch keinen Beleg gibt
				return 1;
			} else { //Sonst der letzte Beleg + 1
				purchase = GasStation.getPurchases().get(size);
				number = purchase.getPurchaseNumber() +1;
				return number;
			 }
		}
	
		
		
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


