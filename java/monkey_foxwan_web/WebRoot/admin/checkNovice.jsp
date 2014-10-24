<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.stang.game.ffd.entity.detail.EntityCheckNoviceDayDetail"%>
<%@page import="java.text.DecimalFormat"%>
<%
	DecimalFormat df=new DecimalFormat("#");
 %>

<%@page import="java.util.*" %>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <%
     List<EntityCheckNoviceDayDetail> lecndd= new ArrayList<EntityCheckNoviceDayDetail>();
     int count=0;
     int cutterPage=0;
    Map<String,Object> resultMap = new HashMap<String,Object>(); 
    if(request.getAttribute("results")==null){
    	response.sendRedirect("checkNovice.action");
    }else{
    	resultMap=( Map<String,Object>)request.getAttribute("results");
   		lecndd=( List<EntityCheckNoviceDayDetail> )resultMap.get("results");
   		count=Integer.parseInt(resultMap.get("pages")+"");
   		cutterPage=Integer.parseInt(resultMap.get("cutterPage")+"");
    }
     %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>check day</title>

	<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/WebCalendar.js"></SCRIPT>
<script type="text/javascript">
function checkPage(){

	if(document.getElementById("startTime").value=="请选择日期"){
	alert("必须有时间才可以进行操作");	
		return false;
	}else{
		return true;
	}
	
}
</script>
</head>
<body>

<s:form action="checkNoviceForDay.action" method="post" enctype ="multipart/form-data" onsubmit="return checkPage()" >
<div>
	<table>
		<tr>
		<td>选择时间：
		<input name="startTime" id="startTime" type="text" value="请选择日期"
							id="stime2" onclick="SelectDate(this,'yyyy-MM-dd')"
							readonly="true" style="cursor: pointer" />
		</td>
		<td><input type="submit" value="查询" name="addnewsdone" /></td>
		</tr>
	</table>
</div>
</s:form>  
      
	<table border=1 width="700px">
	<tr><td colspan=26">
	<!-- <s:form action="checkNovice.action" method="post" enctype ="multipart/form-data" >
	<input type="hidden" name="execl" id="execl" value="1" />
		<input type="submit" value="生成xml" name="addnewsdone" />
		</s:form> -->
	</td></tr>
	<tr><td colspan="48">数字节点说明</td></tr>
	<tr><td colspan="38">
	<table>
	<tr>
	
	<!-- 
	  1欢迎对话
	  2介绍移动
	  3介绍蓄力攻击
	  4等待结束
	  5答题
	  6选区
	  7显示任务界面
	  8领取奖励
	  9提示远征
	  10等待轮到
	  11调曲线
	  12提示蓄力
	  13答题
	  14显示主界面
	  15显示任务界面
	  16领取奖励
	  17打开包裹
	  18更换衣服
	  19关闭包裹
	  20打开任务界面
	  21领取奖励
	  22进入战斗
	  23提示使用道具
	  24提示攻击
	  25使用大招
	  26提示攻击
	  27等待结束
	  28显示主界面
	  29显示任务界面
	  30领取奖励
	  31打开强化中心
	  32放置强化物品
	  33提示强化
	  34提示进入大厅
	  35显示大厅界面
	  36提示购买道具
	  37提示pvp
	  38开始战斗加载
	  39新手完成
	 -->
	<td>1:欢迎对话</td>
	<td>2:介绍移动</td>
	<td>3:介绍蓄力攻击</td>
	<td>4:等待结束</td>
	<td>5:答题</td>
	<td>6:选区</td>
	</tr>
	<tr>
	<td>7:显示任务界面</td>
	<td>8:领取奖励</td>
	<td>9:提示远征</td>
	<td>10：等待轮到</td>
	<td>11:调曲线</td>
	<td>12：提示蓄力</td>
	</tr>
		<tr>
	<td>13:答题</td>
	<td>14:显示主界面</td>
	<td>15:显示任务界面</td>
	<td>16:领取奖励</td>
	<td>17:打开包裹</td>
	<td>18:更换衣服</td>
	</tr>
			<tr>
	<td>19:关闭包裹</td>
	<td>20:打开任务界面</td>
	<td>21:领取奖励</td>
	<td>22:进入战斗</td>
	<td>23:提示使用道具</td>
	<td>24:提示攻击</td>
	</tr>
	<tr>
	<td>25:使用大招</td>
	<td>26:提示攻击</td>
	<td>27:等待结束</td>
	<td>28:显示主界面</td>
	<td>29:显示任务界面</td>
	<td>30:领取奖励</td>
	</tr>
	<tr>
	<td>31:打开强化中心</td>
	<td>32:放置强化物品</td>
	<td>33:提示强化</td>
	<td>34:提示进入大厅</td>
	<td>35:显示大厅界面</td>
	<td>36:提示购买道具</td>
	</tr>
	<tr>
	<td>37:提示pvp</td>
	<td>38:开始战斗加载</td>
	<td>39:新手完成</td>
	</table>
	</td></tr>
	<tr>
	<td>日期</td>
	<%
	for(int i=1;i<=39;i++){
	//if(i==10 || i==17 || i==29 || i==35 ||i==44 || i==50 || i==51){
		//continue;
//	}
	 %>
	 <td><%=i %></td>
	<%
	}
	 %>
	 <td>流失率</td>
	</tr>
	<%
	for(EntityCheckNoviceDayDetail ecndd:lecndd){
	%>
	<tr>
		<td><%=ecndd.getDate().substring(0,10) %></td>
		<td><%=ecndd.getEcnd().getNovice1() %></td>
		<td><%=ecndd.getEcnd().getNovice2() %></td>
		<td><%=ecndd.getEcnd().getNovice3() %></td>
		<td><%=ecndd.getEcnd().getNovice4() %></td>
		<td><%=ecndd.getEcnd().getNovice5() %></td>
		<td><%=ecndd.getEcnd().getNovice6() %></td>
		<td><%=ecndd.getEcnd().getNovice7() %></td>
		<td><%=ecndd.getEcnd().getNovice8() %></td>
		<td><%=ecndd.getEcnd().getNovice9() %></td>
   <td><%=ecndd.getEcnd().getNovice10() %></td> 
		<td><%=ecndd.getEcnd().getNovice11() %></td>
		<td><%=ecndd.getEcnd().getNovice12() %></td>
		<td><%=ecndd.getEcnd().getNovice13() %></td>
		<td><%=ecndd.getEcnd().getNovice14() %></td>
		<td><%=ecndd.getEcnd().getNovice15() %></td>
		<td><%=ecndd.getEcnd().getNovice16() %></td>
		  <td><%=ecndd.getEcnd().getNovice17() %></td> 
		<td><%=ecndd.getEcnd().getNovice18() %></td>
		<td><%=ecndd.getEcnd().getNovice19() %></td>
		<td><%=ecndd.getEcnd().getNovice20() %></td>
		<td><%=ecndd.getEcnd().getNovice21() %></td>
 <td><%=ecndd.getEcnd().getNovice22() %></td>
		<td><%=ecndd.getEcnd().getNovice23() %></td>
		<td><%=ecndd.getEcnd().getNovice24() %></td>
		<td><%=ecndd.getEcnd().getNovice25() %></td>
		<td><%=ecndd.getEcnd().getNovice26() %></td>
		<td><%=ecndd.getEcnd().getNovice27() %></td>
   <td><%=ecndd.getEcnd().getNovice28() %></td> 
		<td><%=ecndd.getEcnd().getNovice29() %></td>
		<td><%=ecndd.getEcnd().getNovice30() %></td>
		<td><%=ecndd.getEcnd().getNovice31() %></td>
		<td><%=ecndd.getEcnd().getNovice32() %></td>
		<td><%=ecndd.getEcnd().getNovice33() %></td>
		<td><%=ecndd.getEcnd().getNovice34() %></td>
		<td><%=ecndd.getEcnd().getNovice35() %></td>
		<td><%=ecndd.getEcnd().getNovice36() %></td>
		<td><%=ecndd.getEcnd().getNovice37() %></td>
		<td><%=ecndd.getEcnd().getNovice38() %></td>
		<td><%=ecndd.getEcnd().getNovice39() %></td>
	<!--<td><%=ecndd.getEcnd().getNovice40() %></td>
		<td><%=ecndd.getEcnd().getNovice41() %></td>
    	<td><%=ecndd.getEcnd().getNovice42() %></td>
		<td><%=ecndd.getEcnd().getNovice43() %></td>
		<td><%=ecndd.getEcnd().getNovice44() %></td>
		<td><%=ecndd.getEcnd().getNovice45() %></td> 
		<td><%=ecndd.getEcnd().getNovice46() %></td>
		<td><%=ecndd.getEcnd().getNovice47() %></td>
        <td><%=ecndd.getEcnd().getNovice48() %></td>
		<td><%=ecndd.getEcnd().getNovice49() %></td>
		<td><%=ecndd.getEcnd().getNovice50() %></td>
		<td><%=ecndd.getEcnd().getNovice51() %></td>
		<td><%=ecndd.getEcnd().getNovice52() %></td>
		<td><%=ecndd.getEcnd().getNovice53() %></td>
		<td><%=ecndd.getEcnd().getNovice54() %></td>
		<td><%=ecndd.getEcnd().getNovice55() %></td>
		<td><%=ecndd.getEcnd().getNovice56() %></td>
		<td><%=ecndd.getEcnd().getNovice57() %></td>
		<td><%=ecndd.getEcnd().getNovice58() %></td>
		<td><%=ecndd.getEcnd().getNovice59() %></td>
		<td><%=ecndd.getEcnd().getNovice60() %></td>
		<td><%=ecndd.getEcnd().getNovice61() %></td>
		<td><%=ecndd.getEcnd().getNovice62() %></td>
		<td><%=ecndd.getEcnd().getNovice63() %></td>
		<td><%=ecndd.getEcnd().getNovice64() %></td>
		<td><%=ecndd.getEcnd().getNovice65() %></td>
		<td><%=ecndd.getEcnd().getNovice66() %></td>
		<td><%=ecndd.getEcnd().getNovice67() %></td>
		<td><%=ecndd.getEcnd().getNovice68() %></td>
		<td><%=ecndd.getEcnd().getNovice69() %></td>
		<td><%=ecndd.getEcnd().getNovice70() %></td>
		<td><%=ecndd.getEcnd().getNovice71() %></td>
		<td><%=ecndd.getEcnd().getNovice72() %></td>
		<td><%=ecndd.getEcnd().getNovice73() %></td>
		<td><%=ecndd.getEcnd().getNovice74() %></td>
		<td><%=ecndd.getEcnd().getNovice75() %></td>
		<td><%=ecndd.getEcnd().getNovice76() %></td>
		<td><%=ecndd.getEcnd().getNovice77() %></td> -->
		<%
		float result=0;
			if(ecndd.getEcnd().getNovice1()>ecndd.getEcnd().getNovice46()){
		    result=ecndd.getEcnd().getNovice1()- ecndd.getEcnd().getNovice38();
		    
		   result=result / ecndd.getEcnd().getNovice1();
		 result=result*100;
			}
		 %>
		<td><%=df.format(result)%>%</td>
	</tr>
	<%
	}
	 %>
	
	
	
	<tr>
	<td colspan="2">
	<%
		for(int i=0;i<count;i++){
		%>
		<a href="checkNovice.action?page=<%=i %>"><%=i%></a>
		<%
		}
	 %>
	</td>
	</tr>
	</table>
	
	
</body>
</html>