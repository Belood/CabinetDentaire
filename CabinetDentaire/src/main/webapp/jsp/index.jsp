<%-- 
    Document   : index
    Created on : 5 mars 2018, 19:23:38
    Author     : Alexandre
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index</title>
    </head>
    <body>
        <form action = "HelloWorld">
            <label for = "name">Please enter your name</label><br/>
            <input type = "text" name = "name"/>
            <input type = "submit" value = "Say Hello"/>
    </body>
</html>
