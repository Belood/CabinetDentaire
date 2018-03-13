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
    protected static final String READ_PATIENT="SELECT * FROM patient";
    protected static final String UPDATE_PATIENT="UPDATE patient SET Nom=?,Prenom=?,Addresse=?,DateNaissance=?,NumTel=?,Profession=?,Sexe=?,Age=?,NumSS=?,NumAssurance=? WHERE PatientID=?";
    protected static final String DELETE_PATIENT="DELETE FROM patient WHERE PatientID=?";
    protected static final String FindAll_PATIENT="SELECT * FROM patient";
    protected static final String FindByID_PATIENT="SELECT * FROM patient WHERE PatientID=?";
    protected static final String FindByName_PATIENT="SELECT * FROM patient where Nom=?";
    protected static final String INSERT_DOSSIER = "INSERT INTO dossier("+"PatientID,DateCreation) VALUES(LAST_INSERT_ID(),DATE(NOW()))" ;
    protected static final String INSERT_EMPLOYE="INSERT INTO personnel(" + "Nom,Prenom,Addresse,DateNaissance,numTel,Email,Age,Salaire,DateEmbauche,Login,Password,NiveauDroits,Discriminator) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    protected static final String DELETE_EMPLOYE="DELETE from personnel WHERE PersonnelID = ?";
    protected static final String UPDATE_EMPLOYE = "UPDATE personnel SET Nom=?, Prenom=?, Addresse=?, DateNaissance=?, NumTel=?, Email=?, Age=?, Salaire=?, DateEmbauche=?,Login=?,Password=?, NiveauDroits=?,Discriminator=? WHERE PersonnelID=?";
    protected static final String FindAll_EMPLOYE = "SELECT * from personnel";
    protected static final String READ_EMPLOYE = "SELECT * from personnel where PersonnelID=?";
    protected static final String FindByID_EMPLOYE = "SELECT * from personnel where PersonnelID=?";
    protected static final String FindByName_EMPLOYE = "SELECT * from personnel where Nom=?";
    protected static final String INSERT_RDV = "INSERT INTO rdv(" + "PatientID,RdvNum,RdvDate,Heure,Motif) VALUES (?,?,?,?,?)";
    protected static final String READ_RDV = "SELECT * FROM rdv";
    protected static final String UPDATE_RDV = "UPDATE rdv SET RdvDate=?,Heure=?,Motif=? WHERE RdvID=? ";
    protected static final String DELETE_RDV = "DELETE FROM rdv WHERE RdvID=?";
    protected static final String FINDAll_RDV = "SELECT * FROM rdv";
    protected static final String LOGIN_CMD = "SELECT * FROM allusers WHERE username=? AND password=?";

}
