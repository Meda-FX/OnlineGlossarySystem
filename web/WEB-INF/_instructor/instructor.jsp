<%@ include file="../includes/header.jsp" %>   

<div class="container list-terms"> 

    <div id="crud">
        <form action="instructor" method="post">
            <h1>Add Terms</h1>    
            <div class="form-group">
                <label for="term">Term</label>
                <input type="text" class="form-control" id="term" value="${term}" name="term" placeholder="Term">
            </div>
            <div class="form-group">
                <label for="definition">Definition</label>
                <textarea class="form-control" rows="5" name="definition" id="definition">${definition}</textarea>
            </div>
            <div class="form-group">
                <label for="sitation">Citation</label>
                <input type="text" class="form-control" value="${citation}" id="citation" name="citation" placeholder="Citation">
            </div>

            <div class="form-group">
                <label for="defDefinition">Dictionary Definition</label>
                <textarea class="form-control" rows="5" value="" name="defDefinition" id="defDefinition">${defDefinition}</textarea>
            </div>

            <div class="form-group">
                <label for="dicCitation">Dictionary Citation</label>
                <input type="text" class="form-control" value="${defCitation}" id="dicCitation" name="dicCitation" placeholder="Dectionary Citation">
            </div>

            <div class="form-group selectpicker">
                <label for="course-code">Course Code:</label>
                <select id="courseCode" name="courseCode">
                    <option value="-1" >Please select course</option>
                    <c:forEach items="${courseList}" var="course">
                        <option value="${course.courseCode}" >${course.courseCode} - ${course.courseName}</option>                        
                    </c:forEach>
                </select>
            </div>   



            <!--<button type="button" class="btn">Save Term</button>-->
            <!--<button type="button" class="btn">Submit Term</button>-->
            <!--<button type="button" class="btn hideFormTerm">Hide Form</button>-->



            <input type="submit" name="submitButton" value="Save Term">


            <input type="submit" name="submitButton" value="Submit Term">

            <input class="hideFormTerm" type="button" value="Hide Form">

        </form>
    </div>
</div>
<br>

<!--to be deleted-->
<div class="container list-terms">         

    <!--to be deleted-->
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
                <p class="message">${message}</p>   
            </div>
        </div>
    </div><!--Search ends here-->

    <div class="row">
        <div class="newTerm" class="col-md-12">
            <button type="button" class="btn navbar-right addTerms">Add Term</button>
        </div>
    </div>

    <!--table begins here-->
    <table class="table table-hover"> 
        <thead>
            <tr>                
                <th scope="col">Term</th>
                <th scope="col">Definition</th>
                <th scope="col">Course</th>
                <th scope="col">Date</th>
                <th scope="col">Status</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${definitionlist}" var="def">
                <tr>
                    <td><c:out value = "${def.term}"/></td>
                    <td>
                        <c:out value = "${def.content}"/>
                    </td> 
                    <td><c:out value = "${def.writtenBy.name}"/></td>
                    <td><fmt:formatDate value="${def.dateCreated}" pattern="yyyy-MM-dd" /></td> 
                    <td><c:out value = "${def.status}"/></td> 
                    <td>
                        <!--<span id="icons" class="glyphicon glyphicon-trash"></span>-->
                        <form action="instructor" method="POST">
                        <input type="hidden" name="defId" value="${def.definitionID}">
                        <input type="submit" name="submitButton" value="Delete">
                        </form>
                    </td>
                    <td>     
            <form class="editInstructorForm" action="instructor" method="GET">
                        <!--<span id="icons" class="glyphicon  glyphicon-pencil addTerms"></span>-->      
                        <input type="hidden" name="action" value="edit">
                        <input type="hidden" name="defId" value="${def.definitionID}">
                        <input class="addTerms" name="submitButton" type="submit" value="Edit">
            </form>
            </td>
            </tr>
        </c:forEach>         
        </tbody>
    </table> <!--Table ends here-->
</div>
</div> <!-- list items  -->

<%@ include file="../includes/footer.jsp" %>
