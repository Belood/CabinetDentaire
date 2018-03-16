/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabinet.models;

import cabinet.javabeans.Consultation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class ConsultationDAO extends CommonDAO {
    
        public ResultSet findAllbyDossierID(int id) {
        ResultSet rs=null;
        try {
            PreparedStatement ps = connection.conn.prepareStatement(SQLConstant.FindAllByDossierID);
            ps.setInt(1,id);
            //System.out.println("------------> "+id);
            rs= ps.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            return rs;
    }
            
    public Consultation create(Consultation consult) {
    try{
            

            PreparedStatement statement=connection.conn.prepareStatement(SQLConstant.INSERT_consult);
          
            statement.setInt(1, consult.getDossierID());
            statement.setInt(2, consult.getConsultationNum());
            statement.setString(3, consult.getTypeConsultation());
            statement.setObject(4, consult.getDateConsultation());
            statement.setString(5, consult.getObservations());
           
     
            statement.executeUpdate();
            statement.close();
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return consult;
    }
    public boolean update(Consultation consult){
         try {
            PreparedStatement statement = connection.conn.prepareStatement(SQLConstant.UPDATE_CONSULT);
            statement.setString(1, consult.getObservations());
            statement.setString(2, consult.getTypeConsultation());
            statement.setInt(3, consult.getConsultationNum());
            statement.setInt(4,consult.getDossierID());
             //System.out.println(statement.toString());
            statement.execute();
            statement.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete(int dossierID,int consultationNum){
         try {
            PreparedStatement statement = connection.conn.prepareStatement(SQLConstant.DELETE_CONSULT);
            statement.setInt(1,dossierID);
            statement.setInt(2,consultationNum);
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public Object read(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object create(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
}
