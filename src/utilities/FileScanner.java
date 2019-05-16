package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import models.Employee;
import models.Fuel;
import models.GasStation;
import models.Good;
import models.Purchase;
import models.Sale;

public class FileScanner {

	//Mitarbeiter auslesen
		public void readEmployee(GasStation gasstation) {
			SimpleDateFormat s1 = new SimpleDateFormat("dd/MM/yyyy");
			
			 String fileName = "resource/textfiles/Data/Employee.txt";
		     ClassLoader classLoader = new FileTransfer().getClass().getClassLoader();
		 
		     File file = new File(classLoader.getResource(fileName).getFile());
		     //Arraylist leeren
		     
			
			

			try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
				String line;
				br.readLine();
		
				while ((line = br.readLine()) != null) {
			
				String[] output = line.split(";");
				gasstation.getEmployees().add(new Employee(output[1], Integer.parseInt(output[0]), s1.parse(output[2])));
					
					
		}
			} catch (IOException | NumberFormatException | ParseException e) {
				e.printStackTrace();
			}
		}
			
		




		
		public void readPurchasesHistory(GasStation gasstation) {
		
			SimpleDateFormat s1 = new SimpleDateFormat("dd/MM/yyyy");
			
			 String fileName = "resource/textfiles/Data/Historypurchases.txt";
		     ClassLoader classLoader = new FileTransfer().getClass().getClassLoader();
		 
		     File file = new File(classLoader.getResource(fileName).getFile());
		    
		     
			
			

			try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
				String line;
				br.readLine();
		
				while ((line = br.readLine()) != null) {
			
				String[] output = line.split(";");
				gasstation.getPurchases().add(new Purchase(Integer.parseInt(output[0]), s1.parse(output[1]), Double.parseDouble(output[2])));
					
					
		}
			} catch (IOException | NumberFormatException | ParseException e) {
				e.printStackTrace();
			}
			
		}




		//Alle Kassenzettel werden ausgelesen und als Objekte erzeugt
		public void readSalesHistory(GasStation gasstation) {
			
			SimpleDateFormat s1 = new SimpleDateFormat("dd/MM/yyyy");
			
			 String fileName = "resource/textfiles/Data/Historysales.txt";
		     ClassLoader classLoader = new FileTransfer().getClass().getClassLoader();
		 
		     File file = new File(classLoader.getResource(fileName).getFile());
		    
		     
			
			

			try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
				String line;
				br.readLine();
		
				while ((line = br.readLine()) != null) {
			
				String[] output = line.split(";");
				gasstation.getSales().add(new Sale(Integer.parseInt(output[0]), s1.parse(output[1]), Double.parseDouble(output[2])));
					
					
		}
			} catch (IOException | NumberFormatException | ParseException e) {
				e.printStackTrace();
			}
			
		}





		//Waren werden ausgelesen und Objekte Goods erzeugt
		public void readGoods(GasStation gasstation) {
		     String fileName = "resource/textfiles/Data/Goods.txt";
		     ClassLoader classLoader = new FileTransfer().getClass().getClassLoader();
		 
		     File file = new File(classLoader.getResource(fileName).getFile());
		     //Arraylist leeren
		     
			
			

			try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
				String line;
				br.readLine();
		
				while ((line = br.readLine()) != null) {
			
				String[] output = line.split(";");
				gasstation.getGoods().add(new Good(Integer.parseInt(output[0]), output[1], output[2], Integer.parseInt(output[3]), Double.parseDouble(output[4])));
					
					
		}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//Waren wurden ausgelesen und Objekt erzeugt 
		
		//Tanks werden ausgelesen und Objekte erzeugt.
		public void readFuels(GasStation gasstation) {
		     String fileName = "resource/textfiles/Data/Fuels.txt";
		     ClassLoader classLoader = new FileTransfer().getClass().getClassLoader();
		 
		     File file = new File(classLoader.getResource(fileName).getFile());
		     
			
			

			try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
				String line;
				br.readLine();
		
				while ((line = br.readLine()) != null) {
			
				String[] output = line.split(";");
				gasstation.getFuels().add(new Fuel(Integer.parseInt(output[0]), output[1], output[2], Double.parseDouble(output[3]), Double.parseDouble(output[4])));
					
					
		}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
//Das auslesen der neuen Lieferungen
		
	public void readDeliversGoods(GasStation gasstation) throws ParseException {
	     String fileName = "resource/textfiles/delivers/WarenLieferung.txt";
	     ClassLoader classLoader = new FileTransfer().getClass().getClassLoader();
	 
	     File file = new File(classLoader.getResource(fileName).getFile());
	     SimpleDateFormat s1 = new SimpleDateFormat("dd.MM.yyyy"); //Format des Lieferungsdatum
	     //Schauen ob die File existiert
	     if (file.exists()) {
	    	 
	    	 
	    	 
	    	 //Datei auslesen
	    	 Date dateofdelivery;// Das Lieferdatum
	    	 double sum = 0;//Die Endsumme
	    	 int newnumber = newdeliveriesnumber(gasstation);
	    	 
	   
	    	 
	    	 try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
				String line;
				line = br.readLine(); //Die Zeile mit dem Lieferdatum
				String[] output = line.split("=");
				dateofdelivery = s1.parse(output[1]);//Lieferdatum wurde festgelegt
				
				br.readLine(); //Das auslesen der unwichtigen Zeile
				int numberofgood; //Die Nummer der Waren
				int newamount; //Die neue Menge
				int amount; //Die Menge der Lieferung
				double price;
					while ((line = br.readLine()) != null) {	//Schleife startet			
						output = line.split(";");
						numberofgood = Integer.parseInt(output[0]);
					
						// Alle Waren nach dem passenden Gut kontrollieren
						for (Good g : gasstation.getGoods()) {
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
				
				gasstation.getPurchases().add(new Purchase(newnumber, dateofdelivery, sum));
				} catch (IOException | ParseException e) {
					e.printStackTrace();
					
				
				}
	    	 //Methode welche die Textdatei dann verschiebt in den deliveries history ordner
	    	 
	    	 
			}	 
	     //Es exitiert nicht dann lassen wir es halt
	    	
	     } // Methode beendet
	     
	     
	     
	
	
	public void readDeliversFuels(GasStation gasstation) {
		
	     String fileName = "resource/textfiles/delivers/KraftstoffLieferung.txt";
	     ClassLoader classLoader = new FileTransfer().getClass().getClassLoader();
	 
	     File file = new File(classLoader.getResource(fileName).getFile());
	     SimpleDateFormat s1 = new SimpleDateFormat("dd.MM.yyyy"); //Format des Lieferungsdatum
	     //Schauen ob die File existiert
	     if (file.exists()) {
	    
	    	 Date dateofdelivery;// Das Lieferdatum
	    	 double sum = 0;//Die Endsumme
	    	 int newnumber = newdeliveriesnumber(gasstation); //Die Lieferungsnummer
	    	 
	   
	    	 
	    	 try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
				//Variable zum auslesen
	    		 
	    		 double  amountdiesel;
		    	 double pricediesel;
		    	 double amountsuper;
		    	 double pricesuper;
	    		 
	    		 
	    		String line;
				line = br.readLine(); //Die Zeile mit dem Lieferdatum
				String[] output = line.split("=");
				dateofdelivery = s1.parse(output[1]);//Lieferdatum wurde festgelegt
				
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
				gasstation.getFuels().get(0).setAmount((amountdiesel+gasstation.getFuels().get(0).getAmount())); //Die Menge des Dieseltanks auffüllen
				gasstation.getFuels().get(1).setAmount((amountsuper+gasstation.getFuels().get(1).getAmount())); //Die Menge des Supertanks auffüllen

				
				
				sum = pricesuper*amountsuper+pricediesel*amountdiesel; //Summe errechnen
				
				gasstation.getPurchases().add(new Purchase(newnumber, dateofdelivery, sum)); //Neuer Einkauf anlegen

				
				} catch (IOException | ParseException e) {
					e.printStackTrace();
					
				
				}
	    	 //Die Datei kann noch gelöscht werden
	    	 
			}	 
	     //Es exitiert nicht dann lassen wir es halt
	    	
	     } // Methode beendet
	
	
	
	private int newdeliveriesnumber(GasStation gasstation) {
		//Number des letzten einkauf auslesen
		int number;
		int size;
		Purchase purchase;
		size = gasstation.getPurchases().size()-1; //Die Zahl wo man das letze findet
		if (size == -1) { //Wenn es noch keinen Beleg gibt
			return 1;
		} else { //Sonst der letzte Beleg + 1
			purchase = gasstation.getPurchases().get(size);
			number = purchase.getPurchaseNumber() +1;
			return number;
		}

	}
	

}
