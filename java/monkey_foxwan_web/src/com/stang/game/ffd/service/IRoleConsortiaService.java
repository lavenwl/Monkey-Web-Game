package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityRoleConsortiaDetail;

public interface IRoleConsortiaService extends IBaseService<EntityRoleConsortiaDetail> {
	
	public List<EntityRoleConsortiaDetail> getRoleConsortia(Map<String,Object> parm);

}
