package com.stang.game.dao;

import java.util.List;

import com.stang.game.entity.detail.GameItemDetail;

public interface IGameItemDao extends IEntityDao<GameItemDetail> {
	public List<GameItemDetail> getGameItem();

	public List<GameItemDetail> getGameItemById(int id);
	public List<GameItemDetail> getGameItemByIdtwo(int id);
	public void ClrAllModel();
	public List<GameItemDetail> getGameItemByItemtype();
}
