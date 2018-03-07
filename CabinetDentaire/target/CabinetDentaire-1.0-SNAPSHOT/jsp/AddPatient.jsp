<%-- 
    Document   : AddPatient
    Created on : 6 mars 2018, 13:35:21
    Author     : Alexandre
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Register</title>
        <style type="text/css">
            .button-register {background-color: green;color: white;}
        </style>
    </head>
    <body>
        <h2>Test creation patient</h2>
        <s:form action="AddPatient" method="post">
            <s:textfield label="Nom" name="nom" />
            <s:textfield label="Prenom" name="prenom" />
            <s:textfield label="Addresse" name="addresse" />
            <s:textfield type="date" label="DateNaissance" name="dateNaissance"/>
            <s:textfield label="Num Tel" name="numTel" />
            <s:textfield label="Email"  name="email"/>
            <s:textfield label="Profession"  name="profession"/>
            <s:radio list="{'homme','femme'}" label="Sexe" name="sexe"/>
            <s:textfield label="Age"  name="age"/>
            <s:textfield label="NumSS"  name="numSS"/>
            <s:textfield label="NumAssurance"  name="numAssurance"/>
            <s:submit cssClass="button-register" value="Ajouter" />
        </s:form>
    </body>
</html>