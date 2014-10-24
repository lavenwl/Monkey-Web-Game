<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.stang.game.service.impl.*"%>
<%@ page import="com.stang.game.entity.detail.*"%>
<%@ page import="com.stang.game.entity.detail.*"%>
<%@ page import="java.util.*"%>
<% 
ServerDetail server = new ServerDetail();
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<%@ taglib prefix="s" uri="/struts-tags"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>
	</head>
	<body>
		<table border = 1 style="font-size: 12px; font-style: normal;">
			<tr>
				<th width = 30>服务器ID(id)						</th>
				<th width = 30>服务器名称(name)					</th>
				<th width = 30>服务器状态(statue_mag)			</th>
				<th width = 30>是否推荐服务器(statue_tui)		</th>
				<th width = 30>是否是新服务器(statue_xin)		</th>
				<th width = 30>是否开启(statue_on)				</th>
				<th width = 30>在线人数(online_num)				</th>	
			</tr>
			<tr>
				<th width = 30>自动定义，不得更改					</th>
				<th width = 30>good day!						</th>
				<th width = 30>1：繁忙；2：拥挤；3：畅通；4：维护	</th>
				<th width = 30>1：推荐服；0：非推荐服				</th>
				<th width = 30>1：新服；0：非新服				</th>
				<th width = 30>1：开服；0：关服					</th>
				<th width = 30>在线人数							</th>
			</tr>
		<s:iterator value="serverlist" status="statta">
			<tr>
				<form action="serverlist2.action" method="post">
					<table>
					  <tr>
						<td><input type="text" size="8" value="<s:property value="id"/>" name="id"/></td>
						<td><input type="text" size="8" value="<s:property value="name"/>" name="name"/></td>
						<td><input type="text" size="8" value="<s:property value="statue_mag"/>" name="statue_mag"/></td>
						<td><input type="text" size="8" value="<s:property value="statue_tui"/>" name="statue_tui"/></td>
						<td><input type="text" size="8" value="<s:property value="statue_xin"/>" name="statue_xin"/></td>
						<td><input type="text" size="8" value="<s:property value="statue_on"/>" name="statue_on"/></td>
						<td><input type="text" size="8" value="<s:property value="online_num"/>" name="online_num"/></td>
						<!-- <td><a href="serverlist2?id=${id }">更新</a></td> -->
					  </tr>
					<!-- 	<tr><td>id：</td><td><input type="text" name="pro.id"></td></tr>
						<tr><td>name：</td><td><input type="text" name="pro.name"></td></tr>
						<tr><td>level：</td><td><input type="text" name="pro.level"></td></tr>
						<tr><td>gongxun：</td><td><input type="text" name="pro.gongxun"></td></tr>
						<tr><td>type：</td><td><input type="text" name="pro.type"></td></tr>
						<tr><td>ta：</td><td><input type="text" name="pro.ta"></td></tr>
						<tr><td>flag：</td><td><input type="text" name="pro.flag"></td></tr>
						<tr><td>time：</td><td><input type="text" name="pro.time"
						onclick="SelectDate(this,'yyyy-MM-dd hh:mm:ss')"  readonly="readonly"></td></tr>
					 -->
					</table>
					<input type="submit" value="更新">
				</form>
			</tr>
		</s:iterator>
		<!-- 在循环过程总，
		struts会将当前循环元素压入root栈顶，
		因此表达式直接写"id",访问的是元素的id属性值 
		stat是一个迭代状态对象，具有index,count,first,last,even,odd。
		-->
		<tr><td><a href="addserver">添加新服</a></td></tr>
		</table>
	</body>
</html>