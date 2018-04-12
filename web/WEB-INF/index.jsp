<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>      

<div class="customContainerLandingPage">
    <!--Alphabet search starts here-->
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-10 col-md-offset-1">
            <div class="alphabets">
                <div class="btn-group btn-group-sm">
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
