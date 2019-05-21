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
		FileScanner.readDeliveryFuelTanks();

		
		
		
	}
	
	public static void writetextfiles() {


		if(GasStation.getEmployees().size()>1) {
		FileSetter.writeemployee();
		}
		
		if(GasStation.getFuelTanks().size()>1) {
		FileSetter.writefuels();
		}
		
		if(GasStation.getGoods().size()>1) {
		FileSetter.writeGoods();
		}

		FileSetter.writeHistorypurchases();
		FileSetter.writeHistorysales();

	}
	
	
	

	}
	
