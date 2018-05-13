package controler;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.ResourceBundle;

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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
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
	private VBox idVB;
	@FXML
	private ListView<Utilisateurs> friends;
	@FXML
	private Label meteo;
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		friends=new ListView<Utilisateurs>();
    	//names.add(this.useurSesion.getName());
		
    	friends.getItems().addAll((Collection<? extends Utilisateurs>) this.useurSesion.friends);
    	friends.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}
	
	public void getUser(Utilisateurs usr) throws RemoteException {
		this.useurSesion=usr;
		System.out.println(this.useurSesion.getName());
		//this.rechercher.setText(this.useurSesion.getName());
	}

    @FXML
    private void publier(ActionEvent event) throws IOException {
    	 Stage s = (Stage) idVB.getScene().getWindow();
    	 Parent root = FXMLLoader.load(getClass().getResource("/view/publication.fxml"));
         Scene scene = new Scene(root);
         s.setScene(scene);
         s.show();
    }
}
