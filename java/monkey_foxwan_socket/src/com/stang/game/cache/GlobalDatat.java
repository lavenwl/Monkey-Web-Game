package com.stang.game.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import java.util.*;
import com.stang.game.entity.detail.*;

public interface GlobalDatat {
	List itemcache=new ArrayList();
	JSONArray ary0 = new JSONArray();//新手引导，添加机器人
//	JSONArray ary1 = new JSONArray();
//	JSONArray ary11 = new JSONArray();
//	JSONArray ary2 = new JSONArray();
//	JSONArray ary22 = new JSONArray();
//	JSONArray ary3 = new JSONArray();
//	JSONArray ary33 = new JSONArray();
//	JSONArray ary4 = new JSONArray();
//	JSONArray ary44 = new JSONArray();
//	JSONArray ary5 = new JSONArray();
//	JSONArray ary55 = new JSONArray();
//	JSONArray ary6= new JSONArray();
//	JSONArray ary66= new JSONArray();
//	JSONArray ary7 = new JSONArray();
//	JSONArray ary77 = new JSONArray();
//	JSONArray ary8 = new JSONArray();
//	JSONArray ary88 = new JSONArray();
//	
//	JSONArray ary01 = new JSONArray();
//	JSONArray ary011 = new JSONArray();
//	JSONArray ary02 = new JSONArray();
//	JSONArray ary022 = new JSONArray();
//	JSONArray ary03 = new JSONArray();
//	JSONArray ary033 = new  ();
//	JSONArray ary04 = new JSONArray();
//	JSONArray ary044 = new JSONArray();
//	JSONArray ary05 = new JSONArray();
//	JSONArray ary055 = new JSONArray();
//	JSONArray ary06= new JSONArray();
//	JSONArray ary066= new JSONArray();
//	JSONArray ary07 = new JSONArray();
//	JSONArray ary077 = new JSONArray();
//	JSONArray ary08 = new JSONArray();
//	JSONArray ary088 = new JSONArray();
	Map<Integer, Map<Integer, JSONArray>> challenge = new HashMap<Integer, Map<Integer, JSONArray>>();
	//通关玩家数据缓存
	Map<Integer, List<Integer>> pMap = new HashMap<Integer, List<Integer>>();
	
	   Map<Integer, GameRoleDetail> cacheGameRoleDetails = new HashMap<Integer, GameRoleDetail>();
	   Map<String, CdkStoreDetail> cacheCdkStoreDetails = new HashMap<String, CdkStoreDetail>();
	   Map<Integer,ActivityDetail> cacheActivities = new HashMap<Integer, ActivityDetail>();
	   Map<Integer, AutoIdDetail> cacheAutoIdDetails = new HashMap<Integer, AutoIdDetail>();
       Map<Integer,CallGiftDetail> cacheCallGiftDetails = new HashMap<Integer, CallGiftDetail>();
       Map<Integer,ChallengeRecordDetail> cacheChallengeRecordDetails = new HashMap<Integer, ChallengeRecordDetail>();
       Map<Integer,CoinDetail> cacheCoindetails = new HashMap<Integer, CoinDetail>();
       Map<Integer,DantiaoDetail> cacheDantiaoDetails = new HashMap<Integer, DantiaoDetail>();
       Map<String,DeliveryDetail> cacheDeliveryDetails = new HashMap<String, DeliveryDetail>();
       Map<Integer,GamblingItemDetail> cacheGamblingItemDetails = new HashMap<Integer, GamblingItemDetail>();
       Map<Integer,GameAvatarDetail> cacheGameAvatarDetails = new HashMap<Integer, GameAvatarDetail>();
       Map<Integer,GameBbuffDetail> cacheGameBbuffDetails = new HashMap<Integer, GameBbuffDetail>();
       Map<Integer,GameBingDetail> cacheGameBingDetails = new HashMap<Integer, GameBingDetail>();
       Map<Integer,GameBmapDetail> cacheGameBmapDetails = new HashMap<Integer, GameBmapDetail>();
       Map<Integer,GameBskillDetail> cacheGameBskillDetails = new HashMap<Integer, GameBskillDetail>();
       Map<Integer,GameBuffDetail> cacheGameBuffDetails = new HashMap<Integer, GameBuffDetail>();
       Map<Integer,GameChartsDetail> cacheGameChartsDetails = new HashMap<Integer, GameChartsDetail>();
       Map<Integer,GameChartstwoDetail> cacheGameChartstwoDetails = new HashMap<Integer, GameChartstwoDetail>();
       Map<Integer, GameChLevelDetail> cacheGameChLevelDetails = new HashMap<Integer, GameChLevelDetail>();
       Map<Integer,GameEInsDetail> cacheGameEInsDetails = new HashMap<Integer, GameEInsDetail>();
       Map<Integer,GameEPropertyDetail> cacheGameEPropertyDetails = new HashMap<Integer, GameEPropertyDetail>();
       Map<Integer,GameEquipDetail> cacheGameEquipDetails = new HashMap<Integer, GameEquipDetail>();
       Map<Integer,GameFoeDetail> cacheGameFoeDetails = new HashMap<Integer, GameFoeDetail>();
       Map<Integer,GameFoeskillDetail> cacheGameFoeskillDetails = new HashMap<Integer, GameFoeskillDetail>();
       Map<Integer,GameItemDetail> cacheGameItemDetails = new HashMap<Integer, GameItemDetail>();
       Map<Integer,GameJingjiFinalDetail> cacheGameJingjiFinalDetails = new HashMap<Integer, GameJingjiFinalDetail>();
       Map<Integer,GameJingjiStaticDetail> cacheGameJingjiStaticDetails = new HashMap<Integer, GameJingjiStaticDetail>();
       //key:level value:gameLevel                 cacheGameLevleDetails
       Map<Integer, GameLevelDetail> cacheGameLevelDetails = new HashMap<Integer, GameLevelDetail>();
       Map<Integer,GameMapDetail> cacheGameMapDetails = new HashMap<Integer, GameMapDetail>();
       Map<Integer,GameMilitaryDetail> cacheGameMilitaryDetails = new HashMap<Integer, GameMilitaryDetail>();
       Map<Integer,GameMissionDetail> cacheGameMissionDetails = new HashMap<Integer, GameMissionDetail>();
       Map<Integer,GameMLevelDetail> cacheGameMLevelDetails = new HashMap<Integer, GameMLevelDetail>();
       Map<Integer,GamePlatsDetail> cacheGamePlatsDetails = new HashMap<Integer, GamePlatsDetail>();
       Map<Integer,GamePriceDetail> cacheGamePriceDetails = new HashMap<Integer, GamePriceDetail>();
       Map<Integer,GameRobotDetail> cacheGameRobotDetails = new HashMap<Integer, GameRobotDetail>();
       Map<Integer,GameSkillDetail> cacheGameSkillDetails = new HashMap<Integer, GameSkillDetail>();
       Map<Integer,GameStarDetail> cacheGameStarDetails = new HashMap<Integer, GameStarDetail>();
       Map<Integer,GameTaskDetail> cacheGameTaskDetails = new HashMap<Integer, GameTaskDetail>();
       Map<Integer,GametotemDetail> cacheGametotemDetails = new HashMap<Integer, GametotemDetail>();
       Map<Integer,GameTowerDetail> cacheGameTowerDetails = new HashMap<Integer, GameTowerDetail>();
       Map<Integer,GameVipDetail> cacheGameVipDetails = new HashMap<Integer, GameVipDetail>();
       Map<Integer,HostDetail> cacheHostDetails = new HashMap<Integer, HostDetail>();
       Map<Integer,MemberDetail> cacheMemberDetails = new HashMap<Integer, MemberDetail>();
       Map<Integer,QunzhanDetail> cacheQunzhanDetails = new HashMap<Integer, QunzhanDetail>();
       Map<Integer,RoleAvatarDetail> cacheRoleAvatarDetails = new HashMap<Integer, RoleAvatarDetail>();
       Map<Integer,RoleBingDetail> cacheRoleBingDetails = new HashMap<Integer, RoleBingDetail>();
       Map<Integer,RoleChallengeDetail> cacheRoleChallengeDetails = new HashMap<Integer, RoleChallengeDetail>();
       Map<Integer,RoleDaytaskDetail> cacheRoleDaytaskDetails = new HashMap<Integer, RoleDaytaskDetail>();
       Map<Integer,RoleEquipDetail> cacheRoleEquipDetails = new HashMap<Integer, RoleEquipDetail>();
       Map<Integer, List<Integer>> cacheForRoleEquip = new HashMap<Integer, List<Integer>>();
       Map<Integer,RoleImposeDetail> cacheRoleImposeDetails = new HashMap<Integer, RoleImposeDetail>();
       Map<Integer,RoleInsDetail> cacheRoleInsDetails = new HashMap<Integer, RoleInsDetail>();
       Map<Long,RoleItemDetail> cacheRoleItemDetails = new HashMap<Long, RoleItemDetail>();
       Map<Integer, HashMap<Integer, Long>> cacheForRoleItem = new HashMap<Integer, HashMap<Integer, Long>>();
       Map<Integer,RoleMapDetail> cacheRoleMapDetails = new HashMap<Integer, RoleMapDetail>();
       Map<Integer, List<Integer>> cacheForRoleMap = new HashMap<Integer, List<Integer>>();
       Map<Integer,RoleMilitaryDetail> cacheRoleMilitaryDetails = new HashMap<Integer, RoleMilitaryDetail>();
       Map<Integer,RoleMilitaryDetail> cacheRoleMilitaryDetails2 = new HashMap<Integer, RoleMilitaryDetail>();
       Map<Integer, List<Integer>> cacheForRoleMilitary = new HashMap<Integer, List<Integer>>();
       //魔魂界面缓存，用户的九个魔将
       Map<Integer, List<Integer>> cacheForRoleMilitaryGhost = new HashMap<Integer, List<Integer>>();
       
       Map<Integer,RoleQuicktimeDetail> cacheRoleQuicktimeDetails = new HashMap<Integer, RoleQuicktimeDetail>();
       Map<Integer,RoleTaskDetail> cacheRoleTaskDetails = new HashMap<Integer, RoleTaskDetail>();
       Map<Integer,RoleTaskTaskDetail> cacheRoleTaskTaskDetails = new HashMap<Integer, RoleTaskTaskDetail>();
       Map<Integer, HashMap<Integer, Integer>> cacheForRoleTaskTask = new HashMap<Integer, HashMap<Integer, Integer>>();
       Map<Integer,RoleTavernDetail> cacheRoleTavernDetails = new HashMap<Integer, RoleTavernDetail>();
       Map<Integer,RoletotemDetail> cacheRoletotemDetails = new HashMap<Integer, RoletotemDetail>();
       Map<Integer, ServerDetail> cacheServerDetails = new HashMap<Integer, ServerDetail>();
       Map<Integer,ShopdiscountDetail> cacheShopdiscountDetails = new HashMap<Integer, ShopdiscountDetail>();
       Map<Integer,TempPackageDetail> cacheTempPackageDetails = new HashMap<Integer, TempPackageDetail>();
       Map<Integer,ZhugongDetail> cacheZhugongDetails = new HashMap<Integer, ZhugongDetail>();
       Map<Integer,GameYellowVipDetail> cacheGameYellowVipDetails = new HashMap<Integer, GameYellowVipDetail>();
	Map<String, Object> rlt = new HashMap<String, Object>();//所有的模型表1
	Map<String, Object> rlttwo = new HashMap<String, Object>();//所有的模型表2
    Map<Integer,Integer> equipthree=new HashMap<Integer, Integer>();
    Map<Integer,Integer> equipfour=new HashMap<Integer, Integer>();
    Map<Integer,Integer> equipfive=new HashMap<Integer, Integer>();
    
    /****************************/
    /***     * 以下为四合一map合并版,用作多区多服     */
    Map<Integer,ActivityDetail> newServerActivityDataMap = new HashMap<Integer, ActivityDetail>();
    Map<Integer,JSONArray> newServerDataMap = new HashMap<Integer,JSONArray>();//新服状态  0：哪一月        1：哪一天  2：哪个服
    Map<Integer, Map<Integer, Integer>> allChongZhiMap = new HashMap<Integer, Map<Integer,Integer>>();//充值   roleid	coinspend
    Map<Integer, Map<Integer, Integer>> allGuanKaMap = new HashMap<Integer, Map<Integer,Integer>>();//关卡  roleid   波数	mapid*20+placeid
    Map<Integer, Map<Integer, Integer>> allFuBenMap = new HashMap<Integer, Map<Integer,Integer>>();//副本  roleid   积分	
    Map<Integer, Map<Integer, Integer>> allZhengBaMap = new HashMap<Integer, Map<Integer,Integer>>();//争霸   roleid   争霸	攻击力
    
    /*********四合一所有人排行***********/
    Map<Integer, Map<Integer, Integer>> allChongZhiPaiMingMap = new HashMap<Integer, Map<Integer,Integer>>();
    Map<Integer, Map<Integer, Integer>> allGuanKaPaiMingMap = new HashMap<Integer, Map<Integer,Integer>>();
    Map<Integer, Map<Integer, Integer>> allFuBenPaiMingMap = new HashMap<Integer, Map<Integer,Integer>>();
    Map<Integer, Map<Integer, Integer>> allZhengBaPaiMingMap = new HashMap<Integer, Map<Integer,Integer>>();
    /*******************/
     
     Map<Integer,JSONArray> grouplist = new HashMap<Integer, JSONArray>();//存放遍历好的群好友
     JSONArray extrashow = new JSONArray();//活动额外显示
	Map<Integer, StatetostateDetail> cacheStatetostateDetails = new HashMap<Integer, StatetostateDetail>();
	Map<Integer, Map<Integer,List<Integer>>> cacheForStatetostate = new HashMap<Integer, Map<Integer, List<Integer>>>();
	Map<Integer, StatetostateDetail> cacheStatetostateDetails2 = new HashMap<Integer, StatetostateDetail>();
	Map<Integer, Map<Integer,List<Integer>>> cacheForStatetostate2 = new HashMap<Integer, Map<Integer, List<Integer>>>();
	Map<Integer,Integer> equipVisitFlag = new HashMap<Integer, Integer>();//存放一个玩家ID,防止玩家多次进入getRoleEquip方法调用去重
	
	
}
