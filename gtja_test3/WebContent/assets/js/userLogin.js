/**
 * Created by wangdong on 2016/7/8.
 */


var username = document.querySelector("input[name=username]");
username.focus();

function checkLogin(){
    var username = document.querySelector("input[name=username]");
    var userpwd = document.querySelector("input[name=userpwd]");

    if(username.value==""){
        username.parentNode.querySelector("b+span").innerText = "用户名不能为空";
        return false;
    }
    if(userpwd.value==""){
        userpwd.parentNode.querySelector("b+span").innerText = "密码不能为空";
        return false;
    }else if(userpwd.value!=""){
        var flag = checkUserpwd(userpwd);
        if(flag==true){
        	loadAjax(
                "POST",
                "LoginServlet?username="+username.value+"&userpwd="+userpwd.value,
                function(str){
                	if(str=="true"){
                		window.location.href="ViewDispacher?command=userInfo";
                	}else if(str=="false"){
//                		showModifyMessage("登录失败");
//                		return false;
                	}
                },
                function(str){
                    showModifyMessage(str);
                }
            )
        }
        
    }
    
}