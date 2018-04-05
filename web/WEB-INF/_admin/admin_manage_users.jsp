<%@ include file="../includes/header.jsp" %>   

<div class="container list-terms">
    
    <!-- CRUD -->
    <br>
    <div class="panel-group">
        <div class="panel">
            <div id="toogleText" class="panel-heading">
                <h4  class="panel-title">
                    <a data-toggle="collapse" href="#collapse1"><h3>Manage Users</h3></a>
                </h4>
            </div>
            <div id="collapse1" class="panel-collapse collapse">
                <ul class="list-group">


                    <div class="form-group">
                        <label for="usr">First Name:</label>
                        <input type="text" class="form-control" id="usr">
                    </div>
                    <div class="form-group">
                        <label for="pwd">Course Code:</label>
                        <input type="text" class="form-control" id="pwd">
                    </div>
                    <div class="form-group">
                        <label for="pwd">Department:</label>
                        <input type="text" class="form-control" id="pwd">
                    </div>
                    <div class="form-group">
                        <label for="pwd">Email:</label>
                        <input type="text" class="form-control" id="pwd">
                    </div>
                    <div class="form-group">
                        <label for="pwd">Course Name:</label>
                        <input type="text" class="form-control" id="pwd">
                    </div>

                    <button type="button" class="btn">SAVE</button>
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
    <br>
    <!--table begins here-->
    <table class="table table-hover">
        <tr>
            <th>First Name</th>
            <th>Course Code</th>
            <th>Department</th>
            <th>Email</th>
            <th>Course Name</th>
            <th></th>
            <th></th>
        </tr>
        <tr>
            <td>Emerald</td>
            <td>N2V 2I8</td>
            <td>S4B 0V4</td>
            <td>orci.lacus@Nunc.co.uk</td>
            <td>Web</td>
            <td>
                <span id="icons" class="glyphicon glyphicon-trash"></span>
            </td>
            <td>
                <span id="icons" class="glyphicon  glyphicon-pencil"></span>        
            </td>
        </tr>
        <tr>
            <td>Colette</td>
            <td>Z6E 9T0</td>
            <td>C2D 2O6</td>
            <td>leo.Vivamus@velconvallisin.com</td>
            <td>Database</td>
            <td>
                <span id="icons" class="glyphicon glyphicon-trash"></span>
            </td>
            <td>
                <span id="icons" class="glyphicon  glyphicon-pencil"></span>        
            </td>
        </tr>
        <tr>
            <td>Lacy</td>
            <td>F9L 1Z7</td>
            <td>S5G 2A3</td>
            <td>et.magna.Praesent@ridiculusmusProin.edu</td>
            <td>Computer Systems</td>
            <td>
                <span id="icons" class="glyphicon glyphicon-trash"></span>
            </td>
            <td>
                <span id="icons" class="glyphicon  glyphicon-pencil"></span>        
            </td>
        </tr>
        <tr>
            <td>Kaitlin</td>
            <td>B2D 6P9</td>
            <td>I8O 3G4</td>
            <td>a.mi.fringilla@augue.com</td>
            <td>Accounting</td>
            <td>
                <span id="icons" class="glyphicon glyphicon-trash"></span>
            </td>
            <td>
                <span id="icons" class="glyphicon  glyphicon-pencil"></span>        
            </td>
        </tr>
        <tr>
            <td>Ifeoma</td>
            <td>X9Z 5D0</td>
            <td>G9A 3D1</td>
            <td>facilisis.magna@urna.ca</td>
            <td>Tourism</td>
            <td>
                <span id="icons" class="glyphicon glyphicon-trash"></span>
            </td>
            <td>
                <span id="icons" class="glyphicon  glyphicon-pencil"></span>        
            </td>
        </tr>
        <tr>
            <td>Hannah</td>
            <td>R6Q 7U5</td>
            <td>T0M 8F5</td>
            <td>turpis.non@luctus.ca</td>
            <td>Object Oriented Prog</td>
            <td>
                <span id="icons" class="glyphicon glyphicon-trash"></span>
            </td>
            <td>
                <span id="icons" class="glyphicon  glyphicon-pencil"></span>        
            </td>
        </tr>
        <tr>
            <td>Robin</td>
            <td>M0D 2I4</td>
            <td>W8D 1D1</td>
            <td>Donec@interdum.net</td>
            <td>Interface Design</td>
            <td>
                <span id="icons" class="glyphicon glyphicon-trash"></span>
            </td>
            <td>
                <span id="icons" class="glyphicon  glyphicon-pencil"></span>        
            </td>
        </tr>
        <tr>
            <td>Ora</td>
            <td>Z5E 3N3</td>
            <td>K0L 3J2</td>
            <td>tincidunt@ametdiam.com</td>
            <td>Marketing</td>
            <td>
                <span id="icons" class="glyphicon glyphicon-trash"></span>
            </td>
            <td>
                <span id="icons" class="glyphicon  glyphicon-pencil"></span>        
            </td>
        </tr>
        <tr>
            <td>Irma</td>
            <td>Q1Q 0N8</td>
            <td>C3T 3D9</td>
            <td>ipsum@cubilia.org</td>
            <td>Garrett</td>
            <td>
                <span id="icons" class="glyphicon glyphicon-trash"></span>
            </td>
            <td>
                <span id="icons" class="glyphicon  glyphicon-pencil"></span>        
            </td>
        </tr>
        <tr>
            <td>Eliana</td>
            <td>J7Z 2R7</td>
            <td>K3S 9C7</td>
            <td>Aliquam@velitinaliquet.edu</td>
            <td>Evan</td>
            <td>
                <span id="icons" class="glyphicon glyphicon-trash"></span>
            </td>
            <td>
                <span id="icons" class="glyphicon  glyphicon-pencil"></span>        
            </td>
        </tr>
        <tr>
            <td>Mechelle</td>
            <td>U1D 0J5</td>
            <td>U4X 7I6</td>
            <td>et.lacinia.vitae@auctorveliteget.co.uk</td>
            <td>Web</td>
            <td>
                <span id="icons" class="glyphicon glyphicon-trash"></span>
            </td>
            <td>
                <span id="icons" class="glyphicon  glyphicon-pencil"></span>        
            </td>
        </tr>
        <tr>
            <td>Beatrice</td>
            <td>O7L 3T5</td>
            <td>R9E 1G8</td>
            <td>non.massa@enimconsequat.net</td>
            <td>Database</td>
            <td>
                <span id="icons" class="glyphicon glyphicon-trash"></span>
            </td>
            <td>
                <span id="icons" class="glyphicon  glyphicon-pencil"></span>        
            </td>
        </tr>
    </table> <!--Table ends here-->

</div> <!-- list items  -->

<%@ include file="../includes/footer.jsp" %>