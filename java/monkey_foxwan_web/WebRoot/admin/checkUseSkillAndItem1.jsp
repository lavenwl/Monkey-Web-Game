<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.stang.game.ffd.entity.detail.EntityGameSkillDetail"%>
<%@page import="java.util.*" %>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <%
    Map<String,Map<String,Integer>> resultMap = new HashMap<String,Map<String,Integer>>();
     List<EntityGameSkillDetail> lresult= new ArrayList<EntityGameSkillDetail>();
    if(request.getAttribute("results")==null){
    	response.sendRedirect("checkUseSkillAndItem.action?type=1");
    }else{
   		resultMap=( Map<String,Map<String,Integer>>)request.getAttribute("results");
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

<s:form action="checkUseSkillAndItem.action?type=1" method="post" enctype ="multipart/form-data" >
 <div>
		<table>
		<tr>
		<td>起始时间：<input type="text" name="stime1" id="stime1" onclick="MyCalendar.SetDate(this)" readonly="readonly" /></td>
		<td>结束时间：<input type="text" name="stime2" id="stime2" onclick="MyCalendar.SetDate(this)" readonly="readonly" /></td>
		<td><input type="submit" value="查询" name="addnewsdone" /></td>
		</tr>
		</table>
        </div>
        </s:form>
       
	<table border=1 width="700px">
	<tr>
	<td>日期</td>	
	<td>三并发</td>
	<td>群体修理包</td>
	<td>隐形涂料</td>
	<td>伤害增幅50%</td>
	<td>防护盾</td>
	<td>三连发</td>
	<td>二连发</td>
	<td>修理包</td>
	</tr>
	<%
	int sbf=0;//三并发
	int qtxlb=0;//群里修理表
	int yxtl=0;//隐形涂料
	int shzf=0;//伤害增幅
	int ffd=0;//防护盾
	int slf=0;//三连发
	int elf=0;//二连发
	int xlb=0;//修理包
	Iterator<Map.Entry<String,Map<String,Integer>>> its = resultMap.entrySet().iterator();
	while(its.hasNext()){	
		Map.Entry entrys=its.next();
		Map<String,Integer> mp = (Map<String,Integer>)entrys.getValue();
		Iterator<Map.Entry<String,Integer>> it = mp.entrySet().iterator();
		%>
		<tr>
		<%
		while(it.hasNext()){
			Map.Entry entry= it.next();
			if(entry.getKey().toString().equals("三并发")){
		sbf=Integer.parseInt(entry.getValue()+""); 
		}else if(entry.getKey().toString().equals("群体修理包")){
			qtxlb=Integer.parseInt(entry.getValue()+"");
		}else if(entry.getKey().toString().equals("隐形涂料")){
			yxtl=Integer.parseInt(entry.getValue()+"");
		}else if(entry.getKey().toString().equals("伤害增幅50%")){
			shzf=Integer.parseInt(entry.getValue()+"");
		}else if(entry.getKey().toString().equals("防护盾")){
			ffd=Integer.parseInt(entry.getValue()+"");
		}else if(entry.getKey().toString().equals("三连发")){
			slf=Integer.parseInt(entry.getValue()+"");
		}else if(entry.getKey().toString().equals("二连发")){
			elf=Integer.parseInt(entry.getValue()+"");
		}else if(entry.getKey().toString().equals("修理包")){
			xlb=Integer.parseInt(entry.getValue()+"");
		}							
	}		
	%>
	<td><%=entrys.getKey() %></td>
	<td><%=sbf%></td>
	<td><%=qtxlb%></td>
	<td><%=yxtl%></td>
	<td><%=shzf%></td>
	<td><%=ffd%></td>
	<td><%=slf%></td>
	<td><%=elf%></td>
	<td><%=xlb%></td>
	</tr>
	<%
	}
	 %>
	</table>
</body>
</html>