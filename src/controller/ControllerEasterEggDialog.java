package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ControllerEasterEggDialog {

    @FXML
    private ImageView imageViewEasterEgg;

    @FXML
    private Button btnOkayEasterEgg;

    @FXML
    void onOkayEasterEggClick(ActionEvent event) {
    	
    	//schlieﬂt das Fenster
    	Stage stage = (Stage) btnOkayEasterEgg.getScene().getWindow();
    	stage.close();

    }

}
