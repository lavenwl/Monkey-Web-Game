package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.ICaseInfoDao;
import com.stang.game.ffd.entity.detail.EntityCaseInfoDetail;

public class CaseInfoDaoImpl extends EntityDao<EntityCaseInfoDetail> implements ICaseInfoDao {
	public void addCaseInfo(Map<String,Object> param){
		try {
			this.sqlMapper.insert("addCaseInfo",param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@SuppressWarnings({ "unchecked", "static-access" })
	public List<EntityCaseInfoDetail> findAll(Map<String,Object> param){
		List<EntityCaseInfoDetail> lecid=null;
		try {
			lecid=this.sqlMapper.queryForList("findAll",param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lecid;
	}
	
	@SuppressWarnings("unchecked")
	public List<EntityCaseInfoDetail> findAllForTime(Map<String,Object>param){
		List<EntityCaseInfoDetail> lecid=null;
		try {
			lecid=this.sqlMapper.queryForList("findAllForTime",param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lecid;
	}
	
	@SuppressWarnings("static-access")
	public void updateCaseInfo(Map<String,Object> param){
		try {
			this.sqlMapper.update("updateCaseInfo",param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 判断昨天的数据是不是最新的
	 * param: lag_type 、 Lag_time
	 */
	public int SearchYesterday(Map<String,Object> param){
		/**
		 * 0:没有数据 1:有数据但不是最新的 2：数据是最新的
		 */
		int flag=0;
		try {
			List<EntityCaseInfoDetail> lecid=this.sqlMapper.queryForList("SearchYesterday",param);
			if(lecid.size()>0){//数据存在无须更新
				return flag=2;
			}else{
				lecid.clear();
				Map<String,Object> tempMap = new HashMap<String,Object>();
				tempMap.put("lag_time", param.get("lag_time").toString().substring(0,10));
				tempMap.put("lag_time2", param.get("lag_time2").toString());
				tempMap.put("lag_type", Integer.parseInt(param.get("lag_type").toString()));
				lecid=this.sqlMapper.queryForList("SearchYesterday",tempMap);
				if(lecid.size()>0){//有数据只需进行更新操作
				   return lecid.get(0).getId();
				}else{
					return flag=0;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	

	public List<EntityCaseInfoDetail> SearchYesterdayForLike(Map<String,Object> param){
		List<EntityCaseInfoDetail>	lecid=null;
		 try {
				lecid=this.sqlMapper.queryForList("SearchYesterdayForLike",param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lecid;
	}
	
	public int searchCount(Map<String,Object> param){
		int lecid=0;
		 try {
				lecid=Integer.parseInt(this.sqlMapper.queryForList("searchCount",param).get(0)+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lecid;
	}
}
