<%@page pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>股票价值综合分析系统</title>
        <link type="text/css" rel="stylesheet" media="all" href="${ctx }/styles/global.css" />
          <link type="text/css" rel="stylesheet" media="all" href="${ctx }/styles/style.css" />
        <link type="text/css" rel="stylesheet" media="all" href="${ctx }/styles/global_color.css" />
        <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
        <script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
		<script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
		<script type="text/javascript" src="${ctx }/js/fkjava_timer.js"></script>
        <script type="text/javascript">
         $(function(){
    	    $("#nowTime").runTimer();
        })
    </script>
    
    
    <script type="text/javascript">
    $(function(){
    	$("#toLoginForm").submit(function(){
    		var loginname = $("#loginname");
    		var username = $("#username11");
    		var password = $("#password");
    		var msg = "";
    		 if ($.trim(loginname.val()) == ""){
    			msg = "登录名不能为空！";
    			loginname.focus(); 
    		}
    		 else if ($.trim(username.val()) == ""){
    				msg = "用户名不能为空！";
    				username.focus(); 
    			}
    		 else if ($.trim(password.val()) == ""){
    			msg = "密码不能为空！";
    			password.focus(); 
    	    }
    		 
    		 else if (!/^[A-Za-z]{5,15}$/.test($.trim(loginname.val()))){
    	 			msg = "登录名格式不正确！5-15个英文字母";
    				loginname.focus(); 
    			}
    			 else if (!/^[\u4E00-\u9FA5]{2,4}$/.test($.trim(username.val()))){
    				msg = "用户名格式不正确！！！用户名为2-4个汉字";
    				username.focus(); 
    		    }
    			 else if (!/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/.test($.trim(password.val()))){
    					msg = "密码格式不正确！！！6-16个字母数组组合";
    					password.focus(); 
    			    } 
    		if (msg != ""){
    			 alert(msg);
    			return false;
    		}else{
    			return true;
    			$("#toLoginForm").submit();
    		}
    	});
    });
        
    </script>
    </head>
    <body style="background-image:url(${ctx }/public/images/bg.jpg) ">

   <!--导航区域开始-->
        <div class="box">
	      <ul class="f-nav" id='f-nav'>
	        <li style="width:200px;"><a href="${ctx }/index?id=${sessionScope.user_session.id}" style="color: white;">股票管理系统首页</a></li>
	        <li style="width:250px;">当前时间:<span id="nowTime"></span></li>
	        <li style="width:200px;">欢迎<font color="red" id="username">${sessionScope.user_session.username}</font>登录系统</li>
	        <li  id="show" style="margin-left:10px;"><a href="${ctx }/user/list" style="color: white;">用户管理</a></li>
	        <li style="margin-left:10px;"><a href="${ctx }/exit" style="color: white;">退出</a></li>
	         
	    </ul>
    </div>
        <!--主要区域开始-->
        <div id="main">            
            
            <form action="${ctx}/admin/add" method="post" class="main_form" id="toLoginForm">
            
            
                 <div class="text_info clearfix"><span>登录名</span></div>
                <div class="input_info">
                    <input type="text" name="loginname" class="width100" value="${loginname}" id="loginname"/>
                     *不少于5个字母
                    <p style="color: red">${param.message1}</p>
                </div>
            
                <div class="text_info clearfix"><span>用户名</span></div>
                
                <div class="input_info">
                	<input  id="username11" type="text" name="username" class="width100" value="${username}" />
                	*不少于2个汉字
                </div>
                
               
                
                <div class="text_info clearfix"><span>密码</span></div>
                <div class="input_info">
                    <input type="password" name="password" value="${password}" class="width100" id="password" />
                    *6-16个数字或字母组合
                </div>            
                <div class="button_info clearfix">
                    <input type="submit" value="注册" class="btn_save" />
                    <!-- history.back()  返回不刷新 -->
                    <input type="button" value="取消" class="btn_save" onclick="history.back();"/>
                </div>
            </form>
        </div>
       
    </body>
</html>