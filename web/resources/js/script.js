$(document).ready(function(){

    $(".editForm").submit(function(event) {
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
        
    
     $(".editUsers").submit(function(event) {
        $.get($(this).attr("action"), $(this).serialize(), function(responseJson) {
            $("#userId").val(responseJson.id);
            $("#userName").val(responseJson.name);
            $("#email").val(responseJson.email);
            if (responseJson.isActivated) {
                $("#active").prop("checked", true);
            } else {
                $("#inactive").prop("checked", true);
            }
            responseJson.privileges.privileges.forEach(function(item){
               $("#privList").children().eq(item.privilegeID-1).prop("checked", true);
            });
        });
        
        event.preventDefault();
    });
    
    $(".editInstructorForm").submit(function(event) {
        $.get($(this).attr("action"), $(this).serialize(), function(responseJson) {
            $("#term").val(responseJson.term);
            $("#termId").val(responseJson.definitionID);
            $("#definition").val(responseJson.content);
            $("#citation").val(responseJson.citation);
            $("#defDefinition").val(responseJson.dictionaryContent);
            $("#dicCitation").val(responseJson.dictionaryCitation);           
            $("#courseCode").val(responseJson.course.courseCode);           
        });
        event.preventDefault();
    });
    

    //CRUD hide and show script
    $("#crud").hide(); 
    $(".hideFormTerm").click(function(){
           $("#crud").hide(1000);
       }); 
    $(".addTerms").click(function(){
           $("#crud").show(1000);
       });
  
    //Read More and Read Less script
     $('.readMoreContent').addClass('hide');
     $('.readMore, .readLess').removeClass('hide');

     $('.readMore').on('click', function(e) {
       $(this).next('.readMoreContent').removeClass('hide');
       $(this).addClass('hide');
       e.preventDefault();
     });

    $('.readLess').on('click', function(e) {
      var p = $(this).parents('.readMoreContent');
      p.addClass('hide');
      p.prev('.readMore').removeClass('hide'); // Hide only the preceding "Read More"
      e.preventDefault();
    });
   
   //Navigation active page locator 
   var path = window.location.href;
   $('.navbar ul a').each(function(){
       if (this.href === path) {
           $(this).addClass('active');
       }
   });
        
 });
 
