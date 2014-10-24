<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.stang.game.ffd.entity.detail.EntityKeyWordDetail"%>
<%@page import="com.stang.game.ffd.service.impl.KeyWordServiceImpl"%>
<%@page import="com.stang.game.ffd.common.StringUtil"%>
<%@page import="com.stang.game.ffd.common.GameConstants"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'setKeyWord.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>
	<script type="text/javascript">
	function getEvent(){
	   if(document.all) return window.event; 
	   func=getEvent.caller; 
	   while(func!=null){ 
	     var arg0=func.arguments[0]; 
	     if(arg0){ 
	       if((arg0.constructor==Event || arg0.constructor ==MouseEvent) || (typeof(arg0)=="object" && arg0.preventDefault && arg0.stopPropagation)){ 
	         return arg0; 
	       } 
	     } 
	     func=func.caller; 
	   } 
   return null; 
}
	function delCheck(valueInfo,keyWordId){
		var rs= confirm(valueInfo);
		if(rs){
		if(window.event)
                   window.event.returnValue = false;
                else
                   getEvent().preventDefault();
		
		window.location.href="delKeyWord.action?keyWordId="+keyWordId;
		}
	}
	function checkAll(){
		var keyWord=document.getElementById("keyWord").value;
		if(keyWord==""){
			alert("请输入关键字！")
			return false;
		}
		return true;
	}
	function change(){
		var select=document.getElementById("keyWordTypeList");
		var text;
		for(var i=0;i<select.length;i++){
			if(select.options[i].selected==true){
				var _value=select.options[i].value;
				document.getElementById("keyWordType").value=_value;
			}	
		}
	}
	
	</script>
	<body>
		<%
			List<EntityKeyWordDetail> ekwd = new KeyWordServiceImpl()
					.findEntityKeyWordDetailByParam(null);
		%>
				<s:form action="addKeyWord.action" method="post"
			onsubmit="return checkAll()" name="userForm" id="userForm">
		<table border="1" style="width: 750px; background-color: #eeeeee;">
			<tr style="background-color: #dddddd">
				<td colspan="10">
					聊天关键字
				</td>
			</tr>
			<%
				int j = 0;
				for (int i = 0; i < ekwd.size(); i++) {
					EntityKeyWordDetail keyWord = ekwd.get(i);
					if (keyWord.getType() == 1) {
						if (j == 10) {
			%>
			<tr>
				<%
					}
							j++;
				%>
				<td style="width: 75px">
					<a href="javascript:void(0)"
						onclick="delCheck('你确定要删除<%=StringUtil.uriDecode(keyWord.getKeyWord(),GameConstants.FORMAT)%>？',<%=keyWord.getId()%>)"><%=StringUtil.uriDecode(keyWord.getKeyWord(),GameConstants.FORMAT)%></a>
				</td>
				<%
					if (j == 10) {
								j = 0;
				%>

			</tr>
			<%
				}
					}
				}
			%>
		</table>

		<table border="1" style="width: 750px; background-color: #eeeeee;">
			<tr style="background-color: #dddddd">
				<td colspan="10">
					昵称关键字
				</td>
			</tr>
			<%
				j = 0;
				for (int i = 0; i < ekwd.size(); i++) {
					EntityKeyWordDetail keyWord = ekwd.get(i);
					if (keyWord.getType() == 2) {
						if (j == 10) {
			%>
			<tr>
				<%
					}
							j++;
				%>
				<td style="width: 75px">
					<a href="javascript:void(0)"
						onclick="delCheck('你确定要删除<%=StringUtil.uriDecode(keyWord.getKeyWord(),GameConstants.FORMAT)%>？',<%=keyWord.getId()%>)"><%=StringUtil.uriDecode(keyWord.getKeyWord(),GameConstants.FORMAT)%></a>
				</td>
				<%
					if (j == 10) {
								j = 0;
				%>

			</tr>
			<%
				}
					}
				}
			%>

		</table>
		<table border="1" style="width: 750px; background-color: #eeeeee;">
			<tr style="background-color: #dddddd">
				<td colspan="10">
					联盟关键字
				</td>
			</tr>
			<%
				j = 0;
				for (int i = 0; i < ekwd.size(); i++) {
					EntityKeyWordDetail keyWord = ekwd.get(i);
					if (keyWord.getType() == 3) {
						if (j == 10) {
			%>
			<tr>
				<%
					}
							j++;
				%>
				<td style="width: 75px">
					<a href="javascript:void(0)"
						onclick="delCheck('你确定要删除<%=StringUtil.uriDecode(keyWord.getKeyWord(),GameConstants.FORMAT)%>？',<%=keyWord.getId()%>)"><%=StringUtil.uriDecode(keyWord.getKeyWord(),GameConstants.FORMAT)%></a>
				</td>
				<%
					if (j == 10) {
								j = 0;
				%>

			</tr>
			<%
				}
					}
				}
			%>
		</table>

		<table border="1" style="width: 750px; background-color: #eeeeee;">
			<tr style="background-color: #dddddd">
				<td colspan="10">
					邮件关键字
				</td>
			</tr>
			<%
				j = 0;
				for (int i = 0; i < ekwd.size(); i++) {
					EntityKeyWordDetail keyWord = ekwd.get(i);
					if (keyWord.getType() == 4) {
						if (j == 10) {
			%>
			<tr>
				<%
					}
							j++;
				%>
				<td style="width: 75px">
					<a href="javascript:void(0)"
						onclick="delCheck('你确定要删除<%=StringUtil.uriDecode(keyWord.getKeyWord(),GameConstants.FORMAT)%>？',<%=keyWord.getId()%>)"><%=StringUtil.uriDecode(keyWord.getKeyWord(),GameConstants.FORMAT)%></a>
				</td>
				<%
					if (j == 10) {
								j = 0;
				%>

			</tr>
			<%
				}
					}
				}
			%>
		</table>
				插入新的关键字：<input type="text" name="keyWord" id="keyWord" />
			<select id="keyWordTypeList" onchange="change()">
				<option value="1">
					聊天
				</option>
				<option value="2">
					昵称
				</option>
				<option value="3">
					联盟
				</option>
				<option value="4">
					邮件
				</option>
			</select>
			<s:submit value="提交"></s:submit>
			<s:hidden name="keyWordType" id="keyWordType" value ="1"/>
		</s:form>
	</body>
</html>
