/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iit.stock.persistance;

import iit.stock.entites.Enseignants;
import iit.stock.utils.JdbcUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahmed.benarab
 */
public class EnseignantsDao {
    //INSERT INTO `enseignant`(`id`, `cin`, `prenom`, `nom`, `adress`, `email`, `phone`, `login`, `password`)
    //VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6],[value-7],[value-8],[value-9])
    
    public Enseignants addEnseignant(Enseignants e)
    {
        Statement st=JdbcUtil.getStatement();
        //String req="Insert into Client ( `nom`, `adresse`, `tel`) values                                                         ( '"+c.getNom()+"', '"+c.getAdresse()+"', '"+c.getTel()+"');";
        String req="Insert into enseignant( `cin`, `prenom`, `nom`, `adress`, `email`, `phone`, `login`, `password`) values('"+e.getCin()+"', '"+e.getPrenom()+"', '"+e.getNom()+"', '"+e.getAdress()+"', '"+e.getEmail()+"', '"+e.getPhone()+"', '"+e.getLogin()+"', '"+e.getPassword()+"');";
        //String req="insert into enseignant values('"+1+"','"+e.getCin()+"', "+e.getPrenom()+", "+e.getNom()+", '"+e.getAdress()+", '"+e.getEmail()+", '"+e.getPhone()+", '"+e.getLogin()+", '"+e.getPassword()+"');";
        System.out.println(req);
         System.out.println("st:" +st);
        try {
            
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return e;
    }
    
    public List<Enseignants> getAllArticle()
    {
        Statement st=JdbcUtil.getStatement();
        String req="select * from enseignant ;";
        List<Enseignants> list=new ArrayList<Enseignants>();
        try {
            ResultSet rs=st.executeQuery(req);
            
            while(rs.next())
            {
                //cin`, `prenom`, `nom`, `adress`, `email`, `phone`, `login`, `password`)Enseignants(int id, int cin, String nom, String prenom, String adress, String email, int phone, String login, String password)
                Enseignants a=new Enseignants(rs.getInt("cin"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adress"),rs.getString("email"),rs.getInt("phone"),rs.getString("login"),rs.getString("password"));
                list.add(a);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    /*
    public Enseignants updateArticle(Enseignants a)
    {
        Statement st=JdbcUtil.getStatement();
        String req="Update Article set qte="+a.getQte()+", prix="+a.getPrix();
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return getArticleByDesignation(a.getDesignation());
    }
    
    public void removeArticle(Enseignants a)
    {
        
        Statement st=JdbcUtil.getStatement();
        String req="remove From Article where designation like '"+a.getDesignation()+"';";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Enseignants getArticleByDesignation(String designation)
    {
        Statement st=JdbcUtil.getStatement();
        String req="select * from Article where designation like '"+designation+"';";
        Enseignants a=null;
        try {
            ResultSet rs=st.executeQuery(req);
            
            while(rs.next())
                a=new Enseignants(rs.getString("designation"), rs.getInt("qte"), rs.getFloat("prix"), rs.getString("remarque"));
            
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;
    }
    */
}
