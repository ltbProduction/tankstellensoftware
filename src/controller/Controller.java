package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;

public class Controller implements EventHandler<ActionEvent> {

	private View view;

	public Controller(View view) {
		this.view = view;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		if (actionEvent.getSource().equals(view.getButton())) {
			System.out.println("Drucktaste 1 betätigt");
			String text = view.getTextField().getText();
			view.getLabel().setText(text);
			
		} else if (actionEvent.getSource().equals(view.getButton2())) {
			System.out.println("Drucktaste 2 betätigt");
			String text = view.getTextField().getText();
			view.getLabel2().setText(text);
		}
	}

}
