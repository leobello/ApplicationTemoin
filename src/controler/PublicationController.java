package controler;



import contenu.Commentaire;
import contenu.Contenu;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.ServicesBd;
import users.Utilisateurs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class PublicationController implements Initializable{


    private int indice;
    private Utilisateurs userSession;
    private Contenu contenu;
    private ArrayList<Contenu> publications;


    @FXML
    private AnchorPane pane;
    @FXML
    private ImageView photo;
    @FXML
    private Label nomPrenom;
    @FXML
    private VBox idVB;
    @FXML
    private Button jaime;
    @FXML
    private Button afficherCommentaires;
    @FXML
    private Button partager;
    @FXML
    private Button supp;
    @FXML
    private TextField commentaire;
    @FXML
    private Button commenter;
    @FXML
    private Button precedent;
    @FXML
    private Button suivant;
    @FXML
    private Button retour;
    @FXML
    private AnchorPane anchor;

    public void like() {
        this.userSession.liker(contenu);
    }

    /*
    public void loadImage() throws IOException {
        URL fxmlpath = this.getClass().getResource("view/publication.fxml");
        FXMLLoader loader = new FXMLLoader(fxmlpath);
        this.pane = loader.load(fxmlpath);
        Scene scene = new Scene(pane);



        WritableImage image = pane.snapshot(new SnapshotParameters(), null);
        File file = new File("/home/near/IdeaProjects/ApplicationTemoin/ressources/image.jpg");

        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "jpg", file);


    }
    */
    public void printComment() throws IOException {
        Stage s1 = (Stage) idVB.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/view/commentaire.fxml"));
        Scene scene = new Scene(root);
        s1.setScene(scene);
        s1.show();
    }

    public void share(){
        this.userSession.publier(this.contenu);
    }

    public void del(){
        this.userSession.delContenu(this.contenu);
    }
    public void comment(){
        String txt = commentaire.getText();
        Commentaire com = new Commentaire(this.userSession,txt);
        contenu.addComment(com);
    }

    public void precedente(){
        if(this.indice > 0) {
            this.indice -= 1;
            init(this.indice);
        }
    }

    public void suivante(){
        if(this.indice < this.publications.size()-1) {
            this.indice += 1;
            init(this.indice);
        }
    }
    public void comeback() throws IOException {
        Stage s1 = (Stage) idVB.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/view/home.fxml"));
        Scene scene = new Scene(root);
        s1.setScene(scene);
        s1.show();
    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    public void initialize(URL location, ResourceBundle resources) {
        this.indice = 0;
        init(this.indice);

        /*
        File file = new File("ressources/image.jpg");
        File file1 = new File("ressources/image.jpg");

        //photo.setFitHeight(image.getHeight());
        //photo.setFitWidth(image.getWidth());
        pane.setPrefWidth(image.getWidth());
        pane.setPrefHeight(image.getHeight());
        photo.setImage(image);
        this.nomPrenom.setText("hello");
        */

    }

    public void init(int i){
        try
        {
            ServicesBd sBd = new ServicesBd();
            sBd.loadContents();
            this.contenu = sBd.getContenu(i);
            this.publications = sBd.getAllContent();
            String path = this.contenu.getContenu().getPath();
            final String imageURI = new File(path).toURI().toString();
            Image image = new Image(imageURI);
            pane.setPrefWidth(image.getWidth());
            pane.setPrefHeight(image.getHeight());

            photo.setImage(image);
            this.nomPrenom.setText(this.contenu.getContenu().getPath() );
            /*

            Stage s1 = (Stage) idVB.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/view/publication.fxml"));
            Scene scene = new Scene(root);
            s1.setScene(scene);
            s1.show();
            */
        }catch(IOException ioe){
            ioe.printStackTrace();
            return;
        }catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
    }

    public Utilisateurs getUserSession(){return this.userSession;}
    public void getUser(Utilisateurs usr) throws RemoteException {
		this.userSession=usr;
		System.out.println(this.userSession.getName());
		this.nomPrenom.setText(this.userSession.getName());

		//this.rechercher.setText(this.useurSesion.getName());
	}







}
