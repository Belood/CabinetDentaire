/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabinet.javabeans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author assil
 */
public class RDV implements Serializable{
    
    private int RdvID;
    private int PatientID;
    private int RdvNum;
    private Date RdvDate;
    private String Heure;
    private String Motif;

    public RDV(int RdvID, int PatientID, int RdvNum, Date RdvDate, String Heure, String Motif) {
        this.RdvID = RdvID;
        this.PatientID = PatientID;
        this.RdvNum = RdvNum;
        this.RdvDate = RdvDate;
        this.Heure = Heure;
        this.Motif = Motif;
    }

    public RDV() {
    }       

    public int getRdvID() {
        return RdvID;
    }

    public void setRdvID(int RdvID) {
        this.RdvID = RdvID;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int PatientID) {
        this.PatientID = PatientID;
    }

    public int getRdvNum() {
        return RdvNum;
    }

    public void setRdvNum(int RdvNum) {
        this.RdvNum = RdvNum;
    }

    public Date getRdvDate() {
        return RdvDate;
    }

    public void setRdvDate(Date RdvDate) {
        this.RdvDate = RdvDate;
    }

    public String getHeure() {
        return Heure;
    }

    public void setHeure(String Heure) {
        this.Heure = Heure;
    }

    public String getMotif() {
        return Motif;
    }

    public void setMotif(String Motif) {
        this.Motif = Motif;
    }

    @Override
    public String toString() {
        return "RDV{" + "RdvID=" + RdvID + ", PatientID=" + PatientID + ", RdvNum=" + RdvNum + ", RdvDate=" + RdvDate + ", Heure=" + Heure + ", Motif=" + Motif + '}';
    }
    
    
}