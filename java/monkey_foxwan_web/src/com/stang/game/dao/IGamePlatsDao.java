package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GamePlatsDetail;
import com.stang.game.entity.detail.GameTaskDetail;
import com.stang.game.entity.detail.RoleMilitaryDetail;

public interface IGamePlatsDao extends IEntityDao<GamePlatsDetail> {
	public List<GamePlatsDetail> getGamePlat();
	public List<GamePlatsDetail> findAllPlat(Map<String,Object> param);
	public List<GamePlatsDetail> findGamePlatByid(Map<String,Object> param);
	public boolean insertGameplat(GamePlatsDetail model);
	public boolean updateGameplat(Map<String, Object> param);
}
