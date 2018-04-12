<%@ include file="includes/header.jsp" %>   

<div class="row">
    <div class="col-xs-12 col-sm-10 col-md-8 col-md-offset-2 col-sm-offset-1">
        <!-- Alphabet buttons -->
        <div class="alphabets">
            <div class="btn-group btn-group-xs">
                <a class="btn btn-default" href="search?action=alphSearch&letter=a">A</a>
                <a class="btn btn-default" href="search?action=alphSearch&letter=b">B</a>
                <a class="btn btn-default" href="search?action=alphSearch&letter=c">C</a>
                <a class="btn btn-default" href="search?action=alphSearch&letter=d">D</a>
                <a class="btn btn-default" href="search?action=alphSearch&letter=e">E</a>
                <a class="btn btn-default" href="search?action=alphSearch&letter=f">F</a>
                <a class="btn btn-default" href="search?action=alphSearch&letter=g">G</a>
                <a class="btn btn-default" href="search?action=alphSearch&letter=h">H</a>
                <a class="btn btn-default" href="search?action=alphSearch&letter=i">I</a>
                <a class="btn btn-default" href="search?action=alphSearch&letter=j">J</a>
                <a class="btn btn-default" href="search?action=alphSearch&letter=k">K</a>
                <a class="btn btn-default" href="search?action=alphSearch&letter=l">L</a>
                <a class="btn btn-default" href="search?action=alphSearch&letter=m">M</a>
                <a class="btn btn-default" href="search?action=alphSearch&letter=n">N</a>
                <a class="btn btn-default" href="search?action=alphSearch&letter=o">O</a>
                <a class="btn btn-default" href="search?action=alphSearch&letter=p">P</a>
                <a class="btn btn-default" href="search?action=alphSearch&letter=q">Q</a>
                <a class="btn btn-default" href="search?action=alphSearch&letter=r">R</a>
                <a class="btn btn-default" href="search?action=alphSearch&letter=s">S</a>
                <a class="btn btn-default" href="search?action=alphSearch&letter=t">T</a>
                <a class="btn btn-default" href="search?action=alphSearch&letter=u">U</a>
                <a class="btn btn-default" href="search?action=alphSearch&letter=v">V</a>
                <a class="btn btn-default" href="search?action=alphSearch&letter=w">W</a>
                <a class="btn btn-default" href="search?action=alphSearch&letter=x">X</a>
                <a class="btn btn-default" href="search?action=alphSearch&letter=y">Y</a>
                <a class="btn btn-default" href="search?action=alphSearch&letter=z">Z</a>
            </div>
        </div>
    </div>
</div>
<!--Search starts here-->
<form action="search" method="GET">  
    <div class="row">
        <div class="col-xs-12 col-sm-10 col-md-6 col-md-offset-3 col-sm-offset-1">
            <div class="input-group">
                <input type="text" class="form-control" name="searchedEntry" placeholder="Search terms" id="txtSearch" value="${searchedEntry}" />
                <input type="text" name="action" value="searchTerm" hidden/>
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
    <c:if test="${user == null}">
        <!--Search filter starts here-->
        <div class="search-filter">
            <div class="row">
                <div class="col-xs-8 col-md-4 col-md-offset-4 col-xs-offset-2">                   
                    <select class="form-control" name="departmentID">
                        <option value="">Filter By School</option>
                        <c:forEach items="${deparlist}" var="department">
                            <option  value="${department.departmentID}" <c:if test="${curSelectedDepart==department.departmentID}">selected</c:if>><c:out value="${department.name}"/></option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
    </c:if>
    <c:if test="${user != null}">
        <div class="search-filter">
            <div class="row">
                <div class="col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
                    <!-- Filter by instructor starts here -->
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <select class="form-control searchFilterDD" name="courseCode">
                            <option value="">Filter By Course</option>
                            <c:forEach items="${courselist}" var="course">
                                <option  value="${course.courseCode}" <c:if test="${curSelectedCour==course.courseCode}">selected</c:if>><c:out value="${course.courseCode}"/></option>
                            </c:forEach>
                        </select>
                    </div> <!-- Filter by instructor ends here-->  
                    <!-- Filter by course starts here -->
                    <div class="col-xs-12 col-sm-6 col-md-6">                        
                        <select class="form-control" name="userId">
                            <option value="">Filter By Instructor</option>
                            <c:forEach items="${instructorlist}" var="user">
                                <option  value="${user.getID()}" <c:if test="${curSelectedUser==user.getID()}">selected</c:if>><c:out value="${user.name}"/></option>
                            </c:forEach>
                        </select>
                    </div><!--Filter by course ends here-->
                </div>        
            </div>    
        </div> <!--Search filter ends here-->
    </form>
</c:if>
<br><br>
<div class="container list-terms">
    <div>
        <h4>Term List</h4>
        <hr class="line">
    </div>
    <!-- Term definitions starts here -->
    <c:if test="${noSuchEntry != true}">
        <c:forEach var="definition" items="${definitionlist}"> 
            <div class="row">
                <!--Left side of the search result starts here: Term title, instructor, citation and date created-->
                <div class="col-xs-12 col-md-3">
                    <h4><c:out value="${definition.term}" /></h4>
                    <p>Instructor: <c:out value="${definition.writtenBy.name}" /></p>                   
                    <p>Date: <fmt:formatDate value="${definition.dateCreated}" pattern="yyyy-MM-dd" /></p>
                </div><!--Left side of the search ends here-->

                <!--Right side of the search result starts here: term definition-->
                <c:if test="${user.getPrivileges().contains(3) == true}">
                    <div class="col-xs-10 col-md-9">
                    </c:if>

                    <c:if test="${user.getPrivileges().contains(3) != true}">
                        <div class="col-xs-12 col-md-9">
                        </c:if>
                        <h4>Term Definition</h4>
                        <div> 
                            <c:out value="${definition.content}" /> <a class="readMore hide" href="#"> Read More </a>
                            <span class="readMoreContent">
                                <div><h5>Citation</h5></div>
                                <div><c:out value="${definition.citation}" /></div>
                                <div><h5>Dictionary Definition</h5></div>
                                <div><c:out value="${definition.dictionaryContent}" /></div>
                                <div><h5>Citation</h5></div>
                                <div><c:out value="${definition.dictionaryCitation}" /></div> 
                                <div><a class="readLess hide" href="#">Read Less</a></div>                                    
                            </span>
                        </div>
                    </div><!--Right side of the search ends here-->  
                </div><!-- Term definitions end here -->
                <hr class="line">
            </c:forEach>
        </c:if>
        <c:if test="${emptyInput == true}">
            <p class="message">You have to type a term.</p>   
        </c:if>
        <c:if test="${noSuchEntry == true}">
            <p class="message">The term does not exist.</p>   
        </c:if>
        <br>
    </div>
</div> <!-- list items  -->

<%@ include file="includes/footer.jsp" %>
