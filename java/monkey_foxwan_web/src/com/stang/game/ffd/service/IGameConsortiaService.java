package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityGameConsortiaDetail;

public interface IGameConsortiaService extends IBaseService<EntityGameConsortiaDetail> {
	 /**
	  * @description 获得所有的公会信息
	  * @param void
	  * @return List<EntityGameConsortiaDetail>
	  */
	public List<EntityGameConsortiaDetail> getAllConsortiaInfo(Map<String,Object> parm);
	/**
	 * 查询当前有多少个公会，分页的时候用
	 * @param param
	 * @return
	 */
	public int searchCountConsortia(Map<String,Object> param);
}
