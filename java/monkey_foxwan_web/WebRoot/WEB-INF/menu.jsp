<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.stang.game.entity.detail.EntityRightUserDetail"%>
<%@page import="com.stang.game.service.impl.RightUserServiceImpl"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>


   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>左边树形菜单</title>
<link type="text/css" rel="stylesheet" href="common/css/page.css">
<script type="text/javascript" src="common/js/jquery.min_alixixi_com.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("ul.side_nav li").hover(function() {
		$(this).find("div").stop()
		.animate({left: "210", opacity:1}, "fast")
		.css("display","block")

	}, function() {
		$(this).find("div").stop()
		.animate({left: "0", opacity: 0}, "fast")
	});
});

function show_menu(_id)
{
	var db=document.getElementById(_id);
	if(db.style.display=="none"){
		db.style.display="block";
	}else
	{
		db.style.display="none";
	}
}

function fram(_url)
{
	document.getElementById('i_f').src=_url;
}
</script>
</head>
<body style="width:100%;height:1000px">
<table style="widht:100%;height:100%">
<tr><td style="height:100%">
<%
int WEB_RIGHT=1;

HashMap<String, Object> param = new HashMap<String, Object>();
param.put("uid", (Integer)session.getAttribute("uid"));
List<EntityRightUserDetail> eruds = new RightUserServiceImpl().findRightUserByMap(param);
	%>
	
<div id="left" style="margin-top: 0px;height:100%;float: left;width:200px">
	<ul class="side_nav">
		<%
if(eruds.size()>=1){
WEB_RIGHT = 2;
 if(eruds.get(0).getRight_value()==2){
	
	 %>

	<div>
	<li>
    <a href="javascript:void(0)" onclick="show_menu('news')">GM工具</a>
   
    </li>
    </div>
    
    <div id="news" style="display: none">
	<ul>
    <li>
    <a href="javascript:void(0)" onclick="fram('message.action')" class="sub_menu">系统消息</a>
    
    </li>
  
  
    <br/>
      <li>
    <a href="javascript:void(0)" onclick="fram('messagetwo.action')" class="sub_menu">更新服务端缓存</a>
    
    </li>
    <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('roletwo.action')" class="sub_menu">更新用户模型表</a>
    
    </li>
    <br/>
    <li>
    <a href="javascript:void(0)" onclick="fram('list.action')" class="sub_menu">会员充值查询</a>
   
    </li>
  
    <br/>
      <li>
    <a href="javascript:void(0)" onclick="fram('listcoin.action')" class="sub_menu">coin表查询</a>
    </li>
    <br/>
    
    <li>
    <a href="javascript:void(0)" onclick="fram('geigiftjsp.action')" class="sub_menu">礼包发送</a>
    </li>    
    <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('serverlistjsp.action')" class="sub_menu">服务器状态</a>
    </li>    
    <br/>
   </ul> 
  </div>
 
 
     
  
  
     <div>
     <br/>
     <br/>
    	<li> 
    <a href="javascript:void(0)" onclick="fram('fuwustatus.action')" class="sub_menu">开服停服</a>
  
    </li>
      <br/>
    	<li> 
    <a href="javascript:void(0)" onclick="fram('huodongmanager.action')" class="sub_menu">活动管理</a>
  
    </li>
    </div>
  
    
         <%}
         if(eruds.get(0).getRight_value()==1){

 	%>
     <div>
     <br/>
     <br/>
     <li>
    <a href="javascript:void(0)" onclick="show_menu('admin_info')">系统管理</a>

    </li> 
    </div>
    <div id="admin_info" style="display:none">
   &nbsp&nbsp&nbsp
    	<li> 
    <a href="javascript:void(0)" onclick="fram('right.action')" class="sub_menu">管理员权限管理</a>
  
    </li>
    
     	<li> 
    <a href="javascript:void(0)" onclick="fram('logrecord.action')" class="sub_menu">日志记录</a>
  
    </li>
    
    </div>
    <%}%>
    
    
       <%
         if(eruds.get(0).getRight_value()==3){

 	%>
 	
 	<div>
	<li>
    <a href="javascript:void(0)" onclick="show_menu('news')">GM工具</a>
   
    </li>
    </div>
    
    <div id="news" style="display: none">
	<ul>
    <li>
    <a href="javascript:void(0)" onclick="fram('message.action')" class="sub_menu">系统消息</a>
    
    </li>
  
  
    <br/>
      <li>
    <a href="javascript:void(0)" onclick="fram('messagetwo.action')" class="sub_menu">更新服务端缓存</a>
    
    </li>
    <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('roletwo.action')" class="sub_menu">更新用户模型表</a>
    
    </li>
    <br/>
    <li>
    <a href="javascript:void(0)" onclick="fram('list.action')" class="sub_menu">会员充值查询</a>
   
    </li>
  
    <br/>
      <li>
    <a href="javascript:void(0)" onclick="fram('listcoin.action')" class="sub_menu">coin表查询</a>
   
    </li>
  
    <br/>
    <li>
    <a href="javascript:void(0)" onclick="fram('geigiftjsp.action')" class="sub_menu">礼包发送</a>

    </li>
  <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('serverlistjsp.action')" class="sub_menu">服务器状态</a>
    </li>    
    <br/>
    
   
    
 
    </ul> 
    
    </div>
 
 
     
  
  
     <div>
     <br/>
     <br/>
    	<li> 
    <a href="javascript:void(0)" onclick="fram('fuwustatus.action')" class="sub_menu">开服停服</a>
  
    </li>
      <br/>
    	<li> 
    <a href="javascript:void(0)" onclick="fram('huodongmanager.action')" class="sub_menu">活动管理</a>
  
    </li>
    </div>
 	
     <div>
     <br/>
     <br/>
     <li>
    <a href="javascript:void(0)" onclick="show_menu('admin_info')">系统管理</a>

    </li> 
    </div>
    <div id="admin_info" style="display:none">
   &nbsp&nbsp&nbsp
    	<li> 
    <a href="javascript:void(0)" onclick="fram('right.action')" class="sub_menu">管理员权限管理</a>
  
    </li>
    
     	<li> 
    <a href="javascript:void(0)" onclick="fram('logrecord.action')" class="sub_menu">日志记录</a>
  
    </li>
    
    </div>
    <%}%>
    
    
             <%
         if(eruds.get(0).getRight_value()==5){

 	%>
 	 	<div>
	<li>
    <a href="javascript:void(0)" onclick="show_menu('gengxin')">更新模型表</a>
   
    </li>
    </div>
  
    <div id="gengxin" style="display: none">
	<ul>
  
  
  
     
  <br/>
    
    
   
     <li>
    <a href="javascript:void(0)" onclick="fram('itemlist.action')" class="sub_menu">gameItem列表</a>
   
    </li>
    <br/>
    
    
   
     <li>
    <a href="javascript:void(0)" onclick="fram('maplist.action')" class="sub_menu">gameMap列表</a>
   
    </li>
    <br/>
    
    
   
     <li>
    <a href="javascript:void(0)" onclick="fram('tasklist.action')" class="sub_menu">gameTask列表</a>
   
    </li>
     <br/>
    
    
   
     <li>
    <a href="javascript:void(0)" onclick="fram('equiplist.action')" class="sub_menu">gameEquip列表</a>
   
    </li>
  <br/>
    
    
   
     <li>
    <a href="javascript:void(0)" onclick="fram('skilllist.action')" class="sub_menu">gameSkill列表</a>
   
    </li>
     <br/>
    
    
   
     <li>
    <a href="javascript:void(0)" onclick="fram('chlevellist.action')" class="sub_menu">gameChlevel列表</a>
   
    </li>
       <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('foelist.action')" class="sub_menu">gameFoe列表</a>
   
    </li>
      <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('equippropertylist.action')" class="sub_menu">gameEquipproperty列表</a>
   
    </li>
       <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('bufflist.action')" class="sub_menu">gameBuffer列表</a>
   
    </li>
     <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('platlist.action')" class="sub_menu">gamePlat列表</a>
   
    </li>
     <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('levellist.action')" class="sub_menu">gameLevel列表</a>
   
    </li>
     <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('mlevellist.action')" class="sub_menu">gameMlevel列表</a>
   
    </li>
       <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('militarylist.action')" class="sub_menu">gameMilitary列表</a>
   
    </li>
       <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('gamblinglist.action')" class="sub_menu">gameBlingItem列表</a>
   
    </li>
    </ul> 
    
    </div>
 	
     <div>
     <br/>
     <br/>
     <li>
    <a href="javascript:void(0)" onclick="show_menu('admin_info')">系统管理</a>

    </li> 
    </div>
    <div id="admin_info" style="display:none">
   &nbsp&nbsp&nbsp
    	<li> 
    <a href="javascript:void(0)" onclick="fram('right.action')" class="sub_menu">管理员权限管理</a>
  
    </li>
    
     	<li> 
    <a href="javascript:void(0)" onclick="fram('logrecord.action')" class="sub_menu">日志记录</a>
  
    </li>
    
    </div>
    <%}%>
    
    
    
    <%if(eruds.get(0).getRight_value()==4){ %>
    
       	<div>
	<li>
    <a href="javascript:void(0)" onclick="show_menu('gengxin')">更新模型表</a>
   
    </li>
    </div>
  
    <div id="gengxin" style="display: none">
	<ul>
  
  
  
     
  <br/>
    
    
   
     <li>
    <a href="javascript:void(0)" onclick="fram('itemlist.action')" class="sub_menu">gameItem列表</a>
   
    </li>
    <br/>
    
    
   
     <li>
    <a href="javascript:void(0)" onclick="fram('maplist.action')" class="sub_menu">gameMap列表</a>
   
    </li>
    <br/>
    
    
   
     <li>
    <a href="javascript:void(0)" onclick="fram('tasklist.action')" class="sub_menu">gameTask列表</a>
   
    </li>
     <br/>
    
    
   
     <li>
    <a href="javascript:void(0)" onclick="fram('equiplist.action')" class="sub_menu">gameEquip列表</a>
   
    </li>
  <br/>
    
    
   
     <li>
    <a href="javascript:void(0)" onclick="fram('skilllist.action')" class="sub_menu">gameSkill列表</a>
   
    </li>
     <br/>
    
    
   
     <li>
    <a href="javascript:void(0)" onclick="fram('chlevellist.action')" class="sub_menu">gameChlevel列表</a>
   
    </li>
       <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('foelist.action')" class="sub_menu">gameFoe列表</a>
   
    </li>
      <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('equippropertylist.action')" class="sub_menu">gameEquipproperty列表</a>
   
    </li>
       <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('bufflist.action')" class="sub_menu">gameBuffer列表</a>
   
    </li>
     <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('platlist.action')" class="sub_menu">gamePlat列表</a>
   
    </li>
     <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('levellist.action')" class="sub_menu">gameLevel列表</a>
   
    </li>
     <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('mlevellist.action')" class="sub_menu">gameMlevel列表</a>
   
    </li>
       <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('militarylist.action')" class="sub_menu">gameMilitary列表</a>
   
    </li>
      <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('gamblinglist.action')" class="sub_menu">gameBlingItem列表</a>
   
    </li>
    </ul> 
    
    </div>
    
    <%} %>
    
    
    <%
    if(eruds.get(0).getRight_value()==6){
	
	 %>

	<div>
	<li>
    <a href="javascript:void(0)" onclick="show_menu('news')">GM工具</a>
   
    </li>
    </div>
    
    <div id="news" style="display: none">
	<ul>
    <li>
    <a href="javascript:void(0)" onclick="fram('message.action')" class="sub_menu">系统消息</a>
    
    </li>
  
  
    <br/>
      <li>
    <a href="javascript:void(0)" onclick="fram('messagetwo.action')" class="sub_menu">更新服务端缓存</a>
    
    </li>
    <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('roletwo.action')" class="sub_menu">更新用户模型表</a>
    
    </li>
    <br/>
    <li>
    <a href="javascript:void(0)" onclick="fram('list.action')" class="sub_menu">会员充值查询</a>
   
    </li>
    <br/>
      <li>
    <a href="javascript:void(0)" onclick="fram('listcoin.action')" class="sub_menu">coin表查询</a>
   
    </li>
     
    <br/>
    <li>
    <a href="javascript:void(0)" onclick="fram('geigiftjsp.action')" class="sub_menu">礼包发送</a>

    </li>
     
  <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('serverlistjsp.action')" class="sub_menu">服务器状态</a>
    </li>    
    <br/>
  
    
   
     
    </ul> 
    
    </div>
 
     
     	<div>
	<li>
    <a href="javascript:void(0)" onclick="show_menu('gengxin')">更新模型表</a>
   
    </li>
    </div>
  
    <div id="gengxin" style="display: none">
	<ul>
  
  
  
     
  <br/>
    
    
   
     <li>
    <a href="javascript:void(0)" onclick="fram('itemlist.action')" class="sub_menu">gameItem列表</a>
   
    </li>
    <br/>
    
    
   
     <li>
    <a href="javascript:void(0)" onclick="fram('maplist.action')" class="sub_menu">gameMap列表</a>
   
    </li>
    <br/>
    
    
   
     <li>
    <a href="javascript:void(0)" onclick="fram('tasklist.action')" class="sub_menu">gameTask列表</a>
   
    </li>
     <br/>
    
    
   
     <li>
    <a href="javascript:void(0)" onclick="fram('equiplist.action')" class="sub_menu">gameEquip列表</a>
   
    </li>
  <br/>
    
    
   
     <li>
    <a href="javascript:void(0)" onclick="fram('skilllist.action')" class="sub_menu">gameSkill列表</a>
   
    </li>
     <br/>
    
    
   
     <li>
    <a href="javascript:void(0)" onclick="fram('chlevellist.action')" class="sub_menu">gameChlevel列表</a>
   
    </li>
       <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('foelist.action')" class="sub_menu">gameFoe列表</a>
   
    </li>
      <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('equippropertylist.action')" class="sub_menu">gameEquipproperty列表</a>
   
    </li>
       <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('bufflist.action')" class="sub_menu">gameBuffer列表</a>
   
    </li>
     <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('platlist.action')" class="sub_menu">gamePlat列表</a>
   
    </li>
     <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('levellist.action')" class="sub_menu">gameLevel列表</a>
   
    </li>
     <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('mlevellist.action')" class="sub_menu">gameMlevel列表</a>
   
    </li>
       <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('militarylist.action')" class="sub_menu">gameMilitary列表</a>
   
    </li>
      <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('gamblinglist.action')" class="sub_menu">gameBlingItem列表</a>
   
    </li>
    </ul> 
    
    </div>
  
     <div>
     <br/>
     <br/>
    	<li> 
    <a href="javascript:void(0)" onclick="fram('fuwustatus.action')" class="sub_menu">开服停服</a>
  
    </li>
      <br/>
    	<li> 
    <a href="javascript:void(0)" onclick="fram('huodongmanager.action')" class="sub_menu">活动管理</a>
  
    </li>
    </div>
         
    
   
    <%}%>
    
    
    
    
    
    
    
    
    <%
    if(eruds.get(0).getRight_value()==7){
	
	 %>

	<div>
	<li>
    <a href="javascript:void(0)" onclick="show_menu('news')">GM工具</a>
   
    </li>
    </div>
    
    <div id="news" style="display: none">
	<ul>
    <li>
    <a href="javascript:void(0)" onclick="fram('message.action')" class="sub_menu">系统消息</a>
    
    </li>
  
  
    <br/>
      <li>
    <a href="javascript:void(0)" onclick="fram('messagetwo.action')" class="sub_menu">更新服务端缓存</a>
    
    </li>
    <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('roletwo.action')" class="sub_menu">更新用户模型表</a>
    
    </li>
    <br/>
    <li>
    <a href="javascript:void(0)" onclick="fram('list.action')" class="sub_menu">会员充值查询</a>
   
    </li>
    <br/>
      <li>
    <a href="javascript:void(0)" onclick="fram('listcoin.action')" class="sub_menu">coin表查询</a>
   
    </li>
    
    <br/>
    <li>
    <a href="javascript:void(0)" onclick="fram('geigiftjsp.action')" class="sub_menu">礼包发送</a>

    </li>
    
     <br/>
      <li>
    <a href="javascript:void(0)" onclick="fram('serverlistjsp.action')" class="sub_menu">服务器状态</a>
    </li>    
    <br/>
    <li>
    <a href="javascript:void(0)" onclick="fram('activitylist.action')" class="sub_menu">更新活动</a>

    </li>
  <br/>
    
    
    
   
     
    </ul> 
    
    </div>
 
     
     	<div>
	<li>
    <a href="javascript:void(0)" onclick="show_menu('gengxin')">更新模型表</a>
   
    </li>
    </div>
  
    <div id="gengxin" style="display: none">
	<ul>
  
  
  
     
  <br/>
    
    
   
     <li>
    <a href="javascript:void(0)" onclick="fram('itemlist.action')" class="sub_menu">gameItem列表</a>
   
    </li>
    <br/>
    
    
   
     <li>
    <a href="javascript:void(0)" onclick="fram('maplist.action')" class="sub_menu">gameMap列表</a>
   
    </li>
    <br/>
    
    
   
     <li>
    <a href="javascript:void(0)" onclick="fram('tasklist.action')" class="sub_menu">gameTask列表</a>
   
    </li>
     <br/>
    
    
   
     <li>
    <a href="javascript:void(0)" onclick="fram('equiplist.action')" class="sub_menu">gameEquip列表</a>
   
    </li>
  <br/>
    
    
   
     <li>
    <a href="javascript:void(0)" onclick="fram('skilllist.action')" class="sub_menu">gameSkill列表</a>
   
    </li>
     <br/>
    
    
   
     <li>
    <a href="javascript:void(0)" onclick="fram('chlevellist.action')" class="sub_menu">gameChlevel列表</a>
   
    </li>
       <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('foelist.action')" class="sub_menu">gameFoe列表</a>
   
    </li>
      <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('equippropertylist.action')" class="sub_menu">gameEquipproperty列表</a>
   
    </li>
       <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('bufflist.action')" class="sub_menu">gameBuffer列表</a>
   
    </li>
     <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('platlist.action')" class="sub_menu">gamePlat列表</a>
   
    </li>
     <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('levellist.action')" class="sub_menu">gameLevel列表</a>
   
    </li>
     <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('mlevellist.action')" class="sub_menu">gameMlevel列表</a>
   
    </li>
       <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('militarylist.action')" class="sub_menu">gameMilitary列表</a>
   
    </li>
       <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('bbufflist.action')" class="sub_menu">gameBbuff列表</a>
   
    </li>
      <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('bmaplist.action')" class="sub_menu">gameBmap列表</a>
   
    </li>
      <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('bskilllist.action')" class="sub_menu">gameBskill列表</a>
   
    </li>
      <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('missionlist.action')" class="sub_menu">gameMission列表</a>
   
    </li>
     <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('binglist.action')" class="sub_menu">gameBing列表</a>
   
    </li>
      <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('gamblinglist.action')" class="sub_menu">gameBlingItem列表</a>
   
    </li>
    </ul> 
    
    </div>
  
     <div>
     <br/>
     <br/>
    	<li> 
    <a href="javascript:void(0)" onclick="fram('fuwustatus.action')" class="sub_menu">开服停服</a>
  
    </li>
      <br/>
    	<li> 
    <a href="javascript:void(0)" onclick="fram('huodongmanager.action')" class="sub_menu">活动管理</a>
  
    </li>
    <li> 
    <a href="javascript:void(0)" onclick="fram('shop.action')" class="sub_menu">商城打折管理</a>
  
    </li>
    </div>
         
     <div>
     <br/>
     <br/>
     <li>
    <a href="javascript:void(0)" onclick="show_menu('admin_info')">系统管理</a>

    </li> 
    </div>
    <div id="admin_info" style="display:none">
   &nbsp&nbsp&nbsp
    	<li> 
    <a href="javascript:void(0)" onclick="fram('right.action')" class="sub_menu">管理员权限管理</a>
  
    </li>
     	<li> 
    <a href="javascript:void(0)" onclick="fram('logrecord.action')" class="sub_menu">日志记录</a>
  
    </li>
    
    </div>
    <%}%>
    
    
     <%}
     else if((Integer)session.getAttribute("uid")==3779){
   %>

	<div>
	<li>
    <a href="javascript:void(0)" onclick="show_menu('news')">GM工具</a>
   
    </li>
    </div>
    
    <div id="news" style="display: none">
	<ul>
    <li>
    <a href="javascript:void(0)" onclick="fram('message.action')" class="sub_menu">系统消息</a>
    
    </li>
  
  
    <br/>
      <li>
    <a href="javascript:void(0)" onclick="fram('messagetwo.action')" class="sub_menu">更新服务端缓存</a>
    
    </li>
    <br/>
    <li>
    <a href="javascript:void(0)" onclick="fram('list.action')" class="sub_menu">会员充值查询</a>
   
    </li>
    <br/>
      <li>
    <a href="javascript:void(0)" onclick="fram('listcoin.action')" class="sub_menu">coin表查询</a>
   
    </li>
    
    <br/>
    <li>
    <a href="javascript:void(0)" onclick="fram('geigiftjsp.action')" class="sub_menu">礼包发送</a>

    </li>
     
  <br/>
     <li>
    <a href="javascript:void(0)" onclick="fram('serverlistjsp.action')" class="sub_menu">服务器状态</a>
    </li>    
    <br/>
    
   
     <li>
    <a href="javascript:void(0)" onclick="fram('itemlist.action')" class="sub_menu">道具列表</a>
   
    </li>
    
 
    </ul> 
    
    </div>
 
     
  
  
     <div>
     <br/>
     <br/>
    	<li> 
    <a href="javascript:void(0)" onclick="fram('fuwustatus.action')" class="sub_menu">开服停服</a>
  
    </li>
      <br/>
    	<li> 
    <a href="javascript:void(0)" onclick="fram('huodongmanager.action')" class="sub_menu">活动管理</a>
  
    </li>
    </div>
         
     <div>
     <br/>
     <br/>
     <li>
    <a href="javascript:void(0)" onclick="show_menu('admin_info')">系统管理</a>

    </li> 
    </div>
    <div id="admin_info" style="display:none">
   &nbsp&nbsp&nbsp
    	<li> 
    <a href="javascript:void(0)" onclick="fram('right.action')" class="sub_menu">管理员权限管理</a>
  
    </li>
    	<li> 
    <a href="javascript:void(0)" onclick="fram('logrecord.action')" class="sub_menu">日志记录</a>
  
    </li>
    </div>
     
    
    
    <% 
     }
     
     %>
</ul>
</div> </td> <td style="height:100%">
<div style="float:left;width:80%;background-color:#CCC;height:100%;width:100%" >
<iframe src="" style="width:1024px;height:100%;margin-top: 0px" scrolling="yes" id="i_f" />
</div>
</td></tr>
</table>
</body>
</html>