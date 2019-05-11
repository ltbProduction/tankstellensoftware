package utilities;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;

import models.GasStation;
import models.Good;




public class FileTransfer {
	
	
	
	public void Datenauslesen() {
		
		
		
	     String fileName = "resource/textfiles/Data/Goods.txt";
	     ClassLoader classLoader = new FileTransfer().getClass().getClassLoader();
	 
	     File file = new File(classLoader.getResource(fileName).getFile());
	         
		
		

		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
			String line;
			br.readLine();
			int i = 0;
			while ((line = br.readLine()) != null) {
			i++;
			String[] output = line.split(";");
			Good g+i = new Good(price, duration, cog)
				
				
	}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {

	FileTransfer f1 = new FileTransfer();
	f1.Datenauslesen();
    GasStation g1 = new GasStation("KKK");
	}
	}
	


