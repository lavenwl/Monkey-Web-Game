package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameItemDetail;

public interface IGameItemService extends IBaseService<GameItemDetail> {
	public List<GameItemDetail> getGameItem();
	public List<GameItemDetail> getGameItemId(String itemname);
	public List<GameItemDetail> getGameItemById(int id);
	public List<GameItemDetail> findAllItem(Map<String,Object> param);
	public boolean insertGameItem(GameItemDetail model);
	public boolean updateGameItem(Map<String, Object> param);
}
