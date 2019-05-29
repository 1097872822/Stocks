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
        <link type="text/css" rel="stylesheet" media="all" href="${ctx }/styles/global_color.css" />
    </head>
    <body style="background-image:url(${ctx }/public/images/bg.jpg) ">
        
        <!--导航区域开始-->
        <div id="navi">                        
            <ul id="menu">
                <li><a href="${ctx }/user/list">用户管理</a></li>
                <li style="margin-left: 300px;">欢迎<font color="red">${sessionScope.user_session.username}</font>登录系统</li>
                <li style="margin-left: 250px;"><a href="${ctx }/exit">退出</a></li>
                
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
                    <input type="button" value="增加" class="btn_add" onclick="location.href='toAddCost.do' ;"/>
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
                            <th class="width100">年度</th>
                            <th>系统名称</th>
                            <th>计划费用</th>
                            <th>工作内容</th>
                            <th>具体措施</th>
                            <th>计划进度</th>
                            <th>文件</th>
                            <th>备注</th>
                            <th class="width200">操作</th>
                        </tr>
                        <c:forEach items="${costList}" var="c">

                    <tr>
                            <td>${c.costId}</td>
                            <td><a href="fee_detail.html">${c.name}</a></td>
                            <td>${c.baseDuration}</td>
                            <td>${c.baseCost}</td>
                            <td>${c.unitCost}</td>
                            <td>${c.status}</td>
                            <td>${c.descr}</td>
                            <td>${c.endout}</td>
                            <td>${c.last}</td>
                            
                            <td>
                                <input type="button" value="修改" class="btn_modify" onclick="location.href='toUpdateCost.do?costId=${c.costId}';" />
                                <input type="button" value="删除" class="btn_delete" onclick="location.href='toDeleteCost.do?costId=${c.costId}';" />

                            </td>
                        </tr>
                        </c:forEach> 
                    </table>
                   
                </div>

               
                   

            </form>
        </div>
        <!--主要区域结束-->
 
    </body>
</html>