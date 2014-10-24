package com.stang.game.server;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import com.stang.game.cache.*;

import org.apache.mina.core.filterchain.IoFilter.NextFilter;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.SocketSessionConfig;
import net.sf.json.JSONArray;
import net.sf.sojo.interchange.json.JsonSerializer;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.stang.game.common.GameConstants;
import com.stang.game.entity.detail.ActivityDetail;
import com.stang.game.entity.detail.AutoIdDetail;
import com.stang.game.entity.detail.CallGiftDetail;
import com.stang.game.entity.detail.ChallengeRecordDetail;
import com.stang.game.entity.detail.CoinDetail;
import com.stang.game.entity.detail.DeliveryDetail;
import com.stang.game.entity.detail.GamblingItemDetail;
import com.stang.game.entity.detail.GameAvatarDetail;
import com.stang.game.entity.detail.GameBbuffDetail;
import com.stang.game.entity.detail.GameBingDetail;
import com.stang.game.entity.detail.GameBmapDetail;
import com.stang.game.entity.detail.GameBskillDetail;
import com.stang.game.entity.detail.GameBuffDetail;
import com.stang.game.entity.detail.GameChLevelDetail;
import com.stang.game.entity.detail.GameChartsDetail;
import com.stang.game.entity.detail.GameChartstwoDetail;
import com.stang.game.entity.detail.GameEInsDetail;
import com.stang.game.entity.detail.GameEPropertyDetail;
import com.stang.game.entity.detail.GameEquipDetail;
import com.stang.game.entity.detail.GameFoeDetail;
import com.stang.game.entity.detail.GameFoeskillDetail;
import com.stang.game.entity.detail.GameItemDetail;
import com.stang.game.entity.detail.GameJingjiFinalDetail;
import com.stang.game.entity.detail.GameJingjiStaticDetail;
import com.stang.game.entity.detail.GameLevelDetail;
import com.stang.game.entity.detail.GameMLevelDetail;
import com.stang.game.entity.detail.GameMapDetail;
import com.stang.game.entity.detail.GameMilitaryDetail;
import com.stang.game.entity.detail.GameMissionDetail;
import com.stang.game.entity.detail.GamePlatsDetail;
import com.stang.game.entity.detail.GamePriceDetail;
import com.stang.game.entity.detail.GameRobotDetail;
import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.entity.detail.GameSkillDetail;
import com.stang.game.entity.detail.GameStarDetail;
import com.stang.game.entity.detail.GameTaskDetail;
import com.stang.game.entity.detail.GameTowerDetail;
import com.stang.game.entity.detail.GameVipDetail;
import com.stang.game.entity.detail.GameYellowVipDetail;
import com.stang.game.entity.detail.GametotemDetail;
import com.stang.game.entity.detail.HostDetail;
import com.stang.game.entity.detail.MemberDetail;
import com.stang.game.entity.detail.RoleAvatarDetail;
import com.stang.game.entity.detail.RoleBingDetail;
import com.stang.game.entity.detail.RoleChallengeDetail;
import com.stang.game.entity.detail.RoleDaytaskDetail;
import com.stang.game.entity.detail.RoleEquipDetail;
import com.stang.game.entity.detail.RoleImposeDetail;
import com.stang.game.entity.detail.RoleInsDetail;
import com.stang.game.entity.detail.RoleItemDetail;
import com.stang.game.entity.detail.RoleMapDetail;
import com.stang.game.entity.detail.RoleMilitaryDetail;
import com.stang.game.entity.detail.RoleQuicktimeDetail;
import com.stang.game.entity.detail.RoleTaskDetail;
import com.stang.game.entity.detail.RoleTaskTaskDetail;
import com.stang.game.entity.detail.RoleTavernDetail;
import com.stang.game.entity.detail.RoletotemDetail;
import com.stang.game.entity.detail.ServerDetail;
import com.stang.game.entity.detail.ShopdiscountDetail;
import com.stang.game.entity.detail.StatetostateDetail;
import com.stang.game.entity.detail.TempPackageDetail;
import com.stang.game.server.handler.BaseHandler;
import com.stang.game.server.handler.BingHandler;
import com.stang.game.server.handler.MapHandler;
import com.stang.game.server.handler.MatchHandler;
import com.stang.game.server.handler.MilitartHandler;
import com.stang.game.server.handler.OpenHandler;
import com.stang.game.server.handler.PlayerHandler;
import com.stang.game.server.handler.SystemHandler;
import com.stang.game.server.handler.TaskHandler;
import com.stang.game.server.handler.TowerHandler;
import com.stang.game.server.handler.XiulianHandler;
import com.stang.game.service.IActivityService;
import com.stang.game.service.IAutoIdService;
import com.stang.game.service.ICallgiftService;
import com.stang.game.service.IChallengeRecordService;
import com.stang.game.service.ICoinService;
import com.stang.game.service.IDantiaoService;
import com.stang.game.service.IDeliveryService;
import com.stang.game.service.IGamblingItemService;
import com.stang.game.service.IGameAvatarService;
import com.stang.game.service.IGameBbuffService;
import com.stang.game.service.IGameBingService;
import com.stang.game.service.IGameBmapService;
import com.stang.game.service.IGameBskillService;
import com.stang.game.service.IGameBuffService;
import com.stang.game.service.IGameChLevelService;
import com.stang.game.service.IGameChartsService;
import com.stang.game.service.IGameChartstwoService;
import com.stang.game.service.IGameEInsService;
import com.stang.game.service.IGameEPropertyService;
import com.stang.game.service.IGameEquipService;
import com.stang.game.service.IGameFoeService;
import com.stang.game.service.IGameFoeskillService;
import com.stang.game.service.IGameItemService;
import com.stang.game.service.IGameJingjiFinalService;
import com.stang.game.service.IGameJingjiStaticService;
import com.stang.game.service.IGameLevelService;
import com.stang.game.service.IGameMLevelService;
import com.stang.game.service.IGameMapService;
import com.stang.game.service.IGameMilitaryService;
import com.stang.game.service.IGameMissionService;
import com.stang.game.service.IGamePlatsService;
import com.stang.game.service.IGamePriceService;
import com.stang.game.service.IGameRobotService;
import com.stang.game.service.IGameRoleService;
import com.stang.game.service.IGameSkillService;
import com.stang.game.service.IGameStarService;
import com.stang.game.service.IGameTaskService;
import com.stang.game.service.IGameTowerService;
import com.stang.game.service.IGameVipService;
import com.stang.game.service.IGameYellowVipService;
import com.stang.game.service.IGametotemService;
import com.stang.game.service.IHostService;
import com.stang.game.service.IMemberService;
import com.stang.game.service.IQunzhanService;
import com.stang.game.service.IRoleAvatarService;
import com.stang.game.service.IRoleBingService;
import com.stang.game.service.IRoleChallengeService;
import com.stang.game.service.IRoleDaytaskService;
import com.stang.game.service.IRoleEquipService;
import com.stang.game.service.IRoleImposeService;
import com.stang.game.service.IRoleInsService;
import com.stang.game.service.IRoleItemService;
import com.stang.game.service.IRoleMapService;
import com.stang.game.service.IRoleMilitaryService;
import com.stang.game.service.IRoleQuicktimeService;
import com.stang.game.service.IRoleTaskService;
import com.stang.game.service.IRoleTaskTaskService;
import com.stang.game.service.IRoleTavernService;
import com.stang.game.service.IRoletotemService;
import com.stang.game.service.IServerService;
import com.stang.game.service.IShopdiscountService;
import com.stang.game.service.IStatetostateService;
import com.stang.game.service.ITempPackageService;
import com.stang.game.service.IZhugongService;
import com.stang.game.service.impl.ActivityServiceImpl;
import com.stang.game.service.impl.AutoIdServiceImpl;
import com.stang.game.service.impl.CallgiftServiceImpl;
import com.stang.game.service.impl.ChallengeRecordServiceImpl;
import com.stang.game.service.impl.CoinServiceImpl;
import com.stang.game.service.impl.DantiaoServiceImpl;
import com.stang.game.service.impl.DeliveryServiceImpl;
import com.stang.game.service.impl.GamblingItemServiceImpl;
import com.stang.game.service.impl.GameAvatarServiceImpl;
import com.stang.game.service.impl.GameBbuffServiceImpl;
import com.stang.game.service.impl.GameBingServiceImpl;
import com.stang.game.service.impl.GameBmapServiceImpl;
import com.stang.game.service.impl.GameBskillServiceImpl;
import com.stang.game.service.impl.GameBuffServiceImpl;
import com.stang.game.service.impl.GameChLevelServiceImpl;
import com.stang.game.service.impl.GameChartsServiceImpl;
import com.stang.game.service.impl.GameChartstwoServiceImpl;
import com.stang.game.service.impl.GameEInsServiceImpl;
import com.stang.game.service.impl.GameEPropertyServiceImpl;
import com.stang.game.service.impl.GameEquipServiceImpl;
import com.stang.game.service.impl.GameFoeServiceImpl;
import com.stang.game.service.impl.GameFoeskillServiceImpl;
import com.stang.game.service.impl.GameItemServiceImpl;
import com.stang.game.service.impl.GameJingjiFinalServiceImpl;
import com.stang.game.service.impl.GameJingjiStaticServiceImpl;
import com.stang.game.service.impl.GameLevelServiceImpl;
import com.stang.game.service.impl.GameMLevelServiceImpl;
import com.stang.game.service.impl.GameMapServiceImpl;
import com.stang.game.service.impl.GameMilitaryServiceImpl;
import com.stang.game.service.impl.GameMissionServiceImpl;
import com.stang.game.service.impl.GamePlatsServiceImpl;
import com.stang.game.service.impl.GamePriceServiceImpl;
import com.stang.game.service.impl.GameRobotServiceImpl;
import com.stang.game.service.impl.GameRoleServiceImpl;
import com.stang.game.service.impl.GameSkillServiceImpl;
import com.stang.game.service.impl.GameStarServiceImpl;
import com.stang.game.service.impl.GameTaskServiceImpl;
import com.stang.game.service.impl.GameTowerServiceImpl;
import com.stang.game.service.impl.GameVipServiceImpl;
import com.stang.game.service.impl.GameYellowVipServiceImpl;
import com.stang.game.service.impl.GametotemServiceImpl;
import com.stang.game.service.impl.HostServiceImpl;
import com.stang.game.service.impl.MemberServiceImpl;
import com.stang.game.service.impl.QunzhanServiceImpl;
import com.stang.game.service.impl.RoleAvatarServiceImpl;
import com.stang.game.service.impl.RoleBingServiceImpl;
import com.stang.game.service.impl.RoleChallengeServiceImpl;
import com.stang.game.service.impl.RoleDaytaskServiceImpl;
import com.stang.game.service.impl.RoleEquipServiceImpl;
import com.stang.game.service.impl.RoleImposeServiceImpl;
import com.stang.game.service.impl.RoleInsServiceImpl;
import com.stang.game.service.impl.RoleItemServiceImpl;
import com.stang.game.service.impl.RoleMapServiceImpl;
import com.stang.game.service.impl.RoleMilitaryServiceImpl;
import com.stang.game.service.impl.RoleQuicktimeServiceImpl;
import com.stang.game.service.impl.RoleTaskServiceImpl;
import com.stang.game.service.impl.RoleTaskTaskServiceImpl;
import com.stang.game.service.impl.RoleTavernServiceImpl;
import com.stang.game.service.impl.RoletotemServiceImpl;
import com.stang.game.service.impl.ServerServiceImpl;
import com.stang.game.service.impl.ShopdiscountServiceImpl;
import com.stang.game.service.impl.StatetostateServiceImpl;
import com.stang.game.service.impl.TempPackageServiceImpl;
import com.stang.game.service.impl.ZhugongServiceImpl;

/**
 * @author wei_fei
 * @company 3tang.com
 * @introductionF 游戏服务器处理类
 */
public class ServerHandler extends IoHandlerAdapter {
	public static int serverState = 1;
	public static int u;
	/* 玩家会话信息(key:roleId,value:session) */
	/* 玩家地址信息(key:roleId,value:remoteAddress) */
	public static Map<Integer, String> roleSessions = new HashMap<Integer, String>();
	public static Map<Integer, IoSession> playerSessions1 = new ConcurrentHashMap<Integer, IoSession>();
	static private IGameRoleService gameRoleService = null;
	private static IGameRoleService getGameRoleService() {
		if (gameRoleService == null) {
			gameRoleService = new GameRoleServiceImpl();
		}
		return gameRoleService;
	}
	private static IActivityService activityService = null;
	private static IActivityService getActivityService() {
		if (activityService == null) {
			activityService = new ActivityServiceImpl();
		}
		return activityService;
	}
	private static IAutoIdService autoIdService = null;
	private static IAutoIdService getAutoIdService() {
		if (autoIdService == null) {
			autoIdService = new AutoIdServiceImpl();
		}
		return autoIdService;
	}
	private static ICallgiftService callgiftService = null;
	private static ICallgiftService getCallgiftService() {
		if (callgiftService == null) {
			callgiftService = new CallgiftServiceImpl();
		}
		return callgiftService;
	}
	private static IGameYellowVipService gameYellowVipService=null;
	private static IGameYellowVipService getGameYellowVipService(){
		if(gameYellowVipService==null){
			gameYellowVipService=new GameYellowVipServiceImpl();	
		}
		return gameYellowVipService;
		
	}
	private static IChallengeRecordService challengeRecordsService = null;
	private static IChallengeRecordService getChallengeRecordService() {
		if (challengeRecordsService == null) {
			challengeRecordsService = new ChallengeRecordServiceImpl();
		}
		return challengeRecordsService;
	}
	private static ICoinService coinService = null;
	private static ICoinService getCoinService() {
		if (coinService == null) {
			coinService = new CoinServiceImpl();
		}
		return coinService;
	}
	private static IDantiaoService dantiaoService = null;
	private static IDantiaoService getDantiaoService() {
		if (dantiaoService == null) {
			dantiaoService = new DantiaoServiceImpl();
		}
		return dantiaoService;
	}
	private static IDeliveryService deliveryService = null;
	private static IDeliveryService getDeliveryService() {
		if (deliveryService == null) {
			deliveryService = new DeliveryServiceImpl();
		}
		return deliveryService;
	}
	private static IGamblingItemService gamblingItemService = null;
	private static IGamblingItemService getGamblingItemService() {
		if (gamblingItemService == null) {
			gamblingItemService = new GamblingItemServiceImpl();
		}
		return gamblingItemService;
	}
	private static IGameAvatarService gameAvatarService = null;
	private static IGameAvatarService getGameAvatarService() {
		if (gameAvatarService == null) {
			gameAvatarService = new GameAvatarServiceImpl();
		}
		return gameAvatarService;
	}
	private static IGameBbuffService gameBbuffService = null;
	private static IGameBbuffService getGameBbuffService() {
		if (gameBbuffService == null) {
			gameBbuffService = new GameBbuffServiceImpl();
		}
		return gameBbuffService;
	}
	private static IGameBingService gameBingService = null;
	private static IGameBingService getGameBingService() {
		if (gameBingService == null) {
			gameBingService = new GameBingServiceImpl();
		}
		return gameBingService;
	}
	private static IGameBmapService gameBmapService = null;
	private static IGameBmapService getGameBmapService() {
		if (gameBmapService == null) {
			gameBmapService = new GameBmapServiceImpl();
		}
		return gameBmapService;
	}
	private static IGameBskillService gameBskillService = null;
	private static IGameBskillService getGameBskillService() {
		if (gameBskillService == null) {
			gameBskillService = new GameBskillServiceImpl();
		}
		return gameBskillService;
	}
	private static IGameBuffService gameBuffService = null;
	private static IGameBuffService getGameBuffService() {
		if (gameBuffService == null) {
			gameBuffService = new GameBuffServiceImpl();
		}
		return gameBuffService;
	}
	private static IGameChartsService gameChartsService = null;
	private static IGameChartsService getGameChartsService() {
		if (gameChartsService == null) {
			gameChartsService = new GameChartsServiceImpl();
		}
		return gameChartsService;
	}
	private static IGameChartstwoService gameChartstwoService=new GameChartstwoServiceImpl();
	private static IGameChartstwoService getGameChartstwoService() {
		if (gameChartstwoService == null) {
			gameChartstwoService = new GameChartstwoServiceImpl();
		}
		return gameChartstwoService;
	}
	private static IGameChLevelService gameChLevelService = null;
	private static IGameChLevelService getGameChLevelService() {
		if (gameChLevelService == null) {
			gameChLevelService = new GameChLevelServiceImpl();
		}
		return gameChLevelService;
	}
	private static IGameEInsService gameEInsService = null;
	private static IGameEInsService getGameEInsService() {
		if (gameEInsService == null) {
			gameEInsService = new GameEInsServiceImpl();
		}
		return gameEInsService;
	}
	private static IGameEPropertyService gameEPropertyService = null;
	private static IGameEPropertyService getGameEPropertyService() {
		if (gameEPropertyService == null) {
			gameEPropertyService = new GameEPropertyServiceImpl();
		}
		return gameEPropertyService;
	}
	private static IGameEquipService gameEquipService = null;
	private static IGameEquipService getGameEquipService() {
		if (gameEquipService == null) {
			gameEquipService = new GameEquipServiceImpl();
		}
		return gameEquipService;
	}
	private static IGameFoeService gameFoeService = null;
	private static IGameFoeService getGameFoeService() {
		if (gameFoeService == null) {
			gameFoeService = new GameFoeServiceImpl();
		}
		return gameFoeService;
	}
	private static IGameFoeskillService gameFoeskillService = null;
	private static IGameFoeskillService getGameFoeskillService() {
		if (gameFoeskillService == null) {
			gameFoeskillService = new GameFoeskillServiceImpl();
		}
		return gameFoeskillService;
	}
	private static IGameItemService gameItemService = null;
	private static IGameItemService getGameItemService() {
		if (gameItemService == null) {
			gameItemService = new GameItemServiceImpl();
		}
		return gameItemService;
	}
	private static IGameJingjiFinalService gameJingjiFinalService = null;
	private static IGameJingjiFinalService getGameJingjiFinalService() {
		if (gameJingjiFinalService == null) {
			gameJingjiFinalService = new GameJingjiFinalServiceImpl();
		}
		return gameJingjiFinalService;
	}
	private static IGameJingjiStaticService  gameJingjiStaticService = null;
	private static IGameJingjiStaticService getGameJingjiStaticService() {
		if (gameJingjiStaticService == null) {
			gameJingjiStaticService = new GameJingjiStaticServiceImpl();
		}
		return gameJingjiStaticService;
	}
	private static IGameLevelService gameLevelService = null;
	private static IGameLevelService getGameLevelService() {
		if (gameLevelService == null) {
			gameLevelService = new GameLevelServiceImpl();
		}
		return gameLevelService;
	}
	private static IGameMapService gameMapService = new GameMapServiceImpl();
	private static IGameMapService getGameMapService() {
		if (gameMapService == null) {
			gameMapService = new GameMapServiceImpl();
		}
		return gameMapService;
	}
	private static IGameMilitaryService gameMilitaryService = null;
	private static IGameMilitaryService getGameMilitaryService() {
		if (gameMilitaryService == null) {
			gameMilitaryService = new GameMilitaryServiceImpl();
		}
		return gameMilitaryService;
	}
	private static IGameMissionService gameMissionService = null;
	private static IGameMissionService getGameMissionService() {
		if (gameMissionService == null) {
			gameMissionService = new GameMissionServiceImpl();
		}
		return gameMissionService;
	}
	private static IGameMLevelService gameMLevelService = new GameMLevelServiceImpl();
	private static IGameMLevelService getGameMLevelService() {
		if (gameMLevelService == null) {
			gameMLevelService = new GameMLevelServiceImpl();
		}
		return gameMLevelService;
	}
	private static IGamePlatsService gamePlatsService = null;
	private static IGamePlatsService getGamePlatsService() {
		if (gamePlatsService == null) {
			gamePlatsService = new GamePlatsServiceImpl();
		}
		return gamePlatsService;
	}
	private static IGamePriceService gamePriceService = null;
	private static IGamePriceService getGamePriceService() {
		if (gamePriceService == null) {
			 gamePriceService = new GamePriceServiceImpl();
		}
		return gamePriceService;
	}
	private static IGameRobotService gameRobotService = null;
	private static IGameRobotService getGameRobotService() {
		if (gameRobotService == null) {
			gameRobotService = new GameRobotServiceImpl();
		}
		return gameRobotService;
	}
	private static IGameSkillService gameSkillService = new GameSkillServiceImpl();
	private static IGameSkillService getGameSkillService() {
		if (gameSkillService == null) {
			gameSkillService = new GameSkillServiceImpl();
		}
		return gameSkillService;
	}
	private static IGameStarService gameStarService = null;
	private static IGameStarService getGameStarService() {
		if (gameStarService == null) {
			gameStarService = new GameStarServiceImpl();
		}
		return gameStarService;
	}
	private static IGameTaskService gameTaskService = null;
	private static IGameTaskService getGameTaskService() {
		if (gameTaskService == null) {
			gameTaskService = new GameTaskServiceImpl();
		}
		return gameTaskService;
	}
	private static IGametotemService gametotemService = null;
	private static IGametotemService getGametotemService() {
		if (gametotemService == null) {
			gametotemService = new GametotemServiceImpl();
		}
		return gametotemService;
	}
	private static IGameTowerService gameTowerService = null;
	private static IGameTowerService getGameTowerService() {
		if (gameTowerService == null) {
			gameTowerService = new GameTowerServiceImpl();
		}
		return gameTowerService;
	}
	private static IGameVipService gameVipService = null;
	private static IGameVipService getGameVipService() {
		if (gameVipService == null) {
			gameVipService = new GameVipServiceImpl();
		}
		return gameVipService;
	}
	private static IHostService hostService = null;
	private static IHostService getHostService() {
		if (hostService == null) {
			hostService = new HostServiceImpl();
		}
		return  hostService;
	}
	private static IMemberService memberService = null;	
	private static IMemberService getMemberService() {
		if (memberService == null) {
			memberService = new MemberServiceImpl();
		}
		return  memberService;
	}
	private static IQunzhanService qunzhanService = null;
	private static IQunzhanService getQunzhanService() {
		if (qunzhanService == null) {
			qunzhanService = new QunzhanServiceImpl();
		}
		return  qunzhanService;
	}
	private static IRoleAvatarService roleAvatarService = null;
	private static IRoleAvatarService getRoleAvatarService() {
		if (roleAvatarService == null) {
			roleAvatarService = new RoleAvatarServiceImpl();
		}
		return  roleAvatarService;
	}
	private static IRoleBingService roleBingService = null;
	private static IRoleBingService getRoleBingService() {
		if (roleBingService == null) {
			roleBingService = new RoleBingServiceImpl();
		}
		return  roleBingService;
	}
	private static IRoleChallengeService roleChallengeService = null;
	private static IRoleChallengeService getRoleChallengeService() {
		if (roleChallengeService == null) {
			roleChallengeService = new RoleChallengeServiceImpl();
		}
		return  roleChallengeService;
	}
	private static IRoleDaytaskService roleDaytaskService = null;
	private static IRoleDaytaskService getRoleDaytaskService() {
		if (roleDaytaskService == null) {
			roleDaytaskService = new RoleDaytaskServiceImpl();
		}
		return  roleDaytaskService;
	}
	private static IRoleEquipService roleEquipService = null;
	private static IRoleEquipService getRoleEquipService() {
		if (roleEquipService == null) {
			roleEquipService = new RoleEquipServiceImpl();
		}
		return  roleEquipService;
	}
	private static IRoleInsService roleInsService = null;
	private static IRoleInsService getRoleInsService() {
		if (roleInsService == null) {
			roleInsService = new RoleInsServiceImpl();
		}
		return  roleInsService;
	}
	private static IRoleItemService roleItemService = null;
	private static IRoleItemService getRoleItemService() {
		if (roleItemService == null) {
			roleItemService = new RoleItemServiceImpl();
		}
		return  roleItemService;
	}
	private static IRoleMapService roleMapService = null;
	private static IRoleMapService getRoleMapService() {
		if (roleMapService == null) {
			roleMapService = new RoleMapServiceImpl();
		}
		return  roleMapService;
	}
	private static IRoleMilitaryService roleMilitaryService = new RoleMilitaryServiceImpl();
	private static IRoleMilitaryService getRoleMilitaryService() {
		if (roleMilitaryService == null) {
			roleMilitaryService = new RoleMilitaryServiceImpl();
		}
		return  roleMilitaryService;
	}
	private static IStatetostateService statetostateService = new StatetostateServiceImpl();
	private static IStatetostateService getStatetostateService() {
		if (statetostateService == null) {
			statetostateService = new StatetostateServiceImpl();
		}
		return  statetostateService;
	}
	private static IRoleQuicktimeService roleQuicktimeService = null;
	private static IRoleQuicktimeService getRoleQuicktimeService() {
		if (roleQuicktimeService == null) {
			roleQuicktimeService = new RoleQuicktimeServiceImpl();
		}
		return  roleQuicktimeService;
	}
	private static IRoleTaskService roleTaskService = null;
	private static IRoleTaskService getRoleTaskService() {
		if (roleTaskService == null) {
			roleTaskService = new RoleTaskServiceImpl();
		}
		return  roleTaskService;
	}
	private static IRoleTaskTaskService roleTaskTaskService = null;
	private static IRoleTaskTaskService getRoleTaskTaskService() {
		if (roleTaskTaskService == null) {
			roleTaskTaskService = new RoleTaskTaskServiceImpl();
		}
		return  roleTaskTaskService;
	}
	private static IRoleTavernService roleTavernService = null;
	private static IRoleTavernService getRoleTavernService() {
		if (roleTavernService == null) {
			roleTavernService = new RoleTavernServiceImpl();
		}
		return  roleTavernService;
	}
	private static IRoletotemService roletotemService = null;
	private static IRoletotemService getRoletotemService() {
		if (roletotemService == null) {
			roletotemService = new RoletotemServiceImpl();
		}
		return  roletotemService;
	}
	private static IServerService serverService = null;
	private static IServerService getServerService() {
		if (serverService == null) {
			serverService = new ServerServiceImpl();
		}
		return  serverService;
	}
	private static IShopdiscountService shopdiscountService = null;
	private static IShopdiscountService getShopdiscountService() {
		if (shopdiscountService == null) {
			shopdiscountService = new ShopdiscountServiceImpl();
		}
		return  shopdiscountService;
	}
	private static ITempPackageService tempPackageService = null;
	private static ITempPackageService getTempPackageService() {
		if (tempPackageService == null) {
			tempPackageService = new TempPackageServiceImpl();
		}
		return  tempPackageService;
	}
	private static IZhugongService zhugongService = null;
	private static IZhugongService getZhugongService() {
		if (zhugongService == null) {
			zhugongService = new ZhugongServiceImpl();
		}
		return  zhugongService;
	}
	
    
	static private IRoleImposeService roleImposeService = null;

	private static IRoleImposeService getRoleImposeService() {
		if (roleImposeService == null) {
			roleImposeService = new RoleImposeServiceImpl();
		}
		return roleImposeService;
	}
	

	/**
	 * @method putPlayerSession
	 * @param roleId
	 *            {Integer} 玩家序号
	 * @param session
	 *            {IoSession} 会话
	 * @return {void}
	 * @description 添加玩家序号-会话信息
	 */
	public static void putPlayerSession(int roleId, IoSession session) {
		playerSessions1.put(roleId, session);
		//System.out.println("执行了putroleid");
		session.setAttribute("roleId", roleId);
		//System.out.println("shuchu:roleid:" + session.getAttribute("roleId"));
	}

	public static void closeServer() {
		serverState = 0;
		GameConstants.log.warn("服务器开始关机");
		
		while (playerSessions1.size() > 0 || queueMax > 0) {
			try {
				for (IoSession session : playerSessions1.values()) {
					session.close();
				}
				debugQueue();
				Thread.sleep(5000);
				
			} catch (InterruptedException e) {
				GameConstants.log.warn("", e);
			}
		}
		GameConstants.log.warn("服务器应用进程关闭");
		System.exit(0);
	}

	/**
	 * @method getSessionByRoleId
	 * @param roleId
	 *            {Integer} 玩家序号
	 * @return {IoSession}
	 * @description 根据玩家序号获得会话信息
	 */
	public static IoSession getSessionByRoleId(Integer roleId) {
		IoSession session = null;
		try {
			session = playerSessions1.get(roleId);
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		}
		return session;
	}

	/**
	 * @method getRoleIdBySession
	 * @param session
	 *            {IoSession} 玩家会话信息
	 * @return {Integer}
	 * @description 根据会话获得玩家序号
	 */
	public static Integer getRoleIdBySession(IoSession session) {
		Object roleId = session.getAttribute("roleId");
		if (roleId == null)
			return null;
		return (Integer) roleId;
	}
	/**
	 * @method sendDataByRoleId
	 * @param data
	 *            {java.util.Map<String,Object>} 需要发送的数据
	 * @param roleId
	 *            {java.lang.String} 玩家序号
	 * @return {void}
	 * @description 根据玩家序号发送数据
	 */
	public static void sendDataByRoleId(Map<String, Object> data, int roleId) {
		//GameConstants.log.warn("4ServerHandler:senddataByRoleId:" + data.toString());
		IoSession ioSession = getSessionByRoleId(roleId);
		if (ioSession != null) {
			sendData(ioSession, data);
		}
	}

	public static void sendDataByRoleId(Map<String, Object> data, String roleId) {
		//GameConstants.log.warn("3ServerHandler:senddataByRoleId:" + data.toString());

		IoSession ioSession = getSessionByRoleId(Integer.parseInt(roleId));
		if (ioSession != null) {
			sendData(ioSession, data);
		}
	}

	public static void sendData(IoSession _session, Object message) {
		//GameConstants.log.warn("2ServerHandler:sendData:" + message.toString());
		if (_session == null || _session.isClosing()) {
			return;
		}
		byte[] _sendInfo = JSON.toJSONBytes(message,
				SerializerFeature.DisableCircularReferenceDetect);
		_session.write(_sendInfo);
	}

	public static void sendData(IoSession _session, Map<String, Object> message) {
		//GameConstants.log.warn("ID:" +  + "ServerHandler:sendData____________________________________________________________________________________:" + message.toString());
		//GameConstants.log.warn("sendData start");
		//System.out.println("1ServerHandler:sendData:" + message.toString());

		if (_session == null || _session.isClosing() || !_session.isConnected()) {
			return;
		}
		//GameConstants.log.warn("ID:" + _session.getRemoteAddress() + "ServerHandler:sendData____________________________________________________________________________________:" + message.toString());
		
		message.put("_currTime", new Date().getTime());
		byte[] _sendInfo = JSON.toJSONBytes(message,
				SerializerFeature.DisableCircularReferenceDetect);
		_session.write(_sendInfo);
		//GameConstants.log.warn("sendData over");
	}

	public static void sendDataToAll(Map<String, Object> params) {
		//System.out.println("ServerHandler:sendDataToAll:" + params.toString());
		for (IoSession ioSession : playerSessions1.values()) {
			sendData(ioSession, params);
		}
	}

	public void sessionClosed(IoSession session) throws Exception {
		sessionCountSub();
		Integer roleId = getRoleIdBySession(session);
		if (null == roleId) {
			return;
		} else {
			this.getGameRoleService().updateRoleline(roleId, 0);
			playerSessions1.remove(roleId);
			session.setAttribute("closed");
			GlobalDatat.grouplist.put(roleId, null);
		}
	}
	
	public ServerHandler() throws Exception {
		//初始化全局缓存
		initGlobalCache();
		//触发更新服务器在线人数
		PlayerHandler.updateOnlineUserNumber();
		// 一天的毫秒数
		long daySpan = 24 * 60 * 60 * 1000;
		XiulianHandler xiulian=new XiulianHandler();//更新用户排行榜
		xiulian.openchartstwo();
		xiulian.upfriendchallenge();//更新用户炫耀挑战的状态
		xiulian.allModels();
		xiulian.newServerActivity();//更新新服四合一排行榜活动
		MapHandler map=new MapHandler();
		map.youngmanytw();//新手引导打开争霸战添加的机器人缓存
		//map.oldmanytw();//打开争霸战缓存
//		MatchHandler match = new MatchHandler();
//		match.jiesuan();
		// 规定的每天时间00:00:00运行
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd '23:59:59'");
		final SimpleDateFormat sdfm = new SimpleDateFormat("yyyy-MM-dd '21:05:00'");
		final SimpleDateFormat sdfmd = new SimpleDateFormat("yyyy-MM-dd '04:30:00'");
		// 首次运行时间
		Date startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sdf.format(new Date()));
		Date startTimem = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sdfm.format(new Date()));
		Date startTimemd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sdfmd.format(new Date()));

		// 如果今天的已经过了 首次运行时间就改为明天
		if (System.currentTimeMillis() > startTime.getTime()) {
			startTime = new Date(startTime.getTime() + daySpan);
		}
		if (System.currentTimeMillis() > startTimem.getTime()) {
			startTimem = new Date(startTimem.getTime() + daySpan);
		}
		if (System.currentTimeMillis() > startTimemd.getTime()) {
			startTimemd = new Date(startTimemd.getTime() + daySpan);
		}
		Timer t = new Timer();
		Timer tm = new Timer();
		Timer tmd = new Timer();
		Timer tmdb = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				int i=0;
				long a = System.currentTimeMillis();
				XiulianHandler xiulian=new XiulianHandler();
				MapHandler map=new MapHandler();
				xiulian.openchartstwo();
				xiulian.allModels();
				GlobalDatat.cacheForRoleMilitaryGhost.clear();//清空魔壂数据
//				QueueCache.updateFlag = 0;
//				try{
//					Thread.sleep(5000);
//				}catch(Exception e ){
//					e.printStackTrace();
//				}
//				QueueCache.updateFlag = 1;
				xiulian.upfriendchallenge();//更新用户炫耀挑战的状态
				map.youngmanytw();//新手引导打开争霸战添加的机器人缓存
				//map.oldmanytw();//打开争霸战缓存
			}
		};
		TimerTask taskm = new TimerTask() {
			public void run() {
				int i=0;
				MatchHandler match = new MatchHandler();
				match.jiesuan();
			}
		};
		TimerTask taskmd = new TimerTask() {
			public void run() {
				initGlobalCache();
			}
		};
		TimerTask taskmdb = new TimerTask() {
			public void run() {
				GameConstants.log.warn("TimerTask(600000ms)");
				debugQueue();
			}
		};
//		TimerTask newServerData = new TimerTask() {
//			public void run() {
//				GameConstants.log.warn("TimerTask(3600000ms)");//一小时刷新一次
//				//清空之前的缓存
//				
//				XiulianHandler xiulian=new XiulianHandler();
//				xiulian.newServerActivity();//更新新服四合一排行榜活动
//			}
//		};
		// 以每24小时执行一次
		t.scheduleAtFixedRate(task, startTime, daySpan);
		tm.scheduleAtFixedRate(taskm, startTimem, daySpan);
		tmd.scheduleAtFixedRate(taskmd, startTimemd, daySpan);
		tmdb.scheduleAtFixedRate(taskmdb, new Date(), 600000);
		/****四合一timer****/
		Timer newServer = new Timer();
		newServer.schedule(new TimerTask(){
			public void run(){
				GlobalDatat.allChongZhiMap.clear();
				GlobalDatat.allChongZhiPaiMingMap.clear();
				GlobalDatat.allFuBenMap.clear();
				GlobalDatat.allFuBenPaiMingMap.clear();
				GlobalDatat.allGuanKaMap.clear();
				GlobalDatat.allGuanKaPaiMingMap.clear();
				GlobalDatat.allZhengBaMap.clear();
				GlobalDatat.allZhengBaPaiMingMap.clear();
				XiulianHandler xiulian=new XiulianHandler();
				xiulian.newServerActivity();//更新新服四合一排行榜活动;
				GameConstants.log.warn("update newServerActivity is ok  !");
				GameConstants.log.warn("---------------------------------------------");
			}
		},2*60*60*1000,2*60*60*1000);//2小时一次
		/****************/
//		if(GlobalDatat.newServerDataMap.size() != 0){
//			tmdb.scheduleAtFixedRate(newServerData, new Date(), 3600000);
//		}
//		Timer item = new Timer();
//		TimerTask taskitem = new TimerTask() {
//			public void run() {
//				MapHandler map=new MapHandler();
//				map.uproleItem();
//			}
//		};
//		item.scheduleAtFixedRate(taskitem, 10000, 10000);//60秒执行一次
	}
	List<GameRoleDetail> gameRoleIQ = new ArrayList<GameRoleDetail>();
	List<GameRoleDetail> gameRoleQ = new ArrayList<GameRoleDetail>();
	List<RoleChallengeDetail> roleChallengeQ = new ArrayList<RoleChallengeDetail>();
	List<RoleDaytaskDetail> roleDaytaskIQ = new ArrayList<RoleDaytaskDetail>();
	List<RoleDaytaskDetail> roleDaytaskQ = new ArrayList<RoleDaytaskDetail>();
	List<RoleEquipDetail> roleEquipIQ = new ArrayList<RoleEquipDetail>();
	List<RoleEquipDetail> roleEquipQ = new ArrayList<RoleEquipDetail>();
	List<RoleImposeDetail> roleImposeQ = new ArrayList<RoleImposeDetail>();
	List<RoleInsDetail> roleInsQ = new ArrayList<RoleInsDetail>();
	List<RoleItemDetail> roleItemIQ = new ArrayList<RoleItemDetail>();
	List<RoleItemDetail> roleItemQ = new ArrayList<RoleItemDetail>();
	List<RoleMapDetail> roleMapQ = new ArrayList<RoleMapDetail>();	
	List<RoleMilitaryDetail> roleMilitaryIQ = new ArrayList<RoleMilitaryDetail>();
	List<RoleMilitaryDetail> roleMilitaryQ = new ArrayList<RoleMilitaryDetail>();
	List<RoleQuicktimeDetail> roleQuicktimeQ = new ArrayList<RoleQuicktimeDetail>();
	List<RoleTavernDetail> roleTarvenIQ = new ArrayList<RoleTavernDetail>();
	List<RoleTavernDetail> roleTarvenQ = new ArrayList<RoleTavernDetail>();
	List<RoleTaskDetail> roleTaskIQ = new ArrayList<RoleTaskDetail>();
	List<RoleTaskDetail> roleTaskQ = new ArrayList<RoleTaskDetail>();
	List<RoleTaskTaskDetail> roleTaskTaskQ = new ArrayList<RoleTaskTaskDetail>();
	List<RoletotemDetail> roleTotmeQ = new ArrayList<RoletotemDetail>();
	
	
	
	//四点半时对数据库同步队列的内容临时备份
    private void save(String name){
    	if(name == "gameRole"){
    		if(null != CacheGameRole.gameRoleQueue_in){
    			if(CacheGameRole.gameRoleQueue_in.size() > 0){
    				int l = CacheGameRole.gameRoleQueue_in.size();
    				if(l != 0){
    					for(int i = 0; i < l; i++){
        					GameRoleDetail gamer = new GameRoleDetail();
        					try {
        						gamer = (GameRoleDetail) ((GameRoleDetail)CacheGameRole.gameRoleQueue_in.front()).clone();
        						CacheGameRole.gameRoleQueue_in.dequeue();
        					} catch (CloneNotSupportedException e) {
        						e.printStackTrace();
        						continue;
        					}
        					gameRoleIQ.add(gamer);
        				}
    				}
    				
    			}
    		}
    		if(null != CacheGameRole.gameRoleQueue){
    			if(CacheGameRole.gameRoleQueue.size() > 0){
    				int l = CacheGameRole.gameRoleQueue.size();
    				if(l != 0){
    					for(int i = 0; i < l; i++){
        					GameRoleDetail gamer = new GameRoleDetail();
        					try {
        						gamer = (GameRoleDetail) ((GameRoleDetail)CacheGameRole.gameRoleQueue.front()).clone();
        						CacheGameRole.gameRoleQueue.dequeue();
        					} catch (CloneNotSupportedException e) {
        						// TODO Auto-generated catch block
        						e.printStackTrace();
        						continue;
        					}
        					gameRoleQ.add(gamer);
        				}
    				}
    				
    			}
    		}
    	}else if(name == "roleChallenge"){
    		if(null != CacheRoleChallenge.roleChallengeQueue){
    			if(CacheRoleChallenge.roleChallengeQueue.size() > 0){
    				int l = CacheRoleChallenge.roleChallengeQueue.size();
    				if(l != 0){
    					for(int i = 0; i < l; i++){
        					RoleChallengeDetail rolec = new RoleChallengeDetail();
        					try {
    							rolec = (RoleChallengeDetail) ((RoleChallengeDetail)CacheRoleChallenge.roleChallengeQueue.front()).clone();
    							CacheRoleChallenge.roleChallengeQueue.dequeue();
    						} catch (CloneNotSupportedException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    							continue;
    						}
        					roleChallengeQ.add(rolec);
        				}
    				}
    				
    			}
    		}
    	}else if(name == "roleDaytask"){
    		if(null != CacheRoleDaytask.roleDaytaskQueue_in){
    			if(CacheRoleDaytask.roleDaytaskQueue_in.size() > 0){
    				int l = CacheRoleDaytask.roleDaytaskQueue_in.size();
    				if(l != 0){
    					for(int i = 0; i < l; i++){
        					RoleDaytaskDetail roled = new RoleDaytaskDetail();
        					try {
    							roled = (RoleDaytaskDetail) ((RoleDaytaskDetail)CacheRoleDaytask.roleDaytaskQueue_in.front()).clone();
    							CacheRoleDaytask.roleDaytaskQueue_in.dequeue();
    						} catch (CloneNotSupportedException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    						}
        					roleDaytaskIQ.add(roled);
        					continue;
        				}
    				}
    				
    			}
    		}
    		if(null != CacheRoleDaytask.roleDaytaskQueue){
    			if(CacheRoleDaytask.roleDaytaskQueue.size() > 0){
    				int l = CacheRoleDaytask.roleDaytaskQueue.size();
    				if(l != 0){
    					for(int i = 0; i < l; i++){
        					RoleDaytaskDetail roled = new RoleDaytaskDetail();
        					try {
    							roled = (RoleDaytaskDetail) ((RoleDaytaskDetail)CacheRoleDaytask.roleDaytaskQueue.front()).clone();
    							CacheRoleDaytask.roleDaytaskQueue.dequeue();
    						} catch (CloneNotSupportedException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    							continue;
    						}
        					roleDaytaskQ.add(roled);
        				}
    				}
    				
    			}
    		}
    	}else if(name == "roleEquip"){
    		if(null != CacheRoleEquip.roleEquipQueue_in){
    			if(CacheRoleEquip.roleEquipQueue_in.size() > 0){
    				int l = CacheRoleEquip.roleEquipQueue_in.size();
    				if(l != 0){
    					for(int i = 0; i < l; i++){
        					RoleEquipDetail rolee = new RoleEquipDetail();
        					try {
    							rolee = (RoleEquipDetail) ((RoleEquipDetail)CacheRoleEquip.roleEquipQueue_in.front()).clone();
    							CacheRoleEquip.roleEquipQueue_in.dequeue();
    						} catch (CloneNotSupportedException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    							continue;
    						}
        					roleEquipIQ.add(rolee);
        				}
    				}
    				
    			}
    		}
    		if(null != CacheRoleEquip.roleEquipQueue){
    			if(CacheRoleEquip.roleEquipQueue.size() > 0){
    				int l = CacheRoleEquip.roleEquipQueue.size();
    				if(l != 0){
    					for(int i = 0; i < l; i++){
        					RoleEquipDetail rolee = new RoleEquipDetail();
        					try {
    							rolee = (RoleEquipDetail) ((RoleEquipDetail)CacheRoleEquip.roleEquipQueue.front()).clone();
    							CacheRoleEquip.roleEquipQueue.dequeue();
    						} catch (CloneNotSupportedException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    							continue;
    						}
        					roleEquipQ.add(rolee);
        				}
    				}
    				
    			}
    		}
    	}else if(name == "roleImpose"){
    		if(null != CacheRoleImpose.roleImposeQueue){
    			if(CacheRoleImpose.roleImposeQueue.size() > 0){
    				int l = CacheRoleImpose.roleImposeQueue.size();
    				if(l != 0){
    					for(int i = 0; i < l; i++){
        					RoleImposeDetail rolei = new RoleImposeDetail();
        					try {
    							rolei = (RoleImposeDetail) ((RoleImposeDetail)CacheRoleImpose.roleImposeQueue.front()).clone();
    							CacheRoleImpose.roleImposeQueue.dequeue();
    						} catch (CloneNotSupportedException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    							continue;
    						}
        					roleImposeQ.add(rolei);
        				}
    				}
    				
    			}
    		}
    	}else if(name == "roleIns"){
    		if(null != CacheRoleIns.roleInsQueue){
    			if(CacheRoleIns.roleInsQueue.size() > 0){
    				int l = CacheRoleIns.roleInsQueue.size();
    				if(l != 0){
    					for(int i = 0; i < l; i++){
        					RoleInsDetail rolei = new RoleInsDetail();
        					try {
    							rolei = (RoleInsDetail) ((RoleInsDetail)CacheRoleIns.roleInsQueue.front()).clone();
    							CacheRoleIns.roleInsQueue.dequeue();
    						} catch (CloneNotSupportedException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    							continue;
    						}
        					roleInsQ.add(rolei);
        				}
    				}
    				
    			}
    		}
    	}else if(name == "roleItem"){
    		if(null != CacheRoleItem.roleItemQueue_in){
    			if(CacheRoleItem.roleItemQueue_in.size() > 0){
    				int l = CacheRoleItem.roleItemQueue_in.size();
    				if(l != 0){
    					for(int i = 0; i < l; i++){
        					RoleItemDetail rolee = new RoleItemDetail();
        					try {
    							rolee = (RoleItemDetail) ((RoleItemDetail)CacheRoleItem.roleItemQueue_in.front()).clone();
    							CacheRoleItem.roleItemQueue_in.dequeue();
    						} catch (CloneNotSupportedException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    							continue;
    						}
        					roleItemIQ.add(rolee);
        				}
    				}
    				
    			}
    		}
    		if(null != CacheRoleItem.roleItemQueue){
    			if(CacheRoleItem.roleItemQueue.size() > 0){
    				int l = CacheRoleItem.roleItemQueue.size();
    				if(l != 0){
    					for(int i = 0; i < l; i++){
        					RoleItemDetail rolee = new RoleItemDetail();
        					try {
    							rolee = (RoleItemDetail) ((RoleItemDetail)CacheRoleItem.roleItemQueue.front()).clone();
    							CacheRoleItem.roleItemQueue.dequeue();
    						} catch (CloneNotSupportedException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    							continue;
    						}
        					roleItemQ.add(rolee);
        				}
    				}
    				
    			}
    		}
    	}else if(name == "roleMap"){
    		if(null != CacheRoleMap.roleMapQueue){
    			if(CacheRoleMap.roleMapQueue.size() > 0){
    				int l = CacheRoleMap.roleMapQueue.size();
    				if(l != 0){
    					for(int i = 0; i < l; i++){
        					RoleMapDetail rolei = new RoleMapDetail();
        					try {
    							rolei = (RoleMapDetail) ((RoleMapDetail)CacheRoleMap.roleMapQueue.front()).clone();
    							CacheRoleMap.roleMapQueue.dequeue();
    						} catch (CloneNotSupportedException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    							continue;
    						}
        					roleMapQ.add(rolei);
        				}
    				}
    				
    			}
    		}
    	}else if(name == "roleMilitary"){
    		if(null != CacheRoleMilitary.roleMilitaryQueue_in){
    			if(CacheRoleMilitary.roleMilitaryQueue_in.size() > 0){
    				int l = CacheRoleMilitary.roleMilitaryQueue_in.size();
    				if(l != 0){
    					for(int i = 0; i < l; i++){
        					RoleMilitaryDetail rolee = new RoleMilitaryDetail();
        					try {
    							rolee = (RoleMilitaryDetail) ((RoleMilitaryDetail)CacheRoleMilitary.roleMilitaryQueue_in.front()).clone();
    							CacheRoleMilitary.roleMilitaryQueue_in.dequeue();
    						} catch (CloneNotSupportedException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    							continue;
    						}
        					roleMilitaryIQ.add(rolee);
        				}
    				}
    				
    			}
    		}
    		if(null != CacheRoleMilitary.roleMilitaryQueue){
    			if(CacheRoleMilitary.roleMilitaryQueue.size() > 0){
    				int l = CacheRoleMilitary.roleMilitaryQueue.size();
    				if(l != 0){
    					for(int i = 0; i < l; i++){
        					RoleMilitaryDetail rolee = new RoleMilitaryDetail();
        					try {
    							rolee = (RoleMilitaryDetail) ((RoleMilitaryDetail)CacheRoleMilitary.roleMilitaryQueue.front()).clone();
    							CacheRoleMilitary.roleMilitaryQueue.dequeue();
    						} catch (CloneNotSupportedException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    							continue;
    						}
        					roleMilitaryQ.add(rolee);
        				}
    				}
    				
    			}
    		}
    	}else if(name == "roleQuicktime"){
    		if(null != CacheRoleQuicktime.roleQuicktimeQueue){
    			if(CacheRoleQuicktime.roleQuicktimeQueue.size() > 0){
    				int l = CacheRoleQuicktime.roleQuicktimeQueue.size();
    				if(l != 0){
    					for(int i = 0; i < l; i++){
        					RoleQuicktimeDetail rolei = new RoleQuicktimeDetail();
        					try {
    							rolei = (RoleQuicktimeDetail) ((RoleQuicktimeDetail)CacheRoleQuicktime.roleQuicktimeQueue.front()).clone();
    							CacheRoleQuicktime.roleQuicktimeQueue.dequeue();
    						} catch (CloneNotSupportedException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    							continue;
    						}
        					roleQuicktimeQ.add(rolei);
        				}
    				}
    				
    			}
    		}
    	}else if(name == "roleTarven"){
    		if(null != CacheRoleTarven.RoleTarvenQueue_in){
    			if(CacheRoleTarven.RoleTarvenQueue_in.size() > 0){
    				int l = CacheRoleTarven.RoleTarvenQueue_in.size();
    				if(l != 0){
    					for(int i = 0; i < l; i++){
        					RoleTavernDetail rolee = new RoleTavernDetail();
        					try {
    							rolee = (RoleTavernDetail) ((RoleTavernDetail)CacheRoleTarven.RoleTarvenQueue_in.front()).clone();
    							CacheRoleTarven.RoleTarvenQueue_in.dequeue();
    						} catch (CloneNotSupportedException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    							continue;
    						}
        					roleTarvenIQ.add(rolee);
        				}
    				}
    				
    			}
    		}
    		if(null != CacheRoleTarven.RoleTarvenQueue){
    			if(CacheRoleTarven.RoleTarvenQueue.size() > 0){
    				int l = CacheRoleTarven.RoleTarvenQueue.size();
    				if(l != 0){
    					for(int i = 0; i < l; i++){
        					RoleTavernDetail rolee = new RoleTavernDetail();
        					try {
    							rolee = (RoleTavernDetail) ((RoleTavernDetail)CacheRoleTarven.RoleTarvenQueue.front()).clone();
    							CacheRoleTarven.RoleTarvenQueue.dequeue();
    						} catch (CloneNotSupportedException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    							continue;
    						}
        					roleTarvenQ.add(rolee);
        				}
    				}
    				
    			}
    		}
    	}else if(name == "roleTask"){
    		if(null != CacheRoleTask.roleTaskQueue_in){
    			if(CacheRoleTask.roleTaskQueue_in.size() > 0){
    				int l = CacheRoleTask.roleTaskQueue_in.size();
    				if(l != 0){
    					for(int i = 0; i < l; i++){
        					RoleTaskDetail rolee = new RoleTaskDetail();
        					try {
    							rolee = (RoleTaskDetail) ((RoleTaskDetail)CacheRoleTask.roleTaskQueue_in.front()).clone();
    							CacheRoleTask.roleTaskQueue_in.dequeue();
    						} catch (CloneNotSupportedException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    							continue;
    						}
        					roleTaskIQ.add(rolee);
        				}
    				}
    				
    			}
    		}
    		if(null != CacheRoleTask.roleTaskQueue){
    			if(CacheRoleTask.roleTaskQueue.size() > 0){
    				int l = CacheRoleTask.roleTaskQueue.size();
    				if(l != 0){
    					for(int i = 0; i < l; i++){
        					RoleTaskDetail rolee = new RoleTaskDetail();
        					try {
    							rolee = (RoleTaskDetail) ((RoleTaskDetail)CacheRoleTask.roleTaskQueue.front()).clone();
    							CacheRoleTask.roleTaskQueue.dequeue();
    						} catch (CloneNotSupportedException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    							continue;
    						}
        					roleTaskQ.add(rolee);
        				}
    				}
    				
    			}
    		}
    	}else if(name == "roleTaskTask"){
    		if(null != CacheRoleTaskTask.roleTaskTaskQueue){
    			if(CacheRoleTaskTask.roleTaskTaskQueue.size() > 0){
    				int l = CacheRoleTaskTask.roleTaskTaskQueue.size();
    				if(l != 0){
    					for(int i = 0; i < l; i++){
        					RoleTaskTaskDetail rolei = new RoleTaskTaskDetail();
        					try {
    							rolei = (RoleTaskTaskDetail) ((RoleTaskTaskDetail)CacheRoleTaskTask.roleTaskTaskQueue.front()).clone();
    							CacheRoleTaskTask.roleTaskTaskQueue.dequeue();
    						} catch (CloneNotSupportedException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    							continue;
    						}
        					roleTaskTaskQ.add(rolei);
        				}
    				}
    				
    			}
    		}
    	}else if(name == "roletotem"){
    		if(null != CacheRoletotme.gameRoletotmeQueue){
    			if(CacheRoletotme.gameRoletotmeQueue.size() > 0){
    				int l = CacheRoletotme.gameRoletotmeQueue.size();
    				if(l != 0){
    					for(int i = 0; i < l; i++){
        					RoletotemDetail rolei = new RoletotemDetail();
        					try {
    							rolei = (RoletotemDetail) ((RoletotemDetail)CacheRoletotme.gameRoletotmeQueue.front()).clone();
    							CacheRoletotme.gameRoletotmeQueue.dequeue();
    						} catch (CloneNotSupportedException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    							continue;
    						}
        					roleTotmeQ.add(rolei);
        				}
    				}
    				
    			}
    		}
    	}
    }
    //读取备份的内容
    private void read(String name){
    	if(name == "gameRole"){
    		if(gameRoleIQ.size() > 0){
    			for(int i = 0; i < gameRoleIQ.size(); i++){
    				this.getGameRoleService().insertRole(gameRoleIQ.get(i));
    			}
    			gameRoleIQ.clear();
    		}
    		if(gameRoleQ.size() > 0){
    			for(int i = 0; i < gameRoleQ.size(); i++){
    				this.getGameRoleService().updateRole(gameRoleQ.get(i));
    			}
    			gameRoleQ.clear();
    		}
    	}else if(name == "roleChallenge"){
    		if(roleChallengeQ.size() > 0){
    			for(int i = 0; i < roleChallengeQ.size(); i++){
    				this.getRoleChallengeService().updateroleChallenge(roleChallengeQ.get(i));
    			}
    			roleChallengeQ.clear();
    		}
    	}else if(name == "roleDaytask"){
    		if(roleDaytaskIQ.size() > 0){
    			for(int i = 0; i < roleDaytaskIQ.size(); i++){
    				this.getRoleDaytaskService().insertRoleDaytask(roleDaytaskIQ.get(i));
    			}
    			roleDaytaskIQ.clear();
    		}
    		if(roleDaytaskQ.size() > 0){
    			for(int i = 0; i < roleDaytaskQ.size(); i++){
    				this.getRoleDaytaskService().updateRoleDaytask(roleDaytaskQ.get(i));
    			}
    			roleDaytaskQ.clear();
    		}
    	}else if(name == "roleEquip"){
    		if(roleEquipIQ.size() > 0){
    			for(int i = 0; i < roleEquipIQ.size(); i++){
    				this.getRoleEquipService().insertRoleEquip(roleEquipIQ.get(i));
    			}
    			roleEquipIQ.clear();
    		}
    		if(roleEquipQ.size() > 0){
    			for(int i = 0; i < roleEquipQ.size(); i++){
    				this.getRoleEquipService().updateRoleEquips(roleEquipQ.get(i));
    			}
    			roleEquipQ.clear();
    		}
    	}else if(name == "roleImpose"){
    		if(roleImposeQ.size() > 0){
    			for(int i = 0; i < roleImposeQ.size(); i++){
    				this.getRoleImposeService().updateImpose(roleImposeQ.get(i));
    			}
    			roleEquipQ.clear();
    		}
    	}else if(name == "roleIns"){
    		if(roleInsQ.size() > 0){
    			for(int i = 0; i < roleInsQ.size(); i++){
    				this.getRoleInsService().updateIns(roleInsQ.get(i));
    			}
    			roleInsQ.clear();
    		}
    	}else if(name == "roleItem"){
    		if(roleItemIQ.size() > 0){
    			for(int i = 0; i < roleItemIQ.size(); i++){
    				this.getRoleItemService().insertRoleItem(roleItemIQ.get(i));
    			}
    			roleItemIQ.clear();
    		}
    		if(roleItemQ.size() > 0){
    			for(int i = 0; i < roleItemQ.size(); i++){
    				this.getRoleItemService().updateRoleItems(roleItemQ.get(i));
    			}
    			roleItemQ.clear();
    		}
    	}else if(name == "roleMap"){
    		if(roleMapQ.size() > 0){
    			for(int i = 0; i < roleMapQ.size(); i++){
    				this.getRoleMapService().updateMap(roleMapQ.get(i));
    			}
    			roleMapQ.clear();
    		}
    	}else if(name == "roleMilitary"){
    		if(roleMilitaryIQ.size() > 0){
    			for(int i = 0; i < roleMilitaryIQ.size(); i++){
    				this.getRoleMilitaryService().insertRoleMilitary(roleMilitaryIQ.get(i));
    			}
    			roleMilitaryIQ.clear();
    		}
    		if(roleMilitaryQ.size() > 0){
    			for(int i = 0; i < roleMilitaryQ.size(); i++){
    				this.getRoleMilitaryService().updateRoleMilitaryc(roleMilitaryQ.get(i));
    			}
    			roleMilitaryQ.clear();
    		}
    	}else if(name == "roleQuicktime"){
    		if(roleQuicktimeQ.size() > 0){
    			for(int i = 0; i < roleQuicktimeQ.size(); i++){
    				this.getRoleQuicktimeService().updateQuicktime(roleQuicktimeQ.get(i));
    			}
    			roleQuicktimeQ.clear();
    		}
    	}else if(name == "roleTarven"){
    		if(roleTarvenIQ.size() > 0){
    			for(int i = 0; i < roleTarvenIQ.size(); i++){
    				this.getRoleTavernService().insertRoleTarven(roleTarvenIQ.get(i));
    			}
    			roleTarvenIQ.clear();
    		}
    		if(roleTarvenQ.size() > 0){
    			for(int i = 0; i < roleTarvenQ.size(); i++){
    				this.getRoleTavernService().updateRoleTarven(roleTarvenQ.get(i));
    			}
    			roleTarvenQ.clear();
    		}
    	}else if(name == "roleTask"){
    		if(roleTaskIQ.size() > 0){
    			for(int i = 0; i < roleTaskIQ.size(); i++){
    				this.getRoleTaskService().insertRoleTask(roleTaskIQ.get(i));
    			}
    			roleTaskIQ.clear();
    		}
    		if(roleTaskQ.size() > 0){
    			for(int i = 0; i < roleTaskQ.size(); i++){
    				this.getRoleTaskService().updateRoleTaskc(roleTaskQ.get(i));
    			}
    			roleTaskQ.clear();
    		}
    	}else if(name == "roleTaskTask"){
    		if(roleTaskTaskQ.size() > 0){
    			for(int i = 0; i < roleTaskTaskQ.size(); i++){
    				this.getRoleTaskTaskService().updateTaskTask(roleTaskTaskQ.get(i));
    			}
    			roleTaskTaskQ.clear();
    		}
    	}else if(name == "roletotem"){
    		if(roleTotmeQ.size() > 0){
    			for(int i = 0; i < roleTotmeQ.size(); i++){
    				this.getRoletotemService().updateTotem(roleTotmeQ.get(i));
    			}
    			roleTotmeQ.clear();
    		}
    	}
    }
	private void initGlobalCache(){
		save("roleChallenge");
		List<RoleChallengeDetail> roleChallengeList = this.getRoleChallengeService().findAllRoleChallenge();
		for(int i = 0; i < roleChallengeList.size(); i++){
			GlobalDatat.cacheRoleChallengeDetails.put(roleChallengeList.get(i).getRoleid(), roleChallengeList.get(i));
		}
		GameConstants.log.warn("roleChallengeList:	" + GlobalDatat.cacheRoleChallengeDetails.size());
		read("roleChallenge");
		
		List<ActivityDetail> activityList = this.getActivityService().findAllActivity();
		Calendar calendar = Calendar.getInstance();
		int month0 = calendar.get(Calendar.MONTH) + 1;//当前月
		int day0 = calendar.get(Calendar.DAY_OF_MONTH);//当前天
		for(int i = 0; i < activityList.size(); i++){
			int serverid = activityList.get(i).getServerid();
			GlobalDatat.cacheActivities.put(activityList.get(i).getId(), activityList.get(i));
//			System.out.println("activityID:"+activityList.get(i).getId()+","+activityList.get(i).getDescription());
			if(activityList.get(i).getId() > 1000 && activityList.get(i).getFlag() == 1){//15天开服活动（4合1）
				int month = activityList.get(i).getMonth();
				int day = activityList.get(i).getDay();
				int monthend = activityList.get(i).getMonthend();
				int dayend = activityList.get(i).getDayend();
				if(month!=monthend){
					if(month0>=month && month0<=monthend){
						if(month0==month){
							if(day0>=day){
								JSONArray newServerData = new JSONArray();
								newServerData.add(activityList.get(i).getServerid());
								newServerData.add(month);
								newServerData.add(day);
								GlobalDatat.newServerDataMap.put(serverid, newServerData);
								GlobalDatat.newServerActivityDataMap.put(serverid,activityList.get(i));
								GameConstants.log.warn("newserverdata:	NO."+serverid+" new server is OK:" + newServerData);
							}
						}else if(month0==monthend){
							if(day0<=dayend){
								JSONArray newServerData = new JSONArray();
								newServerData.add(activityList.get(i).getServerid());
								newServerData.add(activityList.get(i).getMonth());
								newServerData.add(activityList.get(i).getDay());
								GlobalDatat.newServerDataMap.put(serverid, newServerData);
								GlobalDatat.newServerActivityDataMap.put(serverid,activityList.get(i));
								GameConstants.log.warn("newserverdata:	NO."+serverid+" new server is OK:" + newServerData);
							}
						}else if(month0!=month&&month0!=monthend){
							JSONArray newServerData = new JSONArray();
							newServerData.add(activityList.get(i).getServerid());
							newServerData.add(activityList.get(i).getMonth());
							newServerData.add(activityList.get(i).getDay());
							GlobalDatat.newServerDataMap.put(serverid, newServerData);
							GlobalDatat.newServerActivityDataMap.put(serverid,activityList.get(i));
							GameConstants.log.warn("newserverdata:	NO."+serverid+" new server is OK:" + newServerData);
						}
					}
				}
				if(month == monthend){
					if(day0>=day&&day0<=dayend){
						JSONArray newServerData = new JSONArray();
						newServerData.add(activityList.get(i).getServerid());
						newServerData.add(activityList.get(i).getMonth());
						newServerData.add(activityList.get(i).getDay());
						GlobalDatat.newServerDataMap.put(serverid, newServerData);
						GlobalDatat.newServerActivityDataMap.put(serverid,activityList.get(i));
						GameConstants.log.warn("newserverdata:	NO."+serverid+" new server is OK:" + newServerData);
					}
				}
			}
		}
//		int newserverdataMapSize = GlobalDatat.newserverdataMap.size();
		GameConstants.log.warn("activityList:		" + GlobalDatat.cacheActivities.size());
		
		save("gameRole");
		//System.out.println("GlobalDatat.challenge:size:" + GlobalDatat.challenge.size());
		GlobalDatat.challenge.clear();
		//System.out.println("GlobalDatat.challenge:size:" + GlobalDatat.challenge.size());
		List<GameRoleDetail> gameRoleList = this.getGameRoleService().findAllGameRole();
		GameRoleDetail g = new GameRoleDetail();
		try{
			for(int i = 0; i < gameRoleList.size(); i++){
				//服务器整体缓存处理
				g = (GameRoleDetail) gameRoleList.get(i).clone();
				GlobalDatat.cacheGameRoleDetails.put(gameRoleList.get(i).getId(), gameRoleList.get(i)); 
				//通关玩家缓存数据处理
				if(GlobalDatat.pMap.containsKey(g.getMapid())){
					if(GlobalDatat.pMap.get(g.getMapid()).size() < 60){
						GlobalDatat.pMap.get(g.getMapid()).add(g.getId());
					}
				}else{
					List<Integer> list = new ArrayList<Integer>();
					list.add(g.getId());
					GlobalDatat.pMap.put(g.getMapid(), list);
				}
				//争霸战缓存数据处理
				addChanllenge(g);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		GameConstants.log.warn("gameRoleList:		" + GlobalDatat.cacheGameRoleDetails.size());
//		for (Integer serverid : GlobalDatat.newserverdataMap.keySet()) {
//			try{
//				GlobalDatat.mapcharge.clear();
//				for (int i = 0; i < gameRoleList.size(); i++) {
//					g = (GameRoleDetail) gameRoleList.get(i).clone();
//					if(serverid == Integer.valueOf(g.getServerId())){
//						GlobalDatat.mapcharge.put(g.getId(), g.getCoinspend());
//					}
//				}
//				GlobalDatat.mapChargeMap.put(serverid, GlobalDatat.mapcharge);
//			}catch(Exception e){
//				e.printStackTrace();
//			}finally{
//				GameConstants.log.warn("GlobalDatat.mapChargeMap for	" + serverid +"	"+ GlobalDatat.mapChargeMap.get(serverid).size());
//			}
//		} 
//		GameConstants.log.warn("mapChargeMap:		" + GlobalDatat.mapChargeMap.size());
//		GameConstants.log.warn("gamepMap:			" + GlobalDatat.pMap.size());
		//GameConstants.log.warn("GlobalDatat.challenge.toString():	" + GlobalDatat.challenge.toString());
		
		read("gameRole");
		List<AutoIdDetail> autoIdList = this.getAutoIdService().findAllAutoId();
		for(int i = 0; i < autoIdList.size(); i++){
			GlobalDatat.cacheAutoIdDetails.put(autoIdList.get(i).getId(), autoIdList.get(i));	
		}
		GameConstants.log.warn("autoIdList:		" + GlobalDatat.cacheAutoIdDetails.size());
		
//		List<ActivityDetail> activityList = this.getActivityService().findAllActivity();
//		for(int i = 0; i < activityList.size(); i++){
//			GlobalDatat.cacheActivities.put(activityList.get(i).getId(), activityList.get(i));
//			GlobalDatat.newserverdata.clear();
//			if(activityList.get(i).getId()==22){//15天开服活动（4合1）
//				GlobalDatat.newserverdata.clear();
//				GlobalDatat.newserverdata.add(activityList.get(i).getMonth());
//				GlobalDatat.newserverdata.add(activityList.get(i).getDay());
//				GlobalDatat.newserverdata.add(activityList.get(i).getServerid());
//			}
//		}
//		GameConstants.log.warn("newserverdata:		"+GlobalDatat.newserverdata.size());
//		GameConstants.log.warn("activityList:		" + GlobalDatat.cacheActivities.size());
		
		List<CallGiftDetail> callGiftList = this.getCallgiftService().findAllCallGift();
		for(int i = 0; i < callGiftList.size(); i++){
			GlobalDatat.cacheCallGiftDetails.put(callGiftList.get(i).getId(), callGiftList.get(i));
		}
		GameConstants.log.warn("callGiftList:		" + GlobalDatat.cacheCallGiftDetails.size());
		
		List<ChallengeRecordDetail> challengeRecordList = this.getChallengeRecordService().findAllChallengeRecord();
		for(int i = 0; i < challengeRecordList.size(); i++){
			GlobalDatat.cacheChallengeRecordDetails.put(challengeRecordList.get(i).getId(), challengeRecordList.get(i));
		}
		GameConstants.log.warn("challengeRecordList:	" + GlobalDatat.cacheChallengeRecordDetails.size());
		
		List<CoinDetail> coinList=this.getCoinService().findAllCoin();
		for(int i=0;i<coinList.size();i++){
			GlobalDatat.cacheCoindetails.put(coinList.get(i).getId(), coinList.get(i));
		}
		GameConstants.log.warn("coinList:		" + GlobalDatat.cacheCoindetails.size());
		
		List<DeliveryDetail> deliveryList = this.getDeliveryService().findAllDelivery();
		for(int i = 0; i < deliveryList.size(); i++){
			GlobalDatat.cacheDeliveryDetails.put(deliveryList.get(i).getOpenid(), deliveryList.get(i));
		}
		GameConstants.log.warn("deliveryList:		" + GlobalDatat.cacheDeliveryDetails.size());
		
		List<GamblingItemDetail> gamblingItemList = this.getGamblingItemService().findAllGamblingItem();
		for(int i = 0; i < gamblingItemList.size(); i++){
			GlobalDatat.cacheGamblingItemDetails.put(gamblingItemList.get(i).getId(), gamblingItemList.get(i));
		}
		GameConstants.log.warn("gamblingItemList:	" + GlobalDatat.cacheGamblingItemDetails.size());
		
		List<GameAvatarDetail> gameAvatarList = this.getGameAvatarService().findAllGameAvatar();
		for(int i = 0; i < gameAvatarList.size(); i++){
			GlobalDatat.cacheGameAvatarDetails.put(gameAvatarList.get(i).getId(), gameAvatarList.get(i));
		}
		GameConstants.log.warn("gameAvatarList:	" + GlobalDatat.cacheGameAvatarDetails.size());
		
		List<GameBbuffDetail> gameBbuffList = this.getGameBbuffService().getGameBbuff();
		for(int i = 0; i < gameBbuffList.size(); i++){
			GlobalDatat.cacheGameBbuffDetails.put(gameBbuffList.get(i).getId(), gameBbuffList.get(i));
		}
		GameConstants.log.warn("gameBbuffList:		" + GlobalDatat.cacheGameBbuffDetails.size());
		
		List<GameBingDetail> gameBingList = this.getGameBingService().getGameBing();
		for(int i = 0; i < gameBingList.size(); i++){
			GlobalDatat.cacheGameBingDetails.put(gameBingList.get(i).getId(), gameBingList.get(i));
		}
		GameConstants.log.warn("gameBingList:		" + GlobalDatat.cacheGameBingDetails.size());
		
		List<GameBmapDetail> gameBmapList = this.getGameBmapService().getGameBmap();
		for(int i = 0; i < gameBmapList.size(); i++){
			GlobalDatat.cacheGameBmapDetails.put(gameBmapList.get(i).getId(), gameBmapList.get(i));
		}
		GameConstants.log.warn("gameBmapList:		" + GlobalDatat.cacheGameBmapDetails.size());
		
		List<GameBskillDetail> gameBskillList = this.getGameBskillService().getGameBskill();
		for(int i = 0; i < gameBskillList.size(); i++){
			GlobalDatat.cacheGameBskillDetails.put(gameBskillList.get(i).getId(), gameBskillList.get(i));
		}
		GameConstants.log.warn("gameBskillList:	" + GlobalDatat.cacheGameBskillDetails.size());
		
		List<GameBuffDetail> gameBuffList = this.getGameBuffService().getGameBuff();
		for(int i = 0; i < gameBuffList.size(); i++){
			GlobalDatat.cacheGameBuffDetails.put(gameBuffList.get(i).getId(), gameBuffList.get(i));
		}
		GameConstants.log.warn("gameBuffList:		" + GlobalDatat.cacheGameBuffDetails.size());
		
		List<GameChartsDetail> gameCharsList = this.getGameChartsService().findAllGameCharts();
		for(int i = 0; i < gameCharsList.size(); i++){////
			GlobalDatat.cacheGameChartsDetails.put(i, gameCharsList.get(i));
		}
		GameConstants.log.warn("gameCharsList:		" + GlobalDatat.cacheGameChartsDetails.size());
		
		//不需要查询
//		List<GameChartstwoDetail> gameCharstwoList = this.getGameChartstwoService().findAllGameChartstwo();
//		for(int i = 0; i < gameCharstwoList.size(); i++){
//			GlobalDatat.cacheGameChartstwoDetails.put(gameCharstwoList.get(i).getId(), gameCharstwoList.get(i));
//		}
//		GameConstants.log.warn("gameCharstwoList:" + GlobalDatat.cacheGameChartstwoDetails.size());
		
		
		List<GameChLevelDetail> gameChLevelList = this.getGameChLevelService().getGameChLevel();
		for(int i = 0; i < gameChLevelList.size(); i++){
			GlobalDatat.cacheGameChLevelDetails.put(gameChLevelList.get(i).getId(), gameChLevelList.get(i));
		}
		GameConstants.log.warn("gameChLevelList:	" + GlobalDatat.cacheGameChLevelDetails.size());
		
		List<GameEInsDetail> gameEInsList = this.getGameEInsService().getGameEIns();
		for(int i = 0; i < gameEInsList.size(); i++){
			GlobalDatat.cacheGameEInsDetails.put(gameEInsList.get(i).getLevel(), gameEInsList.get(i));
		}
		GameConstants.log.warn("gameEInsList:		" + GlobalDatat.cacheGameEInsDetails.size());
	
		List<GameEPropertyDetail> gameEPropertyList = this.getGameEPropertyService().getGameEProperty();
		for(int i = 0; i < gameEPropertyList.size(); i++){
			GlobalDatat.cacheGameEPropertyDetails.put(gameEPropertyList.get(i).getId(), gameEPropertyList.get(i));
		}
		GameConstants.log.warn("gameEPropertyList:	" + GlobalDatat.cacheGameEPropertyDetails.size());
	
		List<GameEquipDetail> gameEquipList = this.getGameEquipService().getGameEquip();
		for(int i=0;i<gameEquipList.size();i++){
			GlobalDatat.cacheGameEquipDetails.put(gameEquipList.get(i).getId(), gameEquipList.get(i));
		}
		GameConstants.log.warn("gameEquipList:		" + GlobalDatat.cacheGameEquipDetails.size());
	
		List<GameFoeDetail> gameFoeList = this.getGameFoeService().getGameFoe();
		for(int i = 0; i < gameFoeList.size(); i++){
			GlobalDatat.cacheGameFoeDetails.put(gameFoeList.get(i).getFoeid(), gameFoeList.get(i));
		}
		GameConstants.log.warn("gameFoeList:		" + GlobalDatat.cacheGameFoeDetails.size());
	
		List<GameItemDetail> gameItemList = this.getGameItemService().getGameItem();
		for(int i = 0; i < gameItemList.size(); i++){
			GlobalDatat.cacheGameItemDetails.put(gameItemList.get(i).getId(), gameItemList.get(i));
		}
		GameConstants.log.warn("gameItemList:		" + GlobalDatat.cacheGameItemDetails.size());
	
		List<GameJingjiFinalDetail> gamJingjiFinalList = this.getGameJingjiFinalService().findAllGameJingji();
		for(int i = 0; i < gamJingjiFinalList.size(); i++){
			GlobalDatat.cacheGameJingjiFinalDetails.put(gamJingjiFinalList.get(i).getId(), gamJingjiFinalList.get(i))	;
		}
		GameConstants.log.warn("gamJingjiFinalList:	" + GlobalDatat.cacheGameJingjiFinalDetails.size());
	
		List<GameJingjiStaticDetail> gameJingjiStaticList = this.getGameJingjiStaticService().findAllGameJingjiStatic();
		for(int i = 0; i < gameJingjiStaticList.size(); i++){
			GlobalDatat.cacheGameJingjiStaticDetails.put(gameJingjiStaticList.get(i).getId(), gameJingjiStaticList.get(i));
		}
		GameConstants.log.warn("gameJingjiStaticList:	" + GlobalDatat.cacheGameJingjiStaticDetails.size());
	
		List<GameLevelDetail> gameLevelList = this.getGameLevelService().findAllGameLevel();
		for(int i = 0; i < gameLevelList.size(); i++){
			//key:level value:gamelevel
			GlobalDatat.cacheGameLevelDetails.put(gameLevelList.get(i).getId(), gameLevelList.get(i));
		}
		GameConstants.log.warn("gameLevelList:		" + GlobalDatat.cacheGameLevelDetails.size());
		
		List<GameMapDetail> gameMapList = this.getGameMapService().getGameMap();
		for(int i = 0; i < gameMapList.size(); i++){
			GlobalDatat.cacheGameMapDetails.put(gameMapList.get(i).getId(), gameMapList.get(i));
		}
		GameConstants.log.warn("gameMapList:		" + GlobalDatat.cacheGameMapDetails.size());
		
		List<GameMilitaryDetail> gameMilitaryList = this.getGameMilitaryService().getGameMilitary();
		for(int i = 0; i < gameMilitaryList.size(); i++){
			GlobalDatat.cacheGameMilitaryDetails.put(gameMilitaryList.get(i).getId(), gameMilitaryList.get(i));
		}
		GameConstants.log.warn("gameMilitaryList:	" + GlobalDatat.cacheGameMilitaryDetails.size());
	
		List<GameMissionDetail> gameMissionList = this.getGameMissionService().getGameMission();
		for(int i = 0; i < gameMissionList.size(); i++){
			GlobalDatat.cacheGameMissionDetails.put(gameMissionList.get(i).getMapid(), gameMissionList.get(i));
		}
		GameConstants.log.warn("gameMissionList:	" + GlobalDatat.cacheGameMissionDetails.size());
	
		List<GameMLevelDetail> gameMLevelList = this.getGameMLevelService().getGameMLevel();
		for(int i = 0; i < gameMLevelList.size(); i++){
			GlobalDatat.cacheGameMLevelDetails.put(gameMLevelList.get(i).getId(), gameMLevelList.get(i));
		}
		GameConstants.log.warn("gameMLevelList:	" + GlobalDatat.cacheGameMLevelDetails.size());
	
		List<GamePlatsDetail> gamePlatsList = this.getGamePlatsService().getGamePlats();
		for(int i = 0; i < gamePlatsList.size(); i++){
			GlobalDatat.cacheGamePlatsDetails.put(gamePlatsList.get(i).getIndex(), gamePlatsList.get(i));
		}
		GameConstants.log.warn("gamePlatsList:		" + GlobalDatat.cacheGamePlatsDetails.size());
	
		List<GamePriceDetail> gamePriceList = this.getGamePriceService().getAllGamePrice();
		for(int i = 0; i < gamePriceList.size(); i++){
			GlobalDatat.cacheGamePriceDetails.put(gamePriceList.get(i).getId(), gamePriceList.get(i));
		}
		GameConstants.log.warn("gamePriceList:		" + GlobalDatat.cacheGamePriceDetails.size());
	
		List<GameRobotDetail> gameRobotList = this.getGameRobotService().findAllGameRobot();
		for(int i = 0; i < gameRobotList.size(); i++){
			GlobalDatat.cacheGameRobotDetails.put(gameRobotList.get(i).getId(), gameRobotList.get(i));
		}
		GameConstants.log.warn("gameRobotList:		" + GlobalDatat.cacheGameRobotDetails.size());
	
		List<GameSkillDetail> gameSkillList = this.getGameSkillService().getGameSkill();
		for(int i = 0; i < gameSkillList.size(); i++){
			GlobalDatat.cacheGameSkillDetails.put(gameSkillList.get(i).getId(), gameSkillList.get(i));
		}
		GameConstants.log.warn("gameSkillList:		" + GlobalDatat.cacheGameSkillDetails.size());
	
		List<GameStarDetail> gameStarList = this.getGameStarService().getallgamestar();
		for(int i = 0; i < gameStarList.size(); i++){
			GlobalDatat.cacheGameStarDetails.put(gameStarList.get(i).getId(), gameStarList.get(i));	
		}
		GameConstants.log.warn("gameStarList:		" + GlobalDatat.cacheGameStarDetails.size());
	
		List<GameTaskDetail> gameTaskList = this.getGameTaskService().findAllGameTask();
		for(int i = 0; i < gameTaskList.size(); i++){
			GlobalDatat.cacheGameTaskDetails.put(gameTaskList.get(i).getId(), gameTaskList.get(i));
		}
		GameConstants.log.warn("gameTaskList:		" + GlobalDatat.cacheGameTaskDetails.size());
	
		List<GametotemDetail> gametotemList = this.getGametotemService().getGametotem();
		for(int i = 0; i < gametotemList.size(); i++){
			GlobalDatat.cacheGametotemDetails.put(gametotemList.get(i).getId(), gametotemList.get(i));
		}
		GameConstants.log.warn("gametotemList:		" + GlobalDatat.cacheGametotemDetails.size());
	
		List<GameTowerDetail> gameTowerList = this.getGameTowerService().getGameTower();
		for(int i = 0; i < gameTowerList.size(); i++){
			GlobalDatat.cacheGameTowerDetails.put(gameTowerList.get(i).getId(), gameTowerList.get(i));
		}
		GameConstants.log.warn("gameTowerList:		" + GlobalDatat.cacheGameTowerDetails.size());
	
		List<GameVipDetail> gameVipList = this.getGameVipService().allGameVips();
		for(int i = 0; i < gameVipList.size(); i++){
			GlobalDatat.cacheGameVipDetails.put(gameVipList.get(i).getId(), gameVipList.get(i));
		}
		GameConstants.log.warn("gameVipList:		" + GlobalDatat.cacheGameVipDetails.size());
	
		List<HostDetail> hostList = this.getHostService().findAllHost();
		for(int i = 0; i < hostList.size(); i++){
			GlobalDatat.cacheHostDetails.put(hostList.get(i).getId(), hostList.get(i));
		}
		GameConstants.log.warn("hostList:		" + GlobalDatat.cacheHostDetails.size());
	
		List<MemberDetail> memberList = this.getMemberService().findAllMember();
		for(int i = 0; i < memberList.size(); i++){
			GlobalDatat.cacheMemberDetails.put(memberList.get(i).getId(), memberList.get(i));	
		}
		GameConstants.log.warn("memberList:		" + GlobalDatat.cacheMemberDetails.size());
	
		List<RoleAvatarDetail> roleAvatarList = this.getRoleAvatarService().findAllRoleAvatar();
		for(int i = 0; i < roleAvatarList.size(); i++){
			GlobalDatat.cacheRoleAvatarDetails.put(roleAvatarList.get(i).getId(), roleAvatarList.get(i));
		}
		GameConstants.log.warn("roleAvatarList:		" + GlobalDatat.cacheRoleAvatarDetails.size());
	
		List<RoleBingDetail> roleBingList = this.getRoleBingService().findAllRoleBing();
		for(int i = 0; i < roleBingList.size(); i++){
			GlobalDatat.cacheRoleBingDetails.put(roleBingList.get(i).getId(), roleBingList.get(i));
			
		}
		GameConstants.log.warn("roleBingList:		" + GlobalDatat.cacheRoleBingDetails.size());
	
		
		
		
		save("roleDaytask");
		List<RoleDaytaskDetail> roleDaytaskList = this.getRoleDaytaskService().findAllRoleDayTask();
		for(int i = 0; i < roleDaytaskList.size(); i++){
			GlobalDatat.cacheRoleDaytaskDetails.put(roleDaytaskList.get(i).getRoleid(), roleDaytaskList.get(i));
		}
		GameConstants.log.warn("roleDaytaskList:	" + GlobalDatat.cacheRoleDaytaskDetails.size());
		read("roleDaytask");
	
		save("roleEquip");
		List<RoleEquipDetail> roleEquipList = this.getRoleEquipService().findAllRoleEquip();
		List<Integer> mapForRoleEquip = null;
		GlobalDatat.cacheForRoleEquip.clear();
		for(int i = 0; i < roleEquipList.size(); i++){
			GlobalDatat.cacheRoleEquipDetails.put(roleEquipList.get(i).getId(), roleEquipList.get(i));
			if(GlobalDatat.cacheForRoleEquip.containsKey(roleEquipList.get(i).getRoleId())){
				GlobalDatat.cacheForRoleEquip.get(roleEquipList.get(i).getRoleId())
				.add(roleEquipList.get(i).getId());
			}else{
				mapForRoleEquip = new ArrayList<Integer>();
				mapForRoleEquip.add(roleEquipList.get(i).getId());
				GlobalDatat.cacheForRoleEquip.put(roleEquipList.get(i).getRoleId(), mapForRoleEquip);
			}
		}
		GameConstants.log.warn("roleEquipList:		" + GlobalDatat.cacheRoleEquipDetails.size());
		GameConstants.log.warn("cacheForRoleEquip:	" + GlobalDatat.cacheForRoleEquip.size());
		//GameConstants.log.warn("ServerHandler.cacheFOrRoleEquip.equips;" +  GlobalDatat.cacheForRoleEquip.get(6676).toString());
		read("roleEquip");
	
		save("roleImpose");
		List<RoleImposeDetail> roleImposeList = this.getRoleImposeService().findAllRoleImpose();
		for(int i = 0; i < roleImposeList.size(); i++){
			GlobalDatat.cacheRoleImposeDetails.put(roleImposeList.get(i).getRoleid(), roleImposeList.get(i));
		}
		GameConstants.log.warn("roleImposeList:		" + GlobalDatat.cacheRoleImposeDetails.size());
		read("roleImpose");
	
		save("roleIns");
		List<RoleInsDetail> roleInsList = this.getRoleInsService().findAlloleIns();
		for(int i = 0; i < roleInsList.size(); i++){
			GlobalDatat.cacheRoleInsDetails.put(roleInsList.get(i).getRoleId(), roleInsList.get(i));
		}
		GameConstants.log.warn("roleInsList:		" + GlobalDatat.cacheRoleInsDetails.size());
		read("roleIns");
		
		
		save("roleItem");
		List<RoleItemDetail> roleItemList = this.getRoleItemService().findAllRoleItem();
		HashMap<Integer, Long> mapForRoleItem = null;
		GlobalDatat.cacheForRoleItem.clear();
		for(int i = 0; i < roleItemList.size(); i++){
			GlobalDatat.cacheRoleItemDetails.put(roleItemList.get(i).getId(), roleItemList.get(i));
			if(GlobalDatat.cacheForRoleItem.containsKey((roleItemList.get(i).getRoleid()))){
				GlobalDatat.cacheForRoleItem.get(roleItemList.get(i).getRoleid())
				.put(roleItemList.get(i).getItemid(), roleItemList.get(i).getId());
//				if(roleItemList.get(i).getRoleid() == 6006){
//					GameConstants.log.warn("if:" + roleItemList.get(i).getItemid());
//				}
			}else{
				mapForRoleItem = new HashMap<Integer, Long>();
				mapForRoleItem.put(roleItemList.get(i).getItemid(), roleItemList.get(i).getId());
				GlobalDatat.cacheForRoleItem.put(roleItemList.get(i).getRoleid(), mapForRoleItem);
//				if(roleItemList.get(i).getRoleid() == 6006){
//					GameConstants.log.warn("else:" + roleItemList.get(i).getItemid());
//				}
			}
		}
		GameConstants.log.warn("roleItemList:		" + GlobalDatat.cacheRoleItemDetails.size());
		GameConstants.log.warn("cacheForRoleItem:	" + GlobalDatat.cacheForRoleItem.size());
		read("roleItem");

		save("roleMap");
		List<RoleMapDetail> roleMapList = this.getRoleMapService().findAllRoleMap();
		List<Integer> mapForRoleMap = null;
		GlobalDatat.cacheForRoleMap.clear();
		for(int i = 0; i < roleMapList.size(); i++){
			GlobalDatat.cacheRoleMapDetails.put(roleMapList.get(i).getId(), roleMapList.get(i));
			if(GlobalDatat.cacheForRoleMap.containsKey(roleMapList.get(i).getRoleId())){
				GlobalDatat.cacheForRoleMap.get(roleMapList.get(i).getRoleId())
				.add(roleMapList.get(i).getId());

			}else{
				mapForRoleMap = new ArrayList<Integer>();
				mapForRoleMap.add(roleMapList.get(i).getId());
				GlobalDatat.cacheForRoleMap.put(roleMapList.get(i).getRoleId(), mapForRoleMap);
			}
		}
		GameConstants.log.warn("roleMapList:		" + GlobalDatat.cacheRoleMapDetails.size());
		GameConstants.log.warn("cacheForRoleMap:	" + GlobalDatat.cacheForRoleMap.size());
		read("roleMap");
	
		save("roleMilitary");
		List<RoleMilitaryDetail> roleMilitaryList = this.getRoleMilitaryService().findAllRoleMilitary();
		Map<Integer,RoleAvatarDetail> roleMilitaryListById = null;
		List<Integer> mapForRoleMilitary = null;
		GlobalDatat.cacheForRoleMilitary.clear();
		for(int i = 0; i < roleMilitaryList.size(); i++){
			if(GlobalDatat.cacheRoleMilitaryDetails.containsKey(roleMilitaryList.get(i).getId())){
				GlobalDatat.cacheRoleMilitaryDetails2.put(roleMilitaryList.get(i).getId(), roleMilitaryList.get(i));
			}
			GlobalDatat.cacheRoleMilitaryDetails.put(roleMilitaryList.get(i).getId(), roleMilitaryList.get(i));
			if(GlobalDatat.cacheForRoleMilitary.containsKey(roleMilitaryList.get(i).getRoleId())){
				GlobalDatat.cacheForRoleMilitary.get(roleMilitaryList.get(i).getRoleId())
				.add(roleMilitaryList.get(i).getId());
			}else{
				mapForRoleMilitary = new ArrayList<Integer>();
				mapForRoleMilitary.add(roleMilitaryList.get(i).getId());
				GlobalDatat.cacheForRoleMilitary.put(roleMilitaryList.get(i).getRoleId(), mapForRoleMilitary);
			}
		}
		GameConstants.log.warn("roleMilitaryList:	" + GlobalDatat.cacheRoleMilitaryDetails.size());
		GameConstants.log.warn("cacheForRoleMilitary:	" + GlobalDatat.cacheForRoleMilitary.size());
		read("roleMilitary");
		
		List<StatetostateDetail> statetostateList = this.getStatetostateService().findAllStatetostate1();
		GlobalDatat.cacheForStatetostate.clear();
		Map<Integer, List<Integer>> mapForStatetostate = null;
		List<Integer> listForStatetostate1 = null;
		List<Integer> listForStatetostate2 = null;		
		for(int i = 0; i < statetostateList.size(); i++){
			GlobalDatat.cacheStatetostateDetails.put(statetostateList.get(i).getId(), statetostateList.get(i));
			if(GlobalDatat.cacheForStatetostate.containsKey(statetostateList.get(i).getReceiver())){
				if(statetostateList.get(i).getType() == 1 || statetostateList.get(i).getType() == 2){
					if(GlobalDatat.cacheForStatetostate.get(statetostateList.get(i).getReceiver()).get(statetostateList.get(i).getType()).size() < 30){
						GlobalDatat.cacheForStatetostate.get(statetostateList.get(i).getReceiver()).get(statetostateList.get(i).getType()).add(statetostateList.get(i).getId());
					}
				}else{
					GameConstants.log.warn("init statetostate haven an wrong data: id:" + statetostateList.get(i).getId() + "  type:" + statetostateList.get(i).getType());
				}
			}else{
				mapForStatetostate = new HashMap<Integer, List<Integer>>();
				listForStatetostate1 = new ArrayList<Integer>();
				listForStatetostate2 = new ArrayList<Integer>();
				mapForStatetostate.put(1, listForStatetostate1);
				mapForStatetostate.put(2, listForStatetostate2);
				if(statetostateList.get(i).getType() == 1 || statetostateList.get(i).getType() == 2){
					mapForStatetostate.get(statetostateList.get(i).getType()).add(statetostateList.get(i).getId());
				}else{
					GameConstants.log.warn("init statetostate haven an wrong data: id:" + statetostateList.get(i).getId() + "  type:" + statetostateList.get(i).getType());
				}
				GlobalDatat.cacheForStatetostate.put(statetostateList.get(i).getReceiver(), mapForStatetostate);
			}
		}
		GameConstants.log.warn("statetostateList1:	" + GlobalDatat.cacheStatetostateDetails.size());// + "GlobalDatat.cacheStatetostateDetails text:" + GlobalDatat.cacheStatetostateDetails.toString());
		GameConstants.log.warn("cacheForStatetostate1:	" + GlobalDatat.cacheForStatetostate.size());// + GlobalDatat.cacheForStatetostate.toString());	
		
		List<StatetostateDetail>  statetostateList2 = this.getStatetostateService().findAllStatetostate2();
		GlobalDatat.cacheForStatetostate2.clear();
		Map<Integer, List<Integer>> mapForStatetostate2 = null;
		List<Integer> listForStatetostate12 = null;
		List<Integer> listForStatetostate22 = null;		
		for(int i = 0; i < statetostateList2.size(); i++){
			GlobalDatat.cacheStatetostateDetails2.put(statetostateList2.get(i).getId(), statetostateList2.get(i));
			if(GlobalDatat.cacheForStatetostate2.containsKey(statetostateList2.get(i).getReceiver())){
				if(statetostateList2.get(i).getType() == 1 || statetostateList2.get(i).getType() == 2){
					GlobalDatat.cacheForStatetostate2.get(statetostateList2.get(i).getReceiver()).get(statetostateList2.get(i).getType()).add(statetostateList2.get(i).getId());
				}else{
					GameConstants.log.warn("init statetostate haven an wrong data: id:" + statetostateList2.get(i).getId() + "  type:" + statetostateList2.get(i).getType());
				}
			}else{
				mapForStatetostate2 = new HashMap<Integer, List<Integer>>();
				listForStatetostate12 = new ArrayList<Integer>();
				listForStatetostate22 = new ArrayList<Integer>();
				mapForStatetostate2.put(1, listForStatetostate12);
				mapForStatetostate2.put(2, listForStatetostate22);
				if(statetostateList2.get(i).getType() == 1 || statetostateList2.get(i).getType() == 2){
					mapForStatetostate2.get(statetostateList2.get(i).getType()).add(statetostateList2.get(i).getId());
				}else{
					GameConstants.log.warn("init statetostate haven an wrong data: id:" + statetostateList2.get(i).getId() + "  type:" + statetostateList2.get(i).getType());
				}
				GlobalDatat.cacheForStatetostate2.put(statetostateList2.get(i).getReceiver(), mapForStatetostate2);
			}
		}
		GameConstants.log.warn("statetostateList2:	" + GlobalDatat.cacheStatetostateDetails2.size());// + "GlobalDatat.cacheStatetostateDetails2 text:" + GlobalDatat.cacheStatetostateDetails2.toString());
		GameConstants.log.warn("cacheForStatetostate2:	" + GlobalDatat.cacheForStatetostate2.size());// + GlobalDatat.cacheForStatetostate2.toString());	
		
		save("roleQuicktime");
		List<RoleQuicktimeDetail> roleQuicktimeList = this.getRoleQuicktimeService().findAllRolequicktime();
		for(int i = 0; i < roleQuicktimeList.size(); i++){
			GlobalDatat.cacheRoleQuicktimeDetails.put(roleQuicktimeList.get(i).getRoleid(), roleQuicktimeList.get(i));
		}
		GameConstants.log.warn("roleQuicktimeList:	" + GlobalDatat.cacheRoleQuicktimeDetails.size());
		read("roleQuicktime");
	
		save("roleTask");
		List<RoleTaskDetail> roleTaskList = this.getRoleTaskService().findAllRoleTask();
		for(int i = 0; i < roleTaskList.size(); i++){
			//key:roleid value:roleTask
			GlobalDatat.cacheRoleTaskDetails.put(roleTaskList.get(i).getRoleId(), roleTaskList.get(i));
		}
		GameConstants.log.warn("roleTaskList:		" + GlobalDatat.cacheRoleTaskDetails.size());
		read("roleTask");
	
		save("roleTaskTask");
		List<RoleTaskTaskDetail> roleTaskTaskList = this.getRoleTaskTaskService().findAllRoleTaskTask();
		HashMap<Integer, Integer> mapForRoleTaskTask = null;
		GlobalDatat.cacheForRoleTaskTask.clear();
		for(int i = 0; i < roleTaskTaskList.size(); i++){
			GlobalDatat.cacheRoleTaskTaskDetails.put(roleTaskTaskList.get(i).getId(), roleTaskTaskList.get(i));
			if(GlobalDatat.cacheForRoleTaskTask.containsKey(roleTaskTaskList.get(i).getRoleId())){
				GlobalDatat.cacheForRoleTaskTask.get(roleTaskTaskList.get(i).getRoleId())
				.put(roleTaskTaskList.get(i).getTaskid(), roleTaskTaskList.get(i).getId());
			}else{
				mapForRoleTaskTask = new HashMap<Integer, Integer>();
				mapForRoleTaskTask.put(roleTaskTaskList.get(i).getTaskid(), roleTaskTaskList.get(i).getId());
				GlobalDatat.cacheForRoleTaskTask.put(roleTaskTaskList.get(i).getRoleId(), mapForRoleTaskTask);
			}
		}
		GameConstants.log.warn("roleTaskTaskList:	" + GlobalDatat.cacheRoleTaskTaskDetails.size());
		GameConstants.log.warn("cacheForRoleTaskTask:" + GlobalDatat.cacheForRoleTaskTask.size());
		read("roleTaskTask");
	
		save("roleTarven");
		List<RoleTavernDetail> roleTavernList = this.getRoleTavernService().findAllRoleTavern();
		for(int i = 0; i < roleTavernList.size(); i++){
			//key:roleid value:roleTavernDetail
			GlobalDatat.cacheRoleTavernDetails.put(roleTavernList.get(i).getRoleId(), roleTavernList.get(i));
		}
		GameConstants.log.warn("roleTavernList:		" + GlobalDatat.cacheRoleTavernDetails.size());
		read("roleTarven");
	
		save("roletotem");
		List<RoletotemDetail> roletotemList = this.getRoletotemService().getallroletotem();
		for(int i = 0; i < roletotemList.size(); i++){
			GlobalDatat.cacheRoletotemDetails.put(roletotemList.get(i).getId(), roletotemList.get(i));
		}
		GameConstants.log.warn("roletotemList:		" + GlobalDatat.cacheRoletotemDetails.size());
		read("roletotem");
	
		List<ServerDetail> serverList = this.getServerService().getAllServer();
		for(int i = 0; i < serverList.size(); i++){
			GlobalDatat.cacheServerDetails.put(serverList.get(i).getId(), serverList.get(i));
		}
		GameConstants.log.warn("serverList:		" + GlobalDatat.cacheServerDetails.size());
	
		List<TempPackageDetail> tempPackageList = this.getTempPackageService().findAllTempPackage();
		for(int i=0;i<tempPackageList.size();i++){
			GlobalDatat.cacheTempPackageDetails.put(tempPackageList.get(i).getId(), tempPackageList.get(i));
		}
		//GameConstants.log.warn("GlobalDatat.cacheTempPackageDetails.size"+GlobalDatat.cacheTempPackageDetails.size());
	
	
		Map<String, Object> param = new HashMap<String, Object>();
		List<ShopdiscountDetail> li=getShopdiscountService().getShopdiscounttwo(param);
		if(!li.isEmpty())
			GlobalDatat.cacheShopdiscountDetails.put(li.get(0).getId(), li.get(0));
	
		List<GameYellowVipDetail> gyv=getGameYellowVipService().findAllYellowVip();
		for(int i=0;i<gyv.size();i++){
			GlobalDatat.cacheGameYellowVipDetails.put(gyv.get(i).getId(), gyv.get(i));
		}
		GameConstants.log.warn("The system is self-test------");
		for(int i = 0; i < roleEquipList.size(); i++){
			try{
				if(null != roleEquipList.get(i)){
					if(!roleEquipList.get(i).getUser().equals("0") && GlobalDatat.cacheForRoleMilitary.containsKey(roleEquipList.get(i).getRoleId())){
						if(GlobalDatat.cacheForRoleMilitary.get(roleEquipList.get(i).getRoleId()).contains(Integer.valueOf(roleEquipList.get(i).getUser()))){
							//GameConstants.log.warn("roleid:" + roleEquipList.get(i).getRoleId() + " contains military:" + roleEquipList.get(i).getUser());

							if(roleEquipList.get(i).getType() == 1){
								if(GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).getWuqi() != roleEquipList.get(i).getId()){
									GameConstants.log.warn("User's General's data is exist exception! user:" + roleEquipList.get(i).getRoleId() + "		equipid:" + roleEquipList.get(i).getEquipId() + "		index:" + roleEquipList.get(i).getId() + "	roleMilitary(" + roleEquipList.get(i).getUser() + ") update xiezi");
									if(!"0".equals(String.valueOf(GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).getWuqi()))){
										GameConstants.log.warn("There are two same kind of equips(Wuqi) on this military(" + roleEquipList.get(i).getUser() + ") .they are :" + GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).getWuqi() + " and " + roleEquipList.get(i).getId());
										roleEquipList.get(i).setUser("0");
										this.getRoleEquipService().updateRoleEquips(roleEquipList.get(i));
									}else{
										GameConstants.log.warn("reset equips(Wuqi) on this military(" + roleEquipList.get(i).getUser() + ") .they are :" + GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).getWuqi() + " and " + roleEquipList.get(i).getId());
										GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).setWuqi(roleEquipList.get(i).getId());
										this.getRoleMilitaryService().updateRoleMilitary(GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())));
									}
								}
							}else if(roleEquipList.get(i).getType() == 2){
								if(GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).getYifu() != roleEquipList.get(i).getId()){
									GameConstants.log.warn("User's General's data is exist exception! user:" + roleEquipList.get(i).getRoleId() + "		equipid:" + roleEquipList.get(i).getEquipId() + "		index:" + roleEquipList.get(i).getId() + "	roleMilitary(" + roleEquipList.get(i).getUser() + ") update xiezi");
									if(!"0".equals(String.valueOf(GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).getYifu()))){
										GameConstants.log.warn("There are two same kind(Yifu) of equips on this military(" + roleEquipList.get(i).getUser() + ") .they are :" + GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).getYifu() + " and " + roleEquipList.get(i).getId());
										roleEquipList.get(i).setUser("0");
										this.getRoleEquipService().updateRoleEquips(roleEquipList.get(i));
									}else{
										GameConstants.log.warn("reset equips(Yifu) on this military(" + roleEquipList.get(i).getUser() + ") .they are :" + GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).getWuqi() + " and " + roleEquipList.get(i).getId());

										GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).setYifu(roleEquipList.get(i).getId());
										this.getRoleMilitaryService().updateRoleMilitary(GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())));
									}
								}
							}else if(roleEquipList.get(i).getType() == 3){
								if(GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).getHuwan() != roleEquipList.get(i).getId()){
									GameConstants.log.warn("User's General's data is exist exception! user:" + roleEquipList.get(i).getRoleId() + "		equipid:" + roleEquipList.get(i).getEquipId() + "		index:" + roleEquipList.get(i).getId() + "	roleMilitary(" + roleEquipList.get(i).getUser() + ") update xiezi");
									if(!"0".equals(String.valueOf(GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).getHuwan()))){
										GameConstants.log.warn("There are two same kind of equips(Huwan) on this military(" + roleEquipList.get(i).getUser() + ") .they are :" + GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).getHuwan() + " and " + roleEquipList.get(i).getId());
										roleEquipList.get(i).setUser("0");
										this.getRoleEquipService().updateRoleEquips(roleEquipList.get(i));
									}else{
										GameConstants.log.warn("reset equips(Huwan) on this military(" + roleEquipList.get(i).getUser() + ") .they are :" + GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).getWuqi() + " and " + roleEquipList.get(i).getId());

										GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).setHuwan(roleEquipList.get(i).getId());
										this.getRoleMilitaryService().updateRoleMilitary(GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())));
									}
								}
							}else if(roleEquipList.get(i).getType() == 4){
								if(GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).getXiezi() != roleEquipList.get(i).getId()){
									GameConstants.log.warn("User's General's data is exist exception! user:" + roleEquipList.get(i).getRoleId() + "		equipid:" + roleEquipList.get(i).getEquipId() + "		index:" + roleEquipList.get(i).getId() + "	roleMilitary(" + roleEquipList.get(i).getUser() + ") update xiezi");
									if(!"0".equals(String.valueOf(GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).getXiezi()))){
										GameConstants.log.warn("There are two same kind of equips(Xiezi) on this military(" + roleEquipList.get(i).getUser() + ") .they are :" + GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).getXiezi() + " and " + roleEquipList.get(i).getId());
										roleEquipList.get(i).setUser("0");
										this.getRoleEquipService().updateRoleEquips(roleEquipList.get(i));
									}else{
										GameConstants.log.warn("reset equips(Xiezi) on this military(" + roleEquipList.get(i).getUser() + ") .they are :" + GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).getWuqi() + " and " + roleEquipList.get(i).getId());

										GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).setXiezi(roleEquipList.get(i).getId());
										this.getRoleMilitaryService().updateRoleMilitary(GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())));
									}
								}
							}else if(roleEquipList.get(i).getType() == 5){
								if(GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).getTouguan() != roleEquipList.get(i).getId()){
									GameConstants.log.warn("User's General's data is exist exception! user:" + roleEquipList.get(i).getRoleId() + "		equipid:" + roleEquipList.get(i).getEquipId() + "		index:" + roleEquipList.get(i).getId() + "	roleMilitary(" + roleEquipList.get(i).getUser() + ") update xiezi");
									if(!"0".equals(String.valueOf(GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).getTouguan()))){
										GameConstants.log.warn("There are two same kind of equips(Touguan) on this military(" + roleEquipList.get(i).getUser() + ") .they are :" + GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).getTouguan() + " and " + roleEquipList.get(i).getId());
										roleEquipList.get(i).setUser("0");
										this.getRoleEquipService().updateRoleEquips(roleEquipList.get(i));
									}else{
										GameConstants.log.warn("reset equips(Touguan) on this military(" + roleEquipList.get(i).getUser() + ") .they are :" + GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).getWuqi() + " and " + roleEquipList.get(i).getId());

										GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).setTouguan(roleEquipList.get(i).getId());
										this.getRoleMilitaryService().updateRoleMilitary(GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())));
									}
								}
							}else if(roleEquipList.get(i).getType() == 6){
								if(GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).getShipin() != roleEquipList.get(i).getId()){
									GameConstants.log.warn("User's General's data is exist exception! user:" + roleEquipList.get(i).getRoleId() + "		equipid:" + roleEquipList.get(i).getEquipId() + "		index:" + roleEquipList.get(i).getId() + "	roleMilitary(" + roleEquipList.get(i).getUser() + ") update xiezi");
									if(!"0".equals(String.valueOf(GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).getShipin()))){
										GameConstants.log.warn("There are two same kind of equips(Shipin) on this military(" + roleEquipList.get(i).getUser() + ") .they are :" + GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).getShipin() + " and " + roleEquipList.get(i).getId());
										roleEquipList.get(i).setUser("0");
										this.getRoleEquipService().updateRoleEquips(roleEquipList.get(i));
									}else{
										GameConstants.log.warn("reset equips(Shipin) on this military(" + roleEquipList.get(i).getUser() + ") .they are :" + GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).getWuqi() + " and " + roleEquipList.get(i).getId());

										GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).setShipin(roleEquipList.get(i).getId());
										this.getRoleMilitaryService().updateRoleMilitary(GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())));
									}
								}
							}
						}else{
							if(GlobalDatat.cacheRoleMilitaryDetails.containsKey((Integer.valueOf(roleEquipList.get(i).getUser()))))
							GameConstants.log.warn("The user(" + roleEquipList.get(i).getRoleId() + ") don't have this general!  militaryid:" + roleEquipList.get(i).getUser() + "  this general is belong to The user(id):" + GlobalDatat.cacheRoleMilitaryDetails.get(Integer.valueOf(roleEquipList.get(i).getUser())).getRoleId() + "roleEquip set user = 0");
							roleEquipList.get(i).setUser("0");
							this.getRoleEquipService().updateRoleEquips(roleEquipList.get(i));
						}
					}
				}else{
					GameConstants.log.warn("when i = " + i + ", the roleEquip is null!");
				}
				
			}catch(Exception e){
				GameConstants.log.warn("i:" + i + " roleEquips index:" + roleEquipList.get(i).getId() + " equip userid:" + roleEquipList.get(i).getUser());
				e.printStackTrace();
			}
		}
		GameConstants.log.warn("The system's self-test is complete!");
	}
	
	private void addChanllenge(GameRoleDetail g) {
		// TODO Auto-generated method stub
		if(!"null".equals(g.getServerId().toString())){
			int serverid = Integer.valueOf(g.getServerId());
			if(GlobalDatat.challenge.containsKey(serverid)){
				
				List<Integer> list = getKey(g.getLevel());
				if(list.size() == 0){
					//不写入缓存
				}else if(list.size() == 1){
					int mKey = list.get(0);
					int nmKey = Integer.valueOf(mKey + "" + mKey);
					insertCache(mKey, nmKey, list, g);
				}else if(list.size() == 2){
					if(GlobalDatat.challenge.get(serverid).containsKey(list.get(0)) &&
						(GlobalDatat.challenge.get(serverid).get(list.get(0)).size() >= 50)){
						int mKey = list.get(1);
						int nmKey = Integer.valueOf(mKey + "" + mKey);
						insertCache(mKey, nmKey, list, g);
					}else{
						int mKey = list.get(0);
						int nmKey = Integer.valueOf(mKey + "" + mKey);
						insertCache(mKey, nmKey, list, g);
					}
				}
			}else{
				Map<Integer, JSONArray> jsonMap = new HashMap<Integer, JSONArray>(); 
				GlobalDatat.challenge.put(serverid, jsonMap);
				List<Integer> list = getKey(g.getLevel());
				if(list.size() == 0){
					//不写入缓存
				}else if(list.size() == 1){
					int mKey = list.get(0);
					int nmKey = Integer.valueOf(mKey + "" + mKey);
					insertCache(mKey, nmKey, list, g);
				}else if(list.size() == 2){
					if(GlobalDatat.challenge.get(serverid).containsKey(list.get(0)) &&
						(GlobalDatat.challenge.get(serverid).get(list.get(0)).size() >= 50)){
						int mKey = list.get(1);
						int nmKey = Integer.valueOf(mKey + "" + mKey);
						insertCache(mKey, nmKey, list, g);
					}else{
						int mKey = list.get(0);
						int nmKey = Integer.valueOf(mKey + "" + mKey);
						insertCache(mKey, nmKey, list, g);
					}
				}
			}
		}
	}


	private void insertCache(int mKey, int nmKey, List<Integer> list, GameRoleDetail g) {
		try{
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> map = new HashMap<String, Object>();
			int serverid = Integer.valueOf(g.getServerId());
			if(GlobalDatat.challenge.get(serverid).containsKey(mKey)){
				if(GlobalDatat.challenge.get(serverid).get(mKey).size() <= 50){
					param.clear();
					map.clear();
					param.put("roleid", g.getId());
					RoleChallengeDetail ro = this.getRoleChallengeService().findRoleChallengeById(param).get(0);
					map.put("level", g.getLevel());
			    	int success = ro.getSuccess();
					int totals = ro.getTotals();
					if (totals == 0) {
						map.put("percent", 100);
					} else {
						map.put("percent", success * 100 / totals);
					}
					map.put("id", g.getId());// 人物id
					//添加黄钻信息
					JsonSerializer json = new JsonSerializer();
					if(!"null".equals(String.valueOf(g.getHuangzuaninfo()))){
						List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
						.deserialize(g.getHuangzuaninfo());
						int ret = Integer.parseInt(String.valueOf(roleinfo.get(0).get("ret")));
						if(ret==0){
							map.put("isyellowvip", roleinfo.get(0).get("is_yellow_vip"));
							map.put("yellowviplevel", roleinfo.get(0).get("yellow_vip_level"));
							map.put("isyellowyearsvip", roleinfo.get(0).get("is_yellow_year_vip"));
							map.put("url", roleinfo.get(0).get("figureurl"));
						}else{
							map.put("isyellowvip", 0);
							map.put("yellowviplevel", 0);
							map.put("isyellowyearsvip", 0);
							map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
						}
						roleinfo=null;
					}else{
						map.put("isyellowvip", 0);
						map.put("yellowviplevel", 0);
						map.put("isyellowyearsvip", 0);
						map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
					}
					map.put("name", g.getName());
					map.put("t", 1);
					boolean b = true;
					for(int h = 0; h < GlobalDatat.challenge.get(serverid).get(mKey).size(); h++){
						Map<String, Object> m = (Map<String, Object>) GlobalDatat.challenge.get(serverid).get(mKey).get(h);
						if(g.getId() == Integer.valueOf(String.valueOf(m.get("id")))){
							b = false;
							GameConstants.log.warn("避免了争霸战等级缓存数据出现一条重复数据。serverid:" + serverid + "  mkey:" + mKey + " roleid:" + g.getId());
							break;
						}
					}
					if(b){
						GlobalDatat.challenge.get(serverid).get(mKey).add(map);
						GlobalDatat.challenge.get(serverid).get(nmKey).add(g.getId());
					}
					ro=null;
				}
			}else{
				JSONArray json1 = new JSONArray();
				JSONArray json2 = new JSONArray();
				GlobalDatat.challenge.get(serverid).put(mKey, json1);
				GlobalDatat.challenge.get(serverid).put(nmKey, json2);
				//System.out.println("mkey:" + mKey + "  nmkey" + nmKey + "  rolid:" + g.getId() + "   serverid:" + serverid);

				param.clear();
				map.clear();
				param.put("roleid", g.getId());
				RoleChallengeDetail ro = this.getRoleChallengeService().findRoleChallengeById(param).get(0);
				map.put("level", g.getLevel());
		    	int success = ro.getSuccess();
				int totals = ro.getTotals();
				if (totals == 0) {
					map.put("percent", 100);
				} else {
					map.put("percent", success * 100 / totals);
				}
				map.put("id", g.getId());// 人物id
				//添加黄钻信息
				JsonSerializer json = new JsonSerializer();
				if(!"null".equals(String.valueOf(g.getHuangzuaninfo()))){
					List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
					.deserialize(g.getHuangzuaninfo());
					int ret = Integer.parseInt(String.valueOf(roleinfo.get(0).get("ret")));
					if(ret==0){
						map.put("isyellowvip", roleinfo.get(0).get("is_yellow_vip"));
						map.put("yellowviplevel", roleinfo.get(0).get("yellow_vip_level"));
						map.put("isyellowyearsvip", roleinfo.get(0).get("is_yellow_year_vip"));
						map.put("url", roleinfo.get(0).get("figureurl"));
					}else{
						map.put("isyellowvip", 0);
						map.put("yellowviplevel", 0);
						map.put("isyellowyearsvip", 0);
						map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
					}
					roleinfo=null;
				}else{
					map.put("isyellowvip", 0);
					map.put("yellowviplevel", 0);
					map.put("isyellowyearsvip", 0);
					map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
				}
				map.put("name", g.getName());
				map.put("t", 1);
				GlobalDatat.challenge.get(serverid).get(mKey).add(map);
				GlobalDatat.challenge.get(serverid).get(nmKey).add(g.getId());
				ro=null;
			}
		}catch(Exception e){
			GameConstants.log.warn("roleid:" + g.getId() + " is not exist in roleChallenge!");
		}
		
	}


	private List<Integer> getKey(int level) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		if(level < 10){
			
		}
		if(level >= 10 && level < 25){
			list.add(1);
		}
		if(level >= 15 && level < 35){
			list.add(2);		
		}
		if(level >= 25 && level < 45){
			list.add(3);
		}
		if(level >= 35 && level < 55){
			list.add(4);
		}
		if(level >= 45 && level < 65){
			list.add(5);
		}
		if(level >= 55 && level < 75){
			list.add(6);
		}
		if(level >= 65 && level < 80){
			list.add(7);
		}
//		if(level < 10){
//			
//		}
//		if(level >= 65 && level < 80){
//			list.add(7);
//		}
//		if(level >= 55 && level < 75){
//			list.add(6);		
//		}
//		if(level >= 45 && level < 65){
//			list.add(5);
//		}
//		if(level >= 35 && level < 55){
//			list.add(4);
//		}
//		if(level >= 25 && level < 45){
//			list.add(3);
//		}
//		if(level >= 15 && level < 35){
//			list.add(2);
//		}
//		if(level >= 10 && level < 25){
//			list.add(1);
//		}
		return list;
	}


	public static void regameCache(){
		//
		System.out.println("更新模型缓存执行：：：：：：");
//		ClrCache clr = new ClrCache();
//		clr.clrAllModel();
//		clr=null;
		
		GlobalData.cacheGameMap = null;
		GlobalData.cacheGameFTa = null;
		GlobalData.cacheGameMilitary = null;
		GlobalData.cacheMlevel = null;
		GlobalData.cacheGameFoe = null;
		GlobalData.cacheGameFoeskill = null;
		GlobalData.cacheGamepList = null;
		GlobalData.cacheModelItems = null;
		GlobalData.cacheGameEquip = null;
		GlobalData.cacheGameVip = null;
		GlobalData.cacheModelGamblingItemList = null;
		GlobalData.cacheGameEProperty = null;
		GlobalData.cacheGameEIns = null;
		GlobalData.cacheGameSkill = null;
		GlobalData.cacheGameBuff = null;
		GlobalData.cacheGameStar = null;
		GlobalData.cacheGameChLevel = null;
		GlobalData.cacheGameTask = null;
		GlobalData.cacheGameBing = null;
		GlobalData.cacheGameMission = null;
		GlobalData.cacheGameBmap=null;
		GlobalData.cacheGameBskill = null;
		GlobalData.cacheGameBbuff =null;
		
		List<GameBbuffDetail> gameBbuffList = getGameBbuffService().getGameBbuff();
		GlobalData.cacheGameBbuff =gameBbuffList;
		for(int i = 0; i < gameBbuffList.size(); i++){
			GlobalDatat.cacheGameBbuffDetails.put(gameBbuffList.get(i).getId(), gameBbuffList.get(i));
		}
		System.out.println("gameBbuffList:	" + GlobalDatat.cacheGameBbuffDetails.size());
		
		
		List<GameBskillDetail> gameBskillList = getGameBskillService().getGameBskill();
		GlobalData.cacheGameBskill =gameBskillList;
		for(int i = 0; i < gameBskillList.size(); i++){
			GlobalDatat.cacheGameBskillDetails.put(gameBskillList.get(i).getId(), gameBskillList.get(i));
		}
		System.out.println("gameBskillList:	" + GlobalDatat.cacheGameBskillDetails.size());
		
		
		List<GameBmapDetail> gameBmapList = getGameBmapService().getGameBmap();
		GlobalData.cacheGameBmap=gameBmapList;
		for(int i = 0; i < gameBmapList.size(); i++){
			GlobalDatat.cacheGameBmapDetails.put(gameBmapList.get(i).getId(), gameBmapList.get(i));
		}
		System.out.println("gameBmapList:	" + GlobalDatat.cacheGameBmapDetails.size());
		
		
		List<GameMissionDetail> gameMissionList =getGameMissionService().getGameMission();
		GlobalData.cacheGameMission =gameMissionList;
		for(int i = 0; i < gameMissionList.size(); i++){
			GlobalDatat.cacheGameMissionDetails.put(gameMissionList.get(i).getMapid(), gameMissionList.get(i));
		}
		System.out.println("gameMissionList:" + GlobalDatat.cacheGameMissionDetails.size());
	
		
		List<GameBingDetail> gameBingList =getGameBingService().getGameBing();
		GlobalData.cacheGameBing = gameBingList;
		for(int i = 0; i < gameBingList.size(); i++){
			GlobalDatat.cacheGameBingDetails.put(gameBingList.get(i).getId(), gameBingList.get(i));
		}
		System.out.println("gameBingList:	" + GlobalDatat.cacheGameBingDetails.size());
		
		
		List<GameTaskDetail> gameTaskList =getGameTaskService().findAllGameTask();
		GlobalData.cacheGameTask =gameTaskList;
		for(int i = 0; i < gameTaskList.size(); i++){
			GlobalDatat.cacheGameTaskDetails.put(gameTaskList.get(i).getId(), gameTaskList.get(i));
		}
		System.out.println("gameTaskList:" + GlobalDatat.cacheGameTaskDetails.size());
	
		
		List<GameChLevelDetail> gameChLevelList =getGameChLevelService().getGameChLevel();
		GlobalData.cacheGameChLevel =gameChLevelList;
		for(int i = 0; i < gameChLevelList.size(); i++){
			GlobalDatat.cacheGameChLevelDetails.put(gameChLevelList.get(i).getId(), gameChLevelList.get(i));
		}
		System.out.println("gameChLevelList:" + GlobalDatat.cacheGameChLevelDetails.size());
		
		
		List<GameStarDetail> gameStarList =getGameStarService().getallgamestar();
		GlobalData.cacheGameStar =gameStarList;
		for(int i = 0; i < gameStarList.size(); i++){
			GlobalDatat.cacheGameStarDetails.put(gameStarList.get(i).getId(), gameStarList.get(i));	
		}
		System.out.println("gameStarList:" + GlobalDatat.cacheGameStarDetails.size());
	
		
		List<GameBuffDetail> gameBuffList = getGameBuffService().getGameBuff();
		GlobalData.cacheGameBuff =gameBuffList;
		for(int i = 0; i < gameBuffList.size(); i++){
			GlobalDatat.cacheGameBuffDetails.put(gameBuffList.get(i).getId(), gameBuffList.get(i));
		}
		System.out.println("gameBuffList:	" + GlobalDatat.cacheGameBuffDetails.size());
		
		
		List<GameSkillDetail> gameSkillList =getGameSkillService().getGameSkill();
		GlobalData.cacheGameSkill =gameSkillList;
		for(int i = 0; i < gameSkillList.size(); i++){
			GlobalDatat.cacheGameSkillDetails.put(gameSkillList.get(i).getId(), gameSkillList.get(i));
		}
		System.out.println("gameSkillList:" + GlobalDatat.cacheGameSkillDetails.size());
	
		
		List<GameEInsDetail> gameEInsList =getGameEInsService().getGameEIns();
		GlobalData.cacheGameEIns =gameEInsList;
		for(int i = 0; i < gameEInsList.size(); i++){
			GlobalDatat.cacheGameEInsDetails.put(gameEInsList.get(i).getLevel(), gameEInsList.get(i));
		}
		System.out.println("gameEInsList:	" + GlobalDatat.cacheGameEInsDetails.size());
	
		
		List<GameEPropertyDetail> gameEPropertyList =getGameEPropertyService().getGameEProperty();
		GlobalData.cacheGameEProperty =gameEPropertyList;
		for(int i = 0; i < gameEPropertyList.size(); i++){
			GlobalDatat.cacheGameEPropertyDetails.put(gameEPropertyList.get(i).getId(), gameEPropertyList.get(i));
		}
		System.out.println("gameEPropertyList:" + GlobalDatat.cacheGameEPropertyDetails.size());
	
		
		List<GameVipDetail> gameVipList =getGameVipService().allGameVips();
		GlobalData.cacheGameVip = gameVipList;
		for(int i = 0; i < gameVipList.size(); i++){
			GlobalDatat.cacheGameVipDetails.put(gameVipList.get(i).getId(), gameVipList.get(i));
		}
		System.out.println("gameVipList:" + GlobalDatat.cacheGameVipDetails.size());
	
		
		List<GameEquipDetail> gameEquipList =getGameEquipService().getGameEquip();
		GlobalData.cacheGameEquip =gameEquipList;
		for(int i=0;i<gameEquipList.size();i++){
			GlobalDatat.cacheGameEquipDetails.put(gameEquipList.get(i).getId(), gameEquipList.get(i));
		}
		System.out.println("gameEquipList:	" + GlobalDatat.cacheGameEquipDetails.size());
	
		
		List<GameMapDetail> gameMapList =getGameMapService().getGameMap();
		GlobalData.cacheGameMap=gameMapList;
		for(int i = 0; i < gameMapList.size(); i++){
			GlobalDatat.cacheGameMapDetails.put(gameMapList.get(i).getId(), gameMapList.get(i));
		}
		System.out.println("gameMapList:	" + GlobalDatat.cacheGameMapDetails.size());
	
		List<GameTowerDetail> gameTowerList =getGameTowerService().getGameTower();
		for(int i = 0; i < gameTowerList.size(); i++){
			GlobalDatat.cacheGameTowerDetails.put(gameTowerList.get(i).getId(), gameTowerList.get(i));
		}
		System.out.println("gameTowerList:" + GlobalDatat.cacheGameTowerDetails.size());
		GlobalData.cacheGameFTa =gameTowerList;

		List<GameMilitaryDetail> gameMilitaryList =getGameMilitaryService().getGameMilitary();
		GlobalData.cacheGameMilitary=gameMilitaryList;
		for(int i = 0; i < gameMilitaryList.size(); i++){
			GlobalDatat.cacheGameMilitaryDetails.put(gameMilitaryList.get(i).getId(), gameMilitaryList.get(i));
		}
		System.out.println("gameMilitaryList:" + GlobalDatat.cacheGameMilitaryDetails.size());
	
		List<GameMLevelDetail> gameMLevelList =getGameMLevelService().getGameMLevel();
		GlobalData.cacheMlevel = gameMLevelList;
		for(int i = 0; i < gameMLevelList.size(); i++){
			GlobalDatat.cacheGameMLevelDetails.put(gameMLevelList.get(i).getId(), gameMLevelList.get(i));
		}
		System.out.println("gameMLevelList:" + GlobalDatat.cacheGameMLevelDetails.size());
	
		List<GameFoeDetail> gameFoeList = getGameFoeService().getGameFoe();
		GlobalData.cacheGameFoe = gameFoeList;
		for(int i = 0; i < gameFoeList.size(); i++){
			GlobalDatat.cacheGameFoeDetails.put(gameFoeList.get(i).getFoeid(), gameFoeList.get(i));
		}
		System.out.println("gameFoeList:	" + GlobalDatat.cacheGameFoeDetails.size());
		
		List<GameFoeskillDetail> gameFoeskillList = getGameFoeskillService().getGameFoeskill();
		GlobalData.cacheGameFoeskill = gameFoeskillList;
		for(int i = 0; i < gameFoeskillList.size(); i++){
			GlobalDatat.cacheGameFoeskillDetails.put(gameFoeskillList.get(i).getId(), gameFoeskillList.get(i));
		}
		System.out.println("gameFoeskillList:	" + GlobalDatat.cacheGameFoeskillDetails.size());
	

		List<GamePriceDetail> gamePriceList =getGamePriceService().getAllGamePrice();
		GlobalData.cacheGamepList = gamePriceList;
		for(int i = 0; i < gamePriceList.size(); i++){
			GlobalDatat.cacheGamePriceDetails.put(gamePriceList.get(i).getId(), gamePriceList.get(i));
		}
		System.out.println("gamePriceList:" + GlobalDatat.cacheGamePriceDetails.size());
	
		List<GameItemDetail> gameItemList =getGameItemService().getGameItem();
		GlobalData.cacheModelItems =gameItemList;
		for(int i = 0; i < gameItemList.size(); i++){
			GlobalDatat.cacheGameItemDetails.put(gameItemList.get(i).getId(), gameItemList.get(i));
		}
		System.out.println("gameItemList:	" + GlobalDatat.cacheGameItemDetails.size());
	       System.out.println("name::::::"+GlobalDatat.cacheGameItemDetails.get(1).getItemname());
		
		//    TODO   更新模型缓存
	       List<ActivityDetail> activityList = getActivityService().findAllActivity();
			Calendar calendar = Calendar.getInstance();
			int month0 = calendar.get(Calendar.MONTH) + 1;//当前月
			int day0 = calendar.get(Calendar.DAY_OF_MONTH);//当前天
			for(int i = 0; i < activityList.size(); i++){
				int serverid = activityList.get(i).getServerid();
				GlobalDatat.cacheActivities.put(activityList.get(i).getId(), activityList.get(i));
//				System.out.println("activityID:"+activityList.get(i).getId()+","+activityList.get(i).getDescription());
				if(activityList.get(i).getId() > 1000 && activityList.get(i).getFlag() == 1){//15天开服活动（4合1）
					int month = activityList.get(i).getMonth();
					int day = activityList.get(i).getDay();
					int monthend = activityList.get(i).getMonthend();
					int dayend = activityList.get(i).getDayend();
					if(month!=monthend){
						if(month0>=month && month0<=monthend){
							if(month0==month){
								if(day0>=day){
									JSONArray newServerData = new JSONArray();
									newServerData.add(activityList.get(i).getServerid());
									newServerData.add(month);
									newServerData.add(day);
									GlobalDatat.newServerDataMap.put(serverid, newServerData);
									GlobalDatat.newServerActivityDataMap.put(serverid,activityList.get(i));
									GameConstants.log.warn("newserverdata:	NO."+serverid+" new server is OK:" + newServerData);
								}
							}else if(month0==monthend){
								if(day0<=dayend){
									JSONArray newServerData = new JSONArray();
									newServerData.add(activityList.get(i).getServerid());
									newServerData.add(activityList.get(i).getMonth());
									newServerData.add(activityList.get(i).getDay());
									GlobalDatat.newServerDataMap.put(serverid, newServerData);
									GlobalDatat.newServerActivityDataMap.put(serverid,activityList.get(i));
									GameConstants.log.warn("newserverdata:	NO."+serverid+" new server is OK:" + newServerData);
								}
							}else if(month0!=month&&month0!=monthend){
								JSONArray newServerData = new JSONArray();
								newServerData.add(activityList.get(i).getServerid());
								newServerData.add(activityList.get(i).getMonth());
								newServerData.add(activityList.get(i).getDay());
								GlobalDatat.newServerDataMap.put(serverid, newServerData);
								GlobalDatat.newServerActivityDataMap.put(serverid,activityList.get(i));
								GameConstants.log.warn("newserverdata:	NO."+serverid+" new server is OK:" + newServerData);
							}
						}
					}
					if(month == monthend){
						if(day0>=day&&day0<=dayend){
							JSONArray newServerData = new JSONArray();
							newServerData.add(activityList.get(i).getServerid());
							newServerData.add(activityList.get(i).getMonth());
							newServerData.add(activityList.get(i).getDay());
							GlobalDatat.newServerDataMap.put(serverid, newServerData);
							GlobalDatat.newServerActivityDataMap.put(serverid,activityList.get(i));
							GameConstants.log.warn("newserverdata:	NO."+serverid+" new server is OK:" + newServerData);
						}
					}
				}
			}
//			int newserverdataMapSize = GlobalDatat.newserverdataMap.size();
			GameConstants.log.warn("activityList:		" + GlobalDatat.cacheActivities.size());
		/*******************************************************/
		List<CallGiftDetail> callGiftList = getCallgiftService().findAllCallGift();
		for(int i = 0; i < callGiftList.size(); i++){
			GlobalDatat.cacheCallGiftDetails.put(callGiftList.get(i).getId(), callGiftList.get(i));
		}
		System.out.println("callGiftList:	" + GlobalDatat.cacheCallGiftDetails.size());
		
		
//		List<DeliveryDetail> deliveryList = getDeliveryService().findAllDelivery();
//		for(int i = 0; i < deliveryList.size(); i++){
//			GlobalDatat.cacheDeliveryDetails.put(deliveryList.get(i).getOpenid(), deliveryList.get(i));
//		}
//		System.out.println("deliveryList:	" + GlobalDatat.cacheDeliveryDetails.size());
//		
//		List<GamblingItemDetail> gamblingItemList = getGamblingItemService().findAllGamblingItem();
//		for(int i = 0; i < gamblingItemList.size(); i++){
//			GlobalDatat.cacheGamblingItemDetails.put(gamblingItemList.get(i).getId(), gamblingItemList.get(i));
//		}
//		System.out.println("gamblingItemList:" + GlobalDatat.cacheGamblingItemDetails.size());
//		
		List<GameAvatarDetail> gameAvatarList = getGameAvatarService().findAllGameAvatar();
		for(int i = 0; i < gameAvatarList.size(); i++){
			GlobalDatat.cacheGameAvatarDetails.put(gameAvatarList.get(i).getId(), gameAvatarList.get(i));
		}
		System.out.println("gameAvatarList:	" + GlobalDatat.cacheGameAvatarDetails.size());
		
		List<GameLevelDetail> gameLevelList =getGameLevelService().findAllGameLevel();
		for(int i = 0; i < gameLevelList.size(); i++){
			//key:level value:gamelevel
			GlobalDatat.cacheGameLevelDetails.put(gameLevelList.get(i).getId(), gameLevelList.get(i));
		}
		System.out.println("gameLevelList:	" + GlobalDatat.cacheGameLevelDetails.size());
		
		List<GamePlatsDetail> gamePlatsList =getGamePlatsService().getGamePlats();
		for(int i = 0; i < gamePlatsList.size(); i++){
			GlobalDatat.cacheGamePlatsDetails.put(gamePlatsList.get(i).getIndex(), gamePlatsList.get(i));
		}
		System.out.println("gamePlatsList:" + GlobalDatat.cacheGamePlatsDetails.size());
	
		List<GameRobotDetail> gameRobotList =getGameRobotService().findAllGameRobot();
		for(int i = 0; i < gameRobotList.size(); i++){
			GlobalDatat.cacheGameRobotDetails.put(gameRobotList.get(i).getId(), gameRobotList.get(i));
		}
		System.out.println("gameRobotList:" + GlobalDatat.cacheGameRobotDetails.size());
	
		
	
		
		List<GametotemDetail> gametotemList =getGametotemService().getGametotem();
		for(int i = 0; i < gametotemList.size(); i++){
			GlobalDatat.cacheGametotemDetails.put(gametotemList.get(i).getId(), gametotemList.get(i));
		}
		System.out.println("gametotemList:" + GlobalDatat.cacheGametotemDetails.size());
	
		
		
		List<HostDetail> hostList =getHostService().findAllHost();
		for(int i = 0; i < hostList.size(); i++){
			GlobalDatat.cacheHostDetails.put(hostList.get(i).getId(), hostList.get(i));
		}
		
		
		Map<String, Object> param = new HashMap<String, Object>();
		//List<ShopdiscountDetail> li=getShopdiscountService().getShopdiscount(param);
		List<ShopdiscountDetail> li=getShopdiscountService().getShopdiscounttwo(param);
		GlobalDatat.cacheShopdiscountDetails.put(li.get(0).getId(), li.get(0));
	
		List<GameYellowVipDetail> gyv=getGameYellowVipService().findAllYellowVip();
		for(int i=0;i<gyv.size();i++){
			GlobalDatat.cacheGameYellowVipDetails.put(gyv.get(i).getId(), gyv.get(i));
		}
		XiulianHandler xiulians=new XiulianHandler();//更新用户排行榜
		xiulians.allModels();
		/*******************/
		GlobalDatat.allChongZhiMap.clear();
		GlobalDatat.allChongZhiPaiMingMap.clear();
		GlobalDatat.allFuBenMap.clear();
		GlobalDatat.allFuBenPaiMingMap.clear();
		GlobalDatat.allGuanKaMap.clear();
		GlobalDatat.allGuanKaPaiMingMap.clear();
		GlobalDatat.allZhengBaMap.clear();
		GlobalDatat.allZhengBaPaiMingMap.clear();
		xiulians.newServerActivity();
		/*******************/
	}
	public static int queueMax=0;
	public static void debugQueue(){
		queueMax = 0;
		GameConstants.log.warn("-------------------------------------------------------------------------");
		GameConstants.log.warn("online user number:" + playerSessions1.size());
		if(CacheActivity.activityQueue != null){
			GameConstants.log.warn("CacheActivity.Queue:" + CacheActivity.activityQueue.size());
			if(CacheActivity.activityQueue.size() > queueMax){
				queueMax = CacheActivity.activityQueue.size();
			}
		}
		if(CacheCoin.coinQueue != null){
			GameConstants.log.warn("CacheCoin.Queue:" + CacheCoin.coinQueue.size());
			if(CacheCoin.coinQueue.size() > queueMax){
				queueMax = CacheCoin.coinQueue.size();
			}
		}
		if(CacheDelivery.deliveryQueue != null){
			GameConstants.log.warn("CacheDelivery.Queue:" + CacheDelivery.deliveryQueue.size());
			if(CacheDelivery.deliveryQueue.size() > queueMax){
				queueMax =CacheDelivery.deliveryQueue.size();
			}
		}
		if(CacheGameRole.gameRoleQueue != null){
			GameConstants.log.warn("CacheGameRole.Queue:" + CacheGameRole.gameRoleQueue.size() + " indexMap:" + CacheGameRole.gameRoleQueue.indexMap.size());
			if(CacheGameRole.gameRoleQueue.indexMap.size() > queueMax){
				queueMax = CacheGameRole.gameRoleQueue.indexMap.size();
			}
		}
		if(CacheGameRole.gameRoleQueue_in != null){
			GameConstants.log.warn("CacheGameRole.Queue:" + CacheGameRole.gameRoleQueue_in.size());
			if(CacheGameRole.gameRoleQueue_in.size() > queueMax){
				queueMax = CacheGameRole.gameRoleQueue_in.size();
			}
		}
		if( CacheMember.memberQueue != null){
			GameConstants.log.warn("CacheMember.Queue:" + CacheMember.memberQueue.size());
			if(CacheMember.memberQueue.size() > queueMax){
				queueMax = CacheMember.memberQueue.size();
			}
		}
		if(CacheRoleAvatar.roleAvatarQueue != null){
			GameConstants.log.warn("CacheRoleAvatar.Queue:" + CacheRoleAvatar.roleAvatarQueue.size());
			if(CacheRoleAvatar.roleAvatarQueue.size() > queueMax){
				queueMax = CacheRoleAvatar.roleAvatarQueue.size();
			}
		}
		if(CacheRoleBing.roleBingQueue != null){
			GameConstants.log.warn("CacheRoleBing.Queue:" + CacheRoleBing.roleBingQueue.size());
			if( CacheRoleBing.roleBingQueue.size() > queueMax){
				queueMax =  CacheRoleBing.roleBingQueue.size();
			}
		}
		if(CacheRoleChallenge.roleChallengeQueue != null){
			GameConstants.log.warn("CacheRoleChallenge.Queue:" + CacheRoleChallenge.roleChallengeQueue.size());
			if(CacheRoleChallenge.roleChallengeQueue.size() > queueMax){
				queueMax = CacheRoleChallenge.roleChallengeQueue.size();
			}
		}
		if(CacheRoleDaytask.roleDaytaskQueue != null){
			GameConstants.log.warn("CacheRoleDaytask.Queue:" + CacheRoleDaytask.roleDaytaskQueue.size() + " indexMap:" + CacheRoleDaytask.roleDaytaskQueue.indexMap.size());
			if(CacheRoleDaytask.roleDaytaskQueue.indexMap.size() > queueMax){
				queueMax = CacheRoleDaytask.roleDaytaskQueue.indexMap.size();
			}	
		}
		if(CacheRoleEquip.roleEquipQueue != null){

			GameConstants.log.warn("CacheRoleEquip.Queue:" + CacheRoleEquip.roleEquipQueue.size() + " indexMap:" + CacheRoleEquip.roleEquipQueue.indexMap.size());
			if(CacheRoleEquip.roleEquipQueue.indexMap.size() > queueMax){
				queueMax = CacheRoleEquip.roleEquipQueue.indexMap.size();
			}
		}
		if(CacheRoleEquip.roleEquipQueue_in != null){

			GameConstants.log.warn("CacheRoleEquip.Queue_in:" + CacheRoleEquip.roleEquipQueue_in.size());
			if(CacheRoleEquip.roleEquipQueue_in.size() > queueMax){
				queueMax = CacheRoleEquip.roleEquipQueue_in.size();
			}
		}
		if(CacheRoleImpose.roleImposeQueue != null){

			GameConstants.log.warn("CacheRoleImpose.Queue:" + CacheRoleImpose.roleImposeQueue.size());
			if(CacheRoleImpose.roleImposeQueue.size() > queueMax){
				queueMax = CacheRoleImpose.roleImposeQueue.size();
			}
		}
		if(CacheRoleIns.roleInsQueue != null){

			GameConstants.log.warn("CacheRoleIns.Queue:" + CacheRoleIns.roleInsQueue.size());
			if(CacheRoleIns.roleInsQueue.size() > queueMax){
				queueMax = CacheRoleIns.roleInsQueue.size();
			}
		}
		if(CacheRoleItem.roleItemQueue != null){
			GameConstants.log.warn("CacheRoleItem.Queue:" + CacheRoleItem.roleItemQueue.size() + " indexMapl:" + CacheRoleItem.roleItemQueue.indexMapl.size());
			if(CacheRoleItem.roleItemQueue.indexMapl.size() > queueMax){
				queueMax = CacheRoleItem.roleItemQueue.indexMapl.size();
			}
		}
		if(CacheRoleItem.roleItemQueue_in != null){
			GameConstants.log.warn("CacheRoleItem.Queue_in:" + CacheRoleItem.roleItemQueue_in.size());
			if(CacheRoleItem.roleItemQueue_in.size() > queueMax){
				queueMax = CacheRoleItem.roleItemQueue_in.size();
			}
		}
		if(CacheRoleMap.roleMapQueue != null){
			GameConstants.log.warn("CacheRoleMap.Queue:" + CacheRoleMap.roleMapQueue.size());
			if(CacheRoleMap.roleMapQueue.size() > queueMax){
				queueMax = CacheRoleMap.roleMapQueue.size();
			}
		}
		if(CacheRoleMilitary.roleMilitaryQueue != null){
			GameConstants.log.warn("CacheRoleMilitary.Queue:" + CacheRoleMilitary.roleMilitaryQueue.size() + " indexMap:" + CacheRoleMilitary.roleMilitaryQueue.indexMap.size());
			if(CacheRoleMilitary.roleMilitaryQueue.size() > queueMax){
				queueMax = CacheRoleMilitary.roleMilitaryQueue.indexMap.size();
			}
		}
		if(CacheRoleMilitary.roleMilitaryQueue_in != null){
			GameConstants.log.warn("CacheRoleMilitary.Queue_in:" + CacheRoleMilitary.roleMilitaryQueue_in.size());
			if(CacheRoleMilitary.roleMilitaryQueue_in.size() > queueMax){
				queueMax = CacheRoleMilitary.roleMilitaryQueue_in.size();
			}
		}
		if(CacheRoleQuicktime.roleQuicktimeQueue != null){
			GameConstants.log.warn("CacheRoleQuicktime.Queue:" + CacheRoleQuicktime.roleQuicktimeQueue.size());
			if(CacheRoleQuicktime.roleQuicktimeQueue.size() > queueMax){
				queueMax = CacheRoleQuicktime.roleQuicktimeQueue.size();
			}
		}
		if(CacheRoleTarven.RoleTarvenQueue != null){
			GameConstants.log.warn("CacheRoleTarven.Queue:" + CacheRoleTarven.RoleTarvenQueue.size() + " indexMap:" + CacheRoleTarven.RoleTarvenQueue.indexMap.size());
			if(CacheRoleTarven.RoleTarvenQueue.indexMap.size() > queueMax){
				queueMax = CacheRoleTarven.RoleTarvenQueue.indexMap.size();
			}
		}
		if(CacheRoleTask.roleTaskQueue != null){
			GameConstants.log.warn("CacheRoleTask.Queue:" + CacheRoleTask.roleTaskQueue.size() + " indexMap:" + CacheRoleTask.roleTaskQueue.indexMap.size());
			if(CacheRoleTask.roleTaskQueue.indexMap.size() > queueMax){
				queueMax = CacheRoleTask.roleTaskQueue.indexMap.size();
			}
		}
		if(CacheRoleTaskTask.roleTaskTaskQueue != null){
			GameConstants.log.warn("CacheRoleTaskTask.Queue:" + CacheRoleTaskTask.roleTaskTaskQueue.size());
			if(CacheRoleTaskTask.roleTaskTaskQueue.size() > queueMax){
				queueMax = CacheRoleTaskTask.roleTaskTaskQueue.size();
			}
		}
		if(CacheRoletotme.gameRoletotmeQueue != null){
			GameConstants.log.warn("CacheRoletotme.Queue:" + CacheRoletotme.gameRoletotmeQueue.size());
			if(CacheRoletotme.gameRoletotmeQueue.size() > queueMax){
				queueMax = CacheRoletotme.gameRoletotmeQueue.size();
			}
		}
		if(SystemHandler.systemMessageQueue != null){
			GameConstants.log.warn("SystemHandler.messageQeue:" + SystemHandler.systemMessageQueue.size());
		}
		GameConstants.log.warn("-------------------------------------------------------------------------queueMax:" + queueMax);

	}
	public void messageSent(IoSession session, Object message) throws Exception {
		//System.out.println("后."+ new String((byte[]) message));
	}

	public void sessionCreated(IoSession session) throws Exception {
		// 会话创建
		//System.out.println("ServerHandler.sessionCreated:serverState:" + serverState);
		if(serverState == 1){
			SocketSessionConfig cfg = (SocketSessionConfig) session.getConfig();
			cfg.setKeepAlive(true);
			cfg.setSoLinger(0);
			cfg.setReaderIdleTime(60);
			cfg.setWriteTimeout(60);
			cfg.setTcpNoDelay(true);
			session.setAttribute("KeepALiveCount", 0);
			//GameConstants.log.warn("sessioncreated____________________________________");
			HashMap<String, Object> cachekeyMap = new HashMap<String, Object>(); /* 响应信息 */
			session.setAttribute("cachekeyMap", cachekeyMap);
			sessionCountAdd();
		}else{
			return;
		}
		
	}

	static int sessionCount = 0;

	private static synchronized void sessionCountAdd() {
		sessionCount++;
	}

	private static synchronized void sessionCountSub() {
		sessionCount--;
	}

	public void sessionOpened(NextFilter nextFilter, IoSession session)
			throws Exception {
	}

	/**
	 * @param session
	 *            {IoSession}
	 * @param cause
	 *            {Throwable}
	 * @introduction 打印异常的原因
	 */
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		
		GameConstants.log.warn("玩家" + session.getAttribute("roleId")
				+ "抛出异常,断开连接:", cause);
		session.close(true);
	}

	/**
	 * @method messageReceived
	 * @param session{IoSession}
	 * @param message{Object}
	 * @return
	 * @description 消息接收(根据接收到的消息进行处理,并返回信息)
	 */
	Feature[] features = { Feature.AutoCloseSource,
			Feature.AllowUnQuotedFieldNames,
			Feature.DisableCircularReferenceDetect };

	public void messageReceived(IoSession session, Object message)
			throws Exception {
		session.setAttribute("KeepALiveCount", 0);
		//HashMap<String, Object> cachekeyMap = new HashMap<String, Object>(); /* 响应信息 */
		//session.setAttribute("cachekeyMap", cachekeyMap);
		//GameConstants.log.warn("sessionRe:" + session.getAttribute("cachekeyMap"));
		HashMap<String, Object> cachekeyMap = (HashMap<String, Object>) session.getAttribute("cachekeyMap");
		if (message != null) {
			try {
				/* 客户端IP地址 */
				Map<String, Object> object = (Map<String, Object>) JSON.parse(
						(byte[]) message, features);
				//GameConstants.log.warn("ID:" +  + "messageReceived.sessionRe:object_________________________________________________________:" + object.toString());
				if (object.containsKey("_cmd") && object.containsKey("_guid")
						&& object.containsKey("_pid")
						&& object.containsKey("_sig")
						&& object.containsKey("_cachekey")
						&& object.containsKey("_params")) {
					/* 验证客户端相关信息是否合法 */
					Object _cmd = object.get("_cmd"); /* 接口名称 */
					Object _guid = object.get("_guid"); /* 全局唯一标识 */
					Object _pid = object.get("_pid"); /* 玩家ID */
					Object _sig = object.get("_sig"); /* 签名 */
					Object _cacheKey = object.get("_cachekey"); /* 缓存Key */
					Object _param = object.get("_params"); /* 参数 */
				//	GameConstants.log.warn("ID:" + Integer.valueOf(String.valueOf(_pid)) + "messageReceived.sessionRe:object_________________________________________________________:" + object.toString());
					
					
					cachekeyMap.put("time", object.get("_key2").toString());
//					System.out.println("_key2:time:" + object.get("_key2").toString());
					
					
					Object key = object.get("_key1");
//					System.out.println(key.toString());
					Object time = object.get("_key2");
//					System.out.println("请求次数：" + key.toString());
					Object shun = object.get("_key3");
//					System.out.println("shunxu:" + shun);
					String md51 = _cacheKey.toString();
//					System.out.println("@@@@" + key.toString() + time.toString() + shun.toString() + md51);
					String yz = _pid.toString() + key.toString() + time.toString();
					if(object.get("_key1").toString().equals("1")){
						cachekeyMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CACHEKEY + yz, yz);
					}
					//System.out.println("判断是否绿色通道：" + !object.containsKey("_key3tang"));
				if(!object.containsKey("_key3tang")){
					if(!object.get("_key1").toString().equals("1")){
					//添加更改
					if(cachekeyMap.containsValue(yz)){
						GameConstants.log.warn("受到WPE攻击！整体重复请求！强制关闭会话！(dumplic)");
						System.out.println(cachekeyMap.toString());
						System.out.println(yz);
						System.out.println("是否含：" + cachekeyMap.containsValue(yz));
						System.out.println("受到WPE攻击！整体重复请求！强制关闭会话！(dumplic)");
						session.close(true);
						return;
					}
					if(cachekeyMap.size() > 50){
						String timet = cachekeyMap.get("time").toString();
						cachekeyMap.clear();
						cachekeyMap.put("time", timet);
					}
					cachekeyMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CACHEKEY + yz, yz);
//					System.out.println("接收到请求：" + object);
//					System.out.println("cachekeyMap的值：" + cachekeyMap.toString());
					//时间判断
//					System.out.println("time:" + time.toString());
					int time1 = Integer.parseInt(time.toString());
//					System.out.println(cachekeyMap.get("time"));
					int time2 = Integer.parseInt(cachekeyMap.get("time").toString());
					if(time1 > time2){
						GameConstants.log.warn("受到WPE攻击！时间重复请求！强制关闭会话！(time)");
						System.out.println("受到WPE攻击！时间重复请求！强制关闭会话！(time)");
						session.close(true);
						return;
					}
					cachekeyMap.put("time", time);
					
//					System.out.println("玩家信息：" + session.getAttribute("roleId"));
//					System.out.println("_pid:" + _pid.toString());
					String rid1 =session.getAttribute("roleId").toString();
					String rid2 = _pid.toString();
					if(!rid1.equals(rid2)){
						GameConstants.log.warn("受到WPE攻击！玩家不匹配！强制关闭会话！(erro player)");
						System.out.println("受到WPE攻击！玩家不匹配！强制关闭会话！(erro player)");
						session.close(true);
						return;
					}
					String md52 = null;
					if(shun.equals("12")){
						md52 = "id" + _pid.toString() + "key" + key.toString() + "time" + time.toString() + session.getAttribute("iddd");
					}else if(shun.equals("13")){
						md52 = "id" + _pid.toString() + "time" + time.toString() + "key" + key.toString() + session.getAttribute("iddd");
					}else if(shun.equals("23")){
						md52 = "key" + key.toString() + "time" + time.toString() + "id" + _pid.toString() + session.getAttribute("iddd");
					}else if(shun.equals("21")){
						md52 = "key" + key.toString() + "id" + _pid.toString() + "time" + time.toString() + session.getAttribute("iddd");
					}else if(shun.equals("31")){
						md52 = "time" + time.toString() + "id" + _pid.toString() + "key" + key.toString() + session.getAttribute("iddd");
					}else if(shun.equals("32")){
						md52 = "time" + time.toString() + "key" + key.toString() + "id" + _pid.toString() + session.getAttribute("iddd");
					}
				//	System.out.println("session:iddd:" + session.getAttribute("iddd"));
//					System.out.println("md52:" + md52);
					String tmp = md52; // MD5加密
					StringBuffer hexString = new StringBuffer("");
					try {
						MessageDigest md = MessageDigest.getInstance("MD5");
						md.update(tmp.getBytes());
						byte[] hash = md.digest();

						for (int i = 0; i < hash.length; i++) {
							if ((0xff & hash[i]) < 0x10) {
								hexString.append("0"
										+ Integer.toHexString((0xFF & hash[i])));
							} else {
								hexString.append(Integer.toHexString(0xFF & hash[i]));
							}
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				//	System.out.println("md53:" + hexString.toString());
				//	System.out.println("md51:" + md51);
					if (hexString == null || !hexString.toString().equals(md51)) {
						System.out.println(hexString.toString());
						GameConstants.log.warn("受到WPE攻击！验证码错误！强制关闭会话！(erro md5)");
						System.out.println("受到WPE攻击！验证码错误！强制关闭会话！(erro md5)");
						session.close(true);
						return;
					}
				}	
			}	
					
					
					Map _params = (Map) _param;
					BaseHandler handler = null;
					String _cmdName = String.valueOf(_cmd);
					//System.out.println("_cmdName:" + _cmdName);
					//GameConstants.log.warn("_cmdName:" + _cmdName);
					if (_cmdName.startsWith("ply.")) {
						if (_cmdName.equals("ply.get")) {
							// ply.get 正式逻辑开始
							int pid = Integer.parseInt(String.valueOf(_pid));
							if (pid <= 0) {
								GameConstants.log.info("PID非数字或小于等于1");
								session.close(true);
								return;
							}
							GameRoleDetail roleDetail;
							
							if (!session.containsAttribute("roleDetail")) {
								roleDetail = this.getGameRoleService()
										.findRoleById(pid);
								if (roleDetail != null) {
									session.setAttribute("roleDetail",
											roleDetail);
								}
							} else {
								
								roleDetail = (GameRoleDetail) session
										.getAttribute("roleDetail");
								if (roleDetail.getId() != pid) {
									GameConstants.log.warn("sessionPid:"
											+ roleDetail.getId() + " messPid:"
											+ pid);
									session.removeAttribute("roleDetail");
									roleDetail = this.getGameRoleService()
											.findRoleById(pid);
									if (roleDetail != null) {
										session.setAttribute("roleDetail",
												roleDetail);
									}
								}
							}
							if (roleDetail != null) {
								IoSession oldSession = playerSessions1
										.get(roleDetail.getId());
								if (oldSession != null) {// T人
									
									/* 玩家已登录 */
									
									if (!oldSession.equals(session)) { /* 两次会话不一致 */
										
										if (_cmd.equals("ply.get")) {
											int a = -1;
											// 客户端主动断开连接
											if (a == -1) {
												Map<String, Object> _rlt = new HashMap<String, Object>();
												_rlt
														.put(
																GameConstants.GAME_API_RESPONSE_FIELD_CODE,
																141);
												_rlt
														.put(
																GameConstants.GAME_API_RESPONSE_FIELD_CMD,
																"sys.otherlogon");
												_rlt
														.put(
																GameConstants.GAME_API_RESPONSE_FIELD_GUID,
																"0");
												_rlt
														.put(
																GameConstants.GAME_API_RESPONSE_FIELD_CACHEKEY,
																"0");
												_rlt.put("_actpid", pid);
												_rlt.put("key_id", session.getAttribute("iddd"));
												_rlt.put("_params", "");
												sendData(oldSession, _rlt);
												_rlt = null;
												a = 0;
											}
											// 客户端主动断开连接
											if (a == 0) {
												oldSession.close(true);
												a = 1;
												GameConstants.log.warn("玩家"
														+ _pid + "从别处再次登录");
												int i = 0;
												while (i != 60) {// 等待把人T掉1分钟以上则问题很严重.
													i++;
													Thread.sleep(500);
													if (oldSession.isClosing()) {
														break;
													}
												}
												
												if (i == 60) {
													GameConstants.log
															.error("PlayerId:"
																	+ roleDetail
																			.getId()
																	+ ",Kick it failure!! oldSessionClose");
													oldSession.close(true);
													a = 1;
												}
												if (a == 1) {
													putPlayerSession(pid,
															session);
													handler = new PlayerHandler(
															_cmdName,
															String
																	.valueOf(_guid),
															String
																	.valueOf(_sig),
															String.valueOf(pid),
															String
																	.valueOf(_cacheKey),
															_params, session);
												}
											}
										} else {
											session.close(true);
											GameConstants.log
													.error("两次SESSION不一致且不是从PLY.GET开始，T掉新的，PlayerId:"
															+ roleDetail
																	.getId()
															+ "newIp:"
															+ session
																	.getRemoteAddress()
																	.toString()
															+ "oldIp"
															+ oldSession
																	.getRemoteAddress()
																	.toString());
										}
									} else {
										putPlayerSession(
												Integer.parseInt(String
														.valueOf(_pid)),
												session);
										handler = new PlayerHandler(_cmdName,
												String.valueOf(_guid), String
														.valueOf(_sig), String
														.valueOf(_pid), String
														.valueOf(_cacheKey),
												_params, session);
									}
								} else {
									
									putPlayerSession(Integer.parseInt(String
											.valueOf(_pid)), session);
									handler = new PlayerHandler(_cmdName,
											String.valueOf(_guid), String
													.valueOf(_sig), String
													.valueOf(_pid), String
													.valueOf(_cacheKey),
											_params, session);
								}
							} else {
								putPlayerSession(Integer.parseInt(String
										.valueOf(_pid)), session);
								handler = new PlayerHandler(_cmdName, String
										.valueOf(_guid), String.valueOf(_sig),
										String.valueOf(_pid), String
												.valueOf(_cacheKey), _params,
										session);
							}
							roleDetail = null;
						} else {
							putPlayerSession(Integer.parseInt(String
									.valueOf(_pid)), session);
							handler = new PlayerHandler(_cmdName, String
									.valueOf(_guid), String.valueOf(_sig),
									String.valueOf(_pid), String
											.valueOf(_cacheKey), _params,
									session);
						}
					} else if (_cmdName.startsWith("sys.")) {
						handler = new SystemHandler(_cmdName, String
								.valueOf(_guid), String.valueOf(_sig), String
								.valueOf(_pid), String.valueOf(_cacheKey),
								_params, session);
					} else if (_cmdName.startsWith("tower.")) {
						handler = new TowerHandler(_cmdName, String
								.valueOf(_guid), String.valueOf(_sig), String
								.valueOf(_pid), String.valueOf(_cacheKey),
								_params, session);
					} else if (_cmdName.startsWith("mil.")) {
						handler = new MilitartHandler(_cmdName, String
								.valueOf(_guid), String.valueOf(_sig), String
								.valueOf(_pid), String.valueOf(_cacheKey),
								_params, session);
					}else if (_cmdName.startsWith("xiu.")) {
						handler = new XiulianHandler(_cmdName, String
								.valueOf(_guid), String.valueOf(_sig), String
								.valueOf(_pid), String.valueOf(_cacheKey),
								_params, session);
					}else if (_cmdName.startsWith("open.")) {
						handler = new OpenHandler(_cmdName, String
								.valueOf(_guid), String.valueOf(_sig), String
								.valueOf(_pid), String.valueOf(_cacheKey),
								_params, session);
					}else if (_cmdName.startsWith("map.")) {
						handler = new MapHandler(_cmdName, String
								.valueOf(_guid), String.valueOf(_sig), String
								.valueOf(_pid), String.valueOf(_cacheKey),
								_params, session);
					}else if (_cmdName.startsWith("tas.")) {
						handler = new TaskHandler(_cmdName, String
								.valueOf(_guid), String.valueOf(_sig), String
								.valueOf(_pid), String.valueOf(_cacheKey),
								_params, session);

					}else if (_cmdName.startsWith("bing.")) {
						handler = new BingHandler(_cmdName, String
								.valueOf(_guid), String.valueOf(_sig), String
								.valueOf(_pid), String.valueOf(_cacheKey),
								_params, session);
					}else if (_cmdName.startsWith("match.")) {
						handler = new MatchHandler(_cmdName, String
								.valueOf(_guid), String.valueOf(_sig), String
								.valueOf(_pid), String.valueOf(_cacheKey),
								_params, session);
					}
					
					
				} else {
					
					GameConstants.log.warn("传入的参数不完整"
							+ session.getRemoteAddress().toString()+"object:"+object);
				}
			
			} catch (Exception e) {
				GameConstants.log.warn("发生异常的信息:" + message + "异常程序", e);
			}
		} else {
			GameConstants.log.error("messagereceive:message=null");
		}
	}
}
