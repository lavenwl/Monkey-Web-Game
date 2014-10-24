package com.stang.game.dao;

import java.util.List;

import com.stang.game.entity.detail.GameMissionDetail;

public interface IGameMissionDao extends IEntityDao<GameMissionDetail>{

	public List<GameMissionDetail> getGameMission();
	
	public List<GameMissionDetail> findGameMissionById(int id);
	
}
