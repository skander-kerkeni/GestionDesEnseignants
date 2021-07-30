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
public class Niveau {
     int id_niveau;
    String libelle;

    public int getId_niveau() {
        return id_niveau;
    }

    public void setId_niveau(int id_niveau) {
        this.id_niveau = id_niveau;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Niveau( String libelle) {
      
        this.libelle = libelle;
    }

    public Niveau(int id_niveau, String libelle) {
        this.id_niveau = id_niveau;
        this.libelle = libelle;
    }
    
}
