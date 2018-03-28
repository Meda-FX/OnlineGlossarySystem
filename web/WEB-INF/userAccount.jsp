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
        </tr>
        </c:if>
    </table> <!--Table ends here-->
    <br>  
    
    <h3>Select Course</h3>
    <c:forEach items="${courseList}" var="course">
        <div class="checkbox">
        <label>
            <input type="checkbox" <c:out value="${course.courseCode}"/>>${course.courseCode}
        </label>        
        </div>
    </c:forEach>
    <form action="user" method="POST">    
        <input type="hidden" name="action" value="addcourse">
        <input type="submit" value="Add Course">
    </form>
</div> <!-- list items  -->

<%@ include file="includes/footer.jsp" %>