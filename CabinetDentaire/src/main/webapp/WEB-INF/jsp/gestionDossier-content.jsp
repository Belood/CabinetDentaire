<%-- 
    Document   : dossier-content
    Created on : 15 mars 2018, 18:06:28
    Author     : Alexandre
--%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/js/gestionDossierJs.js" charset="utf-8"></script>
<div class="col-xs-10 col-xs-offset-2">
    <h2 class="text-center">Liste des dossiers</h2>
    <table class="table table-bordered table-hover table-condensed" id="dossierTable">
        <thead>
            <tr>
                <th>ID Dossier</th>
                <th>ID Patient</th>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Remarque</th>
                <th>Date de création</th>
                <th>Date dernière modification</th>
                <th>Action</th>
            </tr>
        </thead>
        <s:iterator value="dossierList">
            <tr>
                <td><s:property value="dossierID" /></td>
                <td><s:property value="patientID" /></td>
                <td><s:property value="nom" /></td>
                <td><s:property value="prenom" /></td>
                <td><s:property value="remarque" /></td>                
                <td><s:property value="dateCreation" /></td>
                <td><s:property value="dateDerniereModif" /></td>   
                <td>
                    <a href="showConsultation" ><button onclick="showConsultation(this)" class="btn btn btn-primary">Consultation</button></a>
                </td>
            </tr>
        </s:iterator>
    </table>
</div>
