function getCode() {
    $("#imgId").attr('src', "CodeServlet?" + new Date());
}

function loginVerity() {

    let name = $('#name').val();
    let password = $('#password').val();
    let verityCode = $('#verityCode').val();
    let remember = "close";
    let isCheck = $('#remember').is(':checked');
    if(isCheck === true) {
        remember = "on";
    }

    $.ajax({
        url: "UserServlet",
        data: {
            "action": "login",
            "name": name,
            "password": password,
            "verityCode": verityCode,
            "remember": remember},
        dataType: "json",
        success: function (result) {
            if(result.status === 200) {
                layer.msg(result.msg, {
                    time: 2000,
                    icon: 1
                });
                setTimeout(function () {
                    window.location = "index.jsp";
                }, 2000)
            } else if(result.status === 404) {
                layer.msg(result.msg, {
                    time: 2000,
                    icon: 2
                });

            } else if(result.status === 10001) {
                layer.msg(result.msg, {
                    time: 2000,
                    icon: 7
                });
            }

        }
    })
}

$("#loginBtn").click(function () {
    layer.open({
        type: 1
        ,title: "登录验证"
        ,closeBtn: false
        ,area: '400px;'
        ,shade: 0.8
        ,id: 'LAY_layuipro_login' //设定一个id，防止重复弹出
        ,btn: ['火速登录', '残忍拒绝']
        ,btnAlign: 'c'
        ,moveType: 1 //拖拽模式，0或者1
        ,content: $("#loginDemo").html()
        ,success: function(layero){
            var btn = layero.find('.layui-layer-btn');
            btn.find('.layui-layer-btn0').click(function () {
                loginVerity()
            })
        }
    });
});

function getProvince() {
    $.ajax({
        url: 'UserServlet',
        dataType: 'json',
        data: {"action" : "getProvinceList"},
        success: function (result) {
            var provinceList = eval(result);
            for(let p of provinceList) {
                $("#province").append("<option value=" + p.id + ">" + p.name + "</option>")
            }

        }
    });
}

function getCity(provinceId) {
    $.ajax({
        url: "UserServlet",
        dataType: "json",
        data: {"action": "getCityList", "provinceId": provinceId},
        success: function (result) {
            var cityList = eval(result);

            for(let c of cityList) {
                $("#city").append("<option value=" + c.id + ">" + c.name + "</option>")
            }
        }
    });
}

function getCityList(id) {
    $("#city").empty();
    getCity(id);
}

function checkName(user) {
    let username = user.value;
    if(username.trim() === "") {
        layer.msg("账户名称不能为空", {
            time: 2000,
            icon: 2
        });
    } else {
        $.ajax({
            url: 'UserServlet',
            dataType: 'json',
            data: {"action" : "isRegister", "name": username},
            success: function (result) {
                if(result === 200) {
                    layer.msg("验证通过", {
                        time: 2000,
                        icon: 1
                    });

                } else if(result === 10001){
                    layer.msg("账户名称已被使用", {
                        time: 2000,
                        icon: 2
                    });

                } else if(result === 10002){
                    layer.msg("账户名称不能包含中文", {
                        time: 2000,
                        icon: 2
                    });
                }
            }
        });
    }

}

function registerVerity() {

    let name = $('#rname').val();
    let password = $('#rpassword').val();
    let email = $('#remail').val();
    let sex = $('input:radio:checked').val();
    let provinceId = $("#province").val();
    let cityId = $("#city").val();

    $.ajax({
        url: "UserServlet",
        data: {
            "action": "registerAjax",
            "name": name,
            "password": password,
            "email": email,
            "sex": sex,
            "provinceId": provinceId,
            "cityId": cityId
        },
        dataType: "json",
        success: function (result) {
            if(result === 200) {
                layer.msg("注册新用户成功", {
                    time: 2000,
                    icon: 1
                })
            }
        }
    })
}

$("#registerBtn").click(function () {
    layer.open({
        type: 1
        ,title: "注册用户"
        ,closeBtn: false
        ,area: '400px;'
        ,shade: 0.8
        ,id: 'LAY_layuipro_login' //设定一个id，防止重复弹出
        ,btn: ['火速注册', '残忍拒绝']
        ,btnAlign: 'c'
        ,moveType: 1 //拖拽模式，0或者1
        ,content: $("#registerDemo").html()
        ,success: function(layero){
            var btn = layero.find('.layui-layer-btn');
            btn.find('.layui-layer-btn0').click(function () {
                registerVerity();
            })
        }
    });

    getProvince();
    getCity(1);
});

$("#modifyPwd").click(function () {
    layer.open({
        type: 1
        ,title: "修改密码" //不显示标题栏
        ,closeBtn: false
        ,area: '300px;'
        ,shade: 0.8
        ,id: 'LAY_layuipro_modify' //设定一个id，防止重复弹出
        ,btn: ['火速围观', '残忍拒绝']
        ,btnAlign: 'c'
        ,moveType: 1 //拖拽模式，0或者1
        ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; ' +
            'color: #fff; font-weight: 300;">你知道吗？亲！<br>layer ≠ layui<br><br>' +
            'layer只是作为Layui的一个弹层模块，由于其用户基数较大，所以常常会有人以为layui是lay' +
            'erui<br><br>layer虽然已被 Layui 收编为内置的弹层模块，但仍然会作为一个独立组件全力维护、' +
            '升级。<br><br>我们此后的征途是星辰大海 ^_^</div>'
        ,success: function(layero){
            var btn = layero.find('.layui-layer-btn');
            btn.find('.layui-layer-btn0').click(function () {
                alert("修改密码")
            })
        }
    });
});

$("#logoutBtn").click(function () {
    layer.open({
        type: 1
        ,title: "系统提示" //不显示标题栏
        ,closeBtn: false
        ,area: '300px;'
        ,shade: 0.8
        ,id: 'LAY_layuipro_logout' //设定一个id，防止重复弹出
        ,btn: ['确认退出', '残忍拒绝']
        ,btnAlign: 'c'
        ,moveType: 1 //拖拽模式，0或者1
        ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; ' +
            'color: #fff; font-weight: 300;">你知道吗？亲！<br><br>' +
            '您确认要退出吗？' +
            '<br><br>我们此后的征途是星辰大海 ^_^</div>'
        ,success: function(layero){
            var btn = layero.find('.layui-layer-btn');
            btn.find('.layui-layer-btn0').attr({
                href: 'UserServlet?action=logout'
            })
        }
    });
});

$("#logoutBtnAdmin").click(function () {
    layer.open({
        type: 1
        ,title: "系统提示" //不显示标题栏
        ,closeBtn: false
        ,area: '300px;'
        ,shade: 0.8
        ,id: 'LAY_layuipro_logout' //设定一个id，防止重复弹出
        ,btn: ['确认退出', '残忍拒绝']
        ,btnAlign: 'c'
        ,moveType: 1 //拖拽模式，0或者1
        ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; ' +
            'color: #fff; font-weight: 300;">你知道吗？亲！<br><br>' +
            '您确认要退出吗？' +
            '<br><br>我们此后的征途是星辰大海 ^_^</div>'
        ,success: function(layero){
            var btn = layero.find('.layui-layer-btn');
            btn.find('.layui-layer-btn0').attr({
                href: '../UserServlet?action=logout'
            })
        }
    });
});