/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iit.enseignants.service;

import iit.enseignants.entites.Grade;
import iit.enseignants.persistance.GradeDao;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class GradeService {
   GradeDao gradeDao=new GradeDao();
    public void addGrade( String libelle, float prix_H_cours, float prix_H_td, float prix_H_tp)
    {
        gradeDao.addGrade(new Grade( libelle,  prix_H_cours,  prix_H_td,  prix_H_tp));
    }
    public List<Grade> displayAll() {
        return gradeDao.getAllGrade();
    }

    public Grade updateGrade(Grade e) {
        return gradeDao.updateGrade(e);
    }

    public Grade getGradeById(int id) {
        return gradeDao.getGradeByDesignation(id);
    }
    public void deleteGrade(Grade e){
  gradeDao.removeGrade(e);
    }
    
    
}
