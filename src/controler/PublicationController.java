package controler;



import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;


import contenu.Contenu;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import users.Utilisateurs;

import javafx.scene.image.ImageView;

import users.Utilisateurs;

import javax.imageio.ImageIO;


public class PublicationController implements Initializable{


    private Utilisateurs userSession;
    private Contenu contenu;


    @FXML
    private AnchorPane pane;
    @FXML
    private ImageView photo;
    @FXML
    private Label nomPrenom;

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
    public void printComment(){


    }

    public void share(){

    }

    public void del(){

    }
    public void comment(){

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
        File file = new File("/home/near/IdeaProjects/ApplicationTemoin/ressources/image.jpg");
        Image image = new Image(file.toURI().toString());
        //photo.setFitHeight(image.getHeight());
        //photo.setFitWidth(image.getWidth());
        pane.setPrefWidth(image.getWidth());
        pane.setPrefHeight(image.getHeight());
        photo.setImage(image);

    }
    public void getUser(Utilisateurs usr) throws RemoteException {
		this.userSession=usr;
		System.out.println(this.userSession.getName());
		this.nomPrenom.setText(this.userSession.getName());
		//this.rechercher.setText(this.useurSesion.getName());
	}





}
