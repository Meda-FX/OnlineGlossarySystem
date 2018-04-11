<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>      

<div class="customContainerLandingPage">
<!--Alphabet search starts here-->
<div class="row">
    <div class="col-xs-12 col-sm-12 col-md-10 col-md-offset-1">
        <div class="alphabets">
            <div class="btn-group btn-group-sm">
                <button class="btn btn-default"><a href="search?action=alphSearch&letter=a">A</a></button>
                <button class="btn btn-default"><a href="search?action=alphSearch&letter=b">B</a></button>
                <button class="btn btn-default"><a href="search?action=alphSearch&letter=c">C</a></button>
                <button class="btn btn-default"><a href="search?action=alphSearch&letter=d">D</a></button>
                <button class="btn btn-default"><a href="search?action=alphSearch&letter=e">E</a></button>
                <button class="btn btn-default"><a href="search?action=alphSearch&letter=f">F</a></button>
                <button class="btn btn-default"><a href="search?action=alphSearch&letter=g">G</a></button>
                <button class="btn btn-default"><a href="search?action=alphSearch&letter=h">H</a></button>
                <button class="btn btn-default"><a href="search?action=alphSearch&letter=i">I</a></button>
                <button class="btn btn-default"><a href="search?action=alphSearch&letter=j">J</a></button>
                <button class="btn btn-default"><a href="search?action=alphSearch&letter=k">K</a></button>
                <button class="btn btn-default"><a href="search?action=alphSearch&letter=l">L</a></button>
                <button class="btn btn-default"><a href="search?action=alphSearch&letter=m">M</a></button>
                <button class="btn btn-default"><a href="search?action=alphSearch&letter=n">N</a></button>
                <button class="btn btn-default"><a href="search?action=alphSearch&letter=o">O</a></button>
                <button class="btn btn-default"><a href="search?action=alphSearch&letter=p">P</a></button>
                <button class="btn btn-default"><a href="search?action=alphSearch&letter=q">Q</a></button>
                <button class="btn btn-default"><a href="search?action=alphSearch&letter=r">R</a></button>
                <button class="btn btn-default"><a href="search?action=alphSearch&letter=s">S</a></button>
                <button class="btn btn-default"><a href="search?action=alphSearch&letter=t">T</a></button>
                <button class="btn btn-default"><a href="search?action=alphSearch&letter=u">U</a></button>
                <button class="btn btn-default"><a href="search?action=alphSearch&letter=v">V</a></button>
                <button class="btn btn-default"><a href="search?action=alphSearch&letter=w">W</a></button>
                <button class="btn btn-default"><a href="search?action=alphSearch&letter=x">X</a></button>
                <button class="btn btn-default"><a href="search?action=alphSearch&letter=y">Y</a></button>
                <button class="btn btn-default"><a href="search?action=alphSearch&letter=z">Z</a></button>

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
                    <a href="search?action=advancedSearch"> Advanced Search </a>
                </p>
            </div>
        </div> 
    </div><!--Search filter ends here-->
</div>
<%@ include file="includes/footer.jsp" %>
