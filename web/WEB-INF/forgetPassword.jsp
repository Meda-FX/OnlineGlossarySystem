<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Reset Password</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="resources/css/style.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">        
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-xs-12 col-md-10 col-md-offset-1">
                    <form id="form-login" action="forgetpassword" method="post">
                        <div class="form-header">
                            <h2>Reset Password</h2>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="email" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Your Email">
                        </div>      
                        <div class="message">
                            <c:if test="${not empty message}">
                                <c:out value="${message}"></c:out>
                            </c:if>
                        </div>
                        <div>
                            <button class="login-button" type="submit" >Submit</button>
                        </div>                     
                       
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
