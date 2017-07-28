//全局ajax拦截
var _ajax = $.ajax;
//修改ajax方法的默认实现
$.ajax = function(options) {
    var success = options.success;
    //对用户配置的success方法进行代理
    function interceptor(data) {
        var args = arguments;
        //对数据进行处理
        if (data.code == 403) {
            window.location.href = '/';
            return;
        }
        //这里需要判断用户传入的上下文，具体实现略
        return success.apply(this, args);
    }
    //代理嵌入调用
    options.success = interceptor;
    return _ajax(options);
}
//封装json
$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [ o[this.name] ];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
}