<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>SAIT Glossary Login</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="resources/css/style.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">        
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-xs-12 col-md-10 col-md-offset-1">
                    <form id="form-login" action="#" method="post">
                        <div class="form-header">
                            <h2>SAIT GLOSSARY</h2>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="email" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Your Email">
                        </div>
                        <div class="form-group">
                            <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                        </div>      
                        <div class="message">  
                            ${message}
                        </div>
                        <div>
                            <button class="login-button" type="submit" >Login</button>
                        </div>
                        <hr>
                        <label>
                            <p id="regis-home_login">
                                <a id="login-footer-link" href="search"><span class="glyphicon glyphicon-home"></span>   Home</a>
                            </p>
                        </label>  
                        <label>|</label>  
                        <label>
                            <p id="regis-reset-login">			        
                                <a id="login-footer-link" href="#">   Reset Password</a>
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
