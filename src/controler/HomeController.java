package controler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import bd.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import users.Utilisateurs;
import users._Utilisateurs;

public class HomeController implements Initializable {
	public ObservableList<String> names ;
	public Utilisateurs useurSesion;
	@FXML
	private TextField rechercher;
	@FXML
	private TextArea statusText;
	@FXML
	private Button contenuPriv;
	@FXML
	private Button publier;
	@FXML
	private Button contenuPub;
	@FXML
	private AnchorPane idAnchor;
	@FXML
	private ListView<String> friends;
	@FXML
	private Label meteo;

	@FXML
	public void initialize() {
		friends.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

	}

	/**
	 * @param usr
	 * @throws RemoteException
	 */

	public void getUser(Utilisateurs usr) throws RemoteException {
		this.useurSesion = usr;
		friends.getItems().clear();
		for(_Utilisateurs us: useurSesion.friends) {
			friends.getItems().add(us.getName());
		}

	}

	@FXML
	private void publier(ActionEvent event) throws IOException {
		Stage s = (Stage) idAnchor.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/publication.fxml"));
		try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		PublicationController pub = loader.getController();
		loader.setController(pub);
		pub.getUser(this.useurSesion);
		Scene scene = new Scene((Parent) loader.getRoot());
		s.setScene(scene);
		s.show();
	}

	@FXML
    private void contenuPrive(){

    }

	@FXML
    private void contenuPublic(){

    }


	@FXML
	public void chercher(KeyEvent event) throws RemoteException, MalformedURLException, NotBoundException {
		Users serv = new Users();
		//String nom=this.rechercher.getText();
		if (event.getCode() == KeyCode.ENTER) {
			Stage s = (Stage) idAnchor.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/rechercherUtilisateur.fxml"));
			// if(user!=null){
			try {
				loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RechercheUtilisateurControler pub = loader.getController();
			loader.setController(pub);
			/*System.out.println(this.rechercher.getText());
			System.out.println(serv.getIndexOfUser("amalm"));
			System.out.println("trouve "+serv.getUser("amalm").getName());*/
			pub.getUserSearched(this.useurSesion.searchUser((this.rechercher.getText())));
			pub.getUser(this.useurSesion);
			Scene scene = new Scene((Parent) loader.getRoot());
			s.setScene(scene);
			event.consume();
			s.show();
		}
	}

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
