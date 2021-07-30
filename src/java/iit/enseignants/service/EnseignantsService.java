/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iit.enseignants.service;

import iit.enseignants.entites.Enseignants;
import iit.enseignants.persistance.EnseignantsDao;
import java.util.List;

/**
 *
 * @author ahmed.benarab
 */
public class EnseignantsService {

    EnseignantsDao enseignantDao = new EnseignantsDao();

    public void addEnseignant(int cin, String nom, String prenom, String adress, String email, int phone, String login, String password,String grade) {//Enseignants(int id, int cin, String nom, String prenom, String adress, String email, int phone, String login, String password)
        enseignantDao.addEnseignant(new Enseignants(cin, nom, prenom, adress, email, phone, login, password, grade));
    }

    public List<Enseignants> displayAll() {
        return enseignantDao.getAllArticle();
    }

    public Enseignants updateEnseignant(Enseignants e) {
        return enseignantDao.updateEnseignant(e);
    }

    public Enseignants getEnseignantById(int id) {
        return enseignantDao.getEnseignantById(id);
    }
    public Enseignants verification(String login,String password) {
        return enseignantDao.verification(login,password);
    }
    public void deleteEnseignant(Enseignants e){
    enseignantDao.removeEnseignant(e);
    }

}
