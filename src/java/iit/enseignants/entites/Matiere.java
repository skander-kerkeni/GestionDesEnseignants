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
public class Matiere {
    int id_matiere;
    String libelle;
    String tp;
    String td;
    String cours;
    private String departement;
    private String niveau;
    private String enseignant;

   

    public int getId_matiere() {
        return id_matiere;
    }

    public void setId_matiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getTd() {
        return td;
    }

    public void setTd(String td) {
        this.td = td;
    }

    public String getCours() {
        return cours;
    }

    public void setCours(String cours) {
        this.cours = cours;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(String enseignant) {
        this.enseignant = enseignant;
    }

    public Matiere(int id_matiere, String libelle, String tp, String td, String cours, String departement, String niveau, String enseignant) {
        this.id_matiere = id_matiere;
        this.libelle = libelle;
        this.tp = tp;
        this.td = td;
        this.cours = cours;
        this.departement = departement;
        this.niveau = niveau;
        this.enseignant = enseignant;
    }

    public Matiere(String libelle, String tp, String td, String cours, String departement, String niveau, String enseignant) {
        this.libelle = libelle;
        this.tp = tp;
        this.td = td;
        this.cours = cours;
        this.departement = departement;
        this.niveau = niveau;
        this.enseignant = enseignant;
    }

 
     
    
    
}
