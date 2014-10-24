package com.stang.game.service;

import java.util.List;

import com.stang.game.entity.detail.GameMissionDetail;

public interface IGameMissionService extends IBaseService<GameMissionDetail>{

	public List<GameMissionDetail> getGameMission();
	
	public List<GameMissionDetail> findGameMissionById(int id);
}
