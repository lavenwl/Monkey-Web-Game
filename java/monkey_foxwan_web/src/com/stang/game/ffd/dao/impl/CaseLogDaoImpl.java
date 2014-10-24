package com.stang.game.ffd.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.common.PageProperty;
import com.stang.game.ffd.dao.ICaseLogDao;
import com.stang.game.ffd.entity.detail.EntityCaseLogDetail;

public class CaseLogDaoImpl extends EntityDao<EntityCaseLogDetail>  implements ICaseLogDao {

	@SuppressWarnings("unchecked")
	public List<EntityCaseLogDetail> getAllLgo(Map<String,Object> parms){
		List<EntityCaseLogDetail> ecd= null;
		try{
			ecd=sqlMapper.queryForList("getCaseLog",parms);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ecd;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<EntityCaseLogDetail> getAllPointByParams(Map<String,Object>parms){
		List<EntityCaseLogDetail> ecd = null;
		try{
			ecd=sqlMapper.queryForList("getAllPointByParams",parms);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ecd;
	}
	

	
	@SuppressWarnings("unchecked")
	public List<EntityCaseLogDetail> getAllLgo(String TableName) {
		HashMap<Object,Object> hm= new HashMap<Object,Object>();
		hm.put("TABLE_NAME", TableName);
		List<EntityCaseLogDetail> ecd= null;
		try{
			ecd=sqlMapper.queryForList("getCaseLog",hm);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ecd;
	}
	
	@SuppressWarnings("unchecked")
	public List<EntityCaseLogDetail> getAllPointMaxOnline(Map<String,Object> parms){
		List<EntityCaseLogDetail> ecd= null;
		try{
			ecd=sqlMapper.queryForList("getCaseLogMaxOnline",parms);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ecd;
	}
	
	@SuppressWarnings("unchecked")
	public List<EntityCaseLogDetail> getCaseLogNoviceOld(Map<String,Object> parms){// 无效方法 弃用
		
		List<EntityCaseLogDetail> ecd= null;
		try{
			ecd=sqlMapper.queryForList("getCaseLogNovice",parms);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ecd;
	}
	
	

@SuppressWarnings("unchecked")
public List<Map<String,Object>> getCaseLogNovice(Map<String,Object> parms){
		List<Map<String,Object>> resultMap= new ArrayList<Map<String,Object>>();
		try{
			System.out.print("__________caseLogDaoImpl_______80");
			resultMap=sqlMapper.queryForList("getCaseLogNovice",parms);
			System.out.print("__________caseLogDaoImpl_______82");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return resultMap;
	}
	

	@SuppressWarnings("unchecked")
	public List<EntityCaseLogDetail> searchTwoTables(Map<String,Object> params){
		List<EntityCaseLogDetail> result=null;
		try {
			result=this.sqlMapper.queryForList("searchTwoTables",params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public List<EntityCaseLogDetail> getCheckDayByDateAndCaseId(Map<String,Object> params){
		List<EntityCaseLogDetail> lecld = null;
		try {
			lecld=this.sqlMapper.queryForList("getCheckDayByDateAndCaseId",params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lecld;
	}

	public List<EntityCaseLogDetail> getItem(HashMap<String, Object> parms) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EntityCaseLogDetail> getOnlineUser(HashMap<String, Object> parms) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EntityCaseLogDetail> getRegestUser(HashMap<String, Object> parms) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EntityCaseLogDetail> getUseItem(HashMap<String, Object> parms) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<EntityCaseLogDetail> getAllMaxOnlineByLike(Map<String,Object> params){
		List<EntityCaseLogDetail> lecld=null;
		try {
			lecld=this.sqlMapper.queryForList("getCaseLogMaxOnlineForLike",params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lecld;
	}
	
	public List<EntityCaseLogDetail> getAllInfoLike(Map<String,Object> params){
		List<EntityCaseLogDetail> lecld=null;
		try {
			lecld=this.sqlMapper.queryForList("getCaseInfoLike",params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lecld;
	}
	
	public List<EntityCaseLogDetail> getAllInfoLikes(Map<String,Object> params){
		List<EntityCaseLogDetail> lecld=null;
		try {
			lecld=this.sqlMapper.queryForList("getCaseInfoLike",params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lecld;
	}
	
	@SuppressWarnings({ "static-access", "unchecked" })
	public List<EntityCaseLogDetail> getQh(Map<String,Object> params){
		List<EntityCaseLogDetail> lecld=null;
		try {
			lecld=this.sqlMapper.queryForList("getQh",params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lecld;
	}
	
	public List<EntityCaseLogDetail> getAllPointByLike(Map<String,Object> params){
	List<EntityCaseLogDetail> ecd = null;
	try{
		ecd=sqlMapper.queryForList("getAllPointByParams",params);
	}catch(SQLException e){
		e.printStackTrace();
	}
	return ecd;
	}
	
	public List<EntityCaseLogDetail> getOnlineTime(Map<String,Object> param){
		List<EntityCaseLogDetail> ecd = null;
		try{
			ecd=sqlMapper.queryForList("getTimeOnline",param);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ecd;
	}
	
	public int getRegMan(Map<String,Object> param){
		int result=0;
		try{
			result=sqlMapper.queryForList("getRegCount",param).size();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
	public int getNoRepleAllCount(Map<String,Object> param){
		int result=0;
		try{
			result=sqlMapper.queryForList("getNoRepleAllCount",param).size();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
	public List<EntityCaseLogDetail> getNewPlayer(Map<String,Object> param){
		List<EntityCaseLogDetail> ecd = null;
		try{
			ecd=sqlMapper.queryForList("getNewPlayer",param);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ecd;
	}
	
	@SuppressWarnings("unchecked")
	public List<EntityCaseLogDetail> getOnlineTimeForUser(Map<String,Object> param){
		List<EntityCaseLogDetail> lecld = null;
		try{
			lecld=sqlMapper.queryForList("getOnlineTimeForUser",param);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return lecld;
	}
}
