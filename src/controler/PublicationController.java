package controler;



import contenu.Commentaire;
import contenu.Contenu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
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
    public void printComment() throws IOException {
        // relier à commmentaire.fxml
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

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Contenu> arraylist= new ArrayList();

        try
        {
            FileInputStream fis = new FileInputStream("ressources/contenues.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            arraylist = (ArrayList) ois.readObject();
            this.contenu = arraylist.get(0);
            ois.close();
            fis.close();
            String path = this.contenu.getContenu().getPath();
            final String imageURI = new File(path).toURI().toString();
            Image image = new Image(imageURI);
            pane.setPrefWidth(image.getWidth());
            pane.setPrefHeight(image.getHeight());
            photo.setImage(image);
            this.nomPrenom.setText(this.contenu.getContenu().getPath() );
        }catch(IOException ioe){
            ioe.printStackTrace();
            return;
        }catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
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
    public Utilisateurs getUserSession(){return this.userSession;}
    public void getUser(Utilisateurs usr) throws RemoteException {
		this.userSession=usr;
		System.out.println(this.userSession.getName());
		this.nomPrenom.setText(this.userSession.getName());

		//this.rechercher.setText(this.useurSesion.getName());
	}







}
