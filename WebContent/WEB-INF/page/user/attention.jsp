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
        <script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
		<script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
		<script type="text/javascript" src="${ctx }/js/fkjava_timer.js"></script>
        <script type="text/javascript">
         //alert(${user.first});
         $(function(){
    	    $("#nowTime").runTimer();
        })
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
             <div style="margin-left:300px;"><font size="6px;">请选择你感兴趣的5个股票</font></div>       
            <form action="${ctx}/attention" method="post" class="main_form">
                 <input type="hidden" name="id" id="id" value="${sessionScope.user_session.id}"/>
                
                <div class="text_info clearfix" style="margin-left:150px;" ><span>选择一</span></div>
                
                 <div class="input_info" style="margin-left:370px;margin-top: -50px;" >
                	 <select id="first" name="first" class="valid">
                	     <c:forEach items="${requestScope.job_list}" var="job">
                  			<c:choose>
			    					<c:when test="${user.first==job.id }">
			    						<option value="${job.id }" selected="selected">${job.name }</option>
			    					</c:when>
			    					<c:otherwise>
			    						<option value="${job.id }">${job.name}</option>
			    					</c:otherwise>
			    				</c:choose>
			    				</c:forEach>
				      </select>
                </div>
                
                <div class="text_info clearfix" style="margin-left:150px;" ><span>选择二</span></div>
                <div class="input_info" style="margin-left:370px;margin-top: -50px;">
                	 <select id="second" name="second" class="valid">
                  			 <c:forEach items="${requestScope.job_list}" var="job">
                  			<c:choose>
			    					<c:when test="${user.second==job.id }">
			    						<option value="${job.id }" selected="selected">${job.name }</option>
			    					</c:when>
			    					<c:otherwise>
			    						<option value="${job.id }">${job.name}</option>
			    					</c:otherwise>
			    				</c:choose>
			    				</c:forEach>
				      </select>
                </div>
                
                <div class="text_info clearfix" style="margin-left:150px;" ><span>选择三</span></div>
                <div class="input_info" style="margin-left:370px;margin-top: -50px;">
                	 <select id="third" name="third" class="valid">
                  			 <c:forEach items="${requestScope.job_list}" var="job">
                  			<c:choose>
			    					<c:when test="${user.third==job.id }">
			    						<option value="${job.id }" selected="selected">${job.name }</option>
			    					</c:when>
			    					<c:otherwise>
			    						<option value="${job.id }">${job.name}</option>
			    					</c:otherwise>
			    				</c:choose>
			    				</c:forEach>
				      </select>
                </div>
                
                <div class="text_info clearfix" style="margin-left:150px;" ><span>选择四</span></div>
                <div class="input_info" style="margin-left:370px;margin-top: -50px;">
                	 <select id="fourth" name="fourth" class="valid">
                  			 <c:forEach items="${requestScope.job_list}" var="job">
                  			<c:choose>
			    					<c:when test="${user.fourth==job.id }">
			    						<option value="${job.id }" selected="selected">${job.name }</option>
			    					</c:when>
			    					<c:otherwise>
			    						<option value="${job.id }">${job.name}</option>
			    					</c:otherwise>
			    				</c:choose>
			    				</c:forEach>
				      </select>
                </div>
                
                <div class="text_info clearfix" style="margin-left:150px;" ><span>选择五</span></div>
                <div class="input_info" style="margin-left:370px;margin-top: -50px;">
                	 <select id="fifth" name="fifth" class="valid">
                  			 <c:forEach items="${requestScope.job_list}" var="job">
                  			<c:choose>
			    					<c:when test="${user.fifth==job.id }">
			    						<option value="${job.id }" selected="selected">${job.name }</option>
			    					</c:when>
			    					<c:otherwise>
			    						<option value="${job.id }">${job.name}</option>
			    					</c:otherwise>
			    				</c:choose>
			    				</c:forEach>
				      </select>
                </div>
                   
                <div class="button_info clearfix" style="margin-left:300px;">
                    <input type="submit" value="保存" class="btn_save" />
                    <input type="button" value="取消" class="btn_save" onclick=" history.back();"/>
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