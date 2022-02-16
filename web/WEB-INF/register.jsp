<%-- 
    Document   : register
    Created on : 2022-2-14, 8:32:10
    Author     : Administrator
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>register Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="<c:url value='?action=register' />" method="post">
            <label>Username: </label><input type="textbox" name="username">&nbsp;&nbsp;<input type="submit" value="Register Name">
        </form>
        <p>${message}</p>
    </body>
</html>
