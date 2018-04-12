$(document).ready(function () {

    //CRUD hide and show script
    $("#crud").hide();
    $("#crud").removeClass("hide"); //This is used to remove the FOOC, same in Manage Course
    $(".hideFormTerm").click(function () {
        $("#crud").hide(1000);
    });
    $(".addTerms").click(function () {
        $("#crud").show(1000);
    });
    
    //Manage Course inside users account
    $("#userCoursesManager").hide();
    $("#userCoursesManager").removeClass("hide");
    $(".closeManageUsers").hide();
    $(".closeManageUsers").removeClass("hide");
    $(".closeManageUsers").click(function () {
        $("#userCoursesManager").hide(1000);
        $(".manageUsers").show(1000);
        $(".closeManageUsers").hide(1000);
    });
    $(".manageUsers").click(function () {
        $("#userCoursesManager").show(500);
        $(".manageUsers").hide(500);
        $(".closeManageUsers").show(500);
    });

    $("#end").prop("max", moment().format("YYYY-MM-DD"));
    $("#start").prop("max", moment().format("YYYY-MM-DD"));

    $("#start").change(function () {
        $("#end").prop("min", $(this).val());
    });

    $("#end").change(function () {
        $("#start").prop("max", $(this).val());
    });

    $(".editForm").submit(function (event) {
        $.get($(this).attr("action"), $(this).serialize(), function (responseJson) {
            $("#term").val(responseJson.term);
            $("#termId").val(responseJson.definitionID);
            $("#definition").val(responseJson.content);
            $("#citation").val(responseJson.citation);
            $("#defDefinition").val(responseJson.dictionaryContent);
            $("#dicCitation").val(responseJson.dictionaryCitation);
        });
        event.preventDefault();
        document.body.scrollTop = 0;
        document.documentElement.scrollTop = 0;
    });


    $(".editUsers").submit(function (event) {
        $.get($(this).attr("action"), $(this).serialize(), function (responseJson) {
            $("#userId").val(responseJson.id);
            $("#userId").prop("readonly", true);
            $("#userName").val(responseJson.name);
            $("#email").val(responseJson.email);
            $("#active").attr("disabled", false);
            $("#inactive").attr("disabled", false);
            if (responseJson.isActivated) {
                $("#active").prop("checked", true);
            } else {
                $("#inactive").prop("checked", true);
            }
            $("#privList").children().each(function () {
                $(this).prop("checked", false);
            });
            responseJson.privileges.privileges.forEach(function (item) {
                $("#privList").children().eq(item.privilegeID - 1).prop("checked", true);
            });
        });
        event.preventDefault();
        document.body.scrollTop = 0;
        document.documentElement.scrollTop = 0;
    });
    
    $(".editCourses").submit(function (event) {
        $.get($(this).attr("action"), $(this).serialize(), function (responseJson) {
            $("#courseId").val(responseJson.courseCode);
            $("#courseId").prop("readonly", true);
            $("#courseName").val(responseJson.courseName);
        });
        event.preventDefault();
        document.body.scrollTop = 0;
        document.documentElement.scrollTop = 0;
    });

    $(".editInstructorForm").submit(function (event) {
        $.get($(this).attr("action"), $(this).serialize(), function (responseJson) {
            $("#term").val(responseJson.term);
            $("#termId").val(responseJson.definitionID);
            $("#definition").val(responseJson.content);
            $("#citation").val(responseJson.citation);
            $("#defDefinition").val(responseJson.dictionaryContent);
            $("#dicCitation").val(responseJson.dictionaryCitation);
            $("#courseCode").val(responseJson.course.courseCode);

            $("#dicCitation").val(responseJson.dictionaryCitation);   
            var courseToSet = responseJson.course.courseCode;
            
            $("#courseCode option[value="+courseToSet+"]").attr('selected', 'selected');
            
 //           var courselist = document.getElementById("#courseCode");

    //        $("#courseCode").val(responseJson.course.courseCode);           
        });
        event.preventDefault();
        document.body.scrollTop = 0;
        document.documentElement.scrollTop = 0;
    });

    $(".newUser").click(function () {
        $("#userId").val("");
        $("#userId").prop("readonly", false);
        $("#userName").val("");
        $("#email").val("");
        $("#active").prop("checked", false);
        $("#inactive").prop("checked", true);
        $("#active").attr("disabled", true);
        $("#inactive").attr("disabled", true);
        $("#privList").children().each(function () {
            $(this).prop("checked", false);
        });
    });
    
    $(".newCourse").click(function () {
        $("#courseId").prop("readonly", false);
        $("#courseId").val("");
        $("#courseName").val("");
        
    });

    $(".newTerm").click(function () {
        $("#term").val("");
        $("#termId").val("");
        $("#definition").val("");
        $("#citation").val("");
        $("#defDefinition").val("");
        $("#dicCitation").val("");
        $("#courseCode").val("");
    });

    //Read More and Read Less script
    $('.readMoreContent').addClass('hide');
    $('.readMore, .readLess').removeClass('hide');

    $('.readMore').on('click', function (e) {
        $(this).next('.readMoreContent').removeClass('hide');
        $(this).addClass('hide');
        e.preventDefault();
    });

    $('.readLess').on('click', function (e) {
        var p = $(this).parents('.readMoreContent');
        p.addClass('hide');
        p.prev('.readMore').removeClass('hide'); // Hide only the preceding "Read More"
        e.preventDefault();
    });

    //Navigation active page locator 
    var path = window.location.href;
    $('.navbar ul a').each(function () {
        if (this.href === path) {
            $(this).addClass('active');
        }
    });

    $(".reportForm").submit(function (event) {
        $.get($(this).attr("action"), $(this).serialize(), function (responseJson) {

            var data = responseJson.map(function (item) {
                return {x: moment(new Date(item["date"])).format("YYYY-MM-DD"), y: item["count"]};
            });
            var type;

            var startDate = moment($("#start").val());
            var endDate = moment($("#end").val());
            var daysMagnitude = endDate.diff(startDate, 'days');

            if ($("#reportType").val() === "1")
                type = 'Registrations';
            else if ($("#reportType").val() === "2")
                type = 'Logins';

            var title = "Daily " + type + " between " + startDate.format("YYYY-MM-DD") + " and " + endDate.format("YYYY-MM-DD");
            var timescale;
            if (daysMagnitude < 14) {
                timescale = 'day';
            } else if (daysMagnitude < 28 * 4) {
                timescale = 'week';
            } else if (daysMagnitude < 365) {
                timescale = 'month';
            } else if (daysMagnitude < 365 * 4) {
                timescale = 'quarter';
            } else {
                timescale = 'year';
            }

            var chart = new Chart($('#canvas'), {
                type: 'line',
                data: {
                    datasets: [{
                            data: data,
                            borderColor: '#005eb8',
                            fill: false
                        }]
                },
                options: {
                    legend: {
                        display: false
                    },
                    responsive: true,
                    title: {
                        display: true,
                        text: title,
                        fontColor: '#da291c',
                        fontSize: 24
                    },
                    scales: {
                        xAxes: [{
                                gridLines: {
                                    display: false,
                                    drawBorder: false
                                },
                                type: "time",
                                time: {
                                    unit: timescale,
                                    distribution: 'linear'
                                },
                                ticks: {
                                    source: 'auto'
                                }
                            }],
                        yAxes: [{
                                gridLines: {
                                    drawBorder: false
                                },
                                type: "linear",
                                bounds: 'data',
                                ticks: {
                                    beginAtZero: true,
                                    source: 'auto'
                                }
                            }]
                    }}
            });
            chart.update();
        });
        event.preventDefault();
    });
});

