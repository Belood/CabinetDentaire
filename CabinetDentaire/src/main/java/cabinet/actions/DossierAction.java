/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabinet.actions;

import cabinet.javabeans.Dossier;
import cabinet.models.DossierDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Alexandre
 */
public class DossierAction extends ActionSupport {

    private int dossierID;
    private int patientID;
    private String remarque;
    private LocalDate dateCreation;
    private LocalDate dateDerniereModif;
    private ArrayList<Dossier> dossierList = null;
    private DossierDAO dossierDAO = new DossierDAO();
    
    public String tableDossier(){
          try {
            dossierList = new ArrayList<Dossier>();
            ResultSet rs = dossierDAO.findAll();
            if (rs != null) {
                while (rs.next()) {
                    Dossier dossier=new Dossier(rs.getInt("DossierID"),rs.getInt("PatientID"),rs.getString("Nom"),rs.getString("Prenom"),rs.getString("Remarque"),LocalDate.parse(rs.getString("DateCreation")),LocalDate.parse(rs.getString("DateDerniereModif")));
                    dossierList.add(dossier);
                }
            } else {
                return ERROR;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "findAll";
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

    public ArrayList<Dossier> getDossierList() {
        return dossierList;
    }

    public void setDossierList(ArrayList<Dossier> dossierList) {
        this.dossierList = dossierList;
    }
}
