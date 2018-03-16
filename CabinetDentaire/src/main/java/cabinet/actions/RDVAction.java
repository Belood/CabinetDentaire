/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabinet.actions;

import cabinet.javabeans.RDV;
import cabinet.models.RdvDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

/**
 *
 * @author assil
 */
public class RDVAction extends ActionSupport{
       
    private int RdvID;
    private int PatientID;
    private int RdvNum;
    private Date RdvDate;
    private String Heure;
    private String Motif;
    private ArrayList<RDV> RDVList = null;
    private RdvDAO RdvDao = new RdvDAO();
    private String status;
    
    public String AddRDVForm()
    {
        return SUCCESS;
    }
    
    @Override
    public String execute()
    {
        String res = "success";
        if (String.valueOf(getPatientID()).length() == 0) {
        addFieldError("PatientID", "PatientID is required.");
        res = "input";
        }
        if (String.valueOf(getRdvNum()).length() == 0) {
        addFieldError("RdvNum", "RdvNum is required.");
        res = "input";
        }
        
         try {
            LocalDate.parse(getRdvDate().toString());
          
        } catch (NullPointerException e) {
            e.printStackTrace();
            addFieldError("dateNaissance", "DateNaissance is required.");
              res = "input";
        }
        if (!Optional.ofNullable(getRdvDate()).isPresent()) {
        addFieldError("RdvDate", "Date de Rendez-vous is required.");
        res = "input";
        }
        if (getHeure().length() == 0) {
        addFieldError("Heure", "Heure is required.");
        res = "input";
        }
        if (getMotif().length() == 0) {
        addFieldError("Motif", "Motif is required.");
        res = "input";
        }
        
        if(res.equals("input")) return res;

        RDV rendez_vous = new RDV(RdvID, PatientID, RdvNum, RdvDate, Heure, Motif);
        RdvDAO p = new RdvDAO();
        try {
            p.create(rendez_vous);            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;        
    }

    public String deleteRDV()
    {

        if(RdvDao.delete(RdvID))
        {
            status = "Delete Successful";
        }
        
        return "delete";
    }
    
    public String updateRDV()
    {
        String res = "update";
        
        if (getRdvDate().toString().length() == 0) {
        addFieldError("RdvDate", "Date de Rendez-vous is required.");
        res = "input";
        }
        if (getHeure().length() == 0) {
        addFieldError("Heure", "Heure is required.");
        res = "input";
        }
        if (getMotif().length() == 0) {
        addFieldError("Motif", "Motif is required.");
        res = "input";
        }
        
        if(res.equals("input")) return res;
        if(RdvDao.update(new RDV(RdvID, PatientID, RdvNum, RdvDate, Heure, Motif)))
        {
            status = "Update Successful";
        }
        
        return "update";
    }
     
    
    public String tableRDV()
    {
        try {
            
            RDVList = new ArrayList<RDV>();
            ResultSet rs= RdvDao.findAll();
            if(rs!= null)
            {
                while(rs.next())
                    {
                        RDV rendez_vous = new RDV();
                        rendez_vous.setPatientID(rs.getInt("PatientID"));
                        rendez_vous.setRdvID(rs.getInt("RdvID"));
                        rendez_vous.setRdvNum(rs.getInt("RdvNum"));
                        rendez_vous.setRdvDate(rs.getDate("RdvDate"));
                        rendez_vous.setHeure(rs.getString("Heure"));
                        rendez_vous.setMotif(rs.getString("Motif"));
                        RDVList.add(rendez_vous);            
                        }         
            }
                else{ 
                    return ERROR;}
                      
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "findAll";
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

    public ArrayList<RDV> getRDVList() {
        return RDVList;
    }

    public void setRDVList(ArrayList<RDV> RDVList) {
        this.RDVList = RDVList;
    }

    public RdvDAO getRdvDao() {
        return RdvDao;
    }

    public void setRdvDao(RdvDAO RdvDao) {
        this.RdvDao = RdvDao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
