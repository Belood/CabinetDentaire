/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabinet.javabeans;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Alexandre
 */
public class Patient implements Serializable {

    private int patientID;
    private int salleAttenteID;
    private int personnelID;
    private String nom;
    private String prenom;
    private String addresse;
    private LocalDate dateNaissance;
    private int numTel;
    private String email;
    private String profession;
    private String sexe;
    private int age;
    private int numSS;
    private int numAssurance;

    public Patient(String nom, String prenom, String addresse,LocalDate dateNaissance, int numTel, String email, String profression, String sexe, int age, int numSS, int numAssurance) {
        this.nom = nom;
        this.prenom = prenom;
        this.addresse = addresse;
        this.dateNaissance = dateNaissance;
        this.numTel = numTel;
        this.email = email;
        this.profession = profression;
        this.sexe = sexe;
        this.age = age;
        this.numSS = numSS;
        this.numAssurance = numAssurance;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

 

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getSalleAttenteID() {
        return salleAttenteID;
    }

    public void setSalleAttenteID(int salleAttenteID) {
        this.salleAttenteID = salleAttenteID;
    }

    public int getPersonnelID() {
        return personnelID;
    }

    public void setPersonnelID(int personnelID) {
        this.personnelID = personnelID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumSS() {
        return numSS;
    }

    public void setNumSS(int numSS) {
        this.numSS = numSS;
    }

    public int getNumAssurance() {
        return numAssurance;
    }

    public void setNumAssurance(int numAssurance) {
        this.numAssurance = numAssurance;
    }

    public Patient() {
    }
;
}
