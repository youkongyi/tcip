<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade box border blue col-sm-6" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" 
		style="margin-left: 200px;margin-top:50px; height: 600px;overflow:hidden">
		<div class="box-title">
			<h4><i class="fa fa-plus"></i>生成TOKEN</h4>
			<div class="tools hidden-xs">
				<a href="javascript:;" data-dismiss="modal">
					<i class="fa fa-times"></i>
				</a>
			</div>
		</div>
		<div class="box-body big">
			<div id="succAlert1" class="alert alert-success" style="display: none;">
				<a href="#" class="close" data-dismiss="alert">&times;</a>
				<strong>成功！</strong>
			</div>
			<div id="warnAlert1" class="alert alert-warning" style="display: none;">
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
				<label for="dataorgid" class="col-sm-2 control-label">分公司ID<span class="required">*</span></label>
				<div class="col-sm-10">
				  <input type="text" class="form-control" id="dataorgid"  name="dataorgid" placeholder="请输入分公司ID">
				  <span class="error-span"></span>
				</div>
			  </div>
			  <div class="form-group">
				<label for="orgcode" class="col-sm-2 control-label">机构编码<span class="required">*</span></label>
				<div class="col-sm-10">
				  <input type="text" class="form-control" id="orgcode" name="orgcode"  placeholder="请输入机构编码">
				  <span class="error-span"></span>
				</div>
			  </div>
			  <div class="form-group">
				<label for="secret" class="col-sm-2 control-label">签名<span class="required">*</span></label>	
				<div class="col-sm-10">
				  <input type="text" class="form-control" id="secret" name="secret"  placeholder="请输入签名">
				  <span class="error-span"></span>
				</div>
			  </div>
  			  <div class="form-group">
				<label for="secret" class="col-sm-2 control-label">区域<span class="required">*</span></label>	
				<div class="col-sm-10">
					<select id="area" name="area" class="form-control col-md-12" >
					   <option value="0">华东</option>
					   <option value="1">西南</option>
					   <option value="2">华南</option>
					   <option value="3">华北</option>
					</select>
				</div>
			  </div>
  			  <div class="form-group">
				<label for="secret" class="col-sm-2 control-label">服务地址<span class="required">*</span></label>	
				<div class="col-sm-10">
				  <input type="text" class="form-control" id="url" name="url"  placeholder="请输入签名">
				  <span class="error-span"></span>
				</div>
			  </div>
			  <div class="form-group">
				<label for="expiredate" class="col-sm-2 control-label">失效时间<span class="required">*</span></label>
				<div class="col-md-10">
					<div class="input-group"> 
						<input type="text" id="expiredate" name="expiredate" class="form-control" data-mask="9999-99-99"><span class="input-group-btn"> 
						<button class="btn btn-primary" type="button"><i class="fa fa-calendar"></i> Go!</button> </span>
					</div>
				</div>
			  </div>			  
			  <div class="form-group" style="height: 100%">
				<div class="col-sm-offset-2 col-sm-10">
				  <button type="button" class="btn btn-pink" onclick="createAccessToken()">生成</button>
				  <button type="submit" class="btn btn-pink" data-dismiss="modal">关闭</button>
				</div>
			  </div>
			</form>
		</div>
	</div>