<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh_cn">
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<title>接口测试</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<!-- STYLESHEETS --><!--[if lt IE 9]><script src="js/flot/excanvas.min.js"></script><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script><![endif]-->
	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/cloud-admin.css" >
	<link rel="stylesheet" type="text/css"  href="<%=basePath %>css/themes/default.css" id="skin-switcher" >
	<link rel="stylesheet" type="text/css"  href="<%=basePath %>css/responsive.css" >
	
	<link href="<%=basePath %>font-awesome/css/font-awesome.min.css" rel="stylesheet">
	<!-- DATE RANGE PICKER -->
	<link rel="stylesheet" type="text/css" href="<%=basePath %>js/bootstrap-daterangepicker/daterangepicker-bs3.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>js/typeahead/typeahead.css" />
	<!-- UNIFORM -->
	<link rel="stylesheet" type="text/css" href="<%=basePath %>js/uniform/css/uniform.default.min.css" />
</head>
<body>
	
	<!-- PAGE -->
	<section id="page">
			<!-- SAMPLE BOX CONFIGURATION MODAL FORM-->
			<div class="modal fade" id="box-config" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
				  <div class="modal-content">
					<div class="modal-header">
					  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					  <h4 class="modal-title">Box Settings</h4>
					</div>
					<div class="modal-body">
					  Here goes box setting content.
					</div>
					<div class="modal-footer">
					  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					  <button type="button" class="btn btn-primary">Save changes</button>
					</div>
				  </div>
				</div>
			  </div>
			<!-- /SAMPLE BOX CONFIGURATION MODAL FORM-->
			<div class="container">
				<div class="row">
					<div id="content" class="col-lg-12">
						<!-- PAGE HEADER-->
						<div class="row">
							<div class="col-sm-12">
								<div class="page-header">
									<!-- STYLER -->
									
									<!-- /STYLER -->
									<!-- BREADCRUMBS -->
									<ul class="breadcrumb">
										<li>
											<i class="fa fa-home"></i>
											<a href="index.html">Home</a>
										</li>
										<li>测试</li>
									</ul>
									<!-- /BREADCRUMBS -->
									<div class="clearfix">
										<h3 class="content-title pull-left">接口测试</h3>
									</div>
									<div class="description">通过请求json获取请求返回值 </div>
								</div>
							</div>
						</div>
						<!-- /PAGE HEADER -->
						
						<!-- FORMS -->
						<div class="row">
							<div class="col-md-12">
								<div class="row">
									<div class="col-md-12">
										<!-- BASIC -->
										<div class="col-md-12">
										<div class="box border primary">
											<div class="box-title">
												<h4><i class="fa fa-bars"></i>接口测试</h4>
												<div class="tools hidden-xs">
													<a href="#box-config" data-toggle="modal" class="config">
														<i class="fa fa-cog"></i>
													</a>
													<a href="javascript:;" class="reload">
														<i class="fa fa-refresh"></i>
													</a>
													<a href="javascript:;" class="collapse">
														<i class="fa fa-chevron-up"></i>
													</a>
													<a href="javascript:;" class="remove">
														<i class="fa fa-times"></i>
													</a>
												</div>
											</div>
											<div class="box-body big">
												<form class="form-horizontal" role="form">
												  <div class="form-group">
													<label class="col-sm-2 control-label">请求方式</label>
													<div class="col-sm-10">
													  <input type="text" id="reqMethod" class="form-control" value="get" placeholder="Text input">
													</div>
												  </div>

												  <div class="form-group">
													<label class="col-sm-2 control-label">接口URL</label>
													<div class="col-sm-10">
													  <input type="text" id="reqStr" class="form-control" placeholder="Text input">
													</div>
												  </div>
												  
												  <div class="form-group">
													<label class="col-sm-2 control-label">请求josn</label>
													<div class="col-sm-10">
													 <textarea id="jsonStr" class="form-control" rows="5"></textarea>
													</div>
												  </div>
												  <div class="form-group">
													<label class="col-sm-2 control-label">返回值</label>
													<div class="col-sm-10">
													 <textarea id="retStr" class="form-control" rows="5"></textarea>
													</div>
												  </div>
												  <div class="form-group">
													<div class="col-sm-offset-2 col-sm-10">
													  <button id="testbutton" type="button" class="btn btn-pink" onclick="testService()">测试</button>
													</div>
												  </div>
												 </form>
											</div>
										</div>
								</div>
								</div>
								<!-- /SAMPLE -->
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/PAGE -->
	<!-- JAVASCRIPTS -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!-- JQUERY -->
	<script src="<%=basePath %>js/jquery/jquery-2.0.3.min.js"></script>
	<!-- JQUERY UI-->
	<script src="<%=basePath %>js/jquery-ui-1.10.3.custom/js/jquery-ui-1.10.3.custom.min.js"></script>
	<!-- BOOTSTRAP -->
	<script src="<%=basePath %>bootstrap-dist/js/bootstrap.min.js"></script>
		
	<!-- DATE RANGE PICKER -->
	
	<!-- BLOCK UI -->
	<!-- TYPEHEAD -->
	<!-- AUTOSIZE -->
	<script type="text/javascript" src="<%=basePath %>js/autosize/jquery.autosize.min.js"></script>
	<!-- COUNTABLE -->
	<script type="text/javascript" src="<%=basePath %>js/countable/jquery.simplyCountable.min.js"></script>
	<!-- INPUT MASK -->
	<script type="text/javascript" src="<%=basePath %>js/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
	<!-- FILE UPLOAD -->
	<!-- SELECT2 -->
	<!-- UNIFORM -->
	<script type="text/javascript" src="<%=basePath %>js/uniform/jquery.uniform.min.js"></script>
	<script src="<%=basePath %>js/script.js"></script>
	<script>
		jQuery(document).ready(function() {		
			App.setPage("forms");  //Set current page
			App.init(); //Initialise plugins and elements
		});
		
		function testService(){
			var jsonStr = $("#jsonStr").val();
			var reqStr = $("#reqStr").val();
			var reqMethod = $("#reqMethod").val();
			$("#testbutton").attr("disabled","");
			if (reqMethod == 'get'){
				$.ajax({
			        type:'get',
					async:true,
					url:'/tcip' + reqStr,
					success:function(data){
						$("#testbutton").removeAttr("disabled");
						$("#retStr").val(JSON.stringify(data));
					}
					
				});
			}else {
				$.ajax({
			        type:'post',
					async:true,
					url:'/tcip' + reqStr,
			        data: jsonStr,  
					//data:JSON.stringify(jsonStr),
					contentType : 'application/json;charset=utf-8',
					dataType:'json',
					success:function(data){
						$("#testbutton").removeAttr("disabled");
						$("#retStr").val(JSON.stringify(data));
					}
					
				});
			}
		}
	</script>
	<!-- /JAVASCRIPTS -->
</body>
</html>