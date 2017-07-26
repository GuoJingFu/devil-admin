$(function() {
    function t(t) {
        var e = 0;
        return $(t).each(function() {
            e += $(this).outerWidth(!0)
        }),
        e
    }
    function e(e) {
        var a = t($(e).prevAll()),
        i = t($(e).nextAll()),
        n = t($(".content-tabs").children().not(".D_menuTabs")),
        s = $(".content-tabs").outerWidth(!0) - n,
        r = 0;
        if ($(".page-tabs-content").outerWidth() < s) r = 0;
        else if (i <= s - $(e).outerWidth(!0) - $(e).next().outerWidth(!0)) {
            if (s - $(e).next().outerWidth(!0) > i) {
                r = a;
                for (var o = e; r - $(o).outerWidth() > $(".page-tabs-content").outerWidth() - s;) r -= $(o).prev().outerWidth(),
                o = $(o).prev()
            }
        } else a > s - $(e).outerWidth(!0) - $(e).prev().outerWidth(!0) && (r = a - $(e).prev().outerWidth(!0));
        $(".page-tabs-content").animate({
            marginLeft: 0 - r + "px"
        },
        "fast")
    }
    function a() {
        var e = Math.abs(parseInt($(".page-tabs-content").css("margin-left"))),
        a = t($(".content-tabs").children().not(".D_menuTabs")),
        i = $(".content-tabs").outerWidth(!0) - a,
        n = 0;
        if ($(".page-tabs-content").width() < i) return ! 1;
        for (var s = $(".D_menuTab:first"), r = 0; r + $(s).outerWidth(!0) <= e;) r += $(s).outerWidth(!0),
        s = $(s).next();
        if (r = 0, t($(s).prevAll()) > i) {
            for (; r + $(s).outerWidth(!0) < i && s.length > 0;) r += $(s).outerWidth(!0),
            s = $(s).prev();
            n = t($(s).prevAll())
        }
        $(".page-tabs-content").animate({
            marginLeft: 0 - n + "px"
        },
        "fast")
    }
    function i() {
        var e = Math.abs(parseInt($(".page-tabs-content").css("margin-left"))),
        a = t($(".content-tabs").children().not(".D_menuTabs")),
        i = $(".content-tabs").outerWidth(!0) - a,
        n = 0;
        if ($(".page-tabs-content").width() < i) return ! 1;
        for (var s = $(".D_menuTab:first"), r = 0; r + $(s).outerWidth(!0) <= e;) r += $(s).outerWidth(!0),
        s = $(s).next();
        for (r = 0; r + $(s).outerWidth(!0) < i && s.length > 0;) r += $(s).outerWidth(!0),
        s = $(s).next();
        n = t($(s).prevAll()),
        n > 0 && $(".page-tabs-content").animate({
            marginLeft: 0 - n + "px"
        },
        "fast")
    }
    function n() {
        var t = $(this).attr("href"),
        a = $(this).data("index"),
        i = $.trim($(this).text()),
        n = !0;
        if (void 0 == t || 0 == $.trim(t).length) return ! 1;
        if ($(".D_menuTab").each(function() {
            return $(this).data("id") == t ? ($(this).hasClass("active") || ($(this).addClass("active").siblings(".D_menuTab").removeClass("active"), e(this), $(".D_mainContent .D_iframe").each(function() {
                return $(this).data("id") == t ? ($(this).show().siblings(".D_iframe").hide(), !1) : void 0
            })), n = !1, !1) : void 0
        }), n) {
            var s = '<a href="javascript:;" class="active D_menuTab" data-id="' + t + '">' + i + ' <i class="fa fa-times-circle"></i></a>';
            $(".D_menuTab").removeClass("active");
            var r = '<iframe class="D_iframe" name="iframe' + a + '" width="100%" height="100%" src="' + t + '" frameborder="0" data-id="' + t + '" seamless></iframe>';
            $(".D_mainContent").find("iframe.D_iframe").hide().parents(".D_mainContent").append(r);
            var o = layer.load();
            $(".D_mainContent iframe:visible").load(function() {
                layer.close(o)
            }),
            $(".D_menuTabs .page-tabs-content").append(s),
            e($(".D_menuTab.active"))
        }
        return ! 1
    }
    function s() {
        var t = $(this).parents(".D_menuTab").data("id"),
        a = $(this).parents(".D_menuTab").width();
        if ($(this).parents(".D_menuTab").hasClass("active")) {
            if ($(this).parents(".D_menuTab").next(".D_menuTab").size()) {
                var i = $(this).parents(".D_menuTab").next(".D_menuTab:eq(0)").data("id");
                $(this).parents(".D_menuTab").next(".D_menuTab:eq(0)").addClass("active"),
                $(".D_mainContent .D_iframe").each(function() {
                    return $(this).data("id") == i ? ($(this).show().siblings(".D_iframe").hide(), !1) : void 0
                });
                var n = parseInt($(".page-tabs-content").css("margin-left"));
                0 > n && $(".page-tabs-content").animate({
                    marginLeft: n + a + "px"
                }, "fast"),
                $(this).parents(".D_menuTab").remove(),
                $(".D_mainContent .D_iframe").each(function() {
                    return $(this).data("id") == t ? ($(this).remove(), !1) : void 0
                })
            }
            if ($(this).parents(".D_menuTab").prev(".D_menuTab").size()) {
                var i = $(this).parents(".D_menuTab").prev(".D_menuTab:last").data("id");
                $(this).parents(".D_menuTab").prev(".D_menuTab:last").addClass("active"),
                $(".D_mainContent .D_iframe").each(function() {
                    return $(this).data("id") == i ? ($(this).show().siblings(".D_iframe").hide(), !1) : void 0
                }),
                $(this).parents(".D_menuTab").remove(),
                $(".D_mainContent .D_iframe").each(function() {
                    return $(this).data("id") == t ? ($(this).remove(), !1) : void 0
                })
            }
        } else $(this).parents(".D_menuTab").remove(),
        $(".D_mainContent .D_iframe").each(function() {
            return $(this).data("id") == t ? ($(this).remove(), !1) : void 0
        }),
        e($(".D_menuTab.active"));
        return ! 1
    }
    function r() {
        $(".page-tabs-content").children("[data-id]").not(":first").not(".active").each(function() {
            $('.D_iframe[data-id="' + $(this).data("id") + '"]').remove(),
            $(this).remove()
        }),
        $(".page-tabs-content").css("margin-left", "0")
    }
    function o() {
        e($(".D_menuTab.active"))
    }
    function d() {
        if (!$(this).hasClass("active")) {
            var t = $(this).data("id");
            $(".D_mainContent .D_iframe").each(function() {
                return $(this).data("id") == t ? ($(this).show().siblings(".D_iframe").hide(), !1) : void 0
            }),
            $(this).addClass("active").siblings(".D_menuTab").removeClass("active"),
            e(this)
        }
    }
    function c() {
        var t = $('.D_iframe[data-id="' + $(this).data("id") + '"]'),
        e = t.attr("src"),
        a = layer.load();
        t.attr("src", e).load(function() {
            layer.close(a)
        })
    }
    $(".D_menuItem").each(function(t) {
        $(this).attr("data-index") || $(this).attr("data-index", t)
    }),
    $(".D_menuItem").on("click", n),
    $(".D_menuTabs").on("click", ".D_menuTab i", s),
    $(".D_tabCloseOther").on("click", r),
    $(".D_tabShowActive").on("click", o),
    $(".D_menuTabs").on("click", ".D_menuTab", d),
    $(".D_menuTabs").on("dblclick", ".D_menuTab", c),
    $(".D_tabLeft").on("click", a),
    $(".D_tabRight").on("click", i),
    $(".D_tabCloseAll").on("click",
		function() {
		    $(".page-tabs-content").children("[data-id]").not(":first").each(function() {
		        $('.D_iframe[data-id="' + $(this).data("id") + '"]').remove(),
		        $(this).remove()
		    }),
		    $(".page-tabs-content").children("[data-id]:first").each(function() {
		        $('.D_iframe[data-id="' + $(this).data("id") + '"]').show(),
		        $(this).addClass("active")
		    }),
		    $(".page-tabs-content").css("margin-left", "0")
    	}
    )
});