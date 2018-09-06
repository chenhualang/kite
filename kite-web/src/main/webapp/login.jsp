<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<!-- 引入bootstrap -->
	<link rel="stylesheet" type="text/css" href="static/css/bootstrap.css">
	<!-- 引入JQuery  bootstrap.js-->
	<script src="static/js/jquery-3.1.1.min.js"></script>
	<script src="static/js/bootstrap.js"></script>
	<script type="text/javascript" src="js/WdatePicker.js"></script>
	<script type="text/javascript" src="js/bootstrapValidator.js"></script>
	<script type="text/javascript" src="js/zh_CN.js"></script>
	<link href="css/bootstrapValidator.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="js/layer.js"></script>
	<link href="css/layer.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="js/login.js"></script>
	<style type="text/css">
	body{
	   background: url(images/a.jpg)repeat;
	}
	#login-box {
		/*border:1px solid #F00;*/
		padding: 35px;
		border-radius:15px;
		background: #56666B;
		color: #fff;
	}

	</style>
</head>
<body>
	<div class="container" id="top">
		<div class="row" style="margin-top: 400px; ">
			<div class="col-md-4"></div>
			<div class="col-md-4" id="login-box">
				<form class="form-horizontal" role="form" action="" id="form" method="post">
				  <div class="form-group">
				    <label for="firstname" class="col-sm-3 control-label">用户登录</label>
				    <div class="col-sm-9">
				      <input type="text" class="form-control"  placeholder="请输入账号" name="mailAddress" id="mailAddress">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="lastname" class="col-sm-3 control-label">密码</label>
				    <div class="col-sm-9">
				      <input type="password" class="form-control" placeholder="请输入密码" name="password" id="password">
				    </div>
				  </div>
				  <div class="form-group " style="margin-right: 15px;">
				  <label for="lastname" class="col-sm-4 control-label"></label>
				    <div class="col-sm-4">
				      <button type="button" onclick="doLogin()" class="btn btn-primary btn-info">登录</button>
				    </div>
				    <div class="col-sm-4">
				      <button type="button" onclick="register()" class="btn btn-warning btn-info">注册</button>
				    </div>
				  </div>
				</form>
			</div>
		</div>		
	</div>
	
	
	<!-- 模态框（Modal） -->
<!-- 添加 -->
<div id="mydlg" class="modal fade" id="myModal" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">
   
    <div class="modal-dialog">
        <div class="modal-content">
        
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">账号注册</h4>
            </div>
            <div class="container">
			<form class="form-horizontal" id="myform"  method="post">
			<div class="form-group">
			<label class="col-md-2 control-label">登录账号：</label>
			<div class="col-md-3 ">
			<input type="text" id="mail_address1" name="mailAddress" class="form-control form-control-static" placeholder="请输入账号">
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">登录密码：</label>
			<div class="col-md-3 ">
			<input type="text" id="password1" name="password" class="form-control form-control-static" placeholder="请输入密码">
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">确认密码：</label>
			<div class="col-md-3 ">
			<input type="text" id="againpass1" name="againPasswd" class="form-control form-control-static" placeholder="请输入密码">
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">姓名：</label>
			<div class="col-md-3 ">
			<input type="text" id="nick_name1" name="nickname" class="form-control form-control-static" placeholder="请输入姓名">
			</div>
			</div>
			


 			<div class="form-group">
			<label class="col-md-2 control-label">电话：</label>
			<div class="col-md-3 ">
			<input type="text" id="cellphone1" name="cellphone" class="form-control form-control-static" placeholder="请输入电话">
			</div>
			</div>
			
            <div class="modal-footer col-md-6">
            <!--用来清空表单数据-->
            <input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="closedlg()">关闭</button>
               <button type="button" onclick="regAccountInfo()" class="btn btn-primary">提交</button>
            </div>
            </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div> 
</body>
</html>