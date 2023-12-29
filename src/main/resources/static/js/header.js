
$(function () {
    const nav = $(".menu");
    const nav1 = $(".sub");
    const nav2 = $(".container");
    const miniMenu = $(".mini_menu");
    const sub1 = $(".sub1");
    const sub2 = $(".sub2");
    const sub3 = $(".sub3");
    const sub4 = $(".sub4");

    $(nav).mouseenter(function () {
        $(nav1).stop().slideDown();
        $(nav2).stop().slideDown();
    });

    $(nav).mouseleave(function () {
        $(nav1).stop().slideUp();
        $(nav2).stop().slideUp();
    });
/*---------------------------------------------------------*/
    $(".menu_phone").click(function () {
        miniMenu.toggleClass("active");
    });

    $(".service_btn1").click(function () {
        sub1.toggleClass("active");
    });

    $(".service_btn2").click(function () {
        sub2.toggleClass("active");
    });

    $(".service_btn3").click(function () {
        sub3.toggleClass("active");
    });

    $(".service_btn4").click(function () {
        sub4.toggleClass("active");
    });
});
/*---------------------------------------------------------*/

