/**
 * Created by wangdong on 2016/7/8.
 */

/*用户名获取焦点*/
var username = document.querySelector("input[name=username]");
username.focus();

var useremail = document.querySelector("input[name=useremail]");
var userpwd = document.querySelector("input[name=userpwd]");
var userpwd2 = document.querySelector("input[name=userpwd2]");

function checkRegister(){

    if(username.value==""){
        username.parentNode.querySelector("b+span").innerText = "用户名不能为空";
        return false;
    }


    if(useremail.value==""){
        useremail.parentNode.querySelector("b+span").innerText = "邮箱不能为空";
        return false;
    }else if(useremail.value!=""){
        var emailFlag =  checkEmail(useremail);
        console.log(emailFlag);
    }


    if(userpwd.value==""){
        userpwd.parentNode.querySelector("b+span").innerText = "密码不能为空";
        return false;
    }else if(userpwd.value!=""){
        var pwd1Flag =  checkUserpwd(userpwd);
        console.log(pwd1Flag);
    }


    if(userpwd2.value==""){
        userpwd2.parentNode.querySelector("b+span").innerText = "密码不能为空";
        return false;
    }else if(userpwd2.value!=""){
       var pwd2Flag = checkUserpwd(userpwd2);
       console.log(pwd2Flag);
    }


    if(userpwd.value!=userpwd2.value){
        userpwd2.parentNode.querySelector("b+span").innerText = "密码不一致";
        return false;
    }else{
        if(emailFlag==true&&pwd1Flag==true&&pwd2Flag==true){
        	loadAjax(
                "POST",
                "RegisterServlet?username="+username.value+"&useremail="+useremail.value+"&userpwd="+userpwd.value,
                function(str){
                    if(str=="true"){
                    	showModifyMessage("注册成功");
                    	setTimeout(function(){
                        	window.location.href="ViewDispacher?command=login";
                    	}, 2000);
                    }else if(str=="false"){
                    	showModifyMessage("注册失败");
                    }
                },
                function(str){
                	console.log(str);
                    showModifyMessage("网络连接失败");
                }
            )
        }
        
    }
    
    
}


