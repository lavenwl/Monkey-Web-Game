package com.stang.game.ffd.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityCaseLogDetail;
import com.stang.game.ffd.entity.detail.EntityCheckBattleDetail;
import com.stang.game.ffd.entity.detail.EntityCheckNoviceDetail;
import com.stang.game.ffd.entity.detail.EntityOrderInfoDetail;
import com.stang.game.ffd.entity.detail.EntitySellDetail;

public interface ICaseLogService extends IBaseService<EntityCaseLogDetail> {
	
	 public List<EntityCaseLogDetail> getAllPoint(Map<String,Object> parms);
	/*
	 * 根据表名查询所有数据采集点
	 * */
	 public List<EntityCaseLogDetail> getAllPoint(String tableName);
	 
	 public List<EntityCaseLogDetail> getAllPointMaxOnline(Map<String,Object> parms);
	 /**
	  * @description 获取所有的日期的天数
	  * @param liste
	  * @return 数据有多少天的数据
	  */
	 public List<EntityCaseLogDetail> getAllDateList(List<EntityCaseLogDetail> liste);
	 /**
	  * @description 获取所有的日期的天数
	  * @param liste
	  * @return 数据有多少天的数据
	  */
	 public ArrayList<String> getAllDateListSell(List<EntitySellDetail> lesd);
	 
	 /**
	  * @description 获取时间区间里面的数据的天数
	  * @param liste
	  * @return 数据有多少天的数据
	  */
	 public List<EntityCaseLogDetail> getAllDateListTimeToTime(List<EntityCaseLogDetail> liste,String createTime1,String createTime2);
	 
	 /**
	  * @description 获取充值时间区间里面的数据的天数
	  * @param liste
	  * @return 数据有多少天的数据
	  */
	 public ArrayList<String> getAllDateListPay(List<EntityOrderInfoDetail> leoid);
	 
	 
	 /**
	  * @method getAllUserOnline
	  * @param liste
	  * @return int
	  * @description 获取所有的在线用户
	  */
	 public int getAllUserOnline(List<EntityCaseLogDetail> liste);

	 /**
	  * @method getAllUserOnlineMax
	  * @param liste,crateTime
	  * @return List<EntityCaseLogDetail>
	  * @description 获取所有的在线用户
	  */
	 public int getAllUserOnlineMax(List<EntityCaseLogDetail> liste,String createTime);
	 
	 /**
	  * @method getAllUserOnlineMax
	  * @param liste,crateTime1,createTime2
	  * @return List<EntityCaseLogDetail>
	  * @description 获取选定时间区间内所有的在线用户
	  */
	 public int getAllUserOnlineMax(List<EntityCaseLogDetail> liste,String createTime1,String createTime2);
	 
	 /**
	  * @method getAllUserRegCreateRole
	  * @param liste,_datetime
	  * @return int
	  * @description 根据时间获取成功创建 角色的玩家个数
	  */
	 public int getAllUserRegCreateRole(List<EntityCaseLogDetail> liste,String _datetime);
	 
	 /**
	  * @method getUniqueUser
	  * @param liste,createTime1,createTime2
	  * @return int
	  * @description 根据时间获取成功创建 角色的玩家个数
	  */
	 public List<EntityCaseLogDetail> getUniqueUser(List<EntityCaseLogDetail> liste,String createTime1,String createTime2);
	 
	 /**
	  * @method getUniqueUser
	  * @param liste,createTime1,createTime2
	  * @return int
	  * @description 根据时间获取成功创建 角色的玩家个数
	  */
	 public List<EntityCaseLogDetail> getUniqueUser(List<EntityCaseLogDetail> liste,String createTime); 
	 
	 /**
	  * @method getAllUserReg
	  * @param liste
	  * @param _datetime
	  * @return int
	  * @description 根据时间获取成功注册的玩家数
	  */
	 public int getAllUserReg(List<EntityCaseLogDetail> liste,String _datetime);
	
	 /**
	  * @method getAllUserReg
	  * @param liste
	  * @param _datetime
	  * @return int
	  * @description 根据时间区间获取成功注册的玩家数
	  */
	 public List<EntityCaseLogDetail>  getAllUserReg(List<EntityCaseLogDetail> liste,String createTime1,String createTime2);

	 
	 /**
		 * @method getAllUserRegAll
		 * @param LIst {getAllUserReg} 确定记录的唯一标识组，供数据库查询
		 * @return {Int}
		 * @description 获取所有的注册用户包含哪些没有成功进入游戏的玩家。不排除重复显示的是登陆的次数
		 */
	 public int getAllUserRegAll(List<EntityCaseLogDetail> liste,String _datetime);
	
	 /**
		 * @method getAllUserRegLoding
		 * @param LIst {EntityCaseLogDetail} 确定记录的唯一标识组，供数据库查询
		 * @return {Int}
		 * @description 根据时间获取所有注册玩成功进入游戏的人数，进入游戏主菜单 code5
		 */
	 public int getAllUserRegLoding(List<EntityCaseLogDetail> liste,String _datetime);
	 
	 /**
		 * @method getAllUserRegLodingAll
		 * @param LIst {EntityCaseLogDetail} 确定记录的唯一标识组，供数据库查询
		 * @return {Int}
		 * @description 根据时间获取所有注册玩成功进入游戏的人数，进入游戏主菜单 code5
		 */
	 public int getAllUserRegLodingAll(List<EntityCaseLogDetail> liste,String _datetime);
	 
	 /**
		 * @method getAllUserRegLodingAll
		 * @param LIst {EntityCaseLogDetail} 确定记录的唯一标识组，供数据库查询
		 * @return {Int}
		 * @description 根据时间区域获取所有注册玩成功进入游戏的人数，进入游戏主菜单 code5
		 */
	 public List<EntityCaseLogDetail> getAllUserRegLoding(List<EntityCaseLogDetail> liste,String createTime1,String createTime2);
	 
	 public int getAllUserRegLoding(List<EntityCaseLogDetail> lecld,List<EntityCaseLogDetail> lecld2);
	 
	 
	 /**
	  * @method getAllUserCount
	  * @param List {EntityCaseLogDetail}
	  * @return {int}
	  * @description 根据时间获得“有效的”登陆用户的登录次数()
	  * */
	 public int getAllUserCount(List<EntityCaseLogDetail> liste,String _datetime);
	 
	 /**
	  * @method getAllUserCount
	  * @param List {EntityCaseLogDetail}
	  * @return {int}
	  * @description 根据时间获得“所有”登陆用户的登录次数()
	  * */
	 public int getAllUserCountAll(List<EntityCaseLogDetail> liste,String _datetime);
	 
	 /*获得所有进入游戏的次数*/
	 public int getAllUserLoginAll(List<EntityCaseLogDetail> liste,String _datetime);
	 
	 /*根据时间来获得成功进入游戏的玩家数*/
	 public int getAllUserLogin(List<EntityCaseLogDetail> liste,String _datetime);
	 
	 /*最高在线*/
	 public int getUserOnlineMax(List<EntityCaseLogDetail> liste);
	 
	 /*平均在线*/
	 public int getUserOnlineAvg(List<EntityCaseLogDetail> liste);
	 
	 /**
	  * @method getBuyRmbItem
	  * @param List{EntityCaseLogDetail}
	  * @return {int}
	  * @description 获得用rmb 买的道具信息
	  * */
	 public List<EntityCaseLogDetail> getBuyRmbItem(List<EntityCaseLogDetail> liste,String _datetime);
	 
	 /**
	  * @method getBuyRmbItem
	  * @param List{EntityCaseLogDetail}
	  * @return {int}
	  * @description 获得用rmb 买的道具信息
	  * */
	 public List<EntityCaseLogDetail> getBuyRmbItem(List<EntityCaseLogDetail> liste,String crateTime1,String crateTime2);
	 
	 /**
	  * @method getBuyGiftItem
	  * @param List{EntityCaseLogDetail}
	  * @return {int}
	  * @description 获得用Gift 买的道具信息
	  * */
	 public List<EntityCaseLogDetail> getBuyGiftItem(List<EntityCaseLogDetail> liste,String _datetime);
	 /**
	  * @method getBuyGoldItem
	  * @param List{EntityCaseLogDetail}
	  * @return {int}
	  * @description 获得用游戏币买的道具信息
	  * */
	 public List<EntityCaseLogDetail> getBuyGoldItem(List<EntityCaseLogDetail> liste,String _datetime);
	 
	 /**
	  * @method getUseRmbItem
	  * @param List{EntityCaseLogDetail}
	  * @return {int}
	  * @description 获得“使用”礼金买的道具信息
	  * */
	 public List<EntityCaseLogDetail> getUseRmbItem(List<EntityCaseLogDetail> liste,String _datetime);
	 
	 /**
	  * @method getUseGiftItem
	  * @param List{EntityCaseLogDetail}
	  * @return {int}
	  * @description 获得“使用”礼金买的道具信息
	  * */
	 public List<EntityCaseLogDetail> getUseGiftItem(List<EntityCaseLogDetail> liste,String _datetime);

	 
	 /**
	  * @method getUseGoldItem
	  * @param List{EntityCaseLogDetail}
	  * @return {int}
	  * @description 获得“使用”游戏币买的道具信息
	  * */
	 public List<EntityCaseLogDetail> getUseGoldItem(List<EntityCaseLogDetail> liste,String _datetime);
	 

	 /**
	  * @method getAvataItem
	  * @param List{EntityCaseLogDetail},typeid
	  * @return {List<EntityCaseLogDetail>}
	  * @description 获得所有avata相关的数据
	  * */
	 public List<EntityCaseLogDetail> getAvataItem(List<EntityCaseLogDetail> liste,int  _type);

	 /**
	  * @method getIntensify
	  * @param List{EntityCaseLogDetail}
	  * @return {List<EntityCaseLogDetail>}
	  * @description 获得所有的强化记录
	  */
	 public List<EntityCaseLogDetail> getIntensify(List<EntityCaseLogDetail> liste,String _datetime);
	 
	 /**
	  * @method getIntensifyItem
	  * @param List{EntityCaseLogDetail}
	  * @return {List<EntityCaseLogDetail>}
	  * @description 获得所有的强化出来的道具
	  */
	 public List<EntityCaseLogDetail> getIntensifyItem(List<EntityCaseLogDetail> liste,String _datetime);

	 /**
	  * @method getSynthesis
	  * @param List{EntityCaseLogDetail}
	  * @return {List<EntityCaseLogDetail>}
	  * @description 获得所有合成的记录数
	  */
	 public List<EntityCaseLogDetail> getSynthesis(List<EntityCaseLogDetail> liste,String _datetime);
	 
	 /**
	  * @method getSynthesisItem
	  * @param List{EntityCaseLogDetail}
	  * @return {List<EntityCaseLogDetail>}
	  * @description 获得所有合成的结果
	  */
	 public List<EntityCaseLogDetail> getSynthesisItem(List<EntityCaseLogDetail> liste,String _datetime);
	 /**
	  * @method searchNovice
	  * @param List{EntityCheckNoviceDetail}
	  * @return {List<EntityCheckNoviceDetail>}
	  * @description 获取所有的新手引导的步骤
	  */
	 public EntityCheckNoviceDetail getNovice(List<EntityCaseLogDetail> lecld,String date);
	 
	 /**
	  * @method staicPublic
	  * @param List{EntityCheckNoviceDetail}
	  * @return {List<EntityCheckNoviceDetail>}
	  * @description 获取所有的新手引导的步骤
	  */
	 public List<EntityCaseLogDetail> staicPublic(List<EntityCaseLogDetail> liste,String _datetime,int caseid);
	
	 public List<EntityCaseLogDetail> noRepleAll(List<EntityCaseLogDetail> liste,int caseid);
	 
	 public List<EntityCaseLogDetail> noRepleAll(List<EntityCaseLogDetail> liste,int caseid,String _datetime);
	 
	 /**
	  * @description 返回在一定时间内的数据，包含同样数据
	  * @param lists
	  * @param caseid
	  * @param _datetime
	  * @return
	  */
	 public List<EntityCaseLogDetail> repleAll(List<EntityCaseLogDetail> liste,int caseid,String _datetime);
	 
	 public List<EntityCaseLogDetail> repleAll(List<EntityCaseLogDetail> liste,int caseid);
	 
	 public List<EntityCaseLogDetail> checkTask(List<EntityCaseLogDetail> lecld ,String _dateTime);
	 
	 public List<EntityCaseLogDetail> checkBattle(List<EntityCaseLogDetail>lecld,String _dateTime);
	  
	 public List<Map<String,Object>> getCaseLogNovice(Map<String,Object> parms);
	 
	 public String checkOnlineNum(List<EntityCaseLogDetail> param);
	 
	 /**
	  * 根据不同的值来读取分类的值
	  */
	 public List<EntityCaseLogDetail> getAllPointByParams(Map<String,Object> params);
	 public int getAllUserRegLoding(List<EntityCaseLogDetail> liste);
	 public int getAllUserLoding(List<EntityCaseLogDetail> liste,int caseid1,int caseid2);
	 public List<EntityCaseLogDetail> getAllMaxOnlineByLike(Map<String,Object> params);
	 public List<EntityCaseLogDetail> getAllInfoLike(Map<String,Object> params);
	 public List<EntityCaseLogDetail> getAllInfoLikes(Map<String,Object> params);
	 public List<EntityCaseLogDetail> getQh(Map<String,Object> params);
	 public List<Map<String,Object>> checkOnlineTime(List<EntityCaseLogDetail> lecld2,List<EntityCaseLogDetail> lecld4);
	 public List<Map<String,Object>> checkOnlineTime(List<EntityCaseLogDetail> lecld);
	 /**
	  * 获取在线时长的 特殊倒序
	  * @param param
	  * @return
	  */
	 public List<EntityCaseLogDetail> getOnlineTime(Map<String,Object> param);
	 
	 public int getRegMan(Map<String,Object> param);
	 
	 public int getNoRepleAllCount(Map<String,Object> param);
	 
	 public List<EntityCaseLogDetail> getNewPlayer(Map<String,Object> param);
	 
	 public List<EntityCaseLogDetail> getOnlineTimeForUser(Map<String,Object> param);
	 
	 public EntityCheckNoviceDetail getNovice(List<Map<String,Object>> lmap);
	 
	 public List<Map<String,Object>> checkOnlineTimeForUser(List<EntityCaseLogDetail> lecld);
}
