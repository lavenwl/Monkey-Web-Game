package com.stang.game.ffd.controller;

import java.io.FileOutputStream;
import java.io.OutputStream;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import com.stang.game.ffd.common.GameConstants;
import com.stang.game.ffd.common.StringUtil;
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
import com.stang.game.ffd.dao.impl.DubiousDataDaoImpl;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import com.stang.game.ffd.dao.impl.CaseInfoDaoImpl;
import com.stang.game.ffd.dao.impl.CaseLogDaoImpl;
import com.stang.game.ffd.dao.impl.CheckDayDbDaoImpl;
import com.stang.game.ffd.dao.impl.GameRoleDaoImpl;
import com.stang.game.ffd.dao.impl.GameSceneDaoImpl;
import com.stang.game.ffd.dao.impl.GameSkillDaoImpl;
import com.stang.game.ffd.dao.impl.MemberDaoImpl;
import com.stang.game.ffd.entity.detail.EntityBattleSkillDetail;
import com.stang.game.ffd.entity.detail.EntityCaseInfoDetail;
import com.stang.game.ffd.entity.detail.EntityCaseItmeDetail;
import com.stang.game.ffd.entity.detail.EntityCaseLogDetail;
import com.stang.game.ffd.entity.detail.EntityCheckBattleDetail;
import com.stang.game.ffd.entity.detail.EntityCheckBuildDetail;
import com.stang.game.ffd.entity.detail.EntityCheckDayDbDetail;
import com.stang.game.ffd.entity.detail.EntityCheckDayDetail;
import com.stang.game.ffd.entity.detail.EntityCheckFbDetail;
import com.stang.game.ffd.entity.detail.EntityCheckGoldItemDetail;
import com.stang.game.ffd.entity.detail.EntityCheckNoviceDayDetail;
import com.stang.game.ffd.entity.detail.EntityCheckNoviceDetail;
import com.stang.game.ffd.entity.detail.EntityCheckSellItemDetail;
import com.stang.game.ffd.entity.detail.EntityDubiousDataDetail;
import com.stang.game.ffd.entity.detail.EntityGameAvatarDetail;
import com.stang.game.ffd.entity.detail.EntityGameConsortiaDetail;
import com.stang.game.ffd.entity.detail.EntityGameEquipDetail;
import com.stang.game.ffd.entity.detail.EntityGameItemDetail;
import com.stang.game.ffd.entity.detail.EntityGameItemsDetail;
import com.stang.game.ffd.entity.detail.EntityGamePlaneDetail;
import com.stang.game.ffd.entity.detail.EntityGameRoleDetail;
import com.stang.game.ffd.entity.detail.EntityGameSkillDetail;
import com.stang.game.ffd.entity.detail.EntityItemAllDetail;
import com.stang.game.ffd.entity.detail.EntityNoviceTaskDetail;
import com.stang.game.ffd.entity.detail.EntityOrderInfoDetail;
import com.stang.game.ffd.entity.detail.EntityRightUserDetail;
import com.stang.game.ffd.entity.detail.EntitySellDetail;
import com.stang.game.ffd.entity.detail.GameSceneDetail;
import com.stang.game.ffd.entity.detail.GameTaskFormalDetail;
import com.stang.game.ffd.service.ICaseInfoService;
import com.stang.game.ffd.service.ICaseLogService;
import com.stang.game.ffd.service.IGameAvatarService;
import com.stang.game.ffd.service.IGameConsortiaService;
import com.stang.game.ffd.service.IGameEquipService;
import com.stang.game.ffd.service.IGameItemService;
import com.stang.game.ffd.service.IGamePlaneService;
import com.stang.game.ffd.service.IGameRoleService;
import com.stang.game.ffd.service.IGameSkillService;
import com.stang.game.ffd.service.IGameTaskFormalService;
import com.stang.game.ffd.service.IOrderInfoService;
import com.stang.game.ffd.service.impl.CaseInfoServiceImpl;
import com.stang.game.ffd.service.impl.CaseLogServiceImpl;
import com.stang.game.ffd.service.impl.GameAvatarServiceImpl;
import com.stang.game.ffd.service.impl.GameConsortialServiceImpl;
import com.stang.game.ffd.service.impl.GameEquipServiceImpl;
import com.stang.game.ffd.service.impl.GameItemServiceImpl;
import com.stang.game.ffd.service.impl.GamePlaneServiceImpl;
import com.stang.game.ffd.service.impl.GameRoleServiceImpl;
import com.stang.game.ffd.service.impl.GameSkillServiceImpl;
import com.stang.game.ffd.service.impl.GameTaskFormalServiceImpl;
import com.stang.game.ffd.service.impl.MemberServiceImpl;
import com.stang.game.ffd.service.impl.OrderInfoServiceImpl;
import com.stang.game.ffd.service.impl.RightUserServiceImpl;
import com.alibaba.fastjson.JSON;
/**
 * 数据采集模块
 * 
 * @author kang.gu 采用新架构对数据采集进行重新的编写操作。可以忽视掉 adminDataCollect 里面的数据采集的方法
 */
public class AdminCheckCase extends ActionSupport implements
		ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpSession session;
	private ICaseLogService caseLogService;
	private List<EntityCaseLogDetail> ecld_list;
	private IGameConsortiaService gameConsortialService;
	private String path = "c:\\";
	private ICaseInfoService caseInfoService;
	private IGameRoleService gameRoleService;
	private IGamePlaneService gamePlaneService;
	private IGameItemService gameItemService;
	private IGameAvatarService gameAvatarService;
	private IGameEquipService gameEquipService;
	private IGameSkillService gameSkillService;
	private IOrderInfoService orderInfoService;
	private IGameTaskFormalService gameTaskFormalService;
	private String listName;
	private List<Map<String,Object>> ecld_list_Novice;
	private List<Map<String,Object>> ecld_list_NoviceYesterDay;
	private String priceMax;
	private String priceMin;
	private String itemName;
	private int year;
	private int month;
	private int day;
	private int hour;
	private String str1;
	private String ppsUser;//pps的用户名
	int second=0;
	int WeekOfYear=0; 
	int minute=0;
	public static boolean isStartFlag = false;
public String  start(){
	if(isStartFlag){
		return "succ";
	}
	isStartFlag = true;
	System.out.println("task is go");
	GameConstants.task = new TimerTask(){
			public void run(){
				Calendar ca = Calendar.getInstance();
		    	 year = ca.get(Calendar.YEAR);//获取年份
		    	 month=ca.get(Calendar.MONTH)+1;//获取月份
		    	 day=ca.get(Calendar.DATE);//获取日
//		    int minute=ca.get(Calendar.MINUTE);//分
		      hour=ca.get(Calendar.HOUR_OF_DAY);//小时
		      second=ca.get(Calendar.SECOND);//秒
		      WeekOfYear = ca.get(Calendar.DAY_OF_WEEK);
				/**
				 * 判断当前的时间是不是 凌晨2点，如果是2点~5点之间开始备份前一天数据
				 * 此段时间玩家相对来说比较少。
				 */
		      	
//				Date now = new Date();
//				DateFormat d1 = DateFormat.getDateInstance(); //默认语言（汉语）下的默认风格（MEDIUM风格，比如：2008-6-16 20:54:53）
//				String strrs = d1.format(now);
		      	String strrs=year+"-"+month+"-"+day;
				//System.out.print("++++"+strrs+"+++++");
				if(strrs.length()<10){
				 System.out.print("str 长度"+strrs.length());
				 String strArr[] = strrs.split("-");
				  str1="";
				 for(String tstr:strArr){
					 if(tstr.length()<2){
						 tstr="0"+tstr;
					 }
					 str1+=tstr+"-";
				 }
				}
				str1=str1.substring(0,10);
				//System.out.println("yesterDay time start "+str1+"hour"+hour);
				if(hour > 2 && hour < 7){
					
					//** 玩家登陆数据
					//System.out.println("time succ "+str1);
					checkForDayB(str1);
					//System.out.println("checkForDayB start success");
					//acc.testpublic();
					//**  新手数据相应比较快。。。所以可以都2天。按照原先的逻辑 运行 主方法即可。
					checkNoviceYesterDay(str1);//System.out.println("checkNoviceForDay start success");
					//** 模块加载数据
					check_DayYesterday(str1);//System.out.println("check_DayForDay start success");
					//** 战斗中使用技能
					checkBattleSkillForDay();//System.out.println("checkBattleSkillForDay start success");
					//** 战斗中使用道具
					checkUseSkillAndItemForDay();//System.out.println("checkUserSkillAndItemForDay start success");
					//* 物品强化次数，购买次数的数据检测 
					checkItemYesterDay(str1);//System.out.println("checkItemYesterDay start success");
					//* fb检测,自动更新
					checkfbYesterday(str1);//System.out.println("checkfbYesterday start success");
					//* 战斗使用技能信息
					
					//* 各个模块的热点检测
//					acc.check_build_point_yesterday(str1);System.out.println("check_build_point_yesterday start success");
				}
			}
		};

		GameConstants.checkTask = new TimerTask(){
			public void run(){
				Calendar ca = Calendar.getInstance();
				 year = ca.get(Calendar.YEAR);//获取年份
		    	 month=ca.get(Calendar.MONTH)+1;//获取月份
		    	 day=ca.get(Calendar.DATE);//获取日
//		    int minute=ca.get(Calendar.MINUTE);//分
		      hour=ca.get(Calendar.HOUR_OF_DAY);//小时
		      second=ca.get(Calendar.SECOND);//秒
		      WeekOfYear = ca.get(Calendar.DAY_OF_WEEK);
//				Date now = new Date();
//				DateFormat d1 = DateFormat.getDateInstance(); //默认语言（汉语）下的默认风格（MEDIUM风格，比如：2008-6-16 20:54:53）
//				String strrs = d1.format(now);
				String strrs=year+"-"+month+"-"+day;
				String str2="";
				if(strrs.length()<10){
				 String strArr[] = strrs.split("-");
				 for(String tstr:strArr){
					 if(tstr.length()<2){
						 tstr="0"+tstr;
					 }
					 str2+=tstr+"-";
				 }
				}
				str2=str2.substring(0,10);
					checkForDay15minits(str2);
					//System.out.println("checkForDay15minits start "+str2);
			}
		};
	

		Timer timer=new Timer();
		timer.schedule(GameConstants.task, 0,1000*60*60);
		timer.schedule(GameConstants.checkTask, 0,1000*60*15);
		return "succ";
	}
	
	public ICaseLogService getCaseLogService() {
		if (caseLogService == null) {
			caseLogService = new CaseLogServiceImpl();
		}
		return caseLogService;
	}

	public ICaseInfoService getCaseInfoService() {
		if (caseInfoService == null) {
			caseInfoService = new CaseInfoServiceImpl();
		}
		return caseInfoService;
	}
	
	private IGameConsortiaService getGameConSortialService(){
		if(gameConsortialService == null){
			gameConsortialService = new GameConsortialServiceImpl();
		}
		return gameConsortialService;
	}
	
	private IGameRoleService getGameRoleService(){
		if(gameRoleService==null){
			gameRoleService=new GameRoleServiceImpl();
		}
		return gameRoleService;
	}
	
	private IGamePlaneService getGamePlaneService(){
		if(gamePlaneService==null){
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
		}
		return gameAvatarService;
	}
	
	private IGameEquipService getGameEquipService(){
		if(gameEquipService == null){
			gameEquipService = new GameEquipServiceImpl();
		}
		return gameEquipService;
	}
	
	public IGameSkillService getGameSkillService(){
		if(gameSkillService==null){
			gameSkillService = new GameSkillServiceImpl();
		}
		return gameSkillService;
	}
	
	public IOrderInfoService getOrderInfoService(){
		if(orderInfoService==null){
			orderInfoService= new OrderInfoServiceImpl();
		}
		return orderInfoService;
	}
	
	private IGameTaskFormalService gameTaskFormalService(){
		if(this.gameTaskFormalService==null){
			this.gameTaskFormalService = new GameTaskFormalServiceImpl();
		}
		return gameTaskFormalService;
	}
	
	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}
	

	public String getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(String priceMax) {
		this.priceMax = priceMax;
	}

	public String getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(String priceMin) {
		this.priceMin = priceMin;
	}
	
	public String getPpsUser() {
		return ppsUser;
	}

	public void setPpsUser(String ppsUser) {
		this.ppsUser = ppsUser;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
		this.session = ServletActionContext.getRequest().getSession();
	}

	@SuppressWarnings("static-access")
	public List<EntityCaseLogDetail> getEcld_list() {
		if (ecld_list == null) {
			GregorianCalendar   calendar   =   new   GregorianCalendar(); 
			 Date   date   =   calendar.getTime   (); 
			 SimpleDateFormat   df   =   new   SimpleDateFormat( "yyyy-MM-dd ");
			 calendar.set(calendar.DATE, calendar.get(calendar.DATE)+1);
			 date   =   calendar.getTime   ();
			//結束時間
			 String etime=df.format(date);
			 
			 String stime = df.format(new java.util.Date());//開始時間
			Map<String, Object> parms = new HashMap<String, Object>();
			// 只获取当天的数据
			parms.put("createTime1",stime);
			parms.put("createTime2",etime);
			
			ecld_list = this.getCaseLogService().getAllPoint(parms);
		}
		return ecld_list;
	}
	
	
	public List<EntityCaseLogDetail> getecld_list_maxOnline() {
			GregorianCalendar   calendar   =   new   GregorianCalendar(); 
			 Date   date   =   calendar.getTime   (); 
			 SimpleDateFormat   df   =   new   SimpleDateFormat( "yyyy-MM-dd ");
			 calendar.set(calendar.DATE, calendar.get(calendar.DATE)+1);
			 date   =   calendar.getTime   ();
			//結束時間
			 String etime=df.format(date);
			 String stime = df.format(new java.util.Date());//開始時間
			Map<String, Object> parms = new HashMap<String, Object>();
			// 只获取当天的数据
			parms.put("createTime1",stime);
			parms.put("createTime2",etime);
			parms.put("case_id1", 2);
			parms.put("case_id2", 4);
		return this.getCaseLogService().getAllPointMaxOnline(parms);
	}
	
	public List<EntityCaseLogDetail> getecld_list_maxOnline(String likeTime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date yesterday_time=null;
		Date ytTime=null;
		String tom="";
		try {
			yesterday_time=format.parse(likeTime);
			ytTime=new Date(yesterday_time.getTime()+(1000*60*60*24));
			tom=format.format(ytTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Object> parms = new HashMap<String, Object>();
		// 只获取当天的数据
		parms.put("createTime1",likeTime);
		parms.put("createTime2",tom);
		parms.put("case_id1", 2);
		parms.put("case_id2", 4);
	return this.getCaseLogService().getAllPointMaxOnline(parms);
}
	
	@SuppressWarnings("static-access")
	public List<EntityCaseLogDetail> getecld_list_maxOnlineYesertaday() {
		
		GregorianCalendar   calendar   =   new   GregorianCalendar(); 
		 Date   date   =   calendar.getTime   (); 
		 SimpleDateFormat   df   =   new   SimpleDateFormat( "yyyy-MM-dd ");
		 calendar.set(calendar.DATE, calendar.get(calendar.DATE)-1);
		 date   =   calendar.getTime   ();
		//結束時間
		 String etime=df.format(date);
		 String stime = df.format(new java.util.Date());//開始時間
		Map<String, Object> parms = new HashMap<String, Object>();
		// 只获取当天的数据
		parms.put("createTime1",etime);
		parms.put("createTime2",stime);
		parms.put("case_id1", 2);
		parms.put("case_id2", 3);
		List<EntityCaseLogDetail> tempvalue=this.getCaseLogService().getAllPointMaxOnline(parms);
	return tempvalue;
}
	
	public List<EntityCaseLogDetail> getListMaxOnlineBySqlForLike(String searchTime){
		//根据时间来like 查询出来的数据
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("createTime", searchTime);
		params.put("case_id1", 2);
		params.put("case_id2", 3);
		List<EntityCaseLogDetail> tempValue=this.getCaseLogService().getAllMaxOnlineByLike(params);
		return tempValue;
	}
	
	
	public List<Map<String,Object>> getEcld_list_Novice() {
		if(ecld_list_Novice==null){
			GregorianCalendar   calendar   =   new   GregorianCalendar(); 
			 Date   date   =   calendar.getTime   (); 
			 SimpleDateFormat   df   =   new   SimpleDateFormat( "yyyy-MM-dd ");
			 calendar.set(calendar.DATE, calendar.get(calendar.DATE)+1);
			 date   =   calendar.getTime   ();
			//結束時間
			 String etime=df.format(date);
			 String stime = df.format(new java.util.Date());//開始時間
			Map<String, Object> parms_novice = new HashMap<String, Object>();
			// 只获取当天的数据
			parms_novice.put("createTime1",stime);
			parms_novice.put("createTime2",etime);
			//parms_novice.put("case_id","31");
			ecld_list_Novice = this.getCaseLogService().getCaseLogNovice(parms_novice);
		}
		return ecld_list_Novice;
	}
	
	public List<Map<String,Object>> getEcld_list_Novice(String todayTime) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date yesterday_time=null;
			Date ytTime=null;
			String tom="";
			List<Map<String,Object>> tempArray=new ArrayList<Map<String,Object>>();
			ecld_list_Novice= new ArrayList<Map<String,Object>>();
			try {
				yesterday_time=format.parse(todayTime);
				ytTime=new Date(yesterday_time.getTime()+(1000*60*60*24));
				tom=format.format(ytTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Map<String, Object> parms_novice = new HashMap<String, Object>();
			// 只获取当天的数据
			parms_novice.put("createTime1",todayTime);
			parms_novice.put("createTime2",tom);
			parms_novice.put("case_id1", 31);
			parms_novice.put("case_id2", 41);
			tempArray = this.getCaseLogService().getCaseLogNovice(parms_novice);
			for(Map<String,Object> valueMap:tempArray){
			ecld_list_Novice.add(valueMap);
			}
			parms_novice.put("case_id1", 42);
			parms_novice.put("case_id2", 51);
			tempArray = this.getCaseLogService().getCaseLogNovice(parms_novice);
			for(Map<String,Object> valueMap:tempArray){
			ecld_list_Novice.add(valueMap);
			}
			parms_novice.put("case_id1", 52);
			parms_novice.put("case_id2", 67);
			tempArray = this.getCaseLogService().getCaseLogNovice(parms_novice);
			for(Map<String,Object> valueMap:tempArray){
			ecld_list_Novice.add(valueMap);
			}
			parms_novice.put("case_id1", 125);
			parms_novice.put("case_id2", 142);
			tempArray = this.getCaseLogService().getCaseLogNovice(parms_novice);
			for(Map<String,Object> valueMap:tempArray){
			ecld_list_Novice.add(valueMap);
			}
		return ecld_list_Novice;
	}
	
	//@SuppressWarnings("static-access")
	public List<Map<String,Object>> getEcld_list_NoviceYesterday() {
		if(ecld_list_NoviceYesterDay==null){
			GregorianCalendar   calendar   =   new   GregorianCalendar(); 
			 Date   date   =   calendar.getTime   (); 
			 SimpleDateFormat   df   =   new   SimpleDateFormat( "yyyy-MM-dd ");
			 calendar.set(calendar.DATE, calendar.get(calendar.DATE)-1);
			 date   =   calendar.getTime   ();
			//結束時間
			 String etime=df.format(date);
			 String stime = df.format(new java.util.Date());//開始時間
			Map<String, Object> parms_novice_yesterday = new HashMap<String, Object>();
			// 只获取当天的数据
			parms_novice_yesterday.put("createTime1",etime);
			parms_novice_yesterday.put("createTime2",stime);
			//parms_novice_yesterday.put("case_id","31");
			ecld_list_NoviceYesterDay=this.getCaseLogService().getCaseLogNovice(parms_novice_yesterday);
		}
			return ecld_list_NoviceYesterDay;
		
	}
	
	
	
	@SuppressWarnings("static-access")
	public List<EntityCaseLogDetail> getCheckDay(int case_id){
		//根据不同的采集点的节点要求单独查询数据
		GregorianCalendar   calendar   =   new   GregorianCalendar(); 
		 Date   date   =   calendar.getTime   (); 
		 SimpleDateFormat   df   =   new   SimpleDateFormat( "yyyy-MM-dd ");
		 calendar.set(calendar.DATE, calendar.get(calendar.DATE)+1);
		 date   =   calendar.getTime   ();
		//結束時間
		 String etime=df.format(date);
		 String stime = df.format(new java.util.Date());//開始時間
		Map<String, Object> parms = new HashMap<String, Object>();
		// 只获取当天的数据
		parms.put("createTime1",stime);
		parms.put("createTime2",etime);
		parms.put("case_id", case_id);
		return this.getCaseLogService().getAllPointByParams(parms);
	}
	
	/**
	 * 获取人名道具的买卖或使用
	 * @param case_id
	 * @param _datetime 年月参数
	 * @return 整个数据集合	
	 */
	public List<EntityCaseLogDetail> getBuyOrSellItemInfoForMonth(int case_id,String _datetime){
		//根据不同的采集点的节点要求单独查询数据
//		GregorianCalendar   calendar   =   new   GregorianCalendar(); 
//		 Date   date   =   calendar.getTime   (); 
//		 SimpleDateFormat   df   =   new   SimpleDateFormat( "yyyy-MM-dd ");
//		 calendar.set(calendar.DATE, calendar.get(calendar.DATE)+1);
//		 date   =   calendar.getTime   ();
//		//結束時間
//		 String etime=df.format(date);
//		 String stime = df.format(new java.util.Date());//開始時間
		Map<String, Object> parms = new HashMap<String, Object>();
		// 只获取当天的数据
		parms.put("likeTime",_datetime);
		//parms.put("createTime2",etime);
		parms.put("case_id", case_id);
		return this.getCaseLogService().getAllPointByParams(parms);
	}
	
	
	public List<EntityCaseLogDetail> getCheckDay(int case_id,String likeTime){
		//根据不同的采集点的节点要求单独查询数据
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date yesterday_time=null;
		Date ytTime=null;
		String tom="";
		try {
			yesterday_time=format.parse(likeTime);
			ytTime=new Date(yesterday_time.getTime()+(1000*60*60*24));
			tom=format.format(ytTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Object> parms = new HashMap<String, Object>();
		// 只获取当天的数据
		parms.put("createTime1",likeTime);
		parms.put("createTime2",tom);
		parms.put("case_id", case_id);
		return this.getCaseLogService().getAllPointByParams(parms);
	}
	
	public int getCheckDayNoRep(int case_id){
		GregorianCalendar   calendar   =   new   GregorianCalendar(); 
		 Date   date   =   calendar.getTime   (); 
		 SimpleDateFormat   df   =   new   SimpleDateFormat( "yyyy-MM-dd ");
		 calendar.set(calendar.DATE, calendar.get(calendar.DATE)+1);
		 date   =   calendar.getTime   ();
		//結束時間
		 String etime=df.format(date);
		 String stime = df.format(new java.util.Date());//開始時間
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("likeTime", stime);
		params.put("likeTime2", etime);
		params.put("case_id", case_id);
		return this.getCaseLogService().getNoRepleAllCount(params);
	}
	
	public int getCheckDayNoRep(int case_id,String likeTime){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date yesterday_time=null;
		Date ytTime=null;
		String tom="";
		try {
			yesterday_time=format.parse(likeTime);
			ytTime=new Date(yesterday_time.getTime()+(1000*60*60*24));
			tom=format.format(ytTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("likeTime", likeTime);
		params.put("likeTime2", tom);
		params.put("case_id", case_id);
		return this.getCaseLogService().getNoRepleAllCount(params);
	}
	
	public List<EntityCaseLogDetail> getCheckDayByTime(int case_id,String Liketime){
		//根据不同的采集点的节点要求单独查询数据
		Map<String, Object> parms = new HashMap<String, Object>();
		// 只获取当天的数据
		parms.put("likeTime",Liketime);
		parms.put("case_id", case_id);
		return this.getCaseLogService().getAllPointByParams(parms);
	}
	
	public List<EntityCaseLogDetail> getCheckDayByTime(int case_id,int case_id2,String Liketime){
		//根据不同的采集点的节点要求单独查询数据
		Map<String, Object> parms = new HashMap<String, Object>();
		// 只获取当天的数据
		parms.put("likeTime",Liketime);
		parms.put("case_id1", case_id);
		parms.put("case_id2", case_id2);
		return this.getCaseLogService().getAllPointByParams(parms);
	}

	
	//获取昨天的时间
	@SuppressWarnings("static-access")
	public List<EntityCaseLogDetail> getCheckDayYesterday(int case_id){
		GregorianCalendar   calendar   =   new   GregorianCalendar(); 
		 Date   date   =   calendar.getTime   (); 
		 SimpleDateFormat   df   =   new   SimpleDateFormat( "yyyy-MM-dd ");
		 calendar.set(calendar.DATE, calendar.get(calendar.DATE)-1);
		 date   =   calendar.getTime   ();
		//結束時間
		 String etime=df.format(date);
		 String stime = df.format(new java.util.Date());//開始時間
		Map<String, Object> parms = new HashMap<String, Object>();
		// 只获取当天的数据
		parms.put("createTime1",etime);
		parms.put("createTime2",stime);
		parms.put("case_id", case_id);
		return this.getCaseLogService().getAllPointByParams(parms);
	}
	
	/**
	 * 根据时间来查询
	 * @param case_id
	 * @return
	 */
	public List<EntityCaseLogDetail> getCheckDayYesterday(String time,int case_id1){
		Map<String, Object> parms = new HashMap<String, Object>();
		// 只获取当天的数据
		parms.put("createTime",time);
		parms.put("case_id1", case_id1);
		return this.getCaseLogService().getAllPointByParams(parms);
	}
	
	public List<EntityCaseLogDetail> getCheckDayYesterday(String time,int case_id1,int case_id2){
		Map<String, Object> parms = new HashMap<String, Object>();
		// 只获取当天的数据
		parms.put("createTime",time);
		parms.put("case_id1", case_id1);
		parms.put("case_id2", case_id2);
		return this.getCaseLogService().getAllPointByParams(parms);
	}
	
	
	/**
	 * 根据时间来刷新当前 在case_info 里面的 time时间的数据
	 * @param time
	 * @param case_id
	 * @return List<EntityCaseLogDetail>
	 */
	public List<EntityCaseLogDetail> getCheckDayByDateAndCaseId(String time,int case_id){
		Map<String,Object> params= new HashMap<String,Object>();
		params.put("case_time", time);
		params.put("case_id", case_id);
		CaseLogDaoImpl cldi = new CaseLogDaoImpl();
		List<EntityCaseLogDetail> lecld=cldi.getCheckDayByDateAndCaseId(params);
		return lecld;
	}
	
	
	@SuppressWarnings("static-access")
	public List<EntityCaseLogDetail> getCheckDay(int case_id1,int case_id2){
		//根据不同的采集点的节点要求单独查询数据
		GregorianCalendar   calendar   =   new   GregorianCalendar();
		 SimpleDateFormat   df   =   new   SimpleDateFormat( "yyyy-MM-dd ");
		 calendar.set(calendar.DATE, calendar.get(calendar.DATE)+1);
		 //date   =   calendar.getTime   ();
		 Date   date   =   calendar.getTime   (); 
		//結束時間
		 String etime=df.format(date);
		 String stime = df.format(new java.util.Date());//開始時間
		Map<String, Object> parms = new HashMap<String, Object>();
		// 只获取当天的数据
		parms.put("createTime1",stime);
		parms.put("createTime2",etime);
		parms.put("case_id1", case_id1);
		parms.put("case_id2", case_id2);
		return this.getCaseLogService().getAllPointByParams(parms);
	}
	
	@SuppressWarnings("static-access")
	public List<EntityCaseLogDetail> getCheckDayYesterday(int case_id1,int case_id2){
		//根据不同的采集点的节点要求单独查询数据
		GregorianCalendar   calendar   =   new   GregorianCalendar();
		 SimpleDateFormat   df   =   new   SimpleDateFormat( "yyyy-MM-dd ");
		 calendar.set(calendar.DATE, calendar.get(calendar.DATE)-1);
		 //date   =   calendar.getTime   ();
		 Date date=calendar.getTime();
		//結束時間
		 String etime=df.format(date);
		 String stime = df.format(new java.util.Date());//開始時間
		Map<String, Object> parms = new HashMap<String, Object>();
		// 只获取当天的数据
		parms.put("createTime1",etime);
		parms.put("createTime2",stime);
		parms.put("case_id1", case_id1);
		parms.put("case_id2", case_id2);
		return this.getCaseLogService().getAllPointByParams(parms);
	}
	
	//返回所需要返回的时间
	@SuppressWarnings("static-access")
	public String timeSearch(int change_num){
		GregorianCalendar   calendar   =   new   GregorianCalendar(); 
		 Date   date   =   calendar.getTime   (); 
		 SimpleDateFormat   df   =   new   SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datetime="";
		switch(change_num){
		case 1://返回明天时间
			 calendar.set(calendar.DATE, calendar.get(calendar.DATE)+1);
			 date=calendar.getTime();			
			 datetime=df.format(date);break;
		case 2://返回昨天的时间
			calendar.set(calendar.DATE, calendar.get(calendar.DATE)-1);
			 date=calendar.getTime();			
			 datetime=df.format(date);break;
		case 3://返回当前时间
			calendar.set(calendar.DATE, calendar.get(calendar.DATE));
			 date=calendar.getTime();			
			 datetime=df.format(date);break;
		}
		return datetime;
	}
	
	/**
	 * 查询当日登录老玩家数和当日成功进入游戏的老玩家数
	 * @param liketime like 时间
	 * @param time
	 * @param caseId
	 * @return
	 */
	
	public List<EntityCaseLogDetail> twoTablesSearch(String liketime,String time,int caseId){
		CaseLogDaoImpl cldi = new CaseLogDaoImpl();
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("liketime", liketime);
		params.put("create_time", time);
		params.put("case_id", caseId);
		return cldi.searchTwoTables(params);
	}
	
	public List<EntityCaseLogDetail> twoTablesSearchForNewGameplayer(String liketime,int caseId){
		CaseLogDaoImpl cldi = new CaseLogDaoImpl();
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("liketime", liketime);
		
		params.put("case_id", caseId);
		return cldi.getNewPlayer(params);
	}
	
	/**
	 * 动态生成xml
	 * 
	 * @param title
	 * @param fileTag
	 * @param lecld
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String createExecl(String command, String titleValue,
			Map<String, Object> mapresult, String filePath) {
		DecimalFormat df = new DecimalFormat("#.00");
		// title 的实例
		// String[] title = {"编号","产品名称","产品价格","产品数量","生产日期","产地","是否出口"};
		String tagName = command;
		String[] title = titleValue.split(",");// 标头数据
		try {
			// 获得开始时间
			long start = System.currentTimeMillis();

			// 创建Excel工作薄
			WritableWorkbook wwb;
			// 新建立一个jxl文件,即在C盘下生成test.xls
			OutputStream os = new FileOutputStream(filePath);
			wwb = Workbook.createWorkbook(os);
			// 添加第一个工作表并设置第一个Sheet的名字
			WritableSheet sheet = wwb.createSheet(tagName, 0);
			Label label;
			for (int i = 0; i < title.length; i++) {
				// Label(x,y,z)其中x代表单元格的第x+1列，第y+1行, 单元格的内容是y
				// 在Label对象的子对象中指明单元格的位置和内容
				label = new Label(i, 0, title[i]);
				// 将定义好的单元格添加到工作表中
				sheet.addCell(label);
			}
			// 下面是填充数据
			/*
			 * 保存数字到单元格，需要使用jxl.write.Number 必须使用其完整路径，否则会出现错误
			 */
			// 填充信息
			if (tagName.equals("checkBattle")) {// 战斗状况的xml生成。
				List<EntityCheckBattleDetail> lecbd = (List<EntityCheckBattleDetail>) mapresult
						.get("mapresult");
				for (int i = 1; i <= lecbd.size(); i++) {
					EntityCheckBattleDetail ecbd = lecbd.get(i - 1);
					int j = 0;
					label = new Label(j, i, ecbd.getRoomNum() + "");
					sheet.addCell(label);
					j++;
					switch (ecbd.getBattleType()) {
					case 1:
						label = new Label(j, i, "自由组队");
						break;
					case 2:
						label = new Label(j, i, "撮合");
						break;
					case 3:
						label = new Label(j, i, "pve");
						break;
					}
					sheet.addCell(label);
					j++;
					label = new Label(j, i, (ecbd.getEndTime() - ecbd
							.getStartTime())
							/ 1000 / 60 + "分钟");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecbd.getPlayerCount() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecbd.getMapId() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecbd.getTeamA() + "");
					sheet.addCell(label);
					j++;
					if (ecbd.getTeamB().equals("")) {
						label = new Label(j, i, "机器人");
						sheet.addCell(label);
					} else {
						label = new Label(j, i, ecbd.getTeamB());
						sheet.addCell(label);
					}
					j++;
					switch (Integer.parseInt(ecbd.getWinTeam())) {
					case 1:
						label = new Label(j, i, "A");
						sheet.addCell(label);
						break;
					case 2:
						label = new Label(j, i, "B");
						sheet.addCell(label);
						break;
					}

				}

			} else if (tagName.equals("checkfb")) {// fb状况的xml生成
				List<EntityCheckFbDetail> lecfd = (List<EntityCheckFbDetail>) mapresult
						.get("mapresult");
				for (int i = 1; i <= lecfd.size(); i++) {
					EntityCheckFbDetail ecfd = lecfd.get(i - 1);
					int j = 0;
					label = new Label(j, i, ecfd.getDatetime() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecfd.getFbnum() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecfd.getFbwin() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecfd.getFblost() + "");
					sheet.addCell(label);
					j++;
					if (ecfd.getFbnum() > ecfd.getFbwin()) {
						label = new Label(j, i, df.format(ecfd.getFbwin()
								/ (float) ecfd.getFbnum() * 100)
								+ "%");
						sheet.addCell(label);
						j++;
					}
					if (ecfd.getFbnum() > ecfd.getFblost()) {
						label = new Label(j, i, df.format(ecfd.getFblost()
								/ (float) ecfd.getFbnum() * 100)
								+ "%");
						sheet.addCell(label);
						j++;
					}
				}
			} else if (tagName.equals("checkDay")) {// 一天为单位来统计数据
				List<EntityCheckDayDetail> lecdd = (List<EntityCheckDayDetail>) mapresult
						.get("mapresult");
				int regman = 0;
				for (int i = 1; i <= lecdd.size(); i++) {
					EntityCheckDayDetail ecdd = lecdd.get(i);
					regman += ecdd.getRegMan();
					int j = 0;
					label = new Label(j, i, ecdd.getDate());
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecdd.getRegNum() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecdd.getRegMan() + "");
					sheet.addCell(label);
					j++;
					if (ecdd.getRegMan() + ecdd.getRegNum() > 0) {
						label = new Label(j, i, df.format(ecdd.getRegMan()
								/ (double) (ecdd.getRegNum()) * 100)
								+ "%");
						sheet.addCell(label);
						j++;
					}
					label = new Label(j, i, ecdd.getUlt() + "");
					sheet.addCell(label);
					j++;
					if (ecdd.getUlt() > 0) {
						label = new Label(j, i, df.format(ecdd.getUlts()
								/ (double) ecdd.getUlt() * 100)
								+ "%");
						sheet.addCell(label);
						j++;
					}
					label = new Label(j, i, ecdd.getMaxOnline() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecdd.getNoRepeatlogoin() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecdd.getPzwb() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecdd.getTygjmb() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecdd.getYxb() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecdd.getLjserver() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecdd.getLjltserver() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecdd.getJzmxsj() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecdd.getHqphb() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecdd.getHqghlb() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecdd.getHqdzdh() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecdd.getHqwjxx() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecdd.getJzcjrwjm() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecdd.getJazjm() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecdd.getJzxsbz() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecdd.getJzdtjm() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecdd.getJzfjjm() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecdd.getJzzdjm() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecdd.getJzadzy() + "");
					sheet.addCell(label);
					j++;
				}
				label = new Label(0, lecdd.size() + 1, "新增玩家");
				sheet.addCell(label);
				label = new Label(1, lecdd.size() + 1, regman + "");
				sheet.addCell(label);
			} else if (tagName.equals("checkNovice")) {// 测试新手引导的留存率
				List<EntityCheckNoviceDayDetail> lecdd = (List<EntityCheckNoviceDayDetail>) mapresult
						.get("mapresult");
				for (int i = 1; i <= lecdd.size(); i++) {
					int j = 0;
					EntityCheckNoviceDayDetail ecndd = lecdd.get(i - 1);
					label = new Label(j, i, ecndd.getDate() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice1() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice2() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice3() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice4() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice5() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice6() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice7() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice8() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice9() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice10() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice11() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice12() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice13() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice14() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice15() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice16() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice17() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice18() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice19() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice20() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice21() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice22() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice23() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice24() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice25() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice26() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice27() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice28() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice29() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice30() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice31() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice32() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice33() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice34() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice35() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice36() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, ecndd.getEcnd().getNovice37() + "");
					sheet.addCell(label);
					j++;
					if (ecndd.getEcnd().getNovice1() > ecndd.getEcnd()
							.getNovice37()) {
						label = new Label(j, i, df.format(ecndd.getEcnd()
								.getNovice37()
								/ ecndd.getEcnd().getNovice1() * 100));
						sheet.addCell(label);
						j++;
					} else {
						label = new Label(j, i, "0");
						sheet.addCell(label);
						j++;
					}
				}
			} else if (tagName.equals("checkItem")) {// 检查道具的销售数量
				List<EntityGameItemDetail> legid = (List<EntityGameItemDetail>) mapresult
						.get("mapresult");
				int rmbItem = 0;
				int intensify = 0;
				int synthesis = 0;
				int synthesisitem = 0;
				@SuppressWarnings("unused")
				int rows = 0;
				for (int i = 1; i <= legid.size(); i++) {
					int j = 0;
					rows = i;
					EntityGameItemDetail egid = legid.get(i - 1);
					label = new Label(j, i, egid.getDate() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, egid.getRmbItem() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, egid.getIntensify() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, egid.getSynthesis() + "");
					sheet.addCell(label);
					j++;
					label = new Label(j, i, egid.getSynthesisItem() + "");
					sheet.addCell(label);
					j++;
				}
				int j = 0;
				int i = 0;
				label = new Label(j++, i++, "总计：");
				sheet.addCell(label);
				label = new Label(j++, i++, rmbItem + "");
				sheet.addCell(label);
				label = new Label(j++, i++, intensify + "");
				sheet.addCell(label);
				label = new Label(j++, i++, synthesis + "");
				sheet.addCell(label);
				label = new Label(j++, i++, synthesisitem + "");
				sheet.addCell(label);
			}

			/*
			 * 
			 * 定义公共字体格式 通过获取一个字体的样式来作为模板 首先通过web.getSheet(0)获得第一个sheet
			 * 然后取得第一个sheet的第二列，第一行也就是"产品名称"的字体
			 */
			CellFormat cf = wwb.getSheet(0).getCell(1, 0).getCellFormat();
			WritableCellFormat wc = new WritableCellFormat();
			// 设置居中
			wc.setAlignment(Alignment.CENTRE);
			// 设置边框线
			wc.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 设置单元格的背景颜色
			// wc.setBackground(jxl.format.Colour.RED);
			// label = new Label(1,5,"字体",wc);
			// sheet.addCell(label);

			// 设置字体
			// jxl.write.WritableFont wfont = new
			// jxl.write.WritableFont(WritableFont.createFont("隶书"),20);
			// WritableCellFormat font = new WritableCellFormat(wfont);
			// label = new Label(2,6,"隶书",font);
			// sheet.addCell(label);

			// 写入数据
			wwb.write();
			// 关闭文件
			wwb.close();
			long end = System.currentTimeMillis();
			System.out.println("----完成该操作共用的时间是:" + (end - start) / 1000);
		} catch (Exception e) {
			System.out.println("---出现异常---");
			e.printStackTrace();
		}
		return "null";
	}

	public String checkFunction(){
		final int WEB_RIGHT=4;
		HashMap<String, Object> param = new HashMap<String, Object>();
		HttpSession session = ((HttpServletRequest)request).getSession();
		param.put("uid", (Integer)session.getAttribute("uid"));
		List<EntityRightUserDetail> eruds = new RightUserServiceImpl().findRightUserByMap(param);
		if(eruds.size()!=1){
			return ERROR;
		}
		if(!((eruds.get(0).getRight_value()&1)==1||(eruds.get(0).getRight_value()&WEB_RIGHT)==WEB_RIGHT)){
			return ERROR;
		}
		return "succ";
	}
	
	/* 查看当天的登录注册情况 */
	public String checkDay_Old() {
		String st = "succ";
		st=checkFunction();
		if(st==ERROR){
			return ERROR;
		}
		String _datetime = "";
		String createTime1 = this.request.getParameter("stime1");
		String createTime2 = this.request.getParameter("stime2");
		String pagetype=this.request.getParameter("pagetype");
		List<EntityCheckDayDetail> lecdd = new ArrayList<EntityCheckDayDetail>();// 封裝採集到的最後的數據

		// 选择时间区间 进这里
		if (createTime1 != null || createTime2 != null) {// 2个时间只要有任意一个存在就要为另外一个创建初始值
			if (createTime1 == null || createTime1.equals("")) {
				createTime1 = "1970-01-01";// 意义你懂的
			}
			if (createTime2 == null || createTime2.equals("")) {
				// 获取当前的时间作为 time2的补全时间
				SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
				createTime2 = tempDate.format(new java.util.Date());
			}
			// 首先便利出时间区间里面的信息的天数的数据
//			List<EntityCaseLogDetail> lecld = getCaseLogService()
//					.getAllDateListTimeToTime(liste, createTime1, createTime2);
//			date_list = this.getCaseLogService().getAllDateList(lecld);
		}
		EntityCheckDayDetail ecld = new EntityCheckDayDetail();
		GameRoleDaoImpl grdi = new GameRoleDaoImpl();
		Map<String,Object> mbparams = new HashMap<String,Object>();
		mbparams.put("create_time", timeSearch(3).substring(0,10));
//		System.out.println("老用户时间为"+timeSearch(3).substring(0,10));
		//List<Integer> li= grdi.selectIdAndCreateTime(mbparams);//获取当前的“老用户信息”
		//**获取所有的登录用户
		List<EntityCaseLogDetail>  allLogin=this.getCaseLogService().noRepleAll(getCheckDay(1), 1);
		ecld.setUlt(allLogin.size());
		ecld.setOldPlayer(this.twoTablesSearch(timeSearch(3).substring(0,10), timeSearch(2).substring(0,10), 1).size());
		
		ecld.setOldPlayerLodin(this.twoTablesSearch(timeSearch(3).substring(0,10), timeSearch(2).substring(0,10), 4).size());
		List<EntityCaseLogDetail>  case4=this.getCaseLogService().noRepleAll(getCheckDay(4), 4);
		//**新玩家数
		ecld.setNewPlayer(ecld.getUlt()-ecld.getOldPlayer());//** 数据屏蔽 使用更好的数据跟踪。。读取member当前日期的用户数量
		MemberDaoImpl msi=new MemberDaoImpl();
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("likeTime",timeSearch(3).substring(0,10));
		int newplayers=msi.findMembersByIds(params).size();
		ecld.setPpsIn(newplayers);
//		ecld.setOldPlayer(ecld.getUlt()-ecld.getNewPlayer());
			/* 获得所有的注册人数 */
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
		_datetime=tempDate.format(new java.util.Date());
			ecld.setDate(_datetime);
			/* 获得真实的总登录人数 */
			List<EntityCaseLogDetail>  allLoginPlays=this.getCaseLogService().noRepleAll(getCheckDay(3),3);//获取所有进入游戏的的人数
			ecld.setAllUserLogin(allLoginPlays.size());
			//** 遍历进来的人那些是老玩家
//			ecld.setOldPlayerLodin(case4.size()-this.getCaseLogService().getAllUserLoding(getCheckDay(69,4),69,4));
			ecld.setAllUserPlayNum(case4.size());
//			ecld.setRegNum(this.getCaseLogService().noRepleAll(liste,69).size());// 和时间没有关系的。获取总玩家人数
			ecld.setRegMan(this.getCaseLogService().noRepleAll(getCheckDay(69), 69).size());// 获取当日的新用户
			//ecld.setUlt(this.getCaseLogService().noRepleAll(getCheckDay(1), 1).size());// 当前登录数
			// 与下面的数据相同
			//ecld.setUlts(this.getCaseLogService().noRepleAll(liste, 4).size());// 成功登录进游戏的玩家数
			/* 便利所有注册用户，创建玩家的用户就是新注册的用户,采集点是3的就是68的就是新注册的用户 */
//			ecld.setRegsuccess(this.getCaseLogService().noRepleAll(liste, 68).size());// 获取新登录的用户
			ecld.setRegsuccess(this.getCaseLogService().noRepleAll(this.getCheckDay(68),68).size());
			/* 获得所有进入游戏的人数，成功进入选区界面的人 */
			ecld.setRegManLogin(getCaseLogService().getAllUserRegLoding(this.getCheckDay(69, 98)));
			EntityCheckNoviceDetail ecnd=getCaseLogService().getNovice(this.getCheckDay(31,133), _datetime);
			ecld.setNov1(ecnd.getNovice1());
			ecld.setNov47(ecnd.getNovice46());//** 卷毛强烈建议不要采纳47步的操作数据 
			//ecld.setRegManLogin(100);
			/* 获取所有的登录用户次数 3 */
			//ecld.setAllUserLogin(this.getCaseLogService().noRepleAll(getCheckDay(3), 3).size());
			/* 获取所有成功进入游戏的玩家 到达选取界面 4 */

			//ecld.setAllUserPlayNum(this.getCaseLogService().noRepleAll(getCheckDay(4),4).size());
			String tempStr=this.getCaseLogService().checkOnlineNum(getecld_list_maxOnline());
			String [] avg_result=tempStr.split("&");
		
			ecld.setAvgNum(Integer.parseInt(avg_result[1]));
			
			/**
			 *  获取在线数据的时候要是升序的方式来获取数据
			 */
			
			//获取游戏中玩家的的最高在线
			ecld.setMaxOnline(this.getCaseLogService().getAllUserOnlineMax(
					this.getecld_list_maxOnline(), _datetime));
//			ecld.setNoRepeatlogoin(this.getCaseLogService().getUniqueUser(
//					liste, _datetime).size());
			ecld.setNoRepeatlogoin(ecld.getAllUserLogin());
//			ecld.setPzwb(this.getCaseLogService().staicPublic(getCheckDay(88), _datetime,
//					88).size());
//			ecld.setTygjmb(this.getCaseLogService().staicPublic(getCheckDay(89),
//					_datetime, 89).size());
//			ecld.setYxb(this.getCaseLogService().staicPublic(getCheckDay(90), _datetime,
//					90).size());
//			ecld.setLjserver(this.getCaseLogService().staicPublic(getCheckDay(91),
//					_datetime, 91).size());
//			ecld.setLjltserver(this.getCaseLogService().staicPublic(getCheckDay(92),
//					_datetime, 92).size());
//			ecld.setJzmxsj(this.getCaseLogService().staicPublic(getCheckDay(93),
//					_datetime, 93).size());
//			ecld.setHqphb(this.getCaseLogService().staicPublic(getCheckDay(94),
//					_datetime, 94).size());
//			ecld.setHqghlb(this.getCaseLogService().staicPublic(getCheckDay(95),
//					_datetime, 95).size());
//			ecld.setHqdqlb(this.getCaseLogService().staicPublic(getCheckDay(96),
//					_datetime, 96).size());
//			ecld.setHqdzdh(this.getCaseLogService().staicPublic(getCheckDay(97),
//					_datetime, 97).size());
//			ecld.setHqwjxx(this.getCaseLogService().staicPublic(getCheckDay(98),
//					_datetime, 98).size());
//			ecld.setJzcjrwjm(this.getCaseLogService().staicPublic(getCheckDay(99),
//					_datetime, 99).size());
//			ecld.setJazjm(this.getCaseLogService().staicPublic(getCheckDay(100),
//					_datetime, 100).size());
//			ecld.setJzxsbz(this.getCaseLogService().staicPublic(getCheckDay(101),
//					_datetime, 101).size());
//			ecld.setJzdtjm(this.getCaseLogService().staicPublic(getCheckDay(102),
//					_datetime, 102).size());
//			ecld.setJzfjjm(this.getCaseLogService().staicPublic(getCheckDay(103),
//					_datetime, 103).size());
//			ecld.setJzzdjm(this.getCaseLogService().staicPublic(getCheckDay(104),
//					_datetime, 104).size());
//			ecld.setJzadzy(this.getCaseLogService().staicPublic(getCheckDay(105),
//					_datetime, 105).size());
			lecdd.add(ecld);
			
		

		String execl = request.getParameter("execl");
		if (execl != null) {
			// 说明需要生成xml
			String title = "日期,总创建角色数,当日创建角色数,用户增长率,当日uv,当日uv率,最高在线,不重复登陆,配置文件加载,通用工具面板,音效包,连接server,连接聊天server,连接模型数据,获取排行榜,获取工会列表,获取大区列表,获取大招动画,获取玩家信息,获取创建人物界面,加载主界面,加载新手帮助,加载大厅界面,加载战斗界面,加载战斗资源";
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("mapresult", lecdd);
			String common = "checkDay";
			this.createExecl(common, title, resultMap, path + "checkDay.xls");
		}
		this.publicfunctionForDay(1, ecld,_datetime);
		// 获取信息表里面的数据。多天数据进行遍历
		Map<String, Object> fdParm = new HashMap<String, Object>();
		fdParm.put("lag_type", 1);
		/**
		 * 进行分页处理。。查看一共相关的信息有多少条
		 */
		int pages=0;
		int count=this.getCaseInfoService().searchCount(fdParm);
		int pagesize=25;
		String cutterPage=request.getParameter("page");
		int cp=0;
		if(cutterPage==null || cutterPage.equals("")){
			cp=0;
		}else
		{
			cp=Integer.parseInt(cutterPage);
		}
		if(count%pagesize>0 && count/pagesize>0){
			pages=count/pagesize+1;
		}else{
			pages=0;
		}
		fdParm.put("limit1", cp*pagesize);
		fdParm.put("limit2", pagesize);
		
		List<EntityCaseInfoDetail> result = this.getCaseInfoService().findAll(
				fdParm);
		List<EntityCheckDayDetail> rs_l = new ArrayList<EntityCheckDayDetail>();
		for (EntityCaseInfoDetail ecid : result) {
			EntityCheckDayDetail tempecd = new EntityCheckDayDetail();
		    tempecd = (EntityCheckDayDetail) JSON
					.parseObject(ecid.getLag_info(), EntityCheckDayDetail.class);
			rs_l.add(tempecd);
		}
		// request.setAttribute("results", lecdd);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("results", rs_l);
		resultMap.put("pages", pages);
		resultMap.put("cutterPage", 0);
		request.setAttribute("results", resultMap);
		if(pagetype.equals("1")){
			return "succ2";
		}
		return st;
	}
	
	
	public String checkDay() {
		String st = "succ";
//		st=checkFunction();
//		if(st==ERROR){
//			return ERROR;
//		}
		String _datetime = "";
		GregorianCalendar   calendar   =   new   GregorianCalendar(); 
		 Date   date   =   calendar.getTime   (); 
		 SimpleDateFormat   df   =   new   SimpleDateFormat( "yyyy-MM-dd ");
		 calendar.set(calendar.DATE, calendar.get(calendar.DATE)+1);
		 date   =   calendar.getTime   ();
		//明天時間
		 String tomorrw=df.format(date);
		
		String pagetype=this.request.getParameter("pagetype");
		SimpleDateFormat tempD = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS z");
		List<EntityCheckDayDetail> lecdd = new ArrayList<EntityCheckDayDetail>();// 封裝採集到的最後的數據
		EntityCheckDayDetail ecld = new EntityCheckDayDetail();
		GameRoleDaoImpl grdi = new GameRoleDaoImpl();
		Map<String,Object> mbparams = new HashMap<String,Object>();
		mbparams.put("create_time", timeSearch(3).substring(0,10));
		//**获取所有的登录用户
		System.out.println("1---"+tempD.format(new java.util.Date()));
		ecld.setUlt(getCheckDayNoRep(1));
		System.out.println("2---"+tempD.format(new java.util.Date()));
		ecld.setOldPlayer(this.twoTablesSearch(timeSearch(3).substring(0,10), timeSearch(2).substring(0,10), 1).size());
		System.out.println("3---"+tempD.format(new java.util.Date()));
		ecld.setOldPlayerLodin(this.twoTablesSearch(timeSearch(3).substring(0,10), timeSearch(2).substring(0,10), 4).size());		//**新玩家数
		System.out.println("4---"+tempD.format(new java.util.Date()));
     	ecld.setNewPlayer(ecld.getUlt()-ecld.getOldPlayer());//** 数据屏蔽 使用更好的数据跟踪。。读取member当前日期的用户数量
		
		//ecld.setNewPlayer(twoTablesSearchForNewGameplayer(timeSearch(3).substring(0,10),1).size());
		System.out.println("5---"+tempD.format(new java.util.Date()));
		MemberDaoImpl msi=new MemberDaoImpl();
		Map<String,Object> params = new HashMap<String,Object>();
		
		params.put("likeTime",timeSearch(3).substring(0,10));
		int newplayers=msi.findMembersByIds(params).size();
		ecld.setPpsIn(newplayers);
			/* 获得所有的注册人数 */
		System.out.println("6---"+tempD.format(new java.util.Date()));
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
		_datetime=tempDate.format(new java.util.Date());
			ecld.setDate(_datetime);
			/* 获得真实的总登录人数 */
			List<EntityCaseLogDetail>  allLoginPlays=this.getCaseLogService().noRepleAll(getCheckDay(3),3);//获取所有进入游戏的的人数
			ecld.setAllUserLogin(allLoginPlays.size());
			System.out.println("7---"+tempD.format(new java.util.Date()));
			//** 遍历进来的人那些是老玩家
			ecld.setAllUserPlayNum(getCheckDayNoRep(4));
			System.out.println("8---"+tempD.format(new java.util.Date()));
			//** 重新构造 创建角色 结构体 读game_role create_time
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("likeTime", _datetime);
			param.put("likeTime2", tomorrw);
			ecld.setRegMan(this.getGameRoleService().getGameRoleCount(param));
			System.out.println("9---"+tempD.format(new java.util.Date()));
			// 与下面的数据相同
			/* 便利所有注册用户，创建玩家的用户就是新注册的用户,采集点是3的就是68的就是新注册的用户 */
			
			ecld.setRegsuccess(getCheckDayNoRep(68));
			System.out.println("10---"+tempD.format(new java.util.Date()));
			/* 获得所有进入游戏的人数，成功进入选区界面的人 */
			List<EntityCaseLogDetail> lecld_69=this.getCheckDay(69);
			List<EntityCaseLogDetail> lecld_98=this.getCheckDay(98);
			ecld.setRegManLogin(getCaseLogService().getAllUserRegLoding(lecld_69,lecld_98));
			System.out.println("11---"+tempD.format(new java.util.Date()));
			ecld.setNov1(this.getCheckDayNoRep(31));
			System.out.println("12---"+tempD.format(new java.util.Date()));
			ecld.setNov47(this.getCheckDayNoRep(125));
			System.out.println("13---"+tempD.format(new java.util.Date()));
			/* 获取所有的登录用户次数 3 */
			/* 获取所有成功进入游戏的玩家 到达选取界面 4 */
			String tempStr=this.getCaseLogService().checkOnlineNum(getecld_list_maxOnline());
			String [] avg_result=tempStr.split("&");
		
			ecld.setAvgNum(Integer.parseInt(avg_result[1]));
			System.out.println("14---"+tempD.format(new java.util.Date()));
			
			/**
			 *  获取在线数据的时候要是升序的方式来获取数据
			 */
			
			//获取游戏中玩家的的最高在线
			ecld.setMaxOnline(this.getCaseLogService().getAllUserOnlineMax(
					this.getecld_list_maxOnline(), _datetime));
			System.out.println("15---"+tempD.format(new java.util.Date()));
			ecld.setNoRepeatlogoin(ecld.getAllUserLogin());
			lecdd.add(ecld);
			System.out.println("16---"+tempD.format(new java.util.Date()));
		this.publicfunctionForDay(1, ecld,_datetime);
		// 获取信息表里面的数据。多天数据进行遍历
		Map<String, Object> fdParm = new HashMap<String, Object>();
		fdParm.put("lag_type", 1);
		/**
		 * 进行分页处理。。查看一共相关的信息有多少条
		 */
		int pages=0;
		int count=this.getCaseInfoService().searchCount(fdParm);
		System.out.println("17---"+tempD.format(new java.util.Date()));
		int pagesize=25;
		String cutterPage=request.getParameter("page");
		int cp=0;
		if(cutterPage==null || cutterPage.equals("")){
			cp=0;
		}else
		{
			cp=Integer.parseInt(cutterPage);
		}
		if(count%pagesize>0 && count/pagesize>0){
			pages=count/pagesize+1;
		}else{
			pages=0;
		}
		fdParm.put("limit1", cp*pagesize);
		fdParm.put("limit2", pagesize);
		
		List<EntityCaseInfoDetail> result = this.getCaseInfoService().findAll(
				fdParm);
		System.out.println("18---"+tempD.format(new java.util.Date()));
		List<EntityCheckDayDetail> rs_l = new ArrayList<EntityCheckDayDetail>();
		for (EntityCaseInfoDetail ecid : result) {
			EntityCheckDayDetail tempecd = new EntityCheckDayDetail();
		    tempecd = (EntityCheckDayDetail) JSON
					.parseObject(ecid.getLag_info(), EntityCheckDayDetail.class);
			rs_l.add(tempecd);
		}
		System.out.println("19---"+tempD.format(new java.util.Date()));
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("results", rs_l);
		resultMap.put("pages", pages);
		resultMap.put("cutterPage", 0);
		request.setAttribute("results", resultMap);
		if(pagetype.equals("1")){
			return "succ2";
		}
		return st;
	}
	
	
	
	
	//选择时间查看数据
	public String checkForDay(){
		
		String liketime=request.getParameter("startTime").substring(0,10);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date yesterday_time=null;
		Date ytTime=null;
		String yesterTime="";
		try {
			yesterday_time=format.parse(liketime);
			ytTime=new Date(yesterday_time.getTime()+(1000*60*60*24));
			yesterTime=format.format(ytTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* 获得所有的注册人数 */
		
		SimpleDateFormat tempD = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS z");
		List<EntityCheckDayDetail> lecdd = new ArrayList<EntityCheckDayDetail>();// 封裝採集到的最後的數據
		EntityCheckDayDetail ecld = new EntityCheckDayDetail();
		GameRoleDaoImpl grdi = new GameRoleDaoImpl();
		Map<String,Object> mbparams = new HashMap<String,Object>();
		mbparams.put("create_time", timeSearch(3).substring(0,10));
		//**获取所有的登录用户
		ecld.setUlt(getCheckDayNoRep(1,liketime));
		ecld.setOldPlayer(this.twoTablesSearch(liketime.substring(0,10), yesterTime.substring(0,10), 1).size());
		ecld.setOldPlayerLodin(this.twoTablesSearch(liketime.substring(0,10), yesterTime.substring(0,10), 4).size());		//**新玩家数\
		ecld.setNewPlayer(ecld.getUlt()-ecld.getOldPlayer());//** 数据屏蔽 使用更好的数据跟踪。。读取member当前日期的用户数量
		
		MemberDaoImpl msi=new MemberDaoImpl();
		Map<String,Object> params = new HashMap<String,Object>();
		
		params.put("likeTime",liketime.substring(0,10));
		int newplayers=msi.findMembersByIds(params).size();
		ecld.setPpsIn(newplayers);
			/* 获得所有的注册人数 */
			ecld.setDate(liketime);
			/* 获得真实的总登录人数 */
			ecld.setAllUserLogin(this.getCaseLogService().noRepleAll(getCheckDayByTime(3,liketime), 3).size());
			//** 遍历进来的人那些是老玩家
			ecld.setAllUserPlayNum(getCheckDayNoRep(4,liketime));
			//** 重新构造 创建角色 结构体 读game_role create_time
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("likeTime", liketime);
			param.put("likeTime2", yesterTime);
			ecld.setRegMan(this.getGameRoleService().getGameRoleCount(param));
			
			// 与下面的数据相同
			/* 便利所有注册用户，创建玩家的用户就是新注册的用户,采集点是3的就是68的就是新注册的用户 */
			
			ecld.setRegsuccess(getCheckDayNoRep(68,liketime));
			
			/* 获得所有进入游戏的人数，成功进入选区界面的人 */
			List<EntityCaseLogDetail> lecld_69=this.getCheckDay(69,liketime);
			List<EntityCaseLogDetail> lecld_98=this.getCheckDay(98,liketime);
			ecld.setRegManLogin(getCaseLogService().getAllUserRegLoding(lecld_69,lecld_98));
			
			ecld.setNov1(this.getCheckDayNoRep(31,liketime));
			
			ecld.setNov47(this.getCheckDayNoRep(125,liketime));
			
			/* 获取所有的登录用户次数 3 */
			/* 获取所有成功进入游戏的玩家 到达选取界面 4 */
			String tempStr=this.getCaseLogService().checkOnlineNum(getecld_list_maxOnline(liketime));
			String [] avg_result=tempStr.split("&");
		
			ecld.setAvgNum(Integer.parseInt(avg_result[1]));
			
			
			/**
			 *  获取在线数据的时候要是升序的方式来获取数据
			 */
			
			//获取游戏中玩家的的最高在线
			ecld.setMaxOnline(this.getCaseLogService().getAllUserOnlineMax(
					this.getecld_list_maxOnline(liketime), liketime));
			
			ecld.setNoRepeatlogoin(ecld.getAllUserLogin());
			lecdd.add(ecld);
			
		this.publicfunctionForDay(1, ecld,liketime);	
		return "succ";
	}
	
	
	public void checkForDayB(String liketime){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date yesterday_time=null;
		Date ytTime=null;
		String yesterTime="";
		try {
			yesterday_time=format.parse(liketime);
			ytTime=new Date(yesterday_time.getTime()-(1000*60*60*24));
			yesterTime=format.format(ytTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* 获得所有的注册人数 */
		List<EntityCheckDayDetail> lecdd = new ArrayList<EntityCheckDayDetail>();// 封裝採集到的最後的數據
		EntityCheckDayDetail ecld = new EntityCheckDayDetail();
		Map<String,Object> mbparams = new HashMap<String,Object>();
		mbparams.put("create_time", timeSearch(3).substring(0,10));
		//**获取所有的登录用户
		ecld.setUlt(getCheckDayNoRep(1,yesterTime));
		System.out.print("______yesterTimer_____"+yesterTime.substring(0,10));
		ecld.setOldPlayer(this.twoTablesSearch(yesterTime.substring(0,10), liketime.substring(0,10), 1).size());
		ecld.setOldPlayerLodin(this.twoTablesSearch(yesterTime.substring(0,10), liketime.substring(0,10), 4).size());		//**新玩家数
		ecld.setNewPlayer(ecld.getUlt()-ecld.getOldPlayer());//** 数据屏蔽 使用更好的数据跟踪。。读取member当前日期的用户数量
		MemberDaoImpl msi=new MemberDaoImpl();
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("likeTime",yesterTime.substring(0,10));
		int newplayers=msi.findMembersByIds(params).size();
		ecld.setPpsIn(newplayers);	
			ecld.setDate(yesterTime);
			/* 获得真实的总登录人数 */
			ecld.setAllUserLogin(this.getCaseLogService().noRepleAll(getCheckDayByTime(3,yesterTime), 3).size());
			//** 遍历进来的人那些是老玩家
			ecld.setAllUserPlayNum(getCheckDayNoRep(4,yesterTime));
			//** 重新构造 创建角色 结构体 读game_role create_time
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("likeTime", yesterTime);
			param.put("likeTime2", liketime);
			ecld.setRegMan(this.getGameRoleService().getGameRoleCount(param));
			// 与下面的数据相同
			/* 便利所有注册用户，创建玩家的用户就是新注册的用户,采集点是3的就是68的就是新注册的用户 */
			ecld.setRegsuccess(getCheckDayNoRep(68,yesterTime));
			/* 获得所有进入游戏的人数，成功进入选区界面的人 */
			List<EntityCaseLogDetail> lecld_69=this.getCheckDay(69,yesterTime);
			List<EntityCaseLogDetail> lecld_98=this.getCheckDay(98,yesterTime);
			ecld.setRegManLogin(getCaseLogService().getAllUserRegLoding(lecld_69,lecld_98));
			ecld.setNov1(this.getCheckDayNoRep(31,yesterTime));
			ecld.setNov47(this.getCheckDayNoRep(125,yesterTime));
			/* 获取所有的登录用户次数 3 */
			/* 获取所有成功进入游戏的玩家 到达选取界面 4 */
			String tempStr=this.getCaseLogService().checkOnlineNum(getecld_list_maxOnline(yesterTime));
			String [] avg_result=tempStr.split("&");
			ecld.setAvgNum(Integer.parseInt(avg_result[1]));
			
			/**
			 *  获取在线数据的时候要是升序的方式来获取数据
			 */
			
			//获取游戏中玩家的的最高在线
			ecld.setMaxOnline(this.getCaseLogService().getAllUserOnlineMax(
					this.getecld_list_maxOnline(yesterTime), yesterTime));
			ecld.setNoRepeatlogoin(ecld.getAllUserLogin());
			lecdd.add(ecld);
		this.publicfunctionForDay(1, ecld,yesterTime);
	}
	
	public void checkForDay15minits(String liketime){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date yesterday_time=null;
		Date ytTime=null;
		String yesterTime="";
		try {
			yesterday_time=format.parse(liketime);
			ytTime=new Date(yesterday_time.getTime()+(1000*60*60*24));
			yesterTime=format.format(ytTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* 获得所有的注册人数 */
		SimpleDateFormat tempD = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS z");
		List<EntityCheckDayDetail> lecdd = new ArrayList<EntityCheckDayDetail>();// 封裝採集到的最後的數據
		EntityCheckDayDetail ecld = new EntityCheckDayDetail();
		GameRoleDaoImpl grdi = new GameRoleDaoImpl();
		Map<String,Object> mbparams = new HashMap<String,Object>();
		mbparams.put("create_time", timeSearch(3).substring(0,10));
		//**获取所有的登录用户
		ecld.setUlt(getCheckDayNoRep(1,liketime));
		ecld.setOldPlayer(this.twoTablesSearch(liketime.substring(0,10), yesterTime.substring(0,10), 1).size());
		ecld.setOldPlayerLodin(this.twoTablesSearch(liketime.substring(0,10), yesterTime.substring(0,10), 4).size());		//**新玩家数\
		ecld.setNewPlayer(ecld.getUlt()-ecld.getOldPlayer());//** 数据屏蔽 使用更好的数据跟踪。。读取member当前日期的用户数量
		
		MemberDaoImpl msi=new MemberDaoImpl();
		Map<String,Object> params = new HashMap<String,Object>();
		
		params.put("likeTime",liketime.substring(0,10));
		int newplayers=msi.findMembersByIds(params).size();
		ecld.setPpsIn(newplayers);
			/* 获得所有的注册人数 */
			ecld.setDate(liketime);
			/* 获得真实的总登录人数 */
			ecld.setAllUserLogin(this.getCaseLogService().noRepleAll(getCheckDayByTime(3,liketime), 3).size());
			//** 遍历进来的人那些是老玩家
			ecld.setAllUserPlayNum(getCheckDayNoRep(4,liketime));
			//** 重新构造 创建角色 结构体 读game_role create_time
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("likeTime", liketime);
			param.put("likeTime2", yesterTime);
			ecld.setRegMan(this.getGameRoleService().getGameRoleCount(param));
			
			// 与下面的数据相同
			/* 便利所有注册用户，创建玩家的用户就是新注册的用户,采集点是3的就是68的就是新注册的用户 */
			ecld.setRegsuccess(getCheckDayNoRep(68,liketime));
			/* 获得所有进入游戏的人数，成功进入选区界面的人 */
			List<EntityCaseLogDetail> lecld_69=this.getCheckDay(69,liketime);
			List<EntityCaseLogDetail> lecld_98=this.getCheckDay(98,liketime);
			ecld.setRegManLogin(getCaseLogService().getAllUserRegLoding(lecld_69,lecld_98));
			ecld.setNov1(this.getCheckDayNoRep(31,liketime));
			ecld.setNov47(this.getCheckDayNoRep(125,liketime));
			/* 获取所有的登录用户次数 3 */
			/* 获取所有成功进入游戏的玩家 到达选取界面 4 */
			String tempStr=this.getCaseLogService().checkOnlineNum(getecld_list_maxOnline(liketime));
			String [] avg_result=tempStr.split("&");
			ecld.setAvgNum(Integer.parseInt(avg_result[1]));
			/**
			 *  获取在线数据的时候要是升序的方式来获取数据
			 */
			System.out.print("time is "+liketime);
			//获取游戏中玩家的的最高在线
			if(GameConstants.maxline==0 ||GameConstants.maxline<this.getCaseLogService().getAllUserOnlineMax(
					this.getecld_list_maxOnline(liketime), liketime) ){
				GameConstants.maxline=this.getCaseLogService().getAllUserOnlineMax(
						this.getecld_list_maxOnline(liketime), liketime);
			}
			ecld.setMaxOnline(GameConstants.maxline);
			ecld.setNoRepeatlogoin(ecld.getAllUserLogin());	
			CheckDayDbDaoImpl cdddi = new CheckDayDbDaoImpl();
			String _strJson = JSON.toJSONString(ecld);
			Map<String,Object> mapresult = new HashMap<String,Object>();
			//System.out.println("function "+liketime);
			mapresult.put("jsonValue", _strJson);
			cdddi.addCheckDayDbDetail(mapresult);
	}
	
	/**
	 * 每15分钟更新一次
	 * @return
	 */
	public void checkForDay15minitsOld(String liketime){
		/* 获得所有的注册人数 */
			EntityCheckDayDetail ecld = new EntityCheckDayDetail();
			ecld.setDate(liketime);
			/* 获得真实的总登录人数 */
			MemberDaoImpl msi=new MemberDaoImpl();
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("likeTime",liketime);
			int newplayers=msi.findMembersByIds(params).size();
			ecld.setPpsIn(newplayers);
			//**获取所有的登录用户
			List<EntityCaseLogDetail>  allLogin=this.getCaseLogService().noRepleAll(getCheckDayByTime(1,liketime), 1);
			ecld.setUlt(allLogin.size());
			List<EntityCaseLogDetail>  case4=this.getCaseLogService().noRepleAll(getCheckDayByTime(4,liketime), 4);
			ecld.setOldPlayer(this.twoTablesSearch(liketime,liketime, 1).size());
			ecld.setOldPlayerLodin(this.twoTablesSearch(liketime, liketime, 4).size());
			ecld.setNewPlayer(ecld.getUlt()-ecld.getOldPlayer());
			ecld.setRegMan(this.getCaseLogService().noRepleAll(getCheckDayByTime(69,liketime), 69).size());// 获取当日的新用户
			EntityCheckNoviceDetail ecnd=getCaseLogService().getNovice(this.getCheckDayByTime(31,134,liketime), liketime);
			ecld.setNov1(ecnd.getNovice1());
			ecld.setNov47(ecnd.getNovice47());
			// 与下面的数据相同
			ecld.setRegsuccess(this.getCaseLogService().noRepleAll(this.getCheckDayByTime(68,liketime),68).size());
			/* 获得所有进入游戏的人数，成功进入选区界面的人 */
			ecld.setRegManLogin(getCaseLogService().getAllUserRegLoding(this.getCheckDayByTime(69, 98,liketime)));
			
			/* 获取所有的登录用户次数 4 */
			ecld.setAllUserLogin(this.getCaseLogService().noRepleAll(getCheckDayByTime(3,liketime), 3).size());
			/* 获取所有成功进入游戏的玩家 到达选取界面 4 */

			ecld.setAllUserPlayNum(case4.size());
			String tempStr=this.getCaseLogService().checkOnlineNum(getCheckDayByTime(2,4,liketime));
			String [] avg_result=tempStr.split("&");
			ecld.setAvgNum(Integer.parseInt(avg_result[1]));
		/**
		 *  获取在线数据的时候要是升序的方式来获取数据
		 */
		ecld.setMaxOnline(this.getCaseLogService().getAllUserOnlineMax(
				this.getCheckDayByTime(2,4,liketime), liketime));
		ecld.setNoRepeatlogoin(ecld.getAllUserLogin());
	
	CheckDayDbDaoImpl cdddi = new CheckDayDbDaoImpl();
	String _strJson = JSON.toJSONString(ecld);
	Map<String,Object> mapresult = new HashMap<String,Object>();
	//System.out.println("function "+liketime);
	mapresult.put("jsonValue", _strJson);
	cdddi.addCheckDayDbDetail(mapresult);
	
}
	
	/**
	 * 查看15分钟一次采集的消息记录
	 * @return
	 */
	public String readCheckForDay15minits(){
		//* 获取当前的时间函数，如果没有提供就默认为当天
		String timeDate = request.getParameter("stime");
		//System.out.println("readCheckForDAy15Minits is "+timeDate);
		if(timeDate==null){
			SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
			timeDate = tempDate.format(new java.util.Date()).substring(0,10);
		}
		CheckDayDbDaoImpl cdddi = new CheckDayDbDaoImpl();
		Map<String, Object> fdParm = new HashMap<String, Object>();
		fdParm.put("createDate", timeDate);
		/**
		 * 进行分页处理。。查看一共相关的信息有多少条
		 */
		int pages=0;
		int count=cdddi.searchCheckDayCount(fdParm);
		int pagesize=25;
		String cutterPage=request.getParameter("page");
		int cp=0;
		if(cutterPage==null || cutterPage.equals("")){
			cp=0;
		}else{
			cp=Integer.parseInt(cutterPage);
		}
		if(count%pagesize>0 && count/pagesize>0){
			pages=count/pagesize+1;
		}else{
			pages=0;
		}
		fdParm.put("limit1", cp*pagesize);
		fdParm.put("limit2", pagesize);
		List<EntityCheckDayDbDetail> leddd = cdddi.findAll(fdParm);
		List<EntityCheckDayDetail> rs_l = new ArrayList<EntityCheckDayDetail>();
		for(EntityCheckDayDbDetail ecddd:leddd){
			EntityCheckDayDetail tempecd = new EntityCheckDayDetail();
		    tempecd = (EntityCheckDayDetail) JSON
					.parseObject(ecddd.getJsonValue(), EntityCheckDayDetail.class);
		    tempecd.setDate(ecddd.getCreateDate());
			rs_l.add(tempecd);
		}
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("results", rs_l);
		resultMap.put("count", count);
		resultMap.put("pages", pages);
		resultMap.put("cutterPage", 0);
		request.setAttribute("results", resultMap);
		return "succ2";
	}
	
	/**
	 * 根据传递进来的时间进行like 查询
	 * @return
	 */
	public String SearchCheckDay(){
			String create_time= request.getParameter("create_time");
			String sqlId=request.getParameter("id");
			/*
			 * 将时间格式从String 转换成 date
			 * DataFormat format1 = new SimpleDate
			 */
			GregorianCalendar   calendar   =   new   GregorianCalendar(); 
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date yesterday_time=null;
			Date ytTime=null;
			String yesterTime="";
			try {
				yesterday_time=format.parse(create_time);
				ytTime=new Date(yesterday_time.getTime()-(1000*60*60*24));
				yesterTime=format.format(ytTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/* 获得所有的注册人数 */
			EntityCheckDayDetail ecld = new EntityCheckDayDetail();
			ecld.setDate(create_time);
			/* 获得真实的总登录人数 */
			GameRoleDaoImpl grdi = new GameRoleDaoImpl();
			Map<String,Object> mbparams = new HashMap<String,Object>();
			mbparams.put("create_time", timeSearch(2).substring(0,10));
			List<Integer> li= grdi.selectIdAndCreateTime(mbparams);//获取当前的“老用户信息”
			//**获取所有的登录用户
			List<EntityCaseLogDetail>  allLogin=this.getCaseLogService().noRepleAll(getCheckDayYesterday(yesterTime,1), 1);
			ecld.setUlt(allLogin.size());
			List<EntityCaseLogDetail>  case4=this.getCaseLogService().noRepleAll(getCheckDayYesterday(yesterTime,4), 4);
			ecld.setOldPlayer(this.twoTablesSearch(timeSearch(2).substring(0,10), timeSearch(3).substring(0,10), 1).size());
			ecld.setOldPlayerLodin(this.twoTablesSearch(timeSearch(2).substring(0,10), timeSearch(3).substring(0,10), 4).size());
			ecld.setNewPlayer(ecld.getUlt()-ecld.getOldPlayer());
			ecld.setRegMan(this.getCaseLogService().noRepleAll(getCheckDayYesterday(yesterTime,69), 69).size());// 获取当日的新用户
			// 与下面的数据相同
			ecld.setRegsuccess(this.getCaseLogService().noRepleAll(this.getCheckDayYesterday(yesterTime,68),68).size());
			/* 获得所有进入游戏的人数，成功进入选区界面的人 */
			ecld.setRegManLogin(getCaseLogService().getAllUserRegLoding(this.getCheckDayYesterday(yesterTime,69, 98)));
			
			/* 获取所有的登录用户次数 3 */
			ecld.setAllUserLogin(this.getCaseLogService().noRepleAll(getCheckDayYesterday(yesterTime,3), 3).size());
			/* 获取所有成功进入游戏的玩家 到达选取界面 4 */

			ecld.setAllUserPlayNum(case4.size());
			String tempStr=this.getCaseLogService().checkOnlineNum(getecld_list_maxOnlineYesertaday());
			String [] avg_result=tempStr.split("&");
			ecld.setAvgNum(Integer.parseInt(avg_result[1]));
			/**
			 *  获取在线数据的时候要是升序的方式来获取数据
			 */
//			ecld.setMaxOnline(this.getCaseLogService().getAllUserOnlineMax(
//					this.getecld_list_maxOnlineYesertaday(), create_time));
			ecld.setMaxOnline(this.getCaseLogService().getAllUserOnlineMax(this.getListMaxOnlineBySqlForLike(create_time),create_time));
			ecld.setNoRepeatlogoin(ecld.getAllUserLogin());
			this.publicfunctionYesterday(1, ecld,Integer.parseInt(sqlId),create_time,2);
			request.setAttribute("results", "one");
		return "succ";
	}
	
	public String checkDayOne(){
		Map<String, Object> fdParm = new HashMap<String, Object>();
		fdParm.put("lag_type", 1);
		List<EntityCaseInfoDetail> result = this.getCaseInfoService().findAll(
				fdParm);
		List<EntityCheckDayDetail> rs_l = new ArrayList<EntityCheckDayDetail>();
		for (EntityCaseInfoDetail ecid : result) {
			EntityCheckDayDetail tempecd = new EntityCheckDayDetail();
		    tempecd = (EntityCheckDayDetail) JSON
					.parseObject(ecid.getLag_info(), EntityCheckDayDetail.class);
			rs_l.add(tempecd);
		}
		request.setAttribute("results", rs_l);
		return "succ";
	}
	
	
	public String check_Day(){
		
		String st = "succ";
		st=checkFunction();
		String _datetime = "";
		String createTime1 = this.request.getParameter("stime1");
		String createTime2 = this.request.getParameter("stime2");
		List<EntityCheckDayDetail> lecdd = new ArrayList<EntityCheckDayDetail>();// 封裝採集到的最後的數據

		// 选择时间区间 进这里
		if (createTime1 != null || createTime2 != null) {// 2个时间只要有任意一个存在就要为另外一个创建初始值
			if (createTime1 == null || createTime1.equals("")) {
				createTime1 = "1970-01-01";// 意义你懂的
			}
			if (createTime2 == null || createTime2.equals("")) {
				// 获取当前的时间作为 time2的补全时间
				SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
				createTime2 = tempDate.format(new java.util.Date());
			}
		}
			SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
		_datetime=tempDate.format(new java.util.Date());
			EntityCheckDayDetail ecld = new EntityCheckDayDetail();
			ecld.setDate(_datetime);
			ecld.setAllUserLogin(this.getCaseLogService().noRepleAll(getCheckDay(3), 3).size());
			ecld.setNoRepeatlogoin(ecld.getAllUserLogin());
			ecld.setPzwb(this.getCaseLogService().staicPublic(getCheckDay(88), _datetime,
					88).size());
			ecld.setTygjmb(this.getCaseLogService().staicPublic(getCheckDay(89),
					_datetime, 89).size());
			ecld.setYxb(this.getCaseLogService().staicPublic(getCheckDay(90), _datetime,
					90).size());
			
			/* ljserver 修改为自动挂机节点 使用状态 ，ljltserver 为取消状态 guk */
			
			List<EntityCaseLogDetail> lecldTemp=this.getCaseLogService().staicPublic(getCheckDay(388),_datetime, 388);
			int succ=0;
			int abort=0;
			for(EntityCaseLogDetail ecldtemp:lecldTemp){
				if(ecldtemp.getCase_ex_desc().equals("1")){
					succ+=1;
				}else{
					abort+=1;
				}
				
			}
			
//			ecld.setLjserver(this.getCaseLogService().staicPublic(getCheckDay(91),
//					_datetime, 91).size());
//			ecld.setLjltserver(this.getCaseLogService().staicPublic(getCheckDay(92),
//					_datetime, 92).size());
			
			ecld.setLjserver(succ);
			ecld.setLjltserver(abort);
			
			ecld.setJzmxsj(this.getCaseLogService().staicPublic(getCheckDay(93),
					_datetime, 93).size());
			ecld.setHqphb(this.getCaseLogService().staicPublic(getCheckDay(94),
					_datetime, 94).size());
			ecld.setHqghlb(this.getCaseLogService().staicPublic(getCheckDay(95),
					_datetime, 95).size());
			ecld.setHqdqlb(this.getCaseLogService().staicPublic(getCheckDay(96),
					_datetime, 96).size());
			ecld.setHqdzdh(this.getCaseLogService().staicPublic(getCheckDay(97),
					_datetime, 97).size());
			ecld.setHqwjxx(this.getCaseLogService().staicPublic(getCheckDay(98),
					_datetime, 98).size());
			ecld.setJzcjrwjm(this.getCaseLogService().staicPublic(getCheckDay(99),
					_datetime, 99).size());
			ecld.setJazjm(this.getCaseLogService().staicPublic(getCheckDay(100),
					_datetime, 100).size());
			ecld.setJzxsbz(this.getCaseLogService().staicPublic(getCheckDay(101),
					_datetime, 101).size());
			ecld.setJzdtjm(this.getCaseLogService().staicPublic(getCheckDay(102),
					_datetime, 102).size());
			ecld.setJzfjjm(this.getCaseLogService().staicPublic(getCheckDay(103),
					_datetime, 103).size());
			ecld.setJzzdjm(this.getCaseLogService().staicPublic(getCheckDay(104),
					_datetime, 104).size());
			ecld.setJzadzy(this.getCaseLogService().staicPublic(getCheckDay(105),
					_datetime, 105).size());
			lecdd.add(ecld);
			
		

		String execl = request.getParameter("execl");
		if (execl != null) {
			// 说明需要生成xml
			String title = "日期,总创建角色数,当日创建角色数,用户增长率,当日uv,当日uv率,最高在线,不重复登陆,配置文件加载,通用工具面板,音效包,连接server,连接聊天server,连接模型数据,获取排行榜,获取工会列表,获取大区列表,获取大招动画,获取玩家信息,获取创建人物界面,加载主界面,加载新手帮助,加载大厅界面,加载战斗界面,加载战斗资源";
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("mapresult", lecdd);
			String common = "checkDay";
			this.createExecl(common, title, resultMap, path + "checkDay.xls");
		}
		this.publicfunctionForDay(99, ecld,_datetime);
		
		// 获取信息表里面的数据。多天数据进行遍历
		Map<String, Object> fdParm = new HashMap<String, Object>();
		fdParm.put("lag_type", 99);
		/**
		 * 进行分页处理。。查看一共相关的信息有多少条
		 */
		int pages=0;
		int count=this.getCaseInfoService().searchCount(fdParm);
		int pagesize=25;
		String cutterPage=request.getParameter("page");
		int cp=0;
		if(cutterPage==null || cutterPage.equals("")){
			cp=0;
		}else
		{
			cp=Integer.parseInt(cutterPage);
		}
		if(count%pagesize>0 && count/pagesize>0){
			pages=count/pagesize+1;
		
		}else{
			pages=0;
		}
		
		fdParm.put("limit1", cp*pagesize);
		fdParm.put("limit2", pagesize);
		
		List<EntityCaseInfoDetail> result = this.getCaseInfoService().findAll(
				fdParm);
		List<EntityCheckDayDetail> rs_l = new ArrayList<EntityCheckDayDetail>();
		for (EntityCaseInfoDetail ecid : result) {
			EntityCheckDayDetail tempecd = new EntityCheckDayDetail();
			//System.out.println(ecid.getLag_info());
		    tempecd = (EntityCheckDayDetail) JSON
					.parseObject(ecid.getLag_info(), EntityCheckDayDetail.class);
			rs_l.add(tempecd);
		}
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("results", rs_l);
		resultMap.put("pages", pages);
		resultMap.put("cutterPage", 0);
		
		// request.setAttribute("results", lecdd);
		request.setAttribute("results", resultMap);
		return st;
	}
	
	/**
	 * 根据天数刷新当前的数据信息
	 */
	public String check_DayForDay(){
		String _datetime = request.getParameter("stime1");
		List<EntityCheckDayDetail> lecdd = new ArrayList<EntityCheckDayDetail>();// 封裝採集到的最後的數據
			EntityCheckDayDetail ecld = new EntityCheckDayDetail();
			ecld.setDate(_datetime);
			ecld.setAllUserLogin(this.getCaseLogService().noRepleAll(getCheckDayByTime(3,_datetime), 3).size());
			ecld.setNoRepeatlogoin(ecld.getAllUserLogin());
			ecld.setPzwb(this.getCaseLogService().staicPublic(getCheckDayByTime(88,_datetime), _datetime,
					88).size());
			ecld.setTygjmb(this.getCaseLogService().staicPublic(getCheckDayByTime(89,_datetime),
					_datetime, 89).size());
			ecld.setYxb(this.getCaseLogService().staicPublic(getCheckDayByTime(90,_datetime), _datetime,
					90).size());
//			ecld.setLjserver(this.getCaseLogService().staicPublic(getCheckDay(91),
//					_datetime, 91).size());
//			ecld.setLjltserver(this.getCaseLogService().staicPublic(getCheckDay(92),
//					_datetime, 92).size());
			ecld.setJzmxsj(this.getCaseLogService().staicPublic(getCheckDayByTime(93,_datetime),
					_datetime, 93).size());
			ecld.setHqphb(this.getCaseLogService().staicPublic(getCheckDayByTime(94,_datetime),
					_datetime, 94).size());
			ecld.setHqghlb(this.getCaseLogService().staicPublic(getCheckDayByTime(95,_datetime),
					_datetime, 95).size());
			ecld.setHqdqlb(this.getCaseLogService().staicPublic(getCheckDayByTime(96,_datetime),
					_datetime, 96).size());
			ecld.setHqdzdh(this.getCaseLogService().staicPublic(getCheckDayByTime(97,_datetime),
					_datetime, 97).size());
			ecld.setHqwjxx(this.getCaseLogService().staicPublic(getCheckDayByTime(98,_datetime),
					_datetime, 98).size());
			ecld.setJzcjrwjm(this.getCaseLogService().staicPublic(getCheckDayByTime(99,_datetime),
					_datetime, 99).size());
			ecld.setJazjm(this.getCaseLogService().staicPublic(getCheckDayByTime(100,_datetime),
					_datetime, 100).size());
			ecld.setJzxsbz(this.getCaseLogService().staicPublic(getCheckDayByTime(101,_datetime),
					_datetime, 101).size());
			ecld.setJzdtjm(this.getCaseLogService().staicPublic(getCheckDayByTime(102,_datetime),
					_datetime, 102).size());
			ecld.setJzfjjm(this.getCaseLogService().staicPublic(getCheckDayByTime(103,_datetime),
					_datetime, 103).size());
			ecld.setJzzdjm(this.getCaseLogService().staicPublic(getCheckDayByTime(104,_datetime),
					_datetime, 104).size());
			ecld.setJzadzy(this.getCaseLogService().staicPublic(getCheckDayByTime(105,_datetime),
					_datetime, 105).size());
			lecdd.add(ecld);
		this.publicfunctionForDay(99, ecld,_datetime);
			 
		return "succ";
	}
	
	/**
	 * 检查各个模块的采集热度
	 * @return
	 */
	public String  check_build_point(){
		/**
		 * 7战斗大厅、 22科研所、205 公会模块检测、 19拍卖行模块检测 、6 机库模块检测 
		 * 208 叫宝藏岛模块检测、 18商城、210 后山矿洞 、211竞技场模块 、24 排行榜、4外遇远征
		 * 
		 **/
		String _datetime="";
		
		String st=checkFunction();
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
		_datetime=tempDate.format(new java.util.Date());
		EntityCheckBuildDetail ecbd = new EntityCheckBuildDetail();
		ecbd.setDateTime(_datetime);
		System.out.println("213123");
		ecbd.setZddt(this.getCaseLogService().staicPublic(getCheckDayByTime(7,_datetime),
				_datetime, 7).size());
		ecbd.setKyzx(this.getCaseLogService().staicPublic(getCheckDayByTime(22,_datetime),
				_datetime,22).size());
		ecbd.setGh(this.getCaseLogService().staicPublic(getCheckDayByTime(205,_datetime),
				_datetime, 205).size());
		ecbd.setPmh(this.getCaseLogService().staicPublic(getCheckDayByTime(19,_datetime),
				_datetime, 19).size());
		ecbd.setJk(this.getCaseLogService().staicPublic(getCheckDayByTime(6,_datetime),
				_datetime, 6).size());
		ecbd.setBzd(this.getCaseLogService().staicPublic(getCheckDayByTime(208,_datetime),
				_datetime, 208).size());
		ecbd.setSc(this.getCaseLogService().staicPublic(getCheckDayByTime(18,_datetime),
				_datetime,18).size());
		ecbd.setHskd(this.getCaseLogService().staicPublic(getCheckDayByTime(210,_datetime),
				_datetime, 210).size());
		ecbd.setPhb(this.getCaseLogService().staicPublic(getCheckDayByTime(24,_datetime),
				_datetime, 24).size());
		ecbd.setJjc(this.getCaseLogService().staicPublic(getCheckDayByTime(211,_datetime),
				_datetime, 211).size());
		ecbd.setWyyz(this.getCaseLogService().staicPublic(getCheckDayByTime(4,_datetime),
				_datetime, 4).size());
		this.publicfunctionForDay(100, ecbd,_datetime);
		//delete
		//
			Map<String,List<Map<String,Object>>> bags = new HashMap<String,List<Map<String,Object>>>();//总背包
			List<Map<String,Object>> bag1 = new ArrayList<Map<String,Object>>();//外背包数据
			for(int i=0;i<20;i++){
				Map<String,Object> bag1info = new HashMap<String,Object>();
				bag1info.put("astrology_name", "黑切");
				bag1info.put("live", 2);
				bag1info.put("point", i);//背包位置
				bag1info.put("sellPrice", 6000);
				bag1.add(bag1info);
			}
			bags.put("bag1", bag1);
			this.publicfunctionForDay(999, bags, _datetime);
		//delete
		
		// 获取信息表里面的数据。多天数据进行遍历
		Map<String, Object> fdParm = new HashMap<String, Object>();
		fdParm.put("lag_type", 100);
		/**
		 * 进行分页处理。。查看一共相关的信息有多少条
		 */
		int pages=0;
		int count=this.getCaseInfoService().searchCount(fdParm);
		int pagesize=25;
		String cutterPage=request.getParameter("page");
		int cp=0;
		if(cutterPage==null || cutterPage.equals("")){
			cp=0;
		}else
		{
			cp=Integer.parseInt(cutterPage);
		}
		if(count%pagesize>0 && count/pagesize>0){
			pages=count/pagesize+1;
		
		}else{
			pages=0;
		}
		
		fdParm.put("limit1", cp*pagesize);
		fdParm.put("limit2", pagesize);
		
		List<EntityCaseInfoDetail> result = this.getCaseInfoService().findAll(
				fdParm);
		List<EntityCheckBuildDetail> rs_l = new ArrayList<EntityCheckBuildDetail>();
		for (EntityCaseInfoDetail ecid : result) {
			EntityCheckBuildDetail tempecd = new EntityCheckBuildDetail();
			System.out.println(ecid.getLag_info());
		    tempecd = (EntityCheckBuildDetail) JSON
					.parseObject(ecid.getLag_info(), EntityCheckBuildDetail.class);
			rs_l.add(tempecd);
		}
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("results", rs_l);
		resultMap.put("pages", pages);
		resultMap.put("cutterPage", 0);
		
		// request.setAttribute("results", lecdd);
		request.setAttribute("results", resultMap);
		return "succ";
	}
	
	public void  check_build_point_yesterday(String liketime){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date yesterday_time=null;
		Date ytTime=null;
		String yesterTime="";
		try {
			yesterday_time=format.parse(liketime);
			ytTime=new Date(yesterday_time.getTime()-(1000*60*60*24));
			yesterTime=format.format(ytTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * 7战斗大厅、 22科研所、205 公会模块检测、 19拍卖行模块检测 、6 机库模块检测 
		 * 208 叫宝藏岛模块检测、 18商城、210 后山矿洞 、211竞技场模块 、212 排行榜、4外遇远征
		 **/
		String _datetime="";
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
		_datetime=tempDate.format(new java.util.Date());
		EntityCheckBuildDetail ecbd = new EntityCheckBuildDetail();
		ecbd.setDateTime(_datetime);
		ecbd.setZddt(this.getCaseLogService().staicPublic(getCheckDayByTime(7,yesterTime),
				_datetime,7).size());
		ecbd.setKyzx(this.getCaseLogService().staicPublic(getCheckDayByTime(22,yesterTime),
				_datetime,22).size());
		ecbd.setGh(this.getCaseLogService().staicPublic(getCheckDayByTime(205,yesterTime),
				_datetime, 205).size());
		ecbd.setPmh(this.getCaseLogService().staicPublic(getCheckDayByTime(19,yesterTime),
				_datetime, 19).size());
		ecbd.setJk(this.getCaseLogService().staicPublic(getCheckDayByTime(6,yesterTime),
				_datetime, 6).size());
		ecbd.setBzd(this.getCaseLogService().staicPublic(getCheckDayByTime(208,yesterTime),
				_datetime, 208).size());
		ecbd.setSc(this.getCaseLogService().staicPublic(getCheckDayByTime(18,yesterTime),
				_datetime,18).size());
		ecbd.setHskd(this.getCaseLogService().staicPublic(getCheckDayByTime(210,yesterTime),
				_datetime, 210).size());
		
		ecbd.setPhb(this.getCaseLogService().staicPublic(getCheckDayByTime(24,yesterTime),
				_datetime, 24).size());
		ecbd.setWyyz(this.getCaseLogService().staicPublic(getCheckDayByTime(4,yesterTime),
				_datetime, 4).size());
		this.publicfunctionForDay(100, ecbd,yesterTime);
	}
	
	
	// ** timer check_day
public void check_DayYesterday(String likeTime){
		Date yesterday_time=null;
		Date ytTime=null;
		String yesterTime="";
		List<EntityCheckDayDetail> lecdd = new ArrayList<EntityCheckDayDetail>();// 封裝採集到的最後的數據
			SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
		try {
			yesterday_time=tempDate.parse(likeTime);
			ytTime=new Date(yesterday_time.getTime()-(1000*60*60*24));
			yesterTime=tempDate.format(ytTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			EntityCheckDayDetail ecld = new EntityCheckDayDetail();
			ecld.setDate(yesterTime);
			ecld.setAllUserLogin(this.getCaseLogService().noRepleAll(getCheckDayByTime(3,yesterTime), 3).size());
			ecld.setNoRepeatlogoin(ecld.getAllUserLogin());
			ecld.setPzwb(this.getCaseLogService().staicPublic(getCheckDayByTime(88,yesterTime), yesterTime,
					88).size());
			ecld.setTygjmb(this.getCaseLogService().staicPublic(getCheckDayByTime(89,yesterTime),
					yesterTime, 89).size());
			ecld.setYxb(this.getCaseLogService().staicPublic(getCheckDayByTime(90,yesterTime), yesterTime,
					90).size());
//			ecld.setLjserver(this.getCaseLogService().staicPublic(getCheckDay(91),
//					_datetime, 91).size());
//			ecld.setLjltserver(this.getCaseLogService().staicPublic(getCheckDay(92),
//					_datetime, 92).size());
			ecld.setJzmxsj(this.getCaseLogService().staicPublic(getCheckDayByTime(93,yesterTime),
					yesterTime, 93).size());
			ecld.setHqphb(this.getCaseLogService().staicPublic(getCheckDayByTime(94,yesterTime),
					yesterTime, 94).size());
			ecld.setHqghlb(this.getCaseLogService().staicPublic(getCheckDayByTime(95,yesterTime),
					yesterTime, 95).size());
			ecld.setHqdqlb(this.getCaseLogService().staicPublic(getCheckDayByTime(96,yesterTime),
					yesterTime, 96).size());
			ecld.setHqdzdh(this.getCaseLogService().staicPublic(getCheckDayByTime(97,yesterTime),
					yesterTime, 97).size());
			ecld.setHqwjxx(this.getCaseLogService().staicPublic(getCheckDayByTime(98,yesterTime),
					yesterTime, 98).size());
			ecld.setJzcjrwjm(this.getCaseLogService().staicPublic(getCheckDayByTime(99,yesterTime),
					yesterTime, 99).size());
			ecld.setJazjm(this.getCaseLogService().staicPublic(getCheckDayByTime(100,yesterTime),
					yesterTime, 100).size());
			ecld.setJzxsbz(this.getCaseLogService().staicPublic(getCheckDayByTime(101,yesterTime),
					yesterTime, 101).size());
			ecld.setJzdtjm(this.getCaseLogService().staicPublic(getCheckDayByTime(102,yesterTime),
					yesterTime, 102).size());
			ecld.setJzfjjm(this.getCaseLogService().staicPublic(getCheckDayByTime(103,yesterTime),
					yesterTime, 103).size());
			ecld.setJzzdjm(this.getCaseLogService().staicPublic(getCheckDayByTime(104,yesterTime),
					yesterTime, 104).size());
			ecld.setJzadzy(this.getCaseLogService().staicPublic(getCheckDayByTime(105,yesterTime),
					yesterTime, 105).size());
			lecdd.add(ecld);
		this.publicfunctionForDay(99, ecld,yesterTime);
	}
	
	/**
	 * 查看前一天的數據採集的內容
	 * 
	 */
	public String checkDays() {
		//** 判断当前的时间是不是凌晨 2:00
	
		return "test";
	}
	
	
	
	
	/*查看当前的道具销量*/
	public String checkItem(){
		//HashMap<String,HashMap<String,Object>> results = new HashMap<String,HashMap<String,Object>>();
		EntityGameItemDetail egid;
		String _datetime="";
		String createTime1=this.request.getParameter("stime1");
		String createTime2=this.request.getParameter("stime2");
		//List<EntityCaseLogDetail> liste=getEcld_list();
		
		List<EntityGameItemDetail> legid= new ArrayList<EntityGameItemDetail>();
		/* 因为是按销量所有不用去屏蔽相同的ip或者相同的道具 */
		/* 获取数据里面的日期，判断这是多少天的数据 */
//		List<EntityCaseLogDetail> date_list=this.getCaseLogService().getAllDateList(liste);
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
			//List<EntityCaseLogDetail> lecld=getCaseLogService().getAllDateListTimeToTime(liste,createTime1,createTime2);
			//date_list=this.getCaseLogService().getAllDateList(lecld);
			}
		/* 循环输出获取 每一天的数据 */													
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
		_datetime=tempDate.format(new java.util.Date());
		egid= new EntityGameItemDetail();
			egid.setDate(_datetime);
		/* 获取所有的rmb道具的购买次数 */
			//List<EntityCaseLogDetail> rmbitem=this.getCaseLogService().getBuyRmbItem(getCheckDay(70), _datetime);
			egid.setRmbItem(getCheckDay(70).size());
		/* 获取强化次数 */				//egid.setIntensify(this.getCaseLogService().getIntensify(getCheckDay(79), _datetime).size());
			egid.setIntensify(getCheckDay(79).size());
		/* 获取强化次数里面使用过的道具数量 */	
			
			
		/* 获取道具合成的总次数 */
			//egid.setSynthesis(this.getCaseLogService().getSynthesis(getCheckDay(77), _datetime).size());
			egid.setSynthesis(getCheckDay(77).size());
			//egid.setSynthesisItem(this.getCaseLogService().getSynthesisItem(getCheckDay(78), _datetime).size());
			egid.setSynthesisItem(getCheckDay(78).size());
			legid.add(egid);
			this.publicfunction(3, egid);
	
		Map<String, Object> fdParm = new HashMap<String, Object>();
		fdParm.put("lag_type", 3);
		
		/**
		 * 进行分页处理。。查看一共相关的信息有多少条
		 */
		int pages=0;
		int count=this.getCaseInfoService().searchCount(fdParm);
		int pagesize=25;
		String cutterPage=request.getParameter("page");
		int cp=0;
		if(cutterPage==null || cutterPage.equals("")){
			cp=0;
		}else
		{
			cp=Integer.parseInt(cutterPage);
		}
		if(count%pagesize>0 && count/pagesize>0){
			pages=count/pagesize+1;
		}else{
			pages=0;
		}
		fdParm.put("limit1", cp*pagesize);
		fdParm.put("limit2", pagesize);
		
		List<EntityCaseInfoDetail> result = this.getCaseInfoService().findAll(
				fdParm);
		
		List<EntityGameItemDetail> rs_l = new ArrayList<EntityGameItemDetail>();
		for (EntityCaseInfoDetail ecid : result) {
			EntityGameItemDetail tempecd = new EntityGameItemDetail();
		    tempecd = (EntityGameItemDetail) JSON
					.parseObject(ecid.getLag_info(), EntityGameItemDetail.class);
			rs_l.add(tempecd);
		}
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("results", rs_l);
		resultMap.put("pages", pages);
		resultMap.put("cutterPage", 0);
		resultMap.put("getTime",_datetime);
		request.setAttribute("results", resultMap);
		return "succ";
		}
	
	/* 根据时间查看当前的道具销量 */
	public String checkItemForDay(){
		EntityGameItemDetail egid;
		String _datetime="";
		String createTime1=this.request.getParameter("stime1");
		
		
		
		/* 循环输出获取 每一天的数据 */													
		
		egid= new EntityGameItemDetail();
			egid.setDate(createTime1);
			egid.setRmbItem(getCheckDayNoRep(70,createTime1));
			egid.setIntensify(getCheckDayNoRep(79,createTime1));
		
			egid.setSynthesis(getCheckDayNoRep(77,createTime1));
			egid.setSynthesisItem(getCheckDayNoRep(78,createTime1));
			
			//this.publicfunction(3, egid);
			publicfunctionForDay(3,egid,createTime1);
	
//		Map<String, Object> fdParm = new HashMap<String, Object>();
//		fdParm.put("lag_type", 3);
//		List<EntityCaseInfoDetail> result = this.getCaseInfoService().findAll(
//				fdParm);
//		List<EntityGameItemDetail> rs_l = new ArrayList<EntityGameItemDetail>();
//		for (EntityCaseInfoDetail ecid : result) {
//			EntityGameItemDetail tempecd = new EntityGameItemDetail();
//		    tempecd = (EntityGameItemDetail) JSON
//					.parseObject(ecid.getLag_info(), EntityGameItemDetail.class);
//			rs_l.add(tempecd);
//		}
//		Map<String,Object> resultMap= new HashMap<String,Object>();
//		resultMap.put("results", rs_l);
//		resultMap.put("getTime",_datetime);
//		request.setAttribute("results", resultMap);
		return "succ";
		}
	
	/**
	 * 查看前一天的数据
	 */
	public void checkItemYesterDay(String liketime){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date yesterday_time=null;
		Date ytTime=null;
		String yesterTime="";
		try {
			yesterday_time=format.parse(liketime);
			ytTime=new Date(yesterday_time.getTime()-(1000*60*60*24));
			yesterTime=format.format(ytTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EntityGameItemDetail egid;
		String _datetime="";
		List<EntityGameItemDetail> legid= new ArrayList<EntityGameItemDetail>();
		/* 循环输出获取 每一天的数据 */													
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
		_datetime=tempDate.format(new java.util.Date());
		egid= new EntityGameItemDetail();
			egid.setDate(_datetime);
			egid.setRmbItem(getCheckDayByTime(70,yesterTime).size());
			egid.setIntensify(getCheckDayByTime(79,yesterTime).size());
			egid.setSynthesis(getCheckDayByTime(77,yesterTime).size());
			egid.setSynthesisItem(getCheckDayByTime(78,yesterTime).size());
			this.publicfunctionForDay(3, egid,yesterTime);
		}
	
	/**
	 * 获取工会成员的信息
	 * @return
	 */
	 public String checkGuild(){
//		 String Date=this.request.getParameter("startDate");
		 Map<String,Object> parm = new HashMap<String,Object>();
		 
		 int pages=0;
		 Map<String,Object> fdParm= new HashMap<String,Object>();
			int count=this.getGameConSortialService().searchCountConsortia(fdParm);
			int pagesize=25;
			String cutterPage=request.getParameter("page");
			int cp=0;
			if(cutterPage==null || cutterPage.equals("")){
				cp=0;
			}else
			{
				cp=Integer.parseInt(cutterPage);
			}
			if(count%pagesize>0 && count/pagesize>0){
				pages=count/pagesize+1;
			}else{
				pages=0;
			}
			fdParm.put("limit1", cp*pagesize);
			fdParm.put("limit2", pagesize);
			
			List<EntityGameConsortiaDetail> temp=this.getGameConSortialService().getAllConsortiaInfo(fdParm);
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
		 
//		 this.publicfunction(2, re_list);//工会类别信息
//		//信息获取
//		 Map<String, Object> fdParm = new HashMap<String, Object>();
//			fdParm.put("lag_type", 2);
//			List<EntityCaseInfoDetail> result = this.getCaseInfoService().findAll(
//					fdParm);
//			List<EntityGameConsortiaDetail> rs_l = new ArrayList<EntityGameConsortiaDetail>();
//			for (EntityCaseInfoDetail ecid : result) {
//				EntityGameItemDetail tempecd = new EntityGameItemDetail();
//				rs_l=JSON.parseArray(ecid.getLag_info(), EntityGameConsortiaDetail.class);
//			}
//		 request.setAttribute("results",rs_l);
		 
		 Map<String,Object> resultMap = new HashMap<String,Object>();
			resultMap.put("results", re_list);
			resultMap.put("pages", pages);
			resultMap.put("cutterPage", 0);
			request.setAttribute("results", resultMap);
		 
		 //request.setAttribute("results", re_list);
		 return "succ";
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
			//List<EntityCaseLogDetail> liste = getEcld_list();
			List<EntityItemAllDetail> leial = new ArrayList<EntityItemAllDetail>();//所有道具的集合
			List<EntityGameItemDetail> legid = new ArrayList<EntityGameItemDetail>();
			List<EntityCaseItmeDetail> lecid = new ArrayList<EntityCaseItmeDetail>();
			List<EntityCheckSellItemDetail> lsellitem = new ArrayList<EntityCheckSellItemDetail>();
			/* 因为是按销量所有不用去屏蔽相同的ip或者相同的道具 */
			/* 获取数据里面的日期，判断这是多少天的数据 */
			//List<EntityCaseLogDetail> date_list=this.getCaseLogService().getAllDateList(liste);
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
				
				}
			/* 循环输出获取 每一天的购买数据 */
			String likeTime =request.getParameter("getTime");
			if(likeTime==null){
			SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
			_datetime=tempDate.format(new java.util.Date());
			}else{
			_datetime=likeTime;
			}
			String _datetimes="2012-06";
//				List<EntityCaseLogDetail> rmbitem=this.getCaseLogService().getBuyRmbItem(liste, _datetime);
			List<EntityCaseLogDetail> rmbitem=getBuyOrSellItemInfoForMonth(70,_datetimes);
//				List<EntityCaseLogDetail> sellitem=this.getCaseLogService().staicPublic(liste, _datetime, 73);
			List<EntityCaseLogDetail> sellitem=getBuyOrSellItemInfoForMonth(73,_datetimes);
				for(EntityCaseLogDetail ecld : rmbitem){
					/* 获取字段中的主类型,根jin不同的主类型返回数据集合 */
					EntityItemAllDetail eiad=new EntityItemAllDetail();
					/* 先将数据 清理掉头和尾 */		
					tempa=ecld.getCase_ex_desc().substring(1,ecld.getCase_ex_desc().length()-1).split(",");
					if(!ecld.getCase_ex_desc().equals("null")){
						//System.out.println(ecld.getId()+"|"+ecld.getCase_ex_desc());
					if(tempa.length>1){
						for(String tm:tempa){
							tempArray=tm.substring(1,tm.length()-1).split("-");
							tpmint=Integer.parseInt(tempArray[0]);	
							if(itemType > 0 && itemType < 5 ){ //1~4的类型才是所需要的类型（1-飞机，2-装备，3-道具，4-装扮）
							if(itemType==tpmint){//值匹配和属性相同类型的道具
								
									EntityCaseItmeDetail ecid = new EntityCaseItmeDetail();
									ecid.setMasttypeId(Integer.parseInt(tempArray[0]));
									ecid.setItemId(Integer.parseInt(tempArray[1]));
									ecid.setBuyNum(Integer.parseInt(tempArray[2]));
									lecid.add(ecid);
								}
							}
						}
					}else {
						tempArray=ecld.getCase_ex_desc().substring(2,ecld.getCase_ex_desc().length()-2).split("-");
						String temp1=tempArray[0];
						if(!temp1.equals("null") && !temp1.equals("undefined")){
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
			}
				//循环获取 每天消耗掉的道具	
				
				for(EntityCaseLogDetail ecld : sellitem){
					/* 获取字段中的主类型,根据不同的主类型返回数据集合 */
					List<EntityCheckSellItemDetail> lecsid=new ArrayList<EntityCheckSellItemDetail>();
					/* 先将数据 清理掉头和尾 */
					tempa=ecld.getCase_ex_desc().substring(1,ecld.getCase_ex_desc().length()-1).split(",");
					//System.out.println(ecld.getId()+"-"+ecld.getCase_ex_desc().substring(2,ecld.getCase_ex_desc().length()-2) );
					if(!ecld.getCase_ex_desc().equals("null")){
					if(tempa.length>1 ){
						for(String tm:tempa){
							tempArray=tm.substring(1,tm.length()-1).split("-");
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
						tempArray=ecld.getCase_ex_desc().substring(2,ecld.getCase_ex_desc().length()-2).split("-");
						String temp1=tempArray[0];
						if(!temp1.equals("null") && !temp1.equals("") && !temp1.equals("undefined") ){
							tpmint=Integer.parseInt(tempArray[0]);	
							if(itemType > 0 && itemType < 5 ){ //1~4的类型才是所需要的类型（1-飞机，2-装备，3-道具，4-装扮）
								if(itemType==tpmint){//值匹配和属性相同类型的道具
									//System.out.println("else"+tpmint);
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
			 */Map<String,Object> resultMap = new HashMap<String,Object>();
			switch(itemType){
			case 1://对飞机的数据处理
				List<EntityGamePlaneDetail> legpd=this.checkTopPlane(lecid,lsellitem);
				//**开始便利里面的所有的数据，插入caseInfo
				//this.publicfunction(4, legpd);
				this.publicfunctionForDay(4, legpd, _datetime);
				//信息获取
				 Map<String, Object> fdParm = new HashMap<String, Object>();
					fdParm.put("lag_type", 4);
					List<EntityCaseInfoDetail> result = this.getCaseInfoService().findAll(
							fdParm);
					List<EntityGamePlaneDetail> rs_l = new ArrayList<EntityGamePlaneDetail>();
					for (EntityCaseInfoDetail ecid : result) {
						if(ecid.getLag_time().substring(0,10).equals(_datetime)){
							rs_l=JSON.parseArray(ecid.getLag_info(), EntityGamePlaneDetail.class);
						}
					}
					
					resultMap.put("results", rs_l);
					resultMap.put("getTime", _datetime);
				request.setAttribute("results", resultMap);resu="succ1";
				break;
			case 2://对装备的数据处理
				List<EntityGameEquipDetail> leged=this.checkTopEquip(lecid,lsellitem);
				//**开始便利里面的所有的数据，插入caseInfo
//				this.publicfunction(13, leged);
				this.publicfunctionForDay(13, leged, _datetime);
				//信息获取
				  fdParm = new HashMap<String, Object>();
					fdParm.put("lag_type", 13);
					List<EntityCaseInfoDetail> result_13 = this.getCaseInfoService().findAll(
							fdParm);
					List<EntityGameEquipDetail> rs_l_13 = new ArrayList<EntityGameEquipDetail>();
					for (EntityCaseInfoDetail ecid : result_13) {
						if(ecid.getLag_time().substring(0,10).equals(_datetime)){
						rs_l_13=JSON.parseArray(ecid.getLag_info(), EntityGameEquipDetail.class);
						}
					}
					resultMap.put("results", rs_l_13);
					resultMap.put("getTime", _datetime);
				request.setAttribute("results", resultMap);resu="succ2";
				break;
			case 3://对道具的数据处理
				List<EntityGameItemsDetail> legid2=this.checkTopItem(lecid,lsellitem);
				//**开始便利里面的所有的数据，插入caseInfo
//				this.publicfunction(15, legid2);
				this.publicfunctionForDay(15, legid2, _datetime);
				//信息获取
				  fdParm = new HashMap<String, Object>();
					fdParm.put("lag_type", 15);
					 result = this.getCaseInfoService().findAll(
							fdParm);
					 List<EntityGameItemsDetail>rs_l_15 = new ArrayList<EntityGameItemsDetail>();
					for (EntityCaseInfoDetail ecid : result) {
						if(ecid.getLag_time().substring(0,10).equals(_datetime)){
						rs_l_15=JSON.parseArray(ecid.getLag_info(), EntityGameItemsDetail.class);
						}
					}
					resultMap.put("results", rs_l_15);
					resultMap.put("getTime", _datetime);
				request.setAttribute("results", resultMap);resu="succ3";
				break;
			case 4://对装扮的数据处理
				List<EntityGameAvatarDetail> legad=this.checkTopAvatar(lecid,lsellitem);
				//**开始便利里面的所有的数据，插入caseInfo
//				this.publicfunction(14, legad);
				this.publicfunctionForDay(14, legad, _datetime);
				//信息获取
				  fdParm = new HashMap<String, Object>();
					fdParm.put("lag_type", 14);
					 result = this.getCaseInfoService().findAll(
							fdParm);
					 List<EntityGameAvatarDetail> rs_l_14 = new ArrayList<EntityGameAvatarDetail>();
					for (EntityCaseInfoDetail ecid : result) {
						if(ecid.getLag_time().substring(0,10).equals(_datetime)){
						rs_l_14=JSON.parseArray(ecid.getLag_info(), EntityGameAvatarDetail.class);
						}	
					}
					resultMap.put("results", rs_l_14);
					resultMap.put("getTime", _datetime);
				request.setAttribute("results", resultMap);resu="succ4";
				break;
			}
			return resu;
		}
	 
	 
	 /* 飞机排行榜 */
		public List<EntityGamePlaneDetail> checkTopPlane(List<EntityCaseItmeDetail> lecid,List<EntityCheckSellItemDetail> sellitem){
			
			List<EntityGamePlaneDetail> legpd=null;
			Map<String,Object> parm = new HashMap<String,Object>();
			parm.put("isMarket", 1);
			legpd=this.getGamePlaneService().getAllInfo(parm);
//			for(EntityGamePlaneDetail egpds:legpd){
//				try {
//					egpds.setPlaneName(java.net.URLEncoder.encode(egpds.getPlaneName(),"UTF-8"));
//				} catch (UnsupportedEncodingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
				
					for(EntityGamePlaneDetail egpd : legpd){
						for(EntityCaseItmeDetail ecid:lecid){
						//System.out.print(egpd.getId()+"-"+ecid.getItemId());
						if(egpd.getId()==ecid.getItemId()){
							if(ecid.getBuyNum()>0){
								egpd.setNum(egpd.getNum()+ecid.getBuyNum());
							}
						}
				}
					
			}
					for(EntityGamePlaneDetail egpd : legpd){
				for(EntityCheckSellItemDetail ecsid:sellitem){
					
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
			parm.put("isMarket", 1);
			legids = this.getGameItemService().getAllInfo(parm);
//			for(EntityGameItemsDetail egids:legids){
//				try {
//					egids.setItemName(java.net.URLEncoder.encode(egids.getItemName(),"UTF-8"));
//				} catch (UnsupportedEncodingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
			for(EntityGameItemsDetail egids : legids){
			for(EntityCaseItmeDetail ecid:lecid){
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
			for(EntityGameItemsDetail egid : legids){
			for(EntityCheckSellItemDetail ecsid:sellitem){
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
			parm.put("isMarket", 1);
			legad = this.getGameAvatarService().getAllInfo(parm);
//			for(EntityGameAvatarDetail egad:legad){
//				try {
//					
//					egad.setAvatarName(java.net.URLEncoder.encode(egad.getAvatarName(),"UTF-8"));
//				} catch (UnsupportedEncodingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
			
			for(EntityGameAvatarDetail egad : legad){
			for(EntityCaseItmeDetail ecid:lecid){
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
			parm.put("isMarket", 1);
			leged =this.getGameEquipService().getAllInfo(parm);
//			for(EntityGameEquipDetail eged:leged){
//				try {
//					
//					eged.setEquipName(java.net.URLEncoder.encode(eged.getEquipName(),"UTF-8"));
//				} catch (UnsupportedEncodingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
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
	
		/* fb采集 */
		public String checkfb(){
			String st=checkFunction();
//			List<EntityCaseLogDetail> liste = getEcld_list();
//			List<EntityCaseLogDetail> date_list=this.getCaseLogService().getAllDateList(liste);
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
//				List<EntityCaseLogDetail> lecld=getCaseLogService().getAllDateListTimeToTime(liste,createTime1,createTime2);
//				date_list=this.getCaseLogService().getAllDateList(lecld);
				}
			SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
			_datetime=tempDate.format(new java.util.Date());
			List<EntityCheckFbDetail> lecfd = new ArrayList<EntityCheckFbDetail>();
				EntityCheckFbDetail ecfd = new EntityCheckFbDetail();
				
				ecfd.setDatetime(_datetime);
				// fb进入数 84 、 胜利数86、失败数87
			
				ecfd.setFbwin(getCheckDay(86).size());
				ecfd.setFblost(getCheckDay(87).size());
				ecfd.setFbnum(ecfd.getFbwin()+ecfd.getFblost()); 
				lecfd.add(ecfd);
			this.publicfunctionForDay(5, lecfd,_datetime);
			
			Map<String,Object> fdParm = new HashMap<String, Object>();
				fdParm.put("lag_type", 5);
				/**
				 * 进行分页处理。。查看一共相关的信息有多少条
				 */
				int pages=0;
				int count=this.getCaseInfoService().searchCount(fdParm);
				int pagesize=25;
				String cutterPage=request.getParameter("page");
				int cp=0;
				if(cutterPage==null || cutterPage.equals("")){
					cp=0;
				}else
				{
					cp=Integer.parseInt(cutterPage);
				}
				if(count%pagesize>0 && count/pagesize>0){
					pages=count/pagesize+1;
				
				}else{
					pages=0;
				}
				
				fdParm.put("limit1", cp*pagesize);
				fdParm.put("limit2", pagesize);
				List<EntityCaseInfoDetail> result = this.getCaseInfoService().findAll(
						fdParm);
				 List<EntityCheckFbDetail> rs_1 = new ArrayList<EntityCheckFbDetail>();
				for (EntityCaseInfoDetail ecid : result) {
					if(ecid.getLag_time().toString().substring(0,10).equals(_datetime)){
					rs_1=JSON.parseArray(ecid.getLag_info(), EntityCheckFbDetail.class);
					}
				}
				Map<String,Object> resultMap = new HashMap<String,Object>();
				resultMap.put("results", rs_1);
				resultMap.put("pages", pages);
				resultMap.put("cutterPage", 0);
			request.setAttribute("results", resultMap);
				return st;
		}
		
		
		
		public void checkfbYesterday(String liketime){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date yesterday_time=null;
			Date ytTime=null;
			String yesterTime="";
			try {
				yesterday_time=format.parse(liketime);
				ytTime=new Date(yesterday_time.getTime()-(1000*60*60*24));
				yesterTime=format.format(ytTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			List<EntityCheckFbDetail> lecfd = new ArrayList<EntityCheckFbDetail>();
				EntityCheckFbDetail ecfd = new EntityCheckFbDetail();
				
				ecfd.setDatetime(liketime);
				// fb进入数 84 、 胜利数86、失败数87
			
				ecfd.setFbwin(getCheckDayByTime(86,yesterTime).size());
				ecfd.setFblost(getCheckDayByTime(87,yesterTime).size());
				ecfd.setFbnum(ecfd.getFbwin()+ecfd.getFblost()); 
				lecfd.add(ecfd);
			this.publicfunctionForDay(5, lecfd,yesterTime);
			
		}
		
		/**
		 * 战斗场次统计
		 * 
		 */
		public String checkBattle(){
			String st=checkFunction();
			//List<EntityCaseLogDetail> liste = getEcld_list();
//			List<EntityCaseLogDetail> date_list=this.getCaseLogService().getAllDateList(liste);
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
//				List<EntityCaseLogDetail> lecld=getCaseLogService().getAllDateListTimeToTime(liste,createTime1,createTime2);
//				date_list=this.getCaseLogService().getAllDateList(lecld);
				}
			
			SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
			_datetime=tempDate.format(new java.util.Date());
				leclds=this.getCaseLogService().checkBattle(this.getCheckDay(106), _datetime);
				for(EntityCaseLogDetail ed:leclds){
					
					EntityCheckBattleDetail ecbd= new EntityCheckBattleDetail();
					//0房间号，1房间类型，2战斗类型，3开始时间，4结束时间，5玩家总数，6地图编号，7a队伍，8b队伍 9获胜队伍。个队伍剩余人数
					String[] tempArray=ed.getCase_ex_desc().toString().split("-");
//					System.out.println("id"+ed.getId()+"-"+tempArray.length);
					if(tempArray.length==10){
					ecbd.setRoomNum(Integer.parseInt(tempArray[0]));
					ecbd.setRoomType(Integer.parseInt(tempArray[1]));
					ecbd.setBattleType(Integer.parseInt(tempArray[2]));
					ecbd.setStartTime(Long.parseLong(tempArray[3]));
					ecbd.setEndTime(Long.parseLong(tempArray[4]));
					ecbd.setPlayerCount(Integer.parseInt(tempArray[5]));
					if(tempArray[6].equals("null") || tempArray[6].equals("")){
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
				//** 统计这票数据 统计地图热度
				checkMap(lecbd,_datetime);
				this.publicfunctionForDay(8, lecbd,_datetime);
			Map<String,Object> fdParm = new HashMap<String, Object>();
			fdParm.put("lag_type", 8);
			fdParm.put("likeTime", _datetime);
			List<EntityCaseInfoDetail> result = this.getCaseInfoService().findAll(
					fdParm);
			 List<EntityCheckBattleDetail> rs_1 = new ArrayList<EntityCheckBattleDetail>();
			for (EntityCaseInfoDetail ecid : result) {
				if(ecid.getLag_time().toString().substring(0,10).equals(_datetime)){
					rs_1=JSON.parseArray(ecid.getLag_info(), EntityCheckBattleDetail.class);
				}
			}
			request.setAttribute("results", rs_1);
			return st;
		}
		
		/**
		 * 根据时间来获取地图热度
		 */
		public String checkBattleForDay(){
			String _datetime=request.getParameter("startTime").substring(0,10);
		
			List<EntityCaseLogDetail> leclds=new ArrayList<EntityCaseLogDetail>();
			List<EntityCheckBattleDetail> lecbd = new ArrayList<EntityCheckBattleDetail>();

			
			SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
			
//				leclds=this.getCaseLogService().checkBattle(this.getCheckDay(106), _datetime);
				leclds=this.getCaseLogService().checkBattle(this.getCheckDayByTime(106, _datetime), _datetime);
				for(EntityCaseLogDetail ed:leclds){
					EntityCheckBattleDetail ecbd= new EntityCheckBattleDetail();
					//房间号，房间类型，战斗类型，开始时间，结束时间，玩家总数，地图编号，a队伍，b队伍 获胜队伍。个队伍剩余人数
					//1-        2-       2- 1320233541406-1320233996281-6-0-[9052,4726,6207]-[]-1
					String[] tempArray=ed.getCase_ex_desc().toString().split("-");
//					System.out.println("id"+ed.getId()+"-"+tempArray.length);
					if(tempArray.length==10){
					ecbd.setRoomNum(Integer.parseInt(tempArray[0]));
					ecbd.setRoomType(Integer.parseInt(tempArray[1]));
					ecbd.setBattleType(Integer.parseInt(tempArray[2]));
					ecbd.setStartTime(Long.parseLong(tempArray[3]));
					ecbd.setEndTime(Long.parseLong(tempArray[4]));
					ecbd.setPlayerCount(Integer.parseInt(tempArray[5]));
					if(tempArray[6].equals("null") || tempArray[6].equals("")){
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
				//** 统计这票数据 统计地图热度
				checkMap(lecbd,_datetime);
				this.publicfunctionForDay(8, lecbd,_datetime);
			getCheckMap();
			Map<String,Object> fdParm = new HashMap<String, Object>();
			fdParm.put("lag_type", 8);
			List<EntityCaseInfoDetail> result = this.getCaseInfoService().findAll(
					fdParm);
			 List<EntityCheckBattleDetail> rs_1 = new ArrayList<EntityCheckBattleDetail>();
			for (EntityCaseInfoDetail ecid : result) {
				if(ecid.getLag_time().toString().substring(0,10).equals(_datetime)){
					rs_1=JSON.parseArray(ecid.getLag_info(), EntityCheckBattleDetail.class);
				}
			}
			request.setAttribute("results", rs_1);
			return "succ";
		}
		
		
		/**
		 * 地图 map检测热度分析
		 * @return
		 */
		public void checkMap(List<EntityCheckBattleDetail> ecbdlist,String liketime){
			Map<String,Object> params = new HashMap<String,Object>();
			// *  获取地图的所有信息
			GameSceneDaoImpl dsdi= new GameSceneDaoImpl();
			Map<String,Object> voidMap = new HashMap<String,Object>();
			List<GameSceneDetail> lgsd = dsdi.getGameScene(voidMap);
			boolean flag=true;
			String mapName="";
			for(EntityCheckBattleDetail ecbd:ecbdlist){
				for(GameSceneDetail gsdi:lgsd){
					if(gsdi.getId()==ecbd.getMapId()){
						mapName=gsdi.getSceneName();break;
					}
				}
				if(params.size()==0){					
					params.put(mapName, 1);
				}else{
					Iterator<Map.Entry<String,Object>> it = params.entrySet().iterator();
					while(it.hasNext()){
						Map.Entry entry= it.next();
						//System.out.println(entry.getKey()+"-"+mapName);
						if(entry.getKey().equals(mapName)){
							entry.setValue(Integer.parseInt(entry.getValue()+"")+1);
							flag=false;break;
						}else{
							flag=true;
						}
						}
					if(flag){
						params.put(mapName, 1);
					}
					}
				}
		
			//** 将信息插入到case_info 里面去
				this.publicfunctionForDay(97, params, liketime);
			}
		
		public String getCheckMap(){
			String likeTime=request.getParameter("stime1");
			if(likeTime==null){
				likeTime=this.timeSearch(3).substring(0,10);
			}
			Map<String,Object> fdParm = new HashMap<String, Object>();
			fdParm.put("lag_type", 97);
			List<EntityCaseInfoDetail> lecid = this.getCaseInfoService().findAll(
					fdParm);
			List<Map<String,Object>> lresult= new ArrayList<Map<String,Object>>();
			Map<String,Map<String,Object>> result = new HashMap <String,Map<String,Object>>();
			for(EntityCaseInfoDetail ecid:lecid){
				Map<String,Object> tempMap = new HashMap<String,Object>();
//				System.out.println(ecid.getLag_info());
				tempMap=(Map<String,Object>)JSON.parse(ecid.getLag_info());
				result.put(ecid.getLag_time(), tempMap);
				//lresult.add(tempMap);
			}
			request.setAttribute("results", result);
			return "succ";
		}
		
		//** 地图检测，检测昨天的。
		public void checkMapYesterDay(){
			
		}
		
		/**
		 * 在战斗使用技能的数据采集
		 * @return
		 */
		public String checkBattleSkill(){
			String st=checkFunction();
			List<EntityGameSkillDetail> tempgamesill=this.getGameSkillService().getAllInfo();
			//List<EntityCaseLogDetail> liste = getEcld_list();
//			List<EntityCaseLogDetail> date_list=this.getCaseLogService().getAllDateList(liste);
			String createTime1=this.request.getParameter("stime1");
			String createTime2=this.request.getParameter("stime2");
			String _datetime="";
			Map<String,Integer> result = new HashMap<String,Integer>();
			List<EntityCaseLogDetail> leclds=new ArrayList<EntityCaseLogDetail>();
//			List<EntityBattleSkillDetail> lebsd = new ArrayList<EntityBattleSkillDetail>();
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
//					List<EntityCaseLogDetail> lecld=getCaseLogService().getAllDateListTimeToTime(liste,createTime1,createTime2);
//					date_list=this.getCaseLogService().getAllDateList(lecld);
				}
			
				flag=true;
				SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
				_datetime=tempDate.format(new java.util.Date());
				//leclds=this.getCaseLogService().repleAll(liste, 124, _datetime);
				leclds=this.getCheckDay(124);
				for(EntityCaseLogDetail tempecld:leclds){
					String [] tempArr = tempecld.getCase_ex_desc().split("-");
					flag=true;
					for(EntityGameSkillDetail egsd : tempgamesill){
						int a=Integer.parseInt(tempArr[1]);
						int b=Integer.parseInt(egsd.getSkillCode());
						if(a==b){//判断是否是这个技能
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
			
			
			this.publicfunction(9, result);
			Map<String,Object> fdParm = new HashMap<String, Object>();
			fdParm.put("lag_type", 9);
			List<EntityCaseInfoDetail> cis_result = this.getCaseInfoService().findAll(
					fdParm);
			// List<EntityGameSkillDetail> rs_1 = new ArrayList<EntityGameSkillDetail>();
			Map<String,Integer> rs_1=new HashMap<String,Integer>();
			//** 信息是多条的，最终是条 map 数组包含的数组
			List<Map<String,Integer>> lmap= new ArrayList<Map<String,Integer>>();
			Map<String,Map<String,Integer>> mmap= new HashMap<String,Map<String,Integer>>();
			for (EntityCaseInfoDetail ecid : cis_result) {
				
				rs_1=(Map<String,Integer>)JSON.parse(ecid.getLag_info());
				//** 处理多天的记录
				Map<String,Integer> rss=new HashMap<String,Integer>();
				rss=(Map<String,Integer>)JSON.parse(ecid.getLag_info());
				mmap.put(ecid.getLag_time().substring(0,10), rss);
			
			}
			request.setAttribute("results", mmap);
			return st;
		}
		
		//** timer 战斗使用道具
		public void checkBattleSkillForDay(){
			String _datetime = "";
			Date yesterday_time=null;
			Date ytTime=null;
			String yesterTime="";
			List<EntityCheckDayDetail> lecdd = new ArrayList<EntityCheckDayDetail>();// 封裝採集到的最後的數據
				SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
			_datetime=tempDate.format(new java.util.Date());
			try {
				yesterday_time=tempDate.parse(_datetime);
				ytTime=new Date(yesterday_time.getTime()-(1000*60*60*24));
				yesterTime=tempDate.format(ytTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			GameSkillDaoImpl gsdi= new GameSkillDaoImpl();
			Map<String,Object> params= new HashMap<String,Object>();
			params.put("likeTime", yesterTime);
			params.put("ids", 300);
			List<EntityGameSkillDetail> tempgamesill=gsdi.getAllInfo(params);
			Map<String,Integer> result = new HashMap<String,Integer>();
			List<EntityCaseLogDetail> leclds=new ArrayList<EntityCaseLogDetail>();
//			List<EntityBattleSkillDetail> lebsd = new ArrayList<EntityBattleSkillDetail>();
			boolean flag=true;
				// 首先便利出时间区间里面的信息的天数的数据
//					List<EntityCaseLogDetail> lecld=getCaseLogService().getAllDateListTimeToTime(liste,createTime1,createTime2);
//					date_list=this.getCaseLogService().getAllDateList(lecld);
				flag=true;
				
				//leclds=this.getCaseLogService().repleAll(liste, 124, _datetime);
				leclds=this.getCheckDay(124);
				for(EntityCaseLogDetail tempecld:leclds){
					String [] tempArr = tempecld.getCase_ex_desc().split("-");
					flag=true;
					for(EntityGameSkillDetail egsd : tempgamesill){
						int a=Integer.parseInt(tempArr[1]);
						int b=Integer.parseInt(egsd.getSkillCode());
						if(a==b){//判断是否是这个技能
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
			this.publicfunctionForDay(9, result,yesterTime);
		}
		
		
		
		/**
		 * 在战斗使用技能的数据采集
		 * @return
		 */
		public String checkUseSkillAndItem(){
			Map<String,Object> parm = new HashMap<String,Object>();
			parm.put("likeid", 10);
			List<EntityGameItemsDetail> tempGameItems=this.getGameItemService().getAllInfo(parm);
			
			//List<EntityCaseLogDetail> liste = getEcld_list();
			//List<EntityCaseLogDetail> date_list=this.getCaseLogService().getAllDateList(liste);
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
					//List<EntityCaseLogDetail> lecld=getCaseLogService().getAllDateListTimeToTime(liste,createTime1,createTime2);
				//	date_list=this.getCaseLogService().getAllDateList(lecld);
				}
			SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
			_datetime=tempDate.format(new java.util.Date());
				flag=true;
				//leclds=this.getCaseLogService().repleAll(liste, 123, _datetime);
				leclds=this.getCheckDay(123);
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
			
				this.publicfunction(10, result);

				Map<String,Object> fdParm = new HashMap<String, Object>();
				fdParm.put("lag_type", 10);
				List<EntityCaseInfoDetail> cis_result = this.getCaseInfoService().findAll(
						fdParm);
				Map<String,Integer> rs_1=new HashMap<String,Integer>();
				//** 信息是多条的，最终是条 map 数组包含的数组
				List<Map<String,Integer>> lmap= new ArrayList<Map<String,Integer>>();
				Map<String,Map<String,Integer>> mmap= new HashMap<String,Map<String,Integer>>();
				for (EntityCaseInfoDetail ecid : cis_result) {
					rs_1=(Map<String,Integer>)JSON.parse(ecid.getLag_info());
					//** 处理多天的记录
					Map<String,Integer> rss=new HashMap<String,Integer>();
					rss=(Map<String,Integer>)JSON.parse(ecid.getLag_info());
					mmap.put(ecid.getLag_time().substring(0,10), rss);
				}
			request.setAttribute("results", mmap);
			return "succ";
		}
		
		public void checkUseSkillAndItemForDay(){
			String _datetime = "";
			Date yesterday_time=null;
			Date ytTime=null;
			String yesterTime="";
			List<EntityCheckDayDetail> lecdd = new ArrayList<EntityCheckDayDetail>();// 封裝採集到的最後的數據
				SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
			_datetime=tempDate.format(new java.util.Date());
			try {
				yesterday_time=tempDate.parse(_datetime);
				ytTime=new Date(yesterday_time.getTime()-(1000*60*60*24));
				yesterTime=tempDate.format(ytTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			GameSkillDaoImpl gsdi= new GameSkillDaoImpl();
			Map<String,Object> params= new HashMap<String,Object>();
			params.put("likeTime", yesterTime);
			List<EntityGameItemsDetail> tempGameItems=this.getGameItemService().getAllInfo(params);
			Map<String,Integer> result = new HashMap<String,Integer>();
			List<EntityCaseLogDetail> leclds=new ArrayList<EntityCaseLogDetail>();
			boolean flag=true;
			
		
			_datetime=yesterTime;
				flag=true;
				//leclds=this.getCaseLogService().repleAll(liste, 123, _datetime);
				leclds=this.getCheckDay(123);
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
				this.publicfunctionForDay(10, result,yesterTime);
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
			//List<EntityCaseItmeDetail> lecid = new ArrayList<EntityCaseItmeDetail>();
			/* 因为是按销量所有不用去屏蔽相同的ip或者相同的道具 */
			/* 获取数据里面的日期，判断这是多少天的数据 */
			//List<EntityCaseLogDetail> date_list=this.getCaseLogService().getAllDateList(liste);
			//选择时间区间 进这里
			List<EntitySellDetail> lesd=new ArrayList<EntitySellDetail>();
		
				SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
				_datetime=tempDate.format(new java.util.Date());
				EntitySellDetail esd = new EntitySellDetail();
				List<EntityCaseLogDetail> rmbitem=this.getCaseLogService().getBuyRmbItem(liste, _datetime);
				esd.setDatetime(_datetime);
				for(EntityCaseLogDetail ecld : rmbitem){
					/* 获取字段中的主类型,根据不同的主类型返回数据集合 */
					//EntityItemAllDetail eiad=new EntityItemAllDetail();
					/* 先将数据 清理掉头和尾 */
					System.out.printf(ecld.getId()+",");
					tempa=ecld.getCase_ex_desc().substring(1,ecld.getCase_ex_desc().length()-1).split(",");
					if(tempa.length>1){//是多组数据
						for(String tm:tempa){
							tempArray=tm.substring(1,tm.length()-1).split("-");
							if(tempArray.length>1){
							if(Integer.parseInt(tempArray[0].trim()) > 0 && Integer.parseInt(tempArray[0].trim()) < 5 ){ //1~4的类型才是所需要的类型（1-飞机，2-装备，3-道具，4-装扮）
								esd.setSell(esd.getSell()+Integer.parseInt(tempArray[2])*Integer.parseInt(tempArray[3]));
							}
							}
						}
					}else{
						tempArray=ecld.getCase_ex_desc().substring(2,ecld.getCase_ex_desc().length()-2).split("-");
						if(tempArray.length>1){
						String temp1=tempArray[0];
						if(!temp1.equals("null")){
							tpmint=Integer.parseInt(tempArray[0]);	
							if(Integer.parseInt(tempArray[0].trim()) > 0 && Integer.parseInt(tempArray[0].trim()) < 5 ){ //1~4的类型才是所需要的类型（1-飞机，2-装备，3-道具，4-装扮）
								esd.setSell(esd.getSell()+Integer.parseInt(tempArray[2])*Integer.parseInt(tempArray[3]));
							}
					}
					
				}
					}
			}
				lesd.add(esd);//服务器的消耗
		
			
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
				/* 新建一个数组来保存当前充值的用户 */
			for(String temp:tmp){
				for(EntitySellDetail esd1 : lesd){
					if(esd1.getDatetime().equals(temp)){
						//查看充值表里面有没有当天的记录
						for(EntityOrderInfoDetail eoid:leoid){
								if(eoid.getDataTime().substring(0,10).equals(temp)){
									ArrayList<String> payuser = new ArrayList<String>();
								esd1.setPayMoney(esd1.getPayMoney()+eoid.getPoint());//获取当天的充值数，默认0
								if(payuser.size()==0){
									  payuser.add(eoid.getMember_username());
									}else{
										for(String username:payuser){
											if(!username.equals(eoid.getMember_username())){
												payuser.add(eoid.getMember_username());
											}
										}
									}
								esd1.setPayCount(esd1.getPayCount()+1);
								esd1.setPayCountpeople(payuser.size());
							}
						}
					}
					money=money-esd1.getSell();
					esd1.setServerMoney(money);//当前服务器的金币数
					esd1.setServerCountPeople(this.getCaseLogService().noRepleAll(getEcld_list(),69).size());
				}
				
			}
			this.publicfunction(7, lesd);
			
			Map<String,Object> fdParm = new HashMap<String, Object>();
			fdParm.put("lag_type", 7);

			/**
			 * 进行分页处理。。查看一共相关的信息有多少条
			 */
			int pages=0;
			int count=this.getCaseInfoService().searchCount(fdParm);
			int pagesize=25;
			String cutterPage=request.getParameter("page");
			int cp=0;
			if(cutterPage==null || cutterPage.equals("")){
				cp=0;
			}else
			{
				cp=Integer.parseInt(cutterPage);
			}
			if(count%pagesize>0 && count/pagesize>0){
				pages=count/pagesize+1;
			}else{
				pages=0;
			}
			fdParm.put("limit1", cp*pagesize);
			fdParm.put("limit2", pagesize);
			
			List<EntityCaseInfoDetail> cis_result = this.getCaseInfoService().findAll(
					fdParm);
			//Map<String,Integer> rs_1=new HashMap<String,Integer>();
			//** 信息是多条的，最终是条 map 数组包含的数组
			
			List<List<EntitySellDetail>> array_result = new ArrayList<List<EntitySellDetail>>();
			for (EntityCaseInfoDetail ecid : cis_result) {
				//** 处理多天的记录
				//Map<String,Integer> rss=new HashMap<String,Integer>();
				List<EntitySellDetail> temp_lesd = new ArrayList<EntitySellDetail>();
				temp_lesd=JSON.parseArray(ecid.getLag_info(),EntitySellDetail.class);
				array_result.add(temp_lesd);
			}
//			request.setAttribute("results", array_result);
			
			
//			List<EntityCaseInfoDetail> result = this.getCaseInfoService().findAll(
//					fdParm);
//			
//			List<EntityGameItemDetail> rs_l = new ArrayList<EntityGameItemDetail>();
//			for (EntityCaseInfoDetail ecid : result) {
//				EntityGameItemDetail tempecd = new EntityGameItemDetail();
//			    tempecd = (EntityGameItemDetail) JSON
//						.parseObject(ecid.getLag_info(), EntityGameItemDetail.class);
//				rs_l.add(tempecd);
//			}
			
			
			
			Map<String,Object> resultMap = new HashMap<String,Object>();
			resultMap.put("results", array_result);
			resultMap.put("pages", pages);
			resultMap.put("cutterPage", 0);
			resultMap.put("getTime",_datetime);
			request.setAttribute("results", resultMap);
			

			return "succ";
		}
		
		//
//		public String checkNoviceOld(){
//			String st= checkFunction();
//			//判断下，昨天的信息是不是最新的。如果不是最新的就更新下昨天的信息,判断case_info里面的 case_time 的最后更新时间是多少
//			String yt_date_time =timeSearch(2).substring(0,10)+" 23:59:59";
//			String cunter_time=timeSearch(3).substring(0,10);
//			Map<String,Object> searMap = new HashMap<String,Object>();			
//			List<EntityCheckNoviceDayDetail> lecndd = new ArrayList<EntityCheckNoviceDayDetail>();
//				SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
//				String _datetime=tempDate.format(new java.util.Date());
//				List<EntityCaseLogDetail> lecld=this.getEcld_list_Novice();
//				EntityCheckNoviceDetail ecnd=this.getCaseLogService().getNovice(lecld,_datetime);
//				this.publicfunction(6, ecnd);
//				Map<String,Object> fdParm = new HashMap<String, Object>();
//				fdParm.put("lag_type", 6);
//				/**
//				 * 进行分页处理。。查看一共相关的信息有多少条
//				 */
//				int pages=0;
//				int count=this.getCaseInfoService().searchCount(fdParm);
//				int pagesize=26;
//				String cutterPage=request.getParameter("page");
//				int cp=0;
//				if(cutterPage==null || cutterPage.equals("")){
//					cp=0;
//				}else
//				{
//					cp=Integer.parseInt(cutterPage);
//				}
//				if(count%pagesize>0 && count/pagesize>0){
//					pages=count/pagesize+1;
//				
//				}else{
//					pages=0;
//				}
//				
//				fdParm.put("limit1", cp*pagesize);
//				fdParm.put("limit2", pagesize);
//				
//				List<EntityCaseInfoDetail> cis_result = this.getCaseInfoService().findAll(fdParm);
//				
//				//** 信息是多条的，最终是条 map 数组包含的数组
//				for (EntityCaseInfoDetail ecid : cis_result) {
//					EntityCheckNoviceDetail temp=(EntityCheckNoviceDetail)JSON.parseObject(ecid.getLag_info(),EntityCheckNoviceDetail.class);
//					EntityCheckNoviceDayDetail ecndd=new EntityCheckNoviceDayDetail();
//					ecndd.setDate(ecid.getLag_time());
//					ecndd.setEcnd(temp);
//					lecndd.add(ecndd);
//				}
//				
//				Map<String,Object> resultMap = new HashMap<String,Object>();
//				resultMap.put("results", lecndd);
//				resultMap.put("pages", pages);
//				resultMap.put("cutterPage", 0);
//				
//			request.setAttribute("results", resultMap);
//				return st;
//		}
		
		public String checkNovice(){
			System.out.print("checkNovice__________3821");
			String st= checkFunction();
			//判断下，昨天的信息是不是最新的。如果不是最新的就更新下昨天的信息,判断case_info里面的 case_time 的最后更新时间是多少
			String yt_date_time =timeSearch(2).substring(0,10)+" 23:59:59";
			String cunter_time=timeSearch(3).substring(0,10);
			Map<String,Object> searMap = new HashMap<String,Object>();			
			List<EntityCheckNoviceDayDetail> lecndd = new ArrayList<EntityCheckNoviceDayDetail>();
				SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
				String _datetime=tempDate.format(new java.util.Date());
				System.out.print("checkNovice__________3830");
				List<Map<String,Object>> lecld=this.getEcld_list_Novice(cunter_time);
				System.out.print("checkNovice__________3832");
				EntityCheckNoviceDetail ecnd=this.getCaseLogService().getNovice(lecld);
				this.publicfunctionForDay(6, ecnd,_datetime);
				//this.publicfunction(6, ecnd);
				Map<String,Object> fdParm = new HashMap<String, Object>();
				fdParm.put("lag_type", 6);
				/**
				 * 进行分页处理。。查看一共相关的信息有多少条
				 */
				int pages=0;
				int count=this.getCaseInfoService().searchCount(fdParm);
				int pagesize=26;
				String cutterPage=request.getParameter("page");
				int cp=0;
				if(cutterPage==null || cutterPage.equals("")){
					cp=0;
				}else
				{
					cp=Integer.parseInt(cutterPage);
				}
				if(count%pagesize>0 && count/pagesize>0){
					pages=count/pagesize+1;
				
				}else{
					pages=0;
				}
				
				fdParm.put("limit1", cp*pagesize);
				fdParm.put("limit2", pagesize);
				
				List<EntityCaseInfoDetail> cis_result = this.getCaseInfoService().findAll(fdParm);
				
				//** 信息是多条的，最终是条 map 数组包含的数组
				for (EntityCaseInfoDetail ecid : cis_result) {
					EntityCheckNoviceDetail temp=(EntityCheckNoviceDetail)JSON.parseObject(ecid.getLag_info(),EntityCheckNoviceDetail.class);
					EntityCheckNoviceDayDetail ecndd=new EntityCheckNoviceDayDetail();
					ecndd.setDate(ecid.getLag_time());
					ecndd.setEcnd(temp);
					lecndd.add(ecndd);
				}
				
				Map<String,Object> resultMap = new HashMap<String,Object>();
				resultMap.put("results", lecndd);
				resultMap.put("pages", pages);
				resultMap.put("cutterPage", 0);
				
			request.setAttribute("results", resultMap);
				return st;
		}
		
		public void checkNoviceYesterDay(String datetime){
			//判断下，昨天的信息是不是最新的。如果不是最新的就更新下昨天的信息,判断case_info里面的 case_time 的最后更新时间是多少
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date yesterday_time=null;
			Date ytTime=null;
			String yesterTime="";
			try {
				yesterday_time=format.parse(datetime);
				ytTime=new Date(yesterday_time.getTime()-(1000*60*60*24));
				yesterTime=format.format(ytTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				//List<Map<String,Object>> lecld=this.getEcld_list_NoviceYesterday();
				List<Map<String,Object>> lecld=this.getEcld_list_Novice(yesterTime);
				System.out.print("_______"+yesterTime);
				EntityCheckNoviceDetail ecnd=this.getCaseLogService().getNovice(lecld);
				this.publicfunctionForDay(6, ecnd,yesterTime);
		}
		
		
		public String checkNoviceForDay(){
			//判断下，昨天的信息是不是最新的。如果不是最新的就更新下昨天的信息,判断case_info里面的 case_time 的最后更新时间是多少
			String likeTime = request.getParameter("startTime");
			System.out.print("_______"+likeTime);
			List<Map<String,Object>> lecld=this.getEcld_list_Novice(likeTime);
			EntityCheckNoviceDetail ecnd=this.getCaseLogService().getNovice(lecld);
			this.publicfunctionForDay(6, ecnd,likeTime);
			return "succ";
		}
		
	public String checkOnlineNum(){
		//List<EntityCaseLogDetail> less=getecld_list_maxOnline();
		String[] result_str=this.getCaseLogService().checkOnlineNum(getecld_list_maxOnline()).split("&");
		String[] date_info=result_str[0].split(",");
		List<String> result_array= new ArrayList<String>();
		for(String temp:date_info){
			result_array.add(temp);
		}
		request.setAttribute("results", result_array);
		//System.exit(0);
		return "succ";
	}
		
	
	
	/**
	 * 采集新手任务数据
	 */
	public String checkTask(){
		String st=checkFunction();
	//	List<EntityCaseLogDetail> liste = getEcld_list();
		//List<EntityCaseLogDetail> date_list=this.getCaseLogService().getAllDateList(liste);
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
			//List<EntityCaseLogDetail> lecld=getCaseLogService().getAllDateListTimeToTime(liste,createTime1,createTime2);
			//date_list=this.getCaseLogService().getAllDateList(lecld);
			}
		List<EntityNoviceTaskDetail> lecndd = new ArrayList<EntityNoviceTaskDetail>();
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
		_datetime=tempDate.format(new java.util.Date());
			//leclds=this.getCaseLogService().repleAll(liste, 107, _datetime);
			leclds=this.getCheckDay(107);
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
			this.publicfunction(11, result);

			Map<String,Object> fdParm = new HashMap<String, Object>();
			fdParm.put("lag_type", 11);
			List<EntityCaseInfoDetail> cis_result = this.getCaseInfoService().findAll(
					fdParm);
			Map<String,Integer> rs_1=new HashMap<String,Integer>();
			//** 信息是多条的，最终是条 map 数组包含的数组
			List<Map<String,Integer>> lmap= new ArrayList<Map<String,Integer>>();
			Map<String,Map<String,Integer>> mmap= new HashMap<String,Map<String,Integer>>();
			for (EntityCaseInfoDetail ecid : cis_result) {
				rs_1=(Map<String,Integer>)JSON.parse(ecid.getLag_info());
				//** 处理多天的记录
				Map<String,Integer> rss=new HashMap<String,Integer>();
				rss=(Map<String,Integer>)JSON.parse(ecid.getLag_info());
				mmap.put(ecid.getLag_time().substring(0,10), rss);
			}
		request.setAttribute("results", mmap);
		return st;
		}
	
	/**
	 * 更具传递进来的值来查询当前这个用户的强化历史
	 * 数据量非常大，时间区间必须存在
	 * @return
	 */
	public String checkQh(){
		Map<String,Object> params = new HashMap<String,Object>();
		String userName=request.getParameter("uname");//用户名字
		//更具用户名字来查询出用户的id
		List<Integer> userId=this.getGameRoleService().getIdByRoleName(StringUtil.uriEncode(userName, GameConstants.FORMAT));
		String stime=request.getParameter("stime");//起始时间
		String etime=request.getParameter("etime");//结束时间
		System.out.print(stime+"-"+etime);
		if (stime != null || etime != null) {// 2个时间只要有任意一个存在就要为另外一个创建初始值
			if (stime == null || stime.equals("")) {
				stime = "1970-01-01";// 意义你懂的
			}
			if (etime == null || etime.equals("")) {
				// 获取当前的时间作为 time2的补全时间
				SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
				etime = tempDate.format(new java.util.Date());
			}
			if(stime.equals(etime)){
				params.put("createTime3", stime);
			}else{
				params.put("createTime1", stime);
				params.put("createTime2", etime);
			}
		}
		params.put("USER_ID", userId.get(0));
		params.put("CASE_ID", 79);
		List<EntityCaseLogDetail> resultList=this.getCaseLogService().getQh(params);//获取所有的强化的记录，以及强化的道具消耗
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("uname", userName+userId.get(0));
		resultMap.put("result", resultList);
		request.setAttribute("results", resultMap);
		
		return "succ";
	}
	
	/**
	 * 查看违规信息
	 * 添加道具价格的峰值设定。
	 * 游戏数据格 买家-道具主类型-道具类型-道具数量-道具价格
	 */ 
	public String getViolationDataInfo(){
		//查询出所有的峰值设定
		List<EntityCaseLogDetail> lecld=new ArrayList<EntityCaseLogDetail>();
		lecld=this.getCheckDay(135);//翻出当天所有的交易记录
		List<EntityDubiousDataDetail> leddd=new ArrayList<EntityDubiousDataDetail>();
		DubiousDataDaoImpl dddi= new DubiousDataDaoImpl();
		Map<String,Object> params = new HashMap<String,Object>();
		leddd=dddi.getDoubiousInfo(params);
		EntityDubiousDataDetail resultEddd = new EntityDubiousDataDetail();
		/**
		 * 开始遍历数据中的价格是否为可疑交易
		 */
		for(EntityDubiousDataDetail eddd:leddd){
			for(EntityCaseLogDetail ecld:lecld){
				String [] ecldArray=ecld.getCase_ex_desc().split("-");
				if((Integer.parseInt(ecldArray[1])==eddd.getITEMTYPE()) && (Integer.parseInt(ecldArray[2])==eddd.getITEMID())){
					/**
					 * 判断价格是否已经超出了设定的范围,如果超出范围，记录买家和卖家账户id
					 */
					if(Integer.parseInt(ecldArray[4])>eddd.getPRICEMAX() || Integer.parseInt(ecldArray[4])<eddd.getPRICEMIN()){
							resultEddd.setBuyers(Integer.parseInt(ecldArray[0]));
							resultEddd.setSeller(ecld.getUser_id());
							resultEddd.setITEMNAME(eddd.getITEMNAME());
							break;
					}
					
				}
			}
		}
		
		/**
		 * 将异常的信息放入 case_info中  编号98
		 */
		this.publicfunction(98, resultEddd);
		Map<String, Object> fdParm = new HashMap<String, Object>();
		fdParm.put("lag_type", 98);
		List<EntityCaseInfoDetail> result = this.getCaseInfoService().findAll(
				fdParm);
		List<EntityDubiousDataDetail> rs_l = new ArrayList<EntityDubiousDataDetail>();
		for (EntityCaseInfoDetail ecid : result) {
			EntityDubiousDataDetail resultedd = new EntityDubiousDataDetail();
			resultedd = (EntityDubiousDataDetail) JSON
					.parseObject(ecid.getLag_info(), EntityDubiousDataDetail.class);
			resultedd.setTodaytime(this.timeSearch(3));
			rs_l.add(resultedd);
		}
		request.setAttribute("result", rs_l);
		return "succ";
	}
	
	public String addDubiousDataInfo(){
		DubiousDataDaoImpl dddi= new DubiousDataDaoImpl();
		//添加新的峰值设定
		String [] strArray=null;
		Map<String,Object> mapList = new HashMap<String,Object>();
		if(this.listName==null || this.priceMax==null || this.priceMin==null){
			//数据信息不对不做任何处理
			request.setAttribute("results",0 );
		}else{//数据格式完全没有问题执行插入操作
			strArray=this.listName.split(",");
			if(strArray.length>0){
				for(String tempValue:strArray){
					String [] _value=tempValue.split("-");
					mapList.put("ITEMTYPE", _value[0]);
					mapList.put("ITEMID", _value[2]);
					mapList.put("ITEMNAME", _value[3]);
					mapList.put("PRICEMAX", priceMax);
					mapList.put("PRICEMIN", priceMin);
					mapList.put("FLAG", 1);
				dddi.AddDubiousData(mapList);
				}
			}else{
				String [] _value=listName.split("-");
				mapList.put("ITEMTYPE", _value[0]);
				mapList.put("ITEMID", _value[2]);
				mapList.put("PRICEMAX", priceMax);
				mapList.put("PRICEMIN", priceMin);
				mapList.put("ITEMNAME", _value[3]);
				mapList.put("FLAG", 1);
				dddi.AddDubiousData(mapList);
			}
		}
		return "succ";
	}
	
	/**
	 * 查看所有的峰值记录
	 * @return
	 */
	public String getDoubiousInfo(){
		List<EntityDubiousDataDetail> leddd=new ArrayList<EntityDubiousDataDetail>();
		DubiousDataDaoImpl dddi= new DubiousDataDaoImpl();
		Map<String,Object> params = new HashMap<String,Object>();
		leddd=dddi.getDoubiousInfo(params);
		request.setAttribute("result", leddd);
		return "succ";
	}
	
	
	@SuppressWarnings("static-access")
	public void publicfunction(int valuetype,Object value){
		// ***将当日的内容写入 caseInfo 里面去。如果今天已经有消息了。就是update，反之 add
		String _str = JSON.toJSONString(value);
		//System.out.println("json is"+_str);
		SimpleDateFormat tempDate1 = new SimpleDateFormat("yyyy-MM-dd");
		String nowdate = tempDate1.format(new java.util.Date());
		Map<String, Object> findMap = new HashMap<String, Object>();
		GregorianCalendar   calendar   =   new   GregorianCalendar(); 
		 Date   date   =   calendar.getTime   (); 
		 SimpleDateFormat   df   =   new   SimpleDateFormat( "yyyy-MM-dd ");
		 calendar.set(calendar.DATE, calendar.get(calendar.DATE)+1);
		 date   =   calendar.getTime   ();
		findMap.put("lag_time", nowdate);
		findMap.put("lag_time2", df.format(date));
		findMap.put("lag_type", valuetype);
		List<EntityCaseInfoDetail> lecld = this.getCaseInfoService()
				.findAllForTime(findMap);
		Map<String, Object> caseInfoMap = new HashMap<String, Object>();

		if (lecld.size() > 0) {// **有数据改为更新操作
			SimpleDateFormat tempD = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String up_date = tempD.format(new java.util.Date());
			caseInfoMap.put("lag_info", _str);
			caseInfoMap.put("id", lecld.get(0).getId());
			caseInfoMap.put("lag_time", up_date);
			this.getCaseInfoService().updateCaseInfo(caseInfoMap);
		} else {
			caseInfoMap.put("lag_type", valuetype);
			caseInfoMap.put("lag_info", _str);
			this.getCaseInfoService().addCaseInfo(caseInfoMap);
		}
	}
	
	@SuppressWarnings("static-access")
	public void publicfunctionForDay(int valuetype,Object value,String liketime){
		String _str = JSON.toJSONString(value);
		// ***将当日的内容写入 caseInfo 里面去。如果今天已经有消息了。就是update，反之 add
		Map<String, Object> findMap = new HashMap<String, Object>();
		findMap.put("liketime", liketime);
		findMap.put("lag_type", valuetype);
		List<EntityCaseInfoDetail> lecld = this.getCaseInfoService()
				.findAllForTime(findMap);
		Map<String, Object> caseInfoMap = new HashMap<String, Object>();

		if (lecld.size() > 0) {// **有数据改为更新操作
//			SimpleDateFormat tempD = new SimpleDateFormat(
//					"yyyy-MM-dd HH:mm:ss");
//			String up_date = tempD.format(new java.util.Date());
			caseInfoMap.put("lag_info", _str);
			caseInfoMap.put("id", lecld.get(0).getId());
			caseInfoMap.put("lag_time", liketime);
			this.getCaseInfoService().updateCaseInfo(caseInfoMap);
		} else {
			caseInfoMap.put("lag_type", valuetype);
			caseInfoMap.put("lag_info", _str);
			caseInfoMap.put("lag_time", liketime);
			this.getCaseInfoService().addCaseInfo(caseInfoMap);
		}
	}
	
	
	public void publicfunctionYesterday(int valuetype,Object value,int sqlId,String lagTime,int updateOrInsert){
		/*
		 * valuetype 数据类型的大类
		 * value 要存入数据的内容
		 * sqlId 需要更新的数据id
		 * lagTime 最后的更新时间。一般是 前一天的 23:59:59
		 * updateOrInsert 判断是 更新2 还是 插入1
		 */
		String _str = JSON.toJSONString(value);
		//System.out.println("yesterday "+_str);
		Map<String, Object> caseInfoMap = new HashMap<String, Object>();
		switch(updateOrInsert){
		case 1://插入
			caseInfoMap.put("lag_type", valuetype);
			caseInfoMap.put("lag_info", _str);
			caseInfoMap.put("lag_time", lagTime);
			caseInfoMap.put("like_time", lagTime.substring(0,10));
			this.getCaseInfoService().addCaseInfo(caseInfoMap);
			break;
		case 2://更新
			caseInfoMap.put("lag_info", _str);
			if(sqlId>0){
				caseInfoMap.put("id", sqlId);
			}
			caseInfoMap.put("lag_time", lagTime);
			caseInfoMap.put("like_time", lagTime.substring(0,10));
			this.getCaseInfoService().updateCaseInfo(caseInfoMap);
			break;
		}	
	}

	/**
	 * 金币道具使用量跟踪
	 */
	public String checkGoldSell(){
		//List<EntityCaseLogDetail> liste = getEcld_list();
		//List<EntityCaseLogDetail> date_list=this.getCaseLogService().getAllDateList(liste);
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
//			List<EntityCaseLogDetail> lecld=getCaseLogService().getAllDateListTimeToTime(liste,createTime1,createTime2);
//			date_list=this.getCaseLogService().getAllDateList(lecld);
			}
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
		_datetime=tempDate.format(new java.util.Date());
			
			leclds=this.getCaseLogService().repleAll(this.getCheckDay(121), 121, _datetime);
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
			leclds=this.getCaseLogService().repleAll(getCheckDay(72), 72, _datetime);//获取金币购买的道具价格。
			for(EntityCaseLogDetail ecld:leclds){
				String [] tempArray=ecld.getCase_ex_desc().substring(2,ecld.getCase_ex_desc().length()-2).split("-");
				if(Integer.parseInt(tempArray[3])>0 && tempArray.length>0){
					ecgid.setGoldType6(ecgid.getGoldType6()+Long.parseLong(tempArray[3])*Long.parseLong(tempArray[2]));
				}
			}
			leclds=this.getCaseLogService().repleAll(getCheckDay(122), 122, _datetime);//获取产出金币的数据。
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
			this.publicfunction(12, ecgid);
			Map<String,Object> fdParm = new HashMap<String, Object>();
				fdParm.put("lag_type", 12);
				List<EntityCaseInfoDetail> result = this.getCaseInfoService().findAll(
						fdParm);
				 EntityCheckGoldItemDetail rs_l_12 = new EntityCheckGoldItemDetail();
				for (EntityCaseInfoDetail ecid : result) {
					rs_l_12=JSON.parseObject(ecid.getLag_info(),EntityCheckGoldItemDetail.class);
					rs_l_12.setDateTime(ecid.getLag_time().substring(0,10));
					lecgid.add(rs_l_12);
				}
		request.setAttribute("results", lecgid);
		return "succ";
	}
	
	public void testpublic(){
		System.out.println("开启");
	}
	
	public void pageSize(){
		
	}


	
	/**
	 * 获取平台账户玩家的充值记录
	 * 
	 * @return
	 */
	public String searchPay(){
		System.out.print("ppsUser"+ppsUser);
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String,Object> param = new HashMap<String,Object>();
		if(ppsUser.length()>0 && ppsUser!=null){
			//根据pps 的用户账号获取玩家在游戏里面的名字。
			param.put("ppsName",ppsUser );
			String roleName=this.getGameRoleService().getRoleNameByMemberId(param);
			String roleId=this.getGameRoleService().getRoleIdByMemberId(param);
			
			System.out.print("roleName"+roleName+" "+roleId);
			param.clear();
			param.put("likeMember_username",ppsUser );
			List<EntityOrderInfoDetail> lerid=this.getOrderInfoService().getAllInfoOrderInfo(param);
			result.put("userName", roleName);
			result.put("payRecold", lerid);
			result.put("userId", roleId);
			request.setAttribute("results", result);
		}else{
			List<EntityOrderInfoDetail> lerid=this.getOrderInfoService().getAllInfoOrderInfo(param);
			result.put("userName", "所有");
			result.put("payRecold", lerid);
			result.put("userId", "000");
			request.setAttribute("results", result);
		}
		return "succ";
	}
	
   /**
    * 查询各个等级的人员数量
    * @return
    */
	public String searchUserLive(){
		List<Map<String,Object>> lmap= this.getGameRoleService().getRoleLevel();
		request.setAttribute("results",lmap);
		return "succ";
	}
	
	/**
	 * 在线时长
	 * @return
	 */
	public String onlineTime(){
		int onlineTime=0;
		/**
		 * 查询出登录和等处的所有人的信息。采集点2 和  4 的所有人，包含同玩家
		 */
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("case_time1", request.getParameter("startTime"));
		param.put("case_time2", this.yestOrTom(request.getParameter("startTime"), 1));
		@SuppressWarnings("unused")
		List<EntityCaseLogDetail> lecld=this.getCaseLogService().getOnlineTimeForUser(param);
		List<Map<String,Object>> lMap=this.getCaseLogService().checkOnlineTimeForUser(lecld);
		Map<String,Object> resultMap= lMap.get(0);
		Iterator<Map.Entry<String,Object>> it = resultMap.entrySet().iterator();
		int resArr[] = new int[24];
		while(it.hasNext()){
			Map.Entry entry=it.next();
			onlineTime=Integer.parseInt(entry.getValue()+"")/1000/60/60;
			if(onlineTime<0 || onlineTime>23){
				continue;
			}
			resArr[onlineTime]=resArr[onlineTime]+1;
		}
//		List<Map<String,Object>> lmap=this.getCaseLogService().checkOnlineTime(lecld_2, lecld_4);
//		Map<String,Integer> timeMap = new HashMap<String,Integer>();
//		int resArr[]=new int[24];
//		for(int i=0;i<=23;i++){
//			timeMap.put(i+"", 0);
//		}
//		for(Map<String,Object> tempMap:lmap){
//			Iterator<Map.Entry<String,Object>> it = tempMap.entrySet().iterator();
//			while(it.hasNext()){
//				Map.Entry entry=it.next();
//				//** 判断在线人数的时间区间,是在那个事件区间内
//				onlineTime=Integer.parseInt(entry.getValue()+"")/1000/60/60;
//				//System.out.println(onlineTime+"--"+entry.getKey());
//				if(onlineTime>23 || onlineTime<0){
//					onlineTime=23;
//				}
//				timeMap.put(onlineTime+"", timeMap.get(onlineTime+"")+1);
//				resArr[onlineTime]=resArr[onlineTime]+1;
//				}
//		}
		request.setAttribute("resultsOnlineTime", resArr);
		return "succ";
	}
	
	
	public String onlineTimeOld(){
		int onlineTime=0;
		/**
		 * 查询出登录和等处的所有人的信息。采集点2 和  4 的所有人，包含同玩家
		 */
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("case_time", request.getParameter("startTime"));
		List<EntityCaseLogDetail> lecld=this.getCaseLogService().getOnlineTimeForUser(param);
		List<Map<String,Object>> lmap=this.getCaseLogService().checkOnlineTime(lecld);
		Map<String,Integer> timeMap = new HashMap<String,Integer>();
		int resArr[]=new int[24];
		for(int i=0;i<=23;i++){
			timeMap.put(i+"", 0);
		}
		for(Map<String,Object> tempMap:lmap){
			Iterator<Map.Entry<String,Object>> it = tempMap.entrySet().iterator();
			while(it.hasNext()){
				Map.Entry entry=it.next();
				//** 判断在线人数的时间区间,是在那个事件区间内
				onlineTime=Integer.parseInt(entry.getValue()+"")/1000/60/60;
				//System.out.println(onlineTime+"--"+entry.getKey());
				if(onlineTime>23 || onlineTime<0){
					onlineTime=23;
				}
				timeMap.put(onlineTime+"", timeMap.get(onlineTime+"")+1);
				resArr[onlineTime]=resArr[onlineTime]+1;
				}
		}
		request.setAttribute("resultsOnlineTime", resArr);
		return "succ";
	}
	
	
	
	public String checkTime(){
	 Calendar ca3 = Calendar.getInstance();
//   	 int year3 = ca3.get(Calendar.YEAR);//获取年份
//   	 int month3=ca3.get(Calendar.MONTH)+1;//获取月份
//   	 int day3=ca3.get(Calendar.DATE);//获取日
     int minute3=ca3.get(Calendar.MINUTE);//分
//     int hour3=ca3.get(Calendar.HOUR_OF_DAY);//小时
     int second3=ca3.get(Calendar.SECOND);//秒
//     int WeekOfYear3 = ca3.get(Calendar.DAY_OF_WEEK);
     
     System.out.println("------------"+minute3+"-"+second3);
	 return minute3+"-"+second3;
	}
	
	/**
	 * 根据typeid 类型来选择是 昨天的时间还是明天的时间 0是昨天的 1是明天的
	 * @param dateTime
	 * @param typeId
	 * @return
	 */
	public String yestOrTom(String dateTime,int typeId){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date yesterday_time=null;
		Date ytTime=null;
		String yesterTime="";
		try {
			yesterday_time=format.parse(dateTime);
			switch(typeId){
			case 0:
				ytTime=new Date(yesterday_time.getTime()+(1000*60*60*24));break;
			case 1:
				ytTime=new Date(yesterday_time.getTime()+(1000*60*60*24));break;
			default:
				break;
			}
			yesterTime=format.format(ytTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return yesterTime;
	}
}
