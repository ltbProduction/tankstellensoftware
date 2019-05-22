package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Employee;
import models.Fuel;
import models.GasStation;
import models.Good;
import models.Product;
import models.Purchase;
import models.Sale;

public class Controller_Main implements Initializable {

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
	private ComboBox<?> cb_orderfueltype;

	@FXML
	private TextField tf_orderfuelamount;

	@FXML
	private Button b_orderfuel;

	@FXML
	private Button b_changefuelprice;

	@FXML
	private Tab t_history;

	@FXML
	private AnchorPane dp_balanceenddate;

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
	private AnchorPane AP_LogIn;

	@FXML
	private TextField tf_employeenumber;

	@FXML
	private Button b_login;
  
      @FXML
    private Label l_wrongemployeenumber;
    
    @FXML 
    private Label l_activeemployeename;

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		// Spalten einstellen
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
		tv_purchases.setItems(GasStation.getPurchases());
		
		tc_sales_number.setCellValueFactory(new PropertyValueFactory<Sale, Integer>("saleNumber"));
		tc_sales_date.setCellValueFactory(new PropertyValueFactory<Sale, LocalDate>("saleDate"));
		tc_sales_price.setCellValueFactory(new PropertyValueFactory<Sale, Double>("salePrice"));
		tv_sales.setItems(GasStation.getSales());
		
		tc_employees_number.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employeeNumber"));
		tc_employees_name.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeName"));
		tc_employees_dateofemployment
				.setCellValueFactory(new PropertyValueFactory<Employee, LocalDate>("dateOfEmployment"));
		tv_employees.setItems(GasStation.getEmployees());
		
		tc_goodsstorage2_nr.setCellValueFactory(new PropertyValueFactory<Good, Integer>("number"));
		tc_goodsstorage2_name.setCellValueFactory(new PropertyValueFactory<Good, String>("name"));
		tv_goodsstorage2.setItems(GasStation.getGoods());

		tc_goodsshoppingcart_name.setCellValueFactory(new PropertyValueFactory<Good, String>("name"));
		tc_goodsshoppingcart_price.setCellValueFactory(new PropertyValueFactory<Good, Double>("price"));
		tv_goodsshoppingcart.setItems(GasStation.getShoppingCartGoods());

		tc_fueltanks_tanknumber.setCellValueFactory(new PropertyValueFactory<Fuel, Integer>("number"));
		tc_fueltanks_fueltype.setCellValueFactory(new PropertyValueFactory<Fuel, String>("name"));
		tc_fueltanks_capacity.setCellValueFactory(new PropertyValueFactory<Fuel, Double>("capacity"));
		tc_fueltanks_fuellevel.setCellValueFactory(new PropertyValueFactory<Fuel, Double>("amount"));
		tc_fueltanks_purchaseprice.setCellValueFactory(new PropertyValueFactory<Fuel, Double>("purchasePrice"));
		tc_fueltanks_saleprice.setCellValueFactory(new PropertyValueFactory<Fuel, Double>("salePrice"));
		tv_fueltanks.setItems(GasStation.getFuels());




//    	    @FXML
//    	    private TableColumn<FuelTank, FuelType> tc_fueltanks_fueltype;
//
//    	    @FXML
//    	    private TableColumn<FuelTank, Double> tc_fueltanks_capacity;
//
//    	    @FXML
//    	    private TableColumn<FuelTank, Double> tc_fueltanks_fuellevel;
//
//    	    @FXML
//    	    private TableColumn<FuelTank, Double> tc_fueltanks_saleprice;
//    	  
		// Dummy Daten laden

	}

	@FXML
	void OnAddGoodsClick(ActionEvent event) {

		TabPane_main.setVisible(false);
		AP_addGoods.setVisible(true);

	}

	@FXML
    void OnLogInClick(ActionEvent event) {
    	
    
    	int employeeNumber = Integer.valueOf(tf_employeenumber.getText());
    	
	if(GasStation.existingEmployee(employeeNumber) == true) {
		AP_LogIn.setVisible(false);
    	TabPane_main.setVisible(true);
    	System.out.println("Erfolgreicher Login");
    	
    	//Mitarbeiter auf aktiv setzen
    	GasStation.setCurrentEmployee(employeeNumber);
    	
    	//aktive Mitarbeitername ausgeben 
    	l_activeemployeename.setText(GasStation.activeEmployee().getEmployeeName());
    	
	}else {
		l_wrongemployeenumber.setText("ungültige Mitarbeiternummer");
		System.out.println("Ungültige Mitarbeiternummer");
	}
	
	//Aktualisiert Ampeldarstellung des Kraftstofflevels
	imageview_diesel.setImage(GasStation.getTrafficLight(0));
	imageview_super.setImage(GasStation.getTrafficLight(1));
    }

	@FXML
	void onAddToShoppingCartClick(ActionEvent event) {

	}

	@FXML
	void onBarClick(ActionEvent event) throws IOException {

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
		stage.setTitle("Treibstoffpreis ändern");
		stage.show();


	}

	@FXML
	void onChangeGoodsPriceClick(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userInterface/ChangePriceOfGoodsDialog.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1));
		stage.setTitle("Warenpreis ändern");
		stage.show();
	}

	@FXML
	void onCheckInDeliveryClick(ActionEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Bestellung");
		alert.setHeaderText("Die Lieferung wurde eingebucht!");
		alert.setContentText(null);
		alert.showAndWait();

	}

	@FXML
	void onGasPumpClick(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userInterface/GasPumpDialog.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1));
		stage.setTitle("Zapfsï¿½ule");
		stage.show();

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

		// if Bestellung erfolgreich
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Bestellung");
		alert.setHeaderText("Bestellung war erfolgreich!");
		alert.setContentText(null);
		alert.showAndWait();

	}

	@FXML
	void onOrderGoodsClick(ActionEvent event) {

		// if Bestellung erfolgreich
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Bestellung");
		alert.setHeaderText("Bestellung war erfolgreich!");
		alert.setContentText(null);
		alert.showAndWait();

	}

	@FXML
	void onShowBalanceClick(ActionEvent event) {

	}

	@FXML
	void onToCheckoutClick(ActionEvent event) {

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

}