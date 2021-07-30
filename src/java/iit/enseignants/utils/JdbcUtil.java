/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iit.enseignants.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahmed.benarab
 */
public class JdbcUtil {
    
    static Statement st;
    static Connection conn;
    
    static{
        try {
            Class c =Class.forName("com.mysql.jdbc.Driver");
            //            conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:8889/gestionStock", "root", "");

            conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gestiondesenseignants", "root", "");
            st=conn.createStatement();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JdbcUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(JdbcUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    static public  Statement getStatement(){
        return st;
    }
    
}
