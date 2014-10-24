<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <%@page import="java.util.HashMap"  %>
     <%@page import="java.util.Map"  %>
     <%@page import="java.util.List"  %>
     <%@page import="com.stang.game.entity.detail.ServerDetail"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String pf = (String) session.getAttribute("pf");
	String openid = (String) session.getAttribute("openid");
	String openkey = (String) session.getAttribute("openkey");
	String pfkey = (String) session.getAttribute("pfkey");
	String success = (String) session.getAttribute("success");
	String serverid = (String) session.getAttribute("serverId");
	Map<String, Object> map =  (HashMap<String, Object>)session.getAttribute("servermap");
	List<ServerDetail> serverlist = (List<ServerDetail>)map.get("serverlist");
	List<ServerDetail> roleServerlist = (List<ServerDetail>)map.get("roleServerlist");
	int serverlistsize = serverlist.size();
	int roleServerlistsize = roleServerlist.size();
	boolean isNew = Boolean.valueOf(String.valueOf(session.getAttribute("isNew")));
	//String pid = (String) session.getAttribute("pid");
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="Copyright" content="Tencent" />
<meta name="Description" content="腾讯,社区,开放平台" />
<meta name="Keywords" content="腾讯社区开放平台、开放平台、腾讯社区" />
<title>网页游戏、社交游戏专区 - 腾讯游戏</title>
<link rel="stylesheet" type="text/css" href="/html/css/selectarea.css"  charset="gb2312"/>
<link rel="stylesheet" type="text/css" href="http://openwebgame.qq.com/style_manage/GetStyleData.php?iAppId=100673142&action=custom&datatype=css"/>


<script type="text/javascript" charset="gb2312">
var iAppId = "100719210";
</script>
<style>
/*add by filedwu*/
/*.wy_serList li{ position:static}*/
/*add by filedwu*/
#theServiceList{padding:18px;width:700px;border:#660099 1px solid;height:425px; overflow:hidden;overflow-y:auto; position:relative;}
/*.wy_serverT { border:#d5ba94 1px solid;}
.wy_serverT div { background:#eedbad; color:#70502c}*/
.wy_serverT .wy_lastLogin { color:#70502c}
.serSortstag { color:#70502c; font-size:12px; line-height:22px; width:100%; text-align:left; font-weight:bold}
.txidnt { text-indent:11px; margin-bottom:4px}
.servrlishad {}
/*.wy_serverT { position:static}*/

.wy_banner {display:none}
.wy_lastLogin{display:none}
.wlop_area{display:none}
.wlop_area_tab{display:none}
.display_checkbox {margin:0px 0px 0px 0px}

</style>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=22050343" charset="UTF-8"></script>
<script>
function loginNew(appid,serverid,serverip,str ){
var openid = '<%=openid%>';
var openkey ='<%=openkey%>';
var pf = '<%=pf%>';
var pfkey = '<%=pfkey%>';
var success = '<%=success%>';
var serverId = serverid;
var serverIp = serverip;
var tmp = document.createElement("form");
var action="./Loading?openid=<%=openid%>&pf=<%=pf%>&openkey=<%=openkey%>&pfkey=<%=pfkey%>&serverId=" + serverId + "&serverIp=" + serverIp + "&success=<%=success%>"
     tmp.action = action;
     tmp.method = "post";
     document.body.appendChild(tmp);
     tmp.submit();
     return tmp;
}
</script>
</head>
<body>

<div class="w717">
    <div class="wy_name s_sp"><b class="fl mt6 wy_favicon"></b><h3 class="fl stroke">应用ID:100719210</h3></div>
    <div class="wy_box s_bd">
        <div class="wy_fastinfo c"><ul class="wy_notice"><li><i class="wyico1 wy_ico"></i><em id="notice"> 恭喜本应用隆重发布</em></li></ul><p class="wy_like fr"><!--iframe src="http://open.qzone.qq.com/like?url=http%3A%2F%2Fuser.qzone.qq.com%2F706290408&width=400&height=30&type=button_num" allowtransparency="true" scrolling="no" border="0" frameborder="0" style="width:160px;height:30px;border:none;overflow:hidden;"></iframe--></p><p class="fr"><!--a href="#" class="wy_wb fl c"><i class="wyico2 wy_ico fl"></i><b class="fl">寻侠</b></a><a href="#" class="fl txt_a1 plr5">立即收听</a--></p></div>
        <div class="wy_navbox mb10"><ul class="c"><li><a  class="wyNav wycur s_sp">选择服务器</a></li><!--li><a href="#" class="wyNav s_sp">邀请好友</a></li><li><a href="#" class="wyNav s_sp">游戏介绍</a></li><li><a href="#" class="wyNav s_sp">进入官网</a></li><li><a href="#" class="wyNav s_sp">游戏充值</a></li><li><a href="#" class="wyNav s_sp">论坛</a></li--></ul></div>
        <div class="wy_banner bd_b mb10"><p class="wy_banner_pic"></p></div>
        <!--推荐\最近服务器列表-->
        <div id="zjdl">
            <div class="wy_serverT"><div><h4>推荐服务器</h4><a href="#" class="wy_lastLogin"><span onclick="">点击查看所有服务器</span></a></div></div>
            <div class="wy_recommend">
                <div class="wy_recommend_btn">
                	 <%int l = serverlist.size();
                	 if(l!=0){
             for(int i = 0; i < l; i++){
             ServerDetail server = serverlist.get(i);
             if(server.getStatue_on()==1){
             if(server.getStatue_tui()==1){
             i=l;%>
                     <a href="javascript:loginNew(100673142,<%= server.getId()%>,'<%= server.getIp()%>','release');">
                        <em><%=server.getName() %></em>
                    	<span>进入游戏</span>                    
                     </a>
                
             <% }}}} %>
                
                       <!--  <a href="javascript:loginNew(100673142,1,'release');">
                        <em>一线一区   观音寺</em>
                        <span>进入游戏</span></a> -->
            </div>                
            <div class="wy_serStatus">
                    <p>我们根据您使用的网络环境为您推荐左侧服务器</p>
                    <i class="wy_ico_b wy_ico"></i><b>繁忙</b><i class="wy_ico_c wy_ico"></i><b>拥挤</b><i class="wy_ico_o wy_ico"></i><b>畅通</b><i class="wy_ico_m wy_ico"></i><b>维护</b>
                </div>
            </div>
            <!--<div class="tabMenu">
             <ul class="c"><li><strong>推荐服务器</strong></li></ul>
             </div>
            -->
            <div class="tabCnt zjtj_server">
                <ul class="wy_serList zltj_server c">
                <% l = serverlist.size();
                if(l!=0){
             for(int i = 0; i < l; i++){
             ServerDetail server = serverlist.get(i);
             if(server.getStatue_on()==1){
             if(server.getStatue_tui()==1){
             i=l;%>
             	<li><%if(server.getStatue_mag()==4){ %>
             		<a href="javascript:alert('很抱歉，服务器处于停机状态，无法进入！');">
                    <%}else{ %>
                     <a href="javascript:loginNew(100673142,<%= server.getId()%>,'<%= server.getIp()%>','release');">
                    <%} %>
                        <em class="fl"><%=server.getName() %></em>
                        <%if(server.getStatue_mag()==1){ %>
                   			<b class="wy_ico_b wy_ico"></b>  
                    	<%}else if(server.getStatue_mag()==2){ %>
                    		<b class="wy_ico_c wy_ico"></b>
                    	<%}else if(server.getStatue_mag()==3){ %>
                    		<b class="wy_ico_o wy_ico"></b> 
                    	<%}else if(server.getStatue_mag()==4){ %>
                  			<b class="wy_ico_m wy_ico"></b>
                    	<%} %>
                    	<%if(server.getStatue_xin()==1){ %>
                   			<b class="wy_ico_new wy_ico"></b>  
                    	<%} %>
                    	<%if(server.getStatue_tui()==1){ %>
                   			<b class="wy_ico_j wy_ico"></b>
                    	<%} %>                     
                     </a>
                </li>
             <% }}} }%>
               <!--  <li>
        			<a href="javascript:loginNew(100673142,1,'release');">
            			<em class="fl">一线一区   观音寺</em>
            			<b class="wy_ico_o wy_ico"></b>            
            			<b class="wy_ico_new wy_ico"></b>
            			<b class="wy_ico_j wy_ico"></b>        
            		</a>
    			</li> -->
            	</ul>            
            </div>
            <div class="tabbox_x c">
                <div class="wy_serverT"><div><h4>最近登录服务器</h4></div></div>
                <div class="tabMenu">
                    <ul class="c">
                        <li id="dlnav0" onClick="settab('dlnav',0,2)" class="hover"><b>上次登录</b></li>
                        <li id="dlnav1" onClick="settab('dlnav',1,2)"><b>我的服务器</b></li>
                    </ul>
                </div>
     <div class="tabCnt">
        <div id="con_dlnav_0">
          <ul class="wy_serList zjdl_list c">
          	<%
          	if(roleServerlist.size()!=0){
             for(int i = 0; i < 1; i++){
             ServerDetail server = roleServerlist.get(i);
             if(server.getStatue_on()==1){%>
             	<li><%if(server.getStatue_mag()==4){ %>
             		<a href="javascript:alert('很抱歉，服务器处于停机状态，无法进入！');">
                    <%}else{ %>
                     <a href="javascript:loginNew(100673142,<%= server.getId()%>,'<%= server.getIp()%>','release');">
                    <%} %>
                        <em class="fl"><%=server.getName() %></em>
                        <%if(server.getStatue_mag()==1){ %>
                   			<b class="wy_ico_b wy_ico"></b>  
                    	<%}else if(server.getStatue_mag()==2){ %>
                    		<b class="wy_ico_c wy_ico"></b>
                    	<%}else if(server.getStatue_mag()==3){ %>
                    		<b class="wy_ico_o wy_ico"></b> 
                    	<%}else if(server.getStatue_mag()==4){ %>
                  			<b class="wy_ico_m wy_ico"></b>
                    	<%} %>
                    	<%if(server.getStatue_xin()==1){ %>
                   			<b class="wy_ico_new wy_ico"></b>  
                    	<%} %>
                    	<%if(server.getStatue_tui()==1){ %>
                   			<b class="wy_ico_j wy_ico"></b>
                    	<%} %>                     
                     </a>
                     <span class="time"><%=server.getTime()%></span>
                </li>
             <% }}} %>
           <!--  <li>
        		<a href="javascript:loginNew(100673142,2,'release');">
           		 	<em class="fl">一线二区   黑风洞</em>
            		<b class="wy_ico_o wy_ico"></b>                    
            	</a>
        		<span class="time">2013年08月26日 19:38</span>
    		</li>-->
        </ul>
         </div>
         <div id="con_dlnav_1" style="display:none">
            <ul class="wy_serList zjdl_list c">
            	 <% l = roleServerlist.size();
            	 if(l>5){
            	 l=5;}
            	 if(l!=0){
             for(int i = 0; i < l; i++){
             ServerDetail server = roleServerlist.get(i);
             if(server.getStatue_on()==1){%>
             	<li><%if(server.getStatue_mag()==4){ %>
             		<a href="javascript:alert('很抱歉，服务器处于停机状态，无法进入！');">
                    <%}else{ %>
                     <a href="javascript:loginNew(100673142,<%= server.getId()%>,'<%= server.getIp()%>','release');">
                    <%} %>
                        <em class="fl"><%=server.getName() %></em>
                        <%if(server.getStatue_mag()==1){ %>
                   			<b class="wy_ico_b wy_ico"></b>  
                    	<%}else if(server.getStatue_mag()==2){ %>
                    		<b class="wy_ico_c wy_ico"></b>
                    	<%}else if(server.getStatue_mag()==3){ %>
                    		<b class="wy_ico_o wy_ico"></b> 
                    	<%}else if(server.getStatue_mag()==4){ %>
                  			<b class="wy_ico_m wy_ico"></b>
                    	<%} %>
                    	<%if(server.getStatue_xin()==1){ %>
                   			<b class="wy_ico_new wy_ico"></b>  
                    	<%} %>
                    	<%if(server.getStatue_tui()==1){ %>
                   			<b class="wy_ico_j wy_ico"></b>
                    	<%} %>                     
                     </a>
                     <span class="time"><%=server.getTime()%></span>
                </li>
             <% }} }%>
            	<!--<li>
        			<a href="javascript:loginNew(100673142,1,'release');">
            			<em class="fl">一线一区   观音寺</em>
            			<b class="wy_ico_o wy_ico"></b>                    </a>
        				<span class="time">2013年08月26日 19:38</span>
    			</li>
                <li>
        			<a href="javascript:loginNew(100673142,2,'release');">
            			<em class="fl">一线一区   黑风洞</em>
            			<b class="wy_ico_o wy_ico"></b>                    </a>
        				<span class="time">2013年08月26日 19:36</span>
    			</li>-->
        </ul>
                        <div style="padding:10px;float:right;">本栏目最多显示5个我最近登录过的服务器</div>
                    </div>
                </div>
            </div>
        </div>
        <!--推荐\最近服务器列表End-->
        <!--所有服务器列表-->
        <div id="sevlist">
            <div class="wy_serverT"><div><h4 id="font1">所有服务器</h4>
                    <a href="#" class="wy_lastLogin zjdl"><span onclick="zjdllist()">返回首页</span></a></div></div>
<div class="tabbox_x c">
    <!--div class="wy_serStatus"><i class="wy_ico_b wy_ico"></i><b>繁忙</b><i class="wy_ico_c wy_ico"></i><b>拥挤</b><i class="wy_ico_o wy_ico"></i><b>畅通</b><i class="wy_ico_m wy_ico"></i><b>维护</b></div-->
    <div class="tabMenu">
        <ul class="c">
                                                <li id="daqu0" onclick="settabcls('daqu',0,1)" class="hover" >颠倒西游</li>
                                            </ul>
    </div>
    <div class="tabCnt">
        <div id="con_daqu_0" >
             <ul class="wy_serList c">
             <% l = serverlist.size();
             if(l!=0){
             for(int i = 0; i < l; i++){
             ServerDetail server = serverlist.get(i);
             if(server.getStatue_on()==1){%>
             	<li><%if(server.getStatue_mag()==4){ %>
             		<a href="javascript:alert('很抱歉，服务器处于停机状态，无法进入！');">
                    <%}else{ %>
                     <a href="javascript:loginNew(100673142,<%= server.getId()%>,'<%= server.getIp()%>','release');">
                    <%} %>
                        <em class="fl"><%=server.getName() %></em>
                        <%if(server.getStatue_mag()==1){ %>
                   			<b class="wy_ico_b wy_ico"></b>  
                    	<%}else if(server.getStatue_mag()==2){ %>
                    		<b class="wy_ico_c wy_ico"></b>
                    	<%}else if(server.getStatue_mag()==3){ %>
                    		<b class="wy_ico_o wy_ico"></b> 
                    	<%}else if(server.getStatue_mag()==4){ %>
                  			<b class="wy_ico_m wy_ico"></b>
                    	<%} %>
                    	<%if(server.getStatue_xin()==1){ %>
                   			<b class="wy_ico_new wy_ico"></b>  
                    	<%} %>
                    	<%if(server.getStatue_tui()==1){ %>
                   			<b class="wy_ico_j wy_ico"></b>
                    	<%} %>                     
                     </a>
                </li>
             <% }}} %>
               <!--  <li>
                    <a href="javascript:loginNew(100673142,1,'release');">
                        <em class="fl">一线一区   观音寺</em>
                        <b class="wy_ico_o wy_ico"></b>                        
                        <b class="wy_ico_new wy_ico"></b>
                        <b class="wy_ico_j wy_ico"></b>                    
                     </a>
                </li>
                <li>
                	<a href="javascript:alert('很抱歉，服务器处于停机状态，无法进入！');">
                		<em class="fl">五服</em><b class="wy_ico_m wy_ico"></b>
                	</a>
                </li>
                <li>
                	<a href="javascript:alert('很抱歉，服务器处于停机状态，无法进入！');">
                		<em class="fl">六服</em>
                		<b class="wy_ico_m wy_ico"></b>
                	</a>
                </li>
                <li>
                	<a href="javascript:alert('很抱歉，服务器处于停机状态，无法进入！');">
                		<em class="fl">九服</em><b class="wy_ico_m wy_ico"></b>
                	</a>
                </li> -->
              
            </ul>
        </div>
                                <em id="sFrom" style="display:none">qzone</em>
    </div>
</div>       
 </div>
        <!--所有服务器列表End-->
    </div>
</div>
<script type="text/javascript" src="http://openwebgame.qq.com/html/js/loginmanagerv2.js?onlyCookie=1" charset="gb2312"></script>
<script type="text/javascript" charset="utf-8" src="http://qzonestyle.gtimg.cn/open/fusion/fullscreen.js"></script>

<script type="text/javascript">
//用于最近登录和所有服务器间切换
function serlist()
{
	document.getElementById("sevlist").style.display="block";
	document.getElementById("zjdl").style.display="none";
}
function zjdllist()
{
	document.getElementById("zjdl").style.display="block";
	document.getElementById("sevlist").style.display="none";
}
//用于切换大区的class变化
function settab(name,cursel,n){
	for(i=0;i<n;i++){
		var menu=document.getElementById(name+i);
		var con=document.getElementById("con_"+name+"_"+i);
		menu.className=i==cursel?"hover":"";
		con.style.display=i==cursel?"block":"none"; 
	}
}
function changeTab(id) {
       var i=0;
       var total = 0;
                   total = 1;
       
       for( i=0; i<=total; i++ ){
          var daqu = "daqu_"+i;
          var area_server = "area_"+i;
          $("#"+daqu).attr("class","");
          $("#"+area_server).css('display','none');
       }
       select_daqu = "daqu_"+id;
       select_area_server = "area_"+id;
       $("#"+select_daqu).attr("class","hover");
       $("#"+select_area_server).css('display','block');
}

</script>
<script type="text/javascript" src="http://ossweb-img.qq.com/images/js/jquery/jquery-1.5.1.min.js" charset="gb2312"></script>
<script type="text/javascript" src="http://ossweb-img.qq.com/images/js/basic.js" charset="gb2312"></script>
<script type="text/javascript" src="/html/js/fajax-min.js" charset="gb2312"></script>
<script type="text/javascript" src="/html/js/CommWebGameSelect.js"></script>
</body>
</html>