package model;

import contenu.Contenu;
import contenu.Photo;
import javafx.scene.image.Image;
import services.Privee;
import users.*;

import java.io.*;
import java.util.ArrayList;

public class ServicesBd implements _Model {

    private ArrayList<Utilisateurs> deconnected = new ArrayList<Utilisateurs>();
    private ArrayList<Utilisateurs> users;
    private ArrayList<Contenu> allContent;




    public ServicesBd() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("ressources/contenues.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        allContent = (ArrayList) ois.readObject();
        FileInputStream fis2 = new FileInputStream("ressources/users.txt");
        ObjectInputStream oi2 = new ObjectInputStream(fis2);
        this.users = (ArrayList) oi2.readObject();
    }


    public Contenu getContenu(int i) {
        return this.allContent.get(i);
    }

    public ArrayList<Contenu> getAllContent() {
        return allContent;
    }

    public ArrayList<Utilisateurs> getDeconnected() {
        return deconnected;
    }

    public ArrayList<Utilisateurs> getUsers() {
        return this.users;
    }

    public int nbDeconnecte(){ return  this.deconnected.size(); }
    public int nbUsers(){ return this.users.size(); }
    public int nbContent(){ return this.allContent.size(); }


    public void getContents() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("ressources/contenues.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        allContent = (ArrayList) ois.readObject();
        ois.close();
        fis.close();
    }

    public void getUser() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("ressources/users.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        this.users = (ArrayList) ois.readObject();
        ois.close();
        fis.close();
    }

    public void setContent(Utilisateurs user, Contenu content) throws IOException, ClassNotFoundException {
        getContents();
        allContent.add(content);
        try {
            FileOutputStream fos = new FileOutputStream(new File("ressources/contenues.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.allContent);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public void setUser(Utilisateurs user) throws IOException, ClassNotFoundException {
        getUser();
        users.add(user);
        try {
            FileOutputStream fos = new FileOutputStream(new File("ressources/users.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.users);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }




}