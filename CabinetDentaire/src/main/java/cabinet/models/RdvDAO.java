/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabinet.models;

import static cabinet.models.SQLConstant.INSERT_RDV;
import cabinet.javabeans.RDV;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author assil
 */
public class RdvDAO extends CommonDAO {

    
    public RDV create(RDV rendez_vous)
    {
        try {
            
            PreparedStatement statement = connection.conn.prepareStatement(INSERT_RDV);
            statement.setInt(1, rendez_vous.getPatientID());
            statement.setInt(2, rendez_vous.getRdvNum());
            statement.setObject(3, rendez_vous.getRdvDate());
            statement.setString(4, rendez_vous.getHeure());
            statement.setString(5, rendez_vous.getMotif());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rendez_vous;
    }
    
    public RDV read(RDV rendez_vous)
    {
        try {
            
            PreparedStatement statemnet = connection.conn.prepareStatement(SQLConstant.READ_RDV);
            statemnet.setInt(1, rendez_vous.getPatientID());
            ResultSet resultSet = statemnet.executeQuery();
            rendez_vous.setPatientID(resultSet.getInt("PatientID"));
            rendez_vous.setRdvID(resultSet.getInt("RdvID"));
            rendez_vous.setRdvNum(resultSet.getInt("RdvNum"));
            rendez_vous.setRdvDate(resultSet.getDate("RdvDate"));
            rendez_vous.setHeure(resultSet.getString("Heure"));
            rendez_vous.setMotif(resultSet.getString("Motif"));
            resultSet.close();
            statemnet.close();
            connection.conn.close();            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rendez_vous;
    }
    
    public boolean update(RDV rendez_vous)
    {
        try {
            //System.out.println(rendez_vous.toString());
            PreparedStatement statement = connection.conn.prepareStatement(SQLConstant.UPDATE_RDV);
            
            statement.setObject(1,rendez_vous.getRdvDate());
            statement.setString(2,rendez_vous.getHeure());
            statement.setString(3,rendez_vous.getMotif());  
            statement.setInt(4,rendez_vous.getRdvID());  
            statement.execute();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete (int id)
    {
        
        try {
            
            PreparedStatement statement = connection.conn.prepareStatement(SQLConstant.DELETE_RDV);
            statement.setInt(1, id);
            
            statement.executeUpdate();
            statement.close();
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public Object create(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public ResultSet findAll() {
            ResultSet rs = null;
            try {
                PreparedStatement ps = connection.conn.prepareStatement(SQLConstant.FINDAll_RDV);
                rs= ps.executeQuery();
                return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
            return null;
    }
    
    
    
}
