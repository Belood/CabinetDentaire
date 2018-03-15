/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabinet.actions;

import cabinet.javabeans.Patient;
import cabinet.models.PatientDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Alexandre
 */
public class PatientAction extends ActionSupport {

    private int patientId;
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
    private ArrayList<Patient> patientList = null;
    private PatientDAO patientDAO = new PatientDAO();
    private String status;

    public String addPatientForm() {
        return SUCCESS;
    }

    @Override
    public String execute() {
        String res = "success";
        if (getNom().length() == 0) {
        addFieldError("nom", "Name is required.");
        res = "input";
        }
        if (getPrenom().length() == 0) {
        addFieldError("prenom", "Prenom is required.");
        res = "input";
        }
        if (getAddresse().length() == 0) {
        addFieldError("addresse", "Addresse is required.");
        res = "input";
        }
        if (dateNaissance == null) {
        addFieldError("dateNaissance", "DateNaissance is required.");
        res = "input";
        }
        if (String.valueOf(getNumTel()).length() == 0) {
        addFieldError("numTel", "NumTel is required.");
        res = "input";
        }
        if (getEmail().length() == 0) {
        addFieldError("email", "Email is required.");
        res = "input";
        }
        if (getProfession().length() == 0) {
        addFieldError("profession", "Profession is required.");
        res = "input";
        }
        if (sexe == null) {
        addFieldError("sexe", "Sexe is required.");
        res = "input";
        }
        if (String.valueOf(getAge()).length() == 0) {
        addFieldError("age", "Age is required.");
        res = "input";
        }
        if (String.valueOf(getNumSS()).length() == 0) {
        addFieldError("numSS", "NumSS is required.");
        res = "input";
        }
        if (String.valueOf(getNumAssurance()).length() == 0) {
        addFieldError("numAssurance", "NumAssurance is required.");
        res = "input";
        }
        if(res.equals("input")) return res;
        Patient patient = new Patient(nom, prenom, addresse, dateNaissance, numTel, email, profession, sexe, age, numSS, numAssurance);
        PatientDAO p = new PatientDAO();
        try {
            p.create(patient);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public String deletePatient() {
        if (patientDAO.delete(patientId)) {
            status = "Delete Successful";
        };

        return "delete";
    }

    public String updatePatient() {
        String res = "success";
        if (getNom().length() == 0) {
        addFieldError("nom", "Name is required.");
        res = "input";
        }
        if (getPrenom().length() == 0) {
        addFieldError("prenom", "Prenom is required.");
        res = "input";
        }
        if (getAddresse().length() == 0) {
        addFieldError("addresse", "Addresse is required.");
        res = "input";
        }
        if (dateNaissance == null) {
        addFieldError("dateNaissance", "DateNaissance is required.");
        res = "input";
        }
        if (String.valueOf(getNumTel()).length() == 0) {
        addFieldError("numTel", "NumTel is required.");
        res = "input";
        }
        if (getEmail().length() == 0) {
        addFieldError("email", "Email is required.");
        res = "input";
        }
        if (getProfession().length() == 0) {
        addFieldError("profession", "Profession is required.");
        res = "input";
        }
        if (sexe == null) {
        addFieldError("sexe", "Sexe is required.");
        res = "input";
        }
        if (String.valueOf(getAge()).length() == 0) {
        addFieldError("age", "Age is required.");
        res = "input";
        }
        if (String.valueOf(getNumSS()).length() == 0) {
        addFieldError("numSS", "NumSS is required.");
        res = "input";
        }
        if (String.valueOf(getNumAssurance()).length() == 0) {
        addFieldError("numAssurance", "NumAssurance is required.");
        res = "input";
        }
        if(res.equals("input")) return res;
       if( patientDAO.update(new Patient(patientId,nom,prenom,addresse, dateNaissance, numTel, email, profession, sexe, age, numSS, numAssurance)))
       {
           status="Update Successful";
       }
       return "update";
    }

    public String tablePatient() {
        try {
            patientList = new ArrayList<Patient>();
            ResultSet rs = patientDAO.findAll();
            if (rs != null) {
                while (rs.next()) {
                    Patient patient = new Patient();
                    patient.setPatientID(rs.getInt("PatientID"));
                    patient.setSalleAttenteID(rs.getInt("SalleAttenteID"));
                    patient.setPersonnelID(rs.getInt("PersonnelID"));
                    patient.setNom(rs.getString("Nom"));
                    patient.setPrenom(rs.getString("Prenom"));
                    patient.setAddresse(rs.getString("addresse"));
                    patient.setDateNaissance(LocalDate.parse(rs.getString("DateNaissance")));
                    patient.setNumTel(rs.getInt("NumTel"));
                    patient.setEmail(rs.getString("Email"));
                    patient.setProfession(rs.getString("Profession"));
                    patient.setSexe(rs.getString("Sexe"));
                    patient.setNumSS(rs.getInt("NumSS"));
                    patient.setNumAssurance(rs.getInt("NumAssurance"));
                    patientList.add(patient);
                }
            } else {
                return ERROR;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "findAll";
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

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(ArrayList<Patient> patientList) {
        this.patientList = patientList;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
