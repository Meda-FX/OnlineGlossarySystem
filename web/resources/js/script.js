$(document).ready(function(){
  $("#glossary").on("show.bs.collapse", function(){
    $(".glossary-collapse").html('Manage Terms <span class="glyphicon glyphicon-chevron-up"></span>');
  });
  $("#glossary").on("hide.bs.collapse", function(){
    $(".glossary-collapse").html('Manage Terms <span class="glyphicon glyphicon-chevron-down"></span>');
  });
});

