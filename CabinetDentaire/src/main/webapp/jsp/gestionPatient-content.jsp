<%-- 
    Document   : gestionPatient-content
    Created on : 10 mars 2018, 19:21:08
    Author     : Alexandre
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/js/gestionPatientJs.js" charset="utf-8"></script>
<div class="col-sm-2">
    <h2>Ajout d'un patient</h2>
    <s:form action="AddPatient" method="post" enctype="multipart/form-data" theme="bootstrap" cssClass="form-vertical">
        <s:textfield name="nom"  placeholder="Nom"/>
        <s:textfield name="prenom"  placeholder="Prenom"/>
        <s:textfield name="addresse"  placeholder="Addresse" />
        <s:textfield type="date" name="dateNaissance" label="Date de naissance" />
        <s:textfield name="numTel"  placeholder="Numero telephone" />
        <s:textfield name="email"  placeholder="email"/>
        <s:textfield name="profession"  placeholder="Profession"/>
        <s:radio list="{'homme','femme','Autre'}" name="Sexe" labelposition="inline" label="Sexe"/>
        <s:textfield name="age"  placeholder="Age"/>
        <s:textfield name="numSS"  placeholder="Numero SS"/>
        <s:textfield name="numAssurance"  placeholder="Numero assurance"/>
        <s:submit cssClass="btn btn-info center-block" value="Ajouter"  />
    </s:form>
</div>
<div class="col-sm-10">
    <table class="table table-bordered table-hover table-condensed" id="patientTable">
        <thead>
            <tr>
                <th>Patient ID</th>
                <th>Salle Attente ID</th>
                <th>Personnel ID</th>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Addresse</th>
                <th>Date Naissance</th>
                <th>Num Tel</th>
                <th>Email</th>
                <th>Profession</th>
                <th>Sexe</th>
                <th>Age</th>
                <th>numSS</th>
                <th>numAssurance</th>
                <th>Action</th>
            </tr>
        </thead>
        <s:iterator value="patientList">
            <tr>
                <td><s:property value="patientID" /></td>
                <td><s:property value="salleAttenteID" /></td>
                <td><s:property value="personnelID" /></td>
                <td><s:property value="nom" /></td>
                <td><s:property value="prenom" /></td>
                <td><s:property value="addresse" /></td>
                <td><s:property value="dateNaissance" /></td>
                <td><s:property value="numTel" /></td>
                <td><s:property value="email" /></td>
                <td><s:property value="profession" /></td>
                <td><s:property value="sexe" /></td>
                <td><s:property value="age" /></td>
                <td><s:property value="numSS" /></td>
                <td><s:property value="numAssurance"/></td>
                <td>
                    <button onclick="fetchRow(this)" class="btn btn btn-info" data-toggle="modal" data-target="#updateModal">Update</button>
                    <button onclick="deletePatient(this)" class="btn btn btn-danger">Delete</button>
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
                                <input type="hidden" name="patientId" id="patientId">
                                <input type="text" name="cabinetID" id="cabinetID" class="form-control input-sm" placeholder="CabinetID">
                            </div>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="text" name="nom" id="nom" class="form-control input-sm" placeholder="Nom">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <input type="text" name="addresse" id="addresse" class="form-control input-sm" placeholder="Addresse">
                    </div>
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="date" name="dateNaissance" id="dateNaissance" class="form-control input-sm" placeholder="Date de naissance">
                            </div>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="text" name="numTel" id="numTel" class="form-control input-sm" placeholder="Num Telephone">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="text" name="email" id="email" class="form-control input-sm" placeholder="Email">
                            </div>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="text" name="profession" id="profession" class="form-control input-sm" placeholder="Profession">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="text" name="sexe" id="sexe" class="form-control input-sm" placeholder="sexe">
                            </div>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="text" name="age" id="age" class="form-control input-sm" placeholder="Age">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="text" name="numSS" id="numSS" class="form-control input-sm" placeholder="Num SS">
                            </div>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="text" name="numAssurance" id="numAssurance" class="form-control input-sm" placeholder="Num Assurance">
                            </div>
                        </div>
                    </div>
                    <button onclick="updateRecord();" class="btn btn-info btn-block">Update</button>
                    <div id="resp" class="text-center" style="margin-top: 13px;"></div>
                </div>
            </div>
        </div>
    </div>
</div>