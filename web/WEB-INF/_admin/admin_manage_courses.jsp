<%@ include file="../includes/header.jsp" %>   

<div class="container list-terms"> 
    <div id="crud">
        <h1>Manage Courses</h1>
        <form action="managecourses" method="POST" id="form" >
            <div class="form-group">
                <label for="courseID">Course Code</label>
                <input type="text"  class="form-control" id="courseId" placeholder="Course Code" name="courseId" value="${selectedUser.ID}">
            </div>
            <div class="form-group">
                <label for="courseName">Course Name</label>
                <input type="text" class="form-control" id="courseName" placeholder="Course Name" name="courseName" value="${selectedUser.name}">
            </div>
            <input class="btn" type="submit" value="Confirm">
            <input type="hidden" name="action" value="manage">
            <input class=" btn hideFormTerm" type="button" value="Hide Form">
        </form>
    </div>
</div>
<br>

<div class="container list-terms">
    <br>
    <!--Search starts here-->
    <div class="row">
        <div class="col-xs-12 col-sm-10 col-md-6 col-md-offset-3 col-sm-offset-1">
            <form action="managecourses" method="GET">    
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search courses" id="txtSearch" name="txtSearch" value="<c:out value="${txtSearch}"></c:out>"/>
                    <input type="hidden" name="action" value="search">
                    <div class="input-group-btn">
                        <button class="btn" type="submit">
                            <span class="glyphicon glyphicon-search"></span>
                        </button>
                    </div>
                </div>   
            </form>
            <div>
                <p class="message"><c:out value="${message}" /></p>   
            </div>
        </div>
    </div><!--Search ends here-->
    <div class="row">
        <div class="container">
            <button type="button" class="btn navbar-right addTerms newCourse">New Course</button>
        </div>
    </div>
    <br>

    <!--table begins here-->
    <table class="table table-hover">
        <tr>
            <th>Course Code</th>
            <th>Course Name</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${courseList}" var="course">
            <tr>            
                <td><c:out value="${course.courseCode}"/></td>
                <td><c:out value="${course.courseName}"/></td>
                    <td>
                        <form action="managecourses" method="POST">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="selectedID" value="${course.courseCode}">
                        <input class="btn fa-input" type="submit" value="&#xf014">
                    </form>
                </td>
                <td>     
                    <form class="editCourses" action="managecourses" method="GET">                             
                        <input type="hidden" name="action" value="view">
                        <input type="hidden" name="selectedID" value="${course.courseCode}">
                        <input class="btn fa-input addTerms" type="submit" value="&#xf040"> 
                    </form>
                </td>
            </tr>
        </c:forEach> 
    </table> <!--Table ends here-->

</div> <!-- list items  -->

<%@ include file="../includes/footer.jsp" %>
