<%@ include file="includes/home-header.jsp" %>      

<div class="customContainerLandingPage">
<!--Alphabet search starts here-->
<div class="row">
    <div class="col-xs-12 col-sm-12 col-md-10 col-md-offset-1">
        <div class="alphabets">
            <div class="btn-group btn-group-sm">
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
</div> <!--Alphabet search ends here-->

<!--Search filter starts here-->
<div class="row glossarySearchHeaderStyle">
    <div class="col-sm-8 col-md-6 col-md-offset-3 col-sm-offset-2">
        <h3>SEARCH TERMS</h3>
        <form action="search" method="GET">    
            <div class="input-group">
                <input type="text" class="form-control" name="searchedEntry" placeholder="Search" id="txtSearch" value="${searchedEntry}"/>
                <input type="text" name="action" value="searchTerm" hidden/>
                <div class="input-group-btn">
                    <button class="btn" type="submit">
                        <span class="glyphicon glyphicon-search"></span>
                    </button>
                </div>
            </div>
        </form>
        <div>
            <p>
                <a href="#"> Advanced Search </a>
            </p>
        </div>

</div> 
</div><!--Search filter ends here-->
</div>
<%@ include file="includes/footer.jsp" %>
