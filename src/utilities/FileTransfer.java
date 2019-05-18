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




public class FileTransfer {
	
	//Das ist eine ausführende Klasse die später wieder rausgenommen wird. Sie ist nur da weil es noch kein Model gibt
	
	
	
	
	public static void start() throws ParseException, IOException  {
	readData();
	scandeliveries();
	}
	
	
	
	//Hier beginnt die wirkliche Klasse FileTransfer
	
	
	//Daten auslesen
	public static void readData() {
		GasStation.clearArrayList();
		FileScanner.readGoods();
		FileScanner.readFuels();
		FileScanner.readSalesHistory();
		FileScanner.readPurchasesHistory();
		FileScanner.readEmployee();
	}
	
	public static void scandeliveries() throws ParseException, IOException {
		FileScanner.readDeliversGoods();
		FileScanner.readDeliversFuels();
		
		
		
		
		
	}
	
	
	

	}
	
