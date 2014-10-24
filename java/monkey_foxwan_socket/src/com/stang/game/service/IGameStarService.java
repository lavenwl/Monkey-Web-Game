package com.stang.game.service;

import java.util.List;

import com.stang.game.entity.detail.GameStarDetail;

public interface IGameStarService extends IBaseService<GameStarDetail>{
	public List<GameStarDetail> getgamestars(int starlevel);
	public List<GameStarDetail> getallgamestar();
}
