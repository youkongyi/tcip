jQuery(document).ready(function() {
	App.setPage("dynamic_table");  //Set current page
	App.init(); //Initialise plugins and elements

	$('#expiredate').datepicker({
        showOtherMonths: true,
        selectOtherMonths: true,
        showButtonPanel: true,
        showOn: "both",
        buttonImageOnly: true,
        buttonText: "",
        changeMonth: true,
        changeYear: true
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
				$("#succAlert1").css("display","block");
				$("#succAlert1").append(data.msg);
				
			}else{
				$("#warnAlert1").css("display","block");
				$("#warnAlert1").append(data.msg);
			}
		}
		
	});
}

function deltoken(){
	if($("#databody :checkbox:checked").length == 0){
		$("#warnAlert").css("display","block");
		$("#warnCon").html("请至选择一条记录！");
	}else {
		var ids = '';
		$.each($("#databody :checkbox:checked"),function(){
			ids = ids + $(this).val() + ','; 
		});
		$.ajax({
	        type:'get',
			async:true,
			url:'token_del?ids=' + ids,
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
}