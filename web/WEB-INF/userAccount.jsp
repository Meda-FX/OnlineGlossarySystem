<%@ include file="includes/header.jsp" %>   

<div class="container list-terms">
        <c:if test="${user.getName() == user.name}">            
        <h2><c:out value="${user.name}"/></h2>    
    <br>
    <!--table begins here-->
    <table class="table table-hover">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>            
            <th>Department</th>
            <th>Privilege</th>
            <th>Change Password</th>
        </tr>
        <tr>
            <td><c:out value="${user.getID()}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.department.name}"/></td>
            <td>
             <c:if test="${user.getPrivileges().contains(1) == true}">
               Administrator
            </c:if>                
            <c:if test="${user.getPrivileges().contains(2) == true}">
              Student
            </c:if>
            <c:if test="${user.getPrivileges().contains(3) == true}">
                Editor
            </c:if>
            <c:if test="${user.getPrivileges().contains(4) == true}">
                Instructor
            </c:if>            
            </td>
            <td> <a href="forgetpassword">Reset Password</a></td>
        </tr>
        </c:if>
    </table> <!--Table ends here-->
    <br>  
    
    <h3>Select Course</h3>
    <form action="user" method="POST">  
    <c:forEach items="${courseList}" var="course">
        <div class="checkbox">
        <label>
            <input name="selectedCourse" type="checkbox" <c:if test="${user.getCourses().contains(course.courseCode)==true}">checked</c:if> value="${course.courseCode}" >${course.courseCode}
        </label>        
        </div>
    </c:forEach>      
        <input type="hidden" name="action" value="addCourse">
        <input type="submit" value="Add Course">
    </form>
</div> <!-- list items  -->

<%@ include file="includes/footer.jsp" %>