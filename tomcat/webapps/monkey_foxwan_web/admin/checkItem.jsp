<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.stang.game.ffd.entity.detail.EntityGameItemDetail"%>
<%@page import="java.util.*" %>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <%
     List<EntityGameItemDetail> legid= new ArrayList<EntityGameItemDetail>();
    String gettime="";
    if(request.getAttribute("results")==null){
    	response.sendRedirect("checkItem.action");
    }else{
    	Map<String,Object> resultMap = new HashMap<String,Object>();
    	resultMap=(Map<String,Object>)request.getAttribute("results");
    	gettime=resultMap.get("getTime")+"";
   		legid=( List<EntityGameItemDetail> )resultMap.get("results");
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

<s:form action="checkItem.action" method="post" enctype ="multipart/form-data" >
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
	<table border=1 width="700px">
	<tr><td colspan="6">
	<!-- <s:form action="checkItem.action" method="post" enctype ="multipart/form-data" >
	<input type="hidden" name="execl" id="execl" value="1" />
		<input type="submit" value="生成xml" name="addnewsdone" />
		</s:form> -->
	</td></tr>
	<tr>
	<td>日期</td>	
	<td>rmb销售次数</td>
	<td>强化次数</td>
	<td>合成次数</td>
	<td>合成物品</td>
	<td></td>
	</tr>
	<%
	int rmbItem=0;
	int intensify=0;
	int synthesis=0;
	int synthesisitem=0;
	
	for(EntityGameItemDetail egid:legid){
	rmbItem+=egid.getRmbItem();
	intensify+=egid.getIntensify();
	synthesis+=egid.getSynthesis();
	synthesisitem+=egid.getSynthesisItem();
	%>
	<tr>
	<td><%=egid.getDate() %></td>
	<td><%=egid.getRmbItem() %></td>
	<td><%=egid.getIntensify() %></td>
	<td><%=egid.getSynthesis() %></td>
	<td><%=egid.getSynthesisItem() %></td>
	<td><a href="checkItemAll.action?type=2&getTime=<%=gettime %>">点击查看详细信息</a></td>
	</tr>
	<%
	}
	 %>
	<tr>
		<td>总计</td>
		<td><%=rmbItem %></td>
		<td><%=intensify %></td>
		<td><%=synthesis %></td>
		<td><%=synthesisitem %></td>
	</tr>
	</table>
</body>
</html>