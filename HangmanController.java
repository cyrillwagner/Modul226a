package ch.csbe.hangman;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HangmanController {
	
	@FXML private Button close;
	@FXML private Button help;
	
	@FXML
	private void close(ActionEvent event) throws Exception {
		Parent roothangman = FXMLLoader.load(getClass().getResource("hangman.fxml"));
		Scene scenehangman = new Scene(roothangman);
		Stage stagehangman = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stagehangman.setTitle("hangman");
		stagehangman.centerOnScreen();
		stagehangman.setScene(scenehangman);
		stagehangman.close();
		System.out.println("Programm wurde beendet!");

	}
	
	@FXML
	private void help(ActionEvent event){
		System.out.println("Hilfe ist momentan nicht verfügbar!");
	}

}
