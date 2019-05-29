<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>股票价值综合分析系统</title>
        <link type="text/css" rel="stylesheet" media="all" href="styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="styles/style.css" />
        <link type="text/css" rel="stylesheet" media="all" href="styles/global_color.css" />
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
	        <li  id="inroad" style="margin-left:-50px;"><a href="${ctx }/user/inroad?id=${sessionScope.user_session.id}" style="color: white;">股票分析</a></li>
	        <li id="stockvo" style="margin-left:-40px;"><a href="${ctx }/user/stockvo?id=${sessionScope.user_session.id}" style="color: white;">股价预测</a></li>
	        <li  id="useredit" style="margin-left:-30px;"><a href="${ctx }/user/edit?id=${sessionScope.user_session.id}" style="color: white;">个人信息</a></li>
	        <li  id="select" style="margin-left:5px;"><a href="${ctx }/user/attention?id=${sessionScope.user_session.id}" style="color: white;">我的关注</a>   <a href="${ctx }/exit" style="color: white;margin-left:15px;">退出</a></li>
	        <li id="exit"><a href="${ctx }/exit" style="color: white;margin-left:15px;">退出</a></li>
	         
	    </ul>
    </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        
        <div id="main">
            <form action="addCost.do" method="post" class="">
                <!--排序-->
                <div class="search_add">
                </div> 
               
                <!--数据区域：用表格展示数据-->     
                <div id="data">          
                     <font id="fontordinary" size="6px;" style="margin-left: 120px;"><a href="${stockName_first.url}?id=${sessionScope.user_session.id}">${stockName_first.name}</a>  
                                                                    <a href="${stockName_second.url}?id=${sessionScope.user_session.id}">${stockName_second.name}  </a>
                                                                    <a href="${stockName_third.url}?id=${sessionScope.user_session.id}">${stockName_third.name}</a>
                                                                    <a href="${stockName_fourth.url}?id=${sessionScope.user_session.id}"> ${stockName_fourth.name}</a>
                                                                    <a href="${stockName_fifth.url}?id=${sessionScope.user_session.id}">${stockName_fifth.name}</a></font> 
                    
                     <font id="prompt" size="6px;" style="margin-left: 130px;color: red">想了解更多股票信息，请去登录页面注册账号!</font>
                     <font id="fonttourist" size="6px;" style="margin-left: 145px;">
                                                                            
                     												<a href="${stockName_first.url}?id=1">${stockName_first.name}</a>  
                                                                    <a href="${stockName_second.url}?id=1">${stockName_second.name}  </a>
                                                                    <a href="${stockName_third.url}?id=1">${stockName_third.name}</a>
                                                                    <a href="${stockName_fourth.url}?id=1"> ${stockName_fourth.name}</a>
                                                                    <a href="${stockName_fifth.url}?id=1">${stockName_fifth.name}</a>
                                                                    </font> 
                       
                        <br><div><font size="4px;" style="margin-left: 440px;color: green">每股指标</font></div>                                            
                    <table id="datalist">
                        
                       	
                        <tr>
                            <th>日期</th>
                            <th>股票代码</th>
                            <th>名称</th>
                            <th>基本每股收益(元)</th>
                            <th>扣非每股收益(元)</th>
                            <th>稀释每股收益(元)</th>
                            <th>每股净资产(元)</th>
                            <th>每股资本公积(元)</th>
                            <th>每股未分配利润(元)</th>
                            <th>每股经营现金流(元)</th>
                            <!-- 
                            <th class="width200">操作</th> -->
                        </tr>
                        <c:forEach items="${requestScope.job_list}" var="c">

                    <tr>
                            <td>${c.creatTimeStr}</td>
                            <td>${c.stockcode}</td>
                            <td>${c.name}</td>
                            <td>${c.income}</td>
                            <td>${c.dnepershare}</td>
                            <td>${c.depershare}</td>
                            <td>${c.netassets}</td>
                            <td>${c.providentfund}</td>
                            <td>${c.undistributedprofit}</td>
                            <td>${c.operatingcashflow}</td>
                            
                            
                        </tr>
                        </c:forEach> 
                    </table>
                    <br><div><font size="4px;" style="margin-left: 440px;color: green">成长能力指标</font></div>  
                     <table id="datalist">
                          	
                        <tr>
                            <th>日期</th>
                            <th>名称</th>
                            <th>营业总收入(亿元)</th>
                            <th>归属净利润(亿元)</th>
                            <th>扣非净利润(亿元)</th>
                            <th>营业总收入同比增长</th>
                            <th>归属净利润同比增长</th>
                            <th>扣非净利润同比增长</th>
                            <th>营业总收入滚动环比增长</th>
                            <th>归属净利润滚动环比增长</th>
                            <th>扣非净利润滚动环比增长</th>
                            <!-- 
                            <th class="width200">操作</th> -->
                        </tr>
                        <c:forEach items="${requestScope.job_list}" var="c">

                    <tr>
                            <td>${c.creatTimeStr}</td>
                            <td>${c.name}</td>
                            <td>${c.toperatingincome}</td>
                            <td>${c.grossprofit}</td>
                            <td>${c.aaprofit}</td>
                            <td>${c.nonnetprofit}%</td>
                            <td>${c.toiincreasedyoy}%</td>
                            <td>${c.npatyoygrowth}%</td>
                            <td>${c.nonnetprofitrrgrowth}%</td>
                            <td>${c.toiincreasedyoyrrgrowth}%</td>
                            <td>${c.npatyoygrowthrrgrowth}%</td>
                            
                        </tr>
                        </c:forEach> 
                    </table>
                    <br><div><font size="4px;" style="margin-left: 440px;color: green">盈利能力指标</font></div>  
                     <table id="datalist">
                          		
                        <tr>
                            <th>日期</th>
                            <th>股票代码</th>
                            <th>名称</th>
                            <th>净资产收益率(加权)</th>
                            <th>净资产收益率(非扣/加权)</th>
                            <th>总资产收益率(加权)</th>
                            <th>净利率</th>
                            <th>权益乘数</th>
                            <th>总资产周转率(次)</th>
                            <!-- 
                            <th class="width200">操作</th> -->
                        </tr>
                        <c:forEach items="${requestScope.job_list}" var="c">

                    <tr>
                            <td>${c.creatTimeStr}</td>
                            <td>${c.stockcode}</td>
                            <td>${c.name}</td>
                            <td>${c.npgrowth}%</td>
                            <td>${c.dronassets}%</td>
                            <td>${c.gpmargin}%</td>
                            <td>${c.nirate}%</td>
                            <td>${c.equitymultiplier}</td>
                            <td>${c.tatrate}</td>
                            
                        </tr>
                        </c:forEach> 
                    </table>
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
        
         <!-- 导入jquery插件 -->
		<script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
		<script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
		<script type="text/javascript" src="${ctx }/js/fkjava_timer.js"></script>

        <script type="text/javascript">
         $(function(){
    	    $("#nowTime").runTimer();
        })
    </script>
        </div>
        <!--主要区域结束-->
 
    </body>
</html>