package ch.csbe.hangman;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class TutorialController implements ViewController{


	@FXML
	protected Button tutorialmenu;
	@FXML
	protected TextArea textarea;


	// Geht zurück ins menu
	@FXML
	private void tutorialmenu(ActionEvent event) {
		App.loadScene("menu");
	}

	@Override
	public void init(Stage stage) {
		// TODO Auto-generated method stub

	}
}
