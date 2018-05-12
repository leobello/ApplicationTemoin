package controler;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import users._Utilisateurs;

public class HomeController implements Initializable{
	@FXML
	private TextField rechercher;
	@FXML
	private TextField statusText;
	@FXML
	private Button telecharger;
	@FXML
	private Button publier;
	@FXML
	private ListView<_Utilisateurs> friends;
	@FXML
	private Label meteo;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
