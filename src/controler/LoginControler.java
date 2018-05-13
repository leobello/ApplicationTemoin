package controler;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import client.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import users.Utilisateurs;



public class LoginControler implements Initializable { 
    @FXML
    private Button btnConnexion;
    @FXML
    private PasswordField inputPassword;
    @FXML
    private TextField inputUser;
    @FXML
    private AnchorPane idAnchor;
    @FXML
    private Button btnInscription;

    @FXML

    private void btnConnectAction(ActionEvent event ) throws  NotBoundException,  ClassNotFoundException, MalformedURLException, RemoteException {
    	Client client = new Client();
        //Test.main(null);
    	Utilisateurs usr=client.connectUser(inputUser.getText().toString(),inputPassword.getText().toString());
    	FXMLLoader loader=new FXMLLoader();
    	loader.setLocation(getClass().getResource("/view/home.fxml"));
        //if(user!=null){
    	try {
			loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	HomeController home=loader.getController();
    	loader.setController(home);
    	home.getUser(usr);
    	//System.out.println(user.getName());
    	Stage s1 = (Stage) idAnchor.getScene().getWindow();
    	Parent root = loader.getRoot();
    	Scene scene = new Scene(root);
    	s1.setScene(scene);
        s1.show();
        /*} else {
            inputUser.setText("");
            inputPassword.setText("");
        }*/

    }

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnInscription(ActionEvent event) throws IOException, NotBoundException {
    	Stage s1 = (Stage) idAnchor.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/view/FicheInscription.fxml"));
        Scene scene = new Scene(root);
        s1.setScene(scene);
        s1.show();

    }
}
