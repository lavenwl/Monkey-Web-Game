<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="com.stang.game.ffd.entity.detail.TyroCardDetail" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	List<TyroCardDetail> ltcd = new ArrayList<TyroCardDetail>();
	if(request.getAttribute("rsList")==null){
    	response.sendRedirect("ActiveCodeList.action");
    }else{
    	ltcd=(List<TyroCardDetail>)request.getAttribute("rsList");
    }
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>激活码生成器</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  <body>
  <s:form action="createActiveCode.action" method="post">  
   
  	%请输入区号：<input type="text" name="active_code" label="请输入区号" />
  	请输入要申请的数量：<input type="text" name="code_counts"  onKeyUp="value=value.replace(/[^\d|chun]/g,'')" />
  	<s:submit value="生成激活码" />
  </s:form>
  <table border="1">
  <tr><td>序号</td><td>卡号</td><td>区号</td></tr>
  <%
  	for(int i=0;i<ltcd.size();i++){
  	TyroCardDetail tcd=ltcd.get(i);
  	
  	%>
  	<tr>
  	<td><%=tcd.getId()%></td>
  	<td><%=tcd.getMd5card() %></td>
  	<td><%=tcd.getServerId() %></td>
  	</tr>
  	<%
  	}
   %>
  </table>
  </body>
</html>
