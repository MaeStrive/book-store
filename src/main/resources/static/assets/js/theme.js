// -----------------------------

//   js index
/* =================== */
/*  
    

    

*/
// -----------------------------


(function($) {
    "use strict";



    /*---------------------
    preloader
    --------------------- */

    $(window).on('load', function() {
        $('#preloader').fadeOut('slow', function() { $(this).remove(); });
    });



    /*-----------------
    sticky
    -----------------*/
    $(window).on('scroll', function() {
        if ($(window).scrollTop() > 85) {
            $('header').addClass('navbar-fixed-top');
        } else {
            $('header').removeClass('navbar-fixed-top');
        }
    });

    /*-----------------
    scroll-up
    -----------------*/
    $.scrollUp({
        scrollText: '<i class="fa fa-arrow-up" aria-hidden="true"></i>',
        easingType: 'linear',
        scrollSpeed: 1500,
        animation: 'fade'
    });

    /*------------------------------
         counter
    ------------------------------ */
    $('.counter-up').counterUp();


    /*---------------------
    smooth scroll
    --------------------- */
    $('.smoothscroll').on('click', function(e) {
        e.preventDefault();
        var target = this.hash;

        $('html, body').stop().animate({
            'scrollTop': $(target).offset().top - 80
        }, 1200);
    });


    /*---------------------
    countdown
    --------------------- */
    $('[data-countdown]').each(function() {
        var $this = $(this),
            finalDate = $(this).data('countdown');
        $this.countdown(finalDate, function(event) {
            $this.html(event.strftime('<span class="cdown days"><span class="time-count">%-D</span> <p>Days</p></span> <span class="cdown hour"><span class="time-count">%-H</span> <p>Hour</p></span> <span class="cdown minutes"><span class="time-count">%M</span> <p>Min</p></span> <span class="cdown second"> <span><span class="time-count">%S</span> <p>Sec</p></span>'));
        });
    });




}(jQuery));

// Crypto Nav JS

$("#sideNav-toggle").on('click', function(e) {
    e.preventDefault();
    $("#sideNavWrapper").toggleClass("active");

    if(!$("#sideNavWrapper").hasClass("active")){
        $('.sidebar-nav').addClass('collapseSidenav');
    }else {
        $('.sidebar-nav').removeClass('collapseSidenav');
    }
});

$(function () {

    $('#menu1').metisMenu();

    $('#menu2').metisMenu({
        toggle: false
    });

    $('#menu3').metisMenu();

});




$(window).on('load', function(){
    if ($(window).width() < 992) {
        $('#sideNavWrapper').removeClass('active');
        $('.sidebar-nav').addClass('collapseSidenav');
         
    }  
});


$(window).on('resize', function(){
    if ($(window).width() < 992) {
        $('#sideNavWrapper').removeClass('active');
        $('.sidebar-nav').addClass('collapseSidenav');
    }else {
        $('#sideNavWrapper').addClass('active');
        $('.sidebar-nav').removeClass('collapseSidenav');
    }  
});
