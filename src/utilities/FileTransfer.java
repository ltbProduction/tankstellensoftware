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
	public static void main(String[] args) throws ParseException  {

	FileTransfer f1 = new FileTransfer();
	
    GasStation g1 = new GasStation("KKK");
    f1.start(g1);
    g1.display(); //Methode zum test

    
	}	
	
	
	
	public void start(GasStation gasstation) throws ParseException  {
	FileScanner fs1 = new FileScanner();
	readData(gasstation, fs1);
	scandeliveries(gasstation, fs1);
	}
	
	
	
	//Hier beginnt die wirkliche Klasse FileTransfer
	
	
	//Daten auslesen
	public void readData(GasStation gasstation, FileScanner fs1 ) {
		gasstation.clearArrayList();
		fs1.readGoods(gasstation);
		fs1.readFuels(gasstation);
		fs1.readSalesHistory(gasstation);
		fs1.readPurchasesHistory(gasstation);
		fs1.readEmployee(gasstation);
	}
	
	public void scandeliveries(GasStation gasstation, FileScanner fs1 ) throws ParseException {
		fs1.readDeliversGoods(gasstation);
		fs1.readDeliversFuels(gasstation);
		
		
		
		
		
	}
	
	
	

	}
	


