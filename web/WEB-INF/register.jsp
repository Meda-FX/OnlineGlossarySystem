<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <form id="form-login" action="#" method="post">
                        <div class="form-header">
                            <h2>REGISTRATION</h2>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="fname" id="firstname" placeholder="Enter Your First Name">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="lname" id="lastname" aria-describedby="emailHelp" placeholder="Enter Your Last Name">
                        </div>
                         <div class="form-group">
                            <input type="password" class="form-control" name="pass" id="exampleInputEmail1" aria-describedby="password" placeholder="Enter Your Password">
                        </div>
                         <div class="form-group">
                            <input type="password" class="form-control" name="confirmPass" id="exampleInputEmail1" aria-describedby="confirmPassword" placeholder="Confirm Your Password">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="email" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Your Email">
                        </div>
                        <div class="form-group">
                            <input type="password" name="studentId" class="form-control" id="studentid" placeholder="Student ID">
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
