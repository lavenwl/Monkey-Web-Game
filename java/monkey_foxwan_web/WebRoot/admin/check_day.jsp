<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.stang.game.ffd.entity.detail.EntityCheckDayDetail"%>
<%@page import="java.util.*" %>
<%@page import="java.text.DecimalFormat"%>
<%
DecimalFormat df=new DecimalFormat("#.00");
 %>

 <%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <%
     List<EntityCheckDayDetail> lecld= new ArrayList<EntityCheckDayDetail>();
      Map<String,Object> resultMap= new HashMap<String,Object>();
     int count=0;
     int cutterPage=0;
    if(request.getAttribute("results")==null){
    	response.sendRedirect("check_Day.action");
    }else{
   		resultMap=( Map<String,Object>)request.getAttribute("results");
   		lecld=( List<EntityCheckDayDetail> )resultMap.get("results");
   		count=Integer.parseInt(resultMap.get("pages")+"");
   		cutterPage=Integer.parseInt(resultMap.get("cutterPage")+"");
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
<s:form action="check_DayForDay.action" method="post" enctype ="multipart/form-data" >
<div>
	<table>
		<tr>
		<td>起始时间：<input type="text" name="stime1" id="stime1" onclick="MyCalendar.SetDate(this)" readonly="readonly" /></td>
		<!-- <td>结束时间：<input type="text" name="stime2" id="stime2" onclick="MyCalendar.SetDate(this)" readonly="readonly" /></td> -->
		<td><input type="submit" value="查询" name="addnewsdone" /></td>
		</tr>
	</table>
</div>
</s:form>
	<table border=1 width="700px">
	<tr>	
	<td>日期</td>
	<!-- <td>pps流入用戶</td>
	<td>总创建角色数</td>
	<td>当日创建角色数</td>
	<td>用户增长率</td>
	<td>当日uv</td>
	<td>当日uv率</td>
	<td>最高在线</td>
	<td>不重复登陆</td>
	<td>配置文件加载</td>
	<td>通用工具面板</td>-->
	<td>开启挂机</td>
	<td>关闭挂机</td>
	<td>音效包</td>
	<!-- <td>连接server</td>
	<td>连接聊天server</td> -->
	<td>连接模型数据</td>
	<td>获取排行榜</td>
	<td>获取工会列表</td>
	<td>获取大区列表</td>
	<td>获取大招动画</td>
	<td>获取玩家信息</td>
	<!--  <td>获取创建人物界面</td>-->
	<td>加载主界面</td>
	<td>加载新手帮组</td>
	<td>加载大厅界面</td>
	<td>加载房间界面</td>
	<td>加载战斗界面</td>
	<td>加载战斗资源</td>
	</tr>
	<!-- <tr><td colspan=26">
	<s:form action="checkDay.action" method="post" enctype ="multipart/form-data" >
	<input type="hidden" name="execl" id="execl" value="1" />
		<input type="submit" value="生成xml" name="addnewsdone" />
		</s:form>
	</td></tr>  -->
	<%
	int regman=0;
	for(EntityCheckDayDetail ecd:lecld){
	regman+=ecd.getRegMan();
	%>
	<tr>
	<td><%=ecd.getDate() %></td>
	<!-- <td><%=ecd.getUlts() %></td>
	<td><%=ecd.getRegNum() %></td>
	<td><%=ecd.getRegMan() %></td>
	<td>
	<%
		//用户增长率
		if(ecd.getRegMan()+ecd.getRegNum()>0){
		out.print(df.format(ecd.getRegMan()/(double)(ecd.getRegNum())*100));
		}
	 %>%
	</td>
	<td><%=ecd.getUlt() %></td>
	<td>
	<%
		if(ecd.getUlt()>0){
		out.print(df.format(ecd.getUlts()/(double)ecd.getUlt()*100));
		}
		
	 %>%
	</td>
	<td><%=ecd.getMaxOnline() %></td>
	<td><%=ecd.getNoRepeatlogoin() %></td>
	-->
	<!-- <td><%=ecd.getPzwb() %></td>
	<td><%=ecd.getTygjmb() %></td> -->
	
	 <td><%=ecd.getLjserver() %></td>
	<td><%=ecd.getLjltserver() %></td>
	<td><%=ecd.getYxb() %></td>
	<td><%=ecd.getJzmxsj() %></td>
	<td><%=ecd.getHqphb() %></td>
	<td><%=ecd.getHqghlb() %></td>
	<td><%=ecd.getHqdqlb() %></td>
	<td><%=ecd.getHqdzdh() %></td>
	<td><%=ecd.getHqwjxx() %></td>
	<td><%=ecd.getJzcjrwjm() %></td>
	<td><%=ecd.getJazjm() %></td>
	<td><%=ecd.getJzxsbz() %></td>
	<td><%=ecd.getJzdtjm() %></td>
	<td><%=ecd.getJzfjjm() %></td>
	<td><%=ecd.getJzzdjm() %></td>
	<td><%=ecd.getJzadzy() %></td>
	
	</tr>
	<%
	}
	 %>
	<!-- <tr><td>总计</td><td>新增<%=regman %>新玩家</td></tr>-->
	
	<tr>
	<td colspan="2">
	<%
		for(int i=0;i<count;i++){
		%>
		<a href="checkDay.action?pagetype=2&page=<%=i %>"><%=i%></a>
		<%
		}
	 %>
	</td>
	</tr>
	</table>
</body>
</html>