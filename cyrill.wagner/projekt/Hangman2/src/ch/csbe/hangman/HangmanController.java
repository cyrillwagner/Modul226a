package ch.csbe.hangman;

/**
 * @author cyrill.wagner
 * @version 1.0
 */
import java.util.Optional;
import java.util.Random;

import ch.csbe.hangman.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.Node;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class HangmanController implements ViewController {

	@FXML
	protected Button close;
	@FXML
	protected Button help;
	@FXML
	protected Button menu;
	@FXML
	protected TextField textfield1;
	@FXML
	protected TextField textfield2;
	@FXML
	protected Line line1;
	@FXML
	protected Line line2;
	@FXML
	protected Line line3;
	@FXML
	protected Line line4;
	@FXML
	protected Circle line5;
	@FXML
	protected Line line6;
	@FXML
	protected Line line7;
	@FXML
	protected Line line8;
	@FXML
	protected Line line9;
	@FXML
	protected Line line10;

	int linie = 0;
	int versuche = 10;
	int guess = 0;
	String btn = "";
	String text = "";
	public String word;
	public boolean line = false;
	public char[] array;

	// liste mit den wörtern welche man erraten muss
	public HangmanController() {
		String[] words = { "schweiz", "bauer", "gibbix", "bildschirm", "tafel", "wasserflasche", "brot", "kopfhoerer",
				"teller", "tischplatte", "berg", "csbe", "porsche", "lastwagen", "xylophon", "wand", "lexikon", "zahnarzt",
				"zahnluecke", "zauberstab"};
		int random = new Random().nextInt(words.length);
		word = (words[random]);
		// System.out.println(word);
	}

	@Override
	public void init(Stage stage) {
		array = new char[word.length()];
		for (int p = 0; p < word.length(); p++) {
			array[p] = '_';
		}

	}

	// die eingegeben Buchstaben werden überprüft und entweder wird der
	// buchstaben ins textfield geschrieben
	// oder man verliert einen Versuch und es wird eine Line gezeichnet
	// ein alert wird aufgerufen wenn man das wort erraten hat oder wenn man
	// keine versuche mehr übrig hat
	@FXML
	public void pruefen(ActionEvent event) {
		Button button = (Button) event.getSource();
		btn = button.getText();
		button.setVisible(false);
		for (int p = 0; p < word.length(); p++) {
			if (btn.charAt(0) + 32 == word.charAt(p)) {
				line = true;
				guess++;
				array[p] = btn.charAt(0);

			}
			String b = new String(array);
			textfield1.setText(b);
		}

		if (guess == word.length()) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText("Bravo, du hast das Wort erraten!");
			alert.setContentText("Zurück zum Menu?");

			ButtonType buttonTypeOne = new ButtonType("Ja");
			ButtonType buttonTypeTwo = new ButtonType("Nein(Programm beenden)");

			alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == buttonTypeOne) {
				App.loadScene("menu");
				return;
			} else if (result.get() == buttonTypeTwo) {
				System.out.println("Programm wird beendet!");
				System.exit(0);

			}
		}
		if (!line) {
			linie++;
			switch (linie) {
			case 1:
				((Node) line1).setVisible(true);
				break;
			case 2:
				((Node) line2).setVisible(true);
				break;
			case 3:
				((Node) line3).setVisible(true);
				break;
			case 4:
				((Node) line4).setVisible(true);
				break;
			case 5:
				line5.setVisible(true);
				break;
			case 6:
				((Node) line6).setVisible(true);
				break;
			case 7:
				((Node) line7).setVisible(true);
				break;
			case 8:
				((Node) line8).setVisible(true);
				break;
			case 9:
				((Node) line9).setVisible(true);
				break;
			case 10:
				((Node) line10).setVisible(true);
				break;
			}

			versuche--;
			if (versuche == 0) {

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Neustarten");
				alert.setHeaderText("Du hast verloren! Wort: " + word);
				alert.setContentText("Zurück zum Menu?");

				ButtonType buttonTypeOne = new ButtonType("Ja");
				ButtonType buttonTypeTwo = new ButtonType("Nein(Programm beenden)");

				alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == buttonTypeOne) {
					App.loadScene("menu");
					return;
				} else if (result.get() == buttonTypeTwo) {
					System.out.println("Programm wird beendet!");
					System.exit(0);

				}
			} else {
				textfield2.setText("Übrige Versuche: " + versuche);
			}
		}
		line = false;
	}

	// programm wird geschlossen
	@FXML
	private void close(ActionEvent event) throws Exception {
		System.out.println("Programm wird beendet!");
		System.exit(0);

	}

	// ausgabe der hilfe
	@FXML
	private void help(ActionEvent event) {
		App.loadScene("tutorial");
	}

	// führt zurück ins menu
	@FXML
	private void menu(ActionEvent event) {
		App.loadScene("menu");
	}

}
