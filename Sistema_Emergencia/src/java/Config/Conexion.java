/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author admi
 */
public class Conexion {
    Connection con;               
    //String url ="jdbc:mysql://localhost:3306/bd_restemergencia";
    //String user = "root";
    //String pass = "admin";
    String url ="jdbc:mysql://us-cdbr-east-04.cleardb.com:3306/heroku_86df2531f6399cd";
    String user = "b4348ff5ee3bfd";
    String pass = "6654806e";
    public Connection Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
        }
        return con;
    
}
 
    
}
