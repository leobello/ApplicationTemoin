package controler;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import users.Utilisateurs;

public class RechercheUtilisateurControler implements Initializable {

	@FXML
	private Image image ;
	@FXML
	private Label nomPrenom ;
	@FXML
	private Region region;
	@FXML
	private Button ajouter;


	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}


	public void getUserSearched(Utilisateurs utilisateurs) throws RemoteException {
		this.nomPrenom.setText(utilisateurs.getName());
		
	}


}
