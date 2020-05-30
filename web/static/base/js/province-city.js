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
};

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

getCity(1);

$("#province").change(function() {
	$("#city").empty();
	getCity(this.value);
});