<%@ include file="../includes/header.jsp" %>   

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
</div> <!-- main filter container -->
<!--Search filter ends here-->

<div class="container list-terms">
    <div>
    <h4>Term List</h4>
    <hr class="line">
    </div>
    
    <!-- Term definitions starts here -->
    <c:forEach var="definition" items="${definitions}"> 
        <div class="row">
            <!--Left side of the search result starts here: Term title, instructor, citation and date created-->
            <div class="col-xs-12 col-md-3">
                <h4>${definition.glossary_entry}</h4>
                <p>Instructor: $definition.made_by} </p>
                <p>Citation: ${definition.citation}</p>
                <p>Date: ${definition.date_created}</p>
            </div><!--Left side of the search ends here-->

            <!--Right side of the search result starts here: term definition-->
            <div class="col-xs-12 col-md-9">
                <h4>Term Definition</h4>
                <p>${definition.definition}</p>
                <span><a href="#">Read</a></span>
                <hr>
            </div><!--Right side of the search ends here-->      
        </div><!-- Term definitions end here -->
    </c:forEach>

    <div class="row">
        <div class="col-xs-12 col-md-3">
            <h4>JAVA</h4>
            <p>Instructor: Maryam Mossavi <br>
                Citation: Citation... <br>
                Date: January 25/2013</p>
        </div>

        <div class="col-xs-12 col-md-9">
            <h4>Term Definition</h4>
            <p>Citations are included in research projects anytime you use another individual?s work in your own assignment. When including a quote, paraphrased information, images, or any other piece of information from another?s work, you need to show where you found it by including a citation. This APA format guide explains how to make citations in APA style.</p>
            <span><a href="#">Read</a></span>            
        </div>       
    </div> <!-- Term definitions end here -->
    <hr class="line">
</div> <!-- list items  -->

<%@ include file="../includes/footer.jsp" %>