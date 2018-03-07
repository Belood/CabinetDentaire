/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabinet.actions;

import cabinet.javabeans.Patient;
import cabinet.models.PatientDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.time.LocalDate;

/**
 *
 * @author Alexandre
 */
public class PatientAction extends ActionSupport{
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
            
    @Override
    public String execute() {
        Patient patient=new Patient(nom,prenom, addresse, dateNaissance, numTel, email, profession, sexe, age, numSS, numAssurance);
        PatientDAO p=new PatientDAO();
        try{
            p.create(patient);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return SUCCESS;
    }
        public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = LocalDate.parse(dateNaissance);
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
}
