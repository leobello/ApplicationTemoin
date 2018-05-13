package controler;


import contenu.Contenu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import users.Utilisateurs;

import java.net.URL;
import java.util.ResourceBundle;

public class PublicationController implements Initializable{

    private Utilisateurs userSession;
    private Contenu contenu;

    @FXML
    private Button jaime;
    @FXML
    private Button afficherCommentaires;
    @FXML
    private Button partager;
    @FXML
    private Button supp;
    @FXML
    private TextField commentaire;
    @FXML
    private Button commenter;


    public void like() {
        this.userSession.liker(contenu);
    }

    public void printComment(


    }

    public void share(){

    }

    public void del(){

    }
    public void comment(){

    }


    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.userSession = getCurrentUser();
        this.contenu = getContenu();
    }
}
