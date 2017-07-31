function login() {
    var object = $("#loginForm").serializeObject();
    if (!object.account || !object.password) {
        layer.alert("请输入账号或密码！");
        return;
    }
    layer.load(1, {shade: [0.5,'#000']});
    $.ajax({
        data: {"acount": object.account, "password": object.password},
        url: "/login",
        type: 'post',
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",
        success: function (result) {
            layer.closeAll('loading');
            if (result.status=="FAILURE") {
                layer.alert("操作失败");
            } else {
                if (result.code == 1) {
                    layer.msg(
                        '操作成功',
                        {shade: [0.5,'#000']},
                        function(){
                            window.location.href = '/index'
                        }
                    );
                } else if (result.code == 2) {
                    layer.alert("账户或密码错误！");
                }
            }
        }
    });
}