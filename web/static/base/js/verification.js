function back1() {
	window.location = "welcome.jsp";
}


$("#name").blur(function () { // 鼠标离开时触发事件
	let name = $('#name').val();
	if(name.trim() === "") {
		$('#is_name').css("color", "red").text("账户名称不能为空");
	} else {
		$.ajax({
			url: 'UserServlet',
			type: 'post',
			dataType: 'json',
			data: {"action" : "isRegister", "name": name},
			success: function (result) {
				if(result === 200) {
					$('#is_name').css("color", "green").text("验证通过");
					
				} else if(result === 10001){
					$('#is_name').css("color", "red").text("账户名称已被使用");
					
				} else if(result === 10002){
					$('#is_name').css("color", "red").text("账户不能包含中文");
				}
			}
		}); 
	}
});
