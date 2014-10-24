<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.stang.game.ffd.entity.detail.EntityOrderInfoDetail"%>
<%@page import="java.util.*" %>
<%
	List<EntityOrderInfoDetail> leoid = new ArrayList<EntityOrderInfoDetail>();
	if(request.getAttribute("results")!=null){ 
		leoid= (List<EntityOrderInfoDetail>)request.getAttribute("results");
		for(EntityOrderInfoDetail eoid:leoid){
  				out.println(eoid.getOrderId()+"&"+eoid.getDataTime().substring(0,19)+"&"+eoid.getPoint()+"&"+eoid.getMember_username().split("_")[1]);
  			} 
	}else{
		out.print(request.getAttribute("errCode"));
	}
 %>   
 