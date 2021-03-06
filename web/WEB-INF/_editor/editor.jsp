<%@ include file="../includes/header.jsp" %>   

<div class="container list-terms"> 
    <div id="crud" class="hide">
        <h1>Edit Terms</h1>
        <form action="edit" method="POST" id="form" >
            <div class="form-group">
                <label for="term">Term ID</label>
                <input type="text"  class="form-control" id="termId" name="defId" value="${selectedTerm.definitionID}" readonly="">
            </div>
            <div class="form-group">
                <label for="term">Term</label>
                <input type="text" class="form-control" id="term" placeholder="Term" name="term" value="${selectedTerm.term}" readonly="">
            </div>
            <div class="form-group">
                <label for="definition">Definition</label>
                <textarea class="form-control" rows="5" id="definition" name="definition" value="${selectedTerm.content}"></textarea>
            </div>
            <div class="form-group">
                <label for="sitation">Citation</label>
                <input type="text" class="form-control" id="citation" placeholder="Citation" name="citation" value="${selectedTerm.citation}">
            </div>

            <div class="form-group">
                <label for="defDefinition">Dictionary Definition</label>
                <textarea class="form-control" rows="5" id="defDefinition" name="defDefinition" value="${selectedTerm.dictionaryContent}"></textarea>
            </div>
            <div class="form-group">
                <label for="dicCitation">Dictionary Citation</label>
                <input type="text" class="form-control" id="dicCitation" name="dicCitation" placeholder="Dectionary Citation" value="${selectedTerm.dictionaryCitation}">
            </div>              
            <!--<input type="hidden" name="saveTerm" value="save">-->
            <input class="btn" type="submit" name="action" value="Save Term">
            <!--<input type="hidden" name="submitTerm" value="submit">-->
            <input class="btn" type="submit" name="action" value="Submit Term">
            <input class=" btn hideFormTerm" type="button" value="Hide Form">
        </form>
    </div>
</div>
<br>
<!--Search starts here-->
<form action="edit?action=search" method="GET"> 
    <div class="row">
        <div class="col-xs-12 col-sm-10 col-md-6 col-md-offset-3 col-sm-offset-1">           
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Search terms" name="txtSearch" id="txtSearch" value="${txtSearch}"/>
                
                
                <div class="input-group-btn">
                    <button class="btn" type="submit">
                        <span class="glyphicon glyphicon-search"></span>
                    </button>
                </div>
            </div>           
            <div>
                <p class="message"><c:out value="${message}"/></p>   
            </div>
        </div>
    </div><!--Search ends here-->
    <!--Search filter starts here-->
    <div class="row search-filter"> <!-- main filter container -->    
        <div class="col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">   
            <!-- Filter by instructor starts here -->
            <div class="col-xs-12 col-sm-6 col-md-6">
                <select class="form-control searchFilterDD" name="courseCode">
                    <option value="">Filter By Course</option>
                    <c:forEach items="${courselist}" var="course">
                        <option  value="${course.courseCode}"><c:out value="${course.courseCode}"/></option>
                    </c:forEach>
                </select>
            </div> <!-- Filter by instructor ends here-->  
            <!-- Filter by course starts here -->
            <div class="col-xs-12 col-sm-6 col-md-6">
                <select class="form-control" name="userId">
                    <option value="">Filter By Instructor</option>
                    <c:forEach items="${userlist}" var="user">
                        <option  value="${user.getID()}"><c:out value="${user.name}"/></option>
                    </c:forEach>
                </select>
            </div><!--Filter by course ends here-->
        </div>     
    </div> <!-- main filter container -->
    <!--Search filter ends here-->
</form>
<br>
<div class="container list-terms">
    <table class="table table-hover">       
        <tr>
            <th scope="col">Term</th>
            <th scope="col">Definition</th>
            <th scope="col">Date</th>
            <th scope="col">Owner</th>
            <th scope="col">Status</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${definitionlist}" var="def">
            <tr>
                <td><c:out value = "${def.term}"/></td>
                <td>
                    <c:out value = "${def.content}"/>
                </td> 
                <td><fmt:formatDate value="${def.dateCreated}" pattern="yyyy-MM-dd" /></td>
                <td><c:out value = "${def.writtenBy.name}"/></td> 
                <td><c:out value = "${def.status}"/></td> 
                <td>
                    <!--<span id="icons" class="glyphicon glyphicon-trash"></span>-->
                    <form action="edit" method="POST">
                        <input type="hidden" name="action" value="Delete Term">
                        <input type="hidden" name="defId" value="${def.definitionID}">
                        <input class="btn fa-input addTerms" type="submit" value="&#xf014">
                    </form>
                </td>
                <td>     
                    <form class="editForm" action="edit" method="GET">
                        <!--<span id="icons" class="glyphicon  glyphicon-pencil addTerms"></span>-->                              
                        <input type="hidden" name="action" value="edit">
                        <input type="hidden" name="defId" value="${def.definitionID}">
                        <input class="btn fa-input addTerms" type="submit" value="&#xf040"> 
                    </form>
                </td>
            </tr>
        </c:forEach>       
    </table>
</div> <!-- list items  -->

<%@ include file="../includes/footer.jsp" %>
