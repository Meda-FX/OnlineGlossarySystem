$(document).ready(function(){ 
 
  $("#crud").hide();
 
 $("#hideFormTerm").click(function(){
        $("#crud").hide(1000);
    });
 
 $("#addTerms").click(function(){
        $("#crud").show(1000);
    });

 });
