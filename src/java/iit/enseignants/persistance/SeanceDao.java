/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iit.enseignants.persistance;


import iit.enseignants.entites.Matiere;
import iit.enseignants.entites.Seance;
import iit.enseignants.utils.JdbcUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class SeanceDao {
        public Seance addSeance(Seance a)
    {
        Statement st=JdbcUtil.getStatement();
        String req="Insert into seance ( date,heure_debut, duree,methode,validee,type,enseignant,matiere)values( '"+a.getDate()+"', '"+a.getHeure_debut()+"', '"+a.getDuree()+"', '"+a.getMethode()+"', "+a.getValidee()+",'"+a.getType()+"','"+a.getEnseignant()+"','"+a.getMatiere()+"');";
        System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(SeanceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;
    }
    
    public List<Seance> getAllSeance()
    {
        Statement st=JdbcUtil.getStatement();
        String req="select * from seance ;";
        List<Seance> list=new ArrayList<Seance>();
        try {
            ResultSet rs=st.executeQuery(req);
            
            while(rs.next())
            {
                Seance a=new Seance(rs.getInt("id_seance"),rs.getString("date"),  rs.getString("heure_debut"), rs.getString("duree"),  rs.getString("methode"),rs.getInt("validee"), rs.getString("type"),rs.getString("enseignant"),rs.getString("matiere"));
                list.add(a);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SeanceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public Seance updateSeance(Seance a)
    {
        Statement st=JdbcUtil.getStatement();
        String req="Update seance set date='"+a.getDate()+"',heure_debut='"+a.getHeure_debut()+"', duree='"+a.getDuree()+"' , methode='"+a.getMethode()+"',type='"+a.getType()+"',enseignant='"+a.getEnseignant()+"', matiere='"+a.getMatiere()+"' where id_seance= '"+a.getId_seance()+"';";
        System.out.println("req= "+req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(SeanceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return getSeanceByDesignation(a.getId_seance());
    }
       public Seance valider(Seance a)
    {
        Statement st=JdbcUtil.getStatement();
        String req="Update seance set validee='"+a.getValidee()+"' where id_seance='"+a.getId_seance()+"';";
        System.out.println("req= "+req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(SeanceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return getSeanceByDesignation(a.getId_seance());
    }
    public void removeSeance(Seance a)
    {
        
        Statement st=JdbcUtil.getStatement();
        String req="delete From seance where id_seance = '"+a.getId_seance()+"';";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(SeanceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Seance getSeanceByDesignation(int id_seance)
    {
        Statement st=JdbcUtil.getStatement();
        String req="select * from seance where id_seance like '"+id_seance+"';";
        Seance a=null;
        try {
            ResultSet rs=st.executeQuery(req);
            
            while(rs.next())
                a= a=new Seance(rs.getInt("id_seance"),rs.getString("date"),  rs.getString("heure_debut"), rs.getString("duree"), rs.getString("methode"), rs.getInt("validee"), rs.getString("type"),rs.getString("enseignant"),rs.getString("matiere"));
            
        } catch (SQLException ex) {
            Logger.getLogger(SeanceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;
    }
     public List<Seance> getAllSeancepartd(String nom)
    {
        Statement st=JdbcUtil.getStatement();
        String req="select * from seance where enseignant like '"+nom+"';";
         List<Seance> list=new ArrayList<Seance>();
        try {
            ResultSet rs=st.executeQuery(req);
            
            while(rs.next())
            {
                Seance a=new Seance(rs.getInt("id_seance"),rs.getString("date"),  rs.getString("heure_debut"), rs.getString("duree"),  rs.getString("methode"),rs.getInt("validee"), rs.getString("type"),rs.getString("enseignant"),rs.getString("matiere"));
                list.add(a);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SeanceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
      public List<Seance> getAllSeancepardep(List<Matiere> list1)
    {
        Statement st=JdbcUtil.getStatement();
         List<Seance> list=new ArrayList<Seance>();
           for (Matiere i : list1){
             String matiere = i.getLibelle();
            String req="select * from seance where matiere like '"+matiere+"';";
              
           try {
            ResultSet rs=st.executeQuery(req);
            
            while(rs.next())
            {
                Seance a=new Seance(rs.getInt("id_seance"),rs.getString("date"),  rs.getString("heure_debut"), rs.getString("duree"),  rs.getString("methode"),rs.getInt("validee"), rs.getString("type"),rs.getString("enseignant"),rs.getString("matiere"));
                list.add(a);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SeanceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
           }
        return list;
    }
}
