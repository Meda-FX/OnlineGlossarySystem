<%@ include file="../includes/admin-header.jsp" %>   

<div class="container list-terms">

    <!-- CRUD -->
    <br>
    <div id="panel-group" class="panel-group">
        <div id="panel" class="panel">
            <div class="panel-heading">
                <h4  class="panel-title">
                    <a data-toggle="collapse" href="#collapse1"><h3>Manage Terms</h3></a>
                </h4>
            </div>
            <div id="collapse1" class="panel-collapse collapse">
                <ul class="list-group">

                    <div class="form-group">
                        <label for="usr">Term:</label>
                        <input type="text" class="form-control" id="usr">
                    </div>

                    <div class="form-group">
                        <label for="comment">Definition:</label>
                        <textarea class="form-control" rows="5" id="comment"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="pwd">Citation:</label>
                        <input type="text" class="form-control" id="pwd">
                    </div>

                    <button type="button" class="btn">SAVE TERM</button>
                    <button type="button" class="btn">PUBLISH TERM</button>
                </ul>

            </div>
        </div>
    </div>
    <!-- CRUD ends -->
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

</div> <!-- list items  -->

<%@ include file="../includes/footer.jsp" %>