package utilities;

import java.io.IOException;
import java.text.ParseException;

import models.GasStation;





public class FileTransfer {
	
	//Das ist eine ausführende Klasse die später wieder rausgenommen wird. Sie ist nur da weil es noch kein Model gibt
	
	
	
	
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
		FileScanner.readDeliveryFuels();

		
		
		
	}
	
	public static void writetextfiles() {


		if(GasStation.getEmployees().size()!=0) {
		FileSetter.writeemployee();
		}
		
		if(GasStation.getFuels().size()!=0) {
		FileSetter.writefuels();
		}
		
		if(GasStation.getGoods().size()!=0) {
		FileSetter.writeGoods();
		}
		
		if(GasStation.getPurchases().size()!=0) {
		FileSetter.writeHistorypurchases();
		}
		
		if(GasStation.getSales().size()!=0) {
		FileSetter.writeHistorysales();
		}
	}
	
	public static void refresh() {
		writetextfiles();
		readData();
		
	}
	
	
	

	}
	
