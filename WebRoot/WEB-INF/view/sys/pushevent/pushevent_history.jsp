<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<title>接口清单</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<!-- STYLESHEETS --><!--[if lt IE 9]><script src="js/flot/excanvas.min.js"></script><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script><![endif]-->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/cloud-admin.css" >
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/themes/default.css" id="skin-switcher" >
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/responsive.css" >
	<!-- TYPEAHEAD -->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>font-awesome/css/font-awesome.min.css">
	<!-- JQUERY UI-->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/jquery-ui-1.10.3.custom/css/custom-theme/jquery-ui-1.10.3.custom.min.css" />
	<!-- DATE RANGE PICKER -->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/bootstrap-daterangepicker/daterangepicker-bs3.css" />
	<!-- DATA TABLES -->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/datatables/media/css/jquery.dataTables.min.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/datatables/media/assets/css/datatables.min.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/datatables/extras/TableTools/media/css/TableTools.min.css" />
	
	<!-- SELECT2 -->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/select2/select2.min.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/kkpager_blue.css" />
	
	<script type="text/javascript">
		function load() {
		    	arrayPage(${pagedResult.pages},${pagedResult.total},"pushevent_history");
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
											<a href="#">事件管理</a>
										</li>
										<li>推送历史	</li>
									</ul>
									<!-- /BREADCRUMBS -->
								</div>
							</div>
						</div>
						<!-- /PAGE HEADER -->
						
						<!-- 查询条件 start -->
						<div>
									<!-- BOX -->
									<div class="box border blue">
										<div class="box-title">
											<h4><i class="fa fa-bars"></i>查询条件</h4>
											<div class="tools">
												<a href="javascript:;" class="collapse">
													<i class="fa fa-chevron-up"></i>
												</a>
											</div>
										</div>
										<div class="box-body big">
											<form class="form-horizontal " action="pushevent_history" id="queryForm">
											  <div class="form-group">
											  
												<label class="col-md-1 control-label" for="appid">应用ID</label> 
												 <div class="col-md-2">
													<div class="input-group"> 
														<input type="text" name="appid" class="form-control" value="${eventpushlog.appid }" >
													</div>											
												 </div>
												<label class="col-md-1 control-label" for="dataorgid">分公司ID</label> 
												 <div class="col-md-2">
													<div class="input-group"> 
														<input type="text" name="dataorgid" class="form-control" value="${eventpushlog.dataorgid }" >
													</div>											
												 </div>
												<label class="col-md-1 control-label" for="pushcode">接口编码</label> 
												 <div class="col-md-2">
													<div class="input-group"> 
														<input type="text" name="pushcode" class="form-control" value="${eventpushlog.pushcode }" >
													</div>											
												 </div>
												 <label class="col-md-1 control-label">推送状态:</label> 
												 <div class="col-md-1">
													<div class="input-group"> 
														<input type="text" name="status" class="form-control" value="${eventpushlog.status }" >
													</div>
												</div>
												
												 <div class="col-md-1">
													<div class="input-group"> 
															<button type="submit" class="btn btn-info"><i class="fa fa-search"></i> 查询</button>
													</div>
												</div>
											  </div>
											  
										   </form>
										</div>
									</div>
									<!-- /BOX -->
								</div>
						<!-- 查询条件  end-->
						<!-- DATA TABLES -->
						<div class="row">
							<div class="col-md-12">
								<!-- BOX -->
								<div class="box border blue">
									<div class="box-title">
										<h4><i class="fa fa-table"></i>推送历史</h4>
										<div class="tools hidden-xs">
											<a href="#box-eventreg" data-toggle="modal" class="config">
												<i class="fa fa-pencil"></i>
											</a>
											<a href="javascript:;" class="reload">
												<i class="fa fa-pencil-square-o"></i>
											</a>
											<a href="javascript:;">
												<i class="fa fa-times"></i>
											</a>
											<a href="javascript:;" class="collapse">
												<i class="fa fa-chevron-up"></i>
											</a>
										</div>
									</div>

									<div class="box-body">
										<table id = "datatable"  cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered box border blue table-hover">
											<thead>
													<tr>
														<th><input type="checkbox" width="5%" id="checkall"></th>
														<th>分公司ID</th>
														<th>推送接口编码</th>
														<th>应用ID</th>
														<th class="hidden-xs">url</th>
														<th>推送状态</th>
														<th class="hidden-xs">推送日期</th>
													</tr>
											</thead>
											<tbody>
												<c:forEach items="${pagedResult.dataList }" var="eventpushlog">
												<tr class="gradeU" ondblclick="showMessage(${eventpushlog.id });">
													<td><input type="checkbox" name="id" value="${eventpushlog.id }"></td>
													<td>${eventpushlog.dataorgid }</td>
													<td>${eventpushlog.pushcode }</td>
													<td>${eventpushlog.appid }</td>
													<td>${eventpushlog.url}</td>
													<td class="hidden-xs">${eventpushlog.status}</td>
													<td><fmt:formatDate value="${eventpushlog.createtime}" pattern="yyyy/MM/dd  HH:mm:ss" /> </td>
												</tr>
												</c:forEach>
											</tbody>
											<tfoot>
												<tr>
													<td colspan="7">
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

	<!-- TYPEHEAD -->
	<script type="text/javascript" src="<%=basePath%>js/typeahead/typeahead.min.js"></script>
		
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

	<!-- SELECT2 -->
	<script type="text/javascript" src="<%=basePath%>js/select2/select2.min.js"></script>
	<!-- COOKIE -->
	<script type="text/javascript" src="<%=basePath%>js/jQuery-Cookie/jquery.cookie.min.js"></script>

	<!-- CUSTOM SCRIPT -->
	<script src="<%=basePath%>js/script.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/kkpager.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/pager.js"></script>
	<script type="text/javascript" src="<%=basePath%>custjs/common.js"></script>
	<script type="text/javascript" src="<%=basePath%>custjs/pushevent/pushevent.js"></script>
	<!-- /JAVASCRIPTS -->
	<script type="text/javascript">
		 //查看推送日志详情   
		function showMessage(id){
			$.ajax({
						type : "post",
						async :true,
						url : "viewMessage",
						data : {id:id},
						dataType : "text",
						success : function (res){
							$("#viewMessage").modal();
							$("#messageContent").html(res);
						}
				});
			}
	</script>
</body>
	<%@include file="pushevent_message.jsp" %>
</html>