package controler;



import java.net.URL;
import java.util.ResourceBundle;


import contenu.Contenu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.image.ImageView;

import users.Utilisateurs;

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

    public void printComment(){

    }

    public void share(){

    }

    public void del(){

    }
    public void comment(){

    }

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
   
  
}
