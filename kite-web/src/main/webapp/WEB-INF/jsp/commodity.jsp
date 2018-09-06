<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="../../core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>国际物流商品信息后台管理</title>
	<script src="${pageContext.request.contextPath}/js/commodity.js"></script>
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
						<input type="text" class="form-control" id="kind" name="kind" placeholder="请输入商品类别">
					</div>
				</div>
				<div class="form-group"  >
					<div class="col-md-2 ">
						<input type="text" class="form-control" id="brand" name="brand" placeholder="请输入商品品牌">
					</div>
				</div>
				<div class="form-group"  >
					<div class="col-md-2 ">
						<input type="text" class="form-control" id="name" name="name" placeholder="请输入商品名称">
					</div>
				</div>
				<div class="form-group"  >
					<div class="col-md-2 ">
						<input type="text" class="form-control" id="merchantLogisticsNo" name="merchantLogisticsNo" placeholder="请输入商家物流单号">
					</div>
				</div>

				<button type="button" onclick="getCommodityByCon()" class="btn btn-info ">
					<span class="glyphicon glyphicon-search" aria-hidden="true" >  搜索</span></button>
				<button type="button" onclick="resetCondition()" class="btn btn-info ">
					<span class="glyphicon glyphicon-search" aria-hidden="true" >重置</span></button>
			</form>
		</div>
	</div>


	<table id="commodity-table" class="table table-hover table-striped table-condensed table-bordered"></table>

	<!--toolbar  -->
	<div id="toolbar" class="btn-toolbar">
		<button onclick="openCommodityDlg()" type="button" class="btn btn-success">
			<span class="glyphicon glyphicon-plus" aria-hidden="true" >添加</span>
		</button>
		<button onclick="ImportExcel()" type="button" class="btn btn-success">
			<span class="glyphicon glyphicon-copy" aria-hidden="true" >导入</span>
		</button>
		<button onclick="ExportExcel()" type="button" class="btn btn-success">
			<span class="glyphicon glyphicon-paste" aria-hidden="true" >导出</span>
		</button>
		<button  type="button" onclick="delManyCommodities()" class="btn btn-danger">
			<span class="glyphicon glyphicon-trash" aria-hidden="true">删除</span>
		</button>
	</div>


	<!-- 模态框（Modal） -->
	<!-- 添加订单 -->
	<div id="addcommoditydlg" class="modal fade" id="myModal" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">

		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">添加订单商品信息</h4>
				</div>
				<div class="container">
					<form class="form-horizontal" id="myform"  method="post">
						<div class="form-group">
							<label class="col-md-2 control-label">类别：</label>
							<div class="col-md-3 ">
								<input type="text" id="commodity_kind" name="kind" class="form-control form-control-static" placeholder="请输入类别">
							</div>
							<label class="control-label"><span id="mid" style="color:red"></span></label>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">品牌：</label>
							<div class="col-md-3 ">
								<input type="text" id="commodity_brand"  name="brand" class="form-control form-control-static" placeholder="请输入品牌">
							</div>
						</div>


						<div class="form-group">
							<label class="col-md-2 control-label">商品名称：</label>
							<div class="col-md-3 ">
								<input type="text" id="commodity_name"  name="name" class="form-control form-control-static" placeholder="请输入商品名称">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">商品size：</label>
							<div class="col-md-3 ">
								<input type="text" id="commodity_size" name="size" class="form-control form-control-static" placeholder="请输入商品size">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">数量：</label>
							<div class="col-md-3 ">
								<input type="text" id="commodity_count" name="count" class="form-control form-control-static" placeholder="请输入数量">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">商家物流单号：</label>
							<div class="col-md-3 ">
								<input type="text" id="merchant_logistics_no"  name="merchantLogisticsNo" class="form-control form-control-static" placeholder="请输入单价">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">单价：</label>
							<div class="col-md-3 ">
								<input type="text" id="commodity_unit_price"  name="unitPrice" class="form-control form-control-static" placeholder="请输入单价">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">总价：</label>
							<div class="col-md-3 ">
								<input type="text" id="commodity_total_price"  name="totalPrice" class="form-control form-control-static" placeholder="请输入总价">
							</div>
						</div>

						<div class="modal-footer col-md-6">
							<!--用来清空表单数据-->
							<input type="reset" name="reset" style="display: none;" />
							<button type="button" class="btn btn-default" onclick="closeAddCommodityDlg()">关闭</button>
							<button type="button" onclick="saveCommodity()" class="btn btn-primary">提交</button>
						</div>
					</form>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>



	<!-- 模态框（Modal） -->
	<!-- 修改订单 -->
	<div id="updatecommoditydlg" class="modal fade" id="myModal1" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">

		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel1">修改商品信息</h4>
				</div>
				<div class="container">
					<form class="form-horizontal" id="myform1"  method="post">
						<div class="form-group">
							<label class="col-md-2 control-label">商品编号：</label>
							<div class="col-md-3 ">
								<input type="text"  id="commodity_id" name="id" readonly="readonly" class="form-control form-control-static" placeholder="请输入商品编号">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">类别：</label>
							<div class="col-md-3 ">
								<input type="text"  id="commodity_kind1" name="kind" class="form-control form-control-static" placeholder="请输入类别">
							</div>
							<label class="control-label"><span id="mid1" style="color:red"></span></label>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">品牌：</label>
							<div class="col-md-3 ">
								<input type="text" id="commodity_brand1"  name="brand" class="form-control form-control-static" placeholder="请输入品牌">
							</div>
						</div>


						<div class="form-group">
							<label class="col-md-2 control-label">商品名称：</label>
							<div class="col-md-3 ">
								<input type="text" id="commodity_name1"  name="name" class="form-control form-control-static" placeholder="请输入商品名称">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">商品size：</label>
							<div class="col-md-3 ">
								<input type="text" id="commodity_size1" name="size" class="form-control form-control-static" placeholder="请输入商品size">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">数量：</label>
							<div class="col-md-3 ">
								<input type="text" id="commodity_count1" name="count" class="form-control form-control-static" placeholder="请输入数量">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">商家物流单号：</label>
							<div class="col-md-3 ">
								<input type="text" id="merchant_logistics_no1"  name="merchantLogisticsNo" class="form-control form-control-static" placeholder="请输入单价">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">单价：</label>
							<div class="col-md-3 ">
								<input type="text" id="commodity_unit_price1"  name="unitPrice" class="form-control form-control-static" placeholder="请输入单价">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">总价：</label>
							<div class="col-md-3 ">
								<input type="text" id="commodity_total_price1"  name="totalPrice" class="form-control form-control-static" placeholder="请输入总价">
							</div>
						</div>
						<div class="modal-footer col-md-6">
							<!--用来清空表单数据-->
							<input type="reset" name="reset" style="display: none;" />
							<button type="button" class="btn btn-default" onclick="closeUpdatePackageInfoDlg()">关闭</button>
							<button type="button" onclick="updateCommodity()" class="btn btn-primary">提交</button>
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