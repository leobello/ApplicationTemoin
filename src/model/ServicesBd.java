package model;

import contenu.Contenu;
import users.*;

import java.util.ArrayList;

public class ServicesBd implements _Model {

    private ArrayList<_Utilisateurs> deconnected;
    private ArrayList<_Utilisateurs> connected;
    private ArrayList<Contenu> allContent;

    public ServicesBd(){
        this.deconnected = new ArrayList<_Utilisateurs>();
        this.connected = new ArrayList<_Utilisateurs>();
        this.allContent = new ArrayList<Contenu>();
    }


    public void connexion(_Utilisateurs user) {
        deconnected.remove(user);
        connected.add(user);
    }

    public void deconnexion(_Utilisateurs user) {
        connected.remove(user);
        deconnected.add(user);
    }

    public ArrayList<Contenu> getAllContent() {
        return allContent;
    }

    public ArrayList<_Utilisateurs> getDeconnected() {
        return deconnected;
    }

    public ArrayList<_Utilisateurs> getConnected() {
        return connected;
    }

    @Override
    public int nbDeconnecte(){ return  this.deconnected.size(); }
    @Override
    public int nbConnecte(){ return this.connected.size(); }
    @Override
    public int nbContent(){ return this.allContent.size(); }

    


}