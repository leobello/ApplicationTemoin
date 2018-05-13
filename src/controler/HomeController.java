package controler;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import users.Utilisateurs;

public class HomeController implements Initializable {
	public static ObservableList names = FXCollections.observableArrayList();
	public Utilisateurs useurSesion;
	@FXML
	private TextField rechercher;
	@FXML
	private TextArea statusText;
	@FXML
	private Button telecharger;
	@FXML
	private Button publier;
	@FXML
	private AnchorPane idAnchor;
	@FXML
	private ListView<Utilisateurs> friends;
	@FXML
	private Label meteo;

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		/*
		 * friends=new ListView<Utilisateurs>();
		 * //names.add(this.useurSesion.getName()); this.useurSesion.beFriend(new
		 * User("Amine",22)); try { this.useurSesion.printFriend(); } catch
		 * (RemoteException e) { // TODO Auto-generated catch block e.printStackTrace();
		 * } friends.getItems().addAll((Collection<? extends Utilisateurs>)
		 * this.useurSesion.friends);
		 * friends.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		 */
	}

	public void getUser(Utilisateurs usr) throws RemoteException {
		this.useurSesion = usr;
		System.out.println(this.useurSesion.getName());
		// this.rechercher.setText(this.useurSesion.getName());
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
	public void chercher(KeyEvent event) throws RemoteException {
		Users serv = new Users();
		String nom=this.rechercher.getText();
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
			pub.getUserSearched(serv.getUser(nom));
			Scene scene = new Scene((Parent) loader.getRoot());
			s.setScene(scene);
			event.consume();
			s.show();
		}
	}
}
