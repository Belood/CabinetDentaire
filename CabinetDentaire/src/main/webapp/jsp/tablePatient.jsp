<%-- 
    Document   : tablePatient
    Created on : 7 mars 2018, 18:05:58
    Author     : Alexandre
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <thead>
                <tr style="background-color: #E0E0E1;">
                    <th>Patient ID</th>
                    <th>Salle Attente ID</th>
                    <th>Personnel ID</th>
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>Addresse</th>
                    <th>Date Naissance</th>
                    <th>Email</th>
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
                </tr>
            </s:iterator>
        </table>
    </body>
</html>
