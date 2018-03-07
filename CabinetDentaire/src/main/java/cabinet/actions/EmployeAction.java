/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabinet.actions;

import cabinet.javabeans.Employe;
import cabinet.models.EmployeDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author USER
 */
public class EmployeAction extends ActionSupport {
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

     @Override
    public String execute() {
        Employe employe=new Employe(nom,prenom,addresse,dateNaissance,numTel,email,age,salaire,dateEmbauche,login,password,niveauDroits,discriminator);
        Employe employeTest=new Employe("TEST1","b","c",LocalDate.now(),3,"a",5,75,LocalDate.now(),"f","ge",2,"test");
       Employe employeTest2=new Employe("TEST2","b","c",LocalDate.now(),3,"a",5,75,LocalDate.now(),"f","ge",2,"test");
        EmployeDAO p = new EmployeDAO();
        try{
           p.create(employe);
            p.create(employeTest);
            p.create(employeTest2);
           List<Employe> list = p.findAll();
            System.out.println("employes cree");
            //Employe read = p.read(list.get(0));
            Employe read = list.get(0);
            System.out.println("READ -> nom : "+ read.getNom()+" prenom : " +read.getPrenom());
            read = p.findById(61);
            System.out.println("FindByID -> nom : "+ read.getNom()+" prenom : " +read.getPrenom());
            list = p.findByName("Test");
            System.out.println("FindByName -> nom : "+ list.get(1).getNom()+" prenom : " +list.get(1).getPrenom());
       
       
            
            /*String name =list.get(0).getNom();
            list.get(0).setNom("Modif");
            System.out.println(name +  " modifié en "+ list.get(0).getNom());
             p.update(list.get(0));
             
             System.out.println("employe Update");
             
              System.out.println("employe supprimer "+list.get(1).getNom());
             p.delete(list.get(1));*/
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return SUCCESS;
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
        this.dateNaissance =LocalDate.parse(dateNaissance);
       
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
        this.salaire = Float.parseFloat(salaire);
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
}
