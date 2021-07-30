/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iit.enseignants.service;


import iit.enseignants.entites.Niveau;
import iit.enseignants.persistance.NiveauDao;
import java.util.List;


/**
 *
 * @author Lenovo
 */
public class NiveauService {
   NiveauDao niveauDao=new NiveauDao();
    public void addNiveau( String libelle)
    {
        niveauDao.addNiveau(new Niveau( libelle));
    }
     public List<Niveau> displayAll() {
        return niveauDao.getAllNiveau();
    }

    public Niveau updateNiveau(Niveau e) {
        return niveauDao.updateNiveau(e);
    }

    public Niveau getNiveauById(int id) {
        return niveauDao.getNiveauByDesignation(id);
    }
    public void deleteNiveau(Niveau e){
    niveauDao.removeNiveau(e);
    }
}
