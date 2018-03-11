/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabinet.models;

import cabinet.javabeans.Patient;
import static cabinet.models.SQLConstant.INSERT_DOSSIER;
import static cabinet.models.SQLConstant.INSERT_PATIENT;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Alexandre
 */
public class PatientDAO extends CommonDAO {

    public Patient create(Patient patient) {
        try {
            PreparedStatement statement = connection.conn.prepareStatement(INSERT_PATIENT);
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
            PreparedStatement statement2 = connection.conn.prepareStatement(INSERT_DOSSIER);
            statement2.execute();
            statement2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }

    public Patient read(Patient patient) {
        try {
            PreparedStatement statement = connection.conn.prepareStatement(SQLConstant.READ_PATIENT);
            statement.setInt(1, patient.getPatientID());
            ResultSet resultSet = statement.executeQuery();
            patient.setPatientID(resultSet.getInt("PatientID"));
            patient.setSalleAttenteID(resultSet.getInt("SalleAttenteID"));
            patient.setPersonnelID(resultSet.getInt("PersonnelID"));
            patient.setNom(resultSet.getString("Nom"));
            patient.setPrenom(resultSet.getString("Prenom"));
            patient.setAddresse(resultSet.getString("Addresse"));
            patient.setDateNaissance(LocalDate.parse(resultSet.getString("DateNaissance")));
            patient.setAge(resultSet.getInt("Age"));
            patient.setNumTel(resultSet.getInt("NumTel"));
            patient.setEmail(resultSet.getString("email"));
            patient.setProfession(resultSet.getString("Profession"));
            patient.setSexe(resultSet.getString("Sexe"));
            patient.setNumSS(resultSet.getInt("NumSS"));
            patient.setNumAssurance(resultSet.getInt("NumAssurance"));
            resultSet.close();
            statement.close();
            connection.conn.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }

        return patient;
    }

    public boolean update(Patient patient) {
        try {
            PreparedStatement statement = connection.conn.prepareStatement(SQLConstant.UPDATE_PATIENT);
            statement.setString(1, patient.getNom());
            statement.setString(2, patient.getPrenom());
            statement.setString(3, patient.getAddresse());
            statement.setObject(4, patient.getDateNaissance());
            statement.setInt(5, patient.getNumTel());
            statement.setString(6, patient.getProfession());
            statement.setString(7, patient.getSexe());
            statement.setInt(8, patient.getAge());
            statement.setInt(9, patient.getNumSS());
            statement.setInt(10, patient.getNumAssurance());
            statement.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            PreparedStatement statement = connection.conn.prepareStatement(SQLConstant.DELETE_PATIENT);
            statement.setInt(1, id);

            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public ResultSet findAll() {
        ResultSet rs = null;
        try {
            PreparedStatement ps = connection.conn.prepareStatement(SQLConstant.FindAll_PATIENT);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
}
