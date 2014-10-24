package com.stang.game.common;

import java.util.HashMap;

import org.apache.log4j.Logger;

/**
 * @author fei_wei
 * @company 上海三唐信息科技有限公司
 * @description 游戏常量信息
 */
public class GameConstants {
	// 日志
	public static Logger log = Logger.getRootLogger();
	/* 字符分割符号 */
	public final static String SPLIT_SIGN = "^";

	/* 编码格式 */
	public final static String FORMAT = "UTF-8";

	/* 服务器配置文件路径 */
	public static final String SERVER_CONFIG = "conf/stang/server/ServerConfig.xml";

	/* IBATIS框架配置文件 */
	public static final String DB_IBATIS_CONFIG = "conf/stang/db/ibatis/iBatisConfig.xml";

	/* 缓存服务器配置文件路径 */
	public static final String CACHE_SERVER_CONFIG = "conf/stang/CacheServerConfig.xml";

	/* 基础数据库服务器 */
	public static final String DB_BASE_SERVER = "conf/stang/BaseDbServer.xml";

	/* 数据库及表配置文件路径 */
	public static final String DB_CONFIG = "conf/stang/db/DBConfig.xml";

	/* 数据库及表配置文件编码 */
	public static final String DB_CONFIG_ENCODING = "GB2312";

	/* 数据库访问驱动程序 */
	public static final String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";

	/* 每个数据库表数目默认值 */
	public static final int DB_MAX_TABLES = 10;

	/* 每个表记录数默认最大值 */
	public static final int DB_TABLE_MAX_ROWS = 1000000;

	/* 站点地图配置文件路径 */
	public static final String SITE_MAP_CONFIG = "conf/stang/SiteMapConfig.xml";

	/* 所有服务器名字 */
	public static final int[] SERVERS_ALL_NAME = { 1 };

	/** ******************* Interface information ************************ */

	/* 成功 */
	public static final int GAME_API_SUCCESS = 1;
	
	/*vip每日领取等级不足*/
	public static final int VIP_NOT_ENOUGH = -1;
	
	/*vip每日礼包已经领取*/
	public static final int DO_IT_BEFORE = -2;

	/* 成功 */
	public static final int GAME_API_SUCCESS_WAIT = 3;

	public static final HashMap<String, Object> GAME_API_SUCCESS_INFO = new HashMap<String, Object>();

	/* 失败 */
	public static final int GAME_API_FAILURE = -10;

	public static final String GAME_API_FAILURE_INFO = "Failure";

	/* 加密签名不匹配 */
	public static final int GAME_API_ERROR_SIGN = -1;

	public static final String GAME_API_ERROR_SIGN_INFO = "Sign Error";

	/* 错误请求 */
	public static final int GAME_API_ERROR_INVALID_REQUEST = 0;

	public static final String GAME_API_ERROR_INVALID_REQUEST_INFO = "Invalid Request";

	/* 参数错误 */
	public static final int GAME_API_ERROR_PARAMETER = 2;

	public static final String GAME_API_ERROR_PARAMETER_INFO = "Parameter Error";

	/* 未发现Flash播放器 */
	public static final int GAME_API_ERROR_NOT_FOUND_PLAYER = 110;

	public static final String GAME_API_ERROR_NOT_FOUND_PLAYER_INFO = "Not Found Player";

	/* 数据库服务器异常 */
	public static final int GAME_API_ERROR_DB_SERVER = -100;

	public static final String GAME_API_ERROR_DB_SERVER_INFO = "DB server error";

	/* 处理失败 */
	public static final int GAME_API_ERROR_PROCESS_FAILURE = -1;

	public static final String GAME_API_ERROR_PROCESS_FAILURE_INFO = "Process failure";

	/* 未登录 */
	public static final int GAME_API_ERROR_NO_LOGON = 120;

	/* 未注册 */
	public static final int GAME_API_ERROR_NO_REGIST = 135;

	/* 同一HOST不能多开 */
	public static final int GAME_API_ERROR_ONE_HOST_MULTI_PLAYERS = 140;

	public static final String GAME_API_ERROR_ONE_HOST_MULTI_PLAYERS_INFO = "One host multi players error ";

	/* 该会员已在其他地方登录 */
	public static final int GAME_API_ERROR_ALREADY_LOGON = 141;

	public static final String GAME_API_ERROR_ALREADY_LOGON_INFO = "Already logon error";

	public static final int GAME_BYTE_ARRAY_MIN_SIZE = 50;

	/* 该会员创建游戏角色个数超限 */
	public static final int GAME_API_EXCEED_LIMIT = 144;

	public static final String GAME_API_EXCEED_LIMIT_INFO = "Exceed limit error";

	/* 游戏角色名称重复 */
	public static final int GAME_API_DUPLICATION = 145;

	public static final String GAME_API_DUPLICATION_INFO = "Role name duplication";

	/* 游戏人数满上限 */
	public static final int GAME_API_PLAYERS_LIMIT = 5000;
	public static final int GAME_API_PLAYERS_STATUS_WELL = 50;
	public static final int GAME_API_PLAYERS_STATUS_GENERAL = 150;
	public static final int GAME_API_PLAYERS_STATUS_CROWD = 250;

	public static final String GAME_API_PLAYERS_LIMIT_INFO = "Players limit error";

	public static final String GAME_API_ROLE_IS_MEMBER_OF_CONSORTIA_INFO = "The role is member of consortia";

	/* 没用该用户 */
	public static final int GAME_API_NO_RESIGN = 150;

	public static final String GAME_API_NO_RESIGN_INFO = "NO RESIGN";
	/* 没用该用户 */
	public static final int GAME_API_NO_USER = 146;

	public static final String GAME_API_NO_USER_INFO = "NO USER";

	/* 权限不够(或操作非法) */
	public static final int GAME_API_ILLEGAL = 151;

	public static final String GAME_API_ILLEGAL_INFO = "Operate is illegal";

	public static final String GAME_API_CONSORTIA_ROLENUM_MAX_INFO = "Consortia roleNum is Max";

	/* (消息)发送者不在线 */
	public static final int GAME_API_SENDER_IS_OFFLINE = 195;
	public static final String GAME_API_SENDER_IS_OFFLINE_INFO = "The sender is offline";

	/* (消息)接收者不在线 */
	public static final int GAME_API_RECEIVER_IS_OFFLINE = 196;
	public static final String GAME_API_RECEIVER_IS_OFFLINE_INFO = "The receiver is offline";

	/* (消息)发送和接受者均不在线 */
	public static final int GAME_API_BOTH_SENDER_AND_RECEIVER_ARE_OFFLINE = 197;
	public static final String GAME_API_BOTH_SENDER_AND_RECEIVER_ARE_OFFLINE_INFO = "Both sender and receiver are offline";

	/* 玩家金币不足 */
	public static final int GAME_API_THE_PLAYER_GOLD_IS_NOT_ENOUGH = 202;
	public static final String GAME_API_THE_PLAYER_GOLD_IS_NOT_ENOUGH_INFO = "The player's gold is not enough";

	/* 玩家金钱(或点卷)不足 */
	public static final int GAME_API_THE_PLAYER_MONEY_IS_NOT_ENOUGH = 203;
	public static final String GAME_API_THE_PLAYER_MONEY_IS_NOT_ENOUGH_INFO = "The player's money is not enough";

	/* 玩家等级不足 */
	public static final int GAME_API_THE_PLAYER_LEVEL_IS_NOT_ENOUGH = 207;
	public static final String GAME_API_THE_PLAYER_LEVEL_IS_NOT_ENOUGH_INFO = "The player's level is not enough";

	/* 没有此玩家,请创建角色 */
	public static final int GAME_API_NO_ROLE_OF_GAME = 991;
	public static final String GAME_API_NO_ROLE_OF_GAME_INFO = "There isn't role of game";

	/* (战斗结束后)金币奖励的几率 */
	public static final int GAME_GIFT_GOLD_RATIO = 80;

	/* 服务端处理信息相应码(如成功为:1) */
	public static final String GAME_API_RESPONSE_FIELD_CODE = "_code";

	/* 游戏接口名称 */
	public static final String GAME_API_RESPONSE_FIELD_CMD = "_cmd";

	/* 唯一标识 */
	public static final String GAME_API_RESPONSE_FIELD_GUID = "_guid";

	/* 结果描述 */
	public static final String GAME_API_RESPONSE_FIELD_RLT = "_rlt";

	public static final HashMap<String, Object> GAME_API_RESPONSE_FIELD_RLT_NOINFO = new HashMap<String, Object>();

	/* 缓存Key */
	public static final String GAME_API_RESPONSE_FIELD_CACHEKEY = "_cachekey";

	/* 主动请求的玩家ID */
	public static final String GAME_API_RESPONSE_FIELD_ACTPID = "_actpid";

	/** **************************** 数据库处理 ***************************** */
	/* 处理成功 */
	public static final int CODE_DATA_SUCCESS = 1;
	/* 处理失败 */
	public static final int CODE_DATA_FAILURE = -1;

	/* 数据库服务器连接失败 */
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

	// 金币
	public final static int GAME_COIN = 0;
	// 银币
	public final static int GAME_YIN = 1000;
	// 功勋
	public final static int GAME_GONGXUN = 0;

	// 初级招募
	public final static int GAME_chuji = 3;

	// 中级招募
	public final static int GAME_zhongji = 4;

	// 高级招募
	public final static int GAME_gaoji = 5;
	
	//初级寻宝
	public final static int GAME_chubao = 1;
	//中级寻宝
	public final static int GAME_zhongbao = 2;
	//高级寻宝
	public final static int GAME_gaobao = 3;
	//新服活动在activity 表中的 id
	public final static int NEW_SERVER_ACTIVITY_ID = 22;
	public final static int TURNTABLE_ACTIVITY_ID = 23;
	public final static int HAPPY_TURNTABLE_ACTIVITY_ID = 24;
	public final static int TURNTABLE_START_ID = 5000;//大转盘
	public final static int TURNTABLE_END_ID = 5011;
	public final static int HAPPY_TURNTABLE_START_ID = 7000;//摇摇乐
	public final static int HAPPY_TURNTABLE_END_ID = 7011;
	public final static int ZILLIONAIRE_START_ID = 7012;//大富翁  
	public final static int ZILLIONAIRE_END_ID = 7021;
	public final static int ZILLIONAIRE_ALL_CELL = 64;//大富翁棋盘总格数
}
