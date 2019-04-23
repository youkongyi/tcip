<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- SAMPLE BOX CONFIGURATION MODAL FORM-->
<div class="modal fade box border blue col-sm-6" id="box-eventreg" tabindex="-1" role="dialog" aria-labelledby="box-eventreg" aria-hidden="true" 
	style="margin-left: 200px;margin-top:50px; height: 500px;overflow:hidden">
	<div class="box-title">
		<h4><i class="fa fa-plus"></i>事件注册</h4>
		<div class="tools hidden-xs">
			<a href="javascript:;" data-dismiss="modal">
				<i class="fa fa-times"></i>
			</a>
		</div>
	</div>
	<div class="box-body big">
		<div id="succAlert" class="alert alert-success" style="display: none;">
			<a href="#" class="close" data-dismiss="alert">&times;</a>
			<strong>成功！</strong>
		</div>
		<div id="warnAlert" class="alert alert-warning" style="display: none;">
			<a href="#" class="close" data-dismiss="alert">&times;</a>
			<strong>警告！</strong>
		</div>
		<div class="separator"></div>
		<h3 class="form-title">新增access_token</h3>
		<form id="createForm" class="form-horizontal" role="form">
		
		  <div class="form-group">
			<label for="appid" class="col-sm-2 control-label">APPID<span class="required">*</span></label>
			<div class="col-sm-10">
			  <input type="text" class="form-control" id="appid" name="appid" placeholder="请输入应用ID">
			  <span class="error-span"></span>
			</div>
		  </div>
		  
		  <div class="form-group">
			<label for="messagecode" class="col-sm-2 control-label">分公司ID<span class="required">*</span></label>
			<div class="col-sm-10">
			  <input type="text" class="form-control" id="messagecode" name="messagecode" placeholder="请输入事件编码">
			  <span class="error-span"></span>
			</div>
		  </div>
		  <div class="form-group">
			<label for="url" class="col-sm-2 control-label">机构编码<span class="required">*</span></label>
			<div class="col-sm-10">
			  <input type="text" class="form-control" id="url" name="url"  placeholder="请输入url">
			  <span class="error-span"></span>
			</div>
		  </div>
		  <div class="form-group">
			<label for="type" class="col-sm-2 control-label">签名<span class="required">*</span></label>	
			<div class="col-sm-10">
			  <input type="text" class="form-control" id="type" name="type"  placeholder="请输入推送类型">
			  <span class="error-span"></span>
			</div>
		  </div>
		  <div class="form-group" style="height: 100%">
			<div class="col-sm-offset-2 col-sm-10">
			  <button type="button" class="btn btn-pink" onclick="eventReg()">生成</button>
			  <button type="submit" class="btn btn-pink" data-dismiss="modal">关闭</button>
			</div>
		  </div>
		</form>
	</div>
</div>