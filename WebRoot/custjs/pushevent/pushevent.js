jQuery(document).ready(function() {
		App.setPage("dynamic_table");  //Set current page
		App.init(); //Initialise plugins and elements
		$("#e1").select2({placeholder: "请选择类别"});
		
		$("#cl-dashboard").remove();
});

//事件注册
function eventReg(){
	//获取表单数据，并组装成JSOn
	var str_data=$("#createForm input").map(function(){
	 return '"' + ($(this).attr("name")+'":"'+$(this).val()) + '"';
	}).get().join(",") ;
	var strData = "{" + str_data + "}";

	$.ajax({
        type:'post',
		async:true,
		url:'/tcip/service/event_reg',
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
	
	 //删除操作   
	function del(id){
			$.ajax({
					type : "post",
					async :true,
					url : "del",
					data : {id:id},
					dataType : "text",
					success : function (res){
						if (res == "yes"){
							alert("删除成功！");
							location.href="queryAllGirls";
						}else{
							alert("删除失败");
						}
					}
			});
		}
}
