package controler;


<<<<<<< HEAD
import java.net.URL;
import java.util.ResourceBundle;

=======
import contenu.Contenu;
>>>>>>> branch 'master' of https://github.com/leobello/ApplicationTemoin.git
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
<<<<<<< HEAD
import javafx.scene.image.ImageView;
=======
import users.Utilisateurs;
>>>>>>> branch 'master' of https://github.com/leobello/ApplicationTemoin.git

<<<<<<< HEAD
public class PublicationController implements Initializable{
	@FXML
	private ImageView photo;
	@FXML
	private Label nomPrenom;
=======
import java.net.URL;
import java.util.ResourceBundle;

public class PublicationController implements Initializable{

    private Utilisateurs userSession;
    private Contenu contenu;

>>>>>>> branch 'master' of https://github.com/leobello/ApplicationTemoin.git
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

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
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
