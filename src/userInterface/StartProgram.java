package userInterface;

import javafx.application.Application;
//import javafx.event.EventHandler;
//import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utilities.FileTransfer;

public class StartProgram extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() {
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("UserInterface.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Tankstellensoftware");
		primaryStage.setScene(scene);
		primaryStage.show();
		//GasStation gasstation = new GasStation("Tankstelle Klösterle");
		FileTransfer.start();

			
	}

	@Override
	public void stop() {
		FileTransfer.writetextfiles();
	}

//	@Override
//	public void handle(ActionEvent event) {
//		// TODO Auto-generated method stub
//		
//	}

	
	
	
}
