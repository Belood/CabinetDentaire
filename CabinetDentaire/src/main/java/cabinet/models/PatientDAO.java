/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabinet.models;

import cabinet.javabeans.Patient;

import java.sql.PreparedStatement;

import java.sql.SQLException;

/**
 *
 * @author Alexandre
 */
public class PatientDAO extends CommonDAO{


    public Patient create(Patient patient) {
        try{
            PreparedStatement statement=connection.conn.prepareStatement(SQLConstant.INSERT_PATIENT);
           
            statement.setString(1, patient.getNom());
            statement.setString(2, patient.getPrenom());
            statement.setString(3, patient.getAddresse());
            statement.setObject(4, patient.getDateNaissance());
            statement.setInt(5, patient.getNumTel());
            statement.setString(6, patient.getEmail());
            statement.setString(7, patient.getProfession());
            statement.setString(8, patient.getSexe());
            statement.setInt(9, patient.getAge());
            statement.setInt(10, patient.getNumSS());
            statement.setInt(11, patient.getNumAssurance());
            statement.executeUpdate();
            statement.close();
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return patient;
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
    public Object findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   


}
