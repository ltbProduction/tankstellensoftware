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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Employee;
import models.FuelTank;
import models.FuelType;
import models.GasStation;

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
    private TableView<?> tv_shoppingcart;

    @FXML
    private TableColumn<?, ?> tc_shoppingcart_nr;

    @FXML
    private TableColumn<?, ?> tc_shoppingcart_name;

    @FXML
    private TableColumn<?, ?> tc_shoppingcart_amount;

    @FXML
    private TableColumn<?, ?> tc_shoppingcart_price;

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
    private TableColumn<?, ?> tc_goodsstorage_nr;

    @FXML
    private TableColumn<?, ?> tc_goodsstorage_name;

    @FXML
    private TableColumn<?, ?> tc_goodsstorage_storageunit;

    @FXML
    private TableColumn<?, ?> tc_goodsstorage_amount;

    @FXML
    private TableColumn<?, ?> tc_goodsstorage_saleprice;

    @FXML
    private TableColumn<?, ?> tc_goodsstorage_currency;

    @FXML
    private Tab t_fuel;

    @FXML
    private TableView<FuelTank> tv_fueltanks;

    @FXML
    private TableColumn<FuelTank, Integer> tc_fueltanks_tanknumber;

    @FXML
    private TableColumn<FuelTank, FuelType> tc_fueltanks_fueltype;

    @FXML
    private TableColumn<FuelTank, Double> tc_fueltanks_capacity;

    @FXML
    private TableColumn<FuelTank, Double> tc_fueltanks_fuellevel;

    @FXML
    private TableColumn<FuelTank, Double> tc_fueltanks_purchaseprice;
    
    @FXML
    private TableColumn<FuelTank, Double> tc_fueltanks_saleprice;

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
    private TableColumn<?, ?> ttc_purchases_number;

    @FXML
    private TableColumn<?, ?> ttc_purchases_date;

    @FXML
    private TableColumn<?, ?> ttc_purchases_price;

    @FXML
    private TableColumn<?, ?> ttc_sales_number;

    @FXML
    private TableColumn<?, ?> ttc_sales_date;

    @FXML
    private TableColumn<?, ?> ttc_sales_price;

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
    private TableView<?> tv_goodsstorage2;

    @FXML
    private TableColumn<?, ?> tc_goodsstorage2_nr;

    @FXML
    private TableColumn<?, ?> tc_goodsstorage2_name;

    @FXML
    private TableView<?> tv_goodsshoppingcart;

    @FXML
    private TableColumn<?, ?> tc_goodsshoppingcart_name;

    @FXML
    private TableColumn<?, ?> tc_goodsshoppingcart_price;

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
           
    @Override
	public void initialize(URL url, ResourceBundle rb) { 	
        
    	  // Spalten einstellen
    	  tc_employees_number.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employeeNumber"));
    	  tc_employees_name.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeName"));
    	  tc_employees_dateofemployment.setCellValueFactory(new PropertyValueFactory<Employee, LocalDate>("dateOfEmployment"));
    	  tv_employees.setItems(GasStation.getEmployees());
    	  
    	  tc_fueltanks_tanknumber.setCellValueFactory(new PropertyValueFactory<FuelTank, Integer>("tankNumber"));
    	  tc_fueltanks_fueltype.setCellValueFactory(new PropertyValueFactory<FuelTank, FuelType>("fuelType"));
    	  tc_fueltanks_capacity.setCellValueFactory(new PropertyValueFactory<FuelTank, Double>("capacity"));
    	  tc_fueltanks_fuellevel.setCellValueFactory(new PropertyValueFactory<FuelTank, Double>("fuelLevel"));
    	  tc_fueltanks_purchaseprice.setCellValueFactory(new PropertyValueFactory<FuelTank, Double>("purchasePrice"));
    	  tc_fueltanks_saleprice.setCellValueFactory(new PropertyValueFactory<FuelTank, Double>("salePrice"));
    	  tv_fueltanks.setItems(GasStation.getFuelTanks());
    	  
		
    	  
    	  

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
    	
    	AP_LogIn.setVisible(false);
    	TabPane_main.setVisible(true);

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
    	
    	
    	//if Bestellung erfolgreich
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Bestellung");
    	alert.setHeaderText("Bestellung war erfolgreich!");
    	alert.setContentText(null);
    	alert.showAndWait();

    }

    @FXML
    void onOrderGoodsClick(ActionEvent event) {

    	//if Bestellung erfolgreich
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