package com.stang.game.ffd.controller;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.CellFormat;
import jxl.write.Label;
import jxl.write.WritableCellFormat;

import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.stang.game.ffd.dao.impl.GameTaskFormalDaoImpl;
import com.stang.game.ffd.dao.impl.RoleConsortiaDaoImpl;
import com.stang.game.ffd.dao.impl.RoleSiteInfoDaoImpl;
import com.stang.game.ffd.entity.detail.EntityAreaCountDetail;
import com.stang.game.ffd.entity.detail.EntityCaseItmeDetail;
import com.stang.game.ffd.entity.detail.EntityCaseLogDetail;
import com.stang.game.ffd.entity.detail.EntityCheckBattleDetail;
import com.stang.game.ffd.entity.detail.EntityCheckDayDetail;

import com.stang.game.ffd.entity.detail.EntityBattleItemDetail;
import com.stang.game.ffd.entity.detail.EntityBattleSkillDetail;
import com.stang.game.ffd.entity.detail.EntityCheckFbDetail;
import com.stang.game.ffd.entity.detail.EntityCheckGoldItemDetail;
import com.stang.game.ffd.entity.detail.EntityCheckNoviceDayDetail;
import com.stang.game.ffd.entity.detail.EntityCheckNoviceDetail;
import com.stang.game.ffd.entity.detail.EntityCheckSellItemDetail;
import com.stang.game.ffd.entity.detail.EntityGameAvatarDetail;
import com.stang.game.ffd.entity.detail.EntityGameChatRoleDetail;
import com.stang.game.ffd.entity.detail.EntityGameConsortiaDetail;
import com.stang.game.ffd.entity.detail.EntityGameEquipDetail;
import com.stang.game.ffd.entity.detail.EntityGameItemDetail;
import com.stang.game.ffd.entity.detail.EntityGameItemsDetail;
import com.stang.game.ffd.entity.detail.EntityGameJobDetail;
import com.stang.game.ffd.entity.detail.EntityGameOnlineDetail;
import com.stang.game.ffd.entity.detail.EntityGamePlaneDetail;
import com.stang.game.ffd.entity.detail.EntityGameRoleDetail;
import com.stang.game.ffd.entity.detail.EntityGameSkillDetail;
import com.stang.game.ffd.entity.detail.EntityGameTaskFormalDetail;
import com.stang.game.ffd.entity.detail.EntityGiftBagTypeInfoDetail;
import com.stang.game.ffd.entity.detail.EntityItemAllDetail;
import com.stang.game.ffd.entity.detail.EntityNoviceTaskDetail;
import com.stang.game.ffd.entity.detail.EntityOrderInfoDetail;
import com.stang.game.ffd.entity.detail.EntityRoleConsortiaDetail;
import com.stang.game.ffd.entity.detail.EntitySellDetail;
import com.stang.game.ffd.entity.detail.GameTaskFormalDetail;
import com.stang.game.ffd.entity.detail.RoleSiteInfoDetail;
import com.stang.game.ffd.service.IAutoIdService;
import com.stang.game.ffd.service.ICaseDateExService;
import com.stang.game.ffd.service.ICaseLogService;
import com.stang.game.ffd.service.IGameAvatarService;
import com.stang.game.ffd.service.IGameChatRoleService;
import com.stang.game.ffd.service.IGameConsortiaService;
import com.stang.game.ffd.service.IGameEquipService;
import com.stang.game.ffd.service.IGameItemService;
import com.stang.game.ffd.service.IGamePlaneService;
import com.stang.game.ffd.service.IGameRoleService;
import com.stang.game.ffd.service.IGameSkillService;
import com.stang.game.ffd.service.IGameTaskFormalService;
import com.stang.game.ffd.service.IGiftBagTypeInfoService;
import com.stang.game.ffd.service.IOrderInfoService;
import com.stang.game.ffd.service.IRoleConsortiaService;
import com.stang.game.ffd.service.impl.AutoIdServiceImpl;
import com.stang.game.ffd.service.impl.CaseDateExServiceImpl;
import com.stang.game.ffd.service.impl.CaseLogServiceImpl;
import com.stang.game.ffd.service.impl.GameAvatarServiceImpl;
import com.stang.game.ffd.service.impl.GameChatRoleServiceImpl;
import com.stang.game.ffd.service.impl.GameConsortialServiceImpl;
import com.stang.game.ffd.service.impl.GameEquipServiceImpl;
import com.stang.game.ffd.service.impl.GameItemServiceImpl;
import com.stang.game.ffd.service.impl.GamePlaneServiceImpl;
import com.stang.game.ffd.service.impl.GameRoleServiceImpl;
import com.stang.game.ffd.service.impl.GameSkillServiceImpl;
import com.stang.game.ffd.service.impl.GameTaskFormalServiceImpl;
import com.stang.game.ffd.service.impl.GiftBagTypeInfoServiceImpl;
import com.stang.game.ffd.service.impl.OrderInfoServiceImpl;
import com.stang.game.ffd.service.impl.RoleConsortiaServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.alibaba.fastjson.JSON;

public class AdminDataCollect extends ActionSupport implements ServletRequestAware {
	private HttpServletRequest request;
	private HttpSession session;
	private ICaseDateExService caseDateExService;
	private ICaseLogService caseLogService;
	private List<EntityCaseLogDetail> ecld_list;
	private List<EntityGameConsortiaDetail> egcd;
	private IGameConsortiaService gameConsortialService;
	private IRoleConsortiaService roleConsortiaService;
	private IGameRoleService gameRoleService;
	private EntityRoleConsortiaDetail ercd;
	private EntityCheckDayDetail ecdd;
	private EntityGameJobDetail egjd;
	private EntityGameItemDetail egid;
	private IGamePlaneService gamePlaneService;
	private IGameItemService gameItemService; 
	private IGameAvatarService gameAvatarService;
	private IGameEquipService gameEquipService;
	private IOrderInfoService orderInfoService;
	private IGameChatRoleService gameChatRoleService; 
	private IGameSkillService gameSkillService;
	private IGameTaskFormalService gameTaskFormalService;
	private String path="c:\\";
	private IGiftBagTypeInfoService giftBagTypeInfoService;
	private String  listName;
	private IAutoIdService autoIdService;
	private String giftBagTypeName;//礼包类型名称
	private int emeID;//礼包类型id
	private String giftBagName;//礼包名称
	private int openLive;
	private String item_prop;
	private String [] gifts;
	private String stime1;
	private String stime2;
	private IGameTaskFormalService getGameTaskFormalService;
	
	private ICaseDateExService getCaseDateExService(){
		if(caseDateExService==null){
			caseDateExService= new CaseDateExServiceImpl();
		}
		return caseDateExService;
	}
	
	private ICaseLogService getCaseLogService(){
		if(caseLogService==null){
			caseLogService= new CaseLogServiceImpl();
		}
		return caseLogService;
	}
	
	private IGameConsortiaService getGameConSortialService(){
		if(gameConsortialService == null){
			gameConsortialService = new GameConsortialServiceImpl();
		}
		return gameConsortialService;
	}
	
	private IRoleConsortiaService getRoleConsortiaService(){
		if(roleConsortiaService==null){
			roleConsortiaService = new RoleConsortiaServiceImpl();
		}
		return roleConsortiaService;
	}
	
	private IGameRoleService getGameRoleService(){
		if(gameRoleService==null){
			gameRoleService = new GameRoleServiceImpl();
		}
		return gameRoleService;
	}
	
	private IGamePlaneService getGamePlaneService(){
		if(gamePlaneService == null){
			gamePlaneService = new GamePlaneServiceImpl();
		}
		return gamePlaneService;
	}
	
	private IGameItemService getGameItemService(){
		if(gameItemService == null){
			gameItemService = new GameItemServiceImpl();
		}
		return gameItemService;
	}
	
	private IGameAvatarService getGameAvatarService(){
		if(gameAvatarService == null){
			gameAvatarService = new GameAvatarServiceImpl();
		}return gameAvatarService;
	}
	
	private IGameEquipService getGameEquipService(){
		if(gameEquipService== null){
			gameEquipService = new GameEquipServiceImpl();
		}return gameEquipService;
	}
	
	private IOrderInfoService getOrderInfoService(){
		if(orderInfoService == null){
			orderInfoService = new OrderInfoServiceImpl();
		}
		return orderInfoService;
	}
	
	private IGameChatRoleService getGameChatRoleService(){
		if(gameChatRoleService==null){
			gameChatRoleService = new GameChatRoleServiceImpl();
		}
		return gameChatRoleService;
	}
	
	private IGameTaskFormalService gameTaskFormalService(){
		if(gameTaskFormalService == null){
			gameTaskFormalService = new GameTaskFormalServiceImpl();
		}
		return gameTaskFormalService;
	}
	
	/*先将数据全部取出*/
	private List<EntityCaseLogDetail> getEcld_list(){
		if(ecld_list==null){
			Map<String,Object> parms = new HashMap<String,Object>();
			ecld_list=this.getCaseLogService().getAllPoint(parms);
		}
		return ecld_list;
	}
	
	/*技能方面的数据*/
	private IGameSkillService getGameSkillService(){
		if(gameSkillService==null){
			gameSkillService = new GameSkillServiceImpl();
		}
		return gameSkillService;
	}
	
	private IGiftBagTypeInfoService getGiftBagTypeInfoService(){
		if(giftBagTypeInfoService==null){
			giftBagTypeInfoService = new GiftBagTypeInfoServiceImpl();
		}
		return giftBagTypeInfoService;
	}
	
	private IAutoIdService getAutoIdService(){
		if(autoIdService==null){
			autoIdService = new AutoIdServiceImpl();
		}return autoIdService;
	}
	
	private IGameTaskFormalService getGameTaskFormalService(){
		if(this.gameTaskFormalService==null){
			this.gameTaskFormalService = new GameTaskFormalServiceImpl();
		}
		return gameTaskFormalService;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
		this.session = ServletActionContext.getRequest().getSession();
	}
	
	public int getOpenLive() {
		return openLive;
	}

	public void setOpenLive(int openLive) {
		this.openLive = openLive;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	
	public String getGiftBagTypeName() {
		return giftBagTypeName;
	}

	public void setGiftBagTypeName(String giftBagTypeName) {
		this.giftBagTypeName = giftBagTypeName;
	}
	
	public int getEmeID() {
		return emeID;
	}

	public void setEmeID(int emeID) {
		this.emeID = emeID;
	}
	public String getGiftBagName() {
		return giftBagName;
	}

	public void setGiftBagName(String giftBagName) {
		this.giftBagName = giftBagName;
	}
	
	public String getItem_prop() {
		return item_prop;
	}

	public void setItem_prop(String item_prop) {
		this.item_prop = item_prop;
	}
	
	public String[] getGifts() {
		return gifts;
	}

	public void setGifts(String[] gifts) {
		this.gifts = gifts;
	}
	
	public String getStime1() {
		return stime1;
	}

	public void setStime1(String stime1) {
		this.stime1 = stime1;
	}

	public String getStime2() {
		return stime2;
	}

	public void setStime2(String stime2) {
		this.stime2 = stime2;
	}
	
	/*查看当天的登录注册情况*/
	public String checkDay(){
		String st="succ";
		//Map<String,HashMap<String,Object>> results = new HashMap<String,HashMap<String,Object>>();
		int reg_count=0;//获得所有的注册人数
		int reg_count_v=0;//获得成功注册的人
		int sucess_user=0;//注册玩家成功进入游戏的人数
		int allUserCount=0;//所有的登录玩家数
		int allUserLogo=0;//成功登录游戏的人数
		String _datetime="";
		String createTime1=this.request.getParameter("stime1");
		String createTime2=this.request.getParameter("stime2");
		List<EntityCheckDayDetail> lecdd= new ArrayList<EntityCheckDayDetail>();//封裝採集到的最後的數據
		/*
		 * ibatis  会将变量当字符串处理。在表的外面加单引号所以不能动态给定表名，暂时性屏蔽，日后该dom4j xml直接读写。
		 * */
		/*获得当前信息采集的表明*/
//		List<EntityCaseDateExDetail> leded=this.getCaseDateExService().getTableName();
//		EntityCaseDateExDetail ecd= new EntityCaseDateExDetail();
//		ecd=(EntityCaseDateExDetail)leded.get(0);
//		String tableName=ecd.getTable_name();
//		List<EntityCaseLogDetail> ecld=getCaseLogService().getAllPoint(tableName);
		//-----------------20110726------------------------------------------------
		/*获取数据里面的日期，判断这是多少天的数据*/
		List<EntityCaseLogDetail> date_list=this.getCaseLogService().getAllDateList(getEcld_list());
		List<EntityCaseLogDetail> liste=getEcld_list();
		//选择时间区间 进这里
		if(createTime1!=null || createTime2!=null ){//2个时间只要有任意一个存在就要为另外一个创建初始值
		if(createTime1==null || createTime1.equals("")){
			createTime1 = "1970-01-01";//意义你懂的
		}
		if(createTime2==null || createTime2.equals("")){
			//获取当前的时间作为 time2的补全时间
			SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
			createTime2 = tempDate.format(new java.util.Date());
		}
		// 首先便利出时间区间里面的信息的天数的数据
		List<EntityCaseLogDetail> lecld=getCaseLogService().getAllDateListTimeToTime(liste,createTime1,createTime2);
		date_list=this.getCaseLogService().getAllDateList(lecld);
//		HashMap<String,Object> result = new HashMap<String,Object>();
//		result.put("注册人数", this.getCaseLogService().getAllUserReg(liste, createTime1, createTime2).size());
//		result.put("成功激活的玩家", this.getCaseLogService().getAllUserRegLoding(liste, createTime1, createTime2).size());
//		result.put("最高在线", this.getCaseLogService().getAllUserOnlineMax(liste, createTime1,createTime2));
//		result.put("不重复登录",this.getCaseLogService().getUniqueUser(liste, createTime1, createTime2).size());
//		
		}
		/*循环输出获取 每一天的数据*/
		for(EntityCaseLogDetail _date_list:date_list){
			/*获得所有的注册人数*/
			_datetime=_date_list.getCase_time().toString().substring(0, 10);
			//HashMap<String,Object> result = new HashMap<String,Object>();
			EntityCheckDayDetail ecld= new EntityCheckDayDetail();
			ecld.setDate(_datetime);
			/*获得真实的总登录人数*/
			ecld.setRegNum(this.getCaseLogService().noRepleAll(getEcld_list(),69).size());//和时间没有关系的。获取总玩家人数
			//reg_count=this.getCaseLogService().getAllUserReg(getEcld_list(),_datetime);
			//result.put("注册人数", reg_count);
			ecld.setRegMan(this.getCaseLogService().noRepleAll(liste, 69,_datetime).size());//获取当日的新用户
			ecld.setUlt(this.getCaseLogService().noRepleAll(liste, 1,_datetime).size());//当前登录数
			ecld.setUlts(this.getCaseLogService().noRepleAll(liste, 4,_datetime).size());//成功登录进游戏的玩家数
			
			/*便利所有注册用户，创建玩家的用户就是新注册的用户,采集点是3的就是68的就是新注册的用户*/
			//reg_count_v=this.getCaseLogService().getAllUserRegCreateRole(getEcld_list(),_date_list.getCase_time().toString().substring(0, 10));
			//result.put("注册成功数", reg_count_v);
			//ecld.setRegsuccess(reg_count_v);
			ecld.setRegsuccess(this.getCaseLogService().noRepleAll(liste, 68,_datetime).size());//获取新登录的用户
			/* 获得所有进入游戏的人数，成功进入选区界面的人 */
			//result.put("注册的玩家进入游戏次数", this.getCaseLogService().getAllUserRegLodingAll(getEcld_list(), _datetime));
			ecld.setRegManLogin(this.getCaseLogService().getAllUserRegLoding(getEcld_list(), _datetime));
//			sucess_user=this.getCaseLogService().getAllUserRegLoding(getEcld_list(),_date_list.getCase_time().toString().substring(0, 10));
		
//			result.put("注册的玩家进入游戏人数", sucess_user);
			
			/*获取所有的登录用户次数*/
			//result.put("所有玩家登陆次数", this.getCaseLogService().getAllUserCountAll(getEcld_list(), _datetime));
			ecld.setAllUserLogin(this.getCaseLogService().getAllUserCountAll(getEcld_list(), _datetime));
			//allUserCount=this.getCaseLogService().getAllUserCount(getEcld_list(),_date_list.getCase_time().toString().substring(0, 10));
			//result.put("所有玩家登录人数", allUserCount);
			
			/*获取所有成功进入游戏的玩家 到达选取界面*/
			//result.put("玩家进入游戏次数", this.getCaseLogService().getAllUserLoginAll(getEcld_list(), _datetime));
			ecld.setAllUserPlayNum(this.getCaseLogService().getAllUserLoginAll(getEcld_list(), _datetime));
			//allUserLogo=this.getCaseLogService().getAllUserLogin(getEcld_list(),_date_list.getCase_time().toString().substring(0, 10));
			//result.put("玩家进入游戏人数", allUserLogo);
			//result.put("最高在线", this.getCaseLogService().getAllUserOnlineMax(liste,_datetime));
			ecld.setMaxOnline(this.getCaseLogService().getAllUserOnlineMax(liste,_datetime));
			//result.put("不重复登录",this.getCaseLogService().getUniqueUser(liste, _datetime).size());
			ecld.setNoRepeatlogoin(this.getCaseLogService().getUniqueUser(liste, _datetime).size());
			//results.put(_date_list.getCase_time().toString().substring(0, 10), result);
			ecld.setPzwb(this.getCaseLogService().staicPublic(liste, _datetime, 88).size());
			ecld.setTygjmb(this.getCaseLogService().staicPublic(liste, _datetime, 89).size());
			ecld.setYxb(this.getCaseLogService().staicPublic(liste, _datetime, 90).size());
			ecld.setLjserver(this.getCaseLogService().staicPublic(liste, _datetime, 91).size());
			ecld.setLjltserver(this.getCaseLogService().staicPublic(liste, _datetime, 92).size());
			ecld.setJzmxsj(this.getCaseLogService().staicPublic(liste, _datetime, 93).size());
			ecld.setHqphb(this.getCaseLogService().staicPublic(liste, _datetime, 94).size());
			ecld.setHqghlb(this.getCaseLogService().staicPublic(liste, _datetime, 95).size());
			ecld.setHqdqlb(this.getCaseLogService().staicPublic(liste, _datetime, 96).size());
			ecld.setHqdzdh(this.getCaseLogService().staicPublic(liste, _datetime, 97).size());
			ecld.setHqwjxx(this.getCaseLogService().staicPublic(liste, _datetime, 98).size());
			ecld.setJzcjrwjm(this.getCaseLogService().staicPublic(liste, _datetime, 99).size());
			ecld.setJazjm(this.getCaseLogService().staicPublic(liste, _datetime, 100).size());
			ecld.setJzxsbz(this.getCaseLogService().staicPublic(liste, _datetime, 101).size());
			ecld.setJzdtjm(this.getCaseLogService().staicPublic(liste, _datetime, 102).size());
			ecld.setJzfjjm(this.getCaseLogService().staicPublic(liste, _datetime, 103).size());
			ecld.setJzzdjm(this.getCaseLogService().staicPublic(liste, _datetime, 104).size());
			ecld.setJzadzy(this.getCaseLogService().staicPublic(liste, _datetime, 105).size());
			lecdd.add(ecld);
		}
		String execl=request.getParameter("execl");
		if(execl!=null){
			//说明需要生成xml
			String title="日期,总创建角色数,当日创建角色数,用户增长率,当日uv,当日uv率,最高在线,不重复登陆,配置文件加载,通用工具面板,音效包,连接server,连接聊天server,连接模型数据,获取排行榜,获取工会列表,获取大区列表,获取大招动画,获取玩家信息,获取创建人物界面,加载主界面,加载新手帮助,加载大厅界面,加载战斗界面,加载战斗资源";
			Map<String,Object> resultMap = new HashMap<String,Object>();
			resultMap.put("mapresult", lecdd);
			String common="checkDay";
			this.createExecl( common, title,resultMap,path+"checkDay.xls");
		}
			request.setAttribute("results", lecdd);
			return st;
			}
	/*查看当前的道具销量*/
	public String checkItem(){
		//HashMap<String,HashMap<String,Object>> results = new HashMap<String,HashMap<String,Object>>();
		String _datetime="";
		String createTime1=this.request.getParameter("stime1");
		String createTime2=this.request.getParameter("stime2");
		List<EntityCaseLogDetail> liste=getEcld_list();
		
		List<EntityGameItemDetail> legid= new ArrayList<EntityGameItemDetail>();
		/* 因为是按销量所有不用去屏蔽相同的ip或者相同的道具 */
		/* 获取数据里面的日期，判断这是多少天的数据 */
		List<EntityCaseLogDetail> date_list=this.getCaseLogService().getAllDateList(liste);
		//选择时间区间 进这里
		if(createTime1!=null || createTime2!=null ){//2个时间只要有任意一个存在就要为另外一个创建初始值
			if(createTime1==null || createTime1.equals("")){
				createTime1 = "1970-01-01";//意义你懂的
			}
			if(createTime2==null || createTime2.equals("")){
				//获取当前的时间作为 time2的补全时间
				SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
				createTime2 = tempDate.format(new java.util.Date());
			}
			// 首先便利出时间区间里面的信息的天数的数据
			List<EntityCaseLogDetail> lecld=getCaseLogService().getAllDateListTimeToTime(liste,createTime1,createTime2);
			date_list=this.getCaseLogService().getAllDateList(lecld);
			}
		/* 循环输出获取 每一天的数据 */													
		for(EntityCaseLogDetail _date_list:date_list){
			egid = new EntityGameItemDetail();
			_datetime=_date_list.getCase_time().toString().substring(0, 10);
			egid.setDate(_datetime);
			//HashMap<String,Object> result = new HashMap<String,Object>();
		/* 获取所有的rmb道具的购买次数 */
			List<EntityCaseLogDetail> rmbitem=this.getCaseLogService().getBuyRmbItem(liste, _datetime);
			//result.put("rmb销售次数", rmbitem.size());
			egid.setRmbItem(rmbitem.size());
		/* 获取强化次数 */	
			//result.put("强化次数", this.getCaseLogService().getIntensify(liste, _datetime));
			egid.setIntensify(this.getCaseLogService().getIntensify(liste, _datetime).size());
		/* 获取强化次数里面使用过的道具数量 */	
			
			
		/* 获取道具合成的总次数 */
			//result.put("合成次数", this.getCaseLogService().getSynthesis(liste, _datetime));
			egid.setSynthesis(this.getCaseLogService().getSynthesis(liste, _datetime).size());
			//result.put("合成出的物品数",this.getCaseLogService().getSynthesisItem(liste, _datetime));
			egid.setSynthesisItem(this.getCaseLogService().getSynthesisItem(liste, _datetime).size());
			
			//results.put(_datetime, result);
			legid.add(egid);
		}
		String execl=request.getParameter("execl");
		if(execl!=null){
			//说明需要生成xml
			String title="日期,rmb销售次数,强化次数,合成次数,合成物品";
			Map<String,Object> resultMap = new HashMap<String,Object>();
			resultMap.put("mapresult", legid);
			String common="checkItem";
			this.createExecl( common, title,resultMap,path+"checkItem.xls");
		}
		
		request.setAttribute("results", legid);
		return "succ";
		}
	
	
	/* 根据时间查看道具销量 */
	
	
	/**
	 * 时间转换
	 */
	public static String getStringDate(String _date){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		_date=formatter.format(_date);
		return _date;
	}
	
	
	/**
	 * 获取工会成员的信息
	 * @return
	 */
	 public String checkGuild(){
//		 String Date=this.request.getParameter("startDate");
		 Map<String,Object> parm = new HashMap<String,Object>();
		 List<EntityGameConsortiaDetail> temp=this.getGameConSortialService().getAllConsortiaInfo(parm);
		 List<EntityGameConsortiaDetail> re_list=new ArrayList<EntityGameConsortiaDetail>();
		 /**
		  * 查询出所有的工会信息。然后在去便利每个工会有多少人。
		  * （待定）
		  */
		 for(EntityGameConsortiaDetail egcd :temp){
		Map<String,Object> param = new HashMap<String,Object>();
		 param.put("id", egcd.getChairmanId());
		 List<EntityGameRoleDetail> legrd=getGameRoleService().getGameJob(param);
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 for(EntityGameRoleDetail egrd:legrd){
			 egcd.setEgrd(egrd);
		 	}
		 	egcd.setCtime(formatter.format(egcd.getCreateTime()));
		 	re_list.add(egcd);
		 }
		 request.setAttribute("results",re_list);
		 return "succ";
	 }
	 
	  /**
	   * 获得职业分布
	   * @return
	   */
	public String checkJob(){
		if(egjd==null){
			egjd=new EntityGameJobDetail();
		}
		List<EntityGameJobDetail> legjd = new ArrayList<EntityGameJobDetail>();
		String createTime1=this.request.getParameter("stime");
		String createTime2=this.request.getParameter("stime2");
		Map<String,Object> param = new HashMap<String,Object>();
		Map<String,Object> results =new HashMap<String,Object>();
		if(createTime1 != null && createTime2!=null ){
			param.put("createTime1", createTime1);
			param.put("createTime2", createTime2);
		}
		List<EntityGameRoleDetail> legrd_all=getGameRoleService().getGameJob(param);
		/* 查看各职业的分类情况 1攻击,2敏捷,3防御 */
//		results.put("攻击职业",this.getGameRoleService().getGameJob(legrd_all, 1).size());
//		results.put("敏捷职业",this.getGameRoleService().getGameJob(legrd_all, 2).size());
//		results.put("防御职业",this.getGameRoleService().getGameJob(legrd_all, 3).size());
		egjd.setStrength(this.getGameRoleService().getGameJob(legrd_all, 1).size());
		egjd.setAgility(this.getGameRoleService().getGameJob(legrd_all, 2).size());
		egjd.setDefanse(this.getGameRoleService().getGameJob(legrd_all, 3).size());
		legjd.add(egjd);
		request.setAttribute("results", legjd);
		return "succ";
	}
	 
	/*
	 * 将数据采集表里面的数据，变成，注册用户，注册用户登录，注册用户创建用户书，进入游戏数，所有登录用户数
	 * 进入游戏用户数  和平均在线 和 最高在线，还有登录游戏的老用户数
	 * 一行为一天的数据
	 * */
	public List<EntityCaseLogDetail> createDateView(){
		return null;
	}
	
	
	/* 便利所有道具 */
	public String checkItemAll(){
		String _datetime="";
		String [] tempArray=null;
		String [] tempa=null;
		int tpmint=0;
		//int itmeType=0;//数据类型
		String createTime1=this.request.getParameter("stime1");
		String createTime2=this.request.getParameter("stime2");
		int itemType=Integer.parseInt(this.request.getParameter("type")+"");
		List<EntityCaseLogDetail> liste = getEcld_list();
		List<EntityItemAllDetail> leial = new ArrayList<EntityItemAllDetail>();//所有道具的集合
		List<EntityGameItemDetail> legid = new ArrayList<EntityGameItemDetail>();
		List<EntityCaseItmeDetail> lecid = new ArrayList<EntityCaseItmeDetail>();
		List<EntityCheckSellItemDetail> lsellitem = new ArrayList<EntityCheckSellItemDetail>();
		/* 因为是按销量所有不用去屏蔽相同的ip或者相同的道具 */
		/* 获取数据里面的日期，判断这是多少天的数据 */
		List<EntityCaseLogDetail> date_list=this.getCaseLogService().getAllDateList(liste);
		//选择时间区间 进这里
		if(createTime1!=null || createTime2!=null ){//2个时间只要有任意一个存在就要为另外一个创建初始值
			if(createTime1==null || createTime1.equals("")){
				createTime1 = "1970-01-01";//意义你懂的
			}
			if(createTime2==null || createTime2.equals("")){
				//获取当前的时间作为 time2的补全时间
				SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
				createTime2 = tempDate.format(new java.util.Date());
			}
			// 首先便利出时间区间里面的信息的天数的数据
			List<EntityCaseLogDetail> lecld=getCaseLogService().getAllDateListTimeToTime(liste,createTime1,createTime2);
			date_list=this.getCaseLogService().getAllDateList(lecld);
			}
		/* 循环输出获取 每一天的购买数据 */													
		for(EntityCaseLogDetail _date_list:date_list){
			_datetime=_date_list.getCase_time().toString().substring(0, 10);
			List<EntityCaseLogDetail> rmbitem=this.getCaseLogService().getBuyRmbItem(liste, _datetime);
			List<EntityCaseLogDetail> sellitem=this.getCaseLogService().staicPublic(liste, _datetime, 73);
			for(EntityCaseLogDetail ecld : rmbitem){
				/* 获取字段中的主类型,根据不同的主类型返回数据集合 */
				EntityItemAllDetail eiad=new EntityItemAllDetail();
				/* 先将数据 清理掉头和尾 */
				tempa=ecld.getCase_ex_desc().substring(1,ecld.getCase_ex_desc().length()-1).split(",");
				if(tempa.length>1){
					for(String tm:tempa){
						tempArray=tm.split("-");
						if(itemType > 0 && itemType < 5 ){ //1~4的类型才是所需要的类型（1-飞机，2-装备，3-道具，4-装扮）
							if(itemType==tpmint){//值匹配和属性相同类型的道具
								EntityCaseItmeDetail ecid = new EntityCaseItmeDetail();
								ecid.setMasttypeId(tpmint);
								ecid.setItemId(Integer.parseInt(tempArray[1]));
								ecid.setBuyNum(Integer.parseInt(tempArray[2]));
								lecid.add(ecid);
							}
						}
					}
				}else{
					tempArray=ecld.getCase_ex_desc().substring(1,ecld.getCase_ex_desc().length()-1).split("-");
					String temp1=tempArray[0];
					if(!temp1.equals("null")){
						tpmint=Integer.parseInt(tempArray[0]);	
						if(itemType > 0 && itemType < 5 ){ //1~4的类型才是所需要的类型（1-飞机，2-装备，3-道具，4-装扮）
							if(itemType==tpmint){//值匹配和属性相同类型的道具
								EntityCaseItmeDetail ecid = new EntityCaseItmeDetail();
								ecid.setMasttypeId(tpmint);
								ecid.setItemId(Integer.parseInt(tempArray[1]));
								ecid.setBuyNum(Integer.parseInt(tempArray[2]));
								lecid.add(ecid);
							}
						}
				}
				
			}	
		}
			//循环获取 每天消耗掉的道具	
			
			for(EntityCaseLogDetail ecld : sellitem){
				/* 获取字段中的主类型,根据不同的主类型返回数据集合 */
				List<EntityCheckSellItemDetail> lecsid=new ArrayList<EntityCheckSellItemDetail>();
				/* 先将数据 清理掉头和尾 */
				tempa=ecld.getCase_ex_desc().substring(1,ecld.getCase_ex_desc().length()-1).split(",");
				if(tempa.length>1){
					for(String tm:tempa){
						tempArray=tm.split("-");
						if(itemType > 0 && itemType < 5 ){ //1~4的类型才是所需要的类型（1-飞机，2-装备，3-道具，4-装扮）
							if(itemType==tpmint){//值匹配和属性相同类型的道具
								EntityCheckSellItemDetail ecsid=new EntityCheckSellItemDetail();
								ecsid.setSellmasttypeId(tpmint);
								ecsid.setSellitemId(Integer.parseInt(tempArray[1]));
								ecsid.setSellbuyNum(Integer.parseInt(tempArray[2]));
								lsellitem.add(ecsid);
							}
						}
					}
				}else{
					tempArray=ecld.getCase_ex_desc().substring(1,ecld.getCase_ex_desc().length()-1).split("-");
					String temp1=tempArray[0];
					if(!temp1.equals("null") && !temp1.equals("") ){
						tpmint=Integer.parseInt(tempArray[0]);	
						if(itemType > 0 && itemType < 5 ){ //1~4的类型才是所需要的类型（1-飞机，2-装备，3-道具，4-装扮）
							if(itemType==tpmint){//值匹配和属性相同类型的道具
								EntityCheckSellItemDetail ecsid = new EntityCheckSellItemDetail();
								ecsid.setSellmasttypeId(tpmint);
								ecsid.setSellitemId(Integer.parseInt(tempArray[1]));
								ecsid.setSellbuyNum(Integer.parseInt(tempArray[2]));
								lsellitem.add(ecsid);
							}
						}
				}
				
			}	
		}
		}
		String resu="err";
		/**
		 *  根据调用进来的type值进行再次便利
		 */
		switch(itemType){
		case 1://对飞机的数据处理
			List<EntityGamePlaneDetail> legpd=this.checkTopPlane(lecid,lsellitem);
			request.setAttribute("results", legpd);resu="succ1";
			break;
		case 2://对装备的数据处理
			List<EntityGameEquipDetail> leged=this.checkTopEquip(lecid,lsellitem);
			request.setAttribute("results", leged);resu="succ2";
			break;
		case 3://对道具的数据处理
			List<EntityGameItemsDetail> legid2=this.checkTopItem(lecid,lsellitem);
			request.setAttribute("results", legid2);resu="succ3";
			break;
		case 4://对道具的数据处理
			List<EntityGameAvatarDetail> legad=this.checkTopAvatar(lecid,lsellitem);
			request.setAttribute("results", legad);resu="succ4";
			break;
		}
		return resu;
	}
	
	/* 飞机排行榜 */
	public List<EntityGamePlaneDetail> checkTopPlane(List<EntityCaseItmeDetail> lecid,List<EntityCheckSellItemDetail> sellitem){
		
		List<EntityGamePlaneDetail> legpd=null;
		Map<String,Object> parm = new HashMap<String,Object>();
		legpd=this.getGamePlaneService().getAllInfo(parm);
			for(EntityCaseItmeDetail ecid:lecid){
				for(EntityGamePlaneDetail egpd : legpd){
					//System.out.print(egpd.getId()+"-"+ecid.getItemId());
					if(egpd.getId()==ecid.getItemId()){
						if(ecid.getBuyNum()>0){
							egpd.setNum(egpd.getNum()+ecid.getBuyNum());
						}else{
							egpd.setNum(0+ecid.getBuyNum());
						}
					}
			}
				
		}
			for(EntityCheckSellItemDetail ecsid:sellitem){
				for(EntityGamePlaneDetail egpd : legpd){
					//System.out.print(egpd.getId()+"-"+ecid.getItemId());
					if(egpd.getId()==ecsid.getSellitemId()){
						if(ecsid.getSellbuyNum()>0){
							egpd.setSellNum(egpd.getSellNum()+ecsid.getSellbuyNum());
						}else{
							egpd.setSellNum(0+ecsid.getSellbuyNum());
						}
					}
			}
		}
		return legpd;
	}
	
	/* 道具排行榜 */
	public List<EntityGameItemsDetail> checkTopItem(List<EntityCaseItmeDetail> lecid,List<EntityCheckSellItemDetail> sellitem){
		List<EntityGameItemsDetail> legids=null;
		Map<String,Object> parm = new HashMap<String,Object>();
		legids = this.getGameItemService().getAllInfo(parm);
		for(EntityCaseItmeDetail ecid:lecid){
			for(EntityGameItemsDetail egids : legids){
				//System.out.print(egids.getId()+"-"+ecid.getItemId()+"|");
				if(egids.getId()==ecid.getItemId()){
					if(ecid.getBuyNum()>0){
						egids.setNum(egids.getNum()+ecid.getBuyNum());
					}else{
						egids.setNum(0+ecid.getBuyNum());
					}
				}
		}
	}
		for(EntityCheckSellItemDetail ecsid:sellitem){
			for(EntityGameItemsDetail egid : legids){
				//System.out.print(egpd.getId()+"-"+ecid.getItemId());
				if(egid.getId()==ecsid.getSellitemId()){
					if(ecsid.getSellbuyNum()>0){
						egid.setSellnum(egid.getSellnum()+ecsid.getSellbuyNum());
					}else{
						egid.setSellnum(0+ecsid.getSellbuyNum());
					}
				}
		}
	}
		
		return legids;
	}
	
	/* 装扮排行榜 */
	public List<EntityGameAvatarDetail> checkTopAvatar(List<EntityCaseItmeDetail> lecid,List<EntityCheckSellItemDetail> sellitem){
		List<EntityGameAvatarDetail> legad=null;
		Map<String,Object> parm = new HashMap<String,Object>();
		legad = this.getGameAvatarService().getAllInfo(parm);
		for(EntityCaseItmeDetail ecid:lecid){
			for(EntityGameAvatarDetail egad : legad){
				//System.out.print(egad.getId()+"-"+ecid.getItemId()+"|");
				if(egad.getId()==ecid.getItemId()){
					if(ecid.getBuyNum()>0){
						egad.setNum(egad.getNum()+ecid.getBuyNum());
					}else{
						egad.setNum(0+ecid.getBuyNum());
					}
				}
		}
	}
		for(EntityCheckSellItemDetail ecsid:sellitem){
			for(EntityGameAvatarDetail egad : legad){
				//System.out.print(egpd.getId()+"-"+ecid.getItemId());
				if(egad.getId()==ecsid.getSellitemId()){
					if(ecsid.getSellbuyNum()>0){
							egad.setSellNum(egad.getSellNum()+ecsid.getSellbuyNum());
						}else{
						egad.setSellNum(0+ecsid.getSellbuyNum());
					}
				}
		}
	}
		return legad;
	}
	
	/* 装备排行榜 */
	public List<EntityGameEquipDetail> checkTopEquip(List<EntityCaseItmeDetail> lecid,List<EntityCheckSellItemDetail> sellitem){
		List<EntityGameEquipDetail> leged=null;
		Map<String,Object> parm = new HashMap<String,Object>();
		leged =this.getGameEquipService().getAllInfo(parm);
		for(EntityCaseItmeDetail ecid:lecid){
			for(EntityGameEquipDetail eged : leged){
				//System.out.print(eged.getId()+"-"+ecid.getItemId()+"|");
				if(eged.getId()==ecid.getItemId()){
					if(ecid.getBuyNum()>0){
						eged.setNum(eged.getNum()+ecid.getBuyNum());
					}else{
						eged.setNum(0+ecid.getBuyNum());
					}
				}
		}
	}
		for(EntityCheckSellItemDetail ecsid:sellitem){
			for(EntityGameEquipDetail eged : leged){
				//System.out.print(egpd.getId()+"-"+ecid.getItemId());
				if(eged.getId()==ecsid.getSellitemId()){
					if(ecsid.getSellbuyNum()>0){
						eged.setSellNum(eged.getSellNum()+ecsid.getSellbuyNum());
					}else{
						eged.setSellNum(0+ecsid.getSellbuyNum());
					}
				}
		}
	}
		return leged;
	}
	
	/* 新手引导 */
	public String checkNovice(){
		List<EntityCaseLogDetail> liste = getEcld_list();
		List<EntityCaseLogDetail> date_list=this.getCaseLogService().getAllDateList(liste);
		String createTime1=this.request.getParameter("stime1");
		String createTime2=this.request.getParameter("stime2");
		String _datetime="";
	
		if(createTime1!=null || createTime2!=null ){//2个时间只要有任意一个存在就要为另外一个创建初始值
			if(createTime1==null || createTime1.equals("")){
				createTime1 = "1970-01-01";//意义你懂的
			}
			if(createTime2==null || createTime2.equals("")){
				//获取当前的时间作为 time2的补全时间
				SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
				createTime2 = tempDate.format(new java.util.Date());
			}
			// 首先便利出时间区间里面的信息的天数的数据
			List<EntityCaseLogDetail> lecld=getCaseLogService().getAllDateListTimeToTime(liste,createTime1,createTime2);
			date_list=this.getCaseLogService().getAllDateList(lecld);
			}
		List<EntityCheckNoviceDayDetail> lecndd = new ArrayList<EntityCheckNoviceDayDetail>();
		for(EntityCaseLogDetail _date_list:date_list){
			_datetime=_date_list.getCase_time().toString().substring(0, 10);
			EntityCheckNoviceDetail ecnd=this.getCaseLogService().getNovice(liste,_datetime);
			EntityCheckNoviceDayDetail ecndd=new EntityCheckNoviceDayDetail();
			ecndd.setDate(_datetime);
			ecndd.setEcnd(ecnd);
			lecndd.add(ecndd);
		}
		String execl=request.getParameter("execl");
		if(execl!=null){
			//说明需要生成xml
			String title="日期,";
			for(int i=1;i<=37;i++){
				title+="第"+i+"步,";
			}
			title+="流失率";
			Map<String,Object> resultMap = new HashMap<String,Object>();
			resultMap.put("mapresult", lecndd);
			String common="checkNovice";
			this.createExecl( common, title,resultMap,path+"checkNovice.xls");
		}
		request.setAttribute("results", lecndd);
			return "succ";
	}
	
	/* fb采集 */
	public String checkfb(){
		List<EntityCaseLogDetail> liste = getEcld_list();
		List<EntityCaseLogDetail> date_list=this.getCaseLogService().getAllDateList(liste);
		String createTime1=this.request.getParameter("stime1");
		String createTime2=this.request.getParameter("stime2");
		String _datetime="";
	
		if(createTime1!=null || createTime2!=null ){//2个时间只要有任意一个存在就要为另外一个创建初始值
			if(createTime1==null || createTime1.equals("")){
				createTime1 = "1970-01-01";//意义你懂的
			}
			if(createTime2==null || createTime2.equals("")){
				//获取当前的时间作为 time2的补全时间
				SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
				createTime2 = tempDate.format(new java.util.Date());
			}
			// 首先便利出时间区间里面的信息的天数的数据
			List<EntityCaseLogDetail> lecld=getCaseLogService().getAllDateListTimeToTime(liste,createTime1,createTime2);
			date_list=this.getCaseLogService().getAllDateList(lecld);
			}
		List<EntityCheckFbDetail> lecfd = new ArrayList<EntityCheckFbDetail>();
		for(EntityCaseLogDetail _date_list:date_list){
			_datetime=_date_list.getCase_time().toString().substring(0, 10);
			EntityCheckFbDetail ecfd = new EntityCheckFbDetail();
			ecfd.setDatetime(_datetime);
			// fb进入数 84 、 胜利数86、失败数87
			ecfd.setFbnum(this.getCaseLogService().staicPublic(liste,_datetime,84).size());
			ecfd.setFbwin(this.getCaseLogService().staicPublic(liste,_datetime,86).size());
			ecfd.setFblost(this.getCaseLogService().staicPublic(liste,_datetime,87).size());
			lecfd.add(ecfd);
		}
		String execl=request.getParameter("execl");
		if(execl!=null){
			//说明需要生成xml
			String title="日期,fb开启场次,胜利场次,失败场次,胜率,败率";
			Map<String,Object> resultMap = new HashMap<String,Object>();
			resultMap.put("mapresult", lecfd);
			String common="checkfb";
			this.createExecl( common, title,resultMap,path+"checkfb.xls");
		}
		request.setAttribute("results", lecfd);
			return "succ";
	}
	
	
	// 获取当前的货币流通
	int money=0;
	public String checkSell(){
		String _datetime="";
		String [] tempArray=null;
		String [] tempa=null;
		int tpmint=0;
		String createTime1=this.request.getParameter("stime1");
		String createTime2=this.request.getParameter("stime2");
		List<EntityCaseLogDetail> liste = getEcld_list();
		List<EntityItemAllDetail> leial = new ArrayList<EntityItemAllDetail>();//所有道具的集合
		List<EntityGameItemDetail> legid = new ArrayList<EntityGameItemDetail>();
		List<EntityCaseItmeDetail> lecid = new ArrayList<EntityCaseItmeDetail>();
		/* 因为是按销量所有不用去屏蔽相同的ip或者相同的道具 */
		/* 获取数据里面的日期，判断这是多少天的数据 */
		List<EntityCaseLogDetail> date_list=this.getCaseLogService().getAllDateList(liste);
		//选择时间区间 进这里
		List<EntitySellDetail> lesd=new ArrayList<EntitySellDetail>();
		for(EntityCaseLogDetail _date_list:date_list){
			_datetime=_date_list.getCase_time().toString().substring(0, 10);
			EntitySellDetail esd = new EntitySellDetail();
			List<EntityCaseLogDetail> rmbitem=this.getCaseLogService().getBuyRmbItem(liste, _datetime);
			esd.setDatetime(_datetime);
			for(EntityCaseLogDetail ecld : rmbitem){
				/* 获取字段中的主类型,根据不同的主类型返回数据集合 */
				EntityItemAllDetail eiad=new EntityItemAllDetail();
				/* 先将数据 清理掉头和尾 */
				System.out.printf(ecld.getId()+",");
				tempa=ecld.getCase_ex_desc().substring(1,ecld.getCase_ex_desc().length()-1).split(",");
				if(tempa.length>1){//是多组数据
					for(String tm:tempa){
						tempArray=tm.substring(1,tm.length()-1).split("-");
						if(Integer.parseInt(tempArray[0].trim()) > 0 && Integer.parseInt(tempArray[0].trim()) < 5 ){ //1~4的类型才是所需要的类型（1-飞机，2-装备，3-道具，4-装扮）
							esd.setSell(esd.getSell()+Integer.parseInt(tempArray[2])*Integer.parseInt(tempArray[3]));
						}
					}
				}else{
					tempArray=ecld.getCase_ex_desc().substring(2,ecld.getCase_ex_desc().length()-2).split("-");
					String temp1=tempArray[0];
					if(!temp1.equals("null")){
						tpmint=Integer.parseInt(tempArray[0]);	
						if(Integer.parseInt(tempArray[0].trim()) > 0 && Integer.parseInt(tempArray[0].trim()) < 5 ){ //1~4的类型才是所需要的类型（1-飞机，2-装备，3-道具，4-装扮）
							esd.setSell(esd.getSell()+Integer.parseInt(tempArray[2])*Integer.parseInt(tempArray[3]));
						}
				}
				
			}
		}
			lesd.add(esd);//服务器的消耗
		}
		
		Map<String,Object> parm=new HashMap<String,Object>();
		List<EntityOrderInfoDetail> leoid=getOrderInfoService().getAllInfoOrderInfo(parm);//所有的充值记录
		//先算出来这个服务器一共有多少钱。
		
		if(money==0){
			for(EntityOrderInfoDetail eoid:leoid){
				money+=eoid.getPoint();
			}
		}
		
		//便利这些购买数据里面有几个天数
		ArrayList<String> tmp=this.getCaseLogService().getAllDateListSell(lesd);
		//将充值记录便利成已天为单位的集合数据
		//ArrayList<String> payDays=this.getCaseLogService().getAllDateListPay(leoid);
		//List<EntityOrderInfoDetail> newEoid=new ArrayList<EntityOrderInfoDetail>();
	
//			for(int i=0;i<leoid.size();i+=2){
//				if(leoid.get(i).getDataTime().substring(0,10).equals(leoid.get(i+1).getDataTime().substring(0,10))){
//					leoid.get(i).setPoint(leoid.get(i).getPoint()+leoid.get(i+1).getPoint());
//				}
//			}
//			
			
			/* 新建一个数组来保存当前充值的用户 */
		
		for(String temp:tmp){
			for(EntitySellDetail esd : lesd){
				if(esd.getDatetime().equals(temp)){
					//查看充值表里面有没有当天的记录
					for(EntityOrderInfoDetail eoid:leoid){
							if(eoid.getDataTime().substring(0,10).equals(temp)){
								ArrayList<String> payuser = new ArrayList<String>();
							esd.setPayMoney(esd.getPayMoney()+eoid.getPoint());//获取当天的充值数，默认0
							if(payuser.size()==0){
								  payuser.add(eoid.getMember_username());
								}else{
									for(String username:payuser){
										if(!username.equals(eoid.getMember_username())){
											payuser.add(eoid.getMember_username());
										}
									}
								}
							
							
							esd.setPayCount(esd.getPayCount()+1);
							esd.setPayCountpeople(payuser.size());
							//payuser.clear();
						}
					}
				}
				money=money-esd.getSell();
				esd.setServerMoney(money);//当前服务器的金币数
				esd.setServerCountPeople(this.getCaseLogService().noRepleAll(getEcld_list(),69).size());
			}
			
		}
		request.setAttribute("results", lesd);
		return "succ";
	}
	
	// 获取在线人数
	public String checkOnline(){
		//List<EntityGameChatRoleDetail> legcrd = new ArrayList<EntityGameChatRoleDetail>();
		List<RoleSiteInfoDetail> lgrsid = new ArrayList<RoleSiteInfoDetail>();
		//legcrd=this.getGameChatRoleService().getAllInfo();
		RoleSiteInfoDaoImpl rsidi = new RoleSiteInfoDaoImpl();
		Map<String,Object> map =new HashMap<String,Object>();
		lgrsid=rsidi.getRoleSiteInfoDetail(map);
		EntityGameOnlineDetail egod = new EntityGameOnlineDetail();
		egod.setOnlineNum(lgrsid.size());
		for(RoleSiteInfoDetail rsidis:lgrsid ){
			//System.out.print("-"+egcrd.getBattleTroop()+"-");
			switch(rsidis.getRole_site()){
			case 4:
				egod.setRoomNum(egod.getRoomNum()+1);break;
			case 5:
				egod.setBattleNum(egod.getBattleNum()+1);break;
			case 0:
				egod.setChageArea(egod.getChageArea()+1);break;
			}
		}
		request.setAttribute("results", egod);
		return "succ";
	}
	
	//获取新手任务的好数据采集
	
	/**
	 * 如果要变成多日的。就在弄一个 detail 加个list 就ok 了。
	 */
	public String checkTask_old(){
		List<EntityCaseLogDetail> liste = getEcld_list();
		List<EntityCaseLogDetail> date_list=this.getCaseLogService().getAllDateList(liste);
		String createTime1=this.request.getParameter("stime1");
		String createTime2=this.request.getParameter("stime2");
		String _datetime="";
		List<EntityCaseLogDetail> leclds=new ArrayList<EntityCaseLogDetail>();
		EntityNoviceTaskDetail entd= new EntityNoviceTaskDetail();
		if(createTime1!=null || createTime2!=null ){//2个时间只要有任意一个存在就要为另外一个创建初始值
			if(createTime1==null || createTime1.equals("")){
				createTime1 = "1970-01-01";//意义你懂的
			}
			if(createTime2==null || createTime2.equals("")){
				//获取当前的时间作为 time2的补全时间
				SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
				createTime2 = tempDate.format(new java.util.Date());
			}
			// 首先便利出时间区间里面的信息的天数的数据
			List<EntityCaseLogDetail> lecld=getCaseLogService().getAllDateListTimeToTime(liste,createTime1,createTime2);
			date_list=this.getCaseLogService().getAllDateList(lecld);
			}
		List<EntityNoviceTaskDetail> lecndd = new ArrayList<EntityNoviceTaskDetail>();
		for(EntityCaseLogDetail _date_list:date_list){
			_datetime=_date_list.getCase_time().toString().substring(0, 10);
			leclds=this.getCaseLogService().checkTask(liste, _datetime);
			for(EntityCaseLogDetail ed:leclds){
				switch(ed.getCase_id()){
				case 107:entd.setNoviceTask1(entd.getNoviceTask1()+1);break;
				case 108:entd.setNoviceTask2(entd.getNoviceTask2()+1);break;
				case 109:entd.setNoviceTask3(entd.getNoviceTask3()+1);break;
				case 110:entd.setNoviceTask4(entd.getNoviceTask4()+1);break;
				case 111:entd.setNoviceTask5(entd.getNoviceTask5()+1);break;
				case 112:entd.setNoviceTask6(entd.getNoviceTask6()+1);break;
				case 113:entd.setNoviceTask7(entd.getNoviceTask7()+1);break;
				}
			}
		}
		request.setAttribute("results", lecndd);
			return "succ";
	}
	
	/**
	 * 采集新手任务数据
	 */
	public String checkTask(){
		List<EntityCaseLogDetail> liste = getEcld_list();
		List<EntityCaseLogDetail> date_list=this.getCaseLogService().getAllDateList(liste);
		Map<String,Object> parm = new HashMap<String,Object>();
		List<GameTaskFormalDetail> legtfd = this.gameTaskFormalService().getAllInfo(parm);
		Map<String,Integer> result = new HashMap<String,Integer>();
		String createTime1=this.request.getParameter("stime1");
		String createTime2=this.request.getParameter("stime2");
		String _datetime="";
		List<EntityCaseLogDetail> leclds=new ArrayList<EntityCaseLogDetail>();
		EntityNoviceTaskDetail entd= new EntityNoviceTaskDetail();
		boolean flag=true;
		if(createTime1!=null || createTime2!=null ){//2个时间只要有任意一个存在就要为另外一个创建初始值
			if(createTime1==null || createTime1.equals("")){
				createTime1 = "1970-01-01";//意义你懂的
			}
			if(createTime2==null || createTime2.equals("")){
				//获取当前的时间作为 time2的补全时间
				SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
				createTime2 = tempDate.format(new java.util.Date());
			}
			// 首先便利出时间区间里面的信息的天数的数据
			List<EntityCaseLogDetail> lecld=getCaseLogService().getAllDateListTimeToTime(liste,createTime1,createTime2);
			date_list=this.getCaseLogService().getAllDateList(lecld);
			}
		List<EntityNoviceTaskDetail> lecndd = new ArrayList<EntityNoviceTaskDetail>();
		for(EntityCaseLogDetail _date_list:date_list){
			_datetime=_date_list.getCase_time().toString().substring(0, 10);
			leclds=this.getCaseLogService().repleAll(liste, 107, _datetime);
			for(EntityCaseLogDetail ed:leclds){
				flag=true;
				for(GameTaskFormalDetail tempArr:legtfd){
				int a=Integer.parseInt(ed.getCase_ex_desc());
				int b=tempArr.getId();
				if(a==b){//判断是否是这个技能
					//System.out.print(a+"-"+b);
					if(result.size()==0){
						result.put(tempArr.getTaskName(), 1);break;
					}else{
						Iterator<Map.Entry<String,Integer>> it = result.entrySet().iterator();
						boolean flag1=true;
						while(it.hasNext()){
							flag1=true;
							Map.Entry entry=it.next();
							if(entry.getKey().equals(tempArr.getTaskName())){
								result.put(tempArr.getTaskName(), result.get(tempArr.getTaskName())+1);
								flag1=false;flag=false;break;
							}
						}
						if(flag1){//发现新数据进行添加处理
							result.put(tempArr.getTaskName(), 1);flag=false;
						}
					}
				}
				if(flag==false){break;}
			}
			}
			}
		request.setAttribute("results", result);
		return "succ";
		}
		
	
	
	/**
	 * 战斗场次统计
	 * 
	 */
	public String checkBattle(){
		List<EntityCaseLogDetail> liste = getEcld_list();
		List<EntityCaseLogDetail> date_list=this.getCaseLogService().getAllDateList(liste);
		String createTime1=this.request.getParameter("stime1");
		String createTime2=this.request.getParameter("stime2");
		String _datetime="";
		List<EntityCaseLogDetail> leclds=new ArrayList<EntityCaseLogDetail>();
		List<EntityCheckBattleDetail> lecbd = new ArrayList<EntityCheckBattleDetail>();
		if(createTime1!=null || createTime2!=null ){//2个时间只要有任意一个存在就要为另外一个创建初始值
			if(createTime1==null || createTime1.equals("")){
				createTime1 = "1970-01-01";//意义你懂的
			}
			if(createTime2==null || createTime2.equals("")){
				//获取当前的时间作为 time2的补全时间
				SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
				createTime2 = tempDate.format(new java.util.Date());
			}
			// 首先便利出时间区间里面的信息的天数的数据
			List<EntityCaseLogDetail> lecld=getCaseLogService().getAllDateListTimeToTime(liste,createTime1,createTime2);
			date_list=this.getCaseLogService().getAllDateList(lecld);
			}
		for(EntityCaseLogDetail _date_list:date_list){
			_datetime=_date_list.getCase_time().toString().substring(0, 10);
			leclds=this.getCaseLogService().checkBattle(liste, _datetime);
			for(EntityCaseLogDetail ed:leclds){
				EntityCheckBattleDetail ecbd= new EntityCheckBattleDetail();
				//房间号，房间类型，战斗类型，开始时间，结束时间，玩家总数，地图编号，a队伍，b队伍 获胜队伍。
				String[] tempArray=ed.getCase_ex_desc().toString().split("-");
				if(tempArray.length>=10){
				ecbd.setRoomNum(Integer.parseInt(tempArray[0]));
				ecbd.setRoomType(Integer.parseInt(tempArray[1]));
				ecbd.setBattleType(Integer.parseInt(tempArray[2]));
				ecbd.setStartTime(Long.parseLong(tempArray[3]));
				ecbd.setEndTime(Long.parseLong(tempArray[4]));
				ecbd.setPlayerCount(Integer.parseInt(tempArray[5]));
				if(tempArray[6].equals("null")){
					ecbd.setMapId(0);
				}else{
					ecbd.setMapId(Integer.parseInt(tempArray[6]));
				}
				ecbd.setTeamA(tempArray[7].substring(1,tempArray[7].length()-1));
				ecbd.setTeamB(tempArray[8].substring(1,tempArray[8].length()-1));
				ecbd.setWinTeam(tempArray[9]); 
				lecbd.add(ecbd);
				}
			}
		}
		String execl=request.getParameter("execl");
		if(execl!=null){
			//说明需要生成xml
			String title="房间号,房间类型,战斗时间,玩家总数,地图编号,A队伍,B队伍,获取队伍";
			Map<String,Object> resultMap = new HashMap<String,Object>();
			resultMap.put("mapresult", lecbd);
			String common="checkBattle";
			this.createExecl( common, title,resultMap,path+"checkBattle.xls");
		}
		request.setAttribute("results", lecbd);
		return "succ";
	}
	
	/**
	 * 金币道具使用量跟踪
	 */
	public String checkGoldSell(){

		List<EntityCaseLogDetail> liste = getEcld_list();
		List<EntityCaseLogDetail> date_list=this.getCaseLogService().getAllDateList(liste);
		String createTime1=this.request.getParameter("stime1");
		String createTime2=this.request.getParameter("stime2");
		String _datetime="";
		List<EntityCaseLogDetail> leclds=new ArrayList<EntityCaseLogDetail>();
		List<EntityCheckGoldItemDetail> lecgid = new ArrayList<EntityCheckGoldItemDetail>();
		long serverMoney=0;
		if(createTime1!=null || createTime2!=null ){//2个时间只要有任意一个存在就要为另外一个创建初始值
			if(createTime1==null || createTime1.equals("")){
				createTime1 = "1970-01-01";//意义你懂的
			}
			if(createTime2==null || createTime2.equals("")){
				//获取当前的时间作为 time2的补全时间
				SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
				createTime2 = tempDate.format(new java.util.Date());
			}
			// 首先便利出时间区间里面的信息的天数的数据
			List<EntityCaseLogDetail> lecld=getCaseLogService().getAllDateListTimeToTime(liste,createTime1,createTime2);
			date_list=this.getCaseLogService().getAllDateList(lecld);
			}
		for(EntityCaseLogDetail _date_list:date_list){
			_datetime=_date_list.getCase_time().toString().substring(0, 10);
			
			leclds=this.getCaseLogService().repleAll(liste, 121, _datetime);
			EntityCheckGoldItemDetail ecgid=new EntityCheckGoldItemDetail();
			for(EntityCaseLogDetail ecld:leclds){
				String [] tempArray=ecld.getCase_ex_desc().split("-");
				if(Integer.parseInt(tempArray[0])>0 && Integer.parseInt(tempArray[0])<8){
					if(tempArray.length>1){
					switch(Integer.parseInt(tempArray[0])){
					case 1:ecgid.setGoldType(ecgid.getGoldType()+Long.parseLong(tempArray[1]));break;
					case 2:ecgid.setGoldType2(ecgid.getGoldType2()+Long.parseLong(tempArray[1]));break;
					case 3:ecgid.setGoldType3(ecgid.getGoldType3()+Long.parseLong(tempArray[1]));break;
					case 4:ecgid.setGoldType4(ecgid.getGoldType4()+Long.parseLong(tempArray[1]));break;
					case 5:ecgid.setGoldType5(ecgid.getGoldType5()+Long.parseLong(tempArray[1]));break;
					case 6:ecgid.setGoldType6(ecgid.getGoldType6()+Long.parseLong(tempArray[1]));break;
					case 7:ecgid.setGoldType7(ecgid.getGoldType7()+Long.parseLong(tempArray[1]));break;
					}
				}
				}
				
				
				ecgid.setDateTime(_datetime);
			}
			leclds=this.getCaseLogService().repleAll(liste, 72, _datetime);//获取金币购买的道具价格。
			for(EntityCaseLogDetail ecld:leclds){
				String [] tempArray=ecld.getCase_ex_desc().substring(2,ecld.getCase_ex_desc().length()-2).split("-");
				if(Integer.parseInt(tempArray[3])>0 && tempArray.length>0){
					ecgid.setGoldType6(ecgid.getGoldType6()+Long.parseLong(tempArray[3])*Long.parseLong(tempArray[2]));
				}
			}
			leclds=this.getCaseLogService().repleAll(liste, 122, _datetime);//获取产出金币的数据。
			for(EntityCaseLogDetail ecld:leclds){
				if(Integer.parseInt(ecld.getCase_ex_desc())>0){
					ecgid.setTadayGold(ecgid.getTadayGold()+Long.parseLong(ecld.getCase_ex_desc()));
				}
			}
			//获取服务器当前的金币总数玩家的金币数
			if(serverMoney==0){
				serverMoney=getGameRoleService().getSum();
			}
			ecgid.setServerGold(serverMoney);
			lecgid.add(ecgid);
		}
		request.setAttribute("results", lecgid);
		return "succ";
	}
	
	/**
	 * 查看当前每个区的在线人数
	 * @return 
	 */
	public String checkArea_old(){
		List<EntityGameChatRoleDetail> legcrd = new ArrayList<EntityGameChatRoleDetail>();
		List<EntityAreaCountDetail> leacd = new ArrayList<EntityAreaCountDetail>();
		legcrd=this.getGameChatRoleService().getAreaInfo();
		int areaNum=0;//当前开到多少区了。
		for(EntityGameChatRoleDetail egcrd:legcrd ){
			EntityAreaCountDetail eacd = new EntityAreaCountDetail();
			if(areaNum==0){
				areaNum=egcrd.getRoomArea();
			}
			eacd.setAreaInfo(egcrd.getRoomArea());
			leacd.add(eacd);
		}
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("list", leacd);
		result.put("areaNum", areaNum);
		request.setAttribute("results", result);
		
		return "succ";
	}
	/**
	 * 获取当前的大区信息
	 * @return
	 */
	public String checkArea(){
		int areaNum=0;
		Map<String,Object> parmas =new HashMap<String,Object>();
		RoleSiteInfoDaoImpl rsidi= new RoleSiteInfoDaoImpl();
		List<RoleSiteInfoDetail> lrcsd=rsidi.getRoleSiteInfoDetail(parmas);
		//System.out.println("大区结合的条数");
		for(RoleSiteInfoDetail rsid:lrcsd){
			areaNum=rsid.getRoom_area();break;
		}
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("list", lrcsd);
		result.put("areaNum", areaNum);
		request.setAttribute("results", result);
		
		return "succ";
	}
	
	
	/**
	 * 查看房间里面大局和技能的使用情况
	 */
	public String checkUseSkillAndItem_old(){
		List<EntityCaseLogDetail> liste = getEcld_list();
		List<EntityCaseLogDetail> date_list=this.getCaseLogService().getAllDateList(liste);
		String createTime1=this.request.getParameter("stime1");
		String createTime2=this.request.getParameter("stime2");
		String _datetime="";
		List<EntityCaseLogDetail> leclds=new ArrayList<EntityCaseLogDetail>();
		List<EntityBattleItemDetail> lebid = new ArrayList<EntityBattleItemDetail>();
		boolean flag=true;
		if(createTime1!=null || createTime2!=null ){//2个时间只要有任意一个存在就要为另外一个创建初始值
			if(createTime1==null || createTime1.equals("")){
				createTime1 = "1970-01-01";//意义你懂的
			}
			if(createTime2==null || createTime2.equals("")){
				//获取当前的时间作为 time2的补全时间
				SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
				createTime2 = tempDate.format(new java.util.Date());
			}
			// 首先便利出时间区间里面的信息的天数的数据
				List<EntityCaseLogDetail> lecld=getCaseLogService().getAllDateListTimeToTime(liste,createTime1,createTime2);
				date_list=this.getCaseLogService().getAllDateList(lecld);
			}
		for(EntityCaseLogDetail _date_list:date_list){
			flag=true;
			_datetime=_date_list.getCase_time().toString().substring(0, 10);
			leclds=this.getCaseLogService().repleAll(liste, 123, _datetime);
			for(EntityCaseLogDetail tempecld:leclds){
				EntityBattleItemDetail ebid = new EntityBattleItemDetail();
				String [] tempArr = tempecld.getCase_ex_desc().split("-");
				if(lebid.size()==0){
					ebid.setDateTiem(_datetime);
					ebid.setItemCounts(1);
					ebid.setRoomId(Integer.parseInt(tempArr[0]));
					ebid.setItemId(tempArr[1]);
					lebid.add(ebid);
				}else{
					//便利已经有的集合里面是否有房间相同的 道具
					for(EntityBattleItemDetail ebid2 : lebid){
						if(ebid2.getRoomId()==Integer.parseInt(tempArr[0])){//如果房间号和结果集的房间号是一个的那就说明是一个房间里面的使用道具
							ebid2.setItemCounts(ebid2.getItemCounts()+1);
							ebid2.setItemId(ebid2.getItemId()+"-"+tempArr[1]);
							flag=false;
						}
					}
					if(flag){
						ebid.setDateTiem(_datetime);
						ebid.setItemCounts(1);
						ebid.setRoomId(Integer.parseInt(tempArr[0]));
						ebid.setItemId(tempArr[1]);
						lebid.add(ebid);
					}
				}
				
			}
		}
		request.setAttribute("results",lebid);
		return "succ";
	}
	
	/**
	 * 在战斗使用技能的数据采集
	 * @return
	 */
	public String checkBattleSkill(){
		List<EntityGameSkillDetail> tempgamesill=this.getGameSkillService().getAllInfo();
		List<EntityCaseLogDetail> liste = getEcld_list();
		List<EntityCaseLogDetail> date_list=this.getCaseLogService().getAllDateList(liste);
		String createTime1=this.request.getParameter("stime1");
		String createTime2=this.request.getParameter("stime2");
		String _datetime="";
		Map<String,Integer> result = new HashMap<String,Integer>();
		List<EntityCaseLogDetail> leclds=new ArrayList<EntityCaseLogDetail>();
		List<EntityBattleSkillDetail> lebsd = new ArrayList<EntityBattleSkillDetail>();
		boolean flag=true;
		if(createTime1!=null || createTime2!=null ){//2个时间只要有任意一个存在就要为另外一个创建初始值
			if(createTime1==null || createTime1.equals("")){
				createTime1 = "1970-01-01";//意义你懂的
			}
			if(createTime2==null || createTime2.equals("")){
				//获取当前的时间作为 time2的补全时间
				SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
				createTime2 = tempDate.format(new java.util.Date());
			}
			// 首先便利出时间区间里面的信息的天数的数据
				List<EntityCaseLogDetail> lecld=getCaseLogService().getAllDateListTimeToTime(liste,createTime1,createTime2);
				date_list=this.getCaseLogService().getAllDateList(lecld);
			}
		for(EntityCaseLogDetail _date_list:date_list){
			flag=true;
			_datetime=_date_list.getCase_time().toString().substring(0, 10);
			leclds=this.getCaseLogService().repleAll(liste, 124, _datetime);
//			for(EntityCaseLogDetail tempecld:leclds){
//				EntityBattleSkillDetail ebsd = new EntityBattleSkillDetail();
//				String [] tempArr = tempecld.getCase_ex_desc().split("-");
//				if(lebsd.size()==0){
//					ebsd.setDateTiem(_datetime);
//					ebsd.setSkillCounts(1);
//					ebsd.setRoomId(Integer.parseInt(tempArr[0]));
//					ebsd.setSkillId(tempArr[1]);
//					lebsd.add(ebsd);
//				}else{
//					//便利已经有的集合里面是否有房间相同的 道具
//					for(EntityBattleSkillDetail ebsd2 : lebsd){
//						
//						if(ebsd2.getRoomId()==Integer.parseInt(tempArr[0])){//如果房间号和结果集的房间号是一个的那就说明是一个房间里面的使用道具
//							ebsd2.setSkillCounts(ebsd2.getSkillCounts()+1);
//							ebsd2.setSkillId(ebsd2.getSkillId()+"-"+tempArr[1]);	
//							flag=false;
//						}
//					}
//					if(flag){
//						ebsd.setDateTiem(_datetime);
//						ebsd.setSkillCounts(1);
//						ebsd.setRoomId(Integer.parseInt(tempArr[0]));
//						ebsd.setSkillId(tempArr[1]);
//						lebsd.add(ebsd);
//					}
//				}
//			}
			
			for(EntityCaseLogDetail tempecld:leclds){
				String [] tempArr = tempecld.getCase_ex_desc().split("-");
				flag=true;
				for(EntityGameSkillDetail egsd : tempgamesill){
					int a=Integer.parseInt(tempArr[1]);
					int b=Integer.parseInt(egsd.getSkillCode());
					if(a==b){//判断是否是这个技能
						//egsd.setUseCount(egsd.getUseCount()+1);break;
						if(result.size()==0){
							result.put(egsd.getSkillName(), 1);break;
						}else{
							Iterator<Map.Entry<String,Integer>> it = result.entrySet().iterator();
							boolean flag1=true;
							while(it.hasNext()){
								flag1=true;
								Map.Entry entry=it.next();
								if(entry.getKey().equals(egsd.getSkillName())){
									result.put(egsd.getSkillName(), result.get(egsd.getSkillName())+1);
									flag1=false;flag=false;break;
								}
							}
							if(flag1){//发现新数据进行添加处理
								result.put(egsd.getSkillName(), 1);flag=false;
							}
						}
					}
					if(flag==false){break;}
				}
			}
		}
		//request.setAttribute("results",lebsd);
		request.setAttribute("results", result);
		return "succ";
	}
	
	/**
	 * 在战斗使用技能的数据采集
	 * @return
	 */
	public String checkUseSkillAndItem(){
		Map<String,Object> parm = new HashMap<String,Object>();
		List<EntityGameItemsDetail> tempGameItems=this.getGameItemService().getAllInfo(parm);
		List<EntityCaseLogDetail> liste = getEcld_list();
		List<EntityCaseLogDetail> date_list=this.getCaseLogService().getAllDateList(liste);
		String createTime1=this.request.getParameter("stime1");
		String createTime2=this.request.getParameter("stime2");
		String _datetime="";
		Map<String,Integer> result = new HashMap<String,Integer>();
		List<EntityCaseLogDetail> leclds=new ArrayList<EntityCaseLogDetail>();
		boolean flag=true;
		if(createTime1!=null || createTime2!=null ){//2个时间只要有任意一个存在就要为另外一个创建初始值
			if(createTime1==null || createTime1.equals("")){
				createTime1 = "1970-01-01";//意义你懂的
			}
			if(createTime2==null || createTime2.equals("")){
				//获取当前的时间作为 time2的补全时间
				SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
				createTime2 = tempDate.format(new java.util.Date());
			}
			// 首先便利出时间区间里面的信息的天数的数据
				List<EntityCaseLogDetail> lecld=getCaseLogService().getAllDateListTimeToTime(liste,createTime1,createTime2);
				date_list=this.getCaseLogService().getAllDateList(lecld);
			}
		for(EntityCaseLogDetail _date_list:date_list){
			flag=true;
			_datetime=_date_list.getCase_time().toString().substring(0, 10);
			leclds=this.getCaseLogService().repleAll(liste, 123, _datetime);
	
			for(EntityCaseLogDetail tempecld:leclds){
				String [] tempArr = tempecld.getCase_ex_desc().split("-");
				flag=true;
				for(EntityGameItemsDetail egid : tempGameItems){
					int a=Integer.parseInt(tempArr[1]);
					int b=egid.getId();
					if(a==b){//判断是否是这个技能
						
						if(result.size()==0){
							result.put(egid.getItemName(), 1);break;
						}else{
							Iterator<Map.Entry<String,Integer>> it = result.entrySet().iterator();
							boolean flag1=true;
							while(it.hasNext()){
								flag1=true;
								Map.Entry entry=it.next();
								if(entry.getKey().equals(egid.getItemName())){
									result.put(egid.getItemName(), result.get(egid.getItemName())+1);
									flag1=false;flag=false;break;
								}
							}
							if(flag1){//发现新数据进行添加处理
								result.put(egid.getItemName(), 1);flag=false;
							}
						}
					}
					if(flag==false){break;}
				}
			}
		}
		request.setAttribute("results", result);
		return "succ";
	}
	/**
	 * 动态生成xml
	 * @param title
	 * @param fileTag
	 * @param lecld
	 * @return
	 */
	public String createExecl(String command,String titleValue,Map<String,Object> mapresult,String filePath){
		DecimalFormat df=new DecimalFormat("#.00");
		//  title 的实例   
		//String[] title = {"编号","产品名称","产品价格","产品数量","生产日期","产地","是否出口"};
			String tagName=command;
			String[] title=titleValue.split(",");//标头数据
	        try {   
	        	 // 获得开始时间   
	            long start = System.currentTimeMillis();   
	           
	           
	            // 创建Excel工作薄   
	            WritableWorkbook wwb;   
	            // 新建立一个jxl文件,即在C盘下生成test.xls   
	            OutputStream os = new FileOutputStream(filePath);   
	            wwb=Workbook.createWorkbook(os);    
	            // 添加第一个工作表并设置第一个Sheet的名字   
	            WritableSheet sheet = wwb.createSheet(tagName, 0);   
	            Label label;   
	            for(int i=0;i<title.length;i++){   
	                // Label(x,y,z)其中x代表单元格的第x+1列，第y+1行, 单元格的内容是y   
	                // 在Label对象的子对象中指明单元格的位置和内容   
	                label = new Label(i,0,title[i]);   
	                // 将定义好的单元格添加到工作表中   
	                sheet.addCell(label);   
	            }   
	            // 下面是填充数据   
	            /*   
	             * 保存数字到单元格，需要使用jxl.write.Number  
	             * 必须使用其完整路径，否则会出现错误  
	             * */  
	            // 填充信息 
	            if(tagName.equals("checkBattle")){//战斗状况的xml生成。
	            	List<EntityCheckBattleDetail> lecbd=(List<EntityCheckBattleDetail>)mapresult.get("mapresult");
	            	for(int i=1;i<=lecbd.size();i++){
	            		EntityCheckBattleDetail ecbd=lecbd.get(i-1);
	            			int j=0;
	            			label = new Label(j,i,ecbd.getRoomNum()+"");
	            			sheet.addCell(label);j++;
	            			switch(ecbd.getBattleType()){
	            				case 1:label = new Label(j,i,"自由组队");break;
	            				case 2:label = new Label(j,i,"撮合");break;
	            				case 3:label = new Label(j,i,"pve");break;
	            			}
	            			sheet.addCell(label);j++;
	            			label = new Label(j,i,(ecbd.getEndTime()-ecbd.getStartTime())/1000/60+"分钟");
		            		sheet.addCell(label);j++;
		            		label = new Label(j,i,ecbd.getPlayerCount()+"");
		            		sheet.addCell(label);j++;
		            		label = new Label(j,i,ecbd.getMapId()+"");
		            		sheet.addCell(label);j++;
		            		label = new Label(j,i,ecbd.getTeamA()+"");
		            		sheet.addCell(label);j++;
		            		if(ecbd.getTeamB().equals("")){
		            			label = new Label(j,i,"机器人");
		            			sheet.addCell(label);
		            		}else{
		            			label = new Label(j,i,ecbd.getTeamB());
		            			sheet.addCell(label);
		            		}j++;
		            		switch(Integer.parseInt(ecbd.getWinTeam())){
		        			case 1:label = new Label(j,i,"A");sheet.addCell(label);break;
		        			case 2:label = new Label(j,i,"B");sheet.addCell(label);break;
		        		}
		            		
	            		}
	            	
				}else if(tagName.equals("checkfb")){//fb状况的xml生成
					List<EntityCheckFbDetail> lecfd=(List<EntityCheckFbDetail>)mapresult.get("mapresult");
					for(int i=1;i<=lecfd.size();i++){
						EntityCheckFbDetail ecfd=lecfd.get(i-1);
						int j=0;
						label = new Label(j,i,ecfd.getDatetime()+"");
            			sheet.addCell(label);j++;
            			label = new Label(j,i,ecfd.getFbnum()+"");
            			sheet.addCell(label);j++;
            			label = new Label(j,i,ecfd.getFbwin()+"");
            			sheet.addCell(label);j++;
            			label = new Label(j,i,ecfd.getFblost()+"");
            			sheet.addCell(label);j++;
            			if(ecfd.getFbnum()>ecfd.getFbwin()){
            				label = new Label(j,i,df.format(ecfd.getFbwin() / (float)ecfd.getFbnum()*100)+"%");
                			sheet.addCell(label);j++;
            			}
            			if(ecfd.getFbnum() > ecfd.getFblost()){
            				label = new Label(j,i,df.format(ecfd.getFblost() / (float)ecfd.getFbnum()*100)+"%");
                			sheet.addCell(label);j++;
            			}
	            	}
				}else if(tagName.equals("checkDay")){//一天为单位来统计数据
					List<EntityCheckDayDetail> lecdd=(List<EntityCheckDayDetail>)mapresult.get("mapresult");
					int regman=0;
					for(int i=1;i<=lecdd.size();i++){
						EntityCheckDayDetail ecdd= lecdd.get(i);
						regman+=ecdd.getRegMan();
						int j=0;
						label = new Label(j,i,ecdd.getDate());sheet.addCell(label);j++;
						label = new Label(j,i,ecdd.getRegNum()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecdd.getRegMan()+"");sheet.addCell(label);j++;
						if(ecdd.getRegMan()+ecdd.getRegNum()>0){
							label = new Label(j,i,df.format(ecdd.getRegMan()/(double)(ecdd.getRegNum())*100)+"%");sheet.addCell(label);j++;
						}
						label = new Label(j,i,ecdd.getUlt()+"");sheet.addCell(label);j++;
						if(ecdd.getUlt()>0){
							label = new Label(j,i,df.format(ecdd.getUlts()/(double)ecdd.getUlt()*100)+"%");sheet.addCell(label);j++;
						}
						label = new Label(j,i,ecdd.getMaxOnline()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecdd.getNoRepeatlogoin()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecdd.getPzwb()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecdd.getTygjmb()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecdd.getYxb()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecdd.getLjserver()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecdd.getLjltserver()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecdd.getJzmxsj()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecdd.getHqphb()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecdd.getHqghlb()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecdd.getHqdzdh()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecdd.getHqwjxx()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecdd.getJzcjrwjm()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecdd.getJazjm()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecdd.getJzxsbz()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecdd.getJzdtjm()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecdd.getJzfjjm()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecdd.getJzzdjm()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecdd.getJzadzy()+"");sheet.addCell(label);j++;
					}
					label = new Label(0,lecdd.size()+1,"新增玩家");sheet.addCell(label);
					label = new Label(1,lecdd.size()+1,regman+"");sheet.addCell(label);
				}else if(tagName.equals("checkNovice")){//测试新手引导的留存率
					List<EntityCheckNoviceDayDetail> lecdd=(List<EntityCheckNoviceDayDetail>)mapresult.get("mapresult");
					for(int i=1;i<=lecdd.size();i++){
						int j=0;
						EntityCheckNoviceDayDetail ecndd = lecdd.get(i-1);
						label = new Label(j,i,ecndd.getDate()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice1()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice2()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice3()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice4()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice5()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice6()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice7()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice8()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice9()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice10()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice11()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice12()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice13()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice14()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice15()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice16()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice17()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice18()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice19()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice20()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice21()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice22()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice23()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice24()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice25()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice26()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice27()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice28()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice29()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice30()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice31()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice32()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice33()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice34()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice35()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice36()+"");sheet.addCell(label);j++;
						label = new Label(j,i,ecndd.getEcnd().getNovice37()+"");sheet.addCell(label);j++;
						if(ecndd.getEcnd().getNovice1()>ecndd.getEcnd().getNovice37()){
							label = new Label(j,i,df.format(ecndd.getEcnd().getNovice37() / ecndd.getEcnd().getNovice1()*100));
							sheet.addCell(label);j++;
							}else{
								label = new Label(j,i,"0");sheet.addCell(label);j++;
							}
					}
				}else if(tagName.equals("checkItem")){//检查道具的销售数量
					List<EntityGameItemDetail> legid=(List<EntityGameItemDetail>)mapresult.get("mapresult");
					int rmbItem=0;
					int intensify=0;
					int synthesis=0;
					int synthesisitem=0;
					int rows=0;
					for(int i=1;i<=legid.size();i++){
						int j=0;
						rows=i;
						EntityGameItemDetail egid= legid.get(i-1);
						label = new Label(j,i,egid.getDate()+"");sheet.addCell(label);j++;
						label = new Label(j,i,egid.getRmbItem()+"");sheet.addCell(label);j++;
						label = new Label(j,i,egid.getIntensify()+"");sheet.addCell(label);j++;
						label = new Label(j,i,egid.getSynthesis()+"");sheet.addCell(label);j++;
						label = new Label(j,i,egid.getSynthesisItem()+"");sheet.addCell(label);j++;
					}
					int j=0;
					int i=0;
					label = new Label(j++,i++,"总计：");sheet.addCell(label);
					label = new Label(j++,i++,rmbItem+"");sheet.addCell(label);
					label = new Label(j++,i++,intensify+"");sheet.addCell(label);
					label = new Label(j++,i++,synthesis+"");sheet.addCell(label);
					label = new Label(j++,i++,synthesisitem+"");sheet.addCell(label);
				}
				
	            /*  
	             *   
	             * 定义公共字体格式  
	             * 通过获取一个字体的样式来作为模板  
	             * 首先通过web.getSheet(0)获得第一个sheet  
	             * 然后取得第一个sheet的第二列，第一行也就是"产品名称"的字体   
	             * */  
	            CellFormat cf = wwb.getSheet(0).getCell(1, 0).getCellFormat();   
	            WritableCellFormat wc = new WritableCellFormat();   
	            // 设置居中   
	            wc.setAlignment(Alignment.CENTRE);   
	            // 设置边框线   
	            wc.setBorder(Border.ALL, BorderLineStyle.THIN);   
	            // 设置单元格的背景颜色   
//	            wc.setBackground(jxl.format.Colour.RED);   
//	            label = new Label(1,5,"字体",wc);   
//	            sheet.addCell(label);   
	  
	            // 设置字体   
//	            jxl.write.WritableFont wfont = new jxl.write.WritableFont(WritableFont.createFont("隶书"),20);   
//	            WritableCellFormat font = new WritableCellFormat(wfont);   
//	            label = new Label(2,6,"隶书",font);   
//	            sheet.addCell(label);   
	               
	            // 写入数据   
	            wwb.write();   
	            // 关闭文件   
	            wwb.close();   
	            long end = System.currentTimeMillis();   
	            System.out.println("----完成该操作共用的时间是:"+(end-start)/1000);   
	        } catch (Exception e) {   
	            System.out.println("---出现异常---");   
	            e.printStackTrace();   
	        }
		return "null";
	}
	
	/**
	 * 创建新的礼包规则
	 * @return
	 */
	public String createGiftBagType(){
		String res = "succ";
		EntityGiftBagTypeInfoDetail egbti= new EntityGiftBagTypeInfoDetail();
		egbti.setGTI_NAME(giftBagTypeName);
		/**
		 * 先查看当前礼包类别是否在数据库已经存在，如果存在提示，如果是删除的就开启
		 */
		if(giftBagTypeName.length()==0) return "err";
		
		List<EntityGiftBagTypeInfoDetail>legbtid =this.getGiftBagTypeInfoService().findGiftBagTypeByName(egbti);
		if(legbtid.size()>0){//说明数据库存在此条数据
			EntityGiftBagTypeInfoDetail egbid = new EntityGiftBagTypeInfoDetail();
			egbid=legbtid.get(0);
			if(egbid.getFLAG()==1){//正在使用中的类别 
				return "reperno";
			}else{//曾经用过现在处于“删除”状态，update 将其更新为启用模式 flag = 1
				egbid.setFLAG(1);
				int rsnum=this.getGiftBagTypeInfoService().editGiftBagTypeByFlag(egbid);
				if(rsnum>0){
		    		return "succ";
		    	}else{
		    		return "err";
		    	}
			}
		}else{//数据库没有数据，为插入操作
		    legbtid=this.getGiftBagTypeInfoService().findGiftAll();
		    if(legbtid.size()==0){//一条数据都没有
		    	egbti.setID(1000);
		    }else{
		    egbti.setID(legbtid.get(0).getID()+1);
		    }
			egbti.setFLAG(1);
			this.getGiftBagTypeInfoService().AddGiftBagType(egbti);
		}
		return res;
	}
	/**
	 * 查询出所有的 礼包类别
	 * @return
	 */
    public String findGiftBagTypeInfoAll(){
    	List<EntityGiftBagTypeInfoDetail>legbtid =this.getGiftBagTypeInfoService().findGiftBagType();
    	request.setAttribute("rs", legbtid);
    	return "succ";
    }
    /**
     * 对礼包的类别的编辑操作
     * @return
     */
    public String editGiftBagTypeInfoAll(){
    	EntityGiftBagTypeInfoDetail egbti = new EntityGiftBagTypeInfoDetail();
    	try {
			giftBagTypeName=java.net.URLDecoder.decode(giftBagTypeName,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	egbti.setGTI_NAME(giftBagTypeName);
    	egbti.setID(emeID);
    	//判断下这个名字是不是已经被用掉了。
    	List<EntityGiftBagTypeInfoDetail> legbtid= this.getGiftBagTypeInfoService().findGiftBagTypeByName(egbti);
    	if(legbtid.size()>0){//有同样的数据
    		if(legbtid.get(0).getFLAG()==1){//正在使用中。
    			return "err";
    		}else{//将此屏蔽的信息更新回来update
    			EntityGiftBagTypeInfoDetail update_egbti = new EntityGiftBagTypeInfoDetail();
    			update_egbti.setID(legbtid.get(0).getID());
    			update_egbti.setFLAG(1);
    			int rsnum=this.getGiftBagTypeInfoService().editGiftBagTypeByFlag(update_egbti);
    			if(rsnum>0){//成功执行
    				return "succ";
    			}else{
    				return "err";
    			}
    		}
    	}else{
    	boolean rs=this.getGiftBagTypeInfoService().EditGiftBagType(egbti);
    	if(rs){
    		return "succ";
    	}else{
    	return "err";
    	}
    	}
    }
    
    /**
     * 删除已有的礼包类别信息
     * @return
     */
    public String delGiftBagTypeInfo(){
    	String rs="err";
    	EntityGiftBagTypeInfoDetail egbti = new EntityGiftBagTypeInfoDetail();
    	egbti.setID(this.emeID);
    	egbti.setFLAG(0);
    	int rsnum=this.getGiftBagTypeInfoService().editGiftBagTypeByFlag(egbti);
    	if(rsnum>0){
    		return "succ";
    	}else{
    		return "err";
    	}
    }

    /**
     * 添加礼包
     * @return
     */
    	public String addGiftBag(){
    		String rs="err";
    		EntityGameItemsDetail egids= new EntityGameItemsDetail();
    		String [] stringList=listName.split(",");
    		ArrayList <Map<String,Object>> resore= new ArrayList<Map<String,Object>>();
    		String giftNameInfo="";
    		System.out.println(listName);
    		for(String rs_string:stringList){
    			String [] infoString=rs_string.split("-");
    			Map<String,Object> _map= new HashMap<String,Object>();
    			_map.put("Itype", infoString[0]);
    			_map.put("Iid", infoString[2]);
    			_map.put("Inum", infoString[1]);
    			if(giftNameInfo==""){
    				giftNameInfo=infoString[3]+"x"+ infoString[1];
    			}else{
    				giftNameInfo+=","+infoString[3]+"x"+ infoString[1];
    			}
    			resore.add(_map);
    		}
    		
    		String valuesore=JSON.toJSONString(resore);
    		//List<Map<String,Object>> maps=(List<Map<String,Object>>)JSON.parse(valuesore);
    		List<EntityGameItemsDetail> legid=this.getGameItemService().findGameItemsById();
    		int taskid=0;
    		if(legid.get(0).getId()<6000){
    			egids.setId(6000);
    			taskid=6000;
    		}else{
    			egids.setId(legid.get(0).getId()+1);
    			taskid=legid.get(0).getId()+1;
    		}
    		egids.setItemType(Integer.parseInt(this.giftBagTypeName));
    		egids.setSnsConfParam(valuesore);
    		egids.setItemName(this.giftBagName);
    		if(Integer.parseInt(this.giftBagTypeName)==1001){
    			egids.setItemRes("item/icon/fightitem_098.swf");
    		}else if(Integer.parseInt(this.giftBagTypeName)==1000){
    			egids.setItemRes("item/icon/fightitem_098.swf");
    		}else{
    			egids.setItemRes("item/icon/fightitem_098.swf");
    		}
    		egids.setItemLevel(this.openLive);
    		egids.setItemProp(this.item_prop);
    		egids.setItem_name_gk(giftNameInfo);
    		
    		/**
    		 * 在外网没有对数据‘插入’的操作权限,使用接口长连接进行操作
    		 */
    		SendGiftAction sga = new SendGiftAction();
    		
    		
    		
    	//	sga.sendGiftBag(egids);

    		
    		
    		
    		
    		
    		
    		//    		this.getGameItemService().insertGameItemDetail(egids);
    		
    		//**  对人物不进行任何操作，任务匹配使用别的函数重新构造
//    		
//    		GameTaskFormalDetail gd_param = new GameTaskFormalDetail();
//    		//对任务进行操作
//    		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//    		
//    		this.setStime1(this.getStime1());
//    		this.setStime2(this.getStime2());//礼包的结束时间
//    		try {
//				gd_param.setTaskStartTime(format.parse(this.getStime1()));
//				gd_param.setTaskEndTime(format.parse(this.getStime2()));
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}//礼包的起始时间
//    		
//    		gd_param.setTaskName(this.giftBagName);//任务礼包的名字
//    		gd_param.setTaskDesc(item_prop);//任务礼包的说明
//    		gd_param.setTaskType(7);//任务礼包的类型 7
//    		gd_param.setTaskThingNum(1);//任务礼包的think num 1
//    		gd_param.setHypoType(65);//任务礼包的phoy_type 65
//    		gd_param.setTaskLevel(this.openLive);
//    		gd_param.setTaskBind(0);
//    		gd_param.setDetailDesc("1");
//    		legid=this.getGameItemService().findGameItemsById();
//    		Map<String,Object> maptf= new HashMap<String,Object>();
//    		maptf.put("id", legid.get(0).getId());
//    		maptf.put("type", 3);
//    		maptf.put("num", 1);
//    		List<Map<String,Object>>lmp=new ArrayList<Map<String,Object>>();
//    		lmp.add(maptf);
//    		gd_param.setTaskGiftIds(JSON.toJSONString(lmp));//礼包类型
//    		int ggtfid=this.getGameTaskFormalService().getGameTaskFormalsId();
//    		if(ggtfid>0){
//    			gd_param.setId(ggtfid+1);
//    		}else{
//    			gd_param.setId(10000);
//    		}
////   		gd_param.setId(10000+taskid);
//    		this.getGameTaskFormalService().addTaskFormal(gd_param);
//    		System.out.print(valuesore);
    		return rs;
    	}
    	
    	public String addTask(){
    		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    		String taskId=request.getParameter("taskId");
    		String taskName=request.getParameter("taskName");
    		String taskDesc=request.getParameter("taskDesc");
    		String setTaskLevel=request.getParameter("setTaskLevel");
    		String stime1=request.getParameter("stime1");
    		String stime2=request.getParameter("stime2");
    		GameTaskFormalDetail gd_param = new GameTaskFormalDetail();
    		//对任务进行操作
    		
    	
			gd_param.setTaskStartTime(stime1);
			gd_param.setTaskEndTime(stime2);
    		gd_param.setTaskName(taskName);//任务礼包的名字
    		gd_param.setTaskDesc(taskDesc);//任务礼包的说明
    		gd_param.setTaskType(7);//任务礼包的类型 7
    		gd_param.setTaskThingNum(1);//任务礼包的think num 1
    		gd_param.setHypoType(65);//任务礼包的phoy_type 65
    		gd_param.setTaskLevel(Integer.parseInt(setTaskLevel));
    		gd_param.setTaskBind(0);
    		gd_param.setDetailDesc("1");
    		int legid=Integer.parseInt(taskId);
    		
    		//** 将数据库中的信息直接拿出来 转换为 map 扔给lmp
    		
    		Map<String,Object> maptf= new HashMap<String,Object>();
    		maptf.put("id", legid);
    		maptf.put("type", 3);
    		maptf.put("num", 1);
    		List<Map<String,Object>>lmp=new ArrayList<Map<String,Object>>();
    		lmp.add(maptf);
    		gd_param.setTaskGiftIds(JSON.toJSONString(lmp));//礼包类型
    		int ggtfid=this.getGameTaskFormalService().getGameTaskFormalsId();
    		if(ggtfid>0){
    			gd_param.setId(ggtfid+1);
    		}else{
    			gd_param.setId(10000);
    		}
//   		gd_param.setId(10000+taskid);
    		this.getGameTaskFormalService().addTaskFormal(gd_param);
    	//	System.out.print(valuesore);
    		SendGiftAction sga= new SendGiftAction();
    		//sga.addGameTskFormal(gd_param);
    		
    		return "succ";
    	}

    	/**
    	 * 查询当前所有的类别信息
    	 * @return
    	 */
    	public String findGiftBagList(){
    		List<EntityGameItemsDetail> legid = new ArrayList<EntityGameItemsDetail>();
    		Map<String,Object>parm = new HashMap<String,Object>();
    		parm.put("item_type", 999);
    		legid=this.getGameItemService().findGameItemsGiftBag(parm);
    		/**
    		 * 查询当前的的礼包是不是已经指派成任务类型了。
    		 */
    		Map<String,Object> params = new HashMap<String,Object>();
    		params.put("taskType", 7);
    		GameTaskFormalServiceImpl gtfdi = new GameTaskFormalServiceImpl();
    		List<GameTaskFormalDetail> lgtfd=gtfdi.getAllInfo(params);
    		for(GameTaskFormalDetail gtfd:lgtfd){
    			for(EntityGameItemsDetail egid:legid){
    				List<Map<String,Object>> lmapP =new ArrayList<Map<String,Object>>();
    				lmapP=(List<Map<String,Object>>)JSON.parse(gtfd.getTaskGiftIds());
    				Map<String,Object> mapP= lmapP.get(0);
    				if(mapP.get("id")==egid.getId()){
    					egid.setTaskType(1);System.out.println(egid.getItemName());
    				}
    			}
    		}
    		request.setAttribute("rs_giftBagList", legid);
    		return "succ";
    	}
    	
    	/**
    	 * 删除所选的礼包
    	 * delGiftBagList
    	 */
    	public String delGiftBagList(){
    		int giftId=Integer.parseInt(request.getParameter("giftBagId")+"");
    		Map<String,Object> parm=new HashMap<String,Object>();
    		parm.put("id", giftId);
    		int rs=this.getGameItemService().delGiftBag(parm);
    		return "succ";
    	}
    		
    	public String delGiftTask(){
    		int giftId=Integer.parseInt(request.getParameter("giftaskId")+"");
    		Map<String,Object> parm=new HashMap<String,Object>();
    		parm.put("id", giftId);
    		parm.put("tasktype", 0);
    		//int rs=this.getGameItemService().delGiftBag(parm);
    		SendGiftAction sga= new SendGiftAction();
    	//	sga.delGameTaskFormal(parm);
    		return "succ";
    	}

	
}

