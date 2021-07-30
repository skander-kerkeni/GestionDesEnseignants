/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iit.enseignants.persistance;

import iit.enseignants.entites.Grade;
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
public class GradeDao {
      public Grade addGrade(Grade a)
    {
        Statement st=JdbcUtil.getStatement();
        String req="Insert into grade ( libelle, prix_h_cours, prix_h_td,  prix_h_tp) values('"+a.getLibelle()+"', "+a.getPrix_H_cours()+", "+a.getPrix_H_td()+", "+a.getPrix_H_tp()+");";
        System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GradeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;
    }
    
    public List<Grade> getAllGrade()
    {
        Statement st=JdbcUtil.getStatement();
        String req="select * from grade ;";
        List<Grade> list=new ArrayList<Grade>();
        try {
            ResultSet rs=st.executeQuery(req);
            
            while(rs.next())
            {
                Grade a=new Grade(rs.getInt("id"),rs.getString("libelle"), rs.getFloat("prix_H_cours"),rs.getFloat("prix_H_td"),rs.getFloat("prix_H_cours") );
                list.add(a);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GradeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public Grade updateGrade(Grade a)
    {
        Statement st=JdbcUtil.getStatement();
        String req="Update grade set libelle='"+a.getLibelle()+"', prix_H_cours="+a.getPrix_H_cours()+", prix_H_td="+a.getPrix_H_td()+", prix_H_tp="+a.getPrix_H_tp()+" where id= '"+a.getId_grade()+"';";
        System.out.println("req= "+req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GradeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return getGradeByDesignation(a.getId_grade());
    }
    
    public void removeGrade(Grade a)
    {
        
        Statement st=JdbcUtil.getStatement();
        String req="delete From grade where id ='"+a.getId_grade()+"';";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GradeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Grade getGradeByDesignation(int id_grade)
    {
        Statement st=JdbcUtil.getStatement();
        String req="select * from grade where id like '"+id_grade+"';";
        Grade a=null;
        try {
            ResultSet rs=st.executeQuery(req);
            
            while(rs.next())
                a=new Grade(rs.getInt("id"),rs.getString("libelle"), rs.getFloat("prix_H_cours"),rs.getFloat("prix_H_td"),rs.getFloat("prix_H_cours"));
            
        } catch (SQLException ex) {
            Logger.getLogger(GradeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;
    }
    
    
}
