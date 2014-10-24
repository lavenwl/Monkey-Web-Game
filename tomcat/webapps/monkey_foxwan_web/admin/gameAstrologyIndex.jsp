<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>星云管理首页</title>
  </head>
  <body>
  <table>
  <tr>
  <td><a href="">查看所有星魂</a></td>
  <td><a href="">添加新的星魂类别</a></td>
  <td><a href="">修改编辑星魂</a></td>
  </tr>
  </table>
  <s:form action="addGameAstrologyAction" method="post" >
  <table>
  <tr><td>新增星魂名称: <input type="text" name="astrologyName" id="astrologyName" /></td></tr>
  <tr><td>星魂的类型:
  <select name="astrologyType" id="astrologyType">
  	<option value=1>攻击</option>
  	<option value=2>防御</option>
  	<option value=3>血量</option>
  	 </select>
  </td></tr>
  <tr><td>星魂的初始值:<input type="text" name="astrologyInitial" id="astrologyInitial" /></td></tr>
  <tr><td>星魂的卖出价格初始值:<input type="text" name="astrologySellPrice" id="astrologySellPrice" /></td></tr>
  <tr><td>星魂的品质:
  
  <select name="astrologyQuality" id="astrologyQuality">
  	<option value=1>白</option>
  	<option value=2>绿</option>
  	<option value=3>蓝</option>
  	<option value=4>紫</option>
  	<option value=5>金</option>
  	 </select>
  	 
  </td></tr>
  <tr><td>资源地址:<input type="text" name="astrologySrc" id="astrologySrc" /> </td></tr>
  <tr><td><s:submit value="确认并提交" /> </td></tr>
  </table>
  </s:form>
  </body>
</html>
