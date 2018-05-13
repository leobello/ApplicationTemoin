package controler;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import users.Utilisateurs;
import users._Utilisateurs;

public class HomeController implements Initializable{
	 public static final ObservableList names = 
		        FXCollections.observableArrayList();
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
	private ListView<_Utilisateurs> friends;
	@FXML
	private Label meteo;
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
	
	public void getUser(Utilisateurs usr) throws RemoteException {
		this.useurSesion=usr;
		System.out.println(this.useurSesion.getName());
		//this.rechercher.setText(this.useurSesion.getName());
	}

    @FXML
    private void listAmis(ActionEvent event) {
    	//names.addAll(this.useurSesion.fr)
    }
}
