/*
$(".nav-link").click(function() {
    $(".nav-link").removeClass("active"); // This will remove active classes from all <li> tags
    $(this).addClass("active"); // This will add active class in clicked <li>   
});
$(document).ready(function(){
    $(".nav-link").click(function(){
        $(this).addClass("active");
        $(this).text("Active Class");
    });
});
*/

$(function() {
    $(".nav-link").click(function() {
        // remove classes from all
        $(".nav-link").removeClass("active");
        // add class to the one we clicked
        $(this).addClass("active");
    });
});