/**
 * Created by wangdong on 2016/7/8.
 */


/*获取原来的信息*/
var useremailBackVal = document.querySelector("input[name=useremail]").value;
var userpwdBackVal = document.querySelector("input[name=userpwd]").value;
//var userpwd2BackVal = document.querySelector("input[name=userpwd2]").value;

function confirm(){
    /*获得当前的信息*/
    var useremail = document.querySelector("input[name=useremail]");
    var username = document.querySelector("input[name=username]");
    var userpwd = document.querySelector("input[name=userpwd]");
    var userpwd2 = document.querySelector("input[name=userpwd2]");
    /*判断前后信息是否改变*/
    if(useremailBackVal==useremail.value&&userpwdBackVal==userpwd.value){
        showModifyMessage("你闹着玩是吧，你什么都没改");
        stopDefault(this);
        return false;
    }else{
        /*内容有修改，调用userRegister.js的checkLogin()方法*/

        if(useremail.value==""){
            useremail.parentNode.querySelector("b+span").innerText = "邮箱不能为空";
            stopDefault(this);
            return false;
        }else if(useremail.value!=""){
            var emailFlag =  checkEmail(useremail);
            console.log(emailFlag);
        }


        if(userpwd.value==""){
            userpwd.parentNode.querySelector("b+span").innerText = "密码不能为空";
            stopDefault(this);
            return false;
        }else if(userpwd.value!=""){
            var pwd1Flag =  checkUserpwd(userpwd);
            console.log(pwd1Flag);
        }


        if(userpwd2.value==""){
            userpwd2.parentNode.querySelector("b+span").innerText = "密码不能为空";
            stopDefault(this);
            return false;
        }else if(userpwd2.value!=""){
           var pwd2Flag = checkUserpwd(userpwd2);
           console.log(pwd2Flag);
        }


        if(userpwd.value!=userpwd2.value){
            userpwd2.parentNode.querySelector("b+span").innerText = "密码不一致";
            stopDefault(this);
            return false;
        }else{
            if(emailFlag==true&&pwd1Flag==true&&pwd2Flag==true){
            	loadAjax(
                    "POST",
                    "UpdateServlet.do?useremail="+useremail.value+"&userpwd="+userpwd.value+"&username="+username.value,
                    function(str){
                        if(str=="true"){
                        	showModifyMessage("修改成功");
                        	setTimeout(function(){
                        		window.location.href="ViewDispacher";
                        	}, 2000);
                        }else if(str=="false"){
                        	showModifyMessage("注册失败");
                        }
                    },
                    function(str){
                        showModifyMessage(str);
                    }
                )
            }
            
        }
    }
}