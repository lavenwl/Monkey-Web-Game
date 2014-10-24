package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;
import com.stang.game.cache.CacheRoleEquip;
import com.stang.game.dao.IRoleEquipDao;
import com.stang.game.dao.impl.RoleEquipDaoImpl;
import com.stang.game.entity.detail.RoleEquipDetail;
import com.stang.game.service.IRoleEquipService;

public class RoleEquipServiceImpl extends BaseServiceImpl<RoleEquipDetail>
implements IRoleEquipService{

	private static CacheRoleEquip cacheRoleEquip = null;
	private static CacheRoleEquip getCacheRoleEquip(){
		if(cacheRoleEquip == null){
			cacheRoleEquip = new CacheRoleEquip();
		}
		return cacheRoleEquip;
	}
	
	protected IRoleEquipDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new RoleEquipDaoImpl();
		}
		return (IRoleEquipDao) baseDao;
	}

	@Override
	public boolean deleteRoleEquip(Map<String, Object> param) {
		return getCacheRoleEquip().deleteRoleEquip(param);
//		return getBaseDao().deleteRoleEquip(param);
	}

	@Override
	public List<RoleEquipDetail> getRoleEquipDetail(Map<String, Object> param) {
		return getCacheRoleEquip().getRoleEquip(param);
		//return getBaseDao().getRoleEquipDetail(param);
	}

	@Override
	public boolean insertRoleEquip(RoleEquipDetail detail) {
		return getCacheRoleEquip().insertRoleEquip(detail);
//		return getBaseDao().insertRoleEquip(detail);
	}

	@Override
	public boolean updateRoleEquip(Map<String, Object> param) {
		return getCacheRoleEquip().updateRoleEquip(param);
//		return getBaseDao().updateRoleEquip(param);
	}
	
	@Override
	public boolean updateRoleEquips(RoleEquipDetail detail) {
		return getCacheRoleEquip().updateRoleEquips(detail);
//		return getBaseDao().updateRoleEquip(param);
	}

	@Override
	public boolean addRoleEquipNum(Map<String, Object> param) {
		//System.out.println("RoleEquipServiceImpl.addRoleEquipNum():不存在的xml配置！！");
		return getBaseDao().addRoleEquipNum(param);
	}

	@Override
	public boolean sbRoleEquipNum(Map<String, Object> param) {
		//System.out.println("RoleEquipServiceImpl.sbRoleEquipNum():不存在的xml配置！！");
		return getBaseDao().sbRoleEquipNum(param);
	}

	@Override
	public List<RoleEquipDetail> getRoleEquipById(int bid) {
		return getCacheRoleEquip().getRoleEquipById(bid);
//		return getBaseDao().getRoleEquipById(bid);
	}

	@Override  
	public List<RoleEquipDetail> getRoleEquip(Map<String, Object> param) {
		return getCacheRoleEquip().getRoleEquip(param);
//		return getBaseDao().getRoleEquip(param);
	}

	@Override
	public List<RoleEquipDetail> getRoleEquipByEquipId(Map<String, Object> param) {
		return getCacheRoleEquip().getRoleEquipByEquipId(param);
//		return getBaseDao().getRoleEquipByEquipId(param);
	}

	@Override
	public boolean updateRoleEquipById(Map<String, Object> param) {
		return getCacheRoleEquip().updateRoleEquipById(param);
//		return getBaseDao().updateRoleEquipById(param);
	}

	@Override
	public boolean subRoleEquipById(Map<String, Object> param) {
		return getCacheRoleEquip().subRoleEquipById(param);
//		return getBaseDao().subRoleEquipById(param);
	}

	@Override
	public List<RoleEquipDetail> getRoleEquipByDengji(Map<String, Object> param) {
		return getCacheRoleEquip().getRoleEquipByDengji(param);
//		return getBaseDao().getRoleEquipByDengji(param);
	}

	@Override
	public List<RoleEquipDetail> getRoleEquipUser(Map<String, Object> param) {
		return getCacheRoleEquip().getRoleEquipUser(param);
//		return getBaseDao().getRoleEquipUser(param);
	}

	@Override
	public boolean updateRoleEquipByIdtwo(Map<String, Object> param) {
		return getCacheRoleEquip().updateRoleEquipById(param);
//		return getBaseDao().updateRoleEquipByIdtwo(param);
	}

	@Override
	public List<RoleEquipDetail> findAllRoleEquip() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllRoleEquip();
	}

	@Override
	public List<RoleEquipDetail> getRoleEquiptwo(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().getRoleEquip(param);
	}

}
