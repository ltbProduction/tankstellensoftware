package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.ImageView;

public class Controller {

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
    private TreeTableView<?> ttv_goodsstorage;

    @FXML
    private TreeTableColumn<?, ?> tc_goodsstorage_nr;

    @FXML
    private TreeTableColumn<?, ?> tc_goodsstorage_name;

    @FXML
    private TreeTableColumn<?, ?> tc_goodsstorage_storageunit;

    @FXML
    private TreeTableColumn<?, ?> tc_goodsstorage_amount;

    @FXML
    private TreeTableColumn<?, ?> tc_goodsstorage_saleprice;

    @FXML
    private TreeTableColumn<?, ?> tc_goodsstorage_currency;

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
    private TreeTableView<?> ttv_purchases;

    @FXML
    private TreeTableColumn<?, ?> ttc_purchases_number;

    @FXML
    private TreeTableColumn<?, ?> ttc_purchases_date;

    @FXML
    private TreeTableColumn<?, ?> ttc_purchases_price;

    @FXML
    private TreeTableView<?> ttv_sales;

    @FXML
    private TreeTableColumn<?, ?> ttc_sales_number;

    @FXML
    private TreeTableColumn<?, ?> ttc_sales_date;

    @FXML
    private TreeTableColumn<?, ?> ttc_sales_price;

    @FXML
    private TextField tf_balancestartdate;

    @FXML
    private TextField tf_balanceenddate;

    @FXML
    private Button b_showbalance;

    @FXML
    private Label l_balanceresult;

    @FXML
    private Tab t_employees;

    @FXML
    private TreeTableView<?> ttv_employees;

    @FXML
    private TreeTableColumn<?, ?> ttc_employees_number;

    @FXML
    private TreeTableColumn<?, ?> ttc_employees_name;

    @FXML
    private TreeTableColumn<?, ?> ttc_employees_dateofemployment;

    @FXML
    private Button b_newemployee;

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
    private TextField tf_employeenumber;

    @FXML
    private Button b_login;

    @FXML
    // Klick auf "Waren hinzufügen"
    void OnAddGoodsClick(ActionEvent event) {

    }

    @FXML
 // Klick auf "Login"
    void OnLogInClick(ActionEvent event) {

    }

    @FXML
 // Klick auf "Hinzufügen" im Warenkorb-Fenster
    void onAddToShoppingCartClick(ActionEvent event) {

    }

    @FXML
 // Klick auf "BAR" bei Zahlung durch Kunden
    void onBarClick(ActionEvent event) {

    }

    @FXML
 // Klick auf "Preise ändern" unter "Kraftstoff"
    void onChangeFuelPriceClick(ActionEvent event) {

    }

    @FXML
    // Klick auf "Preise ändern" unter "Waren"
    void onChangeGoodsPriceClick(ActionEvent event) {

    }

    @FXML
    // Klick auf "Lieferung einbuchen"
    void onCheckInDeliveryClick(ActionEvent event) {

    }

    @FXML
    // Klick auf "Zapfsäule 1"
    void onGasPump1Click(ActionEvent event) {

    }

    @FXML
 // Klick auf "Zapfsäule 2"
    void onGasPump2Click(ActionEvent event) {

    }

    @FXML
 // Klick auf "Zapfsäule 3"
    void onGasPump3Click(ActionEvent event) {

    }

    @FXML
 // Klick auf "Zapfsäule 4"
    void onGasPump4Click(ActionEvent event) {

    }

    @FXML
 // Klick auf "Zapfsäule 5"
    void onGasPump5Click(ActionEvent event) {

    }

    @FXML
 // Klick auf "Neuer Mitarbeiter" unter "Mitarbeiter"
    void onNewEmployeeClick(ActionEvent event) {

    }

    @FXML
 // Klick auf Ok-Button zur Bestellung von Kraftstoff
    void onOrderFuelClick(ActionEvent event) {

    }

    @FXML
    // Klick auf Ok-Button zur Bestellung von Waren
    void onOrderGoodsClick(ActionEvent event) {

    }

    @FXML
    // Klick auf Ok-Button zur Berechnung der Bilanz
    void onShowBalanceClick(ActionEvent event) {

    }

    @FXML
    // Klick auf "Zur Kasse" im Warenkorb-Fenster
    void onToCheckoutClick(ActionEvent event) {

    }

}
