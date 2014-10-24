package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityRoleConsortiaDetail;

public interface IRoleConsortiaDao extends IEntityDao<EntityRoleConsortiaDetail>  {
	//  更具工会列表获取工会成员
	public List<EntityRoleConsortiaDetail> getRoleConsortia(Map<String,Object> parmas);
}
