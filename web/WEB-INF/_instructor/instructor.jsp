<%@ include file="../includes/header.jsp" %>   

<div class="container list-terms"> 
    
<div id="crud">
    <form action="" method="post">
    <h1>Add Terms</h1>    
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
        
   <div class="form-group selectpicker">
        <label for="course-code">Course Code:</label>
        <select id="course-code" name="courseCode">
            <option value="-1" >Please select course</option>
            <option value="2" >CMPP-869</option>
            <option value="3" >QTTI-7769</option>
            <option value="4" >QTTI-221</option>
        </select>
    </div>   
       
    <div class="message">  
        ${message}      
    </div>  
    
  <!--<button type="button" class="btn">Save Term</button>-->
    <!--<button type="button" class="btn">Submit Term</button>-->
    <!--<button type="button" class="btn hideFormTerm">Hide Form</button>-->
    
    
    <input type="submit" value="Save Term">
    <input type="hidden" name="action" value="save">
    
    <input type="hidden" name="action" value="submit">
    <input type="submit" value="Submit Term">
    
    <input class="hideFormTerm" type="button" value="Hide Form">
    
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
        <div class="addTerms" class="col-md-12">
             <button type="button" class="btn navbar-right">Add Term</button>
        </div>
    </div>
    
    <!--table begins here-->
    <table class="table table-hover"> 
        <thead>
            <tr>                
                <th scope="col">Term</th>
                <th scope="col">Definition</th>
                <th scope="col">Course</th>
                <th scope="col">Date</th>
                <th scope="col">Status</th>
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
                <td>PROJ-354</td>
                <td>JAN 25-2017</td>
                <td>Published</td>
                <td>
                    <span id="icons" class="glyphicon glyphicon-trash"></span>
                </td>
                <td>
                    <span id="icons" class="glyphicon  glyphicon-pencil"></span>        
                </td>
            </tr>
            <tr>
                <td>Search Trees</td>
                <td>
                    It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.
                </td>
                <td>CPMH-211</td>
                <td>FEB 25-2017</td>
                <td>Pending</td>
                <td>
                    <span id="icons" class="glyphicon glyphicon-trash"></span>
                </td>
                <td>
                    <span id="icons" class="glyphicon  glyphicon-pencil addTerms"></span>        
                </td>
            </tr>            
        </tbody>
    </table> <!--Table ends here-->
    </div>
</div> <!-- list items  -->

<%@ include file="../includes/footer.jsp" %>