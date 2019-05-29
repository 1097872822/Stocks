<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>股票价值综合分析系统</title>
        <link type="text/css" rel="stylesheet" media="all" href="${ctx }/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="${ctx }/styles/style.css" />
        <link type="text/css" rel="stylesheet" media="all" href="${ctx }/styles/global_color.css" />
        <script type="text/javascript">
           var visit =${sessionScope.user_session.username};
           if(visit==null){
        	   document.getElementById('show').style.display='none';
           }else{
        	   document.getElementById('show').style.display='show';
           }
        </script>
        
         <!-- 导入jquery插件 -->
		<script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
		<script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
		<script type="text/javascript" src="${ctx }/js/fkjava_timer.js"></script>

        <script type="text/javascript">
         $(function(){
    	    $("#nowTime").runTimer();
        })
    </script>
    </head>
    <body style="background-image:url(${ctx }/public/images/bg.jpg) ">
        
        <!--导航区域开始-->
         <!--导航区域开始-->
        <div class="box">
	      <ul class="f-nav" id='f-nav'>
	        <li style="width:200px;"><a href="${ctx }/index?id=${sessionScope.user_session.id}" style="color: white;">股票管理系统首页</a></li>
	        <li style="width:250px;">当前时间:<span id="nowTime"></span></li>
	        <li style="width:200px;">欢迎<font color="red" id="username">${sessionScope.user_session.username}</font>登录系统</li>
	        <li  id="show" style="margin-left:10px;"><a href="${ctx }/user/list" style="color: white;">用户管理</a></li>
	         <!-- 只有注册用户，才能看到今日推荐，此功能后续完善 -->
	        <li  id="inroad" style="margin-left:10px;"><a href="${ctx }/user/inroad" style="color: white;">股票分析</a></li>
	        <li id="stockvo" style="margin-left:-40px;"><a href="${ctx }/user/stockvo?id=${sessionScope.user_session.id}" style="color: white;">股价预测</a></li>
	        <li  id="select" style="margin-left:10px;"><a href="${ctx }/user/attention?id=${sessionScope.user_session.id}" style="color: white;">我的关注</a>   <a href="${ctx }/exit" style="color: white;margin-left:15px;">退出</a></li>
	       
	         
	    </ul>
    </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <form action="addCost.do" method="post" class="">
                <!--排序-->
                <div class="search_add">
                    <div>
                    </div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='${ctx}/user/admin_add';"/>
                </div> 
                <!--启用操作的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功！
                </div>    
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                        <tr>
                            <th>ID</th>
                            <th>登录名</th>
                            <th>用户名</th>
                            <th>创建时间</th>
                            <th class="width200">操作</th>
                        </tr>
                        <c:forEach items="${requestScope.list}" var="user" varStatus="stat">

                    <tr>
                             <td>${user.id}</td>
           					 <td>${user.loginname }</td>
	          				 <td>${user.username }</td>
	         			     <td>${user.creatTimeStr}</td>
                            <td>
                                <input type="button" value="修改" class="btn_modify" onclick="location.href='${ctx}/user/edit?id=${user.id}';" />
                                <input type="button" value="删除" class="btn_delete" onclick="location.href='${ctx}/user/delete?id=${user.id}';" />

                            </td>
                        </tr>
                        </c:forEach> 
                    </table>
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        
        <script type="text/javascript">
           var visit ="${sessionScope.user_session.loginname}";
        	   if(visit!="admin"){
        		   //如果不是管理员，而是普通用户，这里将不再展示用户管理
        		   document.getElementById("show").style.display="none";
        		   document.getElementById("exit").style.display="none";
        		   document.getElementById("inroad").style.display="show";
        		   document.getElementById("stockvo").style.display="show";
        		   document.getElementById("select").style.display="show";
        		   //这里需要显示一个页面，这个页面应该是推荐股票的界面，
        	   }else{
        		   //这里才是管理员的界面
        		   document.getElementById("show").style.display="show";
        		   document.getElementById("inroad").style.display="none";
        		   document.getElementById("stockvo").style.display="none";
        		   document.getElementById("select").style.display="show";
        	   }
        	
        </script>
 
    </body>
</html>