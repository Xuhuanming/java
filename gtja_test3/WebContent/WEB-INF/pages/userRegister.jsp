<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户注册</title>
    <link rel="stylesheet" href="WEB-INF/../assets/css/common.css">
    <link rel="stylesheet" href="WEB-INF/../assets/css/userRegister.css">
</head>
<body>
    <div class="bg-panel">
        <!--标题-->
        <h4 class="content-title">用户注册</h4>
        <!--输入内容-->
        <div class="content">
            <div class="info-input username">
                <label>用户名:</label>
                <input type="text" name="username" placeholder="请输入您的用户名" onfocus="clearNote(this)"><b>*</b><span></span>
            </div>
            <div class="info-input useremail">
                <label>邮箱:</label>
                <input type="text" name="useremail" placeholder="请输入您常用的邮箱" onblur="checkEmail(this)" onfocus="clearNote(this)"><b>*</b><span></span>
            </div>
            <div class="info-input userpwd">
                <label>密码:</label>
                <input type="password" name="userpwd" placeholder="请输入您的密码" onblur="checkUserpwd(this)" onfocus="clearNote(this)"><b>*</b><span></span>
            </div>
            <div class="info-input userpwd2">
                <label>确认密码:</label>
                <input type="password" name="userpwd2" placeholder="请再次密码" onblur="checkUserpwd(this)" onfocus="clearNote(this)"><b>*</b><span></span>
            </div>
        </div>
        <div class="btn-group">
        	<a href="javascript:void(0)">
        		<button class="btn cancle" onclick="window.history.back()">返回</button>
        	</a>
            <a href="javascript:void(0)">
                <button class="btn login" onclick="checkRegister()">注册</button>
            </a>
        </div>
    </div>
</body>
<script src="WEB-INF/../assets/js/common.js"></script>
<script src="WEB-INF/../assets/js/userRegister.js"></script>
</html>