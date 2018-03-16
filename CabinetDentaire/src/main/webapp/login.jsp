<%-- 
    Document   : login
    Created on : Mar 8, 2018, 6:08:39 PM
    Author     : assil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Mystyle.css">
        <link href="https://fonts.googleapis.com/css?family=Coiny" rel="stylesheet">

        <title>Login Page</title>
    </head>
    <body>

        <div class="container">
            <div class="login-container">
                <div id="output"></div>
                <div class="avatar">saguenay Teeth</div>
                <div class="form-box">
                    <s:form action="login" theme="simple">
                        <s:textfield key="login" placeholder="username" requiredLabel="true" />
                        <s:password key="password" placeholder="password" requiredLabel="true" />
                        <s:submit class="btn btn-block btn-primary" value="Se connecter"/>
                    </s:form>  

                </div>
            </div>

        </div>
    </body>
</html>
