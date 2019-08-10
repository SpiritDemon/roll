$(function(){
	$("#roll").click(function(){
		var username = $("#username").val();
		$.ajax({
			url:"roll",
			data:{"username":username},
			dataType:"html",
			error:function(){
				$("#div02").html("服务器繁忙，请稍后再试");
			},
			success:function(data){
				$("#div02").html(data);
			},
			type:"POST"
		});
	});
});
