package controler;

import java.net.URL;
import java.util.ResourceBundle;

import contenu.Commentaire;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

public class CommentaireControler implements Initializable {
	@FXML
	private Label pseudo;
	@FXML
	private Label commentaire;
	@FXML
	private Image image;


	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	public void showCommentaireDetails(Commentaire cmt) {
		this.pseudo.setText(cmt.getUser().getName());
		this.commentaire.setText(cmt.getComment());
		//this.image = new Image(cmt.getUser().get

	}

}
