package model;

import contenu.Contenu;
import contenu.Photo;
import javafx.scene.image.Image;
import services.Privee;
import users.*;

import java.io.*;
import java.util.ArrayList;


public class ServicesBd implements _Model {


    private ArrayList<Utilisateurs> users = new ArrayList<>();
    private ArrayList<Contenu> allContent = new ArrayList<>();


    public ServicesBd() throws IOException, ClassNotFoundException {
        //loadContents();
        //loadUsers();
    }

    public void loadUsers() throws IOException, ClassNotFoundException {
        FileInputStream fisU = new FileInputStream("ressources/users.txt");
        ObjectInputStream ois = new ObjectInputStream(fisU);
        users = (ArrayList)ois.readObject();
    }

    public void loadContents() throws IOException, ClassNotFoundException {
        FileInputStream fisC = new FileInputStream("ressources/contenus.txt");
        ObjectInputStream ois = new ObjectInputStream(fisC);
        allContent = (ArrayList)ois.readObject();
    }

    public Contenu getContenu(int i) {
        return this.allContent.get(i);
    }
    public Utilisateurs getUser(int i){ return this.users.get(i); }
    public ArrayList<Contenu> getAllContent() {
        return this.allContent;
    }

    public int nbUsers(){ return this.users.size(); }
    public int nbContent(){ return this.allContent.size(); }

    public void setContent(Utilisateurs user, Contenu content) throws IOException, ClassNotFoundException {
        allContent.add(content);
        try {
            FileOutputStream fosC = new FileOutputStream(new File("ressources/contenus.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(fosC);
            oos.writeObject(this.allContent);
            oos.close();
            fosC.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public void setUser(Utilisateurs user) throws IOException, ClassNotFoundException {
        users.add(user);
        try {
            FileOutputStream fosU = new FileOutputStream(new File("ressources/users.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(fosU);
            oos.writeObject(this.users);
            oos.close();
            fosU.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}