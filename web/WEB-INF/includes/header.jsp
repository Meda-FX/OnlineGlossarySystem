<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="e" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>
             <c:if test="${user == null}">
               SAIT Glossary System
            </c:if>
            <c:if test="${user.getPrivileges().contains(1) == true}">
               Administrator - SAIT Glossary System
            </c:if>
            <c:if test="${user.getPrivileges().contains(2) == true}">
               Student - SAIT Glossary System
            </c:if>
            <c:if test="${user.getPrivileges().contains(3) == true}">
               Editor - SAIT Glossary System
            </c:if>
            <c:if test="${user.getPrivileges().contains(4) == true}">
               Instructor - SAIT Glossary System
            </c:if>
        </title>
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
                    <a class="navbar-brand" href="search">SAIT GLOSSARY</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav"> 
                         <c:if test="${user != null}">
                            <li><a href="#">ACCOUNT</a></li>
                            <li><a href="search">SEARCH</a></li>
                        </c:if>
                        
                        <!--------------------- Admin nav ---------------------->
                        <c:if test="${user.getPrivileges().contains(1) == true}">
                            <li><a href="admin?action=manageUsers">MANAGE USERS</a></li>
                            <li><a href="admin?action=report">REPORT</a></li>                        
                        </c:if>
                        
                        <!--------------------- Student nav ---------------------->
                        <c:if test="${user.getPrivileges().contains(2) == true}">
                            <li><a href="https://www.mysait.ca/cp/home/displaylogin" target="_blank">MY SAIT</a></li>
                             <li><a href="http://www.sait.ca/" target="_blank">SAIT</a></li>
                        </c:if>
                        
                        <!--------------------- Editor nav ---------------------->
                        <c:if test="${user.getPrivileges().contains(3) == true}"> 
                            <li><a href="edit?action=pendingTerms">PENDING TERMS</a></li> 
                        </c:if>
                        
                        <!--------------------- Instructor nav ---------------------->
                        <c:if test="${user.getPrivileges().contains(4) == true}">
                            <li><a href="instructor?action=yourterm">YOUR TERM</a></li>
                        </c:if>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                         <c:if test="${user != null}">
                           <li><a href="login?action=logout"><span class="glyphicon glyphicon-log-out"></span> LOGOUT</a></li>
                        </c:if>                                  
                         <c:if test="${user == null}">
                            <li><a href="#"><span class="glyphicon glyphicon-pencil"></span> REGISTER</a></li>
                            <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> LOGIN</a></li>
                        </c:if>                           
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>

        <div class="container-fluid">
