package controler;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import users.Utilisateurs;

public class RechercheUtilisateurControler implements Initializable {
	Utilisateurs useurSesion;
	Utilisateurs usercher;	
	@FXML
	private Image image ;
	@FXML
	private Label nomPrenom ;
	@FXML
	private Region region;
	@FXML
	private Button ajouter;
	@FXML
	private AnchorPane idAnchor;

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}


	public void getUserSearched(Utilisateurs utilisateurs) throws RemoteException {
		this.nomPrenom.setText(utilisateurs.getName());
		this.usercher=utilisateurs;
	}
	public void getUser(Utilisateurs usr) throws RemoteException {
		this.useurSesion = usr;
	}
	@FXML
	public void ajouter(ActionEvent event) throws IOException {
		this.useurSesion.beFriend(this.usercher);
		System.out.println("Ajouer parfaitement");
		Stage s = (Stage) idAnchor.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/home.fxml"));
		loader.load();
		Scene scene = new Scene((Parent) loader.getRoot());
		s.setScene(scene);
		s.show();
	}


}
