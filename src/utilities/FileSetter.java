package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileSetter {
     private static String pathdata = "C:/Daten/workspace/Tanke/";
     private static String receiptsdata = "C:/Daten/workspace/Tanke/";
     
     
     public static void test() {

 		File file = new File("C:/Daten/workspace/wAd/text.txt");

 		try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) {
 			bw.write("Hallo Welt!");
 		} catch (IOException e) {
 			e.printStackTrace();
 		
     }
     }
}


