package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityGameEquipDetail;

public interface IGameEquipDao extends IEntityDao<EntityGameEquipDetail>{
	public List<EntityGameEquipDetail> getallinfo(Map<String,Object> parm);

	public String getEquipNameById(Map<String, Object> param);
}
