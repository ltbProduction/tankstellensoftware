package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.Window;
import models.Employee;
import models.Fuel;
import models.GasStation;
import models.Good;
import models.Product;
import models.Purchase;
import models.Sale;
import utilities.FileSetter;
import utilities.FileTransfer;
import utilities.Helpmethods;

/**
 * @author Lukas Blunck, Robin Birkhofer, Linus Brugger
 *
 */
public class ControllerMain implements Initializable {

	private File file;
	private FileChooser fileChooser;

	@FXML
	private TabPane tpMain;

	@FXML
	private Tab tStart;

	@FXML
	private Button btnGasPump1;

	@FXML
	private Button btnGasPump2;

	@FXML
	private Button btnGasPump5;

	@FXML
	private Button btnGasPump3;

	@FXML
	private Button btnGasPump4;

	@FXML
	private Button btnAddGoods;

	@FXML
	private TableView<Product> tvShoppingCart;

	@FXML
	private TableColumn<Product, String> tcShoppingCartName;

	@FXML
	private TableColumn<Product, Double> tcShoppingCartAmount;

	@FXML
	private TableColumn<Product, Double> tcShoppingCartUnitPrice;

	@FXML
	private TableColumn<Product, Double> tcShoppingCartTotal;

	@FXML
	private Label lblTotalPrice;

	@FXML
	private Button btnCash;

	@FXML
	private Button btnCheckInDelivery;

	@FXML
	private Button btnGoToGoods;

	@FXML
	private Button btnGoToFuel;

	@FXML
	private ImageView ivSuper;

	@FXML
	private ImageView ivDiesel;

	@FXML
	private Tab tGoods;

	@FXML
	private Button btnOrderGoods;

	@FXML
	private Button btnChangeGoodsPrice;

	@FXML
	private TextField tfOrderGoodNumber;

	@FXML
	private TextField tfOrderGoodAmount;

	@FXML
	private TableView<Good> tvGoodsStorage;

	@FXML
	private TableColumn<Good, Integer> tcGoodsStorageNr;

	@FXML
	private TableColumn<Good, String> tcGoodsStorageName;

	@FXML
	private TableColumn<Good, String> tcGoodsStorageStorageUnit;

	@FXML
	private TableColumn<Good, Double> tcGoodsStorageAmount;

	@FXML
	private TableColumn<Good, Double> tcGoodsStoragePurchasePrice;

	@FXML
	private TableColumn<Good, Double> tcGoodsStorageSalePrice;

	@FXML
	private Tab tFuel;

	@FXML
	private TableView<Fuel> tvFuelTanks;

	@FXML
	private TableColumn<Fuel, Integer> tcFuelTanksTankNumber;

	@FXML
	private TableColumn<Fuel, String> tcFuelTanksFuelType;

	@FXML
	private TableColumn<Fuel, Double> tcFuelTanksCapacity;

	@FXML
	private TableColumn<Fuel, Double> tcFuelTanksFuelLevel;

	@FXML
	private TableColumn<Fuel, Double> tcFuelTanksPurchasePrice;

	@FXML
	private TableColumn<Fuel, Double> tcFuelTanksSalePrice;

	@FXML
	private ComboBox<String> cbOrderFuelType;

	@FXML
	private TextField tfOrderFuelAmount;

	@FXML
	private Button btnOrderFuel;

	@FXML
	private Button btnChangeFuelPrice;

	@FXML
	private Tab tHistory;

	@FXML
	private Button btnShowBalance;

	@FXML
	private Label lblBalanceResult;

	@FXML
	private TableView<Purchase> tvPurchases;

	@FXML
	private TableColumn<Purchase, Integer> tcPurchasesNumber;

	@FXML
	private TableColumn<Purchase, LocalDate> tcPurchasesDate;

	@FXML
	private TableColumn<Purchase, Double> tcPurchasesPrice;

	@FXML
	private TableView<Sale> tvSales;

	@FXML
	private TableColumn<Sale, Integer> tcSalesNumber;

	@FXML
	private TableColumn<Sale, LocalDate> tcSalesDate;

	@FXML
	private TableColumn<Sale, Double> tcSalesPrice;

	@FXML
	private DatePicker dpBalanceStartDate;

	@FXML
	private DatePicker dpBalanceEndDate;

	@FXML
	private Tab tEmployees;

	@FXML
	private Button btnNewEmployee;

	@FXML
	private TableView<Employee> tvEmployees;

	@FXML
	private TableColumn<Employee, Integer> tcEmployeesNumber;

	@FXML
	private TableColumn<Employee, String> tcEmployeesName;

	@FXML
	private TableColumn<Employee, LocalDate> tcEmployeesDateOfEmployment;

	@FXML
	private AnchorPane apAddGoods;

	@FXML
	private AnchorPane apPayProcess;

	@FXML
	private TableView<Good> tvGoodsStorage2;

	@FXML
	private TableColumn<Good, Integer> tcGoodsStorage2Nr;

	@FXML
	private TableColumn<Good, String> tcGoodsStorage2Name;

	@FXML
	private TableView<Good> tvGoodsShoppingCart;

	@FXML
	private TableColumn<Good, String> tcGoodsShoppingCartName;

	@FXML
	private TableColumn<Good, Double> tcGoodsShoppingCartPrice;

	@FXML
	private TextField tfGoodsNumber;

	@FXML
	private TextField tfGoodsAmount;

	@FXML
	private Button btnAddToShoppingCart;

	@FXML
	private Button btnToCheckout;

	@FXML
	private Button btnToCheckout2;

	@FXML
	private AnchorPane apLogin;

	@FXML
	private TextField tfEmployeeNumber;

	@FXML
	private Button btnLogin;

	@FXML
	private Label lblWrongEmployeeNumber;

	@FXML
	private Label lblActiveEmployeeName;

	@FXML
	private AnchorPane apAddFuel;

	@FXML
	private ComboBox<String> cbFuelType;

	@FXML
	private TextField tfAmountOfFuel;

	@FXML
	private Button btnAddFuel;

	@FXML
	private Button btnAddGoodOrder;

	@FXML
	private TableView<Good> tvOrdersOfGoods;

	@FXML
	private TableColumn<Good, String> tcOrderGoodName;

	@FXML
	private TableColumn<Good, Double> tcOrderGoodAmount;

	@FXML
	private Button btnAddFuelOrder;

	@FXML
	private TableView<Fuel> tvOrdersOfFuel;

	@FXML
	private TableColumn<Fuel, String> tcOrderFuelType;

	@FXML
	private TableColumn<Fuel, Double> tcOrderFuelAmount;

	@FXML
	private Pane pane;

	@FXML
	private Label lblTotalPrice2;

	@FXML
	private TextField tfMoneyReceived;

	@FXML
	private Button btnConfirmMoneyReceived;

	@FXML
	private Label lblMoneyReturn;

	@FXML
	private Button btnContinue;

	@FXML
	private Button btnBackToStart;

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		// File-Chooser initialisieren
		fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Textdateien", "*.txt"));

		// Spalten einstellen

		cbOrderFuelType.getItems().removeAll(cbOrderFuelType.getItems()); // loesche vorhandene Werte aus //
																			// Dropdown-Menue
		cbOrderFuelType.getItems().addAll("Super", "Diesel"); // Fuege Werte der Enum-Kraftstoffarten ein
		cbOrderFuelType.getSelectionModel().select(0); // stelle ersten Wert als Standard ein

		cbFuelType.getItems().removeAll(cbFuelType.getItems()); // loesche vorhandene Werte aus Dropdown-Menue
		cbFuelType.getItems().addAll("Super", "Diesel"); // Fuege Werte der Enum-Kraftstoffarten ein
		cbFuelType.getSelectionModel().select(0); // stelle ersten Wert als Standard ein

		tcShoppingCartName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
		tcShoppingCartAmount.setCellValueFactory(new PropertyValueFactory<Product, Double>("amount"));
		tcShoppingCartUnitPrice.setCellValueFactory(new PropertyValueFactory<Product, Double>("salePrice"));
		tcShoppingCartTotal.setCellValueFactory(new PropertyValueFactory<Product, Double>("totalSalePrice"));
		tvShoppingCart.setItems(GasStation.getShoppingCart());

		tcGoodsStorageNr.setCellValueFactory(new PropertyValueFactory<Good, Integer>("number"));
		tcGoodsStorageName.setCellValueFactory(new PropertyValueFactory<Good, String>("name"));
		tcGoodsStorageStorageUnit.setCellValueFactory(new PropertyValueFactory<Good, String>("unit"));
		tcGoodsStorageAmount.setCellValueFactory(new PropertyValueFactory<Good, Double>("amount"));
		tcGoodsStoragePurchasePrice.setCellValueFactory(new PropertyValueFactory<Good, Double>("purchasePrice"));
		tcGoodsStorageSalePrice.setCellValueFactory(new PropertyValueFactory<Good, Double>("salePrice"));
		tvGoodsStorage.setItems(GasStation.getGoods());

		tcPurchasesNumber.setCellValueFactory(new PropertyValueFactory<Purchase, Integer>("purchaseNumber"));
		tcPurchasesDate.setCellValueFactory(new PropertyValueFactory<Purchase, LocalDate>("purchaseDate"));
		tcPurchasesPrice.setCellValueFactory(new PropertyValueFactory<Purchase, Double>("purchasePrice"));
		tvPurchases.setItems(GasStation.getBalancePurchases());

		tcSalesNumber.setCellValueFactory(new PropertyValueFactory<Sale, Integer>("saleNumber"));
		tcSalesDate.setCellValueFactory(new PropertyValueFactory<Sale, LocalDate>("saleDate"));
		tcSalesPrice.setCellValueFactory(new PropertyValueFactory<Sale, Double>("salePrice"));
		tvSales.setItems(GasStation.getBalanceSales());

		tcEmployeesNumber.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employeeNumber"));
		tcEmployeesName.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeName"));
		tcEmployeesDateOfEmployment
				.setCellValueFactory(new PropertyValueFactory<Employee, LocalDate>("dateOfEmployment"));
		tvEmployees.setItems(GasStation.getEmployees());

		tcGoodsStorage2Nr.setCellValueFactory(new PropertyValueFactory<Good, Integer>("number"));
		tcGoodsStorage2Name.setCellValueFactory(new PropertyValueFactory<Good, String>("name"));
		tvGoodsStorage2.setItems(GasStation.getGoods());

		tcGoodsShoppingCartName.setCellValueFactory(new PropertyValueFactory<Good, String>("name"));
		tcGoodsShoppingCartPrice.setCellValueFactory(new PropertyValueFactory<Good, Double>("totalSalePrice"));
		tvGoodsShoppingCart.setItems(GasStation.getShoppingCartGoods());

		tcFuelTanksTankNumber.setCellValueFactory(new PropertyValueFactory<Fuel, Integer>("number"));
		tcFuelTanksFuelType.setCellValueFactory(new PropertyValueFactory<Fuel, String>("name"));
		tcFuelTanksCapacity.setCellValueFactory(new PropertyValueFactory<Fuel, Double>("capacity"));
		tcFuelTanksFuelLevel.setCellValueFactory(new PropertyValueFactory<Fuel, Double>("amount"));
		tcFuelTanksPurchasePrice.setCellValueFactory(new PropertyValueFactory<Fuel, Double>("purchasePrice"));
		tcFuelTanksSalePrice.setCellValueFactory(new PropertyValueFactory<Fuel, Double>("salePrice"));
		tvFuelTanks.setItems(GasStation.getFuels());

		tcOrderGoodAmount.setCellValueFactory(new PropertyValueFactory<Good, Double>("amount"));
		tcOrderGoodName.setCellValueFactory(new PropertyValueFactory<Good, String>("name"));
		tvOrdersOfGoods.setItems(GasStation.getOrderGood());

		tcOrderFuelAmount.setCellValueFactory(new PropertyValueFactory<Fuel, Double>("amount"));
		tcOrderFuelType.setCellValueFactory(new PropertyValueFactory<Fuel, String>("name"));
		tvOrdersOfFuel.setItems(GasStation.getOrderFuel());

		fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Textdateien", "*.txt"));

		cbOrderFuelType.getItems().removeAll(cbOrderFuelType.getItems()); // loesche vorhandene Werte aus
																			// Dropdown-Menue
		cbOrderFuelType.getItems().addAll("Super", "Diesel"); // Fuege Werte der Enum-Kraftstoffarten ein
		cbOrderFuelType.getSelectionModel().select(0); // stelle ersten Wert als Standard ein

		lblTotalPrice2.setText(String.valueOf(GasStation.getTotalPrice()) + " EUR");
		lblTotalPrice.setText(String.valueOf(GasStation.getTotalPrice()) + " EUR");

	}

	/* Durch das Aufrufen dieser Methode gelangt man auf das Fenster Warenkorb, hier
	 kann der Anwender die gewuenschten Waren hinzufuegen
	 Wird ausgeloest wenn man im Tab "Start" auf "Waren hinzufuegen" klickt	*/
	 @FXML
	void onAddGoodsClick(ActionEvent event) {
		// Tabellen aktualisieren
		tvGoodsStorage2.setItems(GasStation.getGoods());
		tvGoodsShoppingCart.setItems(GasStation.getShoppingCartGoods());
		tpMain.setVisible(false);
		apAddGoods.setVisible(true);

	}

/*	 Durch betaetigen des Buttons "einloggen" wird diese Methode ausgeloest
	 Hier wird ueberprueft ob eine korrekte bzw. vorhandene Mitarbeiternummer
	 eingegeben wird
	 Bei korrekter Eingabe gelangt man auf den Startbildschirm
	 Ausserdem wird die Historie und die Ampel feur die Anzeige des Fuellstands
	 aktualisiert*/
	@FXML
	void onLogInClick(ActionEvent event) {

		int employeeNumber = 0;

		try {
			employeeNumber = Integer.valueOf(tfEmployeeNumber.getText());
		} catch (NumberFormatException e) {

		}

		if (GasStation.existingEmployee(employeeNumber) == true) {
			apLogin.setVisible(false);
			tpMain.setVisible(true);

			// Mitarbeiter auf aktiv setzen
			GasStation.setCurrentEmployee(employeeNumber);

			// aktiven Mitarbeitername ausgeben
			lblActiveEmployeeName.setText(GasStation.activeEmployee().getEmployeeName());

			// Ampel aktualisieren
			ivDiesel.setImage(GasStation.getTrafficLight(0));
			ivSuper.setImage(GasStation.getTrafficLight(1));

		} else {
			lblWrongEmployeeNumber.setText("ungueltige Mitarbeiternummer");

			// PopUp falls ungueltige Mitarbeiternummer eingegeben wird
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Fehler");
			alert.setHeaderText("ungueltige Mitarbeiternummer");
			alert.setContentText(null);
			alert.showAndWait();

		}

		// Die History erzeugen
		GasStation.createHistory();
		double sales = GasStation.createFullSales();
		double purchases = GasStation.createFullPurchases();
		double result = sales-purchases;
		result = Math.round(result *100.0)/100.0;
		
		lblBalanceResult.setText("Einnahmen: " + String.valueOf(sales) + " EUR\nAusgaben: " + String.valueOf(purchases)
				+ " EUR\nBetriebsergebnis: " + String.valueOf(result) + " EUR");

	}

/*	 Durch Aufrufen dieser Methode wird der ausgewaehlte Kraftstoff inklusive
	 Menge dem Warenkorb hinzugefuegt und bei fehlerhaften Eingaben PopUps
	 ausgegeben
	 Wird ausgeloest wenn man im Fenster "Zapfsaeule" auf den Button "hinzufuegen"
	 klickt*/
	@FXML
	void addFuelToShoppingCart(ActionEvent event) {

		// Variablen fuer Methodenaufruf
		String chosenFuelType;
		Double amountOfFuel = 0.0;

	/*	 Try-Anweisung wird ausgefuehrt, wenn Wert von amountOfFuel eine
		 Zahl ist*/

		try {
			// setze den Wert von amountOfFuel auf den Wert aus tfAmountOfFuel
			amountOfFuel = Double.valueOf(tfAmountOfFuel.getText());

			// setze chosenFuelType auf den ausgewaehlten Wert der ComboBox
			chosenFuelType = cbFuelType.getValue();

			// Wenn der Wert kleiner/gleich Null ist, gebe ein Alert aus
			if (amountOfFuel <= 0) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Falsche Eingabe");
				alert.setHeaderText("Falsche Eingabe");
				alert.setContentText("Bitte geben Sie eine positive Zahl ein.");
				alert.showAndWait();

			}

/*			 Sonst fuehre weiter aus:
			 Wenn die Methode addFuelToShoppingCart "true" zurueckgibt, wurde der
			 Kraftstoff erfolgreich dem Warenkorb hinzugefuegt. Das Zapfsaeulen-Fenster
			 wird dann geschlossen und das Label Gesamtbetrag auf den neuen
			 neuen Wert gesetzt.*/
			else if (GasStation.addFuelToShoppingCart(chosenFuelType, amountOfFuel)) {

				apAddFuel.setVisible(false);
				tpMain.setVisible(true);

				lblTotalPrice.setText(String.valueOf(GasStation.getTotalPrice()) + " EUR");
				lblTotalPrice2.setText(String.valueOf(GasStation.getTotalPrice()) + " EUR");

				// Ampel aktualisieren
				ivDiesel.setImage(GasStation.getTrafficLight(0));
				ivSuper.setImage(GasStation.getTrafficLight(1));

/*				 Wenn die Methode "false" zurueckgibt, ist nicht mehr genuegend Kraftstoff
				 vorhanden. Der Index des Kraftstofftanks wird ermittelt. Der Nutzer wird
				 anschliessend ueber den Fuellstand des Tanks informiert.*/
			} else {

				int i = Fuel.getIndex(chosenFuelType);

				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Kauf nicht moeglich");
				alert.setHeaderText("Kauf nicht moeglich");
				alert.setContentText("Es sind noch " + GasStation.getFuels().get(i).getAmount() + " Liter "
						+ GasStation.getFuels().get(i).getName() + " verfuegbar.");
				alert.showAndWait();

			}
		} catch (NumberFormatException e) {

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Falsche Eingabe");
			alert.setHeaderText("Falsche Eingabe");
			alert.setContentText("Bitte geben Sie einen gueltigen Wert ein.");
			alert.showAndWait();

		}

		tfAmountOfFuel.setText("");

	}

	// Methode die aufgerufen wird, wenn der Button "hinzufuegen" im "Waren
	// hinzufuegen"-Fenster geklickt wird
	@FXML
	void onAddGoodToShoppingCartClick(ActionEvent event) {

		// setze Parameterwerte
		int goodNumber = 0;
		double goodAmount = 0;

		try {
			goodNumber = Integer.valueOf(tfGoodsNumber.getText());
			goodAmount = Double.valueOf(tfGoodsAmount.getText());
			} catch (NumberFormatException e) {

			}

			if (GasStation.existingGood(goodNumber) == false) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Fehler");
				alert.setHeaderText("Diese Warennummer existiert nicht");
				alert.setContentText(null);
				alert.showAndWait();
			} else if (goodAmount <= 0) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Falsche Eingabe");
				alert.setHeaderText("Falsche Eingabe");
				alert.setContentText("Bitte geben Sie eine gueltige Menge ein.");
				alert.showAndWait();
			} else if (GasStation.existingGood(goodNumber)) {

/*				 Wenn die Methode addFuelToShoppingCart "true" zurueckgibt, wurde der
				 Kraftstoff erfolgreich dem Warenkorb hinzugefuegt. Das Label
				 Gesamtbetrag wird dann auf den Gesamtpreis der ShoppingCart-Liste gesetzt*/
				if (GasStation.addGoodToShoppingCart(goodNumber, goodAmount)) {

					lblTotalPrice2.setText(String.valueOf(GasStation.getTotalPrice()) + " EUR");
					lblTotalPrice.setText(String.valueOf(GasStation.getTotalPrice()) + " EUR");

				/* Wenn die Methode "false" zurueckgibt, ist nicht mehr genuegend Bestand
				 vorhanden. Der Index der Ware wird ermittelt. Der Nutzer wird
				 anschliessend ueber den Bestand der Ware informiert.*/
				} else {
					int i = Good.getIndex(goodNumber);
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Kauf nicht moeglich");
					alert.setHeaderText("Kauf nicht moeglich");
					alert.setContentText("Von der Ware " + GasStation.getGoods().get(i).getName() + " sind noch "
							+ (int) GasStation.getGoods().get(i).getAmount() + " Stueck verfuegbar.");
					alert.showAndWait();

				}

				tfGoodsNumber.setText("");
				tfGoodsAmount.setText("");

			}

	}

/*	 Wird ausgeloest wenn man im Tab "Start" auf "BAR" klickt
	 Durch diese Methode gelangt man zum Bezahlvorgang*/
	@FXML
	void onCashClick(ActionEvent event) throws IOException {

		if (GasStation.getShoppingCart().size() != 0) {



			tpMain.setVisible(false);
			apPayProcess.setVisible(true);

		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fehler");
			alert.setHeaderText("Der Warenkorb ist leer");
			alert.setContentText(null);
			alert.showAndWait();
		}

	}

/*	 Wird ausgeloest wenn man im Tab "Kraftstoff" auf den Button "Preise aendern"
	 klickt
	 Ruft das Fenster ChangePriceOfFuelDialog" auf*/
	@FXML
	void onChangeFuelPriceClick(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userInterface/ChangePriceOfFuelDialog.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1));
		stage.setTitle("Treibstoffpreis aendern");
		stage.show();

	}

/*	 Wird ausgeloest wenn man im Tab "Waren" auf den Button "Preise aendern"
	 klickt
	 Ruft das Fenster ChangePriceOfGoodsDialog" auf
*/	@FXML
	void onChangeGoodsPriceClick(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userInterface/ChangePriceOfGoodsDialog.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1));
		stage.setTitle("Warenpreis aendern");
		stage.show();
	}

	@FXML
	void onCheckInDeliveryClick(ActionEvent event) throws ParseException, IOException {

		Window window = btnCheckInDelivery.getScene().getWindow();
		file = fileChooser.showOpenDialog(window);

		if (file != null) { // Wenn nichts ausgewaehlt wurde
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Bestellung");
			int success = FileTransfer.scandeliveries(file);
			if (success == 1) { // 1 heisst alles hat funktioniert
				alert.setHeaderText("Die Lieferung wurde eingebucht!");
			} else if (success == 2) {
				alert.setHeaderText(
						"Es konnte nicht alles eingebucht werden -> KapazitÃ¤t des Tankes wurde Ã¼berschritten");
			} else {
				alert.setHeaderText(
						"Die Lieferung wurde nicht eingebucht, Fehler in der Textdatei. Bitte melden Sie sich beim Help-Desk.");
			}
			alert.setContentText(null);
			alert.showAndWait();
			FXCollections.copy(GasStation.getFuels(), GasStation.getFuels());
			FXCollections.copy(GasStation.getGoods(), GasStation.getGoods());

			// Ampel aktualisieren
			ivDiesel.setImage(GasStation.getTrafficLight(0));
			ivSuper.setImage(GasStation.getTrafficLight(1));
		}
	}

/*	 Wird ausgeloest wenn man im Tab "Start" auf einen der Buttons der Zapfsaeulen
	 klickt
	 Hierdurch gelangt man zum Fenster um Kraftstoff dem Warenkorb hinzuzufuegen*/
	@FXML
	void onGasPumpClick(ActionEvent event) throws IOException {

		// Tabellen aktualisieren

		tpMain.setVisible(false);
		apAddFuel.setVisible(true);

	}

/*	 Methode wird ausgeloest wenn man im Tab "Mitarbeiter" auf "neuer Mitarbeiter"
	 klickt
	 ruft das Fenster "NewEmployeeDialog" auf*/
	@FXML
	void onNewEmployeeClick(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userInterface/NewEmployeeDialog.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1));
		stage.setTitle("Neuer Mitarbeiter");
		stage.show();

	}

/*	 Methode wird ausgeloest wenn man im Tab "Kraftstoff" auf den Button
	 "abschicken" klickt
	 Durch das Aufrufen wird eine neue Kraftstoffbestellung erstellt*/
	@FXML
	void onOrderFuelClick(ActionEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Bestellung");
		if (GasStation.getOrderFuel().size() != 0) {
			Window window = btnOrderGoods.getScene().getWindow();
			file = fileChooser.showSaveDialog(window);
			// Abbruch
			if (file != null) {
				FileSetter.writeFuelOrder(file);
				FXCollections.copy(GasStation.getOrderFuel(), GasStation.getOrderFuel());

				alert.setHeaderText("Bestellung war erfolgreich!");
				alert.setContentText(null);
				alert.showAndWait();
			}
		} else {
			// Es ist keine Bestellung im Warenkorb
			alert.setHeaderText("Es ist keine Bestellung im Warenkorb");
			alert.setContentText(null);
			alert.showAndWait();
		}
		// Ampel aktualisieren
		ivDiesel.setImage(GasStation.getTrafficLight(0));
		ivSuper.setImage(GasStation.getTrafficLight(1));
	}

/*	 Methode wird ausgeloest wenn man im Tab "Waren" auf den Button "abschicken"
	 klickt
	 Durch das Aufrufen wird eine neue Warenbestellung erstellt*/
	@FXML
	void onOrderGoodsClick(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Bestellung");
		if (GasStation.getOrderGood().size() != 0) {
			Window window = btnOrderGoods.getScene().getWindow();
			file = fileChooser.showSaveDialog(window);
			if (file != null) {
				FileSetter.writeGoodsOrder(file);
				FXCollections.copy(GasStation.getOrderGood(), GasStation.getOrderGood());
				alert.setHeaderText("Bestellung war erfolgreich!");
				alert.setContentText(null);
				alert.showAndWait();
			}
		} else {
			alert.setHeaderText("Es gibt keine Bestellung im Warenkorb");
			alert.setContentText(null);
			alert.showAndWait();
		}

	}

/*	 Methode wird aufgerufen wenn man im Tab "Historie" auf den Button "OK" klickt
	 Gibt in Abhaengigkeit des Start- und Enddatums die Bilanz aus
	 Bei fehlerhaften Eingaben kommen PopUps*/
	@FXML
	void onShowBalanceClick(ActionEvent event) {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Fehler");

		try {
			LocalDate start = dpBalanceStartDate.getValue();
			LocalDate end = dpBalanceEndDate.getValue();
			// Wenn Startdatum vor Enddatum ist
			if (start.isBefore(end)) {
				GasStation.changeBalanceTable(start, end);
			} else {
				alert.setHeaderText("Das Startdatum ist nach dem Enddatum. Das ist nicht moeglich.");
				alert.setContentText(null);
				alert.showAndWait();
			}
		} catch (Exception e) {

			// PopUp fuer Fehler in der Eingabe

			alert.setHeaderText("Start und/oder Enddatum fehlen");
			alert.setContentText(null);
			alert.showAndWait();
			GasStation.createHistory();
		}
		double sales = GasStation.createFullSales();
		double purchases = GasStation.createFullPurchases();
		double result = sales-purchases;
		result = Math.round(result *100.0)/100.0;
		lblBalanceResult.setText("Einnahmen: " + String.valueOf(sales) + " EUR\nAusgaben: " + String.valueOf(purchases)
		+ " EUR\nBetriebsergebnis: " + String.valueOf(result) + " EUR");

	}

	// Durch das Aufrufen dieser Methode gelangt man wieder zurueck zum Startbildschirm
	@FXML
	void onToCheckoutClick(ActionEvent event) {

		apAddFuel.setVisible(false);
		apAddGoods.setVisible(false);
		tpMain.setVisible(true);

	}

	// Durch das Aufrufen dieser Methode gelangt man wieder zurueck zum Startbildschirm
	@FXML
	void onBackToStartClick(ActionEvent event) {

		apPayProcess.setVisible(false);
		tpMain.setVisible(true);

	}

	@FXML
	void onOrderGoodsClickStartScreen(ActionEvent event) {
		tpMain.getSelectionModel().select(tGoods);

	}

	@FXML
	void onOrderFuelClickStartScreen(ActionEvent event) {
		tpMain.getSelectionModel().select(tFuel);
	}

/*	 Wird ausgeloest wenn man im Tab "Waren" auf den Button "hinzufuegen" klickt
	 Fuegt je nach Eingabe die Waren die man bestellen moechte der Tabelle hinzu
	 Bei falschen Angaben kommen PopUps
	 Bei Eingabe der Nummer 666 wird das EasterEgg ausgeloest*/
	@FXML
	void onAddGoodOrderClick(ActionEvent event) throws IOException {

		int number = 0;
		double amount = 0;

		try {
			number = Integer.parseInt(tfOrderGoodNumber.getText());
			amount = Double.parseDouble(tfOrderGoodAmount.getText());

		} catch (NumberFormatException e) {

		}

		if (number == 666) {

			// Easter-Egg
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userInterface/EasterEggDialog.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.setTitle("Der Teufel ist da");
			stage.show();

		} else if (GasStation.existingGood(number) == false) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fehler");
			alert.setHeaderText("Diese Warennummer existiert nicht");
			alert.setContentText(null);
			alert.showAndWait();
		} else if (amount <= 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Falsche Eingabe");
			alert.setHeaderText("Falsche Eingabe");
			alert.setContentText("Bitte geben Sie eine gueltige Menge ein.");
			alert.showAndWait();
		} else if (GasStation.existingGood(number)) {
			GasStation.addGoodOrder(number, amount);

			tfOrderGoodNumber.setText("");
			tfOrderGoodAmount.setText("");
		}
	}

/*	 Wird ausgeloest wenn man im Tab "Kraftstoff" auf den Button "hinzufuegen"
	 klickt
	 Fuegt je nach Eingabe den Kraftstoff den man bestellen moechte der Tabelle
	 hinzu
	 Bei falschen Angaben kommen PopUps*/
	@FXML
	void onAddFuelOrderClick(ActionEvent event) {

		double amount = 0;

		try {
			amount = Double.parseDouble(tfOrderFuelAmount.getText());
		} catch (NumberFormatException e) {

		}

		// GasStation.addFuelOrder(cbOrderFuelType.getValue(), amount);

		if (amount <= 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Falsche Eingabe");
			alert.setHeaderText("Falsche Eingabe");
			alert.setContentText("Bitte geben Sie eine gueltige Menge ein.");
			alert.showAndWait();
		} else {
			GasStation.addFuelOrder(cbOrderFuelType.getValue(), amount);
		}

		tfOrderFuelAmount.setText("");
	}

/*	 Wird ausgeloest wenn man beim Abschliessen des Bezahlvorgangs auf "Berechnen"
	 klickt
	 Hierdurch wird das Rueckgeld angezeigt in Abhaengigkeit des gegebenen Geldes
	 Bei falschen Eingaben kommen PopUps*/
	@FXML
	void onConfirmMoneyReceived(ActionEvent event) {

		double moneyReceived = 0;

		try {
			moneyReceived = Double.parseDouble(tfMoneyReceived.getText());

			// Setze Label auf die Differenz von gegebenem Geld - Gesamtbetrag (gerundet)
			if (moneyReceived > 0) {
				lblMoneyReturn.setText(
						String.valueOf(Math.round(100.0 * (moneyReceived - GasStation.getTotalPrice())) / 100.0) + " EUR");
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Fehler");
				alert.setHeaderText("Bitte eine positive Zahl eingeben.");
				alert.setContentText(null);
				alert.showAndWait();
			}

		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fehler");
			alert.setHeaderText("Bitte eine positive Zahl eingeben.");
			alert.setContentText(null);
			alert.showAndWait();
		}

	}

/*	 Wird ausgeloest wenn man beim Abschliessen des Bezahlvorgangs auf "Berechnen"
	 klickt
	 Schlie�t den Bezahlvorgang komplett ab
	 Anwender kann dann auswaehlen wo er den Verkaufsbeleg speichern moechte*/
	@FXML
	void onContinue(ActionEvent event) {

		// Die neue Verkaufsnummer
		int salenumber = Helpmethods.newsalesnumber();
		// Was soll beim schliessen passieren
		// Stage stage = (Stage) btnContinue.getScene().getWindow();

		// Das DiagonalFeld welches den Speicherort nachfraegt
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Speicherort");
		alert.setHeaderText("Wo moechten Sie den Beleg Speichern?");

		ButtonType saveReceiptAs = new ButtonType("Speicherort auswaehlen");
		ButtonType saveReceiptDesktop = new ButtonType("Desktop");
		alert.getButtonTypes().clear();

		alert.getButtonTypes().addAll(saveReceiptAs, saveReceiptDesktop);

		Optional<ButtonType> option = alert.showAndWait();

		if (option.get() == saveReceiptAs) {
			// Den Filechooser ausloesen
			Window window = btnContinue.getScene().getWindow();
			file = fileChooser.showSaveDialog(window);
			if (file != null) {

				GasStation.finishedreceipt(file, salenumber);

				// schliesst das Fenster
				apPayProcess.setVisible(false);
				tpMain.setVisible(true);
			}
		} else if (option.get() == saveReceiptDesktop) {
			String home = System.getProperty("user.home");
			//Auf dem Desktop speichern
			String filename = home + "/Desktop/Beleg" + String.valueOf(salenumber) + ".txt";
			File file = new File(filename);
			GasStation.finishedreceipt(file, salenumber);
			// schliesst das Fenster
			apPayProcess.setVisible(false);
			tpMain.setVisible(true);
		}

		// Gesamtbetrag-Label aktualisieren, Text-Feld leeren
		lblTotalPrice2.setText(String.valueOf(GasStation.getTotalPrice()) + " EUR");
		lblTotalPrice.setText(String.valueOf(GasStation.getTotalPrice()) + " EUR");
		tfMoneyReceived.setText("");
	}
}