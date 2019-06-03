package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.GasStation;

public class ControllerChangePriceOfGoodsDialog implements Initializable {

	@FXML
	private Button btnConfirmPrice;

	@FXML
	private ComboBox<String> cbNameOfProduct;

	@FXML
	private TextField tfNewPrice;

	@FXML
	void confirmPrice(ActionEvent event) {

		double newPrice = 0;
		try {
			newPrice = Double.valueOf(tfNewPrice.getText());
		} catch (NumberFormatException e) {
			System.out.println("Das ist keine gültige Zahl");
		}

		GasStation.changePriceOfGood(cbNameOfProduct.getValue(), newPrice);

		// schließt das Fenster
		Stage stage = (Stage) btnConfirmPrice.getScene().getWindow();
		stage.close();

	}

	@FXML
	void nameOfProduct(ActionEvent event) {

	}

	@FXML
	void newPrice(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cbNameOfProduct.getItems().removeAll(cbNameOfProduct.getItems());
		cbNameOfProduct.getItems().addAll("Wodka Jelzin", "Filip Maurice", "Jupiter Schokoriegel", "Sitting Bull",
				"TK-Pizza Deluxe");
		cbNameOfProduct.getSelectionModel().select("Wodka Jelzin");
	}

}
