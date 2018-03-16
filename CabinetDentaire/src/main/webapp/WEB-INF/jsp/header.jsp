<%-- 
    Document   : header
    Created on : 9 mars 2018, 19:31:36
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<nav class="navbar navbar-inverse fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>                        
            </button>
            <a class="navbar-brand" href="acceuil">Saguenay Teeth</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="acceuil">Acceuil</a></li>
                <li><a href="GestionEmploye">Employés(Admin only)</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Patient
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="GestionPatient">Gestion des patients</a></li>
                        <li><a href="GestionDossier">Gestion des dossiers</a></li>
                        <li><a href="GestionRDV">Gestion des rendez-vous</a></li> 
                       <!-- <li><a href="#"><s>Visites</s></a></li> -->
                    </ul>
                </li>
                <li><a href="#">Contact</a></li>                
            </ul>            
            <ul class="nav navbar-nav navbar-right">
                <s:if test="%{#session.login!=null}">
                    <li><a><span class="glyphicon glyphicon-user"></span><s:property value="#session.login"/></a></li>
                <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span>Se deconnecter</a></li>
                </s:if>
                <s:else>
                <li><a href="toLog"><span class="glyphicon glyphicon-log-in"></span>Se connecter</a></li>
                </s:else>
            </ul>
        </div>
    </div>
</nav>
<script src="${pageContext.request.contextPath}/js/headerJs.js"></script>