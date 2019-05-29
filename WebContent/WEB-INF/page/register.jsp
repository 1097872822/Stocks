<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>股票价值综合分析系统</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="${ctx}/public/css/font.css">
	<link rel="stylesheet" href="${ctx}/public/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
   
<script type="text/javascript">
$(function(){
	$("#toLoginForm").submit(function(){
		var loginname = $("#loginname");
		var username = $("#username");
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
<body class="login-bg">
    
    <div class="login layui-anim layui-anim-up">
        <div class="message">股票价值综合分析系统用户注册</div>
        <div id="darkbannerwrap"></div>
        <p style="color: red">${param.message1}</p>
        <form id="toLoginForm" method="post" class="layui-form" action="${ctx}/user/add?falg=1">
            <input id="loginname" name="loginname" placeholder="登录名       不少于5个字母" value="${loginname}"  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input id="username" name="username" placeholder="用户名       不少于2个汉字" value="${username}"  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input id="password" name="password" lay-verify="required" value="${password}" placeholder="密码      6-16个字母或数字组合"  type="password" class="layui-input">
            <hr class="hr15">
            <input value="注册" lay-submit lay-filter="login" style="width:100%;" type="submit">
            <hr class="hr20" >
        </form>
    </div>
</body>
</html>