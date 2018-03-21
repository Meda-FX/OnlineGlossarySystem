<%@ include file="../includes/header.jsp" %>   

<div class="container list-terms"> 
    
<div id="crud">
    <h1>Add Terms</h1>
    <form>
  <div class="form-group">
    <label for="term">Term</label>
    <input type="text" class="form-control" id="term" name="term" placeholder="Term">
  </div>
  <div class="form-group">
    <label for="definition">Definition</label>
    <input type="text" rows="5" class="form-control" id="definition" name="definition" placeholder="Definition">
  </div>
   <div class="form-group">
    <label for="sitation">Citation</label>
    <input type="text" class="form-control" id="citation" name="citation" placeholder="Citation">
  </div>
        
        <div class="form-group">
    <label for="defDefinition">Dictionary Definition</label>
    <input type="text" class="form-control" id="defDefinition" name="defDefinition" placeholder="Dictionary Definition">
  </div>
        
        <div class="form-group">
    <label for="dicCitation">Dictionary Citation</label>
    <input type="text" class="form-control" id="citation" name="dicCitation" placeholder="Dectionary Citation">
  </div>
 
  <button type="button" class="btn">SAVE TERM</button>
    <button type="button" class="btn">PUBLISH TERM</button>
    <button id="hideFormTerm" type="button" class="btn">Hide Form</button>
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
        <div id="addTerms" class="col-md-12">
             <button type="button" class="btn navbar-right">Add Term</button>
        </div>
    </div>
    
    <!--table begins here-->
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
                <td>
                    <span id="icons" class="glyphicon glyphicon-trash"></span>
                </td>
                <td>
                    <span id="icons" class="glyphicon  glyphicon-pencil"></span>        
                </td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td>Search Trees</td>
                <td>
                    It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.
                </td>
                <td>FEB 25-2017</td>
                <td>Erron Bob</td>
                <td>
                    <span id="icons" class="glyphicon glyphicon-trash"></span>
                </td>
                <td>
                    <span id="icons" class="glyphicon  glyphicon-pencil"></span>        
                </td>
            </tr>
            <tr>
                <th scope="row">3</th>
                <td>Sockets</td>
                <td>
                    It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.
                </td>
                <td>FEB 25-2017</td>
                <td>Javen Feng</td>
                <td>
                    <span id="icons" class="glyphicon glyphicon-trash"></span>
                </td>
                <td>
                    <span id="icons" class="glyphicon  glyphicon-pencil"></span>        
                </td>
            </tr>

            <tr>
                <th scope="row">4</th>
                <td>Sorting</td>
                <td>
                    It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.
                </td>
                <td>FEB 25-2017</td>
                <td>Oli Kyle</td>
                <td>
                    <span id="icons" class="glyphicon glyphicon-trash"></span>
                </td>
                <td>
                    <span id="icons" class="glyphicon  glyphicon-pencil"></span>        
                </td>
            </tr>

            <tr>
                <th scope="row">5</th>
                <td>Java Bean</td>
                <td>
                    It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.
                </td>
                <td>FEB 25-2017</td>
                <td>Kyle Oli</td>
                <td>
                    <span id="icons" class="glyphicon glyphicon-trash"></span>
                </td>
                <td>
                    <span id="icons" class="glyphicon  glyphicon-pencil"></span>        
                </td>
            </tr>

            <tr>
                <th scope="row">6</th>
                <td>Testing</td>
                <td>
                    It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.
                </td>
                <td>FEB 25-2017</td>
                <td>Blanco Nei</td>
                <td>
                    <span id="icons" class="glyphicon glyphicon-trash"></span>
                </td>
                <td>
                    <span id="icons" class="glyphicon  glyphicon-pencil"></span>        
                </td>
            </tr>

            <tr>
                <th scope="row">7</th>
                <td>Balance</td>
                <td>
                    It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.
                </td>
                <td>FEB 25-2017</td>
                <td>Bob Dog</td>
                <td>
                    <span id="icons" class="glyphicon glyphicon-trash"></span>
                </td>
                <td>
                    <span id="icons" class="glyphicon  glyphicon-pencil"></span>        
                </td>
            </tr>
        </tbody>
    </table> <!--Table ends here-->
    </div>
</div> <!-- list items  -->

<%@ include file="../includes/footer.jsp" %>