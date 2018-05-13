package controler;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import contenu.Commentaire;
import contenu.Contenu;
import contenu.Photo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import services.Privee;
import users.User;
import users.Utilisateurs;

public class CommentaireControler implements Initializable {

    @FXML
	private Label username;
	@FXML
	private Label comment;
	private int indice;

	private Contenu contenu;
    private ArrayList<Commentaire> commentaires = new ArrayList<Commentaire>();


	public void initialize(URL location, ResourceBundle resources) {
        /* tests */
	    User user1 = new User("leo",12);
        User user2 = new User("luffy",12);
	    Contenu c = new Contenu(new Photo("ressources/image.jpg"),user1,new Privee());
        Commentaire com1 = new Commentaire(user2, "très moche!");
        Commentaire com2 = new Commentaire(user1, "efectivement c'est laid!");
        this.indice = 0;
        c.addComment(com1);
        c.addComment(com2);
	    this.contenu = c;
        /*       */
	    try {

            loadComment();

        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    public void loadComment() throws RemoteException {
        this.commentaires = contenu.getComment();
        if (!commentaires.isEmpty()) {
            comment.setText(this.commentaires.get(indice).getComment());
            username.setText(this.commentaires.get(indice).getUser().getName());
        } else {
            username.setText("Pas de commentaire");
        }

    }
    public void suivantEvent() throws RemoteException {
	    if (indice < commentaires.size()-1){
            this.indice += 1;
            loadComment();
        }

	}
    public void precedentEvent() throws RemoteException {
	    if(indice > 0){
            this.indice -= 1;
            loadComment();
        }
	}
}
