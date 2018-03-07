/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabinet.models;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Alexandre
 */
public class ConnectionBDMySQL {
    public Connection conn;
    public static ConnectionBDMySQL db;
    
    
    private ConnectionBDMySQL() {
        String url= "jdbc:mysql://localhost:3306/";
        String dbName = "cabinetdentaire";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection)DriverManager.getConnection(url+dbName,userName,password);
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }
    /**
     *
     * @return  Database connection object
     */
    public static  ConnectionBDMySQL getInstance() {
        if ( db == null ) {
            db = new ConnectionBDMySQL();
            System.out.println("INSTANCIATION DE LA CONNEXION SQL ! ");
        }
        else{
            System.out.println("CONNEXION SQL EXISTANTE ! ");
        }
        return db;
 
    }
   /* public static void main(String[] args){
        for(int i = 1; i < 4; i++)
      System.out.println("Appel N° " + i + " : " + ConnectionBDMySQL.getInstance());
   }*/
 }
