<%-- 
    Document   : shoppingList
    Created on : 2022-2-14, 8:32:33
    Author     : Administrator
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>shoppingList Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, <c:out value="${user.getName()}" /> <a href="<c:url value='?action=logout' />">Logout</a></p>
        <h2>List</h2>
        <form action="<c:url value='?action=add' />" method="post">
            <label>Add item: </label><input type="textbox" name="item">&nbsp;&nbsp;<input type="submit" value="Add">
        </form>
        <p>${msg}</p>
        <form action="<c:url value='?action=delete' />" method="post">
            <ul>
                <c:forEach var="orderitem" items="${user.getItems()}">
                    <li><input type="radio" value="${orderitem}" name="orderitem">${orderitem}</li>
                </c:forEach>
            </ul>
            <input type="submit" value="Delete">
        </form>
    </body>
</html>
