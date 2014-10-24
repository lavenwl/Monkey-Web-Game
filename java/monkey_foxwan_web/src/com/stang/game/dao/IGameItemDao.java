package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameItemDetail;

public interface IGameItemDao extends IEntityDao<GameItemDetail> {
	public List<GameItemDetail> getGameItem();

	
	public List<GameItemDetail> getGameItemId(String itemname);
	public List<GameItemDetail> findAllItem(Map<String,Object> param);
	public List<GameItemDetail> getGameItemById(int id);
	public boolean insertGameItem(GameItemDetail model);
	public boolean updateGameItem(Map<String, Object> param);
}
