/**
 * Created by wangdong on 2016/7/8.
 */
var popBox = document.querySelector(".pop-box");
var file = document.querySelector("input[name=file]");
function showVal(obj){
    console.log(obj.value);
    var filename = document.querySelector(".file-name");
    filename.innerText = obj.value;
}

function uploadComfirm(){
    if(file.value==""){
        console.log("----111111-------");
        showModifyMessage("什么都没选，你传个毛");
        return false;
    }else{
        popBox.style.display="block";
    }
}
function uploadSure(){
	loadAjax(
        "POST",
        "UploadFile.do?file="+file.value,
        function(str){
        	if(str=="true"){
        		showModifyMessage("上传成功");
        		window.location.href="ViewDispacher?command=userInfo";
        	}else if(str=="false"){
            		showModifyMessage("上传失败");
        	}
        },
        function(str){
            showModifyMessage(str);
        }
    )
}

