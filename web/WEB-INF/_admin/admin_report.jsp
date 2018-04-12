<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>  

<div class="container list-terms">
    <div calss="row"> 
        <h3>Daily Usage Report</h3>
        <hr>
<!--        <p> 
            The report provides an accurate plot of the daily selected activity between the selected dates.
        </p>-->
        <form class="reportForm" action="report" method="GET">
            <div class="col-xs-12 col-sm-6 col-md-6">
                <div class="form-group">
                    <label for="start">Start Date:</label>
                    <input type="date" class="form-control" id="start" name="start">
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-6">
                <div class="form-group">
                    <label for="end">End Date:</label>
                    <input type="date" class="form-control" id="end" name="end">
                </div>
            </div>
            <div class="col-xs-8 col-sm-4 col-md-4 col-sm-offset-2">
                <select class="form-control" name="type" id="reportType">
                    <option value="" selected disabled hidden>Report Type</option>
                    <option value="1">Registrations</option>
                    <option value="2">Logins</option>
                </select>
            </div>

            <div class="col-xs-4 col-sm-3 col-md-2">
                <div>
                    <input type="submit" class="btn" value="GENERATE REPORT">
                    <input type="hidden" name="action" value="report">
                </div>
            </div>
            <br>
        </form>
<br>
        <!-- Chart goes here -->
        <div class="col-xs-12 col-md-10 col-md-offset-1">
<!--            <h3> Report </h3>
            <hr>-->
            <c:out value="${message}"></c:out>
                <br>
                <canvas id="canvas"></canvas>
            </div>
            <br><br>
        </div>
        
    </div> <!-- list items  -->
<%@ include file="../includes/footer.jsp" %>