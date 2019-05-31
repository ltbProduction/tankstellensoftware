package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
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

public class Controller_Main implements Initializable {

	private File file;
	private FileChooser fileChooser;

	@FXML
	private TabPane TabPane_main;

	@FXML
	private Tab t_start;

	@FXML
	private Button b_gaspump1;

	@FXML
	private Button b_gaspump2;

	@FXML
	private Button b_gaspump5;

	@FXML
	private Button b_gaspump3;

	@FXML
	private Button b_gaspump4;

	@FXML
	private Button b_addgoods;

	@FXML
	private TableView<Product> tv_shoppingcart;

	@FXML
	private TableColumn<Product, String> tc_shoppingcart_name;

	@FXML
	private TableColumn<Product, Double> tc_shoppingcart_amount;

	@FXML
	private TableColumn<Product, Double> tc_shoppingcart_unitprice;

	@FXML
	private TableColumn<Product, Double> tc_shoppingcart_total;

	@FXML
	private Label l_totalprice;

	@FXML
	private Button b_bar;

	@FXML
	private Button b_checkindelivery;

	@FXML
	private Button b_gotogoods;

	@FXML
	private Button b_gotofuel;

	@FXML
	private ImageView imageview_super;

	@FXML
	private ImageView imageview_diesel;

	@FXML
	private Tab t_goods;

	@FXML
	private Button b_ordergoods;

	@FXML
	private Button b_changegoodsprice;

	@FXML
	private TextField tf_ordergoodnumber;

	@FXML
	private TextField tf_ordergoodamount;

	@FXML
	private TableView<Good> tv_goodsstorage;

	@FXML
	private TableColumn<Good, Integer> tc_goodsstorage_nr;

	@FXML
	private TableColumn<Good, String> tc_goodsstorage_name;

	@FXML
	private TableColumn<Good, String> tc_goodsstorage_storageunit;

	@FXML
	private TableColumn<Good, Double> tc_goodsstorage_amount;

	@FXML
	private TableColumn<Good, Double> tc_goodsstorage_purchaseprice;

	@FXML
	private TableColumn<Good, Double> tc_goodsstorage_saleprice;

	@FXML
	private Tab t_fuel;

	@FXML
	private TableView<Fuel> tv_fueltanks;

	@FXML
	private TableColumn<Fuel, Integer> tc_fueltanks_tanknumber;

	@FXML
	private TableColumn<Fuel, String> tc_fueltanks_fueltype;

	@FXML
	private TableColumn<Fuel, Double> tc_fueltanks_capacity;

	@FXML
	private TableColumn<Fuel, Double> tc_fueltanks_fuellevel;

	@FXML
	private TableColumn<Fuel, Double> tc_fueltanks_purchaseprice;

	@FXML
	private TableColumn<Fuel, Double> tc_fueltanks_saleprice;

	@FXML
	private ComboBox<String> cb_orderfueltype;

	@FXML
	private TextField tf_orderfuelamount;

	@FXML
	private Button b_orderfuel;

	@FXML
	private Button b_changefuelprice;

	@FXML
	private Tab t_history;

	@FXML
	private Button b_showbalance;

	@FXML
	private Label l_balanceresult;

	@FXML
	private TableView<Purchase> tv_purchases;

	@FXML
	private TableColumn<Purchase, Integer> tc_purchases_number;

	@FXML
	private TableColumn<Purchase, LocalDate> tc_purchases_date;

	@FXML
	private TableColumn<Purchase, Double> tc_purchases_price;

	@FXML
	private TableView<Sale> tv_sales;

	@FXML
	private TableColumn<Sale, Integer> tc_sales_number;

	@FXML
	private TableColumn<Sale, LocalDate> tc_sales_date;

	@FXML
	private TableColumn<Sale, Double> tc_sales_price;

	@FXML
	private DatePicker dp_balancestartdate;
	
	@FXML
	private DatePicker dp_balanceenddate;

	@FXML
	private Tab t_employees;

	@FXML
	private Button b_newemployee;

	@FXML
	private TableView<Employee> tv_employees;

	@FXML
	private TableColumn<Employee, Integer> tc_employees_number;

	@FXML
	private TableColumn<Employee, String> tc_employees_name;

	@FXML
	private TableColumn<Employee, LocalDate> tc_employees_dateofemployment;

	@FXML
	private AnchorPane AP_addGoods;

	@FXML
	private TableView<Good> tv_goodsstorage2;

	@FXML
	private TableColumn<Good, Integer> tc_goodsstorage2_nr;

	@FXML
	private TableColumn<Good, String> tc_goodsstorage2_name;

	@FXML
	private TableView<Good> tv_goodsshoppingcart;

	@FXML
	private TableColumn<Good, String> tc_goodsshoppingcart_name;

	@FXML
	private TableColumn<Good, Double> tc_goodsshoppingcart_price;

	@FXML
	private TextField tf_goodsnumber;

	@FXML
	private TextField tf_goodsamount;

	@FXML
	private Button b_addtoshoppingcart;

	@FXML
	private Button b_tocheckout;

	@FXML
	private Button b_tocheckout2;

	@FXML
	private AnchorPane AP_LogIn;

	@FXML
	private TextField tf_employeenumber;

	@FXML
	private Button b_login;

	@FXML
	private Label l_wrongemployeenumber;

	@FXML
	private Label l_activeemployeename;

	@FXML
	private AnchorPane AP_addFuel;

	@FXML
	private ComboBox<String> cb_fueltype;

	@FXML
	private TextField tf_amountoffuel;

	@FXML
	private Button b_addfuel;

	@FXML
	private Button b_addgoodorder;

	@FXML
	private TableView<Good> tv_ordersofgoods;

	@FXML
	private TableColumn<Good, String> tc_ordergoodname;

	@FXML
	private TableColumn<Good, Double> tc_ordergoodamount;

	@FXML
	private Button b_addfuelorder;

	@FXML
	private TableView<Fuel> tv_ordersoffuel;

	@FXML
	private TableColumn<Fuel, String> tc_orderfueltype;

	@FXML
	private TableColumn<Fuel, Double> tc_orderfuelamount;

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		// Spalten einstellen
		
		cb_orderfueltype.getItems().removeAll(cb_orderfueltype.getItems()); // lÃ¶sche vorhandene Werte aus
																			// Dropdown-MenÃ¼
		cb_orderfueltype.getItems().addAll("Super", "Diesel"); // FÃ¼ge Werte der Enum-Kraftstoffarten ein
		cb_orderfueltype.getSelectionModel().select(0); // stelle ersten Wert als Standard ein

		cb_fueltype.getItems().removeAll(cb_fueltype.getItems()); // lÃ¶sche vorhandene Werte aus Dropdown-MenÃ¼
		cb_fueltype.getItems().addAll("Super", "Diesel"); // FÃ¼ge Werte der Enum-Kraftstoffarten ein
		cb_fueltype.getSelectionModel().select(0); // stelle ersten Wert als Standard ein

		tc_shoppingcart_name.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
		tc_shoppingcart_amount.setCellValueFactory(new PropertyValueFactory<Product, Double>("amount"));
		tc_shoppingcart_unitprice.setCellValueFactory(new PropertyValueFactory<Product, Double>("salePrice"));
		tc_shoppingcart_total.setCellValueFactory(new PropertyValueFactory<Product, Double>("totalSalePrice"));
		tv_shoppingcart.setItems(GasStation.getShoppingCart());

		tc_goodsstorage_nr.setCellValueFactory(new PropertyValueFactory<Good, Integer>("number"));
		tc_goodsstorage_name.setCellValueFactory(new PropertyValueFactory<Good, String>("name"));
		tc_goodsstorage_storageunit.setCellValueFactory(new PropertyValueFactory<Good, String>("unit"));
		tc_goodsstorage_amount.setCellValueFactory(new PropertyValueFactory<Good, Double>("amount"));
		tc_goodsstorage_purchaseprice.setCellValueFactory(new PropertyValueFactory<Good, Double>("purchasePrice"));
		tc_goodsstorage_saleprice.setCellValueFactory(new PropertyValueFactory<Good, Double>("salePrice"));
		tv_goodsstorage.setItems(GasStation.getGoods());

		tc_purchases_number.setCellValueFactory(new PropertyValueFactory<Purchase, Integer>("purchaseNumber"));
		tc_purchases_date.setCellValueFactory(new PropertyValueFactory<Purchase, LocalDate>("purchaseDate"));
		tc_purchases_price.setCellValueFactory(new PropertyValueFactory<Purchase, Double>("purchasePrice"));
		tv_purchases.setItems(GasStation.getBalancePurchases());

		tc_sales_number.setCellValueFactory(new PropertyValueFactory<Sale, Integer>("saleNumber"));
		tc_sales_date.setCellValueFactory(new PropertyValueFactory<Sale, LocalDate>("saleDate"));
		tc_sales_price.setCellValueFactory(new PropertyValueFactory<Sale, Double>("salePrice"));
		tv_sales.setItems(GasStation.getBalanceSales());

		tc_employees_number.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employeeNumber"));
		tc_employees_name.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeName"));
		tc_employees_dateofemployment
				.setCellValueFactory(new PropertyValueFactory<Employee, LocalDate>("dateOfEmployment"));
		tv_employees.setItems(GasStation.getEmployees());

		tc_goodsstorage2_nr.setCellValueFactory(new PropertyValueFactory<Good, Integer>("number"));
		tc_goodsstorage2_name.setCellValueFactory(new PropertyValueFactory<Good, String>("name"));
		tv_goodsstorage2.setItems(GasStation.getGoods());

		tc_goodsshoppingcart_name.setCellValueFactory(new PropertyValueFactory<Good, String>("name"));
		tc_goodsshoppingcart_price.setCellValueFactory(new PropertyValueFactory<Good, Double>("totalSalePrice"));
		tv_goodsshoppingcart.setItems(GasStation.getShoppingCartGoods());

		tc_fueltanks_tanknumber.setCellValueFactory(new PropertyValueFactory<Fuel, Integer>("number"));
		tc_fueltanks_fueltype.setCellValueFactory(new PropertyValueFactory<Fuel, String>("name"));
		tc_fueltanks_capacity.setCellValueFactory(new PropertyValueFactory<Fuel, Double>("capacity"));
		tc_fueltanks_fuellevel.setCellValueFactory(new PropertyValueFactory<Fuel, Double>("amount"));
		tc_fueltanks_purchaseprice.setCellValueFactory(new PropertyValueFactory<Fuel, Double>("purchasePrice"));
		tc_fueltanks_saleprice.setCellValueFactory(new PropertyValueFactory<Fuel, Double>("salePrice"));
		tv_fueltanks.setItems(GasStation.getFuels());

		l_totalprice.setText(String.valueOf(GasStation.getTotalPrice()));

		tc_ordergoodamount.setCellValueFactory(new PropertyValueFactory<Good, Double>("amount"));
		tc_ordergoodname.setCellValueFactory(new PropertyValueFactory<Good, String>("name"));
		tv_ordersofgoods.setItems(GasStation.getOrderGood());

		tc_orderfuelamount.setCellValueFactory(new PropertyValueFactory<Fuel, Double>("amount"));
		tc_orderfueltype.setCellValueFactory(new PropertyValueFactory<Fuel, String>("name"));
		tv_ordersoffuel.setItems(GasStation.getOrderFuel());

		fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Textdateien", "*.txt"));

		cb_orderfueltype.getItems().removeAll(cb_orderfueltype.getItems()); // lÃ¶sche vorhandene Werte aus
																			// Dropdown-MenÃ¼
		cb_orderfueltype.getItems().addAll("Super", "Diesel"); // FÃ¼ge Werte der Enum-Kraftstoffarten ein
		cb_orderfueltype.getSelectionModel().select(0); // stelle ersten Wert als Standard ein

	}

	@FXML
	void OnAddGoodsClick(ActionEvent event) {
		// Tabellen aktualisieren
		tv_goodsstorage2.setItems(GasStation.getGoods());
		tv_goodsshoppingcart.setItems(GasStation.getShoppingCartGoods());
		TabPane_main.setVisible(false);
		AP_addGoods.setVisible(true);

	}

	@FXML
	void OnLogInClick(ActionEvent event) {

		int employeeNumber = 0;

		try {
			employeeNumber = Integer.valueOf(tf_employeenumber.getText());
		} catch (NumberFormatException e) {
			System.out.println("Das ist kein Integer");
		}

		if (GasStation.existingEmployee(employeeNumber) == true) {
			AP_LogIn.setVisible(false);
			TabPane_main.setVisible(true);
			System.out.println("Erfolgreicher Login");

			// Mitarbeiter auf aktiv setzen
			GasStation.setCurrentEmployee(employeeNumber);

			// aktive Mitarbeitername ausgeben
			l_activeemployeename.setText(GasStation.activeEmployee().getEmployeeName());

			// Ampel aktualisieren
			imageview_diesel.setImage(GasStation.getTrafficLight(0));
			imageview_super.setImage(GasStation.getTrafficLight(1));

		} else {
			l_wrongemployeenumber.setText("ungültige Mitarbeiternummer");
			System.out.println("Ungültige Mitarbeiternummer");

			// PopUp für ungültige Mitarbeiternummer
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Fehler");
			alert.setHeaderText("ungültige Mitarbeiternummer");
			alert.setContentText(null);
			alert.showAndWait();

		}
		
		//Die History erzeugen
		GasStation.createHistory();
		double sales = GasStation.createFullSales();
		double purchases = GasStation.createFullPurchases();
		l_balanceresult.setText("Einnahmen: "+String.valueOf(sales)+" � Ausgabe: " + String.valueOf(purchases)+ " � Betriebsergebnis: "+ String.valueOf(sales-purchases) + " �");

	}

	@FXML
	void addFuelToShoppingCart(ActionEvent event) {

		// Variablen für Methodenaufruf
		String chosenFuelType;
		Double amountOfFuel = 0.0;

		// Try-Anweisung wird ausgeführt, wenn Wert von amountOfFuel eine
		// Zaahl ist

		try {
			// setze den Wert von amountOfFuel auf den Wert aus tf_amountoffuel
			amountOfFuel = Double.valueOf(tf_amountoffuel.getText());

			// setze chosenFuelType auf den ausgewählten Wert der ComboBox
			chosenFuelType = cb_fueltype.getValue();

			// Wenn der Wert kleiner/gleich Null ist, gebe ein Alert aus
			if (amountOfFuel <= 0) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Falsche Eingabe");
				alert.setHeaderText("Falsche Eingabe");
				alert.setContentText("Bitte geben Sie eine positive Zahl ein.");
				alert.showAndWait();

			}

			// Sonst führe weiter aus:
			// Wenn die Methode addFuelToShoppingCart "true" zurückgibt, wurde der
			// Kraftstoff erfolgreich dem Warenkorb hinzugefügt. Das Zapfsäulen-Fenster
			// wird dann geschlossen und das Label Gesamtbetrag auf den neuen
			// neuen Wert gesetzt.
			else if (GasStation.addFuelToShoppingCart(chosenFuelType, amountOfFuel)) {

				AP_addFuel.setVisible(false);
				TabPane_main.setVisible(true);

				l_totalprice.setText(String.valueOf(GasStation.getTotalPrice()));

				// Ampel aktualisieren
				imageview_diesel.setImage(GasStation.getTrafficLight(0));
				imageview_super.setImage(GasStation.getTrafficLight(1));

				// Wenn die Methode "false" zurückgibt, ist nicht mehr genügend Kraftstoff
				// vorhanden. Der Index des Kraftstofftanks wird ermittelt. Der Nutzer wird
				// anschließend über den Füllstand des Tanks informiert.
			} else {

				int i = Fuel.getIndex(chosenFuelType);

				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Kauf nicht möglich");
				alert.setHeaderText("Kauf nicht möglich");
				alert.setContentText("Es sind noch " + GasStation.getFuels().get(i).getAmount() + " Liter "
						+ GasStation.getFuels().get(i).getName() + " verfügbar.");
				alert.showAndWait();

			}
		} catch (NumberFormatException e) {
			System.out.println("Das ist kein Integer");

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Falsche Eingabe");
			alert.setHeaderText("Falsche Eingabe");
			alert.setContentText("Bitte geben Sie eine ganze Zahl ein.");
			alert.showAndWait();

		}

	}

	// Methode die aufgerufen wird, wenn der Button "HinzufÃ¼gen" im "Waren
	// hinzufÃ¼gen"-Fenster geklickt wird
	@FXML
	void onAddGoodToShoppingCartClick(ActionEvent event) {

		// setze Parameterwerte
		int goodNumber = 0;
		double goodAmount = 0;

		try {
			goodNumber = Integer.valueOf(tf_goodsnumber.getText());
		} catch (NumberFormatException e) {
			System.out.println("Das ist keine Ganzzahl");
		}

		try {
			goodAmount = Double.valueOf(tf_goodsamount.getText());
		} catch (NumberFormatException e) {
			System.out.println("Das ist keine Dezimalzahl");
		}

		// Wenn die Methode addFuelToShoppingCart "true" zurükgibt, wurde der
		// Kraftstoff erfolgreich dem Warenkorb hinzugefügt. Das Label
		// Gesamtbetrag wird dann auf den Gesamtpreis der ShoppingCart-Liste gesetzt
		if (GasStation.addGoodToShoppingCart(goodNumber, goodAmount)) {

			l_totalprice.setText(String.valueOf(GasStation.getTotalPrice()));
			// Wenn die Methode "false" zurÃ¼ckgibt, ist nicht mehr genÃ¼gend Bestand
			// vorhanden. Der Index der Ware wird ermittelt. Der Nutzer wird
			// anschlieÃend Ã¼ber den Bestand der Ware informiert.
		} else {

			int i = Good.getIndex(goodNumber);
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Kauf nicht möglich");
			alert.setHeaderText("Kauf nicht möglich");
			alert.setContentText("Von der Ware " + GasStation.getGoods().get(i).getName() + " sind noch "
					+ (int) GasStation.getGoods().get(i).getAmount() + " Stück verfügbar.");
			alert.showAndWait();

		}

	}

	@FXML
	void onBarClick(ActionEvent event) throws IOException {

		// Gesamtbetrag-Label auf Null setzen
		l_totalprice.setText("0.00");

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userInterface/PayProcessDialog.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1));
		stage.setTitle("Bezahlvorgang");
		stage.show();

	}

	@FXML
	void onChangeFuelPriceClick(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userInterface/ChangePriceOfFuelDialog.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1));
		stage.setTitle("Treibstoffpreis ÃÂ¤ndern");
		stage.show();

	}

	@FXML
	void onChangeGoodsPriceClick(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userInterface/ChangePriceOfGoodsDialog.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1));
		stage.setTitle("Warenpreis ÃÂ¤ndern");
		stage.show();
	}

	@FXML
	void onCheckInDeliveryClick(ActionEvent event) throws ParseException, IOException {

		Window window = b_checkindelivery.getScene().getWindow();
		file = fileChooser.showOpenDialog(window);

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Bestellung");
		int success = FileTransfer.scandeliveries(file);
		if (success == 1) { // 1 heißt alles hat funktioniert
			alert.setHeaderText("Die Lieferung wurde eingebucht!");
		} else if (success == 2) {
			alert.setHeaderText(
					"Es konnte nicht alles eingebucht werden -> Kapazität des Tankes wurde überschritten");
		} else {
			alert.setHeaderText("Die Lieferung wurde nicht eingebucht, Fehler in der Textdatei. Bitte melden Sie sich beim Help-Desk.");
		}
		alert.setContentText(null);
		alert.showAndWait();

		// Ampel aktualisieren
		imageview_diesel.setImage(GasStation.getTrafficLight(0));
		imageview_super.setImage(GasStation.getTrafficLight(1));

	}

	@FXML
	void onGasPumpClick(ActionEvent event) throws IOException {

//		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userInterface/GasPumpDialog.fxml"));
//		Parent root1 = (Parent) fxmlLoader.load();
//		Stage stage = new Stage();
//		stage.setScene(new Scene(root1));
//		stage.setTitle("ZapfsÃÂ¯ÃÂ¿ÃÂ½ule");
//		stage.show();

		// Tabellen aktualisieren

		TabPane_main.setVisible(false);
		AP_addFuel.setVisible(true);

	}

	@FXML
	void onNewEmployeeClick(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userInterface/NewEmployeeDialog.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1));
		stage.setTitle("Neuer Mitarbeiter");
		stage.show();

	}

	@FXML
	void onOrderFuelClick(ActionEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Bestellung");
		if (GasStation.getOrderFuel().size() != 0) {
			Window window = b_ordergoods.getScene().getWindow();
			file = fileChooser.showSaveDialog(window);
			FileSetter.writeFuelOrder(file);
			FXCollections.copy(GasStation.getOrderFuel(), GasStation.getOrderFuel());
			
			alert.setHeaderText("Bestellung war erfolgreich!");
			alert.setContentText(null);
			alert.showAndWait();
		} else {
			// Es ist keine Bestellung im Warenkorb
			alert.setHeaderText("Es ist keine Bestellung im Warenkorb");
			alert.setContentText(null);
			alert.showAndWait();
		}
		// Ampel aktualisieren
		imageview_diesel.setImage(GasStation.getTrafficLight(0));
		imageview_super.setImage(GasStation.getTrafficLight(1));
	}

	@FXML
	void onOrderGoodsClick(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Bestellung");
		if (GasStation.getOrderGood().size() != 0) {
			Window window = b_ordergoods.getScene().getWindow();
			file = fileChooser.showSaveDialog(window);
			FileSetter.writeGoodsOrder(file);
			FXCollections.copy(GasStation.getOrderGood(), GasStation.getOrderGood());
			alert.setHeaderText("Bestellung war erfolgreich!");
			alert.setContentText(null);
			alert.showAndWait();
		} else {
			alert.setHeaderText("Es gibt keine Bestellung im Warenkorb");
			alert.setContentText(null);
			alert.showAndWait();
		}

	}

	@FXML
	void onShowBalanceClick(ActionEvent event) {
	try {
		LocalDate start = dp_balancestartdate.getValue();
		LocalDate end = dp_balanceenddate.getValue();
		
		GasStation.changeBalanceTable(start,end);
	} catch (Exception e) {
	
	// PopUp f�r Fehler in der Eingabe
	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setTitle("Fehler");
	alert.setHeaderText("Start und/oder Enddatum fehlen");
	alert.setContentText(null);
	alert.showAndWait();	
	GasStation.createHistory();
	}
	double sales = GasStation.createFullSales();
	double purchases = GasStation.createFullPurchases();
	l_balanceresult.setText("Einnahmen: "+String.valueOf(sales)+" � Ausgabe: " + String.valueOf(purchases)+ " � Betriebsergebnis: "+ String.valueOf(sales-purchases) + " �");

	}

	@FXML
	void onToCheckoutClick(ActionEvent event) {

		AP_addFuel.setVisible(false);
		AP_addGoods.setVisible(false);
		TabPane_main.setVisible(true);

	}

	@FXML
	void onOrderGoodsClickStartScreen(ActionEvent event) {
		TabPane_main.getSelectionModel().select(t_goods);

	}

	@FXML
	void onOrderFuelClickStartScreen(ActionEvent event) {
		TabPane_main.getSelectionModel().select(t_fuel);
	}

	@FXML
	void onAddGoodOrderClick(ActionEvent event) throws IOException {
		
			int number = 0;
			double amount = 0;
			
			try {
			number = Integer.parseInt(tf_ordergoodnumber.getText());
			amount = Double.parseDouble(tf_ordergoodamount.getText());
			} catch (NumberFormatException e) {
				System.out.println("Falsche Eingabe");
			}
			
			if (GasStation.existingGood(number)) {
				GasStation.addGoodOrder(number, amount);
			} else if (number == 666) {
				
				// Easter-Egg
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userInterface/EasterEggDialog.fxml"));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.setScene(new Scene(root1));
				stage.setTitle("Der Teufel ist da");
				stage.show();

			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Fehler");
				alert.setHeaderText("Die Warennummer existiert nicht");
				alert.setContentText(null);
				alert.showAndWait();
			}
			
			tf_ordergoodnumber.setText("");
			tf_ordergoodamount.setText("");
			
		
		

	}

	@FXML
	void onAddFuelOrderClick(ActionEvent event) {
		System.out.println(cb_orderfueltype.getValue());
		GasStation.addFuelOrder(cb_orderfueltype.getValue(), Double.parseDouble(tf_orderfuelamount.getText()));

	}

}