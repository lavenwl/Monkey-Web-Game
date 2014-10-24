package com.stang.game.ffd.common;

import java.util.Map;
import java.util.TimerTask;

/**
 * @author jianbo.feng
 * @company 上海三唐信息科技有限公司
 * @description 游戏常量信息 
 */
public class GameConstants {
	public static final int GAME_BYTE_ARRAY_MIN_SIZE=50;

	/*文件上传前地址（内网）*/
	public final static String upUrl = "/fly_server/apache-tomcat-6.0.29/webapps/gk";
	
	/*文件上传前地址（本地）*/
    // public final static String upUrl = "/Program Files/Apache Software Foundation/Tomcat 6.0/webapps/gk";
	
	/*文件上传前地址（外网）*/
	//public final static String upUrl = "/gameserver/servers/apache-tomcat-6.0.29/webapps/gk";
	
	/**
	 * 字符分割符号
	 */
	public final static String SPLIT_SIGN = "^";
	
	public static boolean checkDay15minuts=true;
	/*编码格式*/
	public final static String FORMAT = "UTF-8";
	
	/*服务器配置文件路径*/
	//public static final String SERVER_CONFIG = "conf/stang/server/ServerConfig.xml";
	
	/*IBATIS框架配置文件*/
	public static final String DB_IBATIS_CONFIG = "conf/stang/ffd/db/ibatis/iBatisConfig.xml";
	
	public static final String DB_IBATIS_CONFIG_WEB = "conf/stang/ffd/db/ibatis/iBatisConfig_monkey.xml";
	
	/*缓存服务器配置文件路径*/
	public static final String CACHE_SERVER_CONFIG = "conf/stang/CacheServerConfig.xml";

	/*基础数据库服务器*/
	public static final String DB_BASE_SERVER = "conf/stang/BaseDbServer.xml";
	
	/*数据库及表配置文件路径*/
	public static final String DB_CONFIG = "conf/stang/db/DBConfig.xml";
	
	/*数据库及表配置文件编码*/
	public static final String DB_CONFIG_ENCODING = "GB2312";
	
	/*数据库访问驱动程序*/
	public static final String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
	
	/*每个数据库表数目默认值*/
	public static final int DB_MAX_TABLES = 10;
	
	/*每个表记录数默认最大值*/
	public static final int DB_TABLE_MAX_ROWS = 1000000;
	
	/*站点地图配置文件路径*/
	public static final String SITE_MAP_CONFIG = "conf/stang/SiteMapConfig.xml";
	
	/*房间(战斗信息)、登录日志存储路径配置文件*/
	
	public static final String XML_STORE_CONFIG = "conf/stang/db/xml_store.properties";
	
	/*********************   Interface information   *************************/
	
	/*成功*/
	public static final int GAME_API_SUCCESS = 1;
	
	public static final String GAME_API_SUCCESS_INFO = "Success";
	
	/*失败*/
	public static final int GAME_API_FAILURE = -10;
	
	public static final String GAME_API_FAILURE_INFO = "Failure";
	
	/*加密签名不匹配*/
	public static final int GAME_API_ERROR_SIGN = -1;
	
	public static final String GAME_API_ERROR_SIGN_INFO = "Sign Error";
	
	/*错误请求*/
	public static final int GAME_API_ERROR_INVALID_REQUEST = 0;
	
	public static final String GAME_API_ERROR_INVALID_REQUEST_INFO = "Invalid Request";
	
	/*参数错误*/
	public static final int GAME_API_ERROR_PARAMETER = 2;
	
	public static final String GAME_API_ERROR_PARAMETER_INFO = "Parameter Error";
	
	/*未发现Flash播放器*/
	public static final int GAME_API_ERROR_NOT_FOUND_PLAYER = 110;
	
	public static final String GAME_API_ERROR_NOT_FOUND_PLAYER_INFO = "Not Found Player";
	
	/*数据库服务器异常*/
	public static final int GAME_API_ERROR_DB_SERVER = -100;
	
	public static final String GAME_API_ERROR_DB_SERVER_INFO = "DB server error";
	
	/*处理失败*/
	public static final int GAME_API_ERROR_PROCESS_FAILURE = -2;
	
	public static final String GAME_API_ERROR_PROCESS_FAILURE_INFO = "Process failure";	
	
	/*未登录*/
	public static final int GAME_API_ERROR_NO_LOGON = 120;
	
	public static final String GAME_API_ERROR_NO_LOGON_INFO = "No logon";
	
	/*未注册*/
	public static final int GAME_API_ERROR_NO_REGIST = 135;
	
	public static final String GAME_API_ERROR_NO_REGIST_INFO = "No regist";
	
	/*同一HOST不能多开*/
	public static final int GAME_API_ERROR_ONE_HOST_MULTI_PLAYERS = 140;
	
	public static final String GAME_API_ERROR_ONE_HOST_MULTI_PLAYERS_INFO = "One host multi players error ";
	
	/*该会员已在其他地方登录*/
	public static final int GAME_API_ERROR_ALREADY_LOGON = 141;
	
	public static final String GAME_API_ERROR_ALREADY_LOGON_INFO = "Already logon error"; 
	
	/*该会员创建游戏角色个数超限*/
	public static final int GAME_API_EXCEED_LIMIT = 144;
	
	public static final String GAME_API_EXCEED_LIMIT_INFO = "Exceed limit error";
	
	/*游戏角色名称重复*/
	public static final int GAME_API_DUPLICATION = 145;
	
	public static final String GAME_API_DUPLICATION_INFO = "Role name duplication";
	
	/*游戏人数满上限*/
	public static final int GAME_API_PLAYERS_LIMIT = 146;
	
	public static final String GAME_API_PLAYERS_LIMIT_INFO = "Players limit error";
	
	/*不是会长不能解散公会*/
	public static final int GAME_API_ONLY_CHAIRMAN = 147;
	
	public static final String GAME_API_ONLY_CHAIRMAN_INFO = "Only chairman can dissolve consortia";
	
	/*已经申请了*/
	public static final int GAME_API_ALREADY_APPLY_TO_CONSORTIA = 148;
	
	public static final String GAME_API_ALREADY_APPLY_TO_CONSORTIA_INFO = "Already apply to the consortia";
	
	/*角色已经是公会成员了*/
	public static final int GAME_API_ROLE_IS_MEMBER_OF_CONSORTIA = 149;
	
	public static final String GAME_API_ROLE_IS_MEMBER_OF_CONSORTIA_INFO = "The role is member of consortia";
	
	/*会长、副会长需卸职之后才能离开或被开除公会*/
	public static final int GAME_API_NO_RESIGN = 150;
	
	public static final String GAME_API_NO_RESIGN_INFO = "No resign error";
	
	/*权限不够(或操作非法)*/
	public static final int GAME_API_ILLEGAL = 151;
	
	public static final String GAME_API_ILLEGAL_INFO = "Operate is illegal";
	
	/*等待被招募者回复*/
	public static final int GAME_API_WATTING_PLAYER_REPLY = 152;
	
	public static final String GAME_API_WATTING_PLAYER_REPLY_INFO = "Watting the player reply";
	
	/*被招募者(玩家)拒绝加入公会*/
	public static final int GAME_API_REFUSE_JOIN_TO_CONSORTIA = 153;
	
	public static final String GAME_API_REFUSE_JOIN_TO_CONSORTIA_INFO = "Refuse join to consortia";
	
	/*不允许进入房间*/
	public static final int GAME_API_NOT_ALLOW_ENTER_ROOM = 190;
	
	public static final String GAME_API_NOT_ALLOW_ENTER_ROOM_INFO = "Not allow enter the room"; 
	
	/*房间状态不允许进入*/
	public static final int GAME_API_ROOM_STATUS_NOT_ALLOW_ENTER = 191;
	
	public static final String GAME_API_ROOM_STATUS_NOT_ALLOW_ENTER_INFO = "The room status not allow enter";
	
	/*大区状态不允许进入*/
	public static final int GAME_API_AREA_STATUS_NOT_ALLOW_ENTER = 192;
	
	public static final String GAME_API_AREA_STATUS_NOT_ALLOW_ENTER_INFO = "The area status not allow enter";
	
	/*房间无空闲位置位置(不允许进入)*/
	public static final int GAME_API_ROOM_NOT_FREE_SIT = 193;
	
	public static final String GAME_API_ROOM_NOT_FREE_SIT_INFO = "The room not free sit";
	
	/*房间信息没有或者已经关闭*/
	public static final int GAME_API_ROOM_CLOSED = 194;
	public static final String GAME_API_ROOM_CLOSED_INFO = "The room is closed";
	
	/*(消息)发送者不在线*/
	public static final int GAME_API_SENDER_IS_OFFLINE = 195;
	public static final String GAME_API_SENDER_IS_OFFLINE_INFO = "The sender is offline";
	
	/*(消息)接收者不在线*/ 
	public static final int GAME_API_RECEIVER_IS_OFFLINE = 196;
	public static final String GAME_API_RECEIVER_IS_OFFLINE_INFO = "The receiver is offline";
	
	/*(消息)发送和接受者均不在线*/
	public static final int GAME_API_BOTH_SENDER_AND_RECEIVER_ARE_OFFLINE = 197;
	public static final String GAME_API_BOTH_SENDER_AND_RECEIVER_ARE_OFFLINE_INFO = "Both sender and receiver are offline";
	
	/*不能进入另一个房间(已经在房间中)*/
	public static final int GAME_API_DON_NOT_ENTER_TO_ANOTHER_ROOM = 198;
	public static final String GAME_API_DON_NOT_ENTER_TO_ANOTHER_ROOM_INFO = "You don’t enter to another room";
	
	/*该位置已经有玩家*/
	public static final int GAME_API_THE_SIT_HAS_A_PLAYER = 199;
	public static final String GAME_API_THE_SIT_HAS_A_PLAYER_INFO = "The sit has a player";
	
	/*该位置没有该玩家*/
	public static final int GAME_API_THE_PLAYER_ISNOT_IN_THE_SIT = 200;
	public static final String GAME_API_THE_PLAYER_ISNOT_IN_THE_SIT_INFO = "The player isn’t in the sit";
	
	/*该玩家已进入其他房间*/
	public static final int GAME_API_THE_PLAYER_IN_ANOTHER_ROOM = 201;
	public static final String GAME_API_THE_PLAYER_IN_ANOTHER_ROOM_INFO = "The player in another room";
	
	/*玩家金币不足*/
	public static final int GAME_API_THE_PLAYER_GOLD_IS_NOT_ENOUGH = 202;
	public static final String GAME_API_THE_PLAYER_GOLD_IS_NOT_ENOUGH_INFO = "The player's gold is not enough"; 
	
	/*玩家金钱(或点卷)不足*/
	public static final int GAME_API_THE_PLAYER_MONEY_IS_NOT_ENOUGH = 203;
	public static final String GAME_API_THE_PLAYER_MONEY_IS_NOT_ENOUGH_INFO = "The player's money is not enough"; 
	
	/*你就是公会会长*/
	public static final int GAME_API_YOUR_ARE_CHAIRMAN = 204;
	public static final String GAME_API_YOU_ARE_CHAIRMAN_INFO = "You're chairman of the consortia";
	
	/*玩家技能点不足*/
	public static final int GAME_API_THE_PLAYER_SKILL_POINT_IS_NOT_ENOUGH = 205;
	public static final String GAME_API_THE_PLAYER_SKILL_POINT_IS_NOT_ENOUGH_INFO = "The player's skill point is not enough"; 
	
	/*玩家军衔等级不足*/
	public static final int GAME_API_THE_PLAYER_RANK_IS_NOT_ENOUGH = 206;
	public static final String GAME_API_THE_PLAYER_RANK_IS_NOT_ENOUGH_INFO = "The player's rank is not enough"; 
	
	/*玩家等级不足*/
	public static final int GAME_API_THE_PLAYER_LEVEL_IS_NOT_ENOUGH = 207;
	public static final String GAME_API_THE_PLAYER_LEVEL_IS_NOT_ENOUGH_INFO = "The player's level is not enough"; 
	
	/*有玩家未完成场景加载*/
	public static final int GAME_API_THE_PLAYER_IS_NOT_FINISH_LOADDING = 208;
	public static final String GAME_API_THE_PLAYER_IS_NOT_FINISH_LOADDING_INFO = "The player isn't finish loadding"; 
	
	/*玩家没有此项技能*/
	public static final int GAME_API_THE_PLAYER_NOT_HAS_THE_SKILL = 209;
	public static final String GAME_API_THE_PLAYER_NOT_HAS_THE_SKILL_INFO = "The player hasn't the skill"; 
	
	/*没有此玩家,请创建角色*/
	public static final int GAME_API_NO_ROLE_OF_GAME = 991;
	public static final String GAME_API_NO_ROLE_OF_GAME_INFO = "There isn't role of game,please create it.";
	
	/*该玩家已经被(房主)邀请过了*/
	public static final int GAME_API_THE_PLAYERS_HAVE_BEEN_INVITED_TO_THE_ROOM = 992;	
	public static final String GAME_API_THE_PLAYERS_HAVE_BEEN_INVITED_TO_THE_ROOM_INFO = "The players have been invited to the room";	

	/*(战斗结束后)金币奖励的几率*/
	public static final int GAME_GIFT_GOLD_RATIO = 80;
	
	/*服务端处理信息相应码(如成功为:1)*/
	public static final String GAME_API_RESPONSE_FIELD_CODE = "_code";
	
	/*游戏接口名称*/
	public static final String GAME_API_RESPONSE_FIELD_CMD = "_cmd";
	
	/*唯一标识*/
	public static final String GAME_API_RESPONSE_FIELD_GUID = "_guid";
	
	/*结果描述*/
	public static final String GAME_API_RESPONSE_FIELD_RLT = "_rlt";
	
	/*缓存Key*/
	public static final String GAME_API_RESPONSE_FIELD_CACHEKEY = "_cachekey";
	
	/*主动请求的玩家ID*/
	public static final String GAME_API_RESPONSE_FIELD_ACTPID = "_actpid";
	
	/******************************   数据库处理   ******************************/
	/*处理成功*/
	public static final int CODE_DATA_SUCCESS = 1;
	/*处理失败*/
	public static final int CODE_DATA_FAILURE = -1;	
	
	/*数据库服务器连接失败*/
	public static final int CODE_DB_SERVER_ERROR = 400;
	
	/**
	 * 系统分页中每页最大记录数
	 */
	public final static int PAGE_SIZE_DEFAULT = 10;
	
	public final static int PAGE_SIZE_RESOURCE = 10;
	

	public final static int WAP_PAGE_SIZE_100 = 100;

	public final static int WAP_PAGE_SIZE_20 = 20;

	// result dao code
	public final static int CODE_DEFAULT_RESULT = -1;

	public final static int CODE_DAO_SUCCESS = 1;

	public final static int CODE_DAO_FAILURE = -1;

	// result code
	public final static String CODE_SUCCESS = "0";

	public final static String CODE_PARAMETER_ERROR = "1";

	public final static String CODE_DATABASE_ACCESS_ERROR = "2";

	public final static String CODE_UNSUPPORTED_COMMAND_ERROR = "3";

	public final static String CODE_NO_PERMISSION_ERROR = "4";

	public final static String CODE_INVALID = "5";

	public final static String CODE_MAXLENGTH = "6";

	public final static String CODE_MINLENGTH = "7";

	public final static String CODE_RANGE = "8";

	public final static String CODE_REQUIRED = "9";

	public final static String CODE_BYTE = "10";

	public final static String CODE_DATE = "11";

	public final static String CODE_DOUBLE = "12";

	public final static String CODE_FLOAT = "13";

	public final static String CODE_INTEGER = "14";

	public final static String CODE_LONG = "15";

	public final static String CODE_SHORT = "16";

	public final static String CODE_CREDITCARD = "17";

	public final static String CODE_EMAIL = "18";

	public final static String CODE_NOT_EXISTS = "19";

	public final static String CODE_UNIQUE = "20";

	public final static String CODE_USERNAME_PASSWORD_NOT_MATCH = "21";

	public final static String CODE_NEED_LOGIN = "22";

	public final static String CODE_NO_MATCHED_RECORD = "23";

	public final static String CODE_INVALID_LICENSE = "24";

	public final static String CODE_CAMERA_AMOUNT_EXCEED = "25";

	public final static String CODE_USER_AMOUNT_EXCEED = "26";

	public final static String CODE_IN_USING = "27";

	public final static String CODE_CANNOT_BE_DELETE = "28";

	public final static String CODE_XML_INVALID = "29";

	public final static String CODE_CANNOT_GET_JDBC_CONNECTION = "30";

	public final static String CODE_PARAMETER_REQUIRE = "31";

	public final static String CODE_UNKNOWN_ERROR = "99";

	// Exception code from gpio
	public final static String CODE_GPIO_INVALID = "100";

	public final static String CODE_DELETE_AREA_WITH_SUBITEM_ERROR = "101";

	public final static String CODE_CANNOT_DELETE_ROOT_AREA = "102";

	public final static String CODE_NEED_STOP_ALL_TASK_BEFORE_DELETE_SA = "105";

	public final static String CODE_NOT_APPOINT_AREA = "106";

	public final static String CODE_PAIR_PARAMS_NOT_EQUALS = "200";

	public final static String CODE_SA_EERORS = "201";

	public final static String CODE_NOT_THE_SAME = "202";

	public final static String CODE_CAMEREA_IN_OTHER_GROUPS = "203";

	public final static String CODE_NEED_BACKUP_BEFORE_CLEAN = "204";

	public final static String CODE_TASK_HAS_BEEN_CANCELED = "205";

	public final static String CODE_TIME_OUT_RANGE = "206";

	public final static String CODE_START_TIME_LARGER = "207";

	// Exception Code from CSG
	public final static String CODE_CONTROLPTZ_FAILED = "300";

	public final static String CODE_DELETEVSUSER_FAILED = "301";

	public final static String CODE_SETVSIMAGEADJUSTING_FAILED = "302";

	public final static String CODE_SETVSIMAGEFORMAT_FAILED = "303";

	public final static String CODE_SETVSSERIALPORT_FAILED = "304";

	public final static String CODE_SETVSUSER_FAILED = "305";

	public final static String CODE_SETVSVIDEO_FAILED = "306";

	public final static String CODE_SUBSCRIBEALARM_FAILED = "307";

	public final static String CODE_VISIT_NVS_ERROR = "308";

	public final static String CODE_UNSUPPORTED_PTZ_PROTOCOL = "309";

	public final static String CODE_UNSUPPORTED_PTZ_PROTOCOL_COMMAND = "310";

	public final static String CODE_UNSUPPORTED_ACTION = "311";

	public final static String CODE_SETVSIMGPARAM_FAILED = "312";

	public final static String CODE_VS_AUTHENTICATE_FAILED = "313";

	public final static String CODE_SETVSIPINFO_FAILED = "314";

	public final static String CODE_SETGPIODEVICE_FAILED = "315";

	public final static String CODE_SETVSTIME_FAILED = "316";

	public final static String CODE_UNSUPPORT_VS_VENDOR = "317";

	public final static String CODE_SETDECODER_FAILED = "318";

	public final static String CODE_CONTROLVS_FAILED = "319";

	public final static String CODE_SET_VS_LOCAL_STORAGE_TASK_FAILED = "320";

	public final static String CODE_STOP_VS_LOCAL_STORAGE_TASK_FAILED = "321";

	public final static String INPUT_DEFAULT = "请输入关键词";
	
	public final static String FILE_UPLOAD_BASE_DIRECTORY = "D:/upload";

	public final static int USER_PAGE_SIZE = 3;
	
	public final static int LOGINLOG_PAGE_SIZE = 6;
	
	public final static int ACTIONLOG_PAGE_SIZE = 6;
	
	public final static int PISAMPLE_PAGE_SIZE = 3;
	
	public final static int DEPARTMENT_PAGE_SIZE = 3;
	
	public final static int ROLE_PAGE_SIZE = 3;
	
	public final static int QUOTATION_PAGE_SIZE = 3;
	
	public final static int GOODFUND_PAGE_SIZE = 3;
	
	public final static String DATE_FORMAT = "yyyy年MM月dd日 HH点mm分ss秒";
	
	public final static String DATE_FORMAT_YMD = "yyyy年MM月dd日";
	
	public final static String DATE_FORMAT_UNI = "yyyy-MM-dd";
	
	public static Map<String, Object> indexinfo;
	//** 最高在线的全局变量
	public static int maxline=0;
	
	public static boolean maxline_replace=true;
	
	public static TimerTask task;
	
	public static TimerTask checkTask;
	
}
