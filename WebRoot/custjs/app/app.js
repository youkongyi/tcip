jQuery(document).ready(function() {		
	App.setPage("dynamic_table");  //Set current page
	App.init(); //Initialise plugins and elements

	$("#authorize").click(function(){
		
		if($("#databody :checkbox:checked").length == 0){
			$("#warnAlert").css("display","block");
			$("#warnCon").html("请至选择一条记录！");
		}else	if($("#databody :checkbox:checked").length >1){
			$("#warnAlert").css("display","block");
			$("#warnCon").html("一次只能对一个应用进行授权!");
		}else {
			$(location).attr('href', 'app_authorizes?appId=' + $("#databody :checkbox:checked").val());
		}
		//app_authorize.jsp
	});
});


function createAccessToken(){
	
	//获取表单数据，并组装成JSOn
	var str_data=$("#createForm input").map(function(){
	 return '"' + ($(this).attr("name")+'":"'+$(this).val()) + '"';
	}).get().join(",") ;
	var strData = "{" + str_data + "}";

	$.ajax({
        type:'post',
		async:true,
		url:'token_add',
        data: strData,  
		contentType : 'application/json;charset=utf-8',
		dataType:'json',
		success:function(data){
			if (data.result == 0){
				$("#succAlert").css("display","block");
				$("#succAlert").append(data.msg);
				
			}else{
				$("#warnAlert").css("display","block");
				$("#warnAlert").append(data.msg);
			}
		}
	});
}
