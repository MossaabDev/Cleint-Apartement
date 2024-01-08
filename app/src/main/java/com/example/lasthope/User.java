package com.example.lasthope;

public class User {
    int id;
    String name;
    String email;
    String adress;
    String tlf;
    int progress;
    int paied;
    int rest;

    public User(int id, String name, String email, String adress, String tlf, int progress, int paied, int rest) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.adress = adress;
        this.tlf = tlf;
        this.progress = progress;
        this.paied = paied;
        this.rest = rest;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getPaied() {
        return paied;
    }

    public void setPaied(int paied) {
        this.paied = paied;
    }

    public int getRest() {
        return rest;
    }

    public void setRest(int rest) {
        this.rest = rest;
    }

    public String toString(){
        return "name : " + name + " email : " + email + " progress : " + progress + " paiment : " + (float)(paied + rest)*paied/100;
    }

    public int getpayPerc(){
        return (int) (paied + rest)*paied/100;
    }
}
