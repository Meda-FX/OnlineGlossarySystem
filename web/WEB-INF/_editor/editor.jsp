<%@ include file="../includes/header.jsp" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container list-terms"> 
    
<div id="crud">
    <form id="form" action="" method="post">
   <h1>Edit Terms</h1>
   <div class="form-group">
    <label for="term">Term ID</label>
    <input type="hidden" class="form-control" id="termId" name="${selectedTerm.definitionID}" readonly="">
  </div>
  
  <div class="form-group">
    <label for="term">Term</label>
    <input type="text" class="form-control" id="term" placeholder="Term" name="${selectedTerm.term}" readonly="">
  </div>
  <div class="form-group">
    <label for="definition">Definition</label>
    <textarea class="form-control" rows="5" id="definition" name="${selectedTerm.content}"></textarea>
  </div>
   <div class="form-group">
    <label for="sitation">Citation</label>
    <input type="text" class="form-control" id="citation" placeholder="Citation" name="${selectedTerm.citation}">
  </div>
        
   <div class="form-group">
    <label for="defDefinition">Dictionary Definition</label>
    <textarea class="form-control" rows="5" id="defDefinition" name="${selectedTerm.dictionaryContent}"></textarea>
  </div>
        
  <div class="form-group">
    <label for="dicCitation">Dictionary Citation</label>
    <input type="text" class="form-control" id="dicCitation" placeholder="Dectionary Citation" name="${selectedTerm.dictionaryCitation}">
  </div>
  
    <input type="hidden" name="saveTerm" value="save">
    <input type="submit" value="Save Term">
    
    <input type="hidden" name="submitTerm" value="submit">
    <input type="submit" value="Submit Term">
    
    <input class="hideFormTerm" type="button" value="Hide Form">
</form>
</div>
</div>
<br>

<!--Search starts here-->
<div class="row">
    <div class="col-xs-12 col-sm-10 col-md-6 col-md-offset-3 col-sm-offset-1">
        <form action="editor?action=search" method="GET">    
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Search terms" name="txtSearch" id="txtSearch" />
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

<!--Search filter starts here-->
<div class="row search-filter"> <!-- main filter container -->    
    <div class="col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">    

        <!-- Filter by instructor starts here -->
        <div class="col-xs-12 col-sm-6 col-md-6">
            <!-- Small button group -->
            <button id="dropdown_search" class="dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Filter By Course <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <c:forEach items="${courselist}" var="course">
                <li><a href="#"><c:out value="${course.courseCode}"/></a></li>

                </c:forEach>
            </ul>
        </div> <!-- Filter by instructor ends here-->    


        <!-- Filter by course starts here -->
        <div class="col-xs-12 col-sm-6 col-md-6">
            <!-- Small button group -->
            <button id="dropdown_search" class="dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Filter By Instructor <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <c:forEach items="${userlist}" var="user">
                <li><a href="#"><c:out value="${user.name}"/></a></li>
                </c:forEach>
            </ul>

        </div><!--Filter by course ends here-->

    </div>     
</div> <!-- main filter container -->
<!--Search filter ends here-->

<div class="container list-terms">

    <table class="table table-hover">
        <thead>
            <tr>
                <th scope="col">Term</th>
                <th scope="col">Definition</th>
                <th scope="col">Date</th>
                <th scope="col">Owner</th>
                <th scope="col">Status</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <!--    <tr>
                  <td>JAVA</td>
                  <td>
                    It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.
                  </td>     
                  <td>JAN 25-2017</td>
                  <td>Maryam Mossavi</td> 
                  <td><span id="icons" class="glyphicon glyphicon-trash"></span></td>
                  <td><span id="icons" class="glyphicon glyphicon-pencil"></span> </td>
                </tr>-->            

            <c:forEach items="${definitionlist}" var="def">
                <tr>
                    <td><c:out value = "${def.term}"/></td>
                    <td>
                        <c:out value = "${def.content}"/>
                    </td> 
                    <td><fmt:formatDate value="${def.dateCreated}" pattern="yyyy-MM-dd" /></td>
                    <td><c:out value = "${def.writtenBy.name}"/></td> 
                    <td><c:out value = "${def.writtenBy.name}"/></td> 
                    <td><span id="icons" class="glyphicon glyphicon-trash"></span></td>
                    <td>     
                        <form action="edit" method="GET">
                            <!--<span id="icons" class="glyphicon  glyphicon-pencil addTerms"></span>-->      
                            <input type="hidden" name="action" value="edit">
                            <input type="hidden" name="defId" value="${def.definitionID}">
                            <input type="submit" value="Edit">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div> <!-- list items  -->

<%@ include file="../includes/footer.jsp" %>
