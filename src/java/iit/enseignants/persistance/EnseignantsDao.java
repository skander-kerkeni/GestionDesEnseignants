/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iit.enseignants.persistance;

import iit.enseignants.entites.Enseignants;
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
 * @author ahmed.benarab
 */
public class EnseignantsDao {
    //INSERT INTO `enseignant`(`id`, `cin`, `prenom`, `nom`, `adress`, `email`, `phone`, `login`, `password`)
    //VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6],[value-7],[value-8],[value-9])
    
    public Enseignants addEnseignant(Enseignants e)
    {
        Statement st=JdbcUtil.getStatement();
        //String req="Insert into Client ( `nom`, `adresse`, `tel`) values                                                         ( '"+c.getNom()+"', '"+c.getAdresse()+"', '"+c.getTel()+"');";
        String req="Insert into enseignant(`cin`,`prenom`,`nom`,`adress`,`email`,`phone`,`login`,`password`,grade) values('"+e.getCin()+"','"+e.getPrenom()+"','"+e.getNom()+"','"+e.getAdress()+"','"+e.getEmail()+"','"+e.getPhone()+"','"+e.getLogin()+"', '"+e.getPassword()+"','"+e.getGrade()+"');";
        //String req="insert into enseignant values('"+1+"','"+e.getCin()+"', "+e.getPrenom()+", "+e.getNom()+", '"+e.getAdress()+", '"+e.getEmail()+", '"+e.getPhone()+", '"+e.getLogin()+", '"+e.getPassword()+"');";
        //System.out.println(req);
        //System.out.println("ERRRRRRRRRR:  "+st);
        try {
            st.executeUpdate(req,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs=st.getGeneratedKeys();
            rs.next();
            int newKey=rs.getInt(1);
            System.out.println(newKey+"*****************************");
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantsDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRRRRRRRRR:  "+st);
            
        }
        
        return e;
    }
    
    public List<Enseignants> getAllArticle()
    {
        Statement st=JdbcUtil.getStatement();
        String req="select * from enseignant ;";
        List<Enseignants> list=new ArrayList<Enseignants>();
        System.out.print(st+"this is statment");
        try {
            ResultSet rs=st.executeQuery(req);
            
            while(rs.next())
            {
                //cin`, `prenom`, `nom`, `adress`, `email`, `phone`, `login`, `password`)Enseignants(int id, int cin, String nom, String prenom, String adress, String email, int phone, String login, String password)
                Enseignants a=new Enseignants(rs.getInt("id"),rs.getInt("cin"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adress"),rs.getString("email"),rs.getInt("phone"),rs.getString("login"),rs.getString("password"),rs.getString("grade"));
                list.add(a);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public Enseignants updateEnseignant(Enseignants a)
    {
        Statement st=JdbcUtil.getStatement();
        String req="Update enseignant set cin="+a.getCin()+", nom='"+a.getNom()+"',prenom='"+a.getPrenom()+"',adress='"+a.getAdress()+"',email='"+a.getEmail()+"',phone="+a.getPhone()+",login='"+a.getLogin()+"',password='"+a.getPassword()+"',grade='"+a.getGrade()+"' where id= '"+a.getId()+"';";
        System.out.print("reqqqqqqqq"+req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return getEnseignantById(a.getId());
    }
    
    public void removeEnseignant(Enseignants a)
    {
        
        Statement st=JdbcUtil.getStatement();
        String req="delete From enseignant where id = "+a.getId()+";";
        System.out.println("req= "+req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Enseignants getEnseignantById(int id)
    {
        Statement st=JdbcUtil.getStatement();
        String req="select * from enseignant where id like '"+id+"';";
        Enseignants a=null;
        try {
            ResultSet rs=st.executeQuery(req);
            
            while(rs.next())
                 a= new Enseignants(rs.getInt("id"),rs.getInt("cin"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adress"),rs.getString("email"),rs.getInt("phone"),rs.getString("login"),rs.getString("password"),rs.getString("grade"));
            
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;
    }
      public Enseignants verification(String login ,String password)
    {
        Statement st=JdbcUtil.getStatement();
        String req="select * from enseignant where login like '"+login+"' and password like '"+password+"';";
        Enseignants a=null;
        try {
            ResultSet rs=st.executeQuery(req);
            
            while(rs.next())
                 a= new Enseignants(rs.getInt("id"),rs.getInt("cin"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adress"),rs.getString("email"),rs.getInt("phone"),rs.getString("login"),rs.getString("password"),rs.getString("grade"));
            
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;
    }
    
}
