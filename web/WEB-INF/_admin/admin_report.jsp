<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>  

<div class="container list-terms">

    <div calss="row"> 
        <h3>Monthly Usage Report</h3>
        <hr>
        <p> 
            The report provides an accurate number of users that utilizes Sait’s glossary system during the month of selected period.
            The report provides an accurate number of users that utilizes Sait’s glossary system during the month of selected period.
        </p>
        <div class="col-xs-12 col-sm-6 col-md-4 col-md-offset-1">
            <div class="form-group">
                <label for="start">Start Date:</label>
                <input type="date" class="form-control" id="start">
            </div>
        </div>

        <div class="col-xs-12 col-sm-6 col-md-4 col-md-offset-1">
            <div class="form-group">
                <label for="end">End Date:</label>
                <input type="date" class="form-control" id="end">
            </div>
        </div>

        <div class="col-xs-12 col-md-12">
            <button type="button" class="btn">GENERATE REPORT</button>
        </div>
        <br>
        
        <!-- Chart goes here -->
        <div class="col-xs-12 col-md-12">
            <h3> Summary Report </h3>
            <hr>
            <br>
            <p>
                The chart shows the amount of logged in users between January 2017 and December 2017.
            </p>
            <img src="./assets/img/chart.png">
        </div>
    </div>
</div> <!-- list items  -->

<%@ include file="../includes/footer.jsp" %>