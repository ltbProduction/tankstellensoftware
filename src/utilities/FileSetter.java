package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileSetter {
     private static String pathdata = "C:/Daten/workspace/Tanke/";
     private static String receiptsdata = "C:/Daten/workspace/Tanke/";
     private static String firstlineproduct = "Nummer;Name;Lagereinheit;Menge;Verkaufspreis";
     private static String firstlinehistory = "Nummer;Datum;Preis";
     private static String firstlineemployee = "Nummer;Name;Datum";
     
     public static void test() {

 		File file = new File("C:/Daten/workspace/wAd/text.txt");

 		try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) {
 			bw.write("Hallo Welt!");
 		} catch (IOException e) {
 			e.printStackTrace();
 		
     }
     }
}


