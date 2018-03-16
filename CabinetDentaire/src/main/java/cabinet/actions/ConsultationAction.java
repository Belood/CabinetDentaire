/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabinet.actions;

import cabinet.javabeans.Consultation;
import cabinet.models.ConsultationDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class ConsultationAction extends ActionSupport {

    private int patientId;
    private int consultationID;
    private int dossierID;
    private int consultationNum;
    private String typeConsultation;
    private LocalDate dateConsultation;
    private String observations;
    private ArrayList<Consultation> consultList = null;
    private ConsultationDAO consultDao = new ConsultationDAO();
    private String status;

    @Override
    public String execute() {
        if(String.valueOf(getDossierID()).length()==0){
            addFieldError("dossierID", "DossierID is required.");
        }
        if(String.valueOf(getConsultationNum()).length()==0){
            addFieldError("consultationNum", "ConsultationNum is required.");
        }
        if(getTypeConsultation().length()==0){
            addFieldError("typeConsultation", "TypeConsultation is required.");
        }
        if(getObservations().length()==0){
            addFieldError("observations", "Observations is required.");
        }
        try {
            LocalDate.parse(getDateConsultation().toString());
          
        } catch (NullPointerException e) {
            e.printStackTrace();
            addFieldError("dateConsultation", "DateConsultation is required.");
            return INPUT;
        }
        consultDao.create(new Consultation(dossierID, consultationNum, typeConsultation, dateConsultation, observations));
        return SUCCESS;
    }

    public String showConsultation() {
        try {
            ResultSet rs = consultDao.findAllbyDossierID(patientId);
            consultList = new ArrayList<Consultation>();
            if (rs != null) {
                while (rs.next()) {
                    Consultation consult = new Consultation();
                    consult.setConsultationNum(rs.getInt("ConsultationNum"));
                    consult.setDateConsultation(rs.getString("DateConsultation"));
                    consult.setDossierID(rs.getInt("DossierID"));
                    consult.setObservations(rs.getString("Observations"));
                    consult.setTypeConsultation(rs.getString("typeConsultation"));
                    consultList.add(consult);
                }
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "input";
    }

    public String update() {
        consultDao.update(new Consultation(dossierID,consultationNum,typeConsultation,observations)) ;
            status = "Update Successful";
        return "update";
    }

    public String delete() {
        if (consultDao.delete(dossierID,consultationNum)) {
            status = "Delete Successful";
        }

        return "delete";
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

    /**
     * @return the consultList
     */
    public ArrayList<Consultation> getConsultList() {
        return consultList;
    }

    /**
     * @param consultList the consultList to set
     */
    public void setConsultList(ArrayList<Consultation> consultList) {
        this.consultList = consultList;
    }

    /**
     * @return the consultDao
     */
    public ConsultationDAO getConsultDao() {
        return consultDao;
    }

    /**
     * @param consultDao the consultDao to set
     */
    public void setConsultDao(ConsultationDAO consultDao) {
        this.consultDao = consultDao;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the patientId
     */
    public int getPatientId() {
        return patientId;
    }

    /**
     * @param patientId the patientId to set
     */
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

}
