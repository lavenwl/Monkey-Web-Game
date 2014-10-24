package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.cache.CacheRoletotme;
import com.stang.game.dao.IRoletotemDao;
import com.stang.game.dao.impl.RoletotemDaoImpl;
import com.stang.game.entity.detail.RoletotemDetail;
import com.stang.game.service.IRoletotemService;

public class RoletotemServiceImpl extends BaseServiceImpl<RoletotemDetail>
implements IRoletotemService{
     CacheRoletotme c0;
     private CacheRoletotme c(){
    	 if(c0==null){
    		 c0=new CacheRoletotme();
    	 }
		return c0;
     }
	protected IRoletotemDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new RoletotemDaoImpl();
		}
		return (IRoletotemDao) baseDao;
	}

	@Override
	public boolean addRoletotemNum(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return c().addRoletotemNum(param);

		//return getBaseDao().addRoletotemNum(param);
	}

	@Override
	public boolean delRoletotem(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return c().delRoletotem(param);

		//return getBaseDao().delRoletotem(param);
	}

	@Override
	public List<RoletotemDetail> getRoletotem(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return c().getRoletotem(param);

		//return getBaseDao().getRoletotem(param);
	}

	@Override
	public boolean insertRoletotem(RoletotemDetail detail) {
		// TODO Auto-generated method stub
		return c().insertRoletotem(detail);

		//return getBaseDao().insertRoletotem(detail);
	}

	@Override
	public boolean sbRoletotemNum(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return c().sbRoletotemNum(param);

		//return getBaseDao().sbRoletotemNum(param);
	}

	@Override
	public List<RoletotemDetail> getallroletotem() {
		// TODO Auto-generated method stub
		return getBaseDao().getallroletotem();
	}
	@Override
	public List<RoletotemDetail> getRoletotemtwo(Map<String, Object> param) {

	
		return getBaseDao().getRoletotem(param);
	
	}
	@Override
	public void updateTotem(RoletotemDetail roletotemDetail) {
		// TODO Auto-generated method stub
		c().update(roletotemDetail);
	}

	
}
