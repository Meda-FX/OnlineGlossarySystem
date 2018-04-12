<%@ include file="../includes/header.jsp" %>  

<div class="container list-terms"> 
    <div id="crud">
        <h1>Manage Users</h1>
        <form action="manageusers" method="POST" id="form" >
            <div class="form-group">
                <label for="userId">User Id</label>
                <input type="text"  class="form-control" id="userId" placeholder="User ID" name="userId" value="${selectedUser.ID}">
            </div>
            <div class="form-group">
                <label for="userName">User Name</label>
                <input type="text" class="form-control" id="userName" placeholder="User Name" name="userName" value="${selectedUser.name}">
            </div>            
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Email" value="${selectedUser.email}">
            </div>           
            <div class="form-group">
                <label for="status">Status</label>
                <div>
                    <input type="radio" id="active" name="status" value="active"> Active
                    <input type="radio" id="inactive" name="status" value="inactive"> Inactive
                </div>
            </div>
            <div class="form-group">
                <label for="privList">Privilege</label>
                <div id="privList">
                    <c:forEach items="${privilegeList}" var="priv"> 
                        <input name="privilege" type="checkbox" value="${priv.privilegeID}"> ${priv.description}
                    </c:forEach>
                </div>                
            </div>  
            <!--<input type="hidden" name="saveTerm" value="save">-->
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
            <form action="manageusers" method="GET">    
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search with name or ID" id="txtSearch" name="txtSearch" value="${txtSearch}"/>
                    <input type="hidden" name="action" value="searchuser">
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
            <button type="button" class="btn navbar-right addTerms newUser">New User</button>
        </div>
    </div>
    <br>
    <!--table begins here-->
    <table class="table table-hover">
        <tr>
            <th>User Id</th>
            <th>Name</th>
            <th>Department</th>
            <th>Email</th>
            <th>Status</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${userList}" var="users">
            <tr>            
                <td><c:out value="${users.ID}"/></td>
                <td><c:out value="${users.name}"/></td>
                <td><c:out value="${users.department.name}"/></td>
                <td><c:out value="${users.email}"/></td>
                <td><c:if test="${users.isActivated}">Active</c:if>
                    <c:if test="${!users.isActivated}">Inactive</c:if>
                    </td>
                    <td>
                        <form action="manageusers" method="POST">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="selectedID" value="${users.ID}">
                        <input class="btn fa-input" type="submit" value="&#xf014">
                    </form>
                </td>
                <td>     
                    <form class="editUsers" action="manageusers" method="GET">                             
                        <input type="hidden" name="action" value="view">
                        <input type="hidden" name="selectedID" value="${users.ID}">
                        <input class="btn fa-input addTerms" type="submit" value="&#xf040"> 
                    </form>
                </td>
            </tr>
        </c:forEach> 
    </table> <!--Table ends here-->
</div> <!-- list items  -->
<%@ include file="../includes/footer.jsp" %>
