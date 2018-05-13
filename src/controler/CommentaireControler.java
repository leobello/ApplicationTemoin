package controler;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import contenu.Commentaire;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CommentaireControler implements Initializable {
	@FXML
	private Label pseudo;
	@FXML
	private Label contenuCommentaire;
	@FXML
	private Image image;


	public void initialize(URL location, ResourceBundle resources) {


	}
	public void showCommentaireDetails(Commentaire cmt) {
		try {
			this.contenuCommentaire.setText(cmt.getUser().getName());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.contenuCommentaire.setText(cmt.getComment());
		//this.image = new Image(cmt.getUser().get

	}

}
