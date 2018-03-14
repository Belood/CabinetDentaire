<%-- 
    Document   : visites-content
    Created on : 13 mars 2018, 19:16:49
    Author     : USER
--%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/js/gestionPatientJs.js" charset="utf-8"></script>
<div class="col-sm-2">
    <h2> Ajout d'une consultation</h2>
    <s:form action="createConsultation" method="post" enctype="multipart/form-data" theme="bootstrap" cssClass="form-vertical">
        <s:textfield name="consultationNum"  placeholder="Numero de Consultation"/>
        <s:textfield name="typeConsultation"  placeholder="Type de Consultation"/>        
        <s:textfield type="date" name="dateConsultation" label="Date de Consultation" />        
        <s:textfield name="observations"  placeholder="Observations"/>
         
        <s:submit cssClass="btn btn-info center-block" value="Ajouter"  />
    </s:form>
</div>
<div class="col-sm-10">
    <table class="table table-bordered table-hover table-condensed" id="patientTable">
        <thead>
            <tr>
                <th>ID Dossier</th>
                <th>Numero de Consultation</th>
                <th>Type de Consultation</th>
                <th>Date de Consultation</th>
                <th>Observations</th>               
            </tr>
        </thead>
        <s:iterator value="consultList">
            <tr>
                <td><s:property value="dossierID" /></td>
                <td><s:property value="consultationNum" /></td>
                <td><s:property value="typeConsultation" /></td>                
                <td><s:property value="dateConsultation" /></td>
                <td><s:property value="observations" /></td>
                <td><s:property value="Motif" /></td>                
                <td>
                    <button onclick="fetchRowRDV(this)" class="btn btn btn-info" data-toggle="modal" data-target="#updateModal">Update</button>
                    <button onclick="deleteRDV(this)" class="btn btn btn-danger">Delete</button>
                </td>
            </tr>
        </s:iterator>
    </table>
</div>
<div class="container-fluid" id="updateForm">
    <div class="modal fade" id="updateModal" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h4 class="modal-title">Update New Information</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="hidden" name="RdvNum" id="RdvNum">  
                                <input type="hidden" name="PatientID" id="PatientID">
                                <input type="hidden" name="RdvID" id="RdvID">
                            </div>
                        </div>
                  
                    </div>                    
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="date" name="RdvDate" id="RdvDate" class="form-control input-sm" placeholder="Date de Rendez-vous">
                            </div>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="text" name="Heure" id="Heure" class="form-control input-sm" placeholder="Heure de Rendez-vous">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="text" name="Motif" id="Motif" class="form-control input-sm" placeholder="Motif">
                            </div>
                        </div>                        
                    </div>                    
                    <button onclick="updateRecordRDV();" class="btn btn-info btn-block">Update</button>
                    <div id="resp" class="text-center" style="margin-top: 13px;"></div>
                </div>
            </div>
        </div>
    </div>
</div>