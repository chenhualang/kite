<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>国际物流中转仓后台管理</title>

	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" type="text/css" media="screen" />

	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/cssbootstrap.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/cssbootstrap-table.css" />

	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tendina.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>

	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-table-zh-CN.js"></script>
	<script src=".${pageContext.request.contextPath}/js/commodity.js"></script>


</head>
<body>
<!--顶部-->
<div class="layout_top_header">
	<div style="float: left"><span style="font-size: 16px;line-height: 45px;padding-left: 20px;color: #8d8d8d">国际物流中转仓后台管理</h1></span></div>
	<div id="ad_setting" class="ad_setting">
		<a class="ad_setting_a" href="javascript:; ">
			<i class="icon-user glyph-icon" style="font-size: 20px"></i>
			<span>管理员</span>
			<i class="icon-chevron-down glyph-icon"></i>
		</a>
		<ul class="dropdown-menu-uu" style="display: none" id="ad_setting_ul">
			<li class="ad_setting_ul_li"> <a href="javascript:;"><i class="icon-user glyph-icon"></i> 个人中心 </a> </li>
			<li class="ad_setting_ul_li"> <a href="javascript:;"><i class="icon-cog glyph-icon"></i> 设置 </a> </li>
			<li class="ad_setting_ul_li"> <a href="javascript:;"><i class="icon-signout glyph-icon"></i> <span class="font-bold">退出</span> </a> </li>
		</ul>
	</div>
</div>
<!--顶部结束-->
<!--菜单-->
<div class="layout_left_menu">
	<ul id="menu">
		<li class="childUlLi">
			<a href="main.html"  target="menuFrame"><i class="glyph-icon icon-home"></i>首页</a>
			<ul>
				<li><a href="packageinfo.jsp" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>我的包裹</a></li>
			</ul>
		</li>
		<li class="childUlLi">
			<a href="user.html"  target="menuFrame"> <i class="glyph-icon icon-reorder"></i>成员管理</a>
			<ul>
				<li><a href="#"><i class="glyph-icon icon-chevron-right"></i>后台菜单管理</a></li>
				<li><a href="#"><i class="glyph-icon icon-chevron-right"></i>展示商品管理</a></li>
				<li><a href="#"><i class="glyph-icon icon-chevron-right"></i>数据管理</a></li>
			</ul>
		</li>
		<li class="childUlLi">
			<a href="role.html" target="menuFrame"> <i class="glyph-icon icon-reorder"></i>角色管理</a>
			<ul>
				<li><a href="#"><i class="glyph-icon icon-chevron-right"></i>修改密码</a></li>
				<li><a href="#"><i class="glyph-icon icon-chevron-right"></i>帮助</a></li>
			</ul>
		</li>
		<li class="childUlLi">
			<a href="#"> <i class="glyph-icon  icon-location-arrow"></i>菜单管理</a>
			<ul>
				<li><a href="meunbox.html" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>平台菜单</a></li>
				<li><a href="meunbox_add.html" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>运行商菜单</a></li>
				<li><a href="#" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>服务站菜单</a></li>
				<li><a href="#" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>商家菜单</a></li>
			</ul>
		</li>
	</ul>
</div>
<!--菜单-->
<div id="layout_right_content" class="layout_right_content">

	<div class="route_bg">
		<a href="#">主页</a><i class="glyph-icon icon-chevron-right"></i>
		<a href="#">菜单管理</a>
	</div>

	<!--<div class="mian_content">-->
		<!--<div id="page_content">-->
			<!--<iframe id="menuFrame" name="menuFrame" src="main.html" style="overflow:visible;"-->
					<!--scrolling="yes" frameborder="no" width="100%" height="100%"></iframe>-->
		<!--</div>-->
	<!--</div>-->

	<!--查询条件-->
	<div class="portlet-body form">
		<form action="#" class="form-horizontal">
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
					<input type="text" class="form-control" id="unitPrice" name="unitPrice" placeholder="请输入商品单价">
				</div>
			</div>
			<!--/row-->
			<button type="button" onclick="getCommodityByCon()" class="btn btn-info ">
				<span class="glyphicon glyphicon-search" aria-hidden="true" >  搜索</span></button>
			<button type="button" onclick="resetCondition()" class="btn btn-info ">
				<span class="glyphicon glyphicon-search" aria-hidden="true" >重置</span></button>
		</form>
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
								<input type="text" onblur="validAccount()" id="commodity_kind" name="commodity_kind" class="form-control form-control-static" placeholder="请输入类别">
							</div>
							<label class="control-label"><span id="mid" style="color:red"></span></label>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">品牌：</label>
							<div class="col-md-3 ">
								<input type="text" id="commodity_brand"  name="commodity_brand" class="form-control form-control-static" placeholder="请输入品牌">
							</div>
						</div>


						<div class="form-group">
							<label class="col-md-2 control-label">商品名称：</label>
							<div class="col-md-3 ">
								<input type="password" id="commodity_name" onblur="clearPass()" name="commodity_name" class="form-control form-control-static" placeholder="请输入商品名称">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">商品size：</label>
							<div class="col-md-3 ">
								<input type="password" id="commodity_size" name="commodity_size" class="form-control form-control-static" placeholder="请输入商品size">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">数量：</label>
							<div class="col-md-3 ">
								<input type="password" id="commodity_count" name="commodity_count" class="form-control form-control-static" placeholder="请输入数量">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">单价：</label>
							<div class="col-md-3 ">
								<input type="text" id="commodity_unit_price"  name="commodity_unit_price" class="form-control form-control-static" placeholder="请输入单价">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">总价：</label>
							<div class="col-md-3 ">
								<input type="text" id="commodity_total_price"  name="commodity_total_price" class="form-control form-control-static" placeholder="请输入总价">
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
							<label class="col-md-2 control-label">类别：</label>
							<div class="col-md-3 ">
								<input type="text" onblur="validAccount()" id="commodity_kind1" name="commodity_kind1" class="form-control form-control-static" placeholder="请输入类别">
							</div>
							<label class="control-label"><span id="mid1" style="color:red"></span></label>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">品牌：</label>
							<div class="col-md-3 ">
								<input type="text" id="commodity_brand1"  name="commodity_brand1" class="form-control form-control-static" placeholder="请输入品牌">
							</div>
						</div>


						<div class="form-group">
							<label class="col-md-2 control-label">商品名称：</label>
							<div class="col-md-3 ">
								<input type="password" id="commodity_name1" onblur="clearPass()" name="commodity_name1" class="form-control form-control-static" placeholder="请输入商品名称">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">商品size：</label>
							<div class="col-md-3 ">
								<input type="password" id="commodity_size1" name="commodity_size1" class="form-control form-control-static" placeholder="请输入商品size">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">数量：</label>
							<div class="col-md-3 ">
								<input type="password" id="commodity_count1" name="commodity_count1" class="form-control form-control-static" placeholder="请输入数量">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">单价：</label>
							<div class="col-md-3 ">
								<input type="text" id="commodity_unit_price1"  name="commodity_unit_price1" class="form-control form-control-static" placeholder="请输入单价">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label">总价：</label>
							<div class="col-md-3 ">
								<input type="text" id="commodity_total_price1"  name="commodity_total_price1" class="form-control form-control-static" placeholder="请输入总价">
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
	<p>Copyright © 2014 - XXXX科技</p>
</div>
</body>
</html>