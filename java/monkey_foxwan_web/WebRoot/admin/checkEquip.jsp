<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.stang.game.ffd.entity.detail.EntityGameEquipDetail"%>
<%@page import="java.util.*" %>
<%@page import="com.stang.game.ffd.service.impl.*"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <%
     List<EntityGameEquipDetail> legids= new ArrayList<EntityGameEquipDetail>();
     String getTime="";
    if(request.getAttribute("results")==null){
    	response.sendRedirect("checkItemAll.action?type=2");
    }else{
    Map<String,Object> resultMap = new HashMap<String,Object>();
    	resultMap=(Map<String,Object>)request.getAttribute("results");
    	getTime=resultMap.get("getTime")+"";
   		legids=( List<EntityGameEquipDetail> )resultMap.get("results");
    }
     %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>check day</title>
<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/Calendar4.js"></SCRIPT>
</head>
<body>

<s:form action="checkItemAll.action?type=2" method="post" enctype ="multipart/form-data" >
 <div>
		<table>
		<tr>
		<td>起始时间：<input type="text" name="stime1" id="stime1" onclick="MyCalendar.SetDate(this)" readonly="readonly" /></td>
		<td>结束时间：<input type="text" name="stime2" id="stime2" onclick="MyCalendar.SetDate(this)" readonly="readonly" /></td>
		<td><input type="submit" value="查询" name="addnewsdone" /></td>
		</tr>
		</table>
        </div>
        </s:form>
        <table>
        <tr>
        <td><a href="checkItemAll.action?type=1&getTime=<%=getTime %>">飞机销售情况</a></td>
        <td><a href="checkItemAll.action?type=2&getTime=<%=getTime %>">道具销售情况</a></td>
        <td><a href="checkItemAll.action?type=3&getTime=<%=getTime %>">装备销售情况</a></td>
        <td><a href="checkItemAll.action?type=4&getTime=<%=getTime %>">装饰销售情况</a></td>
        </tr>
        </table>
	<table border=1 width="700px">
	<tr>
	<td>序号</td>	
	<td>装备名称</td>
	<td>销售数量</td>
	<td>使用数</td>
	</tr>
	<%
	String result_name="";
	int i=0;
	int j=0;
	List<EntityGameEquipDetail> leged_temp=null;
			Map<String,Object> parm = new HashMap<String,Object>();
			GameEquipServiceImpl egsi=new GameEquipServiceImpl();
			leged_temp =egsi.getAllInfo(parm);
	for(EntityGameEquipDetail egid:legids){
		for(EntityGameEquipDetail egedtemp:leged_temp){
			i=egid.getId();j=egedtemp.getId();
			if(i==j){
			result_name=egedtemp.getEquipName();
			break;
			}
		}
	%>
	<tr>
	<td><%=egid.getId() %></td>
	<!-- <td><%=java.net.URLDecoder.decode(egid.getEquipName(),"UTF-8") %></td> -->
	<td><%=result_name %></td>
	<td><%=egid.getNum() %></td>
	<td><%=egid.getSellNum() %></td>
	</tr>
	<%
	}
	 %>
	
	</table>
</body>
</html>