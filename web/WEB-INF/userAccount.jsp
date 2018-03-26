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
            <th>Course Name</th>
            <th>Privilege</th>
            <c:if test="${user.getPrivileges().contains(3) == true}">
            <th>Privilege</th>
            </c:if>
        </tr>
        <tr>
            <td><c:out value="${user.getID()}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.name}"/></td>
             <c:if test="${user.getPrivileges().contains(1) == true}">
               <td>Administrator</td>
            </c:if>
            <c:if test="${user.getPrivileges().contains(2) == true}">
               <td>Student</td>
            </c:if>
            <c:if test="${user.getPrivileges().contains(3) == true}">
                <td>Editor</td>
            </c:if>
            <c:if test="${user.getPrivileges().contains(4) == true}">
                <td>Instructor</td>
            </c:if>            
        </tr>
        </c:if>
    </table> <!--Table ends here-->

</div> <!-- list items  -->

<%@ include file="includes/footer.jsp" %>