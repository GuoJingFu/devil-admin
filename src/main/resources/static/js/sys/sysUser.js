function login() {
    $.ajax({
        data: {"account": "admin", "password" : "123456"},
        url: "/login",
        type: 'post',
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",
        success: function (result) {
            if (result.status=="FAILURE") {
                layer.alert("添加失败");
            } else {
                layer.msg(
                    '操作成功',
                    {shade: [0.5,'#000']},
                    function(){
                        window.location.href = '/index'
                    }
                );
            }
        }
    });
}