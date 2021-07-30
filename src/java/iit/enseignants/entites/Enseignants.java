package iit.enseignants.entites;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ahmed.benarab
 */
public class Enseignants {
    //INSERT INTO `enseignant`(`id`, `cin`, `prenom`, `nom`, `adress`, `email`, `phone`, `login`, `password`)
    //VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6],[value-7],[value-8],[value-9])
    int id;
    int cin;
    String nom;
    String prenom;
    String adress;
    String email;
    int phone;
    String login;
    String password;
    String grade;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

 

    
    public int getCin() {
        return cin;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdress() {
        return adress;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


    public void setCin(int cin) {
        this.cin = cin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public Enseignants(int id, int cin, String nom, String prenom, String adress, String email, int phone, String login, String password, String grade) {
        this.id = id;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adress = adress;
        this.email = email;
        this.phone = phone;
        this.login = login;
        this.password = password;
        this.grade = grade;
    }

    public Enseignants(int cin, String nom, String prenom, String adress, String email, int phone, String login, String password, String grade) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adress = adress;
        this.email = email;
        this.phone = phone;
        this.login = login;
        this.password = password;
        this.grade = grade;
    }

   
    @Override
    public String toString() {
        return "Enseignants{" + "id=" + id + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", adress=" + adress + ", email=" + email + ", phone=" + phone + ", login=" + login + ", password=" + password + '}';
    }
    
    
    


    
    
    
    
}
