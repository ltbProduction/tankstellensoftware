package controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Fuel;
import models.GasStation;

public class Controller_GasPumpDialog implements Initializable {

	// ObservableList<String> fueltype = FXCollections.observableArrayList("Super",
	// "Diesel");

	@FXML
	private ComboBox<String> cb_fueltype;

	@FXML
	private TextField tf_amountoffuel;

	@FXML
	private Button b_addfuel;

	// Variablen f�r Methodenaufruf
	String chosenFuelName;
	Double amountOfFuel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Dropdown-Men� initialisieren

		cb_fueltype.getItems().removeAll(cb_fueltype.getItems()); // l�sche vorhandene Werte aus Dropdown-Men�
		cb_fueltype.getItems().addAll("Super", "Diesel"); // F�ge Werte der Enum-Kraftstoffarten ein
		cb_fueltype.getSelectionModel().select(0); // stelle ersten Wert als Standard ein

	}

	@FXML
	void addFuelToShoppingCart(ActionEvent event) {

		// setze Parameterwerte
		chosenFuelName = cb_fueltype.getValue(); 
		amountOfFuel = Double.valueOf(tf_amountoffuel.getText());

		if (Fuel.enoughFuelCheck(chosenFuelName, amountOfFuel) == false) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Kauf nicht m�glich");
			alert.setHeaderText("Kauf nicht m�glich");
			alert.setContentText("Der F�llstand des Kraftstofftanks ist zu niedrig.");

			alert.showAndWait();
			
			
		} else if (amountOfFuel < 100) { // Weniger als Hundert Liter tanken
			GasStation.addFuelToShoppingCart(chosenFuelName, amountOfFuel); // Kraftstoff dem Warenkorb hinzuf�gen
			Stage stage = (Stage) b_addfuel.getScene().getWindow(); // Fenster schlie�en
			stage.close();
			
			
		} else if (amountOfFuel > 100) { // Wenn mehr als hundert Liter getankt werden
			Alert alert = new Alert(AlertType.CONFIRMATION); // Best�tigungs-Dialog aufrufen
			alert.setTitle("Kraftstoff kaufen");
			alert.setHeaderText("Hohe Tankmenge");
			alert.setContentText("M�chten Sie wirklich �ber 100 Liter tanken?");

			Optional<ButtonType> result = alert.showAndWait();
			
			if (result.get() == ButtonType.OK) { // Wenn best�tigt wird
				GasStation.addFuelToShoppingCart(chosenFuelName, amountOfFuel); // Kraftstoff dem Warenkorb hinzuf�gen
				Stage stage = (Stage) b_addfuel.getScene().getWindow(); // Fenster schlie�en
				stage.close();
			} else {
				alert.close();
			}

		}

	}

	@FXML
	void chooseFuelType(ActionEvent event) {

	}

	@FXML
	void setAmountOfFuel(ActionEvent event) {

	}

}
