/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iit.stock.service;

import iit.stock.entites.Enseignants;
import iit.stock.persistance.EnseignantsDao;

/**
 *
 * @author ahmed.benarab
 */
public class EnseignantsService {
    
    EnseignantsDao enseignantDao=new EnseignantsDao();
    public void addEnseignant( int cin, String nom, String prenom, String adress, String email, int phone, String login, String password)
            
    {//Enseignants(int id, int cin, String nom, String prenom, String adress, String email, int phone, String login, String password)
        enseignantDao.addEnseignant(new Enseignants(  cin,  nom,  prenom,  adress,  email,  phone,  login,  password));
    }
    
    /*public void approvisionnerArticle(String des, int qte)
    {
        Enseignants a=articleDao.getArticleByDesignation(des);
        
        if(a==null)
        {
            articleDao.addArticle(new Enseignants(des,qte,0,""));
        }
        else
        {
            a.setQte(a.getQte()+qte);
            articleDao.updateArticle(a);
        }
    }*/
    
}
