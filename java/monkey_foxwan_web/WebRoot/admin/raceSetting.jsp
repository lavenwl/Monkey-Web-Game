<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.stang.game.ffd.service.impl.GameItemServiceImpl"%>
<%@page import="com.stang.game.ffd.service.IGameItemService"%>
<%@page import="com.stang.game.ffd.entity.detail.EntityGameItemDetail"%>
<%@page import="com.stang.game.ffd.entity.detail.EntityGameItemsDetail"%>
<%@page import="com.stang.game.ffd.dao.impl.GameSceneDaoImpl"%>
<%@page import="com.stang.game.ffd.entity.detail.GameSceneDetail"%>
<%@page import="com.stang.game.ffd.entity.detail.EntityGameEquipDetail"%>
<%@page import="com.stang.game.ffd.service.impl.GameEquipServiceImpl"%>
<%@page import="com.stang.game.ffd.service.impl.GamePlaneServiceImpl"%>
<%@page import="com.stang.game.ffd.entity.detail.EntityGamePlaneDetail"%>
<%@page import="com.stang.game.ffd.entity.detail.EntityGameAvatarDetail"%>
<%@page import="com.stang.game.ffd.service.impl.GameAvatarServiceImpl"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'raceSetting.jsp' starting page</title>
		<%@ taglib prefix="s" uri="/struts-tags"%>
		<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/WebCalendar.js"></SCRIPT>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

	</head>

	<body>
		<div id="giftListDiv"
			style="z-index: 1; display: none; position: absolute; BORDER-RIGHT: 3px outset; BORDER-TOP: 3px outset; BACKGROUND: #ffffff; BORDER-LEFT: 3px outset; BORDER-BOTTOM: 3px outset;"
			align=left>
			<center>
				<a href="#" onclick="functionCloseGiftList()">关&nbsp;闭</a>
			</center>
			<hr>
			金币：
			<input type="text" onblur="functionGetGiftGold(value)">
			点券：
			<input type="text" onblur="functionGetGiftMoney(value)">
			<hr>
			<table border=0>
				<%
					int i = 0;
					int j = 0;
				%>
				<tr
					<%=j % 4 == 0 ? "style='background-color:#dddddd'"
					: "style='background-color:#eeeeee'"%>>

					<%
						HashMap<String, Object> param = new HashMap<String, Object>();
						List<EntityGameEquipDetail> equipList = new GameEquipServiceImpl()
								.getAllInfo(param);
						for (EntityGameEquipDetail equip : equipList) {
					%>
					<td>
						<input type="checkbox"
							onCLick="functionGetGift('<%=equip.getEquipName()%>','2-1-<%=equip.getId()%>')" /><%=equip.getEquipName()%></td>
					<%
						if (++i % 6 == 0) {
								j++;
					%>
				</tr>
				<tr
					<%=j % 4 == 0 ? "style='background-color:#dddddd'"
									: "style='background-color:#eeeeee'"%>>
					<%
						}
					%>

					<%
						}
					%>
				</tr>
				<tr>
					<td colspan=6>
						<hr>
					</td>
				</tr>
				<tr>
					<td colspan=6>
						<hr>
					</td>
				</tr>
				<tr
					<%=j % 4 == 0 ? "style='background-color:#dddddd'"
					: "style='background-color:#eeeeee'"%>>
					<%
						i = 0;
						List<EntityGamePlaneDetail> planeList = new GamePlaneServiceImpl()
								.getAllInfo(param);
						for (EntityGamePlaneDetail plane : planeList) {
					%>
					<td>
						<input type="checkbox"
							onCLick="functionGetGift('<%=plane.getPlaneName()%>','1-1-<%=plane.getId()%>')" /><%=plane.getPlaneName()%></td>
					<%
						if (++i % 6 == 0) {
								j++;
					%>
				</tr>
				<tr
					<%=j % 4 == 0 ? "style='background-color:#dddddd'"
									: "style='background-color:#eeeeee'"%>>
					<%
						}
					%>
					<%
						}
					%>
				</tr>

				<tr>
					<td colspan=6>
						<hr>
					</td>
				</tr>
				<tr
					<%=j % 4 == 0 ? "style='background-color:#dddddd'"
					: "style='background-color:#eeeeee'"%>>
					<%
						i = 0;
						List<EntityGameAvatarDetail> avatarList = new GameAvatarServiceImpl()
								.getAllInfo(param);
						for (EntityGameAvatarDetail avatar : avatarList) {
					%>
					<td>
						<input type="checkbox"
							onCLick="functionGetGift('<%=avatar.getAvatarName()%>','4-1-<%=avatar.getId()%>')" /><%=avatar.getAvatarName()%></td>
					<%
						if (++i % 6 == 0) {
								j++;
					%>
				</tr>
				<tr
					<%=j % 4 == 0 ? "style='background-color:#dddddd'"
									: "style='background-color:#eeeeee'"%>>
					<%
						}
					%>
					<%
						}
					%>
				</tr>
				<tr
					<%=j % 4 == 0 ? "style='background-color:#dddddd'"
					: "style='background-color:#eeeeee'"%>>
					<%
						i = 0;
						List<EntityGameItemsDetail> itemList = new GameItemServiceImpl()
								.getAllInfo(param);
						for (EntityGameItemsDetail item : itemList) {
					%>
					<td>
						<input style="width: 15px"
							onblur='functionGetGiftItem("<%=item.getItemName()%>","<%=item.getId()%>",value)' /><%=item.getItemName()%></td>
					<%
						if (++i % 6 == 0) {
								j++;
					%>
				</tr>
				<tr
					<%=j % 4 == 0 ? "style='background-color:#dddddd'"
									: "style='background-color:#eeeeee'"%>>
					<%
						}
					%>
					<%
						}
					%>
				</tr>
			</table>
			<hr>
			<center>
				<a href="#" onclick="functionCloseGiftList()">关&nbsp;闭</a>
			</center>
		</div>

		<font size=2><a href="checkRaceing.jsp">(查看修改比赛)</a></font>
		<s:form action="createRace.action" method="post"
			onsubmit="return checkAll()">
			<font color=red size=10><b>${ tip }</b> </font>
			<table border="1">
				<tr>
					<td colspan="4">
						比赛设定
					</td>
				</tr>
				<tr>
					<td>
						比赛名称：
					</td>
					<td>
						<input type="text" name="raceName" id="raceName">
					</td>
					<td>
						名额限制:
					</td>
					<td>
						<input type="text" name="maxNum" id="maxNum">
					</td>
				</tr>
				<tr>
					<td>
						比赛报名开始:
					</td>
					<td>
						<input name="signUpStartTime" id="signUpStartTime" type="text"
							value="" onclick ="SelectDate(this,'yyyy-MM-dd hh:mm:ss')"
							readonly="true" style="cursor: pointer; background-color: white; " />
					</td>
					<td>
						队伍人数:
					</td>
					<td>
						<select name="teamNum" id="teamNum">
							<option value="1">1v1</option>
							<option value="2">2v2</option>
							<option value="3">3v3</option>
							<option value="4">4v4</option>
						</select>
					</td>
				</tr>
				<tr><td>
						比赛报名结束:
					</td>
					<td>
						<input name="signUpEndTime" id="signUpEndTime" type="text"
							value="" onclick="SelectDate(this,'yyyy-MM-dd hh:mm:ss')"
							readonly="true" style="cursor: pointer; background-color: white;" />
					</td>
					<td>
						报名等级:
					</td>
					<td>
						<input type="text" name="startLevel" maxlength="2" id="startLevel" style="width: 55px" value ="1">—<input type="text" name="endLevel" id="endLevel" style="width: 55px" maxlength="2" value="30">
					</td>
				</tr>
				<tr>
					<td>
						比赛开始时间:
					</td>
					<td>
						<input name="startTime" id="startTime" type="text" value=""
							onclick="SelectDate(this,'yyyy-MM-dd hh:mm:ss')"
							readonly="true" style="cursor: pointer; background-color: white;" />
					</td>
					<td>
						报名费:
					</td>
					<td>
						<input type="text" name="signUpMoney"id="signUpMoney" style="width: 90px" value="0" >
						<select id="signUpMoneyType" name="signUpMoneyType">
							<option value="0">金币</option>
							<option value="1">点券</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						
					</td>
				</tr>
				<tr>
					<td>
						单轮战斗场次：
					</td>
					<td>
						<input type="text" name="battleNum" id="battleNum" maxlength="2" value="1">
					</td>
					<td>
						两轮比赛间隔：
					</td>
					<td>
						<input type="text" name="timeBetweenTwoTace"
							id="timeBetweenTwoTace" style="width: 100px" value="8">(分钟)
					</td>
				</tr>
				<tr>
					<td>
						批量生成比赛：
					</td>
					<td colspan="3">
						批量生成次数：<input type="text" id="batchRaceTime" name="batchRaceTime" style="width: 25px" maxlength="2" value="1">
						比赛间隔:<input type="text" id="batchRaceSpacing" name="batchRaceSpacing" style="width: 25px" maxlength="2" value="24">小时
					</td>
				</tr>
				<tr>
					<td>
						比赛描述:
					</td>
					<td colspan="3">
						<textarea style="width: 440px; height: 64px" rows="" cols="" name="raceDes" id="raceDes"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						战斗道具设定
					</td>
				</tr>
				<tr>
					<td>
						请选择可使用的道具
					</td>
					<td colspan="3" valign="top">
						<%
							IGameItemService gisi = new GameItemServiceImpl();
								Map<String, Object> map = new HashMap<String, Object>();
								map.put("itemType", 0);
								List<EntityGameItemsDetail> list = gisi.getAllInfo(map);
								int k = 0;
								for (EntityGameItemsDetail gid : list) {
									if (k % 5 == 0) {
						%><br>
						<%
							}
						%>

						<input type="checkbox" name="items" id="items"
							value="<%=gid.getId()%>"><%=gid.getItemName()%>
						<%
							k++;
								}
						%>

					</td>
				</tr>
				<tr>
					<td colspan="4">
						地图选择
					</td>
				</tr>
				<tr>
					<td>
						选择比赛的地图
					</td>
					<td colspan="3" valign="top">
						<select id="map" name="map" multiple="multiple"
							style="width: 150px; height: 200px; overflow-y: hidden;">
							<%
								GameSceneDaoImpl gsdi = new GameSceneDaoImpl();
									Map<String, Object> mapParam = new HashMap<String, Object>();
									mapParam.put("sceneType", 2);
									List<GameSceneDetail> mapList = gsdi.getGameScene(mapParam);

									for (GameSceneDetail gsd : mapList) {
							%><option value="<%=gsd.getId()%>"><%=gsd.getSceneName()%></option>
							<%
								}
							%>
						</select>
						<font color="red" size="2">按住ctrl或shift多选地图</font>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						奖品选择
					</td>
				</tr>
				<tr>
					<td>
						选择添加比赛奖励
					</td>
					<td colspan="3">
						<div id="raceGift">
							<input type="button" value="添加新名次奖励" onclick="addNewRaceGift()">
							<br />
							1强奖品列表:
							<div id="giftDiv">
								<table>
									<tr>
										<td>
											<select id="gifts1" name="gifts1" multiple="multiple"
												style="width: 150px; height: 50px; overflow-y: hidden;">
											</select>
										</td>
										<td>
											<input type="button" value="&lt;&lt;-添加"
												onclick='document.getElementById("giftListDiv").style.display="block";nowGift=1' />
											<br />
											<input type="button" value="-&gt;&gt;移除"
												onclick="giftsDele(1)" />
										</td>
									</tr>
									<tr>
										<td>
											<input type="text" name="title1" id="title1" />
										</td>
										<td>
										(发送邮件标题)
										</td>
									</tr>
									<tr>
										<td colspan="2">
											<textarea style="width: 269px; height: 75px;g" name="content1"
												id="content1"></textarea>
										</td>
										<td>
										(发送邮件内容)
										</td>
									</tr>
								</table>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="right">
						<input type="submit" value="提交" style="width: 80px" />
					</td>
				</tr>
			</table>

		</s:form>
		<script type="text/javascript">
		function checkAll(){
			var isNum = /^\d+$/;
			if(document.getElementById("startLevel").value!=""&&!isNum.test(document.getElementById("startLevel").value)){
					alert("报名等级格式不对");
					return false;
				}
			if(document.getElementById("startLevel").value!=""&&!isNum.test(document.getElementById("endLevel").value)){
					alert("报名等级格式不对")
					return false;
			}
			if(document.getElementById("signUpMoney").value!=""&&!isNum.test(document.getElementById("signUpMoney").value)){
					alert("报名费格式不对");
					return false;
				}
			if(document.getElementById("raceName").value==null||
				document.getElementById("raceName").value==""){
					alert("请输入比赛名字");
					return false;
				}
			if(document.getElementById("raceDes").value==null||
				document.getElementById("raceDes").value==""){
					alert("请输入比赛描述");
					return false;
				}
			if(document.getElementById("maxNum").value==null||
				document.getElementById("maxNum").value==""){
					alert("请输入名额限制");
					return false;
				}else{
					if(!isNum.test(document.getElementById("maxNum").value)){
					alert("名额限制格式不对");
					return false;
					}
				}
			if(document.getElementById("teamNum").value==null||
				document.getElementById("teamNum").value==""){
					alert("请输入队伍人数");
					return false;
				}else{
					if(!isNum.test(document.getElementById("teamNum").value)){
					alert("队伍人数格式不对");
					return false;
					}else{
					if(document.getElementById("teamNum").value>4||document.getElementById("teamNum").value<1){
						alert("队伍人数必须大于0小于5");
						return false;
						}
					}
				}
			
			if(document.getElementById("startTime").value==null||
				document.getElementById("startTime").value==""){
					alert("请输入比赛开始时间");
					return false;
				}
			if(document.getElementById("signUpStartTime").value==null||
				document.getElementById("signUpStartTime").value==""){
					alert("请输入报名开始时间");
					return false;
				}
			if(document.getElementById("signUpEndTime").value==null||
				document.getElementById("signUpEndTime").value==""){
					alert("请输入报名截止时间");
					return false;
				}
				
			if(document.getElementById("battleNum").value==null||
				document.getElementById("battleNum").value==""){
					alert("请输入单轮战斗场次");
					return false;
				}else{
					if(!isNum.test(document.getElementById("battleNum").value)){
					alert("单轮战斗场次格式不对");
					return false;
					}
				}
			if(document.getElementById("timeBetweenTwoTace").value==null||
				document.getElementById("timeBetweenTwoTace").value==""){
					alert("请输入两轮比赛间隔");
					return false;
				}else{
					if(!isNum.test(document.getElementById("timeBetweenTwoTace").value)){
					alert("两轮比赛间隔格式不对");
					return false;
					}
				}
			if(document.getElementById("batchRaceTime").value == null||
				document.getElementById("batchRaceTime").value==""){
				alert("请输入生成的数量")
				return false;
			}else{
				if(!isNum.test(document.getElementById("batchRaceTime").value)){
				alert("生成数量格式不对");
				return false;
				}
			}
			if(document.getElementById("batchRaceSpacing").value == null||
				document.getElementById("batchRaceSpacing").value==""){
				alert("请输入生成的数量")
				return false;
			}else{
				if(!isNum.test(document.getElementById("batchRaceSpacing").value)){
				alert("生成数量格式不对");
				return false;
				}
			}

			var mapList = document.getElementById("map");
			for(var i=0;i<mapList.length;i++){
					if(mapList.options[i].selected){
					break;
					}
					if(i==mapList.length-1){
						alert("至少选择一张地图");
						return false;
					}
			}
			for(var i=n;i>=1;i/=2){
				var selectedList = document.getElementById("gifts"+i);
				var title = document.getElementById("title"+i);
				var content = document.getElementById("content"+i);
				if(selectedList.length<1||(title.value==null||title.value=="")||(content.value==null||content.value=="")){
					alert(i+"强比赛信息不完整");
					return false;
					}
			}
				
			for(var i=1;i<=n;i*=2){
				var selectedList = document.getElementById("gifts"+i);
					for(var j=0;j<selectedList.length;j++){
						selectedList.options[j].selected = true;
					}
				}
			return true;
		}
		function functionCloseGiftList(){
			document.getElementById("giftListDiv").style.display="none";
		}
		function functionGetGift(name,value){
			var y=document.createElement('option');
			y.text=name;
			y.value=value+"-"+y.text;
			var x=document.getElementById("gifts"+nowGift);
  			try
    		{
				x.add(y,null); // standards compliant
			}
			catch(ex)
			{
				x.add(y); // IE only
			}
		}
		function functionGetGiftItem(name,id,numS){
			var y=document.createElement('option');
			var num = parseInt(numS);
			if(isNaN(num)||num<1){
				return;
			}
			y.text=name+" X"+num;
			y.value="3-"+num+"-"+id+"-"+y.text;
			var x=document.getElementById("gifts"+nowGift);
  			try
    		{
				x.add(y,null); // standards compliant
			}
			catch(ex)
			{
				x.add(y); // IE only
			}
		}
		function functionGetGiftMoney(numS){
			var y=document.createElement('option');
			var num = parseInt(numS);
			if(isNaN(num)||num<1){
				return;
			}
			y.text="点券"+" X"+num;
			y.value="5-"+num+"-0-"+y.text;
			var x=document.getElementById("gifts"+nowGift);
  			try
    		{
				x.add(y,null); // standards compliant
			}
			catch(ex)
			{
				x.add(y); // IE only
			}
		}
		function functionGetGiftGold(numS){
			var y=document.createElement('option');
			var num = parseInt(numS);
			if(isNaN(num)||num<1){
				return;
			}
			y.text="金币"+" X"+num;
			y.value="0-"+num+"-0-"+y.text;
			var x=document.getElementById("gifts"+nowGift);
  			try
    		{
				x.add(y,null); // standards compliant
			}
			catch(ex)
			{
				x.add(y); // IE only
			}
		}
		var n=1;
		var nowGift=1;
		function addNewRaceGift(){
			n*=2;
			document.getElementById("raceGift").innerHTML = 
				document.getElementById("raceGift").innerHTML
				+"<br />"
				+n+"强奖品列表:"
				+document.getElementById("giftDiv").innerHTML.replace("giftsDele(1)","giftsDele("+n+")").replace(/\gifts1/g,"gifts"+n).replace(/title1/g,"title"+n).replace(/content1/g,"content"+n).replace("nowGift=1","nowGift="+n);
		}
		function giftsDele(n){
			var x=document.getElementById("gifts"+n);
			x.remove(x.selectedIndex);
		}

		</script>
	</body>
</html>
