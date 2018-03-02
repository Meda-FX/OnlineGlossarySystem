<%-- 
    Document   : ManageGlossaryGUI
    Created on : Mar 1, 2018, 1:32:11 PM
    Author     : 729347
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach var="term" items="${termlist}">
            ${term.term}
            <c:forEach var="definitions" items="%{definitionslist}">
                ${definitions.definitionList}
            </c:forEach>
        </c:forEach>
    </body>
</html>
