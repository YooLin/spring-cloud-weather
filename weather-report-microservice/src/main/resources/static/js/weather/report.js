$(function(){
	$("#selectCityId").change(function(){
		var cityId = $("#selectCityId").val();
		console.log('cityId', cityId)
		window.location.href = '/weather/report/cityId/' + cityId;
	})
});