<%@page pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="${ctx }/styles/global.css" />
         <link type="text/css" rel="stylesheet" media="all" href="${ctx }/styles/style.css" />
        <link type="text/css" rel="stylesheet" media="all" href="${ctx }/styles/global_color.css" />
        
        
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
	        <li id="ordinary" style="width:200px;"><a href="${ctx }/index?id=${sessionScope.user_session.id}" style="color: white;">股票管理系统首页</a></li>
	        <li id="tourist" style="width:200px;"><a href="${ctx }/index?id=1" style="color: white;">股票管理系统首页</a></li>
	        <li style="width:250px;">当前时间:<span id="nowTime"></span></li>
	        <li style="width:200px;">欢迎<font color="red" id="username">${sessionScope.user_session.username}</font>登录系统</li>
	        <li  id="show" style="margin-left:10px;"><a href="${ctx }/user/list" style="color: white;">用户管理</a></li>
	        <!-- 只有注册用户，才能看到今日推荐，此功能后续完善 -->
	        <li  id="inroad" style="margin-left:-40px;"><a href="${ctx }/user/inroad?id=${sessionScope.user_session.id}" style="color: white;">股票分析</a></li>
	        <li id="stockvo" style="margin-left:-40px;"><a href="${ctx }/user/stockvo?id=${sessionScope.user_session.id}" style="color: white;">股价预测</a></li>
	        <li  id="useredit" style="margin-left:-30px;"><a href="${ctx }/user/edit?id=${sessionScope.user_session.id}" style="color: white;">个人信息</a></li>
	        <li  id="select" style="margin-left:5px;"><a href="${ctx }/user/attention?id=${sessionScope.user_session.id}" style="color: white;">我的关注</a>   <a href="${ctx }/exit" style="color: white;margin-left:15px;">退出</a></li>
	        <li id="exit"><a href="${ctx }/exit" style="color: white;margin-left:15px;">退出</a></li>
	         
	    </ul>
    </div>
        
        <!--主要区域开始-->
        <div id="main">            
            <form action="${pageContext.request.contextPath}/user/add" method="post" class="main_form" id="toLoginForm">

 				<input type="hidden" name="userid" id="userid" value="${user.id }">
               <input type="hidden" name="id" id="id" value="${user.id }">
               
                 <div class="text_info clearfix"><span>登录名</span></div>
                <div class="input_info">
                    <input type="text" name="loginname" class="width100" value="${user.loginname}" id="loginname"/>
                </div>
                <div class="text_info clearfix"><span>用户名</span></div>
                <div class="input_info">
                	<input type="text" name="username" class="width100" value="${user.username}" id="username11"/>
                </div>
                
              
                
                <div class="text_info clearfix"><span>密码</span></div>
                <div class="input_info">
                    <input type="password" name="password" value="${user.password}" class="width100" id="password" />
                </div>            
                <div class="button_info clearfix">
                    <input type="submit" value="保存" class="btn_save" />
                    <!-- history.back()  返回不刷新 -->
                    <input type="button" value="取消" class="btn_save" onclick="history.back();"/>
                </div>
            </form>
        </div>
        
          <script type="text/javascript">
           var visit ="${sessionScope.user_session.loginname}";
           
           if(visit==null||visit==""){
        	   document.getElementById("show").style.display="none";
        	   document.getElementById("inroad").style.display="none";
        	   document.getElementById("stockvo").style.display="none";
        	   document.getElementById("select").style.display="none";
        	   document.getElementById("ordinary").style.display="none";
        	   document.getElementById("tourist").style.display="show";
        	   document.getElementById("fontordinary").style.display="none";
        	   document.getElementById("fonttourist").style.display="show";
        	   document.getElementById("prompt").style.display="show";
        	   
        	  
        		  
        	   
        	   
        	   var chars = ['0', '1', '2', '3', '4', '5', 
        		   '6', '7', '8', '9', 'A', 'B', 'C', 'D',
        		   'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 
        		   'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
        		   'U', 'V', 'W', 'X', 'Y', 'Z',
        		   'a','b','c','d','e','f','g',
        		   'h','i','j','k','l','m','n',
        		   'o','p','q','r','s','t','u',
        		   'v','w','x','y','z'];
               function generateMixed(n) {
                   var res = "";
                   for(var i = 0; i < n; i++) {
                       var id = Math.ceil(Math.random() * 35);
                       res += chars[id];
                   }
                   return res;
               }
               var num1 = generateMixed(8);
               
            	   document.getElementById("username").innerHTML="游客"+num1;
               
           }else{
        	   if(visit!="admin"){
        		   //如果不是管理员，而是普通用户，这里将不再展示用户管理
        		   document.getElementById("show").style.display="none";
        		   
        		   document.getElementById("inroad").style.display="show"; 
        		   document.getElementById("stockvo").style.display="show";
        		   document.getElementById("useredit").style.display="show";
        		   document.getElementById("select").style.display="show";
        		   document.getElementById("ordinary").style.display="show";
            	   document.getElementById("tourist").style.display="none";
            	   document.getElementById("fontordinary").style.display="show";
            	   document.getElementById("fonttourist").style.display="none";
            	   document.getElementById("prompt").style.display="none";
        		   //这里需要显示一个页面，这个页面应该是推荐股票的界面，
        	   }else{
        		   //这里才是管理员的界面
        		   document.getElementById("show").style.display="show";
        		   document.getElementById("exit").style.display="none";
        		   document.getElementById("inroad").style.display="none"; 
        		   document.getElementById("stockvo").style.display="none";
        		   document.getElementById("useredit").style.display="none"; 
        		   document.getElementById("ordinary").style.display="show";
            	   document.getElementById("tourist").style.display="none";
            	   document.getElementById("fontordinary").style.display="show";
            	   document.getElementById("fonttourist").style.display="none";
            	   document.getElementById("prompt").style.display="none";
        		   //document.getElementById("select").style.display="none";
        	   }
        	   
           }
        </script>
    </body>
</html>