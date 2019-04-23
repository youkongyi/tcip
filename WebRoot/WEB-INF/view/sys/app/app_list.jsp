<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="en">
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<title>Cloud Admin | Dynamic Tables</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<!-- STYLESHEETS --><!--[if lt IE 9]><script src="js/flot/excanvas.min.js"></script><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script><![endif]-->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/cloud-admin.css" >
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/themes/default.css" id="skin-switcher" >
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/responsive.css" >
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>font-awesome/css/font-awesome.min.css">
	<!-- JQUERY UI-->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/jquery-ui-1.10.3.custom/css/custom-theme/jquery-ui-1.10.3.custom.min.css" />
	<!-- DATE RANGE PICKER -->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/bootstrap-daterangepicker/daterangepicker-bs3.css" />
	<!-- DATA TABLES -->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/datatables/media/css/jquery.dataTables.min.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/datatables/media/assets/css/datatables.min.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/datatables/extras/TableTools/media/css/TableTools.min.css" />
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/kkpager_blue.css" />
	<!-- FONTS -->
	<!-- <link href='http://fonts.useso.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'>-->
	
	<script type="text/javascript">
		function load() {
		    	arrayPage(${pageResult.pages},${pageResult.total},"sys/app/app_list");
		    }
		    
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
	
	</script>
	
</head>
<body onload="load()">

	<!-- PAGE -->
		<div>
			  
			<!-- /SAMPLE BOX CONFIGURATION MODAL FORM-->
			<div class="container">
				<div class="row">
					<div id="content" class="col-sm-12">
						<!-- PAGE HEADER-->
						<div class="row">
							<div class="col-sm-12">
								<div class="page-header1">
									<!-- BREADCRUMBS -->
									<ul class="breadcrumb">
										<li>
											<i class="fa fa-home"></i>
											<a href="index.html">Home</a>
										</li>
										<li>
											<a href="#">Tables</a>
										</li>
										<li>Dynamic Tables</li>
									</ul>
									<!-- /BREADCRUMBS -->
								</div>
							</div>
						</div>
						<!-- /PAGE HEADER -->
						
						<!-- 提示框 start-->
						<div id="succAlert" class="alert alert-success" style="display: none;">
							<a href="#" class="close" data-dismiss="alert">&times;</a>
							<strong>成功！</strong><span id="sucessCon"></span>
						</div>
						<div id="warnAlert" class="alert alert-warning" style="display: none;">
							<a href="#" class="close" data-dismiss="alert">&times;</a>
							<strong>警告！</strong><span id="warnCon"></span>
						</div>
						<!-- 提示框  end-->
						
						
						<!-- 功能按钮 start-->
						<div class="row" style="margin-top: 10px;">
							<div class="col-md-12">
							<p class="btn-toolbar">
								<button class="btn btn-info" data-toggle="modal" data-target="#myModal"><i class="fa fa-pencil"></i> 新增</button>
								<button class="btn btn-info"><i class="fa fa-pencil-square-o"></i> 修改</button>
								<button class="btn btn-info"><i class="fa fa-times"></i> 删除</button>
								<a class="btn btn-info" data-toggle="modal" id="authorize"><i class="fa fa-check icon-white"></i> 授权</a>
							</p>
							</div>	
						</div>
						<!-- 功能按钮 end -->
						
						<!-- DATA TABLES -->
						<div class="row">
							<div class="col-md-12">
								<!-- BOX -->
								<div class="box border blue">
									<div class="box-title">
										<h4><i class="fa fa-table"></i>第三方应用列表</h4>
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

									<div class="box-body">
									<table id = "datatable"  cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered box border blue table-hover">
											<thead>
													<tr>
														<th style="width: 20px;"><input type="checkbox"  id="checkall"></th>
														<th>应用ID</th>
														<th>分公司编码</th>
													</tr>
											</thead>
											<tbody id="databody">
												<c:forEach items="${pageResult.dataList }" var="app">
												<tr class="gradeU">
													<td><input type="checkbox" value="${app.appid }"></td>
													<td>${app.appid }</td>
													<td class="hidden-xs">${app.appname }</td>
												</tr>
												</c:forEach>
											</tbody>
											<tfoot>
												<tr>
													<td colspan="5">
														<div id="kkpager" style="margin-right: 30px;"></div>
													</td>
												</tr>
											</tfoot>
										</table>
									</div>
								</div>
								<!-- /BOX -->
							</div>
						</div>

						<!-- /EXPORT TABLES -->
						<div class="footer-tools">
							<span class="go-top">
								<i class="fa fa-chevron-up"></i> Top
							</span>
						</div>
					</div><!-- /CONTENT-->
				</div>
			</div>
		</div>
	<!--/PAGE -->
	<!-- JAVASCRIPTS -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!-- JQUERY -->
	<script src="<%=basePath%>js/jquery/jquery-2.0.3.min.js"></script>
	<!-- JQUERY UI-->
	<script src="<%=basePath%>js/jquery-ui-1.10.3.custom/js/jquery-ui-1.10.3.custom.min.js"></script>
	<!-- BOOTSTRAP -->
	<script src="<%=basePath%>bootstrap-dist/js/bootstrap.min.js"></script>
	
	<!-- DATE RANGE PICKER -->
	<script src="<%=basePath%>js/bootstrap-daterangepicker/moment.min.js"></script>
	<script src="<%=basePath%>js/bootstrap-daterangepicker/daterangepicker.min.js"></script>
	<!-- SLIMSCROLL -->
	<script type="text/javascript" src="<%=basePath%>js/jQuery-slimScroll-1.3.0/jquery.slimscroll.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jQuery-slimScroll-1.3.0/slimScrollHorizontal.min.js"></script>
	<!-- BLOCK UI -->
	<script type="text/javascript" src="<%=basePath%>js/jQuery-BlockUI/jquery.blockUI.min.js"></script>
	<!-- DATA TABLES -->
	<script type="text/javascript" src="<%=basePath%>js/datatables/media/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/datatables/media/assets/js/datatables.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/datatables/extras/TableTools/media/js/TableTools.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/datatables/extras/TableTools/media/js/ZeroClipboard.min.js"></script>
	<!-- COOKIE -->
	<script type="text/javascript" src="<%=basePath%>js/jQuery-Cookie/jquery.cookie.min.js"></script>
	<!-- CUSTOM SCRIPT -->
	<script src="<%=basePath%>js/script.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/kkpager.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/pager.js"></script>
	<script type="text/javascript" src="<%=basePath%>custjs/app/app.js"></script>
	<script type="text/javascript" src="<%=basePath%>custjs/common.js"></script>
	
	<!-- /JAVASCRIPTS -->
	
</body>
<%@include file="app_add.jsp" %>
</html>