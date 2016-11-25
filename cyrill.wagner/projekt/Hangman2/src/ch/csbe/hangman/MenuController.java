package ch.csbe.hangman;
/**
 * @author cyrill.wagner
 * @version 1.0
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MenuController implements ViewController {

	@FXML
	protected Button start;
	@FXML
	protected Button help;
	@FXML
	protected Button close;
	@FXML
	protected ImageView background;

	// Programm schliessen
	@FXML
	private void close(ActionEvent event) throws Exception {
		System.out.println("Programm wurde beendet!");
		System.exit(0);

	}

	// Zeigt das Tutorial an
	@FXML
	private void help(ActionEvent event) {
		App.loadScene("tutorial");
	}

	// startet das Spiel in dem die Scene hangman.fxml geladen wird
	@FXML
	private void start(ActionEvent event) {
		App.loadScene("hangman");
	}

	@Override
	public void init(Stage stage) {
		// TODO Auto-generated method stub

	}
}
