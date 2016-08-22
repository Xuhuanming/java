<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户信息修改</title>
    <link rel="stylesheet" href="WEB-INF/../assets/css/common.css">
    <link rel="stylesheet" href="WEB-INF/../assets/css/userAlter.css">
</head>
<body>
    <div class="bg-panel">
        <h4 class="content-title">信息修改</h4>
        <div class="content">
            <div class="info-input username">
                <label>用户名:</label>
                <input type="text" name="username" placeholder="请输入您的用户名" readonly value="${user1.username}" onfocus="clearNote(this)"><b>*</b><span></span>
            </div>
            <div class="info-input useremail">
                <label>邮箱:</label>
                <input type="text" name="useremail" placeholder="请输入您常用的邮箱" value="${user1.email}" onblur="checkEmail(this)" onfocus="clearNote(this)"><b>*</b><span></span>
            </div>
            <div class="info-input userpwd">
                <label>密码:</label>
                <input type="password" name="userpwd" placeholder="请输入您的密码" value="${user1.password}" onblur="checkUserpwd(this)" onfocus="clearNote(this)"><b>*</b><span></span>
            </div>
            <div class="info-input userpwd2">
                <label>确认密码:</label>
                <input type="password" name="userpwd2" placeholder="请再次密码" value="" onblur="checkUserpwd(this)" onfocus="clearNote(this)"><b>*</b><span></span>
            </div>
        </div>
        <div class="btn-group">
            <a href="javascript:window.history.back()">
                <button class="btn back">返回</button>
            </a>
            <!-- <a href="ViewDispacher"> -->
            <a href="javascript:void(0)">
          		  <button class="btn confirm" onclick="confirm()">确认</button>
             </a>
        </div>
    </div>
</body>
<script src="WEB-INF/../assets/js/common.js"></script>
<script src="WEB-INF/../assets/js/userAlter.js"></script>
</html>