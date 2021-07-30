/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iit.enseignants.service;

import iit.enseignants.entites.Matiere;
import iit.enseignants.entites.Seance;
import iit.enseignants.persistance.SeanceDao;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class SeanceService {
    SeanceDao seanceDao=new SeanceDao();
    // public Seance(int id_seance, String date, String heure_debut, String duree, int validee, String type, String enseignant, String matiere)
     public void addSeance( String date, String heure_debut, String duree, String methode,int validee, String type,String enseignant,String matiere)
    {
        seanceDao.addSeance(new Seance(date,  heure_debut,  duree, methode, validee,  type, enseignant, matiere));
    }
    public List<Seance> displayAll() {
        return seanceDao.getAllSeance();
    }
    public List<Seance> displayAllparid(String nom) {
        return seanceDao.getAllSeancepartd(nom);
    }
     public List<Seance> displayAllpardep (List<Matiere> list1) {
        return seanceDao.getAllSeancepardep(list1);
    }

    public Seance updateSeance(Seance e) {
        return seanceDao.updateSeance(e);
    }
     public Seance valider(Seance e) {
        return seanceDao.valider(e);
    }

    public Seance getSeanceById(int id) {
        return seanceDao.getSeanceByDesignation(id);
    }
    public void deleteSeance(Seance e){
    seanceDao.removeSeance(e);
    }
}
