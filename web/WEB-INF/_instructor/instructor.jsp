<%@ include file="../includes/instructor-header.jsp" %>   

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
   
    <table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Term</th>
      <th scope="col">Definition</th>
      <th scope="col">Date</th>
      <th scope="col">Owner</th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>JAVA</td>
      <td>
        It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.
      </td>     
      <td>JAN 25-2017</td>
      <td>Maryam Mossavi</td>
      
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Search Trees</td>
      <td>
           It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.
      </td>
      <td>FEB 25-2017</td>
      <td>Maryam Mossavi</td>
  
    </tr>
     <tr>
      <th scope="row">3</th>
      <td>Sockets</td>
      <td>
           It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.
      </td>
      <td>FEB 25-2017</td>
      <td>Maryam Mossavi</td>
      
    </tr>

     <tr>
      <th scope="row">4</th>
      <td>Sorting</td>
      <td>
           It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.
      </td>
      <td>FEB 25-2017</td>
      <td>Maryam Mossavi</td>
      
    </tr>

     <tr>
      <th scope="row">5</th>
      <td>Java Bean</td>
      <td>
           It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.
      </td>
      <td>FEB 25-2017</td>
      <td>Maryam Mossavi</td>
       
    </tr>

    <tr>
      <th scope="row">6</th>
      <td>Testing</td>
      <td>
           It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.
      </td>
      <td>FEB 25-2017</td>
      <td>Maryam Mossavi</td>
      
    </tr>

    <tr>
      <th scope="row">7</th>
      <td>Balance</td>
      <td>
           It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.
      </td>
      <td>FEB 25-2017</td>
      <td>Maryam Mossavi</td>
       
    </tr>
  </tbody>
</table>

    
</div> <!-- list items  -->

<%@ include file="../includes/footer.jsp" %>