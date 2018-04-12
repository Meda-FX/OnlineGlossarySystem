<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>SAIT Glossary Registration</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="resources/css/style.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">        
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-xs-12 col-md-10 col-md-offset-1">
                    <form id="form-login" action="register" method="post">
                        <div class="form-header">
                            <h2>REGISTRATION</h2>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="fname" id="firstname" placeholder="Enter Your First Name" value="<c:out value="${fname}"></c:out>">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="lname" id="lastname" aria-describedby="emailHelp" placeholder="Enter Your Last Name" value="<c:out value="${lname}"></c:out>">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" name="pass" id="exampleInputEmail1" aria-describedby="password" placeholder="Enter Your Password">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" name="confirmPass" id="exampleInputEmail1" aria-describedby="confirmPassword" placeholder="Confirm Your Password">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="email" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Your Email" value="<c:out value="${email}"></c:out>">
                        </div>
                        <div class="form-group">
                            <input type="password" name="studentId" class="form-control" id="studentid" placeholder="Student ID" value="<c:out value="${studentId}"></c:out>">
                        </div>
                        <div class="form-group">
                            <select name="department">
                                <c:forEach var="school" items="${departments}">
                                    <option value="${school.departmentID}"><c:out value="${school.name}"></c:out></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="message">
                            <c:if test="${not empty message}">
                                <c:out value="${message}"></c:out>
                            </c:if>
                        </div>
                        <div>
                            <button class="login-button" type="submit">Register</button>
                        </div>
                        <hr>
                        <label>
                            <p id="regis-reset-login">
                                <a id="login-footer-link" href="search"><span class="glyphicon glyphicon-home"></span> HOME</a>
                            </p>
                        </label>
                    </form>  
                </div>
            </div>
        </div> <!-- Container ends here -->

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>
</body>
</html>
