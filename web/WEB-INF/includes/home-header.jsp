<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="e" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Glossary System</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="resources/css/style.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">    
        <!--Favicons starts-->
        <link rel="icon" type="image/png" href="http://www.sait.ca/assets/prebuilt/img/favicon/favicon-16x16.png" sizes="16x16">
        <link rel="icon" type="image/png" href="http://www.sait.ca/assets/prebuilt/img/favicon/favicon-32x32.png" sizes="32x32">
        <link rel="icon" type="image/png" href="http://www.sait.ca/assets/prebuilt/img/favicon/favicon-96x96.png" sizes="96x96">
        <!--Favicons ends-->
    </head>
    <body>
        
        <nav class="navbar">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button id="hamburger" type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!--<a id="logoImage" class="navbar-brand" href="#"><img src="./assets/img/logo.png" /></a>-->
                    <a class="navbar-brand" href="#"> SAIT GLOSSARY</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="index.html"><span class="glyphicon glyphicon-pencil"></span> REGISTER</a></li>
                        <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> LOGIN</a></li>
                    </ul>

                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>

        <div class="container-fluid">
