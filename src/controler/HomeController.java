package controler;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import bd.Users;
import contenu.Contenu;
import contenu.Photo;
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
import model.ServicesBd;
import services.Privee;
import users.Diffuseur;
import users.User;
import users.Utilisateurs;
import users._Utilisateurs;

public class HomeController implements Initializable {
	public static ObservableList names = FXCollections.observableArrayList();
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
    private TextField pathPhoto;

	private ArrayList<Contenu> contenuPrive;

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		 
	}


	public void getUser(Utilisateurs usr) throws RemoteException {
		this.useurSesion = usr;
		friends=new ListView<String>();
		//names.add(this.useurSesion.getName()); 
		this.useurSesion.friends.add(new User("amine","159",20));
		ArrayList<String> amins=new ArrayList<String>();
		for(_Utilisateurs usre:this.useurSesion.friends) {
			amins.add(usre.getName());
		}
		friends.getItems().addAll((Collection<? extends String>)amins);
		friends.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		//System.out.println(this.useurSesion.getName());
		// this.rechercher.setText(this.useurSesion.getName());
	}
    /*
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
    */
	@FXML
    public void contenuPrive() throws IOException {
        this.contenuPrive = useurSesion.cleanTimeLine(useurSesion.getTimeline());
        Stage s1 = (Stage) idAnchor.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/view/publication.fxml"));
        Scene scene = new Scene(root);
        s1.setScene(scene);
        s1.show();
    }

    @FXML
    public void publier(){
        Photo pic = new Photo(pathPhoto.getText());
        Contenu c = new Contenu(pic,useurSesion,new Privee());
        //this.contenuPrive.add(c);

        /*

            ici serialiser le contenu dans ressources/contenues.txt


        */




    }






	@FXML
    private void contenuPublic(){

    }


	@FXML
	public void chercher(KeyEvent event) throws RemoteException {
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
			pub.getUserSearched(serv.getUser(this.rechercher.getText()));
			Scene scene = new Scene((Parent) loader.getRoot());
			s.setScene(scene);
			event.consume();
			s.show();
		}
	}
}
