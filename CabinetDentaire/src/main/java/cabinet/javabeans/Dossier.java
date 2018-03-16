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
public class Dossier implements Serializable {

    private int dossierID;
    private int patientID;
    private String nom;
    private String prenom;
    private String remarque;
    private LocalDate dateCreation;
    private LocalDate dateDerniereModif;

    public Dossier() {
    }

    public Dossier(int dossierID, int patientID, String nom, String prenom, String remarque, LocalDate dateCreation, LocalDate dateDerniereModif) {
        this.dossierID = dossierID;
        this.patientID = patientID;
        this.nom=nom;
        this.prenom=prenom;
        this.remarque = remarque;
        this.dateCreation = dateCreation;
        this.dateDerniereModif = dateDerniereModif;
    }

    public int getDossierID() {
        return dossierID;
    }

    public void setDossierID(int dossierID) {
        this.dossierID = dossierID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
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

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDate getDateDerniereModif() {
        return dateDerniereModif;
    }

    public void setDateDerniereModif(LocalDate dateDerniereModif) {
        this.dateDerniereModif = dateDerniereModif;
    }
}
