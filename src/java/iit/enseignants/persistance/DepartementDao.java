/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iit.enseignants.persistance;

import iit.enseignants.entites.Departement;
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
public class DepartementDao {
    public Departement addDepartement(Departement a)
    {
        Statement st=JdbcUtil.getStatement();
        String req="Insert into departement (libelle_dep,chef)values( '"+a.getLibelle_departement()+"','"+a.getChef()+"');";
        System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(DepartementDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;
    }
    
    public List<Departement> getAllDepartement()
    {
        Statement st=JdbcUtil.getStatement();
        String req="select * from departement ;";
        List<Departement> list=new ArrayList<Departement>();
        try {
            ResultSet rs=st.executeQuery(req);
            
            while(rs.next())
            {
                 Departement a=new Departement(rs.getInt("id"),rs.getString("libelle_dep"),rs.getString("chef"));
                list.add(a);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DepartementDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public Departement updateDepartement(Departement a)
    {
        Statement st=JdbcUtil.getStatement();
        String req="Update departement set libelle_dep = '"+a.getLibelle_departement()+"'where id= '"+a.getId_departement()+"';";
        System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(DepartementDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return getDepartementByDesignation(a.getId_departement());
    }
    
       public Departement updateDepartementChef(Departement a)
    {
        Statement st=JdbcUtil.getStatement();
        String req="Update departement set chef = '"+a.getChef()+"'where id= '"+a.getId_departement()+"';";
        System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(DepartementDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return getDepartementByDesignation(a.getId_departement());
    }
    public void removeDepartement(Departement a)
    {
        
        Statement st=JdbcUtil.getStatement();
        String req="delete From departement where id =  '"+a.getId_departement()+"';";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(DepartementDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Departement getDepartementByDesignation(int id_departement)
    {
        Statement st=JdbcUtil.getStatement();
        String req="select * from departement where id like '"+id_departement+"';";
        Departement a=null;
        try {
            ResultSet rs=st.executeQuery(req);
            
            while(rs.next())
                 a=new Departement(rs.getInt("id"),rs.getString("libelle_dep"),rs.getString("chef"));
            
        } catch (SQLException ex) {
            Logger.getLogger(DepartementDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;
    }
       public Departement verification(String nom)
    {
        Statement st=JdbcUtil.getStatement();
        String req="select * from departement where chef like '"+nom+"';";
        Departement a=null;
        try {
            ResultSet rs=st.executeQuery(req);
            
            while(rs.next())
                 a=new Departement(rs.getInt("id"),rs.getString("libelle_dep"),rs.getString("chef"));
            
        } catch (SQLException ex) {
            Logger.getLogger(DepartementDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;
    }
}
