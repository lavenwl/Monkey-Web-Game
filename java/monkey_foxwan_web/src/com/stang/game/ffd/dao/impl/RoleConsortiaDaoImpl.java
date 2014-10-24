package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IRoleConsortiaDao;
import com.stang.game.ffd.entity.detail.EntityRoleConsortiaDetail;

public class RoleConsortiaDaoImpl extends EntityDao<EntityRoleConsortiaDetail> implements
		IRoleConsortiaDao {

	public List<EntityRoleConsortiaDetail> getRoleConsortia(
			Map<String, Object> parmas) {
		// TODO Auto-generated method stub
		List<EntityRoleConsortiaDetail> lercd=null;
		try {
			lercd=this.sqlMapperFlight.queryForList("listRoleConsortiaDetail");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lercd;
	}

	

}
