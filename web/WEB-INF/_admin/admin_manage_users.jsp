<%@ include file="../includes/header.jsp" %>   
<div class="container list-terms"> 
    <div id="crud">
        <h1>Manage Users</h1>
        <form action="manageusers" method="POST" id="form" >
            <div class="form-group">
                <label for="user">User Id</label>
                <input type="text"  class="form-control" id="userId" name="userId" value="${selectedUser.ID}" readonly="">
            </div>
            <div class="form-group">
                <label for="term">User Name</label>
                <input type="text" class="form-control" id="userName" placeholder="User Name" name="userName" value="${selectedUser.name}">
            </div>
            <!--            <div class="form-group">
                            <label for="department">Department</label>
                            <input type="text" class="form-control" id="department" placeholder="Department" name="department" value="${selectedUser.department}">
                        </div>-->
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Email" value="${selectedUser.email}">
            </div> 
            <!--            <div class="form-group">
                            <label for="isActive">Active</label>
                            <input type="text" class="form-control" id="isActive" placeholder="Is Active" name="isActive" value="${selectedUser.isActive}">
                        </div>  -->
            <div class="form-group">
                <label for="status">Status</label>
                <div>
                    <input type="radio" id="active" name="status" value="active"> Active
                    <input type="radio" id="inactive" name="status" value="inactive"> Inactive
                </div>
            </div> 
            <!--            <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="password" placeholder="Password" name="password" value="${selectedUser.password}">
                        </div> -->
            <!--            <div class="form-group">
                            <label for="privilege">Privilege</label>
                            <input type="text" class="form-control" id="privilege" placeholder="Privilege" name="privilege" value="${selectedUser.privilege}">
                        </div>             -->
            <div class="form-group">
                <label for="privilege">Privilege</label>
                <div id="privList">
                    <c:forEach items="${privilegeList}" var="priv"> 
                        <input name="privilege" type="checkbox" value="${priv.privilegeID}" id="priv${priv.privilegeID}"> ${priv.description}
                    </c:forEach>
                </div>
                <!--                <div>
                                    <input name="privilege" type="checkbox" value="" > Administrator
                                    <input name="privilege" type="checkbox" value="" > Editor
                                    <input name="privilege" type="checkbox" value="" > Instructor
                                    <input name="privilege" type="checkbox" value="" > Student
                                </div>-->
            </div>  
            <!--<input type="hidden" name="saveTerm" value="save">-->
            <c:if test="${selectedUser == null}">
                <input class="btn" type="submit" value="Add User">
                <input type="hidden" name="action" value="register">
            </c:if>
            <c:if test="${selectedUser != null}">
                <input class="btn" type="submit" value="Save Changes">
                <input type="hidden" name="action" value="edit">
            </c:if>
            <input class=" btn hideFormTerm" type="button" value="Hide Form">
        </form>
    </div>
</div>
<br>

<div class="container list-terms">

    <!--     CRUD 
        <br>
        <div class="panel-group">
            <div class="panel">
                <div id="toogleText" class="panel-heading">
                    <h4  class="panel-title">
                        <a data-toggle="collapse" href="#collapse1"><h3>Manage Users</h3></a>
                    </h4>
                </div>
                <div id="collapse1" class="panel-collapse collapse">
                    <ul class="list-group">
    
    
                        <div class="form-group">
                            <label for="usr">Name:</label>
                            <input type="text" class="form-control" id="usr">
                        </div>
                        <div class="form-group">
                            <label for="pwd">Course Code:</label>
                            <input type="text" class="form-control" id="pwd">
                        </div>
                        <div class="form-group">
                            <label for="pwd">Department:</label>
                            <input type="text" class="form-control" id="pwd">
                        </div>
                        <div class="form-group">
                            <label for="pwd">Email:</label>
                            <input type="text" class="form-control" id="pwd">
                        </div>
                        <div class="form-group">
                            <label for="pwd">Course Name:</label>
                            <input type="text" class="form-control" id="pwd">
                        </div>
                        <button type="button" class="btn">SAVE</button>
                    </ul>
    
                </div>
            </div>
        </div>
         CRUD ends -->

    <br>
    <!--Search starts here-->
    <div class="row">
        <div class="col-xs-12 col-sm-10 col-md-6 col-md-offset-3 col-sm-offset-1">
            <form action="#" method="GET">    
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search terms" id="txtSearch" />
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
        <div class="newUser" class="col-md-12">
            <button type="button" class="btn navbar-right addTerms">New User</button>
        </div>
    </div>
<!--    <form class="editUsers" action="manageusers" method="GET">                             
        <input type="hidden" name="action" value="add">
        <input class="btn fa-input addTerms" type="submit" value="New User"> 
    </form>-->

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
