package com.stang.game.ffd.dao;


import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityGameConsortiaDetail;

public interface IGameConsortiaDao extends IEntityDao<EntityGameConsortiaDetail> {

	// 获取所有的公会消息贡献度
	public List<EntityGameConsortiaDetail> getAllConsortiaInfo(Map<String,Object> parm);
	
	public int searchCountConsortia(Map<String,Object> param);
}
