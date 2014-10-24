package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GamePlatsDetail;
import com.stang.game.entity.detail.RoleMilitaryDetail;

public interface IGamePlatsDao extends IEntityDao<GamePlatsDetail> {
	public List<GamePlatsDetail> getGamePlats();
	
	public List<GamePlatsDetail> findGamePlatByparams(Map<String, Object> param);//获得随机道具
}
