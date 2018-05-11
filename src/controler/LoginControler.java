package controler;


import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.util.ResourceBundle;

import bd.Test;
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
    private void btnConnectAction(ActionEvent event) throws Exception {
        Client client = new Client();
        //Test.main(null);
        client.connectUser();
        //if (client.check(inputUser.getText(), inputPassword.getText())) {
        boolean i= true;
        if(i){
        	Stage s1 = (Stage) idAnchor.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/view/AccueilChat.fxml"));
            Scene scene = new Scene(root);
            s1.setScene(scene);
            s1.show();
        } else {
            inputUser.setText("");
            inputPassword.setText("");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnInscription(ActionEvent event) throws IOException, NotBoundException {
    	Client client = new Client();
    	client.inscription();
        Stage s1 = (Stage) idAnchor.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/view/FicheInscription.fxml"));
        Scene scene = new Scene(root);
        s1.setScene(scene);
        s1.show();
    }
}
