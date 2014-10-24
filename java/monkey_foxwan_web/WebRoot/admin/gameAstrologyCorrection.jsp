<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page import="com.stang.game.ffd.entity.detail.EntityGameAstrologyCorrectionDetail"%>
<%@page import="java.util.*" %>
<%@page import="java.text.DecimalFormat"%>
<%
	List<EntityGameAstrologyCorrectionDetail> legacd = new ArrayList<EntityGameAstrologyCorrectionDetail>();
    	if(request.getAttribute("results")!=null){
    		  legacd = (List<EntityGameAstrologyCorrectionDetail>)request.getAttribute("results");
    	}else{
    		response.sendRedirect("findGameAstrologyCorrection.action");
    	}	
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加占星修正值</title>
  </head>
  <body>
    <s:form action="addGameAstrologyCorrection.action" method="post">
    	<table>
    	<tr>
    	<td>开启等级：<input type="text" name="correction_lv" id="correction_lv" /></td>
    	<td>修正值：<input type="text" name="correction_value" id="correction_value" /></td>
    	</tr>
    	</table>
    	<s:submit value="确认并提交" ></s:submit>
    </s:form>
    <table>
    <tr><td>等级</td><td>修正值</td></tr>
    <!-- 数据较少的情况下，可以讲数据一并查询出来 -->
    <%
    	for(EntityGameAstrologyCorrectionDetail egcd:legacd){
    	%>
    	<tr>
    	<td><%=egcd.getCorrection_lv() %></td>
    	<td><%=egcd.getCorrection_value() %></td>
    	</tr>
    	<%
    	}
     %>
     </table>
  </body>
</html>
