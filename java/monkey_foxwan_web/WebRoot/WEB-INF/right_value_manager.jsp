<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.stang.game.service.impl.RightValueServiceImpl"%>
<%@ page import="com.stang.game.service.impl.RightUserServiceImpl"%>
<%@ page import="java.util.*"%>
<%@ page import="com.stang.game.entity.detail.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			HashMap param = new HashMap<String, Object>();
			param.put("uid", request.getParameter("uid1"));

			int rightValue = 0;
			List<EntityRightUserDetail> rusl = new RightUserServiceImpl()
					.findRightUserByMap(param);
			if (rusl.size() != 0) {
				EntityRightUserDetail erud = rusl.get(0);
				rightValue = erud.getRight_value();
			}
			List<EntityRightValueDetail> ervdList = new RightValueServiceImpl()
					.findRightValueByMap(new HashMap<String, Object>());
		%>
		<table>

			<tr>
				<td>
					权限描述
				</td>
				<td>
					有
				</td>
				<td>
					无
				</td>
			</tr>

			<%
				int i = 0;
				for (EntityRightValueDetail ervd : ervdList) {
			%>
			<tr>
				<td>
					<%=ervd.getRight_context()%>
				</td>
				<td>
					<input type="radio" name="right<%=i%>"
						value=<%=ervd.getRight_value()%>
						<%=((ervd.getRight_value() & rightValue) > 0 ? "checked=checked"
										: "")%>></input>
				</td>
				<td>
					<input type="radio" name="right<%=i++%>" value=0
						<%=((ervd.getRight_value() & rightValue) == 0 ? "checked=checked"
										: "")%>></input>
				</td>
			</tr>

			<%
			}
			%>

			<tr>
				<td colspan="2">
					<center>
						<form action="right.action" method="post">
							<input type="submit" name="optype" value="sure" onclick="sure()"></input>
							<input type="hidden" id="rightValue" name="rightValue" />
							<input type="hidden" id="uid1" name="uid1" value="${uid1}"/>
						</form>
					</center>
				</td>
			</tr>
		</table>
		<script>
		function sure(){
			var size = <%=i%>;
			var a=0;
			for(i=0;i<size;i++){
				if(document.getElementsByName("right"+i)[0].checked){
					a=a|document.getElementsByName("right"+i)[0].value;
				}else
				{
					a=a|document.getElementsByName("right"+i)[1].value;
				}
			}
			document.getElementById("rightValue").value=a;
		}
		</script>
	</body>
</html>