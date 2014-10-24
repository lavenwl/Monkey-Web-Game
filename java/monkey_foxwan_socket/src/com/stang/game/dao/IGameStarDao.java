package com.stang.game.dao;

import java.util.List;

import com.stang.game.entity.detail.GameStarDetail;

public interface IGameStarDao extends IEntityDao<GameStarDetail>{
	public List<GameStarDetail> getgamestars(int starlevel);
	public List<GameStarDetail> getallgamestar();
}
