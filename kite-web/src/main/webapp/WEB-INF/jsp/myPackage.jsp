<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>国际物流包裹后台管理</title>
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
		<button onclick="openDlg()" type="button" class="btn btn-success">
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

    <!-- 模态框（Modal） -->
    <!-- 修改用户 -->
    <div id="mydlg1" class="modal fade" id="myModal" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">

        <div class="modal-dialog">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">修改用户</h4>
                </div>
                <div class="container">
                    <form class="form-horizontal" id="myform1"  method="post">

                        <div class="form-group">
                            <label class="col-md-2 control-label">用户编号：</label>
                            <div class="col-md-3 ">
                                <input type="text" id="user_id1" readonly="readonly"  name="user_id" class="form-control form-control-static" placeholder="请输入用户编号">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 control-label">登录账号：</label>
                            <div class="col-md-3 ">
                                <input type="text" disabled="disabled" id="user_account1" name="user_account" class="form-control form-control-static" placeholder="请输入登陆账号">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 control-label">用户姓名：</label>
                            <div class="col-md-3 ">
                                <input type="text" id="user_name1"  name="user_name" class="form-control form-control-static" placeholder="请输入用户姓名">
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-md-2 control-label">用户密码：</label>
                            <div class="col-md-3 ">
                                <input type="text" id="user_password1"  disabled="disabled" name="user_password" class="form-control form-control-static" placeholder="请输入密码">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 control-label">用户性别：</label>
                            <div class="col-md-3">
                                &nbsp;&nbsp;&nbsp;
                                <input type="radio" id="nan1" checked name="user_sex" value="男">男&nbsp;&nbsp;
                                <input type="radio" id="nv1" name="user_sex"  value="女">女
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 control-label">年龄：</label>
                            <div class="col-md-3 ">
                                <input type="text" id="user_age1"  name="user_age" class="form-control form-control-static" placeholder="请输入年龄">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 control-label">出生日期：</label>
                            <div class="col-md-3 ">
                                <input type="text"  id="user_birth1"  onclick="WdatePicker()"  name="user_birth" class="form-control form-control-static" placeholder="请输入出生日期">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 control-label">联系电话：</label>
                            <div class="col-md-3 ">
                                <input type="text" id="user_phone1" name="user_phone" class="form-control form-control-static" placeholder="请输入联系电话">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 control-label">Email：</label>
                            <div class="col-md-3 ">
                                <input type="text" id="email1" name="email" class="form-control form-control-static" placeholder="请输入Email">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 control-label">所属部门：</label>
                            <div class="col-md-3 ">
                                <select id="sid1"  name="dept_id" class="form-control form-control-static" placeholder="请输入Email">

                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 control-label">联系地址：</label>
                            <div class="col-md-3">
                                <textarea rows="3" id="user_address1" name="user_address" cols="32" class="form-control form-control-static" placeholder="请输入联系地址"></textarea>
                            </div>
                        </div>
                        <div class="modal-footer col-md-6">
                            <!--用来清空表单数据-->
                            <input type="reset" name="reset" style="display: none;" />
                            <button type="button" class="btn btn-default" onclick="closeDlg()">关闭</button>
                            <button type="button" onclick="upUser()" class="btn btn-primary">提交</button>
                        </div>
                    </form>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

    <!-- 模态框（Modal） -->
    <!-- 添加用户 -->
    <div id="mydlg" class="modal fade" id="myModal" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">

        <div class="modal-dialog">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">添加用户</h4>
                </div>
                <div class="container">
                    <form class="form-horizontal" id="myform"  method="post">
                        <div class="form-group">
                            <label class="col-md-2 control-label">登录账号：</label>
                            <div class="col-md-3 ">
                                <input type="text" onblur="validAccount()" id="user_account" name="user_account" class="form-control form-control-static" placeholder="请输入登陆账号">
                            </div>
                            <label class="control-label"><span id="mid" style="color:red"></span></label>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 control-label">用户姓名：</label>
                            <div class="col-md-3 ">
                                <input type="text" id="user_name"  name="user_name" class="form-control form-control-static" placeholder="请输入用户姓名">
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-md-2 control-label">用户密码：</label>
                            <div class="col-md-3 ">
                                <input type="password" id="user_password" onblur="clearPass()" name="user_password" class="form-control form-control-static" placeholder="请输入密码">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 control-label">确认密码：</label>
                            <div class="col-md-3 ">
                                <input type="password" id="againpass" name="againpass" class="form-control form-control-static" placeholder="请输入密码">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 control-label">用户性别：</label>
                            <div class="col-md-3">
                                &nbsp;&nbsp;&nbsp;
                                <input type="radio" id="nan" checked name="user_sex" value="男">男&nbsp;&nbsp;
                                <input type="radio" id="nv" name="user_sex"  value="女">女
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 control-label">年龄：</label>
                            <div class="col-md-3 ">
                                <input type="text" id="user_age"  name="user_age" class="form-control form-control-static" placeholder="请输入年龄">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 control-label">出生日期：</label>
                            <div class="col-md-3 ">
                                <input type="text"  id="user_birth"  onclick="WdatePicker()"  name="user_birth" class="form-control form-control-static" placeholder="请输入出生日期">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 control-label">联系电话：</label>
                            <div class="col-md-3 ">
                                <input type="text" id="user_phone" name="user_phone" class="form-control form-control-static" placeholder="请输入联系电话">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 control-label">Email：</label>
                            <div class="col-md-3 ">
                                <input type="text" id="email" name="email" class="form-control form-control-static" placeholder="请输入Email">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 control-label">所属部门：</label>
                            <div class="col-md-3 ">
                                <select id="sid"  name="dept_id" class="form-control form-control-static" > </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 control-label">联系地址：</label>
                            <div class="col-md-3">
                                <textarea rows="3" id="user_address" name="user_address" cols="32" class="form-control form-control-static" placeholder="请输入联系地址"></textarea>
                            </div>
                        </div>
                        <div class="modal-footer col-md-6">
                            <!--用来清空表单数据-->
                            <input type="reset" name="reset" style="display: none;" />
                            <button type="button" class="btn btn-default" onclick="closeDlg()">关闭</button>
                            <button type="button" onclick="saveUser()" class="btn btn-primary">提交</button>
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