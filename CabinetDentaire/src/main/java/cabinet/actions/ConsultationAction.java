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
        int res = -1;
        try {
            res = consultDao.retrieveDossier(patientId);

            setDossierID(res);

            Consultation consult = new Consultation(getDossierID(), 1, "t", LocalDate.parse("2018-03-21"), "ytr");
            ConsultationDAO consultDAO = new ConsultationDAO();
            consultDAO.create(consult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String showConsultation() {
        int res = -1;
        try {

            res = consultDao.retrieveDossier(patientId);
            setDossierID(res);
            ResultSet resultSet = consultDao.findAll(getDossierID());
            consultList = new ArrayList<Consultation>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    Consultation consult = new Consultation();

                    consult.setConsultationNum(resultSet.getInt("ConsultationNum"));
                    consult.setDateConsultation(resultSet.getString("DateConsultation"));
                    consult.setDossierID(resultSet.getInt("DossierID"));
                    consult.setObservations(resultSet.getString("Observations"));
                    consult.setTypeConsultation(resultSet.getString("typeConsultation"));
                    consultList.add(consult);
                    return "success";
                }
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "input";
        }
        return "input";
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
    public void setDateConsultation(LocalDate dateConsultation) {
        this.dateConsultation = dateConsultation;
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
