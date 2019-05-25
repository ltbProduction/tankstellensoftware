//package controller;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.Button;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//import models.Fuel;
//import models.GasStation;
//import utilities.Connector;
//
//public class Controller_GasPumpDialog implements Initializable {
//
//	// ObservableList<String> fueltype = FXCollections.observableArrayList("Super",
//	// "Diesel");
//
//	@FXML
//	private ComboBox<String> cb_fueltype;
//
//	@FXML
//	private TextField tf_amountoffuel;
//
//	@FXML
//	private Button b_addfuel;
//	
//	
//
//	// Variablen für Methodenaufruf
//	String chosenFuelType;
//	Double amountOfFuel;
//
//	@Override
//	public void initialize(URL location, ResourceBundle resources) {
//
//		// Dropdown-Menü initialisieren
//
//		cb_fueltype.getItems().removeAll(cb_fueltype.getItems()); // lösche vorhandene Werte aus Dropdown-Menü
//		cb_fueltype.getItems().addAll("Super", "Diesel"); // Füge Werte der Enum-Kraftstoffarten ein
//		cb_fueltype.getSelectionModel().select(0); // stelle ersten Wert als Standard ein
//
//	}
//	
//	
//	
//
//	@FXML
//	void addFuelToShoppingCart(ActionEvent event) {
//
//		// setze Parameterwerte
//		chosenFuelType = cb_fueltype.getValue();
//		amountOfFuel = Double.valueOf(tf_amountoffuel.getText());
//
//		// Wenn die Methode addFuelToShoppingCart "true" zurückgibt, wurde der
//		// Kraftstoff erfolgreich dem Warenkorb hinzugefügt. Das Zapfsäulen-Fenster wird
//		// dann geschlossen.
//		if (GasStation.addFuelToShoppingCart(chosenFuelType, amountOfFuel)) {
//			
//			utilities.Connector.Connecting(controller);
//			
//			Stage stage = (Stage) b_addfuel.getScene().getWindow();
//			stage.close();
//			// Wenn die Methode "false" zurückgibt, ist nicht mehr genügend Kraftstoff
//			// vorhanden. Der Index des Kraftstofftanks wird ermittelt. Der Nutzer wird
//			// anschließend über den Füllstand des Tanks informiert.
//		} else {
//
//			int i = Fuel.getIndex(chosenFuelType);
//
//			Alert alert = new Alert(AlertType.WARNING);
//			alert.setTitle("Kauf nicht möglich");
//			alert.setHeaderText("Kauf nicht möglich");
//			alert.setContentText("Es sind noch " + GasStation.getFuels().get(i).getAmount() + " Liter " + GasStation.getFuels().get(i).getName() + " verfügbar.");
//			alert.showAndWait();
//			
//
//		}
//
//	}
//
//	@FXML
//	void chooseFuelType(ActionEvent event) {
//
//	}
//
//	@FXML
//	void setAmountOfFuel(ActionEvent event) {
//
//	}
//
//}
