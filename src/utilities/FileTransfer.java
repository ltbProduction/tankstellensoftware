package utilities;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;




public class FileTransfer {
	
	
	
	public void Datenauslesen() {
		
	     String fileName = "resource/textfiles/Data/Goods.txt";
	     ClassLoader classLoader = new FileTransfer().getClass().getClassLoader();
	 
	     File file = new File(classLoader.getResource(fileName).getFile());
	         
		
		

		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {

	FileTransfer f1 = new FileTransfer();
	f1.Datenauslesen();

	}
	}
	


