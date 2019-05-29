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
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/v-charts/lib/style.min.css">
        <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/echarts/dist/echarts.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/v-charts/lib/index.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/echarts-amap/dist/echarts-amap.min.js"></script> 
		<script src="https://cdn.jsdelivr.net/npm/echarts/dist/extension/bmap.min.js"></script>
        
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
        <!--导航区域结束-->
        <!--主要区域开始-->
        
        <div id="main">
        <div style="margin-left:380px;"><font size="4px;">2016年---2019年股票走势推荐</font></div>  
            <form action="addCost.do" method="post" class="">
                <!--排序-->
                <div class="search_add">
                </div> 
                  
                <!--数据区域：用表格展示数据-->   
					 <div id="app1" style="width: 820px;height: 400px; border:2px solid rosybrown;margin-top:-20px;margin-left:50px;margin-bottom: 15px;">
     
                      <ve-line :data="chartData" :settings="chartSettings"></ve-line>
                      </div>
           	    
            </form>
            
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
        
         <!-- 导入jquery插件 -->
		<script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
		<script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
		<script type="text/javascript" src="${ctx }/js/fkjava_timer.js"></script>
        
        <script type="text/javascript">
         $(function(){
    	    $("#nowTime").runTimer();
        })
    </script>
    
     <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts-all-3.js"></script>
        
      
        </div>
        <!--主要区域结束-->
       
 <script>
//使用ajax加载数据 
 $.ajax({
     method:'post',
     url:'${ctx}/echartsData?id=${sessionScope.user_session.id}',
     dataType:'json',
     success:function(data){
         initChat(data);
     }
 }); 
 function initChat(data){
	 //代表五个股票
 	var yA = [];
 	var yB = [];
 	var yC = [];
 	var yD = [];
 	var yE = [];
 	
     //将获取到的json数据列表清洗数据后push到xA,yA两个坐标轴 数据列表中
     //注意，此处循环函数可以用于位置数量的数据，不必提前预知数据量大小
     
     	yA.push(data[0].product1);
     	yB.push(data[1].product2);
     	yC.push(data[2].product3);
     	yD.push(data[3].product4);
     	yE.push(data[4].product5);
    
	    	new Vue({
	    		  el: '#app1',
	    		  data() {
	    		    this.chartSettings = {
	    		      title : '一周处理业务折线统计',  
	    		      //metrics: ['${stockName_first.name}', '${stockName_second.name}', '${stockName_third.name}','${stockName_fourth.name}','${stockName_fifth.name}'],
	    		      metrics: [yA[0][0].name,yB[0][0].name,yC[0][0].name,yD[0][0].name,yE[0][0].name],
	    		      dimension: ['日期']
	    		    }
	    		    return {
	    		      chartData: {
	    		        //columns: ['日期', '${stockName_first.name}', '${stockName_second.name}', '${stockName_third.name}','${stockName_fourth.name}','${stockName_fifth.name}'],
	    		       columns: ['日期', yA[0][0].name,yB[0][0].name,yC[0][0].name,yD[0][0].name,yE[0][0].name],
	    		        rows: [
	    		          { '日期': '16-03-31', '${stockName_first.name}': yA[0][0].depershare, '${stockName_second.name}': yB[0][0].depershare, '${stockName_third.name}': yC[0][0].depershare,'${stockName_fourth.name}':yD[0][0].depershare,'${stockName_fifth.name}':yE[0][0].depershare},
	    		          { '日期': '16-06-30', '${stockName_first.name}': yA[0][1].depershare, '${stockName_second.name}': yB[0][1].depershare, '${stockName_third.name}': yC[0][1].depershare,'${stockName_fourth.name}':yD[0][1].depershare,'${stockName_fifth.name}':yE[0][1].depershare},
	    		          { '日期': '16-09-30', '${stockName_first.name}': yA[0][2].depershare, '${stockName_second.name}': yB[0][2].depershare, '${stockName_third.name}': yC[0][2].depershare,'${stockName_fourth.name}':yD[0][2].depershare,'${stockName_fifth.name}':yE[0][2].depershare},
	    		          { '日期': '16-12-31', '${stockName_first.name}': yA[0][3].depershare, '${stockName_second.name}': yB[0][3].depershare, '${stockName_third.name}': yC[0][3].depershare,'${stockName_fourth.name}':yD[0][3].depershare,'${stockName_fifth.name}':yE[0][3].depershare},
	    		          { '日期': '17-03-31', '${stockName_first.name}': yA[0][4].depershare, '${stockName_second.name}': yB[0][4].depershare, '${stockName_third.name}': yC[0][4].depershare,'${stockName_fourth.name}':yD[0][4].depershare,'${stockName_fifth.name}':yE[0][4].depershare},
	    		          { '日期': '17-06-30', '${stockName_first.name}': yA[0][5].depershare, '${stockName_second.name}': yB[0][5].depershare, '${stockName_third.name}': yC[0][5].depershare,'${stockName_fourth.name}':yD[0][5].depershare,'${stockName_fifth.name}':yE[0][5].depershare},
	    		          { '日期': '17-09-30', '${stockName_first.name}': yA[0][6].depershare, '${stockName_second.name}': yB[0][6].depershare, '${stockName_third.name}': yC[0][6].depershare,'${stockName_fourth.name}':yD[0][6].depershare,'${stockName_fifth.name}':yE[0][6].depershare},
	    		          { '日期': '17-12-31', '${stockName_first.name}': yA[0][7].depershare, '${stockName_second.name}': yB[0][7].depershare, '${stockName_third.name}': yC[0][7].depershare,'${stockName_fourth.name}':yD[0][7].depershare,'${stockName_fifth.name}':yE[0][7].depershare},
	    		          { '日期': '18-03-31', '${stockName_first.name}': yA[0][8].depershare, '${stockName_second.name}': yB[0][8].depershare, '${stockName_third.name}': yC[0][8].depershare,'${stockName_fourth.name}':yD[0][8].depershare,'${stockName_fifth.name}':yE[0][8].depershare},
	    		          { '日期': '18-06-30', '${stockName_first.name}': yA[0][9].depershare, '${stockName_second.name}': yB[0][9].depershare, '${stockName_third.name}': yC[0][9].depershare,'${stockName_fourth.name}':yD[0][9].depershare,'${stockName_fifth.name}':yE[0][9].depershare},
	    		          { '日期': '18-09-30', '${stockName_first.name}': yA[0][10].depershare, '${stockName_second.name}': yB[0][10].depershare, '${stockName_third.name}': yC[0][10].depershare,'${stockName_fourth.name}':yD[0][10].depershare,'${stockName_fifth.name}':yE[0][10].depershare},
	    		          { '日期': '18-12-31', '${stockName_first.name}': yA[0][11].depershare, '${stockName_second.name}': yB[0][11].depershare, '${stockName_third.name}': yC[0][11].depershare,'${stockName_fourth.name}':yD[0][11].depershare,'${stockName_fifth.name}':yE[0][11].depershare},
	    		          { '日期': '19-03-31', '${stockName_first.name}': yA[0][12].depershare, '${stockName_second.name}': yB[0][12].depershare, '${stockName_third.name}': yC[0][12].depershare,'${stockName_fourth.name}':yD[0][12].depershare,'${stockName_fifth.name}':yE[0][12].depershare}
	    		         
	    		        ] 
	    		        
	    		      }
	    		    }
	    		  }
	    		})
	    
	};
 
	</script>
	
    </body>
</html>