<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>  

<div class="container list-terms">

    <div calss="row"> 
        <h3>Daily Usage Report</h3>
        <hr>
        <p> 
            The report provides an accurate plot of the selected activity between the selected dates.
        </p>
        <form action="report" method="GET">
        <div class="col-xs-12 col-sm-6 col-md-4 col-md-offset-1">
            <div class="form-group">
                <label for="start">Start Date:</label>
                <input type="date" class="form-control" id="start" name="start">
            </div>
        </div>

        <div class="col-xs-12 col-sm-6 col-md-4 col-md-offset-1">
            <div class="form-group">
                <label for="end">End Date:</label>
                <input type="date" class="form-control" id="end" name="end">
            </div>
        </div>

        <select id="type">
            <option value="" selected disabled hidden>Report Type</option>
            <option value="1">Registrations</option>
            <option value="2">Logins</option>
        </select>
        <div class="col-xs-12 col-md-12">
            <input type="submit" class="btn">GENERATE REPORT</button>
            <input type="hidden" name="action" value="report">
        </div>
        <br>
        </form>
        <!-- Chart goes here -->
        <div class="col-xs-12 col-md-12">
            <h3> Report </h3>
            <hr>
            <br>
            <canvas id="canvas"></canvas>
        </div>
    </div>
</div> <!-- list items  -->

<%@ include file="../includes/footer.jsp" %>