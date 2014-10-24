<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.stang.game.ffd.entity.detail.EntityOrderInfoDetail"%>
<%@page import="java.util.*" %>
<%@page import="java.text.DecimalFormat"%>
<%
DecimalFormat df=new DecimalFormat("#.00");
 %>

 <%@ taglib prefix="s" uri="/struts-tags"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <%
     List<EntityOrderInfoDetail> lecld= new ArrayList<EntityOrderInfoDetail>();
     Map<String,Object> resultMap= new HashMap<String,Object>();
     int count=0;
     int cutterPage=0;
    if(request.getAttribute("results")==null){
    	//response.sendRedirect("searchPay.action");
    
    } else{
   		//resultMap=( Map<String,Object>)request.getAttribute("results");
   		resultMap = (Map<String,Object>)request.getAttribute("results");
   		lecld=(List<EntityOrderInfoDetail>)resultMap.get("payRecold");
   		//count=Integer.parseInt(resultMap.get("pages")+"");
   		//cutterPage=Integer.parseInt(resultMap.get("cutterPage")+"");
    }
     %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>check day</title>
<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/Calendar4.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/WebCalendar.js"></SCRIPT>
<script type="text/javascript">
function checkPage(){

	if(document.getElementById("stime1").value=="请选择日期"){
	alert("必须有时间才可以进行操作");	
		return false;
	}else{
		return true;
	}
	
}
</script>
</head>
<body>

<%

 %>
<table border=1>
<tr>
<br/>

</tr>
<br/>
<tr><h3>得到玩家充值信息:</h3></tr>
<tr>

<td>openid</td>
<td>payitem</td>
<th>totalmoney</th>
<td>充值时间</td>
</tr>
<s:iterator value="buyDetails" status="stat">
       <tr>
		<td><s:property value="openid"/></td>
		<td><s:property value="payitem"/></td>
		<td>
			<s:property value="totalmoney"/>
			</td>
		<td><s:property value="time"/></td>
		</tr>
</s:iterator>
	</table>
		<s:form action="list.action" method="post" enctype ="multipart/form-data" onsubmit="return checkPage()" >
<div>
	<table>
	<br/>
		<tr>
		<td>
			<s:submit value="返回列表"></s:submit>
			</td>
		</tr>
	</table>
</div>
</s:form>
<div>
合计金额：<s:textfield name="allmoney" id="allmoney"  disabled="true"/>
<!-- 实际金额：<s:textfield name="allmoneysj" id="allmoneysj"  disabled="true"/>  -->
<br/>
<!-- 充值黄钻人数：<s:textfield name="hznum" id="hznum"  disabled="true"/> -->
</div>
</body>
</html>