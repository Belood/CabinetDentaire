<%-- 
    Document   : GestionRDV_content
    Created on : Mar 11, 2018, 6:22:50 PM
    Author     : assil
--%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/js/gestionRDVJs.js" charset="utf-8"></script>
<div class="col-xs-2">
    <h2> Ajout d'un Rendez-vous</h2>
    <s:form action="AddRDV" method="post" enctype="multipart/form-data" theme="bootstrap" cssClass="form-vertical">
        <s:textfield name="RdvNum"  placeholder="Numero de Rendez-vous"/>
        <s:textfield name="PatientID"  placeholder="Numero de Patient"/>        
        <s:textfield type="date" name="RdvDate" label="Date de Rendez-vous" />        
        <s:textfield name="Heure"  placeholder="Heure de Rendez-vous"/>
        <s:textfield name="Motif"  placeholder="Motif"/>        
        <s:submit cssClass="btn btn-info center-block" value="Ajouter"  />
    </s:form>
</div>
<div class="col-xs-10">
    <h2 class="text-center">Liste des rendez-vous</h2>
    <table class="table table-bordered table-hover table-condensed" id="patientTable">
        <thead>
            <tr>
                <th>Numero de Rendez-vous</th>
                <th>Numero de Patient</th>
                <th>Date de Rendez-vous</th>
                <th>Heure de Rendez-vous</th>
                <th>Motif</th>     
                <th>Action</th>
            </tr>
        </thead>
        <s:iterator value="RDVList">
            <tr>
                <td><s:property value="RdvNum" /></td>
                <td><s:property value="PatientID" /></td>                
                <td><s:property value="RdvDate" /></td>
                <td><s:property value="Heure" /></td>
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