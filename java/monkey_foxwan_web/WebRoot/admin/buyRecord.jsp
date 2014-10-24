<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.stang.game.ffd.entity.detail.EntityCaseLogDetail"%>
<%@page import="java.util.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	List<EntityCaseLogDetail> lecld = new ArrayList<EntityCaseLogDetail>();
	String tempArr [];
	String tempArrs [];
	String tempString;
	int resultSum=0;
	int resultSumTime7=0;
	int resultSumTime30=0;
	int resultSumTime90=0;
	if(request.getAttribute("results")!=null){
		lecld=(List<EntityCaseLogDetail>)request.getAttribute("results");
		if(lecld.size()>0){
			for(EntityCaseLogDetail ecld:lecld){
			tempString=ecld.getCase_ex_desc().substring(1,ecld.getCase_ex_desc().length()-1);
		//out.println(tempString+"--"+tempString.split(",").length);
			if(tempString.split(",").length>0){
			tempArrs = tempString.split(",");
				for(String temp: tempArrs){
				tempArr = temp.substring(1,temp.length()-1).split("-");
				if(tempArr.length>=5){
				for(int i=0;i<Integer.parseInt(tempArr[2]);i++){
					switch (Integer.parseInt(tempArr[4])){
						case 0:resultSum+=resultSum+Integer.parseInt(tempArr[3]);break;
						case 7:resultSumTime7+=resultSumTime7+Integer.parseInt(tempArr[3]);break;
						case 30:resultSumTime30+=resultSumTime30+Integer.parseInt(tempArr[3]);break;
						case 90:resultSumTime90+=resultSumTime90+Integer.parseInt(tempArr[3]);break;
					}	
				}				
				}
				}
			}
			}
		}
	}
	if(resultSum>0)
		out.println(resultSum/100+"&720");
	if(resultSumTime7>0)
		out.println(resultSumTime7/100+"&7");
	if(resultSumTime30>0)
	   out.println(resultSumTime30/100+"&30");
	if(resultSumTime90>0){
		out.println(resultSumTime90/100+"&90");
	}
%>
