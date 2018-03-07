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
public class Employe implements Serializable {
    
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

    public Employe(){}
    
    public Employe(String nom, String prenom, String addresse, LocalDate dateNaissance, int numTel,String email, int age, float salaire, LocalDate dateEmbauche,String login, String password, int niveauDroits, String discriminator) {
        
        this.nom = nom;
        this.prenom = prenom;
        this.addresse = addresse;
        this.dateNaissance = dateNaissance;
        this.age = age;
        this.numTel = numTel;
        this.email = email;
        this.salaire = salaire;
        this.login = login;
        this.password = password;
        this.niveauDroits = niveauDroits;
        this.dateEmbauche = dateEmbauche;
        this.discriminator = discriminator;
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
     * @return the salaire
     */
    public float getSalaire() {
        return salaire;
    }

    /**
     * @param salaire the salaire to set
     */
    public void setSalaire(String salaire) {
        this.salaire = Float.parseFloat(salaire);
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
    
    
}

