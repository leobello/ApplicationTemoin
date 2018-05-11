package model;


import java.io.Serializable;


public class Message implements Serializable{
    private int idMessage;
    private int idC;
    private int idUt;
    private String message;
    private String loginUt;


    public Message(int idMessage, int idC, int idUt, String message){
        this.idMessage = idMessage;
        this.idC = idC;
        this.idUt = idUt;
        this.message = message;
    }

    public Message(int idMessage, int idC, int idUt, String message, String loginUt, String couleur){
        this.idMessage = idMessage;
        this.idC = idC;
        this.idUt = idUt;
        this.message = message;
        this.loginUt = loginUt;
    }

 
    public int getIdMessage() {
        return idMessage;
    }

   
    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public int getIdC() {
        return idC;
    }

    public int getIdUt() {
        return idUt;
    }


    public void setIdUt(int idUt) {
        this.idUt = idUt;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString(){
        return this.loginUt + " : " + this.getMessage();
    }


    public String getLoginUt() {
        return loginUt;
    }

    public void setLoginUt(String loginUt) {
        this.loginUt = loginUt;
    }



}
