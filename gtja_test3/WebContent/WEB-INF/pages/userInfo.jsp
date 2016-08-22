<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <title>用户信息</title>
    <link rel="stylesheet" href="WEB-INF/../assets/css/common.css">
    <link rel="stylesheet" href="WEB-INF/../assets/css/userInfo.css">
</head>
<body>
    <div class="bg-panel">
        <!--标题-->
        <h4 class="content-title">用户信息</h4>
        <table>
            <thead>
                <tr>
                    <th>用户信息</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <p>${user.username}</p>
                        <p>${user.email}</p>
                    </td>
                    <td>
                        <a href="ToAlterUserpage.do?username=${user.username}">
                            <button class="btn infoAlter">修改</button>
                        </a>
                        <a href="ViewDispacher?command=upload">
                            <button class="btn infoUpload">上传</button>
                        </a>
                        <button class="btn" onclick="download()">下载</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
    <!--确认提示框-->
    <div class="pop-box">
        <div class="bg-panel">
            <div class="btn-group">
                <button class="btn cancle" onclick="boxHide()">取消下载</button>
                <a href="DownloadServlet.do">
               		 <button class="btn">确认下载</button>
                </a>
            </div>
        </div>
    </div>
</body>
<script src="WEB-INF/../assets/js/common.js"></script>
<script src="WEB-INF/../assets/js/userInfo.js"></script>
</html>