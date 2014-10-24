package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IRoleConsortiaDao;
import com.stang.game.ffd.dao.impl.RoleConsortiaDaoImpl;
import com.stang.game.ffd.entity.detail.EntityRoleConsortiaDetail;
import com.stang.game.ffd.service.IRoleConsortiaService;

public class RoleConsortiaServiceImpl extends BaseServiceImpl<EntityRoleConsortiaDetail> implements IRoleConsortiaService {
	public IRoleConsortiaDao getBaseDao(){
		if(this.baseDao==null){
			baseDao=new RoleConsortiaDaoImpl();
		}
		return (IRoleConsortiaDao)baseDao;
	}
	
	public List<EntityRoleConsortiaDetail> getRoleConsortia(Map<String,Object> parmas){
		return getBaseDao().getRoleConsortia(parmas);
	}
	public void getRoleConsortia(){
		
	}
}
