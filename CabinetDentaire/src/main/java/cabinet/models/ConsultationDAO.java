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

    public ResultSet findAll(int id) {
        ResultSet rs = null;
        try {
            PreparedStatement ps = connection.conn.prepareStatement(SQLConstant.FindAll_consult);
            ps.setInt(1,id );
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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

    public int retrieveDossier(int id) {
        PreparedStatement preStatement;
        int res = -1;
        try {
            preStatement = connection.conn.prepareStatement(SQLConstant.SELECT_DossierID);
            preStatement.setInt(1,id);
            System.out.println("------------> "+id);
            ResultSet resultSet = preStatement.executeQuery();
            res=resultSet.getInt("DossierID");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            
            return res;
    }
    
}
