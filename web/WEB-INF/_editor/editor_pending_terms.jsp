<%@ include file="../includes/header.jsp" %>   

<div class="container list-terms"> 
    
<div id="crud">
   <h1>Edit Terms</h1>
  <div class="form-group">
    <label for="term">Term</label>
    <input type="text" class="form-control" id="term" name="term" placeholder="Term" readonly="">
  </div>
  <div class="form-group">
    <label for="definition">Definition</label>
    <textarea class="form-control" rows="5" name="definition" id="definition"></textarea>
  </div>
   <div class="form-group">
    <label for="sitation">Citation</label>
    <input type="text" class="form-control" id="citation" name="citation" placeholder="Citation">
  </div>
        
   <div class="form-group">
    <label for="defDefinition">Dictionary Definition</label>
    <textarea class="form-control" rows="5" name="defDefinition" id="defDefinition"></textarea>
  </div>
        
  <div class="form-group">
    <label for="dicCitation">Dictionary Citation</label>
    <input type="text" class="form-control" id="citation" name="dicCitation" placeholder="Dectionary Citation">
  </div>
   
    <form action="editor" method="post">
        <button type="button" class="btn">Save Term</button>
        <input type="text" hidden name="action" value="SavePending">
    </form>
    <form action="editor" method="post">
          <button type="button" class="btn">Publish Term</button>
          <input type="text" hidden name="action" value="SavePublish">
    </form>
    <button type="button" class="btn hideFormTerm">Hide Form</button>
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
    
    <!--table begins here-->
    <table class="table table-hover"> 
        <thead>
            <tr>                
                <th scope="col">Term</th>
                <th scope="col">Definition</th>
                <th scope="col">Date</th>
                <th scope="col">Owner</th>
                <th scope="col">Course</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>JAVA</td>
                <td>
                    It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.
                </td>     
                <td>JAN 25-2017</td>
                <td>Maryam Mossavi</td>
                <td>HJRA-556</td>
                <td>
                    <span id="icons" class="glyphicon glyphicon-trash"></span>
                </td>
                <td>                    
                    <span id="icons" class="glyphicon  glyphicon-pencil addTerms"></span>                      
                </td>
            </tr>
            <tr>
                <td>Search Trees</td>
                <td>
                    It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.
                </td>
                <td>FEB 25-2017</td>
                <td>Erron Bob</td>
                <td>CMPA-256</td>
                <td>
                    <span id="icons" class="glyphicon glyphicon-trash"></span>
                </td>
                <td>
                    <span id="icons" class="glyphicon  glyphicon-pencil"></span>        
                </td>
            </tr>
            <tr>
                <td>Sockets</td>
                <td>
                    It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.
                </td>
                <td>FEB 25-2017</td>
                <td>Javen Feng</td>
                <td>CCRT-526</td>
                <td>
                    <span id="icons" class="glyphicon glyphicon-trash"></span>
                </td>
                <td>
                    <span id="icons" class="glyphicon  glyphicon-pencil"></span>        
                </td>
            </tr>

            <tr>
                <td>Sorting</td>
                <td>
                    It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.
                </td>
                <td>FEB 25-2017</td>
                <td>Oli Kyle</td>
                <td>UIPA-897</td>
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
