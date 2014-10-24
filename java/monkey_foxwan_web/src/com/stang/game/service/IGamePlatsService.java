package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GamePlatsDetail;

public interface IGamePlatsService extends IBaseService<GamePlatsDetail> {
	public List<GamePlatsDetail> getGamePlat();
	public List<GamePlatsDetail> findAllPlat(Map<String,Object> param);
	public List<GamePlatsDetail> findGamePlatByid(Map<String,Object> param);
	public boolean insertGameplat(GamePlatsDetail model);
	public boolean updateGameplat(Map<String, Object> param);}
