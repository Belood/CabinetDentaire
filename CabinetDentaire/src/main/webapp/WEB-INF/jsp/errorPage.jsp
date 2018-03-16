<%-- 
    Document   : errorPage
    Created on : 15 mars 2018, 21:38:48
    Author     : Alexandre
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <title>Error Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs/dt-1.10.16/datatables.min.css"/>
        <script type="text/javascript" src="https://cdn.datatables.net/v/bs/dt-1.10.16/datatables.min.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/template.css">
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/header.jsp"/>
        <div class="container-fluid" id="mainContent">
            <s:if test="%{#session.login!=null}">
                <h1>Vous ne disposez pas des droits nécessaires pour accéder à cette ressource</h1>  
            </s:if>
            <s:else>
                <h1>Vous devez être connecté pour accéder à cette ressource</h1>
            </s:else>
        </div>
        <jsp:include page="/WEB-INF/jsp/footer.jsp"/>


    </body>
</html>