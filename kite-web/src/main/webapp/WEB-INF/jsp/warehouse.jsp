<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../../core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>国际物流中转仓后台管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="${pageContext.request.contextPath}/js/warehouse.js"></script>
</head>
<body>

<div class="panel panel-default">
	<div class="panel-heading">
		<h4 class="panel-title">
			<strong>条件查询</strong>
		</h4>
	</div>
	<div class="panel-body">
		<form id="conForm" class=" form-inline">
			<div class="form-group">
				<div class="col-md-2 ">
					<input type="text" class="form-control" id="country" name="country" placeholder="请输入转运仓国家">
				</div>
			</div>
			<div class="form-group"  >
				<div class="col-md-2 ">
					<input type="text" class="form-control" id="fullName" name="fullName" placeholder="请输入转运仓名称">
				</div>
			</div>
			<!--/row-->
			<button type="button" onclick="getWarehouseByCon()" class="btn btn-info ">
				<span class="glyphicon glyphicon-search" aria-hidden="true" >  搜索</span></button>
			<button type="button" onclick="resetCondition()" class="btn btn-info ">
				<span class="glyphicon glyphicon-search" aria-hidden="true" >重置</span></button>
		</form>
	</div>
</div>


	<table id="warehouse-table" class="table table-hover table-striped table-condensed table-bordered"></table>

	<!--toolbar  -->
	<div id="toolbar" class="btn-toolbar">
		<button onclick="openWarehouseDlg()" type="button" class="btn btn-success">
			<span class="glyphicon glyphicon-plus" aria-hidden="true" >添加</span>
		</button>
		<button onclick="ImportExcel()" type="button" class="btn btn-success">
			<span class="glyphicon glyphicon-copy" aria-hidden="true" >导入</span>
		</button>
		<button onclick="ExportExcel()" type="button" class="btn btn-success">
			<span class="glyphicon glyphicon-paste" aria-hidden="true" >导出</span>
		</button>
		<button  type="button" onclick="delManyWarehouses()" class="btn btn-danger">
			<span class="glyphicon glyphicon-trash" aria-hidden="true">删除</span>
		</button>
	</div>


	<!-- 模态框（Modal） -->
	<!-- 添加转运仓 -->
	<div id="addwarehousedlg" class="modal fade" id="myModal" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">

		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">添加转运仓</h4>
				</div>
				<div class="container">
					<form class="form-horizontal" id="myform"  method="post">
						<div class="form-group">
							<label class="col-md-2 control-label">转运仓名：</label>
							<div class="col-md-3 ">
								<input type="text"  id="warehouse_full_name" name="fullName" class="form-control form-control-static" placeholder="请输入转运仓全名">
							</div>
							<label class="control-label"><span id="mid" style="color:red"></span></label>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">国家：</label>
							<div class="col-md-3 ">
								<input type="text" id="warehouse_country"  name="country" class="form-control form-control-static" placeholder="请输入转运仓国家">
							</div>
						</div>


						<div class="form-group">
							<label class="col-md-2 control-label">省/直辖市：</label>
							<div class="col-md-3 ">
								<input type="text" id="warehouse_province"  name="province" class="form-control form-control-static" placeholder="请输入转运仓省/直辖市">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">市/区：</label>
							<div class="col-md-3 ">
								<input type="text" id="warehouse_city" name="city" class="form-control form-control-static" placeholder="请输入收货市/区">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">地址：</label>
							<div class="col-md-3 ">
								<input type="text" id="warehouse_address" name="addressLine" class="form-control form-control-static" placeholder="请输入收货地址">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">邮编：</label>
							<div class="col-md-3 ">
								<input type="text"  id="warehouse_zip"  name="zip" class="form-control form-control-static" placeholder="请输入邮编">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">电话号码：</label>
							<div class="col-md-3 ">
								<input type="text" id="warehouse_phone_number"  name="phoneNumber" class="form-control form-control-static" placeholder="请输入电话号码">
							</div>
						</div>

						<div class="modal-footer col-md-6">
							<!--用来清空表单数据-->
							<input type="reset" name="reset" style="display: none;" />
							<button type="button" class="btn btn-default" onclick="closeAddWarehouseDlg()">关闭</button>
							<button type="button" onclick="saveWarehouse()" class="btn btn-primary">提交</button>
						</div>
					</form>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>



	<!-- 模态框（Modal） -->
	<!-- 修改转运仓 -->
	<div id="updatewarehousedlg" class="modal fade" id="myModal1" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">

		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel1">修改转运仓</h4>
				</div>
				<div class="container">
					<form class="form-horizontal" id="myform1"  method="post">
						<div class="form-group">
							<label class="col-md-2 control-label">转运仓编号：</label>
							<div class="col-md-3 ">
								<input type="text" id="warehouse_id"  name="id" readonly="readonly" class="form-control form-control-static" placeholder="请输入转运仓编号">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">转运仓名：</label>
							<div class="col-md-3 ">
								<input type="text"  id="warehouse_full_name1" name="fullName" class="form-control form-control-static" placeholder="请输入转运仓全名">
							</div>
							<label class="control-label"><span id="mid1" style="color:red"></span></label>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">国家：</label>
							<div class="col-md-3 ">
								<input type="text" id="warehouse_country1"  name="country" class="form-control form-control-static" placeholder="请输入转运仓国家">
							</div>
						</div>


						<div class="form-group">
							<label class="col-md-2 control-label">省/直辖市：</label>
							<div class="col-md-3 ">
								<input type="text" id="warehouse_province1" name="province" class="form-control form-control-static" placeholder="请输入转运仓省/直辖市">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">市/区：</label>
							<div class="col-md-3 ">
								<input type="text" id="warehouse_city1" name="city" class="form-control form-control-static" placeholder="请输入收货市/区">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">地址：</label>
							<div class="col-md-3 ">
								<input type="text" id="warehouse_address1" name="addressLine" class="form-control form-control-static" placeholder="请输入收货地址">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">邮编：</label>
							<div class="col-md-3 ">
								<input type="text"  id="warehouse_zip1"  name="zip" class="form-control form-control-static" placeholder="请输入邮编">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">电话号码：</label>
							<div class="col-md-3 ">
								<input type="text" id="warehouse_phone_number1"  name="phoneNumber" class="form-control form-control-static" placeholder="请输入电话号码">
							</div>
						</div>
						<div class="modal-footer col-md-6">
							<!--用来清空表单数据-->
							<input type="reset" name="reset" style="display: none;" />
							<button type="button" class="btn btn-default" onclick="closeUpdateWarehouseDlg()">关闭</button>
							<button type="button" onclick="updateWarehouse()" class="btn btn-primary">提交</button>
						</div>
					</form>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>

</div>
<div class="layout_footer">
</div>
</body>
</html>