/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iit.enseignants.service;

import iit.enseignants.entites.Matiere;
import iit.enseignants.persistance.MatiereDao;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class MatiereService {
    MatiereDao matiereDao=new MatiereDao();
    public void addMatiere( String libelle, String tp , String td,String cours, String departement, String niveau, String enseignant)
    {
        matiereDao.addMatiere(new Matiere( libelle, tp, td,cours, departement, niveau, enseignant));
    }
        public List<Matiere> displayAll() {
        return matiereDao.getAllMatiere();
    }

    public Matiere updateMatiere(Matiere e) {
        return matiereDao.updateMatiere(e);
    }

    public Matiere getMatiereById(int id) {
        return matiereDao.getMatiereByDesignation(id);
    }
    public List<Matiere> displayAllpardep(String nom) {
        return matiereDao.displayAllpardep(nom);
    }
    public void deleteMatiere(Matiere e){
    matiereDao.removeMatiere(e);
    }
    
    
    
    
}
