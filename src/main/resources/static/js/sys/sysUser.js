function login() {
    var object = $("#loginForm").serializeObject();
    if (!object.account || !object.password) {
        layer.alert("请输入账号或密码！");
        return;
    }
    $.ajax({
        data: {"acount": object.account, "password": object.password},
        url: "/login",
        type: 'post',
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",
        success: function (result) {
            if (result.status=="FAILURE") {
                layer.alert("添加失败");
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