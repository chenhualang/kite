<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>XXXXX有限公司管理后台 - 源码之家</title>

	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" type="text/css" media="screen" />

	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-table.css" />

	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tendina.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>

	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-table-zh-CN.js"></script>
	<script src="${pageContext.request.contextPath}/js/package.js"></script>


</head>
<body>
<!--顶部-->
<div class="layout_top_header">
	<div style="float: left"><span style="font-size: 16px;line-height: 45px;padding-left: 20px;color: #8d8d8d">国际货运物流管理后台</h1></span></div>
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
				<li><a href="myPackage.jsp" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>我的包裹</a></li>
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
		<a href="/kite/index">主页</a><i class="glyph-icon icon-chevron-right"></i>
		<a href="#">我的包裹</a>
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
					<input type="text" class="form-control" id="userCode" name="userCode" placeholder="请输入员工编号">
				</div>
			</div>
			<div class="form-group"  >
				<div class="col-md-2 ">
					<input type="text" class="form-control" id="userName" name="userName" placeholder="请输入员工姓名">
				</div>
			</div>
			<!--/row-->
			<button type="button" onclick="getUserByCon()" class="btn btn-info ">
				<span class="glyphicon glyphicon-search" aria-hidden="true" >  搜索</span></button>

		</form>
	</div>

	<table id="test-table" class="table table-hover table-striped table-condensed table-bordered"></table>

	<!--toolbar  -->
	<div id="toolbar" class="btn-toolbar">
		<button onclick="add()" type="button" class="btn btn-success">
			<span class="glyphicon glyphicon-plus" aria-hidden="true" >添加</span>
		</button>
		<button onclick="ImportExcel()" type="button" class="btn btn-success">
			<span class="glyphicon glyphicon-copy" aria-hidden="true" >导入</span>
		</button>
		<button onclick="ExportExcel()" type="button" class="btn btn-success">
			<span class="glyphicon glyphicon-paste" aria-hidden="true" >导出</span>
		</button>
		<button  type="button" onclick="delMany()" class="btn btn-danger">
			<span class="glyphicon glyphicon-trash" aria-hidden="true">删除</span>
		</button>
	</div>


</div>
<div class="layout_footer">
	<p>Copyright © 2014 - XXXX科技</p>
</div>
</body>
</html>