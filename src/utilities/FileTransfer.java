package utilities;

import java.io.IOException;
import java.text.ParseException;





public class FileTransfer {
	
	//Das ist eine ausf�hrende Klasse die sp�ter wieder rausgenommen wird. Sie ist nur da weil es noch kein Model gibt
	
	
	
	
	public static void start() throws ParseException, IOException  {
	readData();
	scandeliveries();
	}
	
	
	
	//Hier beginnt die wirkliche Klasse FileTransfer
	
	
	//Daten auslesen
	public static void readData() {
		
		
		FileScanner.readGoods();
		FileScanner.readFuelTanks();
		FileScanner.readSalesHistory();
		FileScanner.readPurchasesHistory();
		FileScanner.readEmployee();
	}
	
	public static void scandeliveries() throws ParseException, IOException {

		FileScanner.readDeliveryGoods();
		FileScanner.readDeliveryFuelTanks();

		
		
		
	}
	
	public static void writetextfiles() {

		//System.out.println("Test");
		FileSetter.writeemployee();
		FileSetter.writefuels();
		FileSetter.writeGoods();
		FileSetter.writeHistorypurchases();
		FileSetter.writeSalepurchases();

	}
	
	
	

	}
	
