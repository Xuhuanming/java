<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>信息上传</title>
    <link rel="stylesheet" href="WEB-INF/../assets/css/common.css">
    <link rel="stylesheet" href="WEB-INF/../assets/css/infoUpload.css">
</head>
<body>
    <div class="bg-panel">
        <h4 class="content-title">信息上传</h4>
        <div class="content">
        	<form type="POST" action="UploadFile.do">
	            <div class="info-file">
	                <div class="beaufile">
	                    <input type="file" name="file"  placeholder="点击选择您要上传的文件" onchange="showVal(this)">
	                </div>
	                <span class="file-name">点击上边的框框上传</span>
	            </div>
	            <div class="btn-group">
	                <button class="btn back" onclick="window.history.back()">返回</button>
	                <input class="btn" type="submit" value="上传">
	                <!-- <button class="btn" onclick="uploadComfirm()">上传</button> -->
	            </div>
            </form>
        </div>
    </div>

    <!--确认提示框-->
    <div class="pop-box">
        <div class="bg-panel">
            <div class="btn-group">
                <button class="btn cancle" onclick="boxHide()">取消上传</button>
                <button class="btn">确认上传</button>
            </div>
        </div>
    </div>
</body>
<script src="WEB-INF/../assets/js/common.js"></script>
<script src="WEB-INF/../assets/js/infoUpload.js"></script>
</html>