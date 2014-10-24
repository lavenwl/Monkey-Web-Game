<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.stang.game.ffd.service.impl.RightUserServiceImpl"%>
<%@ page import="com.stang.game.ffd.entity.detail.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			List<EntityRightUserDetail> rudList = new RightUserServiceImpl()
					.findRightUserByMap(new HashMap<String, Object>());
		%>
		<font color="red" size="3">${tip }</font>
		<form action="right.action" method="post">
			<table style="border: 2px solid; width: 200px" border="1">
				<tr>
					<td colspan="2" align="center">
						管理账号
					</td>
				</tr>

				<%
				for (EntityRightUserDetail erud : rudList) {
				%>
				<tr>
					<td>
						<input style="width: 10px" type="radio" name="uid1"
							value="<%=erud.getUid()%>" />
					</td>
					<td><%=erud.getUname()%>
					</td>
				</tr>
				<%
				}
				%>
			</table>
			<input name="optype" type="submit" value="delete" style="width: 50px" />
			&nbsp;
			<input name="optype" type="submit" value="edit" style="width: 50px" />
			&nbsp;
			<input type="button" name="add" value="add" style="width: 50px" onclick="dip()" />
			<br />
			<div id="ad" style="display:none">
				<table style="border: 2px solid; width: 200px" border="1">
					<tr>
						<td>
							NEW USER:
						</td>
					</tr>
					<tr>
						<td>
							username:
							<input type="textfield" name="uname" style="width: 150px"></input>
						</td>
					</tr>
					<tr>
						<td>
							password:
							<input type="textfield" name="upassword" style="width: 150px"></input>
						</td>
					</tr>
					<tr>
						<td>
							<center><input name="optype" type="submit" value="submit" style="width: 70px" /></center>
						</td>
					</tr>
				</table>
			</div>
		</form>
		<script>
			function dip(){
				document.getElementById('ad').style.display='block';
			}
		</script>
	</body>
</html>