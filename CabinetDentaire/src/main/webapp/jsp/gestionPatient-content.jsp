<%-- 
    Document   : gestionPatient-content
    Created on : 10 mars 2018, 19:21:08
    Author     : Alexandre
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/js/gestionPatientJs.js"></script>
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
                <td><s:property value="email" /></td>
                <td><s:property value="profession" /></td>
                <td><s:property value="sexe" /></td>
                <td><s:property value="age" /></td>
                <td><s:property value="numSS" /></td>
                <td><s:property value="numAssurance"/></td>
                <td>
                    <a href="updatedetails.action?submitType=updatedata&uemail=<s:property value="uemail"/>">
                        <button class="btn btn-primary">Update</button>
                    </a>
                    <a href="updatedetails.action?submitType=updatedata&uemail=<s:property value="uemail"/>">
                        <button class="btn btn-danger">Delete</button>
                    </a>

                </td>
            </tr>
        </s:iterator>
    </table>
</div>