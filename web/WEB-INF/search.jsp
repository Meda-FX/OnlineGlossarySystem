<%@ include file="includes/header.jsp" %>   

<div class="row">
    <div class="col-xs-12 col-sm-10 col-md-8 col-md-offset-2 col-sm-offset-1">
        <!-- Alphabet buttons -->
        <div class="alphabets">
            <div class="btn-group btn-group-xs">
                <button class="btn btn-default">A</button>
                <button class="btn btn-default">B</button>
                <button class="btn btn-default">C</button>
                <button class="btn btn-default">D</button>
                <button class="btn btn-default">E</button>
                <button class="btn btn-default">F</button>
                <button class="btn btn-default">G</button>
                <button class="btn btn-default">H</button>
                <button class="btn btn-default">I</button>
                <button class="btn btn-default">J</button>
                <button class="btn btn-default">K</button>
                <button class="btn btn-default">L</button>
                <button class="btn btn-default">M</button>
                <button class="btn btn-default">N</button>
                <button class="btn btn-default">O</button>
                <button class="btn btn-default">P</button>
                <button class="btn btn-default">Q</button>
                <button class="btn btn-default">R</button>
                <button class="btn btn-default">S</button>
                <button class="btn btn-default">T</button>
                <button class="btn btn-default">U</button>
                <button class="btn btn-default">V</button>
                <button class="btn btn-default">W</button>
                <button class="btn btn-default">X</button>
                <button class="btn btn-default">Y</button>
                <button class="btn btn-default">Z</button>
            </div>
        </div>
    </div>
</div>

<!--Search starts here-->
<div class="row">
    <div class="col-xs-12 col-sm-10 col-md-6 col-md-offset-3 col-sm-offset-1">
        <form action="search" method="GET">    
            <div class="input-group">
                <input type="text" class="form-control" name="searchedEntry" placeholder="Search terms" id="txtSearch" value="${searchedEntry}" />
                <input type="text" name="action" value="searchTerm" hidden/>
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

<c:if test="${user == null}">
    <!--Search filter starts here-->
    <div class="search-filter">
        <div class="row">
            <div class="col-xs-8 col-md-4 col-md-offset-4 col-xs-offset-2">
                <!-- Small button group -->
                <button id="dropdown_search" class="dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Filter By School <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="#">Business, Accounting and Management</a></li>
                    <li><a href="#">Construction and Trades</a></li>
                    <li><a href="#">Culinary, Hospitality and Travel</a></li>
                    <li><a href="#">Energy, Oil and Gas</a></li>
                    <li><a href="#">Engineering Technologies</a></li>
                    <li><a href="#">Health and Medical</a></li>
                    <li><a href="#">Information Technology</a></li>
                    <li><a href="#">Manufacturing</a></li>
                    <li><a href="#">Media and Communications</a></li>
                    <li><a href="#">Transportation</a></li>
                </ul>
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
                    <!-- Small button group -->
                    <button id="dropdown_search" class="dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Filter By Course <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">Corse One</a></li>
                        <li><a href="#">Course Two</a></li>
                        <li><a href="#">Course Three</a></li>

                    </ul>
                </div> <!-- Filter by instructor ends here-->    


                <!-- Filter by course starts here -->
                <div class="col-xs-12 col-sm-6 col-md-6">
                    <!-- Small button group -->
                    <button id="dropdown_search" class="dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Filter By Instructor <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">Instructor One</a></li>
                        <li><a href="#">Instructor Two</a></li>
                        <li><a href="#">Instructor Three</a></li>
                </div><!--Filter by course ends here-->
            </div>        
        </div>    
</div> <!--Search filter ends here-->
</c:if>
<br><br>
<div class="container list-terms">
    <div>
        <h4>Term List</h4>
        <hr class="line">
    </div>
    <!-- Term definitions starts here -->
    <c:if test="${noSuchEntry != true}">
        <c:forEach var="term" items="${termlist}"> 
            <c:forEach var="definition" items="${term.definitionList.definitionList}"> 
                <div class="row">
                    <!--Left side of the search result starts here: Term title, instructor, citation and date created-->
                    <div class="col-xs-12 col-md-3">
                        <h4>${term.term}</h4>
                        <p>Instructor: ${definition.writtenBy.name} </p>
                        <p>Citation: ${definition.citation}</p>                     
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
                                ${definition.content} <a class="readMore hide" href="#"> Read More </a>
                                <span class="readMoreContent">
                                    <div><h5>Citation</h5></div>
                                    <div>${definition.citation}</div>
                                    <div><h5>Dictionary Definition</h5></div>
                                    <div>${definition.dictionaryContent}</div>
                                    <div><h5>Citation</h5></div>
                                    <div>${definition.dictionaryCitation}</div> 
                                    <div><a class="readLess hide" href="#">Read Less</a></div>                                    
                                </span>
                            </div>
                        </div><!--Right side of the search ends here-->  
                    </div><!-- Term definitions end here -->
                    <hr class="line">
                </c:forEach>
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