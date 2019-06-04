package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import javafx.collections.FXCollections;
import models.GasStation;


/**
 * @author Linus Brugger
 *
 */
public class FileTransfer {
	

	//File Transfer starten
	public static void start() throws ParseException, IOException  {
	readData();

	}
	
	
	
	//Daten auslesen
	public static void readData() {
		
		
		FileScanner.readGoods();
		FileScanner.readFuelTanks();
		FileScanner.readSalesHistory();
		FileScanner.readPurchasesHistory();
		FileScanner.readEmployee();
	}
	/*Die Methode entscheidet ob es sich bei der Datei file um einen KraftstoffLieferung oder um eine Warenbestellung.
	außerdem entscheidet es ob die einlieferung erfolgreich war bei folgender Ausgabe der Methode:
	1 heißt erfolgreich
	2 heißt kapazitätsgrenze übertroffen
	3 heißt Fehler in der Datei*/
	
	public static int scandeliveries(File file) throws ParseException, IOException {
		String line = null;
		int success = 0;
		String[] output = null;
		//Kontrolle um was für eine Lieferung es sich handelt
		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
			br.readLine();
			line = br.readLine();
			output = line.split("=");
			 
			
		} catch (IOException | NumberFormatException  e) {
			e.printStackTrace();
		}
		
		if(line.equals("Warennummer;Bezeichnung;Lagereinheit;Menge;Einkaufspreis")) {
			success = FileScanner.readDeliveryGoods(file);
		} else if (output[0].equals("DIESEL")) {
			success = FileScanner.readDeliveryFuels(file);
		} else success = 3;

		FXCollections.copy(GasStation.getGoods(), GasStation.getGoods());
		FXCollections.copy(GasStation.getFuels(), GasStation.getFuels());
		
		return success;
		
	}
	/*
	Hier werden die Textdateien geschrieben. Die Methode wird nur aufgerufen, wenn die größe der ArrayList nicht
	gleich null ist sonst es wahrscheinlich ein Fehler beim einlesen und die txt Datei würde sich verkleinern.
	*/
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
	

	
	
	

	}
	
