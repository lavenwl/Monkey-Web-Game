package com.stang.game.server.handler;

import java.util.HashMap;
import java.util.Map;

import org.apache.mina.core.session.IoSession;

import com.stang.game.common.GameConstants;
import com.stang.game.service.IActivityService;
import com.stang.game.service.IAutoIdService;
import com.stang.game.service.IBaseService;
import com.stang.game.service.ICdkStoreService;
import com.stang.game.service.IDeliveryService;
import com.stang.game.service.IGameBmapService;
import com.stang.game.service.IGameBuffService;
import com.stang.game.service.IGameChartsService;
import com.stang.game.service.IGameItemService;
import com.stang.game.service.IGameMapService;
import com.stang.game.service.IGameMilitaryService;
import com.stang.game.service.IGameMissionService;
import com.stang.game.service.IGamePlatsService;
import com.stang.game.service.IGamePriceService;
import com.stang.game.service.IGameRoleService;
import com.stang.game.service.IGameSkillService;
import com.stang.game.service.IGameTaskService;
import com.stang.game.service.IHostService;
import com.stang.game.service.IMemberService;
import com.stang.game.service.IRoleBingService;
import com.stang.game.service.IRoleChallengeService;
import com.stang.game.service.IRoleTaskService;
import com.stang.game.service.IRoleTaskTaskService;
import com.stang.game.service.IServerService;
import com.stang.game.service.IStatetostateService;
import com.stang.game.service.impl.ActivityServiceImpl;
import com.stang.game.service.impl.AutoIdServiceImpl;
import com.stang.game.service.impl.CdkStoreServiceImpl;
import com.stang.game.service.impl.DeliveryServiceImpl;
import com.stang.game.service.impl.GameBmapServiceImpl;
import com.stang.game.service.impl.GameBuffServiceImpl;
import com.stang.game.service.impl.GameChartsServiceImpl;
import com.stang.game.service.impl.GameItemServiceImpl;
import com.stang.game.service.impl.GameMapServiceImpl;
import com.stang.game.service.impl.GameMilitaryServiceImpl;
import com.stang.game.service.impl.GameMissionServiceImpl;
import com.stang.game.service.impl.GamePlatsServiceImpl;
import com.stang.game.service.impl.GamePriceServiceImpl;
import com.stang.game.service.impl.GameRoleServiceImpl;
import com.stang.game.service.impl.GameSkillServiceImpl;
import com.stang.game.service.impl.GameTaskServiceImpl;
import com.stang.game.service.impl.HostServiceImpl;
import com.stang.game.service.impl.MemberServiceImpl;
import com.stang.game.service.impl.RoleBingServiceImpl;
import com.stang.game.service.impl.RoleChallengeServiceImpl;
import com.stang.game.service.impl.RoleTaskServiceImpl;
import com.stang.game.service.impl.RoleTaskTaskServiceImpl;
import com.stang.game.service.impl.ServerServiceImpl;
import com.stang.game.service.impl.StatetostateServiceImpl;

/**
 * @author wei
 * @company 上海三唐信息科技有限公司
 * @description 信息获取基础处理
 */
public abstract class BaseHandler {
	public int serverId;
	protected int currRoleId;
	protected IBaseService baseService;
	protected IoSession session; /* session */
	protected String gameApiName; /* 游戏接口名称 */
	protected String globalIdentifier; /* 全局ID */
	protected String encryptedSignature; /* 加密签名 */
	protected String playerId; /* 玩家序列号 */
	protected String cacheKey; /* 缓存Key */
	protected Map<String, Object> params; /* 参数信息 */
	protected HashMap<String, Object> respMap = new HashMap<String, Object>(); /* 响应信息 */
	
	protected IBaseService getBaseService() {
		return baseService;
	}
	
	
	private static IAutoIdService autoIdService;

	protected static IAutoIdService getAutoIdService() {
		if (autoIdService == null) {
			autoIdService = new AutoIdServiceImpl();
		}
		return autoIdService;
	}

	private static IGamePriceService gamePriceService;

	protected static IGamePriceService getGamePriceService() {
		if (gamePriceService == null) {
			gamePriceService = new GamePriceServiceImpl();
		}
		return gamePriceService;
	}

	private static IGameRoleService gameRoleService;

	protected static IGameRoleService getGameRoleService() {
		if (gameRoleService == null) {
			gameRoleService = new GameRoleServiceImpl();
		}
		return gameRoleService;
	}
	
	private static ICdkStoreService cdkStoreService;

	protected static ICdkStoreService getCdkStoreService() {
		if (cdkStoreService == null) {
			cdkStoreService =  new CdkStoreServiceImpl();
		}
		return cdkStoreService;
	}
	
	private static IGameItemService gameItemService;

	protected static IGameItemService getGameItemService() {
		if (gameItemService == null) {
			gameItemService = new GameItemServiceImpl();
		}
		return gameItemService;
	}
	
	private static IStatetostateService StatetostateService;

	protected static IStatetostateService getStatetostateService() {
		if (StatetostateService == null) {
			StatetostateService = new StatetostateServiceImpl();
		}
		return StatetostateService;
	}

	private static IGameMilitaryService gameMilitaryService;

	protected static IGameMilitaryService getGameMilitaryService() {
		if (gameMilitaryService == null) {
			gameMilitaryService = new GameMilitaryServiceImpl();
		}
		return gameMilitaryService;
	}
	private static IRoleTaskTaskService roleTaskTask;
	protected IRoleTaskTaskService getRoleTaskTaskService() {
		if (roleTaskTask == null) {
			roleTaskTask = new RoleTaskTaskServiceImpl();
		}
		return roleTaskTask;
	}
	final static HashMap<Object, Object> defaultInfo = new HashMap<Object, Object>();
public BaseHandler(){}
	public BaseHandler(String gameApiName, String globalIdentifier,
			String encryptedSignature, String playerId, String cacheKey,
			Map params, IoSession session) {
		this.gameApiName = gameApiName;
		this.globalIdentifier = globalIdentifier;
		this.encryptedSignature = encryptedSignature;
		this.playerId = playerId;
		this.currRoleId = Integer.parseInt(playerId);
		this.cacheKey = cacheKey;
		this.params = params;
		this.session = session;
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_ACTPID, playerId);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD, gameApiName);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_GUID,
				globalIdentifier);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CACHEKEY, cacheKey);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, defaultInfo);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
	}

	/**
	 * @method getRespMap
	 * @return {HashMap}
	 * @description 得到响应信息
	 */
	public HashMap<String, Object> getRespMap() {
		if (respMap == null)
			return null;
		respMap.put("_actpid", playerId); /* 主动请求信息的玩家序号 */
		respMap.put("_cachekey", cacheKey); /* 缓存Key */
		return this.respMap;
	}
	//增加gametask配置
	private static IGameTaskService GameTaskService;

	protected static IGameTaskService getGameTaskService() {
		if (GameTaskService == null) {
			GameTaskService = new GameTaskServiceImpl();
		}
		return GameTaskService;
	}
	
	//增加roletask配置
	private static IRoleTaskService RoleTaskService;

	protected static IRoleTaskService getRoleTaskService() {
		if (RoleTaskService == null) {
			RoleTaskService = new RoleTaskServiceImpl();
		}
		return RoleTaskService;
	}
	
	private static IGameMapService GameMapService;

	protected static IGameMapService getGameMapService() {
		if (GameMapService == null) {
			GameMapService = new GameMapServiceImpl();
		}
		return GameMapService;
	}
	
	private static IGamePlatsService GamePlatsService;

	protected static IGamePlatsService getGamePlatsService() {
		if (GamePlatsService == null) {
			GamePlatsService = new GamePlatsServiceImpl();
		}
		return GamePlatsService;
	}
	
private static IRoleChallengeService roleChallengeService;
	
	protected IRoleChallengeService getRoleChallengeService(){
		if(roleChallengeService == null){
			roleChallengeService = new RoleChallengeServiceImpl();
		}
		return roleChallengeService;
	}
	
private static IMemberService memberService;
	
	protected IMemberService getMemberService(){
		if(memberService == null){
			memberService = new MemberServiceImpl();
		}
		return memberService;
	}
	
private static IDeliveryService deliveryService;
	
	protected IDeliveryService getDeliveryService(){
		if(deliveryService == null){
			deliveryService = new DeliveryServiceImpl();
		}
		return deliveryService;
	}
	
private static IGameChartsService gameChartsService;
	
	protected IGameChartsService getGameChartsService(){
		if(gameChartsService == null){
			gameChartsService = new GameChartsServiceImpl();
		}
		return gameChartsService;
	}
	
private static IHostService HostService;
	
	protected IHostService getHostService(){
		if(HostService == null){
			HostService = new HostServiceImpl();
		}
		return HostService;
	}

private static IServerService ServerService;
private IServerService getServerService(){
	if(ServerService ==null){
		ServerService = new ServerServiceImpl();
	}
	return ServerService;
}
	
private static IRoleBingService roleBing;
	protected IRoleBingService getRoleBingService(){
		if(roleBing==null){
			roleBing = new RoleBingServiceImpl();
		}
		return roleBing;
	}
	
	private static IGameMissionService gameMission;
	protected IGameMissionService getGameMissionService(){
		if(gameMission==null){
			gameMission = new GameMissionServiceImpl();
		}
		return gameMission;
	}
	private static IGameSkillService gameSkill;
	protected IGameSkillService getGameSkillService(){
		if(gameSkill==null){
			gameSkill = new GameSkillServiceImpl();
		}
		return gameSkill;
	}
	
	private static IGameBuffService gameBuff;
	protected IGameBuffService getGameBuffService(){
		if(gameBuff==null){
			gameBuff = new GameBuffServiceImpl();
		}
		return gameBuff;
	}

	private static IGameBmapService gameBmap;
	protected IGameBmapService getGameBmapService(){
		if(gameBmap==null){
			gameBmap = new GameBmapServiceImpl();
		}
		return gameBmap;
	}
	
	private static IActivityService activity;
	protected IActivityService getActivityService(){
		if(activity==null){
			activity = new ActivityServiceImpl();
		}
		return activity;
	}
}
