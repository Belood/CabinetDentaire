/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabinet.models;

import cabinet.javabeans.Employe;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author USER
 */
public class EmployeDAO extends CommonDAO {

    public Employe validate(String login, String password) {
        Employe emp = new Employe();
        //boolean status = false;
        try {
            PreparedStatement ps = connection.conn.prepareStatement(SQLConstant.LOGIN_EXIST);
            ps.setString(1, login);
            ps.setString(2, password);
            //System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                emp.setLogin(rs.getString("Login"));
                emp.setPassword(rs.getString("Password"));
                emp.setNiveauDroits(rs.getInt("NiveauDroits"));
            }
            //status = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return emp;
    }

    public Employe create(Employe employe) {
        try {
            PreparedStatement statement = connection.conn.prepareStatement(SQLConstant.INSERT_EMPLOYE);

            statement.setString(1, employe.getNom());
            statement.setString(2, employe.getPrenom());
            statement.setString(3, employe.getAddresse());
            statement.setObject(4, employe.getDateNaissance());
            statement.setInt(5, employe.getNumTel());
            statement.setString(6, employe.getEmail());
            statement.setInt(7, employe.getAge());
            statement.setFloat(8, employe.getSalaire());
            statement.setObject(9, employe.getDateEmbauche());
            statement.setString(10, employe.getLogin());
            statement.setString(11, employe.getPassword());
            statement.setInt(12, employe.getNiveauDroits());
            statement.setString(13, employe.getDiscriminator());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employe;
    }

    public Employe read(Employe employe) {

        try {
            PreparedStatement statement = connection.conn.prepareStatement(SQLConstant.READ_EMPLOYE);
            statement.setInt(1, employe.getPersonnelID());
            ResultSet resultSet = statement.executeQuery();
            employe.setNom(resultSet.getString("Nom"));
            employe.setPrenom(resultSet.getString("Prenom"));
            employe.setAddresse(resultSet.getString("Addresse"));
            employe.setDateNaissance(resultSet.getString("DateNaissance"));
            employe.setAge(resultSet.getInt("Age"));
            employe.setNumTel(resultSet.getInt("NumTel"));
            employe.setEmail(resultSet.getString("email"));
            employe.setSalaire(resultSet.getString("salaire"));
            employe.setLogin(resultSet.getString("login"));
            employe.setPassword(resultSet.getString("password"));
            employe.setNiveauDroits(resultSet.getInt("niveauDroits"));
            employe.setDateEmbauche(resultSet.getString("DateEmbauche"));
            employe.setDiscriminator(resultSet.getString("discriminator"));
            employe.setPersonnelID(resultSet.getInt("personnelID"));
            employe.setCabinetID(resultSet.getInt("CabinetID"));
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }

        return employe;
    }

    public boolean update(Employe employe) {

        try {
            PreparedStatement statement = connection.conn.prepareStatement(SQLConstant.UPDATE_EMPLOYE);
            //System.out.println(employe.toString()); 

            statement.setString(1, employe.getNom());
            statement.setString(2, employe.getPrenom());
            statement.setString(3, employe.getAddresse());
            statement.setObject(4, employe.getDateNaissance());
            statement.setInt(5, employe.getNumTel());
            statement.setString(6, employe.getEmail());
            statement.setInt(7, employe.getAge());
            statement.setFloat(8, employe.getSalaire());
            statement.setObject(9, employe.getDateEmbauche());
            statement.setString(10, employe.getLogin());
            statement.setString(11, employe.getPassword());
            statement.setInt(12, employe.getNiveauDroits());
            statement.setString(13, employe.getDiscriminator());

            statement.setInt(14, employe.getPersonnelID());

            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean delete(int id) {
        try {
            PreparedStatement statement = connection.conn.prepareStatement(SQLConstant.DELETE_EMPLOYE);
            statement.setInt(1, id);

            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Employe findById(int id) {
        Employe employe = new Employe();
        try {
            PreparedStatement statement = connection.conn.prepareStatement(SQLConstant.FindByID_EMPLOYE);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                employe.setNom(resultSet.getString("Nom"));
                employe.setPrenom(resultSet.getString("Prenom"));
                employe.setAddresse(resultSet.getString("Addresse"));
                employe.setDateNaissance(resultSet.getString("DateNaissance"));
                employe.setAge(resultSet.getInt("Age"));
                employe.setNumTel(resultSet.getInt("NumTel"));
                employe.setEmail(resultSet.getString("email"));
                employe.setSalaire(resultSet.getString("salaire"));
                employe.setLogin(resultSet.getString("login"));
                employe.setPassword(resultSet.getString("password"));
                employe.setNiveauDroits(resultSet.getInt("niveauDroits"));
                employe.setDateEmbauche(resultSet.getString("DateEmbauche"));
                employe.setDiscriminator(resultSet.getString("discriminator"));
                employe.setPersonnelID(resultSet.getInt("personnelID"));

                //employe.setCabinetID(resultSet.getInt("CabinetID"));
            }
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }

        return employe;
    }

    public List<Employe> findByName(String name) {
        List<Employe> employes = new LinkedList<Employe>();

        try {
            PreparedStatement statement = connection.conn.prepareStatement(SQLConstant.FindByName_EMPLOYE);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Employe employe = new Employe();
                employe.setNom(resultSet.getString("Nom"));
                employe.setPrenom(resultSet.getString("Prenom"));
                employe.setAddresse(resultSet.getString("Addresse"));
                employe.setDateNaissance(resultSet.getString("DateNaissance"));
                employe.setAge(resultSet.getInt("Age"));
                employe.setNumTel(resultSet.getInt("NumTel"));
                employe.setEmail(resultSet.getString("email"));
                employe.setSalaire(resultSet.getString("salaire"));
                employe.setLogin(resultSet.getString("login"));
                employe.setPassword(resultSet.getString("password"));
                employe.setNiveauDroits(resultSet.getInt("niveauDroits"));
                employe.setDateEmbauche(resultSet.getString("DateEmbauche"));
                employe.setDiscriminator(resultSet.getString("discriminator"));
                employe.setPersonnelID(resultSet.getInt("personnelID"));
                employe.setCabinetID(resultSet.getInt("CabinetID"));
                employes.add(employe);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }

        return employes;
    }

    @Override
    public ResultSet findAll() {
        ResultSet rs = null;
        try {
            PreparedStatement ps = connection.conn.prepareStatement(SQLConstant.FindAll_EMPLOYE);
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
    public boolean update(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object read(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
