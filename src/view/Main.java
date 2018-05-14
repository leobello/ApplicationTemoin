package view;

import bd.Test;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ServicesBd;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        /*Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        Parent root = FXMLLoader.load(getClass().getResource("commentaire.fxml"));
        stage.show();
        
        Parent root = FXMLLoader.load(getClass().getResource("publication.fxml"));
*/		/*Test test=new Test();
		String[] serv=null;
		test.main(serv);*/
        ServicesBd sbd = new ServicesBd();
        


        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }



  
    public static void main(String[] args) {
        launch(args);
    }


}
