<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.stang.game.ffd.entity.detail.EntityGameSkillDetail"%>
<%@page import="java.util.*" %>
<%@page import="s"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <%
    Map<String,Map<String,Integer>> resultMap = new HashMap<String,Map<String,Integer>>();
     List<EntityGameSkillDetail> lresult= new ArrayList<EntityGameSkillDetail>();
    if(request.getAttribute("results")==null){
    	response.sendRedirect("checkBattleSkill.action?type=1");
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

<s:form action="checkBattleSkill.action?type=1" method="post" enctype ="multipart/form-data" >
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
	<td>天火</td>	
	<td>地面援助</td>
	<td>绝对防御</td>
	</tr>
	<%
	int th=0;//天火
	int mj=0;//密集
	int jd=0;//绝对防御
	Iterator<Map.Entry<String,Map<String,Integer>>> its = resultMap.entrySet().iterator();
	while(its.hasNext()){	
		Map.Entry entrys=its.next();
		Map<String,Integer> mp = (Map<String,Integer>)entrys.getValue();
		Iterator<Map.Entry<String,Integer>> it = mp.entrySet().iterator();
		out.print("<tr>");
		while(it.hasNext()){
			Map.Entry entry= it.next();
			if(java.net.URLDecoder.decode(entry.getKey().toString(),"UTF-8").equals("天火")){
		th=Integer.parseInt(entry.getValue()+""); 
		}else if(java.net.URLDecoder.decode(entry.getKey().toString(),"UTF-8").equals("地面援助")){
			mj=Integer.parseInt(entry.getValue()+"");
		}else if(java.net.URLDecoder.decode(entry.getKey().toString(),"UTF-8").equals("绝对防御")){
			jd=Integer.parseInt(entry.getValue()+"");
		}		
	}		
	%>
	<td><%=entrys.getKey() %></td>
	<td><%=th%></td>
	<td><%=mj%></td>
	<td><%=jd%></td>
	<%
	}
	out.print("</tr>");
	 %>
	</table>
</body>
</html>