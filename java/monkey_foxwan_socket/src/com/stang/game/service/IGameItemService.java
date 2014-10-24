package com.stang.game.service;

import java.util.List;

import com.stang.game.entity.detail.GameItemDetail;

public interface IGameItemService extends IBaseService<GameItemDetail> {
	public List<GameItemDetail> getGameItem();
	public List<GameItemDetail> getGameItemByIdtwo(int id);
	public List<GameItemDetail> getGameItemById(int id);
	public List<GameItemDetail> getGameItemByItemtype();
	public List<GameItemDetail> getGameItemRequest();
	public List<GameItemDetail> getGameItemRequest2();
	public List<GameItemDetail> getGameItemTurntable();
	public List<GameItemDetail> getGameItemHappyTurntable();
	public List<GameItemDetail> getGameItemZillionaire();
}
