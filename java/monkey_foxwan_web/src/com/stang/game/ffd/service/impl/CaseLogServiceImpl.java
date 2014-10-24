package com.stang.game.ffd.service.impl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.stang.game.ffd.common.GameConstants;
import com.stang.game.ffd.dao.ICaseLogDao;
import com.stang.game.ffd.dao.impl.CaseLogDaoImpl;
import com.stang.game.ffd.entity.detail.EntityCaseLogDetail;
import com.stang.game.ffd.entity.detail.EntityCheckBattleDetail;
import com.stang.game.ffd.entity.detail.EntityCheckNoviceDetail;
import com.stang.game.ffd.entity.detail.EntityOrderInfoDetail;
import com.stang.game.ffd.entity.detail.EntitySellDetail;
import com.stang.game.ffd.service.ICaseLogService;


public class CaseLogServiceImpl extends BaseServiceImpl<EntityCaseLogDetail>
		implements ICaseLogService {

	public ICaseLogDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new CaseLogDaoImpl();
		}
		return (ICaseLogDao) baseDao;
	}

	/**
	 * @description 获取所有的日期的天数
	 * @param liste
	 * @return 数据有多少天的数据
	 */
	public List<EntityCaseLogDetail> getAllDateList(
			List<EntityCaseLogDetail> liste) {
		List<EntityCaseLogDetail> result_list = new ArrayList<EntityCaseLogDetail>();
		boolean flag = true;
		for (EntityCaseLogDetail ecld : liste) {
			if (result_list.size() == 0) {
				result_list.add(ecld);
			} else {
				for (EntityCaseLogDetail _uid : result_list) {
					if (_uid.getCase_time().toString().substring(0, 10).equals(
							ecld.getCase_time().toString().substring(0, 10))) {
						flag = false;
					}
				}
				if (flag) {
					result_list.add(ecld);
				}
				flag = true;
			}
		}
		return result_list;
	}

	public ArrayList getAllDateListSell(List<EntitySellDetail> lesd) {
		ArrayList<String> _arr = new ArrayList<String>();
		boolean flag = true;
		for (EntitySellDetail esd : lesd) {
			if (_arr.size() == 0) {
				_arr.add(esd.getDatetime());
			} else {
				for (String tmp : _arr) {
					if (esd.getDatetime().equals(tmp)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					_arr.add(esd.getDatetime());
				}
				flag = true;
			}
		}
		return _arr;
	}

	public List<Map<String,Object>> getCaseLogNovice(Map<String,Object> parms){
		return getBaseDao().getCaseLogNovice(parms);
	}
	
	public ArrayList<String> getAllDateListPay(List<EntityOrderInfoDetail> leoid) {
		ArrayList<String> _arr = new ArrayList<String>();
		boolean flag = true;
		for (EntityOrderInfoDetail eoid : leoid) {
			if (_arr.size() == 0) {
				_arr.add(eoid.getDataTime().substring(0, 10));
			} else {
				for (String tmp : _arr) {
					if (eoid.getDataTime().substring(0, 10).equals(tmp)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					_arr.add(eoid.getDataTime().substring(0, 10));
				}
				flag = true;
			}
		}
		return _arr;

	}

	public List<EntityCaseLogDetail> getAllDateListTimeToTime(
			List<EntityCaseLogDetail> liste, String createTime1,
			String createTime2) {
		List<EntityCaseLogDetail> result_list = new ArrayList<EntityCaseLogDetail>();

		for (EntityCaseLogDetail ecld : liste) {
			Timestamp shit = getTimestamp(ecld.getCase_time().toString()
					.substring(0, 10));
			if (shit.compareTo(getTimestamp(createTime1)) >= 0
					&& getTimestamp(
							ecld.getCase_time().toString().substring(0, 10))
							.compareTo(getTimestamp(createTime2)) <= 0) {
				result_list.add(ecld);
			}
		}
		return result_list;
	}

	/* 不含重复的 */
	public List<EntityCaseLogDetail> publicFunction(
			List<EntityCaseLogDetail> liste, int case_id) {
		List<Integer> uid = new ArrayList<Integer>();
		List<EntityCaseLogDetail> result_list = new ArrayList<EntityCaseLogDetail>();
		int uid2 = 0;
		boolean flag = true;
		for (EntityCaseLogDetail ecld : liste) {
			if (ecld.getCase_id() == case_id) {
				if (uid.size() == 0 && ecld.getCase_id() == case_id) {
					uid.add(ecld.getUser_id());
					result_list.add(ecld);
				} else {
					for (int _uid : uid) {
						uid2 = ecld.getUser_id();
						if (_uid == uid2) {
							flag = false;
						}
					}
					if (flag) {
						uid.add(ecld.getUser_id());
						result_list.add(ecld);
					}
				}
			}
			flag = true;
		}
		return result_list;
	}

	/* 不含重复的 */
	public List<EntityCaseLogDetail> publicFunction(
			List<EntityCaseLogDetail> liste, int case_id, String _datetime) {
		List<Integer> uid = new ArrayList<Integer>();
		List<EntityCaseLogDetail> result_list = new ArrayList<EntityCaseLogDetail>();
		int uid2 = 0;
		boolean flag = true;
		for (EntityCaseLogDetail ecld : liste) {
			if (ecld.getCase_id() == case_id) {
				if (uid.size() == 0
						&& ecld.getCase_time().toString().substring(0, 10)
								.equals(_datetime)) {
					uid.add(ecld.getUser_id());
					result_list.add(ecld);
				} else {
					for (int _uid : uid) {
						uid2 = ecld.getUser_id();
						if (_uid == uid2 && ecld.getCase_id() == case_id) {
							flag = false;
						}
					}
					if (flag
							&& ecld.getCase_time().toString().substring(0, 10)
									.equals(_datetime)) {
						uid.add(ecld.getUser_id());
						result_list.add(ecld);
					}
					flag = true;
				}
			}
		}
		return result_list;
	}

	/* 对应userid 进行匹配获取 */
	public List<EntityCaseLogDetail> publicFunction(
			List<EntityCaseLogDetail> liste, int case_id,
			List<EntityCaseLogDetail> user_id) {
		List<Integer> uid = new ArrayList<Integer>();
		List<EntityCaseLogDetail> result_list = new ArrayList<EntityCaseLogDetail>();
		int uid2 = 0;
		boolean flag = true;
		for (EntityCaseLogDetail ecld : liste) {
			if (ecld.getCase_id() == case_id) {
				for (EntityCaseLogDetail ecld_user_id : user_id) {
					if (ecld.getUser_id() == ecld_user_id.getUser_id()
							&& uid.size() == 0) {
						uid.add(ecld.getUser_id());
						result_list.add(ecld);
					} else {
						for (int _uid : uid) {
							uid2 = ecld.getUser_id();
							if (_uid == uid2) {
								flag = false;
							}
						}
						if (flag
								&& ecld_user_id.getUser_id() == ecld
										.getUser_id()) {
							uid.add(ecld.getUser_id());
							result_list.add(ecld);
						}
					}
				}
			}
			flag = true;
		}
		return result_list;
	}

	/* 对应userid 和时间进行匹配获得 */
	public List<EntityCaseLogDetail> publicFunction(
			List<EntityCaseLogDetail> liste, int case_id,
			List<EntityCaseLogDetail> user_id, String _datetime) {
		List<Integer> uid = new ArrayList<Integer>();
		List<EntityCaseLogDetail> result_list = new ArrayList<EntityCaseLogDetail>();
		int uid2 = 0;
		boolean flag = true;
		for (EntityCaseLogDetail ecld : liste) {
			if (ecld.getCase_id() == case_id) {
				for (EntityCaseLogDetail ecld_user_id : user_id) {
					if (ecld.getUser_id() == ecld_user_id.getUser_id()
							&& uid.size() == 0
							&& ecld.getCase_time().toString().substring(0, 10)
									.equals(_datetime)) {
						uid.add(ecld.getUser_id());
						result_list.add(ecld);
					} else {
						for (int _uid : uid) {
							uid2 = ecld.getUser_id();
							if (_uid == uid2) {
								flag = false;
							}
						}
						if (flag
								&& ecld_user_id.getUser_id() == ecld
										.getUser_id()
								&& ecld.getCase_time().toString().substring(0,
										10).equals(_datetime)) {
							uid.add(ecld.getUser_id());
							result_list.add(ecld);
						}

					}
				}
			}
			flag = true;
		}
		return result_list;
	}

	/* 包含重复 */
	public int publicFunctionAll(List<EntityCaseLogDetail> liste, int case_id) {
		List<Integer> uid = new ArrayList<Integer>();
		for (EntityCaseLogDetail ecld : liste) {
			if (ecld.getCase_id() == case_id) {
				uid.add(ecld.getUser_id());
			}
		}
		return uid.size();
	}

	/* 包含重复，根据时间匹配 */
	public int publicFunctionAll(List<EntityCaseLogDetail> liste, int case_id,
			String _datetime) {
		List<Integer> uid = new ArrayList<Integer>();
		for (EntityCaseLogDetail ecld : liste) {
			if (ecld.getCase_id() == case_id
					&& ecld.getCase_time().toString().substring(0, 10).equals(
							_datetime)) {
				uid.add(ecld.getUser_id());
			}
		}
		return uid.size();
	}

	public List<EntityCaseLogDetail> publicFunctionAll(
			List<EntityCaseLogDetail> liste, String _datetime, int case_id) {
		List<EntityCaseLogDetail> lecld = new ArrayList<EntityCaseLogDetail>();
		for (EntityCaseLogDetail ecld : liste) {
			if (ecld.getCase_id() == case_id
					&& ecld.getCase_time().toString().substring(0, 10).equals(
							_datetime)) {
				lecld.add(ecld);
			}
		}
		return lecld;
	}

	/* 包含重复,获取道具强化 */
	public List<EntityCaseLogDetail> publicFunctionIntensify(
			List<EntityCaseLogDetail> liste, int case_id, String _datetime) {

		List<EntityCaseLogDetail> result_list = new ArrayList<EntityCaseLogDetail>();
		for (EntityCaseLogDetail ecld : liste) {
			if (ecld.getCase_id() == case_id
					&& ecld.getCase_time().toString().substring(0, 10).equals(
							_datetime)) {
				result_list.add(ecld);
			}
		}
		return result_list;
	}

	/* 查看道具销量 70~72买 73~75卖，允许相同的数据 */
	public List<EntityCaseLogDetail> publicFunctionItem(
			List<EntityCaseLogDetail> liste, int case_id, String _datetime) {
		List<Integer> uid = new ArrayList<Integer>();
		List<EntityCaseLogDetail> result_list = new ArrayList<EntityCaseLogDetail>();
		for (EntityCaseLogDetail ecld : liste) {
			if (ecld.getCase_id() == case_id) {
				if (ecld.getCase_time().toString().substring(0, 10).equals(
						_datetime)) {
					uid.add(ecld.getUser_id());
					result_list.add(ecld);
				}
			}
		}
		return result_list;
	}

	/* 查看道具销量 70~72买 73~75卖，允许相同的数据 */
	public List<EntityCaseLogDetail> publicFunctionItem(
			List<EntityCaseLogDetail> liste, int case_id) {
		List<EntityCaseLogDetail> result_list = new ArrayList<EntityCaseLogDetail>();
		for (EntityCaseLogDetail ecld : liste) {
			if (ecld.getCase_id() == case_id) {
				result_list.add(ecld);
			}
		}
		return result_list;
	}

	/**
	 * 时间段之间的查询,不允许重复
	 */
	public List<EntityCaseLogDetail> publicTimeToTime(
			List<EntityCaseLogDetail> liste, int case_id, String createTime1,
			String createTime2) {
		List<EntityCaseLogDetail> result_list = new ArrayList<EntityCaseLogDetail>();
		List<EntityCaseLogDetail> rs = this.publicFunctionItem(liste, case_id);
		List<Integer> uid = new ArrayList<Integer>();
		int uid2 = 0;
		boolean flag = true;
		for (EntityCaseLogDetail ecld : rs) {
			if (createTime1 != null && createTime2 != null) {// 当又开始时间和
																// 结束时间的时候
																// ，就便利里面的。
				String datetime = ecld.getCase_time().toString().substring(0,
						10);
				if (getTimestamp(datetime).compareTo(getTimestamp(createTime1)) >= 0
						&& getTimestamp(datetime).compareTo(
								getTimestamp(createTime2)) <= 0) {
					if (ecld.getCase_id() == case_id) {
						if (result_list.size() == 0
								&& ecld.getCase_id() == case_id) {
							uid.add(ecld.getUser_id());
							result_list.add(ecld);
						} else {
							for (int _uid : uid) {
								uid2 = ecld.getUser_id();
								if (_uid == uid2
										&& ecld.getCase_id() == case_id) {
									flag = false;
								}
							}
							if (flag) {
								uid.add(ecld.getUser_id());
								result_list.add(ecld);
							}
						}
					}
					flag = true;
				}
			} else {// 如果没有时间传进来的就将结果集全部输出
				return rs;
			}
		}
		return result_list;
	}

	/**
	 * 时间段之间的查询。允许有重复的
	 */
	public List<EntityCaseLogDetail> publicTimeToTimeAll(
			List<EntityCaseLogDetail> liste, int caseid, String crateTime1,
			String crateTime2) {
		List<EntityCaseLogDetail> rs = new ArrayList<EntityCaseLogDetail>();
		List<EntityCaseLogDetail> result_list = this.publicFunctionItem(liste,
				caseid);
		for (EntityCaseLogDetail res : result_list) {
			if (crateTime1 != null && crateTime2 != null) {// 当又开始时间和 结束时间的时候
															// ，就便利里面的。
				String datetime = res.getCase_time().toString()
						.substring(0, 10);
				if (caseid == 0) {
					// 不区分坐标。不做信息比对
					if (getTimestamp(datetime).compareTo(
							getTimestamp(crateTime1)) >= 0) {
						rs.add(res);
					}
				} else {
					if (getTimestamp(datetime).compareTo(
							getTimestamp(crateTime1)) >= 0
							&& getTimestamp(datetime).compareTo(
									getTimestamp(crateTime2)) <= 0) {
						rs.add(res);
					}
				}
			} else {// 如果没有时间传进来的就将结果集全部输出
				return result_list;
			}
		}
		return rs;
	}

	public int getAllUserOnline(List<EntityCaseLogDetail> liste) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getAllUserRegCreateRole(List<EntityCaseLogDetail> liste,
			String _datetime) {
		return this.publicFunction(liste, 69, _datetime).size();
	}

	public int getAllUserReg(List<EntityCaseLogDetail> liste, String _datetime) {
		return this.publicFunctionAll(liste, 69, _datetime);
	}

	public int getAllUserRegLoding(List<EntityCaseLogDetail> liste,
			String _datetime) {
		// TODO 根据时间获得注册用户群里里面那些是成功进入游戏的（完成新手引导以后的进入游戏主场景 5）
		List<EntityCaseLogDetail> resultList = this.publicFunction(liste, 69,
				_datetime);
		/* 获得新手的所有的id号，在去查询这些人在数据里面那些是成功进入游戏的。 */
		return this.publicFunction(liste, 5, resultList, _datetime).size();
	}
	
	
	//获取新人实际进入游戏数
	public int getAllUserRegLoding(List<EntityCaseLogDetail> liste){
		//** 判断结果集中 拥有 69  和 98 的数据就是新手进入游戏的数据
	    //首先先过滤掉重复的数据
		List<EntityCaseLogDetail> user_69=publicFunction(liste,69);
		List<EntityCaseLogDetail> user_5=publicFunction(liste,98);
		//System.out.println("98的数据条数是"+user_5.size());
		//System.out.println("69的数据条数是"+user_69.size());
		List<Integer> tempArray = new ArrayList<Integer>();
		boolean flag=true;
		for(EntityCaseLogDetail ecid_5 :user_5 ){
			for(EntityCaseLogDetail ecid_69:user_69){
				if(ecid_5.getUser_id()==ecid_69.getUser_id() && tempArray.size()==0){
					tempArray.add(ecid_5.getUser_id());break;
				}else if(ecid_5.getUser_id()==ecid_69.getUser_id()){
					for(int tempUserid:tempArray){
						if(tempUserid==ecid_69.getUser_id()){
							flag=false;break;
						}
					}
					if(flag){
						tempArray.add(ecid_69.getUser_id());break;
					}
				}
				
			}flag=true;
		}
		return tempArray.size();
	}

	public int getAllUserLoding(List<EntityCaseLogDetail> liste,int caseid1,int caseid2){
		
	    //首先先过滤掉重复的数据
		List<EntityCaseLogDetail> user_69=publicFunction(liste,caseid1);
		List<EntityCaseLogDetail> user_5=publicFunction(liste,caseid2);
		//System.out.println("98的数据条数是"+user_5.size());
		//System.out.println("69的数据条数是"+user_69.size());
		List<Integer> tempArray = new ArrayList<Integer>();
		boolean flag=true;
		for(EntityCaseLogDetail ecid_5 :user_5 ){
			for(EntityCaseLogDetail ecid_69:user_69){
				if(ecid_5.getUser_id()==ecid_69.getUser_id() && tempArray.size()==0){
					tempArray.add(ecid_5.getUser_id());break;
				}else if(ecid_5.getUser_id()==ecid_69.getUser_id()){
					for(int tempUserid:tempArray){
						if(tempUserid==ecid_69.getUser_id()){
							flag=false;break;
						}
					}
					if(flag){
						tempArray.add(ecid_69.getUser_id());break;
					}
				}
				
			}flag=true;
		}
		return tempArray.size();
	}
	
	public int getUserOnlineAvg(List<EntityCaseLogDetail> liste) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getUserOnlineMax(List<EntityCaseLogDetail> liste) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<EntityCaseLogDetail> getAllPoint(Map<String, Object> parms) {
		// TODO Auto-generated method stub
		return getBaseDao().getAllLgo(parms);
	}

	public List<EntityCaseLogDetail> getAllPoint(String tablename) {
		// TODO Auto-generated method stub
		return getBaseDao().getAllLgo(tablename);
	}

	public int getAllUserCount(List<EntityCaseLogDetail> liste, String _datetime) {
		// 根据时间获取所有用户的登录次数
		return this.publicFunction(liste, 3, _datetime).size();
	}

	public int getAllUserCountAll(List<EntityCaseLogDetail> liste,
			String _datetime) {
		// TODO Auto-generated method stub
		return this.publicFunctionAll(liste, 3, _datetime);
	}

	public int getAllUserLoginAll(List<EntityCaseLogDetail> liste,
			String _datetime) {
		// TODO Auto-generated method stub
		return this.publicFunctionAll(liste, 4, _datetime);
	}

	public int getAllUserLogin(List<EntityCaseLogDetail> liste, String _datetime) {
		// TODO 根据时间来获取成功进入游戏的玩家数量 4 选取

		return this.publicFunction(liste, 4, _datetime).size();
	}

	public int getAllUserRegLodingAll(List<EntityCaseLogDetail> liste,
			String _datetime) {
		// TODO Auto-generated method stub
		return this.publicFunctionAll(liste, 4, _datetime);
	}

	public int getAllUserRegAll(List<EntityCaseLogDetail> liste,
			String _datetime) {
		return this.publicFunctionAll(liste, 4, _datetime);
	}

	public List<EntityCaseLogDetail> getBuyGiftItem(
			List<EntityCaseLogDetail> liste, String _datetime) {
		// TODO 获取通过礼金购买的道具 code 71
		List<EntityCaseLogDetail> result_list = null;
		result_list = this.publicFunctionItem(liste, 71, _datetime);
		return result_list;
	}

	public List<EntityCaseLogDetail> getBuyGoldItem(
			List<EntityCaseLogDetail> liste, String _datetime) {
		// TODO Auto-generated method stub
		List<EntityCaseLogDetail> result_list = null;
		return result_list;
	}

	public List<EntityCaseLogDetail> getBuyRmbItem(
			List<EntityCaseLogDetail> liste, String _datetime) {
		// TODO 查询出所有rmb 购买的道具数量 70
		List<EntityCaseLogDetail> result_list = null;
		result_list = this.publicFunctionItem(liste, 70, _datetime);
		return result_list;
	}

	public List<EntityCaseLogDetail> getUseGiftItem(
			List<EntityCaseLogDetail> liste, String _datetime) {
		// TODO Auto-generated method stub
		List<EntityCaseLogDetail> result_list = null;
		return result_list;
	}

	public List<EntityCaseLogDetail> getUseGoldItem(
			List<EntityCaseLogDetail> liste, String _datetime) {
		// TODO Auto-generated method stub
		List<EntityCaseLogDetail> result_list = null;
		return result_list;
	}

	public List<EntityCaseLogDetail> getUseRmbItem(
			List<EntityCaseLogDetail> liste, String _datetime) {
		// TODO Auto-generated method stub
		List<EntityCaseLogDetail> result_list = null;
		return result_list;
	}

	public List<EntityCaseLogDetail> getAvataItem(
			List<EntityCaseLogDetail> liste, int _type) {
		/* 根据类型获取数据 */
		List<EntityCaseLogDetail> result_list = null;
		return null;
	}

	public List<EntityCaseLogDetail> getIntensify(
			List<EntityCaseLogDetail> liste, String _datetime) {
		// 获取所有的强化信息
		return this.publicFunctionIntensify(liste, 79, _datetime);
	}

	public List<EntityCaseLogDetail> getSynthesis(
			List<EntityCaseLogDetail> liste, String _datetime) {
		// 获得所有的合成记录
		return this.publicFunctionIntensify(liste, 77, _datetime);
	}

	public List<EntityCaseLogDetail> getSynthesisItem(
			List<EntityCaseLogDetail> liste, String _datetime) {
		// 获得合成记录
		return this.publicFunctionIntensify(liste, 78, _datetime);
	}

	public List<EntityCaseLogDetail> getIntensifyItem(
			List<EntityCaseLogDetail> liste, String _datetime) {
		// 获得合成产出的道具
		return this.publicFunctionIntensify(liste, 80, _datetime);
	}

	/* 根据时间区间进行数据便利 */
	public List<EntityCaseLogDetail> getBuyRmbItem(
			List<EntityCaseLogDetail> liste, String crateTime1,
			String crateTime2) {
		// TODO 查询出所有rmb 购买的道具数量 70
		List<EntityCaseLogDetail> rs = new ArrayList<EntityCaseLogDetail>();
		List<EntityCaseLogDetail> result_list = this.publicFunctionItem(liste,
				70);
		for (EntityCaseLogDetail res : result_list) {
			if (crateTime1 != null && crateTime2 != null) {// 当又开始时间和 结束时间的时候
															// ，就便利里面的。
				String datetime = res.getCase_time().toString()
						.substring(0, 10);
				if (getTimestamp(datetime).compareTo(getTimestamp(crateTime1)) >= 0
						&& getTimestamp(datetime).compareTo(
								getTimestamp(crateTime2)) <= 0) {
					rs.add(res);
				}
			} else {// 如果没有时间传进来的就将结果集全部输出
				return result_list;
			}
		}
		return rs;
	}

	/* 根据时间区间获取注册成功的玩家 68 */
	public List<EntityCaseLogDetail> getAllUserReg(
			List<EntityCaseLogDetail> liste, String crateTime1,
			String crateTime2) {
		List<EntityCaseLogDetail> lur = this.publicTimeToTimeAll(liste, 68,
				crateTime1, crateTime2);
		return lur;
	}

	/**
	 * @method getAllUserRegLodingAll
	 * @param LIst
	 *            {EntityCaseLogDetail} 确定记录的唯一标识组，供数据库查询
	 * @return {Int}
	 * @description 根据时间区域获取所有注册玩成功进入游戏的人数，进入游戏主菜单 code5
	 */
	public List<EntityCaseLogDetail> getAllUserRegLoding(
			List<EntityCaseLogDetail> liste, String crateTime1,
			String crateTime2) {
		List<EntityCaseLogDetail> lur = this.publicTimeToTimeAll(liste, 68,
				crateTime1, crateTime2);// 先将时间段的数据都便利出来。里面是包含重复用户的
		// 在便利一次 ，不含重复信息的数据
		return publicFunction(liste, 4, lur);
	}
	
	public int getAllUserRegLoding(List<EntityCaseLogDetail> lecld69,List<EntityCaseLogDetail> lecld98){
		int count=0;
		for(EntityCaseLogDetail temp69:lecld69){
			for(EntityCaseLogDetail temp98:lecld98){
				if(temp69.getUser_id()==temp98.getUser_id()){
					count++;
				}
			}
		}
		return count;
	}
	
	 public List<EntityCaseLogDetail> getAllPointMaxOnline(Map<String,Object> parms){
		return this.getBaseDao().getAllPointMaxOnline(parms);
	 }

	/* 获取最高在线 */
	public int getAllUserOnlineMax(List<EntityCaseLogDetail> liste,
			String createTime) {
		int online = 0;
		int maxline=0;
		HashMap<String, Object> playerHashMap = new HashMap<String, Object>();
		final Object object = new Object();
		for (EntityCaseLogDetail ecld : liste) {
//			System.out.println(ecld.getCase_id());
			switch (ecld.getCase_id()) {
			  case 2:
					if (playerHashMap.remove(String.valueOf(ecld.getUser_id()) + "") != null) {
						online--;
						if (online < 0) {
							online = 0;
							//System.out.println("小于0");
						}
						
					}
					break;
			    case 3:
			    case 31:
				case 4:
					if(playerHashMap.put(String.valueOf(ecld.getUser_id()), object)==null){
					online++;
					if(online>maxline)
					{
						maxline=online;
					}
					}
					break;
			}
		}
		return maxline;
	}
	
	//** 每5分钟记录一次当前的在线人数
	public String checkOnlineNum(List<EntityCaseLogDetail> liste){
		String result="";
		int online = 0;
		int count=0;
		boolean flag=true;
		HashMap<String, Object> playerHashMap = new HashMap<String, Object>();
		final Object object = new Object();
		List<String> array_list= new ArrayList<String>();
		for (EntityCaseLogDetail ecld : liste) {
			switch (ecld.getCase_id()) {
			  case 2:
					if (playerHashMap.remove(String.valueOf(ecld.getUser_id()) + "") != null) {
						online--;
						if (online < 0) {
							online = 0;
							//System.out.println("小于0");
						}
					}
					break;
			    case 3:
			    case 31:
				case 4:
					if(playerHashMap.put(String.valueOf(ecld.getUser_id()), object)==null){
					online++;
					}
					break;
			}
			//**根据时间端来插入数据，5分钟一次。	
//			System.out.print(ecld.getCase_time().toString().substring(10, 16));
			int tempNum=Integer.parseInt(ecld.getCase_time().toString().substring(14,16));
			if(tempNum % 5==0 && (ecld.getCase_id()==2 || ecld.getCase_id()==4)){//每5分钟采集一次
				if(array_list.size()==0){
					array_list.add(ecld.getCase_time().toString().substring(10,16));
					result+=ecld.getCase_time().toString().substring(10,16)+"-"+online+",";
					count+=online;
				}else{
					for(String temp:array_list){
						if(temp.equals(ecld.getCase_time().toString().substring(10,16))){
							//System.out.println("demo "+temp+"-"+ecld.getCase_time().toString().substring(10,16));
							flag=false;
						}
					}if(flag){
						array_list.add(ecld.getCase_time().toString().substring(10,16));
						result+=ecld.getCase_time().toString().substring(10,16)+"-"+online+",";
						count+=online;
					}
				}flag=true;
			}
		}
		//** 平均数
		if(array_list.size()>0)
		count=count/array_list.size();
		else
		count=0;
		result+="&"+count;
		//System.out.println("最后的数据效验的结果"+result+"|"+count);
		return result;
	}

	public int getAllUserOnlineMax(List<EntityCaseLogDetail> liste,
			String createTime1, String createTime2) {
		List<EntityCaseLogDetail> rs = new ArrayList<EntityCaseLogDetail>();
		int online = 0;
		int maxline = 0;
		for (EntityCaseLogDetail ecld : liste) {
			if (createTime1 != null && createTime2 != null) {// 当又开始时间和
																// 结束时间的时候
																// ，就便利里面的。
				String datetime = ecld.getCase_time().toString().substring(0,
						10);
				if (getTimestamp(datetime).compareTo(getTimestamp(createTime1)) >= 0
						&& getTimestamp(datetime).compareTo(
								getTimestamp(createTime2)) <= 0) {

					// 开始对在线人数进行便利
					if (ecld.getCase_id() == 3) {
						online++;
						if (online > maxline) {
							maxline = online;
						}
					} else if (ecld.getCase_id() == 2) {
						online--;
						if (online < 0) {
							online = 0;
						}
						if (online > maxline) {
							maxline = online;
						}
					}
					rs.add(ecld);
				}
			}
		}
		return maxline;
	}

	public List<EntityCaseLogDetail> getUniqueUser(
			List<EntityCaseLogDetail> liste, String createTime1,
			String createTime2) {
		List<EntityCaseLogDetail> ecld = new ArrayList<EntityCaseLogDetail>();
		ecld = publicTimeToTime(liste, 3, createTime1, createTime2);
		return ecld;
	}

	public List<EntityCaseLogDetail> getUniqueUser(
			List<EntityCaseLogDetail> liste, String createTime) {
		return this.publicFunction(liste, 3, createTime);
	}

	/**
	 * 时间戳的转换
	 */
	public Timestamp getTimestamp(String timestamp) {
		if (timestamp == null) {
			return null;
		}
		Timestamp ts = null;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);
		try {
			ts = new Timestamp(format.parse(timestamp).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.print("输入的时间是错误的");
		}
		return ts;
	}

	/* 新手引导 31~67 */

	public EntityCheckNoviceDetail getNovice(List<EntityCaseLogDetail> lecld,
			String date) {
		EntityCheckNoviceDetail ecnd = new EntityCheckNoviceDetail();
		//System.out.println("结果集大小为"+lecld.size());
		ecnd.setNovice1(this.noRepleAll(lecld,31).size());
		ecnd.setNovice2(this.noRepleAll(lecld,32).size());
		ecnd.setNovice3(this.noRepleAll(lecld,33).size());
		ecnd.setNovice4(this.noRepleAll(lecld,34).size());
		ecnd.setNovice5(this.noRepleAll(lecld,35).size());
		ecnd.setNovice6(this.noRepleAll(lecld,36).size());
		ecnd.setNovice7(this.noRepleAll(lecld,37).size());
		ecnd.setNovice8(this.noRepleAll(lecld,38).size());
		ecnd.setNovice9(this.noRepleAll(lecld,39).size());
		ecnd.setNovice10(this.noRepleAll(lecld,40).size());
		ecnd.setNovice11(this.noRepleAll(lecld,41).size());
		ecnd.setNovice12(this.noRepleAll(lecld,42).size());
		ecnd.setNovice13(this.noRepleAll(lecld,43).size());
		ecnd.setNovice14(this.noRepleAll(lecld,44).size());
		ecnd.setNovice15(this.noRepleAll(lecld,45).size());
		ecnd.setNovice16(this.noRepleAll(lecld,46).size());
		ecnd.setNovice17(this.noRepleAll(lecld,47).size());
		ecnd.setNovice18(this.noRepleAll(lecld,48).size());
		ecnd.setNovice19(this.noRepleAll(lecld,49).size());
		ecnd.setNovice20(this.noRepleAll(lecld,50).size());
		ecnd.setNovice21(this.noRepleAll(lecld,51).size());
		ecnd.setNovice22(this.noRepleAll(lecld,52).size());
		ecnd.setNovice23(this.noRepleAll(lecld,53).size());
		ecnd.setNovice24(this.noRepleAll(lecld,54).size());
		ecnd.setNovice25(this.noRepleAll(lecld,55).size());
		ecnd.setNovice26(this.noRepleAll(lecld,56).size());
		ecnd.setNovice27(this.noRepleAll(lecld,57).size());
		ecnd.setNovice28(this.noRepleAll(lecld,58).size());
		ecnd.setNovice29(this.noRepleAll(lecld,59).size());
		ecnd.setNovice30(this.noRepleAll(lecld,60).size());
		ecnd.setNovice31(this.noRepleAll(lecld,61).size());
		ecnd.setNovice32(this.noRepleAll(lecld,62).size());
		ecnd.setNovice33(this.noRepleAll(lecld,63).size());
		ecnd.setNovice34(this.noRepleAll(lecld,64).size());
		ecnd.setNovice35(this.noRepleAll(lecld,65).size());
		ecnd.setNovice36(this.noRepleAll(lecld,66).size());
		ecnd.setNovice37(this.noRepleAll(lecld,67).size());
		ecnd.setNovice38(this.noRepleAll(lecld,125).size());
		ecnd.setNovice39(this.noRepleAll(lecld,126).size());
		ecnd.setNovice40(this.noRepleAll(lecld,127).size());
		ecnd.setNovice41(this.noRepleAll(lecld,128).size());
		ecnd.setNovice42(this.noRepleAll(lecld,129).size());
		ecnd.setNovice43(this.noRepleAll(lecld,130).size());
		ecnd.setNovice44(this.noRepleAll(lecld,131).size());
		ecnd.setNovice45(this.noRepleAll(lecld,132).size());
		ecnd.setNovice46(this.noRepleAll(lecld,133).size());
		ecnd.setNovice47(this.noRepleAll(lecld,134).size());

		return ecnd;
	}
	
	public EntityCheckNoviceDetail getNovice(List<Map<String,Object>> lmap){
		EntityCheckNoviceDetail ecnd = new EntityCheckNoviceDetail();
		for(Map<String,Object> tempMap:lmap){
			switch(Integer.parseInt(tempMap.get("case_id")+"")){
			case 31:ecnd.setNovice1(Integer.parseInt(tempMap.get("ct")+""));break;
			case 32:ecnd.setNovice2(Integer.parseInt(tempMap.get("ct")+""));break;
			case 33:ecnd.setNovice3(Integer.parseInt(tempMap.get("ct")+""));break;
			case 34:ecnd.setNovice4(Integer.parseInt(tempMap.get("ct")+""));break;
			case 35:ecnd.setNovice5(Integer.parseInt(tempMap.get("ct")+""));break;
			case 36:ecnd.setNovice6(Integer.parseInt(tempMap.get("ct")+""));break;
			case 37:ecnd.setNovice7(Integer.parseInt(tempMap.get("ct")+""));break;
			case 38:ecnd.setNovice8(Integer.parseInt(tempMap.get("ct")+""));break;
			case 39:ecnd.setNovice9(Integer.parseInt(tempMap.get("ct")+""));break;
			case 40:ecnd.setNovice10(Integer.parseInt(tempMap.get("ct")+""));break;
			case 41:ecnd.setNovice11(Integer.parseInt(tempMap.get("ct")+""));break;
			case 42:ecnd.setNovice12(Integer.parseInt(tempMap.get("ct")+""));break;
			case 43:ecnd.setNovice13(Integer.parseInt(tempMap.get("ct")+""));break;
			case 44:ecnd.setNovice14(Integer.parseInt(tempMap.get("ct")+""));break;
			case 45:ecnd.setNovice15(Integer.parseInt(tempMap.get("ct")+""));break;
			case 46:ecnd.setNovice16(Integer.parseInt(tempMap.get("ct")+""));break;
			case 47:ecnd.setNovice17(Integer.parseInt(tempMap.get("ct")+""));break;
			case 48:ecnd.setNovice18(Integer.parseInt(tempMap.get("ct")+""));break;
			case 49:ecnd.setNovice19(Integer.parseInt(tempMap.get("ct")+""));break;
			case 50:ecnd.setNovice20(Integer.parseInt(tempMap.get("ct")+""));break;
			case 51:ecnd.setNovice21(Integer.parseInt(tempMap.get("ct")+""));break;
			case 52:ecnd.setNovice22(Integer.parseInt(tempMap.get("ct")+""));break;
			case 53:ecnd.setNovice23(Integer.parseInt(tempMap.get("ct")+""));break;
			case 54:ecnd.setNovice24(Integer.parseInt(tempMap.get("ct")+""));break;
			case 55:ecnd.setNovice25(Integer.parseInt(tempMap.get("ct")+""));break;
			case 56:ecnd.setNovice26(Integer.parseInt(tempMap.get("ct")+""));break;
			case 57:ecnd.setNovice27(Integer.parseInt(tempMap.get("ct")+""));break;
			case 58:ecnd.setNovice28(Integer.parseInt(tempMap.get("ct")+""));break;
			case 59:ecnd.setNovice29(Integer.parseInt(tempMap.get("ct")+""));break;
			case 60:ecnd.setNovice30(Integer.parseInt(tempMap.get("ct")+""));break;
			case 61:ecnd.setNovice31(Integer.parseInt(tempMap.get("ct")+""));break;
			case 62:ecnd.setNovice32(Integer.parseInt(tempMap.get("ct")+""));break;
			case 63:ecnd.setNovice33(Integer.parseInt(tempMap.get("ct")+""));break;
			case 64:ecnd.setNovice34(Integer.parseInt(tempMap.get("ct")+""));break;
			case 65:ecnd.setNovice35(Integer.parseInt(tempMap.get("ct")+""));break;
			case 66:ecnd.setNovice36(Integer.parseInt(tempMap.get("ct")+""));break;
			case 67:ecnd.setNovice37(Integer.parseInt(tempMap.get("ct")+""));break;
			case 125:ecnd.setNovice38(Integer.parseInt(tempMap.get("ct")+""));break;
			case 126:ecnd.setNovice39(Integer.parseInt(tempMap.get("ct")+""));break;
			case 127:ecnd.setNovice40(Integer.parseInt(tempMap.get("ct")+""));break;
			case 128:ecnd.setNovice41(Integer.parseInt(tempMap.get("ct")+""));break;
			case 129:ecnd.setNovice42(Integer.parseInt(tempMap.get("ct")+""));break;
			case 130:ecnd.setNovice43(Integer.parseInt(tempMap.get("ct")+""));break;
			case 131:ecnd.setNovice44(Integer.parseInt(tempMap.get("ct")+""));break;
			case 132:ecnd.setNovice45(Integer.parseInt(tempMap.get("ct")+""));break;
			case 133:ecnd.setNovice46(Integer.parseInt(tempMap.get("ct")+""));break;
			case 134:ecnd.setNovice47(Integer.parseInt(tempMap.get("ct")+""));break;
			case 135:ecnd.setNovice48(Integer.parseInt(tempMap.get("ct")+""));break;
			case 136:ecnd.setNovice49(Integer.parseInt(tempMap.get("ct")+""));break;
			case 137:ecnd.setNovice50(Integer.parseInt(tempMap.get("ct")+""));break;
			case 138:ecnd.setNovice51(Integer.parseInt(tempMap.get("ct")+""));break;
			case 139:ecnd.setNovice52(Integer.parseInt(tempMap.get("ct")+""));break;
			case 140:ecnd.setNovice53(Integer.parseInt(tempMap.get("ct")+""));break;
			}
		
	}
		return ecnd;
	}

	public List<EntityCaseLogDetail> staicPublic(
			List<EntityCaseLogDetail> lecld, String date, int caseid) {
		// TODO Auto-generated method stub
		return this.publicFunctionIntensify(lecld, caseid, date);
	}

	public List<EntityCaseLogDetail> noRepleAll(
			List<EntityCaseLogDetail> liste, int caseid) {
		return publicFunction(liste, caseid);
	}

	public List<EntityCaseLogDetail> noRepleAll(
			List<EntityCaseLogDetail> liste, int caseid, String _datetime) {
		return publicFunction(liste, caseid, _datetime);
	}

	public List<EntityCaseLogDetail> checkTask(List<EntityCaseLogDetail> lecld,
			String _dateTime) {
		List<Integer> uid = new ArrayList<Integer>();
		List<EntityCaseLogDetail> result_list = new ArrayList<EntityCaseLogDetail>();
		for (EntityCaseLogDetail ecld : lecld) {
			if (ecld.getCase_id() >= 107 && ecld.getCase_id() <= 113) {
				if (ecld.getCase_time().toString().substring(0, 10).equals(
						_dateTime)) {
					uid.add(ecld.getUser_id());
					result_list.add(ecld);
				}
			}
		}
		return result_list;

	}

	public List<EntityCaseLogDetail> checkBattle(
			List<EntityCaseLogDetail> lecld, String _dateTime) {

		List<EntityCaseLogDetail> result_list = new ArrayList<EntityCaseLogDetail>();
		for (EntityCaseLogDetail ecld : lecld) {
			if (ecld.getCase_id() == 106) {
				if (ecld.getCase_time().toString().substring(0, 10).equals(
						_dateTime)) {
					result_list.add(ecld);
				}
			}
		}
		return result_list;
	}

	public List<EntityCaseLogDetail> repleAll(List<EntityCaseLogDetail> lists,
			int caseid, String _datetime) {
		return publicFunctionAll(lists, _datetime, caseid);
	}

	public List<EntityCaseLogDetail> repleAll(List<EntityCaseLogDetail> liste,
			int caseid) {
		List<EntityCaseLogDetail> tempList = new ArrayList<EntityCaseLogDetail>();
		for (EntityCaseLogDetail ecld : liste) {
			if (ecld.getCase_id() == caseid) {
				tempList.add(ecld);
			}
		}
		return tempList;
	}
	
	public List<EntityCaseLogDetail> getAllPointByParams(Map<String,Object> params){
		return getBaseDao().getAllPointByParams(params);
	}
	
	public List<EntityCaseLogDetail> getAllMaxOnlineByLike(Map<String,Object> params){
		return getBaseDao().getAllMaxOnlineByLike(params);
	}
	public List<EntityCaseLogDetail> getAllInfoLike(Map<String,Object> params){
		return getBaseDao().getAllInfoLike(params);
	}
	public List<EntityCaseLogDetail> getAllInfoLikes(Map<String,Object> params){
		return getBaseDao().getAllInfoLikes(params);
	}
	public List<EntityCaseLogDetail> getQh(Map<String,Object> params){
		return getBaseDao().getQh(params);
	}
	
	public List<Map<String,Object>> checkOnlineTime(List<EntityCaseLogDetail> lecld2,List<EntityCaseLogDetail> lecld4 ){
		List<Map<String,Object>> lMap=new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> resMap= new ArrayList<Map<String,Object>>();
		long time4=0;
		long time2=0;
		for(EntityCaseLogDetail temp2:lecld2){
			for(int i=0;i<lecld4.size();i++){
				if(temp2.getUser_id()==lecld4.get(i).getUser_id()){
//					if(temp2.getUser_id()==20694){
//						System.out.print(temp2.getUser_id()+"-"+lecld4.get(i).getUser_id()+"__");
//						System.out.println(temp2.getCase_time()+"-"+lecld4.get(i).getCase_time());
//						}  
					Map<String,Object> result=new HashMap<String,Object>();
					time2=timeToUnix(temp2.getCase_time()+"");
					time4=timeToUnix(lecld4.get(i).getCase_time()+"");
					if(time2>time4){
						
						result.put(temp2.getUser_id()+"", (time2-time4));
					lecld4.remove(i);
					lMap.add(result);
					break;
					}
					}
				}
			}
		resMap=this.timeSum(lMap);
		return resMap;
	}
	
	public List<Map<String,Object>> checkOnlineTime(List<EntityCaseLogDetail> lecld){
//		List<Map<String,Object>> lMap=new ArrayList<Map<String,Object>>();
//		List<Map<String,Object>> resMap= new ArrayList<Map<String,Object>>();
//		long time4=0;
//		long time2=0;
//		for(EntityCaseLogDetail temp2:lecld2){
//			for(int i=0;i<lecld4.size();i++){
//				if(temp2.getUser_id()==lecld4.get(i).getUser_id()){
////					if(temp2.getUser_id()==20694){
////						System.out.print(temp2.getUser_id()+"-"+lecld4.get(i).getUser_id()+"__");
////						System.out.println(temp2.getCase_time()+"-"+lecld4.get(i).getCase_time());
////						}  
//					Map<String,Object> result=new HashMap<String,Object>();
//					time2=timeToUnix(temp2.getCase_time()+"");
//					time4=timeToUnix(lecld4.get(i).getCase_time()+"");
//					if(time2>time4){
//						
//						result.put(temp2.getUser_id()+"", (time2-time4));
//					lecld4.remove(i);
//					lMap.add(result);
//					break;
//					}
//					}
//				}
//			}
//		resMap=this.timeSum(lMap);
//		return resMap;
		return null;
	}
	
	//** 遍历相同的玩家的数据惊醒时间 累加
	public List<Map<String,Object>> timeSum(List<Map<String,Object>> parm){
		List<Map<String,Object>> lmap = new ArrayList<Map<String,Object>>();
		boolean flag=true;
		for(Map<String,Object> tempMap:parm){
			Map<String,Object> resMap = new HashMap<String,Object>();
			flag=true;
			Iterator<Map.Entry<String,Object>> it = tempMap.entrySet().iterator();
			while(it.hasNext()){
				Map.Entry entry=it.next();
				if(lmap.size()==0){
					resMap.put(entry.getKey()+"", entry.getValue());
					lmap.add(resMap);
					break;
				}else{
					for(Map<String,Object> resm:lmap){
					Iterator<Map.Entry<String,Object>> itrus = resm.entrySet().iterator();
					while(itrus.hasNext()){
						Map.Entry entryRus = itrus.next();
						if(entry.getKey().equals(entryRus.getKey())){
							//System.out.println("userid"+entry.getKey());
							entryRus.setValue(Integer.parseInt(entryRus.getValue()+"")+Integer.parseInt(entry.getValue()+""));
							flag=false;
							break;
						}
					}
					if(flag==false){
						break;
					}
				}
					if(flag){
						resMap.put(entry.getKey()+"", entry.getValue());
						lmap.add(resMap);
						break;
					}
			}
		}
		}
		return lmap;
	}
	
	public static long timeToUnix(String dTime){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String dateString1 = dTime;
		Date date = null;
		try {
			date = df.parse(dateString1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 long l1=date.getTime();
		 return l1;
	}
	
	public List<EntityCaseLogDetail> getOnlineTime(Map<String,Object> param){
		return this.getBaseDao().getOnlineTime(param);
	}
	
	public int getRegMan(Map<String,Object> param){
		return this.getBaseDao().getRegMan(param);
	}
	public int getNoRepleAllCount(Map<String,Object> param){
		return this.getBaseDao().getNoRepleAllCount(param);
	}
	
	public List<EntityCaseLogDetail> getNewPlayer(Map<String,Object> param){
		return this.getBaseDao().getNewPlayer(param);
	}
	public List<EntityCaseLogDetail> getOnlineTimeForUser(Map<String,Object> param){
		return this.getBaseDao().getOnlineTimeForUser(param);
	}
	
	 public List<Map<String,Object>> checkOnlineTimeForUser(List<EntityCaseLogDetail> lecld){
		 List<Map<String,Object>> lMap = new ArrayList<Map<String,Object>>();
		 Map<String,Object> reMap = new HashMap<String,Object>();
		 boolean flag=false;
		long sTime=0,eTime=0,resultNum=0;
		int tempUserId=0;
		 for(int i=0;i<lecld.size();i++){
			 switch(lecld.get(i).getCase_id()){
			 case 2://退出的节点的，向前推延节点
//				 System.out.println("2  "+lecld.get(i).getUser_id());
				 tempUserId=lecld.get(i).getUser_id();
				 sTime=timeToUnix(lecld.get(i).getCase_time()+"");
				 flag=true;
				 break;
			 case 3://如果上面的一个节点是 2 ，那么就获取当前的其实点。获取最近的时间
//				 System.out.println("3  "+lecld.get(i).getUser_id());
				 if(flag && tempUserId == lecld.get(i).getUser_id()){
					 eTime=timeToUnix(lecld.get(i).getCase_time()+"");
					 if(reMap.get(lecld.get(i).getUser_id())==null){
						 reMap.put(lecld.get(i).getUser_id()+"", sTime-eTime);flag=false;
					 }else{
						 resultNum=eTime-sTime;
						 int tempNum=Integer.parseInt(reMap.get(lecld.get(i).getUser_id())+"");
						 reMap.put(lecld.get(i).getUser_id()+"", tempNum+resultNum);flag=false;
					 }
					 break;
				 }
			 }
		 }
		 lMap.add(reMap);
		 return lMap;
	 }
}
