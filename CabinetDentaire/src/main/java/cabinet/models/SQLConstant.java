/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabinet.models;

/**
 *
 * @author Alexandre
 */
public class SQLConstant {

    protected static final String INSERT_PATIENT = "INSERT INTO patient(" + "Nom,Prenom,Addresse,DateNaissance,NumTel,Email,Profession,Sexe,Age,NumSS,NumAssurance) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    protected static final String INSERT_EMPLOYE="INSERT INTO personnel(" + "Nom,Prenom,Addresse,DateNaissance,numTel,Email,Age,Salaire,DateEmbauche,Login,Password,NiveauDroits,Discriminator) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    protected static final String DELETE_EMPLOYE="DELETE from personnel WHERE PersonnelID = ?";
    protected static final String UPDATE_EMPLOYE = "UPDATE personnel SET Nom=?, Prenom=?, Addresse=?, DateNaissance=?, NumTel=?, Email=?, Age=?, Salaire=?, DateEmbauche=?,Login=?,Password=?, NiveauDroits=?,Discriminator=? WHERE PersonnelID=?";
    protected static final String FindAll_EMPLOYE = "SELECT * from personnel";
    protected static final String READ_EMPLOYE = "SELECT * from personnel where PersonnelID=?";
    protected static final String FindByID_EMPLOYE = "SELECT * from personnel where PersonnelID=?";
    protected static final String FindByName_EMPLOYE = "SELECT * from personnel where Nom=?";

}
