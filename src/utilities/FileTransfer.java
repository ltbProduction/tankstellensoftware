package utilities;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;

import models.Fuel;
import models.GasStation;
import models.Good;




public class FileTransfer {
	
	//Das ist eine ausführende Klasse die später wieder rausgenommen wird. Sie ist nur da weil es noch kein Model gibt
	public static void main(String[] args) {

	FileTransfer f1 = new FileTransfer();
	
    GasStation g1 = new GasStation("KKK");
    f1.readData(g1);
    g1.displayproducts();
	}	
	
	
	
	
	
	//Hier beginnt die wirkliche Klasse FileTransfer
	
	
	//Daten auslesen
	public void readData(GasStation gasstation) {
		readGoods(gasstation);
		readFuels(gasstation);
		
	}
	//Waren werden ausgelesen und Objekte Goods erzeugt
	public void readGoods(GasStation gasstation) {
	     String fileName = "resource/textfiles/Data/Goods.txt";
	     ClassLoader classLoader = new FileTransfer().getClass().getClassLoader();
	 
	     File file = new File(classLoader.getResource(fileName).getFile());
	         
		
		

		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
			String line;
			br.readLine();
	
			while ((line = br.readLine()) != null) {
		
			String[] output = line.split(";");
			gasstation.addGood(new Good(Integer.parseInt(output[0]), output[1], output[2], Integer.parseInt(output[3]), Double.parseDouble(output[4])));
				
				
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
			gasstation.addFuel(new Fuel(Integer.parseInt(output[0]), output[1], output[2], Double.parseDouble(output[3]), Double.parseDouble(output[4])));
				
				
	}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	}
	


