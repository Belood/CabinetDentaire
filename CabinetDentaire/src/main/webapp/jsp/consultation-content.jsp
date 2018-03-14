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
                <td>
                    <button onclick="fetchRowConsultation(this)" class="btn btn btn-info" data-toggle="modal" data-target="#updateModal">Update</button>
                    <button onclick="deleteConsultation(this)" class="btn btn btn-danger">Delete</button>
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
                                <input type="hidden" name="DossierID" id="DossierID">  
                                <input type="hidden" name="ConsultationID" id="ConsultationID">
                               
                            </div>
                        </div>
                  
                    </div>                    
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="text" name="ConsultationNum" id="CcnsultationNum" class="form-control input-sm" placeholder="Numero de Consultation">
                            </div>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="text" name="Heure" id="heure" class="form-control input-sm" placeholder="Type de Consultation">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="date" name="dateConsultation" id="dateConsultation" class="form-control input-sm" placeholder="Date de Consultation">
                            </div>
                        </div> 
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="date" name="Observations" id="observations" class="form-control input-sm" placeholder="Observations">
                            </div>
                        </div>   
                    </div>                    
                    <button onclick="updateRecordConsultation();" class="btn btn-info btn-block">Update</button>
                    <div id="resp" class="text-center" style="margin-top: 13px;"></div>
                </div>
            </div>
        </div>
    </div>
</div>