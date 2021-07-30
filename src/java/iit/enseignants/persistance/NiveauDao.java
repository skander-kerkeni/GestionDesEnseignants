/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iit.enseignants.persistance;

import iit.enseignants.entites.Niveau;
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
public class NiveauDao {
     public Niveau addNiveau(Niveau a)
    {
        Statement st=JdbcUtil.getStatement();
        String req="Insert into niveau (`libelle`)values( '"+a.getLibelle()+"');";
        System.out.println(req);
        System.out.println("sssssssssss"+st);
     
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(NiveauDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;
    }
    
    public List<Niveau> getAllNiveau()
    {
        Statement st=JdbcUtil.getStatement();
        String req="select * from niveau ;";
        List<Niveau> list=new ArrayList<Niveau>();
        try {
            ResultSet rs=st.executeQuery(req);
            
            while(rs.next())
            {
                Niveau a=new Niveau(rs.getInt("id"),rs.getString("libelle"));
                list.add(a);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(NiveauDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public Niveau updateNiveau(Niveau a)
    {
        Statement st=JdbcUtil.getStatement();
        String req="Update niveau set libelle ='"+a.getLibelle()+"' where id= '"+a.getId_niveau()+"';";
        System.out.println("req= "+req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(NiveauDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return getNiveauByDesignation(a.getId_niveau());
    }
    
    public void removeNiveau(Niveau a)
    {
        
        Statement st=JdbcUtil.getStatement();
        String req="delete From niveau where id = "+a.getId_niveau()+";";
        System.out.println("req= "+req);

        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(NiveauDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Niveau getNiveauByDesignation(int id_niveau)
    {
        Statement st=JdbcUtil.getStatement();
        String req="select * from niveau where id like '"+id_niveau+"';";
        Niveau a=null;
        try {
            ResultSet rs=st.executeQuery(req);
            
            while(rs.next())
                a=new Niveau(rs.getInt("id"),rs.getString("libelle"));
            
        } catch (SQLException ex) {
            Logger.getLogger(NiveauDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;
    }
    
}
