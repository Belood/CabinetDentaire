/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabinet.actions;

import cabinet.javabeans.Employe;
import cabinet.models.EmployeDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author USER
 */
public class EmployeAction extends ActionSupport implements SessionAware {

    private int personnelID;
    private int cabinetID;
    private String nom;
    private String prenom;
    private String addresse;
    private LocalDate dateNaissance;
    private int numTel;
    private String email;
    private int age;
    private float salaire;
    private LocalDate dateEmbauche;
    private String login;
    private String password;
    private int niveauDroits;
    private String discriminator;
    private ArrayList<Employe> employeList = null;
    private EmployeDAO employeDAO = new EmployeDAO();
    private String status;
    private SessionMap<String, Object> sessionMap;

    public String login() {
        try {
            if (employeDAO.validate(getLogin(), getPassword())) {
                sessionMap.put("login", getLogin());
                return "success";
            }
        } catch (Exception e) {
            this.addActionError("Identifiant ou mot de pass invalide");
        }
        return INPUT;
    }

    public String logout() {
        if (sessionMap != null) {
            sessionMap.invalidate();
        }
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
        if (String.valueOf(getAge()).length() == 0) {
            addFieldError("age", "Age is required.");
            res = "input";
        }
        if (getEmail().length() == 0) {
            addFieldError("email", "Email is required.");
            res = "input";
        }
        if (String.valueOf(getSalaire()).length() == 0) {
            addFieldError("salaire", "Salaire is required.");
            res = "input";
        }
        if (String.valueOf(getAge()).length() == 0) {
            addFieldError("age", "Age is required.");
            res = "input";
        }
        if (dateEmbauche == null) {
            addFieldError("dateEmbauche", "DateEmbauche is required.");
            res = "input";
        }
        if (getLogin().length() == 0) {
            addFieldError("login", "Login is required.");
            res = "input";
        }
        if (getPassword().length() == 0) {
            addFieldError("password", "Password is required.");
            res = "input";
        }
        if (String.valueOf(getNiveauDroits()).length() == 0) {
            addFieldError("niveauDroits", "NiveauDroits is required.");
            res = "input";
        }
        if (getDiscriminator().length() == 0) {
            addFieldError("discriminator", "Discriminator is required.");
            res = "input";
        }

        if (res.equals("input")) {
            return res;
        }

        Employe employe = new Employe(getNom(), getPrenom(), getAddresse(), getDateNaissance(), getNumTel(), getEmail(), getAge(), getSalaire(), getDateEmbauche(), getLogin(), getPassword(), getNiveauDroits(), getDiscriminator());
        EmployeDAO employeDAO = new EmployeDAO();
        try {
            employeDAO.create(employe);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public String tableEmploye() {
        try {
            employeList = new ArrayList<Employe>();
            ResultSet resultSet = employeDAO.findAll();
            if (resultSet != null) {
                while (resultSet.next()) {
                    Employe employe = new Employe();
                    employe.setNom(resultSet.getString("Nom"));
                    employe.setPrenom(resultSet.getString("Prenom"));
                    employe.setAddresse(resultSet.getString("Addresse"));
                    employe.setDateNaissance(resultSet.getString("DateNaissance"));
                    employe.setAge(resultSet.getInt("Age"));
                    employe.setNumTel(resultSet.getInt("NumTel"));
                    employe.setEmail(resultSet.getString("email"));
                    employe.setSalaire(resultSet.getString("salaire"));
                    employe.setLogin(resultSet.getString("login"));
                    employe.setPassword(resultSet.getString("password"));
                    employe.setNiveauDroits(resultSet.getInt("niveauDroits"));
                    employe.setDateEmbauche(resultSet.getString("DateEmbauche"));
                    employe.setDiscriminator(resultSet.getString("discriminator"));
                    employe.setPersonnelID(resultSet.getInt("personnelID"));
                    //System.out.println("personnelID : "+resultSet.getInt("personnelID"));
                    //employe.setCabinetID(resultSet.getInt("CabinetID"));
                    employeList.add(employe);
                }
            } else {
                return ERROR;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "findAll";
    }

    public String deleteEmploye() {
        if (employeDAO.delete(personnelID)) {
            setStatus("Delete Successful");
        }

        return "delete";
    }

    public String updateEmploye() {
        String res = "update";
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
        if (String.valueOf(getAge()).length() == 0) {
            addFieldError("age", "Age is required.");
            res = "input";
        }
        if (getEmail().length() == 0) {
            addFieldError("email", "Email is required.");
            res = "input";
        }
        if (String.valueOf(getSalaire()).length() == 0) {
            addFieldError("salaire", "Salaire is required.");
            res = "input";
        }
        if (String.valueOf(getAge()).length() == 0) {
            addFieldError("age", "Age is required.");
            res = "input";
        }
        if (dateEmbauche == null) {
            addFieldError("dateEmbauche", "DateEmbauche is required.");
            res = "input";
        }
        if (getLogin().length() == 0) {
            addFieldError("login", "Login is required.");
            res = "input";
        }
        if (getPassword().length() == 0) {
            addFieldError("password", "Password is required.");
            res = "input";
        }
        if (String.valueOf(getNiveauDroits()).length() == 0) {
            addFieldError("niveauDroits", "NiveauDroits is required.");
            res = "input";
        }
        if (getDiscriminator().length() == 0) {
            addFieldError("discriminator", "Discriminator is required.");
            res = "input";
        }

        if (res.equals("input")) {
            return res;
        }
        if (employeDAO.update(new Employe(getPersonnelID(), getNom(), getPrenom(), getAddresse(), getDateNaissance(), getNumTel(), getEmail(), getAge(), getSalaire(), getDateEmbauche(), getLogin(), getPassword(), getNiveauDroits(), getDiscriminator())));
        {
            setStatus("Update Successful");
        }
        return "update";
    }

    /**
     * @return the personnelID
     */
    public int getPersonnelID() {
        return personnelID;
    }

    /**
     * @param personnelID the personnelID to set
     */
    public void setPersonnelID(int personnelID) {
        this.personnelID = personnelID;
    }

    /**
     * @return the cabinetID
     */
    public int getCabinetID() {
        return cabinetID;
    }

    /**
     * @param cabinetID the cabinetID to set
     */
    public void setCabinetID(int cabinetID) {
        this.cabinetID = cabinetID;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the addresse
     */
    public String getAddresse() {
        return addresse;
    }

    /**
     * @param addresse the addresse to set
     */
    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    /**
     * @return the dateNaissance
     */
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    /**
     * @param dateNaissance the dateNaissance to set
     */
    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = LocalDate.parse(dateNaissance);

    }

    /**
     * @return the numTel
     */
    public int getNumTel() {
        return numTel;
    }

    /**
     * @param numTel the numTel to set
     */
    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the salaire
     */
    public float getSalaire() {
        return salaire;
    }

    /**
     * @param salaire the salaire to set
     */
    public void setSalaire(String salaire) {
        this.setSalaire(Float.parseFloat(salaire));
    }

    /**
     * @return the dateEmbauche
     */
    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    /**
     * @param dateEmbauche the dateEmbauche to set
     */
    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = LocalDate.parse(dateEmbauche);
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the niveauDroits
     */
    public int getNiveauDroits() {
        return niveauDroits;
    }

    /**
     * @param niveauDroits the niveauDroits to set
     */
    public void setNiveauDroits(int niveauDroits) {
        this.niveauDroits = niveauDroits;
    }

    /**
     * @return the discriminator
     */
    public String getDiscriminator() {
        return discriminator;
    }

    /**
     * @param discriminator the discriminator to set
     */
    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    /**
     * @param salaire the salaire to set
     */
    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    /**
     * @return the employeList
     */
    public ArrayList<Employe> getEmployeList() {
        return employeList;
    }

    /**
     * @param employeList the employeList to set
     */
    public void setEmployeList(ArrayList<Employe> employeList) {
        this.employeList = employeList;
    }

    /**
     * @return the employeDAO
     */
    public EmployeDAO getEmployeDAO() {
        return employeDAO;
    }

    /**
     * @param employeDAO the employeDAO to set
     */
    public void setEmployeDAO(EmployeDAO employeDAO) {
        this.employeDAO = employeDAO;
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

    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    @Override
    public void setSession(Map<String, Object> map) {

        sessionMap = (SessionMap) map;
    }

}
