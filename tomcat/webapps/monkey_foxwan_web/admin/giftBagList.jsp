<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="java.util.*" %>
<%@ page import="com.stang.game.ffd.entity.detail.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
 <%
     List<EntityGameItemsDetail> legid= new ArrayList<EntityGameItemsDetail>();
    if(request.getAttribute("rs_giftBagList")==null){
    	response.sendRedirect("findGiftBagList.action");
    }else{
   		legid=(List<EntityGameItemsDetail>)request.getAttribute("rs_giftBagList");
    }
     %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>礼包列表</title>
    <SCRIPT LANGUAGE="JavaScript" SRC="../common/js/Calendar4.js"></SCRIPT>
	
	<script type="text/javascript">
	function delCheck(valueInfo,gbid){
		var rs= confirm(valueInfo);
		if(rs){
		//location.href="delGiftBagList.action?giftBagId="+gbid;
		location.href="delGiftTask.action?giftaskId="+gbid;
		}
	}
	
	function showC(gid){
		document.getElementById(gid).style.display="block";
	}
	</script>
  </head>
  
  <body>
  	<table>
  	<tr>
  		<td>序号</td>
  		<td>礼包</td>
  		<td>礼品</td>
  		<td colspan="2">编辑礼包状态</td>
  	</tr>
  	<%
  		for(EntityGameItemsDetail egid:legid){
  		%>
  		<tr>
  		<td><%=egid.getId() %></td>
  		<td><%=egid.getItemName() %></td>
  		<td><%=egid.getItem_name_gk() %></td>
  		<td>
  		<div id="edit">
  		<!-- <a href="javascript:void(0)" onclick="delCheck('你确定要删除<%=egid.getItemName() %>?',<%=egid.getId() %>)" >删除</a>  -->
  		<%
  			switch(egid.getTaskType()){
  				case 1:
  					// ** 任务处于启用状态 提示关闭
  					%>
  					<a href="javascript:void(0)" onclick="showC(<%=egid.getId() %>)">礼包下架</a>
  					<%
  					break;
  				case 0:
  					//** 任务处于关闭状态 提示开启
  					%>
  					<a href="javascript:void(0)" onclick="delCheck('你确定要下架礼包<%=egid.getItemName() %>?',<%=egid.getId() %>)" >礼包下架</a>
  					<%
  					break;
  			}
  		 %>
  		
  		</div>
  		<div id="update">
  		</div>
  		<br></td>
  		</tr>
  		
  		<tr>
  		<td colspan="5">
  		<div id="<%=egid.getId() %>" style="display:none">
  	     <s:form action="addTask.action" method="post" >
  	     <table>
  	     <tr>
    		<td>起始时间：<input type="text" name="stime1" id="stime1" onclick="MyCalendar.SetDate(this)" readonly="readonly" /></td>
			<td>结束时间：<input type="text" name="stime2" id="stime2" onclick="MyCalendar.SetDate(this)" readonly="readonly" /></td>
			<td><s:submit value="确认并提交" /></td>
		</tr> 
		<tr>
		<td><input type="hidden" name="taskId" id="taskId" value="<%=egid.getId() %>" /></td>
		<td><input type="hidden" name="taskName" id="taskName" value="<%=egid.getItemName() %>" /></td>
		<td><input type="hidden" name="taskDesc" id="taskDesc" value="<%=egid.getItemProp() %>" /></td>
		<td><input type="hidden" name="setTaskLevel" id="setTaskLevel" value="<%=egid.getItemLevel() %>" /></td>
		</tr>
		</table>
  	    </s:form>
  	    </div>
  		</td>
  		</tr>
  		<%
  		}
  	 %>
  	</table>
  		
  </body>
</html>
