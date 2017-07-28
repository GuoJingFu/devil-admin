/**
 * devil js
 * @author Devil
 */
//初始化
$(function () {
    //左侧菜单初始化
    $("#side-menu").metisMenu();
});

//菜单淡入淡出
function SmoothlyMenu() {
    $("body").hasClass("mini-navbar") ? $("body").hasClass("fixed-sidebar") ? ($("#side-menu").hide(), setTimeout(function () {
        $("#side-menu").fadeIn(500)
    }, 300)) : $("#side-menu").removeAttr("style") : ($("#side-menu").hide(), setTimeout(function () {
        $("#side-menu").fadeIn(500)
    }, 100))
}

//切换菜单最大最小话
$(".navbar-minimalize").click(function () {
    $("body").toggleClass("mini-navbar");
    SmoothlyMenu();
});