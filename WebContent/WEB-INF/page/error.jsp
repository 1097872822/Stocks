<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<link rel="shortcut icon" href="${ctx}/public/logo.ico" type="image/x-icon" />
<head>
    <title>错误页面</title>
</head>
<body>
<h1 style="color: red;">很抱歉，我会尽快处理这个错误！！！</h1>
<div style="color: rgb(60,210,146);">我将会在<font id="sp" style="color: red;"></font>秒之后跳转回系统首页，给你不好的体验，耽误你了！！！</div>
	<script type="text/javascript">
		onload=function(){
			setInterval(go, 1000);
		};
		var x=6; //利用了全局变量来执行
		function go(){
		x--;
			if(x>0){
			document.getElementById("sp").innerHTML=x;  //每次设置的x的值都不一样了。
			}else{
			location.href='./index.html';
			}
		}
	</script>
</body>
</html>