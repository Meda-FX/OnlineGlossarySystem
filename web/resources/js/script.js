$(document).ready(function(){ 
 
  
    
    $(".editform").submit(function(event) {
        $.get($(this).attr("action"), $(this).serialize(), function(responseJson) {
            $("#term").val(responseJson.term);
            $("#termId").val(responseJson.definitionID);
            $("#definition").val(responseJson.content);
            $("#citation").val(responseJson.citation);
            $("#defDefinition").val(responseJson.dictionaryContent);
            $("#dicCitation").val(responseJson.dictionaryCitation);           
        });
        event.preventDefault();
    });
    
   $("#crud").hide();
 
 $(".hideFormTerm").click(function(){
        $("#crud").hide(1000);
    });
 
 $(".addTerms").click(function(){
        $("#crud").show(1000);
    });
    

 });
