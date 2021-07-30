/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iit.enseignants.service;

import iit.enseignants.entites.Departement;
import iit.enseignants.persistance.DepartementDao;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class DepartementService {
  DepartementDao DepartementDao=new DepartementDao();
    public void addDepartement( String libelle_Departement,String chef)
    {
        DepartementDao.addDepartement(new Departement( libelle_Departement,chef));
    }
        public List<Departement> displayAll() {
        return DepartementDao.getAllDepartement();
    }

    public Departement updateDepartement(Departement e) {
        return DepartementDao.updateDepartement(e);
    }
     public Departement updateDepartementchef(Departement e) {
        return DepartementDao.updateDepartementChef(e);
    }
     public Departement veritfication(String nom) {
        return DepartementDao.verification(nom);
    }

    public Departement getDepartementById(int id) {
        return DepartementDao.getDepartementByDesignation(id);
    }
    public void deleteDepartement(Departement e){
    DepartementDao.removeDepartement(e);
    }
}
