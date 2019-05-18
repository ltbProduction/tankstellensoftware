package controller;


	
	import javafx.event.ActionEvent;
import javafx.fxml.FXML;
	import javafx.scene.control.Button;
	import javafx.scene.control.Label;
	import javafx.scene.control.TextField;
import javafx.stage.Stage;

	public class Controller_PayProcessDialog {

	    @FXML
	    private Label l_price;

	    @FXML
	    private TextField tf_moneyreceived;

	    @FXML
	    private Button b_confirmmoneyreceived;

	    @FXML
	    private Label l_money_return;

	    @FXML
	    private Button b_continue;

	    @FXML
	    void onConfirmMoneyReceived(ActionEvent event) {

	    }

	    @FXML
	    void onContinue(ActionEvent event) {
	    	
	    	
	    	//schlieﬂt das Fenster
	    	Stage stage = (Stage)
	    	    	b_continue.getScene().getWindow();
	    	    	stage.close();

	    }

	}

