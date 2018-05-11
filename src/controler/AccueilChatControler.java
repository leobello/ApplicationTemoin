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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;





public class AccueilChatControler implements Initializable {

    @FXML
    private Button btnDeco;
    @FXML
    private Label labelNom;
    @FXML
    private Label labelPrenom;
    @FXML
    private AnchorPane idAnchor;


    @FXML public void handleMouseClick(MouseEvent arg0) throws IOException, RemoteException {


        Stage s1 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FenetreChat.fxml"));
        Scene scene = new Scene(root);
        s1.initModality(Modality.APPLICATION_MODAL);
        s1.setScene(scene);
        s1.show();
    }


    @FXML
    private void deconnexion(ActionEvent event) throws IOException {
        Stage s1 = (Stage) idAnchor.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
        Scene scene = new Scene(root);
        s1.setScene(scene);
        s1.show();
        System.gc();
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
}



