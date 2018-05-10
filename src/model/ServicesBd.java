package model;

import users.*;

import java.util.ArrayList;

public class ServicesBd implements _Model {

    private ArrayList<_Utilisateurs> deconnected;
    private ArrayList<_Utilisateurs> connected;

    public ServicesBd(){
        this.deconnected = new ArrayList<_Utilisateurs>();
        this.connected = new ArrayList<_Utilisateurs>();
    }


    public void connexion(_Utilisateurs user) {
        deconnected.remove(user);
        connected.add(user);
    }

    @Override
    public int nbDeconnecte(){ return  this.deconnected.size(); }
    @Override
    public int nbConnecte(){ return this.connected.size(); }






}