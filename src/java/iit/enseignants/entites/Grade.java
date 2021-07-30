/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iit.enseignants.entites;

/**
 *
 * @author Lenovo
 */
public class Grade {
    int id_grade;
    String libelle;
    float prix_H_cours;
    float prix_H_td;
    float prix_H_tp;

    public int getId_grade() {
        return id_grade;
    }

    public void setId_grade(int id_grade) {
        this.id_grade = id_grade;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getPrix_H_cours() {
        return prix_H_cours;
    }

    public void setPrix_H_cours(float prix_H_cours) {
        this.prix_H_cours = prix_H_cours;
    }

    public float getPrix_H_td() {
        return prix_H_td;
    }

    public void setPrix_H_td(float prix_H_td) {
        this.prix_H_td = prix_H_td;
    }

    public float getPrix_H_tp() {
        return prix_H_tp;
    }

    public void setPrix_H_tp(float prix_H_tp) {
        this.prix_H_tp = prix_H_tp;
    }

    public Grade( String libelle, float prix_H_cours, float prix_H_td, float prix_H_tp) {
       
        this.libelle = libelle;
        this.prix_H_cours = prix_H_cours;
        this.prix_H_td = prix_H_td;
        this.prix_H_tp = prix_H_tp;
    }

    public Grade(int id_grade, String libelle, float prix_H_cours, float prix_H_td, float prix_H_tp) {
        this.id_grade = id_grade;
        this.libelle = libelle;
        this.prix_H_cours = prix_H_cours;
        this.prix_H_td = prix_H_td;
        this.prix_H_tp = prix_H_tp;
    }

 
    
    
    
}
