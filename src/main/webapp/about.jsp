<%--
  Created by IntelliJ IDEA.
  User: Ioannis
  Date: 3/2/2023
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/topdown/header.jsp"%>
<section class="banner" id="top">
  <div class="container">
    <div class="row">
      <div class="col-md-5">
        <div class="left-side">
          <div class="logo">
            <img src="img/logo.png" alt="Fly Away">
          </div>
        </div>
      </div>
      <div class="col-md-5 col-md-offset-1">
        <section id="first-tab-group" class="tabgroup">
          <div id="tab1">
            <div class="submit-form">
              <h4><em>Fly with US</em></h4>
              <p class="text-justify">Ambitioni dedisse scripsisse iudicaretur. Cras mattis iudicium purus sit amet fermentum. Donec sed odio operae, eu vulputate felis rhoncus. Praeterea iter est quasdam res quas ex communi. At nos hinc posthac, sitientis piros Afros. Petierunt uti sibi concilium totius Galliae in diem certam indicere. Cras mattis iudicium purus sit amet fermentum.</p>
            </div>
          </div>
        </section>
      </div>
    </div>
  </div>
</section>






<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.2.min.js"><\/script>')</script>

<script src="js/vendor/bootstrap.min.js"></script>

<script src="js/datepicker.js"></script>
<script src="js/plugins.js"></script>
<script src="js/main.js"></script>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
  $(document).ready(function() {



    // navigation click actions
    $('.scroll-link').on('click', function(event){
      event.preventDefault();
      var sectionID = $(this).attr("data-id");
      scrollToID('#' + sectionID, 750);
    });
    // scroll to top action
    $('.scroll-top').on('click', function(event) {
      event.preventDefault();
      $('html, body').animate({scrollTop:0}, 'slow');
    });
    // mobile nav toggle
    $('#nav-toggle').on('click', function (event) {
      event.preventDefault();
      $('#main-nav').toggleClass("open");
    });
  });
  // scroll function
  function scrollToID(id, speed){
    var offSet = 0;
    var targetOffset = $(id).offset().top - offSet;
    var mainNav = $('#main-nav');
    $('html,body').animate({scrollTop:targetOffset}, speed);
    if (mainNav.hasClass("open")) {
      mainNav.css("height", "1px").removeClass("in").addClass("collapse");
      mainNav.removeClass("open");
    }
  }
  if (typeof console === "undefined") {
    console = {
      log: function() { }
    };
  }
</script>
<%@ include file="/topdown/footer.jsp"%>
