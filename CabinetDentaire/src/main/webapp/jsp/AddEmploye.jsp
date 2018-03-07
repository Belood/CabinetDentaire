<%-- 
    Document   : AddEmploye
    Created on : 6 mars 2018, 17:42:15
    Author     : USER
--%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>RegisterEmploye</title>
        <style type="text/css">
            .button-register {background-color: green;color: white;}
        </style>
    </head>
    <body>
        <h2>Test creation employe</h2>
        <s:form action="AddEmploye" method="post">
            
            <s:textfield label="Nom" name="nom" />
            <s:textfield label="Prenom" name="prenom" />
            <s:textfield label="Addresse" name="addresse" />
            <s:textfield type="date" label="DateNaissance" name="dateNaissance"/>
            <s:textfield label="NumTel" name="numTel" />
            <s:textfield label="Email"  name="email"/>
            <s:textfield label="Age"  name="age"/>
            <s:textfield label="Salaire"  name="salaire"/>
            <s:textfield type="date" label="DateEmbauche" name="dateEmbauche"/>
            <s:textfield label="Login"  name="login"/>
            <s:textfield label="Password"  name="password"/>
            <s:textfield label="NiveauDroits"  name="niveauDroits"/>
            <s:textfield label="Discriminator"  name="Discriminator"/>    
            <s:submit cssClass="button-register" value="Ajouter" />
        </s:form>
    </body>
</html>