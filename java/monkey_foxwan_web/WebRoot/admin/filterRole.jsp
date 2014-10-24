<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>禁言/禁登录/禁IP管理</title>
	</head>
	<body>
		<%@ taglib prefix="s" uri="/struts-tags"%>

		<table>
			<tr>
				<td>
					<a href="#" onclick="replaceDiv(0)">查看禁止发言用户</a>
				</td>
				<td>
					<a href="#" onclick="replaceDiv(1)">查看禁止登录用户</a>
				</td>
				<td>
					<a href="#" onclick="replaceDiv(2)">查看禁止登录IP</a>
				</td>
				<td>
					<a href="#" onclick="replaceDiv(3)">禁发言/登录</a>
				</td>
				<td>
					<a href="#" onclick="replaceDiv(4)">禁止IP/IP段</a>
				</td>
				<td>
					<a href="#" onclick="replaceDiv(5)">解发言/登录</a>
				</td>
				<td>
					<a href="#" onclick="replaceDiv(6)">解禁IP/IP段</a>
				</td>
			</tr>
		</table>
		<div id="tip">
		<font color="red" size="3">${tip }</font>
		</div>
		<!-- 查看禁止发言用户 -->
		<div style="display:none" id="0">
		<s:form action="/FilterRole.action">
				<table>
					<tr>
						<td>
							<s:textfield name="username">昵称:</s:textfield>
						</td>
						<td>
							<s:submit value="SEARCH" />
						</td>
					</tr>
				</table>
				<s:hidden name="caseType" value="0"></s:hidden>
			</s:form>
		</div>
		<div style="display:none" id="1">
				<s:form action="/FilterRole.action">
				<table>
					<tr>
						<td>
							<s:textfield name="username">昵称:</s:textfield>
						</td>
						<td>
							<s:submit value="SEARCH" />
						</td>
					</tr>
				</table>
				<s:hidden name="caseType" value="1"></s:hidden>
			</s:form>
		</div>
		<div style="display:none" id="2">
				<s:form action="/FilterRole.action">
				<table>
					<tr>
						<td>
							<s:textfield name="ip">ip地址:</s:textfield>
						</td>
						<td>
							<s:submit value="SEARCH" />
						</td>
					</tr>
				</table>
				<s:hidden name="caseType" value="2"></s:hidden>
			</s:form>
		</div>
		<!-- 禁止发言、禁止登录 -->
		<div style="display:none" id="3">
			<s:form action="/FilterRole.action">
				<table>
					<tr>
						<td>
							<s:textfield name="username">昵称:</s:textfield>
						</td>
					</tr>
					<tr>
						<td>
							<s:textfield name="serverId">服务器ID:</s:textfield>
						</td>
					</tr>
					<tr>
						<td>
							<s:textfield name="releaseallTime">解封时间:</s:textfield>
						</td>
					</tr>
					<tr>
						<td>
							<s:radio list="#{1:'禁止发言',2:'禁止登录'}" listKey="key"
								listValue="value" value="1" name="type"></s:radio>
						</td>
					</tr>
					<tr>
						<td>
							<s:submit value="提交" />
						</td>
						<td>
							<s:reset value="重置" />
						</td>
					</tr>
				</table>
				<s:hidden name="caseType" value="3"></s:hidden>
			</s:form>
		</div>
		<!-- 禁止网段 -->
		<div style="display:none" id="4">
			<s:form action="/FilterRole.action">
				<table>
					<tr>
						<td>
							<s:textfield name="ip">ip地址:</s:textfield>
						</td>
					</tr>
					<tr>
						<td>
							<s:textfield name="mask" value="255.255.255.255">MASK:</s:textfield>
						</td>
					</tr>
					<tr>
						<td>
							<s:textfield name="releaseallTime">解封时间:</s:textfield>
						</td>
					</tr>
					<tr>
						<td>
							<s:submit value="立刻封杀" />
						</td>
						<td>
							<s:reset value="表单重置" />
						</td>
					</tr>
				</table>
				<s:hidden name="caseType" value="4"></s:hidden>
			</s:form>
		</div>
		<div style="display:none" id="5">
		<s:form action="/FilterRole.action">
				<table>
					<tr>
						<td>
							<s:textfield name="username">昵称:</s:textfield>
						</td>
					</tr>
					<tr>
						<td>
							<s:textfield name="serverId">服务器ID:</s:textfield>
						</td>
					</tr>
					<tr>
						<td>
							<s:radio list="#{1:'允许发言',2:'允许登录'}" listKey="key"
								listValue="value" value="1" name="type"></s:radio>
						</td>
					</tr>
					<tr>
						<td>
							<s:submit value="立刻释放" />
						</td>
						<td>
							<s:reset value="表单重置" />
						</td>
					</tr>
				</table>
				<s:hidden name="caseType" value="3"></s:hidden>
			</s:form>
		</div>
		<div style="display:none" id="6">
			<s:form action="/FilterRole.action">
				<table>
					<tr>
						<td>
							<s:textfield name="ip">ip地址:</s:textfield>
						</td>
					</tr>
					<tr>
						<td>
							<s:textfield name="mask" value="255.255.255.255">MASK:</s:textfield>
						</td>
					</tr>
					<tr>
						<td>
							<s:submit value="立刻释放" />
						</td>
						<td>
							<s:reset value="表单重置" />
						</td>
					</tr>
				</table>
				<s:hidden name="caseType" value="6"></s:hidden>
			</s:form>
		</div>
		<script>
			document.getElementById(${caseType}).style.display="block";
			function replaceDiv(divId){
				document.getElementById("tip").style.display="none";
				for(i=0;i<7;i++){
					document.getElementById(i+"").style.display="none";
				}
				document.getElementById(divId+"").style.display="block";
			}
		</script>
	</body>
</html>