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
 * @author USER
 */
public class Consultation implements Serializable {
    
    private int consultationID;
    private int dossierID;
    private int consultationNum;
    private String typeConsultation;
    private LocalDate dateConsultation;
    private String observations;
    
 @Override
    public String toString() {
        return "Consultation{" + "consultationID=" + consultationID + ", dossierID=" + dossierID + ", consultationNum=" + consultationNum + ", typrConsultation=" + typeConsultation + ", dateConsultation=" + dateConsultation + ", observations=" + observations + '}';
    }
 
public Consultation(){}
public Consultation(int consultationID, int dossierID, int consultationNum, String typrConsultation, LocalDate dateConsultation, String observations) {
        this.consultationID = consultationID;
        this.dossierID = dossierID;
        this.consultationNum = consultationNum;
        this.typeConsultation = typrConsultation;
        this.dateConsultation = dateConsultation;
        this.observations = observations;
    }
public Consultation(int dossierID, int consultationNum, String typrConsultation, LocalDate dateConsultation, String observations) {
        
        this.dossierID = dossierID;
        this.consultationNum = consultationNum;
        this.typeConsultation = typrConsultation;
        this.dateConsultation = dateConsultation;
        this.observations = observations;
    }

    /**
     * @return the consultationID
     */
    public int getConsultationID() {
        return consultationID;
    }

    /**
     * @param consultationID the consultationID to set
     */
    public void setConsultationID(int consultationID) {
        this.consultationID = consultationID;
    }

    /**
     * @return the dossierID
     */
    public int getDossierID() {
        return dossierID;
    }

    /**
     * @param dossierID the dossierID to set
     */
    public void setDossierID(int dossierID) {
        this.dossierID = dossierID;
    }

    /**
     * @return the consultationNum
     */
    public int getConsultationNum() {
        return consultationNum;
    }

    /**
     * @param consultationNum the consultationNum to set
     */
    public void setConsultationNum(int consultationNum) {
        this.consultationNum = consultationNum;
    }

    /**
     * @return the typeConsultation
     */
    public String getTypeConsultation() {
        return typeConsultation;
    }

    /**
     * @param typeConsultation the typeConsultation to set
     */
    public void setTypeConsultation(String typeConsultation) {
        this.typeConsultation = typeConsultation;
    }

    /**
     * @return the dateConsultation
     */
    public LocalDate getDateConsultation() {
        return dateConsultation;
    }

    /**
     * @param dateConsultation the dateConsultation to set
     */
    public void setDateConsultation(String dateConsultation) {
        this.dateConsultation = LocalDate.parse(dateConsultation);
    }

    /**
     * @return the observations
     */
    public String getObservations() {
        return observations;
    }

    /**
     * @param observations the observations to set
     */
    public void setObservations(String observations) {
        this.observations = observations;
    }
    
}
