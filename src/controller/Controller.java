package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {

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
    private TableView<?> ttv_fueltanks;

    @FXML
    private TableColumn<?, ?> tc_fueltanks_fuelnumber;

    @FXML
    private TableColumn<?, ?> tc_fueltanks_fueltype;

    @FXML
    private TableColumn<?, ?> tc_fueltanks_capacity;

    @FXML
    private TableColumn<?, ?> tc_fueltanks_fuellevel;

    @FXML
    private TableColumn<?, ?> tc_fueltanks_saleprice;

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
    private TextField tf_balancestartdate;

    @FXML
    private TextField tf_balanceenddate;

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
    private Tab t_employees;

    @FXML
    private Button b_newemployee;

    @FXML
    private TableColumn<?, ?> ttc_employees_number;

    @FXML
    private TableColumn<?, ?> ttc_employees_name;

    @FXML
    private TableColumn<?, ?> ttc_employees_dateofemployment;

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
           
 
	
	
	

    @FXML
    void OnAddGoodsClick(ActionEvent event) {
    	
    	
    	
    }

    @FXML
    void OnLogInClick(ActionEvent event) {

    }

    @FXML
    void onAddToShoppingCartClick(ActionEvent event) {

    }

    @FXML
    void onBarClick(ActionEvent event) {

    }

    @FXML
    void onChangeFuelPriceClick(ActionEvent event) throws IOException {

    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userInterface/ChangePriceDialog.fxml"));
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

    }

    @FXML

    void onGasPump1Click(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userInterface/GasPumpDialog.fxml"));
    	Parent root1 = (Parent) fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setScene(new Scene(root1));
    	stage.setTitle("Zapfsï¿½ule");
    	stage.show();	

    }

    	
    

    @FXML
    void onGasPump2Click(ActionEvent event) {

    }

    @FXML
    void onGasPump3Click(ActionEvent event) {

    }

    @FXML
    void onGasPump4Click(ActionEvent event) {

    }

    @FXML
    void onGasPump5Click(ActionEvent event) {

    }

    @FXML
    void onNewEmployeeClick(ActionEvent event) {

    }

    @FXML
    void onOrderFuelClick(ActionEvent event) {

    }

    @FXML
    void onOrderGoodsClick(ActionEvent event) {

    }

    @FXML
    void onShowBalanceClick(ActionEvent event) {

    }

    @FXML
    void onToCheckoutClick(ActionEvent event) {

    }

}
