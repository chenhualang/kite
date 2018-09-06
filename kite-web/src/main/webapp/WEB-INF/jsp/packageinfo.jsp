<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="../../core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>国际物流包裹后台管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="${pageContext.request.contextPath}/js/packageinfo.js"></script>
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
					<input type="text" class="form-control" id="merchantLogisticsNo" name="merchantLogisticsNo" placeholder="请输入商家物流单号">
				</div>
			</div>
			<div class="form-group"  >
				<div class="col-md-2 ">
					<input type="text" class="form-control" id="orderNo" name="orderNo" placeholder="请输入订单号">
				</div>
			</div>
			<div class="form-group"  >
				<div class="col-md-2 ">
					<input type="text" class="form-control" id="packageStatus" name="packageStatus" placeholder="订单状态">
				</div>
			</div>
			<!--/row-->
			<button type="button" onclick="getPackageInfoByCon()" class="btn btn-info ">
				<span class="glyphicon glyphicon-search" aria-hidden="true" >  搜索</span></button>
			<button type="button" onclick="resetCondition()" class="btn btn-info ">
				<span class="glyphicon glyphicon-search" aria-hidden="true" >重置</span></button>
		</form>
	</div>
</div>


	<table id="packageinfo-table" class="table table-hover table-striped table-condensed table-bordered"></table>

	<!--toolbar  -->
	<div id="toolbar" class="btn-toolbar">
		<button onclick="openPackageInfoDlg()" type="button" class="btn btn-success">
			<span class="glyphicon glyphicon-plus" aria-hidden="true" >添加</span>
		</button>
		<button onclick="ImportExcel()" type="button" class="btn btn-success">
			<span class="glyphicon glyphicon-copy" aria-hidden="true" >导入</span>
		</button>
		<button onclick="ExportExcel()" type="button" class="btn btn-success">
			<span class="glyphicon glyphicon-paste" aria-hidden="true" >导出</span>
		</button>
		<button  type="button" onclick="delManyPackageInfos()" class="btn btn-danger">
			<span class="glyphicon glyphicon-trash" aria-hidden="true">删除</span>
		</button>
	</div>


	<!-- 模态框（Modal） -->
	<!-- 添加订单 -->
	<div id="addpackagedlg" class="modal fade" id="myModal" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">

		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">添加订单信息</h4>
				</div>
				<div class="container">
					<form class="form-horizontal" id="myform"  method="post">
						<div class="form-group">
							<label class="col-md-2 control-label">用户名：</label>
							<div class="col-md-3 ">
								<input type="text" id="user_name" name="userName" class="form-control form-control-static" placeholder="请输入用户名">
							</div>
							<label class="control-label"><span id="mid" style="color:red"></span></label>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">商家物流单号：</label>
							<div class="col-md-3 ">
								<input type="text" id="merchant_logistics_no"  name="merchantLogisticsNo" class="form-control form-control-static" placeholder="请输入商家物流单号">
							</div>
						</div>


						<div class="form-group">
							<label class="col-md-2 control-label">转运仓：</label>
							<div class="col-md-3 ">
								<input type="text" id="warehouse_no"  name="warehouseNo" class="form-control form-control-static" placeholder="请输入转运仓">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">收货省/直辖市：</label>
							<div class="col-md-3 ">
								<input type="text" id="province" name="province" class="form-control form-control-static" placeholder="请输入收货省/直辖市">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">收货市/区：</label>
							<div class="col-md-3 ">
								<input type="text" id="city" name="city" class="form-control form-control-static" placeholder="请输入收货市/区">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">收货地址：</label>
							<div class="col-md-3 ">
								<input type="text" id="address"  name="address" class="form-control form-control-static" placeholder="请输入收货地址">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">订单状态：</label>
							<div class="col-md-3 ">
								<input type="text"  id="status"  onclick="WdatePicker()"  name="status" class="form-control form-control-static" placeholder="请输入订单状态">
							</div>
						</div>

						<div class="modal-footer col-md-6">
							<!--用来清空表单数据-->
							<input type="reset" name="reset" style="display: none;" />
							<button type="button" class="btn btn-default" onclick="closeAddPackageInfoDlg()">关闭</button>
							<button type="button" onclick="savePackageInfo()" class="btn btn-primary">提交</button>
						</div>
					</form>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>



	<!-- 模态框（Modal） -->
	<!-- 修改订单 -->
	<div id="updatepackagedlg" class="modal fade" id="myModal1" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">

		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel1">修改订单信息</h4>
				</div>
				<div class="container">
					<form class="form-horizontal" id="myform1"  method="post">
						<div class="form-group">
							<label class="col-md-2 control-label">包裹编号：</label>
							<div class="col-md-3 ">
								<input type="text" id="packageinfo_id"  name="id" readonly="readonly" class="form-control form-control-static" placeholder="请输入包裹编号">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">用户名：</label>
							<div class="col-md-3 ">
								<input type="text"  id="user_name1" name="userName" class="form-control form-control-static" placeholder="请输入用户名">
							</div>
							<label class="control-label"><span id="mid1" style="color:red"></span></label>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">商家物流单号：</label>
							<div class="col-md-3 ">
								<input type="text" id="merchant_logistics_no1"  name="merchantLogisticsNo" class="form-control form-control-static" placeholder="请输入商家物流单号">
							</div>
						</div>


						<div class="form-group">
							<label class="col-md-2 control-label">转运仓：</label>
							<div class="col-md-3 ">
								<input type="text" id="warehouse_no1"  name="warehouseNo" class="form-control form-control-static" placeholder="请输入转运仓">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">收货省/直辖市：</label>
							<div class="col-md-3 ">
								<input type="text" id="province1" name="province" class="form-control form-control-static" placeholder="请输入收货省/直辖市">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">收货市/区：</label>
							<div class="col-md-3 ">
								<input type="text" id="city1" name="city" class="form-control form-control-static" placeholder="请输入收货市/区">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">收货地址：</label>
							<div class="col-md-3 ">
								<input type="text" id="address1"  name="address" class="form-control form-control-static" placeholder="请输入收货地址">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">订单状态：</label>
							<div class="col-md-3 ">
								<input type="text"  id="status1"  name="status" class="form-control form-control-static" placeholder="请输入订单状态">
							</div>
						</div>
						<div class="modal-footer col-md-6">
							<!--用来清空表单数据-->
							<input type="reset" name="reset" style="display: none;" />
							<button type="button" class="btn btn-default" onclick="closeUpdatePackageInfoDlg()">关闭</button>
							<button type="button" onclick="updatePackageInfo()" class="btn btn-primary">提交</button>
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