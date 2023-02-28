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

function changes(ch) {
    if (document.getElementById("roundtrip").checked === true) {
        document.getElementById("retdate").disabled = false;
        document.getElementById("retdate").setAttribute("required", "required");
    } else if (document.getElementById("one-way").checked === true) {
        document.getElementById("retdate").disabled=true;
        document.getElementById("retdate").value="";
        document.getElementById("retdate").setAttribute("required","");
    }
    else
    {
        document.getElementById("retdate").disabled=true;
        document.getElementById("retdate").setAttribute("required","");

    }
};