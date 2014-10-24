/*
 * @author guk
 * @Description  数据采集
 * */
package com.stang.game.ffd.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityCaseLogDetail;

public interface ICaseLogDao extends IEntityDao<EntityCaseLogDetail> {

	/*查询出所有的信息*/
	public List<EntityCaseLogDetail> getAllLgo(Map<String,Object> parms);
		/*
		 * 根据表明查询所有记录
		 * */
	public List<EntityCaseLogDetail> getAllLgo(String tableName);
	
	/*查询出所有的注册用户的数量，并且按照时段来查询*/
	public List<EntityCaseLogDetail> getRegestUser(HashMap<String,Object> parms);
	
	/*查询分时在线统计*/
	public List<EntityCaseLogDetail> getOnlineUser(HashMap<String,Object> parms);
	
	/*查看道具一段时间道具的销售量*/
	public List<EntityCaseLogDetail> getItem(HashMap<String,Object> parms);
	
	/*查看道具的使用量*/
	public List<EntityCaseLogDetail> getUseItem(HashMap<String,Object> parms);
	
	/*获取用户在线时间要 升序排序*/
	public List<EntityCaseLogDetail> getAllPointMaxOnline(Map<String,Object> parms);
	
	public List<Map<String,Object>> getCaseLogNovice(Map<String,Object> parms);
	
	public List<EntityCaseLogDetail> getAllPointByParams(Map<String,Object> params);
	
	
	/**
	 * 根据时间对最高在线，只给一个时间，和2个case_id 的 or 查询
	 * @param params
	 * @return
	 */
	public List<EntityCaseLogDetail> getAllMaxOnlineByLike(Map<String,Object> params);
	
	public List<EntityCaseLogDetail> getAllInfoLike(Map<String,Object> params);
	public List<EntityCaseLogDetail> getAllInfoLikes(Map<String,Object> params);
	public List<EntityCaseLogDetail> getQh(Map<String,Object> params);
	/**
	 * 获取在线时间 2,4节点必须为逆序
	 * @return
	 */
	public List<EntityCaseLogDetail> getOnlineTime(Map<String,Object> param);
	
	public int getRegMan(Map<String,Object> param);
	
	public int getNoRepleAllCount(Map<String,Object> param);
	
	public List<EntityCaseLogDetail> getNewPlayer(Map<String,Object> param);
	
	public List<EntityCaseLogDetail> getOnlineTimeForUser(Map<String,Object> param);
	
	
	
}
