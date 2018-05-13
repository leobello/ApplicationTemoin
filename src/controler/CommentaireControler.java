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

	private Contenu contenu;
    private ArrayList<Commentaire> commentaires = new ArrayList<>();

    
	public void initialize(URL location, ResourceBundle resources) {
        /* tests */
	    User user1 = new User("leo",12);
        User user2 = new User("luffy",12);
	    Contenu c = new Contenu(new Photo("ressources/image.jpg"),user1,new Privee());
        Commentaire com = new Commentaire(user2, "très moche!");
        //c.addComment(com);
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
            comment.setText(this.commentaires.get(0).getComment());
            username.setText(this.commentaires.get(0).getUser().getName());
        } else {
            username.setText("Pas de commentaire");
        }
    }

}
